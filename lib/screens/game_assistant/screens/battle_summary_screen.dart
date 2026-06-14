import 'package:flutter/material.dart';

import '../../../widgets/mana_section_header.dart';
import '../../../widgets/mana_surface_card.dart';
import '../services/game_log_service.dart';
import '../types/game_assistant_types.dart';

class BattleSummaryScreen extends StatelessWidget {
  const BattleSummaryScreen({
    super.key,
    required this.state,
    required this.onNewGame,
  });

  final GameAssistantState state;
  final VoidCallback onNewGame;

  @override
  Widget build(BuildContext context) {
    const logService = GameLogService();
    final summary = logService.summarize(state);
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: const Text('Resumo da partida'),
        actions: [
          IconButton(
            tooltip: 'Nova partida',
            onPressed: onNewGame,
            icon: const Icon(Icons.restart_alt_rounded),
          ),
        ],
      ),
      body: ListView(
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 112),
        children: [
          ManaSurfaceCard(
            borderColor: scheme.primary.withValues(alpha: 0.30),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Text(
                  'Campo encerrado',
                  style: theme.textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 12),
                Wrap(
                  spacing: 10,
                  runSpacing: 10,
                  children: [
                    _SummaryMetric(
                      icon: Icons.timer_outlined,
                      label: 'duração',
                      value: logService.formatDuration(summary.duration),
                      color: scheme.primary,
                    ),
                    _SummaryMetric(
                      icon: Icons.style_outlined,
                      label: 'cartas',
                      value: '${summary.cardsTracked}',
                      color: scheme.secondary,
                    ),
                    _SummaryMetric(
                      icon: Icons.add_circle_outline,
                      label: 'marcadores',
                      value: '${summary.totalCounters}',
                      color: scheme.tertiary,
                    ),
                    _SummaryMetric(
                      icon: Icons.local_fire_department_outlined,
                      label: 'dano',
                      value: '${summary.totalDamage}',
                      color: const Color(0xFFFFB86C),
                    ),
                    _SummaryMetric(
                      icon: Icons.auto_awesome_outlined,
                      label: 'habilidades',
                      value: '${summary.totalAbilities}',
                      color: const Color(0xFF50FA7B),
                    ),
                  ],
                ),
              ],
            ),
          ),
          const ManaSectionHeader(title: 'Jogadores'),
          for (final player in state.players) ...[
            _PlayerSummaryTile(player: player),
            const SizedBox(height: 8),
          ],
          const ManaSectionHeader(title: 'Cartas no campo'),
          if (state.trackedCards.isEmpty)
            ManaSurfaceCard(
              child: Text(
                'Nenhuma carta foi rastreada nesta sessão.',
                style: theme.textTheme.bodyMedium?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w700,
                ),
              ),
            )
          else
            for (final card in state.trackedCards) ...[
              _CardSummaryTile(card: card),
              const SizedBox(height: 8),
            ],
          const ManaSectionHeader(title: 'Registro'),
          if (state.log.isEmpty)
            ManaSurfaceCard(
              child: Text(
                'Nenhuma ação registrada.',
                style: theme.textTheme.bodyMedium?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w700,
                ),
              ),
            )
          else
            for (final entry in state.log.reversed.take(12)) ...[
              _LogTile(entry: entry),
              const SizedBox(height: 8),
            ],
          const SizedBox(height: 16),
          FilledButton.icon(
            onPressed: onNewGame,
            icon: const Icon(Icons.add_rounded),
            label: const Text('Iniciar nova partida'),
          ),
        ],
      ),
    );
  }
}

class _SummaryMetric extends StatelessWidget {
  const _SummaryMetric({
    required this.icon,
    required this.label,
    required this.value,
    required this.color,
  });

  final IconData icon;
  final String label;
  final String value;
  final Color color;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return ConstrainedBox(
      constraints: const BoxConstraints(minWidth: 130),
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: color.withValues(alpha: 0.12),
          borderRadius: BorderRadius.circular(14),
          border: Border.all(color: color.withValues(alpha: 0.26)),
        ),
        child: Padding(
          padding: const EdgeInsets.all(10),
          child: Row(
            mainAxisSize: MainAxisSize.min,
            children: [
              Icon(icon, color: color, size: 20),
              const SizedBox(width: 8),
              Flexible(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      value,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: theme.textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                        letterSpacing: 0,
                      ),
                    ),
                    Text(
                      label,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: theme.textTheme.labelSmall?.copyWith(
                        color: Theme.of(context).colorScheme.onSurfaceVariant,
                        fontWeight: FontWeight.w700,
                      ),
                    ),
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

class _PlayerSummaryTile extends StatelessWidget {
  const _PlayerSummaryTile({required this.player});

  final GameAssistantPlayer player;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ManaSurfaceCard(
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 12),
      child: Row(
        children: [
          Icon(Icons.person_outline, color: scheme.primary),
          const SizedBox(width: 10),
          Expanded(
            child: Text(
              player.name,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
            ),
          ),
          Text(
            '${player.life} vida',
            style: Theme.of(context).textTheme.labelLarge?.copyWith(
                  color: scheme.secondary,
                  fontWeight: FontWeight.w900,
                ),
          ),
        ],
      ),
    );
  }
}

class _CardSummaryTile extends StatelessWidget {
  const _CardSummaryTile({required this.card});

  final GameAssistantTrackedCard card;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return ManaSurfaceCard(
      padding: const EdgeInsets.all(12),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(Icons.style_outlined, color: scheme.secondary),
              const SizedBox(width: 10),
              Expanded(
                child: Text(
                  card.name,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
              ),
              Text(
                '${(card.confidence * 100).round()}%',
                style: theme.textTheme.labelSmall?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w800,
                ),
              ),
            ],
          ),
          const SizedBox(height: 6),
          Text(
            [
              card.editionLabel,
              if (card.damage > 0) '${card.damage} dano',
              if (card.totalCounters > 0) '${card.totalCounters} marcadores',
              if (card.abilities.isNotEmpty)
                '${card.abilities.length} habilidades',
            ].join(' · '),
            maxLines: 2,
            overflow: TextOverflow.ellipsis,
            style: theme.textTheme.bodySmall?.copyWith(
              color: scheme.onSurfaceVariant,
              fontWeight: FontWeight.w700,
            ),
          ),
        ],
      ),
    );
  }
}

class _LogTile extends StatelessWidget {
  const _LogTile({required this.entry});

  final GameAssistantLogEntry entry;

  @override
  Widget build(BuildContext context) {
    return ManaSurfaceCard(
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
      child: Row(
        children: [
          const Icon(Icons.history_rounded, size: 18),
          const SizedBox(width: 10),
          Expanded(
            child: Text(
              entry.message,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.bodySmall?.copyWith(
                    fontWeight: FontWeight.w700,
                  ),
            ),
          ),
        ],
      ),
    );
  }
}
