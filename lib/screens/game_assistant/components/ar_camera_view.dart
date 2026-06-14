import 'dart:async';
import 'dart:io';
import 'dart:math' as math;

import 'package:camera/camera.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import '../../../data/scan/scan_models.dart';
import '../screens/camera_permission_screen.dart';
import '../services/card_recognition_service.dart';
import '../types/game_assistant_types.dart';
import 'floating_card_panel.dart';
import 'surface_calibration_overlay.dart';

typedef CardMoveCallback = void Function(String cardId, Offset position);
typedef TableTapCallback = void Function(Offset position);

class ARCameraView extends StatefulWidget {
  const ARCameraView({
    super.key,
    required this.state,
    required this.recognitionService,
    required this.onCameraReady,
    required this.onCameraUnavailable,
    required this.onStatus,
    required this.onCardRecognized,
    required this.onSelectCard,
    required this.onMoveCard,
    required this.onDeselectCard,
    required this.onAddManualCardAt,
    required this.onBeginCalibration,
    required this.onCompleteCalibration,
    this.statusBottomInset = 12,
  });

  final GameAssistantState state;
  final GameAssistantCardRecognitionService recognitionService;
  final VoidCallback onCameraReady;
  final ValueChanged<String> onCameraUnavailable;
  final ValueChanged<String> onStatus;
  final ValueChanged<ScanRecognitionCandidate> onCardRecognized;
  final ValueChanged<String> onSelectCard;
  final CardMoveCallback onMoveCard;
  final VoidCallback onDeselectCard;
  final TableTapCallback onAddManualCardAt;
  final VoidCallback onBeginCalibration;
  final VoidCallback onCompleteCalibration;
  final double statusBottomInset;

  @override
  State<ARCameraView> createState() => _ARCameraViewState();
}

class _ARCameraViewState extends State<ARCameraView> {
  static const Duration _frameThrottle = Duration(milliseconds: 650);
  static const Duration _sameCardCooldown = Duration(seconds: 5);

  CameraController? _cameraController;
  bool _loading = true;
  bool _processingFrame = false;
  DateTime? _lastFrameProcessedAt;
  DateTime? _lastRecognitionAt;
  String? _lastRecognizedPrintingId;
  String? _cameraError;

  bool get _cameraSupported {
    if (kIsWeb) return false;
    return defaultTargetPlatform == TargetPlatform.android ||
        defaultTargetPlatform == TargetPlatform.iOS;
  }

  @override
  void initState() {
    super.initState();
    unawaited(_initializeCamera());
  }

  @override
  void didUpdateWidget(covariant ARCameraView oldWidget) {
    super.didUpdateWidget(oldWidget);
    if (widget.state.isScanning && !oldWidget.state.isScanning) {
      unawaited(_startImageStream());
    } else if (!widget.state.isScanning && oldWidget.state.isScanning) {
      unawaited(_stopImageStream());
    }
  }

  @override
  void dispose() {
    unawaited(_stopImageStream());
    unawaited(_cameraController?.dispose());
    super.dispose();
  }

  Future<void> _initializeCamera() async {
    if (!_cameraSupported) {
      const message = 'Use Android ou iOS com câmera para abrir o assistente.';
      setState(() {
        _loading = false;
        _cameraError = message;
      });
      widget.onCameraUnavailable(message);
      return;
    }

    setState(() {
      _loading = true;
      _cameraError = null;
    });

    try {
      final cameras = await availableCameras();
      if (cameras.isEmpty) {
        throw CameraException(
          'NoCamera',
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
        // Nem todos os aparelhos expõem controles de foco/exposição no stream.
      }
      if (!mounted) {
        await controller.dispose();
        return;
      }
      setState(() {
        _cameraController = controller;
        _loading = false;
      });
      widget.onCameraReady();
      if (widget.state.isScanning) {
        unawaited(_startImageStream());
      }
    } on CameraException catch (error) {
      if (!mounted) return;
      final message = _cameraErrorMessage(error);
      setState(() {
        _loading = false;
        _cameraError = message;
      });
      widget.onCameraUnavailable(message);
    } catch (error) {
      if (!mounted) return;
      final message = 'Não foi possível abrir a câmera: $error';
      setState(() {
        _loading = false;
        _cameraError = message;
      });
      widget.onCameraUnavailable(message);
    }
  }

  Future<void> _startImageStream() async {
    final controller = _cameraController;
    if (controller == null ||
        !controller.value.isInitialized ||
        controller.value.isStreamingImages) {
      return;
    }
    if (!widget.state.surfaceCalibrated) return;
    final ready = await widget.recognitionService.ensureReady();
    if (!ready) {
      widget.onStatus('Atualize o catálogo no Scan antes da detecção offline.');
      return;
    }
    await controller.startImageStream(_processImage);
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

  Future<void> _processImage(CameraImage image) async {
    final controller = _cameraController;
    if (controller == null ||
        !widget.state.isScanning ||
        _processingFrame ||
        !controller.value.isInitialized) {
      return;
    }
    final now = DateTime.now();
    final lastFrame = _lastFrameProcessedAt;
    if (lastFrame != null && now.difference(lastFrame) < _frameThrottle) {
      return;
    }
    _lastFrameProcessedAt = now;
    _processingFrame = true;
    try {
      final snapshot = await widget.recognitionService.recognizeCameraImage(
        image: image,
        camera: controller.description,
        deviceOrientation: controller.value.deviceOrientation,
      );
      final candidate = snapshot.candidate;
      if (candidate != null && _shouldEmitCandidate(candidate, now)) {
        _lastRecognizedPrintingId = candidate.printingId;
        _lastRecognitionAt = now;
        widget.onCardRecognized(candidate);
      } else if (snapshot.message != null) {
        widget.onStatus(snapshot.message!);
      }
    } catch (_) {
      widget.onStatus('Analisando o campo...');
    } finally {
      _processingFrame = false;
    }
  }

  bool _shouldEmitCandidate(ScanRecognitionCandidate candidate, DateTime now) {
    if (_lastRecognizedPrintingId != candidate.printingId) return true;
    final lastSeen = _lastRecognitionAt;
    if (lastSeen == null) return true;
    return now.difference(lastSeen) >= _sameCardCooldown;
  }

  @override
  Widget build(BuildContext context) {
    final error = _cameraError;
    if (error != null) {
      return CameraPermissionScreen(
        message: error,
        onRetry: _initializeCamera,
      );
    }

    return ClipRRect(
      borderRadius: BorderRadius.circular(0),
      child: DecoratedBox(
        decoration: const BoxDecoration(color: Colors.black),
        child: Stack(
          fit: StackFit.expand,
          children: [
            if (_cameraController?.value.isInitialized ?? false)
              _LiveCameraPreview(controller: _cameraController!)
            else
              Center(
                child: _loading
                    ? const CircularProgressIndicator()
                    : const Icon(Icons.no_photography_outlined, size: 48),
              ),
            _FieldOverlay(
              state: widget.state,
              onSelectCard: widget.onSelectCard,
              onMoveCard: widget.onMoveCard,
              onDeselectCard: widget.onDeselectCard,
              onAddManualCardAt: widget.onAddManualCardAt,
            ),
            if (!widget.state.surfaceCalibrated)
              SurfaceCalibrationOverlay(
                cameraReady: widget.state.cameraReady,
                calibrating:
                    widget.state.phase == GameAssistantPhase.calibrating,
                onBeginCalibration: widget.onBeginCalibration,
                onCompleteCalibration: widget.onCompleteCalibration,
              ),
            if (widget.state.surfaceCalibrated)
              Positioned(
                left: 12,
                right: 12,
                bottom: widget.statusBottomInset,
                child: _StatusPill(
                  status: widget.state.statusMessage,
                  scanning: widget.state.isScanning,
                ),
              ),
          ],
        ),
      ),
    );
  }

  String _cameraErrorMessage(CameraException error) {
    return switch (error.code) {
      'CameraAccessDenied' ||
      'CameraAccessDeniedWithoutPrompt' ||
      'CameraAccessRestricted' =>
        'Permissão da câmera negada. Ative a permissão e tente novamente.',
      _ => error.description == null
          ? 'Não foi possível abrir a câmera.'
          : 'Não foi possível abrir a câmera: ${error.description}',
    };
  }
}

class _LiveCameraPreview extends StatelessWidget {
  const _LiveCameraPreview({required this.controller});

  final CameraController controller;

  @override
  Widget build(BuildContext context) {
    final previewSize = controller.value.previewSize;
    if (previewSize == null) return CameraPreview(controller);

    final isPortrait =
        MediaQuery.orientationOf(context) == Orientation.portrait;
    final width = isPortrait ? previewSize.height : previewSize.width;
    final height = isPortrait ? previewSize.width : previewSize.height;

    return ClipRect(
      child: FittedBox(
        fit: BoxFit.cover,
        child: SizedBox(
          width: width,
          height: height,
          child: CameraPreview(controller),
        ),
      ),
    );
  }
}

class _FieldOverlay extends StatelessWidget {
  const _FieldOverlay({
    required this.state,
    required this.onSelectCard,
    required this.onMoveCard,
    required this.onDeselectCard,
    required this.onAddManualCardAt,
  });

  final GameAssistantState state;
  final ValueChanged<String> onSelectCard;
  final CardMoveCallback onMoveCard;
  final VoidCallback onDeselectCard;
  final TableTapCallback onAddManualCardAt;

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        return Stack(
          fit: StackFit.expand,
          children: [
            GestureDetector(
              behavior: HitTestBehavior.opaque,
              onTapDown: (details) => _handleTableTap(
                details: details,
                size: constraints.biggest,
              ),
              child: CustomPaint(
                painter: _TableScanPainter(
                  active: state.isScanning,
                  color: Theme.of(context).colorScheme.primary,
                ),
              ),
            ),
            for (final card in state.trackedCards)
              _PositionedCardPanel(
                card: card,
                selected: card.id == state.activeCard?.id,
                size: constraints.biggest,
                onTap: () => onSelectCard(card.id),
                onMove: onMoveCard,
              ),
          ],
        );
      },
    );
  }

  void _handleTableTap({
    required TapDownDetails details,
    required Size size,
  }) {
    if (state.activeCard != null) {
      onDeselectCard();
      return;
    }

    if (state.surfaceCalibrated && state.phase == GameAssistantPhase.paused) {
      onAddManualCardAt(
        Offset(
          (details.localPosition.dx / size.width).clamp(0, 1).toDouble(),
          (details.localPosition.dy / size.height).clamp(0, 1).toDouble(),
        ),
      );
      return;
    }

    onDeselectCard();
  }
}

class _PositionedCardPanel extends StatelessWidget {
  const _PositionedCardPanel({
    required this.card,
    required this.selected,
    required this.size,
    required this.onTap,
    required this.onMove,
  });

  final GameAssistantTrackedCard card;
  final bool selected;
  final Size size;
  final VoidCallback onTap;
  final CardMoveCallback onMove;

  @override
  Widget build(BuildContext context) {
    final width = selected ? 190.0 : 154.0;
    final height = selected ? 82.0 : 66.0;
    final left = (card.position.dx * size.width) - (width / 2);
    final top = (card.position.dy * size.height) - (height / 2);
    return Positioned(
      left: left.clamp(8.0, math.max(8.0, size.width - width - 8)),
      top: top.clamp(96.0, math.max(96.0, size.height - height - 82)),
      child: GestureDetector(
        behavior: HitTestBehavior.translucent,
        onPanStart: (_) => onTap(),
        onPanUpdate: (details) {
          onMove(
            card.id,
            Offset(
              (card.position.dx * size.width + details.delta.dx) / size.width,
              (card.position.dy * size.height + details.delta.dy) / size.height,
            ),
          );
        },
        child: FloatingCardPanel(
          card: card,
          selected: selected,
          onTap: onTap,
        ),
      ),
    );
  }
}

class _StatusPill extends StatelessWidget {
  const _StatusPill({
    required this.status,
    required this.scanning,
  });

  final String status;
  final bool scanning;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return DecoratedBox(
      decoration: BoxDecoration(
        color: Colors.black.withValues(alpha: 0.72),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(
          color: (scanning ? scheme.primary : scheme.outline)
              .withValues(alpha: 0.38),
        ),
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
        child: Row(
          children: [
            Icon(
              scanning
                  ? Icons.center_focus_strong_rounded
                  : Icons.pause_circle_outline,
              color: scanning ? scheme.primary : scheme.onSurfaceVariant,
              size: 18,
            ),
            const SizedBox(width: 8),
            Expanded(
              child: Text(
                status,
                maxLines: 2,
                overflow: TextOverflow.ellipsis,
                style: Theme.of(context).textTheme.bodySmall?.copyWith(
                      color: Colors.white,
                      fontWeight: FontWeight.w800,
                    ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _TableScanPainter extends CustomPainter {
  const _TableScanPainter({
    required this.active,
    required this.color,
  });

  final bool active;
  final Color color;

  @override
  void paint(Canvas canvas, Size size) {
    if (size.isEmpty) return;
    final center = Offset(size.width / 2, size.height / 2);
    final radius = math.min(size.width, size.height) * 0.38;
    final paint = Paint()
      ..color = color.withValues(alpha: active ? 0.18 : 0.08)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.4;
    canvas.drawCircle(center, radius, paint);
    canvas.drawCircle(center, radius * 0.62, paint);
    canvas.drawLine(
      Offset(center.dx - radius, center.dy),
      Offset(center.dx + radius, center.dy),
      paint,
    );
    canvas.drawLine(
      Offset(center.dx, center.dy - radius),
      Offset(center.dx, center.dy + radius),
      paint,
    );
  }

  @override
  bool shouldRepaint(covariant _TableScanPainter oldDelegate) {
    return oldDelegate.active != active || oldDelegate.color != color;
  }
}
