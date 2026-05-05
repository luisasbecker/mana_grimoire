import 'package:flutter/material.dart';

/// Tema escuro principal — referência leve a MTG (mana) com layout limpo estilo hub.
abstract final class ManaTheme {
  // Dracula palette (core)
  static const Color _bg = Color(0xFF282A36);
  static const Color _surfaceLow = Color(0xFF303241);
  static const Color _surfaceHigh = Color(0xFF3A3D4F);
  static const Color _selection = Color(0xFF44475A);
  static const Color _currentLine = Color(0xFF6272A4);
  static const Color _fg = Color(0xFFF8F8F2);
  static const Color _comment = Color(0xFFB8B9C8);

  // Dracula accents
  static const Color _red = Color(0xFFFF5555);
  static const Color _cyan = Color(0xFF8BE9FD);
  static const Color _purple = Color(0xFFBD93F9);
  static const Color _pink = Color(0xFFFF79C6);

  static ThemeData dark() {
    // Nota: mantemos M3, mas com ColorScheme explícito para garantir consistência Dracula.
    final base = ColorScheme.fromSeed(
      seedColor: _purple,
      brightness: Brightness.dark,
      surface: _bg,
      surfaceContainerLowest: _bg,
      surfaceContainerLow: _surfaceLow,
      surfaceContainer: _surfaceHigh,
      surfaceContainerHigh: _selection,
      surfaceContainerHighest: _currentLine.withValues(alpha: 0.35),
      secondary: _cyan,
      tertiary: _purple,
    );

    return ThemeData(
      useMaterial3: true,
      brightness: Brightness.dark,
      colorScheme: base.copyWith(
        primary: _purple,
        onPrimary: _bg,
        primaryContainer: _currentLine.withValues(alpha: 0.55),
        onPrimaryContainer: _fg,
        secondary: _cyan,
        onSecondary: _bg,
        secondaryContainer: _cyan.withValues(alpha: 0.18),
        onSecondaryContainer: _fg,
        tertiary: _pink,
        onTertiary: _bg,
        tertiaryContainer: _pink.withValues(alpha: 0.18),
        onTertiaryContainer: _fg,
        surface: _bg,
        onSurface: _fg,
        onSurfaceVariant: _comment,
        outline: _currentLine.withValues(alpha: 0.9),
        outlineVariant: _selection.withValues(alpha: 0.9),
        error: _red,
        onError: _bg,
        errorContainer: _red.withValues(alpha: 0.2),
        onErrorContainer: _fg,
      ),
      scaffoldBackgroundColor: _bg,
      textTheme: Typography.whiteCupertino.apply(
        bodyColor: _fg,
        displayColor: _fg,
      ),
      appBarTheme: AppBarTheme(
        elevation: 0,
        scrolledUnderElevation: 0,
        centerTitle: true,
        backgroundColor: _bg,
        foregroundColor: _fg,
        titleTextStyle: TextStyle(
          fontSize: 18,
          fontWeight: FontWeight.w600,
          letterSpacing: 0.2,
          color: _fg,
        ),
      ),
      navigationBarTheme: NavigationBarThemeData(
        elevation: 0,
        height: 72,
        backgroundColor: _selection,
        indicatorColor: _purple.withValues(alpha: 0.22),
        labelTextStyle: WidgetStateProperty.resolveWith((states) {
          final selected = states.contains(WidgetState.selected);
          return TextStyle(
            fontSize: 12,
            fontWeight: selected ? FontWeight.w600 : FontWeight.w500,
            letterSpacing: 0.1,
          );
        }),
      ),
      cardTheme: CardThemeData(
        elevation: 0,
        color: _surfaceHigh,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(18)),
        clipBehavior: Clip.antiAlias,
      ),
      dialogTheme: DialogThemeData(
        backgroundColor: _selection,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      ),
      inputDecorationTheme: InputDecorationTheme(
        filled: true,
        fillColor: _selection.withValues(alpha: 0.72),
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(16),
          borderSide: BorderSide.none,
        ),
        enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(16),
          borderSide: BorderSide(color: _currentLine.withValues(alpha: 0.45)),
        ),
        focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(16),
          borderSide: BorderSide(color: _purple, width: 1.5),
        ),
        contentPadding:
            const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
      ),
      chipTheme: ChipThemeData(
        padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 0),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
        side: BorderSide.none,
        backgroundColor: _selection.withValues(alpha: 0.72),
        labelStyle: TextStyle(
          fontSize: 11,
          fontWeight: FontWeight.w700,
          color: _comment,
        ),
      ),
      filledButtonTheme: FilledButtonThemeData(
        style: FilledButton.styleFrom(
          minimumSize: const Size(48, 46),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(14),
          ),
          textStyle: const TextStyle(fontWeight: FontWeight.w800),
        ),
      ),
      outlinedButtonTheme: OutlinedButtonThemeData(
        style: OutlinedButton.styleFrom(
          minimumSize: const Size(48, 46),
          side: BorderSide(color: _currentLine.withValues(alpha: 0.55)),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(14),
          ),
          textStyle: const TextStyle(fontWeight: FontWeight.w800),
        ),
      ),
      floatingActionButtonTheme: FloatingActionButtonThemeData(
        elevation: 2,
        highlightElevation: 4,
        backgroundColor: _purple,
        foregroundColor: _bg,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      ),
    );
  }
}
