import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_surface_card.dart';
import '../../data/local/db/app_database.dart';

class DecksScreen extends StatefulWidget {
  const DecksScreen({super.key});

  @override
  State<DecksScreen> createState() => _DecksScreenState();
}

class _DecksScreenState extends State<DecksScreen> {
  Future<void> _onToggleActive(Deck d, bool active) async {
    try {
      if (active) {
        final check = await appDb.decksDao.checkActivationConflicts(d.id);
        if (!mounted) return;
        final t = AppLocalizations.of(context)!;

        final currentActive = check.activeDeck;
        final conflicts = check.conflicts;
        if (currentActive != null && conflicts.isNotEmpty) {
          final ok = await showDialog<bool>(
            context: context,
            builder: (dialogContext) => AlertDialog(
              title: Text(t.activateDeckTitle),
              content: SizedBox(
                width: double.maxFinite,
                child: SingleChildScrollView(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        t.activateDeckBody(currentActive.name),
                        style: Theme.of(dialogContext).textTheme.bodyMedium,
                      ),
                      const SizedBox(height: 12),
                      for (final c in conflicts)
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 4),
                          child: Row(
                            children: [
                              Expanded(
                                child: Text(
                                  c.name,
                                  style: Theme.of(dialogContext)
                                      .textTheme
                                      .bodyMedium
                                      ?.copyWith(fontWeight: FontWeight.w700),
                                ),
                              ),
                              Text(
                                '×${c.quantity}',
                                style: Theme.of(dialogContext)
                                    .textTheme
                                    .bodyMedium
                                    ?.copyWith(fontWeight: FontWeight.w900),
                              ),
                            ],
                          ),
                        ),
                    ],
                  ),
                ),
              ),
              actions: [
                TextButton(
                  onPressed: () => Navigator.of(dialogContext).pop(false),
                  child: Text(t.cancel),
                ),
                ElevatedButton(
                  onPressed: () => Navigator.of(dialogContext).pop(true),
                  child: Text(t.confirm),
                ),
              ],
            ),
          );
          if (ok != true) return;
        }

        await appDb.decksDao.setDeckActive(
          deckId: d.id,
          isActive: true,
          now: DateTime.now(),
        );
        return;
      }

      await appDb.decksDao.setDeckActive(
        deckId: d.id,
        isActive: false,
        now: DateTime.now(),
      );
    } catch (e) {
      if (!mounted) return;
      final t = AppLocalizations.of(context)!;
      final messenger = ScaffoldMessenger.of(context);
      messenger.showSnackBar(
        SnackBar(content: Text('${t.error}: $e')),
      );
    }
  }

  Future<void> _openActiveDeckPicker({
    required List<Deck> decks,
    required Map<String, bool> completeByDeckId,
  }) async {
    final t = AppLocalizations.of(context)!;
    await showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (sheetContext) {
        final active = decks.where((d) => d.isActive).toList();
        final activeId = active.isEmpty ? null : active.first.id;

        return DraggableScrollableSheet(
          expand: false,
          initialChildSize: 0.65,
          minChildSize: 0.45,
          maxChildSize: 0.95,
          builder: (context, controller) {
            return Padding(
              padding: EdgeInsets.only(
                left: 16,
                right: 16,
                top: 6,
                bottom: 16 + MediaQuery.of(context).viewInsets.bottom,
              ),
              child: Column(
                children: [
                  Text(
                    t.activeDeckPickerTitle,
                    style: Theme.of(context).textTheme.titleMedium?.copyWith(
                          fontWeight: FontWeight.w900,
                        ),
                  ),
                  const SizedBox(height: 10),
                  Expanded(
                    child: ListView(
                      controller: controller,
                      children: [
                        RadioListTile<String?>(
                          value: null,
                          groupValue: activeId,
                          title: Text(t.activeDeckNone),
                          onChanged: (v) async {
                            Navigator.of(sheetContext).pop();
                            await appDb.decksDao.deactivateAllDecks();
                          },
                        ),
                        const Divider(height: 1),
                        for (final d in decks) ...[
                          RadioListTile<String?>(
                            value: d.id,
                            groupValue: activeId,
                            title: Text(d.name),
                            subtitle: Text(d.format),
                            onChanged: (completeByDeckId[d.id] ?? true)
                                ? (v) async {
                                    Navigator.of(sheetContext).pop();
                                    await _onToggleActive(d, true);
                                  }
                                : null,
                          ),
                          const Divider(height: 1),
                        ],
                      ],
                    ),
                  ),
                ],
              ),
            );
          },
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final t = AppLocalizations.of(context)!;
    return Scaffold(
      appBar: ManaInternalAppBar(
        title: t.decksTitle,
        actions: [
          StreamBuilder<List<Deck>>(
            stream: appDb.decksDao.watchDecks(),
            builder: (context, dSnap) {
              final decks = dSnap.data ?? const <Deck>[];
              if (decks.isEmpty) return const SizedBox.shrink();
              return StreamBuilder<Map<String, bool>>(
                stream: appDb.decksDao.watchDeckCompleteness(),
                builder: (context, cSnap) {
                  final completeByDeckId =
                      cSnap.data ?? const <String, bool>{};
                  return IconButton(
                    tooltip: t.activeDeckPickerTitle,
                    icon: const Icon(Icons.more_vert_rounded),
                    onPressed: () => _openActiveDeckPicker(
                      decks: decks,
                      completeByDeckId: completeByDeckId,
                    ),
                  );
                },
              );
            },
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () async {
          final messenger = ScaffoldMessenger.of(context);
          try {
            await context.pushNamed(AppRoutes.createDeck);
          } catch (e) {
            if (!context.mounted) return;
            messenger.showSnackBar(
              SnackBar(content: Text('Erro ao abrir criação de deck: $e')),
            );
          }
        },
        icon: const Icon(Icons.add_rounded),
        label: Text(t.decksCreateCta),
      ),
      body: StreamBuilder<List<Deck>>(
        stream: appDb.decksDao.watchDecks(),
        builder: (context, snapshot) {
          final decks = snapshot.data ?? const <Deck>[];
          if (decks.isEmpty) {
            return ManaEmptyState(
              icon: Icons.style_outlined,
              title: t.decksEmptyTitle,
              subtitle: t.decksEmptySubtitle,
            );
          }

          return StreamBuilder<Map<String, bool>>(
            stream: appDb.decksDao.watchDeckCompleteness(),
            builder: (context, cSnap) {
              return ListView.separated(
                padding: const EdgeInsets.fromLTRB(16, 8, 16, 110),
                itemCount: decks.length,
                separatorBuilder: (_, __) => const SizedBox(height: 10),
                itemBuilder: (context, index) {
                  final d = decks[index];
                  final active = d.isActive;

                  final card = ManaSurfaceCard(
                    onTap: () => context.pushNamed(
                      AppRoutes.deckDetail,
                      pathParameters: {'deckId': d.id},
                    ),
                    padding: const EdgeInsets.all(14),
                    child: Row(
                      children: [
                        Container(
                          width: 44,
                          height: 44,
                          decoration: BoxDecoration(
                            color: (active
                                    ? scheme.primaryContainer
                                    : scheme.primaryContainer.withOpacity(0.35))
                                .withOpacity(active ? 0.55 : 1),
                            borderRadius: BorderRadius.circular(12),
                            border: active
                                ? Border.all(
                                    color: scheme.primary.withOpacity(0.55),
                                  )
                                : null,
                          ),
                          child: Icon(
                            Icons.style_rounded,
                            color: active ? scheme.primary : scheme.primary,
                          ),
                        ),
                        const SizedBox(width: 12),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Row(
                                children: [
                                  Expanded(
                                    child: Text(
                                      d.name,
                                      maxLines: 1,
                                      overflow: TextOverflow.ellipsis,
                                      style: Theme.of(context)
                                          .textTheme
                                          .titleMedium
                                          ?.copyWith(fontWeight: FontWeight.w900),
                                    ),
                                  ),
                                ],
                              ),
                              const SizedBox(height: 6),
                              Align(
                                alignment: Alignment.centerLeft,
                                child: Container(
                                  padding: const EdgeInsets.symmetric(
                                    horizontal: 10,
                                    vertical: 5,
                                  ),
                                  decoration: BoxDecoration(
                                    color: scheme.secondaryContainer
                                        .withOpacity(0.35),
                                    borderRadius: BorderRadius.circular(999),
                                    border: Border.all(
                                      color: scheme.secondary.withOpacity(0.35),
                                    ),
                                  ),
                                  child: Text(
                                    d.format,
                                    style: Theme.of(context)
                                        .textTheme
                                        .labelSmall
                                        ?.copyWith(
                                          color: scheme.onSurface,
                                          fontWeight: FontWeight.w700,
                                          letterSpacing: 0.2,
                                        ),
                                  ),
                                ),
                              ),
                              // Switch disabled already indicates missing cards.
                            ],
                          ),
                        ),
                        Icon(
                          Icons.chevron_right_rounded,
                          color: scheme.onSurfaceVariant,
                        ),
                      ],
                    ),
                  );

                  if (!active) return card;

                  return Container(
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(18),
                      border: Border.all(color: scheme.primary.withOpacity(0.55)),
                      boxShadow: [
                        BoxShadow(
                          color: scheme.primary.withOpacity(0.18),
                          blurRadius: 22,
                          offset: const Offset(0, 10),
                        ),
                      ],
                    ),
                    child: card,
                  );
                },
              );
            },
          );
        },
      ),
    );
  }
}

