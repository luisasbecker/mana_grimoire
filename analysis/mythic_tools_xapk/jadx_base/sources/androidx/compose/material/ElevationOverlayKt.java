package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ElevationOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0004\b\n\u0010\u000b\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"LocalElevationOverlay", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteElevation", "getLocalAbsoluteElevation", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ElevationOverlayKt {
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultElevationOverlay.INSTANCE;
        }
    });
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Dp.m9112boximpl(Dp.m9114constructorimpl(0.0f));
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateForegroundColor-CLU3JFs, reason: not valid java name */
    public static final long m3037calculateForegroundColorCLU3JFs(long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1613340891, "C(calculateForegroundColor)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)87@3454L32:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613340891, i, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:85)");
        }
        long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(ColorsKt.m3001contentColorForek8zF_U(j, composer, i & 14), ((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6324copywmQWz5c$default;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }

    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }
}
