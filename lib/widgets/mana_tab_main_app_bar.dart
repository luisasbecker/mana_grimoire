import 'package:flutter/material.dart';

/// Cabeçalho para abas principais (Coleções, Scan, Chat): estilizado, sem avatar/settings.
class ManaTabMainAppBar extends StatelessWidget implements PreferredSizeWidget {
  const ManaTabMainAppBar({
    super.key,
    required this.title,
    this.bottomHeight = 4,
  });

  final String title;
  /// Altura extra da linha gradiente sob o título.
  final double bottomHeight;

  @override
  Size get preferredSize =>
      Size.fromHeight(kToolbarHeight + bottomHeight + 2);

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;

    return AppBar(
      automaticallyImplyLeading: false,
      centerTitle: true,
      elevation: 0,
      title: Text(
        title,
        style: theme.textTheme.titleLarge?.copyWith(
          fontWeight: FontWeight.w700,
          letterSpacing: 0.35,
        ),
      ),
      bottom: PreferredSize(
        preferredSize: Size.fromHeight(bottomHeight),
        child: Padding(
          padding: const EdgeInsets.only(bottom: 6),
          child: Align(
            alignment: Alignment.center,
            child: Container(
              height: 2,
              width: 120,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(2),
                gradient: LinearGradient(
                  colors: [
                    scheme.primary.withOpacity(0.2),
                    scheme.primary,
                    scheme.tertiary.withOpacity(0.75),
                  ],
                ),
                boxShadow: [
                  BoxShadow(
                    color: scheme.primary.withOpacity(0.25),
                    blurRadius: 8,
                    offset: const Offset(0, 1),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
