import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:mana_grimoire/widgets/create_collection_dialog.dart';

void main() {
  testWidgets('CreateCollectionDialog validates and returns a trimmed name',
      (tester) async {
    String? result;

    await tester.pumpWidget(
      MaterialApp(
        locale: const Locale('pt'),
        supportedLocales: AppLocalizations.supportedLocales,
        localizationsDelegates: const [
          AppLocalizations.delegate,
          GlobalMaterialLocalizations.delegate,
          GlobalWidgetsLocalizations.delegate,
          GlobalCupertinoLocalizations.delegate,
        ],
        home: Builder(
          builder: (context) {
            return Scaffold(
              body: Center(
                child: ElevatedButton(
                  onPressed: () async {
                    result = await showCreateCollectionDialog(context);
                  },
                  child: const Text('Abrir'),
                ),
              ),
            );
          },
        ),
      ),
    );

    await tester.tap(find.text('Abrir'));
    await tester.pumpAndSettle();

    await tester.tap(find.text('Criar'));
    await tester.pump();
    expect(find.text('O nome da coleção é obrigatório.'), findsOneWidget);

    await tester.enterText(find.byType(TextFormField), '  Binder Modern  ');
    await tester.tap(find.text('Criar'));
    await tester.pumpAndSettle();

    expect(result, 'Binder Modern');
    expect(tester.takeException(), isNull);
  });
}
