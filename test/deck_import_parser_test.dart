import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/screens/decks/widgets/deck_import_parser.dart';

void main() {
  test('parseDeckImportLines parses valid and invalid lines', () {
    final parsed = parseDeckImportLines('''
1 Sol Ring
2 Arcane Signet
invalid line
0 Forest
''').toList();

    expect(parsed.length, 4);

    expect(parsed[0].isValid, isTrue);
    expect(parsed[0].quantity, 1);
    expect(parsed[0].name, 'Sol Ring');

    expect(parsed[1].isValid, isTrue);
    expect(parsed[1].quantity, 2);
    expect(parsed[1].name, 'Arcane Signet');

    expect(parsed[2].isValid, isFalse);
    expect(parsed[2].rawLine, 'invalid line');

    expect(parsed[3].isValid, isFalse);
    expect(parsed[3].rawLine, '0 Forest');
  });
}
