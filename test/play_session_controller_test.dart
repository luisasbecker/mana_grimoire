import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/screens/tabs/play_session_controller.dart';

void main() {
  test('PlaySessionController persists a four-player session', () async {
    final store = _MemoryPlaySessionStore();
    final controller = PlaySessionController(store);
    await pumpEventQueue();

    controller.startNew(players: 4, mode: 'Commander');
    controller.incrementLife(2);
    controller.decrementLife(0);
    await pumpEventQueue();

    expect(controller.state.players, 4);
    expect(controller.state.lifeTotals, [19, 20, 21, 20]);
    expect(store.saved?.players, 4);
    expect(store.saved?.lifeTotals, [19, 20, 21, 20]);
  });

  test('PlaySessionState normalizes unsupported values', () {
    final state = PlaySessionState.fromJson({
      'hasSession': true,
      'players': 3,
      'mode': 'Legacy',
      'lifeTotals': [-4, 1200, 7],
    });

    expect(state.players, 2);
    expect(state.mode, 'Commander');
    expect(state.lifeTotals, [0, 999]);
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
