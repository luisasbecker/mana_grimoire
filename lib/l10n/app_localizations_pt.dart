// ignore: unused_import
import 'package:intl/intl.dart' as intl;
import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for Portuguese (`pt`).
class AppLocalizationsPt extends AppLocalizations {
  AppLocalizationsPt([String locale = 'pt']) : super(locale);

  @override
  String get navCollection => 'Coleção';

  @override
  String get navScan => 'Scan';

  @override
  String get navHome => 'Início';

  @override
  String get navChat => 'Chat';

  @override
  String get navPlay => 'Jogar';

  @override
  String get collectionHubTitle => 'Coleção';

  @override
  String get collectionHubSubtitle => 'A tua biblioteca';

  @override
  String get collectionHubMyCardsTitle => 'Minhas cartas';

  @override
  String get collectionHubMyCardsSubtitle => 'Coleções, scans e edições';

  @override
  String get collectionHubDecksTitle => 'Decks';

  @override
  String get collectionHubDecksSubtitle => 'Cria e gerencia as tuas listas';

  @override
  String get cardsTitle => 'Cartas';

  @override
  String get allCardsTitle => 'Todas as cartas';

  @override
  String get allCardsSubtitle => 'De todas as coleções';

  @override
  String get allCardsSearchHint => 'Buscar em todas as coleções…';

  @override
  String get allCardsEmptyTitle => 'Ainda não há cartas';

  @override
  String get allCardsEmptySubtitle =>
      'Adiciona cartas a qualquer coleção para vê-las aqui.';

  @override
  String get decksTitle => 'Decks';

  @override
  String get decksEmptyTitle => 'Ainda não tens decks';

  @override
  String get decksEmptySubtitle =>
      'Toca em “Criar deck” para adicionar o primeiro.';

  @override
  String get decksCreateCta => 'Criar deck';

  @override
  String get createDeckTitle => 'Criar deck';

  @override
  String get createDeckNameLabel => 'Nome do deck';

  @override
  String get createDeckNameHint => 'Ex.: Atraxa Superfriends';

  @override
  String get createDeckFormatLabel => 'Formato';

  @override
  String get createDeckCreateButton => 'Criar';

  @override
  String get createDeckNameRequired => 'O nome do deck é obrigatório.';

  @override
  String get deckEmptyTitle => 'Deck vazio';

  @override
  String get deckEmptySubtitle => 'Em breve: adicionar cartas ao deck.';

  @override
  String get deckEditCta => 'Editar deck';

  @override
  String get editDeckTitle => 'Editar deck';

  @override
  String get deckSaveCta => 'Salvar';

  @override
  String get addCardToDeckTitle => 'Adicionar carta';

  @override
  String get addCardToDeckSearchHint => 'Buscar na Scryfall (ex.: Sol Ring)';

  @override
  String get addCardToDeckEmptyTitle => 'Procura uma carta';

  @override
  String get addCardToDeckEmptySubtitle => 'Escreve o nome da carta acima.';

  @override
  String get addCardToDeckNoResultsTitle => 'Sem resultados visíveis';

  @override
  String get addCardToDeckNoResultsSubtitle =>
      'Tenta outro termo ou verifica a grafia.';

  @override
  String get addCardToDeckAdded => 'Carta adicionada ao deck.';

  @override
  String get quantity => 'Quantidade';

  @override
  String get options => 'Opções';

  @override
  String get advancedOptions => 'Opções avançadas';

  @override
  String get changePrinting => 'Trocar edição';

  @override
  String get remove => 'Remover';

  @override
  String get cancel => 'Cancelar';

  @override
  String get error => 'Erro';

  @override
  String get deckCardRemoveTitle => 'Remover carta do deck';

  @override
  String get deckCardRemoveBody => 'Deseja remover esta carta do deck?';

  @override
  String get connectToCollectionTitle => 'Coleção';

  @override
  String get connectToCollectionAddOption =>
      'Adicionar esta carta a uma das minhas coleções';

  @override
  String get connectToCollectionLinkOption =>
      'Vincular a uma carta existente na minha coleção';

  @override
  String get connectToCollectionLinkOptionSubtitle => 'Em breve';

  @override
  String get connectToCollectionLinkComingSoon =>
      'Vínculo com coleção em breve.';

  @override
  String get pickCollectionTitle => 'Escolher coleção';

  @override
  String get pickCollectionEmpty => 'Ainda não tens coleções.';

  @override
  String get pickEditionFirst => 'Escolhe uma edição primeiro (Trocar edição).';

  @override
  String get deleteDeckCta => 'Excluir deck';

  @override
  String get deleteDeckTitle => 'Excluir deck';

  @override
  String get deleteDeckBody =>
      'Tem certeza que deseja excluir este deck? Esta ação não pode ser desfeita.';

  @override
  String get deckImportCta => 'Importar deck';

  @override
  String get deckImportTitle => 'Importar deck';

  @override
  String get deckImportHint => '1 Sol Ring\n1 Arcane Signet\n15 Forest\n...';

  @override
  String get deckImportEmptyInput => 'Cole um texto de deck para importar.';

  @override
  String deckImportProgress(Object processed, Object total) {
    return 'Processando $processed de $total…';
  }

  @override
  String get deckImportFailedLinesTitle => 'Linhas com problema';

  @override
  String deckImportResultSummary(Object imported, Object notFound) {
    return 'Importado: $imported cartas • Não encontradas: $notFound';
  }

  @override
  String get deckExportCta => 'Exportar deck';

  @override
  String get deckExportTitle => 'Exportar deck';

  @override
  String get deckExportEmpty => 'Este deck está vazio.';

  @override
  String get deckExportCopyCta => 'Copiar texto';

  @override
  String get deckExportCopied => 'Texto copiado.';

  @override
  String get deckPreviewHint => 'Desliza para mais cartas • Toca para detalhes';

  @override
  String get confirm => 'Confirmar';

  @override
  String get activateDeckTitle => 'Ativar deck';

  @override
  String activateDeckBody(Object activeDeckName) {
    return 'Para ativar este deck, as seguintes cartas precisam ser movidas de $activeDeckName:';
  }

  @override
  String get deckActivationMissingCards => 'Faltam cartas na tua coleção';

  @override
  String get activeDeckPickerTitle => 'Deck ativo';

  @override
  String get activeDeckNone => 'Nenhum deck ativo';

  @override
  String deckCardsCount(Object count) {
    return '$count cartas no deck';
  }

  @override
  String get deckTypePlaneswalkers => 'Planeswalkers';

  @override
  String get deckTypeCreatures => 'Criaturas';

  @override
  String get deckTypeInstants => 'Instantâneas';

  @override
  String get deckTypeSorceries => 'Feitiços';

  @override
  String get deckTypeEnchantments => 'Encantamentos';

  @override
  String get deckTypeArtifacts => 'Artefatos';

  @override
  String get deckTypeLands => 'Terrenos';

  @override
  String get deckTypeOther => 'Outros';

  @override
  String get deckTypeCommander => 'Commander';

  @override
  String get commandersTitle => 'Comandante(s)';

  @override
  String get setCommanderCta => 'Definir';

  @override
  String get noCommanderSelected => 'Nenhum comandante definido.';

  @override
  String get pickCommanderTitle => 'Escolher comandante';

  @override
  String get pickCommanderHint => 'Buscar na Scryfall (ex.: Atraxa)';

  @override
  String get pickCommanderEmptyTitle => 'Procura uma carta';

  @override
  String get pickCommanderEmptySubtitle => 'Escreve o nome acima.';

  @override
  String get pickCommanderNoResultsTitle => 'Sem resultados visíveis';

  @override
  String get pickCommanderNoResultsSubtitle =>
      'Tenta outro termo ou verifica a grafia.';

  @override
  String get commanderMaxReached => 'Já tens 2 comandantes neste deck.';

  @override
  String get deckToCollectionCta => 'Incluir deck na coleção';

  @override
  String get deckToCollectionTitle => 'Incluir deck na coleção';

  @override
  String get newCollectionCta => 'Criar nova coleção';

  @override
  String get newCollectionTitle => 'Nova coleção';

  @override
  String get newCollectionNameLabel => 'Nome';

  @override
  String get newCollectionNameHint => 'Ex.: Binder, Trade, Staples';

  @override
  String get newCollectionNameRequired => 'O nome da coleção é obrigatório.';

  @override
  String get collectionsEmptyTitle => 'Ainda não tens coleções';

  @override
  String get collectionsEmptySubtitle =>
      'Toca em “Nova coleção” para criar a primeira.';

  @override
  String get retry => 'Tentar novamente';

  @override
  String get selectPrintingTitle => 'Selecionar edição';

  @override
  String get selectPrintingInvalidNavigation =>
      'Navegação inválida para seleção de edição.';

  @override
  String get selectPrintingEmpty => 'Nenhuma edição encontrada.';

  @override
  String get selectPrintingLimitedHint =>
      'Lista limitada por desempenho. Use busca mais específica na app se precisar de uma edição rara.';

  @override
  String get selectPrintingLoadMore => 'Carregar mais edições';

  @override
  String get playPlayerOneLabel => 'Jogador 1';

  @override
  String get playPlayerTwoLabel => 'Jogador 2';

  @override
  String get playGrimoireTitle => 'Grimório';

  @override
  String get playGoHomeCta => 'Ir para início';

  @override
  String get create => 'Criar';

  @override
  String deckToCollectionResult(Object added, Object skipped) {
    return 'Adicionado: $added cartas • Ignoradas: $skipped';
  }
}
