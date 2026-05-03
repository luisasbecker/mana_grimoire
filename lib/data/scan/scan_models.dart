import 'dart:ui';

class ScanCatalogCard {
  const ScanCatalogCard({
    required this.id,
    required this.oracleId,
    required this.name,
    required this.setCode,
    required this.setName,
    required this.collectorNumber,
    required this.rarity,
    required this.typeLine,
    this.printedName,
    this.printedLanguage,
    this.manaCost,
    this.imageUrlSmall,
    this.imageUrlNormal,
    this.imageUrlPng,
  });

  final String id;
  final String oracleId;
  final String name;
  final String setCode;
  final String setName;
  final String collectorNumber;
  final String rarity;
  final String typeLine;
  final String? printedName;
  final String? printedLanguage;
  final String? manaCost;
  final String? imageUrlSmall;
  final String? imageUrlNormal;
  final String? imageUrlPng;

  String get editionLabel =>
      '${setCode.toUpperCase()} #$collectorNumber'.trim();
}

class ScanRecognitionCandidate {
  const ScanRecognitionCandidate({
    required this.card,
    required this.score,
    required this.matchReason,
  });

  final ScanCatalogCard card;
  final double score;
  final String matchReason;

  String get printingId => card.id;
  String get oracleId => card.oracleId;
  String get name => card.name;
  String get typeLine => card.typeLine;
  String get setCode => card.setCode;
  String get setName => card.setName;
  String get collectorNumber => card.collectorNumber;
  String? get imageSmall => card.imageUrlSmall;
  String? get imageNormal => card.imageUrlNormal;
  String get editionLabel => card.editionLabel;
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

class ScanRecognitionOptions {
  const ScanRecognitionOptions({
    this.liveMode = false,
    this.persistSession = true,
    this.allowRemoteCatalog = true,
    this.maxQueryHints = 3,
  });

  const ScanRecognitionOptions.live()
      : liveMode = true,
        persistSession = false,
        allowRemoteCatalog = false,
        maxQueryHints = 3;

  final bool liveMode;
  final bool persistSession;
  final bool allowRemoteCatalog;
  final int maxQueryHints;
}

class OcrLine {
  const OcrLine({
    required this.text,
    required this.boundingBox,
    this.confidence,
  });

  final String text;
  final Rect boundingBox;
  final double? confidence;
}

class OcrTextResult {
  const OcrTextResult({required this.text, required this.lines});

  final String text;
  final List<OcrLine> lines;

  bool get isEmpty => text.trim().isEmpty;

  String prioritizedText({int topLineCount = 4, int bottomLineCount = 2}) {
    if (lines.isEmpty) return text.trim();
    final sorted = [...lines]..sort(
        (left, right) => left.boundingBox.top.compareTo(right.boundingBox.top));
    final selected = <String>{
      ...sorted.take(topLineCount).map((line) => line.text.trim()),
      ...sorted.reversed.take(bottomLineCount).map((line) => line.text.trim()),
    }.where((line) => line.isNotEmpty).toList();
    return selected.isEmpty ? text.trim() : selected.join('\n');
  }
}

class BufferedScanEntry {
  const BufferedScanEntry({
    required this.card,
    required this.quantity,
    required this.firstSeenAt,
    required this.lastSeenAt,
    required this.confidence,
    this.isFoil = false,
    this.language = 'EN',
    this.condition = 'NM',
    this.notes,
  });

  final ScanCatalogCard card;
  final int quantity;
  final DateTime firstSeenAt;
  final DateTime lastSeenAt;
  final double confidence;
  final bool isFoil;
  final String language;
  final String condition;
  final String? notes;

  String get variantKey => [
        card.id,
        isFoil ? 'foil' : 'nonfoil',
        condition.trim().toUpperCase(),
        language.trim().toUpperCase(),
      ].join('|');

  BufferedScanEntry copyWith({
    ScanCatalogCard? card,
    int? quantity,
    DateTime? firstSeenAt,
    DateTime? lastSeenAt,
    double? confidence,
    bool? isFoil,
    String? language,
    String? condition,
    String? notes,
    bool clearNotes = false,
  }) {
    return BufferedScanEntry(
      card: card ?? this.card,
      quantity: quantity ?? this.quantity,
      firstSeenAt: firstSeenAt ?? this.firstSeenAt,
      lastSeenAt: lastSeenAt ?? this.lastSeenAt,
      confidence: confidence ?? this.confidence,
      isFoil: isFoil ?? this.isFoil,
      language: language ?? this.language,
      condition: condition ?? this.condition,
      notes: clearNotes ? null : notes ?? this.notes,
    );
  }
}

class ScanRecognitionException implements Exception {
  const ScanRecognitionException(this.message);

  final String message;

  @override
  String toString() => message;
}
