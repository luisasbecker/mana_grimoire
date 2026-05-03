import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../../../app/router.dart';
import '../../../data/local/db/app_database.dart';
import '../../../data/local/db/db_instance.dart';
import '../../../data/local/db/daos/collection_dao.dart';
import '../../../data/remote/scryfall/scryfall_cache_service.dart';

class EditCollectionItemSheet extends StatefulWidget {
  const EditCollectionItemSheet({
    super.key,
    required this.row,
  });

  final CollectionItemView row;

  @override
  State<EditCollectionItemSheet> createState() =>
      _EditCollectionItemSheetState();
}

class _EditCollectionItemSheetState extends State<EditCollectionItemSheet> {
  final _cacheService = ScryfallCacheService();

  late int _qty;
  late bool _foil;
  late String _condition;
  late String _language;
  late ScryfallPrinting _selectedPrinting;

  bool _saving = false;
  bool _changingPrinting = false;

  @override
  void initState() {
    super.initState();
    final it = widget.row.item;
    _qty = it.quantity;
    _foil = it.isFoil;
    _condition = it.condition;
    _language = it.language;
    _selectedPrinting = widget.row.printing;
  }

  Future<void> _save() async {
    setState(() => _saving = true);
    try {
      final now = DateTime.now();
      await appDb.collectionDao.updateItemAndPrintingMerge(
        itemId: widget.row.item.id,
        newPrintingId: _selectedPrinting.printingId,
        quantity: _qty,
        isFoil: _foil,
        condition: _condition,
        language: _language,
        notes: widget.row.item.notes,
        now: now,
      );
      if (mounted) Navigator.pop(context);
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  Future<void> _selectPrinting() async {
    if (_saving || _changingPrinting) return;

    final rootContext = rootNavigatorKey.currentContext;
    final navContext = rootContext ?? context;
    final selected = await GoRouter.of(navContext).pushNamed<String>(
      AppRoutes.selectPrinting,
      extra: {
        'oracleId': _selectedPrinting.oracleId,
        'selectedPrintingId': _selectedPrinting.printingId,
      },
    );
    if (selected == null ||
        selected.isEmpty ||
        selected == _selectedPrinting.printingId) {
      return;
    }

    setState(() => _changingPrinting = true);
    try {
      await _cacheService.ensurePrintingCached(selected);
      final printing = await _printingById(selected);
      if (printing == null) {
        throw StateError('Edição selecionada não foi encontrada no cache.');
      }
      if (!mounted) return;
      setState(() => _selectedPrinting = printing);
    } catch (error) {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Não foi possível trocar edição: $error')),
      );
    } finally {
      if (mounted) setState(() => _changingPrinting = false);
    }
  }

  Future<ScryfallPrinting?> _printingById(String printingId) {
    return (appDb.select(appDb.scryfallPrintings)
          ..where((table) => table.printingId.equals(printingId)))
        .getSingleOrNull();
  }

  Future<void> _remove() async {
    final ok = await showDialog<bool>(
      context: context,
      builder: (dialogContext) => AlertDialog(
        title: const Text('Remover carta'),
        content: const Text('Deseja remover este item da coleção?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(dialogContext).pop(false),
            child: const Text('Cancelar'),
          ),
          ElevatedButton(
            onPressed: () => Navigator.of(dialogContext).pop(true),
            child: const Text('Remover'),
          ),
        ],
      ),
    );

    if (ok != true) return;

    setState(() => _saving = true);
    try {
      await appDb.collectionDao.deleteItem(widget.row.item.id);
      if (mounted) Navigator.pop(context);
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final bottom = MediaQuery.of(context).viewInsets.bottom;
    final p = _selectedPrinting;

    return SafeArea(
      top: false,
      child: Padding(
        padding:
            EdgeInsets.only(left: 16, right: 16, top: 16, bottom: 16 + bottom),
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                p.name,
                style:
                    const TextStyle(fontSize: 18, fontWeight: FontWeight.w600),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 6),
              Text(
                '${p.setName} (${p.setCode.toUpperCase()}) • #${p.collectorNumber}',
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 10),
              OutlinedButton.icon(
                onPressed:
                    (_saving || _changingPrinting) ? null : _selectPrinting,
                icon: _changingPrinting
                    ? const SizedBox.square(
                        dimension: 16,
                        child: CircularProgressIndicator(strokeWidth: 2),
                      )
                    : const Icon(Icons.layers_rounded),
                label: const Text('Trocar edição'),
              ),
              const SizedBox(height: 12),
              Row(
                children: [
                  const Expanded(
                    child: Text(
                      'Quantidade',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ),
                  IconButton(
                    onPressed: (_saving || _qty <= 1)
                        ? null
                        : () => setState(() => _qty--),
                    constraints:
                        const BoxConstraints.tightFor(width: 40, height: 40),
                    icon: const Icon(Icons.remove),
                  ),
                  Text('$_qty', style: const TextStyle(fontSize: 16)),
                  IconButton(
                    onPressed: _saving ? null : () => setState(() => _qty++),
                    constraints:
                        const BoxConstraints.tightFor(width: 40, height: 40),
                    icon: const Icon(Icons.add),
                  ),
                ],
              ),
              DropdownButtonFormField<String>(
                initialValue: _condition,
                isExpanded: true,
                decoration: const InputDecoration(labelText: 'Condição'),
                items: const [
                  DropdownMenuItem(value: 'NM', child: Text('NM (Near Mint)')),
                  DropdownMenuItem(
                    value: 'SP',
                    child: Text(
                      'SP (Slightly Played)',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ),
                  DropdownMenuItem(
                    value: 'MP',
                    child: Text(
                      'MP (Moderately Played)',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ),
                  DropdownMenuItem(
                    value: 'HP',
                    child: Text(
                      'HP (Heavily Played)',
                      maxLines: 1,
                      overflow: TextOverflow.ellipsis,
                    ),
                  ),
                  DropdownMenuItem(value: 'DMG', child: Text('DMG (Damaged)')),
                ],
                onChanged: _saving
                    ? null
                    : (v) => setState(() => _condition = v ?? 'NM'),
              ),
              const SizedBox(height: 12),
              SwitchListTile(
                contentPadding: EdgeInsets.zero,
                title: const Text('Foil'),
                value: _foil,
                onChanged: _saving ? null : (v) => setState(() => _foil = v),
              ),
              DropdownButtonFormField<String>(
                initialValue: _language,
                isExpanded: true,
                decoration: const InputDecoration(labelText: 'Idioma'),
                items: const [
                  DropdownMenuItem(value: 'EN', child: Text('EN (Inglês)')),
                  DropdownMenuItem(value: 'BR', child: Text('BR (Português)')),
                ],
                onChanged: _saving
                    ? null
                    : (v) => setState(() => _language = v ?? 'EN'),
              ),
              const SizedBox(height: 16),
              LayoutBuilder(
                builder: (context, constraints) {
                  final removeButton = OutlinedButton(
                    onPressed: _saving ? null : _remove,
                    child: const Text('Remover'),
                  );
                  final saveButton = ElevatedButton(
                    onPressed: _saving ? null : _save,
                    child: _saving
                        ? const SizedBox(
                            width: 18,
                            height: 18,
                            child: CircularProgressIndicator(strokeWidth: 2),
                          )
                        : const Text('Salvar'),
                  );
                  if (constraints.maxWidth < 340) {
                    return Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        removeButton,
                        const SizedBox(height: 8),
                        saveButton,
                      ],
                    );
                  }
                  return Row(
                    children: [
                      Expanded(child: removeButton),
                      const SizedBox(width: 12),
                      Expanded(child: saveButton),
                    ],
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
