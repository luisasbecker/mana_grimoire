import 'package:drift/drift.dart' as drift;
import 'package:drift/native.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/data/local/db/app_database.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  test('CollectionDao.updateItem merges into equivalent target item', () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    final now = DateTime.now();
    final suffix = now.microsecondsSinceEpoch.toString();
    final collectionId = 'test-collection-merge-$suffix';
    final printingId = 'test-printing-merge-$suffix';
    final sourceItemId = 'test-item-source-$suffix';
    final targetItemId = 'test-item-target-$suffix';

    try {
      await db.collectionDao.createCollection(
        id: collectionId,
        name: 'Merge Test',
        now: now,
      );
      await db.scryfallCacheDao.upsertPrintings([
        ScryfallPrintingsCompanion.insert(
          printingId: printingId,
          oracleId: 'oracle-merge',
          name: 'Sol Ring',
          typeLine: 'Artifact',
          setCode: 'cmm',
          setName: 'Commander Masters',
          collectorNumber: '1',
          releasedAt: const drift.Value.absent(),
          manaCost: const drift.Value.absent(),
          manaValue: const drift.Value.absent(),
          rarity: const drift.Value.absent(),
          imageSmall: const drift.Value.absent(),
          imageNormal: const drift.Value.absent(),
          imagePng: const drift.Value.absent(),
          legalitiesJson: const drift.Value.absent(),
          updatedAtCache: now,
        ),
      ]);

      await db.collectionDao.addOrIncrementItem(
        itemId: sourceItemId,
        collectionId: collectionId,
        printingId: printingId,
        quantity: 2,
        isFoil: false,
        condition: 'NM',
        language: 'EN',
        now: now,
      );
      await db.collectionDao.addOrIncrementItem(
        itemId: targetItemId,
        collectionId: collectionId,
        printingId: printingId,
        quantity: 3,
        isFoil: true,
        condition: 'SP',
        language: 'PT',
        now: now,
      );

      await db.collectionDao.updateItem(
        itemId: sourceItemId,
        quantity: 2,
        isFoil: true,
        condition: 'SP',
        language: 'PT',
        now: now.add(const Duration(minutes: 1)),
      );

      final rows = await db.collectionDao
          .watchCollectionItems(collectionId: collectionId)
          .first;
      expect(rows.length, 1);
      expect(rows.single.item.id, targetItemId);
      expect(rows.single.item.quantity, 5);
    } finally {
      await db.close();
    }
  });
}
