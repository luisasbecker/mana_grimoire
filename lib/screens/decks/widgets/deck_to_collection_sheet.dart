import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:uuid/uuid.dart';

import '../../../data/local/db/app_database.dart';
import '../../../data/local/db/db_instance.dart';

class DeckToCollectionSheet extends StatefulWidget {
  const DeckToCollectionSheet({
    super.key,
    required this.deckId,
    required this.deckName,
  });

  final String deckId;
  final String deckName;

  @override
  State<DeckToCollectionSheet> createState() => _DeckToCollectionSheetState();
}

class _DeckToCollectionSheetState extends State<DeckToCollectionSheet> {
  final _uuid = const Uuid();
  bool _adding = false;
  String? _error;

  Future<void> _createCollectionDialog() async {
    final t = AppLocalizations.of(context)!;
    final controller = TextEditingController();
    final name = await showDialog<String?>(
      context: context,
      builder: (dialogContext) => AlertDialog(
        title: Text(t.newCollectionTitle),
        content: TextField(
          controller: controller,
          decoration: InputDecoration(
            labelText: t.newCollectionNameLabel,
            hintText: t.newCollectionNameHint,
          ),
          autofocus: true,
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(dialogContext).pop(null),
            child: Text(t.cancel),
          ),
          ElevatedButton(
            onPressed: () =>
                Navigator.of(dialogContext).pop(controller.text.trim()),
            child: Text(t.create),
          ),
        ],
      ),
    );
    controller.dispose();
    if (name == null || name.isEmpty) return;
    final now = DateTime.now();
    await appDb.collectionDao.createCollection(
      id: _uuid.v4(),
      name: name,
      now: now,
    );
  }

  Future<void> _addDeckToCollection(Collection c) async {
    if (_adding) return;
    final t = AppLocalizations.of(context)!;
    setState(() {
      _adding = true;
      _error = null;
    });
    try {
      final entries = await appDb.deckEntriesDao
          .watchDeckEntries(deckId: widget.deckId)
          .first;

      // Agrupa por printingId para evitar múltiplos inserts do mesmo printing.
      final byPrinting = <String, int>{};
      var skipped = 0;
      for (final row in entries) {
        final qty = row.entry.quantity;
        if (qty <= 0) continue;
        final pid = row.entry.preferredPrintingId;
        if (pid == null || pid.isEmpty) {
          skipped += 1;
          continue;
        }
        byPrinting.update(pid, (v) => v + qty, ifAbsent: () => qty);
      }

      var added = 0;
      final now = DateTime.now();
      for (final e in byPrinting.entries) {
        await appDb.collectionDao.addOrIncrementItem(
          itemId: _uuid.v4(),
          collectionId: c.id,
          printingId: e.key,
          quantity: e.value,
          isFoil: false,
          condition: 'NM',
          language: 'EN',
          notes: null,
          now: now,
        );
        added += e.value;
      }

      if (!mounted) return;
      Navigator.of(context).pop();
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(t.deckToCollectionResult(added, skipped)),
        ),
      );
    } catch (e) {
      if (!mounted) return;
      setState(() => _error = e.toString());
    } finally {
      if (mounted) setState(() => _adding = false);
    }
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
      builder: (context, controller) {
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
                  t.deckToCollectionTitle,
                  textAlign: TextAlign.center,
                  style: Theme.of(context).textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                const SizedBox(height: 6),
                Text(
                  widget.deckName,
                  textAlign: TextAlign.center,
                  style: Theme.of(context).textTheme.bodySmall?.copyWith(
                        color: scheme.onSurfaceVariant,
                        fontWeight: FontWeight.w600,
                      ),
                ),
                const SizedBox(height: 10),
                Row(
                  children: [
                    Expanded(
                      child: OutlinedButton.icon(
                        onPressed: _adding ? null : _createCollectionDialog,
                        icon: const Icon(Icons.create_new_folder_outlined),
                        label: Text(t.newCollectionCta),
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 10),
                if (_adding) const LinearProgressIndicator(minHeight: 3),
                if (_error != null) ...[
                  const SizedBox(height: 8),
                  Text(
                    '${t.error}: $_error',
                    style: Theme.of(context)
                        .textTheme
                        .bodySmall
                        ?.copyWith(color: scheme.error),
                  ),
                ],
                const SizedBox(height: 10),
                Expanded(
                  child: StreamBuilder<List<Collection>>(
                    stream: appDb.collectionDao.watchCollections(),
                    builder: (context, snap) {
                      final cols = snap.data ?? const <Collection>[];
                      if (cols.isEmpty) {
                        return Center(
                          child: Text(
                            t.pickCollectionEmpty,
                            style: Theme.of(context).textTheme.bodySmall,
                          ),
                        );
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
                            onTap:
                                _adding ? null : () => _addDeckToCollection(c),
                          );
                        },
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
