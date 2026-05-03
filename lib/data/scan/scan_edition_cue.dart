class ScanEditionCue {
  const ScanEditionCue({
    required this.collectorNumbers,
    required this.setCodes,
    required this.printCues,
  });

  factory ScanEditionCue.fromRawText(String rawText) {
    final collectorNumbers = <String>{};
    final setCodes = <String>{};
    final printCues = <ScanEditionPrintCue>{};

    for (final line in rawText.split('\n')) {
      final normalizedLine = _normalizeLine(line);
      if (normalizedLine.isEmpty) continue;
      final tokens = RegExp(r'[a-z0-9-]{1,12}')
          .allMatches(normalizedLine)
          .map((match) => match.group(0)!)
          .toList();
      if (tokens.isEmpty) continue;

      final lineCollectors = <String>{};
      final lineSets = <String>{};
      for (final token in tokens) {
        final collector = normalizeCollectorNumber(token);
        if (collector != null) {
          collectorNumbers.add(collector);
          lineCollectors.add(collector);
        }

        final setCode = normalizeSetCode(token);
        if (setCode != null) {
          setCodes.add(setCode);
          lineSets.add(setCode);
        }

        if (token.contains('-')) {
          final parts = token.split('-');
          for (final part in parts) {
            final partCollector = normalizeCollectorNumber(part);
            if (partCollector != null) {
              collectorNumbers.add(partCollector);
              lineCollectors.add(partCollector);
            }
            final partSet = normalizeSetCode(part);
            if (partSet != null) {
              setCodes.add(partSet);
              lineSets.add(partSet);
            }
          }
        }
      }

      for (final setCode in lineSets) {
        for (final collectorNumber in lineCollectors) {
          printCues.add(
            ScanEditionPrintCue(
              setCode: setCode,
              collectorNumber: collectorNumber,
            ),
          );
        }
      }
    }

    return ScanEditionCue(
      collectorNumbers: collectorNumbers,
      setCodes: setCodes,
      printCues: printCues,
    );
  }

  final Set<String> collectorNumbers;
  final Set<String> setCodes;
  final Set<ScanEditionPrintCue> printCues;

  bool get hasAnyCue =>
      collectorNumbers.isNotEmpty ||
      setCodes.isNotEmpty ||
      printCues.isNotEmpty;

  double scoreFor({
    required String setCode,
    required String collectorNumber,
  }) {
    final normalizedSet = normalizeSetCode(setCode);
    final normalizedCollector = normalizeCollectorNumber(collectorNumber);
    final hasSet = normalizedSet != null && setCodes.contains(normalizedSet);
    final hasCollector = normalizedCollector != null &&
        collectorNumbers.contains(normalizedCollector);
    final hasPrintCue = normalizedSet != null &&
        normalizedCollector != null &&
        printCues.contains(
          ScanEditionPrintCue(
            setCode: normalizedSet,
            collectorNumber: normalizedCollector,
          ),
        );

    if (hasPrintCue) return 0.46;
    if (hasSet && hasCollector) return 0.38;
    if (hasSet) return 0.24;
    if (hasCollector) return 0.16;
    return 0;
  }

  static String? normalizeCollectorNumber(String value) {
    final compact = _foldDiacritics(value.toLowerCase())
        .replaceAll(RegExp(r'[^a-z0-9-]'), '');
    if (compact.isEmpty) return null;

    final matches = RegExp(r'0*(\d{1,4})([a-z]?)').allMatches(compact);
    if (matches.isEmpty) return null;
    final match = matches.last;
    final digits = match.group(1);
    if (digits == null || digits.isEmpty) return null;
    final numeric = int.tryParse(digits);
    if (numeric == null || numeric <= 0) return null;
    final suffix = match.group(2) ?? '';
    return '$numeric$suffix';
  }

  static String? normalizeSetCode(String value) {
    final compact = _foldDiacritics(value.toLowerCase())
        .replaceAll('0', 'o')
        .replaceAll('1', 'i')
        .replaceAll('5', 's')
        .replaceAll(RegExp(r'[^a-z0-9]'), '');
    if (compact.length < 3 || compact.length > 5) return null;
    if (!RegExp(r'[a-z]').hasMatch(compact)) return null;
    return compact;
  }

  static String _normalizeLine(String value) {
    return _foldDiacritics(value.toLowerCase())
        .replaceAll(RegExp(r'[^a-z0-9-]+'), ' ')
        .replaceAll(RegExp(r'\s+'), ' ')
        .trim();
  }

  static String _foldDiacritics(String value) {
    return value
        .replaceAll(RegExp('[áàâãäåāăą]'), 'a')
        .replaceAll(RegExp('[çćč]'), 'c')
        .replaceAll(RegExp('[ďđ]'), 'd')
        .replaceAll(RegExp('[éèêëēėęě]'), 'e')
        .replaceAll(RegExp('[íìîïīįı]'), 'i')
        .replaceAll(RegExp('[ñń]'), 'n')
        .replaceAll(RegExp('[óòôõöøōő]'), 'o')
        .replaceAll(RegExp('[ŕř]'), 'r')
        .replaceAll(RegExp('[śš]'), 's')
        .replaceAll(RegExp('[ť]'), 't')
        .replaceAll(RegExp('[úùûüūůűų]'), 'u')
        .replaceAll(RegExp('[ýÿ]'), 'y')
        .replaceAll(RegExp('[žźż]'), 'z')
        .replaceAll('æ', 'ae')
        .replaceAll('œ', 'oe');
  }
}

class ScanEditionPrintCue {
  const ScanEditionPrintCue({
    required this.setCode,
    required this.collectorNumber,
  });

  final String setCode;
  final String collectorNumber;

  @override
  bool operator ==(Object other) {
    return other is ScanEditionPrintCue &&
        other.setCode == setCode &&
        other.collectorNumber == collectorNumber;
  }

  @override
  int get hashCode => Object.hash(setCode, collectorNumber);
}
