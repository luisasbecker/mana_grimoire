package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: ColorScheme.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aí\u0003\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104\u001aí\u0003\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b6\u00104\u001a\u001b\u00107\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0017\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u00020\u0003*\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001a\b\u0010B\u001a\u00020\u0001H\u0000\u001a÷\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001a±\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001a÷\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001a±\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001a\u0019\u0010I\u001a\u00020\u0003*\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001a#\u0010U\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P\"\u000e\u0010Q\u001a\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001a\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010P¨\u0006["}, d2 = {"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ColorSchemeKt.m3491lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 65535, null);
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(ColorSchemeKt.LocalTonalElevationEnabled$lambda$2());
        }
    });

    /* JADX INFO: compiled from: ColorScheme.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryFixed.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryFixedDim.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryFixed.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryFixedVariant.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryFixed.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryFixedDim.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryFixed.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryFixedVariant.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryFixed.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryFixedDim.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryFixed.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryFixedVariant.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final boolean LocalTonalElevationEnabled$lambda$2() {
        return true;
    }

    /* JADX INFO: renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m3477applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1610977682, "C(applyTonalElevation)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)1540@70581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
        }
        ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalTonalElevationEnabled;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zBooleanValue = ((Boolean) objConsume).booleanValue();
        if (Color.m6326equalsimpl0(j, colorScheme.getSurface()) && zBooleanValue) {
            j = m3492surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m3478contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m6326equalsimpl0(j, colorScheme.getPrimary())) {
            return colorScheme.getOnPrimary();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getSecondary())) {
            return colorScheme.getOnSecondary();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getTertiary())) {
            return colorScheme.getOnTertiary();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getBackground())) {
            return colorScheme.getOnBackground();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getError())) {
            return colorScheme.getOnError();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getPrimaryContainer())) {
            return colorScheme.getOnPrimaryContainer();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getSecondaryContainer())) {
            return colorScheme.getOnSecondaryContainer();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getTertiaryContainer())) {
            return colorScheme.getOnTertiaryContainer();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getErrorContainer())) {
            return colorScheme.getOnErrorContainer();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getInverseSurface())) {
            return colorScheme.getInverseOnSurface();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getSurface())) {
            return colorScheme.getOnSurface();
        }
        if (Color.m6326equalsimpl0(j, colorScheme.getSurfaceVariant())) {
            return colorScheme.getOnSurfaceVariant();
        }
        if (!Color.m6326equalsimpl0(j, colorScheme.getSurfaceBright()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceContainer()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceContainerHigh()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceContainerHighest()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceContainerLow()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceContainerLowest()) && !Color.m6326equalsimpl0(j, colorScheme.getSurfaceDim())) {
            if (!Color.m6326equalsimpl0(j, colorScheme.getPrimaryFixed()) && !Color.m6326equalsimpl0(j, colorScheme.getPrimaryFixedDim())) {
                if (!Color.m6326equalsimpl0(j, colorScheme.getSecondaryFixed()) && !Color.m6326equalsimpl0(j, colorScheme.getSecondaryFixedDim())) {
                    if (!Color.m6326equalsimpl0(j, colorScheme.getTertiaryFixed()) && !Color.m6326equalsimpl0(j, colorScheme.getTertiaryFixedDim())) {
                        return Color.INSTANCE.m6361getUnspecified0d7_KjU();
                    }
                    return colorScheme.getOnTertiaryFixed();
                }
                return colorScheme.getOnSecondaryFixed();
            }
            return colorScheme.getOnPrimaryFixed();
        }
        return colorScheme.getOnSurface();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m3479contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 509589638, "C(contentColorFor)N(backgroundColor:c#ui.graphics.Color)1112@50936L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
        }
        composer.startReplaceGroup(89374938);
        ComposerKt.sourceInformation(composer, "*1113@51020L7");
        long jM3478contentColorFor4WTKRHQ = m3478contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (jM3478contentColorFor4WTKRHQ == 16) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM3478contentColorFor4WTKRHQ = ((Color) objConsume).m6335unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM3478contentColorFor4WTKRHQ;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m3480darkColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return m3485darkColorScheme_VG5OTI$default(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3481darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long jM4822getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m4822getPrimary0d7_KjU() : j;
        long jM4806getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m4806getOnPrimary0d7_KjU() : j2;
        long jM4823getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m4823getPrimaryContainer0d7_KjU() : j3;
        long jM4807getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m4807getOnPrimaryContainer0d7_KjU() : j4;
        long jM4801getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m4801getInversePrimary0d7_KjU() : j5;
        long jM4827getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m4827getSecondary0d7_KjU() : j6;
        long jM4810getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m4810getOnSecondary0d7_KjU() : j7;
        long jM4828getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m4828getSecondaryContainer0d7_KjU() : j8;
        long j37 = jM4822getPrimary0d7_KjU;
        long jM4811getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m4811getOnSecondaryContainer0d7_KjU() : j9;
        long jM4841getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m4841getTertiary0d7_KjU() : j10;
        long jM4816getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m4816getOnTertiary0d7_KjU() : j11;
        long jM4842getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m4842getTertiaryContainer0d7_KjU() : j12;
        long jM4817getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m4817getOnTertiaryContainer0d7_KjU() : j13;
        long jM4797getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m4797getBackground0d7_KjU() : j14;
        long jM4803getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m4803getOnBackground0d7_KjU() : j15;
        long jM4831getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m4831getSurface0d7_KjU() : j16;
        long jM4814getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m4814getOnSurface0d7_KjU() : j17;
        long jM4840getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m4840getSurfaceVariant0d7_KjU() : j18;
        long jM4815getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m4815getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long jM4802getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m4802getInverseSurface0d7_KjU() : j21;
        long jM4800getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m4800getInverseOnSurface0d7_KjU() : j22;
        long jM4798getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m4798getError0d7_KjU() : j23;
        long jM4804getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m4804getOnError0d7_KjU() : j24;
        long jM4799getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m4799getErrorContainer0d7_KjU() : j25;
        long jM4805getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m4805getOnErrorContainer0d7_KjU() : j26;
        long jM4820getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m4820getOutline0d7_KjU() : j27;
        long jM4821getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m4821getOutlineVariant0d7_KjU() : j28;
        long jM4826getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m4826getScrim0d7_KjU() : j29;
        long jM4832getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m4832getSurfaceBright0d7_KjU() : j30;
        long jM4833getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m4833getSurfaceContainer0d7_KjU() : j31;
        long jM4834getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m4834getSurfaceContainerHigh0d7_KjU() : j32;
        long jM4835getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m4835getSurfaceContainerHighest0d7_KjU() : j33;
        long jM4836getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m4836getSurfaceContainerLow0d7_KjU() : j34;
        long jM4837getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m4837getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m4838getSurfaceDim0d7_KjU();
        }
        return m3480darkColorSchemeCXl9yA(j37, jM4806getOnPrimary0d7_KjU, jM4823getPrimaryContainer0d7_KjU, jM4807getOnPrimaryContainer0d7_KjU, jM4801getInversePrimary0d7_KjU, jM4827getSecondary0d7_KjU, jM4810getOnSecondary0d7_KjU, jM4828getSecondaryContainer0d7_KjU, jM4811getOnSecondaryContainer0d7_KjU, jM4841getTertiary0d7_KjU, jM4816getOnTertiary0d7_KjU, jM4842getTertiaryContainer0d7_KjU, jM4817getOnTertiaryContainer0d7_KjU, jM4797getBackground0d7_KjU, jM4803getOnBackground0d7_KjU, jM4831getSurface0d7_KjU, jM4814getOnSurface0d7_KjU, jM4840getSurfaceVariant0d7_KjU, jM4815getOnSurfaceVariant0d7_KjU, j38, jM4802getInverseSurface0d7_KjU, jM4800getInverseOnSurface0d7_KjU, jM4798getError0d7_KjU, jM4804getOnError0d7_KjU, jM4799getErrorContainer0d7_KjU, jM4805getOnErrorContainer0d7_KjU, jM4820getOutline0d7_KjU, jM4821getOutlineVariant0d7_KjU, jM4826getScrim0d7_KjU, jM4832getSurfaceBright0d7_KjU, jM4833getSurfaceContainer0d7_KjU, jM4834getSurfaceContainerHigh0d7_KjU, jM4835getSurfaceContainerHighest0d7_KjU, jM4836getSurfaceContainerLow0d7_KjU, jM4837getSurfaceContainerLowest0d7_KjU, j36);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m3482darkColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return m3485darkColorScheme_VG5OTI$default(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Videoio.CAP_OPENNI_GENERATORS_MASK, 65535, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3483darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM4822getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m4822getPrimary0d7_KjU() : j;
        long jM4806getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m4806getOnPrimary0d7_KjU() : j2;
        long jM4823getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m4823getPrimaryContainer0d7_KjU() : j3;
        long jM4807getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m4807getOnPrimaryContainer0d7_KjU() : j4;
        long jM4801getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m4801getInversePrimary0d7_KjU() : j5;
        long jM4827getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m4827getSecondary0d7_KjU() : j6;
        long jM4810getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m4810getOnSecondary0d7_KjU() : j7;
        long jM4828getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m4828getSecondaryContainer0d7_KjU() : j8;
        long j30 = jM4822getPrimary0d7_KjU;
        long jM4811getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m4811getOnSecondaryContainer0d7_KjU() : j9;
        long jM4841getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m4841getTertiary0d7_KjU() : j10;
        long jM4816getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m4816getOnTertiary0d7_KjU() : j11;
        long jM4842getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m4842getTertiaryContainer0d7_KjU() : j12;
        long jM4817getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m4817getOnTertiaryContainer0d7_KjU() : j13;
        long jM4797getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m4797getBackground0d7_KjU() : j14;
        long jM4803getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m4803getOnBackground0d7_KjU() : j15;
        long jM4831getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m4831getSurface0d7_KjU() : j16;
        long jM4814getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m4814getOnSurface0d7_KjU() : j17;
        long jM4840getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m4840getSurfaceVariant0d7_KjU() : j18;
        long jM4815getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m4815getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long jM4802getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m4802getInverseSurface0d7_KjU() : j21;
        long jM4800getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m4800getInverseOnSurface0d7_KjU() : j22;
        long jM4798getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m4798getError0d7_KjU() : j23;
        long jM4804getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m4804getOnError0d7_KjU() : j24;
        long jM4799getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m4799getErrorContainer0d7_KjU() : j25;
        long jM4805getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m4805getOnErrorContainer0d7_KjU() : j26;
        long jM4820getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m4820getOutline0d7_KjU() : j27;
        long jM4821getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m4821getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorDarkTokens.INSTANCE.m4826getScrim0d7_KjU();
        }
        return m3482darkColorSchemeG1PFcw(j30, jM4806getOnPrimary0d7_KjU, jM4823getPrimaryContainer0d7_KjU, jM4807getOnPrimaryContainer0d7_KjU, jM4801getInversePrimary0d7_KjU, jM4827getSecondary0d7_KjU, jM4810getOnSecondary0d7_KjU, jM4828getSecondaryContainer0d7_KjU, jM4811getOnSecondaryContainer0d7_KjU, jM4841getTertiary0d7_KjU, jM4816getOnTertiary0d7_KjU, jM4842getTertiaryContainer0d7_KjU, jM4817getOnTertiaryContainer0d7_KjU, jM4797getBackground0d7_KjU, jM4803getOnBackground0d7_KjU, jM4831getSurface0d7_KjU, jM4814getOnSurface0d7_KjU, jM4840getSurfaceVariant0d7_KjU, jM4815getOnSurfaceVariant0d7_KjU, j31, jM4802getInverseSurface0d7_KjU, jM4800getInverseOnSurface0d7_KjU, jM4798getError0d7_KjU, jM4804getOnError0d7_KjU, jM4799getErrorContainer0d7_KjU, jM4805getOnErrorContainer0d7_KjU, jM4820getOutline0d7_KjU, jM4821getOutlineVariant0d7_KjU, j29);
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m3484darkColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3485darkColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long jM4822getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m4822getPrimary0d7_KjU() : j;
        long jM4806getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m4806getOnPrimary0d7_KjU() : j2;
        long jM4823getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m4823getPrimaryContainer0d7_KjU() : j3;
        long jM4807getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m4807getOnPrimaryContainer0d7_KjU() : j4;
        long jM4801getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m4801getInversePrimary0d7_KjU() : j5;
        long jM4827getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m4827getSecondary0d7_KjU() : j6;
        long jM4810getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m4810getOnSecondary0d7_KjU() : j7;
        long j49 = jM4822getPrimary0d7_KjU;
        long jM4828getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m4828getSecondaryContainer0d7_KjU() : j8;
        long jM4811getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m4811getOnSecondaryContainer0d7_KjU() : j9;
        long jM4841getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m4841getTertiary0d7_KjU() : j10;
        long jM4816getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m4816getOnTertiary0d7_KjU() : j11;
        long jM4842getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m4842getTertiaryContainer0d7_KjU() : j12;
        long jM4817getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m4817getOnTertiaryContainer0d7_KjU() : j13;
        long jM4797getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m4797getBackground0d7_KjU() : j14;
        long jM4803getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m4803getOnBackground0d7_KjU() : j15;
        long jM4831getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m4831getSurface0d7_KjU() : j16;
        long jM4814getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m4814getOnSurface0d7_KjU() : j17;
        long jM4840getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m4840getSurfaceVariant0d7_KjU() : j18;
        long jM4815getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m4815getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long jM4802getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m4802getInverseSurface0d7_KjU() : j21;
        long jM4800getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m4800getInverseOnSurface0d7_KjU() : j22;
        long jM4798getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m4798getError0d7_KjU() : j23;
        long jM4804getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m4804getOnError0d7_KjU() : j24;
        long jM4799getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m4799getErrorContainer0d7_KjU() : j25;
        long jM4805getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m4805getOnErrorContainer0d7_KjU() : j26;
        long jM4820getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m4820getOutline0d7_KjU() : j27;
        long jM4821getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m4821getOutlineVariant0d7_KjU() : j28;
        long jM4826getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m4826getScrim0d7_KjU() : j29;
        long jM4832getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m4832getSurfaceBright0d7_KjU() : j30;
        long jM4833getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m4833getSurfaceContainer0d7_KjU() : j31;
        long jM4834getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m4834getSurfaceContainerHigh0d7_KjU() : j32;
        long jM4835getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m4835getSurfaceContainerHighest0d7_KjU() : j33;
        long jM4836getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m4836getSurfaceContainerLow0d7_KjU() : j34;
        long jM4837getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m4837getSurfaceContainerLowest0d7_KjU() : j35;
        long jM4838getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorDarkTokens.INSTANCE.m4838getSurfaceDim0d7_KjU() : j36;
        long jM4824getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorDarkTokens.INSTANCE.m4824getPrimaryFixed0d7_KjU() : j37;
        long jM4825getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorDarkTokens.INSTANCE.m4825getPrimaryFixedDim0d7_KjU() : j38;
        long jM4808getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorDarkTokens.INSTANCE.m4808getOnPrimaryFixed0d7_KjU() : j39;
        long jM4809getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorDarkTokens.INSTANCE.m4809getOnPrimaryFixedVariant0d7_KjU() : j40;
        long jM4829getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorDarkTokens.INSTANCE.m4829getSecondaryFixed0d7_KjU() : j41;
        long jM4830getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorDarkTokens.INSTANCE.m4830getSecondaryFixedDim0d7_KjU() : j42;
        long jM4812getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m4812getOnSecondaryFixed0d7_KjU() : j43;
        long jM4813getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m4813getOnSecondaryFixedVariant0d7_KjU() : j44;
        long jM4843getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m4843getTertiaryFixed0d7_KjU() : j45;
        long jM4844getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m4844getTertiaryFixedDim0d7_KjU() : j46;
        long jM4818getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m4818getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorDarkTokens.INSTANCE.m4819getOnTertiaryFixedVariant0d7_KjU();
        }
        return m3484darkColorScheme_VG5OTI(j49, jM4806getOnPrimary0d7_KjU, jM4823getPrimaryContainer0d7_KjU, jM4807getOnPrimaryContainer0d7_KjU, jM4801getInversePrimary0d7_KjU, jM4827getSecondary0d7_KjU, jM4810getOnSecondary0d7_KjU, jM4828getSecondaryContainer0d7_KjU, jM4811getOnSecondaryContainer0d7_KjU, jM4841getTertiary0d7_KjU, jM4816getOnTertiary0d7_KjU, jM4842getTertiaryContainer0d7_KjU, jM4817getOnTertiaryContainer0d7_KjU, jM4797getBackground0d7_KjU, jM4803getOnBackground0d7_KjU, jM4831getSurface0d7_KjU, jM4814getOnSurface0d7_KjU, jM4840getSurfaceVariant0d7_KjU, jM4815getOnSurfaceVariant0d7_KjU, j50, jM4802getInverseSurface0d7_KjU, jM4800getInverseOnSurface0d7_KjU, jM4798getError0d7_KjU, jM4804getOnError0d7_KjU, jM4799getErrorContainer0d7_KjU, jM4805getOnErrorContainer0d7_KjU, jM4820getOutline0d7_KjU, jM4821getOutlineVariant0d7_KjU, jM4826getScrim0d7_KjU, jM4832getSurfaceBright0d7_KjU, jM4833getSurfaceContainer0d7_KjU, jM4834getSurfaceContainerHigh0d7_KjU, jM4835getSurfaceContainerHighest0d7_KjU, jM4836getSurfaceContainerLow0d7_KjU, jM4837getSurfaceContainerLowest0d7_KjU, jM4838getSurfaceDim0d7_KjU, jM4824getPrimaryFixed0d7_KjU, jM4825getPrimaryFixedDim0d7_KjU, jM4808getOnPrimaryFixed0d7_KjU, jM4809getOnPrimaryFixedVariant0d7_KjU, jM4829getSecondaryFixed0d7_KjU, jM4830getSecondaryFixedDim0d7_KjU, jM4812getOnSecondaryFixed0d7_KjU, jM4813getOnSecondaryFixedVariant0d7_KjU, jM4843getTertiaryFixed0d7_KjU, jM4844getTertiaryFixedDim0d7_KjU, jM4818getOnTertiaryFixed0d7_KjU, j48);
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return m3491lightColorScheme_VG5OTI$default(0L, 0L, 0L, PaletteTokens.INSTANCE.m5247getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m5260getSecondary300d7_KjU(), 0L, 0L, 0L, PaletteTokens.INSTANCE.m5273getTertiary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, PaletteTokens.INSTANCE.m5197getError300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -33558793, 65535, null);
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.getBackground();
            case 2:
                return colorScheme.getError();
            case 3:
                return colorScheme.getErrorContainer();
            case 4:
                return colorScheme.getInverseOnSurface();
            case 5:
                return colorScheme.getInversePrimary();
            case 6:
                return colorScheme.getInverseSurface();
            case 7:
                return colorScheme.getOnBackground();
            case 8:
                return colorScheme.getOnError();
            case 9:
                return colorScheme.getOnErrorContainer();
            case 10:
                return colorScheme.getOnPrimary();
            case 11:
                return colorScheme.getOnPrimaryContainer();
            case 12:
                return colorScheme.getOnSecondary();
            case 13:
                return colorScheme.getOnSecondaryContainer();
            case 14:
                return colorScheme.getOnSurface();
            case 15:
                return colorScheme.getOnSurfaceVariant();
            case 16:
                return colorScheme.getSurfaceTint();
            case 17:
                return colorScheme.getOnTertiary();
            case 18:
                return colorScheme.getOnTertiaryContainer();
            case 19:
                return colorScheme.getOutline();
            case 20:
                return colorScheme.getOutlineVariant();
            case 21:
                return colorScheme.getPrimary();
            case 22:
                return colorScheme.getPrimaryContainer();
            case 23:
                return colorScheme.getScrim();
            case 24:
                return colorScheme.getSecondary();
            case 25:
                return colorScheme.getSecondaryContainer();
            case 26:
                return colorScheme.getSurface();
            case 27:
                return colorScheme.getSurfaceVariant();
            case 28:
                return colorScheme.getSurfaceBright();
            case 29:
                return colorScheme.getSurfaceContainer();
            case 30:
                return colorScheme.getSurfaceContainerHigh();
            case 31:
                return colorScheme.getSurfaceContainerHighest();
            case 32:
                return colorScheme.getSurfaceContainerLow();
            case 33:
                return colorScheme.getSurfaceContainerLowest();
            case 34:
                return colorScheme.getSurfaceDim();
            case 35:
                return colorScheme.getTertiary();
            case 36:
                return colorScheme.getTertiaryContainer();
            case 37:
                return colorScheme.getPrimaryFixed();
            case 38:
                return colorScheme.getPrimaryFixedDim();
            case 39:
                return colorScheme.getOnPrimaryFixed();
            case 40:
                return colorScheme.getOnPrimaryFixedVariant();
            case 41:
                return colorScheme.getSecondaryFixed();
            case 42:
                return colorScheme.getSecondaryFixedDim();
            case 43:
                return colorScheme.getOnSecondaryFixed();
            case 44:
                return colorScheme.getOnSecondaryFixedVariant();
            case 45:
                return colorScheme.getTertiaryFixed();
            case 46:
                return colorScheme.getTertiaryFixedDim();
            case 47:
                return colorScheme.getOnTertiaryFixed();
            case 48:
                return colorScheme.getOnTertiaryFixedVariant();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -810780884, "C(<get-value>)1524@69711L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1524)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jFromToken;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional Fixed roles instead")
    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m3486lightColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return m3491lightColorScheme_VG5OTI$default(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 65520, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3487lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long jM4870getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m4870getPrimary0d7_KjU() : j;
        long jM4854getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m4854getOnPrimary0d7_KjU() : j2;
        long jM4871getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m4871getPrimaryContainer0d7_KjU() : j3;
        long jM4855getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m4855getOnPrimaryContainer0d7_KjU() : j4;
        long jM4849getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m4849getInversePrimary0d7_KjU() : j5;
        long jM4875getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m4875getSecondary0d7_KjU() : j6;
        long jM4858getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m4858getOnSecondary0d7_KjU() : j7;
        long jM4876getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m4876getSecondaryContainer0d7_KjU() : j8;
        long j37 = jM4870getPrimary0d7_KjU;
        long jM4859getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m4859getOnSecondaryContainer0d7_KjU() : j9;
        long jM4889getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m4889getTertiary0d7_KjU() : j10;
        long jM4864getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m4864getOnTertiary0d7_KjU() : j11;
        long jM4890getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m4890getTertiaryContainer0d7_KjU() : j12;
        long jM4865getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m4865getOnTertiaryContainer0d7_KjU() : j13;
        long jM4845getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m4845getBackground0d7_KjU() : j14;
        long jM4851getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m4851getOnBackground0d7_KjU() : j15;
        long jM4879getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m4879getSurface0d7_KjU() : j16;
        long jM4862getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m4862getOnSurface0d7_KjU() : j17;
        long jM4888getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m4888getSurfaceVariant0d7_KjU() : j18;
        long jM4863getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m4863getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long jM4850getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m4850getInverseSurface0d7_KjU() : j21;
        long jM4848getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m4848getInverseOnSurface0d7_KjU() : j22;
        long jM4846getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m4846getError0d7_KjU() : j23;
        long jM4852getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m4852getOnError0d7_KjU() : j24;
        long jM4847getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m4847getErrorContainer0d7_KjU() : j25;
        long jM4853getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m4853getOnErrorContainer0d7_KjU() : j26;
        long jM4868getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m4868getOutline0d7_KjU() : j27;
        long jM4869getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m4869getOutlineVariant0d7_KjU() : j28;
        long jM4874getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m4874getScrim0d7_KjU() : j29;
        long jM4880getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m4880getSurfaceBright0d7_KjU() : j30;
        long jM4881getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m4881getSurfaceContainer0d7_KjU() : j31;
        long jM4882getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m4882getSurfaceContainerHigh0d7_KjU() : j32;
        long jM4883getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m4883getSurfaceContainerHighest0d7_KjU() : j33;
        long jM4884getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m4884getSurfaceContainerLow0d7_KjU() : j34;
        long jM4885getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m4885getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m4886getSurfaceDim0d7_KjU();
        }
        return m3486lightColorSchemeCXl9yA(j37, jM4854getOnPrimary0d7_KjU, jM4871getPrimaryContainer0d7_KjU, jM4855getOnPrimaryContainer0d7_KjU, jM4849getInversePrimary0d7_KjU, jM4875getSecondary0d7_KjU, jM4858getOnSecondary0d7_KjU, jM4876getSecondaryContainer0d7_KjU, jM4859getOnSecondaryContainer0d7_KjU, jM4889getTertiary0d7_KjU, jM4864getOnTertiary0d7_KjU, jM4890getTertiaryContainer0d7_KjU, jM4865getOnTertiaryContainer0d7_KjU, jM4845getBackground0d7_KjU, jM4851getOnBackground0d7_KjU, jM4879getSurface0d7_KjU, jM4862getOnSurface0d7_KjU, jM4888getSurfaceVariant0d7_KjU, jM4863getOnSurfaceVariant0d7_KjU, j38, jM4850getInverseSurface0d7_KjU, jM4848getInverseOnSurface0d7_KjU, jM4846getError0d7_KjU, jM4852getOnError0d7_KjU, jM4847getErrorContainer0d7_KjU, jM4853getOnErrorContainer0d7_KjU, jM4868getOutline0d7_KjU, jM4869getOutlineVariant0d7_KjU, jM4874getScrim0d7_KjU, jM4880getSurfaceBright0d7_KjU, jM4881getSurfaceContainer0d7_KjU, jM4882getSurfaceContainerHigh0d7_KjU, jM4883getSurfaceContainerHighest0d7_KjU, jM4884getSurfaceContainerLow0d7_KjU, jM4885getSurfaceContainerLowest0d7_KjU, j36);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m3488lightColorSchemeG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return m3491lightColorScheme_VG5OTI$default(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Videoio.CAP_OPENNI_GENERATORS_MASK, 65535, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3489lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long jM4870getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m4870getPrimary0d7_KjU() : j;
        long jM4854getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m4854getOnPrimary0d7_KjU() : j2;
        long jM4871getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m4871getPrimaryContainer0d7_KjU() : j3;
        long jM4855getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m4855getOnPrimaryContainer0d7_KjU() : j4;
        long jM4849getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m4849getInversePrimary0d7_KjU() : j5;
        long jM4875getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m4875getSecondary0d7_KjU() : j6;
        long jM4858getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m4858getOnSecondary0d7_KjU() : j7;
        long jM4876getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m4876getSecondaryContainer0d7_KjU() : j8;
        long j30 = jM4870getPrimary0d7_KjU;
        long jM4859getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m4859getOnSecondaryContainer0d7_KjU() : j9;
        long jM4889getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m4889getTertiary0d7_KjU() : j10;
        long jM4864getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m4864getOnTertiary0d7_KjU() : j11;
        long jM4890getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m4890getTertiaryContainer0d7_KjU() : j12;
        long jM4865getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m4865getOnTertiaryContainer0d7_KjU() : j13;
        long jM4845getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m4845getBackground0d7_KjU() : j14;
        long jM4851getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m4851getOnBackground0d7_KjU() : j15;
        long jM4879getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m4879getSurface0d7_KjU() : j16;
        long jM4862getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m4862getOnSurface0d7_KjU() : j17;
        long jM4888getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m4888getSurfaceVariant0d7_KjU() : j18;
        long jM4863getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m4863getOnSurfaceVariant0d7_KjU() : j19;
        long j31 = (i & 524288) != 0 ? j30 : j20;
        long jM4850getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m4850getInverseSurface0d7_KjU() : j21;
        long jM4848getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m4848getInverseOnSurface0d7_KjU() : j22;
        long jM4846getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m4846getError0d7_KjU() : j23;
        long jM4852getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m4852getOnError0d7_KjU() : j24;
        long jM4847getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m4847getErrorContainer0d7_KjU() : j25;
        long jM4853getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m4853getOnErrorContainer0d7_KjU() : j26;
        long jM4868getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m4868getOutline0d7_KjU() : j27;
        long jM4869getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m4869getOutlineVariant0d7_KjU() : j28;
        if ((i & 268435456) != 0) {
            j29 = ColorLightTokens.INSTANCE.m4874getScrim0d7_KjU();
        }
        return m3488lightColorSchemeG1PFcw(j30, jM4854getOnPrimary0d7_KjU, jM4871getPrimaryContainer0d7_KjU, jM4855getOnPrimaryContainer0d7_KjU, jM4849getInversePrimary0d7_KjU, jM4875getSecondary0d7_KjU, jM4858getOnSecondary0d7_KjU, jM4876getSecondaryContainer0d7_KjU, jM4859getOnSecondaryContainer0d7_KjU, jM4889getTertiary0d7_KjU, jM4864getOnTertiary0d7_KjU, jM4890getTertiaryContainer0d7_KjU, jM4865getOnTertiaryContainer0d7_KjU, jM4845getBackground0d7_KjU, jM4851getOnBackground0d7_KjU, jM4879getSurface0d7_KjU, jM4862getOnSurface0d7_KjU, jM4888getSurfaceVariant0d7_KjU, jM4863getOnSurfaceVariant0d7_KjU, j31, jM4850getInverseSurface0d7_KjU, jM4848getInverseOnSurface0d7_KjU, jM4846getError0d7_KjU, jM4852getOnError0d7_KjU, jM4847getErrorContainer0d7_KjU, jM4853getOnErrorContainer0d7_KjU, jM4868getOutline0d7_KjU, jM4869getOutlineVariant0d7_KjU, j29);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m3490lightColorScheme_VG5OTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m3491lightColorScheme_VG5OTI$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, int i, int i2, Object obj) {
        long jM4870getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m4870getPrimary0d7_KjU() : j;
        long jM4854getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m4854getOnPrimary0d7_KjU() : j2;
        long jM4871getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m4871getPrimaryContainer0d7_KjU() : j3;
        long jM4855getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m4855getOnPrimaryContainer0d7_KjU() : j4;
        long jM4849getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m4849getInversePrimary0d7_KjU() : j5;
        long jM4875getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m4875getSecondary0d7_KjU() : j6;
        long jM4858getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m4858getOnSecondary0d7_KjU() : j7;
        long j49 = jM4870getPrimary0d7_KjU;
        long jM4876getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m4876getSecondaryContainer0d7_KjU() : j8;
        long jM4859getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m4859getOnSecondaryContainer0d7_KjU() : j9;
        long jM4889getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m4889getTertiary0d7_KjU() : j10;
        long jM4864getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m4864getOnTertiary0d7_KjU() : j11;
        long jM4890getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m4890getTertiaryContainer0d7_KjU() : j12;
        long jM4865getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m4865getOnTertiaryContainer0d7_KjU() : j13;
        long jM4845getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m4845getBackground0d7_KjU() : j14;
        long jM4851getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m4851getOnBackground0d7_KjU() : j15;
        long jM4879getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m4879getSurface0d7_KjU() : j16;
        long jM4862getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m4862getOnSurface0d7_KjU() : j17;
        long jM4888getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m4888getSurfaceVariant0d7_KjU() : j18;
        long jM4863getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m4863getOnSurfaceVariant0d7_KjU() : j19;
        long j50 = (i & 524288) != 0 ? j49 : j20;
        long jM4850getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m4850getInverseSurface0d7_KjU() : j21;
        long jM4848getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m4848getInverseOnSurface0d7_KjU() : j22;
        long jM4846getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m4846getError0d7_KjU() : j23;
        long jM4852getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m4852getOnError0d7_KjU() : j24;
        long jM4847getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m4847getErrorContainer0d7_KjU() : j25;
        long jM4853getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m4853getOnErrorContainer0d7_KjU() : j26;
        long jM4868getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m4868getOutline0d7_KjU() : j27;
        long jM4869getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m4869getOutlineVariant0d7_KjU() : j28;
        long jM4874getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m4874getScrim0d7_KjU() : j29;
        long jM4880getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m4880getSurfaceBright0d7_KjU() : j30;
        long jM4881getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m4881getSurfaceContainer0d7_KjU() : j31;
        long jM4882getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m4882getSurfaceContainerHigh0d7_KjU() : j32;
        long jM4883getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m4883getSurfaceContainerHighest0d7_KjU() : j33;
        long jM4884getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m4884getSurfaceContainerLow0d7_KjU() : j34;
        long jM4885getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m4885getSurfaceContainerLowest0d7_KjU() : j35;
        long jM4886getSurfaceDim0d7_KjU = (i2 & 8) != 0 ? ColorLightTokens.INSTANCE.m4886getSurfaceDim0d7_KjU() : j36;
        long jM4872getPrimaryFixed0d7_KjU = (i2 & 16) != 0 ? ColorLightTokens.INSTANCE.m4872getPrimaryFixed0d7_KjU() : j37;
        long jM4873getPrimaryFixedDim0d7_KjU = (i2 & 32) != 0 ? ColorLightTokens.INSTANCE.m4873getPrimaryFixedDim0d7_KjU() : j38;
        long jM4856getOnPrimaryFixed0d7_KjU = (i2 & 64) != 0 ? ColorLightTokens.INSTANCE.m4856getOnPrimaryFixed0d7_KjU() : j39;
        long jM4857getOnPrimaryFixedVariant0d7_KjU = (i2 & 128) != 0 ? ColorLightTokens.INSTANCE.m4857getOnPrimaryFixedVariant0d7_KjU() : j40;
        long jM4877getSecondaryFixed0d7_KjU = (i2 & 256) != 0 ? ColorLightTokens.INSTANCE.m4877getSecondaryFixed0d7_KjU() : j41;
        long jM4878getSecondaryFixedDim0d7_KjU = (i2 & 512) != 0 ? ColorLightTokens.INSTANCE.m4878getSecondaryFixedDim0d7_KjU() : j42;
        long jM4860getOnSecondaryFixed0d7_KjU = (i2 & 1024) != 0 ? ColorLightTokens.INSTANCE.m4860getOnSecondaryFixed0d7_KjU() : j43;
        long jM4861getOnSecondaryFixedVariant0d7_KjU = (i2 & 2048) != 0 ? ColorLightTokens.INSTANCE.m4861getOnSecondaryFixedVariant0d7_KjU() : j44;
        long jM4891getTertiaryFixed0d7_KjU = (i2 & 4096) != 0 ? ColorLightTokens.INSTANCE.m4891getTertiaryFixed0d7_KjU() : j45;
        long jM4892getTertiaryFixedDim0d7_KjU = (i2 & 8192) != 0 ? ColorLightTokens.INSTANCE.m4892getTertiaryFixedDim0d7_KjU() : j46;
        long jM4866getOnTertiaryFixed0d7_KjU = (i2 & 16384) != 0 ? ColorLightTokens.INSTANCE.m4866getOnTertiaryFixed0d7_KjU() : j47;
        if ((i2 & 32768) != 0) {
            j48 = ColorLightTokens.INSTANCE.m4867getOnTertiaryFixedVariant0d7_KjU();
        }
        return m3490lightColorScheme_VG5OTI(j49, jM4854getOnPrimary0d7_KjU, jM4871getPrimaryContainer0d7_KjU, jM4855getOnPrimaryContainer0d7_KjU, jM4849getInversePrimary0d7_KjU, jM4875getSecondary0d7_KjU, jM4858getOnSecondary0d7_KjU, jM4876getSecondaryContainer0d7_KjU, jM4859getOnSecondaryContainer0d7_KjU, jM4889getTertiary0d7_KjU, jM4864getOnTertiary0d7_KjU, jM4890getTertiaryContainer0d7_KjU, jM4865getOnTertiaryContainer0d7_KjU, jM4845getBackground0d7_KjU, jM4851getOnBackground0d7_KjU, jM4879getSurface0d7_KjU, jM4862getOnSurface0d7_KjU, jM4888getSurfaceVariant0d7_KjU, jM4863getOnSurfaceVariant0d7_KjU, j50, jM4850getInverseSurface0d7_KjU, jM4848getInverseOnSurface0d7_KjU, jM4846getError0d7_KjU, jM4852getOnError0d7_KjU, jM4847getErrorContainer0d7_KjU, jM4853getOnErrorContainer0d7_KjU, jM4868getOutline0d7_KjU, jM4869getOutlineVariant0d7_KjU, jM4874getScrim0d7_KjU, jM4880getSurfaceBright0d7_KjU, jM4881getSurfaceContainer0d7_KjU, jM4882getSurfaceContainerHigh0d7_KjU, jM4883getSurfaceContainerHighest0d7_KjU, jM4884getSurfaceContainerLow0d7_KjU, jM4885getSurfaceContainerLowest0d7_KjU, jM4886getSurfaceDim0d7_KjU, jM4872getPrimaryFixed0d7_KjU, jM4873getPrimaryFixedDim0d7_KjU, jM4856getOnPrimaryFixed0d7_KjU, jM4857getOnPrimaryFixedVariant0d7_KjU, jM4877getSecondaryFixed0d7_KjU, jM4878getSecondaryFixedDim0d7_KjU, jM4860getOnSecondaryFixed0d7_KjU, jM4861getOnSecondaryFixedVariant0d7_KjU, jM4891getTertiaryFixed0d7_KjU, jM4892getTertiaryFixedDim0d7_KjU, jM4866getOnTertiaryFixed0d7_KjU, j48);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m3492surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m9119equalsimpl0(f, Dp.m9114constructorimpl(0.0f))) {
            return colorScheme.getSurface();
        }
        return ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(colorScheme.getSurfaceTint(), ((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface());
    }
}
