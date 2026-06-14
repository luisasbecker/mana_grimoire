import 'package:flutter_test/flutter_test.dart';
import 'package:mana_grimoire/data/scan/scan_models.dart';
import 'package:mana_grimoire/screens/game_assistant/controllers/game_assistant_controller.dart';
import 'package:mana_grimoire/screens/game_assistant/services/card_recognition_service.dart';
import 'package:mana_grimoire/screens/game_assistant/types/game_assistant_types.dart';

void main() {
  test('GameAssistantCardRecognitionService requires 80 percent confidence',
      () {
    expect(
        GameAssistantCardRecognitionService.minimumRecognitionConfidence, 0.80);
  });

  test('GameAssistantController tracks cards, counters, abilities and summary',
      () {
    final controller = GameAssistantController();

    controller.markCameraReady();
    controller.beginSurfaceCalibration();
    controller.completeSurfaceCalibration();
    controller.registerCandidate(
      ScanRecognitionCandidate(
        card: const ScanCatalogCard(
          id: 'sol-ring-cmm-1',
          oracleId: 'sol-ring-oracle',
          name: 'Sol Ring',
          setCode: 'cmm',
          setName: 'Commander Masters',
          collectorNumber: '1',
          rarity: 'uncommon',
          typeLine: 'Artifact',
          imageUrlPng: 'https://img.example/sol-ring.png',
        ),
        score: 0.92,
        matchReason: 'OCR name',
      ),
    );

    expect(controller.state.activeCard, isNull);
    controller.selectCard('sol-ring-cmm-1');
    controller.moveCard('sol-ring-cmm-1', const Offset(0.72, 0.58));
    controller.decrementLife(0);
    controller.incrementCounter(GameAssistantCounterType.charge);
    controller.incrementCounter(GameAssistantCounterType.charge);
    controller.decrementCounter(GameAssistantCounterType.charge);
    controller.incrementDamage();
    controller.toggleAbility(GameAssistantAbility.hexproof);
    controller.endGame();

    expect(controller.state.phase, GameAssistantPhase.summary);
    expect(controller.state.players.first.life, 39);
    expect(controller.state.trackedCards, hasLength(1));
    expect(controller.state.activeCard?.name, 'Sol Ring');
    expect(controller.state.activeCard?.imageUrl,
        'https://img.example/sol-ring.png');
    expect(controller.state.activeCard?.position, const Offset(0.72, 0.58));
    expect(
      controller.state.activeCard
          ?.counterValue(GameAssistantCounterType.charge),
      1,
    );
    expect(controller.state.activeCard?.damage, 1);
    expect(
      controller.state.activeCard?.abilities,
      contains(GameAssistantAbility.hexproof),
    );
    expect(controller.state.totalCounters, 1);
    expect(controller.state.totalDamage, 1);
    expect(controller.state.totalAbilities, 1);
    expect(controller.state.log, isNotEmpty);
  });

  test('GameAssistantController can clear card selection', () {
    final controller = GameAssistantController();

    controller.addManualCard();
    expect(controller.state.activeCard, isNotNull);

    controller.deselectCard();

    expect(controller.state.activeCard, isNull);
    expect(controller.state.activeCardId, isNull);
  });

  test('GameAssistantController adds manual cards at tapped table position',
      () {
    final controller = GameAssistantController();

    controller.addManualCardAt(const Offset(0.62, 0.44));

    expect(controller.state.trackedCards, hasLength(1));
    expect(controller.state.activeCard?.name, 'Carta 1');
    expect(controller.state.activeCard?.position, const Offset(0.62, 0.44));
  });

  test('GameAssistantController clamps tapped table positions', () {
    final controller = GameAssistantController();

    controller.addManualCardAt(const Offset(0.99, 0.01));

    expect(controller.state.activeCard?.position, const Offset(0.92, 0.14));
  });

  test('GameAssistantController removes selected cards from the board', () {
    final controller = GameAssistantController();

    controller.addManualCard();
    final cardId = controller.state.activeCard!.id;

    controller.removeCard(cardId);

    expect(controller.state.trackedCards, isEmpty);
    expect(controller.state.activeCard, isNull);
    expect(controller.state.statusMessage, contains('removida'));
  });
}
