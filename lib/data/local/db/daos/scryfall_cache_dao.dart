import 'dart:convert';
import 'package:drift/drift.dart';
import '../app_database.dart';
import '../tables.dart';

part 'scryfall_cache_dao.g.dart';

class PrintingWithLatestPrice {
  PrintingWithLatestPrice({
    required this.printing,
    required this.priceMinor,
    required this.currency,
    required this.retrievedAt,
  });

  final ScryfallPrinting printing;
  final int? priceMinor;
  final String? currency;
  final DateTime? retrievedAt;
}

@DriftAccessor(tables: [ScryfallPrintings, PriceSnapshots])
class ScryfallCacheDao extends DatabaseAccessor<AppDatabase>
    with _$ScryfallCacheDaoMixin {
  ScryfallCacheDao(super.db);

  Future<void> upsertPrintings(List<ScryfallPrintingsCompanion> rows) async {
    await batch((b) {
      b.insertAllOnConflictUpdate(scryfallPrintings, rows);
    });
  }

  Future<void> insertPriceSnapshots(List<PriceSnapshotsCompanion> rows) async {
    if (rows.isEmpty) return;
    await batch((b) => b.insertAll(priceSnapshots, rows));
  }

  Future<void> clearAll() async {
    await batch((b) {
      b.deleteAll(priceSnapshots);
      b.deleteAll(scryfallPrintings);
    });
  }

  Stream<List<PrintingWithLatestPrice>> watchPrintingsWithLatestPrice() {
    const src = 'scryfall_usd';

    final query = customSelect(
      '''
        SELECT 
        p.printing_id,
        p.oracle_id,
        p.name,
        p.type_line,
        p.set_code,
        p.set_name,
        p.collector_number,
        p.released_at,
        p.mana_cost,
        p.mana_value,
        p.rarity,
        p.image_small,
        p.image_normal,
        p.image_png,
        p.legalities_json,
        p.updated_at_cache,

        ps.value_minor AS price_minor,
        ps.currency AS currency,
        ps.retrieved_at AS retrieved_at

        FROM scryfall_printings p
        LEFT JOIN price_snapshots ps
        ON ps.printing_id = p.printing_id
        AND ps.source = ?
        AND ps.retrieved_at = (
            SELECT MAX(retrieved_at)
            FROM price_snapshots
            WHERE printing_id = p.printing_id AND source = ?
        )
        ORDER BY p.updated_at_cache DESC
        ''',
      variables: [
        Variable.withString(src),
        Variable.withString(src),
      ],
      readsFrom: {scryfallPrintings, priceSnapshots},
    );

    return query.watch().map((rows) {
      return rows.map((r) {
        final d = r.data;

        // Monta "printing" manualmente (sem fromData)
        final printing = ScryfallPrinting(
          printingId: d['printing_id'] as String,
          oracleId: d['oracle_id'] as String,
          name: d['name'] as String,
          typeLine: d['type_line'] as String,
          setCode: d['set_code'] as String,
          setName: d['set_name'] as String,
          collectorNumber: d['collector_number'] as String,
          releasedAt: d['released_at'] == null
              ? null
              : DateTime.tryParse(d['released_at'].toString()),
          manaCost: d['mana_cost'] as String?,
          manaValue: (d['mana_value'] as num?)?.toDouble(),
          rarity: d['rarity'] as String?,
          imageSmall: d['image_small'] as String?,
          imageNormal: d['image_normal'] as String?,
          imagePng: d['image_png'] as String?,
          legalitiesJson: d['legalities_json'] as String?,
          updatedAtCache: DateTime.parse(d['updated_at_cache'].toString()),
        );

        final priceMinor = d['price_minor'] as int?;
        final currency = d['currency'] as String?;

        DateTime? retrievedAt;
        final ra = d['retrieved_at'];
        if (ra != null) {
          retrievedAt = DateTime.tryParse(ra.toString());
        }

        return PrintingWithLatestPrice(
          printing: printing,
          priceMinor: priceMinor,
          currency: currency,
          retrievedAt: retrievedAt,
        );
      }).toList();
    });
  }

  // Utilidade: salvar legalities como JSON string
  static String encodeJson(Object? obj) => jsonEncode(obj);
}
