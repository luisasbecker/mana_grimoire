import 'package:flutter/material.dart';

import '../types/game_assistant_types.dart';

IconData iconForGameAssistantAbility(GameAssistantAbility ability) {
  return switch (ability) {
    GameAssistantAbility.flying => Icons.air_rounded,
    GameAssistantAbility.deathtouch => Icons.dangerous_outlined,
    GameAssistantAbility.trample => Icons.keyboard_double_arrow_right,
    GameAssistantAbility.lifelink => Icons.favorite_outline,
    GameAssistantAbility.hexproof => Icons.gpp_good_outlined,
    GameAssistantAbility.vigilance => Icons.visibility_outlined,
    GameAssistantAbility.haste => Icons.speed_outlined,
    GameAssistantAbility.reach => Icons.open_with_rounded,
    GameAssistantAbility.menace => Icons.warning_amber_rounded,
    GameAssistantAbility.firstStrike => Icons.flash_on_outlined,
    GameAssistantAbility.doubleStrike => Icons.bolt_outlined,
    GameAssistantAbility.indestructible => Icons.health_and_safety_outlined,
    GameAssistantAbility.ward => Icons.admin_panel_settings_outlined,
  };
}

class AbilityIconStrip extends StatelessWidget {
  const AbilityIconStrip({
    super.key,
    required this.abilities,
    this.maxVisible = 3,
    this.selected = false,
  });

  final Set<GameAssistantAbility> abilities;
  final int maxVisible;
  final bool selected;

  @override
  Widget build(BuildContext context) {
    final ordered = GameAssistantAbility.values
        .where(abilities.contains)
        .take(maxVisible)
        .toList(growable: false);
    if (ordered.isEmpty) return const SizedBox.shrink();

    final hiddenCount = abilities.length - ordered.length;
    final scheme = Theme.of(context).colorScheme;
    final badgeSize = selected ? 22.0 : 17.5;
    final iconSize = selected ? 13.0 : 10.5;
    final foreground = Colors.white.withValues(alpha: 0.92);
    final background = scheme.primary.withValues(alpha: selected ? 0.34 : 0.28);
    final border = scheme.primary.withValues(alpha: selected ? 0.62 : 0.44);

    final strip = Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        for (final ability in ordered) ...[
          Tooltip(
            message: ability.label,
            child: Container(
              width: badgeSize,
              height: badgeSize,
              decoration: BoxDecoration(
                color: background,
                borderRadius: BorderRadius.circular(999),
                border: Border.all(color: border),
              ),
              child: Icon(
                iconForGameAssistantAbility(ability),
                size: iconSize,
                color: foreground,
              ),
            ),
          ),
          SizedBox(width: selected ? 4 : 3),
        ],
        if (hiddenCount > 0)
          Container(
            height: badgeSize,
            padding: EdgeInsets.symmetric(horizontal: selected ? 5 : 4),
            decoration: BoxDecoration(
              color: Colors.white.withValues(alpha: 0.10),
              borderRadius: BorderRadius.circular(999),
              border: Border.all(
                color: Colors.white.withValues(alpha: 0.18),
              ),
            ),
            alignment: Alignment.center,
            child: Text(
              '+$hiddenCount',
              style: Theme.of(context).textTheme.labelSmall?.copyWith(
                    color: foreground,
                    fontSize: selected ? 10.5 : 8.5,
                    fontWeight: FontWeight.w900,
                    height: 1,
                  ),
            ),
          ),
      ],
    );

    return LayoutBuilder(
      builder: (context, constraints) {
        if (!constraints.maxWidth.isFinite) return strip;
        return SizedBox(
          width: constraints.maxWidth,
          child: Align(
            alignment: Alignment.centerLeft,
            child: FittedBox(
              fit: BoxFit.scaleDown,
              alignment: Alignment.centerLeft,
              child: strip,
            ),
          ),
        );
      },
    );
  }
}
