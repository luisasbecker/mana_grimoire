import 'package:flutter/material.dart';

class GameActionButton extends StatelessWidget {
  const GameActionButton({
    super.key,
    required this.icon,
    required this.label,
    required this.onPressed,
    this.filled = false,
    this.danger = false,
  });

  final IconData icon;
  final String label;
  final VoidCallback? onPressed;
  final bool filled;
  final bool danger;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final foreground = danger ? scheme.error : null;
    final child = FittedBox(
      fit: BoxFit.scaleDown,
      child: Text(label),
    );

    if (filled) {
      return FilledButton.icon(
        onPressed: onPressed,
        style: danger
            ? FilledButton.styleFrom(
                backgroundColor: scheme.errorContainer,
                foregroundColor: scheme.onErrorContainer,
              )
            : null,
        icon: Icon(icon),
        label: child,
      );
    }

    return OutlinedButton.icon(
      onPressed: onPressed,
      style: OutlinedButton.styleFrom(foregroundColor: foreground),
      icon: Icon(icon),
      label: child,
    );
  }
}
