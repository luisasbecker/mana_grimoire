import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../screens/collection_detail/collection_detail_screen.dart';
import '../screens/collections/collections_screen.dart';
import '../screens/collections/collection_hub_screen.dart';
import '../screens/collections/all_cards_screen.dart';
import '../screens/dev/scryfall_test_screen.dart';
import '../screens/decks/create_deck_screen.dart';
import '../screens/decks/deck_detail_screen.dart';
import '../screens/decks/edit_deck_screen.dart';
import '../screens/decks/add_card_to_deck_screen.dart';
import '../screens/decks/decks_screen.dart';
import '../screens/game_assistant/screens/game_assistant_screen.dart';
import '../screens/home/home_hub_screen.dart';
import '../screens/scan/scan_screen.dart';
import '../screens/social/social_hub_screen.dart';
import '../screens/tabs/play_session_screen.dart';
import '../screens/tabs/play_tab_screen.dart';
import '../screens/scryfall_add_card/scryfall_add_card_screen.dart';
import '../screens/select_printing/select_printing_screen.dart';
import '../screens/shell/main_shell.dart';

/// Nomes de rotas estáveis para `pushNamed` / `goNamed`.
abstract final class AppRoutes {
  static const collectionHub = 'collectionHub';
  static const collectionRoot = 'collectionRoot'; // /collections
  static const collectionDetail = 'collectionDetail';
  static const addCard = 'addCard';
  static const allCards = 'allCards';
  static const decks = 'decks';
  static const createDeck = 'createDeck';
  static const deckDetail = 'deckDetail';
  static const editDeck = 'editDeck';
  static const addCardToDeck = 'addCardToDeck';
  static const scan = 'scan';
  static const homeHub = 'homeHub';
  static const chat = 'chat';
  static const play = 'play';
  static const gameAssistant = 'gameAssistant';
  static const playSession = 'playSession';
  static const selectPrinting = 'selectPrinting';
  static const devScryfallTest = 'devScryfallTest';
}

final GlobalKey<NavigatorState> _collectionNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'collectionNav');
final GlobalKey<NavigatorState> _scanNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'scanNav');
final GlobalKey<NavigatorState> _homeNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'homeNav');
final GlobalKey<NavigatorState> _chatNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'chatNav');
final GlobalKey<NavigatorState> _playNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'playNav');
final GlobalKey<NavigatorState> _gameAssistantNavKey =
    GlobalKey<NavigatorState>(debugLabel: 'gameAssistantNav');

/// Navigator raiz do [appRouter] — empilha rotas por cima do shell (ex.: modal → select printing).
final GlobalKey<NavigatorState> rootNavigatorKey = GlobalKey<NavigatorState>();

final GoRouter appRouter = GoRouter(
  navigatorKey: rootNavigatorKey,
  initialLocation: '/collection-hub',
  routes: [
    StatefulShellRoute.indexedStack(
      builder: (context, state, navigationShell) {
        return MainShell(navigationShell: navigationShell, state: state);
      },
      branches: <StatefulShellBranch>[
        StatefulShellBranch(
          navigatorKey: _collectionNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/collection-hub',
              name: AppRoutes.collectionHub,
              builder: (_, __) => const CollectionHubScreen(),
              routes: <RouteBase>[
                GoRoute(
                  path: 'collections',
                  name: AppRoutes.collectionRoot,
                  builder: (_, __) => const CollectionsScreen(),
                  routes: <RouteBase>[
                    GoRoute(
                      path: 'all',
                      name: AppRoutes.allCards,
                      builder: (_, __) => const AllCardsScreen(),
                    ),
                    GoRoute(
                      path: ':collectionId',
                      name: AppRoutes.collectionDetail,
                      builder: (context, state) {
                        final id = state.pathParameters['collectionId']!;
                        final name = switch (state.extra) {
                          final String s => s,
                          _ => state.uri.queryParameters['name'] ?? 'Coleção',
                        };
                        return CollectionDetailScreen(
                          collectionId: id,
                          collectionName: name,
                        );
                      },
                      routes: <RouteBase>[
                        GoRoute(
                          path: 'add-card',
                          name: AppRoutes.addCard,
                          builder: (context, state) {
                            final id = state.pathParameters['collectionId']!;
                            return ScryfallAddCardScreen(
                                defaultCollectionId: id);
                          },
                        ),
                      ],
                    ),
                  ],
                ),
                GoRoute(
                  path: 'decks',
                  name: AppRoutes.decks,
                  builder: (_, __) => const DecksScreen(),
                  routes: <RouteBase>[
                    GoRoute(
                      path: 'create',
                      name: AppRoutes.createDeck,
                      builder: (_, __) => const CreateDeckScreen(),
                    ),
                    GoRoute(
                      path: ':deckId',
                      name: AppRoutes.deckDetail,
                      builder: (context, state) {
                        final id = state.pathParameters['deckId']!;
                        return DeckDetailScreen(deckId: id);
                      },
                      routes: <RouteBase>[
                        GoRoute(
                          path: 'edit',
                          name: AppRoutes.editDeck,
                          builder: (context, state) {
                            final id = state.pathParameters['deckId']!;
                            return EditDeckScreen(deckId: id);
                          },
                        ),
                        GoRoute(
                          path: 'add-card',
                          name: AppRoutes.addCardToDeck,
                          builder: (context, state) {
                            final id = state.pathParameters['deckId']!;
                            return AddCardToDeckScreen(deckId: id);
                          },
                        ),
                      ],
                    ),
                  ],
                ),
              ],
            ),
          ],
        ),
        StatefulShellBranch(
          navigatorKey: _scanNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/scan',
              name: AppRoutes.scan,
              builder: (_, __) => const ScanScreen(),
            ),
          ],
        ),
        StatefulShellBranch(
          navigatorKey: _homeNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/home',
              name: AppRoutes.homeHub,
              builder: (_, __) => const HomeHubScreen(),
            ),
          ],
        ),
        StatefulShellBranch(
          navigatorKey: _chatNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/chat',
              name: AppRoutes.chat,
              builder: (_, __) => const SocialHubScreen(),
            ),
          ],
        ),
        StatefulShellBranch(
          navigatorKey: _playNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/play',
              name: AppRoutes.play,
              builder: (_, __) => const PlayTabScreen(),
            ),
          ],
        ),
        StatefulShellBranch(
          navigatorKey: _gameAssistantNavKey,
          routes: <RouteBase>[
            GoRoute(
              path: '/game-assistant',
              name: AppRoutes.gameAssistant,
              builder: (_, __) => const GameAssistantScreen(),
            ),
          ],
        ),
      ],
    ),
    GoRoute(
      path: '/play/session',
      name: AppRoutes.playSession,
      parentNavigatorKey: rootNavigatorKey,
      builder: (_, __) => const PlaySessionScreen(),
    ),
    GoRoute(
      path: '/select-printing',
      name: AppRoutes.selectPrinting,
      parentNavigatorKey: rootNavigatorKey,
      builder: (context, state) {
        final extra = state.extra;
        if (extra is! Map) {
          return const SelectPrintingInvalidScreen();
        }
        final oracleId = extra['oracleId'] as String?;
        final selectedPrintingId = extra['selectedPrintingId'] as String?;
        if (oracleId == null || selectedPrintingId == null) {
          return const SelectPrintingInvalidScreen();
        }
        return SelectPrintingScreen(
          oracleId: oracleId,
          selectedPrintingId: selectedPrintingId,
        );
      },
    ),
    if (kDebugMode)
      GoRoute(
        path: '/dev/scryfall-test',
        name: AppRoutes.devScryfallTest,
        parentNavigatorKey: rootNavigatorKey,
        builder: (_, __) => const ScryfallTestScreen(),
      ),
  ],
);
