import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';

import '../../../app/router.dart';
import '../../../data/local/db/daos/deck_entries_dao.dart';
import '../../../data/local/db/app_database.dart';
import '../../../data/local/db/db_instance.dart';
import '../../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../../data/remote/scryfall/scryfall_client.dart';
import '../../../data/remote/scryfall/scryfall_local_search_service.dart';
import '../../../screens/scryfall_add_card/widgets/add_to_collection_sheet.dart';
import '../../../widgets/cached_card_thumbnail.dart';

class DeckCardDetailSheet extends StatefulWidget {
  const DeckCardDetailSheet({
    super.key,
    required this.deckId,
    required this.row,
  });

  final String deckId;
  final DeckEntryView row;

  @override
  State<DeckCardDetailSheet> createState() => _DeckCardDetailSheetState();
}

class _DeckCardDetailSheetState extends State<DeckCardDetailSheet> {
  final _client = ScryfallClient();
  final _cacheService = ScryfallCacheService();
  final _localSearch = ScryfallLocalSearchService();

  bool _loadingCard = false;
  bool _changingPrinting = false;
  Map<String, dynamic>? _cardJson;
  String? _cardError;
  ScryfallPrinting? _selectedPrinting;
  String? _preferredPrintingId;

  late int _qty;
  bool _savingQty = false;

  @override
  void initState() {
    super.initState();
    _qty = widget.row.entry.quantity;
    _selectedPrinting = widget.row.printing;
    _preferredPrintingId = widget.row.entry.preferredPrintingId;
    _loadCard();
  }

  Future<void> _loadCard() async {
    final printingId = _preferredPrintingId;
    if (printingId == null || printingId.isEmpty) return;
    setState(() {
      _loadingCard = true;
      _cardError = null;
    });
    try {
      final json = await _cardByIdRemoteThenLocal(printingId);
      if (!mounted) return;
      setState(() => _cardJson = json);
    } catch (e) {
      if (!mounted) return;
      setState(() => _cardError = e.toString());
    } finally {
      if (mounted) setState(() => _loadingCard = false);
    }
  }

  String? _oracleTextFromCard(Map<String, dynamic>? card) {
    if (card == null) return null;
    final oracle = card['oracle_text'];
    if (oracle is String && oracle.trim().isNotEmpty) return oracle.trim();

    final faces = card['card_faces'];
    if (faces is List) {
      final parts = <String>[];
      for (final f in faces) {
        if (f is! Map) continue;
        final name = (f['name'] as String?)?.trim();
        final text = (f['oracle_text'] as String?)?.trim();
        if (text == null || text.isEmpty) continue;
        if (name != null && name.isNotEmpty) {
          parts.add('$name\n$text');
        } else {
          parts.add(text);
        }
      }
      if (parts.isNotEmpty) return parts.join('\n\n—\n\n');
    }
    return null;
  }

  String? _typeLineFromCard(Map<String, dynamic>? card) {
    if (card == null) return null;
    final tl = card['type_line'];
    if (tl is String && tl.trim().isNotEmpty) return tl.trim();
    final faces = card['card_faces'];
    if (faces is List && faces.isNotEmpty) {
      final f0 = faces.first;
      if (f0 is Map) {
        final tl0 = f0['type_line'];
        if (tl0 is String && tl0.trim().isNotEmpty) return tl0.trim();
      }
    }
    return null;
  }

  String? _manaCostFromCard(Map<String, dynamic>? card) {
    if (card == null) return null;
    final mc = card['mana_cost'];
    if (mc is String && mc.trim().isNotEmpty) return mc.trim();
    final faces = card['card_faces'];
    if (faces is List && faces.isNotEmpty) {
      final f0 = faces.first;
      if (f0 is Map) {
        final mc0 = f0['mana_cost'];
        if (mc0 is String && mc0.trim().isNotEmpty) return mc0.trim();
      }
    }
    return null;
  }

  String? _normalImageFromCard(Map<String, dynamic>? card) {
    if (card == null) return null;
    return ScryfallClient.extractImageNormal(card);
  }

  Future<void> _setQty(int nextQty) async {
    setState(() {
      _qty = nextQty;
    });
    setState(() => _savingQty = true);
    try {
      await appDb.deckEntriesDao.setQuantity(
        entryId: widget.row.entry.id,
        quantity: nextQty,
        now: DateTime.now(),
      );
      if (!mounted) return;
      if (nextQty <= 0) Navigator.of(context).pop();
    } finally {
      if (mounted) setState(() => _savingQty = false);
    }
  }

  Future<void> _confirmRemove() async {
    final t = AppLocalizations.of(context)!;
    final ok = await showDialog<bool>(
      context: context,
      builder: (dialogContext) => AlertDialog(
        title: Text(t.deckCardRemoveTitle),
        content: Text(t.deckCardRemoveBody),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(dialogContext).pop(false),
            child: Text(t.cancel),
          ),
          ElevatedButton(
            onPressed: () => Navigator.of(dialogContext).pop(true),
            child: Text(t.remove),
          ),
        ],
      ),
    );
    if (ok == true) {
      await _setQty(0);
    }
  }

  Future<void> _openConnectSheet() async {
    final t = AppLocalizations.of(context)!;
    await showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => SafeArea(
        top: false,
        child: Padding(
          padding: const EdgeInsets.fromLTRB(16, 10, 16, 16),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text(
                t.connectToCollectionTitle,
                textAlign: TextAlign.center,
                style: Theme.of(ctx).textTheme.titleMedium?.copyWith(
                      fontWeight: FontWeight.w900,
                    ),
              ),
              const SizedBox(height: 12),
              ListTile(
                leading: const Icon(Icons.add_rounded),
                title: Text(t.connectToCollectionAddOption),
                onTap: () async {
                  Navigator.of(ctx).pop();
                  await _openPickCollectionSheet();
                },
              ),
              ListTile(
                leading: const Icon(Icons.link_rounded),
                title: Text(t.connectToCollectionLinkOption),
                subtitle: Text(t.connectToCollectionLinkOptionSubtitle),
                onTap: () {
                  Navigator.of(ctx).pop();
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                        content: Text(t.connectToCollectionLinkComingSoon)),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }

  Future<void> _openPickCollectionSheet() async {
    final t = AppLocalizations.of(context)!;
    await showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => DraggableScrollableSheet(
        expand: false,
        initialChildSize: 0.75,
        minChildSize: 0.45,
        maxChildSize: 0.95,
        builder: (ctx, controller) => SafeArea(
          top: false,
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.fromLTRB(16, 10, 16, 10),
                child: Text(
                  t.pickCollectionTitle,
                  style: Theme.of(ctx).textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
              ),
              Expanded(
                child: StreamBuilder(
                  stream: appDb.collectionDao.watchCollections(),
                  builder: (context, snapshot) {
                    final cols = snapshot.data ?? const [];
                    if (cols.isEmpty) {
                      return Center(child: Text(t.pickCollectionEmpty));
                    }
                    return ListView.separated(
                      controller: controller,
                      itemCount: cols.length,
                      separatorBuilder: (_, __) => const Divider(height: 1),
                      itemBuilder: (context, i) {
                        final c = cols[i];
                        return ListTile(
                          title: Text(c.name),
                          trailing: const Icon(Icons.chevron_right_rounded),
                          onTap: () async {
                            Navigator.of(ctx).pop();
                            await _openAddToCollectionSheet(c.id);
                          },
                        );
                      },
                    );
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Future<void> _openAddToCollectionSheet(String collectionId) async {
    final t = AppLocalizations.of(context)!;
    final entry = widget.row.entry;
    final printingId = _preferredPrintingId;
    if (printingId == null || printingId.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text(t.pickEditionFirst)),
      );
      return;
    }

    await showModalBottomSheet<void>(
      context: context,
      isScrollControlled: true,
      showDragHandle: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => AddToCollectionSheet(
        defaultCollectionId: collectionId,
        initialPrintingId: printingId,
        oracleId: entry.oracleId,
      ),
    );
  }

  Future<void> _changePrinting() async {
    if (_changingPrinting) return;
    final entry = widget.row.entry;
    final selected = _preferredPrintingId;
    final rootCtx = rootNavigatorKey.currentContext;
    final navCtx = rootCtx ?? context;

    final result = await GoRouter.of(navCtx).pushNamed<String>(
      AppRoutes.selectPrinting,
      extra: {
        'oracleId': entry.oracleId,
        'selectedPrintingId': selected ?? '',
      },
    );
    final picked = result;
    if (picked == null || picked.isEmpty) return;
    if (!mounted) return;

    // Cache the picked printing so the deck list can render it.
    setState(() => _changingPrinting = true);
    try {
      final card = await _cardByIdRemoteThenLocal(picked);
      await _cacheService.cacheSingleScryfallCard(card);
      final printing = await _printingById(picked);

      final now = DateTime.now();
      await appDb.deckEntriesDao.setPreferredPrinting(
        entryId: entry.id,
        preferredPrintingId: picked,
        now: now,
      );

      if (!mounted) return;
      setState(() {
        _preferredPrintingId = picked;
        _selectedPrinting = printing;
        _cardJson = card;
        _cardError = null;
      });
    } catch (e) {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('${AppLocalizations.of(context)!.error}: $e')),
      );
    } finally {
      if (mounted) setState(() => _changingPrinting = false);
    }
  }

  Future<ScryfallPrinting?> _printingById(String printingId) {
    return (appDb.select(appDb.scryfallPrintings)
          ..where((table) => table.printingId.equals(printingId)))
        .getSingleOrNull();
  }

  Future<Map<String, dynamic>> _cardByIdRemoteThenLocal(
    String printingId,
  ) async {
    try {
      return await _client.getCardById(printingId);
    } catch (error) {
      final local = await _localSearch.getCardById(printingId);
      if (local != null) return local;
      throw scryfallLocalFallbackErrorMessage(error);
    }
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    final scheme = Theme.of(context).colorScheme;

    final p = _selectedPrinting ?? widget.row.printing;
    final name = p?.name ?? widget.row.entry.oracleId;
    final typeLine = _typeLineFromCard(_cardJson) ?? p?.typeLine;
    final manaCost = _manaCostFromCard(_cardJson) ?? p?.manaCost;
    final oracleText = _oracleTextFromCard(_cardJson);
    final bigImg =
        _normalImageFromCard(_cardJson) ?? p?.imageNormal ?? p?.imageSmall;

    final setLine =
        p == null ? null : '${p.setCode.toUpperCase()} • #${p.collectorNumber}';
    final setName = p?.setName;

    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.85,
      minChildSize: 0.45,
      maxChildSize: 0.95,
      builder: (context, scrollController) {
        return SafeArea(
          top: false,
          child: SingleChildScrollView(
            controller: scrollController,
            padding: EdgeInsets.only(
              left: 16,
              right: 16,
              top: 10,
              bottom: 16 + MediaQuery.of(context).viewInsets.bottom,
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Row(
                  children: [
                    Expanded(
                      child: Text(
                        name,
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                        style:
                            Theme.of(context).textTheme.titleMedium?.copyWith(
                                  fontWeight: FontWeight.w900,
                                ),
                      ),
                    ),
                    IconButton(
                      tooltip: t.connectToCollectionTitle,
                      onPressed: _openConnectSheet,
                      style: IconButton.styleFrom(
                        backgroundColor:
                            scheme.primaryContainer.withValues(alpha: 0.65),
                        foregroundColor: scheme.onPrimaryContainer,
                        side: BorderSide(
                          color: scheme.primary.withValues(alpha: 0.45),
                        ),
                        elevation: 2,
                        shadowColor: scheme.primary.withValues(alpha: 0.25),
                      ),
                      icon: const Icon(Icons.add_rounded),
                    ),
                  ],
                ),
                const SizedBox(height: 10),
                Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    CachedCardThumbnail(
                      imageUrl: bigImg,
                      label: name,
                      caption: setLine,
                      width: 120,
                      height: 168,
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          if (typeLine != null &&
                              typeLine.trim().isNotEmpty) ...[
                            Text(
                              typeLine,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodySmall
                                  ?.copyWith(
                                    color: scheme.onSurfaceVariant,
                                  ),
                            ),
                            const SizedBox(height: 8),
                          ],
                          if (manaCost != null &&
                              manaCost.trim().isNotEmpty) ...[
                            Text(
                              manaCost,
                              style: Theme.of(context)
                                  .textTheme
                                  .titleSmall
                                  ?.copyWith(
                                    fontWeight: FontWeight.w800,
                                    letterSpacing: 0.2,
                                  ),
                            ),
                            const SizedBox(height: 8),
                          ],
                          if (setLine != null) ...[
                            Text(
                              setLine,
                              style: Theme.of(context)
                                  .textTheme
                                  .labelMedium
                                  ?.copyWith(
                                    color: scheme.primary,
                                    fontWeight: FontWeight.w700,
                                  ),
                            ),
                            if (setName != null &&
                                setName.trim().isNotEmpty) ...[
                              const SizedBox(height: 2),
                              Text(
                                setName,
                                style: Theme.of(context)
                                    .textTheme
                                    .bodySmall
                                    ?.copyWith(
                                      color: scheme.onSurfaceVariant,
                                    ),
                              ),
                            ],
                          ],
                        ],
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 12),
                if (_loadingCard) const LinearProgressIndicator(minHeight: 3),
                if (_cardError != null) ...[
                  const SizedBox(height: 8),
                  Text(
                    '${t.error}: $_cardError',
                    style: Theme.of(context)
                        .textTheme
                        .bodySmall
                        ?.copyWith(color: scheme.error),
                  ),
                ],
                if (oracleText != null && oracleText.trim().isNotEmpty) ...[
                  const SizedBox(height: 12),
                  Container(
                    width: double.infinity,
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      color: scheme.surfaceContainerHigh.withValues(alpha: 0.7),
                      borderRadius: BorderRadius.circular(14),
                      border: Border.all(
                        color: scheme.outlineVariant.withValues(alpha: 0.6),
                      ),
                    ),
                    child: Text(
                      oracleText,
                      style: Theme.of(context).textTheme.bodySmall,
                    ),
                  ),
                ],
                const SizedBox(height: 14),
                Container(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
                  decoration: BoxDecoration(
                    color: scheme.surfaceContainerHigh.withValues(alpha: 0.7),
                    borderRadius: BorderRadius.circular(14),
                    border: Border.all(
                        color: scheme.outlineVariant.withValues(alpha: 0.6)),
                  ),
                  child: Row(
                    children: [
                      Text(
                        t.quantity,
                        style: Theme.of(context).textTheme.titleSmall?.copyWith(
                              fontWeight: FontWeight.w800,
                            ),
                      ),
                      const Spacer(),
                      IconButton(
                        onPressed: (_savingQty || _qty <= 0)
                            ? null
                            : () async {
                                final next = _qty - 1;
                                if (next <= 0) {
                                  await _confirmRemove();
                                  return;
                                }
                                await _setQty(next);
                              },
                        icon: const Icon(Icons.remove),
                      ),
                      Text(
                        '$_qty',
                        style:
                            Theme.of(context).textTheme.titleMedium?.copyWith(
                                  fontWeight: FontWeight.w900,
                                ),
                      ),
                      IconButton(
                        onPressed: _savingQty ? null : () => _setQty(_qty + 1),
                        icon: const Icon(Icons.add),
                      ),
                    ],
                  ),
                ),
                const SizedBox(height: 12),
                LayoutBuilder(
                  builder: (context, constraints) {
                    final changeButton = OutlinedButton.icon(
                      onPressed: _changingPrinting ? null : _changePrinting,
                      icon: const Icon(Icons.layers_rounded),
                      label: _changingPrinting
                          ? const SizedBox(
                              width: 16,
                              height: 16,
                              child: CircularProgressIndicator(strokeWidth: 2),
                            )
                          : Text(
                              t.changePrinting,
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                            ),
                    );
                    final removeButton = OutlinedButton.icon(
                      onPressed: _confirmRemove,
                      style: OutlinedButton.styleFrom(
                        foregroundColor: scheme.error,
                      ),
                      icon: const Icon(Icons.delete_outline_rounded),
                      label: Text(
                        t.remove,
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                      ),
                    );
                    if (constraints.maxWidth < 340) {
                      return Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          changeButton,
                          const SizedBox(height: 8),
                          removeButton,
                        ],
                      );
                    }
                    return Row(
                      children: [
                        Expanded(child: changeButton),
                        const SizedBox(width: 10),
                        Expanded(child: removeButton),
                      ],
                    );
                  },
                ),
                const SizedBox(height: 6),
              ],
            ),
          ),
        );
      },
    );
  }
}
