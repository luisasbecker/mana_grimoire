import 'dart:async';
import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:uuid/uuid.dart';

import '../../data/local/db/db_instance.dart';
import '../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../data/remote/scryfall/scryfall_client.dart';
import '../../data/remote/scryfall/scryfall_local_search_service.dart';
import '../../widgets/cached_card_thumbnail.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';

class AddCardToDeckScreen extends StatefulWidget {
  const AddCardToDeckScreen({
    super.key,
    required this.deckId,
  });

  final String deckId;

  @override
  State<AddCardToDeckScreen> createState() => _AddCardToDeckScreenState();
}

class _AddCardToDeckScreenState extends State<AddCardToDeckScreen> {
  final _client = ScryfallClient();
  final _cacheService = ScryfallCacheService();
  final _localSearch = ScryfallLocalSearchService();
  final _uuid = const Uuid();

  Timer? _debounce;
  bool _loading = false;
  String? _error;
  String _query = '';
  List<Map<String, dynamic>> _results = [];

  void _onQueryChanged(String v) {
    setState(() => _query = v);
    _debounce?.cancel();
    _debounce = Timer(const Duration(milliseconds: 350), _search);
  }

  Future<void> _search() async {
    final q = _query.trim();
    if (q.isEmpty) {
      setState(() {
        _results = [];
        _error = null;
      });
      return;
    }

    setState(() {
      _loading = true;
      _error = null;
    });
    try {
      final first = await _searchRemoteThenLocal(q);
      if (!mounted) return;
      setState(() => _results = first);

      await _cacheService.cacheScryfallCards(first);
    } catch (e) {
      if (mounted) setState(() => _error = e.toString());
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

  @override
  void dispose() {
    _debounce?.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final t = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: ManaInternalAppBar(title: t.addCardToDeckTitle),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 8, 16, 24),
        child: Column(
          children: [
            TextField(
              decoration: InputDecoration(
                hintText: t.addCardToDeckSearchHint,
                prefixIcon: const Icon(Icons.search_rounded),
              ),
              onChanged: _onQueryChanged,
            ),
            const SizedBox(height: 12),
            if (_loading) const LinearProgressIndicator(minHeight: 3),
            const SizedBox(height: 8),
            Expanded(
              child: _results.isEmpty
                  ? (_error != null
                      ? ManaEmptyState(
                          icon: Icons.cloud_off_rounded,
                          title: t.error,
                          subtitle: _error!,
                        )
                      : ManaEmptyState(
                          icon: Icons.travel_explore_rounded,
                          title: _query.trim().isEmpty
                              ? t.addCardToDeckEmptyTitle
                              : t.addCardToDeckNoResultsTitle,
                          subtitle: _query.trim().isEmpty
                              ? t.addCardToDeckEmptySubtitle
                              : t.addCardToDeckNoResultsSubtitle,
                        ))
                  : ListView.separated(
                      itemCount: _results.length,
                      separatorBuilder: (_, __) => const SizedBox(height: 10),
                      itemBuilder: (context, index) {
                        final card = _results[index];
                        final name = (card['name'] as String?) ?? 'Unknown';
                        final typeLine = (card['type_line'] as String?) ?? '';
                        final setCode = (card['set'] as String?) ?? '';
                        final collector =
                            (card['collector_number'] as String?) ?? '';
                        final img = ScryfallClient.extractImageSmall(card) ??
                            ScryfallClient.extractImageNormal(card) ??
                            ScryfallClient.extractImagePng(card);

                        return ManaSurfaceCard(
                          onTap: () async {
                            final printingId = card['id'] as String?;
                            final oracleId = card['oracle_id'] as String?;
                            if (printingId == null || oracleId == null) return;

                            await appDb.deckEntriesDao.addOrIncrement(
                              id: _uuid.v4(),
                              deckId: widget.deckId,
                              oracleId: oracleId,
                              preferredPrintingId: printingId,
                              quantityDelta: 1,
                              now: DateTime.now(),
                              section: 'main',
                            );

                            if (!context.mounted) return;
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(content: Text(t.addCardToDeckAdded)),
                            );
                          },
                          padding: const EdgeInsets.all(12),
                          child: Row(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              CachedCardThumbnail(
                                imageUrl: img,
                                label: name,
                                caption: '${setCode.toUpperCase()} #$collector',
                                width: 56,
                                height: 78,
                              ),
                              const SizedBox(width: 12),
                              Expanded(
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      name,
                                      style: Theme.of(context)
                                          .textTheme
                                          .titleSmall
                                          ?.copyWith(
                                              fontWeight: FontWeight.w700),
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
                                    const SizedBox(height: 6),
                                    Text(
                                      '${setCode.toUpperCase()} · #$collector',
                                      style: Theme.of(context)
                                          .textTheme
                                          .labelMedium
                                          ?.copyWith(
                                            color: scheme.primary,
                                            fontWeight: FontWeight.w600,
                                          ),
                                    ),
                                  ],
                                ),
                              ),
                              Icon(Icons.add_circle_outline_rounded,
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
  }
}
