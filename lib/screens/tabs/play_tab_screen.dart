import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../widgets/mana_section_header.dart';
import '../../widgets/mana_surface_card.dart';
import 'play_game_catalog.dart';
import 'play_session_controller.dart';

class PlayTabScreen extends ConsumerStatefulWidget {
  const PlayTabScreen({super.key});

  @override
  ConsumerState<PlayTabScreen> createState() => _PlayTabScreenState();
}

class _PlayTabScreenState extends ConsumerState<PlayTabScreen> {
  int _players = 4;
  String _modeId = 'commander';
  String _variant = 'Todos contra todos';
  int _startingLife = 40;
  String _tableTemplateId = 'commander_pod';
  String _visualThemeId = 'arcane';

  PlayGameMode get _selectedMode => playModeByInput(_modeId);

  PlayVisualTheme get _selectedTheme => playVisualThemeById(_visualThemeId);

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final session = ref.watch(playSessionControllerProvider);
    final templates = tableTemplatesForPlayers(_players);

    return Scaffold(
      body: SafeArea(
        child: LayoutBuilder(
          builder: (context, _) {
            return SingleChildScrollView(
              padding: const EdgeInsets.fromLTRB(16, 18, 16, 24),
              child: Center(
                child: ConstrainedBox(
                  constraints: const BoxConstraints(maxWidth: 760),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: [
                      Text(
                        'Jogar',
                        textAlign: TextAlign.center,
                        style: theme.textTheme.headlineSmall?.copyWith(
                          fontWeight: FontWeight.w900,
                          letterSpacing: 0,
                        ),
                      ),
                      const SizedBox(height: 6),
                      Text(
                        'Formatos, variantes e mesas para Magic.',
                        textAlign: TextAlign.center,
                        style: theme.textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                        ),
                      ),
                      if (session.hasSession) ...[
                        const SizedBox(height: 16),
                        _SavedSessionBanner(session: session),
                      ],
                      const ManaSectionHeader(
                        title: 'Modo de jogo',
                        subtitle:
                            'Cada formato ajusta vida inicial, variantes e jogadores disponíveis.',
                      ),
                      _ModeGrid(
                        selectedModeId: _modeId,
                        onSelected: _selectMode,
                      ),
                      const ManaSectionHeader(title: 'Mesa'),
                      ManaSurfaceCard(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.stretch,
                          children: [
                            _PlayersPicker(
                              mode: _selectedMode,
                              selectedPlayers: _players,
                              onSelected: _selectPlayers,
                            ),
                            const SizedBox(height: 16),
                            _VariantPicker(
                              mode: _selectedMode,
                              selectedVariant: _variant,
                              onSelected: _selectVariant,
                            ),
                            const SizedBox(height: 16),
                            _StartingLifeStepper(
                              value: _startingLife,
                              defaultValue: _selectedMode.startingLife,
                              onChanged: (value) {
                                setState(() {
                                  _startingLife = value.clamp(1, 999).toInt();
                                });
                              },
                              onReset: () {
                                setState(() {
                                  _startingLife = _selectedMode.startingLife;
                                });
                              },
                            ),
                          ],
                        ),
                      ),
                      const ManaSectionHeader(
                        title: 'Tema visual',
                        subtitle: 'Cores aplicadas na mesa e nos assentos.',
                      ),
                      _VisualThemePicker(
                        selectedThemeId: _visualThemeId,
                        onSelected: (id) {
                          setState(() => _visualThemeId = id);
                        },
                      ),
                      const ManaSectionHeader(
                        title: 'Template de mesa',
                        subtitle:
                            'Layouts gráficos mudam conforme o número de jogadores.',
                      ),
                      _TemplatePicker(
                        templates: templates,
                        selectedTemplateId: _tableTemplateId,
                        theme: _selectedTheme,
                        players: _players,
                        onSelected: (id) {
                          setState(() => _tableTemplateId = id);
                        },
                      ),
                      const SizedBox(height: 22),
                      FilledButton.icon(
                        onPressed: () {
                          ref
                              .read(playSessionControllerProvider.notifier)
                              .startNew(
                                players: _players,
                                mode: _modeId,
                                variant: _variant,
                                startingLife: _startingLife,
                                tableTemplateId: _tableTemplateId,
                                visualThemeId: _visualThemeId,
                              );
                          context.pushNamed(AppRoutes.playSession);
                        },
                        icon: const Icon(Icons.play_arrow_rounded),
                        label: const Text('Iniciar partida'),
                      ),
                    ],
                  ),
                ),
              ),
            );
          },
        ),
      ),
    );
  }

  void _selectMode(PlayGameMode mode) {
    setState(() {
      _modeId = mode.id;
      _players = normalizePlayersForMode(_players, mode);
      _variant = mode.defaultVariant;
      _startingLife = mode.startingLife;
      _tableTemplateId = defaultTableTemplateFor(
        mode: mode,
        players: _players,
        variant: _variant,
      ).id;
    });
  }

  void _selectPlayers(int players) {
    setState(() {
      _players = players;
      _tableTemplateId = defaultTableTemplateFor(
        mode: _selectedMode,
        players: _players,
        variant: _variant,
      ).id;
    });
  }

  void _selectVariant(String variant) {
    setState(() {
      _variant = variant;
      _tableTemplateId = defaultTableTemplateFor(
        mode: _selectedMode,
        players: _players,
        variant: _variant,
      ).id;
    });
  }
}

class _SavedSessionBanner extends StatelessWidget {
  const _SavedSessionBanner({required this.session});

  final PlaySessionState session;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return ManaSurfaceCard(
      borderColor: scheme.primary.withValues(alpha: 0.35),
      backgroundColor: scheme.primaryContainer.withValues(alpha: 0.28),
      child: Row(
        children: [
          Icon(Icons.table_restaurant_rounded, color: scheme.primary),
          const SizedBox(width: 12),
          Expanded(
            child: Text(
              '${session.players}P · ${session.mode} · ${session.tableTemplate.name}',
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: theme.textTheme.bodySmall?.copyWith(
                color: scheme.onSurfaceVariant,
                fontWeight: FontWeight.w700,
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
    );
  }
}

class _ModeGrid extends StatelessWidget {
  const _ModeGrid({
    required this.selectedModeId,
    required this.onSelected,
  });

  final String selectedModeId;
  final ValueChanged<PlayGameMode> onSelected;

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        final twoColumns = constraints.maxWidth >= 620;
        final itemWidth =
            twoColumns ? (constraints.maxWidth - 12) / 2 : constraints.maxWidth;

        return Wrap(
          spacing: 12,
          runSpacing: 12,
          children: [
            for (final mode in playGameModes)
              SizedBox(
                width: itemWidth,
                child: _ModeCard(
                  mode: mode,
                  selected: mode.id == selectedModeId,
                  onTap: () => onSelected(mode),
                ),
              ),
          ],
        );
      },
    );
  }
}

class _ModeCard extends StatelessWidget {
  const _ModeCard({
    required this.mode,
    required this.selected,
    required this.onTap,
  });

  final PlayGameMode mode;
  final bool selected;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final accent = _modeColor(mode.id, scheme);

    return ManaSurfaceCard(
      onTap: onTap,
      borderColor: selected
          ? accent.withValues(alpha: 0.75)
          : scheme.outlineVariant.withValues(alpha: 0.28),
      backgroundColor: selected
          ? accent.withValues(alpha: 0.14)
          : scheme.surfaceContainerHigh,
      child: Row(
        children: [
          Container(
            width: 42,
            height: 42,
            decoration: BoxDecoration(
              color: accent.withValues(alpha: 0.18),
              borderRadius: BorderRadius.circular(12),
              border: Border.all(color: accent.withValues(alpha: 0.42)),
            ),
            child: Icon(_modeIcon(mode.id), color: accent),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  mode.name,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  mode.subtitle,
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.bodySmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                    height: 1.2,
                  ),
                ),
                const SizedBox(height: 8),
                Text(
                  '${mode.startingLife} vida · ${mode.supportedPlayers.join('/')}P',
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.labelSmall?.copyWith(
                    color: accent,
                    fontWeight: FontWeight.w800,
                  ),
                ),
              ],
            ),
          ),
          if (selected) ...[
            const SizedBox(width: 8),
            Icon(Icons.check_circle_rounded, color: accent),
          ],
        ],
      ),
    );
  }
}

class _PlayersPicker extends StatelessWidget {
  const _PlayersPicker({
    required this.mode,
    required this.selectedPlayers,
    required this.onSelected,
  });

  final PlayGameMode mode;
  final int selectedPlayers;
  final ValueChanged<int> onSelected;

  @override
  Widget build(BuildContext context) {
    return _LabeledControl(
      title: 'Jogadores',
      child: Wrap(
        spacing: 8,
        runSpacing: 8,
        children: [
          for (final players in mode.supportedPlayers)
            ChoiceChip(
              label: Text('$players'),
              selected: players == selectedPlayers,
              onSelected: (_) => onSelected(players),
            ),
        ],
      ),
    );
  }
}

class _VariantPicker extends StatelessWidget {
  const _VariantPicker({
    required this.mode,
    required this.selectedVariant,
    required this.onSelected,
  });

  final PlayGameMode mode;
  final String selectedVariant;
  final ValueChanged<String> onSelected;

  @override
  Widget build(BuildContext context) {
    return _LabeledControl(
      title: 'Variante',
      child: Wrap(
        spacing: 8,
        runSpacing: 8,
        children: [
          for (final variant in mode.variants)
            ChoiceChip(
              label: Text(variant),
              selected: variant == selectedVariant,
              onSelected: (_) => onSelected(variant),
            ),
        ],
      ),
    );
  }
}

class _StartingLifeStepper extends StatelessWidget {
  const _StartingLifeStepper({
    required this.value,
    required this.defaultValue,
    required this.onChanged,
    required this.onReset,
  });

  final int value;
  final int defaultValue;
  final ValueChanged<int> onChanged;
  final VoidCallback onReset;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return _LabeledControl(
      title: 'Vida inicial',
      child: Row(
        children: [
          IconButton.filledTonal(
            onPressed: () => onChanged(value - 1),
            icon: const Icon(Icons.remove_rounded),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Center(
              child: FittedBox(
                fit: BoxFit.scaleDown,
                child: Text(
                  '$value',
                  style: theme.textTheme.headlineMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                    letterSpacing: 0,
                  ),
                ),
              ),
            ),
          ),
          const SizedBox(width: 12),
          IconButton.filledTonal(
            onPressed: () => onChanged(value + 1),
            icon: const Icon(Icons.add_rounded),
          ),
          const SizedBox(width: 8),
          Tooltip(
            message: 'Padrão do formato',
            child: IconButton(
              onPressed: value == defaultValue ? null : onReset,
              icon: Icon(
                Icons.restart_alt_rounded,
                color: value == defaultValue ? scheme.onSurfaceVariant : null,
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class _VisualThemePicker extends StatelessWidget {
  const _VisualThemePicker({
    required this.selectedThemeId,
    required this.onSelected,
  });

  final String selectedThemeId;
  final ValueChanged<String> onSelected;

  @override
  Widget build(BuildContext context) {
    return Wrap(
      spacing: 10,
      runSpacing: 10,
      children: [
        for (final visualTheme in playVisualThemes)
          _VisualThemeTile(
            visualTheme: visualTheme,
            selected: visualTheme.id == selectedThemeId,
            onTap: () => onSelected(visualTheme.id),
          ),
      ],
    );
  }
}

class _VisualThemeTile extends StatelessWidget {
  const _VisualThemeTile({
    required this.visualTheme,
    required this.selected,
    required this.onTap,
  });

  final PlayVisualTheme visualTheme;
  final bool selected;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return SizedBox(
      width: 168,
      child: ManaSurfaceCard(
        onTap: onTap,
        borderColor: selected
            ? visualTheme.primary.withValues(alpha: 0.8)
            : scheme.outlineVariant.withValues(alpha: 0.28),
        child: Row(
          children: [
            SizedBox(
              width: 42,
              height: 42,
              child: Stack(
                children: [
                  Positioned.fill(
                    child: DecoratedBox(
                      decoration: BoxDecoration(
                        color: visualTheme.table,
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                  ),
                  Align(
                    alignment: Alignment.topRight,
                    child: _ThemeDot(color: visualTheme.primary),
                  ),
                  Align(
                    alignment: Alignment.bottomLeft,
                    child: _ThemeDot(color: visualTheme.secondary),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 10),
            Expanded(
              child: Text(
                visualTheme.name,
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                style: theme.textTheme.labelLarge?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
              ),
            ),
            if (selected)
              Icon(
                Icons.check_rounded,
                size: 18,
                color: visualTheme.primary,
              ),
          ],
        ),
      ),
    );
  }
}

class _ThemeDot extends StatelessWidget {
  const _ThemeDot({required this.color});

  final Color color;

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 18,
      height: 18,
      decoration: BoxDecoration(
        color: color,
        shape: BoxShape.circle,
        border: Border.all(
          color: Theme.of(context).colorScheme.surface.withValues(alpha: 0.8),
          width: 2,
        ),
      ),
    );
  }
}

class _TemplatePicker extends StatelessWidget {
  const _TemplatePicker({
    required this.templates,
    required this.selectedTemplateId,
    required this.theme,
    required this.players,
    required this.onSelected,
  });

  final List<PlayTableTemplate> templates;
  final String selectedTemplateId;
  final PlayVisualTheme theme;
  final int players;
  final ValueChanged<String> onSelected;

  @override
  Widget build(BuildContext context) {
    if (templates.isEmpty) return const SizedBox.shrink();

    return LayoutBuilder(
      builder: (context, constraints) {
        final twoColumns = constraints.maxWidth >= 620;
        final width =
            twoColumns ? (constraints.maxWidth - 12) / 2 : constraints.maxWidth;

        return Wrap(
          spacing: 12,
          runSpacing: 12,
          children: [
            for (final template in templates)
              SizedBox(
                width: width,
                child: _TemplateTile(
                  template: template,
                  selected: template.id == selectedTemplateId,
                  visualTheme: theme,
                  players: players,
                  onTap: () => onSelected(template.id),
                ),
              ),
          ],
        );
      },
    );
  }
}

class _TemplateTile extends StatelessWidget {
  const _TemplateTile({
    required this.template,
    required this.selected,
    required this.visualTheme,
    required this.players,
    required this.onTap,
  });

  final PlayTableTemplate template;
  final bool selected;
  final PlayVisualTheme visualTheme;
  final int players;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return ManaSurfaceCard(
      onTap: onTap,
      borderColor: selected
          ? visualTheme.primary.withValues(alpha: 0.85)
          : scheme.outlineVariant.withValues(alpha: 0.28),
      child: Row(
        children: [
          SizedBox(
            width: 96,
            height: 72,
            child: _TemplatePreview(
              template: template,
              players: players,
              visualTheme: visualTheme,
            ),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  template.name,
                  maxLines: 1,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.titleSmall?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  template.subtitle,
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                  style: theme.textTheme.bodySmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                    height: 1.2,
                  ),
                ),
              ],
            ),
          ),
          if (selected) ...[
            const SizedBox(width: 8),
            Icon(Icons.check_circle_rounded, color: visualTheme.primary),
          ],
        ],
      ),
    );
  }
}

class _TemplatePreview extends StatelessWidget {
  const _TemplatePreview({
    required this.template,
    required this.players,
    required this.visualTheme,
  });

  final PlayTableTemplate template;
  final int players;
  final PlayVisualTheme visualTheme;

  @override
  Widget build(BuildContext context) {
    return CustomPaint(
      painter: _TemplatePreviewPainter(
        template: template,
        players: players,
        visualTheme: visualTheme,
        surface: Theme.of(context).colorScheme.surfaceContainerHighest,
      ),
    );
  }
}

class _TemplatePreviewPainter extends CustomPainter {
  const _TemplatePreviewPainter({
    required this.template,
    required this.players,
    required this.visualTheme,
    required this.surface,
  });

  final PlayTableTemplate template;
  final int players;
  final PlayVisualTheme visualTheme;
  final Color surface;

  @override
  void paint(Canvas canvas, Size size) {
    final tableRect = Rect.fromCenter(
      center: size.center(Offset.zero),
      width: size.width * 0.58,
      height: size.height * 0.42,
    );
    final tablePaint = Paint()
      ..color = visualTheme.table
      ..style = PaintingStyle.fill;
    final borderPaint = Paint()
      ..color = visualTheme.primary.withValues(alpha: 0.7)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;
    final seatPaint = Paint()
      ..color = visualTheme.secondary
      ..style = PaintingStyle.fill;

    canvas.drawRRect(
      RRect.fromRectAndRadius(tableRect, const Radius.circular(18)),
      tablePaint,
    );
    canvas.drawRRect(
      RRect.fromRectAndRadius(tableRect, const Radius.circular(18)),
      borderPaint,
    );

    final seats = seatCentersForTemplate(template, players);
    for (final seat in seats) {
      final center = Offset(seat.dx * size.width, seat.dy * size.height);
      canvas.drawCircle(center, 5.2, seatPaint);
      canvas.drawCircle(
        center,
        6.8,
        Paint()
          ..color = surface.withValues(alpha: 0.52)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1,
      );
    }
  }

  @override
  bool shouldRepaint(covariant _TemplatePreviewPainter oldDelegate) {
    return oldDelegate.template != template ||
        oldDelegate.players != players ||
        oldDelegate.visualTheme != visualTheme ||
        oldDelegate.surface != surface;
  }
}

class _LabeledControl extends StatelessWidget {
  const _LabeledControl({
    required this.title,
    required this.child,
  });

  final String title;
  final Widget child;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Text(
          title,
          maxLines: 1,
          overflow: TextOverflow.ellipsis,
          style: theme.textTheme.labelLarge?.copyWith(
            color: scheme.onSurfaceVariant,
            fontWeight: FontWeight.w800,
          ),
        ),
        const SizedBox(height: 8),
        child,
      ],
    );
  }
}

IconData _modeIcon(String modeId) {
  return switch (modeId) {
    'commander' => Icons.groups_rounded,
    'duel_commander' => Icons.sports_martial_arts_rounded,
    'standard' => Icons.style_rounded,
    'modern' => Icons.bolt_rounded,
    'pauper' => Icons.handyman_rounded,
    'legacy' => Icons.history_edu_rounded,
    'brawl' => Icons.shield_rounded,
    _ => Icons.auto_awesome_rounded,
  };
}

Color _modeColor(String modeId, ColorScheme scheme) {
  return switch (modeId) {
    'commander' => scheme.primary,
    'duel_commander' => const Color(0xFFFFB86C),
    'standard' => scheme.secondary,
    'modern' => const Color(0xFFFFD166),
    'pauper' => const Color(0xFF50FA7B),
    'legacy' => const Color(0xFFFF79C6),
    'brawl' => const Color(0xFF8BE9FD),
    _ => scheme.tertiary,
  };
}
