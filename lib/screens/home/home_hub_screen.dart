import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../widgets/mana_home_app_bar.dart';
import '../../widgets/mana_section_header.dart';
import '../../widgets/mana_surface_card.dart';

/// Hub principal (scroll) — centro da bottom bar.
class HomeHubScreen extends StatelessWidget {
  const HomeHubScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: const ManaHomeAppBar(),
      body: CustomScrollView(
        slivers: [
          SliverPadding(
            padding: const EdgeInsets.fromLTRB(16, 8, 16, 0),
            sliver: SliverToBoxAdapter(
              child: TextField(
                readOnly: true,
                onTap: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Busca global em breve.')),
                  );
                },
                decoration: const InputDecoration(
                  hintText: 'Buscar cartas...',
                  prefixIcon: Icon(Icons.search_rounded),
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverToBoxAdapter(
              child: ManaSectionHeader(
                title: 'Mensagens e trocas',
                subtitle: 'Resumo da tua atividade social',
                trailing: Icon(Icons.notifications_none_rounded,
                    color: scheme.onSurfaceVariant),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            sliver: SliverList(
              delegate: SliverChildListDelegate([
                ManaSurfaceCard(
                  onTap: () {},
                  child: Row(
                    children: [
                      CircleAvatar(
                        backgroundColor: scheme.tertiary.withOpacity(0.25),
                        child: Icon(Icons.person, color: scheme.tertiary),
                      ),
                      const SizedBox(width: 14),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Pedro quer trocar uma carta contigo',
                              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                                    fontWeight: FontWeight.w600,
                                  ),
                            ),
                            const SizedBox(height: 4),
                            Text(
                              'Propôs Rhystic Study (NM) · há 2 h',
                              style: Theme.of(context).textTheme.bodySmall?.copyWith(
                                    color: scheme.onSurfaceVariant,
                                  ),
                            ),
                          ],
                        ),
                      ),
                      Icon(Icons.chevron_right_rounded, color: scheme.onSurfaceVariant),
                    ],
                  ),
                ),
                const SizedBox(height: 10),
                ManaSurfaceCard(
                  onTap: () {},
                  child: Row(
                    children: [
                      CircleAvatar(
                        backgroundColor: scheme.secondary.withOpacity(0.22),
                        child: Icon(Icons.forum_outlined, color: scheme.secondary),
                      ),
                      const SizedBox(width: 14),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Nova mensagem sobre Sol Ring',
                              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                                    fontWeight: FontWeight.w600,
                                  ),
                            ),
                            const SizedBox(height: 4),
                            Text(
                              'Grupo Commander SP · há 5 h',
                              style: Theme.of(context).textTheme.bodySmall?.copyWith(
                                    color: scheme.onSurfaceVariant,
                                  ),
                            ),
                          ],
                        ),
                      ),
                      Icon(Icons.chevron_right_rounded, color: scheme.onSurfaceVariant),
                    ],
                  ),
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
                height: 168,
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  children: [
                    _FeaturedCard(
                      title: 'Novas cartas populares',
                      line: 'Commander · Standard · Pioneer',
                      accent: scheme.primary,
                    ),
                    const SizedBox(width: 12),
                    _FeaturedCard(
                      title: 'Tendências da semana',
                      line: 'Combos e techs da comunidade',
                      accent: scheme.tertiary,
                    ),
                    const SizedBox(width: 12),
                    _FeaturedCard(
                      title: 'Arte & lore',
                      line: 'Universos Beyond e mais',
                      accent: scheme.secondary,
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
                  onPressed: () =>
                      context.pushNamed(AppRoutes.devScryfallTest),
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

class _FeaturedCard extends StatelessWidget {
  const _FeaturedCard({
    required this.title,
    required this.line,
    required this.accent,
  });

  final String title;
  final String line;
  final Color accent;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return SizedBox(
      width: 220,
      child: ManaSurfaceCard(
        onTap: () {},
        padding: const EdgeInsets.all(16),
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
              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w700,
                  ),
            ),
            const SizedBox(height: 6),
            Text(
              line,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.bodySmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                  ),
            ),
          ],
        ),
      ),
    );
  }
}
