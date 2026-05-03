# Analise do XAPK: Mythic Tools 2.9.4

Arquivo analisado: `/Users/gilbertojunior/Downloads/MTG Life Counter_ Mythic Tools_2.9.4_APKPure.xapk`  
Pacote Android: `com.studiolaganne.lengendarylens`  
Versao: `2.9.4` (`versionCode` 621)  
Data da analise: 2026-05-03

## Escopo e limites

Esta analise foi feita para referencia de produto e arquitetura. O objetivo e entender features, fluxos, estruturas e logica de negocio para inspirar o Mana Grimoire, sem copiar codigo, assets, modelos, chaves, identidade visual ou textos proprietarios.

Foram usados tres caminhos:

- Inspecao do XAPK/splits e manifesto.
- Decodificacao de recursos, bancos SQLite e codigo decompilado.
- Execucao em emulador Android para validar telas principais e fluxo real.

O decompile com `jadx` terminou com erros em alguns arquivos, o que e comum em APKs grandes/otimizados, mas gerou material suficiente para mapear a arquitetura e os fluxos.

## Resumo executivo

Mythic Tools nao e apenas um life counter. Ele combina cinco produtos em um:

- Contador multiplayer de vida para Magic, com Commander como caso central.
- Scanner de cartas e listas com reconhecimento por camera, precos e contagem.
- Busca offline/online de cartas, sets, regras e glossario.
- Gerenciador de decks, colecao, listas, importacao/exportacao e status de posse.
- Camada social/conta: amigos, playgroups, historico de jogos, estatisticas e sync.

A estrategia de produto e bem clara: o app deixa o usuario experimentar Home, Search, Game e Scanner sem conta, mas posiciona conta gratuita como desbloqueio de colecao, historico, playgroups, sync e estatisticas. A monetizacao premium parece concentrada em Mythic+, com recomendacoes, avaliacoes e recursos inteligentes para decks.

## Estrutura do XAPK

O XAPK e composto por um APK base, splits de idioma/densidade/ABI e dois splits grandes de dados.

| Split | Papel | Tamanho aproximado |
| --- | --- | ---: |
| `com.studiolaganne.lengendarylens.apk` | App base, layouts, classes, DBs base, ML Kit | 96 MB |
| `mtg_databases.apk` | Bancos de cartas localizados | 256 MB |
| `ml_models.apk` | Modelos ONNX e embeddings | 100 MB |
| `config.arm64_v8a.apk` | Bibliotecas nativas ONNX/OpenCV/ML Kit | 62 MB |
| `config.xxhdpi.apk` | Recursos de densidade | 96 KB |
| `config.*.apk` | Idiomas | 60 KB a 260 KB cada |

Metadados principais do manifesto:

- `minSdk`: 26.
- `targetSdk`: 36.
- Permissoes principais: camera, internet/rede, notificacoes, billing, biometria/fingerprint, media/storage, FCM, foreground services, install referrer e advertising/ad services.
- Deep links: `artifact.mythic.tools` e `mythic.tools`, incluindo callbacks de Discord/Twitch/email e rotas de evento/usuario.

## Navegacao validada em runtime

### Onboarding

O onboarding tem tres promessas visuais:

- Life counter multiplayer como experiencia principal.
- Scanner de cartas com dados de preco, oracle, legalidades e rulings.
- Historico/estatisticas de games e decks.

Depois do onboarding, o app pede cadastro, mas permite continuar sem conta via `Skip`.

Screenshots:

- `runtime/onboarding_scan.png`
- `runtime/onboarding_stats.png`

### Home

A Home tem:

- Header com logo, Store, Settings e perfil.
- Card de conta gratuita, explicando amigos, playgroups, decks, historico, sync e estatisticas.
- Recent cards, com atalho de busca.
- Random keyword/rulebook como conteudo util diario.
- Bottom navigation fixa: Home, Scan, Game, Search, Collection.

Screenshot: `runtime/home.png`

### Scan

A aba Scan pede permissao de camera e abre uma tela de camera full-screen com:

- Titulo de lista de scan.
- Total de cartas detectadas.
- Total de preco.
- Exportar lista.
- Apagar lista.
- Botao de pause.
- Settings.
- Moldura/guia para apontar a camera para uma carta.

Na analise estatica, o scanner e uma das partes mais fortes do app: ele usa CameraX, ML Kit, ONNX Runtime e OpenCV, com modelos locais para detectar/cortar/classificar cartas e embeddings para buscar o print aproximado.

Screenshot: `runtime/scan.png`

### Game

A aba Game tem um tutorial inicial e depois um setup em etapas. O fluxo observado:

- Selecionar formato: Commander/EDH, Duel Commander, Standard, Modern, Pauper, Legacy ou outros.
- Selecionar tema visual.
- Confirmar vida inicial.
- Escolher variante/subformato.
- Configurar timer global e turn timers.
- Seguir para layout/players.

O app tem muitos layouts XML especificos para 1 a 8 jogadores e diferentes tipos de orientacao/mesa, alem de overlays para commander damage, counters e menus.

Screenshots:

- `runtime/game_format.png`
- `runtime/game_options.png`

### Search

A busca tem abas Cards e Sets, campo de texto, modo grade/lista, filtros, ordenacao, agrupamento e settings. Os recursos estaticos indicam suporte multilanguage e agrupamentos por tipo, cor, identidade, custo, raridade, set, preco e outras dimensoes.

Screenshot: `runtime/search.png`

### Collection

Sem login, a aba Collection e bloqueada por conta e vende a proposta de organizar a colecao, escanear caixas/binders e usar tudo com uma conta gratuita.

Screenshot: `runtime/collection_gate.png`

## Telas e modulos encontrados nos recursos

Atividades principais:

- `MainActivity`, `OnboardingActivity`, `SignUpActivity`, `SearchActivity`, `SettingsActivity`, `StoreActivity`.
- Scanner: `ScanToDeckActivity`, `ScanToListActivity`, `PickACardActivity`.
- Cards e regras: `CardActivity`, `AllPrintsActivity`, `SetDetailsActivity`, `RulesActivity`, `WebActivity`.
- Decks: `DecksListActivity`, `DeckDetailsActivity`, `DeckTokensActivity`, `ArchivedDecksActivity`.
- Jogos: `GameDetailsActivity`, telas de eventos de game e historico.
- Social: `FriendsListActivity`, `CirclesListActivity`, `PlaygroupListActivity`, `PlaygroupDetailsActivity`, `SharedCollectionsActivity`.
- Eventos: `EventsActivity` e telas de torneio/evento.

Fragments e dialogs revelam fluxos adicionais:

- Importacao/exportacao de deck em TXT/CSV e integracoes com links externos.
- Conversao para smart deck, update para edicao mais barata, status da colecao.
- Tokens do deck, combos, recomendacoes, rankings e deck ID card.
- Dice, coin flip, Planechase, Archenemy, Initiative/Undercity, The Ring, poison, commander tax, commander damage.
- Perfil, QR, privacidade, convites, playgroups e mensagens.

## Dados locais

O app carrega bastante conteudo offline por SQLite.

| Banco | Conteudo | Observacoes |
| --- | --- | --- |
| `cards_en_18.db` | Cartas e prints em ingles | 39.147 cards, 106.995 prints, FTS para busca |
| `cards_*.db` | Cartas localizadas | de/fr/es/pt/it/ja/ko/ru/zh etc. |
| `sets_en_13.db` | Sets | 970 sets no banco local |
| `rules_en_10.db` | Regras completas | 3.260 regras, 10 secoes, data efetiva `2026-01-16` |
| `glossary_en_5.db` | Glossario | 716 entradas |
| `decks_5.db` | Formatos, subformatos, tags, temas | 24 formatos, 8 subformatos, 414 tags, 119 temas |
| `Messages.db` | Mensagens locais | Estrutura pronta, vazio no asset |

Detalhe importante: o app usa versionamento no nome dos bancos (`cards_en_18`, `rules_en_10`, etc.) e possui logica para copiar do asset para armazenamento interno, validar schemas e apagar versoes antigas. Tambem existe fluxo para baixar atualizacoes de bancos via backend.

## Modelos de ML e scanner

O split de modelos inclui:

- Modelos ONNX para deteccao de carta, classificacao, arte da carta, simbolos de set e print-list.
- Embeddings binarios (`.meb`) para cartas e sets.
- Modelos TFLite de ML Kit para object detection/language ID.

Arquitetura inferida:

- CameraX captura frames.
- Modelo de deteccao acha a regiao da carta.
- OpenCV ordena cantos, corrige perspectiva e recorta a imagem.
- Classificador identifica tipo/layout da carta.
- Embedding visual busca cartas parecidas em indice local.
- Resultado cruza com banco de prints e metadados.

Para o Mana Grimoire, esse modulo e uma boa inspiracao de arquitetura, mas nao devemos reaproveitar modelos/embeddings/assets proprietarios.

## Backend, conta e sincronizacao

O app usa Retrofit/OkHttp para um backend em `api.mythic.tools`, com Firebase Auth para identidade e tokens. O cliente adiciona headers de versao, build, device, locale, token Firebase/Google e assinatura de requisicao.

Grupos de endpoints vistos no codigo:

- Auth/login/logout e callbacks sociais.
- Cards, prints, precos, status de colecao.
- Download/update de bancos.
- Deck CRUD, import/sync externo, duplicate/fork, archive/delete/restore.
- Collection/list CRUD, add/move/remove cards, import/export, privacy/share.
- Friends, circles, playgroups, messages, ownership/admin.
- Games, notas, tags, publish/unpublish e estatisticas.
- Eventos/promos/trivia/torneios.
- Store/themes e sincronizacao de subscription.

Chaves e identificadores publicos de SDK existem no app decompilado, como e comum em APKs, mas nao foram documentados aqui.

## Logica de negocio principal

### Conta gratuita como motor de retencao

O app deixa a experiencia basica aberta, mas usa conta para:

- Amigos e playgroups.
- Listar decks.
- Salvar historico completo.
- Sincronizar dispositivos.
- Manter estatisticas.
- Gerenciar colecao.

Essa e uma boa decisao de produto: cadastro e apresentado como utilidade concreta, nao como barreira inicial absoluta.

### Jogo e contador

O estado de jogo guarda:

- Formato, subformato e vida inicial.
- Numero de jogadores e layout.
- Status: nao iniciado, em progresso, finalizado.
- Commander damage, poison, energy, experience, storm, radiation e commander tax.
- Day/night, monarch, initiative, The Ring e variantes multiplayer.
- Timer global, turn timer, jogador/turno atual.
- Eventos do jogo, vencedores, usuarios/decks vinculados e flags de sync.

O padrao forte aqui e tratar o contador como uma sessao rica, nao so como quatro numeros.

### Decks

O app cobre:

- CRUD, archive/delete/restore.
- Import/export TXT/CSV e links externos.
- Tokens, combos, rankings, bracket, power/health/manabase.
- Status de posse pela colecao.
- Privacidade, fork/duplicate e compartilhamento.

### Colecao

O modelo e orientado a uso fisico:

- Caixas, binders e bulk.
- Status por print.
- Condicao, idioma, foil, altered, signed, misprint, proxy.
- Preco unitario e preco total.
- Mover cartas entre listas/colecoes.
- Atualizar para edicao mais barata.
- Compartilhar colecoes.

### Eventos e torneios

Ha suporte a Constructed, Booster Draft e Sealed, com Swiss, single elimination e Swiss + finals. A logica inclui rounds, pairings, byes, standings, match best-of e tie-breakers.

### Mythic+

Monetizacao premium via RevenueCat com entitlement `Mythic+`. Recursos associados:

- Recomendacoes de cartas.
- Avaliacoes e explicacoes.
- Smart deck.
- Rankings de cartas.
- Combos e ID card do deck.
- Sugestoes de bracket/power.

## Tecnologias identificadas

- Android nativo em Kotlin/Java, com XML layouts e algumas telas Jetpack Compose.
- AndroidX: AppCompat, Fragment, RecyclerView, ViewPager2, Preference, WorkManager, CameraX, Room/DataStore, Credentials/Biometric.
- Material Components.
- Firebase Auth, Messaging, Analytics, Crashlytics/Sessions/Installations.
- Google ML Kit.
- ONNX Runtime e OpenCV nativo.
- Retrofit, OkHttp, Gson, coroutines.
- RevenueCat e Google Play Billing.
- AppsFlyer, Facebook SDK, Customer.io e Segment.
- ZXing/JourneyApps para QR/barcode.
- Coil para imagens.

## Ideias para inspirar o Mana Grimoire

### Prioridade alta

- Bottom nav simples com cinco polos: Home, Scan, Play/Game, Search, Collection/Decks.
- Home util, nao marketing: recentes, atalhos, regra/keyword do dia, status de sync/conta.
- Game como sessao rica: vida, commander damage, poison, timers, eventos e vencedor.
- Setup de jogo em etapas: formato -> jogadores/layout -> opcionais -> iniciar.
- Search com filtros e agrupamento fortes, mesmo antes de o scanner estar perfeito.
- Collection/decks com status de posse e import/export.

### Prioridade media

- Scanner que primeiro salva uma lista confiavel, antes de tentar automatizar tudo.
- "Scan list" com contador, preco total, exportar e limpar.
- Deck health/ID card como output simples e visual.
- Historico por deck com winrate e on the play/on the draw.
- Playgroups como camada social depois que jogo/decks estiverem solidos.

### Prioridade futura/premium

- Recomendacoes inteligentes para Commander.
- Avaliacao de power/bracket.
- Sugestoes de upgrades a partir da colecao.
- Combos e sinergias por deck.
- Estatisticas avancadas de mesa/playgroup.

### Evitar copiar

- Assets, imagens, videos, fontes, layout exato e identidade visual.
- Modelos ONNX/TFLite e embeddings.
- Estrutura de backend, assinaturas, SDK keys e endpoints privados.
- Textos de onboarding/marketing.

O caminho mais seguro e absorver os padroes de produto: organizar bem os fluxos, manter utilidade offline, capturar historico, e transformar scanner/deck/colecao em um ciclo unico.

