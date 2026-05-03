import 'package:flutter/material.dart';

/// Cabeçalho do hub [Início]: definições, título e avatar.
class ManaHomeAppBar extends StatelessWidget implements PreferredSizeWidget {
  const ManaHomeAppBar({super.key});

  @override
  Size get preferredSize => const Size.fromHeight(64);

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    const draculaPurple = Color(0xFFBD93F9);
    const draculaPink = Color(0xFFFF79C6);
    const draculaCyan = Color(0xFF8BE9FD);

    return AppBar(
      automaticallyImplyLeading: false,
      centerTitle: true,
      titleSpacing: 0,
      toolbarHeight: 64,
      title: ShaderMask(
        blendMode: BlendMode.srcIn,
        shaderCallback: (rect) => LinearGradient(
          begin: Alignment.centerLeft,
          end: Alignment.centerRight,
          colors: [
            scheme.onSurface,
            draculaPurple,
            draculaPink,
            draculaCyan.withValues(alpha: 0.95),
          ],
          stops: const [0.0, 0.45, 0.8, 1.0],
        ).createShader(rect),
        child: FittedBox(
          fit: BoxFit.scaleDown,
          child: Text(
            'Mana Grimoire',
            maxLines: 1,
            style: theme.textTheme.titleLarge?.copyWith(
              fontWeight: FontWeight.w700,
              letterSpacing: 0.35,
            ),
          ),
        ),
      ),
      leading: IconButton(
        tooltip: 'Definições',
        icon: Icon(
          Icons.settings_outlined,
          color: scheme.onSurface.withValues(alpha: 0.9),
        ),
        onPressed: () {
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Definições em breve.')),
          );
        },
      ),
      leadingWidth: 48,
      actions: [
        Padding(
          padding: const EdgeInsets.only(right: 10),
          child: Material(
            color: scheme.primaryContainer.withValues(alpha: 0.4),
            shape: const CircleBorder(),
            child: InkWell(
              onTap: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Perfil em breve.')),
                );
              },
              customBorder: const CircleBorder(),
              child: Padding(
                padding: const EdgeInsets.all(2),
                child: CircleAvatar(
                  radius: 22,
                  backgroundColor:
                      scheme.primaryContainer.withValues(alpha: 0.6),
                  child: Text(
                    '?',
                    style: theme.textTheme.titleMedium?.copyWith(
                      fontWeight: FontWeight.w800,
                    ),
                  ),
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }
}
