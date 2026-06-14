import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../widgets/mana_bottom_nav_bar.dart';

/// Shell principal: bottom navigation + [StatefulNavigationShell] (IndexedStack).
class MainShell extends StatelessWidget {
  const MainShell({
    super.key,
    required this.navigationShell,
    required this.state,
  });

  final StatefulNavigationShell navigationShell;
  final GoRouterState state;

  @override
  Widget build(BuildContext context) {
    final path = state.uri.path;
    final hideBottomNav = path.startsWith('/play/session');
    return Scaffold(
      body: navigationShell,
      bottomNavigationBar: hideBottomNav
          ? null
          : ManaBottomNavBar(
              currentIndex: navigationShell.currentIndex,
              onDestinationSelected: (i) {
                // Navega para a rota raiz de cada aba.
                // Isso evita “flash” de rotas anteriores mantidas no branch (ex.: /play/session).
                switch (i) {
                  case 0:
                    context.goNamed(AppRoutes.collectionHub);
                    return;
                  case 1:
                    context.goNamed(AppRoutes.scan);
                    return;
                  case 2:
                    context.goNamed(AppRoutes.homeHub);
                    return;
                  case 3:
                    context.goNamed(AppRoutes.chat);
                    return;
                  case 4:
                    context.goNamed(AppRoutes.play);
                    return;
                  case 5:
                    context.goNamed(AppRoutes.gameAssistant);
                    return;
                }
              },
            ),
    );
  }
}
