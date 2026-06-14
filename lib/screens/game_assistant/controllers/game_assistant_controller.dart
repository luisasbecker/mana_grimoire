import 'dart:ui';

import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../../../data/scan/scan_models.dart';
import '../types/game_assistant_types.dart';

final gameAssistantControllerProvider =
    StateNotifierProvider<GameAssistantController, GameAssistantState>((ref) {
  return GameAssistantController();
});

class GameAssistantController extends StateNotifier<GameAssistantState> {
  GameAssistantController() : super(GameAssistantState.initial());

  void markCameraReady() {
    state = state.copyWith(
      cameraReady: true,
      statusMessage: state.surfaceCalibrated
          ? 'Câmera pronta. Aponte para uma carta.'
          : 'Câmera pronta. Escaneie a superfície da mesa.',
    );
  }

  void markCameraUnavailable(String message) {
    state = state.copyWith(
      cameraReady: false,
      phase: GameAssistantPhase.setup,
      statusMessage: message,
    );
  }

  void setStatus(String message) {
    if (message == state.statusMessage) return;
    state = state.copyWith(statusMessage: message);
  }

  void beginSurfaceCalibration() {
    state = state.copyWith(
      phase: GameAssistantPhase.calibrating,
      statusMessage: 'Alinhe a câmera com a mesa e confirme a superfície.',
    );
  }

  void completeSurfaceCalibration() {
    state = _withLog(
      state.copyWith(
        phase: GameAssistantPhase.scanning,
        surfaceCalibrated: true,
        statusMessage: 'Mesa calibrada. Procurando cartas no campo.',
      ),
      'Superfície da mesa calibrada.',
    );
  }

  void resumeScanning() {
    state = state.copyWith(
      phase: GameAssistantPhase.scanning,
      statusMessage: 'Procurando cartas no campo.',
    );
  }

  void pauseScanning() {
    state = state.copyWith(
      phase: GameAssistantPhase.paused,
      statusMessage: 'Assistente pausado.',
    );
  }

  void registerCandidate(ScanRecognitionCandidate candidate) {
    final now = DateTime.now();
    final cards = [...state.trackedCards];
    final index = cards.indexWhere(
      (card) => card.printingId == candidate.printingId,
    );

    if (index >= 0) {
      final existing = cards[index];
      cards[index] = existing.copyWith(
        imageUrl: existing.imageUrl ?? candidate.bestImageUrl,
        confidence: candidate.score,
        lastSeenAt: now,
      );
    } else {
      final cardId = candidate.printingId;
      cards.add(
        GameAssistantTrackedCard(
          id: cardId,
          printingId: candidate.printingId,
          oracleId: candidate.oracleId,
          name: candidate.name,
          editionLabel: candidate.editionLabel,
          typeLine: candidate.typeLine,
          imageUrl: candidate.bestImageUrl,
          confidence: candidate.score,
          position: _positionForCard(cards.length),
          firstSeenAt: now,
          lastSeenAt: now,
        ),
      );
    }

    final verb = index >= 0 ? 'Atualizada' : 'Detectada';
    state = _withLog(
      state.copyWith(
        trackedCards: cards,
        phase: GameAssistantPhase.scanning,
        statusMessage: '$verb: ${candidate.name}',
      ),
      '$verb carta ${candidate.name}.',
    );
  }

  void addManualCard() {
    _addManualCardAt(_positionForCard(state.trackedCards.length));
  }

  void addManualCardAt(Offset normalizedPosition) {
    _addManualCardAt(_clampCardPosition(normalizedPosition));
  }

  void _addManualCardAt(Offset position) {
    final now = DateTime.now();
    final nextNumber = state.trackedCards.length + 1;
    final card = GameAssistantTrackedCard(
      id: 'manual-$nextNumber-${now.millisecondsSinceEpoch}',
      printingId: 'manual-$nextNumber',
      oracleId: 'manual-$nextNumber',
      name: 'Carta $nextNumber',
      editionLabel: 'Manual',
      typeLine: 'Permanente',
      confidence: 1,
      position: position,
      firstSeenAt: now,
      lastSeenAt: now,
    );
    state = _withLog(
      state.copyWith(
        trackedCards: [...state.trackedCards, card],
        activeCardId: card.id,
        statusMessage: '${card.name} adicionada ao campo.',
      ),
      '${card.name} adicionada manualmente.',
    );
  }

  void selectCard(String cardId) {
    if (!state.trackedCards.any((card) => card.id == cardId)) return;
    state = state.copyWith(activeCardId: cardId);
  }

  void removeCard(String cardId) {
    final cards = [...state.trackedCards];
    final index = cards.indexWhere((card) => card.id == cardId);
    if (index < 0) return;
    final removed = cards.removeAt(index);
    state = _withLog(
      state.copyWith(
        trackedCards: cards,
        clearActiveCard: state.activeCardId == cardId,
        statusMessage: '${removed.name} removida do campo.',
      ),
      '${removed.name} removida do campo.',
    );
  }

  void deselectCard() {
    if (state.activeCardId == null) return;
    state = state.copyWith(
      clearActiveCard: true,
      statusMessage: 'Carta desselecionada. Toque em uma carta para editar.',
    );
  }

  void moveCard(String cardId, Offset normalizedPosition) {
    final cards = [...state.trackedCards];
    final index = cards.indexWhere((card) => card.id == cardId);
    if (index < 0) return;
    final nextPosition = _clampCardPosition(normalizedPosition);
    if ((cards[index].position - nextPosition).distance < 0.002) return;
    cards[index] = cards[index].copyWith(position: nextPosition);
    state = state.copyWith(
      trackedCards: cards,
      activeCardId: cardId,
    );
  }

  void incrementLife(int playerIndex) {
    if (playerIndex < 0 || playerIndex >= state.players.length) return;
    _setPlayerLife(playerIndex, state.players[playerIndex].life + 1);
  }

  void decrementLife(int playerIndex) {
    if (playerIndex < 0 || playerIndex >= state.players.length) return;
    _setPlayerLife(playerIndex, state.players[playerIndex].life - 1);
  }

  void incrementCounter(GameAssistantCounterType type) {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.withCounter(type, card.counterValue(type) + 1),
      '${card.name}: ${type.label} +1.',
    );
  }

  void decrementCounter(GameAssistantCounterType type) {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.withCounter(type, card.counterValue(type) - 1),
      '${card.name}: ${type.label} -1.',
    );
  }

  void incrementDamage() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(damage: card.damage + 1),
      '${card.name}: dano marcado +1.',
    );
  }

  void decrementDamage() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(damage: card.damage - 1),
      '${card.name}: dano marcado -1.',
    );
  }

  void incrementPowerBuff() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(powerBuff: card.powerBuff + 1),
      '${card.name}: poder +1.',
    );
  }

  void decrementPowerBuff() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(powerBuff: card.powerBuff - 1),
      '${card.name}: poder -1.',
    );
  }

  void incrementToughnessBuff() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(toughnessBuff: card.toughnessBuff + 1),
      '${card.name}: resistência +1.',
    );
  }

  void decrementToughnessBuff() {
    final card = state.activeCard;
    if (card == null) return;
    _updateCard(
      card.id,
      card.copyWith(toughnessBuff: card.toughnessBuff - 1),
      '${card.name}: resistência -1.',
    );
  }

  void toggleAbility(GameAssistantAbility ability) {
    final card = state.activeCard;
    if (card == null) return;
    final abilities = Set<GameAssistantAbility>.from(card.abilities);
    final added = abilities.add(ability);
    if (!added) abilities.remove(ability);
    _updateCard(
      card.id,
      card.copyWith(abilities: abilities),
      added
          ? '${card.name}: ${ability.label} adicionada.'
          : '${card.name}: ${ability.label} removida.',
    );
  }

  void endGame() {
    state = _withLog(
      state.copyWith(
        phase: GameAssistantPhase.summary,
        endedAt: DateTime.now(),
        statusMessage: 'Partida encerrada.',
      ),
      'Partida encerrada.',
    );
  }

  void resetGame() {
    state = GameAssistantState.initial();
  }

  void _setPlayerLife(int playerIndex, int value) {
    if (playerIndex < 0 || playerIndex >= state.players.length) return;
    final players = [...state.players];
    players[playerIndex] = players[playerIndex].copyWith(life: value);
    state = _withLog(
      state.copyWith(
        players: players,
        statusMessage:
            '${players[playerIndex].name}: ${players[playerIndex].life} de vida.',
      ),
      '${players[playerIndex].name} foi para ${players[playerIndex].life} de vida.',
    );
  }

  void _updateCard(
    String cardId,
    GameAssistantTrackedCard updated,
    String logMessage,
  ) {
    final cards = [...state.trackedCards];
    final index = cards.indexWhere((card) => card.id == cardId);
    if (index < 0) return;
    cards[index] = updated;
    state = _withLog(
      state.copyWith(
        trackedCards: cards,
        activeCardId: cardId,
        statusMessage: logMessage,
      ),
      logMessage,
    );
  }

  GameAssistantState _withLog(GameAssistantState next, String message) {
    final entry = GameAssistantLogEntry(
      timestamp: DateTime.now(),
      message: message,
    );
    final recentLog =
        next.log.length <= 79 ? next.log : next.log.skip(next.log.length - 79);
    return next.copyWith(
      log: [
        ...recentLog,
        entry,
      ],
    );
  }

  Offset _positionForCard(int index) {
    const positions = <Offset>[
      Offset(0.18, 0.30),
      Offset(0.50, 0.30),
      Offset(0.82, 0.30),
      Offset(0.22, 0.48),
      Offset(0.54, 0.48),
      Offset(0.78, 0.48),
      Offset(0.18, 0.66),
      Offset(0.50, 0.66),
      Offset(0.82, 0.66),
      Offset(0.34, 0.82),
      Offset(0.66, 0.82),
    ];
    final base = positions[index % positions.length];
    final cycle = index ~/ positions.length;
    if (cycle == 0) return base;
    final offset = cycle.isEven ? 0.035 : -0.035;
    return Offset(
      (base.dx + offset).clamp(0.10, 0.90).toDouble(),
      (base.dy - offset).clamp(0.16, 0.86).toDouble(),
    );
  }

  Offset _clampCardPosition(Offset normalizedPosition) {
    return Offset(
      normalizedPosition.dx.clamp(0.08, 0.92).toDouble(),
      normalizedPosition.dy.clamp(0.14, 0.88).toDouble(),
    );
  }
}
