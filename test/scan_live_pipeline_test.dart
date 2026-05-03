import 'dart:typed_data';

import 'package:drift/drift.dart' as drift;
import 'package:drift/native.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/data/local/db/app_database.dart';
import 'package:mana_grimoire/data/scan/catalog_scan_index.dart';
import 'package:mana_grimoire/data/scan/live_scan_acceptance.dart';
import 'package:mana_grimoire/data/scan/live_scan_frame_cropper.dart';
import 'package:mana_grimoire/data/scan/scan_catalog_filter.dart';
import 'package:mana_grimoire/data/scan/scan_edition_cue.dart';
import 'package:mana_grimoire/data/scan/scan_models.dart';

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

  test('localized scan uses collector and set cues to pick the exact edition',
      () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    try {
      final now = DateTime(2026);
      await db.scryfallCacheDao.upsertPrintings([
        ScryfallPrintingsCompanion.insert(
          printingId: 'mindslaver-mrd-pt-206',
          oracleId: 'mindslaver-oracle',
          name: 'Mindslaver',
          printedName: const drift.Value('Escraviza-Mentes'),
          language: const drift.Value('pt'),
          typeLine: 'Legendary Artifact',
          setCode: 'mrd',
          setName: 'Mirrodin',
          collectorNumber: '206',
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
        ScryfallPrintingsCompanion.insert(
          printingId: 'mindslaver-otp-pt-63',
          oracleId: 'mindslaver-oracle',
          name: 'Mindslaver',
          printedName: const drift.Value('Escraviza-mentes'),
          language: const drift.Value('pt'),
          typeLine: 'Legendary Artifact',
          setCode: 'otp',
          setName: 'Breaking News',
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
        ScryfallPrintingsCompanion.insert(
          printingId: 'mindslaver-som-pt-176',
          oracleId: 'mindslaver-oracle',
          name: 'Mindslaver',
          printedName: const drift.Value('Escraviza-Mentes'),
          language: const drift.Value('pt'),
          typeLine: 'Legendary Artifact',
          setCode: 'som',
          setName: 'Scars of Mirrodin',
          collectorNumber: '176',
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
      final candidates = await index.search(
        rawText: 'ESCRAVIZA-MENTES\nM 0063 OTP PT GOSSIP GOBLIN',
      );

      expect(candidates, isNotEmpty);
      expect(candidates.first.printingId, 'mindslaver-otp-pt-63');
      expect(candidates.first.editionLabel, 'OTP #63');
      expect(candidates.first.matchReason, contains('edition cue'));
    } finally {
      await db.close();
    }
  });

  test('art series cards are excluded from the scan index', () async {
    final db = AppDatabase.forExecutor(NativeDatabase.memory());
    try {
      final now = DateTime(2026);
      await db.scryfallCacheDao.upsertPrintings([
        ScryfallPrintingsCompanion.insert(
          printingId: 'liesa-amid-art-63',
          oracleId: 'liesa-oracle',
          name: 'Liesa, Forgotten Archangel // Liesa, Forgotten Archangel',
          typeLine: 'Card // Card',
          setCode: 'amid',
          setName: 'Midnight Hunt Art Series',
          collectorNumber: '63',
          releasedAt: const drift.Value.absent(),
          manaCost: const drift.Value.absent(),
          manaValue: const drift.Value.absent(),
          rarity: const drift.Value('common'),
          imageSmall: const drift.Value.absent(),
          imageNormal: const drift.Value.absent(),
          imagePng: const drift.Value.absent(),
          legalitiesJson: const drift.Value.absent(),
          updatedAtCache: now,
        ),
      ]);

      final index = CatalogScanIndex(database: db);
      final candidates = await index.search(
        rawText: 'Liesa Forgotten Archangel\nM 0063 AMID',
      );

      expect(candidates, isEmpty);
    } finally {
      await db.close();
    }
  });

  test('art series Scryfall JSON is not eligible for scan imports', () {
    expect(
      ScanCatalogFilter.isScanEligibleJson({
        'layout': 'art_series',
        'name': 'Liesa, Forgotten Archangel',
        'type_line': 'Card',
        'set_name': 'Midnight Hunt Art Series',
      }),
      isFalse,
    );
  });

  test('edition cue normalizes zero-padded collector numbers and OCR set codes',
      () {
    final cue = ScanEditionCue.fromRawText('M 0063 0TP PT');

    expect(cue.collectorNumbers, contains('63'));
    expect(cue.setCodes, contains('otp'));
    expect(
      cue.scoreFor(setCode: 'OTP', collectorNumber: '63'),
      greaterThanOrEqualTo(0.38),
    );
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

  test('visual-only live matches are not auto accepted', () {
    const card = ScanCatalogCard(
      id: 'liesa-amid-63',
      oracleId: 'liesa-oracle',
      name: 'Liesa, Forgotten Archangel',
      setCode: 'amid',
      setName: 'Alchemy: Innistrad',
      collectorNumber: '63',
      rarity: 'rare',
      typeLine: 'Legendary Creature',
    );
    const candidate = ScanRecognitionCandidate(
      card: card,
      score: 0.90,
      matchReason: 'visual fingerprint 90%',
    );
    const policy = LiveScanAcceptancePolicy(
      fastConfirmations: 2,
      strictConfirmations: 3,
    );

    final acceptance = policy.evaluate(candidate);

    expect(acceptance.canAutoAccept, isFalse);
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
