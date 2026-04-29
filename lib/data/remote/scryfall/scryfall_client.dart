import 'dart:convert';

import 'package:dio/dio.dart';

/// Uma página de resultados da API `/cards/search` (Scryfall).
class ScryfallCardSearchPage {
  ScryfallCardSearchPage({
    required this.data,
    required this.hasMore,
    this.nextPageUrl,
  });

  final List<Map<String, dynamic>> data;
  final bool hasMore;
  final String? nextPageUrl;
}

class ScryfallClient {
  ScryfallClient({Dio? dio}) : _dio = dio ?? Dio() {
    _dio.options.baseUrl = 'https://api.scryfall.com';
    _dio.options.connectTimeout = const Duration(seconds: 15);
    _dio.options.receiveTimeout = const Duration(seconds: 20);
    _dio.options.headers = {
      'Accept': 'application/json',
      'User-Agent': 'ManaGrimoire/0.1 (Flutter)',
    };
  }

  final Dio _dio;

  /// Busca padrão (1 página).
  /// `unique`:
  /// - 'cards' (default): colapsa printings por oracle (não serve para "trocar edição")
  /// - 'prints': retorna todos os printings (serve para listar edições)
  Future<List<Map<String, dynamic>>> searchCards(
    String query, {
    String unique = 'cards',
  }) async {
    final res = await _dio.get(
      '/cards/search',
      queryParameters: {
        'q': query,
        'unique': unique,
        'order': 'released',
        'dir': 'desc',
      },
    );

    final data = res.data as Map<String, dynamic>;
    final list = (data['data'] as List).cast<Map<String, dynamic>>();
    return list;
  }

  /// Primeira página de `/cards/search` (útil para carregar aos poucos no cliente).
  Future<ScryfallCardSearchPage> searchCardsFirstPage(
    String query, {
    String unique = 'cards',
  }) async {
    final res = await _dio.get(
      '/cards/search',
      queryParameters: {
        'q': query,
        'unique': unique,
        'order': 'released',
        'dir': 'desc',
      },
    );
    return _parseSearchPage(res);
  }

  /// Página seguinte usando a URL absoluta devolvida por `next_page`.
  Future<ScryfallCardSearchPage> fetchSearchNextPage(String nextPageAbsoluteUrl) async {
    final res = await _dio.getUri(Uri.parse(nextPageAbsoluteUrl));
    return _parseSearchPage(res);
  }

  ScryfallCardSearchPage _parseSearchPage(Response res) {
    final data = res.data as Map<String, dynamic>;
    final list = (data['data'] as List).cast<Map<String, dynamic>>();
    final hasMore = data['has_more'] == true;
    final next = data['next_page'] as String?;
    return ScryfallCardSearchPage(
      data: list,
      hasMore: hasMore,
      nextPageUrl: next,
    );
  }

  /// Busca com paginação (até maxCards) seguindo next_page.
  /// Use `unique: 'prints'` para listar todas as edições.
  Future<List<Map<String, dynamic>>> searchAllCards(
    String query, {
    String unique = 'cards',
    int maxCards = 1000,
  }) async {
    final all = <Map<String, dynamic>>[];

    Response res = await _dio.get(
      '/cards/search',
      queryParameters: {
        'q': query,
        'unique': unique,
        'order': 'released',
        'dir': 'desc',
      },
    );

    while (true) {
      final data = res.data as Map<String, dynamic>;
      final page = (data['data'] as List).cast<Map<String, dynamic>>();
      all.addAll(page);

      if (all.length >= maxCards) break;

      final hasMore = data['has_more'] == true;
      final next = data['next_page'] as String?;

      if (!hasMore || next == null) break;

      // next_page é URL absoluta (https://api.scryfall.com/...)
      res = await _dio.getUri(Uri.parse(next));
    }

    return all;
  }

  /// Busca um printing específico por ID (útil para mostrar oracle_text no detalhe).
  Future<Map<String, dynamic>> getCardById(String printingId) async {
    final res = await _dio.get('/cards/$printingId');
    return (res.data as Map<String, dynamic>);
  }

  // --------------------
  // Helpers
  // --------------------

  static String? extractImageSmall(Map<String, dynamic> card) {
    final imageUris = card['image_uris'];
    if (imageUris is Map) return imageUris['small'] as String?;

    // Double-faced / layouts especiais
    final faces = card['card_faces'];
    if (faces is List && faces.isNotEmpty) {
      final f0 = faces.first;
      if (f0 is Map && f0['image_uris'] is Map) {
        return (f0['image_uris'] as Map)['small'] as String?;
      }
    }
    return null;
  }

  static String? extractImageNormal(Map<String, dynamic> card) {
    final imageUris = card['image_uris'];
    if (imageUris is Map) return imageUris['normal'] as String?;

    final faces = card['card_faces'];
    if (faces is List && faces.isNotEmpty) {
      final f0 = faces.first;
      if (f0 is Map && f0['image_uris'] is Map) {
        return (f0['image_uris'] as Map)['normal'] as String?;
      }
    }
    return null;
  }

  static String? extractImagePng(Map<String, dynamic> card) {
    final imageUris = card['image_uris'];
    if (imageUris is Map) return imageUris['png'] as String?;

    final faces = card['card_faces'];
    if (faces is List && faces.isNotEmpty) {
      final f0 = faces.first;
      if (f0 is Map && f0['image_uris'] is Map) {
        return (f0['image_uris'] as Map)['png'] as String?;
      }
    }
    return null;
  }

  /// Converte string "12.34" USD em centavos (1234). Retorna null se inválido.
  static int? usdStringToMinor(String? usd) {
    if (usd == null) return null;
    final v = double.tryParse(usd);
    if (v == null) return null;
    return (v * 100).round();
  }

  static String? legalitiesToJson(Map<String, dynamic> card) {
    final legalities = card['legalities'];
    if (legalities is Map) return jsonEncode(legalities);
    return null;
  }
}
