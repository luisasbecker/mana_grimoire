import 'dart:math' as math;
import 'dart:ui';

import 'package:flutter/foundation.dart';

enum PlayTableLayout {
  solo,
  duelStack,
  duelSideBySide,
  triangle,
  cross,
  teams,
  ring,
  emperor,
}

@immutable
class PlayGameMode {
  const PlayGameMode({
    required this.id,
    required this.name,
    required this.subtitle,
    required this.defaultPlayers,
    required this.supportedPlayers,
    required this.startingLife,
    required this.defaultVariant,
    required this.variants,
  });

  final String id;
  final String name;
  final String subtitle;
  final int defaultPlayers;
  final List<int> supportedPlayers;
  final int startingLife;
  final String defaultVariant;
  final List<String> variants;
}

@immutable
class PlayVisualTheme {
  const PlayVisualTheme({
    required this.id,
    required this.name,
    required this.primary,
    required this.secondary,
    required this.table,
  });

  final String id;
  final String name;
  final Color primary;
  final Color secondary;
  final Color table;
}

@immutable
class PlayTableTemplate {
  const PlayTableTemplate({
    required this.id,
    required this.name,
    required this.subtitle,
    required this.layout,
    required this.supportedPlayers,
  });

  final String id;
  final String name;
  final String subtitle;
  final PlayTableLayout layout;
  final List<int> supportedPlayers;
}

const List<PlayGameMode> playGameModes = [
  PlayGameMode(
    id: 'commander',
    name: 'Commander / EDH',
    subtitle: 'Mesa multiplayer com 40 de vida e política de pod.',
    defaultPlayers: 4,
    supportedPlayers: [2, 3, 4, 5, 6],
    startingLife: 40,
    defaultVariant: 'Todos contra todos',
    variants: [
      'Todos contra todos',
      'Gigante de Duas Cabeças',
      'Planechase',
      'Archenemy',
    ],
  ),
  PlayGameMode(
    id: 'duel_commander',
    name: 'Duel Commander',
    subtitle: 'Commander competitivo para dois jogadores.',
    defaultPlayers: 2,
    supportedPlayers: [2],
    startingLife: 20,
    defaultVariant: 'Melhor de um',
    variants: ['Melhor de um', 'Melhor de três'],
  ),
  PlayGameMode(
    id: 'standard',
    name: 'Standard',
    subtitle: 'Formato rotativo para partidas rápidas.',
    defaultPlayers: 2,
    supportedPlayers: [2],
    startingLife: 20,
    defaultVariant: 'Construído',
    variants: ['Construído', 'Melhor de três'],
  ),
  PlayGameMode(
    id: 'modern',
    name: 'Modern',
    subtitle: 'Duelos eternos com pool amplo e 20 de vida.',
    defaultPlayers: 2,
    supportedPlayers: [2],
    startingLife: 20,
    defaultVariant: 'Construído',
    variants: ['Construído', 'Melhor de três'],
  ),
  PlayGameMode(
    id: 'pauper',
    name: 'Pauper',
    subtitle: 'Somente comuns, ritmo técnico e econômico.',
    defaultPlayers: 2,
    supportedPlayers: [2],
    startingLife: 20,
    defaultVariant: 'Construído',
    variants: ['Construído', 'Melhor de três'],
  ),
  PlayGameMode(
    id: 'legacy',
    name: 'Legacy',
    subtitle: 'Formato eterno para duelos de alta potência.',
    defaultPlayers: 2,
    supportedPlayers: [2],
    startingLife: 20,
    defaultVariant: 'Construído',
    variants: ['Construído', 'Melhor de três'],
  ),
  PlayGameMode(
    id: 'brawl',
    name: 'Brawl',
    subtitle: 'Commander compacto com identidade de cor.',
    defaultPlayers: 2,
    supportedPlayers: [2, 3, 4],
    startingLife: 25,
    defaultVariant: 'Brawl',
    variants: ['Brawl', 'Historic Brawl', 'Mesa livre'],
  ),
  PlayGameMode(
    id: 'casual',
    name: 'Casual',
    subtitle: 'Template flexível para mesas livres e variantes.',
    defaultPlayers: 4,
    supportedPlayers: [1, 2, 3, 4, 5, 6, 8],
    startingLife: 20,
    defaultVariant: 'Mesa livre',
    variants: [
      'Mesa livre',
      'Gigante de Duas Cabeças',
      'Emperor',
      'Planechase',
    ],
  ),
];

const List<PlayVisualTheme> playVisualThemes = [
  PlayVisualTheme(
    id: 'arcane',
    name: 'Arcano',
    primary: Color(0xFFBD93F9),
    secondary: Color(0xFF8BE9FD),
    table: Color(0xFF383A59),
  ),
  PlayVisualTheme(
    id: 'verdant',
    name: 'Verdejante',
    primary: Color(0xFF50FA7B),
    secondary: Color(0xFFE8D48B),
    table: Color(0xFF243D33),
  ),
  PlayVisualTheme(
    id: 'ember',
    name: 'Brasa',
    primary: Color(0xFFFF5555),
    secondary: Color(0xFFFFB86C),
    table: Color(0xFF4A2E34),
  ),
  PlayVisualTheme(
    id: 'tide',
    name: 'Maré',
    primary: Color(0xFF8BE9FD),
    secondary: Color(0xFFFF79C6),
    table: Color(0xFF273C55),
  ),
];

const List<PlayTableTemplate> playTableTemplates = [
  PlayTableTemplate(
    id: 'solo_focus',
    name: 'Solo',
    subtitle: 'Teste de deck, goldfish ou treino de sequência.',
    layout: PlayTableLayout.solo,
    supportedPlayers: [1],
  ),
  PlayTableTemplate(
    id: 'duel_focus',
    name: 'Duelo vertical',
    subtitle: 'Dois jogadores frente a frente.',
    layout: PlayTableLayout.duelStack,
    supportedPlayers: [2],
  ),
  PlayTableTemplate(
    id: 'duel_side',
    name: 'Duelo lateral',
    subtitle: 'Mesa compartilhada em paisagem.',
    layout: PlayTableLayout.duelSideBySide,
    supportedPlayers: [2],
  ),
  PlayTableTemplate(
    id: 'triangle',
    name: 'Triângulo',
    subtitle: 'Três jogadores com centro livre.',
    layout: PlayTableLayout.triangle,
    supportedPlayers: [3],
  ),
  PlayTableTemplate(
    id: 'commander_pod',
    name: 'Pod Commander',
    subtitle: 'Quatro assentos em cruz ao redor da mesa.',
    layout: PlayTableLayout.cross,
    supportedPlayers: [4],
  ),
  PlayTableTemplate(
    id: 'teams_2v2',
    name: 'Times 2v2',
    subtitle: 'Duplas alinhadas para Gigante de Duas Cabeças.',
    layout: PlayTableLayout.teams,
    supportedPlayers: [4],
  ),
  PlayTableTemplate(
    id: 'pentagon',
    name: 'Pentágono',
    subtitle: 'Cinco jogadores em anel.',
    layout: PlayTableLayout.ring,
    supportedPlayers: [5],
  ),
  PlayTableTemplate(
    id: 'six_ring',
    name: 'Hexágono',
    subtitle: 'Seis jogadores com leitura circular.',
    layout: PlayTableLayout.ring,
    supportedPlayers: [6],
  ),
  PlayTableTemplate(
    id: 'emperor',
    name: 'Emperor',
    subtitle: 'Duas linhas de três jogadores.',
    layout: PlayTableLayout.emperor,
    supportedPlayers: [6],
  ),
  PlayTableTemplate(
    id: 'eight_ring',
    name: 'Octógono',
    subtitle: 'Mesa grande para oito jogadores.',
    layout: PlayTableLayout.ring,
    supportedPlayers: [8],
  ),
];

PlayGameMode playModeByInput(String? value) {
  final normalized = (value ?? '').trim().toLowerCase();
  final legacy = switch (normalized) {
    'commander' || 'commander / edh' || 'edh' => 'commander',
    'duel commander' || 'duel_commander' => 'duel_commander',
    'standard' => 'standard',
    'modern' => 'modern',
    'pauper' => 'pauper',
    'legacy' => 'legacy',
    'brawl' => 'brawl',
    'casual' => 'casual',
    _ => normalized,
  };

  for (final mode in playGameModes) {
    if (mode.id == legacy || mode.name.toLowerCase() == normalized) {
      return mode;
    }
  }
  return playGameModes.first;
}

PlayVisualTheme playVisualThemeById(String? id) {
  for (final theme in playVisualThemes) {
    if (theme.id == id) return theme;
  }
  return playVisualThemes.first;
}

PlayTableTemplate playTableTemplateById(String? id) {
  for (final template in playTableTemplates) {
    if (template.id == id) return template;
  }
  return playTableTemplates.first;
}

List<PlayTableTemplate> tableTemplatesForPlayers(int players) {
  return [
    for (final template in playTableTemplates)
      if (template.supportedPlayers.contains(players)) template,
  ];
}

int normalizePlayersForMode(int players, PlayGameMode mode) {
  if (mode.supportedPlayers.contains(players)) return players;
  return mode.defaultPlayers;
}

String normalizeVariantForMode(String? variant, PlayGameMode mode) {
  if (variant != null && mode.variants.contains(variant)) return variant;
  return mode.defaultVariant;
}

PlayTableTemplate defaultTableTemplateFor({
  required PlayGameMode mode,
  required int players,
  String? variant,
}) {
  final variantName = variant ?? mode.defaultVariant;
  final preferredId = switch ((mode.id, players, variantName)) {
    (_, 4, 'Gigante de Duas Cabeças') => 'teams_2v2',
    ('casual', 6, 'Emperor') => 'emperor',
    (_, 1, _) => 'solo_focus',
    (_, 2, _) => 'duel_focus',
    (_, 3, _) => 'triangle',
    (_, 4, _) => 'commander_pod',
    (_, 5, _) => 'pentagon',
    (_, 6, _) => 'six_ring',
    (_, 8, _) => 'eight_ring',
    _ => 'duel_focus',
  };
  return normalizeTableTemplateForPlayers(preferredId, players, mode: mode);
}

PlayTableTemplate normalizeTableTemplateForPlayers(
  String? templateId,
  int players, {
  required PlayGameMode mode,
  String? variant,
}) {
  for (final template in playTableTemplates) {
    if (template.id == templateId &&
        template.supportedPlayers.contains(players)) {
      return template;
    }
  }

  final available = tableTemplatesForPlayers(players);
  if (available.isEmpty) {
    return defaultTableTemplateFor(
      mode: mode,
      players: mode.defaultPlayers,
      variant: variant,
    );
  }
  return available.first;
}

int normalizeStartingLife(int value, PlayGameMode mode) {
  if (value <= 0) return mode.startingLife;
  return value.clamp(1, 999).toInt();
}

List<Offset> seatCentersForTemplate(
  PlayTableTemplate template,
  int players,
) {
  return switch (template.layout) {
    PlayTableLayout.solo => const [Offset(0.5, 0.5)],
    PlayTableLayout.duelStack => const [
        Offset(0.5, 0.2),
        Offset(0.5, 0.8),
      ],
    PlayTableLayout.duelSideBySide => const [
        Offset(0.22, 0.5),
        Offset(0.78, 0.5),
      ],
    PlayTableLayout.triangle => const [
        Offset(0.5, 0.18),
        Offset(0.22, 0.78),
        Offset(0.78, 0.78),
      ],
    PlayTableLayout.cross => const [
        Offset(0.5, 0.13),
        Offset(0.88, 0.5),
        Offset(0.5, 0.87),
        Offset(0.12, 0.5),
      ],
    PlayTableLayout.teams => const [
        Offset(0.25, 0.22),
        Offset(0.75, 0.22),
        Offset(0.25, 0.78),
        Offset(0.75, 0.78),
      ],
    PlayTableLayout.emperor => const [
        Offset(0.18, 0.22),
        Offset(0.5, 0.2),
        Offset(0.82, 0.22),
        Offset(0.18, 0.78),
        Offset(0.5, 0.8),
        Offset(0.82, 0.78),
      ],
    PlayTableLayout.ring => List<Offset>.generate(players, (index) {
        final angle = -math.pi / 2 + (math.pi * 2 * index / players);
        return Offset(
          0.5 + math.cos(angle) * 0.38,
          0.5 + math.sin(angle) * 0.35,
        );
      }, growable: false),
  };
}

double readableSeatRotation(Offset seatCenter) {
  final dx = seatCenter.dx - 0.5;
  final dy = seatCenter.dy - 0.5;
  if (dx.abs() < 0.001 && dy.abs() < 0.001) return 0;
  final angle = math.atan2(-dx, dy);
  return angle <= -math.pi + 0.001 ? math.pi : angle;
}
