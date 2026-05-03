import 'dart:async';
import 'dart:math' as math;

import 'package:drift/drift.dart';

import '../local/db/app_database.dart';
import 'scan_models.dart';

class CatalogScanIndex {
  CatalogScanIndex({required AppDatabase database}) : _database = database;

  final AppDatabase _database;
  final List<_ScanIndexEntry> _entries = [];
  final Map<_ScanIndexEntry, int> _entryIndexes = {};
  final Map<String, List<_ScanIndexEntry>> _exactNameIndex = {};
  final Map<String, List<_ScanIndexEntry>> _prefixIndex = {};
  final Map<String, List<int>> _trigramIndex = {};

  Future<bool>? _loadFuture;
  DateTime? _loadedAt;

  int get cardCount => _entries.length;
  bool get isLoaded => _loadedAt != null && _entries.isNotEmpty;

  Future<bool> ensureLoaded({bool force = false}) {
    if (!force && isLoaded) return Future.value(true);
    if (!force && _loadFuture != null) return _loadFuture!;
    final future = _load();
    _loadFuture = future;
    return future.whenComplete(() => _loadFuture = null);
  }

  Future<List<ScanRecognitionCandidate>> search({
    required String rawText,
    int limit = 8,
  }) async {
    if (rawText.trim().isEmpty || !await ensureLoaded()) {
      return const <ScanRecognitionCandidate>[];
    }

    final hints = _extractQueryHints(rawText);
    if (hints.isEmpty) return const <ScanRecognitionCandidate>[];

    final normalizedRaw = _normalize(rawText);
    final collectorNumber = _extractCollectorNumber(rawText);
    final setCode = _extractSetCode(rawText);
    final candidatesById = <String, ScanRecognitionCandidate>{};

    for (final hint in hints.take(8)) {
      for (final variant in _queryVariants(hint)) {
        final entries = _candidateEntriesForVariant(variant);
        for (final entry in entries) {
          final score = _scoreEntry(
            entry: entry,
            variant: variant,
            normalizedRawText: normalizedRaw,
            collectorNumber: collectorNumber,
            setCode: setCode,
          );
          if (score.value < 0.34) continue;
          final existing = candidatesById[entry.card.id];
          if (existing == null || score.value > existing.score) {
            candidatesById[entry.card.id] = ScanRecognitionCandidate(
              card: entry.card,
              score: score.value,
              matchReason: score.hasEditionCue
                  ? 'Live catalog index; edition cue'
                  : entry.isAmbiguousPrint
                      ? 'Live catalog index; ambiguous name only'
                      : 'Live catalog index; unique name',
            );
          }
        }
      }
    }

    final sorted = candidatesById.values.toList()
      ..sort((left, right) {
        final scoreComparison = right.score.compareTo(left.score);
        if (scoreComparison != 0) return scoreComparison;
        final nameComparison = left.card.name.compareTo(right.card.name);
        if (nameComparison != 0) return nameComparison;
        return left.card.setCode.compareTo(right.card.setCode);
      });
    return sorted.take(limit).toList();
  }

  Future<List<ScanCatalogCard>> printingsForName(
    String cardName, {
    int limit = 160,
  }) async {
    if (cardName.trim().isEmpty || !await ensureLoaded()) {
      return const <ScanCatalogCard>[];
    }
    final nameKey = _normalize(cardName);
    return _entries
        .where((entry) => entry.nameKey == nameKey)
        .take(limit)
        .map((entry) => entry.card)
        .toList();
  }

  Future<bool> _load() async {
    final rows = await (_database.select(_database.scryfallPrintings)
          ..orderBy([(table) => OrderingTerm.asc(table.name)]))
        .get();
    if (rows.isEmpty) {
      _clear();
      return false;
    }

    _clear();
    final cards = rows.map(scanCatalogCardFromPrinting).toList();
    final printCountsByName = <String, int>{};
    for (final card in cards) {
      final nameKey = _normalize(card.name);
      printCountsByName[nameKey] = (printCountsByName[nameKey] ?? 0) + 1;
    }

    for (final card in cards) {
      final nameKey = _normalize(card.name);
      final aliases = _aliasesFor(card);
      final entry = _ScanIndexEntry(
        card: card,
        aliases: aliases,
        nameKey: nameKey,
        isAmbiguousPrint: (printCountsByName[nameKey] ?? 0) > 1,
      );
      final entryIndex = _entries.length;
      _entries.add(entry);
      _entryIndexes[entry] = entryIndex;

      for (final alias in aliases) {
        _exactNameIndex.putIfAbsent(alias, () => []).add(entry);
        if (alias.length >= 3) {
          _prefixIndex.putIfAbsent(alias.substring(0, 3), () => []).add(entry);
        }
        for (final gram in _trigrams(alias)) {
          _trigramIndex.putIfAbsent(gram, () => []).add(entryIndex);
        }
      }
    }
    _loadedAt = DateTime.now().toUtc();
    return _entries.isNotEmpty;
  }

  void _clear() {
    _entries.clear();
    _entryIndexes.clear();
    _exactNameIndex.clear();
    _prefixIndex.clear();
    _trigramIndex.clear();
    _loadedAt = null;
  }

  Set<String> _aliasesFor(ScanCatalogCard card) {
    final aliases = <String>{};
    for (final name in [card.name, card.printedName]) {
      if (name == null || name.trim().isEmpty) continue;
      aliases.add(_normalize(name));
      aliases.add(_ocrFriendlyNormalize(name));
      for (final separator in const ['//', '/', '(']) {
        if (name.contains(separator)) {
          final firstPart = name.split(separator).first;
          aliases.add(_normalize(firstPart));
          aliases.add(_ocrFriendlyNormalize(firstPart));
        }
      }
    }
    return aliases.where((alias) => alias.length >= 2).toSet();
  }

  List<_ScanIndexEntry> _candidateEntriesForVariant(String variant) {
    final exact = _exactNameIndex[variant];
    if (exact != null) return exact;

    final byIndex = <int, int>{};
    if (variant.length >= 3) {
      final prefixEntries = _prefixIndex[variant.substring(0, 3)];
      if (prefixEntries != null) {
        for (final entry in prefixEntries.take(260)) {
          final index = _entryIndexes[entry];
          if (index != null) byIndex[index] = (byIndex[index] ?? 0) + 4;
        }
      }
    }

    for (final gram in _trigrams(variant)) {
      final indexes = _trigramIndex[gram];
      if (indexes == null) continue;
      for (final index in indexes.take(180)) {
        byIndex[index] = (byIndex[index] ?? 0) + 1;
      }
    }

    final rankedIndexes = byIndex.entries.toList()
      ..sort((left, right) => right.value.compareTo(left.value));
    return rankedIndexes.take(320).map((entry) => _entries[entry.key]).toList();
  }

  _EntryScore _scoreEntry({
    required _ScanIndexEntry entry,
    required String variant,
    required String normalizedRawText,
    required String? collectorNumber,
    required String? setCode,
  }) {
    var score = 0.0;
    for (final alias in entry.aliases) {
      if (alias == variant) {
        score = math.max(score, 0.95);
      } else if (alias.startsWith(variant) || variant.startsWith(alias)) {
        score = math.max(score, 0.82);
      } else if (alias.contains(variant) || variant.contains(alias)) {
        score = math.max(score, 0.74);
      } else if (normalizedRawText.contains(alias)) {
        score = math.max(score, 0.88);
      } else {
        final similarity = _similarity(alias, variant);
        if (similarity >= 0.56) {
          score = math.max(score, 0.34 + (similarity * 0.55));
        }
      }
    }

    final normalizedCollector = _normalize(entry.card.collectorNumber);
    final hasCollectorCue =
        collectorNumber != null && normalizedCollector == collectorNumber;
    final hasSetCue =
        setCode != null && entry.card.setCode.toLowerCase() == setCode;
    final hasEditionCue = hasCollectorCue || hasSetCue;
    if (hasCollectorCue) {
      score += 0.22;
    }
    if (hasSetCue) {
      score += 0.12;
    }
    if (normalizedRawText.contains(_normalize(entry.card.typeLine))) {
      score += 0.02;
    }
    if (entry.isAmbiguousPrint && !hasEditionCue) {
      score = math.min(score, 0.68);
    }
    return _EntryScore(
        value: score.clamp(0, 1).toDouble(), hasEditionCue: hasEditionCue);
  }

  List<String> _extractQueryHints(String rawText) {
    final lines = rawText
        .split('\n')
        .map((line) => line.replaceAll(RegExp(r'\s+'), ' ').trim())
        .where((line) => line.length >= 2)
        .take(10)
        .toList();
    final hints = <String>{};

    for (var index = 0; index < lines.length; index++) {
      final line = lines[index];
      if (_looksLikeNameLine(line)) {
        hints.add(line);
        final words = line.split(' ');
        if (words.length >= 2) hints.add(words.take(4).join(' '));
      }
      if (index + 1 < lines.length) {
        final combined = '${lines[index]} ${lines[index + 1]}';
        if (_looksLikeNameLine(combined)) hints.add(combined);
      }
    }

    if (hints.isEmpty && lines.isNotEmpty) hints.add(lines.take(3).join(' '));
    return hints.toList();
  }

  bool _looksLikeNameLine(String value) {
    final normalized = value
        .toLowerCase()
        .replaceAll(RegExp(r'[^a-z0-9 ]'), ' ')
        .replaceAll(RegExp(r'\s+'), ' ')
        .trim();
    if (normalized.length < 3 || normalized.length > 48) return false;
    if (RegExp(r'^\d+[a-z]?$').hasMatch(normalized)) return false;
    return normalized.split(' ').length <= 7;
  }

  Iterable<String> _queryVariants(String value) sync* {
    final normalized = _normalize(value);
    final ocrFriendly = _ocrFriendlyNormalize(value);
    if (normalized.isNotEmpty) yield normalized;
    if (ocrFriendly.isNotEmpty && ocrFriendly != normalized) yield ocrFriendly;
  }

  String? _extractCollectorNumber(String rawText) {
    final match = RegExp(r'\b\d{1,4}[a-zA-Z]?\b').firstMatch(rawText);
    return match == null ? null : _normalize(match.group(0)!);
  }

  String? _extractSetCode(String rawText) {
    final matches =
        RegExp(r'\b[A-Z0-9]{3,5}\b', caseSensitive: false).allMatches(rawText);
    for (final match in matches) {
      final value = match.group(0)!.toLowerCase();
      if (!RegExp(r'^\d+$').hasMatch(value)) return value;
    }
    return null;
  }

  Iterable<String> _trigrams(String value) sync* {
    if (value.length < 3) {
      if (value.isNotEmpty) yield value;
      return;
    }
    for (var index = 0; index <= value.length - 3; index++) {
      yield value.substring(index, index + 3);
    }
  }

  String _normalize(String value) {
    return _foldDiacritics(value.toLowerCase())
        .replaceAll(RegExp(r'[^a-z0-9]'), '');
  }

  String _foldDiacritics(String value) {
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

  String _ocrFriendlyNormalize(String value) {
    return _normalize(
      value
          .toLowerCase()
          .replaceAll('0', 'o')
          .replaceAll('1', 'i')
          .replaceAll('3', 'e')
          .replaceAll('4', 'a')
          .replaceAll('5', 's')
          .replaceAll('7', 't')
          .replaceAll('8', 'b'),
    );
  }

  double _similarity(String left, String right) {
    if (left.isEmpty || right.isEmpty) return 0;
    final distance = _boundedLevenshtein(left, right);
    final maxLength = math.max(left.length, right.length);
    return 1 - (distance / maxLength.clamp(1, 9999));
  }

  int _boundedLevenshtein(String left, String right) {
    if ((left.length - right.length).abs() > 8) {
      return math.max(left.length, right.length);
    }
    final previous = List<int>.generate(right.length + 1, (index) => index);
    final current = List<int>.filled(right.length + 1, 0);
    for (var i = 1; i <= left.length; i++) {
      current[0] = i;
      for (var j = 1; j <= right.length; j++) {
        final cost = left[i - 1] == right[j - 1] ? 0 : 1;
        current[j] = math.min(
          math.min(current[j - 1] + 1, previous[j] + 1),
          previous[j - 1] + cost,
        );
      }
      previous.setAll(0, current);
    }
    return previous[right.length];
  }
}

ScanCatalogCard scanCatalogCardFromPrinting(ScryfallPrinting printing) {
  return ScanCatalogCard(
    id: printing.printingId,
    oracleId: printing.oracleId,
    name: printing.name,
    printedName: printing.printedName,
    printedLanguage: printing.language,
    setCode: printing.setCode,
    setName: printing.setName,
    collectorNumber: printing.collectorNumber,
    rarity: printing.rarity ?? '',
    typeLine: printing.typeLine,
    manaCost: printing.manaCost,
    imageUrlSmall: printing.imageSmall,
    imageUrlNormal: printing.imageNormal,
    imageUrlPng: printing.imagePng,
  );
}

class _ScanIndexEntry {
  const _ScanIndexEntry({
    required this.card,
    required this.aliases,
    required this.nameKey,
    required this.isAmbiguousPrint,
  });

  final ScanCatalogCard card;
  final Set<String> aliases;
  final String nameKey;
  final bool isAmbiguousPrint;
}

class _EntryScore {
  const _EntryScore({required this.value, required this.hasEditionCue});

  final double value;
  final bool hasEditionCue;
}
