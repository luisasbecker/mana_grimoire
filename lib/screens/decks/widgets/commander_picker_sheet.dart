import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import '../../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../../data/remote/scryfall/scryfall_client.dart';
import '../../../data/remote/scryfall/scryfall_local_search_service.dart';
import '../../../widgets/cached_card_thumbnail.dart';
import '../../../widgets/mana_empty_state.dart';
import '../../../widgets/mana_surface_card.dart';

class CommanderPickResult {
  const CommanderPickResult({
    required this.oracleId,
    required this.printingId,
  });

  final String oracleId;
  final String printingId;
}

class CommanderPickerSheet extends StatefulWidget {
  const CommanderPickerSheet({super.key});

  @override
  State<CommanderPickerSheet> createState() => _CommanderPickerSheetState();
}

class _CommanderPickerSheetState extends State<CommanderPickerSheet> {
  final _client = ScryfallClient();
  final _cacheService = ScryfallCacheService();
  final _localSearch = ScryfallLocalSearchService();
  bool _loading = false;
  String _query = '';
  List<Map<String, dynamic>> _results = [];
  String? _error;

  Future<void> _search(String v) async {
    setState(() => _query = v);
    final q = v.trim();
    if (q.isEmpty) {
      setState(() {
        _results = [];
        _error = null;
      });
      return;
    }
    setState(() => _loading = true);
    try {
      final res = await _searchRemoteThenLocal(q);
      if (!mounted) return;
      setState(() {
        _results = res;
        _error = null;
      });
    } catch (error) {
      if (!mounted) return;
      setState(() {
        _results = [];
        _error = error.toString();
      });
    } finally {
      if (mounted) setState(() => _loading = false);
    }
  }

  Future<List<Map<String, dynamic>>> _searchRemoteThenLocal(String q) async {
    try {
      final res = await _client.searchCards(q);
      return res.take(30).toList();
    } catch (error) {
      final local = await _localSearch.searchCards(q, limit: 30);
      if (local.isNotEmpty) return local;
      throw scryfallLocalFallbackErrorMessage(error);
    }
  }

  Future<void> _pick(Map<String, dynamic> card) async {
    final printingId = card['id'] as String?;
    final oracleId = card['oracle_id'] as String?;
    if (printingId == null || oracleId == null) return;

    // Cache printing so it shows in Commander section immediately.
    await _cacheService.cacheSingleScryfallCard(card);

    if (!mounted) return;
    Navigator.of(context).pop(CommanderPickResult(
      oracleId: oracleId,
      printingId: printingId,
    ));
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    final scheme = Theme.of(context).colorScheme;

    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.85,
      minChildSize: 0.5,
      maxChildSize: 0.95,
      builder: (context, scrollController) {
        return SafeArea(
          top: false,
          child: Padding(
            padding: EdgeInsets.only(
              left: 16,
              right: 16,
              top: 10,
              bottom: 16 + MediaQuery.of(context).viewInsets.bottom,
            ),
            child: Column(
              children: [
                Text(
                  t.pickCommanderTitle,
                  style: Theme.of(context).textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                const SizedBox(height: 10),
                TextField(
                  decoration: InputDecoration(
                    hintText: t.pickCommanderHint,
                    prefixIcon: const Icon(Icons.search_rounded),
                  ),
                  onChanged: _search,
                ),
                const SizedBox(height: 10),
                if (_loading) const LinearProgressIndicator(minHeight: 3),
                const SizedBox(height: 8),
                Expanded(
                  child: _results.isEmpty
                      ? ManaEmptyState(
                          icon: Icons.travel_explore_rounded,
                          title: _query.trim().isEmpty
                              ? t.pickCommanderEmptyTitle
                              : t.pickCommanderNoResultsTitle,
                          subtitle: _error ??
                              (_query.trim().isEmpty
                                  ? t.pickCommanderEmptySubtitle
                                  : t.pickCommanderNoResultsSubtitle),
                        )
                      : ListView.separated(
                          controller: scrollController,
                          itemCount: _results.length,
                          separatorBuilder: (_, __) =>
                              const SizedBox(height: 10),
                          itemBuilder: (context, i) {
                            final card = _results[i];
                            final name = (card['name'] as String?) ?? 'Unknown';
                            final typeLine =
                                (card['type_line'] as String?) ?? '';
                            final img =
                                ScryfallClient.extractImageSmall(card) ??
                                    ScryfallClient.extractImageNormal(card) ??
                                    ScryfallClient.extractImagePng(card);
                            return ManaSurfaceCard(
                              onTap: () => _pick(card),
                              padding: const EdgeInsets.all(12),
                              child: Row(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  CachedCardThumbnail(
                                    imageUrl: img,
                                    label: name,
                                    width: 52,
                                    height: 72,
                                  ),
                                  const SizedBox(width: 12),
                                  Expanded(
                                    child: Column(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          name,
                                          style: Theme.of(context)
                                              .textTheme
                                              .titleSmall
                                              ?.copyWith(
                                                fontWeight: FontWeight.w800,
                                              ),
                                        ),
                                        const SizedBox(height: 4),
                                        Text(
                                          typeLine,
                                          maxLines: 2,
                                          overflow: TextOverflow.ellipsis,
                                          style: Theme.of(context)
                                              .textTheme
                                              .bodySmall
                                              ?.copyWith(
                                                color: scheme.onSurfaceVariant,
                                              ),
                                        ),
                                      ],
                                    ),
                                  ),
                                  Icon(Icons.chevron_right_rounded,
                                      color: scheme.onSurfaceVariant),
                                ],
                              ),
                            );
                          },
                        ),
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
