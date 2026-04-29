class ParsedDeckLine {
  const ParsedDeckLine._(this.isValid, this.quantity, this.name, this.rawLine);

  final bool isValid;
  final int quantity;
  final String name;
  final String rawLine;

  factory ParsedDeckLine.valid(int quantity, String name, String rawLine) =>
      ParsedDeckLine._(true, quantity, name, rawLine);

  factory ParsedDeckLine.invalid(String rawLine) =>
      ParsedDeckLine._(false, 0, '', rawLine);
}

Iterable<ParsedDeckLine> parseDeckImportLines(String raw) sync* {
  final lines = raw.split('\n');
  for (final line in lines) {
    final trimmed = line.trim();
    if (trimmed.isEmpty) continue;

    final match = RegExp(r'^(\d+)\s+(.+)$').firstMatch(trimmed);
    if (match == null) {
      yield ParsedDeckLine.invalid(trimmed);
      continue;
    }
    final qty = int.tryParse(match.group(1) ?? '');
    final name = (match.group(2) ?? '').trim();
    if (qty == null || qty <= 0 || name.isEmpty) {
      yield ParsedDeckLine.invalid(trimmed);
      continue;
    }
    yield ParsedDeckLine.valid(qty, name, trimmed);
  }
}
