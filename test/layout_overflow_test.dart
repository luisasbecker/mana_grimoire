import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:mana_grimoire/app/app.dart';
import 'package:mana_grimoire/data/scan/scan_models.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:mana_grimoire/screens/decks/create_deck_screen.dart';
import 'package:mana_grimoire/screens/decks/widgets/deck_import_sheet.dart';
import 'package:mana_grimoire/screens/game_assistant/components/floating_card_panel.dart';
import 'package:mana_grimoire/screens/game_assistant/types/game_assistant_types.dart';
import 'package:mana_grimoire/screens/scan/widgets/scan_buffer_tile.dart';
import 'package:mana_grimoire/screens/scryfall_add_card/widgets/add_to_collection_sheet.dart';
import 'package:mana_grimoire/widgets/mana_bottom_nav_bar.dart';
import 'package:mana_grimoire/widgets/mana_chip.dart';
import 'package:mana_grimoire/widgets/mana_empty_state.dart';

void main() {
  Future<void> setSmallViewport(WidgetTester tester) async {
    tester.view.devicePixelRatio = 1;
    tester.view.physicalSize = const Size(320, 568);
    addTearDown(() {
      tester.view.resetDevicePixelRatio();
      tester.view.resetPhysicalSize();
    });
  }

  Future<void> pumpLocalized(
    WidgetTester tester,
    Widget child, {
    double textScale = 1.25,
  }) async {
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
        home: MediaQuery(
          data: MediaQueryData(
            size: const Size(320, 568),
            textScaler: TextScaler.linear(textScale),
          ),
          child: child,
        ),
      ),
    );
    await tester.pumpAndSettle();
    expect(tester.takeException(), isNull);
  }

  testWidgets('shared UI components do not overflow on narrow screens',
      (tester) async {
    await setSmallViewport(tester);
    await pumpLocalized(
      tester,
      Scaffold(
        bottomNavigationBar: ManaBottomNavBar(
          currentIndex: 0,
          onDestinationSelected: (_) {},
        ),
        body: const Column(
          children: [
            Expanded(
              child: ManaEmptyState(
                icon: Icons.style_outlined,
                title: 'Título extremamente comprido para validar layout',
                subtitle:
                    'Subtítulo também longo para garantir que o estado vazio role em telas pequenas.',
              ),
            ),
            Padding(
              padding: EdgeInsets.all(8),
              child: ManaChip(
                label:
                    'Nome de edição ou etiqueta muito comprida que não deve estourar',
              ),
            ),
          ],
        ),
      ),
    );
  });

  testWidgets('main app tabs do not overflow on a narrow viewport',
      (tester) async {
    await setSmallViewport(tester);
    await tester.pumpWidget(
      const ProviderScope(
        child: ManaGrimoireApp(),
      ),
    );
    await tester.pump(const Duration(milliseconds: 300));
    expect(tester.takeException(), isNull);

    for (final label in [
      'Coleções',
      'Scan',
      'Início',
      'Chat',
      'Jogar',
      'Assist. Jogo',
    ]) {
      await tester.tap(find.text(label).last);
      await tester.pump(const Duration(milliseconds: 300));
      expect(tester.takeException(), isNull);
    }

    await tester.pumpWidget(
      const ProviderScope(
        child: MaterialApp(home: SizedBox.shrink()),
      ),
    );
    await tester.pump(const Duration(seconds: 2));
  });

  testWidgets('forms and sheets stay scrollable on narrow screens',
      (tester) async {
    await setSmallViewport(tester);

    await pumpLocalized(tester, const CreateDeckScreen());

    await pumpLocalized(
      tester,
      const Scaffold(
        body: AddToCollectionSheet(
          defaultCollectionId: 'collection-id',
          initialPrintingId: 'printing-id',
          oracleId: 'oracle-id',
        ),
      ),
    );

    await pumpLocalized(
      tester,
      const Scaffold(
        body: DeckImportSheet(deckId: 'deck-id'),
      ),
    );
  });

  testWidgets('scan buffer tile does not overflow with long card metadata',
      (tester) async {
    await setSmallViewport(tester);
    final now = DateTime(2026);
    await pumpLocalized(
      tester,
      Scaffold(
        body: Center(
          child: SizedBox(
            width: 286,
            height: 120,
            child: ScanBufferTile(
              entry: BufferedScanEntry(
                card: ScanCatalogCard(
                  id: 'printing-id',
                  oracleId: 'oracle-id',
                  name:
                      'Nome extremamente comprido de uma carta reconhecida pelo live scan',
                  setCode: 'long',
                  setName:
                      'Nome de edição exageradamente comprido para validar o tile',
                  collectorNumber: '123456',
                  rarity: 'mythic',
                  typeLine: 'Legendary Creature',
                ),
                quantity: 999,
                firstSeenAt: now,
                lastSeenAt: now,
                confidence: 0.98,
                condition: 'MP',
                language: 'Português brasileiro',
                isFoil: true,
              ),
              onTap: () {},
              onRemove: () {},
              onIncrement: () {},
              onDecrement: () {},
            ),
          ),
        ),
      ),
    );
  });

  testWidgets('game assistant floating card panel shows compact ability icons',
      (tester) async {
    await setSmallViewport(tester);
    final now = DateTime(2026);
    await pumpLocalized(
      tester,
      Scaffold(
        body: Center(
          child: FloatingCardPanel(
            card: GameAssistantTrackedCard(
              id: 'manual-1',
              printingId: 'manual-1',
              oracleId: 'manual-1',
              name: 'Carta manual com habilidades',
              editionLabel: 'Manual',
              typeLine: 'Permanente',
              confidence: 1,
              position: const Offset(0.5, 0.5),
              firstSeenAt: now,
              lastSeenAt: now,
              abilities: const {
                GameAssistantAbility.flying,
                GameAssistantAbility.deathtouch,
                GameAssistantAbility.trample,
                GameAssistantAbility.lifelink,
                GameAssistantAbility.hexproof,
              },
            ),
            selected: false,
            onTap: () {},
          ),
        ),
      ),
    );

    expect(find.text('+2'), findsOneWidget);
  });
}
