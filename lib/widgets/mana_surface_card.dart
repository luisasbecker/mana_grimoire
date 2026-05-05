import 'package:flutter/material.dart';

/// Cartão com superfície elevada e cantos arredondados.
class ManaSurfaceCard extends StatelessWidget {
  const ManaSurfaceCard({
    super.key,
    required this.child,
    this.onTap,
    this.padding = const EdgeInsets.all(14),
    this.borderColor,
    this.backgroundColor,
  });

  final Widget child;
  final VoidCallback? onTap;
  final EdgeInsetsGeometry padding;
  final Color? borderColor;
  final Color? backgroundColor;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final radius = BorderRadius.circular(18);
    final shape = RoundedRectangleBorder(
      borderRadius: radius,
      side: BorderSide(
        color: borderColor ?? scheme.outlineVariant.withValues(alpha: 0.28),
      ),
    );

    final content = Padding(padding: padding, child: child);
    final material = Material(
      color: backgroundColor ?? scheme.surfaceContainerHigh,
      elevation: 0,
      shape: shape,
      clipBehavior: Clip.antiAlias,
      child: onTap == null
          ? content
          : InkWell(
              onTap: onTap,
              borderRadius: radius,
              child: content,
            ),
    );

    return DecoratedBox(
      decoration: BoxDecoration(
        borderRadius: radius,
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.10),
            blurRadius: 18,
            offset: const Offset(0, 10),
          ),
        ],
      ),
      child: material,
    );
  }
}
