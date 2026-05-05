import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../app/router.dart';
import '../../widgets/mana_tab_main_app_bar.dart';
import '../../widgets/mana_surface_card.dart';
import 'widgets/collection_section_switcher.dart';

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
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 112),
        children: [
          const CollectionSectionSwitcher(
            currentSection: CollectionSection.cards,
          ),
          const SizedBox(height: 14),
          ManaSurfaceCard(
            padding: const EdgeInsets.fromLTRB(18, 16, 18, 16),
            borderColor: scheme.secondary.withValues(alpha: 0.22),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Inventário ativo',
                  style: theme.textTheme.labelMedium?.copyWith(
                    color: scheme.onSurfaceVariant,
                    fontWeight: FontWeight.w800,
                  ),
                ),
                const SizedBox(height: 12),
                Row(
                  children: [
                    Expanded(
                      child: _HubStat(
                        value: 'Offline',
                        label: 'pronto para consulta',
                        accent: scheme.secondary,
                      ),
                    ),
                    const SizedBox(width: 10),
                    Expanded(
                      child: _HubStat(
                        value: 'Sync',
                        label: 'preparado para nuvem',
                        accent: const Color(0xFF50FA7B),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
          const SizedBox(height: 18),
          _HubDestinationCard(
            onTap: () => context.goNamed(AppRoutes.collectionRoot),
            icon: Icons.collections_bookmark_rounded,
            color: scheme.primary,
            title: t.collectionHubMyCardsTitle,
            subtitle: t.collectionHubMyCardsSubtitle,
          ),
          const SizedBox(height: 12),
          _HubDestinationCard(
            onTap: () => context.goNamed(AppRoutes.decks),
            icon: Icons.style_rounded,
            color: scheme.secondary,
            title: t.collectionHubDecksTitle,
            subtitle: t.collectionHubDecksSubtitle,
          ),
          const SizedBox(height: 12),
          ManaSurfaceCard(
            onTap: () => context.goNamed(AppRoutes.chat),
            padding: const EdgeInsets.fromLTRB(16, 14, 16, 14),
            borderColor: scheme.tertiary.withValues(alpha: 0.18),
            backgroundColor: scheme.surfaceContainer.withValues(alpha: 0.64),
            child: Row(
              children: [
                _HubIcon(
                  icon: Icons.swap_horiz_rounded,
                  color: scheme.tertiary,
                  bg: scheme.tertiaryContainer.withValues(alpha: 0.35),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'Trocas',
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: theme.textTheme.titleMedium?.copyWith(
                          fontWeight: FontWeight.w900,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(
                        'Mensagens e propostas entre jogadores.',
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                        style: theme.textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                          fontWeight: FontWeight.w600,
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(width: 10),
                Container(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 10, vertical: 6),
                  decoration: BoxDecoration(
                    color: scheme.tertiary.withValues(alpha: 0.14),
                    borderRadius: BorderRadius.circular(999),
                  ),
                  child: Text(
                    'abrir',
                    style: theme.textTheme.labelSmall?.copyWith(
                      color: scheme.tertiary,
                      fontWeight: FontWeight.w900,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class _HubStat extends StatelessWidget {
  const _HubStat({
    required this.value,
    required this.label,
    required this.accent,
  });

  final String value;
  final String label;
  final Color accent;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return Container(
      padding: const EdgeInsets.fromLTRB(12, 11, 12, 11),
      decoration: BoxDecoration(
        color: accent.withValues(alpha: 0.11),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(color: accent.withValues(alpha: 0.28)),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            value,
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
            style: Theme.of(context).textTheme.titleMedium?.copyWith(
                  color: scheme.onSurface,
                  fontWeight: FontWeight.w900,
                ),
          ),
          const SizedBox(height: 3),
          Text(
            label,
            maxLines: 2,
            overflow: TextOverflow.ellipsis,
            style: Theme.of(context).textTheme.labelSmall?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w700,
                ),
          ),
        ],
      ),
    );
  }
}

class _HubDestinationCard extends StatelessWidget {
  const _HubDestinationCard({
    required this.onTap,
    required this.icon,
    required this.color,
    required this.title,
    required this.subtitle,
  });

  final VoidCallback onTap;
  final IconData icon;
  final Color color;
  final String title;
  final String subtitle;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return ManaSurfaceCard(
      onTap: onTap,
      padding: const EdgeInsets.all(16),
      borderColor: color.withValues(alpha: 0.26),
      child: Row(
        children: [
          _HubIcon(
            icon: icon,
            color: color,
            bg: color.withValues(alpha: 0.15),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  subtitle,
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.bodySmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                    fontWeight: FontWeight.w600,
                  ),
                ),
              ],
            ),
          ),
          Icon(Icons.chevron_right_rounded, color: scheme.onSurfaceVariant),
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
        borderRadius: BorderRadius.circular(16),
        border: Border.all(
          color: color.withValues(alpha: 0.30),
        ),
      ),
      child: Icon(icon, color: color),
    );
  }
}
