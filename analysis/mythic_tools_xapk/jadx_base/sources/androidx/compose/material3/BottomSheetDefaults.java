package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0017\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "<init>", "()V", "HiddenShape", "Landroidx/compose/ui/graphics/Shape;", "getHiddenShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ExpandedShape", "getExpandedShape", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM$material3", "VelocityThreshold", "getVelocityThreshold-D9Ej5fM$material3", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m5303getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetPeekHeight = Dp.m9114constructorimpl(56.0f);
    private static final float SheetMaxWidth = Dp.m9114constructorimpl(640.0f);
    private static final float PositionalThreshold = Dp.m9114constructorimpl(56.0f);
    private static final float VelocityThreshold = Dp.m9114constructorimpl(125.0f);

    private BottomSheetDefaults() {
    }

    static final Unit DragHandle_lgZ2HuY$lambda$1$lambda$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    static final Unit DragHandle_lgZ2HuY$lambda$2(BottomSheetDefaults bottomSheetDefaults, Modifier modifier, float f, float f2, Shape shape, long j, int i, int i2, Composer composer, int i3) {
        bottomSheetDefaults.m3323DragHandlelgZ2HuY(modifier, f, f2, shape, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3323DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final float fM5302getDockedDragHandleWidthD9Ej5fM;
        int i4;
        float fM5301getDockedDragHandleHeightD9Ej5fM;
        Shape extraLarge;
        long value;
        Composer composer2;
        final Modifier.Companion companion;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1364277227);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DragHandle)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,shape,color:c#ui.graphics.Color)416@17418L51,419@17591L82,424@17739L74,417@17478L335:SheetDefaults.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                fM5302getDockedDragHandleWidthD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM5302getDockedDragHandleWidthD9Ej5fM) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    fM5301getDockedDragHandleHeightD9Ej5fM = f2;
                    i3 |= composerStartRestartGroup.changed(fM5301getDockedDragHandleHeightD9Ej5fM) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        extraLarge = shape;
                        int i7 = composerStartRestartGroup.changed(extraLarge) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        extraLarge = shape;
                    }
                    i3 |= i7;
                } else {
                    extraLarge = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        value = j;
                        int i8 = composerStartRestartGroup.changed(value) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        value = j;
                    }
                    i3 |= i8;
                } else {
                    value = j;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "413@17285L6,414@17367L5");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i6 != 0) {
                            fM5302getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5302getDockedDragHandleWidthD9Ej5fM();
                        }
                        if (i4 != 0) {
                            fM5301getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5301getDockedDragHandleHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                        }
                        if ((i2 & 16) != 0) {
                            value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = modifier2;
                    }
                    final float f4 = fM5301getDockedDragHandleHeightD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1364277227, i3, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:415)");
                    }
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
                    Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(companion, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1105372569, "CC(remember):SheetDefaults.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$1$lambda$0(strM4676getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i9 = i3 >> 6;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4145SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM2039paddingVpY3zN4$default, false, (Function1) objRememberedValue, 1, null), extraLarge, value, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i10) {
                            ComposerKt.sourceInformation(composer3, "C425@17753L50:SheetDefaults.kt#uh7d8r");
                            if (!composer3.shouldExecute((i10 & 3) != 2, i10 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1039573072, i10, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:425)");
                            }
                            BoxKt.Box(SizeKt.m2085sizeVpY3zN4(Modifier.INSTANCE, fM5302getDockedDragHandleWidthD9Ej5fM, f4), composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composer2, (i9 & 112) | 12582912 | (i9 & 896), 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    f3 = fM5301getDockedDragHandleHeightD9Ej5fM;
                }
                final float f5 = fM5302getDockedDragHandleWidthD9Ej5fM;
                final Shape shape2 = extraLarge;
                final long j2 = value;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$2(this.f$0, companion, f5, f3, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            fM5301getDockedDragHandleHeightD9Ej5fM = f2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            final float f52 = fM5302getDockedDragHandleWidthD9Ej5fM;
            final Shape shape22 = extraLarge;
            final long j22 = value;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM5302getDockedDragHandleWidthD9Ej5fM = f;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        fM5301getDockedDragHandleHeightD9Ej5fM = f2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        final float f522 = fM5302getDockedDragHandleWidthD9Ej5fM;
        final Shape shape222 = extraLarge;
        final long j222 = value;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 433375448, "C(<get-ContainerColor>)383@16075L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:383)");
        }
        long value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m3324getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getExpandedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1683783414, "C(<get-ExpandedShape>)379@15912L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:379)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getHiddenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1971658024, "C(<get-HiddenShape>)375@15714L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:375)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m3325getPositionalThresholdD9Ej5fM$material3() {
        return PositionalThreshold;
    }

    public final long getScrimColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2040719176, "C(<get-ScrimColor>)390@16359L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:390)");
        }
        long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6324copywmQWz5c$default;
    }

    /* JADX INFO: renamed from: getSheetMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m3326getSheetMaxWidthD9Ej5fM() {
        return SheetMaxWidth;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m3327getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m3328getVelocityThresholdD9Ej5fM$material3() {
        return VelocityThreshold;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -511309409, "C(<get-windowInsets>)401@16789L11:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:401)");
        }
        WindowInsets windowInsetsM2110onlybOOhFvg = WindowInsetsKt.m2110onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m2122plusgK_yJZ4(WindowInsetsSides.INSTANCE.m2130getBottomJoeWqyM(), WindowInsetsSides.INSTANCE.m2136getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM2110onlybOOhFvg;
    }
}
