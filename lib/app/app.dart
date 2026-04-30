import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';

import '../l10n/l10n.dart';
import '../theme/mana_theme.dart';
import 'router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

class ManaGrimoireApp extends StatelessWidget {
  const ManaGrimoireApp({super.key});

  @override
  Widget build(BuildContext context) {
    final dark = ManaTheme.dark();
    return MaterialApp.router(
      title: 'Mana Grimoire',
      debugShowCheckedModeBanner: false,
      theme: dark,
      darkTheme: dark,
      themeMode: ThemeMode.dark,
      locale: const Locale('pt'),
      supportedLocales: L10n.all,
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      routerConfig: appRouter,
    );
  }
}
