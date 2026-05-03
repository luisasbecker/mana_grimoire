import 'package:flutter/material.dart';

/// Barra inferior fixa com 5 destinos.
///
/// - Home fica exatamente no centro.
/// - O selecionado tem destaque circular + glow.
class ManaBottomNavBar extends StatelessWidget {
  const ManaBottomNavBar({
    super.key,
    required this.currentIndex,
    required this.onDestinationSelected,
  });

  final int currentIndex;
  final ValueChanged<int> onDestinationSelected;

  static const _destinations = <_Dest>[
    _Dest(
      label: 'Coleções',
      icon: Icons.collections_bookmark_outlined,
      selectedIcon: Icons.collections_bookmark,
    ),
    _Dest(
      label: 'Scan',
      icon: Icons.qr_code_scanner_outlined,
      selectedIcon: Icons.qr_code_scanner,
    ),
    _Dest(
      label: 'Início',
      icon: Icons.home_outlined,
      selectedIcon: Icons.home_rounded,
    ),
    _Dest(
      label: 'Chat',
      icon: Icons.chat_bubble_outline,
      selectedIcon: Icons.chat_bubble,
    ),
    _Dest(
      label: 'Jogar',
      icon: Icons.sports_esports_outlined,
      selectedIcon: Icons.sports_esports,
    ),
  ];

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final bottomInset = MediaQuery.paddingOf(context).bottom;
    final bg = scheme.surfaceContainerHighest.withValues(alpha: 0.85);
    final border = scheme.outlineVariant.withValues(alpha: 0.65);
    final accent = scheme.primary;

    return LayoutBuilder(
      builder: (context, c) {
        return Container(
          height: 72 + bottomInset,
          decoration: BoxDecoration(
            color: bg,
            // Full-width: menos aspecto de “caixa” flutuante.
            borderRadius: BorderRadius.circular(0),
            border: Border(
              top: BorderSide(color: border, width: 1),
            ),
            boxShadow: [
              BoxShadow(
                color: Colors.black.withValues(alpha: 0.35),
                blurRadius: 22,
                offset: const Offset(0, 10),
              ),
              BoxShadow(
                color: accent.withValues(alpha: 0.10),
                blurRadius: 18,
                offset: const Offset(0, 0),
              ),
            ],
          ),
          child: Padding(
            padding: EdgeInsets.only(
              left: 10,
              right: 10,
              top: 4,
              bottom: 4 + bottomInset,
            ),
            child: Row(
              children: List.generate(_destinations.length, (i) {
                final dest = _destinations[i];
                final selected = i == currentIndex;
                return Expanded(
                  child: _NavItem(
                    dest: dest,
                    index: i,
                    selected: selected,
                    isHome: i == 2,
                    onTap: onDestinationSelected,
                  ),
                );
              }),
            ),
          ),
        );
      },
    );
  }
}

class _Dest {
  const _Dest({
    required this.label,
    required this.icon,
    required this.selectedIcon,
  });
  final String label;
  final IconData icon;
  final IconData selectedIcon;
}

class _NavItem extends StatelessWidget {
  const _NavItem({
    required this.dest,
    required this.index,
    required this.selected,
    required this.isHome,
    required this.onTap,
  });

  final _Dest dest;
  final int index;
  final bool selected;
  final bool isHome;
  final ValueChanged<int> onTap;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final fg =
        selected ? scheme.primary : scheme.onSurface.withValues(alpha: 0.78);
    final iconData = selected ? dest.selectedIcon : dest.icon;

    final circleSize = isHome ? 38.0 : 34.0;
    final iconSize = isHome ? 23.0 : 21.0;

    return Material(
      color: Colors.transparent,
      child: InkWell(
        onTap: () => onTap(index),
        borderRadius: BorderRadius.circular(18),
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 4),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              AnimatedContainer(
                duration: const Duration(milliseconds: 220),
                curve: Curves.easeOutCubic,
                width: circleSize,
                height: circleSize,
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: selected
                      ? scheme.primaryContainer.withValues(alpha: 0.55)
                      : Colors.transparent,
                  border: Border.all(
                    color: selected
                        ? scheme.primary.withValues(alpha: 0.75)
                        : scheme.outlineVariant.withValues(alpha: 0.35),
                    width: 1,
                  ),
                  boxShadow: selected
                      ? [
                          BoxShadow(
                            color: scheme.primary.withValues(alpha: 0.35),
                            blurRadius: 16,
                            offset: const Offset(0, 4),
                          ),
                        ]
                      : const [],
                ),
                child: Center(
                  child: Icon(iconData, size: iconSize, color: fg),
                ),
              ),
              const SizedBox(height: 1),
              Flexible(
                child: FittedBox(
                  fit: BoxFit.scaleDown,
                  child: Text(
                    dest.label,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: theme.textTheme.labelSmall?.copyWith(
                      color: fg,
                      fontWeight: selected ? FontWeight.w700 : FontWeight.w600,
                      fontSize: 8.5,
                      letterSpacing: 0.2,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
