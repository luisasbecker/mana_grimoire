import 'dart:typed_data';

import 'package:drift/drift.dart' as drift;
import 'package:drift/native.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/data/local/db/app_database.dart';
import 'package:mana_grimoire/data/scan/catalog_scan_index.dart';
import 'package:mana_grimoire/data/scan/live_scan_acceptance.dart';
import 'package:mana_grimoire/data/scan/live_scan_frame_cropper.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  test('live name OCR result is strong enough to enter acceptance flow',
      () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    try {
      final now = DateTime(2026);
      await db.scryfallCacheDao.upsertPrintings([
        ScryfallPrintingsCompanion.insert(
          printingId: 'sol-ring-cmm-1',
          oracleId: 'sol-ring-oracle',
          name: 'Sol Ring',
          typeLine: 'Artifact',
          setCode: 'cmm',
          setName: 'Commander Masters',
          collectorNumber: '1',
          releasedAt: const drift.Value.absent(),
          manaCost: const drift.Value('{1}'),
          manaValue: const drift.Value(1),
          rarity: const drift.Value('uncommon'),
          imageSmall: const drift.Value.absent(),
          imageNormal: const drift.Value.absent(),
          imagePng: const drift.Value.absent(),
          legalitiesJson: const drift.Value.absent(),
          updatedAtCache: now,
        ),
      ]);

      final index = CatalogScanIndex(database: db);
      final candidates = await index.search(rawText: 'Sol Ring');
      expect(candidates, isNotEmpty);
      expect(candidates.first.name, 'Sol Ring');
      expect(candidates.first.score, greaterThanOrEqualTo(0.88));
      expect(candidates.first.matchReason, contains('unique name'));

      const policy = LiveScanAcceptancePolicy(
        fastConfirmations: 2,
        strictConfirmations: 3,
      );
      final acceptance = policy.evaluate(candidates.first);
      expect(acceptance.canAutoAccept, isTrue);
      expect(acceptance.confirmationsRequired, 2);
    } finally {
      await db.close();
    }
  });

  test('localized printed names are indexed as live scan aliases', () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    try {
      final now = DateTime(2026);
      await db.scryfallCacheDao.upsertPrintings([
        ScryfallPrintingsCompanion.insert(
          printingId: 'mindslaver-otj-pt-63',
          oracleId: 'mindslaver-oracle',
          name: 'Mindslaver',
          printedName: const drift.Value('Escraviza-Mentes'),
          language: const drift.Value('pt'),
          typeLine: 'Legendary Artifact',
          setCode: 'otj',
          setName: 'Outlaws of Thunder Junction',
          collectorNumber: '63',
          releasedAt: const drift.Value.absent(),
          manaCost: const drift.Value('{6}'),
          manaValue: const drift.Value(6),
          rarity: const drift.Value('mythic'),
          imageSmall: const drift.Value.absent(),
          imageNormal: const drift.Value.absent(),
          imagePng: const drift.Value.absent(),
          legalitiesJson: const drift.Value.absent(),
          updatedAtCache: now,
        ),
      ]);

      final index = CatalogScanIndex(database: db);
      final candidates = await index.search(rawText: 'ESCRAVIZA-MENTES');
      expect(candidates, isNotEmpty);
      expect(candidates.first.name, 'Mindslaver');
      expect(candidates.first.card.printedName, 'Escraviza-Mentes');
      expect(candidates.first.score, greaterThanOrEqualTo(0.88));
    } finally {
      await db.close();
    }
  });

  test('live duplicate gate blocks repeated reads until another card appears',
      () {
    final gate = LiveScanDuplicateGate();

    expect(gate.shouldAccept('mindslaver|nonfoil|NM|EN'), isTrue);
    expect(gate.shouldAccept('mindslaver|nonfoil|NM|EN'), isFalse);
    expect(gate.shouldAccept('sol-ring|nonfoil|NM|EN'), isTrue);
    expect(gate.shouldAccept('mindslaver|nonfoil|NM|EN'), isTrue);

    gate.reset();
    expect(gate.shouldAccept('mindslaver|nonfoil|NM|EN'), isTrue);
  });

  test('card guide and camera crop use the same real card geometry', () {
    final guide = LiveScanFrameCropper.cardGuideForUprightFrame(
      width: 720,
      height: 1280,
    );
    expect(
      guide.width / guide.height,
      closeTo(LiveScanFrameCropper.cardAspectRatio, 0.001),
    );

    const cropper = LiveScanFrameCropper();
    final rois = cropper.roiRequests(
      imageWidth: 1280,
      imageHeight: 720,
      rotationDegrees: 90,
    );
    final cardRoi = rois.singleWhere((roi) => roi.kind == LiveScanRoiKind.card);
    expect(cardRoi.left.isEven, isTrue);
    expect(cardRoi.top.isEven, isTrue);
    expect(cardRoi.width.isEven, isTrue);
    expect(cardRoi.height.isEven, isTrue);

    final bytes = Uint8List(1280 * 720 + 1280 * (720 ~/ 2));
    final crop = cropper.crop(
      bytes: bytes,
      imageWidth: 1280,
      imageHeight: 720,
      sourceBytesPerRow: 1280,
      format: LiveScanPixelFormat.nv21,
      roi: cardRoi,
    );

    expect(crop, isNotNull);
    expect(crop!.kind, LiveScanRoiKind.card);
    expect(crop.bytes.length, crop.width * crop.height * 3 ~/ 2);
  });
}
