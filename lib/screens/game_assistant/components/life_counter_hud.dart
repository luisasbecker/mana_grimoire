import 'package:flutter/material.dart';

import '../types/game_assistant_types.dart';

class LifeCounterHUD extends StatelessWidget {
  const LifeCounterHUD({
    super.key,
    required this.players,
    required this.onIncrement,
    required this.onDecrement,
  });

  final List<GameAssistantPlayer> players;
  final ValueChanged<int> onIncrement;
  final ValueChanged<int> onDecrement;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 74,
      child: ListView.separated(
        scrollDirection: Axis.horizontal,
        padding: const EdgeInsets.symmetric(horizontal: 12),
        itemCount: players.length,
        separatorBuilder: (_, __) => const SizedBox(width: 8),
        itemBuilder: (context, index) {
          return _LifeCounterTile(
            player: players[index],
            onIncrement: () => onIncrement(index),
            onDecrement: () => onDecrement(index),
          );
        },
      ),
    );
  }
}

class _LifeCounterTile extends StatelessWidget {
  const _LifeCounterTile({
    required this.player,
    required this.onIncrement,
    required this.onDecrement,
  });

  final GameAssistantPlayer player;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return DecoratedBox(
      decoration: BoxDecoration(
        color: Colors.black.withValues(alpha: 0.66),
        borderRadius: BorderRadius.circular(18),
        border: Border.all(color: scheme.primary.withValues(alpha: 0.34)),
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 7),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            _SmallRoundButton(
              icon: Icons.remove_rounded,
              tooltip: 'Diminuir vida',
              onPressed: onDecrement,
            ),
            const SizedBox(width: 7),
            SizedBox(
              width: 58,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text(
                    player.name,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: theme.textTheme.labelSmall?.copyWith(
                      color: Colors.white.withValues(alpha: 0.76),
                      fontWeight: FontWeight.w800,
                    ),
                  ),
                  FittedBox(
                    fit: BoxFit.scaleDown,
                    child: Text(
                      '${player.life}',
                      style: theme.textTheme.headlineSmall?.copyWith(
                        color: Colors.white,
                        fontWeight: FontWeight.w900,
                        letterSpacing: 0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 7),
            _SmallRoundButton(
              icon: Icons.add_rounded,
              tooltip: 'Aumentar vida',
              onPressed: onIncrement,
            ),
          ],
        ),
      ),
    );
  }
}

class _SmallRoundButton extends StatelessWidget {
  const _SmallRoundButton({
    required this.icon,
    required this.tooltip,
    required this.onPressed,
  });

  final IconData icon;
  final String tooltip;
  final VoidCallback onPressed;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return Tooltip(
      message: tooltip,
      child: SizedBox.square(
        dimension: 32,
        child: IconButton.filledTonal(
          padding: EdgeInsets.zero,
          style: IconButton.styleFrom(
            backgroundColor: scheme.primary.withValues(alpha: 0.20),
            foregroundColor: Colors.white,
          ),
          onPressed: onPressed,
          icon: Icon(icon, size: 18),
        ),
      ),
    );
  }
}
