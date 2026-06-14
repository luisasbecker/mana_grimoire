import 'package:flutter/material.dart';

import '../types/game_assistant_types.dart';

class CardCounterControls extends StatelessWidget {
  const CardCounterControls({
    super.key,
    required this.card,
    required this.onIncrementCounter,
    required this.onDecrementCounter,
    required this.onIncrementDamage,
    required this.onDecrementDamage,
    required this.onIncrementPower,
    required this.onDecrementPower,
    required this.onIncrementToughness,
    required this.onDecrementToughness,
  });

  final GameAssistantTrackedCard card;
  final ValueChanged<GameAssistantCounterType> onIncrementCounter;
  final ValueChanged<GameAssistantCounterType> onDecrementCounter;
  final VoidCallback onIncrementDamage;
  final VoidCallback onDecrementDamage;
  final VoidCallback onIncrementPower;
  final VoidCallback onDecrementPower;
  final VoidCallback onIncrementToughness;
  final VoidCallback onDecrementToughness;

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Wrap(
          spacing: 8,
          runSpacing: 8,
          children: [
            _ValueStepper(
              label: 'Dano',
              value: card.damage,
              icon: Icons.local_fire_department_outlined,
              onIncrement: onIncrementDamage,
              onDecrement: onDecrementDamage,
            ),
            _ValueStepper(
              label: 'Poder',
              value: card.powerBuff,
              icon: Icons.fitness_center_outlined,
              signed: true,
              onIncrement: onIncrementPower,
              onDecrement: onDecrementPower,
            ),
            _ValueStepper(
              label: 'Resist.',
              value: card.toughnessBuff,
              icon: Icons.shield_outlined,
              signed: true,
              onIncrement: onIncrementToughness,
              onDecrement: onDecrementToughness,
            ),
          ],
        ),
        const SizedBox(height: 10),
        Wrap(
          spacing: 8,
          runSpacing: 8,
          children: [
            for (final type in GameAssistantCounterType.values)
              _CounterPill(
                type: type,
                value: card.counterValue(type),
                onIncrement: () => onIncrementCounter(type),
                onDecrement: () => onDecrementCounter(type),
              ),
          ],
        ),
      ],
    );
  }
}

class _CounterPill extends StatelessWidget {
  const _CounterPill({
    required this.type,
    required this.value,
    required this.onIncrement,
    required this.onDecrement,
  });

  final GameAssistantCounterType type;
  final int value;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;

  @override
  Widget build(BuildContext context) {
    return _ValueStepper(
      label: type.label,
      value: value,
      icon: _iconForType(type),
      onIncrement: onIncrement,
      onDecrement: onDecrement,
    );
  }

  IconData _iconForType(GameAssistantCounterType type) {
    return switch (type) {
      GameAssistantCounterType.plusOne => Icons.add_circle_outline,
      GameAssistantCounterType.minusOne => Icons.remove_circle_outline,
      GameAssistantCounterType.charge => Icons.bolt_outlined,
      GameAssistantCounterType.shield => Icons.shield_outlined,
      GameAssistantCounterType.stun => Icons.motion_photos_pause_outlined,
      GameAssistantCounterType.loyalty => Icons.military_tech_outlined,
      GameAssistantCounterType.generic => Icons.adjust_rounded,
    };
  }
}

class _ValueStepper extends StatelessWidget {
  const _ValueStepper({
    required this.label,
    required this.value,
    required this.icon,
    required this.onIncrement,
    required this.onDecrement,
    this.signed = false,
  });

  final String label;
  final int value;
  final IconData icon;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;
  final bool signed;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final valueLabel = signed && value > 0 ? '+$value' : '$value';
    return ConstrainedBox(
      constraints: const BoxConstraints(minWidth: 132, maxWidth: 164),
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: scheme.surfaceContainerHighest.withValues(alpha: 0.58),
          borderRadius: BorderRadius.circular(14),
          border:
              Border.all(color: scheme.outlineVariant.withValues(alpha: 0.4)),
        ),
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 7),
          child: Row(
            mainAxisSize: MainAxisSize.min,
            children: [
              Icon(icon, size: 17, color: scheme.secondary),
              const SizedBox(width: 6),
              Expanded(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      label,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: theme.textTheme.labelSmall?.copyWith(
                        color: scheme.onSurfaceVariant,
                        fontWeight: FontWeight.w800,
                      ),
                    ),
                    Text(
                      valueLabel,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: theme.textTheme.titleSmall?.copyWith(
                        fontWeight: FontWeight.w900,
                        letterSpacing: 0,
                      ),
                    ),
                  ],
                ),
              ),
              _MiniIconButton(
                icon: Icons.remove_rounded,
                tooltip: 'Remover',
                onPressed: onDecrement,
              ),
              _MiniIconButton(
                icon: Icons.add_rounded,
                tooltip: 'Adicionar',
                onPressed: onIncrement,
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class _MiniIconButton extends StatelessWidget {
  const _MiniIconButton({
    required this.icon,
    required this.tooltip,
    required this.onPressed,
  });

  final IconData icon;
  final String tooltip;
  final VoidCallback onPressed;

  @override
  Widget build(BuildContext context) {
    return Tooltip(
      message: tooltip,
      child: SizedBox.square(
        dimension: 28,
        child: IconButton(
          padding: EdgeInsets.zero,
          visualDensity: VisualDensity.compact,
          onPressed: onPressed,
          icon: Icon(icon, size: 18),
        ),
      ),
    );
  }
}
