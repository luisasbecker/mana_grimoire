import 'package:drift/drift.dart';
import '../app_database.dart';
import '../tables.dart';

part 'collection_dao.g.dart';

class CollectionItemView {
  CollectionItemView({
    required this.item,
    required this.printing,
  });

  final CollectionItem item;
  final ScryfallPrinting printing;
}

@DriftAccessor(tables: [Collections, CollectionItems, ScryfallPrintings])
class CollectionDao extends DatabaseAccessor<AppDatabase>
    with _$CollectionDaoMixin {
  CollectionDao(super.db);

  // ---- Collections ----

  Stream<List<Collection>> watchCollections({String? nameFilter}) {
    final q = select(collections)
      ..orderBy([(t) => OrderingTerm.asc(t.name)]);
    if (nameFilter != null && nameFilter.trim().isNotEmpty) {
      q.where((t) => t.name.like('%${nameFilter.trim()}%'));
    }
    return q.watch();
  }

  Future<void> createCollection({
    required String id,
    required String name,
    required DateTime now,
  }) async {
    await into(collections).insert(
      CollectionsCompanion.insert(
        id: id,
        name: name,
        createdAt: now,
        updatedAt: now,
      ),
      mode: InsertMode.insertOrReplace,
    );
  }

  Future<List<Collection>> getCollectionsOnce() {
    return select(collections).get();
  }

  // ---- Items ----

  Stream<List<CollectionItemView>> watchCollectionItems({
    required String collectionId,
    String? cardNameFilter,
  }) {
    final items = select(collectionItems)
      ..where((t) => t.collectionId.equals(collectionId))
      ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]);

    final joinQ = items.join([
      innerJoin(
        scryfallPrintings,
        scryfallPrintings.printingId.equalsExp(collectionItems.printingId),
      ),
    ]);

    if (cardNameFilter != null && cardNameFilter.trim().isNotEmpty) {
      joinQ.where(scryfallPrintings.name.like('%${cardNameFilter.trim()}%'));
    }

    return joinQ.watch().map((rows) {
      return rows.map((r) {
        final item = r.readTable(collectionItems);
        final printing = r.readTable(scryfallPrintings);
        return CollectionItemView(item: item, printing: printing);
      }).toList();
    });
  }

  /// Agrega itens de todas as coleções (view computada, sem coleção “real”).
  Stream<List<CollectionItemView>> watchAllCollectionItems({
    String? cardNameFilter,
  }) {
    final items = select(collectionItems)
      ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]);

    final joinQ = items.join([
      innerJoin(
        scryfallPrintings,
        scryfallPrintings.printingId.equalsExp(collectionItems.printingId),
      ),
    ]);

    if (cardNameFilter != null && cardNameFilter.trim().isNotEmpty) {
      joinQ.where(scryfallPrintings.name.like('%${cardNameFilter.trim()}%'));
    }

    return joinQ.watch().map((rows) {
      return rows.map((r) {
        final item = r.readTable(collectionItems);
        final printing = r.readTable(scryfallPrintings);
        return CollectionItemView(item: item, printing: printing);
      }).toList();
    });
  }

  /// Se existir item com mesma (coleção + printing + foil + condition + language),
  /// incrementa quantity. Caso contrário, cria novo item.
  Future<void> addOrIncrementItem({
    required String itemId,
    required String collectionId,
    required String printingId,
    required int quantity,
    required bool isFoil,
    required String condition,
    required String language,
    String? notes,
    required DateTime now,
  }) async {
    await transaction(() async {
      final existing = await (select(collectionItems)
            ..where((t) =>
                t.collectionId.equals(collectionId) &
                t.printingId.equals(printingId) &
                t.isFoil.equals(isFoil) &
                t.condition.equals(condition) &
                t.language.equals(language)))
          .getSingleOrNull();

      if (existing != null) {
        final newQty = existing.quantity + quantity;
        if (newQty <= 0) {
          await (delete(collectionItems)
                ..where((t) => t.id.equals(existing.id)))
              .go();
          return;
        }

        await (update(collectionItems)..where((t) => t.id.equals(existing.id)))
            .write(
          CollectionItemsCompanion(
            quantity: Value(newQty),
            updatedAt: Value(now),
          ),
        );
        return;
      }

      if (quantity <= 0) return;

      await into(collectionItems).insert(
        CollectionItemsCompanion(
          id: Value(itemId),
          collectionId: Value(collectionId),
          printingId: Value(printingId),
          quantity: Value(quantity),
          isFoil: Value(isFoil),
          condition: Value(condition),
          language: Value(language),
          notes: Value(notes),
          createdAt: Value(now),
          updatedAt: Value(now),
        ),
      );
    });
  }

  /// Define quantidade absoluta. Se quantity <= 0 => remove item.
  Future<void> setQuantity({
    required String itemId,
    required int quantity,
    required DateTime now,
  }) async {
    await transaction(() async {
      if (quantity <= 0) {
        await (delete(collectionItems)..where((t) => t.id.equals(itemId))).go();
        return;
      }

      await (update(collectionItems)..where((t) => t.id.equals(itemId))).write(
        CollectionItemsCompanion(
          quantity: Value(quantity),
          updatedAt: Value(now),
        ),
      );
    });
  }

  /// Incrementa/diminui quantidade por delta. Se chegar <= 0 => remove.
  Future<void> changeQuantity({
    required String itemId,
    required int delta,
    required DateTime now,
  }) async {
    await transaction(() async {
      final current = await (select(collectionItems)
            ..where((t) => t.id.equals(itemId)))
          .getSingleOrNull();
      if (current == null) return;

      final newQty = current.quantity + delta;
      if (newQty <= 0) {
        await (delete(collectionItems)..where((t) => t.id.equals(itemId))).go();
        return;
      }

      await (update(collectionItems)..where((t) => t.id.equals(itemId))).write(
        CollectionItemsCompanion(
          quantity: Value(newQty),
          updatedAt: Value(now),
        ),
      );
    });
  }

  /// Atualiza um item existente, fazendo merge quando os atributos mudam para
  /// uma combinação já existente no banco.
  Future<void> updateItem({
    required String itemId,
    required int quantity,
    required bool isFoil,
    required String condition,
    required String language,
    String? notes,
    required DateTime now,
  }) async {
    await transaction(() async {
      final current = await (select(collectionItems)
            ..where((t) => t.id.equals(itemId)))
          .getSingleOrNull();
      if (current == null) return;

      if (quantity <= 0) {
        await (delete(collectionItems)..where((t) => t.id.equals(itemId))).go();
        return;
      }

      final target = await (select(collectionItems)
            ..where((t) =>
                t.id.equals(itemId).not() &
                t.collectionId.equals(current.collectionId) &
                t.printingId.equals(current.printingId) &
                t.isFoil.equals(isFoil) &
                t.condition.equals(condition) &
                t.language.equals(language)))
          .getSingleOrNull();

      if (target == null) {
        await (update(collectionItems)..where((t) => t.id.equals(itemId))).write(
          CollectionItemsCompanion(
            quantity: Value(quantity),
            isFoil: Value(isFoil),
            condition: Value(condition),
            language: Value(language),
            notes: Value(notes),
            updatedAt: Value(now),
          ),
        );
        return;
      }

      final mergedQty = target.quantity + quantity;
      await (update(collectionItems)..where((t) => t.id.equals(target.id))).write(
        CollectionItemsCompanion(
          quantity: Value(mergedQty),
          notes: Value(target.notes),
          updatedAt: Value(now),
        ),
      );

      await (delete(collectionItems)..where((t) => t.id.equals(itemId))).go();
    });
  }

  /// Atualiza atributos do item (foil/condition/language/notes) e faz MERGE se necessário:
  /// Se após a alteração já existir outro item equivalente (mesma coleção + printing + atributos),
  /// soma quantidades e remove o item original.
  Future<void> updateItemAttributesMerge({
    required String itemId,
    required bool isFoil,
    required String condition,
    required String language,
    String? notes,
    required DateTime now,
  }) async {
    await transaction(() async {
      final current = await (select(collectionItems)
            ..where((t) => t.id.equals(itemId)))
          .getSingleOrNull();

      if (current == null) return;

      // Procura item "alvo" equivalente (mesma chave), mas com id diferente
      final target = await (select(collectionItems)
            ..where((t) =>
                t.id.equals(itemId).not() &
                t.collectionId.equals(current.collectionId) &
                t.printingId.equals(current.printingId) &
                t.isFoil.equals(isFoil) &
                t.condition.equals(condition) &
                t.language.equals(language)))
          .getSingleOrNull();

      if (target == null) {
        // Apenas atualiza este item
        await (update(collectionItems)..where((t) => t.id.equals(itemId))).write(
          CollectionItemsCompanion(
            isFoil: Value(isFoil),
            condition: Value(condition),
            language: Value(language),
            notes: Value(notes),
            updatedAt: Value(now),
          ),
        );
        return;
      }

      // MERGE: soma quantidades no target e remove o current
      final mergedQty = target.quantity + current.quantity;

      await (update(collectionItems)..where((t) => t.id.equals(target.id)))
          .write(
        CollectionItemsCompanion(
          quantity: Value(mergedQty),
          notes: Value(target.notes), // mantém notes do alvo (decisão de MVP)
          updatedAt: Value(now),
        ),
      );

      await (delete(collectionItems)..where((t) => t.id.equals(current.id))).go();
    });
  }

  /// Troca o printing do item e faz MERGE se necessário (mesma regra, mas mudando printing).
  /// Útil quando o usuário escolheu edição errada.
  Future<void> changePrintingMerge({
    required String itemId,
    required String newPrintingId,
    required DateTime now,
  }) async {
    await transaction(() async {
      final current = await (select(collectionItems)
            ..where((t) => t.id.equals(itemId)))
          .getSingleOrNull();
      if (current == null) return;

      // Procura item equivalente ao "resultado" final (mesmos atributos, mas printing novo)
      final target = await (select(collectionItems)
            ..where((t) =>
                t.id.equals(itemId).not() &
                t.collectionId.equals(current.collectionId) &
                t.printingId.equals(newPrintingId) &
                t.isFoil.equals(current.isFoil) &
                t.condition.equals(current.condition) &
                t.language.equals(current.language)))
          .getSingleOrNull();

      if (target == null) {
        await (update(collectionItems)..where((t) => t.id.equals(itemId))).write(
          CollectionItemsCompanion(
            printingId: Value(newPrintingId),
            updatedAt: Value(now),
          ),
        );
        return;
      }

      // MERGE
      final mergedQty = target.quantity + current.quantity;

      await (update(collectionItems)..where((t) => t.id.equals(target.id)))
          .write(
        CollectionItemsCompanion(
          quantity: Value(mergedQty),
          updatedAt: Value(now),
        ),
      );

      await (delete(collectionItems)..where((t) => t.id.equals(current.id))).go();
    });
  }

  Future<void> deleteItem(String itemId) async {
    await (delete(collectionItems)..where((t) => t.id.equals(itemId))).go();
  }
}
