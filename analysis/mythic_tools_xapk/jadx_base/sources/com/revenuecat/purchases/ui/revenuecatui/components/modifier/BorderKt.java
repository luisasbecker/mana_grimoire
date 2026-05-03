package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.WebmConstants;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a.\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Border_Preview_LinearGradient", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Border_Preview_LinearGradientCircle", "(Landroidx/compose/runtime/Composer;I)V", "Border_Preview_LinearGradientSquare", "Border_Preview_RadialGradient", "Border_Preview_RadialGradientCircle", "Border_Preview_RadialGradientSquare", "Border_Preview_Solid", "Border_Preview_SolidCircle", "Border_Preview_SolidThin", OutlinedTextFieldKt.BorderId, "Landroidx/compose/ui/Modifier;", "width", "Landroidx/compose/ui/unit/Dp;", "colorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyle;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class BorderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradient(final Shape shape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1213727402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_LinearGradient)118@3595L1114:Border.kt#pifk6e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(shape) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1213727402, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradient (Border.kt:117)");
            }
            BoxKt.Box(border(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), new BorderStyle(Dp.m9114constructorimpl(10.0f), ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(135.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6353getCyan0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 30.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, 8, null)), 80.0f)}))), null), shape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BorderKt.Border_Preview_LinearGradient(shape, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradientCircle(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-873280999);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_LinearGradientCircle)100@3129L50:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-873280999, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradientCircle (Border.kt:99)");
            }
            Border_Preview_LinearGradient(RoundedCornerShapeKt.getCircleShape(), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradientCircle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_LinearGradientCircle(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_LinearGradientSquare(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(328570534);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_LinearGradientSquare)94@2971L53:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328570534, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_LinearGradientSquare (Border.kt:93)");
            }
            Border_Preview_LinearGradient(RectangleShapeKt.getRectangleShape(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_LinearGradientSquare.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_LinearGradientSquare(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradient(final Shape shape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1379549156);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_RadialGradient)151@4812L1074:Border.kt#pifk6e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(shape) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1379549156, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradient (Border.kt:150)");
            }
            BoxKt.Box(border(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), new BorderStyle(Dp.m9114constructorimpl(10.0f), ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6353getCyan0d7_KjU()), 80.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 90.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, 8, null)), 96.0f)}))), null), shape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BorderKt.Border_Preview_RadialGradient(shape, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradientCircle(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1718788077);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_RadialGradientCircle)112@3442L50:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1718788077, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradientCircle (Border.kt:111)");
            }
            Border_Preview_RadialGradient(RoundedCornerShapeKt.getCircleShape(), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradientCircle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_RadialGradientCircle(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_RadialGradientSquare(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-516936544);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_RadialGradientSquare)106@3284L53:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-516936544, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_RadialGradientSquare (Border.kt:105)");
            }
            Border_Preview_RadialGradient(RectangleShapeKt.getRectangleShape(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_RadialGradientSquare.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_RadialGradientSquare(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_Solid(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1171018009);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_Solid)43@1707L301:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1171018009, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_Solid (Border.kt:42)");
            }
            BoxKt.Box(border$default(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), new BorderStyle(Dp.m9114constructorimpl(10.0f), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null), null, 2, null), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_Solid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_Solid(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_SolidCircle(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2094328983);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_SolidCircle)77@2528L338:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2094328983, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_SolidCircle (Border.kt:76)");
            }
            BoxKt.Box(border(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), new BorderStyle(Dp.m9114constructorimpl(10.0f), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_SolidCircle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_SolidCircle(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Border_Preview_SolidThin(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(471558496);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Border_Preview_SolidThin)60@2116L300:Border.kt#pifk6e");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(471558496, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.modifier.Border_Preview_SolidThin (Border.kt:59)");
            }
            BoxKt.Box(border$default(androidx.compose.foundation.BackgroundKt.m1483backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), Color.INSTANCE.m6359getRed0d7_KjU(), null, 2, null), new BorderStyle(Dp.m9114constructorimpl(2.0f), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null), null, 2, null), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt.Border_Preview_SolidThin.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BorderKt.Border_Preview_SolidThin(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final /* synthetic */ Modifier border(Modifier modifier, BorderStyle border, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m10497borderziNgDLE(modifier, border.m10519getWidthD9Ej5fM(), border.getColor(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStyle borderStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStyle, shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final /* synthetic */ Modifier m10497borderziNgDLE(Modifier border, float f, ColorStyle colorStyle, Shape shape) {
        Intrinsics.checkNotNullParameter(border, "$this$border");
        Intrinsics.checkNotNullParameter(colorStyle, "colorStyle");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (colorStyle instanceof ColorStyle.Solid) {
            return androidx.compose.foundation.BorderKt.m1494borderxT4_qwU(border, f, ((ColorStyle.Solid) colorStyle).m10538unboximpl(), shape);
        }
        if (colorStyle instanceof ColorStyle.Gradient) {
            return androidx.compose.foundation.BorderKt.m1496borderziNgDLE(border, f, ((ColorStyle.Gradient) colorStyle).m10530unboximpl(), shape);
        }
        throw new NoWhenBranchMatchedException();
    }
}
