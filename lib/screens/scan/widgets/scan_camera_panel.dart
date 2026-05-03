import 'package:camera/camera.dart';
import 'package:flutter/material.dart';

class ScanCameraPanel extends StatelessWidget {
  const ScanCameraPanel({
    super.key,
    required this.controller,
    required this.cameraLoading,
    required this.scanLoopActive,
    required this.showSuccessFrame,
    required this.status,
    this.error,
  });

  final CameraController? controller;
  final bool cameraLoading;
  final bool scanLoopActive;
  final bool showSuccessFrame;
  final String status;
  final String? error;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final initialized = controller != null && controller!.value.isInitialized;

    return ClipRRect(
      borderRadius: BorderRadius.circular(18),
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: Colors.black,
          border: Border.all(
            color: showSuccessFrame
                ? const Color(0xFF31E981)
                : scheme.outlineVariant.withValues(alpha: 0.55),
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
                isScanning: scanLoopActive,
                isMatched: showSuccessFrame,
              ),
            Positioned(
              left: 12,
              right: 12,
              bottom: 12,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: Colors.black.withValues(alpha: 0.62),
                  borderRadius: BorderRadius.circular(14),
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
    required this.isScanning,
    required this.isMatched,
  });

  final bool isScanning;
  final bool isMatched;

  @override
  Widget build(BuildContext context) {
    final color = isMatched
        ? const Color(0xFF31E981)
        : Colors.white.withValues(alpha: isScanning ? 0.92 : 0.72);
    return IgnorePointer(
      child: Center(
        child: FractionallySizedBox(
          widthFactor: 0.72,
          heightFactor: 0.78,
          child: DecoratedBox(
            decoration: BoxDecoration(
              color: Colors.white.withValues(alpha: 0.03),
              borderRadius: BorderRadius.circular(18),
              border: Border.all(color: color, width: isMatched ? 3 : 2),
              boxShadow: [
                if (isMatched)
                  BoxShadow(
                    color: color.withValues(alpha: 0.45),
                    blurRadius: 26,
                    spreadRadius: 2,
                  ),
              ],
            ),
            child: CustomPaint(painter: _CornerGuidePainter(color: color)),
          ),
        ),
      ),
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
