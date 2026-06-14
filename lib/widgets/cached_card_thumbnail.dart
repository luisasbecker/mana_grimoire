import 'dart:io';
import 'dart:typed_data';

import 'package:flutter/material.dart';

import '../data/remote/scryfall/scryfall_tls.dart';

/// Miniatura de carta MTG (artwork pequeno) usada em listas.
class CachedCardThumbnail extends StatelessWidget {
  const CachedCardThumbnail({
    super.key,
    required this.imageUrl,
    this.label,
    this.caption,
    this.width = 48,
    this.height = 68,
    this.showFrame = true,
  });

  final String? imageUrl;
  final String? label;
  final String? caption;
  final double width;
  final double height;
  final bool showFrame;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final url = imageUrl;
    final inner = url == null || url.isEmpty
        ? _CardThumbnailPlaceholder(
            width: width,
            height: height,
            label: label,
            caption: caption,
          )
        : _CardThumbnailImage(
            url: url,
            width: width,
            height: height,
            label: label,
            caption: caption,
          );

    if (!showFrame) return inner;

    return Container(
      padding: const EdgeInsets.all(2),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        border: Border.all(
          color: scheme.outlineVariant.withValues(alpha: 0.45),
        ),
        boxShadow: [
          BoxShadow(
            color: scheme.primary.withValues(alpha: 0.08),
            blurRadius: 8,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: inner,
    );
  }
}

class _CardThumbnailImage extends StatefulWidget {
  const _CardThumbnailImage({
    required this.url,
    required this.width,
    required this.height,
    this.label,
    this.caption,
  });

  final String url;
  final double width;
  final double height;
  final String? label;
  final String? caption;

  @override
  State<_CardThumbnailImage> createState() => _CardThumbnailImageState();
}

class _CardThumbnailImageState extends State<_CardThumbnailImage> {
  static final _memoryCache = <String, Uint8List>{};
  static const _maxCachedImages = 180;
  static const _maxImageBytes = 6 * 1024 * 1024;

  late Future<Uint8List> _future;

  @override
  void initState() {
    super.initState();
    _future = _loadImage(widget.url);
  }

  @override
  void didUpdateWidget(covariant _CardThumbnailImage oldWidget) {
    super.didUpdateWidget(oldWidget);
    if (oldWidget.url != widget.url) {
      _future = _loadImage(widget.url);
    }
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<Uint8List>(
      future: _future,
      builder: (context, snapshot) {
        final bytes = snapshot.data;
        if (bytes == null) {
          return _CardThumbnailPlaceholder(
            width: widget.width,
            height: widget.height,
            label: widget.label,
            caption: widget.caption,
            unsupported: snapshot.hasError,
          );
        }
        return ClipRRect(
          borderRadius: BorderRadius.circular(8),
          child: Image.memory(
            bytes,
            width: widget.width,
            height: widget.height,
            fit: BoxFit.cover,
            gaplessPlayback: true,
            filterQuality: FilterQuality.medium,
            errorBuilder: (_, __, ___) => _CardThumbnailPlaceholder(
              width: widget.width,
              height: widget.height,
              label: widget.label,
              caption: widget.caption,
              unsupported: true,
            ),
          ),
        );
      },
    );
  }

  static Future<Uint8List> _loadImage(String rawUrl) async {
    final cached = _memoryCache.remove(rawUrl);
    if (cached != null) {
      _memoryCache[rawUrl] = cached;
      return cached;
    }

    final uri = Uri.parse(rawUrl);
    final bytes = await _fetchImageBytes(
      uri,
      allowScryfallCertificateFallback: isTrustedScryfallHost(uri.host),
    );
    _remember(rawUrl, bytes);
    return bytes;
  }

  static Future<Uint8List> _fetchImageBytes(
    Uri uri, {
    required bool allowScryfallCertificateFallback,
  }) async {
    final client = allowScryfallCertificateFallback
        ? createScryfallHttpClient()
        : (HttpClient()..connectionTimeout = const Duration(seconds: 15));
    try {
      final request = await client.getUrl(uri);
      request.headers.set(
        HttpHeaders.userAgentHeader,
        'ManaGrimoire/0.1 (Flutter; card thumbnails)',
      );
      final response = await request.close();
      if (response.statusCode < 200 || response.statusCode >= 300) {
        throw HttpException(
          'Could not load card image (${response.statusCode}).',
          uri: uri,
        );
      }

      final bytes = BytesBuilder(copy: false);
      await for (final chunk in response) {
        bytes.add(chunk);
        if (bytes.length > _maxImageBytes) {
          throw HttpException('Card image is too large.', uri: uri);
        }
      }
      return bytes.takeBytes();
    } finally {
      client.close(force: true);
    }
  }

  static void _remember(String url, Uint8List bytes) {
    _memoryCache[url] = bytes;
    while (_memoryCache.length > _maxCachedImages) {
      _memoryCache.remove(_memoryCache.keys.first);
    }
  }
}

class _CardThumbnailPlaceholder extends StatelessWidget {
  const _CardThumbnailPlaceholder({
    required this.width,
    required this.height,
    this.label,
    this.caption,
    this.unsupported = false,
  });

  final double width;
  final double height;
  final String? label;
  final String? caption;
  final bool unsupported;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final title = label?.trim();
    final subtitle = caption?.trim();
    final color = _fallbackColor(title);
    final compact = width < 44 || height < 62;

    return SizedBox(
      width: width,
      height: height,
      child: ClipRRect(
        borderRadius: BorderRadius.circular(8),
        child: DecoratedBox(
          decoration: BoxDecoration(
            color: scheme.surfaceContainerHighest.withValues(alpha: 0.72),
            border: Border.all(
              color: unsupported
                  ? scheme.primary.withValues(alpha: 0.36)
                  : scheme.outlineVariant.withValues(alpha: 0.45),
            ),
          ),
          child: title == null || title.isEmpty
              ? Icon(
                  unsupported
                      ? Icons.image_not_supported_outlined
                      : Icons.style,
                  color: scheme.onSurfaceVariant.withValues(alpha: 0.72),
                  size: (width * 0.58).clamp(16, 32).toDouble(),
                )
              : compact
                  ? DecoratedBox(
                      decoration: BoxDecoration(color: color),
                      child: Center(
                        child: Text(
                          _initialsFor(title),
                          maxLines: 1,
                          overflow: TextOverflow.clip,
                          style: TextStyle(
                            color: Colors.white,
                            fontSize:
                                (width * 0.28).clamp(9.0, 13.0).toDouble(),
                            fontWeight: FontWeight.w900,
                            height: 1,
                          ),
                        ),
                      ),
                    )
                  : Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        Expanded(
                          flex: 4,
                          child: DecoratedBox(
                            decoration: BoxDecoration(color: color),
                            child: Center(
                              child: Icon(
                                Icons.auto_awesome_rounded,
                                color: Colors.white.withValues(alpha: 0.88),
                                size: (width * 0.32).clamp(14, 24).toDouble(),
                              ),
                            ),
                          ),
                        ),
                        Expanded(
                          flex: 5,
                          child: Padding(
                            padding: const EdgeInsets.fromLTRB(4, 4, 4, 3),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              crossAxisAlignment: CrossAxisAlignment.stretch,
                              children: [
                                Text(
                                  title,
                                  maxLines: subtitle == null || subtitle.isEmpty
                                      ? 3
                                      : 2,
                                  overflow: TextOverflow.ellipsis,
                                  textAlign: TextAlign.center,
                                  style: TextStyle(
                                    color: scheme.onSurface,
                                    fontSize: (width * 0.145)
                                        .clamp(7.0, 18.0)
                                        .toDouble(),
                                    fontWeight: FontWeight.w800,
                                    height: 1.05,
                                  ),
                                ),
                                if (subtitle != null &&
                                    subtitle.isNotEmpty) ...[
                                  const SizedBox(height: 2),
                                  Text(
                                    subtitle,
                                    maxLines: 1,
                                    overflow: TextOverflow.ellipsis,
                                    textAlign: TextAlign.center,
                                    style: TextStyle(
                                      color: scheme.onSurfaceVariant,
                                      fontSize: (width * 0.12)
                                          .clamp(6.5, 13.0)
                                          .toDouble(),
                                      fontWeight: FontWeight.w700,
                                      height: 1,
                                    ),
                                  ),
                                ],
                              ],
                            ),
                          ),
                        ),
                      ],
                    ),
        ),
      ),
    );
  }

  Color _fallbackColor(String? seed) {
    const palette = [
      Color(0xFF4267AC),
      Color(0xFF5F7F3A),
      Color(0xFFA34D3F),
      Color(0xFF7A5AA6),
      Color(0xFF2D7A78),
      Color(0xFF8C6B2F),
    ];
    final text = seed ?? '';
    final hash = text.codeUnits.fold<int>(0, (sum, unit) => sum + unit);
    return palette[hash % palette.length];
  }

  String _initialsFor(String value) {
    final words = value
        .split(RegExp(r'\s+'))
        .where((word) => word.trim().isNotEmpty)
        .take(2)
        .toList();
    if (words.isEmpty) return '?';
    return words.map((word) => word.characters.first.toUpperCase()).join();
  }
}
