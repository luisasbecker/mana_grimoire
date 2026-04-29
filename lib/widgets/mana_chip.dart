import 'package:flutter/material.dart';

enum ManaChipTone { neutral, primary, gold, blue }

class ManaChip extends StatelessWidget {
  const ManaChip({
    super.key,
    required this.label,
    this.tone = ManaChipTone.neutral,
    this.compact = true,
  });

  final String label;
  final ManaChipTone tone;
  final bool compact;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final (Color bg, Color fg) = switch (tone) {
      ManaChipTone.primary => (
          scheme.primary.withOpacity(0.22),
          scheme.primary,
        ),
      ManaChipTone.gold => (
          const Color(0xFFC9A227).withOpacity(0.2),
          const Color(0xFFE8D48B),
        ),
      ManaChipTone.blue => (
          scheme.secondary.withOpacity(0.22),
          scheme.secondary,
        ),
      ManaChipTone.neutral => (
          scheme.surfaceContainerHighest.withOpacity(0.65),
          scheme.onSurfaceVariant,
        ),
    };

    return Container(
      padding: EdgeInsets.symmetric(
        horizontal: compact ? 8 : 10,
        vertical: compact ? 4 : 6,
      ),
      decoration: BoxDecoration(
        color: bg,
        borderRadius: BorderRadius.circular(8),
        border: Border.all(color: fg.withOpacity(0.25)),
      ),
      child: Text(
        label,
        style: TextStyle(
          fontSize: compact ? 11 : 12,
          fontWeight: FontWeight.w600,
          color: fg,
          letterSpacing: 0.2,
        ),
      ),
    );
  }
}
