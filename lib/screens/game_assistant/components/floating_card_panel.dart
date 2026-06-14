import 'package:flutter/material.dart';

import '../../../widgets/cached_card_thumbnail.dart';
import '../../../widgets/mana_chip.dart';
import '../types/game_assistant_types.dart';
import 'ability_icon_strip.dart';

class FloatingCardPanel extends StatelessWidget {
  const FloatingCardPanel({
    super.key,
    required this.card,
    required this.selected,
    required this.onTap,
  });

  final GameAssistantTrackedCard card;
  final bool selected;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final accent = selected ? scheme.primary : scheme.secondary;
    return Material(
      color: Colors.transparent,
      child: InkWell(
        onTap: onTap,
        borderRadius: BorderRadius.circular(16),
        child: AnimatedContainer(
          duration: const Duration(milliseconds: 180),
          width: selected ? 190 : 154,
          padding: const EdgeInsets.all(8),
          decoration: BoxDecoration(
            color: Colors.black.withValues(alpha: selected ? 0.82 : 0.70),
            borderRadius: BorderRadius.circular(16),
            border: Border.all(
              color: accent.withValues(alpha: selected ? 0.70 : 0.36),
              width: selected ? 1.6 : 1,
            ),
            boxShadow: [
              BoxShadow(
                color: accent.withValues(alpha: selected ? 0.22 : 0.10),
                blurRadius: selected ? 22 : 14,
                offset: const Offset(0, 8),
              ),
            ],
          ),
          child: Row(
            mainAxisSize: MainAxisSize.min,
            children: [
              CachedCardThumbnail(
                imageUrl: card.imageUrl,
                label: card.name,
                caption: card.editionLabel,
                width: selected ? 38 : 30,
                height: selected ? 52 : 42,
                showFrame: false,
              ),
              const SizedBox(width: 8),
              Expanded(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      card.name,
                      maxLines: selected ? 2 : 1,
                      overflow: TextOverflow.ellipsis,
                      style: theme.textTheme.labelMedium?.copyWith(
                        color: Colors.white,
                        fontWeight: FontWeight.w900,
                      ),
                    ),
                    const SizedBox(height: 4),
                    Wrap(
                      spacing: 4,
                      runSpacing: 4,
                      children: [
                        ManaChip(
                          label: card.editionLabel,
                          tone: ManaChipTone.blue,
                        ),
                        if (card.damage > 0)
                          ManaChip(
                            label: '${card.damage} dano',
                            tone: ManaChipTone.gold,
                          ),
                        if (card.totalCounters > 0)
                          ManaChip(
                            label: '${card.totalCounters} marc.',
                            tone: ManaChipTone.primary,
                          ),
                      ],
                    ),
                    if (card.abilities.isNotEmpty) ...[
                      const SizedBox(height: 5),
                      AbilityIconStrip(
                        abilities: card.abilities,
                        selected: selected,
                      ),
                    ],
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
