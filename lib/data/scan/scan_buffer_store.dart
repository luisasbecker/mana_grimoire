import 'dart:convert';
import 'dart:io';

import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

import 'scan_models.dart';

class ScanBufferStore {
  static const _fileName = 'mana_live_scan_buffer.json';
  static const _maxEntries = 250;

  Future<List<BufferedScanEntry>> load() async {
    final file = await _bufferFile();
    if (!await file.exists()) return const <BufferedScanEntry>[];

    try {
      final payload = jsonDecode(await file.readAsString());
      if (payload is! Map<String, dynamic>) {
        return const <BufferedScanEntry>[];
      }
      final entries = payload['entries'];
      if (entries is! List<dynamic>) return const <BufferedScanEntry>[];
      return entries
          .whereType<Map<String, dynamic>>()
          .map(_entryFromJson)
          .whereType<BufferedScanEntry>()
          .take(_maxEntries)
          .toList();
    } on FormatException {
      await clear();
      return const <BufferedScanEntry>[];
    }
  }

  Future<void> save(List<BufferedScanEntry> entries) async {
    final file = await _bufferFile();
    await file.parent.create(recursive: true);
    final temporaryFile = File('${file.path}.tmp');
    await temporaryFile.writeAsString(
      jsonEncode(<String, dynamic>{
        'version': 1,
        'updatedAt': DateTime.now().toUtc().toIso8601String(),
        'entries': entries.take(_maxEntries).map(_entryToJson).toList(),
      }),
      flush: true,
    );
    if (await file.exists()) await file.delete();
    await temporaryFile.rename(file.path);
  }

  Future<void> clear() async {
    final file = await _bufferFile();
    if (await file.exists()) await file.delete();
  }

  Future<File> _bufferFile() async {
    final directory = await getApplicationDocumentsDirectory();
    return File(p.join(directory.path, _fileName));
  }

  Map<String, dynamic> _entryToJson(BufferedScanEntry entry) {
    return <String, dynamic>{
      'card': _cardToJson(entry.card),
      'quantity': entry.quantity.clamp(1, 9999),
      'firstSeenAt': entry.firstSeenAt.toIso8601String(),
      'lastSeenAt': entry.lastSeenAt.toIso8601String(),
      'confidence': entry.confidence.clamp(0, 1),
      'isFoil': entry.isFoil,
      'language': entry.language,
      'condition': entry.condition,
      'notes': entry.notes,
    };
  }

  BufferedScanEntry? _entryFromJson(Map<String, dynamic> json) {
    final cardPayload = json['card'];
    if (cardPayload is! Map<String, dynamic>) return null;
    final card = _cardFromJson(cardPayload);
    if (card == null) return null;
    return BufferedScanEntry(
      card: card,
      quantity: (json['quantity'] as int? ?? 1).clamp(1, 9999),
      firstSeenAt: DateTime.tryParse(json['firstSeenAt']?.toString() ?? '') ??
          DateTime.now().toUtc(),
      lastSeenAt: DateTime.tryParse(json['lastSeenAt']?.toString() ?? '') ??
          DateTime.now().toUtc(),
      confidence: (json['confidence'] as num? ?? 0).toDouble().clamp(0, 1),
      isFoil: json['isFoil'] == true,
      language: _normalize(json['language']?.toString() ?? 'EN'),
      condition: _normalize(json['condition']?.toString() ?? 'NM'),
      notes: _normalizeNullable(json['notes']?.toString()),
    );
  }

  Map<String, dynamic> _cardToJson(ScanCatalogCard card) {
    return <String, dynamic>{
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
    };
  }

  ScanCatalogCard? _cardFromJson(Map<String, dynamic> json) {
    final id = _normalize(json['id']?.toString() ?? '');
    final name = _normalize(json['name']?.toString() ?? '');
    if (id.isEmpty || name.isEmpty) return null;
    return ScanCatalogCard(
      id: id,
      oracleId: _normalize(json['oracleId']?.toString() ?? ''),
      name: name,
      setCode: _normalize(json['setCode']?.toString() ?? ''),
      setName: _normalize(json['setName']?.toString() ?? ''),
      collectorNumber: _normalize(json['collectorNumber']?.toString() ?? ''),
      rarity: _normalize(json['rarity']?.toString() ?? ''),
      typeLine: _normalize(json['typeLine']?.toString() ?? ''),
      manaCost: _normalizeNullable(json['manaCost']?.toString()),
      imageUrlSmall: _normalizeNullable(json['imageUrlSmall']?.toString()),
      imageUrlNormal: _normalizeNullable(json['imageUrlNormal']?.toString()),
      imageUrlPng: _normalizeNullable(json['imageUrlPng']?.toString()),
    );
  }

  String _normalize(String value) => value.trim();

  String? _normalizeNullable(String? value) {
    if (value == null) return null;
    final normalized = _normalize(value);
    return normalized.isEmpty ? null : normalized;
  }
}
