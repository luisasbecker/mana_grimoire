import 'dart:async';
import 'dart:convert';
import 'dart:io';

import 'package:flutter/foundation.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

final playSessionStoreProvider = Provider<PlaySessionStore>(
  (ref) => const FilePlaySessionStore(),
);

final playSessionControllerProvider =
    StateNotifierProvider<PlaySessionController, PlaySessionState>((ref) {
  return PlaySessionController(ref.watch(playSessionStoreProvider));
});

@immutable
class PlaySessionState {
  const PlaySessionState({
    required this.hasSession,
    required this.players,
    required this.mode,
    required this.lifeTotals,
  });

  factory PlaySessionState.initial() {
    return const PlaySessionState(
      hasSession: false,
      players: 2,
      mode: 'Commander',
      lifeTotals: [20, 20],
    );
  }

  factory PlaySessionState.start({
    required int players,
    required String mode,
  }) {
    final safePlayers = _normalizePlayers(players);
    return PlaySessionState(
      hasSession: true,
      players: safePlayers,
      mode: _normalizeMode(mode),
      lifeTotals: List<int>.unmodifiable(
        List<int>.filled(safePlayers, 20, growable: false),
      ),
    );
  }

  factory PlaySessionState.fromJson(Map<String, Object?> json) {
    final rawLifeTotals = json['lifeTotals'];
    final lifeTotals = rawLifeTotals is List
        ? rawLifeTotals.whereType<num>().map((value) => value.round()).toList()
        : const <int>[];
    return PlaySessionState(
      hasSession: json['hasSession'] == true,
      players: _normalizePlayers((json['players'] as num?)?.round() ?? 2),
      mode: _normalizeMode(json['mode'] as String? ?? 'Commander'),
      lifeTotals: lifeTotals,
    ).normalized();
  }

  final bool hasSession;
  final int players;
  final String mode;
  final List<int> lifeTotals;

  Map<String, Object?> toJson() {
    return {
      'hasSession': hasSession,
      'players': players,
      'mode': mode,
      'lifeTotals': lifeTotals,
    };
  }

  PlaySessionState copyWith({
    bool? hasSession,
    int? players,
    String? mode,
    List<int>? lifeTotals,
  }) {
    return PlaySessionState(
      hasSession: hasSession ?? this.hasSession,
      players: players ?? this.players,
      mode: mode ?? this.mode,
      lifeTotals: lifeTotals ?? this.lifeTotals,
    ).normalized();
  }

  PlaySessionState normalized() {
    final safePlayers = _normalizePlayers(players);
    final safeTotals = List<int>.unmodifiable(
      List<int>.generate(
        safePlayers,
        (index) =>
            index < lifeTotals.length ? _clampLife(lifeTotals[index]) : 20,
        growable: false,
      ),
    );
    return PlaySessionState(
      hasSession: hasSession,
      players: safePlayers,
      mode: _normalizeMode(mode),
      lifeTotals: safeTotals,
    );
  }

  int lifeAt(int index) {
    if (index < 0 || index >= lifeTotals.length) return 20;
    return lifeTotals[index];
  }

  static int _normalizePlayers(int value) => value == 4 ? 4 : 2;

  static String _normalizeMode(String value) {
    return switch (value) {
      'Commander' || 'Standard' || 'Casual' => value,
      _ => 'Commander',
    };
  }

  static int _clampLife(int value) => value.clamp(0, 999).toInt();
}

abstract class PlaySessionStore {
  const PlaySessionStore();

  Future<PlaySessionState?> read();

  Future<void> write(PlaySessionState state);

  Future<void> clear();
}

class FilePlaySessionStore extends PlaySessionStore {
  const FilePlaySessionStore();

  static const _fileName = 'play_session.json';

  @override
  Future<PlaySessionState?> read() async {
    final file = await _sessionFile();
    if (file == null || !await file.exists()) return null;
    try {
      final raw = await file.readAsString();
      final json = jsonDecode(raw);
      if (json is! Map) return null;
      return PlaySessionState.fromJson(Map<String, Object?>.from(json));
    } catch (_) {
      return null;
    }
  }

  @override
  Future<void> write(PlaySessionState state) async {
    final file = await _sessionFile();
    if (file == null) return;
    await file.writeAsString(jsonEncode(state.toJson()), flush: true);
  }

  @override
  Future<void> clear() async {
    final file = await _sessionFile();
    if (file != null && await file.exists()) {
      await file.delete();
    }
  }

  Future<File?> _sessionFile() async {
    try {
      final directory = await getApplicationSupportDirectory();
      final stateDirectory = Directory(p.join(directory.path, 'state'));
      if (!await stateDirectory.exists()) {
        await stateDirectory.create(recursive: true);
      }
      return File(p.join(stateDirectory.path, _fileName));
    } catch (_) {
      return null;
    }
  }
}

class PlaySessionController extends StateNotifier<PlaySessionState> {
  PlaySessionController(this._store) : super(PlaySessionState.initial()) {
    unawaited(_restore());
  }

  final PlaySessionStore _store;

  Future<void> _restore() async {
    final saved = await _store.read();
    if (saved == null) return;
    state = saved.normalized();
  }

  void startNew({
    required int players,
    required String mode,
  }) {
    state = PlaySessionState.start(players: players, mode: mode);
    unawaited(_store.write(state));
  }

  void incrementLife(int playerIndex) {
    _setLife(playerIndex, state.lifeAt(playerIndex) + 1);
  }

  void decrementLife(int playerIndex) {
    _setLife(playerIndex, state.lifeAt(playerIndex) - 1);
  }

  void clear() {
    state = PlaySessionState.initial();
    unawaited(_store.clear());
  }

  void _setLife(int playerIndex, int value) {
    if (playerIndex < 0 || playerIndex >= state.players) return;
    final lifeTotals = [...state.lifeTotals];
    lifeTotals[playerIndex] = PlaySessionState._clampLife(value);
    state = state.copyWith(
      hasSession: true,
      lifeTotals: lifeTotals,
    );
    unawaited(_store.write(state));
  }
}
