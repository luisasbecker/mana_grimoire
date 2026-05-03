import 'package:drift/drift.dart';

import '../app_database.dart';
import '../tables.dart';

part 'decks_dao.g.dart';

class DeckActivationConflict {
  DeckActivationConflict({
    required this.oracleId,
    required this.name,
    required this.quantity,
  });

  final String oracleId;
  final String name;
  final int quantity;
}

class DeckActivationCheckResult {
  DeckActivationCheckResult({
    required this.activeDeck,
    required this.conflicts,
  });

  final Deck? activeDeck;
  final List<DeckActivationConflict> conflicts;
}

@DriftAccessor(tables: [Decks, DeckEntries, CollectionItems, ScryfallPrintings])
class DecksDao extends DatabaseAccessor<AppDatabase> with _$DecksDaoMixin {
  DecksDao(super.db);

  Stream<List<Deck>> watchDecks() {
    final q = select(decks)..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]);
    return q.watch();
  }

  /// Retorna se cada deck está "completo" na coleção (MVP):
  /// para cada oracleId do deck, required <= owned (somando todos CollectionItems).
  ///
  /// Decks sem entradas não aparecem no resultado e devem ser tratados como completos.
  Stream<Map<String, bool>> watchDeckCompleteness() {
    final q = customSelect(
      '''
      WITH required AS (
        SELECT deck_id AS deckId, oracle_id AS oracleId, SUM(quantity) AS req
        FROM deck_entries
        GROUP BY deck_id, oracle_id
      ),
      owned AS (
        SELECT sp.oracle_id AS oracleId, SUM(ci.quantity) AS own
        FROM collection_items ci
        INNER JOIN scryfall_printings sp ON sp.printing_id = ci.printing_id
        GROUP BY sp.oracle_id
      )
      SELECT r.deckId AS deckId,
             SUM(CASE WHEN r.req > COALESCE(o.own, 0) THEN 1 ELSE 0 END) AS missingLines
      FROM required r
      LEFT JOIN owned o ON o.oracleId = r.oracleId
      GROUP BY r.deckId
      ''',
      readsFrom: {deckEntries, collectionItems, scryfallPrintings},
    );

    return q.watch().map((rows) {
      final out = <String, bool>{};
      for (final r in rows) {
        final deckId = r.read<String>('deckId');
        final missing = r.read<int>('missingLines');
        out[deckId] = missing == 0;
      }
      return out;
    });
  }

  Future<void> createDeck({
    required String id,
    required String name,
    required String format,
    required DateTime now,
  }) async {
    await into(decks).insert(
      DecksCompanion.insert(
        id: id,
        name: name,
        format: format,
        isActive: const Value(false),
        createdAt: now,
        updatedAt: now,
      ),
      mode: InsertMode.insertOrReplace,
    );
  }

  Future<Deck?> getDeckOnce(String id) {
    return (select(decks)..where((t) => t.id.equals(id))).getSingleOrNull();
  }

  Future<Deck?> getActiveDeckOnce() {
    return (select(decks)..where((t) => t.isActive.equals(true)))
        .getSingleOrNull();
  }

  Future<void> setDeckActive({
    required String deckId,
    required bool isActive,
    required DateTime now,
  }) async {
    await transaction(() async {
      if (isActive) {
        // Garantia MVP: somente 1 deck ativo.
        await (update(decks)..where((t) => t.isActive.equals(true))).write(
          DecksCompanion(
            isActive: const Value(false),
          ),
        );
      }
      await (update(decks)..where((t) => t.id.equals(deckId))).write(
        DecksCompanion(
          isActive: Value(isActive),
        ),
      );
    });
  }

  Future<void> deactivateAllDecks() async {
    await (update(decks)..where((t) => t.isActive.equals(true))).write(
      const DecksCompanion(
        isActive: Value(false),
      ),
    );
  }

  Future<Map<String, int>> _sumDeckRequiredByOracleId(String deckId) async {
    final rows = await customSelect(
      '''
      SELECT oracle_id AS oracleId, SUM(quantity) AS qty
      FROM deck_entries
      WHERE deck_id = ?
      GROUP BY oracle_id
      ''',
      variables: [Variable<String>(deckId)],
      readsFrom: {deckEntries},
    ).get();

    final out = <String, int>{};
    for (final r in rows) {
      final oracleId = r.read<String>('oracleId');
      final qty = r.read<int>('qty');
      out[oracleId] = qty;
    }
    return out;
  }

  Future<Map<String, int>> _sumOwnedByOracleId() async {
    final rows = await customSelect(
      '''
      SELECT sp.oracle_id AS oracleId, SUM(ci.quantity) AS qty
      FROM collection_items ci
      INNER JOIN scryfall_printings sp ON sp.printing_id = ci.printing_id
      GROUP BY sp.oracle_id
      ''',
      readsFrom: {collectionItems, scryfallPrintings},
    ).get();

    final out = <String, int>{};
    for (final r in rows) {
      final oracleId = r.read<String>('oracleId');
      final qty = r.read<int>('qty');
      out[oracleId] = qty;
    }
    return out;
  }

  Future<Map<String, String>> _deckOracleIdToName(String deckId) async {
    // Melhor esforço: pega um nome cacheado por oracleId via printing preferida.
    final rows = await customSelect(
      '''
      SELECT de.oracle_id AS oracleId, COALESCE(sp.name, de.oracle_id) AS name
      FROM deck_entries de
      LEFT JOIN scryfall_printings sp ON sp.printing_id = de.preferred_printing_id
      WHERE de.deck_id = ?
      ''',
      variables: [Variable<String>(deckId)],
      readsFrom: {deckEntries, scryfallPrintings},
    ).get();

    final out = <String, String>{};
    for (final r in rows) {
      final oracleId = r.read<String>('oracleId');
      final name = r.read<String>('name');
      out.putIfAbsent(oracleId, () => name);
    }
    return out;
  }

  Future<DeckActivationCheckResult> checkActivationConflicts(
    String deckId,
  ) async {
    final active = await getActiveDeckOnce();
    if (active == null || active.id == deckId) {
      return DeckActivationCheckResult(activeDeck: active, conflicts: const []);
    }

    final requiredNew = await _sumDeckRequiredByOracleId(deckId);
    final usedByActive = await _sumDeckRequiredByOracleId(active.id);
    final owned = await _sumOwnedByOracleId();
    final names = await _deckOracleIdToName(deckId);

    final conflicts = <DeckActivationConflict>[];
    for (final e in requiredNew.entries) {
      final oracleId = e.key;
      final req = e.value;
      final own = owned[oracleId] ?? 0;
      final used = usedByActive[oracleId] ?? 0;
      final available = own - used;
      if (req > available) {
        conflicts.add(
          DeckActivationConflict(
            oracleId: oracleId,
            name: names[oracleId] ?? oracleId,
            quantity: req - available,
          ),
        );
      }
    }

    conflicts.sort((a, b) {
      final d = b.quantity.compareTo(a.quantity);
      return d != 0 ? d : a.name.toLowerCase().compareTo(b.name.toLowerCase());
    });

    return DeckActivationCheckResult(activeDeck: active, conflicts: conflicts);
  }

  Future<void> updateDeck({
    required String id,
    required String name,
    required String format,
    required DateTime now,
  }) async {
    await (update(decks)..where((t) => t.id.equals(id))).write(
      DecksCompanion(
        name: Value(name),
        format: Value(format),
        updatedAt: Value(now),
      ),
    );
  }

  Future<void> deleteDeck(String id) async {
    await (delete(decks)..where((t) => t.id.equals(id))).go();
  }
}
