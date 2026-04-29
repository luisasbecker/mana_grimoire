import 'package:drift/drift.dart';

import '../app_database.dart';
import '../tables.dart';

part 'deck_entries_dao.g.dart';

class DeckEntryView {
  DeckEntryView({
    required this.entry,
    required this.printing,
  });

  final DeckEntry entry;
  final ScryfallPrinting? printing;
}

@DriftAccessor(tables: [DeckEntries, ScryfallPrintings])
class DeckEntriesDao extends DatabaseAccessor<AppDatabase>
    with _$DeckEntriesDaoMixin {
  DeckEntriesDao(super.db);

  Future<DeckEntry?> getEntryOnceForDeckOracleSection({
    required String deckId,
    required String oracleId,
    required String section,
  }) {
    return (select(deckEntries)
          ..where((t) =>
              t.deckId.equals(deckId) &
              t.oracleId.equals(oracleId) &
              t.section.equals(section))
          ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)])
          ..limit(1))
        .getSingleOrNull();
  }

  Future<void> setSection({
    required String entryId,
    required String section,
    required DateTime now,
  }) async {
    await (update(deckEntries)..where((t) => t.id.equals(entryId))).write(
      DeckEntriesCompanion(
        section: Value(section),
        updatedAt: Value(now),
      ),
    );
  }

  Stream<List<DeckEntryView>> watchDeckEntriesForSection({
    required String deckId,
    required String section,
  }) {
    final entriesQ = select(deckEntries)
      ..where((t) => t.deckId.equals(deckId) & t.section.equals(section))
      ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]);

    final joinQ = entriesQ.join([
      leftOuterJoin(
        scryfallPrintings,
        scryfallPrintings.printingId
            .equalsExp(deckEntries.preferredPrintingId),
      ),
    ]);

    return joinQ.watch().map((rows) {
      return rows.map((r) {
        final entry = r.readTable(deckEntries);
        final printing = r.readTableOrNull(scryfallPrintings);
        return DeckEntryView(entry: entry, printing: printing);
      }).toList();
    });
  }

  Stream<List<DeckEntryView>> watchDeckEntries({
    required String deckId,
    String? cardNameFilter,
  }) {
    final entriesQ = select(deckEntries)
      ..where((t) => t.deckId.equals(deckId))
      ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]);

    final joinQ = entriesQ.join([
      leftOuterJoin(
        scryfallPrintings,
        scryfallPrintings.printingId
            .equalsExp(deckEntries.preferredPrintingId),
      ),
    ]);

    if (cardNameFilter != null && cardNameFilter.trim().isNotEmpty) {
      joinQ.where(scryfallPrintings.name.like('%${cardNameFilter.trim()}%'));
    }

    return joinQ.watch().map((rows) {
      return rows.map((r) {
        final entry = r.readTable(deckEntries);
        final printing = r.readTableOrNull(scryfallPrintings);
        return DeckEntryView(entry: entry, printing: printing);
      }).toList();
    });
  }

  Future<void> addOrIncrement({
    required String id,
    required String deckId,
    required String oracleId,
    String? preferredPrintingId,
    required int quantityDelta,
    required DateTime now,
    String section = 'main',
  }) async {
    await transaction(() async {
      final existing = await (select(deckEntries)
            ..where((t) =>
                t.deckId.equals(deckId) &
                t.oracleId.equals(oracleId) &
                t.section.equals(section) &
                (preferredPrintingId == null
                    ? t.preferredPrintingId.isNull()
                    : t.preferredPrintingId.equals(preferredPrintingId))))
          .getSingleOrNull();

      if (existing != null) {
        final newQty = existing.quantity + quantityDelta;
        if (newQty <= 0) {
          await (delete(deckEntries)..where((t) => t.id.equals(existing.id)))
              .go();
          return;
        }
        await (update(deckEntries)..where((t) => t.id.equals(existing.id))).write(
          DeckEntriesCompanion(
            quantity: Value(newQty),
            updatedAt: Value(now),
          ),
        );
        return;
      }

      if (quantityDelta <= 0) return;

      await into(deckEntries).insert(
        DeckEntriesCompanion.insert(
          id: id,
          deckId: deckId,
          oracleId: oracleId,
          preferredPrintingId: Value(preferredPrintingId),
          collectionItemId: const Value.absent(),
          quantity: quantityDelta,
          section: Value(section),
          ownedStatus: const Value('notOwned'),
          createdAt: now,
          updatedAt: now,
        ),
      );
    });
  }

  Future<void> setQuantity({
    required String entryId,
    required int quantity,
    required DateTime now,
  }) async {
    if (quantity <= 0) {
      await (delete(deckEntries)..where((t) => t.id.equals(entryId))).go();
      return;
    }
    await (update(deckEntries)..where((t) => t.id.equals(entryId))).write(
      DeckEntriesCompanion(
        quantity: Value(quantity),
        updatedAt: Value(now),
      ),
    );
  }

  Future<void> setPreferredPrinting({
    required String entryId,
    required String? preferredPrintingId,
    required DateTime now,
  }) async {
    await (update(deckEntries)..where((t) => t.id.equals(entryId))).write(
      DeckEntriesCompanion(
        preferredPrintingId: Value(preferredPrintingId),
        updatedAt: Value(now),
      ),
    );
  }

  Future<void> deleteEntriesForDeck(String deckId) async {
    await (delete(deckEntries)..where((t) => t.deckId.equals(deckId))).go();
  }
}

