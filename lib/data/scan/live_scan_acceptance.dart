import 'scan_models.dart';

class LiveScanAcceptance {
  const LiveScanAcceptance._({
    required this.canAutoAccept,
    required this.confirmationsRequired,
    required this.statusMessage,
  });

  factory LiveScanAcceptance.accept({required int confirmationsRequired}) {
    return LiveScanAcceptance._(
      canAutoAccept: true,
      confirmationsRequired: confirmationsRequired,
      statusMessage: 'Candidato confirmado.',
    );
  }

  factory LiveScanAcceptance.reject(String statusMessage) {
    return LiveScanAcceptance._(
      canAutoAccept: false,
      confirmationsRequired: 0,
      statusMessage: statusMessage,
    );
  }

  final bool canAutoAccept;
  final int confirmationsRequired;
  final String statusMessage;
}

class LiveScanAcceptancePolicy {
  const LiveScanAcceptancePolicy({
    required this.fastConfirmations,
    required this.strictConfirmations,
  });

  final int fastConfirmations;
  final int strictConfirmations;

  LiveScanAcceptance evaluate(ScanRecognitionCandidate candidate) {
    final reason = candidate.matchReason.toLowerCase();
    final isVisual = reason.contains('visual fingerprint');
    final agreesWithOcr = reason.contains('ocr agrees');
    final hasEditionCue = reason.contains('edition cue');
    final isUniqueName = reason.contains('unique name');
    final isAmbiguousNameOnly = reason.contains('ambiguous name only');

    if (isVisual && agreesWithOcr && candidate.score >= 0.70) {
      return LiveScanAcceptance.accept(
        confirmationsRequired: fastConfirmations,
      );
    }
    if (isVisual && candidate.score >= 0.76) {
      return LiveScanAcceptance.accept(
        confirmationsRequired: fastConfirmations,
      );
    }
    if (hasEditionCue && candidate.score >= 0.78) {
      return LiveScanAcceptance.accept(
        confirmationsRequired: fastConfirmations,
      );
    }
    if (isUniqueName && candidate.score >= 0.88) {
      return LiveScanAcceptance.accept(
        confirmationsRequired: fastConfirmations,
      );
    }
    if (isAmbiguousNameOnly && candidate.score >= 0.66) {
      return LiveScanAcceptance.accept(
        confirmationsRequired: strictConfirmations,
      );
    }

    return LiveScanAcceptance.reject(
      'Possível ${candidate.name} (${candidate.editionLabel}). Mantenha na mira para confirmar.',
    );
  }
}

class LiveScanDuplicateGate {
  String? _lastAcceptedVariantKey;

  bool shouldAccept(String variantKey) {
    if (variantKey.isEmpty) return false;
    if (_lastAcceptedVariantKey == variantKey) return false;
    _lastAcceptedVariantKey = variantKey;
    return true;
  }

  void forget(String variantKey) {
    if (_lastAcceptedVariantKey == variantKey) {
      _lastAcceptedVariantKey = null;
    }
  }

  void reset() {
    _lastAcceptedVariantKey = null;
  }
}
