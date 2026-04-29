import 'package:flutter/material.dart';

/// AppBar mínimo para fluxos internos: voltar + título.
class ManaInternalAppBar extends StatelessWidget implements PreferredSizeWidget {
  const ManaInternalAppBar({
    super.key,
    required this.title,
    this.actions,
  });

  final String title;
  final List<Widget>? actions;

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      title: Text(title),
      actions: actions,
    );
  }
}
