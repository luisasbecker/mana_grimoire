import 'dart:ui';

import 'package:flutter/foundation.dart';

enum GameAssistantPhase {
  setup,
  calibrating,
  scanning,
  paused,
  summary,
}

enum GameAssistantCounterType {
  plusOne,
  minusOne,
  charge,
  shield,
  stun,
  loyalty,
  generic,
}

extension GameAssistantCounterTypeLabel on GameAssistantCounterType {
  String get label {
    return switch (this) {
      GameAssistantCounterType.plusOne => '+1/+1',
      GameAssistantCounterType.minusOne => '-1/-1',
      GameAssistantCounterType.charge => 'Carga',
      GameAssistantCounterType.shield => 'Escudo',
      GameAssistantCounterType.stun => 'Atordoar',
      GameAssistantCounterType.loyalty => 'Lealdade',
      GameAssistantCounterType.generic => 'Geral',
    };
  }
}

enum GameAssistantAbility {
  flying,
  deathtouch,
  trample,
  lifelink,
  hexproof,
  vigilance,
  haste,
  reach,
  menace,
  firstStrike,
  doubleStrike,
  indestructible,
  ward,
}

extension GameAssistantAbilityLabel on GameAssistantAbility {
  String get label {
    return switch (this) {
      GameAssistantAbility.flying => 'Flying',
      GameAssistantAbility.deathtouch => 'Deathtouch',
      GameAssistantAbility.trample => 'Trample',
      GameAssistantAbility.lifelink => 'Lifelink',
      GameAssistantAbility.hexproof => 'Hexproof',
      GameAssistantAbility.vigilance => 'Vigilance',
      GameAssistantAbility.haste => 'Haste',
      GameAssistantAbility.reach => 'Reach',
      GameAssistantAbility.menace => 'Menace',
      GameAssistantAbility.firstStrike => 'First strike',
      GameAssistantAbility.doubleStrike => 'Double strike',
      GameAssistantAbility.indestructible => 'Indestructible',
      GameAssistantAbility.ward => 'Ward',
    };
  }
}

@immutable
class GameAssistantPlayer {
  const GameAssistantPlayer({
    required this.id,
    required this.name,
    required this.life,
  });

  final String id;
  final String name;
  final int life;

  GameAssistantPlayer copyWith({
    String? id,
    String? name,
    int? life,
  }) {
    return GameAssistantPlayer(
      id: id ?? this.id,
      name: name ?? this.name,
      life: _clampLife(life ?? this.life),
    );
  }

  static int _clampLife(int value) => value.clamp(0, 999).toInt();
}

@immutable
class GameAssistantTrackedCard {
  const GameAssistantTrackedCard({
    required this.id,
    required this.printingId,
    required this.oracleId,
    required this.name,
    required this.editionLabel,
    required this.typeLine,
    required this.confidence,
    required this.position,
    required this.firstSeenAt,
    required this.lastSeenAt,
    this.imageUrl,
    this.damage = 0,
    this.powerBuff = 0,
    this.toughnessBuff = 0,
    this.counters = const <GameAssistantCounterType, int>{},
    this.abilities = const <GameAssistantAbility>{},
  });

  final String id;
  final String printingId;
  final String oracleId;
  final String name;
  final String editionLabel;
  final String typeLine;
  final String? imageUrl;
  final double confidence;
  final Offset position;
  final DateTime firstSeenAt;
  final DateTime lastSeenAt;
  final int damage;
  final int powerBuff;
  final int toughnessBuff;
  final Map<GameAssistantCounterType, int> counters;
  final Set<GameAssistantAbility> abilities;

  int counterValue(GameAssistantCounterType type) => counters[type] ?? 0;

  int get totalCounters =>
      counters.values.fold<int>(0, (sum, value) => sum + value);

  GameAssistantTrackedCard copyWith({
    String? id,
    String? printingId,
    String? oracleId,
    String? name,
    String? editionLabel,
    String? typeLine,
    String? imageUrl,
    double? confidence,
    Offset? position,
    DateTime? firstSeenAt,
    DateTime? lastSeenAt,
    int? damage,
    int? powerBuff,
    int? toughnessBuff,
    Map<GameAssistantCounterType, int>? counters,
    Set<GameAssistantAbility>? abilities,
  }) {
    return GameAssistantTrackedCard(
      id: id ?? this.id,
      printingId: printingId ?? this.printingId,
      oracleId: oracleId ?? this.oracleId,
      name: name ?? this.name,
      editionLabel: editionLabel ?? this.editionLabel,
      typeLine: typeLine ?? this.typeLine,
      imageUrl: imageUrl ?? this.imageUrl,
      confidence: (confidence ?? this.confidence).clamp(0, 1).toDouble(),
      position: position ?? this.position,
      firstSeenAt: firstSeenAt ?? this.firstSeenAt,
      lastSeenAt: lastSeenAt ?? this.lastSeenAt,
      damage: _clampCounter(damage ?? this.damage),
      powerBuff: _clampBuff(powerBuff ?? this.powerBuff),
      toughnessBuff: _clampBuff(toughnessBuff ?? this.toughnessBuff),
      counters: Map<GameAssistantCounterType, int>.unmodifiable(counters ??
          this.counters.map(
                (type, value) => MapEntry(type, _clampCounter(value)),
              )),
      abilities:
          Set<GameAssistantAbility>.unmodifiable(abilities ?? this.abilities),
    );
  }

  GameAssistantTrackedCard withCounter(
    GameAssistantCounterType type,
    int value,
  ) {
    final next = Map<GameAssistantCounterType, int>.from(counters);
    final safeValue = _clampCounter(value);
    if (safeValue == 0) {
      next.remove(type);
    } else {
      next[type] = safeValue;
    }
    return copyWith(counters: next);
  }

  static int _clampCounter(int value) => value.clamp(0, 999).toInt();

  static int _clampBuff(int value) => value.clamp(-99, 99).toInt();
}

@immutable
class GameAssistantLogEntry {
  const GameAssistantLogEntry({
    required this.timestamp,
    required this.message,
  });

  final DateTime timestamp;
  final String message;
}

@immutable
class GameAssistantState {
  const GameAssistantState({
    required this.phase,
    required this.players,
    required this.trackedCards,
    required this.startedAt,
    required this.log,
    this.activeCardId,
    this.surfaceCalibrated = false,
    this.cameraReady = false,
    this.statusMessage = 'Aponte a câmera para a mesa para começar.',
    this.endedAt,
  });

  factory GameAssistantState.initial() {
    final now = DateTime.now();
    return GameAssistantState(
      phase: GameAssistantPhase.setup,
      startedAt: now,
      players: List<GameAssistantPlayer>.unmodifiable(
        List<GameAssistantPlayer>.generate(
          4,
          (index) => GameAssistantPlayer(
            id: 'player-${index + 1}',
            name: 'P${index + 1}',
            life: 40,
          ),
          growable: false,
        ),
      ),
      trackedCards: const <GameAssistantTrackedCard>[],
      log: const <GameAssistantLogEntry>[],
    );
  }

  final GameAssistantPhase phase;
  final List<GameAssistantPlayer> players;
  final List<GameAssistantTrackedCard> trackedCards;
  final String? activeCardId;
  final bool surfaceCalibrated;
  final bool cameraReady;
  final String statusMessage;
  final DateTime startedAt;
  final DateTime? endedAt;
  final List<GameAssistantLogEntry> log;

  bool get isScanning => phase == GameAssistantPhase.scanning;

  GameAssistantTrackedCard? get activeCard {
    for (final card in trackedCards) {
      if (card.id == activeCardId) return card;
    }
    return null;
  }

  int get totalDamage =>
      trackedCards.fold<int>(0, (sum, card) => sum + card.damage);

  int get totalCounters =>
      trackedCards.fold<int>(0, (sum, card) => sum + card.totalCounters);

  int get totalAbilities =>
      trackedCards.fold<int>(0, (sum, card) => sum + card.abilities.length);

  Duration get elapsed {
    final end = endedAt ?? DateTime.now();
    return end.difference(startedAt);
  }

  GameAssistantState copyWith({
    GameAssistantPhase? phase,
    List<GameAssistantPlayer>? players,
    List<GameAssistantTrackedCard>? trackedCards,
    String? activeCardId,
    bool clearActiveCard = false,
    bool? surfaceCalibrated,
    bool? cameraReady,
    String? statusMessage,
    DateTime? startedAt,
    DateTime? endedAt,
    bool clearEndedAt = false,
    List<GameAssistantLogEntry>? log,
  }) {
    return GameAssistantState(
      phase: phase ?? this.phase,
      players: List<GameAssistantPlayer>.unmodifiable(players ?? this.players),
      trackedCards: List<GameAssistantTrackedCard>.unmodifiable(
        trackedCards ?? this.trackedCards,
      ),
      activeCardId: clearActiveCard ? null : activeCardId ?? this.activeCardId,
      surfaceCalibrated: surfaceCalibrated ?? this.surfaceCalibrated,
      cameraReady: cameraReady ?? this.cameraReady,
      statusMessage: statusMessage ?? this.statusMessage,
      startedAt: startedAt ?? this.startedAt,
      endedAt: clearEndedAt ? null : endedAt ?? this.endedAt,
      log: List<GameAssistantLogEntry>.unmodifiable(log ?? this.log),
    );
  }
}
