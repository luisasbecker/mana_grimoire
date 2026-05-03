import 'dart:async';
import 'dart:convert';
import 'dart:io';

import 'package:dio/dio.dart';

import '../local/db/app_database.dart';

enum ScanCatalogSyncPhase { idle, checking, importing, completed, failed }

class ScanCatalogSyncSnapshot {
  const ScanCatalogSyncSnapshot({
    required this.phase,
    required this.cardCount,
    this.bulkUpdatedAt,
    this.startedAt,
    this.completedAt,
    this.progress,
    this.lastError,
    this.downloadUri,
    this.downloadedBytes = 0,
    this.totalBytes,
  });

  factory ScanCatalogSyncSnapshot.idle() {
    return const ScanCatalogSyncSnapshot(
      phase: ScanCatalogSyncPhase.idle,
      cardCount: 0,
    );
  }

  final ScanCatalogSyncPhase phase;
  final int cardCount;
  final DateTime? bulkUpdatedAt;
  final DateTime? startedAt;
  final DateTime? completedAt;
  final double? progress;
  final String? lastError;
  final String? downloadUri;
  final int downloadedBytes;
  final int? totalBytes;

  bool get isRunning =>
      phase == ScanCatalogSyncPhase.checking ||
      phase == ScanCatalogSyncPhase.importing;
}

class ScanCatalogSyncService {
  ScanCatalogSyncService({
    required AppDatabase database,
    Dio? dio,
  })  : _database = database,
        _dio = dio ?? Dio() {
    _dio.options.baseUrl = 'https://api.scryfall.com';
    _dio.options.connectTimeout = const Duration(seconds: 15);
    _dio.options.receiveTimeout = const Duration(seconds: 30);
    _dio.options.headers = {
      'Accept': 'application/json',
      'User-Agent': 'ManaGrimoire/0.1 (Flutter; catalog sync)',
    };
  }

  static const String _datasetType = 'default_cards';
  static const int _batchSize = 500;
  static const int _progressUpdateInterval = 1000;
  static const int _downloadProgressUpdateBytes = 8 * 1024 * 1024;
  static const Duration _downloadProgressUpdateInterval =
      Duration(milliseconds: 700);

  final AppDatabase _database;
  final Dio _dio;
  bool _syncInProgress = false;
  bool _cancelRequested = false;
  bool _schemaReady = false;
  bool _legacyRawTableDropped = false;
  Future<void>? _schemaFuture;

  Future<void> ensureSchema() async {
    if (_schemaReady) return;
    final existingFuture = _schemaFuture;
    if (existingFuture != null) {
      await existingFuture;
      return;
    }
    _schemaFuture = _ensureSchema();
    try {
      await _schemaFuture;
    } catch (_) {
      _schemaFuture = null;
      rethrow;
    }
  }

  Future<void> _ensureSchema() async {
    await _database.customStatement('''
      CREATE TABLE IF NOT EXISTS scan_catalog_sync_entries (
        singleton_id INTEGER NOT NULL PRIMARY KEY CHECK (singleton_id = 1),
        dataset_type TEXT NOT NULL DEFAULT 'default_cards',
        status TEXT NOT NULL DEFAULT 'idle',
        bulk_updated_at TEXT NULL,
        started_at TEXT NULL,
        completed_at TEXT NULL,
        card_count INTEGER NOT NULL DEFAULT 0,
        progress REAL NULL,
        last_error TEXT NULL,
        download_uri TEXT NULL,
        downloaded_bytes INTEGER NOT NULL DEFAULT 0,
        total_bytes INTEGER NULL
      );
    ''');
    await _ensureSyncColumn(
      name: 'downloaded_bytes',
      definition: 'INTEGER NOT NULL DEFAULT 0',
    );
    await _ensureSyncColumn(name: 'total_bytes', definition: 'INTEGER NULL');
    _schemaReady = true;
  }

  Future<void> _ensureSyncColumn({
    required String name,
    required String definition,
  }) async {
    final columns = await _database
        .customSelect('PRAGMA table_info(scan_catalog_sync_entries)')
        .get();
    final exists = columns.any((row) => row.data['name'] == name);
    if (!exists) {
      await _database.customStatement(
        'ALTER TABLE scan_catalog_sync_entries ADD COLUMN $name $definition',
      );
    }
  }

  Future<ScanCatalogSyncSnapshot> currentStatus() async {
    await ensureSchema();
    final row = await _database
        .customSelect(
          'SELECT * FROM scan_catalog_sync_entries WHERE singleton_id = 1',
        )
        .getSingleOrNull();
    if (row == null) {
      final count = await countCachedCards();
      return ScanCatalogSyncSnapshot(
        phase: count > 0
            ? ScanCatalogSyncPhase.completed
            : ScanCatalogSyncPhase.idle,
        cardCount: count,
      );
    }
    return _snapshotFromRow(row.data);
  }

  Future<int> countCachedCards() async {
    final row = await _database
        .customSelect('SELECT COUNT(*) AS count FROM scryfall_printings')
        .getSingle();
    return _intFrom(row.data['count']);
  }

  Future<bool> hasSyncedCatalog() async {
    final status = await currentStatus();
    if (status.phase == ScanCatalogSyncPhase.completed &&
        status.cardCount > 0) {
      return true;
    }
    return await countCachedCards() > 0;
  }

  void cancelSync() {
    _cancelRequested = true;
  }

  Future<ScanCatalogSyncSnapshot> sync({
    bool force = false,
    ValueChanged<ScanCatalogSyncSnapshot>? onProgress,
  }) async {
    if (_syncInProgress) {
      return currentStatus();
    }

    _syncInProgress = true;
    _cancelRequested = false;
    try {
      await ensureSchema();
      return await _runSync(force: force, onProgress: onProgress);
    } catch (error) {
      try {
        final failed = await _writeStatus(
          phase: ScanCatalogSyncPhase.failed,
          lastError: error.toString(),
        );
        onProgress?.call(failed);
        return failed;
      } catch (_) {
        return ScanCatalogSyncSnapshot(
          phase: ScanCatalogSyncPhase.failed,
          cardCount: 0,
          lastError: error.toString(),
        );
      }
    } finally {
      _syncInProgress = false;
    }
  }

  Future<ScanCatalogSyncSnapshot> _runSync({
    required bool force,
    ValueChanged<ScanCatalogSyncSnapshot>? onProgress,
  }) async {
    try {
      final checking = await _writeStatus(phase: ScanCatalogSyncPhase.checking);
      onProgress?.call(checking);

      await _dropLegacyRawTable();
      final bulkInfo = await _fetchBulkInfo();
      final current = await currentStatus();
      final localCardCount = await countCachedCards();
      if (!force &&
          localCardCount > 0 &&
          current.bulkUpdatedAt != null &&
          !bulkInfo.updatedAt.isAfter(current.bulkUpdatedAt!)) {
        final completed = await _writeStatus(
          phase: ScanCatalogSyncPhase.completed,
          bulkUpdatedAt: bulkInfo.updatedAt,
          completedAt: DateTime.now().toUtc(),
          cardCount: localCardCount,
          progress: 1,
          downloadUri: bulkInfo.downloadUri.toString(),
          downloadedBytes: bulkInfo.size,
          totalBytes: bulkInfo.size,
        );
        onProgress?.call(completed);
        return completed;
      }

      final startedAt = DateTime.now().toUtc();
      final importing = await _writeStatus(
        phase: ScanCatalogSyncPhase.importing,
        bulkUpdatedAt: bulkInfo.updatedAt,
        startedAt: startedAt,
        completedAt: null,
        cardCount: 0,
        progress: 0,
        downloadUri: bulkInfo.downloadUri.toString(),
        downloadedBytes: 0,
        totalBytes: bulkInfo.size,
      );
      onProgress?.call(importing);

      final importedCount = await _importBulkCards(
        bulkInfo.downloadUri,
        startedAt: startedAt,
        totalBytes: bulkInfo.size,
        onProgress: onProgress,
      );
      await _deleteCardsNotRefreshedSince(startedAt);
      final cardCount = await countCachedCards();
      final completed = await _writeStatus(
        phase: ScanCatalogSyncPhase.completed,
        bulkUpdatedAt: bulkInfo.updatedAt,
        startedAt: startedAt,
        completedAt: DateTime.now().toUtc(),
        cardCount: cardCount == 0 ? importedCount : cardCount,
        progress: 1,
        downloadUri: bulkInfo.downloadUri.toString(),
        downloadedBytes: bulkInfo.size,
        totalBytes: bulkInfo.size,
      );
      onProgress?.call(completed);
      return completed;
    } on _CatalogSyncCancelled {
      final idle = await _writeStatus(phase: ScanCatalogSyncPhase.idle);
      onProgress?.call(idle);
      return idle;
    } catch (error) {
      final failed = await _writeStatus(
        phase: ScanCatalogSyncPhase.failed,
        lastError: error.toString(),
      );
      onProgress?.call(failed);
      return failed;
    }
  }

  Future<_BulkInfo> _fetchBulkInfo() async {
    final response = await _dio.get<Map<String, dynamic>>(
      '/bulk-data/$_datasetType',
    );
    final payload = response.data;
    if (payload == null || payload['object'] == 'error') {
      throw const FormatException('Invalid Scryfall bulk metadata response.');
    }
    final updatedAt =
        DateTime.tryParse(payload['updated_at']?.toString() ?? '');
    final downloadUri = Uri.tryParse(payload['download_uri']?.toString() ?? '');
    final size = _intFrom(payload['size']);
    if (updatedAt == null || downloadUri == null) {
      throw const FormatException('Scryfall bulk metadata is incomplete.');
    }
    return _BulkInfo(
      updatedAt: updatedAt.toUtc(),
      downloadUri: downloadUri,
      size: size > 0 ? size : null,
    );
  }

  Future<void> _dropLegacyRawTable() async {
    if (_legacyRawTableDropped) return;
    _legacyRawTableDropped = true;
    await _database
        .customStatement('DROP TABLE IF EXISTS scan_catalog_raw_cards');
  }

  Future<int> _importBulkCards(
    Uri downloadUri, {
    required DateTime startedAt,
    required int? totalBytes,
    ValueChanged<ScanCatalogSyncSnapshot>? onProgress,
  }) async {
    final client = HttpClient()
      ..connectionTimeout = const Duration(seconds: 20)
      ..idleTimeout = const Duration(seconds: 30)
      ..userAgent = 'ManaGrimoire/0.1 (Flutter; Android/iOS)';
    try {
      final request = await client.getUrl(downloadUri);
      request.headers.set(
        HttpHeaders.acceptHeader,
        'application/json;q=0.9,*/*;q=0.8',
      );
      request.headers.set(HttpHeaders.acceptEncodingHeader, 'gzip');
      final response = await request.close();
      if (response.statusCode < 200 || response.statusCode >= 300) {
        throw HttpException(
          'Could not download Scryfall bulk data (${response.statusCode}).',
          uri: downloadUri,
        );
      }

      var imported = 0;
      var lastReported = 0;
      var downloadedBytes = 0;
      var lastReportedBytes = 0;
      var lastDownloadReportAt = DateTime.fromMillisecondsSinceEpoch(0);
      final printings = <_BulkPrintingRow>[];
      final refreshedAt = DateTime.now().toUtc();
      final responseTotalBytes = totalBytes ??
          (response.contentLength > 0 ? response.contentLength : null);
      final byteStream = _trackDownloadedBytes(
        response,
        onBytes: (bytes) async {
          downloadedBytes = bytes;
          final now = DateTime.now();
          final enoughBytes =
              bytes - lastReportedBytes >= _downloadProgressUpdateBytes;
          final enoughTime = now.difference(lastDownloadReportAt) >=
              _downloadProgressUpdateInterval;
          if (!enoughBytes && !enoughTime) return;
          lastReportedBytes = bytes;
          lastDownloadReportAt = now;
          final snapshot = await _writeStatus(
            phase: ScanCatalogSyncPhase.importing,
            startedAt: startedAt,
            cardCount: imported,
            progress: _progressFromBytes(bytes, responseTotalBytes),
            downloadUri: downloadUri.toString(),
            downloadedBytes: bytes,
            totalBytes: responseTotalBytes,
          );
          onProgress?.call(snapshot);
        },
      );
      final textStream = byteStream.transform(utf8.decoder);
      await for (final json in _streamJsonObjects(textStream)) {
        if (_cancelRequested) throw const _CatalogSyncCancelled();
        final printing = _mapBulkPrinting(
          json,
          refreshedAt: refreshedAt,
        );
        if (printing == null) continue;
        printings.add(printing);
        if (printings.length >= _batchSize) {
          await _writeBatch(printings);
          imported += printings.length;
          printings.clear();
          if (imported - lastReported >= _progressUpdateInterval) {
            lastReported = imported;
            final snapshot = await _writeStatus(
              phase: ScanCatalogSyncPhase.importing,
              startedAt: startedAt,
              cardCount: imported,
              progress: _progressFromBytes(
                downloadedBytes,
                responseTotalBytes,
              ),
              downloadUri: downloadUri.toString(),
              downloadedBytes: downloadedBytes,
              totalBytes: responseTotalBytes,
            );
            onProgress?.call(snapshot);
          }
        }
      }

      if (printings.isNotEmpty) {
        await _writeBatch(printings);
        imported += printings.length;
      }
      final snapshot = await _writeStatus(
        phase: ScanCatalogSyncPhase.importing,
        startedAt: startedAt,
        cardCount: imported,
        progress: _progressFromBytes(downloadedBytes, responseTotalBytes),
        downloadUri: downloadUri.toString(),
        downloadedBytes: downloadedBytes,
        totalBytes: responseTotalBytes,
      );
      onProgress?.call(snapshot);
      return imported;
    } finally {
      client.close(force: true);
    }
  }

  Future<void> _writeBatch(List<_BulkPrintingRow> printings) async {
    if (printings.isEmpty) return;
    const valuePlaceholder = '(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)';
    final valuesSql = List.filled(printings.length, valuePlaceholder).join(',');
    final variables = <Object?>[];
    for (final printing in printings) {
      variables.addAll(printing.toSqlVariables());
    }
    await _database.customStatement(
      '''
      INSERT INTO scryfall_printings (
        printing_id,
        oracle_id,
        name,
        type_line,
        set_code,
        set_name,
        collector_number,
        released_at,
        mana_cost,
        mana_value,
        rarity,
        image_small,
        image_normal,
        image_png,
        legalities_json,
        updated_at_cache
      )
      VALUES $valuesSql
      ON CONFLICT(printing_id) DO UPDATE SET
        oracle_id = excluded.oracle_id,
        name = excluded.name,
        type_line = excluded.type_line,
        set_code = excluded.set_code,
        set_name = excluded.set_name,
        collector_number = excluded.collector_number,
        released_at = excluded.released_at,
        mana_cost = excluded.mana_cost,
        mana_value = excluded.mana_value,
        rarity = excluded.rarity,
        image_small = excluded.image_small,
        image_normal = excluded.image_normal,
        image_png = excluded.image_png,
        legalities_json = excluded.legalities_json,
        updated_at_cache = excluded.updated_at_cache
      ''',
      variables,
    );
  }

  Future<void> _deleteCardsNotRefreshedSince(DateTime cutoff) async {
    await _database.customStatement(
      'DELETE FROM scryfall_printings WHERE updated_at_cache < ?',
      [_toDriftDateTime(cutoff)],
    );
  }

  _BulkPrintingRow? _mapBulkPrinting(
    Map<String, dynamic> json, {
    required DateTime refreshedAt,
  }) {
    final printingId = json['id']?.toString();
    final oracleId = json['oracle_id']?.toString();
    if (printingId == null ||
        printingId.isEmpty ||
        oracleId == null ||
        oracleId.isEmpty) {
      return null;
    }

    final faces = (json['card_faces'] as List<dynamic>? ?? const [])
        .whereType<Map<String, dynamic>>()
        .toList();
    final primaryFace = faces.isEmpty ? null : faces.first;
    final faceNames = faces
        .map((face) => face['name']?.toString())
        .whereType<String>()
        .where((name) => name.isNotEmpty)
        .toList();
    final name = json['name']?.toString() ??
        (faceNames.isEmpty ? 'Unknown card' : faceNames.join(' // '));
    final typeLine =
        json['type_line']?.toString() ?? primaryFace?['type_line']?.toString();
    final manaCost =
        json['mana_cost']?.toString() ?? primaryFace?['mana_cost']?.toString();
    final manaValue = json['mana_value'];

    return _BulkPrintingRow(
      printingId: printingId,
      oracleId: oracleId,
      name: name,
      typeLine: typeLine ?? '',
      setCode: json['set']?.toString() ?? '',
      setName: json['set_name']?.toString() ?? '',
      collectorNumber: json['collector_number']?.toString() ?? '',
      releasedAt: _parseDate(json['released_at']),
      manaCost: manaCost,
      manaValue: manaValue is num ? manaValue.toDouble() : null,
      rarity: json['rarity']?.toString(),
      imageSmall: _extractImageUri(json, 'small'),
      imageNormal: _extractImageUri(json, 'normal'),
      imagePng: _extractImageUri(json, 'png'),
      updatedAtCache: refreshedAt,
    );
  }

  DateTime? _parseDate(Object? value) {
    final text = value?.toString();
    if (text == null || text.isEmpty) return null;
    return DateTime.tryParse(text);
  }

  String? _extractImageUri(Map<String, dynamic> json, String key) {
    final imageUris = json['image_uris'];
    if (imageUris is Map<String, dynamic>) {
      final value = imageUris[key]?.toString();
      if (value != null && value.isNotEmpty) return value;
    }

    final faces = json['card_faces'];
    if (faces is List<dynamic>) {
      for (final face in faces.whereType<Map<String, dynamic>>()) {
        final faceImageUris = face['image_uris'];
        if (faceImageUris is Map<String, dynamic>) {
          final value = faceImageUris[key]?.toString();
          if (value != null && value.isNotEmpty) return value;
        }
      }
    }
    return null;
  }

  Stream<List<int>> _trackDownloadedBytes(
    Stream<List<int>> chunks, {
    required Future<void> Function(int bytes) onBytes,
  }) async* {
    var downloaded = 0;
    await for (final chunk in chunks) {
      downloaded += chunk.length;
      await onBytes(downloaded);
      yield chunk;
    }
  }

  double? _progressFromBytes(int downloadedBytes, int? totalBytes) {
    if (totalBytes == null || totalBytes <= 0) return null;
    return (downloadedBytes / totalBytes).clamp(0, 0.99).toDouble();
  }

  Stream<Map<String, dynamic>> _streamJsonObjects(
      Stream<String> chunks) async* {
    StringBuffer? buffer;
    var depth = 0;
    var inString = false;
    var escaped = false;

    await for (final chunk in chunks) {
      for (var i = 0; i < chunk.length; i++) {
        final char = chunk[i];
        if (buffer == null) {
          if (char != '{') continue;
          buffer = StringBuffer();
        }

        buffer.write(char);

        if (escaped) {
          escaped = false;
          continue;
        }
        if (inString && char == '\\') {
          escaped = true;
          continue;
        }
        if (char == '"') {
          inString = !inString;
          continue;
        }
        if (inString) continue;

        if (char == '{') {
          depth++;
        } else if (char == '}') {
          depth--;
          if (depth == 0) {
            final rawObject = buffer.toString();
            buffer = null;
            final decoded = jsonDecode(rawObject);
            if (decoded is Map<String, dynamic>) yield decoded;
          }
        }
      }
    }
  }

  Future<ScanCatalogSyncSnapshot> _writeStatus({
    required ScanCatalogSyncPhase phase,
    DateTime? bulkUpdatedAt,
    DateTime? startedAt,
    DateTime? completedAt,
    int? cardCount,
    double? progress,
    String? lastError,
    String? downloadUri,
    int? downloadedBytes,
    int? totalBytes,
  }) async {
    final previous = await _database
        .customSelect(
          'SELECT * FROM scan_catalog_sync_entries WHERE singleton_id = 1',
        )
        .getSingleOrNull();
    final previousData = previous?.data;
    await _database.customStatement(
      '''
      INSERT INTO scan_catalog_sync_entries
        (singleton_id, dataset_type, status, bulk_updated_at, started_at,
         completed_at, card_count, progress, last_error, download_uri,
         downloaded_bytes, total_bytes)
      VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
      ON CONFLICT(singleton_id) DO UPDATE SET
        dataset_type = excluded.dataset_type,
        status = excluded.status,
        bulk_updated_at = excluded.bulk_updated_at,
        started_at = excluded.started_at,
        completed_at = excluded.completed_at,
        card_count = excluded.card_count,
        progress = excluded.progress,
        last_error = excluded.last_error,
        download_uri = excluded.download_uri,
        downloaded_bytes = excluded.downloaded_bytes,
        total_bytes = excluded.total_bytes
      ''',
      [
        _datasetType,
        phase.name,
        (bulkUpdatedAt ?? _dateFrom(previousData?['bulk_updated_at']))
                ?.toIso8601String() ??
            '',
        (startedAt ?? _dateFrom(previousData?['started_at']))
                ?.toIso8601String() ??
            '',
        completedAt?.toIso8601String() ?? '',
        cardCount ?? _intFrom(previousData?['card_count']),
        progress,
        lastError,
        downloadUri,
        downloadedBytes ?? _intFrom(previousData?['downloaded_bytes']),
        totalBytes ?? _nullableIntFrom(previousData?['total_bytes']),
      ],
    );
    return currentStatus();
  }

  ScanCatalogSyncSnapshot _snapshotFromRow(Map<String, Object?> data) {
    final phaseName = data['status']?.toString() ?? 'idle';
    return ScanCatalogSyncSnapshot(
      phase: ScanCatalogSyncPhase.values.firstWhere(
        (phase) => phase.name == phaseName,
        orElse: () => ScanCatalogSyncPhase.idle,
      ),
      cardCount: _intFrom(data['card_count']),
      bulkUpdatedAt: _dateFrom(data['bulk_updated_at']),
      startedAt: _dateFrom(data['started_at']),
      completedAt: _dateFrom(data['completed_at']),
      progress: _doubleFrom(data['progress']),
      lastError: _stringFrom(data['last_error']),
      downloadUri: _stringFrom(data['download_uri']),
      downloadedBytes: _intFrom(data['downloaded_bytes']),
      totalBytes: _nullableIntFrom(data['total_bytes']),
    );
  }

  DateTime? _dateFrom(Object? value) {
    final raw = value?.toString();
    if (raw == null || raw.isEmpty) return null;
    return DateTime.tryParse(raw)?.toUtc();
  }

  String? _stringFrom(Object? value) {
    final raw = value?.toString();
    return raw == null || raw.isEmpty ? null : raw;
  }

  int _intFrom(Object? value) {
    if (value is int) return value;
    if (value is num) return value.toInt();
    return int.tryParse(value?.toString() ?? '') ?? 0;
  }

  int? _nullableIntFrom(Object? value) {
    if (value == null) return null;
    if (value is int) return value;
    if (value is num) return value.toInt();
    return int.tryParse(value.toString());
  }

  double? _doubleFrom(Object? value) {
    if (value == null) return null;
    if (value is num) return value.toDouble();
    return double.tryParse(value.toString());
  }
}

class _BulkInfo {
  const _BulkInfo({
    required this.updatedAt,
    required this.downloadUri,
    required this.size,
  });

  final DateTime updatedAt;
  final Uri downloadUri;
  final int? size;
}

class _BulkPrintingRow {
  const _BulkPrintingRow({
    required this.printingId,
    required this.oracleId,
    required this.name,
    required this.typeLine,
    required this.setCode,
    required this.setName,
    required this.collectorNumber,
    required this.updatedAtCache,
    this.releasedAt,
    this.manaCost,
    this.manaValue,
    this.rarity,
    this.imageSmall,
    this.imageNormal,
    this.imagePng,
  });

  final String printingId;
  final String oracleId;
  final String name;
  final String typeLine;
  final String setCode;
  final String setName;
  final String collectorNumber;
  final DateTime? releasedAt;
  final String? manaCost;
  final double? manaValue;
  final String? rarity;
  final String? imageSmall;
  final String? imageNormal;
  final String? imagePng;
  final DateTime updatedAtCache;

  List<Object?> toSqlVariables() {
    return [
      printingId,
      oracleId,
      name,
      typeLine,
      setCode,
      setName,
      collectorNumber,
      _toDriftDateTime(releasedAt),
      manaCost,
      manaValue,
      rarity,
      imageSmall,
      imageNormal,
      imagePng,
      null,
      _toDriftDateTime(updatedAtCache),
    ];
  }
}

int? _toDriftDateTime(DateTime? value) {
  if (value == null) return null;
  return value.toUtc().millisecondsSinceEpoch ~/ 1000;
}

class _CatalogSyncCancelled implements Exception {
  const _CatalogSyncCancelled();
}

typedef ValueChanged<T> = void Function(T value);
