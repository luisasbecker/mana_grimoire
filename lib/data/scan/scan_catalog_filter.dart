import '../local/db/app_database.dart';
import 'scan_models.dart';

class ScanCatalogFilter {
  const ScanCatalogFilter._();

  static bool isScanEligiblePrinting(ScryfallPrinting printing) {
    return _isScanEligible(
      setName: printing.setName,
      typeLine: printing.typeLine,
    );
  }

  static bool isScanEligibleCard(ScanCatalogCard card) {
    return _isScanEligible(
      setName: card.setName,
      typeLine: card.typeLine,
    );
  }

  static bool isScanEligibleJson(Map<String, dynamic> json) {
    final layout = json['layout']?.toString().toLowerCase() ?? '';
    if (layout == 'art_series') return false;

    final setName = json['set_name']?.toString() ?? '';
    final typeLine = json['type_line']?.toString() ??
        _firstFaceString(json, 'type_line') ??
        '';
    return _isScanEligible(setName: setName, typeLine: typeLine);
  }

  static String? _firstFaceString(Map<String, dynamic> json, String key) {
    final faces = json['card_faces'];
    if (faces is! List<dynamic> || faces.isEmpty) return null;
    final first = faces.first;
    if (first is! Map<String, dynamic>) return null;
    return first[key]?.toString();
  }

  static bool _isScanEligible({
    required String setName,
    required String typeLine,
  }) {
    final normalizedSet = setName.toLowerCase();
    if (normalizedSet.contains('art series')) return false;

    final normalizedType = typeLine
        .toLowerCase()
        .replaceAll(RegExp(r'[^a-z]+'), ' ')
        .replaceAll(RegExp(r'\s+'), ' ')
        .trim();
    if (normalizedType == 'card' || normalizedType == 'card card') {
      return false;
    }

    return true;
  }
}
