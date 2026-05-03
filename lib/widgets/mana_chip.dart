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
          scheme.primary.withValues(alpha: 0.22),
          scheme.primary,
        ),
      ManaChipTone.gold => (
          const Color(0xFFC9A227).withValues(alpha: 0.2),
          const Color(0xFFE8D48B),
        ),
      ManaChipTone.blue => (
          scheme.secondary.withValues(alpha: 0.22),
          scheme.secondary,
        ),
      ManaChipTone.neutral => (
          scheme.surfaceContainerHighest.withValues(alpha: 0.65),
          scheme.onSurfaceVariant,
        ),
    };

    final maxChipWidth = (MediaQuery.sizeOf(context).width - 48)
        .clamp(96.0, compact ? 220.0 : 280.0);

    return ConstrainedBox(
      constraints: BoxConstraints(maxWidth: maxChipWidth),
      child: Container(
        padding: EdgeInsets.symmetric(
          horizontal: compact ? 8 : 10,
          vertical: compact ? 4 : 6,
        ),
        decoration: BoxDecoration(
          color: bg,
          borderRadius: BorderRadius.circular(8),
          border: Border.all(color: fg.withValues(alpha: 0.25)),
        ),
        child: Text(
          label,
          maxLines: 1,
          overflow: TextOverflow.ellipsis,
          style: TextStyle(
            fontSize: compact ? 11 : 12,
            fontWeight: FontWeight.w600,
            color: fg,
            letterSpacing: 0.2,
          ),
        ),
      ),
    );
  }
}
