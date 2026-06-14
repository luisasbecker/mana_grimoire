import '../types/game_assistant_types.dart';

class GameAssistantSummary {
  const GameAssistantSummary({
    required this.duration,
    required this.cardsTracked,
    required this.totalCounters,
    required this.totalDamage,
    required this.totalAbilities,
    required this.lowestLife,
    required this.actionsLogged,
  });

  final Duration duration;
  final int cardsTracked;
  final int totalCounters;
  final int totalDamage;
  final int totalAbilities;
  final int lowestLife;
  final int actionsLogged;
}

class GameLogService {
  const GameLogService();

  GameAssistantSummary summarize(GameAssistantState state) {
    final lowestLife = state.players.isEmpty
        ? 0
        : state.players
            .map((player) => player.life)
            .reduce((left, right) => left < right ? left : right);
    return GameAssistantSummary(
      duration: state.elapsed,
      cardsTracked: state.trackedCards.length,
      totalCounters: state.totalCounters,
      totalDamage: state.totalDamage,
      totalAbilities: state.totalAbilities,
      lowestLife: lowestLife,
      actionsLogged: state.log.length,
    );
  }

  String formatDuration(Duration duration) {
    final minutes = duration.inMinutes;
    final seconds = duration.inSeconds.remainder(60);
    if (minutes <= 0) return '${seconds}s';
    return '${minutes}m ${seconds.toString().padLeft(2, '0')}s';
  }
}
