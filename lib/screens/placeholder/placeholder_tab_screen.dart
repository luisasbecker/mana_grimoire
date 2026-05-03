import 'package:flutter/material.dart';

import '../../widgets/mana_tab_main_app_bar.dart';

/// Ecrã placeholder para abas ainda não implementadas.
class PlaceholderTabScreen extends StatelessWidget {
  const PlaceholderTabScreen({
    super.key,
    required this.title,
    this.subtitle = 'Disponível em breve.',
  });

  final String title;
  final String subtitle;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return Scaffold(
      appBar: ManaTabMainAppBar(title: title),
      body: LayoutBuilder(
        builder: (context, constraints) {
          final minHeight = constraints.hasBoundedHeight
              ? (constraints.maxHeight - 64).clamp(0.0, double.infinity)
              : 0.0;
          return SingleChildScrollView(
            padding: const EdgeInsets.all(32),
            child: ConstrainedBox(
              constraints: BoxConstraints(minHeight: minHeight),
              child: Center(
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(
                      Icons.auto_awesome,
                      size: 48,
                      color: scheme.primary.withValues(alpha: 0.7),
                    ),
                    const SizedBox(height: 20),
                    Text(
                      subtitle,
                      textAlign: TextAlign.center,
                      style: Theme.of(context).textTheme.bodyLarge?.copyWith(
                            color: scheme.onSurfaceVariant,
                          ),
                    ),
                  ],
                ),
              ),
            ),
          );
        },
      ),
    );
  }
}
