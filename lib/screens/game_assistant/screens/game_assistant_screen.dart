import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../../../data/local/db/db_instance.dart';
import '../../../widgets/mana_surface_card.dart';
import '../../../widgets/mana_tab_main_app_bar.dart';
import '../components/ability_selector.dart';
import '../components/ar_camera_view.dart';
import '../components/card_counter_controls.dart';
import '../components/life_counter_hud.dart';
import '../controllers/game_assistant_controller.dart';
import '../services/card_recognition_service.dart';
import '../types/game_assistant_types.dart';
import 'battle_summary_screen.dart';

class GameAssistantScreen extends ConsumerStatefulWidget {
  const GameAssistantScreen({super.key});

  @override
  ConsumerState<GameAssistantScreen> createState() =>
      _GameAssistantScreenState();
}

class _GameAssistantScreenState extends ConsumerState<GameAssistantScreen> {
  late final GameAssistantCardRecognitionService _recognitionService;

  @override
  void initState() {
    super.initState();
    _recognitionService = GameAssistantCardRecognitionService(db: appDb);
  }

  @override
  void dispose() {
    _recognitionService.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final state = ref.watch(gameAssistantControllerProvider);
    final controller = ref.read(gameAssistantControllerProvider.notifier);

    if (state.phase == GameAssistantPhase.summary) {
      return BattleSummaryScreen(
        state: state,
        onNewGame: controller.resetGame,
      );
    }

    return Scaffold(
      appBar: const ManaTabMainAppBar(title: 'Assistente de Jogo'),
      body: LayoutBuilder(
        builder: (context, constraints) {
          final activeCard = state.activeCard;
          final showBottomControls =
              state.surfaceCalibrated || activeCard != null;
          final compactDockHeight = 70.0;
          final panelMaxHeight = activeCard == null
              ? compactDockHeight
              : (constraints.maxHeight * 0.46).clamp(260.0, 360.0).toDouble();
          return Stack(
            fit: StackFit.expand,
            children: [
              ARCameraView(
                state: state,
                recognitionService: _recognitionService,
                statusBottomInset: panelMaxHeight + 22,
                onCameraReady: controller.markCameraReady,
                onCameraUnavailable: controller.markCameraUnavailable,
                onStatus: controller.setStatus,
                onCardRecognized: controller.registerCandidate,
                onSelectCard: controller.selectCard,
                onMoveCard: controller.moveCard,
                onDeselectCard: controller.deselectCard,
                onAddManualCardAt: controller.addManualCardAt,
                onBeginCalibration: controller.beginSurfaceCalibration,
                onCompleteCalibration: controller.completeSurfaceCalibration,
              ),
              Positioned(
                top: 12,
                left: 0,
                right: 0,
                child: LifeCounterHUD(
                  players: state.players,
                  onIncrement: controller.incrementLife,
                  onDecrement: controller.decrementLife,
                ),
              ),
              if (showBottomControls)
                Positioned(
                  left: 12,
                  right: 12,
                  bottom: 12,
                  child: ConstrainedBox(
                    constraints: BoxConstraints(maxHeight: panelMaxHeight),
                    child: activeCard == null
                        ? _CompactSessionDock(
                            state: state,
                            onBeginCalibration:
                                controller.beginSurfaceCalibration,
                            onCompleteCalibration:
                                controller.completeSurfaceCalibration,
                            onResumeScanning: controller.resumeScanning,
                            onPauseScanning: controller.pauseScanning,
                            onAddManualCard: controller.addManualCard,
                            onEndGame: controller.endGame,
                          )
                        : _AssistantControlPanel(
                            card: activeCard,
                            onDeselectCard: controller.deselectCard,
                            onRemoveCard: () =>
                                controller.removeCard(activeCard.id),
                            onIncrementCounter: controller.incrementCounter,
                            onDecrementCounter: controller.decrementCounter,
                            onIncrementDamage: controller.incrementDamage,
                            onDecrementDamage: controller.decrementDamage,
                            onIncrementPower: controller.incrementPowerBuff,
                            onDecrementPower: controller.decrementPowerBuff,
                            onIncrementToughness:
                                controller.incrementToughnessBuff,
                            onDecrementToughness:
                                controller.decrementToughnessBuff,
                            onToggleAbility: controller.toggleAbility,
                          ),
                  ),
                ),
            ],
          );
        },
      ),
    );
  }
}

class _AssistantControlPanel extends StatelessWidget {
  const _AssistantControlPanel({
    required this.card,
    required this.onDeselectCard,
    required this.onRemoveCard,
    required this.onIncrementCounter,
    required this.onDecrementCounter,
    required this.onIncrementDamage,
    required this.onDecrementDamage,
    required this.onIncrementPower,
    required this.onDecrementPower,
    required this.onIncrementToughness,
    required this.onDecrementToughness,
    required this.onToggleAbility,
  });

  final GameAssistantTrackedCard card;
  final VoidCallback onDeselectCard;
  final VoidCallback onRemoveCard;
  final ValueChanged<GameAssistantCounterType> onIncrementCounter;
  final ValueChanged<GameAssistantCounterType> onDecrementCounter;
  final VoidCallback onIncrementDamage;
  final VoidCallback onDecrementDamage;
  final VoidCallback onIncrementPower;
  final VoidCallback onDecrementPower;
  final VoidCallback onIncrementToughness;
  final VoidCallback onDecrementToughness;
  final ValueChanged<GameAssistantAbility> onToggleAbility;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    return ManaSurfaceCard(
      padding: const EdgeInsets.fromLTRB(14, 12, 14, 14),
      backgroundColor: scheme.surfaceContainerHigh.withValues(alpha: 0.95),
      borderColor: scheme.primary.withValues(alpha: 0.22),
      child: SingleChildScrollView(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Row(
              children: [
                Icon(Icons.style_outlined, color: scheme.primary),
                const SizedBox(width: 8),
                Expanded(
                  child: Text(
                    card.name,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                    style: theme.textTheme.titleSmall?.copyWith(
                      fontWeight: FontWeight.w900,
                    ),
                  ),
                ),
                Text(
                  '${(card.confidence * 100).round()}%',
                  style: theme.textTheme.labelSmall?.copyWith(
                    color: scheme.onSurfaceVariant,
                    fontWeight: FontWeight.w900,
                  ),
                ),
                const SizedBox(width: 4),
                IconButton(
                  tooltip: 'Remover carta do campo',
                  color: scheme.error,
                  onPressed: onRemoveCard,
                  icon: const Icon(Icons.delete_outline_rounded),
                ),
                IconButton(
                  tooltip: 'Desselecionar carta',
                  onPressed: onDeselectCard,
                  icon: const Icon(Icons.close_rounded),
                ),
              ],
            ),
            const SizedBox(height: 2),
            Text(
              card.typeLine,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: theme.textTheme.bodySmall?.copyWith(
                color: scheme.onSurfaceVariant,
                fontWeight: FontWeight.w700,
              ),
            ),
            const SizedBox(height: 12),
            CardCounterControls(
              card: card,
              onIncrementCounter: onIncrementCounter,
              onDecrementCounter: onDecrementCounter,
              onIncrementDamage: onIncrementDamage,
              onDecrementDamage: onDecrementDamage,
              onIncrementPower: onIncrementPower,
              onDecrementPower: onDecrementPower,
              onIncrementToughness: onIncrementToughness,
              onDecrementToughness: onDecrementToughness,
            ),
            const SizedBox(height: 14),
            Text(
              'Habilidades',
              style: theme.textTheme.labelLarge?.copyWith(
                fontWeight: FontWeight.w900,
              ),
            ),
            const SizedBox(height: 8),
            AbilitySelector(
              selectedAbilities: card.abilities,
              onToggleAbility: onToggleAbility,
            ),
          ],
        ),
      ),
    );
  }
}

class _CompactSessionDock extends StatelessWidget {
  const _CompactSessionDock({
    required this.state,
    required this.onBeginCalibration,
    required this.onCompleteCalibration,
    required this.onResumeScanning,
    required this.onPauseScanning,
    required this.onAddManualCard,
    required this.onEndGame,
  });

  final GameAssistantState state;
  final VoidCallback onBeginCalibration;
  final VoidCallback onCompleteCalibration;
  final VoidCallback onResumeScanning;
  final VoidCallback onPauseScanning;
  final VoidCallback onAddManualCard;
  final VoidCallback onEndGame;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final calibrating = state.phase == GameAssistantPhase.calibrating;
    final needsCalibration = !state.surfaceCalibrated;
    final primaryActionLabel = needsCalibration
        ? calibrating
            ? 'Confirmar mesa'
            : 'Calibrar mesa'
        : state.isScanning
            ? 'Pausar'
            : 'Retomar';
    final primaryActionIcon = needsCalibration
        ? calibrating
            ? Icons.check_rounded
            : Icons.grid_on_rounded
        : state.isScanning
            ? Icons.pause_rounded
            : Icons.play_arrow_rounded;
    final primaryAction = needsCalibration
        ? state.cameraReady
            ? calibrating
                ? onCompleteCalibration
                : onBeginCalibration
            : null
        : state.isScanning
            ? onPauseScanning
            : onResumeScanning;

    return ManaSurfaceCard(
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 8),
      backgroundColor: scheme.surfaceContainerHigh.withValues(alpha: 0.93),
      borderColor: scheme.primary.withValues(alpha: 0.18),
      child: Row(
        children: [
          Expanded(
            child: Text(
              state.trackedCards.isEmpty
                  ? state.statusMessage
                  : '${state.trackedCards.length} carta(s) no campo',
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: theme.textTheme.labelMedium?.copyWith(
                color: scheme.onSurfaceVariant,
                fontWeight: FontWeight.w800,
              ),
            ),
          ),
          const SizedBox(width: 8),
          _DockIconButton(
            tooltip: primaryActionLabel,
            icon: primaryActionIcon,
            onPressed: primaryAction,
            filled: true,
          ),
          const SizedBox(width: 6),
          _DockIconButton(
            tooltip: 'Adicionar carta',
            icon: Icons.add_box_outlined,
            onPressed: onAddManualCard,
          ),
          const SizedBox(width: 6),
          _DockIconButton(
            tooltip: 'Encerrar partida',
            icon: Icons.stop_circle_outlined,
            onPressed: onEndGame,
            danger: true,
          ),
        ],
      ),
    );
  }
}

class _DockIconButton extends StatelessWidget {
  const _DockIconButton({
    required this.tooltip,
    required this.icon,
    required this.onPressed,
    this.filled = false,
    this.danger = false,
  });

  final String tooltip;
  final IconData icon;
  final VoidCallback? onPressed;
  final bool filled;
  final bool danger;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final style = IconButton.styleFrom(
      backgroundColor: danger ? scheme.errorContainer : null,
      foregroundColor: danger ? scheme.onErrorContainer : null,
      fixedSize: const Size.square(44),
      minimumSize: const Size.square(44),
      tapTargetSize: MaterialTapTargetSize.shrinkWrap,
    );
    final child = IconButton(
      tooltip: tooltip,
      style: style,
      onPressed: onPressed,
      icon: Icon(icon),
    );
    if (filled) {
      return IconButton.filledTonal(
        tooltip: tooltip,
        style: style,
        onPressed: onPressed,
        icon: Icon(icon),
      );
    }
    return child;
  }
}
