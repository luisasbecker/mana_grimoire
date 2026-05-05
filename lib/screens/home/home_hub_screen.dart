import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../data/local/db/app_database.dart';
import '../../data/local/db/daos/collection_dao.dart';
import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_home_app_bar.dart';
import '../../widgets/mana_section_header.dart';
import '../../widgets/mana_surface_card.dart';

/// Hub principal (scroll) — centro da bottom bar.
class HomeHubScreen extends StatelessWidget {
  const HomeHubScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Scaffold(
      appBar: const ManaHomeAppBar(),
      body: CustomScrollView(
        slivers: [
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 8, 16, 0),
            sliver: SliverToBoxAdapter(
              child: Text(
                'Boa noite',
                style: theme.textTheme.bodyMedium?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w700,
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 8, 16, 0),
            sliver: SliverToBoxAdapter(
              child: TextField(
                readOnly: true,
                onTap: () => context.goNamed(AppRoutes.allCards),
                decoration: const InputDecoration(
                  hintText: 'Buscar cartas, decks ou jogadores...',
                  prefixIcon: Icon(Icons.search_rounded),
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 22, 16, 0),
            sliver: SliverToBoxAdapter(
              child: _HomeStatsRow(scheme: scheme),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverToBoxAdapter(
              child: ManaSectionHeader(
                title: 'Ações rápidas',
                subtitle: 'Entradas principais para a tua rotina de jogo',
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverList(
              delegate: SliverChildListDelegate([
                Row(
                  children: [
                    Expanded(
                      child: _QuickActionCard(
                        title: 'Coleções',
                        subtitle: 'organizar binder',
                        icon: Icons.collections_bookmark_rounded,
                        accent: scheme.primary,
                        onTap: () => context.goNamed(AppRoutes.collectionHub),
                      ),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: _QuickActionCard(
                        title: 'Decks',
                        subtitle: 'minhas listas',
                        icon: Icons.style_rounded,
                        accent: scheme.secondary,
                        onTap: () => context.goNamed(AppRoutes.decks),
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 12),
                Row(
                  children: [
                    Expanded(
                      child: _QuickActionCard(
                        title: 'Scan',
                        subtitle: 'catálogo local',
                        icon: Icons.qr_code_scanner_rounded,
                        accent: const Color(0xFF50FA7B),
                        onTap: () => context.goNamed(AppRoutes.scan),
                      ),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: _QuickActionCard(
                        title: 'Jogar',
                        subtitle: 'Commander',
                        icon: Icons.sports_esports_rounded,
                        accent: const Color(0xFFF1FA8C),
                        onTap: () => context.goNamed(AppRoutes.play),
                      ),
                    ),
                  ],
                ),
              ]),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverToBoxAdapter(
              child: ManaSectionHeader(
                title: 'Mensagens e trocas',
                subtitle: 'Resumo da tua atividade social',
                trailing: Icon(
                  Icons.notifications_none_rounded,
                  color: scheme.onSurfaceVariant,
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverList(
              delegate: SliverChildListDelegate([
                _ActivityCard(
                  icon: Icons.person_rounded,
                  accent: scheme.tertiary,
                  title: 'Pedro quer trocar uma carta contigo',
                  subtitle: 'Propôs Rhystic Study (NM) · há 2 h',
                  onTap: () => context.goNamed(AppRoutes.chat),
                ),
                const SizedBox(height: 10),
                _ActivityCard(
                  icon: Icons.forum_outlined,
                  accent: scheme.secondary,
                  title: 'Nova mensagem sobre Sol Ring',
                  subtitle: 'Grupo Commander SP · há 5 h',
                  onTap: () => context.goNamed(AppRoutes.chat),
                ),
              ]),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 24, 16, 8),
            sliver: SliverToBoxAdapter(
              child: ManaSectionHeader(
                title: 'Destaques',
                subtitle: 'Inspiração para a tua próxima decklist',
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 0, 16, 24),
            sliver: SliverToBoxAdapter(
              child: SizedBox(
                height: 154,
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  children: [
                    _FeaturedCard(
                      title: 'Novas cartas populares',
                      line: 'Commander · Standard · Pioneer',
                      accent: scheme.primary,
                      onTap: () => context.goNamed(AppRoutes.collectionRoot),
                    ),
                    const SizedBox(width: 12),
                    _FeaturedCard(
                      title: 'Tendências da semana',
                      line: 'Combos e techs da comunidade',
                      accent: scheme.tertiary,
                      onTap: () => context.goNamed(AppRoutes.decks),
                    ),
                    const SizedBox(width: 12),
                    _FeaturedCard(
                      title: 'Arte & lore',
                      line: 'Universos Beyond e mais',
                      accent: scheme.secondary,
                      onTap: () => context.goNamed(AppRoutes.chat),
                    ),
                  ],
                ),
              ),
            ),
          ),
          if (kDebugMode)
            SliverPadding(
              padding: const EdgeInsets.fromLTRB(16, 0, 16, 32),
              sliver: SliverToBoxAdapter(
                child: OutlinedButton.icon(
                  onPressed: () => context.pushNamed(AppRoutes.devScryfallTest),
                  icon: const Icon(Icons.science_outlined),
                  label: const Text('Dev: teste Scryfall + cache'),
                ),
              ),
            ),
        ],
      ),
    );
  }
}

class _HomeStatsRow extends StatelessWidget {
  const _HomeStatsRow({required this.scheme});

  final ColorScheme scheme;

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<List<CollectionItemView>>(
      stream: appDb.collectionDao.watchAllCollectionItems(),
      builder: (context, collectionSnapshot) {
        final items = collectionSnapshot.data ?? const <CollectionItemView>[];
        final totalCards = items.fold<int>(
          0,
          (sum, view) => sum + view.item.quantity,
        );

        return StreamBuilder<List<Deck>>(
          stream: appDb.decksDao.watchDecks(),
          builder: (context, deckSnapshot) {
            final decks = deckSnapshot.data ?? const <Deck>[];
            final activeDecks = decks.where((d) => d.isActive).length;
            return Row(
              children: [
                Expanded(
                  child: _StatTile(
                    value: '$totalCards',
                    label: 'cartas',
                    accent: scheme.primary,
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: _StatTile(
                    value: '${decks.length}',
                    label: 'decks',
                    accent: scheme.secondary,
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: _StatTile(
                    value: '$activeDecks',
                    label: 'ativos',
                    accent: scheme.tertiary,
                  ),
                ),
              ],
            );
          },
        );
      },
    );
  }
}

class _StatTile extends StatelessWidget {
  const _StatTile({
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
    return ManaSurfaceCard(
      padding: const EdgeInsets.fromLTRB(14, 14, 14, 12),
      borderColor: accent.withValues(alpha: 0.18),
      backgroundColor: scheme.surfaceContainer.withValues(alpha: 0.72),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          FittedBox(
            fit: BoxFit.scaleDown,
            alignment: Alignment.centerLeft,
            child: Text(
              value,
              maxLines: 1,
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                    letterSpacing: 0,
                    color: scheme.onSurface,
                  ),
            ),
          ),
          const SizedBox(height: 6),
          Text(
            label,
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
            style: Theme.of(context).textTheme.labelSmall?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w800,
                ),
          ),
        ],
      ),
    );
  }
}

class _QuickActionCard extends StatelessWidget {
  const _QuickActionCard({
    required this.title,
    required this.subtitle,
    required this.icon,
    required this.accent,
    required this.onTap,
  });

  final String title;
  final String subtitle;
  final IconData icon;
  final Color accent;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ManaSurfaceCard(
      onTap: onTap,
      padding: const EdgeInsets.all(16),
      borderColor: accent.withValues(alpha: 0.30),
      backgroundColor: scheme.surfaceContainerHigh.withValues(alpha: 0.86),
      child: ConstrainedBox(
        constraints: const BoxConstraints(minHeight: 68),
        child: Row(
          children: [
            Container(
              width: 42,
              height: 42,
              decoration: BoxDecoration(
                color: accent.withValues(alpha: 0.18),
                borderRadius: BorderRadius.circular(14),
              ),
              child: Icon(icon, color: accent, size: 23),
            ),
            const SizedBox(width: 12),
            Expanded(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    title,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.titleSmall?.copyWith(
                          fontWeight: FontWeight.w900,
                        ),
                  ),
                  const SizedBox(height: 4),
                  Text(
                    subtitle,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.labelSmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                          fontWeight: FontWeight.w700,
                        ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _ActivityCard extends StatelessWidget {
  const _ActivityCard({
    required this.icon,
    required this.accent,
    required this.title,
    required this.subtitle,
    required this.onTap,
  });

  final IconData icon;
  final Color accent;
  final String title;
  final String subtitle;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ManaSurfaceCard(
      onTap: onTap,
      padding: const EdgeInsets.fromLTRB(14, 12, 12, 12),
      child: Row(
        children: [
          CircleAvatar(
            radius: 20,
            backgroundColor: accent.withValues(alpha: 0.22),
            child: Icon(icon, color: accent, size: 21),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                  style: Theme.of(context).textTheme.titleSmall?.copyWith(
                        fontWeight: FontWeight.w800,
                      ),
                ),
                const SizedBox(height: 4),
                Text(
                  subtitle,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: Theme.of(context).textTheme.bodySmall?.copyWith(
                        color: scheme.onSurfaceVariant,
                        fontWeight: FontWeight.w600,
                      ),
                ),
              ],
            ),
          ),
          const SizedBox(width: 8),
          Icon(Icons.chevron_right_rounded, color: scheme.onSurfaceVariant),
        ],
      ),
    );
  }
}

class _FeaturedCard extends StatelessWidget {
  const _FeaturedCard({
    required this.title,
    required this.line,
    required this.accent,
    required this.onTap,
  });

  final String title;
  final String line;
  final Color accent;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return SizedBox(
      width: 210,
      child: ManaSurfaceCard(
        onTap: onTap,
        padding: const EdgeInsets.all(16),
        borderColor: accent.withValues(alpha: 0.24),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              height: 4,
              width: 40,
              decoration: BoxDecoration(
                color: accent,
                borderRadius: BorderRadius.circular(2),
              ),
            ),
            const Spacer(),
            Text(
              title,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
            ),
            const SizedBox(height: 6),
            Text(
              line,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.bodySmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                    fontWeight: FontWeight.w600,
                  ),
            ),
          ],
        ),
      ),
    );
  }
}
