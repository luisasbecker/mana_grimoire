package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m3184colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, Composer composer, int i, int i2, int i3) {
        float f3;
        long j9;
        long jM6370compositeOverOWjLjI;
        long j10;
        long jM6370compositeOverOWjLjI2;
        long j11;
        long jM6370compositeOverOWjLjI3;
        long j12;
        ComposerKt.sourceInformationMarkerStart(composer, -1032127534, "C(colors)N(checkedThumbColor:c#ui.graphics.Color,checkedTrackColor:c#ui.graphics.Color,checkedTrackAlpha,uncheckedThumbColor:c#ui.graphics.Color,uncheckedTrackColor:c#ui.graphics.Color,uncheckedTrackAlpha,disabledCheckedThumbColor:c#ui.graphics.Color,disabledCheckedTrackColor:c#ui.graphics.Color,disabledUncheckedThumbColor:c#ui.graphics.Color,disabledUncheckedTrackColor:c#ui.graphics.Color)318@13166L6,321@13338L6,322@13405L6,326@13583L8,327@13638L6,330@13771L8,331@13826L6,334@13963L8,335@14018L6,338@14155L8,339@14210L6:Switch.kt#jmzs0o");
        long jM2986getSecondaryVariant0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2986getSecondaryVariant0d7_KjU() : j;
        long j13 = (i3 & 2) != 0 ? jM2986getSecondaryVariant0d7_KjU : j2;
        float f4 = (i3 & 4) != 0 ? 0.54f : f;
        long jM2987getSurface0d7_KjU = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2987getSurface0d7_KjU() : j3;
        long jM2982getOnSurface0d7_KjU = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU() : j4;
        float f5 = (i3 & 32) != 0 ? 0.38f : f2;
        if ((i3 & 64) != 0) {
            long j14 = jM2986getSecondaryVariant0d7_KjU;
            j9 = j14;
            f3 = f4;
            jM6370compositeOverOWjLjI = ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2987getSurface0d7_KjU());
        } else {
            f3 = f4;
            j9 = jM2986getSecondaryVariant0d7_KjU;
            jM6370compositeOverOWjLjI = j5;
        }
        if ((i3 & 128) != 0) {
            j10 = jM6370compositeOverOWjLjI;
            jM6370compositeOverOWjLjI2 = ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(j13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2987getSurface0d7_KjU());
        } else {
            j10 = jM6370compositeOverOWjLjI;
            jM6370compositeOverOWjLjI2 = j6;
        }
        if ((i3 & 256) != 0) {
            j11 = jM6370compositeOverOWjLjI2;
            jM6370compositeOverOWjLjI3 = ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(jM2987getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2987getSurface0d7_KjU());
        } else {
            j11 = jM6370compositeOverOWjLjI2;
            jM6370compositeOverOWjLjI3 = j7;
        }
        long jM6370compositeOverOWjLjI4 = (i3 & 512) != 0 ? ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(jM2982getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2987getSurface0d7_KjU()) : j8;
        if (ComposerKt.isTraceInProgress()) {
            j12 = jM6370compositeOverOWjLjI4;
            ComposerKt.traceEventStart(-1032127534, i, i2, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:341)");
        } else {
            j12 = jM6370compositeOverOWjLjI4;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j9, Color.m6324copywmQWz5c$default(j13, f3, 0.0f, 0.0f, 0.0f, 14, null), jM2987getSurface0d7_KjU, Color.m6324copywmQWz5c$default(jM2982getOnSurface0d7_KjU, f5, 0.0f, 0.0f, 0.0f, 14, null), j10, Color.m6324copywmQWz5c$default(j11, f3, 0.0f, 0.0f, 0.0f, 14, null), jM6370compositeOverOWjLjI3, Color.m6324copywmQWz5c$default(j12, f5, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSwitchColors;
    }
}
