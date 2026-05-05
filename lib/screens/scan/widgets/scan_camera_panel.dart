import 'dart:math' as math;

import 'package:camera/camera.dart';
import 'package:flutter/material.dart';

import '../../../data/scan/live_scan_frame_cropper.dart';
import '../../../data/scan/scan_models.dart';

class ScanCameraPanel extends StatelessWidget {
  const ScanCameraPanel({
    super.key,
    required this.controller,
    required this.cameraLoading,
    required this.scanLoopActive,
    required this.showSuccessFrame,
    required this.status,
    this.error,
    this.liveCandidate,
    this.bufferCount = 0,
    this.catalogReady = false,
    this.confirmationsSeen = 0,
    this.confirmationsRequired = 0,
  });

  final CameraController? controller;
  final bool cameraLoading;
  final bool scanLoopActive;
  final bool showSuccessFrame;
  final String status;
  final String? error;
  final ScanRecognitionCandidate? liveCandidate;
  final int bufferCount;
  final bool catalogReady;
  final int confirmationsSeen;
  final int confirmationsRequired;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final initialized = controller != null && controller!.value.isInitialized;

    return ClipRRect(
      borderRadius: BorderRadius.circular(24),
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: Colors.black,
          border: Border.all(
            color: showSuccessFrame
                ? const Color(0xFF31E981)
                : scheme.outlineVariant.withValues(alpha: 0.48),
            width: showSuccessFrame ? 2.5 : 1,
          ),
        ),
        child: Stack(
          fit: StackFit.expand,
          children: [
            if (initialized)
              _LiveCameraPreview(controller: controller!)
            else
              Center(
                child: cameraLoading
                    ? const CircularProgressIndicator()
                    : Icon(
                        Icons.no_photography_outlined,
                        color: scheme.onSurfaceVariant,
                        size: 48,
                      ),
              ),
            if (initialized)
              _ScanFrameOverlay(
                controller: controller!,
                isScanning: scanLoopActive,
                isMatched: showSuccessFrame,
              ),
            Positioned(
              left: 12,
              right: 12,
              top: 12,
              child: Row(
                children: [
                  Expanded(
                    child: _HudPill(
                      icon: catalogReady
                          ? Icons.offline_pin_outlined
                          : Icons.cloud_off_outlined,
                      label: catalogReady ? 'offline ok' : 'catálogo pendente',
                      color: catalogReady
                          ? const Color(0xFF50FA7B)
                          : scheme.secondary,
                    ),
                  ),
                  const SizedBox(width: 8),
                  Expanded(
                    child: _HudPill(
                      icon: Icons.style_outlined,
                      label: '$bufferCount no buffer',
                      color: scheme.tertiary,
                    ),
                  ),
                ],
              ),
            ),
            if (liveCandidate != null)
              Positioned(
                left: 14,
                right: 14,
                bottom: 70,
                child: _CandidateBadge(
                  candidate: liveCandidate!,
                  confirmationsSeen: confirmationsSeen,
                  confirmationsRequired: confirmationsRequired,
                ),
              ),
            Positioned(
              left: 12,
              right: 12,
              bottom: 12,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: Colors.black.withValues(alpha: 0.66),
                  borderRadius: BorderRadius.circular(16),
                  border: Border.all(
                    color: Colors.white.withValues(alpha: 0.10),
                  ),
                ),
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 12,
                    vertical: 10,
                  ),
                  child: Text(
                    error ?? status,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.bodySmall?.copyWith(
                          color: error == null
                              ? Colors.white
                              : scheme.errorContainer,
                          fontWeight: FontWeight.w800,
                        ),
                  ),
                ),
              ),
            ),
            if (scanLoopActive)
              Positioned(
                left: 0,
                right: 0,
                top: 0,
                child: LinearProgressIndicator(
                  minHeight: 3,
                  color: scheme.primary,
                  backgroundColor: Colors.transparent,
                ),
              ),
          ],
        ),
      ),
    );
  }
}

class _HudPill extends StatelessWidget {
  const _HudPill({
    required this.icon,
    required this.label,
    required this.color,
  });

  final IconData icon;
  final String label;
  final Color color;

  @override
  Widget build(BuildContext context) {
    return DecoratedBox(
      decoration: BoxDecoration(
        color: Colors.black.withValues(alpha: 0.62),
        borderRadius: BorderRadius.circular(999),
        border: Border.all(color: color.withValues(alpha: 0.42)),
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 7),
        child: Row(
          children: [
            Icon(icon, size: 16, color: color),
            const SizedBox(width: 6),
            Expanded(
              child: Text(
                label,
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                style: Theme.of(context).textTheme.labelSmall?.copyWith(
                      color: Colors.white,
                      fontWeight: FontWeight.w900,
                    ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _CandidateBadge extends StatelessWidget {
  const _CandidateBadge({
    required this.candidate,
    required this.confirmationsSeen,
    required this.confirmationsRequired,
  });

  final ScanRecognitionCandidate candidate;
  final int confirmationsSeen;
  final int confirmationsRequired;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final score = candidate.score.clamp(0, 1).toDouble();
    final accent = score >= 0.82 ? const Color(0xFF50FA7B) : scheme.secondary;
    final seen = confirmationsSeen.clamp(0, confirmationsRequired);
    final confirmationLabel = confirmationsRequired <= 0
        ? 'analisando'
        : '$seen/$confirmationsRequired frames';

    return DecoratedBox(
      decoration: BoxDecoration(
        color: Colors.black.withValues(alpha: 0.76),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: accent.withValues(alpha: 0.46)),
        boxShadow: [
          BoxShadow(
            color: accent.withValues(alpha: 0.16),
            blurRadius: 22,
            spreadRadius: 1,
          ),
        ],
      ),
      child: Padding(
        padding: const EdgeInsets.fromLTRB(12, 10, 10, 10),
        child: Row(
          children: [
            Icon(Icons.center_focus_strong_rounded, color: accent, size: 24),
            const SizedBox(width: 10),
            Expanded(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    candidate.name,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.titleSmall?.copyWith(
                          color: Colors.white,
                          fontWeight: FontWeight.w900,
                        ),
                  ),
                  const SizedBox(height: 2),
                  Text(
                    '${candidate.editionLabel} · $confirmationLabel',
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.labelSmall?.copyWith(
                          color: Colors.white.withValues(alpha: 0.72),
                          fontWeight: FontWeight.w700,
                        ),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 8),
            DecoratedBox(
              decoration: BoxDecoration(
                color: accent.withValues(alpha: 0.16),
                borderRadius: BorderRadius.circular(10),
              ),
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 9, vertical: 6),
                child: Text(
                  '${(score * 100).round()}%',
                  style: Theme.of(context).textTheme.labelSmall?.copyWith(
                        color: accent,
                        fontWeight: FontWeight.w900,
                      ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _LiveCameraPreview extends StatelessWidget {
  const _LiveCameraPreview({required this.controller});

  final CameraController controller;

  @override
  Widget build(BuildContext context) {
    final previewSize = controller.value.previewSize;
    if (previewSize == null) {
      return CameraPreview(controller);
    }

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

class _ScanFrameOverlay extends StatelessWidget {
  const _ScanFrameOverlay({
    required this.controller,
    required this.isScanning,
    required this.isMatched,
  });

  final CameraController controller;
  final bool isScanning;
  final bool isMatched;

  @override
  Widget build(BuildContext context) {
    final color = isMatched
        ? const Color(0xFF31E981)
        : Colors.white.withValues(alpha: isScanning ? 0.92 : 0.72);
    return IgnorePointer(
      child: LayoutBuilder(
        builder: (context, constraints) {
          final rect = _mappedGuideRect(context, constraints.biggest);
          return Stack(
            fit: StackFit.expand,
            clipBehavior: Clip.hardEdge,
            children: [
              Positioned(
                left: rect.left,
                top: rect.top,
                width: rect.width,
                height: rect.height,
                child: DecoratedBox(
                  decoration: BoxDecoration(
                    color: Colors.white.withValues(alpha: 0.03),
                    borderRadius: BorderRadius.circular(18),
                    border: Border.all(
                      color: color,
                      width: isMatched ? 3 : 2,
                    ),
                    boxShadow: [
                      if (isMatched)
                        BoxShadow(
                          color: color.withValues(alpha: 0.45),
                          blurRadius: 26,
                          spreadRadius: 2,
                        ),
                    ],
                  ),
                  child: CustomPaint(
                    painter: _CornerGuidePainter(color: color),
                  ),
                ),
              ),
            ],
          );
        },
      ),
    );
  }

  Rect _mappedGuideRect(BuildContext context, Size panelSize) {
    final previewSize = controller.value.previewSize;
    if (previewSize == null || panelSize.isEmpty) {
      final guide = LiveScanFrameCropper.cardGuideForUprightFrame(
        width: panelSize.width,
        height: panelSize.height,
      );
      return Rect.fromLTWH(guide.left, guide.top, guide.width, guide.height);
    }

    final isPortrait =
        MediaQuery.orientationOf(context) == Orientation.portrait;
    final uprightWidth = isPortrait ? previewSize.height : previewSize.width;
    final uprightHeight = isPortrait ? previewSize.width : previewSize.height;
    final guide = LiveScanFrameCropper.cardGuideForUprightFrame(
      width: uprightWidth,
      height: uprightHeight,
    );

    final scale = math.max(
      panelSize.width / uprightWidth,
      panelSize.height / uprightHeight,
    );
    final renderedWidth = uprightWidth * scale;
    final renderedHeight = uprightHeight * scale;
    final dx = (panelSize.width - renderedWidth) / 2;
    final dy = (panelSize.height - renderedHeight) / 2;

    return Rect.fromLTWH(
      dx + (guide.left * scale),
      dy + (guide.top * scale),
      guide.width * scale,
      guide.height * scale,
    );
  }
}

class _CornerGuidePainter extends CustomPainter {
  const _CornerGuidePainter({required this.color});

  final Color color;

  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = color
      ..strokeWidth = 5
      ..style = PaintingStyle.stroke
      ..strokeCap = StrokeCap.round;
    const corner = 34.0;
    const inset = 2.5;
    canvas.drawLine(
        const Offset(inset, inset), const Offset(corner, inset), paint);
    canvas.drawLine(
        const Offset(inset, inset), const Offset(inset, corner), paint);
    canvas.drawLine(
      Offset(size.width - inset, inset),
      Offset(size.width - corner, inset),
      paint,
    );
    canvas.drawLine(
      Offset(size.width - inset, inset),
      Offset(size.width - inset, corner),
      paint,
    );
    canvas.drawLine(
      Offset(inset, size.height - inset),
      Offset(corner, size.height - inset),
      paint,
    );
    canvas.drawLine(
      Offset(inset, size.height - inset),
      Offset(inset, size.height - corner),
      paint,
    );
    canvas.drawLine(
      Offset(size.width - inset, size.height - inset),
      Offset(size.width - corner, size.height - inset),
      paint,
    );
    canvas.drawLine(
      Offset(size.width - inset, size.height - inset),
      Offset(size.width - inset, size.height - corner),
      paint,
    );
  }

  @override
  bool shouldRepaint(covariant _CornerGuidePainter oldDelegate) {
    return oldDelegate.color != color;
  }
}
