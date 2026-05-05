import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../../app/router.dart';

enum CollectionSection {
  cards,
  decks,
  trades,
}

class CollectionSectionSwitcher extends StatelessWidget {
  const CollectionSectionSwitcher({
    super.key,
    required this.currentSection,
  });

  final CollectionSection currentSection;

  void _select(BuildContext context, CollectionSection section) {
    switch (section) {
      case CollectionSection.cards:
        context.goNamed(AppRoutes.collectionRoot);
      case CollectionSection.decks:
        context.goNamed(AppRoutes.decks);
      case CollectionSection.trades:
        context.goNamed(AppRoutes.chat);
    }
  }

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return Container(
      height: 50,
      padding: const EdgeInsets.all(5),
      decoration: BoxDecoration(
        color: scheme.surfaceContainerLow,
        borderRadius: BorderRadius.circular(18),
        border: Border.all(
          color: scheme.outlineVariant.withValues(alpha: 0.4),
        ),
      ),
      child: Row(
        children: [
          Expanded(
            child: _SectionPill(
              key: const Key('collection-section-cards'),
              label: 'Cartas',
              icon: Icons.collections_bookmark_rounded,
              selected: currentSection == CollectionSection.cards,
              color: scheme.secondary,
              onTap: () => _select(context, CollectionSection.cards),
            ),
          ),
          const SizedBox(width: 6),
          Expanded(
            child: _SectionPill(
              key: const Key('collection-section-decks'),
              label: 'Decks',
              icon: Icons.style_rounded,
              selected: currentSection == CollectionSection.decks,
              color: scheme.primary,
              onTap: () => _select(context, CollectionSection.decks),
            ),
          ),
          const SizedBox(width: 6),
          Expanded(
            child: _SectionPill(
              key: const Key('collection-section-trades'),
              label: 'Trocas',
              icon: Icons.swap_horiz_rounded,
              selected: currentSection == CollectionSection.trades,
              color: scheme.tertiary,
              onTap: () => _select(context, CollectionSection.trades),
            ),
          ),
        ],
      ),
    );
  }
}

class _SectionPill extends StatelessWidget {
  const _SectionPill({
    super.key,
    required this.label,
    required this.icon,
    required this.selected,
    required this.color,
    required this.onTap,
  });

  final String label;
  final IconData icon;
  final bool selected;
  final Color color;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final textColor = selected ? color : scheme.onSurfaceVariant;
    return Semantics(
      button: true,
      selected: selected,
      label: label,
      child: Material(
        color: selected ? color.withValues(alpha: 0.18) : Colors.transparent,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(13),
          side: selected
              ? BorderSide(color: color.withValues(alpha: 0.46))
              : BorderSide.none,
        ),
        clipBehavior: Clip.antiAlias,
        child: InkWell(
          onTap: onTap,
          child: Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 6),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(icon, size: 16, color: textColor),
                  const SizedBox(width: 5),
                  Flexible(
                    child: Text(
                      label,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.labelMedium?.copyWith(
                            color: textColor,
                            fontWeight: FontWeight.w900,
                          ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
