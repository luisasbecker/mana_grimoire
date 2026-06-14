import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';

import '../../data/remote/scryfall/scryfall_client.dart';
import '../../data/remote/scryfall/scryfall_local_search_service.dart';
import '../../widgets/cached_card_thumbnail.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_surface_card.dart';

/// Rota inválida (extra em falta ou formato errado).
class SelectPrintingInvalidScreen extends StatelessWidget {
  const SelectPrintingInvalidScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    return Scaffold(
      appBar: ManaInternalAppBar(title: t.selectPrintingTitle),
      body: Center(
        child: Padding(
          padding: EdgeInsets.all(24),
          child: Text(t.selectPrintingInvalidNavigation),
        ),
      ),
    );
  }
}

class SelectPrintingScreen extends StatefulWidget {
  const SelectPrintingScreen({
    super.key,
    required this.oracleId,
    required this.selectedPrintingId,
  });

  final String oracleId;
  final String selectedPrintingId;

  @override
  State<SelectPrintingScreen> createState() => _SelectPrintingScreenState();
}

class _SelectPrintingScreenState extends State<SelectPrintingScreen> {
  final _client = ScryfallClient();
  final _localSearch = ScryfallLocalSearchService();
  final _scrollController = ScrollController();

  static const int _maxTotalPrintings = 600;

  bool _loadingInitial = true;
  bool _loadingMore = false;
  String? _error;
  final List<Map<String, dynamic>> _printings = [];
  String? _nextPageUrl;
  bool _hasMore = false;

  @override
  void initState() {
    super.initState();
    _scrollController.addListener(_onScroll);
    _loadFirstPage();
  }

  @override
  void dispose() {
    _scrollController.removeListener(_onScroll);
    _scrollController.dispose();
    super.dispose();
  }

  void _onScroll() {
    if (!_hasMore || _loadingMore || _loadingInitial || _error != null) return;
    if (_printings.length >= _maxTotalPrintings) return;
    final pos = _scrollController.position;
    if (pos.pixels >= pos.maxScrollExtent - 400) {
      _loadMore();
    }
  }

  Future<void> _loadFirstPage() async {
    setState(() {
      _loadingInitial = true;
      _error = null;
      _printings.clear();
      _nextPageUrl = null;
      _hasMore = false;
    });

    try {
      final page = await _client.searchCardsFirstPage(
        'oracleid:${widget.oracleId}',
        unique: 'prints',
      );
      if (!mounted) return;
      setState(() {
        _printings.addAll(page.data);
        _nextPageUrl = page.nextPageUrl;
        _hasMore = page.hasMore && _nextPageUrl != null;
      });
    } catch (error) {
      final localPage = await _localSearch.searchCardsFirstPage(
        'oracleid:${widget.oracleId}',
        unique: 'prints',
        limit: _maxTotalPrintings,
      );
      if (!mounted) return;
      if (localPage.data.isNotEmpty) {
        setState(() {
          _printings.addAll(localPage.data);
          _nextPageUrl = null;
          _hasMore = false;
        });
      } else {
        setState(() => _error = scryfallLocalFallbackErrorMessage(error));
      }
    } finally {
      if (mounted) setState(() => _loadingInitial = false);
    }
  }

  Future<void> _loadMore() async {
    final url = _nextPageUrl;
    if (url == null || !_hasMore || _loadingMore || _loadingInitial) return;
    if (_printings.length >= _maxTotalPrintings) {
      setState(() => _hasMore = false);
      return;
    }

    setState(() => _loadingMore = true);
    try {
      final page = await _client.fetchSearchNextPage(url);
      setState(() {
        final remaining = _maxTotalPrintings - _printings.length;
        final toAdd = page.data.take(remaining).toList();
        _printings.addAll(toAdd);
        _nextPageUrl = page.nextPageUrl;
        _hasMore = page.hasMore &&
            _nextPageUrl != null &&
            _printings.length < _maxTotalPrintings;
      });
    } catch (e) {
      setState(() => _error = e.toString());
    } finally {
      setState(() => _loadingMore = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    return Scaffold(
      appBar: ManaInternalAppBar(title: t.selectPrintingTitle),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: _loadingInitial
            ? const Center(child: CircularProgressIndicator())
            : _error != null
                ? Center(
                    child: Padding(
                      padding: const EdgeInsets.all(16),
                      child: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Text('${t.error}: $_error'),
                          const SizedBox(height: 10),
                          OutlinedButton(
                            onPressed: _loadFirstPage,
                            child: Text(t.retry),
                          ),
                        ],
                      ),
                    ),
                  )
                : _printings.isEmpty
                    ? Center(child: Text(t.selectPrintingEmpty))
                    : Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          if (_printings.length >= _maxTotalPrintings)
                            Padding(
                              padding: const EdgeInsets.only(bottom: 8),
                              child: Text(
                                t.selectPrintingLimitedHint,
                                style: const TextStyle(fontSize: 12),
                              ),
                            ),
                          Expanded(
                            child: ListView.separated(
                              controller: _scrollController,
                              itemCount: _printings.length +
                                  ((_hasMore || _loadingMore) ? 1 : 0),
                              separatorBuilder: (_, __) =>
                                  const SizedBox(height: 8),
                              itemBuilder: (context, index) {
                                if (index >= _printings.length) {
                                  if (_loadingMore) {
                                    return const Padding(
                                      padding:
                                          EdgeInsets.symmetric(vertical: 16),
                                      child: Center(
                                        child: CircularProgressIndicator(),
                                      ),
                                    );
                                  }
                                  return Padding(
                                    padding:
                                        const EdgeInsets.symmetric(vertical: 8),
                                    child: OutlinedButton(
                                      onPressed: _loadMore,
                                      child: Text(t.selectPrintingLoadMore),
                                    ),
                                  );
                                }

                                final c = _printings[index];
                                final id = c['id'] as String?;
                                final name = (c['name'] as String?) ?? '';
                                final setCode = (c['set'] as String?) ?? '';
                                final setName =
                                    (c['set_name'] as String?) ?? '';
                                final collector =
                                    (c['collector_number'] as String?) ?? '';
                                final img =
                                    ScryfallClient.extractImageSmall(c) ??
                                        ScryfallClient.extractImageNormal(c) ??
                                        ScryfallClient.extractImagePng(c);

                                final selected = id != null &&
                                    id == widget.selectedPrintingId;

                                return ManaSurfaceCard(
                                  onTap: id == null
                                      ? null
                                      : () => context.pop<String>(id),
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 12,
                                    vertical: 10,
                                  ),
                                  child: Row(
                                    children: [
                                      CachedCardThumbnail(
                                        imageUrl: img,
                                        label: name,
                                        caption:
                                            '${setCode.toUpperCase()} #$collector',
                                      ),
                                      const SizedBox(width: 12),
                                      Expanded(
                                        child: Column(
                                          crossAxisAlignment:
                                              CrossAxisAlignment.start,
                                          children: [
                                            Text(
                                              '${setCode.toUpperCase()} · #$collector',
                                              style: Theme.of(context)
                                                  .textTheme
                                                  .titleSmall
                                                  ?.copyWith(
                                                    fontWeight: FontWeight.w700,
                                                  ),
                                            ),
                                            const SizedBox(height: 4),
                                            Text(
                                              setName,
                                              maxLines: 2,
                                              overflow: TextOverflow.ellipsis,
                                              style: Theme.of(context)
                                                  .textTheme
                                                  .bodySmall,
                                            ),
                                          ],
                                        ),
                                      ),
                                      if (selected)
                                        Icon(
                                          Icons.check_circle_rounded,
                                          color: Theme.of(context)
                                              .colorScheme
                                              .primary,
                                        ),
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
