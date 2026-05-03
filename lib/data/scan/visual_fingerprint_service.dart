import 'dart:convert';
import 'dart:io';
import 'dart:typed_data';

import 'package:dio/dio.dart';
import 'package:image/image.dart' as img;
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

import 'live_scan_frame_cropper.dart';
import 'scan_catalog_filter.dart';
import 'scan_models.dart';

class AverageHashVisualFingerprintService {
  AverageHashVisualFingerprintService({Dio? dio}) : _dio = dio ?? Dio();

  static const int _averageHashSize = 16;
  static const int _averageHashBits = _averageHashSize * _averageHashSize;
  static const int _differenceHashWidth = 17;
  static const int _differenceHashHeight = 16;
  static const int _differenceHashBits =
      (_differenceHashWidth - 1) * _differenceHashHeight;
  static const int _colorGridColumns = 4;
  static const int _colorGridRows = 4;
  static const int _maxImageBytes = 8 * 1024 * 1024;
  static const int _maxIndexedCards = 5000;
  static const String _indexFileName = 'mana_visual_fingerprint_index.json';

  final Dio _dio;
  final Map<String, _VisualFingerprint> _remoteFingerprintCache = {};
  final Map<String, _IndexedFingerprint> _index = {};
  Future<void>? _loadFuture;

  Future<double?> compareWithCatalogCard({
    required String imagePath,
    required ScanCatalogCard card,
  }) async {
    if (!ScanCatalogFilter.isScanEligibleCard(card)) return null;
    final candidateUrl = _visualSourceUrl(card);
    if (candidateUrl == null || candidateUrl.isEmpty) return null;

    final localFingerprint = await _fingerprintLocalCardImage(imagePath);
    final remoteFingerprint = await _fingerprintRemoteCardImage(candidateUrl);
    if (localFingerprint == null || remoteFingerprint == null) return null;
    return _fingerprintSimilarity(localFingerprint, remoteFingerprint);
  }

  Future<void> indexCatalogCards(List<ScanCatalogCard> cards) async {
    await _ensureIndexLoaded();
    var changed = false;

    for (final card in cards.take(96)) {
      if (!ScanCatalogFilter.isScanEligibleCard(card)) continue;
      if (_index.containsKey(card.id)) continue;
      final imageUrl = _visualSourceUrl(card);
      if (imageUrl == null || imageUrl.isEmpty) continue;
      try {
        final fingerprint = await _fingerprintRemoteCardImage(imageUrl);
        if (fingerprint == null) continue;
        _index[card.id] = _IndexedFingerprint(
          card: card,
          fingerprint: fingerprint,
          indexedAt: DateTime.now().toUtc(),
        );
        changed = true;
      } on DioException {
        continue;
      } on FormatException {
        continue;
      }
    }

    if (changed) {
      _pruneIndex();
      await _saveIndex();
    }
  }

  Future<List<ScanRecognitionCandidate>> findVisualMatches({
    required String imagePath,
    int limit = 8,
    double minScore = 0.70,
  }) async {
    await _ensureIndexLoaded();
    if (_index.isEmpty) return const <ScanRecognitionCandidate>[];

    final localFingerprint = await _fingerprintLocalCardImage(imagePath);
    if (localFingerprint == null) return const <ScanRecognitionCandidate>[];

    final matches = <ScanRecognitionCandidate>[];
    for (final entry in _index.values) {
      if (!ScanCatalogFilter.isScanEligibleCard(entry.card)) continue;
      final score = _fingerprintSimilarity(localFingerprint, entry.fingerprint);
      if (score >= minScore) {
        matches.add(
          ScanRecognitionCandidate(
            card: entry.card,
            score: score,
            matchReason: 'Local composite visual fingerprint index',
          ),
        );
      }
    }

    matches.sort((a, b) => b.score.compareTo(a.score));
    return matches.take(limit).toList();
  }

  Future<List<ScanRecognitionCandidate>> findVisualMatchesInCrop({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
    Set<String>? allowedCardIds,
    int limit = 8,
    double minScore = 0.78,
  }) async {
    await _ensureIndexLoaded();
    if (_index.isEmpty) return const <ScanRecognitionCandidate>[];

    final localFingerprint = _fingerprintCrop(crop: crop, format: format);
    if (localFingerprint == null) return const <ScanRecognitionCandidate>[];

    final matches = <ScanRecognitionCandidate>[];
    for (final entry in _index.values) {
      if (!ScanCatalogFilter.isScanEligibleCard(entry.card)) continue;
      if (allowedCardIds != null && !allowedCardIds.contains(entry.card.id)) {
        continue;
      }
      final score = _fingerprintSimilarity(localFingerprint, entry.fingerprint);
      if (score >= minScore) {
        matches.add(
          ScanRecognitionCandidate(
            card: entry.card,
            score: score,
            matchReason: 'Live composite visual fingerprint index',
          ),
        );
      }
    }

    matches.sort((a, b) => b.score.compareTo(a.score));
    return matches.take(limit).toList();
  }

  Future<_VisualFingerprint?> _fingerprintLocalCardImage(
    String imagePath,
  ) async {
    final file = File(imagePath);
    if (!await file.exists()) return null;
    final length = await file.length();
    if (length <= 0 || length > _maxImageBytes) return null;
    return _fingerprintBytes(await file.readAsBytes(), cropLikelyCard: true);
  }

  Future<_VisualFingerprint?> _fingerprintRemoteCardImage(
    String imageUrl,
  ) async {
    final cached = _remoteFingerprintCache[imageUrl];
    if (cached != null) return cached;

    final response = await _dio.get<List<int>>(
      imageUrl,
      options: Options(
        responseType: ResponseType.bytes,
        receiveTimeout: const Duration(seconds: 8),
      ),
    );
    final bytes = response.data;
    if (bytes == null || bytes.isEmpty || bytes.length > _maxImageBytes) {
      return null;
    }

    final fingerprint = _fingerprintBytes(
      Uint8List.fromList(bytes),
      cropLikelyCard: false,
    );
    if (fingerprint == null) return null;
    _remoteFingerprintCache[imageUrl] = fingerprint;
    if (_remoteFingerprintCache.length > 240) {
      _remoteFingerprintCache.remove(_remoteFingerprintCache.keys.first);
    }
    return fingerprint;
  }

  Future<void> _ensureIndexLoaded() {
    return _loadFuture ??= _loadIndex();
  }

  Future<File> _indexFile() async {
    final directory = await getApplicationDocumentsDirectory();
    return File(p.join(directory.path, _indexFileName));
  }

  Future<void> _loadIndex() async {
    final file = await _indexFile();
    if (!await file.exists()) return;

    try {
      final payload = jsonDecode(await file.readAsString());
      if (payload is! Map<String, dynamic>) return;
      final entries = payload['entries'];
      if (entries is! List<dynamic>) return;
      for (final entry in entries.whereType<Map<String, dynamic>>()) {
        final indexed = _IndexedFingerprint.fromJson(entry);
        if (indexed != null &&
            ScanCatalogFilter.isScanEligibleCard(indexed.card)) {
          _index[indexed.card.id] = indexed;
        }
      }
      _pruneIndex();
    } on FormatException {
      await file.delete();
    }
  }

  Future<void> _saveIndex() async {
    final file = await _indexFile();
    await file.parent.create(recursive: true);
    final temporaryFile = File('${file.path}.tmp');
    await temporaryFile.writeAsString(
      jsonEncode(<String, dynamic>{
        'version': 2,
        'hash': 'composite-ahash-dhash-color',
        'updatedAt': DateTime.now().toUtc().toIso8601String(),
        'entries': _index.values.map((entry) => entry.toJson()).toList(),
      }),
      flush: true,
    );
    if (await file.exists()) await file.delete();
    await temporaryFile.rename(file.path);
  }

  void _pruneIndex() {
    if (_index.length <= _maxIndexedCards) return;
    final entries = _index.values.toList()
      ..sort((a, b) => b.indexedAt.compareTo(a.indexedAt));
    _index
      ..clear()
      ..addEntries(
        entries.take(_maxIndexedCards).map(
              (entry) => MapEntry(entry.card.id, entry),
            ),
      );
  }

  _VisualFingerprint? _fingerprintBytes(
    Uint8List bytes, {
    required bool cropLikelyCard,
  }) {
    final decoded = img.decodeImage(bytes);
    if (decoded == null || decoded.width < 32 || decoded.height < 32) {
      return null;
    }

    final source = cropLikelyCard ? _centerCropToCardRatio(decoded) : decoded;
    return _fingerprintImage(source);
  }

  _VisualFingerprint? _fingerprintImage(img.Image source) {
    final averageResized = img.copyResize(
      source,
      width: _averageHashSize,
      height: _averageHashSize,
      interpolation: img.Interpolation.average,
    );
    final averageLuminance = _imageLuminance(averageResized);
    final averageMean = _mean(averageLuminance);
    final averageHash = Uint8List.fromList(
      averageLuminance.map((value) => value >= averageMean ? 1 : 0).toList(),
    );

    final differenceResized = img.copyResize(
      source,
      width: _differenceHashWidth,
      height: _differenceHashHeight,
      interpolation: img.Interpolation.average,
    );
    final differenceHash = <int>[];
    for (var y = 0; y < differenceResized.height; y++) {
      for (var x = 0; x < differenceResized.width - 1; x++) {
        final left = _pixelLuminance(differenceResized.getPixel(x, y));
        final right = _pixelLuminance(differenceResized.getPixel(x + 1, y));
        differenceHash.add(left > right ? 1 : 0);
      }
    }

    return _VisualFingerprint(
      averageHash: averageHash,
      differenceHash: Uint8List.fromList(differenceHash),
      colorSignature: _imageColorSignature(source),
    );
  }

  _VisualFingerprint? _fingerprintCrop({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
  }) {
    if (crop.width < 32 || crop.height < 32 || crop.bytes.isEmpty) return null;

    final averageLuminance = _resizedCropLuminance(
      crop: crop,
      format: format,
      width: _averageHashSize,
      height: _averageHashSize,
    );
    if (averageLuminance == null || averageLuminance.isEmpty) return null;
    final averageMean = _mean(averageLuminance);
    final averageHash = Uint8List.fromList(
      averageLuminance.map((value) => value >= averageMean ? 1 : 0).toList(),
    );

    final differenceLuminance = _resizedCropLuminance(
      crop: crop,
      format: format,
      width: _differenceHashWidth,
      height: _differenceHashHeight,
    );
    if (differenceLuminance == null || differenceLuminance.isEmpty) {
      return null;
    }
    final differenceHash = <int>[];
    for (var y = 0; y < _differenceHashHeight; y++) {
      for (var x = 0; x < _differenceHashWidth - 1; x++) {
        final offset = (y * _differenceHashWidth) + x;
        differenceHash.add(
          differenceLuminance[offset] > differenceLuminance[offset + 1] ? 1 : 0,
        );
      }
    }

    return _VisualFingerprint(
      averageHash: averageHash,
      differenceHash: Uint8List.fromList(differenceHash),
      colorSignature: _cropColorSignature(crop: crop, format: format),
    );
  }

  List<int>? _resizedCropLuminance({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
    required int width,
    required int height,
  }) {
    final values = <int>[];
    for (var y = 0; y < height; y++) {
      final sourceY =
          ((y + 0.5) * crop.height / height).floor().clamp(0, crop.height - 1);
      for (var x = 0; x < width; x++) {
        final sourceX =
            ((x + 0.5) * crop.width / width).floor().clamp(0, crop.width - 1);
        final rgb = _cropRgb(crop, format, sourceX, sourceY);
        if (rgb == null) return null;
        values.add(_rgbLuminance(rgb));
      }
    }
    return values;
  }

  Uint8List _imageColorSignature(img.Image image) {
    final signature = <int>[];
    for (var gridY = 0; gridY < _colorGridRows; gridY++) {
      for (var gridX = 0; gridX < _colorGridColumns; gridX++) {
        final sample = _averageImageRegion(
          image,
          left: gridX / _colorGridColumns,
          top: gridY / _colorGridRows,
          width: 1 / _colorGridColumns,
          height: 1 / _colorGridRows,
        );
        signature
          ..add(sample.r)
          ..add(sample.g)
          ..add(sample.b);
      }
    }
    return Uint8List.fromList(signature);
  }

  Uint8List _cropColorSignature({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
  }) {
    final signature = <int>[];
    for (var gridY = 0; gridY < _colorGridRows; gridY++) {
      for (var gridX = 0; gridX < _colorGridColumns; gridX++) {
        final sample = _averageCropRegion(
          crop: crop,
          format: format,
          left: gridX / _colorGridColumns,
          top: gridY / _colorGridRows,
          width: 1 / _colorGridColumns,
          height: 1 / _colorGridRows,
        );
        signature
          ..add(sample.r)
          ..add(sample.g)
          ..add(sample.b);
      }
    }
    return Uint8List.fromList(signature);
  }

  _Rgb _averageImageRegion(
    img.Image image, {
    required double left,
    required double top,
    required double width,
    required double height,
  }) {
    var r = 0;
    var g = 0;
    var b = 0;
    var samples = 0;
    for (var y = 0; y < 4; y++) {
      final sourceY = ((top + ((y + 0.5) * height / 4)) * image.height)
          .floor()
          .clamp(0, image.height - 1);
      for (var x = 0; x < 4; x++) {
        final sourceX = ((left + ((x + 0.5) * width / 4)) * image.width)
            .floor()
            .clamp(0, image.width - 1);
        final pixel = image.getPixel(sourceX, sourceY);
        r += pixel.r.round();
        g += pixel.g.round();
        b += pixel.b.round();
        samples++;
      }
    }
    return _Rgb(
      r: (r / samples).round().clamp(0, 255),
      g: (g / samples).round().clamp(0, 255),
      b: (b / samples).round().clamp(0, 255),
    );
  }

  _Rgb _averageCropRegion({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
    required double left,
    required double top,
    required double width,
    required double height,
  }) {
    var r = 0;
    var g = 0;
    var b = 0;
    var samples = 0;
    for (var y = 0; y < 4; y++) {
      final sourceY = ((top + ((y + 0.5) * height / 4)) * crop.height)
          .floor()
          .clamp(0, crop.height - 1);
      for (var x = 0; x < 4; x++) {
        final sourceX = ((left + ((x + 0.5) * width / 4)) * crop.width)
            .floor()
            .clamp(0, crop.width - 1);
        final rgb = _cropRgb(crop, format, sourceX, sourceY);
        if (rgb == null) continue;
        r += rgb.r;
        g += rgb.g;
        b += rgb.b;
        samples++;
      }
    }
    if (samples == 0) return const _Rgb(r: 0, g: 0, b: 0);
    return _Rgb(
      r: (r / samples).round().clamp(0, 255),
      g: (g / samples).round().clamp(0, 255),
      b: (b / samples).round().clamp(0, 255),
    );
  }

  _Rgb? _cropRgb(
    LiveScanCrop crop,
    LiveScanPixelFormat format,
    int x,
    int y,
  ) {
    return switch (format) {
      LiveScanPixelFormat.nv21 => _nv21Rgb(crop, x, y),
      LiveScanPixelFormat.bgra8888 => _bgraRgb(crop, x, y),
    };
  }

  _Rgb? _nv21Rgb(LiveScanCrop crop, int x, int y) {
    final yOffset = (y * crop.bytesPerRow) + x;
    final yPlaneSize = crop.bytesPerRow * crop.height;
    final uvOffset =
        yPlaneSize + ((y ~/ 2) * crop.bytesPerRow) + (x.isEven ? x : x - 1);
    if (yOffset < 0 ||
        yOffset >= yPlaneSize ||
        uvOffset < yPlaneSize ||
        uvOffset + 1 >= crop.bytes.length) {
      return null;
    }

    final luminance = crop.bytes[yOffset].toDouble();
    final v = crop.bytes[uvOffset].toDouble() - 128;
    final u = crop.bytes[uvOffset + 1].toDouble() - 128;
    final r = (luminance + (1.370705 * v)).round().clamp(0, 255);
    final g =
        (luminance - (0.337633 * u) - (0.698001 * v)).round().clamp(0, 255);
    final b = (luminance + (1.732446 * u)).round().clamp(0, 255);
    return _Rgb(r: r, g: g, b: b);
  }

  _Rgb? _bgraRgb(LiveScanCrop crop, int x, int y) {
    final offset = (y * crop.bytesPerRow) + (x * 4);
    if (offset < 0 || offset + 2 >= crop.bytes.length) return null;
    return _Rgb(
      b: crop.bytes[offset],
      g: crop.bytes[offset + 1],
      r: crop.bytes[offset + 2],
    );
  }

  img.Image _centerCropToCardRatio(img.Image image) {
    final maxWidth = (image.width * 0.82).round();
    final maxHeight = (image.height * 0.86).round();
    var cropHeight = maxHeight;
    var cropWidth = (cropHeight * LiveScanFrameCropper.cardAspectRatio).round();
    if (cropWidth > maxWidth) {
      cropWidth = maxWidth;
      cropHeight = (cropWidth / LiveScanFrameCropper.cardAspectRatio).round();
    }
    cropWidth = cropWidth.clamp(32, image.width);
    cropHeight = cropHeight.clamp(32, image.height);
    final x = ((image.width - cropWidth) / 2).round().clamp(0, image.width);
    final y = ((image.height - cropHeight) / 2).round().clamp(0, image.height);
    return img.copyCrop(
      image,
      x: x,
      y: y,
      width: cropWidth,
      height: cropHeight,
    );
  }

  List<int> _imageLuminance(img.Image image) {
    final luminance = <int>[];
    for (var y = 0; y < image.height; y++) {
      for (var x = 0; x < image.width; x++) {
        luminance.add(_pixelLuminance(image.getPixel(x, y)));
      }
    }
    return luminance;
  }

  int _pixelLuminance(img.Pixel pixel) {
    return ((pixel.r * 0.299) + (pixel.g * 0.587) + (pixel.b * 0.114)).round();
  }

  int _rgbLuminance(_Rgb rgb) {
    return ((rgb.r * 0.299) + (rgb.g * 0.587) + (rgb.b * 0.114)).round();
  }

  double _mean(List<int> values) {
    return values.fold<int>(0, (sum, value) => sum + value) / values.length;
  }

  double _fingerprintSimilarity(
    _VisualFingerprint left,
    _VisualFingerprint right,
  ) {
    var weightedScore = 0.0;
    var totalWeight = 0.0;

    void add(double? score, double weight) {
      if (score == null) return;
      weightedScore += score * weight;
      totalWeight += weight;
    }

    add(_bitSimilarity(left.averageHash, right.averageHash, _averageHashBits),
        0.40);
    add(
      _bitSimilarity(
        left.differenceHash,
        right.differenceHash,
        _differenceHashBits,
      ),
      0.40,
    );
    add(_colorSimilarity(left.colorSignature, right.colorSignature), 0.20);

    if (totalWeight <= 0) return 0;
    return (weightedScore / totalWeight).clamp(0, 1).toDouble();
  }

  double? _bitSimilarity(Uint8List left, Uint8List right, int expectedBits) {
    if (left.isEmpty || right.isEmpty) return null;
    final distance = _hammingDistance(left, right);
    final denominator = expectedBits <= 0
        ? (left.length < right.length ? left.length : right.length)
        : expectedBits;
    return (1 - (distance / denominator.clamp(1, 9999))).clamp(0, 1).toDouble();
  }

  double? _colorSimilarity(Uint8List left, Uint8List right) {
    if (left.isEmpty || right.isEmpty) return null;
    final length = left.length < right.length ? left.length : right.length;
    if (length <= 0) return null;
    var totalDifference = 0;
    for (var i = 0; i < length; i++) {
      totalDifference += (left[i] - right[i]).abs();
    }
    final averageDifference = totalDifference / length;
    return (1 - (averageDifference / 255)).clamp(0, 1).toDouble();
  }

  int _hammingDistance(Uint8List left, Uint8List right) {
    final length = left.length < right.length ? left.length : right.length;
    var distance = 0;
    for (var i = 0; i < length; i++) {
      if (left[i] != right[i]) distance++;
    }
    return distance + (left.length - right.length).abs();
  }

  String? _visualSourceUrl(ScanCatalogCard card) {
    return card.imageUrlNormal ?? card.imageUrlSmall ?? card.imageUrlPng;
  }
}

class _VisualFingerprint {
  const _VisualFingerprint({
    required this.averageHash,
    required this.differenceHash,
    required this.colorSignature,
  });

  final Uint8List averageHash;
  final Uint8List differenceHash;
  final Uint8List colorSignature;
}

class _IndexedFingerprint {
  const _IndexedFingerprint({
    required this.card,
    required this.fingerprint,
    required this.indexedAt,
  });

  final ScanCatalogCard card;
  final _VisualFingerprint fingerprint;
  final DateTime indexedAt;

  Map<String, dynamic> toJson() {
    return <String, dynamic>{
      'card': <String, dynamic>{
        'id': card.id,
        'oracleId': card.oracleId,
        'name': card.name,
        'printedName': card.printedName,
        'printedLanguage': card.printedLanguage,
        'setCode': card.setCode,
        'setName': card.setName,
        'collectorNumber': card.collectorNumber,
        'rarity': card.rarity,
        'typeLine': card.typeLine,
        'manaCost': card.manaCost,
        'imageUrlSmall': card.imageUrlSmall,
        'imageUrlNormal': card.imageUrlNormal,
        'imageUrlPng': card.imageUrlPng,
      },
      'averageHash': base64Encode(fingerprint.averageHash),
      'differenceHash': base64Encode(fingerprint.differenceHash),
      'colorSignature': base64Encode(fingerprint.colorSignature),
      'fingerprint': base64Encode(fingerprint.averageHash),
      'indexedAt': indexedAt.toIso8601String(),
    };
  }

  static _IndexedFingerprint? fromJson(Map<String, dynamic> json) {
    final cardPayload = json['card'];
    final averagePayload = json['averageHash'] ?? json['fingerprint'];
    if (cardPayload is! Map<String, dynamic> || averagePayload is! String) {
      return null;
    }
    final id = cardPayload['id']?.toString() ?? '';
    final name = cardPayload['name']?.toString() ?? '';
    if (id.isEmpty || name.isEmpty) return null;

    try {
      final averageHash = base64Decode(averagePayload);
      final differenceHash = _decodeOptionalBytes(json['differenceHash']);
      final colorSignature = _decodeOptionalBytes(json['colorSignature']);
      return _IndexedFingerprint(
        card: ScanCatalogCard(
          id: id,
          oracleId: cardPayload['oracleId']?.toString() ?? '',
          name: name,
          printedName: cardPayload['printedName']?.toString(),
          printedLanguage: cardPayload['printedLanguage']?.toString(),
          setCode: cardPayload['setCode']?.toString() ?? '',
          setName: cardPayload['setName']?.toString() ?? '',
          collectorNumber: cardPayload['collectorNumber']?.toString() ?? '',
          rarity: cardPayload['rarity']?.toString() ?? '',
          typeLine: cardPayload['typeLine']?.toString() ?? '',
          manaCost: cardPayload['manaCost']?.toString(),
          imageUrlSmall: cardPayload['imageUrlSmall']?.toString(),
          imageUrlNormal: cardPayload['imageUrlNormal']?.toString(),
          imageUrlPng: cardPayload['imageUrlPng']?.toString(),
        ),
        fingerprint: _VisualFingerprint(
          averageHash: averageHash,
          differenceHash: differenceHash,
          colorSignature: colorSignature,
        ),
        indexedAt: DateTime.tryParse(json['indexedAt']?.toString() ?? '') ??
            DateTime.fromMillisecondsSinceEpoch(0, isUtc: true),
      );
    } on FormatException {
      return null;
    }
  }

  static Uint8List _decodeOptionalBytes(Object? payload) {
    if (payload is! String || payload.isEmpty) return Uint8List(0);
    return base64Decode(payload);
  }
}

class _Rgb {
  const _Rgb({required this.r, required this.g, required this.b});

  final int r;
  final int g;
  final int b;
}
