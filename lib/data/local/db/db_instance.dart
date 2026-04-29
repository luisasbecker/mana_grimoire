import 'app_database.dart';

/// Instância global do banco da aplicação.
///
/// Não chame [AppDatabase.close] a partir de ecrãs individuais: o ciclo de vida
/// do banco é o da app inteira.
final AppDatabase appDb = AppDatabase();
