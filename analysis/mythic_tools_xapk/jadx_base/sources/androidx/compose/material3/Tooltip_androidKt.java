package androidx.compose.material3;

import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Tooltip.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001av\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001a\u0090\u0001\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009a\u0001\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"PlainTooltipAndroid", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "maxWidth", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltipAndroid", Constants.GP_IAP_TITLE, NativeProtocol.WEB_DIALOG_ACTION, "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Tooltip_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125 A[PHI: r19
      0x0125: PHI (r19v8 int) = (r19v4 int), (r19v6 int), (r19v7 int) binds: [B:102:0x0123, B:109:0x0137, B:108:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void PlainTooltip(final TooltipScope tooltipScope, Modifier modifier, long j, float f, Shape shape, long j2, long j3, float f2, float f3, final Function2 function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j4;
        int i4;
        float f4;
        Shape shape2;
        long j5;
        int i5;
        int i6;
        final float f5;
        int i7;
        int i8;
        int i9;
        final Modifier modifier3;
        final long j6;
        final float f6;
        final Shape shape3;
        Composer composer2;
        final long j7;
        final long j8;
        final float f7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM9221getUnspecifiedMYxV2XQ;
        float fM4463getPlainTooltipMaxWidthD9Ej5fM;
        Shape plainTooltipContainerShape;
        long plainTooltipContentColor;
        long plainTooltipContainerColor;
        long j9;
        Shape shape4;
        long j10;
        int i10;
        float fM9114constructorimpl;
        float f8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1456881596);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlainTooltipAndroid)N(modifier,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)105@4515L349:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 2) == 0) {
                    j4 = j;
                    int i12 = composerStartRestartGroup.changed(j4) ? 256 : 128;
                    i3 |= i12;
                } else {
                    j4 = j;
                }
                i3 |= i12;
            } else {
                j4 = j;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    f4 = f;
                    i3 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i13 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    j5 = j2;
                    i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j5)) ? 131072 : 65536;
                } else {
                    j5 = j2;
                }
                if ((1572864 & i) == 0) {
                    i5 = i3 | (((i2 & 32) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288);
                } else {
                    i5 = i3;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i5 |= 12582912;
                    f5 = f2;
                } else {
                    f5 = f2;
                    if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(f5) ? 8388608 : 4194304;
                    }
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                    if ((i & 100663296) == 0) {
                        i8 = i7;
                        i5 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    int i14 = 805306368;
                    if ((i2 & 256) != 0) {
                        i5 |= i14;
                    } else if ((i & 805306368) == 0) {
                        i14 = composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        i5 |= i14;
                    }
                    i9 = i5;
                    if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        j6 = j4;
                        f6 = f4;
                        shape3 = shape2;
                        composer2 = composerStartRestartGroup;
                        j7 = j5;
                        j8 = j3;
                        f7 = f3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4239L26,99@4309L24,100@4379L26");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i11 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                                i9 &= -897;
                            } else {
                                jM9221getUnspecifiedMYxV2XQ = j4;
                            }
                            fM4463getPlainTooltipMaxWidthD9Ej5fM = i4 != 0 ? TooltipDefaults.INSTANCE.m4463getPlainTooltipMaxWidthD9Ej5fM() : f4;
                            if ((i2 & 8) != 0) {
                                plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                                i9 &= -57345;
                            } else {
                                plainTooltipContainerShape = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            } else {
                                plainTooltipContentColor = j5;
                            }
                            if ((i2 & 32) != 0) {
                                plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                plainTooltipContainerColor = j3;
                            }
                            float fM9114constructorimpl2 = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f5;
                            if (i8 != 0) {
                                f5 = fM9114constructorimpl2;
                                i10 = i9;
                                fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                                j9 = jM9221getUnspecifiedMYxV2XQ;
                                shape4 = plainTooltipContainerShape;
                                j10 = plainTooltipContainerColor;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    f8 = fM9114constructorimpl;
                                } else {
                                    f8 = fM9114constructorimpl;
                                    ComposerKt.traceEventStart(1456881596, i10, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:104)");
                                }
                                int i15 = 2147482750 & i10;
                                long j11 = j9;
                                float f9 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                                long j12 = plainTooltipContentColor;
                                float f10 = f5;
                                float f11 = f8;
                                TooltipKt.m4470PlainTooltipgv3ox5I(tooltipScope, companion, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j9), f9, shape4, j12, j10, f10, f11, function2, composerStartRestartGroup, i15, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                f5 = f10;
                                composer2 = composerStartRestartGroup;
                                f7 = f11;
                                j8 = j10;
                                j7 = j12;
                                f6 = f9;
                                shape3 = shape4;
                                j6 = j11;
                            } else {
                                f5 = fM9114constructorimpl2;
                                j9 = jM9221getUnspecifiedMYxV2XQ;
                                shape4 = plainTooltipContainerShape;
                                j10 = plainTooltipContainerColor;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i9 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i9 &= -57345;
                            }
                            if ((i2 & 16) != 0) {
                                i9 &= -458753;
                            }
                            if ((i2 & 32) != 0) {
                                i9 &= -3670017;
                            }
                            companion = modifier2;
                            j9 = j4;
                            fM4463getPlainTooltipMaxWidthD9Ej5fM = f4;
                            shape4 = shape2;
                            plainTooltipContentColor = j5;
                            j10 = j3;
                        }
                        i10 = i9;
                        fM9114constructorimpl = f3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i152 = 2147482750 & i10;
                        long j112 = j9;
                        float f92 = fM4463getPlainTooltipMaxWidthD9Ej5fM;
                        long j122 = plainTooltipContentColor;
                        float f102 = f5;
                        float f112 = f8;
                        TooltipKt.m4470PlainTooltipgv3ox5I(tooltipScope, companion, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j9), f92, shape4, j122, j10, f102, f112, function2, composerStartRestartGroup, i152, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = companion;
                        f5 = f102;
                        composer2 = composerStartRestartGroup;
                        f7 = f112;
                        j8 = j10;
                        j7 = j122;
                        f6 = f92;
                        shape3 = shape4;
                        j6 = j112;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.Tooltip_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return Tooltip_androidKt.PlainTooltipAndroid_m9Er_Xc$lambda$1(tooltipScope, modifier3, j6, f6, shape3, j7, j8, f5, f7, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 100663296;
                i8 = i7;
                int i142 = 805306368;
                if ((i2 & 256) != 0) {
                }
                i9 = i5;
                if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f4 = f;
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            int i1422 = 805306368;
            if ((i2 & 256) != 0) {
            }
            i9 = i5;
            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f4 = f;
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        int i14222 = 805306368;
        if ((i2 & 256) != 0) {
        }
        i9 = i5;
        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with maxWidth parameter.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void PlainTooltip(final TooltipScope tooltipScope, Modifier modifier, long j, Shape shape, long j2, long j3, float f, float f2, final Function2 function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long jM9221getUnspecifiedMYxV2XQ;
        Shape plainTooltipContainerShape;
        long plainTooltipContentColor;
        long plainTooltipContainerColor;
        int i4;
        float f3;
        int i5;
        final float f4;
        final long j4;
        final long j5;
        final float f5;
        final Modifier modifier3;
        final Shape shape2;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        long j7;
        Shape shape3;
        long j8;
        float fM9114constructorimpl;
        float f6;
        Modifier modifier4;
        long j9;
        long j10;
        Composer composerStartRestartGroup = composer.startRestartGroup(2114904198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlainTooltipAndroid)N(modifier,caretSize:c#ui.unit.DpSize,shape,contentColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)61@2558L377:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 2) == 0) {
                    jM9221getUnspecifiedMYxV2XQ = j;
                    int i8 = composerStartRestartGroup.changed(jM9221getUnspecifiedMYxV2XQ) ? 256 : 128;
                    i3 |= i8;
                } else {
                    jM9221getUnspecifiedMYxV2XQ = j;
                }
                i3 |= i8;
            } else {
                jM9221getUnspecifiedMYxV2XQ = j;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 4) == 0) {
                    plainTooltipContainerShape = shape;
                    int i9 = composerStartRestartGroup.changed(plainTooltipContainerShape) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    plainTooltipContainerShape = shape;
                }
                i3 |= i9;
            } else {
                plainTooltipContainerShape = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 8) == 0) {
                    plainTooltipContentColor = j2;
                    int i10 = composerStartRestartGroup.changed(plainTooltipContentColor) ? 16384 : 8192;
                    i3 |= i10;
                } else {
                    plainTooltipContentColor = j2;
                }
                i3 |= i10;
            } else {
                plainTooltipContentColor = j2;
            }
            if ((196608 & i) != 0) {
                plainTooltipContainerColor = j3;
                i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(plainTooltipContainerColor)) ? 131072 : 65536;
            } else {
                plainTooltipContainerColor = j3;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    i3 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                }
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
            }
            if ((i2 & 128) != 0) {
                if ((i & 100663296) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@2282L26,55@2352L24,56@2422L26");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 2) != 0) {
                            jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                            i3 &= -897;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -7169;
                            plainTooltipContainerShape = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 16) != 0) {
                            plainTooltipContainerColor = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        }
                        float fM9114constructorimpl2 = i4 != 0 ? Dp.m9114constructorimpl(0.0f) : f3;
                        if (i5 != 0) {
                            shape3 = plainTooltipContainerShape;
                            j10 = plainTooltipContentColor;
                            fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                            f6 = fM9114constructorimpl2;
                            i6 = i3;
                            modifier4 = modifier2;
                        } else {
                            i6 = i3;
                            j7 = jM9221getUnspecifiedMYxV2XQ;
                            shape3 = plainTooltipContainerShape;
                            j8 = plainTooltipContainerColor;
                            long j11 = plainTooltipContentColor;
                            fM9114constructorimpl = f2;
                            f6 = fM9114constructorimpl2;
                            modifier4 = modifier2;
                            j9 = j11;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2114904198, i6, -1, "androidx.compose.material3.PlainTooltipAndroid (Tooltip.android.kt:61)");
                            }
                            int i11 = (i6 & 14) | 3072 | (i6 & 112);
                            int i12 = i6 << 3;
                            long j12 = j7;
                            TooltipKt.m4470PlainTooltipgv3ox5I(tooltipScope, modifier4, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j7), TooltipDefaults.INSTANCE.m4463getPlainTooltipMaxWidthD9Ej5fM(), shape3, j9, j8, f6, fM9114constructorimpl, function2, composerStartRestartGroup, (i12 & 1879048192) | i11 | (i12 & 57344) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i12 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            f4 = fM9114constructorimpl;
                            f5 = f6;
                            j6 = j8;
                            j5 = j9;
                            shape2 = shape3;
                            j4 = j12;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -458753;
                        }
                        i6 = i3;
                        modifier4 = modifier2;
                        shape3 = plainTooltipContainerShape;
                        j10 = plainTooltipContentColor;
                        fM9114constructorimpl = f2;
                        f6 = f3;
                    }
                    j7 = jM9221getUnspecifiedMYxV2XQ;
                    j9 = j10;
                    j8 = plainTooltipContainerColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = (i6 & 14) | 3072 | (i6 & 112);
                    int i122 = i6 << 3;
                    long j122 = j7;
                    TooltipKt.m4470PlainTooltipgv3ox5I(tooltipScope, modifier4, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j7), TooltipDefaults.INSTANCE.m4463getPlainTooltipMaxWidthD9Ej5fM(), shape3, j9, j8, f6, fM9114constructorimpl, function2, composerStartRestartGroup, (i122 & 1879048192) | i112 | (i122 & 57344) | (i122 & 458752) | (i122 & 3670016) | (i122 & 29360128) | (i122 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                    f4 = fM9114constructorimpl;
                    f5 = f6;
                    j6 = j8;
                    j5 = j9;
                    shape2 = shape3;
                    j4 = j122;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f4 = f2;
                    j4 = jM9221getUnspecifiedMYxV2XQ;
                    j5 = plainTooltipContentColor;
                    f5 = f3;
                    modifier3 = modifier2;
                    shape2 = plainTooltipContainerShape;
                    j6 = plainTooltipContainerColor;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.Tooltip_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return Tooltip_androidKt.PlainTooltipAndroid_7QI4Sbk$lambda$0(tooltipScope, modifier3, j4, shape2, j5, j6, f5, f4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 100663296;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit PlainTooltipAndroid_7QI4Sbk$lambda$0(TooltipScope tooltipScope, Modifier modifier, long j, Shape shape, long j2, long j3, float f, float f2, Function2 function2, int i, int i2, Composer composer, int i3) {
        PlainTooltip(tooltipScope, modifier, j, shape, j2, j3, f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit PlainTooltipAndroid_m9Er_Xc$lambda$1(TooltipScope tooltipScope, Modifier modifier, long j, float f, Shape shape, long j2, long j3, float f2, float f3, Function2 function2, int i, int i2, Composer composer, int i3) {
        PlainTooltip(tooltipScope, modifier, j, f, shape, j2, j3, f2, f3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void RichTooltip(final TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, float f, Shape shape, RichTooltipColors richTooltipColors, float f2, float f3, final Function2 function23, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2 function24;
        int i6;
        Function2 function25;
        long j2;
        int i7;
        float fM4464getRichTooltipMaxWidthD9Ej5fM;
        RichTooltipColors richTooltipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        final Shape shape2;
        final float f4;
        final Modifier modifier3;
        final Function2 function26;
        Composer composer2;
        final float f5;
        final float f6;
        final RichTooltipColors richTooltipColors3;
        final Function2 function27;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM9221getUnspecifiedMYxV2XQ;
        Shape richTooltipContainerShape;
        int i13;
        Function2 function28;
        float f7;
        float fM5290getContainerElevationD9Ej5fM;
        float f8;
        RichTooltipColors richTooltipColors4;
        long j4;
        Function2 function29;
        Composer composerStartRestartGroup = composer.startRestartGroup(-905938553);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RichTooltipAndroid)N(modifier,title,action,caretSize:c#ui.unit.DpSize,maxWidth:c#ui.unit.Dp,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)202@8696L337:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 1;
        if (i14 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 2;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function24 = function2;
                    i4 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i6 = i3 & 4;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function25 = function22;
                        i4 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i3 & 8) == 0) {
                            j2 = j;
                            int i15 = composerStartRestartGroup.changed(j2) ? 16384 : 8192;
                            i4 |= i15;
                        } else {
                            j2 = j;
                        }
                        i4 |= i15;
                    } else {
                        j2 = j;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        fM4464getRichTooltipMaxWidthD9Ej5fM = f;
                    } else {
                        fM4464getRichTooltipMaxWidthD9Ej5fM = f;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(fM4464getRichTooltipMaxWidthD9Ej5fM) ? 131072 : 65536;
                        }
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        richTooltipColors2 = richTooltipColors;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(richTooltipColors2)) ? 8388608 : 4194304;
                    } else {
                        richTooltipColors2 = richTooltipColors;
                    }
                    i8 = i3 & 128;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        i10 = i3 & 256;
                        if (i10 == 0) {
                            if ((i & 805306368) == 0) {
                                i11 = i10;
                                i4 |= composerStartRestartGroup.changed(f3) ? 536870912 : 268435456;
                            }
                            if ((i3 & 512) == 0) {
                                i12 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i12 = i2 | (composerStartRestartGroup.changedInstance(function23) ? 4 : 2);
                            } else {
                                i12 = i2;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                shape2 = shape;
                                f4 = f2;
                                modifier3 = modifier2;
                                function26 = function24;
                                composer2 = composerStartRestartGroup;
                                f5 = f3;
                                f6 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                richTooltipColors3 = richTooltipColors2;
                                function27 = function25;
                                j3 = j2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "196@8445L25,197@8520L19");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i14 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i5 != 0) {
                                        function24 = null;
                                    }
                                    Function2 function210 = i6 == 0 ? function25 : null;
                                    if ((i3 & 8) != 0) {
                                        jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                                        i4 &= -57345;
                                    } else {
                                        jM9221getUnspecifiedMYxV2XQ = j2;
                                    }
                                    if (i7 != 0) {
                                        fM4464getRichTooltipMaxWidthD9Ej5fM = TooltipDefaults.INSTANCE.m4464getRichTooltipMaxWidthD9Ej5fM();
                                    }
                                    if ((i3 & 32) != 0) {
                                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    } else {
                                        richTooltipContainerShape = shape;
                                    }
                                    if ((i3 & 64) != 0) {
                                        richTooltipColors2 = TooltipDefaults.INSTANCE.richTooltipColors(composerStartRestartGroup, 6);
                                        i4 = (-29360129) & i4;
                                    }
                                    float fM4947getLevel0D9Ej5fM = i9 != 0 ? ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM() : f2;
                                    if (i11 != 0) {
                                        long j5 = jM9221getUnspecifiedMYxV2XQ;
                                        f8 = fM4947getLevel0D9Ej5fM;
                                        richTooltipColors4 = richTooltipColors2;
                                        function29 = function24;
                                        fM5290getContainerElevationD9Ej5fM = RichTooltipTokens.INSTANCE.m5290getContainerElevationD9Ej5fM();
                                        i13 = i4;
                                        function28 = function210;
                                        f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        j4 = j5;
                                    } else {
                                        i13 = i4;
                                        function28 = function210;
                                        f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                        Function2 function211 = function24;
                                        fM5290getContainerElevationD9Ej5fM = f3;
                                        long j6 = jM9221getUnspecifiedMYxV2XQ;
                                        f8 = fM4947getLevel0D9Ej5fM;
                                        richTooltipColors4 = richTooltipColors2;
                                        j4 = j6;
                                        function29 = function211;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    Function2 function212 = function25;
                                    i13 = i4;
                                    function28 = function212;
                                    richTooltipContainerShape = shape;
                                    f8 = f2;
                                    f7 = fM4464getRichTooltipMaxWidthD9Ej5fM;
                                    companion = modifier2;
                                    function29 = function24;
                                    fM5290getContainerElevationD9Ej5fM = f3;
                                    richTooltipColors4 = richTooltipColors2;
                                    j4 = j2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-905938553, i13, i12, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:201)");
                                }
                                long j7 = j4;
                                float f9 = f7;
                                Shape shape3 = richTooltipContainerShape;
                                TooltipKt.m4472RichTooltipEkvW5A0(tooltipScope, companion, function29, function28, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j4), f9, shape3, richTooltipColors4, f8, fM5290getContainerElevationD9Ej5fM, function23, composerStartRestartGroup, i13 & 2147426302, i12 & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function27 = function28;
                                f4 = f8;
                                composer2 = composerStartRestartGroup;
                                function26 = function29;
                                shape2 = shape3;
                                f5 = fM5290getContainerElevationD9Ej5fM;
                                modifier3 = companion;
                                richTooltipColors3 = richTooltipColors4;
                                f6 = f9;
                                j3 = j7;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.Tooltip_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return Tooltip_androidKt.RichTooltipAndroid_ZuUcA3Q$lambda$3(tooltipScope, modifier3, function26, function27, j3, f6, shape2, richTooltipColors3, f4, f5, function23, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        i11 = i10;
                        if ((i3 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    i10 = i3 & 256;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function25 = function22;
                if ((i & 24576) != 0) {
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i8 = i3 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function24 = function2;
            i6 = i3 & 4;
            if (i6 != 0) {
            }
            function25 = function22;
            if ((i & 24576) != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i8 = i3 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 2;
        if (i5 == 0) {
        }
        function24 = function2;
        i6 = i3 & 4;
        if (i6 != 0) {
        }
        function25 = function22;
        if ((i & 24576) != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i8 = i3 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with maxWidth parameter.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void RichTooltip(final TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, Shape shape, RichTooltipColors richTooltipColors, float f, float f2, final Function2 function23, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2 function24;
        int i5;
        Function2 function25;
        long jM9221getUnspecifiedMYxV2XQ;
        Shape richTooltipContainerShape;
        int i6;
        RichTooltipColors richTooltipColors2;
        int i7;
        float fM4947getLevel0D9Ej5fM;
        int i8;
        int i9;
        final Function2 function26;
        final Function2 function27;
        final RichTooltipColors richTooltipColors3;
        final Shape shape2;
        final float f3;
        final float f4;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM5290getContainerElevationD9Ej5fM;
        int i10;
        Function2 function28;
        float f5;
        Modifier modifier4;
        Function2 function29;
        RichTooltipColors richTooltipColors4;
        long j3;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-244908363);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RichTooltipAndroid)N(modifier,title,action,caretSize:c#ui.unit.DpSize,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,text)154@6569L364:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(tooltipScope) : composerStartRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function24 = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function24) ? 256 : 128;
                }
                i5 = i2 & 4;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function25 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        jM9221getUnspecifiedMYxV2XQ = j;
                        i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(jM9221getUnspecifiedMYxV2XQ)) ? 16384 : 8192;
                    } else {
                        jM9221getUnspecifiedMYxV2XQ = j;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        if ((i2 & 16) == 0) {
                            richTooltipContainerShape = shape;
                            int i12 = composerStartRestartGroup.changed(richTooltipContainerShape) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            richTooltipContainerShape = shape;
                        }
                        i3 |= i12;
                    } else {
                        richTooltipContainerShape = shape;
                    }
                    if ((i & 1572864) != 0) {
                        i6 = 196608;
                        richTooltipColors2 = richTooltipColors;
                        i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(richTooltipColors2)) ? 1048576 : 524288;
                    } else {
                        i6 = 196608;
                        richTooltipColors2 = richTooltipColors;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        fM4947getLevel0D9Ej5fM = f;
                    } else {
                        fM4947getLevel0D9Ej5fM = f;
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(fM4947getLevel0D9Ej5fM) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i3 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        if ((i2 & 256) == 0) {
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function26 = function24;
                                function27 = function25;
                                richTooltipColors3 = richTooltipColors2;
                                shape2 = richTooltipContainerShape;
                                f3 = f2;
                                f4 = fM4947getLevel0D9Ej5fM;
                                modifier3 = modifier2;
                                j2 = jM9221getUnspecifiedMYxV2XQ;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "148@6318L25,149@6393L19");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function24 = null;
                                    }
                                    if (i5 != 0) {
                                        function25 = null;
                                    }
                                    if ((i2 & 8) != 0) {
                                        jM9221getUnspecifiedMYxV2XQ = DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -458753;
                                        richTooltipContainerShape = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 32) != 0) {
                                        richTooltipColors2 = TooltipDefaults.INSTANCE.richTooltipColors(composerStartRestartGroup, 6);
                                        i3 = (-3670017) & i3;
                                    }
                                    if (i7 != 0) {
                                        fM4947getLevel0D9Ej5fM = ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM();
                                    }
                                    if (i9 != 0) {
                                        Function2 function210 = function25;
                                        fM5290getContainerElevationD9Ej5fM = RichTooltipTokens.INSTANCE.m5290getContainerElevationD9Ej5fM();
                                        i10 = i3;
                                        function28 = function210;
                                        f5 = fM4947getLevel0D9Ej5fM;
                                        modifier4 = modifier2;
                                        function29 = function24;
                                        richTooltipColors4 = richTooltipColors2;
                                        j3 = jM9221getUnspecifiedMYxV2XQ;
                                        shape3 = richTooltipContainerShape;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-244908363, i10, -1, "androidx.compose.material3.RichTooltipAndroid (Tooltip.android.kt:154)");
                                    }
                                    int i13 = i10 << 3;
                                    long j4 = j3;
                                    TooltipKt.m4472RichTooltipEkvW5A0(tooltipScope, modifier4, function29, function28, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j3), TooltipDefaults.INSTANCE.m4464getRichTooltipMaxWidthD9Ej5fM(), shape3, richTooltipColors4, f5, fM5290getContainerElevationD9Ej5fM, function23, composerStartRestartGroup, (i10 & 14) | i6 | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (i13 & 3670016) | (i13 & 29360128) | (i13 & 234881024) | (i13 & 1879048192), (i10 >> 27) & 14, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function27 = function28;
                                    f3 = fM5290getContainerElevationD9Ej5fM;
                                    function26 = function29;
                                    f4 = f5;
                                    modifier3 = modifier4;
                                    richTooltipColors3 = richTooltipColors4;
                                    shape2 = shape3;
                                    j2 = j4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -3670017;
                                    }
                                }
                                f5 = fM4947getLevel0D9Ej5fM;
                                i10 = i3;
                                modifier4 = modifier2;
                                function29 = function24;
                                function28 = function25;
                                richTooltipColors4 = richTooltipColors2;
                                j3 = jM9221getUnspecifiedMYxV2XQ;
                                shape3 = richTooltipContainerShape;
                                fM5290getContainerElevationD9Ej5fM = f2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i132 = i10 << 3;
                                long j42 = j3;
                                TooltipKt.m4472RichTooltipEkvW5A0(tooltipScope, modifier4, function29, function28, TooltipDefaults.INSTANCE.m4461caretShapeEaSLcWc(j3), TooltipDefaults.INSTANCE.m4464getRichTooltipMaxWidthD9Ej5fM(), shape3, richTooltipColors4, f5, fM5290getContainerElevationD9Ej5fM, function23, composerStartRestartGroup, (i10 & 14) | i6 | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (i132 & 3670016) | (i132 & 29360128) | (i132 & 234881024) | (i132 & 1879048192), (i10 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function27 = function28;
                                f3 = fM5290getContainerElevationD9Ej5fM;
                                function26 = function29;
                                f4 = f5;
                                modifier3 = modifier4;
                                richTooltipColors3 = richTooltipColors4;
                                shape2 = shape3;
                                j2 = j42;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.Tooltip_androidKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return Tooltip_androidKt.RichTooltipAndroid_yDvdmqw$lambda$2(tooltipScope, modifier3, function26, function27, j2, shape2, richTooltipColors3, f4, f3, function23, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    if ((i2 & 256) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function25 = function22;
                if ((i & 24576) != 0) {
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 256) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function24 = function2;
            i5 = i2 & 4;
            if (i5 != 0) {
            }
            function25 = function22;
            if ((i & 24576) != 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 256) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 == 0) {
        }
        function24 = function2;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        function25 = function22;
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 256) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit RichTooltipAndroid_ZuUcA3Q$lambda$3(TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, float f, Shape shape, RichTooltipColors richTooltipColors, float f2, float f3, Function2 function23, int i, int i2, int i3, Composer composer, int i4) {
        RichTooltip(tooltipScope, modifier, function2, function22, j, f, shape, richTooltipColors, f2, f3, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit RichTooltipAndroid_yDvdmqw$lambda$2(TooltipScope tooltipScope, Modifier modifier, Function2 function2, Function2 function22, long j, Shape shape, RichTooltipColors richTooltipColors, float f, float f2, Function2 function23, int i, int i2, Composer composer, int i3) {
        RichTooltip(tooltipScope, modifier, function2, function22, j, shape, richTooltipColors, f, f2, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
