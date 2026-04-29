import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for Spanish Castilian (`es`).
class AppLocalizationsEs extends AppLocalizations {
  AppLocalizationsEs([String locale = 'es']) : super(locale);

  @override
  String get navCollection => 'Colección';

  @override
  String get navScan => 'Scan';

  @override
  String get navHome => 'Inicio';

  @override
  String get navChat => 'Chat';

  @override
  String get navPlay => 'Jugar';

  @override
  String get collectionHubTitle => 'Colección';

  @override
  String get collectionHubSubtitle => 'Tu biblioteca';

  @override
  String get collectionHubMyCardsTitle => 'Mis cartas';

  @override
  String get collectionHubMyCardsSubtitle => 'Colecciones, escaneos y ediciones';

  @override
  String get collectionHubDecksTitle => 'Mazos';

  @override
  String get collectionHubDecksSubtitle => 'Crea y gestiona tus listas';

  @override
  String get cardsTitle => 'Cartas';

  @override
  String get allCardsTitle => 'Todas las cartas';

  @override
  String get allCardsSubtitle => 'De todas las colecciones';

  @override
  String get allCardsSearchHint => 'Buscar en todas las colecciones…';

  @override
  String get allCardsEmptyTitle => 'Aún no hay cartas';

  @override
  String get allCardsEmptySubtitle => 'Añade cartas a cualquier colección para verlas aquí.';

  @override
  String get decksTitle => 'Mazos';

  @override
  String get decksEmptyTitle => 'Aún no tienes mazos';

  @override
  String get decksEmptySubtitle => 'Toca “Crear mazo” para añadir el primero.';

  @override
  String get decksCreateCta => 'Crear mazo';

  @override
  String get createDeckTitle => 'Crear mazo';

  @override
  String get createDeckNameLabel => 'Nombre del mazo';

  @override
  String get createDeckNameHint => 'Ej.: Atraxa Superfriends';

  @override
  String get createDeckFormatLabel => 'Formato';

  @override
  String get createDeckCreateButton => 'Crear';

  @override
  String get createDeckNameRequired => 'El nombre del mazo es obligatorio.';

  @override
  String get deckEmptyTitle => 'Mazo vacío';

  @override
  String get deckEmptySubtitle => 'Próximamente: añadir cartas al mazo.';

  @override
  String get deckEditCta => 'Editar mazo';

  @override
  String get editDeckTitle => 'Editar mazo';

  @override
  String get deckSaveCta => 'Guardar';

  @override
  String get addCardToDeckTitle => 'Añadir carta';

  @override
  String get addCardToDeckSearchHint => 'Buscar en Scryfall (ej.: Sol Ring)';

  @override
  String get addCardToDeckEmptyTitle => 'Busca una carta';

  @override
  String get addCardToDeckEmptySubtitle => 'Escribe el nombre de la carta arriba.';

  @override
  String get addCardToDeckNoResultsTitle => 'Sin resultados visibles';

  @override
  String get addCardToDeckNoResultsSubtitle => 'Prueba otro término o revisa la ortografía.';

  @override
  String get addCardToDeckAdded => 'Carta añadida al mazo.';

  @override
  String get quantity => 'Cantidad';

  @override
  String get options => 'Opciones';

  @override
  String get advancedOptions => 'Opciones avanzadas';

  @override
  String get changePrinting => 'Cambiar edición';

  @override
  String get remove => 'Eliminar';

  @override
  String get cancel => 'Cancelar';

  @override
  String get error => 'Error';

  @override
  String get deckCardRemoveTitle => 'Eliminar carta del mazo';

  @override
  String get deckCardRemoveBody => '¿Eliminar esta carta del mazo?';

  @override
  String get connectToCollectionTitle => 'Colección';

  @override
  String get connectToCollectionAddOption => 'Añadir esta carta a una de mis colecciones';

  @override
  String get connectToCollectionLinkOption => 'Vincular a una carta existente en mi colección';

  @override
  String get connectToCollectionLinkOptionSubtitle => 'Próximamente';

  @override
  String get connectToCollectionLinkComingSoon => 'Vinculación con colección próximamente.';

  @override
  String get pickCollectionTitle => 'Elegir colección';

  @override
  String get pickCollectionEmpty => 'Aún no tienes colecciones.';

  @override
  String get pickEditionFirst => 'Elige una edición primero (Cambiar edición).';

  @override
  String get deleteDeckCta => 'Eliminar mazo';

  @override
  String get deleteDeckTitle => 'Eliminar mazo';

  @override
  String get deleteDeckBody => '¿Seguro que quieres eliminar este mazo? Esta acción no se puede deshacer.';

  @override
  String get deckImportCta => 'Importar mazo';

  @override
  String get deckImportTitle => 'Importar mazo';

  @override
  String get deckImportHint => '1 Sol Ring\n1 Arcane Signet\n15 Forest\n...';

  @override
  String get deckImportEmptyInput => 'Pega un texto de mazo para importar.';

  @override
  String deckImportProgress(Object processed, Object total) {
    return 'Procesando $processed de $total…';
  }

  @override
  String get deckImportFailedLinesTitle => 'Líneas con problema';

  @override
  String deckImportResultSummary(Object imported, Object notFound) {
    return 'Importado: $imported cartas • No encontradas: $notFound';
  }

  @override
  String get deckExportCta => 'Exportar mazo';

  @override
  String get deckExportTitle => 'Exportar mazo';

  @override
  String get deckExportEmpty => 'Este mazo está vacío.';

  @override
  String get deckExportCopyCta => 'Copiar texto';

  @override
  String get deckExportCopied => 'Texto copiado.';

  @override
  String get deckPreviewHint => 'Desliza para ver más cartas • Toca para detalles';

  @override
  String get confirm => 'Confirmar';

  @override
  String get activateDeckTitle => 'Activar mazo';

  @override
  String activateDeckBody(Object activeDeckName) {
    return 'Para activar este mazo, las siguientes cartas deberán moverse desde $activeDeckName:';
  }

  @override
  String get deckActivationMissingCards => 'Faltan cartas en tu colección';

  @override
  String get activeDeckPickerTitle => 'Mazo activo';

  @override
  String get activeDeckNone => 'Ningún mazo activo';

  @override
  String deckCardsCount(Object count) {
    return '$count cartas en el mazo';
  }

  @override
  String get deckTypePlaneswalkers => 'Planeswalkers';

  @override
  String get deckTypeCreatures => 'Criaturas';

  @override
  String get deckTypeInstants => 'Instantáneos';

  @override
  String get deckTypeSorceries => 'Conjuros';

  @override
  String get deckTypeEnchantments => 'Encantamientos';

  @override
  String get deckTypeArtifacts => 'Artefactos';

  @override
  String get deckTypeLands => 'Tierras';

  @override
  String get deckTypeOther => 'Otros';

  @override
  String get deckTypeCommander => 'Commander';

  @override
  String get commandersTitle => 'Comandante(s)';

  @override
  String get setCommanderCta => 'Definir';

  @override
  String get noCommanderSelected => 'Sin comandante definido.';

  @override
  String get pickCommanderTitle => 'Elegir comandante';

  @override
  String get pickCommanderHint => 'Buscar en Scryfall (ej.: Atraxa)';

  @override
  String get pickCommanderEmptyTitle => 'Busca una carta';

  @override
  String get pickCommanderEmptySubtitle => 'Escribe el nombre arriba.';

  @override
  String get pickCommanderNoResultsTitle => 'Sin resultados visibles';

  @override
  String get pickCommanderNoResultsSubtitle => 'Prueba otro término o revisa la ortografía.';

  @override
  String get commanderMaxReached => 'Ya tienes 2 comandantes en este mazo.';

  @override
  String get deckToCollectionCta => 'Añadir mazo a la colección';

  @override
  String get deckToCollectionTitle => 'Añadir mazo a la colección';

  @override
  String get newCollectionCta => 'Crear nueva colección';

  @override
  String get newCollectionTitle => 'Nueva colección';

  @override
  String get newCollectionNameLabel => 'Nombre';

  @override
  String get newCollectionNameHint => 'Ej.: Binder, Trade, Staples';

  @override
  String get collectionsEmptyTitle => 'Aún no tienes colecciones';

  @override
  String get collectionsEmptySubtitle => 'Toca “Nueva colección” para crear la primera.';

  @override
  String get retry => 'Reintentar';

  @override
  String get selectPrintingTitle => 'Seleccionar edición';

  @override
  String get selectPrintingInvalidNavigation => 'Navegación inválida para seleccionar edición.';

  @override
  String get selectPrintingEmpty => 'No se encontraron ediciones.';

  @override
  String get selectPrintingLimitedHint => 'Lista limitada por rendimiento. Usa una búsqueda más específica si necesitas una edición rara.';

  @override
  String get selectPrintingLoadMore => 'Cargar más ediciones';

  @override
  String get playPlayerOneLabel => 'Jugador 1';

  @override
  String get playPlayerTwoLabel => 'Jugador 2';

  @override
  String get playGrimoireTitle => 'Grimorio';

  @override
  String get playGoHomeCta => 'Ir a inicio';

  @override
  String get create => 'Crear';

  @override
  String deckToCollectionResult(Object added, Object skipped) {
    return 'Añadido: $added cartas • Omitidas: $skipped';
  }
}
