import 'package:flutter/material.dart';

import '../../../data/scan/catalog_scan_index.dart';
import '../../../data/scan/scan_models.dart';
import '../../../widgets/cached_card_thumbnail.dart';

class ScanBufferEntrySheet extends StatefulWidget {
  const ScanBufferEntrySheet({
    super.key,
    required this.entry,
    required this.scanIndex,
  });

  final BufferedScanEntry entry;
  final CatalogScanIndex scanIndex;

  @override
  State<ScanBufferEntrySheet> createState() => _ScanBufferEntrySheetState();
}

class _ScanBufferEntrySheetState extends State<ScanBufferEntrySheet> {
  late int _quantity;
  late bool _isFoil;
  late String _condition;
  late String _language;
  late TextEditingController _notesController;
  late ScanCatalogCard _selectedCard;
  late Future<List<ScanCatalogCard>> _printingsFuture;

  @override
  void initState() {
    super.initState();
    _quantity = widget.entry.quantity;
    _isFoil = widget.entry.isFoil;
    _condition = widget.entry.condition;
    _language = widget.entry.language;
    _notesController = TextEditingController(text: widget.entry.notes ?? '');
    _selectedCard = widget.entry.card;
    _printingsFuture =
        widget.scanIndex.printingsForName(widget.entry.card.name);
  }

  @override
  void dispose() {
    _notesController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final bottom = MediaQuery.of(context).viewInsets.bottom;
    return SafeArea(
      top: false,
      child: Padding(
        padding:
            EdgeInsets.only(left: 16, right: 16, top: 10, bottom: 16 + bottom),
        child: ListView(
          shrinkWrap: true,
          children: [
            Text(
              _selectedCard.name,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              textAlign: TextAlign.center,
              style: Theme.of(context).textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.w900,
                  ),
            ),
            const SizedBox(height: 4),
            Text(
              _selectedCard.editionLabel,
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
              textAlign: TextAlign.center,
              style: Theme.of(context).textTheme.bodySmall,
            ),
            const SizedBox(height: 14),
            Center(
              child: CachedCardThumbnail(
                imageUrl:
                    _selectedCard.imageUrlNormal ?? _selectedCard.imageUrlSmall,
                width: 120,
                height: 168,
              ),
            ),
            const SizedBox(height: 14),
            FutureBuilder<List<ScanCatalogCard>>(
              future: _printingsFuture,
              builder: (context, snapshot) {
                final printings = snapshot.data ?? const <ScanCatalogCard>[];
                if (printings.isEmpty) return const SizedBox.shrink();
                final selectedId =
                    printings.any((card) => card.id == _selectedCard.id)
                        ? _selectedCard.id
                        : null;
                return DropdownButtonFormField<String>(
                  initialValue: selectedId,
                  isExpanded: true,
                  decoration: const InputDecoration(
                    labelText: 'Impressão / edição',
                    prefixIcon: Icon(Icons.auto_stories_outlined),
                  ),
                  items: printings
                      .map(
                        (printing) => DropdownMenuItem(
                          value: printing.id,
                          child: Text(
                            '${printing.setName} (${printing.setCode.toUpperCase()}) #${printing.collectorNumber}',
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                      )
                      .toList(),
                  onChanged: (value) {
                    final nextCard = _findPrinting(printings, value);
                    if (nextCard == null) return;
                    setState(() => _selectedCard = nextCard);
                  },
                );
              },
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
                  onPressed:
                      _quantity <= 1 ? null : () => setState(() => _quantity--),
                  constraints:
                      const BoxConstraints.tightFor(width: 40, height: 40),
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
                  constraints:
                      const BoxConstraints.tightFor(width: 40, height: 40),
                  icon: const Icon(Icons.add_rounded),
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
              isExpanded: true,
              decoration: const InputDecoration(labelText: 'Idioma'),
              items: const [
                DropdownMenuItem(value: 'EN', child: Text('EN (Inglês)')),
                DropdownMenuItem(value: 'BR', child: Text('BR (Português)')),
                DropdownMenuItem(value: 'JP', child: Text('JP (Japonês)')),
                DropdownMenuItem(value: 'ES', child: Text('ES (Espanhol)')),
                DropdownMenuItem(value: 'DE', child: Text('DE (Alemão)')),
                DropdownMenuItem(value: 'FR', child: Text('FR (Francês)')),
              ],
              onChanged: (value) => setState(() => _language = value ?? 'EN'),
            ),
            const SizedBox(height: 10),
            TextField(
              controller: _notesController,
              maxLines: 3,
              maxLength: 500,
              decoration: const InputDecoration(
                labelText: 'Notas',
                prefixIcon: Icon(Icons.notes_outlined),
              ),
            ),
            const SizedBox(height: 16),
            LayoutBuilder(
              builder: (context, constraints) {
                final removeButton = OutlinedButton(
                  onPressed: () => Navigator.of(context).pop(
                    widget.entry.copyWith(quantity: 0),
                  ),
                  child: const Text('Remover'),
                );
                final saveButton = FilledButton(
                  onPressed: () {
                    final notes = _notesController.text.trim();
                    Navigator.of(context).pop(
                      widget.entry.copyWith(
                        card: _selectedCard,
                        quantity: _quantity.clamp(1, 9999),
                        isFoil: _isFoil,
                        condition: _condition,
                        language: _language,
                        notes: notes.isEmpty ? null : notes,
                        clearNotes: notes.isEmpty,
                      ),
                    );
                  },
                  child: const Text('Salvar'),
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
    );
  }

  ScanCatalogCard? _findPrinting(List<ScanCatalogCard> printings, String? id) {
    for (final printing in printings) {
      if (printing.id == id) return printing;
    }
    return null;
  }
}
