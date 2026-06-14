import 'dart:io';

import 'package:dio/dio.dart';
import 'package:dio/io.dart';

bool isTrustedScryfallHost(String host) {
  final normalized = host.toLowerCase();
  return normalized == 'api.scryfall.com' ||
      normalized == 'cards.scryfall.io' ||
      normalized.endsWith('.scryfall.io');
}

HttpClient createScryfallHttpClient() {
  return HttpClient()
    ..connectionTimeout = const Duration(seconds: 15)
    ..badCertificateCallback = (_, host, __) => isTrustedScryfallHost(host);
}

Dio createScryfallDio() {
  final dio = Dio();
  dio.httpClientAdapter = IOHttpClientAdapter(
    createHttpClient: createScryfallHttpClient,
  );
  return dio;
}
