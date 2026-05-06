import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../app/router.dart';
import 'play_game_catalog.dart';
import 'play_session_controller.dart';

class PlaySessionScreen extends ConsumerWidget {
  const PlaySessionScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final t = AppLocalizations.of(context)!;
    final session = ref.watch(playSessionControllerProvider);
    final controller = ref.read(playSessionControllerProvider.notifier);
    final visualTheme = session.visualTheme;

    if (!session.hasSession) {
      return _NoSessionScreen(scheme: scheme);
    }

    return Scaffold(
      backgroundColor: Color.lerp(scheme.surface, visualTheme.table, 0.22),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.fromLTRB(10, 8, 10, 10),
          child: Column(
            children: [
              _SessionHeader(session: session),
              const SizedBox(height: 8),
              Expanded(
                child: _TableStage(
                  session: session,
                  controller: controller,
                  playerLabel: (index) => _playerLabel(t, index),
                  onGrimoirePressed: () => _openGrimoireSheet(
                    context: context,
                    theme: theme,
                    scheme: scheme,
                    t: t,
                    controller: controller,
                    session: session,
                  ),
                  onCountersPressed: (index) => _openPlayerCountersSheet(
                    context: context,
                    playerIndex: index,
                    playerLabel: (player) => _playerLabel(t, player),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  String _playerLabel(AppLocalizations t, int index) {
    return switch (index) {
      0 => t.playPlayerOneLabel,
      1 => t.playPlayerTwoLabel,
      _ => 'Jogador ${index + 1}',
    };
  }

  Future<void> _openGrimoireSheet({
    required BuildContext context,
    required ThemeData theme,
    required ColorScheme scheme,
    required AppLocalizations t,
    required PlaySessionController controller,
    required PlaySessionState session,
  }) {
    return showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      backgroundColor: scheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => Padding(
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              t.playGrimoireTitle,
              textAlign: TextAlign.center,
              style: theme.textTheme.titleLarge?.copyWith(
                fontWeight: FontWeight.w900,
              ),
            ),
            const SizedBox(height: 8),
            Text(
              '${session.mode} · ${session.variant} · ${session.tableTemplate.name}',
              textAlign: TextAlign.center,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              style: theme.textTheme.bodySmall?.copyWith(
                color: scheme.onSurfaceVariant,
              ),
            ),
            const SizedBox(height: 16),
            FilledButton.icon(
              onPressed: () {
                Navigator.of(ctx).pop();
                context.goNamed(AppRoutes.homeHub);
              },
              icon: const Icon(Icons.home_rounded),
              label: Text(t.playGoHomeCta),
            ),
            const SizedBox(height: 8),
            OutlinedButton.icon(
              onPressed: () {
                controller.clear();
                Navigator.of(ctx).pop();
                context.goNamed(AppRoutes.play);
              },
              icon: const Icon(Icons.flag_rounded),
              label: const Text('Encerrar partida'),
            ),
          ],
        ),
      ),
    );
  }

  Future<void> _openPlayerCountersSheet({
    required BuildContext context,
    required int playerIndex,
    required String Function(int index) playerLabel,
  }) {
    return showModalBottomSheet<void>(
      context: context,
      isScrollControlled: true,
      showDragHandle: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) {
        return Consumer(
          builder: (context, ref, _) {
            final theme = Theme.of(context);
            final scheme = theme.colorScheme;
            final session = ref.watch(playSessionControllerProvider);
            final controller = ref.read(playSessionControllerProvider.notifier);
            final counters = session.countersAt(playerIndex);

            return SafeArea(
              child: Padding(
                padding: EdgeInsets.fromLTRB(
                  16,
                  8,
                  16,
                  MediaQuery.viewInsetsOf(context).bottom + 16,
                ),
                child: ConstrainedBox(
                  constraints: BoxConstraints(
                    maxHeight: MediaQuery.sizeOf(context).height * 0.78,
                  ),
                  child: ListView(
                    shrinkWrap: true,
                    children: [
                      Text(
                        playerLabel(playerIndex),
                        textAlign: TextAlign.center,
                        style: theme.textTheme.titleLarge?.copyWith(
                          fontWeight: FontWeight.w900,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(
                        'Marcadores e dano de comandante',
                        textAlign: TextAlign.center,
                        style: theme.textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                          fontWeight: FontWeight.w700,
                        ),
                      ),
                      const SizedBox(height: 16),
                      for (final definition in _counterDefinitions(scheme))
                        _CounterAdjustRow(
                          icon: definition.icon,
                          label: definition.label,
                          value: counters.valueFor(definition.type),
                          accent: definition.color,
                          onIncrement: () => controller.incrementCounter(
                            playerIndex,
                            definition.type,
                          ),
                          onDecrement: () => controller.decrementCounter(
                            playerIndex,
                            definition.type,
                          ),
                        ),
                      const SizedBox(height: 12),
                      Divider(color: scheme.outlineVariant),
                      const SizedBox(height: 8),
                      Text(
                        'Dano de comandante recebido',
                        style: theme.textTheme.titleSmall?.copyWith(
                          fontWeight: FontWeight.w900,
                        ),
                      ),
                      const SizedBox(height: 8),
                      for (var sourceIndex = 0;
                          sourceIndex < session.players;
                          sourceIndex++)
                        if (sourceIndex != playerIndex)
                          _CommanderDamageRow(
                            label: 'De ${playerLabel(sourceIndex)}',
                            value: session.commanderDamageAt(
                              playerIndex: playerIndex,
                              sourceIndex: sourceIndex,
                            ),
                            accent: _playerAccent(
                              sourceIndex,
                              session.visualTheme,
                            ),
                            onIncrement: () =>
                                controller.incrementCommanderDamage(
                              playerIndex: playerIndex,
                              sourceIndex: sourceIndex,
                            ),
                            onDecrement: () =>
                                controller.decrementCommanderDamage(
                              playerIndex: playerIndex,
                              sourceIndex: sourceIndex,
                            ),
                          ),
                    ],
                  ),
                ),
              ),
            );
          },
        );
      },
    );
  }
}

class _NoSessionScreen extends StatelessWidget {
  const _NoSessionScreen({required this.scheme});

  final ColorScheme scheme;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      body: SafeArea(
        child: Center(
          child: Padding(
            padding: const EdgeInsets.all(24),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Icon(
                  Icons.table_restaurant_rounded,
                  size: 48,
                  color: scheme.primary,
                ),
                const SizedBox(height: 12),
                Text(
                  'Nenhuma partida ativa',
                  textAlign: TextAlign.center,
                  style: theme.textTheme.titleLarge?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(height: 14),
                FilledButton.icon(
                  onPressed: () => context.goNamed(AppRoutes.play),
                  icon: const Icon(Icons.tune_rounded),
                  label: const Text('Configurar mesa'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

class _SessionHeader extends StatelessWidget {
  const _SessionHeader({required this.session});

  final PlaySessionState session;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Row(
      children: [
        Tooltip(
          message: 'Voltar',
          child: IconButton.filledTonal(
            onPressed: () {
              if (Navigator.of(context).canPop()) {
                context.pop();
              } else {
                context.goNamed(AppRoutes.play);
              }
            },
            icon: const Icon(Icons.close_rounded),
          ),
        ),
        const SizedBox(width: 8),
        Expanded(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                session.mode,
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                textAlign: TextAlign.center,
                style: theme.textTheme.titleMedium?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
              ),
              const SizedBox(height: 2),
              Text(
                '${session.variant} · ${session.players}P · ${session.tableTemplate.name}',
                maxLines: 1,
                overflow: TextOverflow.ellipsis,
                textAlign: TextAlign.center,
                style: theme.textTheme.labelSmall?.copyWith(
                  color: scheme.onSurfaceVariant,
                  fontWeight: FontWeight.w700,
                ),
              ),
            ],
          ),
        ),
        const SizedBox(width: 8),
        SizedBox(
          width: 48,
          height: 48,
          child: DecoratedBox(
            decoration: BoxDecoration(
              color: session.visualTheme.primary.withValues(alpha: 0.16),
              borderRadius: BorderRadius.circular(14),
              border: Border.all(
                color: session.visualTheme.primary.withValues(alpha: 0.35),
              ),
            ),
            child: Icon(
              Icons.auto_awesome_rounded,
              color: session.visualTheme.primary,
            ),
          ),
        ),
      ],
    );
  }
}

class _TableStage extends StatelessWidget {
  const _TableStage({
    required this.session,
    required this.controller,
    required this.playerLabel,
    required this.onGrimoirePressed,
    required this.onCountersPressed,
  });

  final PlaySessionState session;
  final PlaySessionController controller;
  final String Function(int index) playerLabel;
  final VoidCallback onGrimoirePressed;
  final ValueChanged<int> onCountersPressed;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final template = session.tableTemplate;
    final visualTheme = session.visualTheme;
    final seats = seatCentersForTemplate(template, session.players);

    return LayoutBuilder(
      builder: (context, constraints) {
        final stageSize = constraints.biggest;
        final seatSize = _seatSizeFor(session.players, stageSize);
        final grimoireSize = session.players >= 5 ? 62.0 : 78.0;

        return ClipRRect(
          borderRadius: BorderRadius.circular(24),
          child: Stack(
            children: [
              Positioned.fill(
                child: CustomPaint(
                  painter: _ManaTablePainter(
                    seats: seats,
                    visualTheme: visualTheme,
                    surface: scheme.surface,
                    outline: scheme.outlineVariant,
                  ),
                ),
              ),
              if (session.players == 1)
                Positioned(
                  right: 16,
                  bottom: 16,
                  child: _GrimoireButton(
                    size: grimoireSize,
                    visualTheme: visualTheme,
                    onPressed: onGrimoirePressed,
                  ),
                )
              else
                Center(
                  child: _GrimoireButton(
                    size: grimoireSize,
                    visualTheme: visualTheme,
                    onPressed: onGrimoirePressed,
                  ),
                ),
              for (var index = 0; index < session.players; index++)
                _SeatPositioned(
                  center: seats[index],
                  stageSize: stageSize,
                  seatSize: seatSize,
                  child: Transform.rotate(
                    angle: readableSeatRotation(seats[index]),
                    child: _LifeSeat(
                      label: playerLabel(index),
                      value: session.lifeAt(index),
                      counters: session.countersAt(index),
                      commanderDamage: session.maxCommanderDamageAt(index),
                      accent: _playerAccent(index, visualTheme),
                      compact: session.players >= 5 || seatSize.width < 160,
                      onAdd: () => controller.incrementLife(index),
                      onSub: () => controller.decrementLife(index),
                      onCountersPressed: () => onCountersPressed(index),
                    ),
                  ),
                ),
            ],
          ),
        );
      },
    );
  }

  Size _seatSizeFor(int players, Size stageSize) {
    final width = switch (players) {
      1 => stageSize.width * 0.68,
      2 => stageSize.width * 0.70,
      3 => stageSize.width * 0.48,
      4 => stageSize.width * 0.42,
      5 => stageSize.width * 0.34,
      6 => stageSize.width * 0.31,
      _ => stageSize.width * 0.28,
    };
    final height = switch (players) {
      1 => stageSize.height * 0.34,
      2 => stageSize.height * 0.22,
      3 => stageSize.height * 0.20,
      4 => stageSize.height * 0.19,
      5 => stageSize.height * 0.18,
      6 => stageSize.height * 0.17,
      _ => stageSize.height * 0.16,
    };

    return Size(
      width.clamp(104.0, 360.0).toDouble(),
      height.clamp(86.0, 190.0).toDouble(),
    );
  }
}

class _SeatPositioned extends StatelessWidget {
  const _SeatPositioned({
    required this.center,
    required this.stageSize,
    required this.seatSize,
    required this.child,
  });

  final Offset center;
  final Size stageSize;
  final Size seatSize;
  final Widget child;

  @override
  Widget build(BuildContext context) {
    final left = (center.dx * stageSize.width - seatSize.width / 2)
        .clamp(
          0.0,
          stageSize.width - seatSize.width,
        )
        .toDouble();
    final top = (center.dy * stageSize.height - seatSize.height / 2)
        .clamp(
          0.0,
          stageSize.height - seatSize.height,
        )
        .toDouble();

    return Positioned(
      left: left,
      top: top,
      width: seatSize.width,
      height: seatSize.height,
      child: child,
    );
  }
}

class _ManaTablePainter extends CustomPainter {
  const _ManaTablePainter({
    required this.seats,
    required this.visualTheme,
    required this.surface,
    required this.outline,
  });

  final List<Offset> seats;
  final PlayVisualTheme visualTheme;
  final Color surface;
  final Color outline;

  @override
  void paint(Canvas canvas, Size size) {
    final rect = Offset.zero & size;
    final bgPaint = Paint()
      ..shader = LinearGradient(
        begin: Alignment.topLeft,
        end: Alignment.bottomRight,
        colors: [
          visualTheme.table.withValues(alpha: 0.92),
          surface.withValues(alpha: 0.90),
        ],
      ).createShader(rect);
    canvas.drawRect(rect, bgPaint);

    final tableRect = Rect.fromCenter(
      center: size.center(Offset.zero),
      width: size.width * 0.56,
      height: size.height * 0.40,
    );
    final tableRadius = Radius.circular(size.shortestSide * 0.12);
    final table = RRect.fromRectAndRadius(tableRect, tableRadius);
    final tablePaint = Paint()
      ..color = visualTheme.table.withValues(alpha: 0.88)
      ..style = PaintingStyle.fill;
    final tableBorder = Paint()
      ..color = visualTheme.primary.withValues(alpha: 0.55)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2;
    final connectorPaint = Paint()
      ..color = visualTheme.secondary.withValues(alpha: 0.28)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.2;

    canvas.drawRRect(table, tablePaint);
    canvas.drawRRect(table, tableBorder);

    final center = size.center(Offset.zero);
    for (final seat in seats) {
      final seatCenter = Offset(seat.dx * size.width, seat.dy * size.height);
      canvas.drawLine(center, seatCenter, connectorPaint);
      canvas.drawCircle(
        seatCenter,
        34,
        Paint()
          ..color = visualTheme.primary.withValues(alpha: 0.08)
          ..style = PaintingStyle.fill,
      );
      canvas.drawCircle(
        seatCenter,
        35,
        Paint()
          ..color = outline.withValues(alpha: 0.34)
          ..style = PaintingStyle.stroke
          ..strokeWidth = 1,
      );
    }

    final pipPaint = Paint()..style = PaintingStyle.fill;
    final pipRadius = size.shortestSide * 0.012;
    final pipOffsets = [
      const Offset(0.35, 0.34),
      const Offset(0.65, 0.34),
      const Offset(0.5, 0.5),
      const Offset(0.35, 0.66),
      const Offset(0.65, 0.66),
    ];
    for (var index = 0; index < pipOffsets.length; index++) {
      pipPaint.color =
          (index.isEven ? visualTheme.primary : visualTheme.secondary)
              .withValues(alpha: 0.45);
      final pip = Offset(
        tableRect.left + tableRect.width * pipOffsets[index].dx,
        tableRect.top + tableRect.height * pipOffsets[index].dy,
      );
      canvas.drawCircle(pip, pipRadius.clamp(4.0, 8.0).toDouble(), pipPaint);
    }
  }

  @override
  bool shouldRepaint(covariant _ManaTablePainter oldDelegate) {
    return oldDelegate.seats != seats ||
        oldDelegate.visualTheme != visualTheme ||
        oldDelegate.surface != surface ||
        oldDelegate.outline != outline;
  }
}

class _GrimoireButton extends StatelessWidget {
  const _GrimoireButton({
    required this.size,
    required this.visualTheme,
    required this.onPressed,
  });

  final double size;
  final PlayVisualTheme visualTheme;
  final VoidCallback onPressed;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;

    return SizedBox.square(
      dimension: size,
      child: DecoratedBox(
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [
              visualTheme.primary.withValues(alpha: 0.86),
              visualTheme.table.withValues(alpha: 0.94),
            ],
          ),
          border: Border.all(
            color: visualTheme.secondary.withValues(alpha: 0.62),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withValues(alpha: 0.36),
              blurRadius: 18,
              offset: const Offset(0, 10),
            ),
            BoxShadow(
              color: visualTheme.primary.withValues(alpha: 0.28),
              blurRadius: 20,
            ),
          ],
        ),
        child: Material(
          color: Colors.transparent,
          child: InkWell(
            onTap: onPressed,
            customBorder: const CircleBorder(),
            child: Tooltip(
              message: 'Grimório',
              child: Icon(
                Icons.menu_book_rounded,
                size: size * 0.42,
                color: scheme.onPrimaryContainer,
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _LifeSeat extends StatelessWidget {
  const _LifeSeat({
    required this.label,
    required this.value,
    required this.counters,
    required this.commanderDamage,
    required this.accent,
    required this.onAdd,
    required this.onSub,
    required this.onCountersPressed,
    required this.compact,
  });

  final String label;
  final int value;
  final PlayPlayerCounters counters;
  final int commanderDamage;
  final Color accent;
  final VoidCallback onAdd;
  final VoidCallback onSub;
  final VoidCallback onCountersPressed;
  final bool compact;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return DecoratedBox(
      decoration: BoxDecoration(
        color: scheme.surfaceContainerHigh.withValues(alpha: 0.88),
        borderRadius: BorderRadius.circular(18),
        border: Border.all(color: accent.withValues(alpha: 0.62), width: 1.2),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.24),
            blurRadius: 18,
            offset: const Offset(0, 10),
          ),
        ],
      ),
      child: Padding(
        padding: EdgeInsets.symmetric(
          horizontal: compact ? 8 : 12,
          vertical: compact ? 8 : 10,
        ),
        child: compact ? _compactContent(theme) : _wideContent(theme),
      ),
    );
  }

  Widget _compactContent(ThemeData theme) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        _SeatLabel(
          label: label,
          accent: accent,
          onCountersPressed: onCountersPressed,
        ),
        const SizedBox(height: 4),
        _CounterSummary(
          counters: counters,
          commanderDamage: commanderDamage,
          compact: true,
        ),
        const SizedBox(height: 4),
        Expanded(
          child: FittedBox(
            fit: BoxFit.scaleDown,
            child: Text(
              '$value',
              style: theme.textTheme.displaySmall?.copyWith(
                fontWeight: FontWeight.w900,
                letterSpacing: 0,
              ),
            ),
          ),
        ),
        const SizedBox(height: 4),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            _LifeActionButton(
              icon: Icons.remove_rounded,
              tooltip: 'Diminuir vida',
              accent: accent,
              onPressed: onSub,
              compact: true,
            ),
            const SizedBox(width: 10),
            _LifeActionButton(
              icon: Icons.add_rounded,
              tooltip: 'Aumentar vida',
              accent: accent,
              onPressed: onAdd,
              compact: true,
            ),
          ],
        ),
      ],
    );
  }

  Widget _wideContent(ThemeData theme) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        _SeatLabel(
          label: label,
          accent: accent,
          onCountersPressed: onCountersPressed,
        ),
        const SizedBox(height: 6),
        _CounterSummary(
          counters: counters,
          commanderDamage: commanderDamage,
          compact: false,
        ),
        const SizedBox(height: 8),
        Expanded(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              _LifeActionButton(
                icon: Icons.remove_rounded,
                tooltip: 'Diminuir vida',
                accent: accent,
                onPressed: onSub,
                compact: false,
              ),
              const SizedBox(width: 12),
              Expanded(
                child: FittedBox(
                  fit: BoxFit.scaleDown,
                  child: Text(
                    '$value',
                    style: theme.textTheme.displayMedium?.copyWith(
                      fontWeight: FontWeight.w900,
                      letterSpacing: 0,
                    ),
                  ),
                ),
              ),
              const SizedBox(width: 12),
              _LifeActionButton(
                icon: Icons.add_rounded,
                tooltip: 'Aumentar vida',
                accent: accent,
                onPressed: onAdd,
                compact: false,
              ),
            ],
          ),
        ),
      ],
    );
  }
}

class _SeatLabel extends StatelessWidget {
  const _SeatLabel({
    required this.label,
    required this.accent,
    required this.onCountersPressed,
  });

  final String label;
  final Color accent;
  final VoidCallback onCountersPressed;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Container(
          width: 8,
          height: 8,
          decoration: BoxDecoration(color: accent, shape: BoxShape.circle),
        ),
        const SizedBox(width: 6),
        Flexible(
          child: Text(
            label,
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
            style: theme.textTheme.labelMedium?.copyWith(
              color: scheme.onSurfaceVariant,
              fontWeight: FontWeight.w800,
            ),
          ),
        ),
        const SizedBox(width: 4),
        Tooltip(
          message: 'Marcadores',
          child: SizedBox.square(
            dimension: 28,
            child: IconButton(
              padding: EdgeInsets.zero,
              visualDensity: VisualDensity.compact,
              onPressed: onCountersPressed,
              icon: Icon(
                Icons.tune_rounded,
                size: 18,
                color: accent,
              ),
            ),
          ),
        ),
      ],
    );
  }
}

class _CounterSummary extends StatelessWidget {
  const _CounterSummary({
    required this.counters,
    required this.commanderDamage,
    required this.compact,
  });

  final PlayPlayerCounters counters;
  final int commanderDamage;
  final bool compact;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;

    return FittedBox(
      fit: BoxFit.scaleDown,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          _CounterBadge(
            icon: Icons.science_rounded,
            label: compact ? 'V' : 'Veneno',
            value: counters.poison,
            color: const Color(0xFF50FA7B),
          ),
          const SizedBox(width: 5),
          _CounterBadge(
            icon: Icons.shield_rounded,
            label: compact ? 'CMD' : 'Cmd',
            value: commanderDamage,
            color: scheme.primary,
            highlighted: commanderDamage >= 21,
          ),
          const SizedBox(width: 5),
          _CounterBadge(
            icon: Icons.bolt_rounded,
            label: compact ? 'E' : 'Energia',
            value: counters.energy,
            color: scheme.secondary,
          ),
        ],
      ),
    );
  }
}

class _CounterBadge extends StatelessWidget {
  const _CounterBadge({
    required this.icon,
    required this.label,
    required this.value,
    required this.color,
    this.highlighted = false,
  });

  final IconData icon;
  final String label;
  final int value;
  final Color color;
  final bool highlighted;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final foreground = highlighted ? scheme.error : color;

    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 3),
      decoration: BoxDecoration(
        color: foreground.withValues(alpha: highlighted ? 0.24 : 0.14),
        borderRadius: BorderRadius.circular(7),
        border: Border.all(color: foreground.withValues(alpha: 0.35)),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(icon, size: 12, color: foreground),
          const SizedBox(width: 3),
          Text(
            '$label $value',
            style: TextStyle(
              color: foreground,
              fontSize: 10,
              fontWeight: FontWeight.w900,
              letterSpacing: 0,
            ),
          ),
        ],
      ),
    );
  }
}

class _LifeActionButton extends StatelessWidget {
  const _LifeActionButton({
    required this.icon,
    required this.tooltip,
    required this.accent,
    required this.onPressed,
    required this.compact,
  });

  final IconData icon;
  final String tooltip;
  final Color accent;
  final VoidCallback onPressed;
  final bool compact;

  @override
  Widget build(BuildContext context) {
    final size = compact ? 32.0 : 40.0;

    return Tooltip(
      message: tooltip,
      child: SizedBox.square(
        dimension: size,
        child: Material(
          color: accent.withValues(alpha: 0.18),
          shape: const CircleBorder(),
          child: InkWell(
            onTap: onPressed,
            customBorder: const CircleBorder(),
            child: Icon(icon, size: compact ? 19 : 23, color: accent),
          ),
        ),
      ),
    );
  }
}

Color _playerAccent(int index, PlayVisualTheme visualTheme) {
  const accents = [
    Color(0xFFE8D48B),
    Color(0xFF8BE9FD),
    Color(0xFFFF79C6),
    Color(0xFF50FA7B),
    Color(0xFFFFB86C),
    Color(0xFFFF5555),
    Color(0xFFBD93F9),
    Color(0xFFF8F8F2),
  ];
  if (index == 0) return visualTheme.primary;
  if (index == 1) return visualTheme.secondary;
  return accents[index % accents.length];
}

class _CounterDefinition {
  const _CounterDefinition({
    required this.type,
    required this.label,
    required this.icon,
    required this.color,
  });

  final PlayCounterType type;
  final String label;
  final IconData icon;
  final Color color;
}

List<_CounterDefinition> _counterDefinitions(ColorScheme scheme) {
  return [
    const _CounterDefinition(
      type: PlayCounterType.poison,
      label: 'Veneno',
      icon: Icons.science_rounded,
      color: Color(0xFF50FA7B),
    ),
    _CounterDefinition(
      type: PlayCounterType.energy,
      label: 'Energia',
      icon: Icons.bolt_rounded,
      color: scheme.secondary,
    ),
    const _CounterDefinition(
      type: PlayCounterType.experience,
      label: 'Experiência',
      icon: Icons.military_tech_rounded,
      color: Color(0xFFE8D48B),
    ),
    const _CounterDefinition(
      type: PlayCounterType.commanderTax,
      label: 'Taxa de comandante',
      icon: Icons.account_balance_rounded,
      color: Color(0xFFFFB86C),
    ),
    const _CounterDefinition(
      type: PlayCounterType.storm,
      label: 'Storm',
      icon: Icons.thunderstorm_rounded,
      color: Color(0xFF8BE9FD),
    ),
    _CounterDefinition(
      type: PlayCounterType.radiation,
      label: 'Radiação',
      icon: Icons.warning_amber_rounded,
      color: scheme.error,
    ),
  ];
}

class _CounterAdjustRow extends StatelessWidget {
  const _CounterAdjustRow({
    required this.icon,
    required this.label,
    required this.value,
    required this.accent,
    required this.onIncrement,
    required this.onDecrement,
  });

  final IconData icon;
  final String label;
  final int value;
  final Color accent;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;

  @override
  Widget build(BuildContext context) {
    return _AdjustRow(
      icon: icon,
      label: label,
      value: value,
      accent: accent,
      onIncrement: onIncrement,
      onDecrement: onDecrement,
    );
  }
}

class _CommanderDamageRow extends StatelessWidget {
  const _CommanderDamageRow({
    required this.label,
    required this.value,
    required this.accent,
    required this.onIncrement,
    required this.onDecrement,
  });

  final String label;
  final int value;
  final Color accent;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;

  @override
  Widget build(BuildContext context) {
    return _AdjustRow(
      icon: Icons.shield_rounded,
      label: label,
      value: value,
      accent: value >= 21 ? Theme.of(context).colorScheme.error : accent,
      onIncrement: onIncrement,
      onDecrement: onDecrement,
      trailingLabel: value >= 21 ? '21+' : null,
    );
  }
}

class _AdjustRow extends StatelessWidget {
  const _AdjustRow({
    required this.icon,
    required this.label,
    required this.value,
    required this.accent,
    required this.onIncrement,
    required this.onDecrement,
    this.trailingLabel,
  });

  final IconData icon;
  final String label;
  final int value;
  final Color accent;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;
  final String? trailingLabel;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 5),
      child: Container(
        padding: const EdgeInsets.fromLTRB(10, 8, 10, 8),
        decoration: BoxDecoration(
          color: scheme.surfaceContainerHighest.withValues(alpha: 0.5),
          borderRadius: BorderRadius.circular(12),
          border: Border.all(color: accent.withValues(alpha: 0.24)),
        ),
        child: Row(
          children: [
            Icon(icon, color: accent, size: 22),
            const SizedBox(width: 10),
            Expanded(
              child: Text(
                label,
                maxLines: 2,
                overflow: TextOverflow.ellipsis,
                style: theme.textTheme.bodyMedium?.copyWith(
                  fontWeight: FontWeight.w800,
                ),
              ),
            ),
            if (trailingLabel != null) ...[
              const SizedBox(width: 6),
              Text(
                trailingLabel!,
                style: theme.textTheme.labelSmall?.copyWith(
                  color: accent,
                  fontWeight: FontWeight.w900,
                ),
              ),
            ],
            const SizedBox(width: 8),
            _LifeActionButton(
              icon: Icons.remove_rounded,
              tooltip: 'Diminuir',
              accent: accent,
              onPressed: onDecrement,
              compact: true,
            ),
            SizedBox(
              width: 52,
              child: Text(
                '$value',
                textAlign: TextAlign.center,
                style: theme.textTheme.titleLarge?.copyWith(
                  fontWeight: FontWeight.w900,
                  letterSpacing: 0,
                ),
              ),
            ),
            _LifeActionButton(
              icon: Icons.add_rounded,
              tooltip: 'Aumentar',
              accent: accent,
              onPressed: onIncrement,
              compact: true,
            ),
          ],
        ),
      ),
    );
  }
}
