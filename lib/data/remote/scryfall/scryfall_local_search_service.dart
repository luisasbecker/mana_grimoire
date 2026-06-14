import 'package:drift/drift.dart';

import '../../local/db/app_database.dart';
import '../../local/db/db_instance.dart';
import 'scryfall_client.dart';

String scryfallLocalFallbackErrorMessage(Object error) {
  final text = error.toString();
  if (text.contains('CERTIFICATE_VERIFY_FAILED') ||
      text.contains('HandshakeException') ||
      text.contains('status code of 403')) {
    return 'A Scryfall está bloqueada ou indisponível na rede atual. '
        'Não encontrei esse termo no catálogo local.';
  }
  return text;
}

class ScryfallLocalSearchService {
  ScryfallLocalSearchService({AppDatabase? database})
      : _database = database ?? appDb;

  final AppDatabase _database;

  Future<List<Map<String, dynamic>>> searchCards(
    String query, {
    String unique = 'cards',
    int limit = 30,
  }) async {
    final trimmed = query.trim();
    if (trimmed.isEmpty) return const <Map<String, dynamic>>[];

    final oracleId = _oracleIdFromQuery(trimmed);
    if (oracleId != null) {
      return searchPrintingsForOracleId(oracleId, limit: limit);
    }

    final normalized = _escapeLike(trimmed.toLowerCase());
    final contains = '%$normalized%';
    final prefix = '$normalized%';

    final rows = await _database.customSelect(
      '''
          SELECT
            printing_id,
            oracle_id,
            name,
            printed_name,
            language,
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
            legalities_json
          FROM scryfall_printings
          WHERE lower(name) LIKE ? ESCAPE '\\'
             OR lower(COALESCE(printed_name, '')) LIKE ? ESCAPE '\\'
          ORDER BY
            CASE
              WHEN lower(name) = ? THEN 0
              WHEN lower(COALESCE(printed_name, '')) = ? THEN 0
              WHEN lower(name) LIKE ? ESCAPE '\\' THEN 1
              WHEN lower(COALESCE(printed_name, '')) LIKE ? ESCAPE '\\' THEN 1
              ELSE 2
            END,
            name COLLATE NOCASE ASC,
            released_at DESC,
            set_code COLLATE NOCASE ASC
          LIMIT ?
          ''',
      variables: [
        Variable<String>(contains),
        Variable<String>(contains),
        Variable<String>(trimmed.toLowerCase()),
        Variable<String>(trimmed.toLowerCase()),
        Variable<String>(prefix),
        Variable<String>(prefix),
        Variable<int>(limit * 6),
      ],
      readsFrom: {_database.scryfallPrintings},
    ).get();

    final cards = rows.map(_rowToScryfallCard).toList();
    if (unique == 'prints') return cards.take(limit).toList();
    return _uniqueByOracle(cards, limit: limit);
  }

  Future<ScryfallCardSearchPage> searchCardsFirstPage(
    String query, {
    String unique = 'cards',
    int limit = 80,
  }) async {
    final data = await searchCards(query, unique: unique, limit: limit);
    return ScryfallCardSearchPage(data: data, hasMore: false);
  }

  Future<List<Map<String, dynamic>>> searchPrintingsForOracleId(
    String oracleId, {
    int limit = 600,
  }) async {
    final rows = await _database.customSelect(
      '''
          SELECT
            printing_id,
            oracle_id,
            name,
            printed_name,
            language,
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
            legalities_json
          FROM scryfall_printings
          WHERE oracle_id = ?
          ORDER BY released_at DESC, set_code COLLATE NOCASE ASC
          LIMIT ?
          ''',
      variables: [
        Variable<String>(oracleId),
        Variable<int>(limit),
      ],
      readsFrom: {_database.scryfallPrintings},
    ).get();
    return rows.map(_rowToScryfallCard).toList();
  }

  Future<Map<String, dynamic>?> getCardById(String printingId) async {
    final rows = await _database.customSelect(
      '''
          SELECT
            printing_id,
            oracle_id,
            name,
            printed_name,
            language,
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
            legalities_json
          FROM scryfall_printings
          WHERE printing_id = ?
          LIMIT 1
          ''',
      variables: [Variable<String>(printingId)],
      readsFrom: {_database.scryfallPrintings},
    ).get();
    if (rows.isEmpty) return null;
    return _rowToScryfallCard(rows.first);
  }

  List<Map<String, dynamic>> _uniqueByOracle(
    List<Map<String, dynamic>> cards, {
    required int limit,
  }) {
    final byOracle = <String, Map<String, dynamic>>{};
    for (final card in cards) {
      final oracleId = card['oracle_id'] as String?;
      if (oracleId == null || oracleId.isEmpty) continue;
      byOracle.putIfAbsent(oracleId, () => card);
      if (byOracle.length >= limit) break;
    }
    return byOracle.values.toList();
  }

  Map<String, dynamic> _rowToScryfallCard(QueryRow row) {
    final data = row.data;
    final imageUris = <String, String>{};
    final imageSmall = data['image_small'] as String?;
    final imageNormal = data['image_normal'] as String?;
    final imagePng = data['image_png'] as String?;
    if (imageSmall != null && imageSmall.isNotEmpty) {
      imageUris['small'] = imageSmall;
    }
    if (imageNormal != null && imageNormal.isNotEmpty) {
      imageUris['normal'] = imageNormal;
    }
    if (imagePng != null && imagePng.isNotEmpty) {
      imageUris['png'] = imagePng;
    }

    final card = <String, dynamic>{
      'id': data['printing_id'] as String,
      'oracle_id': data['oracle_id'] as String,
      'name': data['name'] as String,
      'printed_name': data['printed_name'] as String?,
      'lang': data['language'] as String?,
      'type_line': data['type_line'] as String? ?? '',
      'set': data['set_code'] as String? ?? '',
      'set_name': data['set_name'] as String? ?? '',
      'collector_number': data['collector_number'] as String? ?? '',
      'mana_cost': data['mana_cost'] as String?,
      'mana_value': data['mana_value'],
      'rarity': data['rarity'] as String?,
      'legalities': const <String, String>{},
      'prices': const <String, String?>{'usd': null},
    };
    if (imageUris.isNotEmpty) card['image_uris'] = imageUris;

    final releasedAt = data['released_at'];
    if (releasedAt != null) {
      card['released_at'] = releasedAt is DateTime
          ? releasedAt.toIso8601String().split('T').first
          : releasedAt.toString().split(' ').first;
    }
    return card;
  }

  String? _oracleIdFromQuery(String query) {
    final match = RegExp(r'oracleid:([0-9a-fA-F-]+)').firstMatch(query.trim());
    return match?.group(1);
  }

  String _escapeLike(String value) {
    return value
        .replaceAll(r'\', r'\\')
        .replaceAll('%', r'\%')
        .replaceAll('_', r'\_');
  }
}
