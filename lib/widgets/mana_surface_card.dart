import 'package:flutter/material.dart';

/// Cartão com superfície elevada e cantos arredondados.
class ManaSurfaceCard extends StatelessWidget {
  const ManaSurfaceCard({
    super.key,
    required this.child,
    this.onTap,
    this.padding = const EdgeInsets.all(14),
  });

  final Widget child;
  final VoidCallback? onTap;
  final EdgeInsetsGeometry padding;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final shape = RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(16),
      side: BorderSide(
        color: scheme.outlineVariant.withValues(alpha: 0.25),
      ),
    );

    final content = Padding(padding: padding, child: child);

    if (onTap == null) {
      return Material(
        color: scheme.surfaceContainerHigh,
        elevation: 0,
        shape: shape,
        clipBehavior: Clip.antiAlias,
        child: content,
      );
    }

    return Material(
      color: scheme.surfaceContainerHigh,
      elevation: 0,
      shape: shape,
      clipBehavior: Clip.antiAlias,
      child: InkWell(
        onTap: onTap,
        borderRadius: BorderRadius.circular(16),
        child: content,
      ),
    );
  }
}
