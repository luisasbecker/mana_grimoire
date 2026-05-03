import 'package:flutter/services.dart';

class ScanFeedbackService {
  static const _channel = MethodChannel('mana_grimoire/scan_feedback');

  Future<void> playRecognitionSound({required bool enabled}) async {
    if (!enabled) return;
    try {
      await _channel.invokeMethod<bool>('playRecognitionSound');
    } on MissingPluginException {
      await SystemSound.play(SystemSoundType.click);
    } on PlatformException {
      await SystemSound.play(SystemSoundType.click);
    }
  }
}
