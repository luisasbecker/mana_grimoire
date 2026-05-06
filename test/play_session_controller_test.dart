import 'dart:math' as math;

import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/screens/tabs/play_game_catalog.dart';
import 'package:mana_grimoire/screens/tabs/play_session_controller.dart';

void main() {
  test('PlaySessionController persists a four-player session', () async {
    final store = _MemoryPlaySessionStore();
    final controller = PlaySessionController(store);
    await pumpEventQueue();

    controller.startNew(players: 4, mode: 'Commander');
    controller.incrementLife(2);
    controller.decrementLife(0);
    controller.incrementCounter(0, PlayCounterType.poison);
    controller.incrementCounter(0, PlayCounterType.poison);
    controller.decrementCounter(0, PlayCounterType.poison);
    controller.incrementCounter(1, PlayCounterType.energy);
    controller.incrementCommanderDamage(playerIndex: 0, sourceIndex: 2);
    controller.incrementCommanderDamage(playerIndex: 0, sourceIndex: 2);
    controller.decrementCommanderDamage(playerIndex: 0, sourceIndex: 2);
    await pumpEventQueue();

    expect(controller.state.players, 4);
    expect(controller.state.modeId, 'commander');
    expect(controller.state.startingLife, 40);
    expect(controller.state.tableTemplateId, 'commander_pod');
    expect(controller.state.lifeTotals, [39, 40, 41, 40]);
    expect(controller.state.countersAt(0).poison, 1);
    expect(controller.state.countersAt(1).energy, 1);
    expect(
      controller.state.commanderDamageAt(playerIndex: 0, sourceIndex: 2),
      1,
    );
    expect(store.saved?.players, 4);
    expect(store.saved?.lifeTotals, [39, 40, 41, 40]);
    expect(store.saved?.countersAt(0).poison, 1);
    expect(
      store.saved?.commanderDamageAt(playerIndex: 0, sourceIndex: 2),
      1,
    );
  });

  test('PlaySessionState normalizes unsupported values', () {
    final state = PlaySessionState.fromJson({
      'hasSession': true,
      'players': 9,
      'mode': 'Vintage',
      'variant': 'Chaos',
      'startingLife': -2,
      'tableTemplateId': 'eight_ring',
      'visualThemeId': 'unknown',
      'lifeTotals': [-4, 1200, 7],
      'playerCounters': [
        {'poison': -2, 'energy': 1000},
        {'experience': 4, 'storm': 2},
      ],
      'commanderDamage': [
        [0, 30, -2],
        [4, 0, 8, 12],
      ],
    });

    expect(state.players, 4);
    expect(state.modeId, 'commander');
    expect(state.variant, 'Todos contra todos');
    expect(state.startingLife, 40);
    expect(state.tableTemplateId, 'commander_pod');
    expect(state.visualThemeId, 'arcane');
    expect(state.lifeTotals, [0, 999, 7, 40]);
    expect(state.countersAt(0).poison, 0);
    expect(state.countersAt(0).energy, 999);
    expect(state.countersAt(1).experience, 4);
    expect(state.countersAt(2).storm, 0);
    expect(state.commanderDamageAt(playerIndex: 0, sourceIndex: 1), 30);
    expect(state.commanderDamageAt(playerIndex: 0, sourceIndex: 2), 0);
    expect(state.commanderDamageAt(playerIndex: 1, sourceIndex: 3), 12);
    expect(state.commanderDamageAt(playerIndex: 2, sourceIndex: 1), 0);
  });

  test('PlaySessionState keeps supported constructed formats', () {
    final state = PlaySessionState.fromJson({
      'hasSession': true,
      'players': 6,
      'mode': 'Casual',
      'variant': 'Emperor',
      'startingLife': 30,
      'tableTemplateId': 'emperor',
      'visualThemeId': 'ember',
      'lifeTotals': [30, 29, 28],
    });

    expect(state.players, 6);
    expect(state.modeId, 'casual');
    expect(state.mode, 'Casual');
    expect(state.variant, 'Emperor');
    expect(state.startingLife, 30);
    expect(state.tableTemplateId, 'emperor');
    expect(state.visualThemeId, 'ember');
    expect(state.lifeTotals, [30, 29, 28, 30, 30, 30]);
  });

  test('PlaySessionState derives variant-aware default table templates', () {
    final state = PlaySessionState.start(
      players: 6,
      mode: 'Casual',
      variant: 'Emperor',
    );

    expect(state.tableTemplateId, 'emperor');
    expect(state.lifeTotals, [20, 20, 20, 20, 20, 20]);
    expect(state.playerCounters.length, 6);
    expect(state.commanderDamage.length, 6);
  });

  test('readableSeatRotation faces each four-player seat toward table center',
      () {
    final seats = seatCentersForTemplate(
      playTableTemplateById('commander_pod'),
      4,
    );

    expect(readableSeatRotation(seats[0]), closeTo(math.pi, 0.001));
    expect(readableSeatRotation(seats[1]), closeTo(-math.pi / 2, 0.001));
    expect(readableSeatRotation(seats[2]), closeTo(0, 0.001));
    expect(readableSeatRotation(seats[3]), closeTo(math.pi / 2, 0.001));
  });
}

class _MemoryPlaySessionStore extends PlaySessionStore {
  PlaySessionState? saved;

  @override
  Future<void> clear() async {
    saved = null;
  }

  @override
  Future<PlaySessionState?> read() async {
    return saved;
  }

  @override
  Future<void> write(PlaySessionState state) async {
    saved = state;
  }
}
