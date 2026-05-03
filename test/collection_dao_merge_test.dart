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

  test('CollectionDao.updateItemAndPrintingMerge merges changed edition',
      () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    final now = DateTime.now();
    final suffix = now.microsecondsSinceEpoch.toString();
    final collectionId = 'test-collection-printing-merge-$suffix';
    final oldPrintingId = 'test-printing-old-$suffix';
    final newPrintingId = 'test-printing-new-$suffix';
    final sourceItemId = 'test-item-source-printing-$suffix';
    final targetItemId = 'test-item-target-printing-$suffix';

    try {
      await db.collectionDao.createCollection(
        id: collectionId,
        name: 'Printing Merge Test',
        now: now,
      );
      await db.scryfallCacheDao.upsertPrintings([
        _printing(
          printingId: oldPrintingId,
          oracleId: 'oracle-printing-merge',
          setCode: 'lea',
          setName: 'Limited Edition Alpha',
          now: now,
        ),
        _printing(
          printingId: newPrintingId,
          oracleId: 'oracle-printing-merge',
          setCode: 'cmm',
          setName: 'Commander Masters',
          now: now,
        ),
      ]);

      await db.collectionDao.addOrIncrementItem(
        itemId: sourceItemId,
        collectionId: collectionId,
        printingId: oldPrintingId,
        quantity: 2,
        isFoil: false,
        condition: 'NM',
        language: 'EN',
        now: now,
      );
      await db.collectionDao.addOrIncrementItem(
        itemId: targetItemId,
        collectionId: collectionId,
        printingId: newPrintingId,
        quantity: 3,
        isFoil: true,
        condition: 'SP',
        language: 'PT',
        now: now,
      );

      await db.collectionDao.updateItemAndPrintingMerge(
        itemId: sourceItemId,
        newPrintingId: newPrintingId,
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
      expect(rows.single.item.printingId, newPrintingId);
      expect(rows.single.item.quantity, 5);
    } finally {
      await db.close();
    }
  });
}

ScryfallPrintingsCompanion _printing({
  required String printingId,
  required String oracleId,
  required String setCode,
  required String setName,
  required DateTime now,
}) {
  return ScryfallPrintingsCompanion.insert(
    printingId: printingId,
    oracleId: oracleId,
    name: 'Sol Ring',
    typeLine: 'Artifact',
    setCode: setCode,
    setName: setName,
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
  );
}
