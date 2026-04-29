import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';

/// Miniatura de carta MTG (artwork pequeno) usada em listas.
class CachedCardThumbnail extends StatelessWidget {
  const CachedCardThumbnail({
    super.key,
    required this.imageUrl,
    this.width = 48,
    this.height = 68,
    this.showFrame = true,
  });

  final String? imageUrl;
  final double width;
  final double height;
  final bool showFrame;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final url = imageUrl;
    final inner = url == null || url.isEmpty
        ? SizedBox(width: width, height: height)
        : ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: CachedNetworkImage(
              imageUrl: url,
              width: width,
              height: height,
              fit: BoxFit.cover,
              errorWidget: (_, __, ___) =>
                  const Icon(Icons.image_not_supported, size: 32),
            ),
          );

    if (!showFrame) return inner;

    return Container(
      padding: const EdgeInsets.all(2),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        border: Border.all(
          color: scheme.outlineVariant.withOpacity(0.45),
        ),
        boxShadow: [
          BoxShadow(
            color: scheme.primary.withOpacity(0.08),
            blurRadius: 8,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: inner,
    );
  }
}
