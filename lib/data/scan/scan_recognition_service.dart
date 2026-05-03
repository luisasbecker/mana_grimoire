import 'dart:async';
import 'dart:math' as math;

import 'package:google_mlkit_text_recognition/google_mlkit_text_recognition.dart';

import '../local/db/app_database.dart';
import '../remote/scryfall/scryfall_cache_service.dart';
import '../remote/scryfall/scryfall_client.dart';
import 'catalog_scan_index.dart';
import 'scan_models.dart';
import 'visual_fingerprint_service.dart';

class MlKitOcrEngine {
  MlKitOcrEngine({TextRecognizer? recognizer})
      : _recognizer = recognizer ?? TextRecognizer();

  final TextRecognizer _recognizer;

  Future<OcrTextResult> recognizeInputImageDetailed(
    InputImage inputImage,
  ) async {
    final recognizedText = await _recognizer.processImage(inputImage);
    final lines = recognizedText.blocks
        .expand((block) => block.lines)
        .map(
          (line) => OcrLine(
            text: line.text,
            boundingBox: line.boundingBox,
            confidence: line.confidence,
          ),
        )
        .toList()
      ..sort(
        (left, right) => left.boundingBox.top.compareTo(right.boundingBox.top),
      );
    return OcrTextResult(text: recognizedText.text.trim(), lines: lines);
  }

  Future<String> recognizeImagePath(String imagePath) async {
    final inputImage = InputImage.fromFilePath(imagePath);
    final result = await recognizeInputImageDetailed(inputImage);
    return result.text.trim();
  }

  Future<void> dispose() => _recognizer.close();
}

class ManaScanRecognitionService {
  ManaScanRecognitionService({
    required AppDatabase db,
    required CatalogScanIndex scanIndex,
    ScryfallClient? client,
    ScryfallCacheService? cacheService,
    MlKitOcrEngine? ocrEngine,
    AverageHashVisualFingerprintService? visualFingerprintService,
  })  : _scanIndex = scanIndex,
        _client = client ?? ScryfallClient(),
        _cacheService = cacheService ?? ScryfallCacheService(db: db),
        _ocrEngine = ocrEngine ?? MlKitOcrEngine(),
        _visualFingerprintService =
            visualFingerprintService ?? AverageHashVisualFingerprintService();

  final CatalogScanIndex _scanIndex;
  final ScryfallClient _client;
  final ScryfallCacheService _cacheService;
  final MlKitOcrEngine _ocrEngine;
  final AverageHashVisualFingerprintService _visualFingerprintService;

  MlKitOcrEngine get ocrEngine => _ocrEngine;
  AverageHashVisualFingerprintService get visualFingerprintService =>
      _visualFingerprintService;

  Future<ScanRecognitionResult> recognizeImagePath(String imagePath) async {
    final rawText = await _ocrEngine.recognizeImagePath(imagePath);
    final result =
        await recognizeRawText(rawText: rawText, imagePath: imagePath);
    return _rerankWithVisualFingerprint(imagePath: imagePath, result: result);
  }

  Future<ScanRecognitionResult> recognizeRawText({
    required String rawText,
    String? imagePath,
    ScanRecognitionOptions options = const ScanRecognitionOptions(),
  }) async {
    final cleanedText = rawText.trim();
    if (cleanedText.isEmpty) {
      throw const ScanRecognitionException(
        'Nenhum texto legível foi encontrado na imagem.',
      );
    }

    if (options.liveMode) {
      final localCandidates = await _scanIndex.search(rawText: cleanedText);
      if (localCandidates.isNotEmpty) {
        return ScanRecognitionResult(
          rawText: cleanedText,
          candidates: localCandidates,
        );
      }
      if (!options.allowRemoteCatalog) {
        throw const ScanRecognitionException(
          'Nenhuma carta correspondente foi encontrada no catálogo local.',
        );
      }
    }

    final localCandidates = await _scanIndex.search(rawText: cleanedText);
    if (localCandidates.isNotEmpty) {
      return ScanRecognitionResult(
        rawText: cleanedText,
        candidates: localCandidates,
      );
    }

    if (!options.allowRemoteCatalog) {
      throw const ScanRecognitionException(
        'Nenhuma carta correspondente foi encontrada no catálogo local.',
      );
    }

    final remoteCandidates = await _recognizeViaScryfall(
      cleanedText,
      maxQueryHints: options.maxQueryHints,
    );
    if (remoteCandidates.isEmpty) {
      throw const ScanRecognitionException(
        'Nenhuma carta correspondente foi encontrada.',
      );
    }

    return ScanRecognitionResult(
      rawText: cleanedText,
      candidates: remoteCandidates,
    );
  }

  Future<void> cacheCandidate(ScanRecognitionCandidate candidate) async {
    final card = await _client.getCardById(candidate.printingId);
    await _cacheService.cacheSingleScryfallCard(card);
    unawaited(_scanIndex.ensureLoaded(force: true));
  }

  Future<void> indexVisualCards(List<ScanCatalogCard> cards) {
    return _visualFingerprintService.indexCatalogCards(cards);
  }

  Future<void> dispose() => _ocrEngine.dispose();

  Future<List<ScanRecognitionCandidate>> _recognizeViaScryfall(
    String rawText, {
    required int maxQueryHints,
  }) async {
    final queryHints = _extractQueryHints(rawText);
    if (queryHints.isEmpty) return const <ScanRecognitionCandidate>[];

    final normalizedRawText = _normalize(rawText);
    final collectorNumber = _extractCollectorNumber(rawText);
    final setCode = _extractSetCode(rawText);
    final candidatesById = <String, ScanRecognitionCandidate>{};

    for (final query in queryHints.take(maxQueryHints)) {
      final cards = <Map<String, dynamic>>[];
      final fuzzy = await _client.getNamedCardFuzzy(query);
      if (fuzzy != null) cards.add(fuzzy);
      cards.addAll((await _client.searchCardsOrEmpty(query)).take(8));

      for (final json in cards) {
        final card = _scanCatalogCardFromJson(json);
        if (card.id.isEmpty || card.oracleId.isEmpty) continue;
        final score = _scoreCard(
          card: card,
          normalizedRawText: normalizedRawText,
          query: query,
          collectorNumber: collectorNumber,
          setCode: setCode,
        );
        final candidate = ScanRecognitionCandidate(
          card: card,
          score: score,
          matchReason: collectorNumber != null || setCode != null
              ? 'OCR name and edition cue'
              : 'OCR name heuristic',
        );
        final existing = candidatesById[card.id];
        if (existing == null || candidate.score > existing.score) {
          candidatesById[card.id] = candidate;
        }
      }
      await _cacheService.cacheScryfallCards(cards);
    }

    final candidates = candidatesById.values.toList()
      ..sort((a, b) => b.score.compareTo(a.score));
    if (candidates.isNotEmpty) {
      unawaited(_scanIndex.ensureLoaded(force: true));
    }
    return candidates.take(8).toList();
  }

  Future<ScanRecognitionResult> _rerankWithVisualFingerprint({
    required String imagePath,
    required ScanRecognitionResult result,
  }) async {
    await _visualFingerprintService.indexCatalogCards(
      result.candidates.map((candidate) => candidate.card).toList(),
    );
    if (result.candidates.length < 2) return result;

    final reranked = <ScanRecognitionCandidate>[];
    for (final candidate in result.candidates.take(8)) {
      final visualScore =
          await _visualFingerprintService.compareWithCatalogCard(
        imagePath: imagePath,
        card: candidate.card,
      );
      if (visualScore == null) {
        reranked.add(candidate);
        continue;
      }
      final blendedScore = ((candidate.score * 0.68) + (visualScore * 0.32))
          .clamp(0, 1)
          .toDouble();
      reranked.add(
        ScanRecognitionCandidate(
          card: candidate.card,
          score: blendedScore,
          matchReason:
              '${candidate.matchReason}; visual fingerprint ${(visualScore * 100).toStringAsFixed(0)}%',
        ),
      );
    }
    reranked.sort((a, b) => b.score.compareTo(a.score));
    return ScanRecognitionResult(rawText: result.rawText, candidates: reranked);
  }

  ScanCatalogCard _scanCatalogCardFromJson(Map<String, dynamic> json) {
    final faces = (json['card_faces'] as List<dynamic>? ?? const [])
        .whereType<Map<String, dynamic>>()
        .toList();
    final primaryFace = faces.isEmpty ? null : faces.first;
    final imageSmall = ScryfallClient.extractImageSmall(json);
    final imageNormal = ScryfallClient.extractImageNormal(json);
    final imagePng = ScryfallClient.extractImagePng(json);
    return ScanCatalogCard(
      id: json['id']?.toString() ?? '',
      oracleId: json['oracle_id']?.toString() ?? '',
      name: json['name']?.toString() ?? primaryFace?['name']?.toString() ?? '',
      printedName: json['printed_name']?.toString() ??
          primaryFace?['printed_name']?.toString(),
      printedLanguage: json['lang']?.toString(),
      setCode: json['set']?.toString() ?? '',
      setName: json['set_name']?.toString() ?? '',
      collectorNumber: json['collector_number']?.toString() ?? '',
      rarity: json['rarity']?.toString() ?? '',
      typeLine: json['type_line']?.toString() ??
          primaryFace?['type_line']?.toString() ??
          '',
      manaCost: json['mana_cost']?.toString() ??
          primaryFace?['mana_cost']?.toString(),
      imageUrlSmall: imageSmall,
      imageUrlNormal: imageNormal,
      imageUrlPng: imagePng,
    );
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

  double _scoreCard({
    required ScanCatalogCard card,
    required String normalizedRawText,
    required String query,
    required String? collectorNumber,
    required String? setCode,
  }) {
    final normalizedQuery = _normalize(query);
    final aliases = _aliasesForCard(card);
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

    final normalizedCollector = _normalize(card.collectorNumber);
    if (collectorNumber != null && normalizedCollector == collectorNumber) {
      score += 0.22;
    }
    if (setCode != null && card.setCode.toLowerCase() == setCode) {
      score += 0.12;
    }

    return score.clamp(0, 1).toDouble();
  }

  Set<String> _aliasesForCard(ScanCatalogCard card) {
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

  String? _extractCollectorNumber(String rawText) {
    final match = RegExp(r'\b\d{1,4}[a-zA-Z]?\b').firstMatch(rawText);
    return match == null ? null : _normalize(match.group(0)!);
  }

  String? _extractSetCode(String rawText) {
    final matches =
        RegExp(r'\b[A-Z0-9]{3,5}\b', caseSensitive: false).allMatches(rawText);
    for (final match in matches) {
      final value = match.group(0)!.toLowerCase();
      if (!RegExp(r'^\d+$').hasMatch(value)) return _normalize(value);
    }
    return null;
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
