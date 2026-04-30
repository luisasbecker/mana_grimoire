import 'dart:async';

import 'package:camera/camera.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:uuid/uuid.dart';

import '../../data/local/db/app_database.dart' show Collection;
import '../../data/local/db/db_instance.dart';
import '../../data/scan/scan_recognition_service.dart';
import '../../widgets/cached_card_thumbnail.dart';
import '../../widgets/mana_chip.dart';
import '../../widgets/mana_empty_state.dart';
import '../../widgets/mana_surface_card.dart';
import '../../widgets/mana_tab_main_app_bar.dart';

class ScanScreen extends StatefulWidget {
  const ScanScreen({super.key});

  @override
  State<ScanScreen> createState() => _ScanScreenState();
}

class _ScanScreenState extends State<ScanScreen> {
  static const double _autoAcceptConfidence = 0.72;

  final _uuid = const Uuid();
  final _recognitionService = ManaScanRecognitionService();

  CameraController? _cameraController;
  bool _cameraLoading = false;
  bool _scanning = false;
  bool _saving = false;
  String? _selectedCollectionId;
  String? _error;
  String _status = 'Aponte a carta para a moldura e toque em escanear.';
  List<_ScanBufferEntry> _buffer = const [];

  bool get _scanSupported {
    if (kIsWeb) return false;
    return defaultTargetPlatform == TargetPlatform.android ||
        defaultTargetPlatform == TargetPlatform.iOS;
  }

  int get _totalBuffered =>
      _buffer.fold<int>(0, (sum, entry) => sum + entry.quantity);

  @override
  void initState() {
    super.initState();
    if (_scanSupported) {
      unawaited(_initializeCamera());
    }
  }

  @override
  void dispose() {
    unawaited(_cameraController?.dispose());
    unawaited(_recognitionService.dispose());
    super.dispose();
  }

  Future<void> _initializeCamera() async {
    setState(() {
      _cameraLoading = true;
      _error = null;
      _status = 'Preparando câmera...';
    });

    try {
      final cameras = await availableCameras();
      if (cameras.isEmpty) {
        throw CameraException('NoCamera', 'Nenhuma câmera disponível.');
      }
      final preferred = cameras.firstWhere(
        (camera) => camera.lensDirection == CameraLensDirection.back,
        orElse: () => cameras.first,
      );
      final controller = CameraController(
        preferred,
        ResolutionPreset.high,
        enableAudio: false,
      );
      await controller.initialize();
      try {
        await controller.setFlashMode(FlashMode.off);
      } on CameraException {
        // Alguns dispositivos não permitem controlar flash nesse modo.
      }
      if (!mounted) {
        await controller.dispose();
        return;
      }
      setState(() {
        _cameraController = controller;
        _status = 'Câmera pronta. Mantenha o nome da carta legível.';
      });
    } on CameraException catch (error) {
      if (!mounted) return;
      setState(() {
        _error = _cameraErrorMessage(error);
        _status = _error!;
      });
    } catch (error) {
      if (!mounted) return;
      setState(() {
        _error = 'Não foi possível abrir a câmera: $error';
        _status = _error!;
      });
    } finally {
      if (mounted) {
        setState(() => _cameraLoading = false);
      }
    }
  }

  Future<void> _captureAndRecognize() async {
    final controller = _cameraController;
    if (_scanning || controller == null || !controller.value.isInitialized) {
      return;
    }

    setState(() {
      _scanning = true;
      _error = null;
      _status = 'Lendo carta...';
    });

    try {
      final photo = await controller.takePicture();
      final result = await _recognitionService.recognizeImagePath(photo.path);
      if (!mounted) return;

      final primary = result.primary;
      if (primary == null) {
        setState(() {
          _error = result.rawText.isEmpty
              ? 'Nenhum texto legível foi encontrado.'
              : 'Nenhuma carta foi identificada com segurança.';
          _status = 'Tente aproximar a câmera do nome da carta.';
        });
        return;
      }

      if (primary.score >= _autoAcceptConfidence) {
        _addCandidateToBuffer(primary);
        setState(() {
          _status = 'Reconhecida: ${primary.name} (${primary.editionLabel}).';
        });
        return;
      }

      final selected = await _openRecognitionReview(result);
      if (selected != null && mounted) {
        _addCandidateToBuffer(selected);
        setState(() {
          _status = 'Adicionada: ${selected.name} (${selected.editionLabel}).';
        });
      }
    } on CameraException catch (error) {
      if (!mounted) return;
      setState(() {
        _error = _cameraErrorMessage(error);
        _status = _error!;
      });
    } catch (error) {
      if (!mounted) return;
      setState(() {
        _error = 'Falha ao reconhecer a carta: $error';
        _status = 'Tente novamente com melhor iluminação.';
      });
    } finally {
      if (mounted) {
        setState(() => _scanning = false);
      }
    }
  }

  Future<ScanRecognitionCandidate?> _openRecognitionReview(
    ScanRecognitionResult result,
  ) {
    return showModalBottomSheet<ScanRecognitionCandidate>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => _RecognitionReviewSheet(result: result),
    );
  }

  void _addCandidateToBuffer(ScanRecognitionCandidate candidate) {
    setState(() {
      final defaultVariantKey = _ScanBufferEntry.variantKeyFor(
        candidate.printingId,
        isFoil: false,
        condition: 'NM',
        language: 'EN',
      );
      final existingIndex = _buffer.indexWhere(
        (entry) => entry.variantKey == defaultVariantKey,
      );
      if (existingIndex >= 0) {
        final next = [..._buffer];
        final current = next[existingIndex];
        next[existingIndex] = current.copyWith(
          quantity: current.quantity + 1,
          confidence: candidate.score,
          lastSeenAt: DateTime.now(),
        );
        _buffer = next;
        return;
      }

      _buffer = [
        _ScanBufferEntry(
          id: _uuid.v4(),
          candidate: candidate,
          quantity: 1,
          confidence: candidate.score,
          firstSeenAt: DateTime.now(),
          lastSeenAt: DateTime.now(),
        ),
        ..._buffer,
      ];
    });
  }

  Future<void> _openBufferEntryEditor(_ScanBufferEntry entry) async {
    final updated = await showModalBottomSheet<_ScanBufferEntry>(
      context: context,
      showDragHandle: true,
      isScrollControlled: true,
      backgroundColor: Theme.of(context).colorScheme.surfaceContainerHigh,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (_) => _ScanBufferEntrySheet(entry: entry),
    );
    if (updated == null || !mounted) return;

    setState(() {
      if (updated.quantity <= 0) {
        _buffer = _buffer.where((item) => item.id != entry.id).toList();
        return;
      }
      _buffer = _buffer
          .map(
            (item) => item.id == entry.id ? updated : item,
          )
          .toList();
    });
  }

  Future<void> _saveBufferedCards() async {
    final collectionId = _selectedCollectionId;
    if (_saving || _buffer.isEmpty) return;
    if (collectionId == null || collectionId.isEmpty) {
      setState(() {
        _error = 'Escolha uma coleção antes de salvar o scan.';
      });
      return;
    }

    setState(() {
      _saving = true;
      _error = null;
    });

    try {
      final now = DateTime.now();
      for (final entry in _buffer) {
        await _recognitionService.cacheCandidate(entry.candidate);
        await appDb.collectionDao.addOrIncrementItem(
          itemId: _uuid.v4(),
          collectionId: collectionId,
          printingId: entry.candidate.printingId,
          quantity: entry.quantity,
          isFoil: entry.isFoil,
          condition: entry.condition,
          language: entry.language,
          notes: null,
          now: now,
        );
      }

      if (!mounted) return;
      setState(() {
        _buffer = const [];
        _status = 'Cartas salvas na coleção.';
      });
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Scan salvo na coleção.')),
      );
    } catch (error) {
      if (!mounted) return;
      setState(() {
        _error = 'Não foi possível salvar o scan: $error';
      });
    } finally {
      if (mounted) {
        setState(() => _saving = false);
      }
    }
  }

  Future<void> _createCollectionDialog() async {
    final controller = TextEditingController();
    try {
      final name = await showDialog<String?>(
        context: context,
        builder: (dialogContext) => AlertDialog(
          title: const Text('Nova coleção'),
          content: TextField(
            controller: controller,
            autofocus: true,
            decoration: const InputDecoration(
              labelText: 'Nome',
              hintText: 'Ex.: Binder, Trade, Staples',
            ),
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.of(dialogContext).pop(null),
              child: const Text('Cancelar'),
            ),
            ElevatedButton(
              onPressed: () =>
                  Navigator.of(dialogContext).pop(controller.text.trim()),
              child: const Text('Criar'),
            ),
          ],
        ),
      );

      if (name == null || name.isEmpty) return;
      final id = _uuid.v4();
      final now = DateTime.now();
      await appDb.collectionDao.createCollection(
        id: id,
        name: name,
        now: now,
      );
      if (!mounted) return;
      setState(() => _selectedCollectionId = id);
    } finally {
      controller.dispose();
    }
  }

  @override
  Widget build(BuildContext context) {
    if (!_scanSupported) {
      return const Scaffold(
        appBar: ManaTabMainAppBar(title: 'Scan'),
        body: ManaEmptyState(
          icon: Icons.qr_code_scanner_rounded,
          title: 'Scan disponível em Android e iOS',
          subtitle:
              'Use um dispositivo móvel com câmera para reconhecer cartas.',
        ),
      );
    }

    return Scaffold(
      appBar: const ManaTabMainAppBar(title: 'Scan'),
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16, 8, 16, 100),
        child: Column(
          children: [
            Expanded(
              flex: 5,
              child: _buildCameraPanel(context),
            ),
            const SizedBox(height: 12),
            _buildControlsCard(context),
            const SizedBox(height: 12),
            Expanded(
              flex: 3,
              child: _buildBufferPanel(context),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildCameraPanel(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final controller = _cameraController;
    final initialized = controller != null && controller.value.isInitialized;

    return ClipRRect(
      borderRadius: BorderRadius.circular(18),
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: Colors.black,
          border: Border.all(
            color: scheme.outlineVariant.withValues(alpha: 0.55),
          ),
        ),
        child: Stack(
          fit: StackFit.expand,
          children: [
            if (initialized)
              CameraPreview(controller)
            else
              Center(
                child: _cameraLoading
                    ? const CircularProgressIndicator()
                    : Icon(
                        Icons.no_photography_outlined,
                        color: scheme.onSurfaceVariant,
                        size: 48,
                      ),
              ),
            if (initialized) const _ScanFrameOverlay(),
            Positioned(
              left: 12,
              right: 12,
              bottom: 12,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: Colors.black.withValues(alpha: 0.58),
                  borderRadius: BorderRadius.circular(14),
                  border: Border.all(
                    color: Colors.white.withValues(alpha: 0.10),
                  ),
                ),
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 12,
                    vertical: 10,
                  ),
                  child: Text(
                    _error ?? _status,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                    style: Theme.of(context).textTheme.bodySmall?.copyWith(
                          color: _error == null
                              ? Colors.white
                              : scheme.errorContainer,
                          fontWeight: FontWeight.w700,
                        ),
                  ),
                ),
              ),
            ),
            if (_scanning)
              Positioned(
                left: 0,
                right: 0,
                top: 0,
                child: LinearProgressIndicator(
                  minHeight: 3,
                  color: scheme.primary,
                  backgroundColor: Colors.transparent,
                ),
              ),
          ],
        ),
      ),
    );
  }

  Widget _buildControlsCard(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    final canScan = !_scanning &&
        !_cameraLoading &&
        (_cameraController?.value.isInitialized ?? false);

    return ManaSurfaceCard(
      padding: const EdgeInsets.all(12),
      child: Column(
        children: [
          Row(
            children: [
              Expanded(child: _buildCollectionSelector()),
              const SizedBox(width: 8),
              IconButton.filledTonal(
                tooltip: 'Nova coleção',
                onPressed: _saving ? null : _createCollectionDialog,
                icon: const Icon(Icons.create_new_folder_outlined),
              ),
            ],
          ),
          const SizedBox(height: 10),
          Row(
            children: [
              Expanded(
                child: FilledButton.icon(
                  onPressed: canScan ? _captureAndRecognize : null,
                  icon: _scanning
                      ? const SizedBox(
                          width: 18,
                          height: 18,
                          child: CircularProgressIndicator(strokeWidth: 2),
                        )
                      : const Icon(Icons.center_focus_strong_rounded),
                  label: const Text('Escanear'),
                ),
              ),
              const SizedBox(width: 10),
              Expanded(
                child: OutlinedButton.icon(
                  onPressed:
                      _buffer.isEmpty || _saving ? null : _saveBufferedCards,
                  style: OutlinedButton.styleFrom(
                    foregroundColor: scheme.secondary,
                  ),
                  icon: _saving
                      ? const SizedBox(
                          width: 18,
                          height: 18,
                          child: CircularProgressIndicator(strokeWidth: 2),
                        )
                      : const Icon(Icons.library_add_check_outlined),
                  label: Text('Salvar ($_totalBuffered)'),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildCollectionSelector() {
    return StreamBuilder<List<Collection>>(
      stream: appDb.collectionDao.watchCollections(),
      builder: (context, snapshot) {
        final collections = snapshot.data ?? const <Collection>[];
        if (collections.isEmpty) {
          return OutlinedButton.icon(
            onPressed: _saving ? null : _createCollectionDialog,
            icon: const Icon(Icons.create_new_folder_outlined),
            label: const Text('Criar coleção'),
          );
        }

        final selected = collections.any((c) => c.id == _selectedCollectionId)
            ? _selectedCollectionId
            : collections.first.id;
        if (_selectedCollectionId != selected) {
          WidgetsBinding.instance.addPostFrameCallback((_) {
            if (mounted) setState(() => _selectedCollectionId = selected);
          });
        }

        return DropdownButtonFormField<String>(
          initialValue: selected,
          isExpanded: true,
          decoration: const InputDecoration(
            labelText: 'Salvar em',
            prefixIcon: Icon(Icons.folder_special_outlined),
          ),
          items: collections
              .map(
                (collection) => DropdownMenuItem(
                  value: collection.id,
                  child: Text(
                    collection.name,
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                  ),
                ),
              )
              .toList(),
          onChanged: _saving
              ? null
              : (value) => setState(() => _selectedCollectionId = value),
        );
      },
    );
  }

  Widget _buildBufferPanel(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    if (_buffer.isEmpty) {
      return ManaSurfaceCard(
        padding: const EdgeInsets.all(16),
        child: Row(
          children: [
            Icon(
              Icons.style_outlined,
              color: scheme.primary,
              size: 34,
            ),
            const SizedBox(width: 12),
            Expanded(
              child: Text(
                'As cartas reconhecidas ficam aqui antes de serem salvas.',
                style: Theme.of(context).textTheme.bodyMedium?.copyWith(
                      color: scheme.onSurfaceVariant,
                      fontWeight: FontWeight.w600,
                    ),
              ),
            ),
          ],
        ),
      );
    }

    return ListView.separated(
      scrollDirection: Axis.horizontal,
      itemCount: _buffer.length,
      separatorBuilder: (_, __) => const SizedBox(width: 10),
      itemBuilder: (context, index) {
        final entry = _buffer[index];
        return SizedBox(
          width: 250,
          child: _ScanBufferTile(
            entry: entry,
            onTap: () => _openBufferEntryEditor(entry),
            onRemove: () {
              setState(() {
                _buffer = _buffer.where((item) => item.id != entry.id).toList();
              });
            },
          ),
        );
      },
    );
  }

  String _cameraErrorMessage(CameraException error) {
    switch (error.code) {
      case 'CameraAccessDenied':
      case 'CameraAccessDeniedWithoutPrompt':
      case 'CameraAccessRestricted':
        return 'Permissão da câmera negada. Ative a permissão e tente novamente.';
      case 'NoCamera':
        return 'Nenhuma câmera foi encontrada neste dispositivo.';
      default:
        return 'Não foi possível abrir a câmera: ${error.description ?? error.code}';
    }
  }
}

class _ScanBufferEntry {
  const _ScanBufferEntry({
    required this.id,
    required this.candidate,
    required this.quantity,
    required this.confidence,
    required this.firstSeenAt,
    required this.lastSeenAt,
    this.isFoil = false,
    this.condition = 'NM',
    this.language = 'EN',
  });

  final String id;
  final ScanRecognitionCandidate candidate;
  final int quantity;
  final double confidence;
  final DateTime firstSeenAt;
  final DateTime lastSeenAt;
  final bool isFoil;
  final String condition;
  final String language;

  String get variantKey => variantKeyFor(
        candidate.printingId,
        isFoil: isFoil,
        condition: condition,
        language: language,
      );

  static String variantKeyFor(
    String printingId, {
    required bool isFoil,
    required String condition,
    required String language,
  }) {
    return [
      printingId,
      isFoil ? 'foil' : 'nonfoil',
      condition.trim().toUpperCase(),
      language.trim().toUpperCase(),
    ].join('|');
  }

  _ScanBufferEntry copyWith({
    int? quantity,
    double? confidence,
    DateTime? lastSeenAt,
    bool? isFoil,
    String? condition,
    String? language,
  }) {
    return _ScanBufferEntry(
      id: id,
      candidate: candidate,
      quantity: quantity ?? this.quantity,
      confidence: confidence ?? this.confidence,
      firstSeenAt: firstSeenAt,
      lastSeenAt: lastSeenAt ?? this.lastSeenAt,
      isFoil: isFoil ?? this.isFoil,
      condition: condition ?? this.condition,
      language: language ?? this.language,
    );
  }
}

class _ScanFrameOverlay extends StatelessWidget {
  const _ScanFrameOverlay();

  @override
  Widget build(BuildContext context) {
    return IgnorePointer(
      child: Center(
        child: FractionallySizedBox(
          widthFactor: 0.72,
          heightFactor: 0.72,
          child: DecoratedBox(
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(18),
              border: Border.all(
                color: Colors.white.withValues(alpha: 0.82),
                width: 2,
              ),
              boxShadow: [
                BoxShadow(
                  color: Theme.of(
                    context,
                  ).colorScheme.primary.withValues(alpha: 0.30),
                  blurRadius: 22,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

class _ScanBufferTile extends StatelessWidget {
  const _ScanBufferTile({
    required this.entry,
    required this.onTap,
    required this.onRemove,
  });

  final _ScanBufferEntry entry;
  final VoidCallback onTap;
  final VoidCallback onRemove;

  @override
  Widget build(BuildContext context) {
    final candidate = entry.candidate;
    return ManaSurfaceCard(
      onTap: onTap,
      padding: const EdgeInsets.all(10),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          CachedCardThumbnail(
            imageUrl: candidate.imageSmall,
            width: 52,
            height: 72,
          ),
          const SizedBox(width: 10),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  candidate.name,
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                  style: Theme.of(context).textTheme.titleSmall?.copyWith(
                        fontWeight: FontWeight.w800,
                      ),
                ),
                const SizedBox(height: 6),
                Wrap(
                  spacing: 6,
                  runSpacing: 6,
                  children: [
                    ManaChip(
                      label: candidate.editionLabel,
                      tone: ManaChipTone.blue,
                    ),
                    ManaChip(label: entry.condition),
                    if (entry.isFoil)
                      const ManaChip(label: 'FOIL', tone: ManaChipTone.gold),
                  ],
                ),
              ],
            ),
          ),
          Column(
            children: [
              Text(
                '×${entry.quantity}',
                style: Theme.of(context).textTheme.titleMedium?.copyWith(
                      fontWeight: FontWeight.w900,
                    ),
              ),
              IconButton(
                tooltip: 'Remover',
                onPressed: onRemove,
                icon: const Icon(Icons.close_rounded, size: 18),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class _RecognitionReviewSheet extends StatelessWidget {
  const _RecognitionReviewSheet({required this.result});

  final ScanRecognitionResult result;

  @override
  Widget build(BuildContext context) {
    final scheme = Theme.of(context).colorScheme;
    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.75,
      minChildSize: 0.45,
      maxChildSize: 0.95,
      builder: (context, controller) {
        return SafeArea(
          top: false,
          child: Padding(
            padding: const EdgeInsets.fromLTRB(16, 10, 16, 16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Text(
                  'Confirmar carta',
                  textAlign: TextAlign.center,
                  style: Theme.of(context).textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                const SizedBox(height: 8),
                Text(
                  'O reconhecimento não passou do limite automático.',
                  textAlign: TextAlign.center,
                  style: Theme.of(context).textTheme.bodySmall?.copyWith(
                        color: scheme.onSurfaceVariant,
                      ),
                ),
                const SizedBox(height: 12),
                Expanded(
                  child: ListView.separated(
                    controller: controller,
                    itemCount: result.candidates.length,
                    separatorBuilder: (_, __) => const SizedBox(height: 10),
                    itemBuilder: (context, index) {
                      final candidate = result.candidates[index];
                      return ManaSurfaceCard(
                        onTap: () => Navigator.of(context).pop(candidate),
                        padding: const EdgeInsets.all(12),
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            CachedCardThumbnail(
                              imageUrl: candidate.imageSmall,
                              width: 52,
                              height: 72,
                            ),
                            const SizedBox(width: 12),
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    candidate.name,
                                    style: Theme.of(context)
                                        .textTheme
                                        .titleSmall
                                        ?.copyWith(
                                          fontWeight: FontWeight.w800,
                                        ),
                                  ),
                                  const SizedBox(height: 4),
                                  Text(
                                    candidate.typeLine,
                                    maxLines: 2,
                                    overflow: TextOverflow.ellipsis,
                                    style: Theme.of(context)
                                        .textTheme
                                        .bodySmall
                                        ?.copyWith(
                                          color: scheme.onSurfaceVariant,
                                        ),
                                  ),
                                  const SizedBox(height: 6),
                                  Wrap(
                                    spacing: 6,
                                    children: [
                                      ManaChip(
                                        label: candidate.editionLabel,
                                        tone: ManaChipTone.blue,
                                      ),
                                      ManaChip(
                                        label:
                                            '${(candidate.score * 100).round()}%',
                                        tone: ManaChipTone.primary,
                                      ),
                                    ],
                                  ),
                                ],
                              ),
                            ),
                            Icon(
                              Icons.chevron_right_rounded,
                              color: scheme.onSurfaceVariant,
                            ),
                          ],
                        ),
                      );
                    },
                  ),
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}

class _ScanBufferEntrySheet extends StatefulWidget {
  const _ScanBufferEntrySheet({required this.entry});

  final _ScanBufferEntry entry;

  @override
  State<_ScanBufferEntrySheet> createState() => _ScanBufferEntrySheetState();
}

class _ScanBufferEntrySheetState extends State<_ScanBufferEntrySheet> {
  late int _quantity;
  late bool _isFoil;
  late String _condition;
  late String _language;

  @override
  void initState() {
    super.initState();
    _quantity = widget.entry.quantity;
    _isFoil = widget.entry.isFoil;
    _condition = widget.entry.condition;
    _language = widget.entry.language;
  }

  @override
  Widget build(BuildContext context) {
    final candidate = widget.entry.candidate;
    final bottom = MediaQuery.of(context).viewInsets.bottom;

    return SafeArea(
      top: false,
      child: Padding(
        padding:
            EdgeInsets.only(left: 16, right: 16, top: 10, bottom: 16 + bottom),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              candidate.name,
              textAlign: TextAlign.center,
              style: Theme.of(context).textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
            ),
            const SizedBox(height: 4),
            Text(
              candidate.editionLabel,
              textAlign: TextAlign.center,
              style: Theme.of(context).textTheme.bodySmall,
            ),
            const SizedBox(height: 14),
            Row(
              children: [
                const Text('Quantidade'),
                const Spacer(),
                IconButton(
                  onPressed:
                      _quantity <= 1 ? null : () => setState(() => _quantity--),
                  icon: const Icon(Icons.remove_rounded),
                ),
                Text(
                  '$_quantity',
                  style: Theme.of(context).textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.w900,
                      ),
                ),
                IconButton(
                  onPressed: () => setState(() => _quantity++),
                  icon: const Icon(Icons.add_rounded),
                ),
              ],
            ),
            DropdownButtonFormField<String>(
              initialValue: _condition,
              decoration: const InputDecoration(labelText: 'Condição'),
              items: const [
                DropdownMenuItem(value: 'NM', child: Text('NM (Near Mint)')),
                DropdownMenuItem(
                    value: 'SP', child: Text('SP (Slightly Played)')),
                DropdownMenuItem(
                    value: 'MP', child: Text('MP (Moderately Played)')),
                DropdownMenuItem(
                    value: 'HP', child: Text('HP (Heavily Played)')),
                DropdownMenuItem(value: 'DMG', child: Text('DMG (Damaged)')),
              ],
              onChanged: (value) => setState(() => _condition = value ?? 'NM'),
            ),
            const SizedBox(height: 10),
            SwitchListTile(
              contentPadding: EdgeInsets.zero,
              title: const Text('Foil'),
              value: _isFoil,
              onChanged: (value) => setState(() => _isFoil = value),
            ),
            DropdownButtonFormField<String>(
              initialValue: _language,
              decoration: const InputDecoration(labelText: 'Idioma'),
              items: const [
                DropdownMenuItem(value: 'EN', child: Text('EN (Inglês)')),
                DropdownMenuItem(value: 'BR', child: Text('BR (Português)')),
              ],
              onChanged: (value) => setState(() => _language = value ?? 'EN'),
            ),
            const SizedBox(height: 16),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton(
                    onPressed: () => Navigator.of(context).pop(
                      widget.entry.copyWith(quantity: 0),
                    ),
                    child: const Text('Remover'),
                  ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: FilledButton(
                    onPressed: () => Navigator.of(context).pop(
                      widget.entry.copyWith(
                        quantity: _quantity,
                        isFoil: _isFoil,
                        condition: _condition,
                        language: _language,
                      ),
                    ),
                    child: const Text('Salvar'),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
