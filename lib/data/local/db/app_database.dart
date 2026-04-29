import 'package:drift/drift.dart';
import 'package:drift_flutter/drift_flutter.dart';

import 'tables.dart';
import 'daos/scryfall_cache_dao.dart';
import 'daos/collection_dao.dart';
import 'daos/decks_dao.dart';
import 'daos/deck_entries_dao.dart';

part 'app_database.g.dart';

@DriftDatabase(
  tables: [
    ScryfallPrintings,
    PriceSnapshots,
    Collections,
    CollectionItems,
    Decks,
    DeckEntries,
  ],
  daos: [ScryfallCacheDao, CollectionDao, DecksDao, DeckEntriesDao],
)
class AppDatabase extends _$AppDatabase {
  AppDatabase() : super(_openConnection());

  @override
  int get schemaVersion => 6;

  @override
  MigrationStrategy get migration => MigrationStrategy(
        onCreate: (m) async => m.createAll(),
        onUpgrade: (m, from, to) async {
          if (from < 2) {
            await m.createTable(scryfallPrintings);
            await m.createTable(priceSnapshots);
          }
          if (from < 3) {
            await m.createTable(collections);
            await m.createTable(collectionItems);
          }
          if (from < 4) {
            await m.createTable(decks);
          }
          if (from < 5) {
            await m.createTable(deckEntries);
          }
          if (from < 6) {
            await m.addColumn(decks, decks.isActive);
          }
        },
      );
}

QueryExecutor _openConnection() {
  return driftDatabase(
    name: 'mana_grimoire',
    web: DriftWebOptions(
      sqlite3Wasm: Uri.parse('sqlite3.wasm'),
      driftWorker: Uri.parse('drift_worker.dart.js'),
    ),
  );
}
