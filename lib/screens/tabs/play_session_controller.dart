import 'dart:async';
import 'dart:convert';
import 'dart:io';

import 'package:flutter/foundation.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

import 'play_game_catalog.dart';

final playSessionStoreProvider = Provider<PlaySessionStore>(
  (ref) => const FilePlaySessionStore(),
);

final playSessionControllerProvider =
    StateNotifierProvider<PlaySessionController, PlaySessionState>((ref) {
  return PlaySessionController(ref.watch(playSessionStoreProvider));
});

enum PlayCounterType {
  poison,
  energy,
  experience,
  commanderTax,
  storm,
  radiation,
}

@immutable
class PlayPlayerCounters {
  const PlayPlayerCounters({
    required this.poison,
    required this.energy,
    required this.experience,
    required this.commanderTax,
    required this.storm,
    required this.radiation,
  });

  const PlayPlayerCounters.empty()
      : poison = 0,
        energy = 0,
        experience = 0,
        commanderTax = 0,
        storm = 0,
        radiation = 0;

  factory PlayPlayerCounters.fromJson(Map<String, Object?> json) {
    return PlayPlayerCounters(
      poison: _counterFromJson(json['poison']),
      energy: _counterFromJson(json['energy']),
      experience: _counterFromJson(json['experience']),
      commanderTax: _counterFromJson(json['commanderTax']),
      storm: _counterFromJson(json['storm']),
      radiation: _counterFromJson(json['radiation']),
    );
  }

  final int poison;
  final int energy;
  final int experience;
  final int commanderTax;
  final int storm;
  final int radiation;

  Map<String, Object?> toJson() {
    return {
      'poison': poison,
      'energy': energy,
      'experience': experience,
      'commanderTax': commanderTax,
      'storm': storm,
      'radiation': radiation,
    };
  }

  PlayPlayerCounters copyWith({
    int? poison,
    int? energy,
    int? experience,
    int? commanderTax,
    int? storm,
    int? radiation,
  }) {
    return PlayPlayerCounters(
      poison: _clampCounter(poison ?? this.poison),
      energy: _clampCounter(energy ?? this.energy),
      experience: _clampCounter(experience ?? this.experience),
      commanderTax: _clampCounter(commanderTax ?? this.commanderTax),
      storm: _clampCounter(storm ?? this.storm),
      radiation: _clampCounter(radiation ?? this.radiation),
    );
  }

  int valueFor(PlayCounterType type) {
    return switch (type) {
      PlayCounterType.poison => poison,
      PlayCounterType.energy => energy,
      PlayCounterType.experience => experience,
      PlayCounterType.commanderTax => commanderTax,
      PlayCounterType.storm => storm,
      PlayCounterType.radiation => radiation,
    };
  }

  PlayPlayerCounters withValue(PlayCounterType type, int value) {
    return switch (type) {
      PlayCounterType.poison => copyWith(poison: value),
      PlayCounterType.energy => copyWith(energy: value),
      PlayCounterType.experience => copyWith(experience: value),
      PlayCounterType.commanderTax => copyWith(commanderTax: value),
      PlayCounterType.storm => copyWith(storm: value),
      PlayCounterType.radiation => copyWith(radiation: value),
    };
  }

  static int _counterFromJson(Object? value) {
    return _clampCounter((value as num?)?.round() ?? 0);
  }

  static int _clampCounter(int value) => value.clamp(0, 999).toInt();
}

@immutable
class PlaySessionState {
  const PlaySessionState({
    required this.hasSession,
    required this.players,
    required this.modeId,
    required this.variant,
    required this.startingLife,
    required this.tableTemplateId,
    required this.visualThemeId,
    required this.lifeTotals,
    required this.playerCounters,
    required this.commanderDamage,
  });

  factory PlaySessionState.initial() {
    final mode = playModeByInput('commander');
    final template = defaultTableTemplateFor(
      mode: mode,
      players: mode.defaultPlayers,
    );
    return const PlaySessionState(
      hasSession: false,
      players: 4,
      modeId: 'commander',
      variant: 'Todos contra todos',
      startingLife: 40,
      tableTemplateId: 'commander_pod',
      visualThemeId: 'arcane',
      lifeTotals: [40, 40, 40, 40],
      playerCounters: [
        PlayPlayerCounters.empty(),
        PlayPlayerCounters.empty(),
        PlayPlayerCounters.empty(),
        PlayPlayerCounters.empty(),
      ],
      commanderDamage: [
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
      ],
    ).copyWith(
      tableTemplateId: template.id,
    );
  }

  factory PlaySessionState.start({
    required int players,
    required String mode,
    String? variant,
    int? startingLife,
    String? tableTemplateId,
    String? visualThemeId,
  }) {
    final modeDefinition = playModeByInput(mode);
    final safePlayers = normalizePlayersForMode(players, modeDefinition);
    final safeVariant = normalizeVariantForMode(variant, modeDefinition);
    final safeStartingLife = normalizeStartingLife(
      startingLife ?? modeDefinition.startingLife,
      modeDefinition,
    );
    final template = tableTemplateId == null
        ? defaultTableTemplateFor(
            mode: modeDefinition,
            players: safePlayers,
            variant: safeVariant,
          )
        : normalizeTableTemplateForPlayers(
            tableTemplateId,
            safePlayers,
            mode: modeDefinition,
            variant: safeVariant,
          );
    return PlaySessionState(
      hasSession: true,
      players: safePlayers,
      modeId: modeDefinition.id,
      variant: safeVariant,
      startingLife: safeStartingLife,
      tableTemplateId: template.id,
      visualThemeId: playVisualThemeById(visualThemeId).id,
      lifeTotals: List<int>.unmodifiable(
        List<int>.filled(safePlayers, safeStartingLife, growable: false),
      ),
      playerCounters: _emptyCounters(safePlayers),
      commanderDamage: _emptyCommanderDamage(safePlayers),
    );
  }

  factory PlaySessionState.fromJson(Map<String, Object?> json) {
    final modeDefinition = playModeByInput(
      json['modeId'] as String? ?? json['mode'] as String?,
    );
    final safePlayers = normalizePlayersForMode(
      (json['players'] as num?)?.round() ?? modeDefinition.defaultPlayers,
      modeDefinition,
    );
    final safeVariant = normalizeVariantForMode(
      json['variant'] as String?,
      modeDefinition,
    );
    final safeStartingLife = normalizeStartingLife(
      (json['startingLife'] as num?)?.round() ?? modeDefinition.startingLife,
      modeDefinition,
    );
    final rawTemplateId = json['tableTemplateId'] as String?;
    final template = rawTemplateId == null
        ? defaultTableTemplateFor(
            mode: modeDefinition,
            players: safePlayers,
            variant: safeVariant,
          )
        : normalizeTableTemplateForPlayers(
            rawTemplateId,
            safePlayers,
            mode: modeDefinition,
            variant: safeVariant,
          );
    final rawLifeTotals = json['lifeTotals'];
    final lifeTotals = rawLifeTotals is List
        ? rawLifeTotals.whereType<num>().map((value) => value.round()).toList()
        : const <int>[];
    final playerCounters = _countersFromJson(json['playerCounters']);
    final commanderDamage = _commanderDamageFromJson(json['commanderDamage']);
    return PlaySessionState(
      hasSession: json['hasSession'] == true,
      players: safePlayers,
      modeId: modeDefinition.id,
      variant: safeVariant,
      startingLife: safeStartingLife,
      tableTemplateId: template.id,
      visualThemeId: playVisualThemeById(json['visualThemeId'] as String?).id,
      lifeTotals: lifeTotals,
      playerCounters: playerCounters,
      commanderDamage: commanderDamage,
    ).normalized();
  }

  final bool hasSession;
  final int players;
  final String modeId;
  final String variant;
  final int startingLife;
  final String tableTemplateId;
  final String visualThemeId;
  final List<int> lifeTotals;
  final List<PlayPlayerCounters> playerCounters;
  final List<List<int>> commanderDamage;

  PlayGameMode get modeDefinition => playModeByInput(modeId);

  PlayTableTemplate get tableTemplate => playTableTemplateById(tableTemplateId);

  PlayVisualTheme get visualTheme => playVisualThemeById(visualThemeId);

  String get mode => modeDefinition.name;

  Map<String, Object?> toJson() {
    return {
      'hasSession': hasSession,
      'players': players,
      'mode': modeId,
      'modeId': modeId,
      'variant': variant,
      'startingLife': startingLife,
      'tableTemplateId': tableTemplateId,
      'visualThemeId': visualThemeId,
      'lifeTotals': lifeTotals,
      'playerCounters': [
        for (final counters in playerCounters) counters.toJson(),
      ],
      'commanderDamage': [
        for (final row in commanderDamage) row,
      ],
    };
  }

  PlaySessionState copyWith({
    bool? hasSession,
    int? players,
    String? modeId,
    String? variant,
    int? startingLife,
    String? tableTemplateId,
    String? visualThemeId,
    List<int>? lifeTotals,
    List<PlayPlayerCounters>? playerCounters,
    List<List<int>>? commanderDamage,
  }) {
    return PlaySessionState(
      hasSession: hasSession ?? this.hasSession,
      players: players ?? this.players,
      modeId: modeId ?? this.modeId,
      variant: variant ?? this.variant,
      startingLife: startingLife ?? this.startingLife,
      tableTemplateId: tableTemplateId ?? this.tableTemplateId,
      visualThemeId: visualThemeId ?? this.visualThemeId,
      lifeTotals: lifeTotals ?? this.lifeTotals,
      playerCounters: playerCounters ?? this.playerCounters,
      commanderDamage: commanderDamage ?? this.commanderDamage,
    ).normalized();
  }

  PlaySessionState normalized() {
    final modeDefinition = playModeByInput(modeId);
    final safePlayers = normalizePlayersForMode(players, modeDefinition);
    final safeVariant = normalizeVariantForMode(variant, modeDefinition);
    final safeStartingLife = normalizeStartingLife(
      startingLife,
      modeDefinition,
    );
    final template = normalizeTableTemplateForPlayers(
      tableTemplateId,
      safePlayers,
      mode: modeDefinition,
      variant: safeVariant,
    );
    final safeTotals = List<int>.unmodifiable(
      List<int>.generate(
        safePlayers,
        (index) => index < lifeTotals.length
            ? _clampLife(lifeTotals[index])
            : safeStartingLife,
        growable: false,
      ),
    );
    final safeCounters = List<PlayPlayerCounters>.unmodifiable(
      List<PlayPlayerCounters>.generate(
        safePlayers,
        (index) => index < playerCounters.length
            ? playerCounters[index]
            : const PlayPlayerCounters.empty(),
        growable: false,
      ),
    );
    final safeCommanderDamage = _normalizeCommanderDamage(
      commanderDamage,
      safePlayers,
    );
    return PlaySessionState(
      hasSession: hasSession,
      players: safePlayers,
      modeId: modeDefinition.id,
      variant: safeVariant,
      startingLife: safeStartingLife,
      tableTemplateId: template.id,
      visualThemeId: playVisualThemeById(visualThemeId).id,
      lifeTotals: safeTotals,
      playerCounters: safeCounters,
      commanderDamage: safeCommanderDamage,
    );
  }

  int lifeAt(int index) {
    if (index < 0 || index >= lifeTotals.length) return startingLife;
    return lifeTotals[index];
  }

  PlayPlayerCounters countersAt(int playerIndex) {
    if (playerIndex < 0 || playerIndex >= playerCounters.length) {
      return const PlayPlayerCounters.empty();
    }
    return playerCounters[playerIndex];
  }

  int commanderDamageAt({
    required int playerIndex,
    required int sourceIndex,
  }) {
    if (playerIndex < 0 ||
        playerIndex >= commanderDamage.length ||
        sourceIndex < 0 ||
        sourceIndex >= commanderDamage[playerIndex].length) {
      return 0;
    }
    return commanderDamage[playerIndex][sourceIndex];
  }

  int maxCommanderDamageAt(int playerIndex) {
    if (playerIndex < 0 || playerIndex >= commanderDamage.length) return 0;
    var maxDamage = 0;
    for (final value in commanderDamage[playerIndex]) {
      if (value > maxDamage) maxDamage = value;
    }
    return maxDamage;
  }

  static int _clampLife(int value) => value.clamp(0, 999).toInt();

  static List<PlayPlayerCounters> _emptyCounters(int players) {
    return List<PlayPlayerCounters>.unmodifiable(
      List<PlayPlayerCounters>.filled(
        players,
        const PlayPlayerCounters.empty(),
        growable: false,
      ),
    );
  }

  static List<List<int>> _emptyCommanderDamage(int players) {
    return List<List<int>>.unmodifiable(
      List<List<int>>.generate(
        players,
        (_) => List<int>.unmodifiable(
          List<int>.filled(players, 0, growable: false),
        ),
        growable: false,
      ),
    );
  }

  static List<PlayPlayerCounters> _countersFromJson(Object? value) {
    if (value is! List) return const <PlayPlayerCounters>[];
    return List<PlayPlayerCounters>.unmodifiable(
      value.map((raw) {
        if (raw is! Map) return const PlayPlayerCounters.empty();
        return PlayPlayerCounters.fromJson(Map<String, Object?>.from(raw));
      }),
    );
  }

  static List<List<int>> _commanderDamageFromJson(Object? value) {
    if (value is! List) return const <List<int>>[];
    return List<List<int>>.unmodifiable(
      value.map((row) {
        if (row is! List) return const <int>[];
        return List<int>.unmodifiable(
          row.map((raw) => (raw as num?)?.round() ?? 0),
        );
      }),
    );
  }

  static List<List<int>> _normalizeCommanderDamage(
    List<List<int>> damage,
    int players,
  ) {
    return List<List<int>>.unmodifiable(
      List<List<int>>.generate(
        players,
        (defender) => List<int>.unmodifiable(
          List<int>.generate(
            players,
            (source) {
              if (defender == source) return 0;
              if (defender >= damage.length ||
                  source >= damage[defender].length) {
                return 0;
              }
              return PlayPlayerCounters._clampCounter(damage[defender][source]);
            },
            growable: false,
          ),
        ),
        growable: false,
      ),
    );
  }
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
    String? variant,
    int? startingLife,
    String? tableTemplateId,
    String? visualThemeId,
  }) {
    state = PlaySessionState.start(
      players: players,
      mode: mode,
      variant: variant,
      startingLife: startingLife,
      tableTemplateId: tableTemplateId,
      visualThemeId: visualThemeId,
    );
    unawaited(_store.write(state));
  }

  void incrementLife(int playerIndex) {
    _setLife(playerIndex, state.lifeAt(playerIndex) + 1);
  }

  void decrementLife(int playerIndex) {
    _setLife(playerIndex, state.lifeAt(playerIndex) - 1);
  }

  void incrementCounter(int playerIndex, PlayCounterType type) {
    _setCounter(
        playerIndex, type, state.countersAt(playerIndex).valueFor(type) + 1);
  }

  void decrementCounter(int playerIndex, PlayCounterType type) {
    _setCounter(
        playerIndex, type, state.countersAt(playerIndex).valueFor(type) - 1);
  }

  void incrementCommanderDamage({
    required int playerIndex,
    required int sourceIndex,
  }) {
    _setCommanderDamage(
      playerIndex: playerIndex,
      sourceIndex: sourceIndex,
      value: state.commanderDamageAt(
            playerIndex: playerIndex,
            sourceIndex: sourceIndex,
          ) +
          1,
    );
  }

  void decrementCommanderDamage({
    required int playerIndex,
    required int sourceIndex,
  }) {
    _setCommanderDamage(
      playerIndex: playerIndex,
      sourceIndex: sourceIndex,
      value: state.commanderDamageAt(
            playerIndex: playerIndex,
            sourceIndex: sourceIndex,
          ) -
          1,
    );
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

  void _setCounter(int playerIndex, PlayCounterType type, int value) {
    if (playerIndex < 0 || playerIndex >= state.players) return;
    final playerCounters = [...state.playerCounters];
    playerCounters[playerIndex] = playerCounters[playerIndex].withValue(
      type,
      value,
    );
    state = state.copyWith(
      hasSession: true,
      playerCounters: playerCounters,
    );
    unawaited(_store.write(state));
  }

  void _setCommanderDamage({
    required int playerIndex,
    required int sourceIndex,
    required int value,
  }) {
    if (playerIndex < 0 ||
        playerIndex >= state.players ||
        sourceIndex < 0 ||
        sourceIndex >= state.players ||
        playerIndex == sourceIndex) {
      return;
    }
    final commanderDamage = [
      for (final row in state.commanderDamage) [...row],
    ];
    commanderDamage[playerIndex][sourceIndex] =
        PlayPlayerCounters._clampCounter(value);
    state = state.copyWith(
      hasSession: true,
      commanderDamage: commanderDamage,
    );
    unawaited(_store.write(state));
  }
}
