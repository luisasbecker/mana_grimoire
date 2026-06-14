import 'package:flutter/material.dart';

import 'game_action_button.dart';

class SurfaceCalibrationOverlay extends StatelessWidget {
  const SurfaceCalibrationOverlay({
    super.key,
    required this.cameraReady,
    required this.onBeginCalibration,
    required this.onCompleteCalibration,
    required this.calibrating,
  });

  final bool cameraReady;
  final bool calibrating;
  final VoidCallback onBeginCalibration;
  final VoidCallback onCompleteCalibration;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final title = calibrating ? 'Superfície alinhada?' : 'Escanear mesa';
    final subtitle = calibrating
        ? 'Mantenha as cartas dentro da área iluminada e confirme.'
        : 'Faça uma leitura rápida da superfície antes de rastrear cartas.';
    return Positioned.fill(
      child: ColoredBox(
        color: Colors.black.withValues(alpha: 0.36),
        child: Padding(
          padding: const EdgeInsets.all(18),
          child: Column(
            children: [
              const Spacer(),
              Expanded(
                flex: 4,
                child: CustomPaint(
                  painter: _CalibrationGridPainter(
                    color: scheme.primary.withValues(alpha: 0.78),
                  ),
                  child: const SizedBox.expand(),
                ),
              ),
              const SizedBox(height: 18),
              DecoratedBox(
                decoration: BoxDecoration(
                  color: Colors.black.withValues(alpha: 0.70),
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(
                    color: scheme.primary.withValues(alpha: 0.36),
                  ),
                ),
                child: Padding(
                  padding: const EdgeInsets.all(14),
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        title,
                        textAlign: TextAlign.center,
                        style:
                            Theme.of(context).textTheme.titleMedium?.copyWith(
                                  color: Colors.white,
                                  fontWeight: FontWeight.w900,
                                ),
                      ),
                      const SizedBox(height: 6),
                      Text(
                        subtitle,
                        textAlign: TextAlign.center,
                        style: Theme.of(context).textTheme.bodySmall?.copyWith(
                              color: Colors.white.withValues(alpha: 0.76),
                              fontWeight: FontWeight.w600,
                            ),
                      ),
                      const SizedBox(height: 12),
                      GameActionButton(
                        filled: true,
                        icon: calibrating
                            ? Icons.check_circle_outline
                            : Icons.grid_on_rounded,
                        label: calibrating ? 'Confirmar mesa' : 'Calibrar',
                        onPressed: cameraReady
                            ? calibrating
                                ? onCompleteCalibration
                                : onBeginCalibration
                            : null,
                      ),
                    ],
                  ),
                ),
              ),
              const Spacer(flex: 2),
            ],
          ),
        ),
      ),
    );
  }
}

class _CalibrationGridPainter extends CustomPainter {
  const _CalibrationGridPainter({required this.color});

  final Color color;

  @override
  void paint(Canvas canvas, Size size) {
    if (size.isEmpty) return;
    final rect = Rect.fromCenter(
      center: Offset(size.width / 2, size.height / 2),
      width: size.width * 0.86,
      height: size.height * 0.68,
    );
    final paint = Paint()
      ..color = color
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.6;
    final fillPaint = Paint()
      ..color = color.withValues(alpha: 0.05)
      ..style = PaintingStyle.fill;
    canvas.drawRRect(
      RRect.fromRectAndRadius(rect, const Radius.circular(24)),
      fillPaint,
    );
    canvas.drawRRect(
      RRect.fromRectAndRadius(rect, const Radius.circular(24)),
      paint,
    );
    for (var i = 1; i < 4; i++) {
      final x = rect.left + rect.width * (i / 4);
      canvas.drawLine(Offset(x, rect.top), Offset(x, rect.bottom), paint);
    }
    for (var i = 1; i < 3; i++) {
      final y = rect.top + rect.height * (i / 3);
      canvas.drawLine(Offset(rect.left, y), Offset(rect.right, y), paint);
    }
  }

  @override
  bool shouldRepaint(covariant _CalibrationGridPainter oldDelegate) {
    return oldDelegate.color != color;
  }
}
