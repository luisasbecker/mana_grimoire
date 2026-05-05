import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_surface_card.dart';
import '../../data/local/db/app_database.dart';
import '../collections/widgets/collection_section_switcher.dart';

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
                    child: RadioGroup<String?>(
                      groupValue: activeId,
                      onChanged: (value) async {
                        Navigator.of(sheetContext).pop();
                        if (value == null) {
                          await appDb.decksDao.deactivateAllDecks();
                          return;
                        }
                        for (final d in decks) {
                          if (d.id == value) {
                            await _onToggleActive(d, true);
                            return;
                          }
                        }
                      },
                      child: ListView(
                        controller: controller,
                        children: [
                          RadioListTile<String?>(
                            value: null,
                            title: Text(t.activeDeckNone),
                          ),
                          const Divider(height: 1),
                          for (final d in decks) ...[
                            RadioListTile<String?>(
                              value: d.id,
                              title: Text(d.name),
                              subtitle: Text(d.format),
                              enabled: completeByDeckId[d.id] ?? true,
                            ),
                            const Divider(height: 1),
                          ],
                        ],
                      ),
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
                  final completeByDeckId = cSnap.data ?? const <String, bool>{};
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
      body: Column(
        children: [
          const Padding(
            padding: EdgeInsets.fromLTRB(16, 8, 16, 8),
            child: CollectionSectionSwitcher(
              currentSection: CollectionSection.decks,
            ),
          ),
          Expanded(
            child: StreamBuilder<List<Deck>>(
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
                    final completeByDeckId =
                        cSnap.data ?? const <String, bool>{};
                    final activeCount = decks.where((d) => d.isActive).length;
                    return ListView.separated(
                      padding: const EdgeInsets.fromLTRB(16, 0, 16, 112),
                      itemCount: decks.length + 1,
                      separatorBuilder: (_, __) => const SizedBox(height: 12),
                      itemBuilder: (context, index) {
                        if (index == 0) {
                          return _DeckOverview(
                            totalDecks: decks.length,
                            activeDecks: activeCount,
                          );
                        }

                        final deckIndex = index - 1;
                        final d = decks[deckIndex];
                        final active = d.isActive;
                        final complete = completeByDeckId[d.id] ?? true;

                        final card = ManaSurfaceCard(
                          onTap: () => context.pushNamed(
                            AppRoutes.deckDetail,
                            pathParameters: {'deckId': d.id},
                          ),
                          padding: const EdgeInsets.all(14),
                          borderColor: active
                              ? scheme.primary.withValues(alpha: 0.55)
                              : scheme.outlineVariant.withValues(alpha: 0.28),
                          child: Row(
                            children: [
                              _DeckArt(
                                index: deckIndex,
                                active: active,
                              ),
                              const SizedBox(width: 14),
                              Expanded(
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      d.name,
                                      maxLines: 1,
                                      overflow: TextOverflow.ellipsis,
                                      style: Theme.of(context)
                                          .textTheme
                                          .titleMedium
                                          ?.copyWith(
                                            fontWeight: FontWeight.w900,
                                          ),
                                    ),
                                    const SizedBox(height: 6),
                                    Wrap(
                                      spacing: 8,
                                      runSpacing: 6,
                                      children: [
                                        _DeckStatusBadge(
                                          label: d.format,
                                          color: scheme.secondary,
                                        ),
                                        if (active)
                                          _DeckStatusBadge(
                                            label: 'ativo',
                                            color: scheme.primary,
                                          ),
                                        if (!complete)
                                          _DeckStatusBadge(
                                            label: 'faltam cartas',
                                            color: scheme.error,
                                          ),
                                      ],
                                    ),
                                    const SizedBox(height: 10),
                                    ClipRRect(
                                      borderRadius: BorderRadius.circular(999),
                                      child: LinearProgressIndicator(
                                        minHeight: 7,
                                        value: complete ? 1 : 0.72,
                                        color: complete
                                            ? scheme.primary
                                            : scheme.error,
                                        backgroundColor: scheme
                                            .surfaceContainerLow
                                            .withValues(alpha: 0.82),
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                              const SizedBox(width: 10),
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
                            border: Border.all(
                              color: scheme.primary.withValues(alpha: 0.55),
                            ),
                            boxShadow: [
                              BoxShadow(
                                color: scheme.primary.withValues(alpha: 0.18),
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
          ),
        ],
      ),
    );
  }
}

class _DeckOverview extends StatelessWidget {
  const _DeckOverview({
    required this.totalDecks,
    required this.activeDecks,
  });

  final int totalDecks;
  final int activeDecks;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ManaSurfaceCard(
      padding: const EdgeInsets.fromLTRB(16, 14, 16, 16),
      borderColor: scheme.secondary.withValues(alpha: 0.24),
      backgroundColor: scheme.surfaceContainer.withValues(alpha: 0.70),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            'Prioridade de decks',
            style: Theme.of(context).textTheme.titleMedium?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
          ),
          const SizedBox(height: 12),
          Row(
            children: [
              Expanded(
                child: _DeckOverviewMetric(
                  value: '$totalDecks',
                  label: 'listas',
                  color: scheme.secondary,
                ),
              ),
              const SizedBox(width: 10),
              Expanded(
                child: _DeckOverviewMetric(
                  value: '$activeDecks',
                  label: 'ativas',
                  color: scheme.primary,
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class _DeckOverviewMetric extends StatelessWidget {
  const _DeckOverviewMetric({
    required this.value,
    required this.label,
    required this.color,
  });

  final String value;
  final String label;
  final Color color;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
      decoration: BoxDecoration(
        color: color.withValues(alpha: 0.12),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(color: color.withValues(alpha: 0.28)),
      ),
      child: Row(
        children: [
          Text(
            value,
            style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                  fontWeight: FontWeight.w900,
                ),
          ),
          const SizedBox(width: 8),
          Expanded(
            child: Text(
              label,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: Theme.of(context).textTheme.labelMedium?.copyWith(
                    color: Theme.of(context).colorScheme.onSurfaceVariant,
                    fontWeight: FontWeight.w800,
                  ),
            ),
          ),
        ],
      ),
    );
  }
}

class _DeckArt extends StatelessWidget {
  const _DeckArt({
    required this.index,
    required this.active,
  });

  final int index;
  final bool active;

  @override
  Widget build(BuildContext context) {
    const palettes = [
      [Color(0xFFBD93F9), Color(0xFFFF79C6)],
      [Color(0xFF8BE9FD), Color(0xFF50FA7B)],
      [Color(0xFFFF5555), Color(0xFFF1FA8C)],
    ];
    final colors = palettes[index % palettes.length];
    return Container(
      width: 52,
      height: 66,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        gradient: LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
          colors: colors,
        ),
        border: Border.all(
          color: Colors.white.withValues(alpha: active ? 0.36 : 0.14),
        ),
        boxShadow: [
          if (active)
            BoxShadow(
              color: colors.first.withValues(alpha: 0.24),
              blurRadius: 20,
              offset: const Offset(0, 8),
            ),
        ],
      ),
      child: Align(
        alignment: Alignment.bottomRight,
        child: Padding(
          padding: const EdgeInsets.all(7),
          child: Icon(
            Icons.auto_awesome_rounded,
            color: Colors.white.withValues(alpha: 0.82),
            size: 18,
          ),
        ),
      ),
    );
  }
}

class _DeckStatusBadge extends StatelessWidget {
  const _DeckStatusBadge({
    required this.label,
    required this.color,
  });

  final String label;
  final Color color;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
      decoration: BoxDecoration(
        color: color.withValues(alpha: 0.14),
        borderRadius: BorderRadius.circular(999),
        border: Border.all(color: color.withValues(alpha: 0.30)),
      ),
      child: Text(
        label,
        maxLines: 1,
        overflow: TextOverflow.ellipsis,
        style: Theme.of(context).textTheme.labelSmall?.copyWith(
              color: color,
              fontWeight: FontWeight.w900,
              letterSpacing: 0,
            ),
      ),
    );
  }
}
