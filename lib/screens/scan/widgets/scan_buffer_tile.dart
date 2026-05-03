import 'package:flutter/material.dart';

import '../../../data/scan/scan_models.dart';
import '../../../widgets/cached_card_thumbnail.dart';
import '../../../widgets/mana_chip.dart';
import '../../../widgets/mana_surface_card.dart';

class ScanBufferTile extends StatelessWidget {
  const ScanBufferTile({
    super.key,
    required this.entry,
    required this.onTap,
    required this.onRemove,
    required this.onIncrement,
    required this.onDecrement,
  });

  final BufferedScanEntry entry;
  final VoidCallback onTap;
  final VoidCallback onRemove;
  final VoidCallback onIncrement;
  final VoidCallback onDecrement;

  @override
  Widget build(BuildContext context) {
    final card = entry.card;
    return LayoutBuilder(
      builder: (context, constraints) {
        final dense =
            constraints.hasBoundedHeight && constraints.maxHeight < 150;
        return ManaSurfaceCard(
          onTap: onTap,
          padding: EdgeInsets.all(dense ? 8 : 10),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              CachedCardThumbnail(
                imageUrl: card.imageUrlSmall,
                width: dense ? 38 : 48,
                height: dense ? 54 : 68,
              ),
              const SizedBox(width: 10),
              Expanded(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      card.name,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.titleSmall?.copyWith(
                            fontWeight: FontWeight.w800,
                          ),
                    ),
                    const SizedBox(height: 4),
                    if (dense)
                      Text(
                        _compactMetadata,
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: Theme.of(context).textTheme.labelSmall?.copyWith(
                              color: Theme.of(context)
                                  .colorScheme
                                  .onSurfaceVariant,
                              fontWeight: FontWeight.w600,
                            ),
                      )
                    else ...[
                      Text(
                        card.editionLabel,
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                        style: Theme.of(context).textTheme.labelSmall?.copyWith(
                              color: Theme.of(context)
                                  .colorScheme
                                  .onSurfaceVariant,
                              fontWeight: FontWeight.w600,
                            ),
                      ),
                      const SizedBox(height: 6),
                      Wrap(
                        spacing: 5,
                        runSpacing: 5,
                        children: [
                          ManaChip(label: entry.condition, compact: true),
                          ManaChip(label: entry.language, compact: true),
                          if (entry.isFoil)
                            const ManaChip(
                              label: 'FOIL',
                              tone: ManaChipTone.gold,
                              compact: true,
                            ),
                        ],
                      ),
                    ],
                  ],
                ),
              ),
              const SizedBox(width: 8),
              SizedBox(
                width: dense ? 64 : 72,
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    FittedBox(
                      fit: BoxFit.scaleDown,
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          _BufferQuantityButton(
                            icon: Icons.remove_rounded,
                            tooltip: 'Diminuir',
                            dense: dense,
                            onPressed: onDecrement,
                          ),
                          SizedBox(
                            width: dense ? 20 : 24,
                            child: Text(
                              '${entry.quantity}',
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .titleSmall
                                  ?.copyWith(
                                    fontWeight: FontWeight.w900,
                                  ),
                            ),
                          ),
                          _BufferQuantityButton(
                            icon: Icons.add_rounded,
                            tooltip: 'Aumentar',
                            dense: dense,
                            onPressed: onIncrement,
                          ),
                        ],
                      ),
                    ),
                    SizedBox(height: dense ? 0 : 2),
                    IconButton(
                      tooltip: 'Remover',
                      visualDensity: VisualDensity.compact,
                      constraints: BoxConstraints.tightFor(
                        width: dense ? 24 : 32,
                        height: dense ? 24 : 32,
                      ),
                      padding: EdgeInsets.zero,
                      onPressed: onRemove,
                      icon: Icon(Icons.close_rounded, size: dense ? 15 : 18),
                    ),
                  ],
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  String get _compactMetadata {
    final foil = entry.isFoil ? ' · FOIL' : '';
    return '${entry.card.editionLabel} · ${entry.condition} · ${entry.language}$foil';
  }
}

class _BufferQuantityButton extends StatelessWidget {
  const _BufferQuantityButton({
    required this.icon,
    required this.tooltip,
    required this.onPressed,
    required this.dense,
  });

  final IconData icon;
  final String tooltip;
  final VoidCallback onPressed;
  final bool dense;

  @override
  Widget build(BuildContext context) {
    return IconButton(
      tooltip: tooltip,
      visualDensity: VisualDensity.compact,
      constraints: BoxConstraints.tightFor(
        width: dense ? 20 : 24,
        height: dense ? 22 : 28,
      ),
      padding: EdgeInsets.zero,
      onPressed: onPressed,
      icon: Icon(icon, size: dense ? 14 : 16),
    );
  }
}
