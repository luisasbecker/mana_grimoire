import 'package:flutter/material.dart';
import 'package:mana_grimoire/l10n/app_localizations.dart';

Future<String?> showCreateCollectionDialog(BuildContext context) {
  return showDialog<String>(
    context: context,
    builder: (_) => const CreateCollectionDialog(),
  );
}

class CreateCollectionDialog extends StatefulWidget {
  const CreateCollectionDialog({super.key});

  @override
  State<CreateCollectionDialog> createState() => _CreateCollectionDialogState();
}

class _CreateCollectionDialogState extends State<CreateCollectionDialog> {
  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();

  @override
  void dispose() {
    _nameController.dispose();
    super.dispose();
  }

  void _submit() {
    if (_formKey.currentState?.validate() != true) return;
    Navigator.of(context).pop(_nameController.text.trim());
  }

  @override
  Widget build(BuildContext context) {
    final t = AppLocalizations.of(context)!;

    return AlertDialog(
      title: Text(t.newCollectionTitle),
      content: Form(
        key: _formKey,
        child: TextFormField(
          controller: _nameController,
          autofocus: true,
          textInputAction: TextInputAction.done,
          textCapitalization: TextCapitalization.words,
          decoration: InputDecoration(
            labelText: t.newCollectionNameLabel,
            hintText: t.newCollectionNameHint,
          ),
          validator: (value) {
            if (value == null || value.trim().isEmpty) {
              return t.newCollectionNameRequired;
            }
            return null;
          },
          onFieldSubmitted: (_) => _submit(),
        ),
      ),
      actions: [
        TextButton(
          onPressed: () => Navigator.of(context).pop(null),
          child: Text(t.cancel),
        ),
        ElevatedButton(
          onPressed: _submit,
          child: Text(t.create),
        ),
      ],
    );
  }
}
