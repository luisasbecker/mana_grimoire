import 'package:drift/drift.dart' as drift;

import '../../local/db/app_database.dart';
import 'scryfall_client.dart';

class ScryfallMappedCacheRow {
  const ScryfallMappedCacheRow({
    required this.printing,
    this.priceSnapshot,
  });

  final ScryfallPrintingsCompanion printing;
  final PriceSnapshotsCompanion? priceSnapshot;
}

class ScryfallMapper {
  const ScryfallMapper();

  ScryfallMappedCacheRow? mapCardToCacheRow(
    Map<String, dynamic> card, {
    required DateTime now,
    required String snapshotId,
  }) {
    final printingId = card['id'] as String?;
    final oracleId = card['oracle_id'] as String?;
    if (printingId == null || oracleId == null) return null;

    final name = (card['name'] as String?) ?? 'Unknown';
    final printedName = card['printed_name'] as String?;
    final language = card['lang'] as String?;
    final typeLine = (card['type_line'] as String?) ?? '';
    final setCode = (card['set'] as String?) ?? '';
    final setName = (card['set_name'] as String?) ?? '';
    final collectorNumber = (card['collector_number'] as String?) ?? '';
    final manaCost = card['mana_cost'] as String?;
    final mvNum = card['mana_value'];
    final manaValue = mvNum is num ? mvNum.toDouble() : null;
    final rarity = card['rarity'] as String?;
    final imageSmall = ScryfallClient.extractImageSmall(card);
    final imageNormal = ScryfallClient.extractImageNormal(card);
    final imagePng = ScryfallClient.extractImagePng(card);
    final legalitiesJson = ScryfallClient.legalitiesToJson(card);

    final printing = ScryfallPrintingsCompanion.insert(
      printingId: printingId,
      oracleId: oracleId,
      name: name,
      printedName: drift.Value(printedName),
      language: drift.Value(language),
      typeLine: typeLine,
      setCode: setCode,
      setName: setName,
      collectorNumber: collectorNumber,
      releasedAt: const drift.Value.absent(),
      manaCost: drift.Value(manaCost),
      manaValue: drift.Value(manaValue),
      rarity: drift.Value(rarity),
      imageSmall: drift.Value(imageSmall),
      imageNormal: drift.Value(imageNormal),
      imagePng: drift.Value(imagePng),
      legalitiesJson: drift.Value(legalitiesJson),
      updatedAtCache: now,
    );

    final prices = card['prices'];
    String? usd;
    if (prices is Map) {
      usd = prices['usd'] as String?;
    }
    final usdMinor = ScryfallClient.usdStringToMinor(usd);

    final snapshot = usdMinor == null
        ? null
        : PriceSnapshotsCompanion.insert(
            id: snapshotId,
            printingId: printingId,
            source: 'scryfall_usd',
            currency: 'USD',
            valueMinor: usdMinor,
            retrievedAt: now,
          );

    return ScryfallMappedCacheRow(printing: printing, priceSnapshot: snapshot);
  }
}
