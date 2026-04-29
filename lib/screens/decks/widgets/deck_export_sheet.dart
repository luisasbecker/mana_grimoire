import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter/services.dart';

import '../../../data/local/db/daos/deck_entries_dao.dart';
import '../../../data/local/db/db_instance.dart';

class DeckExportSheet extends StatelessWidget {
  const DeckExportSheet({
    super.key,
    required this.deckId,
  });

  final String deckId;

  String _toPlainText(List<DeckEntryView> entries) {
    final lines = <String>[];
    for (final row in entries) {
      final qty = row.entry.quantity;
      if (qty <= 0) continue;
      final name = row.printing?.name ?? row.entry.oracleId;
      lines.add('$qty $name');
    }
    return lines.join('\n');
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    final scheme = Theme.of(context).colorScheme;

    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.8,
      minChildSize: 0.45,
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
            child: StreamBuilder<List<DeckEntryView>>(
              stream: appDb.deckEntriesDao.watchDeckEntries(deckId: deckId),
              builder: (context, snapshot) {
                final entries = snapshot.data ?? const <DeckEntryView>[];
                final text = _toPlainText(entries);

                return Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    Text(
                      t.deckExportTitle,
                      textAlign: TextAlign.center,
                      style: Theme.of(context).textTheme.titleMedium?.copyWith(
                            fontWeight: FontWeight.w900,
                          ),
                    ),
                    const SizedBox(height: 10),
                    Expanded(
                      child: Container(
                        padding: const EdgeInsets.all(12),
                        decoration: BoxDecoration(
                          color: scheme.surfaceContainerHigh.withOpacity(0.7),
                          borderRadius: BorderRadius.circular(14),
                          border: Border.all(
                            color: scheme.outlineVariant.withOpacity(0.6),
                          ),
                        ),
                        child: SingleChildScrollView(
                          controller: scrollController,
                          child: SelectableText(
                            text.isEmpty ? t.deckExportEmpty : text,
                            style: Theme.of(context).textTheme.bodySmall,
                          ),
                        ),
                      ),
                    ),
                    const SizedBox(height: 12),
                    Row(
                      children: [
                        Expanded(
                          child: OutlinedButton(
                            onPressed: () => Navigator.of(context).pop(),
                            child: Text(t.cancel),
                          ),
                        ),
                        const SizedBox(width: 12),
                        Expanded(
                          child: FilledButton.icon(
                            onPressed: text.isEmpty
                                ? null
                                : () async {
                                    await Clipboard.setData(
                                      ClipboardData(text: text),
                                    );
                                    if (!context.mounted) return;
                                    ScaffoldMessenger.of(context).showSnackBar(
                                      SnackBar(content: Text(t.deckExportCopied)),
                                    );
                                  },
                            icon: const Icon(Icons.copy_rounded),
                            label: Text(t.deckExportCopyCta),
                          ),
                        ),
                      ],
                    ),
                  ],
                );
              },
            ),
          ),
        );
      },
    );
  }
}

