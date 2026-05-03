package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchDefaults;", "", "()V", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;", "checkedThumbColor", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-lRJcREg", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLandroidx/compose/runtime/Composer;III)Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-lRJcREg, reason: not valid java name */
    public final SwitchColors m10670colorslRJcREg(ColorStyle colorStyle, ColorStyle colorStyle2, ColorStyle colorStyle3, long j, ColorStyle colorStyle4, ColorStyle colorStyle5, ColorStyle colorStyle6, long j2, ColorStyle colorStyle7, ColorStyle colorStyle8, ColorStyle colorStyle9, long j3, ColorStyle colorStyle10, ColorStyle colorStyle11, ColorStyle colorStyle12, long j4, Composer composer, int i, int i2, int i3) {
        ColorStyle colorStyle13;
        ColorStyle colorStyle14;
        ColorStyle colorStyleM10531boximpl;
        composer.startReplaceGroup(1279282675);
        ComposerKt.sourceInformation(composer, "C(colors)P(2,3!1,1:c#ui.graphics.Color,14,15,12,13:c#ui.graphics.Color,6,7!1,5:c#ui.graphics.Color,10,11!,9:c#ui.graphics.Color)124@5816L5,125@5913L5,127@6064L5,128@6165L5,129@6266L5,130@6380L5,131@6457L5,134@6599L5,136@6732L11,140@6903L5,142@7027L11,146@7243L5,148@7366L11,151@7527L5,153@7662L11,157@7837L5,159@7961L11,163@8144L5,165@8268L11,168@8402L5,170@8527L11:Switch.kt#51odh9");
        ColorStyle colorStyleM10531boximpl2 = (i3 & 1) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6))) : colorStyle;
        ColorStyle colorStyleM10531boximpl3 = (i3 & 2) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6))) : colorStyle2;
        ColorStyle colorStyleM10531boximpl4 = (i3 & 4) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6360getTransparent0d7_KjU())) : colorStyle3;
        long value = (i3 & 8) != 0 ? SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j;
        ColorStyle colorStyleM10531boximpl5 = (i3 & 16) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6))) : colorStyle4;
        ColorStyle colorStyleM10531boximpl6 = (i3 & 32) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6))) : colorStyle5;
        ColorStyle colorStyleM10531boximpl7 = (i3 & 64) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6))) : colorStyle6;
        long value2 = (i3 & 128) != 0 ? SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j2;
        ColorStyle colorStyleM10531boximpl8 = (i3 & 256) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()))) : colorStyle7;
        if ((i3 & 512) != 0) {
            colorStyle13 = colorStyleM10531boximpl8;
            colorStyle14 = colorStyleM10531boximpl2;
            colorStyleM10531boximpl = ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface())));
        } else {
            colorStyle13 = colorStyleM10531boximpl8;
            colorStyle14 = colorStyleM10531boximpl2;
            colorStyleM10531boximpl = colorStyle8;
        }
        ColorStyle colorStyleM10531boximpl9 = (i3 & 1024) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6360getTransparent0d7_KjU())) : colorStyle9;
        long jM6370compositeOverOWjLjI = (i3 & 2048) != 0 ? ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()) : j3;
        ColorStyle colorStyleM10531boximpl10 = (i3 & 4096) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()))) : colorStyle10;
        ColorStyle colorStyleM10531boximpl11 = (i3 & 8192) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()))) : colorStyle11;
        ColorStyle colorStyleM10531boximpl12 = (i3 & 16384) != 0 ? ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()))) : colorStyle12;
        long jM6370compositeOverOWjLjI2 = (i3 & 32768) != 0 ? ColorKt.m6370compositeOverOWjLjI(Color.m6324copywmQWz5c$default(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface()) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1279282675, i, i2, "com.revenuecat.purchases.ui.revenuecatui.composables.SwitchDefaults.colors (Switch.kt:172)");
        }
        SwitchColors switchColors = new SwitchColors(colorStyle14, colorStyleM10531boximpl3, colorStyleM10531boximpl4, value, colorStyleM10531boximpl5, colorStyleM10531boximpl6, colorStyleM10531boximpl7, value2, colorStyle13, colorStyleM10531boximpl, colorStyleM10531boximpl9, jM6370compositeOverOWjLjI, colorStyleM10531boximpl10, colorStyleM10531boximpl11, colorStyleM10531boximpl12, jM6370compositeOverOWjLjI2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return switchColors;
    }
}
