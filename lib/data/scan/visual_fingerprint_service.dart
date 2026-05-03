import 'dart:convert';
import 'dart:io';
import 'dart:typed_data';

import 'package:dio/dio.dart';
import 'package:image/image.dart' as img;
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

import 'live_scan_frame_cropper.dart';
import 'scan_models.dart';

class AverageHashVisualFingerprintService {
  AverageHashVisualFingerprintService({Dio? dio}) : _dio = dio ?? Dio();

  static const int _hashSize = 16;
  static const int _hashBits = _hashSize * _hashSize;
  static const int _maxImageBytes = 8 * 1024 * 1024;
  static const int _maxIndexedCards = 5000;
  static const String _indexFileName = 'mana_visual_fingerprint_index.json';

  final Dio _dio;
  final Map<String, Uint8List> _remoteFingerprintCache = {};
  final Map<String, _IndexedFingerprint> _index = {};
  Future<void>? _loadFuture;

  Future<double?> compareWithCatalogCard({
    required String imagePath,
    required ScanCatalogCard card,
  }) async {
    final candidateUrl = card.imageUrlSmall ?? card.imageUrlNormal;
    if (candidateUrl == null || candidateUrl.isEmpty) return null;

    final localHash = await _fingerprintLocalCardImage(imagePath);
    final remoteHash = await _fingerprintRemoteCardImage(candidateUrl);
    if (localHash == null || remoteHash == null) return null;
    final distance = _hammingDistance(localHash, remoteHash);
    return (1 - (distance / _hashBits)).clamp(0, 1).toDouble();
  }

  Future<void> indexCatalogCards(List<ScanCatalogCard> cards) async {
    await _ensureIndexLoaded();
    var changed = false;

    for (final card in cards.take(96)) {
      if (_index.containsKey(card.id)) continue;
      final imageUrl = card.imageUrlSmall ?? card.imageUrlNormal;
      if (imageUrl == null || imageUrl.isEmpty) continue;
      try {
        final fingerprint = await _fingerprintRemoteCardImage(imageUrl);
        if (fingerprint == null) continue;
        _index[card.id] = _IndexedFingerprint(
          card: card,
          fingerprint: fingerprint,
          indexedAt: DateTime.now().toUtc(),
        );
        changed = true;
      } on DioException {
        continue;
      } on FormatException {
        continue;
      }
    }

    if (changed) {
      _pruneIndex();
      await _saveIndex();
    }
  }

  Future<List<ScanRecognitionCandidate>> findVisualMatches({
    required String imagePath,
    int limit = 8,
    double minScore = 0.70,
  }) async {
    await _ensureIndexLoaded();
    if (_index.isEmpty) return const <ScanRecognitionCandidate>[];

    final localHash = await _fingerprintLocalCardImage(imagePath);
    if (localHash == null) return const <ScanRecognitionCandidate>[];

    final matches = <ScanRecognitionCandidate>[];
    for (final entry in _index.values) {
      final distance = _hammingDistance(localHash, entry.fingerprint);
      final score = (1 - (distance / _hashBits)).clamp(0, 1).toDouble();
      if (score >= minScore) {
        matches.add(
          ScanRecognitionCandidate(
            card: entry.card,
            score: score,
            matchReason: 'Local visual fingerprint index',
          ),
        );
      }
    }

    matches.sort((a, b) => b.score.compareTo(a.score));
    return matches.take(limit).toList();
  }

  Future<List<ScanRecognitionCandidate>> findVisualMatchesInCrop({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
    Set<String>? allowedCardIds,
    int limit = 8,
    double minScore = 0.78,
  }) async {
    await _ensureIndexLoaded();
    if (_index.isEmpty) return const <ScanRecognitionCandidate>[];

    final localHash = _fingerprintCrop(crop: crop, format: format);
    if (localHash == null) return const <ScanRecognitionCandidate>[];

    final matches = <ScanRecognitionCandidate>[];
    for (final entry in _index.values) {
      if (allowedCardIds != null && !allowedCardIds.contains(entry.card.id)) {
        continue;
      }
      final distance = _hammingDistance(localHash, entry.fingerprint);
      final score = (1 - (distance / _hashBits)).clamp(0, 1).toDouble();
      if (score >= minScore) {
        matches.add(
          ScanRecognitionCandidate(
            card: entry.card,
            score: score,
            matchReason: 'Live visual fingerprint index',
          ),
        );
      }
    }

    matches.sort((a, b) => b.score.compareTo(a.score));
    return matches.take(limit).toList();
  }

  Future<Uint8List?> _fingerprintLocalCardImage(String imagePath) async {
    final file = File(imagePath);
    if (!await file.exists()) return null;
    final length = await file.length();
    if (length <= 0 || length > _maxImageBytes) return null;
    return _fingerprintBytes(await file.readAsBytes(), cropLikelyCard: true);
  }

  Future<Uint8List?> _fingerprintRemoteCardImage(String imageUrl) async {
    final cached = _remoteFingerprintCache[imageUrl];
    if (cached != null) return cached;

    final response = await _dio.get<List<int>>(
      imageUrl,
      options: Options(
        responseType: ResponseType.bytes,
        receiveTimeout: const Duration(seconds: 8),
      ),
    );
    final bytes = response.data;
    if (bytes == null || bytes.isEmpty || bytes.length > _maxImageBytes) {
      return null;
    }

    final fingerprint = _fingerprintBytes(
      Uint8List.fromList(bytes),
      cropLikelyCard: false,
    );
    if (fingerprint == null) return null;
    _remoteFingerprintCache[imageUrl] = fingerprint;
    if (_remoteFingerprintCache.length > 240) {
      _remoteFingerprintCache.remove(_remoteFingerprintCache.keys.first);
    }
    return fingerprint;
  }

  Future<void> _ensureIndexLoaded() {
    return _loadFuture ??= _loadIndex();
  }

  Future<File> _indexFile() async {
    final directory = await getApplicationDocumentsDirectory();
    return File(p.join(directory.path, _indexFileName));
  }

  Future<void> _loadIndex() async {
    final file = await _indexFile();
    if (!await file.exists()) return;

    try {
      final payload = jsonDecode(await file.readAsString());
      if (payload is! Map<String, dynamic>) return;
      final entries = payload['entries'];
      if (entries is! List<dynamic>) return;
      for (final entry in entries.whereType<Map<String, dynamic>>()) {
        final indexed = _IndexedFingerprint.fromJson(entry);
        if (indexed != null) _index[indexed.card.id] = indexed;
      }
      _pruneIndex();
    } on FormatException {
      await file.delete();
    }
  }

  Future<void> _saveIndex() async {
    final file = await _indexFile();
    await file.parent.create(recursive: true);
    final temporaryFile = File('${file.path}.tmp');
    await temporaryFile.writeAsString(
      jsonEncode(<String, dynamic>{
        'version': 1,
        'hash': 'average-hash-${_hashSize}x$_hashSize',
        'updatedAt': DateTime.now().toUtc().toIso8601String(),
        'entries': _index.values.map((entry) => entry.toJson()).toList(),
      }),
      flush: true,
    );
    if (await file.exists()) await file.delete();
    await temporaryFile.rename(file.path);
  }

  void _pruneIndex() {
    if (_index.length <= _maxIndexedCards) return;
    final entries = _index.values.toList()
      ..sort((a, b) => b.indexedAt.compareTo(a.indexedAt));
    _index
      ..clear()
      ..addEntries(
        entries.take(_maxIndexedCards).map(
              (entry) => MapEntry(entry.card.id, entry),
            ),
      );
  }

  Uint8List? _fingerprintBytes(
    Uint8List bytes, {
    required bool cropLikelyCard,
  }) {
    final decoded = img.decodeImage(bytes);
    if (decoded == null || decoded.width < 32 || decoded.height < 32) {
      return null;
    }

    final source = cropLikelyCard ? _centerCropToCardRatio(decoded) : decoded;
    final resized = img.copyResize(
      source,
      width: _hashSize,
      height: _hashSize,
      interpolation: img.Interpolation.average,
    );

    final luminance = <int>[];
    for (var y = 0; y < resized.height; y++) {
      for (var x = 0; x < resized.width; x++) {
        final pixel = resized.getPixel(x, y);
        luminance.add(
          ((pixel.r * 0.299) + (pixel.g * 0.587) + (pixel.b * 0.114)).round(),
        );
      }
    }

    final average =
        luminance.fold<int>(0, (sum, value) => sum + value) / luminance.length;
    return Uint8List.fromList(
      luminance.map((value) => value >= average ? 1 : 0).toList(),
    );
  }

  Uint8List? _fingerprintCrop({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
  }) {
    if (crop.width < 32 || crop.height < 32 || crop.bytes.isEmpty) return null;
    final luminance = _resizedCropLuminance(crop: crop, format: format);
    if (luminance == null || luminance.isEmpty) return null;
    final average =
        luminance.fold<int>(0, (sum, value) => sum + value) / luminance.length;
    return Uint8List.fromList(
      luminance.map((value) => value >= average ? 1 : 0).toList(),
    );
  }

  List<int>? _resizedCropLuminance({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
  }) {
    final values = <int>[];
    for (var y = 0; y < _hashSize; y++) {
      final sourceY = ((y + 0.5) * crop.height / _hashSize)
          .floor()
          .clamp(0, crop.height - 1);
      for (var x = 0; x < _hashSize; x++) {
        final sourceX = ((x + 0.5) * crop.width / _hashSize)
            .floor()
            .clamp(0, crop.width - 1);
        final luminance = switch (format) {
          LiveScanPixelFormat.nv21 => _nv21Luminance(crop, sourceX, sourceY),
          LiveScanPixelFormat.bgra8888 =>
            _bgraLuminance(crop, sourceX, sourceY),
        };
        if (luminance == null) return null;
        values.add(luminance);
      }
    }
    return values;
  }

  int? _nv21Luminance(LiveScanCrop crop, int x, int y) {
    final offset = (y * crop.bytesPerRow) + x;
    if (offset < 0 || offset >= crop.width * crop.height) return null;
    return crop.bytes[offset];
  }

  int? _bgraLuminance(LiveScanCrop crop, int x, int y) {
    final offset = (y * crop.bytesPerRow) + (x * 4);
    if (offset < 0 || offset + 2 >= crop.bytes.length) return null;
    final b = crop.bytes[offset];
    final g = crop.bytes[offset + 1];
    final r = crop.bytes[offset + 2];
    return ((r * 0.299) + (g * 0.587) + (b * 0.114)).round();
  }

  img.Image _centerCropToCardRatio(img.Image image) {
    const cardAspectRatio = 0.716;
    final maxWidth = (image.width * 0.82).round();
    final maxHeight = (image.height * 0.86).round();
    var cropHeight = maxHeight;
    var cropWidth = (cropHeight * cardAspectRatio).round();
    if (cropWidth > maxWidth) {
      cropWidth = maxWidth;
      cropHeight = (cropWidth / cardAspectRatio).round();
    }
    cropWidth = cropWidth.clamp(32, image.width);
    cropHeight = cropHeight.clamp(32, image.height);
    final x = ((image.width - cropWidth) / 2).round().clamp(0, image.width);
    final y = ((image.height - cropHeight) / 2).round().clamp(0, image.height);
    return img.copyCrop(
      image,
      x: x,
      y: y,
      width: cropWidth,
      height: cropHeight,
    );
  }

  int _hammingDistance(Uint8List left, Uint8List right) {
    final length = left.length < right.length ? left.length : right.length;
    var distance = 0;
    for (var i = 0; i < length; i++) {
      if (left[i] != right[i]) distance++;
    }
    return distance + (left.length - right.length).abs();
  }
}

class _IndexedFingerprint {
  const _IndexedFingerprint({
    required this.card,
    required this.fingerprint,
    required this.indexedAt,
  });

  final ScanCatalogCard card;
  final Uint8List fingerprint;
  final DateTime indexedAt;

  Map<String, dynamic> toJson() {
    return <String, dynamic>{
      'card': <String, dynamic>{
        'id': card.id,
        'oracleId': card.oracleId,
        'name': card.name,
        'setCode': card.setCode,
        'setName': card.setName,
        'collectorNumber': card.collectorNumber,
        'rarity': card.rarity,
        'typeLine': card.typeLine,
        'manaCost': card.manaCost,
        'imageUrlSmall': card.imageUrlSmall,
        'imageUrlNormal': card.imageUrlNormal,
        'imageUrlPng': card.imageUrlPng,
      },
      'fingerprint': base64Encode(fingerprint),
      'indexedAt': indexedAt.toIso8601String(),
    };
  }

  static _IndexedFingerprint? fromJson(Map<String, dynamic> json) {
    final cardPayload = json['card'];
    final fingerprintPayload = json['fingerprint'];
    if (cardPayload is! Map<String, dynamic> || fingerprintPayload is! String) {
      return null;
    }
    final id = cardPayload['id']?.toString() ?? '';
    final name = cardPayload['name']?.toString() ?? '';
    if (id.isEmpty || name.isEmpty) return null;
    return _IndexedFingerprint(
      card: ScanCatalogCard(
        id: id,
        oracleId: cardPayload['oracleId']?.toString() ?? '',
        name: name,
        setCode: cardPayload['setCode']?.toString() ?? '',
        setName: cardPayload['setName']?.toString() ?? '',
        collectorNumber: cardPayload['collectorNumber']?.toString() ?? '',
        rarity: cardPayload['rarity']?.toString() ?? '',
        typeLine: cardPayload['typeLine']?.toString() ?? '',
        manaCost: cardPayload['manaCost']?.toString(),
        imageUrlSmall: cardPayload['imageUrlSmall']?.toString(),
        imageUrlNormal: cardPayload['imageUrlNormal']?.toString(),
        imageUrlPng: cardPayload['imageUrlPng']?.toString(),
      ),
      fingerprint: base64Decode(fingerprintPayload),
      indexedAt: DateTime.tryParse(json['indexedAt']?.toString() ?? '') ??
          DateTime.fromMillisecondsSinceEpoch(0, isUtc: true),
    );
  }
}
