import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../app/router.dart';

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
        onPressed: () => _showSettingsSheet(context),
      ),
      leadingWidth: 48,
      actions: [
        Padding(
          padding: const EdgeInsets.only(right: 10),
          child: Material(
            color: scheme.primaryContainer.withValues(alpha: 0.4),
            shape: const CircleBorder(),
            child: InkWell(
              onTap: () => _showProfileSheet(context),
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

void _showSettingsSheet(BuildContext context) {
  showModalBottomSheet<void>(
    context: context,
    showDragHandle: true,
    backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
    shape: const RoundedRectangleBorder(
      borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
    ),
    builder: (sheetContext) {
      final scheme = Theme.of(sheetContext).colorScheme;
      return SafeArea(
        child: Padding(
          padding: const EdgeInsets.fromLTRB(16, 4, 16, 18),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              ListTile(
                leading: Icon(Icons.settings_rounded, color: scheme.primary),
                title: const Text('Definições'),
                subtitle: const Text('Atalhos rápidos do aplicativo'),
              ),
              const Divider(height: 1),
              ListTile(
                leading: const Icon(Icons.qr_code_scanner_rounded),
                title: const Text('Scan e catálogo'),
                subtitle: const Text('Abrir scanner e sincronização local'),
                onTap: () {
                  Navigator.of(sheetContext).pop();
                  context.goNamed(AppRoutes.scan);
                },
              ),
              ListTile(
                leading: const Icon(Icons.collections_bookmark_rounded),
                title: const Text('Coleções'),
                subtitle: const Text('Gerenciar cartas e inventário'),
                onTap: () {
                  Navigator.of(sheetContext).pop();
                  context.goNamed(AppRoutes.collectionRoot);
                },
              ),
              ListTile(
                leading: const Icon(Icons.dark_mode_outlined),
                title: const Text('Tema'),
                subtitle: const Text('Tema escuro ativo'),
              ),
            ],
          ),
        ),
      );
    },
  );
}

void _showProfileSheet(BuildContext context) {
  showModalBottomSheet<void>(
    context: context,
    showDragHandle: true,
    backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
    shape: const RoundedRectangleBorder(
      borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
    ),
    builder: (sheetContext) {
      final scheme = Theme.of(sheetContext).colorScheme;
      return SafeArea(
        child: Padding(
          padding: const EdgeInsets.fromLTRB(16, 4, 16, 18),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              ListTile(
                leading: CircleAvatar(
                  backgroundColor: scheme.primaryContainer,
                  child: const Text('?'),
                ),
                title: const Text('Perfil local'),
                subtitle: const Text('Coleção e decks neste aparelho'),
              ),
              const Divider(height: 1),
              ListTile(
                leading: const Icon(Icons.collections_bookmark_rounded),
                title: const Text('Minhas coleções'),
                onTap: () {
                  Navigator.of(sheetContext).pop();
                  context.goNamed(AppRoutes.collectionRoot);
                },
              ),
              ListTile(
                leading: const Icon(Icons.style_rounded),
                title: const Text('Meus decks'),
                onTap: () {
                  Navigator.of(sheetContext).pop();
                  context.goNamed(AppRoutes.decks);
                },
              ),
            ],
          ),
        ),
      );
    },
  );
}
