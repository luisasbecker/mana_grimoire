import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import 'play_session_controller.dart';

/// Aba Jogar (setup): ecrã leve antes de entrar em full-screen.
class PlayTabScreen extends ConsumerStatefulWidget {
  const PlayTabScreen({super.key});

  @override
  ConsumerState<PlayTabScreen> createState() => _PlayTabScreenState();
}

class _PlayTabScreenState extends ConsumerState<PlayTabScreen> {
  int _players = 2;
  String _mode = 'Commander';

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final session = ref.watch(playSessionControllerProvider);

    return Scaffold(
      body: SafeArea(
        child: LayoutBuilder(
          builder: (context, constraints) {
            return SingleChildScrollView(
              padding: const EdgeInsets.fromLTRB(16, 18, 16, 24),
              child: ConstrainedBox(
                constraints: BoxConstraints(minHeight: constraints.maxHeight),
                child: Center(
                  child: ConstrainedBox(
                    constraints: const BoxConstraints(maxWidth: 520),
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        Text(
                          'Jogar',
                          textAlign: TextAlign.center,
                          style: theme.textTheme.titleLarge?.copyWith(
                            fontWeight: FontWeight.w800,
                            letterSpacing: 0.35,
                          ),
                        ),
                        const SizedBox(height: 6),
                        Text(
                          'Configura o básico e entra em full-screen.',
                          textAlign: TextAlign.center,
                          style: theme.textTheme.bodySmall?.copyWith(
                            color: scheme.onSurfaceVariant,
                          ),
                        ),
                        if (session.hasSession) ...[
                          const SizedBox(height: 14),
                          Container(
                            padding: const EdgeInsets.fromLTRB(14, 12, 14, 12),
                            decoration: BoxDecoration(
                              color: scheme.primaryContainer
                                  .withValues(alpha: 0.28),
                              borderRadius: BorderRadius.circular(16),
                              border: Border.all(
                                color: scheme.primary.withValues(alpha: 0.35),
                              ),
                            ),
                            child: Row(
                              children: [
                                Icon(
                                  Icons.auto_awesome,
                                  color: scheme.primary,
                                ),
                                const SizedBox(width: 10),
                                Expanded(
                                  child: Text(
                                    'Há um jogo salvo (${session.players}P · ${session.mode}).',
                                    maxLines: 2,
                                    overflow: TextOverflow.ellipsis,
                                    style: theme.textTheme.bodySmall?.copyWith(
                                      color: scheme.onSurfaceVariant,
                                      fontWeight: FontWeight.w600,
                                    ),
                                  ),
                                ),
                                const SizedBox(width: 10),
                                FilledButton.tonal(
                                  onPressed: () => context.pushNamed(
                                    AppRoutes.playSession,
                                    extra: const {'resume': true},
                                  ),
                                  child: const Text('Retomar'),
                                ),
                              ],
                            ),
                          ),
                        ],
                        const SizedBox(height: 18),
                        _SetupCard(
                          title: 'Jogadores',
                          child: SegmentedButton<int>(
                            segments: const [
                              ButtonSegment(value: 2, label: Text('2')),
                              ButtonSegment(value: 4, label: Text('4')),
                            ],
                            selected: {_players},
                            onSelectionChanged: (v) =>
                                setState(() => _players = v.first),
                          ),
                        ),
                        const SizedBox(height: 12),
                        _SetupCard(
                          title: 'Modo',
                          child: Wrap(
                            spacing: 8,
                            runSpacing: 8,
                            alignment: WrapAlignment.center,
                            children: [
                              ChoiceChip(
                                label: const Text('Commander'),
                                selected: _mode == 'Commander',
                                onSelected: (_) =>
                                    setState(() => _mode = 'Commander'),
                              ),
                              ChoiceChip(
                                label: const Text('Standard'),
                                selected: _mode == 'Standard',
                                onSelected: (_) =>
                                    setState(() => _mode = 'Standard'),
                              ),
                              ChoiceChip(
                                label: const Text('Casual'),
                                selected: _mode == 'Casual',
                                onSelected: (_) =>
                                    setState(() => _mode = 'Casual'),
                              ),
                            ],
                          ),
                        ),
                        const SizedBox(height: 18),
                        FilledButton.icon(
                          onPressed: () {
                            ref
                                .read(playSessionControllerProvider.notifier)
                                .startNew(
                                  players: _players,
                                  mode: _mode,
                                );
                            context.pushNamed(AppRoutes.playSession);
                          },
                          icon: const Icon(Icons.play_arrow_rounded),
                          label: const Text('Confirmar e iniciar'),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}

class _SetupCard extends StatelessWidget {
  const _SetupCard({
    required this.title,
    required this.child,
  });

  final String title;
  final Widget child;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return Container(
      padding: const EdgeInsets.fromLTRB(14, 12, 14, 14),
      decoration: BoxDecoration(
        color: scheme.surfaceContainerHigh.withValues(alpha: 0.65),
        borderRadius: BorderRadius.circular(16),
        border:
            Border.all(color: scheme.outlineVariant.withValues(alpha: 0.55)),
      ),
      child: Column(
        children: [
          Text(
            title,
            style: theme.textTheme.titleSmall?.copyWith(
              fontWeight: FontWeight.w800,
              letterSpacing: 0.2,
            ),
          ),
          const SizedBox(height: 10),
          Center(child: child),
        ],
      ),
    );
  }
}
