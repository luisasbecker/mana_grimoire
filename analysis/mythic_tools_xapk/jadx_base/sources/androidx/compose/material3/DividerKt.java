package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001a-\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "VerticalDivider", "VerticalDivider-9IZ8Weo", "Divider", "Divider-9IZ8Weo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DividerKt {
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    @Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3614Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        int i3;
        long j2;
        Modifier.Companion companion;
        float fM3613getThicknessD9Ej5fM;
        long color;
        float fM9114constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1562471785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)106@3745L78:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                i3 |= i6;
            } else {
                j2 = j;
            }
            i3 |= i6;
        } else {
            j2 = j;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "98@3564L5");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier;
                fM3613getThicknessD9Ej5fM = i5 != 0 ? DividerDefaults.INSTANCE.m3613getThicknessD9Ej5fM() : f;
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    color = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1562471785, i3, -1, "androidx.compose.material3.Divider (Divider.kt:99)");
                }
                if (Dp.m9119equalsimpl0(fM3613getThicknessD9Ej5fM, Dp.INSTANCE.m9132getHairlineD9Ej5fM())) {
                    composerStartRestartGroup.startReplaceGroup(-1258183496);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9114constructorimpl = fM3613getThicknessD9Ej5fM;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1258250053);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@3672L7");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM9114constructorimpl = Dp.m9114constructorimpl(1.0f / ((Density) objConsume).getDensity());
                    composerStartRestartGroup.endReplaceGroup();
                }
                BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM9114constructorimpl), color, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                companion = modifier;
                fM3613getThicknessD9Ej5fM = f;
            }
            color = j2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (Dp.m9119equalsimpl0(fM3613getThicknessD9Ej5fM, Dp.INSTANCE.m9132getHairlineD9Ej5fM())) {
            }
            BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM9114constructorimpl), color, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier;
            fM3613getThicknessD9Ej5fM = f;
            color = j2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = companion;
            final float f2 = fM3613getThicknessD9Ej5fM;
            final long j3 = color;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DividerKt.Divider_9IZ8Weo$lambda$6(modifier2, f2, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Divider_9IZ8Weo$lambda$6(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m3614Divider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: HorizontalDivider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3615HorizontalDivider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        final long color;
        Modifier.Companion companion;
        final float fM3613getThicknessD9Ej5fM;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(75144485);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)53@2086L220,53@2036L270:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                color = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(color)) ? 256 : 128;
            } else {
                color = j;
            }
            boolean z = true;
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM3613getThicknessD9Ej5fM = f2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2021L5");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    fM3613getThicknessD9Ej5fM = i5 != 0 ? DividerDefaults.INSTANCE.m3613getThicknessD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        color = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM3613getThicknessD9Ej5fM = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(75144485, i3, -1, "androidx.compose.material3.HorizontalDivider (Divider.kt:53)");
                }
                Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM3613getThicknessD9Ej5fM);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -800586783, "CC(remember):Divider.kt#9igjgp");
                boolean z2 = (i3 & 112) == 32;
                if ((((i3 & 896) ^ 384) <= 256 || !composerStartRestartGroup.changed(color)) && (i3 & 384) != 256) {
                    z = false;
                }
                boolean z3 = z2 | z;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DividerKt.HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(fM3613getThicknessD9Ej5fM, color, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM2069height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                final float f3 = fM3613getThicknessD9Ej5fM;
                final long j2 = color;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DividerKt.HorizontalDivider_9IZ8Weo$lambda$2(modifier3, f3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) != 0) {
        }
        boolean z4 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(float f, long j, DrawScope drawScope) {
        float f2 = drawScope.mo1624toPx0680j_4(f);
        float f3 = drawScope.mo1624toPx0680j_4(f) / 2.0f;
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32));
        float f4 = drawScope.mo1624toPx0680j_4(f) / 2.0f;
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, jM6072constructorimpl, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f2, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalDivider_9IZ8Weo$lambda$2(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m3615HorizontalDivider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: VerticalDivider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3616VerticalDivider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        final long color;
        Modifier.Companion companion;
        final float fM3613getThicknessD9Ej5fM;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1534852205);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)81@3058L221,81@3008L271:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                color = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(color)) ? 256 : 128;
            } else {
                color = j;
            }
            boolean z = true;
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM3613getThicknessD9Ej5fM = f2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2993L5");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    fM3613getThicknessD9Ej5fM = i5 != 0 ? DividerDefaults.INSTANCE.m3613getThicknessD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        color = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM3613getThicknessD9Ej5fM = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1534852205, i3, -1, "androidx.compose.material3.VerticalDivider (Divider.kt:81)");
                }
                Modifier modifierM2088width3ABfNKs = SizeKt.m2088width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), fM3613getThicknessD9Ej5fM);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1819179376, "CC(remember):Divider.kt#9igjgp");
                boolean z2 = (i3 & 112) == 32;
                if ((((i3 & 896) ^ 384) <= 256 || !composerStartRestartGroup.changed(color)) && (i3 & 384) != 256) {
                    z = false;
                }
                boolean z3 = z2 | z;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DividerKt.VerticalDivider_9IZ8Weo$lambda$4$lambda$3(fM3613getThicknessD9Ej5fM, color, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM2088width3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier3 = companion;
                final float f3 = fM3613getThicknessD9Ej5fM;
                final long j2 = color;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DividerKt.VerticalDivider_9IZ8Weo$lambda$5(modifier3, f3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) != 0) {
        }
        boolean z4 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit VerticalDivider_9IZ8Weo$lambda$4$lambda$3(float f, long j, DrawScope drawScope) {
        float f2 = drawScope.mo1624toPx0680j_4(f);
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(drawScope.mo1624toPx0680j_4(f) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float f3 = drawScope.mo1624toPx0680j_4(f) / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, jM6072constructorimpl, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f2, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDivider_9IZ8Weo$lambda$5(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m3616VerticalDivider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
