import 'package:drift/drift.dart';

/// Cache local da Scryfall (não sincroniza)
class ScryfallPrintings extends Table {
  TextColumn get printingId => text()(); // Scryfall printing id (PK)
  TextColumn get oracleId => text()();

  TextColumn get name => text()();
  TextColumn get printedName => text().nullable()();
  TextColumn get language => text().nullable()();
  TextColumn get typeLine => text()();

  TextColumn get setCode => text()();
  TextColumn get setName => text()();
  TextColumn get collectorNumber => text()();

  DateTimeColumn get releasedAt => dateTime().nullable()();

  TextColumn get manaCost => text().nullable()();
  RealColumn get manaValue => real().nullable()();

  TextColumn get rarity => text().nullable()();

  TextColumn get imageSmall => text().nullable()();
  TextColumn get imageNormal => text().nullable()();
  TextColumn get imagePng => text().nullable()();

  /// JSON string do map de legalities.
  TextColumn get legalitiesJson => text().nullable()();

  DateTimeColumn get updatedAtCache => dateTime()();

  @override
  Set<Column> get primaryKey => {printingId};
}

/// Snapshots de preço (múltiplas fontes e moedas)
class PriceSnapshots extends Table {
  TextColumn get id => text()(); // UUID
  TextColumn get printingId => text()();

  /// Ex.: "scryfall_usd" (futuro: "ligamagic_brl")
  TextColumn get source => text()();

  /// "USD", "BRL"
  TextColumn get currency => text()();

  /// Valor em unidades menores: centavos (USD cents / BRL centavos)
  IntColumn get valueMinor => integer()();

  DateTimeColumn get retrievedAt => dateTime()();

  @override
  Set<Column> get primaryKey => {id};
}

class Collections extends Table {
  TextColumn get id => text()(); // UUID
  TextColumn get name => text()();

  DateTimeColumn get createdAt => dateTime()();
  DateTimeColumn get updatedAt => dateTime()();

  @override
  Set<Column> get primaryKey => {id};
}

class CollectionItems extends Table {
  TextColumn get id => text()(); // UUID
  TextColumn get collectionId => text()();

  // FK lógico para ScryfallPrintings.printingId
  TextColumn get printingId => text()();

  IntColumn get quantity => integer()();

  BoolColumn get isFoil => boolean().withDefault(const Constant(false))();

  // Enum textual: NM/SP/MP/HP/DMG
  TextColumn get condition => text()();

  // Idioma: EN/BR (default EN)
  TextColumn get language => text().withDefault(const Constant('EN'))();

  TextColumn get notes => text().nullable()();

  DateTimeColumn get createdAt => dateTime()();
  DateTimeColumn get updatedAt => dateTime()();

  @override
  Set<Column> get primaryKey => {id};
}

/// Decks (persistência mínima; cards do deck virão depois via DeckEntries).
class Decks extends Table {
  TextColumn get id => text()(); // UUID
  TextColumn get name => text()();

  /// Commander | Standard | Pauper | Modern | Other
  TextColumn get format => text()();

  /// Apenas 1 deck ativo por vez (reserva de cartas da coleção).
  BoolColumn get isActive => boolean().withDefault(const Constant(false))();

  DateTimeColumn get createdAt => dateTime()();
  DateTimeColumn get updatedAt => dateTime()();

  @override
  Set<Column> get primaryKey => {id};
}

/// Entradas do deck (cartas no deck).
///
/// Pensado para futuro:
/// - pode existir no deck mesmo sem estar na coleção (collectionItemId null)
/// - pode apontar para uma printing preferida (preferredPrintingId)
/// - ownedStatus e section permitem UX futura (main/side/commander etc.)
class DeckEntries extends Table {
  TextColumn get id => text()(); // UUID
  TextColumn get deckId => text()();

  TextColumn get oracleId => text()();

  /// ScryfallPrintings.printingId (nullable)
  TextColumn get preferredPrintingId => text().nullable()();

  /// CollectionItems.id (nullable) — vínculo opcional no futuro
  TextColumn get collectionItemId => text().nullable()();

  IntColumn get quantity => integer()();

  /// main | sideboard | commander | maybeboard (por agora, default main)
  TextColumn get section => text().withDefault(const Constant('main'))();

  /// owned | notOwned | linkedToCollection
  TextColumn get ownedStatus =>
      text().withDefault(const Constant('notOwned'))();

  DateTimeColumn get createdAt => dateTime()();
  DateTimeColumn get updatedAt => dateTime()();

  @override
  Set<Column> get primaryKey => {id};
}
