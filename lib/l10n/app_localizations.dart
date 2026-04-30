import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:intl/intl.dart' as intl;

import 'app_localizations_en.dart';
import 'app_localizations_es.dart';
import 'app_localizations_pt.dart';

// ignore_for_file: type=lint

/// Callers can lookup localized strings with an instance of AppLocalizations
/// returned by `AppLocalizations.of(context)`.
///
/// Applications need to include `AppLocalizations.delegate()` in their app's
/// `localizationDelegates` list, and the locales they support in the app's
/// `supportedLocales` list. For example:
///
/// ```dart
/// import 'l10n/app_localizations.dart';
///
/// return MaterialApp(
///   localizationsDelegates: AppLocalizations.localizationsDelegates,
///   supportedLocales: AppLocalizations.supportedLocales,
///   home: MyApplicationHome(),
/// );
/// ```
///
/// ## Update pubspec.yaml
///
/// Please make sure to update your pubspec.yaml to include the following
/// packages:
///
/// ```yaml
/// dependencies:
///   # Internationalization support.
///   flutter_localizations:
///     sdk: flutter
///   intl: any # Use the pinned version from flutter_localizations
///
///   # Rest of dependencies
/// ```
///
/// ## iOS Applications
///
/// iOS applications define key application metadata, including supported
/// locales, in an Info.plist file that is built into the application bundle.
/// To configure the locales supported by your app, you’ll need to edit this
/// file.
///
/// First, open your project’s ios/Runner.xcworkspace Xcode workspace file.
/// Then, in the Project Navigator, open the Info.plist file under the Runner
/// project’s Runner folder.
///
/// Next, select the Information Property List item, select Add Item from the
/// Editor menu, then select Localizations from the pop-up menu.
///
/// Select and expand the newly-created Localizations item then, for each
/// locale your application supports, add a new item and select the locale
/// you wish to add from the pop-up menu in the Value field. This list should
/// be consistent with the languages listed in the AppLocalizations.supportedLocales
/// property.
abstract class AppLocalizations {
  AppLocalizations(String locale)
      : localeName = intl.Intl.canonicalizedLocale(locale.toString());

  final String localeName;

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  static const LocalizationsDelegate<AppLocalizations> delegate =
      _AppLocalizationsDelegate();

  /// A list of this localizations delegate along with the default localizations
  /// delegates.
  ///
  /// Returns a list of localizations delegates containing this delegate along with
  /// GlobalMaterialLocalizations.delegate, GlobalCupertinoLocalizations.delegate,
  /// and GlobalWidgetsLocalizations.delegate.
  ///
  /// Additional delegates can be added by appending to this list in
  /// MaterialApp. This list does not have to be used at all if a custom list
  /// of delegates is preferred or required.
  static const List<LocalizationsDelegate<dynamic>> localizationsDelegates =
      <LocalizationsDelegate<dynamic>>[
    delegate,
    GlobalMaterialLocalizations.delegate,
    GlobalCupertinoLocalizations.delegate,
    GlobalWidgetsLocalizations.delegate,
  ];

  /// A list of this localizations delegate's supported locales.
  static const List<Locale> supportedLocales = <Locale>[
    Locale('en'),
    Locale('es'),
    Locale('pt')
  ];

  /// No description provided for @navCollection.
  ///
  /// In pt, this message translates to:
  /// **'Coleção'**
  String get navCollection;

  /// No description provided for @navScan.
  ///
  /// In pt, this message translates to:
  /// **'Scan'**
  String get navScan;

  /// No description provided for @navHome.
  ///
  /// In pt, this message translates to:
  /// **'Início'**
  String get navHome;

  /// No description provided for @navChat.
  ///
  /// In pt, this message translates to:
  /// **'Chat'**
  String get navChat;

  /// No description provided for @navPlay.
  ///
  /// In pt, this message translates to:
  /// **'Jogar'**
  String get navPlay;

  /// No description provided for @collectionHubTitle.
  ///
  /// In pt, this message translates to:
  /// **'Coleção'**
  String get collectionHubTitle;

  /// No description provided for @collectionHubSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'A tua biblioteca'**
  String get collectionHubSubtitle;

  /// No description provided for @collectionHubMyCardsTitle.
  ///
  /// In pt, this message translates to:
  /// **'Minhas cartas'**
  String get collectionHubMyCardsTitle;

  /// No description provided for @collectionHubMyCardsSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Coleções, scans e edições'**
  String get collectionHubMyCardsSubtitle;

  /// No description provided for @collectionHubDecksTitle.
  ///
  /// In pt, this message translates to:
  /// **'Decks'**
  String get collectionHubDecksTitle;

  /// No description provided for @collectionHubDecksSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Cria e gerencia as tuas listas'**
  String get collectionHubDecksSubtitle;

  /// No description provided for @cardsTitle.
  ///
  /// In pt, this message translates to:
  /// **'Cartas'**
  String get cardsTitle;

  /// No description provided for @allCardsTitle.
  ///
  /// In pt, this message translates to:
  /// **'Todas as cartas'**
  String get allCardsTitle;

  /// No description provided for @allCardsSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'De todas as coleções'**
  String get allCardsSubtitle;

  /// No description provided for @allCardsSearchHint.
  ///
  /// In pt, this message translates to:
  /// **'Buscar em todas as coleções…'**
  String get allCardsSearchHint;

  /// No description provided for @allCardsEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Ainda não há cartas'**
  String get allCardsEmptyTitle;

  /// No description provided for @allCardsEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Adiciona cartas a qualquer coleção para vê-las aqui.'**
  String get allCardsEmptySubtitle;

  /// No description provided for @decksTitle.
  ///
  /// In pt, this message translates to:
  /// **'Decks'**
  String get decksTitle;

  /// No description provided for @decksEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Ainda não tens decks'**
  String get decksEmptyTitle;

  /// No description provided for @decksEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Toca em “Criar deck” para adicionar o primeiro.'**
  String get decksEmptySubtitle;

  /// No description provided for @decksCreateCta.
  ///
  /// In pt, this message translates to:
  /// **'Criar deck'**
  String get decksCreateCta;

  /// No description provided for @createDeckTitle.
  ///
  /// In pt, this message translates to:
  /// **'Criar deck'**
  String get createDeckTitle;

  /// No description provided for @createDeckNameLabel.
  ///
  /// In pt, this message translates to:
  /// **'Nome do deck'**
  String get createDeckNameLabel;

  /// No description provided for @createDeckNameHint.
  ///
  /// In pt, this message translates to:
  /// **'Ex.: Atraxa Superfriends'**
  String get createDeckNameHint;

  /// No description provided for @createDeckFormatLabel.
  ///
  /// In pt, this message translates to:
  /// **'Formato'**
  String get createDeckFormatLabel;

  /// No description provided for @createDeckCreateButton.
  ///
  /// In pt, this message translates to:
  /// **'Criar'**
  String get createDeckCreateButton;

  /// No description provided for @createDeckNameRequired.
  ///
  /// In pt, this message translates to:
  /// **'O nome do deck é obrigatório.'**
  String get createDeckNameRequired;

  /// No description provided for @deckEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Deck vazio'**
  String get deckEmptyTitle;

  /// No description provided for @deckEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Em breve: adicionar cartas ao deck.'**
  String get deckEmptySubtitle;

  /// No description provided for @deckEditCta.
  ///
  /// In pt, this message translates to:
  /// **'Editar deck'**
  String get deckEditCta;

  /// No description provided for @editDeckTitle.
  ///
  /// In pt, this message translates to:
  /// **'Editar deck'**
  String get editDeckTitle;

  /// No description provided for @deckSaveCta.
  ///
  /// In pt, this message translates to:
  /// **'Salvar'**
  String get deckSaveCta;

  /// No description provided for @addCardToDeckTitle.
  ///
  /// In pt, this message translates to:
  /// **'Adicionar carta'**
  String get addCardToDeckTitle;

  /// No description provided for @addCardToDeckSearchHint.
  ///
  /// In pt, this message translates to:
  /// **'Buscar na Scryfall (ex.: Sol Ring)'**
  String get addCardToDeckSearchHint;

  /// No description provided for @addCardToDeckEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Procura uma carta'**
  String get addCardToDeckEmptyTitle;

  /// No description provided for @addCardToDeckEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Escreve o nome da carta acima.'**
  String get addCardToDeckEmptySubtitle;

  /// No description provided for @addCardToDeckNoResultsTitle.
  ///
  /// In pt, this message translates to:
  /// **'Sem resultados visíveis'**
  String get addCardToDeckNoResultsTitle;

  /// No description provided for @addCardToDeckNoResultsSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Tenta outro termo ou verifica a grafia.'**
  String get addCardToDeckNoResultsSubtitle;

  /// No description provided for @addCardToDeckAdded.
  ///
  /// In pt, this message translates to:
  /// **'Carta adicionada ao deck.'**
  String get addCardToDeckAdded;

  /// No description provided for @quantity.
  ///
  /// In pt, this message translates to:
  /// **'Quantidade'**
  String get quantity;

  /// No description provided for @options.
  ///
  /// In pt, this message translates to:
  /// **'Opções'**
  String get options;

  /// No description provided for @advancedOptions.
  ///
  /// In pt, this message translates to:
  /// **'Opções avançadas'**
  String get advancedOptions;

  /// No description provided for @changePrinting.
  ///
  /// In pt, this message translates to:
  /// **'Trocar edição'**
  String get changePrinting;

  /// No description provided for @remove.
  ///
  /// In pt, this message translates to:
  /// **'Remover'**
  String get remove;

  /// No description provided for @cancel.
  ///
  /// In pt, this message translates to:
  /// **'Cancelar'**
  String get cancel;

  /// No description provided for @error.
  ///
  /// In pt, this message translates to:
  /// **'Erro'**
  String get error;

  /// No description provided for @deckCardRemoveTitle.
  ///
  /// In pt, this message translates to:
  /// **'Remover carta do deck'**
  String get deckCardRemoveTitle;

  /// No description provided for @deckCardRemoveBody.
  ///
  /// In pt, this message translates to:
  /// **'Deseja remover esta carta do deck?'**
  String get deckCardRemoveBody;

  /// No description provided for @connectToCollectionTitle.
  ///
  /// In pt, this message translates to:
  /// **'Coleção'**
  String get connectToCollectionTitle;

  /// No description provided for @connectToCollectionAddOption.
  ///
  /// In pt, this message translates to:
  /// **'Adicionar esta carta a uma das minhas coleções'**
  String get connectToCollectionAddOption;

  /// No description provided for @connectToCollectionLinkOption.
  ///
  /// In pt, this message translates to:
  /// **'Vincular a uma carta existente na minha coleção'**
  String get connectToCollectionLinkOption;

  /// No description provided for @connectToCollectionLinkOptionSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Em breve'**
  String get connectToCollectionLinkOptionSubtitle;

  /// No description provided for @connectToCollectionLinkComingSoon.
  ///
  /// In pt, this message translates to:
  /// **'Vínculo com coleção em breve.'**
  String get connectToCollectionLinkComingSoon;

  /// No description provided for @pickCollectionTitle.
  ///
  /// In pt, this message translates to:
  /// **'Escolher coleção'**
  String get pickCollectionTitle;

  /// No description provided for @pickCollectionEmpty.
  ///
  /// In pt, this message translates to:
  /// **'Ainda não tens coleções.'**
  String get pickCollectionEmpty;

  /// No description provided for @pickEditionFirst.
  ///
  /// In pt, this message translates to:
  /// **'Escolhe uma edição primeiro (Trocar edição).'**
  String get pickEditionFirst;

  /// No description provided for @deleteDeckCta.
  ///
  /// In pt, this message translates to:
  /// **'Excluir deck'**
  String get deleteDeckCta;

  /// No description provided for @deleteDeckTitle.
  ///
  /// In pt, this message translates to:
  /// **'Excluir deck'**
  String get deleteDeckTitle;

  /// No description provided for @deleteDeckBody.
  ///
  /// In pt, this message translates to:
  /// **'Tem certeza que deseja excluir este deck? Esta ação não pode ser desfeita.'**
  String get deleteDeckBody;

  /// No description provided for @deckImportCta.
  ///
  /// In pt, this message translates to:
  /// **'Importar deck'**
  String get deckImportCta;

  /// No description provided for @deckImportTitle.
  ///
  /// In pt, this message translates to:
  /// **'Importar deck'**
  String get deckImportTitle;

  /// No description provided for @deckImportHint.
  ///
  /// In pt, this message translates to:
  /// **'1 Sol Ring\n1 Arcane Signet\n15 Forest\n...'**
  String get deckImportHint;

  /// No description provided for @deckImportEmptyInput.
  ///
  /// In pt, this message translates to:
  /// **'Cole um texto de deck para importar.'**
  String get deckImportEmptyInput;

  /// No description provided for @deckImportProgress.
  ///
  /// In pt, this message translates to:
  /// **'Processando {processed} de {total}…'**
  String deckImportProgress(Object processed, Object total);

  /// No description provided for @deckImportFailedLinesTitle.
  ///
  /// In pt, this message translates to:
  /// **'Linhas com problema'**
  String get deckImportFailedLinesTitle;

  /// No description provided for @deckImportResultSummary.
  ///
  /// In pt, this message translates to:
  /// **'Importado: {imported} cartas • Não encontradas: {notFound}'**
  String deckImportResultSummary(Object imported, Object notFound);

  /// No description provided for @deckExportCta.
  ///
  /// In pt, this message translates to:
  /// **'Exportar deck'**
  String get deckExportCta;

  /// No description provided for @deckExportTitle.
  ///
  /// In pt, this message translates to:
  /// **'Exportar deck'**
  String get deckExportTitle;

  /// No description provided for @deckExportEmpty.
  ///
  /// In pt, this message translates to:
  /// **'Este deck está vazio.'**
  String get deckExportEmpty;

  /// No description provided for @deckExportCopyCta.
  ///
  /// In pt, this message translates to:
  /// **'Copiar texto'**
  String get deckExportCopyCta;

  /// No description provided for @deckExportCopied.
  ///
  /// In pt, this message translates to:
  /// **'Texto copiado.'**
  String get deckExportCopied;

  /// No description provided for @deckPreviewHint.
  ///
  /// In pt, this message translates to:
  /// **'Desliza para mais cartas • Toca para detalhes'**
  String get deckPreviewHint;

  /// No description provided for @confirm.
  ///
  /// In pt, this message translates to:
  /// **'Confirmar'**
  String get confirm;

  /// No description provided for @activateDeckTitle.
  ///
  /// In pt, this message translates to:
  /// **'Ativar deck'**
  String get activateDeckTitle;

  /// No description provided for @activateDeckBody.
  ///
  /// In pt, this message translates to:
  /// **'Para ativar este deck, as seguintes cartas precisam ser movidas de {activeDeckName}:'**
  String activateDeckBody(Object activeDeckName);

  /// No description provided for @deckActivationMissingCards.
  ///
  /// In pt, this message translates to:
  /// **'Faltam cartas na tua coleção'**
  String get deckActivationMissingCards;

  /// No description provided for @activeDeckPickerTitle.
  ///
  /// In pt, this message translates to:
  /// **'Deck ativo'**
  String get activeDeckPickerTitle;

  /// No description provided for @activeDeckNone.
  ///
  /// In pt, this message translates to:
  /// **'Nenhum deck ativo'**
  String get activeDeckNone;

  /// No description provided for @deckCardsCount.
  ///
  /// In pt, this message translates to:
  /// **'{count} cartas no deck'**
  String deckCardsCount(Object count);

  /// No description provided for @deckTypePlaneswalkers.
  ///
  /// In pt, this message translates to:
  /// **'Planeswalkers'**
  String get deckTypePlaneswalkers;

  /// No description provided for @deckTypeCreatures.
  ///
  /// In pt, this message translates to:
  /// **'Criaturas'**
  String get deckTypeCreatures;

  /// No description provided for @deckTypeInstants.
  ///
  /// In pt, this message translates to:
  /// **'Instantâneas'**
  String get deckTypeInstants;

  /// No description provided for @deckTypeSorceries.
  ///
  /// In pt, this message translates to:
  /// **'Feitiços'**
  String get deckTypeSorceries;

  /// No description provided for @deckTypeEnchantments.
  ///
  /// In pt, this message translates to:
  /// **'Encantamentos'**
  String get deckTypeEnchantments;

  /// No description provided for @deckTypeArtifacts.
  ///
  /// In pt, this message translates to:
  /// **'Artefatos'**
  String get deckTypeArtifacts;

  /// No description provided for @deckTypeLands.
  ///
  /// In pt, this message translates to:
  /// **'Terrenos'**
  String get deckTypeLands;

  /// No description provided for @deckTypeOther.
  ///
  /// In pt, this message translates to:
  /// **'Outros'**
  String get deckTypeOther;

  /// No description provided for @deckTypeCommander.
  ///
  /// In pt, this message translates to:
  /// **'Commander'**
  String get deckTypeCommander;

  /// No description provided for @commandersTitle.
  ///
  /// In pt, this message translates to:
  /// **'Comandante(s)'**
  String get commandersTitle;

  /// No description provided for @setCommanderCta.
  ///
  /// In pt, this message translates to:
  /// **'Definir'**
  String get setCommanderCta;

  /// No description provided for @noCommanderSelected.
  ///
  /// In pt, this message translates to:
  /// **'Nenhum comandante definido.'**
  String get noCommanderSelected;

  /// No description provided for @pickCommanderTitle.
  ///
  /// In pt, this message translates to:
  /// **'Escolher comandante'**
  String get pickCommanderTitle;

  /// No description provided for @pickCommanderHint.
  ///
  /// In pt, this message translates to:
  /// **'Buscar na Scryfall (ex.: Atraxa)'**
  String get pickCommanderHint;

  /// No description provided for @pickCommanderEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Procura uma carta'**
  String get pickCommanderEmptyTitle;

  /// No description provided for @pickCommanderEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Escreve o nome acima.'**
  String get pickCommanderEmptySubtitle;

  /// No description provided for @pickCommanderNoResultsTitle.
  ///
  /// In pt, this message translates to:
  /// **'Sem resultados visíveis'**
  String get pickCommanderNoResultsTitle;

  /// No description provided for @pickCommanderNoResultsSubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Tenta outro termo ou verifica a grafia.'**
  String get pickCommanderNoResultsSubtitle;

  /// No description provided for @commanderMaxReached.
  ///
  /// In pt, this message translates to:
  /// **'Já tens 2 comandantes neste deck.'**
  String get commanderMaxReached;

  /// No description provided for @deckToCollectionCta.
  ///
  /// In pt, this message translates to:
  /// **'Incluir deck na coleção'**
  String get deckToCollectionCta;

  /// No description provided for @deckToCollectionTitle.
  ///
  /// In pt, this message translates to:
  /// **'Incluir deck na coleção'**
  String get deckToCollectionTitle;

  /// No description provided for @newCollectionCta.
  ///
  /// In pt, this message translates to:
  /// **'Criar nova coleção'**
  String get newCollectionCta;

  /// No description provided for @newCollectionTitle.
  ///
  /// In pt, this message translates to:
  /// **'Nova coleção'**
  String get newCollectionTitle;

  /// No description provided for @newCollectionNameLabel.
  ///
  /// In pt, this message translates to:
  /// **'Nome'**
  String get newCollectionNameLabel;

  /// No description provided for @newCollectionNameHint.
  ///
  /// In pt, this message translates to:
  /// **'Ex.: Binder, Trade, Staples'**
  String get newCollectionNameHint;

  /// No description provided for @collectionsEmptyTitle.
  ///
  /// In pt, this message translates to:
  /// **'Ainda não tens coleções'**
  String get collectionsEmptyTitle;

  /// No description provided for @collectionsEmptySubtitle.
  ///
  /// In pt, this message translates to:
  /// **'Toca em “Nova coleção” para criar a primeira.'**
  String get collectionsEmptySubtitle;

  /// No description provided for @retry.
  ///
  /// In pt, this message translates to:
  /// **'Tentar novamente'**
  String get retry;

  /// No description provided for @selectPrintingTitle.
  ///
  /// In pt, this message translates to:
  /// **'Selecionar edição'**
  String get selectPrintingTitle;

  /// No description provided for @selectPrintingInvalidNavigation.
  ///
  /// In pt, this message translates to:
  /// **'Navegação inválida para seleção de edição.'**
  String get selectPrintingInvalidNavigation;

  /// No description provided for @selectPrintingEmpty.
  ///
  /// In pt, this message translates to:
  /// **'Nenhuma edição encontrada.'**
  String get selectPrintingEmpty;

  /// No description provided for @selectPrintingLimitedHint.
  ///
  /// In pt, this message translates to:
  /// **'Lista limitada por desempenho. Use busca mais específica na app se precisar de uma edição rara.'**
  String get selectPrintingLimitedHint;

  /// No description provided for @selectPrintingLoadMore.
  ///
  /// In pt, this message translates to:
  /// **'Carregar mais edições'**
  String get selectPrintingLoadMore;

  /// No description provided for @playPlayerOneLabel.
  ///
  /// In pt, this message translates to:
  /// **'Jogador 1'**
  String get playPlayerOneLabel;

  /// No description provided for @playPlayerTwoLabel.
  ///
  /// In pt, this message translates to:
  /// **'Jogador 2'**
  String get playPlayerTwoLabel;

  /// No description provided for @playGrimoireTitle.
  ///
  /// In pt, this message translates to:
  /// **'Grimório'**
  String get playGrimoireTitle;

  /// No description provided for @playGoHomeCta.
  ///
  /// In pt, this message translates to:
  /// **'Ir para início'**
  String get playGoHomeCta;

  /// No description provided for @create.
  ///
  /// In pt, this message translates to:
  /// **'Criar'**
  String get create;

  /// No description provided for @deckToCollectionResult.
  ///
  /// In pt, this message translates to:
  /// **'Adicionado: {added} cartas • Ignoradas: {skipped}'**
  String deckToCollectionResult(Object added, Object skipped);
}

class _AppLocalizationsDelegate
    extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  Future<AppLocalizations> load(Locale locale) {
    return SynchronousFuture<AppLocalizations>(lookupAppLocalizations(locale));
  }

  @override
  bool isSupported(Locale locale) =>
      <String>['en', 'es', 'pt'].contains(locale.languageCode);

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}

AppLocalizations lookupAppLocalizations(Locale locale) {
  // Lookup logic when only language code is specified.
  switch (locale.languageCode) {
    case 'en':
      return AppLocalizationsEn();
    case 'es':
      return AppLocalizationsEs();
    case 'pt':
      return AppLocalizationsPt();
  }

  throw FlutterError(
      'AppLocalizations.delegate failed to load unsupported locale "$locale". This is likely '
      'an issue with the localizations generation tool. Please file an issue '
      'on GitHub with a reproducible sample app and the gen-l10n configuration '
      'that was used.');
}
