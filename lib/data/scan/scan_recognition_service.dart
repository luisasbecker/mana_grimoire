import 'dart:math' as math;

import 'package:google_mlkit_text_recognition/google_mlkit_text_recognition.dart';

import '../remote/scryfall/scryfall_cache_service.dart';
import '../remote/scryfall/scryfall_client.dart';

class ScanRecognitionCandidate {
  const ScanRecognitionCandidate({
    required this.cardJson,
    required this.score,
    required this.matchReason,
  });

  final Map<String, dynamic> cardJson;
  final double score;
  final String matchReason;

  String get printingId => _readString(cardJson['id']);
  String get oracleId => _readString(cardJson['oracle_id']);
  String get name => _readString(cardJson['name'], fallback: 'Unknown');
  String get typeLine => _readString(cardJson['type_line']);
  String get setCode => _readString(cardJson['set']);
  String get setName => _readString(cardJson['set_name']);
  String get collectorNumber => _readString(cardJson['collector_number']);
  String? get imageSmall => ScryfallClient.extractImageSmall(cardJson);
  String? get imageNormal => ScryfallClient.extractImageNormal(cardJson);

  String get editionLabel =>
      '${setCode.toUpperCase()} #$collectorNumber'.trim();

  static String _readString(Object? value, {String fallback = ''}) {
    final out = value?.toString().trim();
    return out == null || out.isEmpty ? fallback : out;
  }
}

class ScanRecognitionResult {
  const ScanRecognitionResult({
    required this.rawText,
    required this.candidates,
  });

  final String rawText;
  final List<ScanRecognitionCandidate> candidates;

  ScanRecognitionCandidate? get primary =>
      candidates.isEmpty ? null : candidates.first;
}

class ManaScanRecognitionService {
  ManaScanRecognitionService({
    ScryfallClient? client,
    ScryfallCacheService? cacheService,
    TextRecognizer? recognizer,
  })  : _client = client ?? ScryfallClient(),
        _cacheService = cacheService ?? ScryfallCacheService(),
        _recognizer = recognizer ?? TextRecognizer();

  final ScryfallClient _client;
  final ScryfallCacheService _cacheService;
  final TextRecognizer _recognizer;

  Future<ScanRecognitionResult> recognizeImagePath(String imagePath) async {
    final image = InputImage.fromFilePath(imagePath);
    final recognized = await _recognizer.processImage(image);
    return recognizeRawText(recognized.text.trim());
  }

  Future<ScanRecognitionResult> recognizeRawText(
    String rawText, {
    int maxQueryHints = 3,
  }) async {
    final cleanedText = rawText.trim();
    if (cleanedText.isEmpty) {
      return const ScanRecognitionResult(rawText: '', candidates: []);
    }

    final queryHints = _extractQueryHints(cleanedText);
    if (queryHints.isEmpty) {
      return ScanRecognitionResult(rawText: cleanedText, candidates: const []);
    }

    final normalizedRawText = _normalize(cleanedText);
    final collectorNumber = _extractCollectorNumber(cleanedText);
    final setCode = _extractSetCode(cleanedText);
    final candidatesById = <String, ScanRecognitionCandidate>{};

    for (final query in queryHints.take(maxQueryHints)) {
      final cards = <Map<String, dynamic>>[];
      final fuzzy = await _client.getNamedCardFuzzy(query);
      if (fuzzy != null) cards.add(fuzzy);
      cards.addAll((await _client.searchCardsOrEmpty(query)).take(8));

      for (final card in cards) {
        final id = card['id']?.toString();
        final oracleId = card['oracle_id']?.toString();
        if (id == null || id.isEmpty || oracleId == null || oracleId.isEmpty) {
          continue;
        }

        final score = _scoreCard(
          card: card,
          normalizedRawText: normalizedRawText,
          query: query,
          collectorNumber: collectorNumber,
          setCode: setCode,
        );
        final reason = collectorNumber != null || setCode != null
            ? 'OCR name and edition cue'
            : 'OCR name heuristic';
        final candidate = ScanRecognitionCandidate(
          cardJson: card,
          score: score,
          matchReason: reason,
        );
        final existing = candidatesById[id];
        if (existing == null || candidate.score > existing.score) {
          candidatesById[id] = candidate;
        }
      }
    }

    final candidates = candidatesById.values.toList()
      ..sort((a, b) => b.score.compareTo(a.score));
    final topCandidates = candidates.take(8).toList();
    if (topCandidates.isNotEmpty) {
      await _cacheService.cacheScryfallCards(
        topCandidates.map((candidate) => candidate.cardJson).toList(),
      );
    }

    return ScanRecognitionResult(
      rawText: cleanedText,
      candidates: topCandidates,
    );
  }

  Future<void> cacheCandidate(ScanRecognitionCandidate candidate) {
    return _cacheService.cacheSingleScryfallCard(candidate.cardJson);
  }

  Future<void> dispose() => _recognizer.close();

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
        if (words.length >= 2) {
          hints.add(words.take(4).join(' '));
        }
      }
      if (index + 1 < lines.length) {
        final combined = '${lines[index]} ${lines[index + 1]}';
        if (_looksLikeNameLine(combined)) {
          hints.add(combined);
        }
      }
    }

    if (hints.isEmpty && lines.isNotEmpty) {
      hints.add(lines.take(3).join(' '));
    }
    return hints.toList();
  }

  bool _looksLikeNameLine(String value) {
    final normalized = value
        .toLowerCase()
        .replaceAll(RegExp(r'[^a-z0-9 ]'), ' ')
        .replaceAll(RegExp(r'\s+'), ' ')
        .trim();
    if (normalized.length < 3 || normalized.length > 48) {
      return false;
    }
    if (RegExp(r'^\d+[a-z]?$').hasMatch(normalized)) {
      return false;
    }
    return normalized.split(' ').length <= 7;
  }

  double _scoreCard({
    required Map<String, dynamic> card,
    required String normalizedRawText,
    required String query,
    required String? collectorNumber,
    required String? setCode,
  }) {
    final normalizedQuery = _normalize(query);
    final aliases = _aliasesForName(card['name']?.toString() ?? '');
    var score = 0.0;

    for (final alias in aliases) {
      if (alias.isEmpty) continue;
      if (alias == normalizedQuery) {
        score = math.max(score, 0.95);
      } else if (alias.startsWith(normalizedQuery) ||
          normalizedQuery.startsWith(alias)) {
        score = math.max(score, 0.82);
      } else if (alias.contains(normalizedQuery) ||
          normalizedQuery.contains(alias)) {
        score = math.max(score, 0.74);
      } else if (normalizedRawText.contains(alias)) {
        score = math.max(score, 0.88);
      } else {
        final similarity = _similarity(alias, normalizedQuery);
        if (similarity >= 0.56) {
          score = math.max(score, 0.34 + (similarity * 0.55));
        }
      }
    }

    final normalizedCollector = _normalize(
      card['collector_number']?.toString() ?? '',
    );
    if (collectorNumber != null && normalizedCollector == collectorNumber) {
      score += 0.22;
    }

    final normalizedSetCode = _normalize(card['set']?.toString() ?? '');
    if (setCode != null && normalizedSetCode == setCode) {
      score += 0.12;
    }

    return score.clamp(0, 1).toDouble();
  }

  Set<String> _aliasesForName(String name) {
    final aliases = <String>{
      _normalize(name),
      _ocrFriendlyNormalize(name),
    };
    for (final separator in const ['//', '/', '(']) {
      if (name.contains(separator)) {
        aliases.add(_normalize(name.split(separator).first));
      }
    }
    return aliases.where((alias) => alias.length >= 2).toSet();
  }

  String? _extractCollectorNumber(String rawText) {
    final match = RegExp(r'\b\d{1,4}[a-zA-Z]?\b').firstMatch(rawText);
    return match == null ? null : _normalize(match.group(0)!);
  }

  String? _extractSetCode(String rawText) {
    final matches = RegExp(
      r'\b[A-Z0-9]{3,5}\b',
      caseSensitive: false,
    ).allMatches(rawText);
    for (final match in matches) {
      final value = match.group(0)!.toLowerCase();
      if (!RegExp(r'^\d+$').hasMatch(value)) {
        return _normalize(value);
      }
    }
    return null;
  }

  String _normalize(String value) {
    return value.toLowerCase().replaceAll(RegExp(r'[^a-z0-9]'), '');
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
    if (left.isEmpty || right.isEmpty) {
      return 0;
    }
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
