package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.BaselineButtonTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010-\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b5\u00106J\r\u0010;\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010;\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b<\u00106J\r\u0010?\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010?\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b@\u00106J\r\u0010C\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010C\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\bD\u00106J\r\u0010G\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010G\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\bH\u00106JA\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bR\u0010SJA\u0010T\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bU\u0010SJA\u0010V\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bW\u0010SJ\u0017\u0010X\u001a\u00020Y2\b\b\u0002\u0010\\\u001a\u00020]H\u0007¢\u0006\u0002\u0010^R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0010\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b(\u0010$R\u0011\u0010)\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b*\u0010$R\u0011\u0010+\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b,\u0010$R\u0018\u00107\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0018\u0010=\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0018\u0010A\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010:R\u0018\u0010E\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010:R\u0018\u0010I\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010:R\u0011\u0010X\u001a\u00020Y8G¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "<init>", "()V", "ButtonLeadingSpace", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonTrailingSpace", "ButtonWithIconStartpadding", "SmallStartPadding", "SmallEndPadding", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconContentPadding", "getButtonWithIconContentPadding", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonWithIconHorizontalEndPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "filledTonalShape", "getFilledTonalShape", "outlinedShape", "getOutlinedShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "defaultButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3", "textButtonColors", "textButtonColors-ro_MJ88", "defaultTextButtonColors", "getDefaultTextButtonColors$material3", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonLeadingSpace;
    private static final float ButtonTrailingSpace;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconStartpadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float SmallEndPadding;
    private static final float SmallStartPadding;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;

    static {
        float fM4733getLeadingSpaceD9Ej5fM = BaselineButtonTokens.INSTANCE.m4733getLeadingSpaceD9Ej5fM();
        ButtonLeadingSpace = fM4733getLeadingSpaceD9Ej5fM;
        float fM4735getTrailingSpaceD9Ej5fM = BaselineButtonTokens.INSTANCE.m4735getTrailingSpaceD9Ej5fM();
        ButtonTrailingSpace = fM4735getTrailingSpaceD9Ej5fM;
        float fM9114constructorimpl = Dp.m9114constructorimpl(16.0f);
        ButtonWithIconStartpadding = fM9114constructorimpl;
        SmallStartPadding = ButtonSmallTokens.INSTANCE.m4755getLeadingSpaceD9Ej5fM();
        SmallEndPadding = ButtonSmallTokens.INSTANCE.m4757getTrailingSpaceD9Ej5fM();
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(8.0f);
        ButtonVerticalPadding = fM9114constructorimpl2;
        PaddingValues paddingValuesM2033PaddingValuesa9UjIt4 = PaddingKt.m2033PaddingValuesa9UjIt4(fM4733getLeadingSpaceD9Ej5fM, fM9114constructorimpl2, fM4735getTrailingSpaceD9Ej5fM, fM9114constructorimpl2);
        ContentPadding = paddingValuesM2033PaddingValuesa9UjIt4;
        ButtonWithIconContentPadding = PaddingKt.m2033PaddingValuesa9UjIt4(fM9114constructorimpl, fM9114constructorimpl2, fM4735getTrailingSpaceD9Ej5fM, fM9114constructorimpl2);
        float fM9114constructorimpl3 = Dp.m9114constructorimpl(12.0f);
        TextButtonHorizontalPadding = fM9114constructorimpl3;
        TextButtonContentPadding = PaddingKt.m2033PaddingValuesa9UjIt4(fM9114constructorimpl3, paddingValuesM2033PaddingValuesa9UjIt4.getTop(), fM9114constructorimpl3, paddingValuesM2033PaddingValuesa9UjIt4.getBottom());
        float fM9114constructorimpl4 = Dp.m9114constructorimpl(16.0f);
        TextButtonWithIconHorizontalEndPadding = fM9114constructorimpl4;
        TextButtonWithIconContentPadding = PaddingKt.m2033PaddingValuesa9UjIt4(fM9114constructorimpl3, paddingValuesM2033PaddingValuesa9UjIt4.getTop(), fM9114constructorimpl4, paddingValuesM2033PaddingValuesa9UjIt4.getBottom());
        MinWidth = Dp.m9114constructorimpl(58.0f);
        MinHeight = ButtonSmallTokens.INSTANCE.m4752getContainerHeightD9Ej5fM();
        IconSize = Dp.m9114constructorimpl(18.0f);
        IconSpacing = ButtonSmallTokens.INSTANCE.m4753getIconLabelSpaceD9Ej5fM();
    }

    private ButtonDefaults() {
    }

    public final ButtonColors buttonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1449248637, "C(buttonColors)572@26919L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449248637, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:572)");
        }
        ButtonColors defaultButtonColors$material3 = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors$material3;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m3340buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -339300779, "C(buttonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)590@27725L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6361getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6361getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:590)");
        }
        ButtonColors buttonColorsM3335copyjRlVdoo = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3335copyjRlVdoo(j5, jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM3335copyjRlVdoo;
    }

    /* JADX INFO: renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m3341buttonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1827791191, "C(buttonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilledButtonTokens.INSTANCE.m5017getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = FilledButtonTokens.INSTANCE.m5021getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilledButtonTokens.INSTANCE.m5019getFocusedContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilledButtonTokens.INSTANCE.m5020getHoveredContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = FilledButtonTokens.INSTANCE.m5018getDisabledContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:811)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final ButtonColors elevatedButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2025043443, "C(elevatedButtonColors)617@29043L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025043443, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:617)");
        }
        ButtonColors defaultElevatedButtonColors$material3 = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedButtonColors$material3;
    }

    /* JADX INFO: renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m3342elevatedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1507908383, "C(elevatedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)635@29902L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6361getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6361getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:635)");
        }
        ButtonColors buttonColorsM3335copyjRlVdoo = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3335copyjRlVdoo(j5, jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM3335copyjRlVdoo;
    }

    /* JADX INFO: renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m3343elevatedButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1065482445, "C(elevatedButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = ElevatedButtonTokens.INSTANCE.m4935getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = ElevatedButtonTokens.INSTANCE.m4939getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = ElevatedButtonTokens.INSTANCE.m4937getFocusedContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = ElevatedButtonTokens.INSTANCE.m4938getHoveredContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = ElevatedButtonTokens.INSTANCE.m4936getDisabledContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:838)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final ButtonColors filledTonalButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 824987837, "C(filledTonalButtonColors)663@31274L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(824987837, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:663)");
        }
        ButtonColors defaultFilledTonalButtonColors$material3 = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m3344filledTonalButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1670757653, "C(filledTonalButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)682@32163L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6361getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6361getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:682)");
        }
        ButtonColors buttonColorsM3335copyjRlVdoo = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3335copyjRlVdoo(j5, jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM3335copyjRlVdoo;
    }

    /* JADX INFO: renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m3345filledTonalButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 5982871, "C(filledTonalButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilledTonalButtonTokens.INSTANCE.m5035getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = FilledTonalButtonTokens.INSTANCE.m5041getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilledTonalButtonTokens.INSTANCE.m5038getFocusContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilledTonalButtonTokens.INSTANCE.m5039getHoverContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = Dp.m9114constructorimpl(0.0f);
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:868)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final ButtonColors getDefaultButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultButtonColorsCached = colorScheme.getDefaultButtonColorsCached();
        if (defaultButtonColorsCached != null) {
            return defaultButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), FilledButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), FilledButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultElevatedButtonColorsCached = colorScheme.getDefaultElevatedButtonColorsCached();
        if (defaultElevatedButtonColorsCached != null) {
            return defaultElevatedButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultElevatedButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultFilledTonalButtonColorsCached = colorScheme.getDefaultFilledTonalButtonColorsCached();
        if (defaultFilledTonalButtonColorsCached != null) {
            return defaultFilledTonalButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getLabelTextColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledTonalButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultOutlinedButtonColorsCached = colorScheme.getDefaultOutlinedButtonColorsCached();
        if (defaultOutlinedButtonColorsCached != null) {
            return defaultOutlinedButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(Color.INSTANCE.m6360getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getLabelTextColor()), Color.INSTANCE.m6360getTransparent0d7_KjU(), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors getDefaultTextButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultTextButtonColorsCached = colorScheme.getDefaultTextButtonColorsCached();
        if (defaultTextButtonColorsCached != null) {
            return defaultTextButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(Color.INSTANCE.m6360getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, ColorSchemeKeyTokens.Primary), Color.INSTANCE.m6360getTransparent0d7_KjU(), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, TextButtonTokens.INSTANCE.getDisabledLabelColor()), TextButtonTokens.INSTANCE.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultTextButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2143958791, "C(<get-elevatedShape>)554@26279L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, i, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:554)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFilledTonalShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -886584987, "C(<get-filledTonalShape>)558@26436L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, i, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:558)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3346getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m3347getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3348getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3349getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Deprecated(message = "Please use the version that takes an `enabled` param to get the `BorderStroke` with the correct opacity", replaceWith = @ReplaceWith(expression = "outlinedButtonBorder(enabled)", imports = {}))
    public final BorderStroke getOutlinedButtonBorder(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -563957672, "C(<get-outlinedButtonBorder>)888@42276L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:886)");
        }
        BorderStroke borderStrokeM1509BorderStrokecXLIe8U = BorderStrokeKt.m1509BorderStrokecXLIe8U(ButtonSmallTokens.INSTANCE.m4756getOutlinedOutlineWidthD9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM1509BorderStrokecXLIe8U;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2045213065, "C(<get-outlinedShape>)562@26587L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:562)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1234923021, "C(<get-shape>)550@26128L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:550)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    public final Shape getTextShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -349121587, "C(<get-textShape>)566@26729L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:566)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final BorderStroke outlinedButtonBorder(boolean z, Composer composer, int i, int i2) {
        long jM6324copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -626854767, "C(outlinedButtonBorder)N(enabled):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-626854767, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:898)");
        }
        float fM4756getOutlinedOutlineWidthD9Ej5fM = ButtonSmallTokens.INSTANCE.m4756getOutlinedOutlineWidthD9Ej5fM();
        if (z) {
            composer.startReplaceGroup(-112346942);
            ComposerKt.sourceInformation(composer, "902@42706L5");
            jM6324copywmQWz5c$default = ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-112259336);
            ComposerKt.sourceInformation(composer, "904@42791L5");
            jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6), OutlinedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            composer.endReplaceGroup();
        }
        BorderStroke borderStrokeM1509BorderStrokecXLIe8U = BorderStrokeKt.m1509BorderStrokecXLIe8U(fM4756getOutlinedOutlineWidthD9Ej5fM, jM6324copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM1509BorderStrokecXLIe8U;
    }

    public final ButtonColors outlinedButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1344886725, "C(outlinedButtonColors)709@33555L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344886725, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:709)");
        }
        ButtonColors defaultOutlinedButtonColors$material3 = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedButtonColors$material3;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m3350outlinedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1778526249, "C(outlinedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)727@34414L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6361getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6361getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:727)");
        }
        ButtonColors buttonColorsM3335copyjRlVdoo = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3335copyjRlVdoo(j5, jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM3335copyjRlVdoo;
    }

    public final ButtonColors textButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1880341584, "C(textButtonColors)752@35580L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880341584, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:752)");
        }
        ButtonColors defaultTextButtonColors$material3 = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextButtonColors$material3;
    }

    /* JADX INFO: renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m3351textButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1402274782, "C(textButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)770@36410L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6361getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6361getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:770)");
        }
        ButtonColors buttonColorsM3335copyjRlVdoo = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3335copyjRlVdoo(j5, jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM3335copyjRlVdoo;
    }
}
