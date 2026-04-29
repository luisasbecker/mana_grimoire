import 'package:uuid/uuid.dart';

import '../../local/db/app_database.dart';
import '../../local/db/db_instance.dart';
import 'scryfall_client.dart';
import 'scryfall_mapper.dart';

class ScryfallCacheService {
  ScryfallCacheService({
    AppDatabase? db,
    ScryfallClient? client,
    ScryfallMapper? mapper,
    Uuid? uuid,
  })  : _db = db ?? appDb,
        _client = client ?? ScryfallClient(),
        _mapper = mapper ?? const ScryfallMapper(),
        _uuid = uuid ?? const Uuid();

  final AppDatabase _db;
  final ScryfallClient _client;
  final ScryfallMapper _mapper;
  final Uuid _uuid;

  Future<void> cacheScryfallCards(List<Map<String, dynamic>> cards) async {
    if (cards.isEmpty) return;
    final now = DateTime.now();
    final printings = <ScryfallPrintingsCompanion>[];
    final snapshots = <PriceSnapshotsCompanion>[];

    for (final card in cards) {
      final mapped = _mapper.mapCardToCacheRow(
        card,
        now: now,
        snapshotId: _uuid.v4(),
      );
      if (mapped == null) continue;
      printings.add(mapped.printing);
      final snapshot = mapped.priceSnapshot;
      if (snapshot != null) snapshots.add(snapshot);
    }

    await _db.scryfallCacheDao.upsertPrintings(printings);
    await _db.scryfallCacheDao.insertPriceSnapshots(snapshots);
  }

  Future<void> cacheSingleScryfallCard(Map<String, dynamic> card) async {
    await cacheScryfallCards([card]);
  }

  Future<void> ensurePrintingCached(String printingId) async {
    final existing = await (_db.select(_db.scryfallPrintings)
          ..where((t) => t.printingId.equals(printingId)))
        .getSingleOrNull();
    if (existing != null) return;

    final card = await _client.getCardById(printingId);
    await cacheSingleScryfallCard(card);
  }
}
