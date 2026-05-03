import 'dart:async';
import 'dart:io';

import 'package:camera/camera.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:google_mlkit_text_recognition/google_mlkit_text_recognition.dart';
import 'package:uuid/uuid.dart';

import '../../data/local/db/app_database.dart' show Collection;
import '../../data/local/db/db_instance.dart';
import '../../data/scan/catalog_scan_index.dart';
import '../../data/scan/catalog_sync_service.dart';
import '../../data/scan/live_scan_acceptance.dart';
import '../../data/scan/live_scan_frame_cropper.dart';
import '../../data/scan/scan_buffer_store.dart';
import '../../data/scan/scan_models.dart';
import '../../data/scan/scan_recognition_service.dart';
import '../../widgets/create_collection_dialog.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';
import '../../widgets/mana_tab_main_app_bar.dart';
import 'widgets/scan_buffer_entry_sheet.dart';
import 'widgets/scan_buffer_tile.dart';
import 'widgets/scan_camera_panel.dart';

class ScanScreen extends StatefulWidget {
  const ScanScreen({super.key});

  @override
  State<ScanScreen> createState() => _ScanScreenState();
}

class _ScanScreenState extends State<ScanScreen> {
  static const double _minimumConfidence = 0.64;
  static const double _minimumNameAnchorConfidence = 0.58;
  static const Duration _frameThrottle = Duration(milliseconds: 280);
  static const Duration _ocrTimeout = Duration(milliseconds: 1500);
  static const Duration _recognitionTimeout = Duration(milliseconds: 900);
  static const Duration _noMatchCooldown = Duration(seconds: 3);
  static const Duration _liveConfirmationWindow = Duration(seconds: 3);
  static const Duration _nameAnchorTtl = Duration(seconds: 4);
  static const Duration _successFrameDuration = Duration(milliseconds: 950);
  static const int _fastLiveConfirmations = 2;
  static const int _strictLiveConfirmations = 3;
  static const _deviceOrientations = <DeviceOrientation, int>{
    DeviceOrientation.portraitUp: 0,
    DeviceOrientation.landscapeLeft: 90,
    DeviceOrientation.portraitDown: 180,
    DeviceOrientation.landscapeRight: 270,
  };

  final _uuid = const Uuid();
  final _bufferStore = ScanBufferStore();
  final _frameCropper = const LiveScanFrameCropper();
  final _duplicateGate = LiveScanDuplicateGate();
  late final CatalogScanIndex _scanIndex;
  late final ScanCatalogSyncService _catalogSyncService;
  late final ManaScanRecognitionService _recognitionService;

  CameraController? _cameraController;
  ScanCatalogSyncSnapshot _catalogStatus = ScanCatalogSyncSnapshot.idle();
  bool _cameraLoading = false;
  bool _syncingCatalog = false;
  bool _scanLoopActive = false;
  bool _scanInFlight = false;
  bool _saving = false;
  bool _restoringBuffer = true;
  bool _showSuccessFrame = false;
  DateTime? _lastFrameProcessedAt;
  DateTime? _pendingLiveCandidateFirstSeenAt;
  DateTime? _liveNameAnchorSeenAt;
  Timer? _successFrameTimer;
  String? _selectedCollectionId;
  String? _pendingLiveCandidateId;
  String? _liveNameText;
  String? _error;
  String _status = 'Prepare o catálogo local e inicie o scan contínuo.';
  ScanRecognitionCandidate? _liveNameAnchor;
  ScanRecognitionCandidate? _livePreviewCandidate;
  int _pendingLiveCandidateSeenCount = 0;
  int _pendingLiveCandidateConfirmationsRequired = 0;
  int _scanGeneration = 0;
  int _liveOcrCycle = 0;
  List<BufferedScanEntry> _buffer = const [];
  final Map<String, DateTime> _recentNoMatchKeys = {};
  final Map<String, DateTime> _visualWarmupNames = {};

  bool get _scanSupported {
    if (kIsWeb) return false;
    return defaultTargetPlatform == TargetPlatform.android ||
        defaultTargetPlatform == TargetPlatform.iOS;
  }

  int get _totalBuffered =>
      _buffer.fold<int>(0, (sum, entry) => sum + entry.quantity);

  @override
  void initState() {
    super.initState();
    _scanIndex = CatalogScanIndex(database: appDb);
    _catalogSyncService = ScanCatalogSyncService(database: appDb);
    _recognitionService = ManaScanRecognitionService(
      db: appDb,
      scanIndex: _scanIndex,
    );
    unawaited(_restorePersistedBuffer());
    unawaited(_refreshCatalogStatus());
    if (_scanSupported) {
      unawaited(_ensureCameraReady());
    }
  }

  @override
  void dispose() {
    _scanGeneration++;
    _scanLoopActive = false;
    _successFrameTimer?.cancel();
    unawaited(_stopImageStream());
    unawaited(_cameraController?.dispose());
    unawaited(_recognitionService.dispose());
    super.dispose();
  }

  Future<void> _refreshCatalogStatus() async {
    final status = await _catalogSyncService.currentStatus();
    if (!mounted) return;
    setState(() => _catalogStatus = status);
  }

  Future<void> _runCatalogSync({bool force = false}) async {
    if (_syncingCatalog || _scanLoopActive) return;
    final startedAt = DateTime.now().toUtc();
    setState(() {
      _syncingCatalog = true;
      _error = null;
      _catalogStatus = ScanCatalogSyncSnapshot(
        phase: ScanCatalogSyncPhase.checking,
        cardCount: _catalogStatus.cardCount,
        startedAt: startedAt,
      );
      _status = 'Preparando download do catálogo local...';
    });

    ScanCatalogSyncSnapshot? finalStatus;
    try {
      finalStatus = await _catalogSyncService.sync(
        force: force,
        onProgress: (snapshot) {
          if (!mounted) return;
          setState(() => _applyCatalogSnapshot(snapshot));
        },
      );
    } catch (error) {
      finalStatus = ScanCatalogSyncSnapshot(
        phase: ScanCatalogSyncPhase.failed,
        cardCount: _catalogStatus.cardCount,
        lastError: error.toString(),
      );
    } finally {
      if (mounted) {
        final status = finalStatus;
        setState(() {
          if (status != null) {
            _applyCatalogSnapshot(status);
          }
          _syncingCatalog = false;
        });
      }
    }
  }

  void _applyCatalogSnapshot(ScanCatalogSyncSnapshot snapshot) {
    _catalogStatus = snapshot;
    _status = switch (snapshot.phase) {
      ScanCatalogSyncPhase.checking => 'Verificando bulk data...',
      ScanCatalogSyncPhase.importing => _catalogRunningLabel(snapshot),
      ScanCatalogSyncPhase.completed =>
        'Catálogo local pronto com ${snapshot.cardCount} cartas.',
      ScanCatalogSyncPhase.failed =>
        snapshot.lastError ?? 'Falha ao atualizar o catálogo.',
      ScanCatalogSyncPhase.idle => 'Atualização cancelada.',
    };
    _error = snapshot.phase == ScanCatalogSyncPhase.failed
        ? snapshot.lastError
        : null;
  }

  Future<void> _restorePersistedBuffer() async {
    final entries = await _bufferStore.load();
    if (!mounted) return;
    setState(() {
      _buffer = entries;
      _restoringBuffer = false;
      if (entries.isNotEmpty) {
        _status = 'Sessão restaurada com $_totalBuffered carta(s) no buffer.';
      }
    });
  }

  Future<void> _persistBuffer() => _bufferStore.save(_buffer);

  Future<void> _clearPersistedBuffer() => _bufferStore.clear();

  Future<void> _ensureCameraReady() async {
    if (_cameraController != null &&
        _cameraController!.value.isInitialized &&
        !_cameraController!.value.hasError) {
      return;
    }

    setState(() {
      _cameraLoading = true;
      _status = 'Preparando câmera...';
      _error = null;
    });

    try {
      final cameras = await availableCameras();
      if (cameras.isEmpty) {
        throw const ScanRecognitionException(
          'Nenhuma câmera foi encontrada neste dispositivo.',
        );
      }

      final preferred = cameras.firstWhere(
        (camera) => camera.lensDirection == CameraLensDirection.back,
        orElse: () => cameras.first,
      );
      final controller = CameraController(
        preferred,
        ResolutionPreset.high,
        enableAudio: false,
        imageFormatGroup: Platform.isAndroid
            ? ImageFormatGroup.nv21
            : ImageFormatGroup.bgra8888,
      );
      await controller.initialize();
      try {
        await controller.setFlashMode(FlashMode.off);
        await controller.setFocusMode(FocusMode.auto);
        await controller.setExposureMode(ExposureMode.auto);
      } on CameraException {
        // Alguns dispositivos não expõem esses controles no modo stream.
      }
      if (!mounted) {
        await controller.dispose();
        return;
      }
      setState(() {
        _cameraController = controller;
        _status = 'Câmera pronta. Inicie o live scan quando quiser.';
      });
    } on CameraException catch (error) {
      if (!mounted) return;
      setState(() {
        _error = _cameraErrorMessage(error);
        _status = _error!;
      });
    } catch (error) {
      if (!mounted) return;
      setState(() {
        _error = error.toString();
        _status = 'Não foi possível abrir a câmera.';
      });
    } finally {
      if (mounted) setState(() => _cameraLoading = false);
    }
  }

  Future<void> _startLiveScan() async {
    await _ensureCameraReady();
    final controller = _cameraController;
    if (controller == null || !controller.value.isInitialized) return;
    if (controller.value.isStreamingImages) return;

    _catalogSyncService.cancelSync();
    setState(() {
      _status = 'Carregando catálogo local...';
      _error = null;
    });

    final catalogStatus = await _catalogSyncService.currentStatus();
    if (!mounted) return;
    _catalogStatus = catalogStatus;
    final hasViableCatalog = await _catalogSyncService.hasSyncedCatalog();
    final hasLocalIndex = hasViableCatalog && await _scanIndex.ensureLoaded();
    if (!hasLocalIndex) {
      if (!mounted) return;
      setState(() {
        _scanLoopActive = false;
        _status = 'Atualize o catálogo local antes do live scan.';
        _error =
            'O live scan usa o banco local para evitar rede durante a detecção.';
      });
      return;
    }
    if (!mounted) return;

    _scanGeneration++;
    _clearLiveScanState();
    setState(() {
      _scanLoopActive = true;
      _status = 'Escaneando...';
    });
    await controller.startImageStream(_processCameraImage);
  }

  Future<void> _pauseLiveScan() async {
    _scanGeneration++;
    await _stopImageStream();
    _clearLiveScanState();
    if (!mounted) return;
    setState(() {
      _scanLoopActive = false;
      _status = 'Live scan pausado.';
    });
    _duplicateGate.reset();
  }

  Future<void> _stopImageStream() async {
    final controller = _cameraController;
    if (controller == null ||
        !controller.value.isInitialized ||
        !controller.value.isStreamingImages) {
      return;
    }
    await controller.stopImageStream();
  }

  Future<void> _processCameraImage(CameraImage image) async {
    if (!_scanLoopActive || _scanInFlight) return;
    final now = DateTime.now();
    final lastFrame = _lastFrameProcessedAt;
    if (lastFrame != null && now.difference(lastFrame) < _frameThrottle) {
      return;
    }
    _lastFrameProcessedAt = now;

    final generation = _scanGeneration;
    _scanInFlight = true;
    try {
      final result = await _recognizeCameraImageByRoi(
        image: image,
        generation: generation,
      );
      if (!_isActiveScanGeneration(generation)) return;
      if (result == null) {
        setState(() => _status = 'Escaneando...');
        return;
      }

      final primary = result.primary;
      if (primary == null || primary.score < _minimumConfidence) {
        setState(() {
          _status = 'Escaneando...';
          _livePreviewCandidate = primary;
        });
        return;
      }

      final acceptance = _scanAcceptanceFor(primary);
      if (!acceptance.canAutoAccept) {
        _clearPendingLiveCandidate();
        setState(() {
          _status = acceptance.statusMessage;
          _livePreviewCandidate = primary;
        });
        return;
      }

      if (!_isLiveCandidateStable(primary, acceptance.confirmationsRequired)) {
        setState(() {
          _status = 'Verificando ${primary.name} (${primary.editionLabel})...';
          _livePreviewCandidate = primary;
        });
        return;
      }

      setState(() => _mergeBufferedCandidate(primary));
      _clearPendingLiveCandidate();
      _recordAcceptedLiveMatch(result);
    } on TimeoutException {
      if (_isActiveScanGeneration(generation)) {
        setState(() => _status = 'Escaneando...');
      }
    } on CameraException catch (error) {
      if (!_isActiveScanGeneration(generation)) return;
      setState(() {
        _status = _cameraErrorMessage(error);
        _error = _status;
        _scanLoopActive = false;
      });
      await _stopImageStream();
    } catch (error) {
      if (_isActiveScanGeneration(generation)) {
        setState(() => _status = 'Escaneando...');
      }
    } finally {
      _scanInFlight = false;
    }
  }

  Future<ScanRecognitionResult?> _recognizeCameraImageByRoi({
    required CameraImage image,
    required int generation,
  }) async {
    final controller = _cameraController;
    if (controller == null) return null;

    final rotationDegrees = _inputImageRotationDegrees(controller.description);
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
      setState(() {
        _status = 'Formato do stream da câmera não suportado neste aparelho.';
      });
      return null;
    }

    final plane = image.planes.first;
    final roiRequests = _frameCropper.roiRequests(
      imageWidth: image.width,
      imageHeight: image.height,
      rotationDegrees: rotationDegrees,
    );

    final crops = <LiveScanRoiKind, LiveScanCrop>{};
    for (final roi in roiRequests) {
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

    final cardCrop = crops[LiveScanRoiKind.card];
    final activeNameAnchor = _activeNameAnchor();
    if (cardCrop != null) {
      final visualResult = await _recognizeVisualCrop(
        crop: cardCrop,
        format: pixelFormat,
        nameAnchor: activeNameAnchor,
        ocrResult: null,
      );
      if (!_isActiveScanGeneration(generation)) return null;
      final visualPrimary = visualResult?.primary;
      if (visualPrimary != null && visualPrimary.score >= _minimumConfidence) {
        if (mounted) {
          setState(() => _livePreviewCandidate = visualPrimary);
        }
        return visualResult;
      }
    }

    final roiKind = _nextOcrRoiKind(activeNameAnchor);
    final ocrResult = await _recognizeOcrCrop(
      crops: crops,
      roiKind: roiKind,
      rotation: rotation,
      inputFormat: inputFormat,
    );
    if (!_isActiveScanGeneration(generation)) return null;

    final text =
        ocrResult == null ? '' : _prioritizedTextForRoi(ocrResult, roiKind);
    ScanRecognitionResult? roiResult;

    if (text.trim().isNotEmpty && roiKind == LiveScanRoiKind.nameBand) {
      roiResult = await _recognizeLiveText(text).timeout(_recognitionTimeout);
      if (!_isActiveScanGeneration(generation)) return null;
      final primary = roiResult?.primary;
      if (primary != null && primary.score >= _minimumNameAnchorConfidence) {
        _updateLiveNameAnchor(primary, text);
      }
      if (roiResult != null) return roiResult;
    } else if (text.trim().isNotEmpty) {
      final nameAnchor = activeNameAnchor ?? _activeNameAnchor();
      if (nameAnchor != null) {
        final combinedText = [
          _liveNameText ?? nameAnchor.name,
          text,
        ].where((value) => value.trim().isNotEmpty).join('\n');
        roiResult =
            await _recognizeLiveText(combinedText).timeout(_recognitionTimeout);
        if (!_isActiveScanGeneration(generation)) return null;
        roiResult =
            _constrainToNameAnchor(result: roiResult, nameAnchor: nameAnchor);
        if (roiResult != null) return roiResult;
      }
    }

    if (!_shouldRunFullCardOcrFallback(roiKind: roiKind, roiText: text)) {
      return null;
    }

    final nameAnchor = activeNameAnchor ?? _activeNameAnchor();
    return _recognizeFullCardFallback(
      crops: crops,
      baseRotationDegrees: rotationDegrees,
      inputFormat: inputFormat,
      nameAnchor: nameAnchor,
      generation: generation,
    );
  }

  Future<ScanRecognitionResult?> _recognizeFullCardFallback({
    required Map<LiveScanRoiKind, LiveScanCrop> crops,
    required int baseRotationDegrees,
    required InputImageFormat inputFormat,
    required ScanRecognitionCandidate? nameAnchor,
    required int generation,
  }) async {
    for (final offset in const [0, 90, 270, 180]) {
      final rotation = InputImageRotationValue.fromRawValue(
        (baseRotationDegrees + offset) % 360,
      );
      if (rotation == null) continue;
      final fallbackOcr = await _recognizeOcrCrop(
        crops: crops,
        roiKind: LiveScanRoiKind.card,
        rotation: rotation,
        inputFormat: inputFormat,
      );
      if (!_isActiveScanGeneration(generation)) return null;
      if (fallbackOcr == null) continue;

      final fallbackText =
          _prioritizedTextForRoi(fallbackOcr, LiveScanRoiKind.card);
      if (fallbackText.trim().isEmpty) continue;
      final fallbackCombinedText = [
        if (nameAnchor != null) _liveNameText ?? nameAnchor.name,
        fallbackText,
      ].where((value) => value.trim().isNotEmpty).join('\n');
      final fallbackResult = await _recognizeLiveText(fallbackCombinedText)
          .timeout(_recognitionTimeout);
      if (!_isActiveScanGeneration(generation)) return null;
      if (nameAnchor == null) {
        if (fallbackResult?.primary != null) return fallbackResult;
        continue;
      }
      final constrained = _constrainToNameAnchor(
        result: fallbackResult,
        nameAnchor: nameAnchor,
      );
      if (constrained?.primary != null) return constrained;
    }
    return null;
  }

  Future<OcrTextResult?> _recognizeOcrCrop({
    required Map<LiveScanRoiKind, LiveScanCrop> crops,
    required LiveScanRoiKind roiKind,
    required InputImageRotation rotation,
    required InputImageFormat inputFormat,
  }) async {
    final crop = crops[roiKind];
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
    return _recognitionService.ocrEngine
        .recognizeInputImageDetailed(inputImage)
        .timeout(_ocrTimeout);
  }

  bool _shouldRunFullCardOcrFallback({
    required LiveScanRoiKind roiKind,
    required String roiText,
  }) {
    if (roiKind == LiveScanRoiKind.card) return false;
    if (roiText.trim().isEmpty) return true;
    return _liveOcrCycle % 4 == 0;
  }

  Future<ScanRecognitionResult?> _recognizeLiveText(String rawText) async {
    final recognitionKey = _recognitionKey(rawText);
    if (recognitionKey == null) return null;

    final lastNoMatch = _recentNoMatchKeys[recognitionKey];
    if (lastNoMatch != null &&
        DateTime.now().difference(lastNoMatch) < _noMatchCooldown) {
      return null;
    }

    try {
      return await _recognitionService.recognizeRawText(
        rawText: rawText,
        options: const ScanRecognitionOptions.live(),
      );
    } on ScanRecognitionException {
      _recentNoMatchKeys[recognitionKey] = DateTime.now();
      if (_recentNoMatchKeys.length > 80) {
        _recentNoMatchKeys.remove(_recentNoMatchKeys.keys.first);
      }
      return null;
    }
  }

  Future<ScanRecognitionResult?> _recognizeVisualCrop({
    required LiveScanCrop crop,
    required LiveScanPixelFormat format,
    required ScanRecognitionCandidate? nameAnchor,
    required ScanRecognitionResult? ocrResult,
  }) async {
    Set<String>? allowedCardIds;
    if (nameAnchor != null) {
      final printings = await _scanIndex.printingsForName(nameAnchor.name);
      if (printings.isNotEmpty) {
        allowedCardIds = printings.map((card) => card.id).toSet();
        _warmUpVisualPrintings(nameAnchor.name, printings);
      }
    }

    final visualMatches = await _recognitionService.visualFingerprintService
        .findVisualMatchesInCrop(
      crop: crop,
      format: format,
      allowedCardIds: allowedCardIds,
      minScore: nameAnchor == null ? 0.82 : 0.70,
    );
    if (visualMatches.isEmpty) return null;

    final ocrById = {
      for (final candidate
          in ocrResult?.candidates ?? const <ScanRecognitionCandidate>[])
        candidate.printingId: candidate,
    };
    final blended = visualMatches.map((visualCandidate) {
      final ocrCandidate = ocrById[visualCandidate.printingId];
      final score = ocrCandidate == null
          ? visualCandidate.score
          : ((visualCandidate.score * 0.72) + (ocrCandidate.score * 0.28))
              .clamp(0, 1)
              .toDouble();
      return ScanRecognitionCandidate(
        card: visualCandidate.card,
        score: score,
        matchReason: ocrCandidate == null
            ? visualCandidate.matchReason
            : '${visualCandidate.matchReason}; OCR agrees',
      );
    }).toList()
      ..sort((left, right) => right.score.compareTo(left.score));

    return ScanRecognitionResult(
      rawText: ocrResult?.rawText ?? '[visual live match]',
      candidates: blended,
    );
  }

  void _warmUpVisualPrintings(
      String cardName, List<ScanCatalogCard> printings) {
    final key = _normalizedCardName(cardName);
    final lastWarmup = _visualWarmupNames[key];
    final now = DateTime.now();
    if (lastWarmup != null &&
        now.difference(lastWarmup) < const Duration(minutes: 30)) {
      return;
    }
    _visualWarmupNames[key] = now;
    unawaited(
        _recognitionService.indexVisualCards(printings.take(96).toList()));
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

  ScanRecognitionResult? _constrainToNameAnchor({
    required ScanRecognitionResult? result,
    required ScanRecognitionCandidate nameAnchor,
  }) {
    if (result == null) return null;
    final anchorName = _normalizedCardName(nameAnchor.name);
    final constrainedCandidates = result.candidates.where((candidate) {
      final candidateName = _normalizedCardName(candidate.name);
      return candidateName == anchorName ||
          _nameSimilarity(candidateName, anchorName) >= 0.86;
    }).toList();
    if (constrainedCandidates.isEmpty) return null;
    return ScanRecognitionResult(
      rawText: result.rawText,
      candidates: constrainedCandidates,
    );
  }

  String _prioritizedTextForRoi(OcrTextResult result, LiveScanRoiKind kind) {
    return switch (kind) {
      LiveScanRoiKind.nameBand =>
        result.prioritizedText(topLineCount: 3, bottomLineCount: 0),
      LiveScanRoiKind.collectorBand =>
        result.prioritizedText(topLineCount: 3, bottomLineCount: 1),
      LiveScanRoiKind.card =>
        result.prioritizedText(topLineCount: 5, bottomLineCount: 3),
    };
  }

  LiveScanPixelFormat? _liveScanPixelFormat(InputImageFormat? format) {
    if (Platform.isAndroid && format == InputImageFormat.nv21) {
      return LiveScanPixelFormat.nv21;
    }
    if (Platform.isIOS && format == InputImageFormat.bgra8888) {
      return LiveScanPixelFormat.bgra8888;
    }
    return null;
  }

  int? _inputImageRotationDegrees(CameraDescription camera) {
    if (Platform.isIOS) return camera.sensorOrientation;
    final orientation =
        _deviceOrientations[_cameraController?.value.deviceOrientation];
    if (orientation == null) return null;
    return camera.lensDirection == CameraLensDirection.front
        ? (camera.sensorOrientation + orientation) % 360
        : (camera.sensorOrientation - orientation + 360) % 360;
  }

  bool _isActiveScanGeneration(int generation) {
    return mounted && _scanLoopActive && _scanGeneration == generation;
  }

  ScanRecognitionCandidate? _activeNameAnchor() {
    final anchor = _liveNameAnchor;
    final seenAt = _liveNameAnchorSeenAt;
    if (anchor == null || seenAt == null) return null;
    if (DateTime.now().difference(seenAt) > _nameAnchorTtl) {
      _liveNameAnchor = null;
      _liveNameText = null;
      _liveNameAnchorSeenAt = null;
      return null;
    }
    return anchor;
  }

  LiveScanRoiKind _nextOcrRoiKind(ScanRecognitionCandidate? activeNameAnchor) {
    _liveOcrCycle++;
    if (activeNameAnchor == null || _liveOcrCycle % 5 == 0) {
      return LiveScanRoiKind.nameBand;
    }
    return LiveScanRoiKind.collectorBand;
  }

  void _updateLiveNameAnchor(
    ScanRecognitionCandidate candidate,
    String rawText,
  ) {
    _liveNameAnchor = candidate;
    _liveNameText = rawText;
    _liveNameAnchorSeenAt = DateTime.now();
    unawaited(
      _scanIndex.printingsForName(candidate.name).then((printings) {
        if (printings.isNotEmpty) {
          _warmUpVisualPrintings(candidate.name, printings);
        }
      }),
    );
  }

  LiveScanAcceptance _scanAcceptanceFor(ScanRecognitionCandidate candidate) {
    return const LiveScanAcceptancePolicy(
      fastConfirmations: _fastLiveConfirmations,
      strictConfirmations: _strictLiveConfirmations,
    ).evaluate(candidate);
  }

  bool _isLiveCandidateStable(
    ScanRecognitionCandidate candidate,
    int confirmationsRequired,
  ) {
    final now = DateTime.now();
    final firstSeenAt = _pendingLiveCandidateFirstSeenAt;
    final isSameCandidate = _pendingLiveCandidateId == candidate.printingId;
    final isFresh = firstSeenAt != null &&
        now.difference(firstSeenAt) <= _liveConfirmationWindow;

    if (!isSameCandidate || !isFresh) {
      _pendingLiveCandidateId = candidate.printingId;
      _pendingLiveCandidateFirstSeenAt = now;
      _pendingLiveCandidateSeenCount = 1;
      _pendingLiveCandidateConfirmationsRequired = confirmationsRequired;
      return false;
    }

    _pendingLiveCandidateSeenCount++;
    _pendingLiveCandidateConfirmationsRequired = confirmationsRequired;
    return _pendingLiveCandidateSeenCount >= confirmationsRequired;
  }

  void _clearPendingLiveCandidate() {
    _pendingLiveCandidateId = null;
    _pendingLiveCandidateFirstSeenAt = null;
    _pendingLiveCandidateSeenCount = 0;
    _pendingLiveCandidateConfirmationsRequired = 0;
  }

  void _clearLiveScanState() {
    _clearPendingLiveCandidate();
    _liveNameAnchor = null;
    _livePreviewCandidate = null;
    _liveNameText = null;
    _liveNameAnchorSeenAt = null;
    _liveOcrCycle = 0;
  }

  void _mergeBufferedCandidate(ScanRecognitionCandidate candidate) {
    final now = DateTime.now().toUtc();
    _markSuccessfulRead();
    final defaultEntry = BufferedScanEntry(
      card: candidate.card,
      quantity: 1,
      firstSeenAt: now,
      lastSeenAt: now,
      confidence: candidate.score,
    );

    if (!_duplicateGate.shouldAccept(defaultEntry.variantKey)) {
      _livePreviewCandidate = candidate;
      _status =
          'Reconhecida ${candidate.name}. Aponte para outra carta para contar outra cópia.';
      return;
    }

    final existingIndex = _buffer.indexWhere(
      (entry) => entry.variantKey == defaultEntry.variantKey,
    );
    if (existingIndex >= 0) {
      final updatedEntry = _buffer[existingIndex].copyWith(
        quantity: _buffer[existingIndex].quantity + 1,
        lastSeenAt: now,
        confidence: candidate.score,
      );
      final updatedBuffer = [..._buffer];
      updatedBuffer[existingIndex] = updatedEntry;
      _buffer = updatedBuffer;
    } else {
      _buffer = [defaultEntry, ..._buffer];
    }

    _livePreviewCandidate = candidate;
    _status = 'Adicionada ${candidate.name} (${candidate.editionLabel}).';
    unawaited(_persistBuffer());
  }

  void _recordAcceptedLiveMatch(ScanRecognitionResult result) {
    final primary = result.primary;
    if (primary == null) return;
    unawaited(_recognitionService.indexVisualCards([primary.card]));
  }

  void _markSuccessfulRead() {
    _successFrameTimer?.cancel();
    _showSuccessFrame = true;
    _successFrameTimer = Timer(_successFrameDuration, () {
      if (!mounted) return;
      setState(() => _showSuccessFrame = false);
    });
  }

  Future<void> _openBufferEntryEditor(BufferedScanEntry entry) async {
    final updated = await showModalBottomSheet<BufferedScanEntry>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => ScanBufferEntrySheet(
        entry: entry,
        scanIndex: _scanIndex,
      ),
    );
    if (updated == null || !mounted) return;

    setState(() {
      if (updated.quantity <= 0) {
        _buffer = _buffer
            .where((item) => item.variantKey != entry.variantKey)
            .toList();
        return;
      }
      _buffer = _buffer
          .map((item) => item.variantKey == entry.variantKey ? updated : item)
          .toList();
    });
    unawaited(_persistBuffer());
  }

  void _removeBufferedEntry(BufferedScanEntry entry) {
    setState(() {
      _buffer =
          _buffer.where((item) => item.variantKey != entry.variantKey).toList();
      _duplicateGate.forget(entry.variantKey);
    });
    unawaited(_persistBuffer());
  }

  void _setBufferedEntryQuantity(BufferedScanEntry entry, int quantity) {
    if (quantity <= 0) {
      _removeBufferedEntry(entry);
      return;
    }

    setState(() {
      _buffer = _buffer
          .map((item) => item.variantKey == entry.variantKey
              ? item.copyWith(quantity: quantity.clamp(1, 9999))
              : item)
          .toList();
    });
    unawaited(_persistBuffer());
  }

  Future<void> _saveBufferedCards() async {
    final collectionId = _selectedCollectionId;
    if (_saving || _buffer.isEmpty) return;
    if (collectionId == null || collectionId.isEmpty) {
      setState(() => _error = 'Escolha uma coleção antes de salvar o scan.');
      return;
    }

    setState(() {
      _saving = true;
      _error = null;
    });

    try {
      final now = DateTime.now();
      for (final entry in _buffer) {
        await appDb.collectionDao.addOrIncrementItem(
          itemId: _uuid.v4(),
          collectionId: collectionId,
          printingId: entry.card.id,
          quantity: entry.quantity,
          isFoil: entry.isFoil,
          condition: entry.condition,
          language: entry.language,
          notes: entry.notes,
          now: now,
        );
      }

      if (!mounted) return;
      setState(() {
        _buffer = const [];
        _duplicateGate.reset();
        _status = 'Cartas salvas na coleção.';
      });
      unawaited(_clearPersistedBuffer());
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Scan salvo na coleção.')),
      );
    } catch (error) {
      if (!mounted) return;
      setState(() => _error = 'Não foi possível salvar o scan: $error');
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  Future<void> _createCollectionDialog() async {
    final name = await showCreateCollectionDialog(context);
    if (!mounted) return;
    if (name == null || name.isEmpty) return;

    final id = _uuid.v4();
    final now = DateTime.now();
    try {
      await appDb.collectionDao.createCollection(id: id, name: name, now: now);
      if (!mounted) return;
      setState(() => _selectedCollectionId = id);
    } catch (error) {
      if (!mounted) return;
      setState(() => _error = 'Não foi possível criar a coleção: $error');
    }
  }

  @override
  Widget build(BuildContext context) {
    if (!_scanSupported) {
      return const Scaffold(
        appBar: ManaTabMainAppBar(title: 'Scan'),
        body: ManaEmptyState(
          icon: Icons.qr_code_scanner_rounded,
          title: 'Scan disponível em Android e iOS',
          subtitle:
              'Use um dispositivo móvel com câmera para reconhecer cartas.',
        ),
      );
    }

    return Scaffold(
      appBar: const ManaTabMainAppBar(title: 'Live Scan'),
      body: LayoutBuilder(
        builder: (context, constraints) {
          final contentWidth = constraints.maxWidth - 32;
          final idealCameraHeight =
              contentWidth / LiveScanFrameCropper.cardAspectRatio;
          final cameraHeight = idealCameraHeight.clamp(520.0, 760.0).toDouble();
          return ListView(
            padding: const EdgeInsets.fromLTRB(16, 8, 16, 100),
            children: [
              SizedBox(height: cameraHeight, child: _buildCameraPanel(context)),
              const SizedBox(height: 12),
              _buildCatalogStatusCard(context),
              const SizedBox(height: 10),
              _buildControlsCard(context),
              const SizedBox(height: 10),
              SizedBox(
                height: (constraints.maxHeight * 0.22).clamp(180.0, 260.0),
                child: _buildBufferPanel(context),
              ),
            ],
          );
        },
      ),
    );
  }

  Widget _buildCameraPanel(BuildContext context) {
    final catalogReady =
        _catalogStatus.phase == ScanCatalogSyncPhase.completed &&
            _catalogStatus.cardCount >=
                ScanCatalogSyncService.minimumViableCardCount;
    return ScanCameraPanel(
      controller: _cameraController,
      cameraLoading: _cameraLoading,
      scanLoopActive: _scanLoopActive,
      showSuccessFrame: _showSuccessFrame,
      status: _status,
      error: _error,
      liveCandidate: _livePreviewCandidate,
      bufferCount: _totalBuffered,
      catalogReady: catalogReady,
      confirmationsSeen: _pendingLiveCandidateSeenCount,
      confirmationsRequired: _pendingLiveCandidateConfirmationsRequired,
    );
  }

  Widget _buildCatalogStatusCard(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final progress = _catalogStatus.progress;
    final percent = progress == null
        ? null
        : (progress.clamp(0, 1) * 100).round().clamp(0, 100);
    final hasLocalCatalog = _catalogStatus.cardCount >=
        ScanCatalogSyncService.minimumViableCardCount;
    final ready = _catalogStatus.phase == ScanCatalogSyncPhase.completed &&
        hasLocalCatalog;
    return ManaSurfaceCard(
      padding: const EdgeInsets.all(12),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Row(
            children: [
              Icon(
                hasLocalCatalog
                    ? Icons.offline_pin_outlined
                    : Icons.cloud_download_outlined,
                color: hasLocalCatalog ? scheme.primary : scheme.secondary,
              ),
              const SizedBox(width: 10),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      ready
                          ? 'Catálogo local pronto'
                          : 'Catálogo local necessário',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.titleSmall?.copyWith(
                            fontWeight: FontWeight.w800,
                          ),
                    ),
                    const SizedBox(height: 2),
                    Text(
                      _catalogSubtitle(_catalogStatus),
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.bodySmall?.copyWith(
                            color: scheme.onSurfaceVariant,
                          ),
                    ),
                  ],
                ),
              ),
              const SizedBox(width: 8),
              OutlinedButton.icon(
                onPressed: _syncingCatalog || _scanLoopActive
                    ? null
                    : () => _runCatalogSync(force: ready),
                icon: _syncingCatalog
                    ? const SizedBox.square(
                        dimension: 16,
                        child: CircularProgressIndicator(strokeWidth: 2),
                      )
                    : const Icon(Icons.download_for_offline_outlined),
                label: FittedBox(
                  fit: BoxFit.scaleDown,
                  child: Text(ready ? 'Atualizar' : 'Baixar'),
                ),
              ),
            ],
          ),
          if (_catalogStatus.isRunning) ...[
            const SizedBox(height: 10),
            LinearProgressIndicator(
              minHeight: 6,
              borderRadius: BorderRadius.circular(999),
              value: progress == null || progress <= 0
                  ? null
                  : progress.clamp(0, 1).toDouble(),
            ),
            const SizedBox(height: 6),
            Row(
              children: [
                Expanded(
                  child: Text(
                    _catalogRunningDetail(_catalogStatus),
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.labelSmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                          fontWeight: FontWeight.w700,
                        ),
                  ),
                ),
                if (percent != null)
                  Text(
                    '$percent%',
                    style: Theme.of(context).textTheme.labelSmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                          fontWeight: FontWeight.w900,
                        ),
                  ),
              ],
            ),
          ],
        ],
      ),
    );
  }

  String _catalogRunningLabel(ScanCatalogSyncSnapshot snapshot) {
    final bytes = _catalogByteProgress(snapshot);
    if (bytes != null) {
      return 'Baixando $bytes • ${snapshot.cardCount} cartas indexadas';
    }
    return 'Indexando ${snapshot.cardCount} cartas...';
  }

  String _catalogSubtitle(ScanCatalogSyncSnapshot snapshot) {
    if (snapshot.isRunning) {
      return switch (snapshot.phase) {
        ScanCatalogSyncPhase.checking => 'Verificando Scryfall e banco local',
        ScanCatalogSyncPhase.importing =>
          '${snapshot.cardCount} cartas indexadas',
        _ => '${snapshot.cardCount} cartas no banco local',
      };
    }
    if (snapshot.phase == ScanCatalogSyncPhase.idle &&
        snapshot.lastError != null) {
      return snapshot.lastError!;
    }
    return '${snapshot.cardCount} cartas no banco local';
  }

  String _catalogRunningDetail(ScanCatalogSyncSnapshot snapshot) {
    final bytes = _catalogByteProgress(snapshot);
    final cards = '${snapshot.cardCount} cartas indexadas';
    if (snapshot.phase == ScanCatalogSyncPhase.checking) {
      return bytes ?? 'Preparando download...';
    }
    return bytes == null ? cards : '$bytes • $cards';
  }

  String? _catalogByteProgress(ScanCatalogSyncSnapshot snapshot) {
    final total = snapshot.totalBytes;
    if (total == null || total <= 0) return null;
    return '${_formatBytes(snapshot.downloadedBytes)} / ${_formatBytes(total)}';
  }

  String _formatBytes(int bytes) {
    if (bytes <= 0) return '0 MB';
    const mb = 1000 * 1000;
    const gb = 1000 * mb;
    if (bytes >= gb) {
      return '${(bytes / gb).toStringAsFixed(1)} GB';
    }
    return '${(bytes / mb).toStringAsFixed(0)} MB';
  }

  Widget _buildControlsCard(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final canScan = !_syncingCatalog &&
        !_cameraLoading &&
        (_cameraController?.value.isInitialized ?? false);

    return ManaSurfaceCard(
      padding: const EdgeInsets.all(12),
      child: Column(
        children: [
          Row(
            children: [
              Expanded(child: _buildCollectionSelector()),
              const SizedBox(width: 8),
              IconButton.filledTonal(
                tooltip: 'Nova coleção',
                onPressed: _saving ? null : _createCollectionDialog,
                icon: const Icon(Icons.create_new_folder_outlined),
              ),
            ],
          ),
          const SizedBox(height: 10),
          LayoutBuilder(
            builder: (context, constraints) {
              final liveButton = FilledButton.icon(
                onPressed: canScan
                    ? () => _scanLoopActive
                        ? unawaited(_pauseLiveScan())
                        : unawaited(_startLiveScan())
                    : null,
                icon: Icon(
                  _scanLoopActive
                      ? Icons.pause_rounded
                      : Icons.center_focus_strong_rounded,
                ),
                label: FittedBox(
                  fit: BoxFit.scaleDown,
                  child: Text(_scanLoopActive ? 'Pausar' : 'Live scan'),
                ),
              );
              final saveButton = OutlinedButton.icon(
                onPressed:
                    _buffer.isEmpty || _saving ? null : _saveBufferedCards,
                style: OutlinedButton.styleFrom(
                  foregroundColor: scheme.secondary,
                ),
                icon: _saving
                    ? const SizedBox.square(
                        dimension: 18,
                        child: CircularProgressIndicator(strokeWidth: 2),
                      )
                    : const Icon(Icons.library_add_check_outlined),
                label: FittedBox(
                  fit: BoxFit.scaleDown,
                  child: Text('Salvar ($_totalBuffered)'),
                ),
              );
              if (constraints.maxWidth < 340) {
                return Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    liveButton,
                    const SizedBox(height: 8),
                    saveButton,
                  ],
                );
              }
              return Row(
                children: [
                  Expanded(child: liveButton),
                  const SizedBox(width: 10),
                  Expanded(child: saveButton),
                ],
              );
            },
          ),
        ],
      ),
    );
  }

  Widget _buildCollectionSelector() {
    return StreamBuilder<List<Collection>>(
      stream: appDb.collectionDao.watchCollections(),
      builder: (context, snapshot) {
        final collections = snapshot.data ?? const <Collection>[];
        if (collections.isEmpty) {
          return OutlinedButton.icon(
            onPressed: _saving ? null : _createCollectionDialog,
            icon: const Icon(Icons.create_new_folder_outlined),
            label: const Text('Criar coleção'),
          );
        }

        final selected = collections.any((c) => c.id == _selectedCollectionId)
            ? _selectedCollectionId
            : collections.first.id;
        if (_selectedCollectionId != selected) {
          WidgetsBinding.instance.addPostFrameCallback((_) {
            if (mounted) setState(() => _selectedCollectionId = selected);
          });
        }

        return DropdownButtonFormField<String>(
          initialValue: selected,
          isExpanded: true,
          decoration: const InputDecoration(
            labelText: 'Salvar em',
            prefixIcon: Icon(Icons.folder_special_outlined),
          ),
          items: collections
              .map(
                (collection) => DropdownMenuItem(
                  value: collection.id,
                  child: Text(
                    collection.name,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                  ),
                ),
              )
              .toList(),
          onChanged: _saving
              ? null
              : (value) => setState(() => _selectedCollectionId = value),
        );
      },
    );
  }

  Widget _buildBufferPanel(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    if (_buffer.isEmpty) {
      return ManaSurfaceCard(
        padding: const EdgeInsets.all(16),
        child: Row(
          children: [
            Icon(Icons.style_outlined, color: scheme.primary, size: 34),
            const SizedBox(width: 12),
            Expanded(
              child: Text(
                _restoringBuffer
                    ? 'Restaurando sessão de scan...'
                    : 'As cartas reconhecidas ficam aqui antes de serem salvas.',
                style: Theme.of(context).textTheme.bodyMedium?.copyWith(
                      color: scheme.onSurfaceVariant,
                      fontWeight: FontWeight.w600,
                    ),
              ),
            ),
          ],
        ),
      );
    }

    return ListView.separated(
      scrollDirection: Axis.horizontal,
      itemCount: _buffer.length,
      separatorBuilder: (_, __) => const SizedBox(width: 10),
      itemBuilder: (context, index) {
        final entry = _buffer[index];
        return SizedBox(
          width: 286,
          child: ScanBufferTile(
            entry: entry,
            onTap: () => _openBufferEntryEditor(entry),
            onRemove: () => _removeBufferedEntry(entry),
            onIncrement: () =>
                _setBufferedEntryQuantity(entry, entry.quantity + 1),
            onDecrement: () =>
                _setBufferedEntryQuantity(entry, entry.quantity - 1),
          ),
        );
      },
    );
  }

  String _cameraErrorMessage(CameraException error) {
    switch (error.code) {
      case 'CameraAccessDenied':
      case 'CameraAccessDeniedWithoutPrompt':
      case 'CameraAccessRestricted':
        return 'Permissão da câmera negada. Ative a permissão e tente novamente.';
      default:
        return 'Não foi possível abrir a câmera: ${error.description ?? error.code}';
    }
  }

  String _normalizedCardName(String value) {
    return value.toLowerCase().replaceAll(RegExp(r'[^a-z0-9]'), '');
  }

  double _nameSimilarity(String left, String right) {
    if (left.isEmpty || right.isEmpty) return 0;
    final distance = _levenshteinDistance(left, right);
    final maxLength = left.length > right.length ? left.length : right.length;
    return 1 - (distance / maxLength.clamp(1, 9999));
  }

  int _levenshteinDistance(String left, String right) {
    if ((left.length - right.length).abs() > 6) {
      return left.length > right.length ? left.length : right.length;
    }
    final previous = List<int>.generate(right.length + 1, (index) => index);
    final current = List<int>.filled(right.length + 1, 0);
    for (var i = 1; i <= left.length; i++) {
      current[0] = i;
      for (var j = 1; j <= right.length; j++) {
        final cost = left[i - 1] == right[j - 1] ? 0 : 1;
        current[j] = [
          current[j - 1] + 1,
          previous[j] + 1,
          previous[j - 1] + cost,
        ].reduce((a, b) => a < b ? a : b);
      }
      previous.setAll(0, current);
    }
    return previous[right.length];
  }
}
