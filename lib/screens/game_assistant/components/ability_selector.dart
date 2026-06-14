import 'package:flutter/material.dart';

import '../types/game_assistant_types.dart';
import 'ability_icon_strip.dart';

class AbilitySelector extends StatelessWidget {
  const AbilitySelector({
    super.key,
    required this.selectedAbilities,
    required this.onToggleAbility,
  });

  final Set<GameAssistantAbility> selectedAbilities;
  final ValueChanged<GameAssistantAbility> onToggleAbility;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return Wrap(
      spacing: 8,
      runSpacing: 8,
      children: [
        for (final ability in GameAssistantAbility.values)
          FilterChip(
            selected: selectedAbilities.contains(ability),
            onSelected: (_) => onToggleAbility(ability),
            avatar: Icon(
              iconForGameAssistantAbility(ability),
              size: 16,
              color: selectedAbilities.contains(ability)
                  ? scheme.onPrimaryContainer
                  : scheme.secondary,
            ),
            label: Text(ability.label),
            labelStyle: Theme.of(context).textTheme.labelSmall?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
          ),
      ],
    );
  }
}
