import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import '../../data/local/db/db_instance.dart';
import '../../data/local/db/daos/collection_dao.dart';
import '../../widgets/cached_card_thumbnail.dart';
import '../../widgets/mana_internal_app_bar.dart';
import '../../widgets/mana_chip.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';
import 'widgets/edit_collection_item_sheet.dart';

class CollectionDetailScreen extends StatefulWidget {
  const CollectionDetailScreen({
    super.key,
    required this.collectionId,
    required this.collectionName,
  });

  final String collectionId;
  final String collectionName;

  @override
  State<CollectionDetailScreen> createState() => _CollectionDetailScreenState();
}

class _CollectionDetailScreenState extends State<CollectionDetailScreen> {
  String _filter = '';

  Future<void> _openEditSheet(CollectionItemView row) async {
    await showModalBottomSheet<void>(
      context: context,
      isScrollControlled: true,
      showDragHandle: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => EditCollectionItemSheet(row: row),
    );
    if (mounted) setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: ManaInternalAppBar(title: widget.collectionName),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () async {
          await context.pushNamed(
            AppRoutes.addCard,
            pathParameters: {'collectionId': widget.collectionId},
          );
          if (mounted) setState(() {});
        },
        icon: const Icon(Icons.add_rounded),
        label: const Text('Adicionar carta'),
      ),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 8, 16, 100),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              decoration: const InputDecoration(
                hintText: 'Buscar na coleção por nome…',
                prefixIcon: Icon(Icons.search_rounded),
              ),
              onChanged: (v) => setState(() => _filter = v),
            ),
            const SizedBox(height: 12),
            Expanded(
              child: StreamBuilder<List<CollectionItemView>>(
                stream: appDb.collectionDao.watchCollectionItems(
                  collectionId: widget.collectionId,
                  cardNameFilter: _filter,
                ),
                builder: (context, snapshot) {
                  final items = snapshot.data ?? const [];
                  if (items.isEmpty) {
                    return const ManaEmptyState(
                      icon: Icons.style_outlined,
                      title: 'Sem cartas aqui',
                      subtitle: 'Adiciona cartas ou ajusta o filtro de nome.',
                    );
                  }

                  return ListView.separated(
                    itemCount: items.length,
                    separatorBuilder: (_, __) => const SizedBox(height: 10),
                    itemBuilder: (context, index) {
                      final row = items[index];
                      final p = row.printing;
                      final it = row.item;
                      final img = p.imageSmall;

                      return ManaSurfaceCard(
                        onTap: () => _openEditSheet(row),
                        padding: const EdgeInsets.all(12),
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            CachedCardThumbnail(
                              imageUrl: img,
                              width: 56,
                              height: 78,
                            ),
                            const SizedBox(width: 12),
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    p.name,
                                    style: Theme.of(context)
                                        .textTheme
                                        .titleSmall
                                        ?.copyWith(fontWeight: FontWeight.w700),
                                  ),
                                  const SizedBox(height: 6),
                                  Wrap(
                                    spacing: 6,
                                    runSpacing: 6,
                                    children: [
                                      ManaChip(
                                        label:
                                            '${p.setCode.toUpperCase()} · #${p.collectorNumber}',
                                        tone: ManaChipTone.blue,
                                      ),
                                      ManaChip(
                                        label: it.condition,
                                        tone: ManaChipTone.neutral,
                                      ),
                                      ManaChip(
                                        label: it.language,
                                        tone: ManaChipTone.neutral,
                                      ),
                                      if (it.isFoil)
                                        const ManaChip(
                                          label: 'FOIL',
                                          tone: ManaChipTone.gold,
                                        ),
                                    ],
                                  ),
                                ],
                              ),
                            ),
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.end,
                              children: [
                                Text(
                                  '×${it.quantity}',
                                  style: Theme.of(context)
                                      .textTheme
                                      .titleMedium
                                      ?.copyWith(fontWeight: FontWeight.w800),
                                ),
                                const SizedBox(height: 4),
                                Text(
                                  'Editar',
                                  style: Theme.of(context)
                                      .textTheme
                                      .labelSmall
                                      ?.copyWith(
                                        color: Theme.of(context)
                                            .colorScheme
                                            .primary,
                                        fontWeight: FontWeight.w600,
                                      ),
                                ),
                              ],
                            ),
                          ],
                        ),
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
  }
}
