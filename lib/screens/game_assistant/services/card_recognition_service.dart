import 'dart:async';
import 'dart:io';

import 'package:camera/camera.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:google_mlkit_text_recognition/google_mlkit_text_recognition.dart';

import '../../../data/local/db/app_database.dart';
import '../../../data/scan/catalog_scan_index.dart';
import '../../../data/scan/live_scan_frame_cropper.dart';
import '../../../data/scan/scan_models.dart';
import '../../../data/scan/scan_recognition_service.dart';

class GameAssistantRecognitionSnapshot {
  const GameAssistantRecognitionSnapshot({
    this.candidate,
    this.message,
  });

  final ScanRecognitionCandidate? candidate;
  final String? message;
}

class GameAssistantCardRecognitionService {
  GameAssistantCardRecognitionService({
    required AppDatabase db,
    CatalogScanIndex? scanIndex,
    ManaScanRecognitionService? recognitionService,
  }) : this._(
          db: db,
          scanIndex: scanIndex ?? CatalogScanIndex(database: db),
          recognitionService: recognitionService,
        );

  GameAssistantCardRecognitionService._({
    required AppDatabase db,
    required CatalogScanIndex scanIndex,
    ManaScanRecognitionService? recognitionService,
  })  : _scanIndex = scanIndex,
        _recognitionService = recognitionService ??
            ManaScanRecognitionService(db: db, scanIndex: scanIndex);

  static const Duration ocrTimeout = Duration(milliseconds: 1200);
  static const Duration recognitionTimeout = Duration(milliseconds: 900);
  static const double minimumRecognitionConfidence = 0.80;
  static const double lowConfidenceFeedbackThreshold = 0.58;

  final CatalogScanIndex _scanIndex;
  final ManaScanRecognitionService _recognitionService;
  final LiveScanFrameCropper _frameCropper = const LiveScanFrameCropper();
  final Map<String, DateTime> _recentNoMatchKeys = {};

  Future<bool> ensureReady() => _scanIndex.ensureLoaded();

  Future<GameAssistantRecognitionSnapshot> recognizeCameraImage({
    required CameraImage image,
    required CameraDescription camera,
    required DeviceOrientation deviceOrientation,
  }) async {
    final rotationDegrees = _inputImageRotationDegrees(
      camera: camera,
      deviceOrientation: deviceOrientation,
    );
    final rotation = rotationDegrees == null
        ? null
        : InputImageRotationValue.fromRawValue(rotationDegrees);
    final inputFormat = InputImageFormatValue.fromRawValue(image.format.raw);
    final pixelFormat = _liveScanPixelFormat(inputFormat);
    if (rotationDegrees == null ||
        rotation == null ||
        inputFormat == null ||
        pixelFormat == null ||
        image.planes.length != 1) {
      return const GameAssistantRecognitionSnapshot(
        message: 'Formato do stream da câmera não suportado neste aparelho.',
      );
    }

    final localCatalogReady = await ensureReady();
    if (!localCatalogReady) {
      return const GameAssistantRecognitionSnapshot(
        message: 'Atualize o catálogo no Scan para reconhecer cartas offline.',
      );
    }

    final plane = image.planes.first;
    final crops = <LiveScanRoiKind, LiveScanCrop>{};
    for (final roi in _frameCropper.roiRequests(
      imageWidth: image.width,
      imageHeight: image.height,
      rotationDegrees: rotationDegrees,
    )) {
      final crop = _frameCropper.crop(
        bytes: plane.bytes,
        imageWidth: image.width,
        imageHeight: image.height,
        sourceBytesPerRow: plane.bytesPerRow,
        format: pixelFormat,
        roi: roi,
      );
      if (crop != null) crops[roi.kind] = crop;
    }

    for (final kind in const [
      LiveScanRoiKind.nameBand,
      LiveScanRoiKind.card,
    ]) {
      final text = await _ocrCrop(
        crops[kind],
        rotation: rotation,
        inputFormat: inputFormat,
      );
      if (text == null || text.trim().isEmpty) continue;
      final result = await _recognizeLiveText(text);
      final candidate = result?.primary;
      if (candidate != null) {
        if (candidate.score >= minimumRecognitionConfidence) {
          return GameAssistantRecognitionSnapshot(candidate: candidate);
        }
        if (candidate.score >= lowConfidenceFeedbackThreshold) {
          return GameAssistantRecognitionSnapshot(
            message:
                'Leitura ignorada: ${(candidate.score * 100).round()}% de confiança.',
          );
        }
      }
    }

    return const GameAssistantRecognitionSnapshot();
  }

  Future<void> dispose() => _recognitionService.dispose();

  Future<String?> _ocrCrop(
    LiveScanCrop? crop, {
    required InputImageRotation rotation,
    required InputImageFormat inputFormat,
  }) async {
    if (crop == null) return null;
    final inputImage = InputImage.fromBytes(
      bytes: crop.bytes,
      metadata: InputImageMetadata(
        size: Size(crop.width.toDouble(), crop.height.toDouble()),
        rotation: rotation,
        format: inputFormat,
        bytesPerRow: crop.bytesPerRow,
      ),
    );
    final result = await _recognitionService.ocrEngine
        .recognizeInputImageDetailed(inputImage)
        .timeout(ocrTimeout);
    return crop.kind == LiveScanRoiKind.card
        ? result.prioritizedText(topLineCount: 5, bottomLineCount: 3)
        : result.prioritizedText(topLineCount: 3, bottomLineCount: 1);
  }

  Future<ScanRecognitionResult?> _recognizeLiveText(String rawText) async {
    final key = _recognitionKey(rawText);
    if (key == null) return null;
    final lastNoMatch = _recentNoMatchKeys[key];
    if (lastNoMatch != null &&
        DateTime.now().difference(lastNoMatch) < const Duration(seconds: 3)) {
      return null;
    }

    try {
      return await _recognitionService
          .recognizeRawText(
            rawText: rawText,
            options: const ScanRecognitionOptions.live(),
          )
          .timeout(recognitionTimeout);
    } on TimeoutException {
      return null;
    } on ScanRecognitionException {
      _recentNoMatchKeys[key] = DateTime.now();
      if (_recentNoMatchKeys.length > 80) {
        _recentNoMatchKeys.remove(_recentNoMatchKeys.keys.first);
      }
      return null;
    }
  }

  String? _recognitionKey(String rawText) {
    final normalizedLines = rawText
        .split('\n')
        .map(
          (line) => line
              .toLowerCase()
              .replaceAll(RegExp(r'[^a-z0-9 ]'), ' ')
              .replaceAll(RegExp(r'\s+'), ' ')
              .trim(),
        )
        .where((line) => line.length >= 3 && !RegExp(r'^\d+$').hasMatch(line))
        .take(4)
        .toList();
    if (normalizedLines.isEmpty) return null;
    return normalizedLines.join('|');
  }

  int? _inputImageRotationDegrees({
    required CameraDescription camera,
    required DeviceOrientation deviceOrientation,
  }) {
    if (Platform.isIOS) return camera.sensorOrientation;
    final orientation = _deviceOrientations[deviceOrientation];
    if (orientation == null) return null;
    return camera.lensDirection == CameraLensDirection.front
        ? (camera.sensorOrientation + orientation) % 360
        : (camera.sensorOrientation - orientation + 360) % 360;
  }

  LiveScanPixelFormat? _liveScanPixelFormat(InputImageFormat? format) {
    if (defaultTargetPlatform == TargetPlatform.android &&
        format == InputImageFormat.nv21) {
      return LiveScanPixelFormat.nv21;
    }
    if (defaultTargetPlatform == TargetPlatform.iOS &&
        format == InputImageFormat.bgra8888) {
      return LiveScanPixelFormat.bgra8888;
    }
    return null;
  }

  static const _deviceOrientations = <DeviceOrientation, int>{
    DeviceOrientation.portraitUp: 0,
    DeviceOrientation.landscapeLeft: 90,
    DeviceOrientation.portraitDown: 180,
    DeviceOrientation.landscapeRight: 270,
  };
}
