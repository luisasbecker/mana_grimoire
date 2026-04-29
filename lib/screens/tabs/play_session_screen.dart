import 'package:flutter/material.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:go_router/go_router.dart';

import '../../app/router.dart';
import 'play_session_cache.dart';

/// Tela de sessão de partida: full-screen (sem AppBar e sem bottom bar).
class PlaySessionScreen extends StatefulWidget {
  const PlaySessionScreen({super.key});

  @override
  State<PlaySessionScreen> createState() => _PlaySessionScreenState();
}

class _PlaySessionScreenState extends State<PlaySessionScreen> {
  final _cache = PlaySessionCache.instance;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final scheme = theme.colorScheme;
    final t = AppLocalizations.of(context)!;

    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
          child: Column(
            children: [
              Expanded(
                child: _LifeBlock(
                  label: t.playPlayerOneLabel,
                  value: _cache.lifeA,
                  onAdd: () => setState(() => _cache.lifeA++),
                  onSub: () => setState(() {
                    if (_cache.lifeA > 0) _cache.lifeA--;
                  }),
                ),
              ),
              const SizedBox(height: 12),
              Center(
                child: _GrimoireButton(
                  onPressed: () async {
                    await showModalBottomSheet<void>(
                      context: context,
                      showDragHandle: true,
                      backgroundColor: scheme.surfaceContainerHigh,
                      shape: const RoundedRectangleBorder(
                        borderRadius:
                            BorderRadius.vertical(top: Radius.circular(20)),
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
                              style: theme.textTheme.titleLarge
                                  ?.copyWith(fontWeight: FontWeight.w800),
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
                  },
                ),
              ),
              const SizedBox(height: 12),
              Expanded(
                child: _LifeBlock(
                  label: t.playPlayerTwoLabel,
                  value: _cache.lifeB,
                  onAdd: () => setState(() => _cache.lifeB++),
                  onSub: () => setState(() {
                    if (_cache.lifeB > 0) _cache.lifeB--;
                  }),
                ),
              ),
            ],
          ),
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
              scheme.primaryContainer.withOpacity(0.85),
              scheme.surfaceContainerHigh.withOpacity(0.95),
            ],
          ),
          border: Border.all(
            color: scheme.primary.withOpacity(0.6),
            width: 1.5,
          ),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.35),
              blurRadius: 20,
              offset: const Offset(0, 12),
            ),
            BoxShadow(
              color: scheme.primary.withOpacity(0.30),
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
  });

  final String label;
  final int value;
  final VoidCallback onAdd;
  final VoidCallback onSub;

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
            style: theme.textTheme.titleSmall?.copyWith(
              color: scheme.onSurfaceVariant,
              fontWeight: FontWeight.w600,
            ),
          ),
          const SizedBox(height: 8),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              FilledButton.tonal(
                onPressed: onSub,
                style: FilledButton.styleFrom(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 20, vertical: 16),
                ),
                child: const Icon(Icons.remove, size: 28),
              ),
              const SizedBox(width: 20),
              Text(
                '$value',
                style: theme.textTheme.displayMedium?.copyWith(
                  fontWeight: FontWeight.w800,
                  letterSpacing: 1.2,
                ),
              ),
              const SizedBox(width: 20),
              FilledButton.tonal(
                onPressed: onAdd,
                style: FilledButton.styleFrom(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 20, vertical: 16),
                ),
                child: const Icon(Icons.add, size: 28),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
