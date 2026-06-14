import 'package:flutter/material.dart';

import '../../../widgets/mana_empty_state.dart';

class CameraPermissionScreen extends StatelessWidget {
  const CameraPermissionScreen({
    super.key,
    required this.message,
    required this.onRetry,
  });

  final String message;
  final VoidCallback onRetry;

  @override
  Widget build(BuildContext context) {
    return Stack(
      fit: StackFit.expand,
      children: [
        ManaEmptyState(
          icon: Icons.photo_camera_outlined,
          title: 'Permissão de câmera necessária',
          subtitle: message,
        ),
        Positioned(
          left: 24,
          right: 24,
          bottom: 24,
          child: FilledButton.icon(
            onPressed: onRetry,
            icon: const Icon(Icons.refresh_rounded),
            label: const Text('Tentar novamente'),
          ),
        ),
      ],
    );
  }
}
