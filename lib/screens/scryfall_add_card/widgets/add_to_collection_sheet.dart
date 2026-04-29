import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:uuid/uuid.dart';

import '../../../app/router.dart' show AppRoutes, rootNavigatorKey;
import '../../../data/local/db/db_instance.dart';
import '../../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../../data/remote/scryfall/scryfall_client.dart';

class AddToCollectionSheet extends StatefulWidget {
  const AddToCollectionSheet({
    super.key,
    required this.defaultCollectionId,
    required this.initialPrintingId,
    required this.oracleId,
  });

  final String defaultCollectionId;
  final String initialPrintingId;
  final String oracleId;

  @override
  State<AddToCollectionSheet> createState() => _AddToCollectionSheetState();
}

class _AddToCollectionSheetState extends State<AddToCollectionSheet> {
  final _uuid = const Uuid();
  final _cacheService = ScryfallCacheService();

  String? _collectionId;
  String _printingId = '';
  int _qty = 1;
  bool _foil = false;
  String _condition = 'NM';
  String _language = 'EN';

  bool _saving = false;

  @override
  void initState() {
    super.initState();
    _collectionId = widget.defaultCollectionId;
    _printingId = widget.initialPrintingId;
  }

  Future<void> _selectPrinting() async {
    final navCtx = rootNavigatorKey.currentContext;
    if (navCtx == null || !navCtx.mounted) return;

    final selected = await GoRouter.of(navCtx).pushNamed<String>(
      AppRoutes.selectPrinting,
      extra: <String, String>{
        'oracleId': widget.oracleId,
        'selectedPrintingId': _printingId,
      },
    );

    if (selected != null && mounted) {
      setState(() => _printingId = selected);
    }
  }

  /// Garante que o printing selecionado existe em ScryfallPrintings (cache local),
  /// senão o JOIN da listagem da coleção pode esconder o item.
  Future<void> _ensurePrintingCached(String printingId) async {
    await _cacheService.ensurePrintingCached(printingId);
  }

  Future<void> _save() async {
    final colId = _collectionId;
    if (colId == null) return;

    setState(() => _saving = true);

    try {
      await _ensurePrintingCached(_printingId);

      final now = DateTime.now();
      await appDb.collectionDao.addOrIncrementItem(
        itemId: _uuid.v4(),
        collectionId: colId,
        printingId: _printingId,
        quantity: _qty,
        isFoil: _foil,
        condition: _condition,
        language: _language,
        notes: null,
        now: now,
      );

      if (mounted) Navigator.pop(context);
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final bottom = MediaQuery.of(context).viewInsets.bottom;

    return Padding(
      padding:
          EdgeInsets.only(left: 16, right: 16, top: 16, bottom: 16 + bottom),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          const Text(
            'Adicionar à coleção',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.w600),
          ),
          const SizedBox(height: 12),
          Row(
            children: [
              const Text('Quantidade'),
              const Spacer(),
              IconButton(
                onPressed: (_saving || _qty <= 1)
                    ? null
                    : () => setState(() => _qty--),
                icon: const Icon(Icons.remove),
              ),
              Text('$_qty', style: const TextStyle(fontSize: 16)),
              IconButton(
                onPressed: _saving ? null : () => setState(() => _qty++),
                icon: const Icon(Icons.add),
              ),
            ],
          ),
          DropdownButtonFormField<String>(
            value: _condition,
            decoration: const InputDecoration(labelText: 'Condição'),
            items: const [
              DropdownMenuItem(value: 'NM', child: Text('NM (Near Mint)')),
              DropdownMenuItem(
                  value: 'SP', child: Text('SP (Slightly Played)')),
              DropdownMenuItem(
                  value: 'MP', child: Text('MP (Moderately Played)')),
              DropdownMenuItem(value: 'HP', child: Text('HP (Heavily Played)')),
              DropdownMenuItem(value: 'DMG', child: Text('DMG (Damaged)')),
            ],
            onChanged:
                _saving ? null : (v) => setState(() => _condition = v ?? 'NM'),
          ),
          const SizedBox(height: 12),
          SwitchListTile(
            contentPadding: EdgeInsets.zero,
            title: const Text('Foil'),
            value: _foil,
            onChanged: _saving ? null : (v) => setState(() => _foil = v),
          ),
          DropdownButtonFormField<String>(
            value: _language,
            decoration: const InputDecoration(labelText: 'Idioma'),
            items: const [
              DropdownMenuItem(value: 'EN', child: Text('EN (Inglês)')),
              DropdownMenuItem(value: 'BR', child: Text('BR (Português)')),
            ],
            onChanged:
                _saving ? null : (v) => setState(() => _language = v ?? 'EN'),
          ),
          const SizedBox(height: 12),
          Row(
            children: [
              Expanded(
                child: Text(
                  'Printing selecionado: $_printingId',
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              TextButton(
                onPressed: _saving ? null : _selectPrinting,
                child: const Text('Trocar edição'),
              ),
            ],
          ),
          const SizedBox(height: 12),
          Row(
            children: [
              Expanded(
                child: OutlinedButton(
                  onPressed: _saving ? null : () => Navigator.pop(context),
                  child: const Text('Cancelar'),
                ),
              ),
              const SizedBox(width: 12),
              Expanded(
                child: ElevatedButton(
                  onPressed: _saving ? null : _save,
                  child: _saving
                      ? const SizedBox(
                          width: 18,
                          height: 18,
                          child: CircularProgressIndicator(strokeWidth: 2),
                        )
                      : const Text('Adicionar'),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
