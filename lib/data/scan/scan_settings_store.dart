import 'dart:convert';
import 'dart:io';

import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

class ScanSettings {
  const ScanSettings({this.recognitionSoundEnabled = false});

  final bool recognitionSoundEnabled;

  ScanSettings copyWith({bool? recognitionSoundEnabled}) {
    return ScanSettings(
      recognitionSoundEnabled:
          recognitionSoundEnabled ?? this.recognitionSoundEnabled,
    );
  }
}

class ScanSettingsStore {
  static const _fileName = 'mana_live_scan_settings.json';

  Future<ScanSettings> load() async {
    final file = await _settingsFile();
    if (!await file.exists()) return const ScanSettings();

    try {
      final payload = jsonDecode(await file.readAsString());
      if (payload is! Map<String, dynamic>) return const ScanSettings();
      return ScanSettings(
        recognitionSoundEnabled: payload['recognitionSoundEnabled'] == true,
      );
    } on FormatException {
      await clear();
      return const ScanSettings();
    }
  }

  Future<void> save(ScanSettings settings) async {
    final file = await _settingsFile();
    await file.parent.create(recursive: true);
    final temporaryFile = File('${file.path}.tmp');
    await temporaryFile.writeAsString(
      jsonEncode(<String, dynamic>{
        'version': 1,
        'updatedAt': DateTime.now().toUtc().toIso8601String(),
        'recognitionSoundEnabled': settings.recognitionSoundEnabled,
      }),
      flush: true,
    );
    if (await file.exists()) await file.delete();
    await temporaryFile.rename(file.path);
  }

  Future<void> clear() async {
    final file = await _settingsFile();
    if (await file.exists()) await file.delete();
  }

  Future<File> _settingsFile() async {
    final directory = await getApplicationDocumentsDirectory();
    return File(p.join(directory.path, _fileName));
  }
}
