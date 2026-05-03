import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../app/router.dart';
import '../../widgets/mana_tab_main_app_bar.dart';
import '../../widgets/mana_surface_card.dart';

class CollectionHubScreen extends StatelessWidget {
  const CollectionHubScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final t = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: ManaTabMainAppBar(title: t.collectionHubTitle),
      body: ListView(
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 110),
        children: [
          const SizedBox(height: 10),
          ManaSurfaceCard(
            onTap: () => context.pushNamed(AppRoutes.collectionRoot),
            padding: const EdgeInsets.all(16),
            child: Row(
              children: [
                _HubIcon(
                  icon: Icons.collections_bookmark_rounded,
                  color: scheme.primary,
                  bg: scheme.primaryContainer.withValues(alpha: 0.35),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        t.collectionHubMyCardsTitle,
                        style: theme.textTheme.titleMedium?.copyWith(
                          fontWeight: FontWeight.w800,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(
                        t.collectionHubMyCardsSubtitle,
                        style: theme.textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                        ),
                      ),
                    ],
                  ),
                ),
                Icon(Icons.chevron_right_rounded,
                    color: scheme.onSurfaceVariant),
              ],
            ),
          ),
          const SizedBox(height: 12),
          ManaSurfaceCard(
            onTap: () => context.pushNamed(AppRoutes.decks),
            padding: const EdgeInsets.all(16),
            child: Row(
              children: [
                _HubIcon(
                  icon: Icons.style_rounded,
                  color: scheme.secondary,
                  bg: scheme.secondaryContainer.withValues(alpha: 0.35),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        t.collectionHubDecksTitle,
                        style: theme.textTheme.titleMedium?.copyWith(
                          fontWeight: FontWeight.w800,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(
                        t.collectionHubDecksSubtitle,
                        style: theme.textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                        ),
                      ),
                    ],
                  ),
                ),
                Icon(Icons.chevron_right_rounded,
                    color: scheme.onSurfaceVariant),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class _HubIcon extends StatelessWidget {
  const _HubIcon({
    required this.icon,
    required this.color,
    required this.bg,
  });

  final IconData icon;
  final Color color;
  final Color bg;

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 52,
      height: 52,
      decoration: BoxDecoration(
        color: bg,
        borderRadius: BorderRadius.circular(14),
        border: Border.all(
          color: color.withValues(alpha: 0.28),
        ),
      ),
      child: Icon(icon, color: color),
    );
  }
}
