import 'package:flutter/material.dart';

import '../../../data/local/db/db_instance.dart';
import '../../../data/local/db/daos/collection_dao.dart';

class EditCollectionItemSheet extends StatefulWidget {
  const EditCollectionItemSheet({
    super.key,
    required this.row,
  });

  final CollectionItemView row;

  @override
  State<EditCollectionItemSheet> createState() => _EditCollectionItemSheetState();
}

class _EditCollectionItemSheetState extends State<EditCollectionItemSheet> {
  late int _qty;
  late bool _foil;
  late String _condition;
  late String _language;

  bool _saving = false;

  @override
  void initState() {
    super.initState();
    final it = widget.row.item;
    _qty = it.quantity;
    _foil = it.isFoil;
    _condition = it.condition;
    _language = it.language;
  }

  Future<void> _save() async {
    setState(() => _saving = true);
    try {
      final now = DateTime.now();
      await appDb.collectionDao.updateItem(
        itemId: widget.row.item.id,
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
    final p = widget.row.printing;

    return Padding(
      padding: EdgeInsets.only(left: 16, right: 16, top: 16, bottom: 16 + bottom),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text(
            p.name,
            style: const TextStyle(fontSize: 18, fontWeight: FontWeight.w600),
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: 6),
          Text('${p.setCode.toUpperCase()} • #${p.collectorNumber}'),
          const SizedBox(height: 12),

          Row(
            children: [
              const Text('Quantidade'),
              const Spacer(),
              IconButton(
                onPressed: (_saving || _qty <= 1) ? null : () => setState(() => _qty--),
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
              DropdownMenuItem(value: 'SP', child: Text('SP (Slightly Played)')),
              DropdownMenuItem(value: 'MP', child: Text('MP (Moderately Played)')),
              DropdownMenuItem(value: 'HP', child: Text('HP (Heavily Played)')),
              DropdownMenuItem(value: 'DMG', child: Text('DMG (Damaged)')),
            ],
            onChanged: _saving ? null : (v) => setState(() => _condition = v ?? 'NM'),
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
            onChanged: _saving ? null : (v) => setState(() => _language = v ?? 'EN'),
          ),

          const SizedBox(height: 16),

          Row(
            children: [
              Expanded(
                child: OutlinedButton(
                  onPressed: _saving ? null : _remove,
                  child: const Text('Remover'),
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
                      : const Text('Salvar'),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
