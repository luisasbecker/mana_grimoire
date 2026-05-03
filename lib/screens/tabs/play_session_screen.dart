import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import 'play_session_controller.dart';

/// Tela de sessão de partida: full-screen (sem AppBar e sem bottom bar).
class PlaySessionScreen extends ConsumerWidget {
  const PlaySessionScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final t = AppLocalizations.of(context)!;
    final session = ref.watch(playSessionControllerProvider);
    final controller = ref.read(playSessionControllerProvider.notifier);
    final lifeBlocks = List<Widget>.generate(
      session.players,
      (index) => _LifeBlock(
        label: _playerLabel(t, index),
        value: session.lifeAt(index),
        compact: session.players > 2,
        onAdd: () => controller.incrementLife(index),
        onSub: () => controller.decrementLife(index),
      ),
    );

    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
          child: session.players <= 2
              ? Column(
                  children: [
                    Expanded(child: lifeBlocks[0]),
                    const SizedBox(height: 12),
                    Center(
                      child: _GrimoireButton(
                        onPressed: () => _openGrimoireSheet(
                          context: context,
                          theme: theme,
                          scheme: scheme,
                          t: t,
                        ),
                      ),
                    ),
                    const SizedBox(height: 12),
                    Expanded(child: lifeBlocks[1]),
                  ],
                )
              : Column(
                  children: [
                    Expanded(
                      child: GridView.count(
                        crossAxisCount: 2,
                        childAspectRatio: 1.05,
                        mainAxisSpacing: 12,
                        crossAxisSpacing: 12,
                        children: lifeBlocks,
                      ),
                    ),
                    const SizedBox(height: 12),
                    _GrimoireButton(
                      onPressed: () => _openGrimoireSheet(
                        context: context,
                        theme: theme,
                        scheme: scheme,
                        t: t,
                      ),
                    ),
                  ],
                ),
        ),
      ),
    );
  }

  String _playerLabel(AppLocalizations t, int index) {
    return switch (index) {
      0 => t.playPlayerOneLabel,
      1 => t.playPlayerTwoLabel,
      _ => 'Jogador ${index + 1}',
    };
  }

  Future<void> _openGrimoireSheet({
    required BuildContext context,
    required ThemeData theme,
    required ColorScheme scheme,
    required AppLocalizations t,
  }) {
    return showModalBottomSheet<void>(
      context: context,
      showDragHandle: true,
      backgroundColor: scheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) => Padding(
        padding: const EdgeInsets.fromLTRB(16, 10, 16, 16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              t.playGrimoireTitle,
              textAlign: TextAlign.center,
              style: theme.textTheme.titleLarge?.copyWith(
                fontWeight: FontWeight.w800,
              ),
            ),
            const SizedBox(height: 14),
            FilledButton(
              onPressed: () {
                Navigator.of(ctx).pop();
                context.goNamed(AppRoutes.homeHub);
              },
              child: Text(t.playGoHomeCta),
            ),
          ],
        ),
      ),
    );
  }
}

class _GrimoireButton extends StatelessWidget {
  const _GrimoireButton({required this.onPressed});

  final VoidCallback onPressed;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return ConstrainedBox(
      constraints: const BoxConstraints.tightFor(width: 92, height: 92),
      child: DecoratedBox(
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [
              scheme.primaryContainer.withValues(alpha: 0.85),
              scheme.surfaceContainerHigh.withValues(alpha: 0.95),
            ],
          ),
          border: Border.all(
            color: scheme.primary.withValues(alpha: 0.6),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withValues(alpha: 0.35),
              blurRadius: 20,
              offset: const Offset(0, 12),
            ),
            BoxShadow(
              color: scheme.primary.withValues(alpha: 0.30),
              blurRadius: 18,
              offset: const Offset(0, 0),
            ),
          ],
        ),
        child: Material(
          color: Colors.transparent,
          child: InkWell(
            onTap: onPressed,
            customBorder: const CircleBorder(),
            child: Center(
              child: Icon(
                Icons.menu_book_rounded,
                size: 36,
                color: scheme.onPrimaryContainer,
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _LifeBlock extends StatelessWidget {
  const _LifeBlock({
    required this.label,
    required this.value,
    required this.onAdd,
    required this.onSub,
    this.compact = false,
  });

  final String label;
  final int value;
  final VoidCallback onAdd;
  final VoidCallback onSub;
  final bool compact;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = Theme.of(context).colorScheme;
    return Center(
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text(
            label,
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
            style: theme.textTheme.titleSmall?.copyWith(
              color: scheme.onSurfaceVariant,
              fontWeight: FontWeight.w600,
            ),
          ),
          const SizedBox(height: 8),
          FittedBox(
            fit: BoxFit.scaleDown,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                FilledButton.tonal(
                  onPressed: onSub,
                  style: FilledButton.styleFrom(
                    padding: EdgeInsets.symmetric(
                      horizontal: compact ? 14 : 20,
                      vertical: compact ? 12 : 16,
                    ),
                  ),
                  child: Icon(Icons.remove, size: compact ? 24 : 28),
                ),
                SizedBox(width: compact ? 12 : 20),
                Text(
                  '$value',
                  style: (compact
                          ? theme.textTheme.displaySmall
                          : theme.textTheme.displayMedium)
                      ?.copyWith(
                    fontWeight: FontWeight.w800,
                    letterSpacing: 1.2,
                  ),
                ),
                SizedBox(width: compact ? 12 : 20),
                FilledButton.tonal(
                  onPressed: onAdd,
                  style: FilledButton.styleFrom(
                    padding: EdgeInsets.symmetric(
                      horizontal: compact ? 14 : 20,
                      vertical: compact ? 12 : 16,
                    ),
                  ),
                  child: Icon(Icons.add, size: compact ? 24 : 28),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
