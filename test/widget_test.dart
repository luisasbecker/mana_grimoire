import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:mana_grimoire/app/app.dart';

void main() {
  testWidgets('App loads collection tab with shell',
      (WidgetTester tester) async {
    await tester.pumpWidget(
      const ProviderScope(
        child: ManaGrimoireApp(),
      ),
    );
    await tester.pump();
    await tester.pump(const Duration(milliseconds: 100));

    expect(find.text('Coleções'), findsWidgets);
    expect(find.text('Início'), findsWidgets);

    // Desmontar e avançar tempo para drenar timers internos do Drift ao fechar streams.
    await tester.pumpWidget(
      const ProviderScope(
        child: MaterialApp(home: SizedBox.shrink()),
      ),
    );
    await tester.pump(const Duration(seconds: 2));
  });

  testWidgets('Bottom navigation opens play tab flow',
      (WidgetTester tester) async {
    await tester.pumpWidget(
      const ProviderScope(
        child: ManaGrimoireApp(),
      ),
    );
    await tester.pumpAndSettle();

    await tester.tap(find.text('Jogar'));
    await tester.pumpAndSettle();

    expect(find.text('Iniciar partida'), findsOneWidget);
  });

  testWidgets('Collection section switcher opens cards decks and trades',
      (WidgetTester tester) async {
    await tester.pumpWidget(
      const ProviderScope(
        child: ManaGrimoireApp(),
      ),
    );
    await tester.pumpAndSettle();

    await tester.tap(find.text('Coleções').last);
    await tester.pumpAndSettle();

    await tester.tap(find.byKey(const Key('collection-section-decks')));
    await tester.pumpAndSettle();
    expect(find.text('Criar deck'), findsOneWidget);

    await tester.tap(find.byKey(const Key('collection-section-cards')));
    await tester.pumpAndSettle();
    expect(find.text('Nova coleção'), findsOneWidget);

    await tester.tap(find.byKey(const Key('collection-section-trades')));
    await tester.pumpAndSettle();
    expect(find.text('Central social'), findsOneWidget);

    await tester.pumpWidget(
      const ProviderScope(
        child: MaterialApp(home: SizedBox.shrink()),
      ),
    );
    await tester.pump(const Duration(seconds: 2));
  });
}
