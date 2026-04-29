import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';

import '../../data/local/db/daos/scryfall_cache_dao.dart';
import '../../data/local/db/db_instance.dart';
import '../../data/remote/scryfall/scryfall_cache_service.dart';
import '../../data/remote/scryfall/scryfall_client.dart';
import '../../widgets/mana_internal_app_bar.dart';

/// Ecrã de desenvolvimento para validar cache Scryfall + Drift.
class ScryfallTestScreen extends StatefulWidget {
  const ScryfallTestScreen({super.key});

  @override
  State<ScryfallTestScreen> createState() => _ScryfallTestScreenState();
}

class _ScryfallTestScreenState extends State<ScryfallTestScreen> {
  final _client = ScryfallClient();
  final _cacheService = ScryfallCacheService();

  bool _loading = false;
  String? _error;

  Future<void> _fetchAndCache() async {
    setState(() {
      _loading = true;
      _error = null;
    });

    try {
      final result = await _client.searchCards('commander');
      final top10 = result.take(10).toList();
      await _cacheService.cacheScryfallCards(top10);
    } catch (e) {
      setState(() {
        _error = e.toString();
      });
    } finally {
      setState(() {
        _loading = false;
      });
    }
  }

  Future<void> _clearCache() async {
    await appDb.scryfallCacheDao.clearAll();
    if (mounted) setState(() {});
  }

  String _formatPrice(int minor, String currency) {
    final v = (minor / 100.0).toStringAsFixed(2);
    return '$currency $v';
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: const ManaInternalAppBar(title: 'Dev · Scryfall cache'),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Row(
              children: [
                ElevatedButton(
                  onPressed: _loading ? null : _fetchAndCache,
                  child: const Text('Fetch & Cache (Top 10)'),
                ),
                const SizedBox(width: 12),
                OutlinedButton(
                  onPressed: _loading ? null : _clearCache,
                  child: const Text('Clear Cache'),
                ),
              ],
            ),
            const SizedBox(height: 12),
            if (_loading) const LinearProgressIndicator(),
            if (_error != null) ...[
              const SizedBox(height: 12),
              Text('Error:\n$_error',
                  style: const TextStyle(color: Colors.red)),
            ],
            const SizedBox(height: 12),
            Expanded(
              child: StreamBuilder<List<PrintingWithLatestPrice>>(
                stream: appDb.scryfallCacheDao.watchPrintingsWithLatestPrice(),
                builder: (context, snapshot) {
                  final rows = snapshot.data ?? const [];
                  if (rows.isEmpty) {
                    return const Center(
                        child: Text('No cached printings yet.'));
                  }

                  return ListView.separated(
                    itemCount: rows.length,
                    separatorBuilder: (_, __) => const Divider(height: 1),
                    itemBuilder: (context, index) {
                      final row = rows[index];
                      final p = row.printing;

                      final priceText =
                          (row.priceMinor != null && row.currency != null)
                              ? _formatPrice(row.priceMinor!, row.currency!)
                              : '—';

                      return ListTile(
                        leading: (p.imageSmall != null)
                            ? ClipRRect(
                                borderRadius: BorderRadius.circular(6),
                                child: CachedNetworkImage(
                                  imageUrl: p.imageSmall!,
                                  width: 48,
                                  height: 68,
                                  fit: BoxFit.cover,
                                  placeholder: (c, _) =>
                                      const SizedBox(width: 48, height: 68),
                                  errorWidget: (c, _, __) =>
                                      const Icon(Icons.image_not_supported),
                                ),
                              )
                            : const SizedBox(width: 48, height: 68),
                        title: Text(p.name),
                        subtitle: Text(
                          '${p.typeLine}\n${p.setCode.toUpperCase()} • #${p.collectorNumber} • $priceText',
                        ),
                        isThreeLine: true,
                        onTap: () {
                          showDialog<void>(
                            context: context,
                            builder: (_) => AlertDialog(
                              title: Text(p.name),
                              content: (p.imageNormal != null)
                                  ? CachedNetworkImage(
                                      imageUrl: p.imageNormal!,
                                      fit: BoxFit.contain,
                                    )
                                  : const Text('No image available.'),
                            ),
                          );
                        },
                      );
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
