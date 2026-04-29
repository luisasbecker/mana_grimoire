import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/data/remote/scryfall/scryfall_mapper.dart';

void main() {
  const mapper = ScryfallMapper();

  test('mapCardToCacheRow maps printing and USD snapshot', () {
    final now = DateTime.parse('2026-01-01T12:00:00Z');
    final card = <String, dynamic>{
      'id': 'printing-1',
      'oracle_id': 'oracle-1',
      'name': 'Sol Ring',
      'type_line': 'Artifact',
      'set': 'cmm',
      'set_name': 'Commander Masters',
      'collector_number': '1',
      'mana_cost': '{1}',
      'mana_value': 1,
      'rarity': 'uncommon',
      'image_uris': {
        'small': 'https://img/small.jpg',
        'normal': 'https://img/normal.jpg',
        'png': 'https://img/card.png',
      },
      'legalities': {'commander': 'legal'},
      'prices': {'usd': '2.34'},
    };

    final mapped = mapper.mapCardToCacheRow(
      card,
      now: now,
      snapshotId: 'snapshot-1',
    );

    expect(mapped, isNotNull);
    expect(mapped!.printing.printingId.value, 'printing-1');
    expect(mapped.printing.oracleId.value, 'oracle-1');
    expect(mapped.printing.name.value, 'Sol Ring');
    expect(mapped.printing.manaValue.value, 1.0);
    expect(mapped.printing.imageNormal.value, 'https://img/normal.jpg');

    expect(mapped.priceSnapshot, isNotNull);
    expect(mapped.priceSnapshot!.id.value, 'snapshot-1');
    expect(mapped.priceSnapshot!.printingId.value, 'printing-1');
    expect(mapped.priceSnapshot!.valueMinor.value, 234);
  });

  test('mapCardToCacheRow returns null snapshot when usd missing', () {
    final now = DateTime.parse('2026-01-01T12:00:00Z');
    final card = <String, dynamic>{
      'id': 'printing-2',
      'oracle_id': 'oracle-2',
      'name': 'Island',
      'type_line': 'Basic Land',
      'set': 'lea',
      'set_name': 'Limited Edition Alpha',
      'collector_number': '295',
      'prices': {'usd': null},
    };

    final mapped = mapper.mapCardToCacheRow(
      card,
      now: now,
      snapshotId: 'snapshot-2',
    );

    expect(mapped, isNotNull);
    expect(mapped!.printing.printingId.value, 'printing-2');
    expect(mapped.priceSnapshot, isNull);
  });
}
