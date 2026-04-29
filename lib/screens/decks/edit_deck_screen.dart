import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';
import 'package:uuid/uuid.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_internal_app_bar.dart';
import 'widgets/commander_picker_sheet.dart';

class EditDeckScreen extends StatefulWidget {
  const EditDeckScreen({
    super.key,
    required this.deckId,
  });

  final String deckId;

  @override
  State<EditDeckScreen> createState() => _EditDeckScreenState();
}

class _EditDeckScreenState extends State<EditDeckScreen> {
  final _name = TextEditingController();
  String _format = 'Commander';
  bool _saving = false;
  bool _loaded = false;
  bool _deleting = false;

  @override
  void dispose() {
    _name.dispose();
    super.dispose();
  }

  Future<void> _loadOnce() async {
    final deck = await appDb.decksDao.getDeckOnce(widget.deckId);
    if (!mounted) return;
    if (deck == null) return;
    setState(() {
      _name.text = deck.name;
      _format = deck.format;
      _loaded = true;
    });
  }

  Future<void> _save() async {
    final t = AppLocalizations.of(context)!;
    final name = _name.text.trim();
    if (name.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text(t.createDeckNameRequired)),
      );
      return;
    }
    setState(() => _saving = true);
    try {
      await appDb.decksDao.updateDeck(
        id: widget.deckId,
        name: name,
        format: _format,
        now: DateTime.now(),
      );
      if (mounted) context.pop();
    } catch (e) {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Erro ao salvar deck: $e')),
      );
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  Future<void> _addCommanderFlow(List commanders) async {
    final t = AppLocalizations.of(context)!;
    if (commanders.length >= 2) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text(t.commanderMaxReached)),
      );
      return;
    }

    final res = await showModalBottomSheet<CommanderPickResult>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => const CommanderPickerSheet(),
    );
    if (res == null) return;

    final now = DateTime.now();

    // Se já existir como comandante, não duplica — apenas garante printing preferido.
    final existingCommander =
        await appDb.deckEntriesDao.getEntryOnceForDeckOracleSection(
      deckId: widget.deckId,
      oracleId: res.oracleId,
      section: 'commander',
    );
    if (existingCommander != null) {
      await appDb.deckEntriesDao.setPreferredPrinting(
        entryId: existingCommander.id,
        preferredPrintingId: res.printingId,
        now: now,
      );
      return;
    }

    // Se já existir no deck (main), reutiliza a cópia:
    // - qty==1: move para commander
    // - qty>1: decrementa main e cria commander qty=1
    final existingMain =
        await appDb.deckEntriesDao.getEntryOnceForDeckOracleSection(
      deckId: widget.deckId,
      oracleId: res.oracleId,
      section: 'main',
    );

    if (existingMain != null) {
      if (existingMain.quantity <= 1) {
        await appDb.deckEntriesDao.setSection(
          entryId: existingMain.id,
          section: 'commander',
          now: now,
        );
        await appDb.deckEntriesDao.setPreferredPrinting(
          entryId: existingMain.id,
          preferredPrintingId: res.printingId,
          now: now,
        );
        return;
      }

      await appDb.deckEntriesDao.setQuantity(
        entryId: existingMain.id,
        quantity: existingMain.quantity - 1,
        now: now,
      );
    }

    await appDb.deckEntriesDao.addOrIncrement(
      id: const Uuid().v4(),
      deckId: widget.deckId,
      oracleId: res.oracleId,
      preferredPrintingId: res.printingId,
      quantityDelta: 1,
      now: now,
      section: 'commander',
    );
  }

  Future<void> _deleteDeck() async {
    if (_deleting) return;
    final t = AppLocalizations.of(context)!;

    final ok = await showDialog<bool>(
      context: context,
      builder: (dialogContext) => AlertDialog(
        title: Text(t.deleteDeckTitle),
        content: Text(t.deleteDeckBody),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(dialogContext).pop(false),
            child: Text(t.cancel),
          ),
          ElevatedButton(
            onPressed: () => Navigator.of(dialogContext).pop(true),
            child: Text(t.deleteDeckCta),
          ),
        ],
      ),
    );
    if (ok != true) return;

    setState(() => _deleting = true);
    try {
      await appDb.deckEntriesDao.deleteEntriesForDeck(widget.deckId);
      await appDb.decksDao.deleteDeck(widget.deckId);
      if (!mounted) return;
      // Volta para a lista de decks.
      GoRouter.of(context).goNamed(AppRoutes.decks);
    } catch (e) {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Erro ao excluir deck: $e')),
      );
    } finally {
      if (mounted) setState(() => _deleting = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;

    if (!_loaded) {
      // Lazy-load after first build so we don't block build synchronously.
      WidgetsBinding.instance.addPostFrameCallback((_) {
        if (!_loaded) _loadOnce();
      });
    }

    return Scaffold(
      appBar: ManaInternalAppBar(title: t.editDeckTitle),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 12, 16, 24),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _name,
              textInputAction: TextInputAction.done,
              onSubmitted: (_) => _saving ? null : _save(),
              decoration: InputDecoration(
                labelText: t.createDeckNameLabel,
                hintText: t.createDeckNameHint,
              ),
            ),
            const SizedBox(height: 12),
            DropdownButtonFormField<String>(
              value: _format,
              decoration: InputDecoration(labelText: t.createDeckFormatLabel),
              items: const [
                DropdownMenuItem(value: 'Commander', child: Text('Commander')),
                DropdownMenuItem(value: 'Standard', child: Text('Standard')),
                DropdownMenuItem(value: 'Pauper', child: Text('Pauper')),
                DropdownMenuItem(value: 'Modern', child: Text('Modern')),
                DropdownMenuItem(value: 'Other', child: Text('Other')),
              ],
              onChanged: _saving ? null : (v) => setState(() => _format = v ?? 'Commander'),
            ),
            if (_format == 'Commander') ...[
              const SizedBox(height: 12),
              StreamBuilder(
                stream: appDb.deckEntriesDao.watchDeckEntriesForSection(
                  deckId: widget.deckId,
                  section: 'commander',
                ),
                builder: (context, snap) {
                  final commanders = snap.data ?? const [];
                  return Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      color: Theme.of(context)
                          .colorScheme
                          .surfaceContainerHigh
                          .withOpacity(0.65),
                      borderRadius: BorderRadius.circular(16),
                      border: Border.all(
                        color: Theme.of(context)
                            .colorScheme
                            .outlineVariant
                            .withOpacity(0.55),
                      ),
                    ),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        Row(
                          children: [
                            Expanded(
                              child: Text(
                                t.commandersTitle,
                                style: Theme.of(context)
                                    .textTheme
                                    .titleSmall
                                    ?.copyWith(fontWeight: FontWeight.w900),
                              ),
                            ),
                            TextButton.icon(
                              onPressed: (_saving || _deleting)
                                  ? null
                                  : () => _addCommanderFlow(commanders),
                              icon: const Icon(Icons.add_rounded),
                              label: Text(t.setCommanderCta),
                            ),
                          ],
                        ),
                        const SizedBox(height: 6),
                        if (commanders.isEmpty)
                          Text(
                            t.noCommanderSelected,
                            style: Theme.of(context).textTheme.bodySmall?.copyWith(
                                  color: Theme.of(context)
                                      .colorScheme
                                      .onSurfaceVariant,
                                ),
                          )
                        else
                          ...commanders.map((c) {
                            final name =
                                c.printing?.name ?? c.entry.oracleId;
                            return ListTile(
                              dense: true,
                              contentPadding: EdgeInsets.zero,
                              title: Text(name),
                              trailing: IconButton(
                                tooltip: t.remove,
                                onPressed: (_saving || _deleting)
                                    ? null
                                    : () => appDb.deckEntriesDao.setQuantity(
                                          entryId: c.entry.id,
                                          quantity: 0,
                                          now: DateTime.now(),
                                        ),
                                icon: const Icon(Icons.close_rounded),
                              ),
                            );
                          }),
                      ],
                    ),
                  );
                },
              ),
            ],
            const Spacer(),
            OutlinedButton.icon(
              onPressed: (_saving || _deleting) ? null : _deleteDeck,
              style: OutlinedButton.styleFrom(
                foregroundColor: Theme.of(context).colorScheme.error,
              ),
              icon: _deleting
                  ? const SizedBox(
                      width: 18,
                      height: 18,
                      child: CircularProgressIndicator(strokeWidth: 2),
                    )
                  : const Icon(Icons.delete_outline_rounded),
              label: Text(t.deleteDeckCta),
            ),
            const SizedBox(height: 10),
            FilledButton(
              onPressed: (_saving || _deleting) ? null : _save,
              child: _saving
                  ? const SizedBox(
                      width: 18,
                      height: 18,
                      child: CircularProgressIndicator(strokeWidth: 2),
                    )
                  : Text(t.deckSaveCta),
            ),
          ],
        ),
      ),
    );
  }
}

