import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../widgets/mana_section_header.dart';
import '../../widgets/mana_surface_card.dart';
import '../../widgets/mana_tab_main_app_bar.dart';

class SocialHubScreen extends StatelessWidget {
  const SocialHubScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Scaffold(
      appBar: const ManaTabMainAppBar(title: 'Chat'),
      body: ListView(
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 112),
        children: [
          ManaSurfaceCard(
            padding: const EdgeInsets.fromLTRB(16, 16, 16, 16),
            borderColor: scheme.tertiary.withValues(alpha: 0.24),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Central social',
                  style: theme.textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 12),
                Row(
                  children: [
                    Expanded(
                      child: _SocialMetric(
                        value: '0',
                        label: 'mensagens',
                        color: scheme.secondary,
                      ),
                    ),
                    const SizedBox(width: 10),
                    Expanded(
                      child: _SocialMetric(
                        value: '0',
                        label: 'trocas',
                        color: scheme.tertiary,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
          const SizedBox(height: 18),
          ManaSectionHeader(
            title: 'Conversas',
            subtitle: 'Atalhos para mensagens e grupos',
          ),
          _SocialActionCard(
            icon: Icons.forum_outlined,
            color: scheme.secondary,
            title: 'Mensagens',
            subtitle: 'Nenhuma conversa ativa neste aparelho.',
          ),
          const SizedBox(height: 12),
          _SocialActionCard(
            icon: Icons.swap_horiz_rounded,
            color: scheme.tertiary,
            title: 'Trocas',
            subtitle: 'Propostas de troca aparecerão nesta área.',
          ),
          const SizedBox(height: 18),
          ManaSectionHeader(
            title: 'Ir para',
            subtitle: 'Seções relacionadas',
          ),
          Row(
            children: [
              Expanded(
                child: _ShortcutButton(
                  icon: Icons.collections_bookmark_rounded,
                  label: 'Cartas',
                  color: scheme.primary,
                  onTap: () => context.goNamed(AppRoutes.collectionRoot),
                ),
              ),
              const SizedBox(width: 10),
              Expanded(
                child: _ShortcutButton(
                  icon: Icons.style_rounded,
                  label: 'Decks',
                  color: scheme.secondary,
                  onTap: () => context.goNamed(AppRoutes.decks),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class _SocialMetric extends StatelessWidget {
  const _SocialMetric({
    required this.value,
    required this.label,
    required this.color,
  });

  final String value;
  final String label;
  final Color color;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
      decoration: BoxDecoration(
        color: color.withValues(alpha: 0.12),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(color: color.withValues(alpha: 0.28)),
      ),
      child: Row(
        children: [
          Text(
            value,
            style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
          ),
          const SizedBox(width: 8),
          Expanded(
            child: Text(
              label,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.labelMedium?.copyWith(
                    color: Theme.of(context).colorScheme.onSurfaceVariant,
                    fontWeight: FontWeight.w800,
                  ),
            ),
          ),
        ],
      ),
    );
  }
}

class _SocialActionCard extends StatelessWidget {
  const _SocialActionCard({
    required this.icon,
    required this.color,
    required this.title,
    required this.subtitle,
  });

  final IconData icon;
  final Color color;
  final String title;
  final String subtitle;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ManaSurfaceCard(
      padding: const EdgeInsets.fromLTRB(14, 12, 14, 12),
      borderColor: color.withValues(alpha: 0.22),
      child: Row(
        children: [
          CircleAvatar(
            radius: 22,
            backgroundColor: color.withValues(alpha: 0.18),
            child: Icon(icon, color: color),
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
                  style: Theme.of(context).textTheme.titleSmall?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                const SizedBox(height: 4),
                Text(
                  subtitle,
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
        ],
      ),
    );
  }
}

class _ShortcutButton extends StatelessWidget {
  const _ShortcutButton({
    required this.icon,
    required this.label,
    required this.color,
    required this.onTap,
  });

  final IconData icon;
  final String label;
  final Color color;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return ManaSurfaceCard(
      onTap: onTap,
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 14),
      borderColor: color.withValues(alpha: 0.24),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(icon, color: color, size: 20),
          const SizedBox(width: 8),
          Flexible(
            child: Text(
              label,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.labelLarge?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
            ),
          ),
        ],
      ),
    );
  }
}
