// ignore: unused_import
import 'package:intl/intl.dart' as intl;
import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for English (`en`).
class AppLocalizationsEn extends AppLocalizations {
  AppLocalizationsEn([String locale = 'en']) : super(locale);

  @override
  String get navCollection => 'Collection';

  @override
  String get navScan => 'Scan';

  @override
  String get navHome => 'Home';

  @override
  String get navChat => 'Chat';

  @override
  String get navPlay => 'Play';

  @override
  String get collectionHubTitle => 'Collection';

  @override
  String get collectionHubSubtitle => 'Your library';

  @override
  String get collectionHubMyCardsTitle => 'My Cards';

  @override
  String get collectionHubMyCardsSubtitle =>
      'Collections, scans, and printings';

  @override
  String get collectionHubDecksTitle => 'Decks';

  @override
  String get collectionHubDecksSubtitle => 'Build and manage your lists';

  @override
  String get cardsTitle => 'Cards';

  @override
  String get allCardsTitle => 'All Cards';

  @override
  String get allCardsSubtitle => 'Across all collections';

  @override
  String get allCardsSearchHint => 'Search across all collections…';

  @override
  String get allCardsEmptyTitle => 'No cards yet';

  @override
  String get allCardsEmptySubtitle =>
      'Add cards to any collection to see them here.';

  @override
  String get decksTitle => 'Decks';

  @override
  String get decksEmptyTitle => 'You don\'t have any decks yet';

  @override
  String get decksEmptySubtitle => 'Tap “Create Deck” to add your first one.';

  @override
  String get decksCreateCta => 'Create Deck';

  @override
  String get createDeckTitle => 'Create Deck';

  @override
  String get createDeckNameLabel => 'Deck name';

  @override
  String get createDeckNameHint => 'Ex.: Atraxa Superfriends';

  @override
  String get createDeckFormatLabel => 'Format';

  @override
  String get createDeckCreateButton => 'Create';

  @override
  String get createDeckNameRequired => 'Deck name is required.';

  @override
  String get deckEmptyTitle => 'Empty deck';

  @override
  String get deckEmptySubtitle => 'Coming soon: add cards to the deck.';

  @override
  String get deckEditCta => 'Edit deck';

  @override
  String get editDeckTitle => 'Edit deck';

  @override
  String get deckSaveCta => 'Save';

  @override
  String get addCardToDeckTitle => 'Add card';

  @override
  String get addCardToDeckSearchHint => 'Search Scryfall (ex.: Sol Ring)';

  @override
  String get addCardToDeckEmptyTitle => 'Search for a card';

  @override
  String get addCardToDeckEmptySubtitle => 'Type the card name above.';

  @override
  String get addCardToDeckNoResultsTitle => 'No visible results';

  @override
  String get addCardToDeckNoResultsSubtitle =>
      'Try a different term or check spelling.';

  @override
  String get addCardToDeckAdded => 'Card added to deck.';

  @override
  String get quantity => 'Quantity';

  @override
  String get options => 'Options';

  @override
  String get advancedOptions => 'Advanced options';

  @override
  String get changePrinting => 'Change printing';

  @override
  String get remove => 'Remove';

  @override
  String get cancel => 'Cancel';

  @override
  String get error => 'Error';

  @override
  String get deckCardRemoveTitle => 'Remove card from deck';

  @override
  String get deckCardRemoveBody => 'Remove this card from the deck?';

  @override
  String get connectToCollectionTitle => 'Collection';

  @override
  String get connectToCollectionAddOption =>
      'Add this card to one of my collections';

  @override
  String get connectToCollectionLinkOption =>
      'Link to an existing card in my collection';

  @override
  String get connectToCollectionLinkOptionSubtitle => 'Coming soon';

  @override
  String get connectToCollectionLinkComingSoon =>
      'Linking to collection coming soon.';

  @override
  String get pickCollectionTitle => 'Pick a collection';

  @override
  String get pickCollectionEmpty => 'You don\'t have any collections yet.';

  @override
  String get pickEditionFirst => 'Pick an edition first (Change printing).';

  @override
  String get deleteDeckCta => 'Delete deck';

  @override
  String get deleteDeckTitle => 'Delete deck';

  @override
  String get deleteDeckBody =>
      'Are you sure you want to delete this deck? This action can\'t be undone.';

  @override
  String get deckImportCta => 'Import Deck';

  @override
  String get deckImportTitle => 'Import Deck';

  @override
  String get deckImportHint => '1 Sol Ring\n1 Arcane Signet\n15 Forest\n...';

  @override
  String get deckImportEmptyInput => 'Paste a deck text to import.';

  @override
  String deckImportProgress(Object processed, Object total) {
    return 'Processing $processed of $total…';
  }

  @override
  String get deckImportFailedLinesTitle => 'Problem lines';

  @override
  String deckImportResultSummary(Object imported, Object notFound) {
    return 'Imported: $imported cards • Not found: $notFound';
  }

  @override
  String get deckExportCta => 'Export Deck';

  @override
  String get deckExportTitle => 'Export Deck';

  @override
  String get deckExportEmpty => 'This deck is empty.';

  @override
  String get deckExportCopyCta => 'Copy text';

  @override
  String get deckExportCopied => 'Text copied.';

  @override
  String get deckPreviewHint => 'Swipe for more cards • Tap for details';

  @override
  String get confirm => 'Confirm';

  @override
  String get activateDeckTitle => 'Activate Deck';

  @override
  String activateDeckBody(Object activeDeckName) {
    return 'To activate this deck, the following cards will need to be moved from $activeDeckName:';
  }

  @override
  String get deckActivationMissingCards => 'Missing cards in your collection';

  @override
  String get activeDeckPickerTitle => 'Active deck';

  @override
  String get activeDeckNone => 'No active deck';

  @override
  String deckCardsCount(Object count) {
    return '$count cards in deck';
  }

  @override
  String get deckTypePlaneswalkers => 'Planeswalkers';

  @override
  String get deckTypeCreatures => 'Creatures';

  @override
  String get deckTypeInstants => 'Instants';

  @override
  String get deckTypeSorceries => 'Sorceries';

  @override
  String get deckTypeEnchantments => 'Enchantments';

  @override
  String get deckTypeArtifacts => 'Artifacts';

  @override
  String get deckTypeLands => 'Lands';

  @override
  String get deckTypeOther => 'Other';

  @override
  String get deckTypeCommander => 'Commander';

  @override
  String get commandersTitle => 'Commander(s)';

  @override
  String get setCommanderCta => 'Set';

  @override
  String get noCommanderSelected => 'No commander set.';

  @override
  String get pickCommanderTitle => 'Pick commander';

  @override
  String get pickCommanderHint => 'Search Scryfall (ex.: Atraxa)';

  @override
  String get pickCommanderEmptyTitle => 'Search for a card';

  @override
  String get pickCommanderEmptySubtitle => 'Type the name above.';

  @override
  String get pickCommanderNoResultsTitle => 'No visible results';

  @override
  String get pickCommanderNoResultsSubtitle =>
      'Try a different term or check spelling.';

  @override
  String get commanderMaxReached =>
      'You already have 2 commanders in this deck.';

  @override
  String get deckToCollectionCta => 'Add deck to collection';

  @override
  String get deckToCollectionTitle => 'Add deck to collection';

  @override
  String get newCollectionCta => 'Create new collection';

  @override
  String get newCollectionTitle => 'New collection';

  @override
  String get newCollectionNameLabel => 'Name';

  @override
  String get newCollectionNameHint => 'Ex.: Binder, Trade, Staples';

  @override
  String get newCollectionNameRequired => 'Collection name is required.';

  @override
  String get collectionsEmptyTitle => 'You don\'t have any collections yet';

  @override
  String get collectionsEmptySubtitle =>
      'Tap “New collection” to create your first one.';

  @override
  String get retry => 'Retry';

  @override
  String get selectPrintingTitle => 'Select printing';

  @override
  String get selectPrintingInvalidNavigation =>
      'Invalid navigation for printing selection.';

  @override
  String get selectPrintingEmpty => 'No printings found.';

  @override
  String get selectPrintingLimitedHint =>
      'List limited for performance. Use a more specific search if you need a rare printing.';

  @override
  String get selectPrintingLoadMore => 'Load more printings';

  @override
  String get playPlayerOneLabel => 'Player 1';

  @override
  String get playPlayerTwoLabel => 'Player 2';

  @override
  String get playGrimoireTitle => 'Grimoire';

  @override
  String get playGoHomeCta => 'Go to Home';

  @override
  String get create => 'Create';

  @override
  String deckToCollectionResult(Object added, Object skipped) {
    return 'Added: $added cards • Skipped: $skipped';
  }
}
