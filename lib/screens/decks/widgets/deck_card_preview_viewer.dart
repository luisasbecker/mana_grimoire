import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../../data/local/db/daos/deck_entries_dao.dart';
import '../../../widgets/cached_card_thumbnail.dart';
import 'deck_card_detail_sheet.dart';

class DeckCardPreviewViewer extends StatefulWidget {
  const DeckCardPreviewViewer({
    super.key,
    required this.deckId,
    required this.rows,
    required this.initialIndex,
  });

  final String deckId;
  final List<DeckEntryView> rows;
  final int initialIndex;

  @override
  State<DeckCardPreviewViewer> createState() => _DeckCardPreviewViewerState();
}

class _DeckCardPreviewViewerState extends State<DeckCardPreviewViewer> {
  late final PageController _controller;
  late int _index;

  @override
  void initState() {
    super.initState();
    final safeIndex = widget.initialIndex.clamp(0, widget.rows.length - 1);
    _index = safeIndex;
    _controller = PageController(initialPage: safeIndex);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  DeckEntryView? get _currentRow {
    if (widget.rows.isEmpty) return null;
    return widget.rows[_index.clamp(0, widget.rows.length - 1)];
  }

  String? _bestImageUrl(DeckEntryView row) {
    final p = row.printing;
    return p?.imagePng ?? p?.imageNormal ?? p?.imageSmall;
  }

  Future<void> _openDetails() async {
    final row = _currentRow;
    if (row == null) return;
    await showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => DeckCardDetailSheet(
        deckId: widget.deckId,
        row: row,
      ),
    );
    // Mantém o viewer aberto; o sheet já contém toda a lógica de edição.
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    final scheme = Theme.of(context).colorScheme;
    final rows = widget.rows;

    return Scaffold(
      backgroundColor: Colors.black,
      body: SafeArea(
        child: Stack(
          children: [
            if (rows.isEmpty)
              Center(
                child: Text(
                  t.deckExportEmpty,
                  style: Theme.of(context)
                      .textTheme
                      .bodyMedium
                      ?.copyWith(color: Colors.white70),
                ),
              )
            else
              PageView.builder(
                controller: _controller,
                itemCount: rows.length,
                onPageChanged: (i) => setState(() => _index = i),
                itemBuilder: (context, i) {
                  final row = rows[i];
                  final url = _bestImageUrl(row);
                  final printing = row.printing;
                  final name = printing?.name ?? row.entry.oracleId;
                  final setLine = printing == null
                      ? null
                      : '${printing.setCode.toUpperCase()} #${printing.collectorNumber}';
                  return Center(
                    child: Padding(
                      padding: const EdgeInsets.fromLTRB(18, 28, 18, 96),
                      child: AspectRatio(
                        aspectRatio: 63 / 88,
                        child: ClipRRect(
                          borderRadius: BorderRadius.circular(14),
                          child: DecoratedBox(
                            decoration: BoxDecoration(
                              color: const Color(0xFF101214),
                              border: Border.all(
                                color: Colors.white.withValues(alpha: 0.12),
                              ),
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.black.withValues(alpha: 0.65),
                                  blurRadius: 30,
                                  offset: const Offset(0, 18),
                                ),
                              ],
                            ),
                            child: LayoutBuilder(
                              builder: (context, constraints) {
                                return CachedCardThumbnail(
                                  imageUrl: url,
                                  label: name,
                                  caption: setLine,
                                  width: constraints.maxWidth,
                                  height: constraints.maxHeight,
                                  showFrame: false,
                                );
                              },
                            ),
                          ),
                        ),
                      ),
                    ),
                  );
                },
              ),
            Positioned(
              top: 10,
              right: 10,
              child: IconButton.filledTonal(
                onPressed: () => Navigator.of(context).pop(),
                icon: const Icon(Icons.close_rounded),
              ),
            ),
            Align(
              alignment: Alignment.bottomCenter,
              child: SafeArea(
                top: false,
                child: Padding(
                  padding: const EdgeInsets.fromLTRB(14, 0, 14, 12),
                  child: _CollapsedActionPanel(
                    scheme: scheme,
                    row: _currentRow,
                    hintText: t.deckPreviewHint,
                    onTap: _openDetails,
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _CollapsedActionPanel extends StatelessWidget {
  const _CollapsedActionPanel({
    required this.scheme,
    required this.row,
    required this.hintText,
    required this.onTap,
  });

  final ColorScheme scheme;
  final DeckEntryView? row;
  final String hintText;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final r = row;
    final name = r?.printing?.name ?? r?.entry.oracleId ?? '';
    final qty = r?.entry.quantity ?? 0;

    return Material(
      color: scheme.surfaceContainerHigh.withValues(alpha: 0.82),
      borderRadius: BorderRadius.circular(18),
      child: InkWell(
        onTap: r == null ? null : onTap,
        borderRadius: BorderRadius.circular(18),
        child: Padding(
          padding: const EdgeInsets.fromLTRB(14, 10, 14, 12),
          child: Row(
            children: [
              Container(
                width: 44,
                height: 4,
                decoration: BoxDecoration(
                  color: scheme.onSurface.withValues(alpha: 0.22),
                  borderRadius: BorderRadius.circular(99),
                ),
              ),
              const SizedBox(width: 12),
              Expanded(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      name,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.titleSmall?.copyWith(
                            fontWeight: FontWeight.w900,
                          ),
                    ),
                    const SizedBox(height: 2),
                    Text(
                      hintText,
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                      style: Theme.of(context).textTheme.labelMedium?.copyWith(
                            color: scheme.onSurfaceVariant,
                            fontWeight: FontWeight.w600,
                          ),
                    ),
                  ],
                ),
              ),
              const SizedBox(width: 12),
              Text(
                '×$qty',
                style: Theme.of(context).textTheme.titleMedium?.copyWith(
                      fontWeight: FontWeight.w900,
                    ),
              ),
              const SizedBox(width: 2),
              Icon(
                Icons.keyboard_arrow_up_rounded,
                color: scheme.onSurfaceVariant,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
