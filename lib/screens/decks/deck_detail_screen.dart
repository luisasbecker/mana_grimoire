import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../data/local/db/daos/deck_entries_dao.dart';
import '../../widgets/cached_card_thumbnail.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';
import 'widgets/deck_import_sheet.dart';
import 'widgets/deck_export_sheet.dart';
import 'widgets/deck_to_collection_sheet.dart';
import 'widgets/deck_card_preview_viewer.dart';

class DeckDetailScreen extends StatelessWidget {
  const DeckDetailScreen({
    super.key,
    required this.deckId,
  });

  final String deckId;

  static String _categoryFromTypeLine(String? typeLine) {
    final tl = (typeLine ?? '').toLowerCase();
    if (tl.contains('land')) return 'lands';
    if (tl.contains('planeswalker')) return 'planeswalkers';
    if (tl.contains('creature')) return 'creatures';
    if (tl.contains('instant')) return 'instants';
    if (tl.contains('sorcery')) return 'sorceries';
    if (tl.contains('enchantment')) return 'enchantments';
    if (tl.contains('artifact')) return 'artifacts';
    return 'other';
  }

  static int _orderForCategory(String c) {
    return switch (c) {
      'commander' => -1,
      'planeswalkers' => 0,
      'creatures' => 1,
      'instants' => 2,
      'sorceries' => 3,
      'enchantments' => 4,
      'artifacts' => 5,
      'lands' => 6,
      _ => 7,
    };
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    return FutureBuilder(
      future: appDb.decksDao.getDeckOnce(deckId),
      builder: (context, snapshot) {
        final deck = snapshot.data;
        return Scaffold(
          appBar: AppBar(
            title: Text(deck?.name ?? t.decksTitle),
            actions: [
              PopupMenuButton<_DeckMenuAction>(
                tooltip: t.options,
                enabled: deck != null,
                icon: const Icon(Icons.more_vert_rounded),
                onSelected: (a) async {
                  final d = deck;
                  if (d == null) return;
                  switch (a) {
                    case _DeckMenuAction.edit:
                      context.pushNamed(
                        AppRoutes.editDeck,
                        pathParameters: {'deckId': d.id},
                      );
                      return;
                    case _DeckMenuAction.import:
                      await showModalBottomSheet<void>(
                        context: context,
                        showDragHandle: true,
                        isScrollControlled: true,
                        backgroundColor:
                            Theme.of(context).colorScheme.surfaceContainerHigh,
                        shape: const RoundedRectangleBorder(
                          borderRadius: BorderRadius.vertical(
                            top: Radius.circular(20),
                          ),
                        ),
                        builder: (_) => DeckImportSheet(deckId: deckId),
                      );
                      return;
                    case _DeckMenuAction.export:
                      await showModalBottomSheet<void>(
                        context: context,
                        showDragHandle: true,
                        isScrollControlled: true,
                        backgroundColor:
                            Theme.of(context).colorScheme.surfaceContainerHigh,
                        shape: const RoundedRectangleBorder(
                          borderRadius: BorderRadius.vertical(
                            top: Radius.circular(20),
                          ),
                        ),
                        builder: (_) => DeckExportSheet(deckId: deckId),
                      );
                      return;
                    case _DeckMenuAction.addToCollection:
                      await showModalBottomSheet<void>(
                        context: context,
                        showDragHandle: true,
                        isScrollControlled: true,
                        backgroundColor:
                            Theme.of(context).colorScheme.surfaceContainerHigh,
                        shape: const RoundedRectangleBorder(
                          borderRadius: BorderRadius.vertical(
                            top: Radius.circular(20),
                          ),
                        ),
                        builder: (_) => DeckToCollectionSheet(
                          deckId: deckId,
                          deckName: d.name,
                        ),
                      );
                      return;
                  }
                },
                itemBuilder: (context) => [
                  PopupMenuItem(
                    value: _DeckMenuAction.edit,
                    child: ListTile(
                      dense: true,
                      contentPadding: EdgeInsets.zero,
                      leading: const Icon(Icons.edit_rounded),
                      title: Text(t.deckEditCta),
                    ),
                  ),
                  PopupMenuItem(
                    value: _DeckMenuAction.import,
                    child: ListTile(
                      dense: true,
                      contentPadding: EdgeInsets.zero,
                      leading: const Icon(Icons.file_upload_outlined),
                      title: Text(t.deckImportCta),
                    ),
                  ),
                  const PopupMenuDivider(),
                  PopupMenuItem(
                    value: _DeckMenuAction.export,
                    child: ListTile(
                      dense: true,
                      contentPadding: EdgeInsets.zero,
                      leading: const Icon(Icons.file_download_outlined),
                      title: Text(t.deckExportCta),
                    ),
                  ),
                  PopupMenuItem(
                    value: _DeckMenuAction.addToCollection,
                    child: ListTile(
                      dense: true,
                      contentPadding: EdgeInsets.zero,
                      leading: const Icon(Icons.library_add_outlined),
                      title: Text(t.deckToCollectionCta),
                    ),
                  ),
                ],
              ),
              const SizedBox(width: 4),
            ],
          ),
          floatingActionButton: deck == null
              ? null
              : FloatingActionButton.small(
                  onPressed: () => context.pushNamed(
                    AppRoutes.addCardToDeck,
                    pathParameters: {'deckId': deck.id},
                  ),
                  tooltip: t.addCardToDeckTitle,
                  child: const Icon(Icons.add_rounded),
                ),
          body: Padding(
            // Mantém espaço para o FAB sem reduzir demais a lista.
            padding: const EdgeInsets.fromLTRB(16, 6, 16, 84),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                StreamBuilder<List<DeckEntryView>>(
                  stream: appDb.deckEntriesDao.watchDeckEntries(deckId: deckId),
                  builder: (context, entriesSnap) {
                    final entries = entriesSnap.data ?? const <DeckEntryView>[];

                    final totalCards = entries.fold<int>(
                      0,
                      (sum, e) => sum + (e.entry.quantity),
                    );

                    return Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          Padding(
                            padding: const EdgeInsets.only(bottom: 6),
                            child: Text(
                              t.deckCardsCount(totalCards),
                              style: Theme.of(context)
                                  .textTheme
                                  .bodySmall
                                  ?.copyWith(
                                    color: Theme.of(context)
                                        .colorScheme
                                        .onSurfaceVariant,
                                    fontWeight: FontWeight.w600,
                                  ),
                              textAlign: TextAlign.center,
                            ),
                          ),
                          const SizedBox(height: 4),
                          Expanded(
                            child: entries.isEmpty
                                ? ManaEmptyState(
                                    icon: Icons.style_outlined,
                                    title: t.deckEmptyTitle,
                                    subtitle: t.deckEmptySubtitle,
                                  )
                                : _DeckEntriesList(
                                    deckId: deckId,
                                    entries: entries,
                                  ),
                          ),
                        ],
                      ),
                    );
                  },
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}

enum _DeckMenuAction { edit, import, export, addToCollection }

class _DeckEntriesList extends StatelessWidget {
  const _DeckEntriesList({
    required this.deckId,
    required this.entries,
  });

  final String deckId;
  final List<DeckEntryView> entries;

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;

    final grouped = <String, List<DeckEntryView>>{};
    for (final row in entries) {
      final cat = row.entry.section == 'commander'
          ? 'commander'
          : DeckDetailScreen._categoryFromTypeLine(row.printing?.typeLine);
      grouped.putIfAbsent(cat, () => []).add(row);
    }

    final cats = grouped.keys.toList()
      ..sort((a, b) => DeckDetailScreen._orderForCategory(a)
          .compareTo(DeckDetailScreen._orderForCategory(b)));

    final items = <Object>[];
    for (final c in cats) {
      items.add(c);
      items.addAll(grouped[c]!);
    }

    String labelForCategory(String c) {
      return switch (c) {
        'commander' => t.deckTypeCommander,
        'planeswalkers' => t.deckTypePlaneswalkers,
        'creatures' => t.deckTypeCreatures,
        'instants' => t.deckTypeInstants,
        'sorceries' => t.deckTypeSorceries,
        'enchantments' => t.deckTypeEnchantments,
        'artifacts' => t.deckTypeArtifacts,
        'lands' => t.deckTypeLands,
        _ => t.deckTypeOther,
      };
    }

    int countForCategory(String c) {
      final list = grouped[c] ?? const [];
      return list.fold<int>(0, (sum, r) => sum + r.entry.quantity);
    }

    return ListView.separated(
      itemCount: items.length,
      separatorBuilder: (_, __) => const SizedBox(height: 8),
      itemBuilder: (context, i) {
        final it = items[i];
        if (it is String) {
          final count = countForCategory(it);
          return Padding(
            padding: const EdgeInsets.only(top: 6, bottom: 2),
            child: Row(
              children: [
                Text(
                  labelForCategory(it),
                  style: Theme.of(context)
                      .textTheme
                      .titleSmall
                      ?.copyWith(fontWeight: FontWeight.w900),
                ),
                const SizedBox(width: 10),
                Text(
                  '($count)',
                  style: Theme.of(context).textTheme.bodySmall?.copyWith(
                        color: Theme.of(context).colorScheme.onSurfaceVariant,
                        fontWeight: FontWeight.w600,
                      ),
                ),
              ],
            ),
          );
        }

        final row = it as DeckEntryView;
        final e = row.entry;
        final p = row.printing;
        final name = p?.name ?? e.oracleId;
        final img = p?.imageSmall;
        final setLine = p == null
            ? null
            : '${p.setCode.toUpperCase()} · #${p.collectorNumber}';

        return ManaSurfaceCard(
          onTap: () async {
            final swipeRows = items.whereType<DeckEntryView>().toList();
            final initialIndex =
                swipeRows.indexWhere((r) => r.entry.id == row.entry.id);
            await Navigator.of(context).push(
              MaterialPageRoute<void>(
                fullscreenDialog: true,
                builder: (_) => DeckCardPreviewViewer(
                  deckId: deckId,
                  rows: swipeRows,
                  initialIndex: initialIndex < 0 ? 0 : initialIndex,
                ),
              ),
            );
          },
          padding: const EdgeInsets.all(12),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              CachedCardThumbnail(
                imageUrl: img,
                width: 52,
                height: 72,
              ),
              const SizedBox(width: 12),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      name,
                      style: Theme.of(context).textTheme.titleSmall?.copyWith(
                            fontWeight: FontWeight.w800,
                          ),
                    ),
                    if (setLine != null) ...[
                      const SizedBox(height: 6),
                      Text(
                        setLine,
                        style:
                            Theme.of(context).textTheme.labelMedium?.copyWith(
                                  color: Theme.of(context).colorScheme.primary,
                                  fontWeight: FontWeight.w600,
                                ),
                      ),
                    ],
                  ],
                ),
              ),
              Text(
                '×${e.quantity}',
                style: Theme.of(context)
                    .textTheme
                    .titleMedium
                    ?.copyWith(fontWeight: FontWeight.w900),
              ),
            ],
          ),
        );
      },
    );
  }
}
