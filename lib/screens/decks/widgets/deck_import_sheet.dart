import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:uuid/uuid.dart';

import '../../../data/local/db/db_instance.dart';
import '../../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../../data/remote/scryfall/scryfall_client.dart';
import '../../../data/remote/scryfall/scryfall_local_search_service.dart';
import 'deck_import_parser.dart';

class DeckImportSheet extends StatefulWidget {
  const DeckImportSheet({
    super.key,
    required this.deckId,
  });

  final String deckId;

  @override
  State<DeckImportSheet> createState() => _DeckImportSheetState();
}

class _DeckImportSheetState extends State<DeckImportSheet> {
  final _client = ScryfallClient();
  final _cacheService = ScryfallCacheService();
  final _localSearch = ScryfallLocalSearchService();
  final _uuid = const Uuid();
  final _controller = TextEditingController();

  bool _importing = false;
  int _processed = 0;
  int _total = 0;

  int _importedCards = 0;
  int _notFound = 0;
  final List<String> _failedLines = [];

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  Future<void> _import() async {
    if (_importing) return;
    final t = AppLocalizations.of(context)!;

    final parsed = parseDeckImportLines(_controller.text).toList();
    if (parsed.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text(t.deckImportEmptyInput)),
      );
      return;
    }

    setState(() {
      _importing = true;
      _processed = 0;
      _total = parsed.length;
      _importedCards = 0;
      _notFound = 0;
      _failedLines.clear();
    });

    for (final p in parsed) {
      if (!mounted) return;
      setState(() => _processed++);

      if (!p.isValid) {
        _failedLines.add(p.rawLine);
        continue;
      }

      try {
        final results = await _searchRemoteThenLocal(p.name);
        if (results.isEmpty) {
          _notFound += 1;
          _failedLines.add(p.rawLine);
          continue;
        }

        final first = results.first;
        final printingId = first['id'] as String?;
        final oracleId = first['oracle_id'] as String?;
        if (printingId == null ||
            printingId.isEmpty ||
            oracleId == null ||
            oracleId.isEmpty) {
          _notFound += 1;
          _failedLines.add(p.rawLine);
          continue;
        }

        // Cache local do printing (para nome/imagem/set aparecer imediatamente).
        final now = DateTime.now();
        await _cacheService.cacheSingleScryfallCard(first);

        await appDb.deckEntriesDao.addOrIncrement(
          id: _uuid.v4(),
          deckId: widget.deckId,
          oracleId: oracleId,
          preferredPrintingId: printingId,
          quantityDelta: p.quantity,
          now: now,
          section: 'main',
        );
        _importedCards += p.quantity;
      } catch (_) {
        _failedLines.add(p.rawLine);
      }
    }

    if (!mounted) return;
    setState(() => _importing = false);

    final msg = t.deckImportResultSummary(_importedCards, _notFound);
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(msg)));
  }

  Future<List<Map<String, dynamic>>> _searchRemoteThenLocal(String q) async {
    try {
      return await _client.searchCards(q);
    } catch (_) {
      return _localSearch.searchCards(q, limit: 1);
    }
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    final scheme = Theme.of(context).colorScheme;

    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.82,
      minChildSize: 0.45,
      maxChildSize: 0.95,
      builder: (context, scrollController) {
        return SafeArea(
          top: false,
          child: ListView(
            controller: scrollController,
            padding: EdgeInsets.only(
              left: 16,
              right: 16,
              top: 10,
              bottom: 16 + MediaQuery.of(context).viewInsets.bottom,
            ),
            children: [
              Text(
                t.deckImportTitle,
                textAlign: TextAlign.center,
                style: Theme.of(context).textTheme.titleMedium?.copyWith(
                      fontWeight: FontWeight.w900,
                    ),
              ),
              const SizedBox(height: 10),
              TextField(
                controller: _controller,
                minLines: 6,
                maxLines: 10,
                decoration: InputDecoration(
                  hintText: t.deckImportHint,
                ),
                enabled: !_importing,
              ),
              const SizedBox(height: 10),
              if (_importing)
                Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    LinearProgressIndicator(
                      minHeight: 3,
                      value: _total == 0
                          ? null
                          : (_processed / _total).clamp(0, 1),
                    ),
                    const SizedBox(height: 6),
                    Text(
                      t.deckImportProgress(_processed, _total),
                      style: Theme.of(context).textTheme.bodySmall?.copyWith(
                            color: scheme.onSurfaceVariant,
                          ),
                      textAlign: TextAlign.center,
                    ),
                  ],
                ),
              if (_failedLines.isNotEmpty) ...[
                const SizedBox(height: 10),
                Text(
                  t.deckImportFailedLinesTitle,
                  style: Theme.of(context).textTheme.titleSmall?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                const SizedBox(height: 6),
                Container(
                  padding: const EdgeInsets.all(12),
                  decoration: BoxDecoration(
                    color: scheme.surfaceContainerHigh.withValues(alpha: 0.7),
                    borderRadius: BorderRadius.circular(14),
                    border: Border.all(
                        color: scheme.outlineVariant.withValues(alpha: 0.6)),
                  ),
                  child: Text(
                    _failedLines.take(12).join('\n'),
                    style: Theme.of(context).textTheme.bodySmall?.copyWith(
                          color: scheme.onSurfaceVariant,
                        ),
                  ),
                ),
              ],
              const SizedBox(height: 12),
              LayoutBuilder(
                builder: (context, constraints) {
                  final cancelButton = OutlinedButton(
                    onPressed:
                        _importing ? null : () => Navigator.of(context).pop(),
                    child: Text(t.cancel),
                  );
                  final importButton = FilledButton(
                    onPressed: _importing ? null : _import,
                    child: _importing
                        ? const SizedBox(
                            width: 18,
                            height: 18,
                            child: CircularProgressIndicator(strokeWidth: 2),
                          )
                        : Text(t.deckImportCta),
                  );
                  if (constraints.maxWidth < 340) {
                    return Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        cancelButton,
                        const SizedBox(height: 8),
                        importButton,
                      ],
                    );
                  }
                  return Row(
                    children: [
                      Expanded(child: cancelButton),
                      const SizedBox(width: 12),
                      Expanded(child: importButton),
                    ],
                  );
                },
              ),
            ],
          ),
        );
      },
    );
  }
}
