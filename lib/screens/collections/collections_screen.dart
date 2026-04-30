import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:uuid/uuid.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';

class CollectionsScreen extends StatefulWidget {
  const CollectionsScreen({super.key});

  @override
  State<CollectionsScreen> createState() => _CollectionsScreenState();
}

class _CollectionsScreenState extends State<CollectionsScreen> {
  final _uuid = const Uuid();

  Future<void> _createCollectionDialog() async {
    final controller = TextEditingController();
    final t = AppLocalizations.of(context)!;
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

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final t = AppLocalizations.of(context)!;

    return Scaffold(
      appBar: ManaInternalAppBar(title: t.cardsTitle),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: _createCollectionDialog,
        icon: const Icon(Icons.add_rounded),
        label: Text(t.newCollectionTitle),
      ),
      body: StreamBuilder(
        stream: appDb.collectionDao.watchCollections(),
        builder: (context, snapshot) {
          final collections = snapshot.data ?? const [];
          if (collections.isEmpty) {
            return ManaEmptyState(
              icon: Icons.folder_special_outlined,
              title: t.collectionsEmptyTitle,
              subtitle: t.collectionsEmptySubtitle,
            );
          }

          final showAllCards = collections.length >= 2;
          final totalRows = collections.length + (showAllCards ? 1 : 0);

          return ListView.separated(
            padding: const EdgeInsets.fromLTRB(16, 8, 16, 100),
            itemCount: totalRows,
            separatorBuilder: (_, __) => const SizedBox(height: 10),
            itemBuilder: (context, index) {
              if (showAllCards && index == 0) {
                return ManaSurfaceCard(
                  onTap: () => context.pushNamed(AppRoutes.allCards),
                  padding:
                      const EdgeInsets.symmetric(horizontal: 14, vertical: 12),
                  child: Row(
                    children: [
                      Container(
                        width: 48,
                        height: 48,
                        decoration: BoxDecoration(
                          color: scheme.tertiary.withOpacity(0.18),
                          borderRadius: BorderRadius.circular(12),
                        ),
                        child: Icon(
                          Icons.auto_awesome_rounded,
                          color: scheme.tertiary,
                        ),
                      ),
                      const SizedBox(width: 14),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              t.allCardsTitle,
                              style: Theme.of(context)
                                  .textTheme
                                  .titleMedium
                                  ?.copyWith(fontWeight: FontWeight.w800),
                            ),
                            const SizedBox(height: 2),
                            Text(
                              t.allCardsSubtitle,
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
                      Icon(
                        Icons.chevron_right_rounded,
                        color: scheme.onSurfaceVariant,
                      ),
                    ],
                  ),
                );
              }

              final collectionIndex = index - (showAllCards ? 1 : 0);
              final c = collections[collectionIndex];
              return ManaSurfaceCard(
                onTap: () {
                  context.pushNamed(
                    AppRoutes.collectionDetail,
                    pathParameters: {'collectionId': c.id},
                    extra: c.name,
                  );
                },
                padding:
                    const EdgeInsets.symmetric(horizontal: 14, vertical: 12),
                child: Row(
                  children: [
                    Container(
                      width: 48,
                      height: 48,
                      decoration: BoxDecoration(
                        color: scheme.primary.withOpacity(0.18),
                        borderRadius: BorderRadius.circular(12),
                      ),
                      child: Icon(
                        Icons.folder_special_rounded,
                        color: scheme.primary,
                      ),
                    ),
                    const SizedBox(width: 14),
                    Expanded(
                      child: Text(
                        c.name,
                        style:
                            Theme.of(context).textTheme.titleMedium?.copyWith(
                                  fontWeight: FontWeight.w600,
                                ),
                      ),
                    ),
                    Icon(Icons.chevron_right_rounded,
                        color: scheme.onSurfaceVariant),
                  ],
                ),
              );
            },
          );
        },
      ),
    );
  }
}
