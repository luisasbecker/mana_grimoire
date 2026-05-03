import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';
import 'package:uuid/uuid.dart';

import '../../data/local/db/db_instance.dart';
import '../../widgets/mana_internal_app_bar.dart';

class CreateDeckScreen extends StatefulWidget {
  const CreateDeckScreen({super.key});

  @override
  State<CreateDeckScreen> createState() => _CreateDeckScreenState();
}

class _CreateDeckScreenState extends State<CreateDeckScreen> {
  final _uuid = const Uuid();
  final _name = TextEditingController();

  String _format = 'Commander';
  bool _saving = false;

  @override
  void dispose() {
    _name.dispose();
    super.dispose();
  }

  Future<void> _create() async {
    final name = _name.text.trim();
    if (name.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
            content:
                Text(AppLocalizations.of(context)!.createDeckNameRequired)),
      );
      return;
    }
    setState(() => _saving = true);
    try {
      final now = DateTime.now();
      await appDb.decksDao.createDeck(
        id: _uuid.v4(),
        name: name,
        format: _format,
        now: now,
      );
      if (mounted) context.pop();
    } catch (e) {
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Erro ao criar deck: $e')),
      );
    } finally {
      if (mounted) setState(() => _saving = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;
    return Scaffold(
      appBar: ManaInternalAppBar(title: t.createDeckTitle),
      body: ListView(
        padding: const EdgeInsets.fromLTRB(16, 12, 16, 24),
        children: [
          TextField(
            controller: _name,
            textInputAction: TextInputAction.done,
            onSubmitted: (_) => _saving ? null : _create(),
            decoration: InputDecoration(
              labelText: t.createDeckNameLabel,
              hintText: t.createDeckNameHint,
            ),
            autofocus: true,
          ),
          const SizedBox(height: 12),
          DropdownButtonFormField<String>(
            initialValue: _format,
            decoration: InputDecoration(labelText: t.createDeckFormatLabel),
            items: const [
              DropdownMenuItem(value: 'Commander', child: Text('Commander')),
              DropdownMenuItem(value: 'Standard', child: Text('Standard')),
              DropdownMenuItem(value: 'Pauper', child: Text('Pauper')),
              DropdownMenuItem(value: 'Modern', child: Text('Modern')),
              DropdownMenuItem(value: 'Other', child: Text('Other')),
            ],
            onChanged: _saving
                ? null
                : (v) => setState(() => _format = v ?? 'Commander'),
          ),
          const SizedBox(height: 32),
          FilledButton(
            onPressed: _saving ? null : _create,
            child: _saving
                ? const SizedBox(
                    width: 18,
                    height: 18,
                    child: CircularProgressIndicator(strokeWidth: 2),
                  )
                : Text(t.createDeckCreateButton),
          ),
        ],
      ),
    );
  }
}
