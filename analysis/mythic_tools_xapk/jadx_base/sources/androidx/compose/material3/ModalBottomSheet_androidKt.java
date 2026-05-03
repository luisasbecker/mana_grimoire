package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¶\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aT\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0004\b\"\u0010#\u001a\f\u0010$\u001a\u00020%*\u00020&H\u0000\u001a\u0013\u0010'\u001a\u00020%*\u00020\rH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*²\u0006\u0015\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/material3/ModalBottomSheetProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "ModalBottomSheetDialog-sW7UJKQ", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "isDark", "isDark-8_81llA", "(J)Z", "material3", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheet_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use constructor with contentWindowInsets parameter.", replaceWith = @ReplaceWith(expression = "ModalBottomSheet(onDismissRequest,modifier,sheetState,sheetMaxWidth,shape,containerColor,contentColor,tonalElevation,scrimColor,dragHandle,{ windowInsets },properties,content,)", imports = {}))
    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3831ModalBottomSheetdYc4hso(final Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, WindowInsets windowInsets, ModalBottomSheetProperties modalBottomSheetProperties, final Function3 function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        SheetState sheetStateRememberModalBottomSheetState;
        int i5;
        Shape shape2;
        long j4;
        long j5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final float f3;
        final Shape shape3;
        final long j6;
        final Modifier modifier3;
        final SheetState sheetState2;
        final long j7;
        final float f4;
        final long j8;
        final Function2 function22;
        final WindowInsets windowInsets2;
        final ModalBottomSheetProperties modalBottomSheetProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape expandedShape;
        long containerColor;
        long scrimColor;
        final WindowInsets windowInsets3;
        ModalBottomSheetProperties properties;
        Shape shape4;
        Modifier modifier4;
        float f5;
        SheetState sheetState3;
        long j9;
        long j10;
        float f6;
        Function2 function23;
        Composer composerStartRestartGroup = composer.startRestartGroup(1342054200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,windowInsets,properties,content)343@15830L485:ModalBottomSheet.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    int i14 = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) ? 256 : 128;
                    i4 |= i14;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i4 |= i14;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        shape2 = shape;
                        int i15 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i15;
                } else {
                    shape2 = shape;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    j4 = j;
                    i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(j4)) ? 131072 : 65536;
                } else {
                    j4 = j;
                }
                if ((i & 1572864) == 0) {
                    j5 = j2;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(j5)) ? 1048576 : 524288;
                } else {
                    j5 = j2;
                }
                i6 = i3 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i & 100663296) == 0) {
                    i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(j3)) ? 67108864 : 33554432;
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                    i4 |= 805306368;
                } else {
                    if ((i & 805306368) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                    }
                    if ((i2 & 6) != 0) {
                        i9 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(windowInsets)) ? 4 : 2);
                    } else {
                        i9 = i2;
                    }
                    i10 = i3 & 2048;
                    if (i10 == 0) {
                        i9 |= 48;
                        i11 = i10;
                    } else if ((i2 & 48) == 0) {
                        i11 = i10;
                        i9 |= composerStartRestartGroup.changed(modalBottomSheetProperties) ? 32 : 16;
                    } else {
                        i11 = i10;
                    }
                    i12 = i9;
                    if ((i3 & 4096) != 0) {
                        if ((i2 & 384) == 0) {
                            i12 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 147) == 146) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "331@15186L31,333@15317L13,334@15380L14,335@15422L31,337@15530L10,339@15677L12");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                }
                                float fM3326getSheetMaxWidthD9Ej5fM = i5 != 0 ? BottomSheetDefaults.INSTANCE.m3326getSheetMaxWidthD9Ej5fM() : f;
                                if ((i3 & 16) != 0) {
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    expandedShape = shape2;
                                }
                                if ((i3 & 32) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -458753;
                                } else {
                                    containerColor = j4;
                                }
                                if ((i3 & 64) != 0) {
                                    long jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 &= -3670017;
                                    j5 = jM3479contentColorForek8zF_U;
                                }
                                float fM9114constructorimpl = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                if ((i3 & 256) != 0) {
                                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    scrimColor = j3;
                                }
                                Function2 function2M3517getLambda$1294623166$material3 = i8 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m3517getLambda$1294623166$material3() : function2;
                                if ((i3 & 1024) != 0) {
                                    windowInsets3 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                                    i12 &= -15;
                                } else {
                                    windowInsets3 = windowInsets;
                                }
                                properties = i11 != 0 ? ModalBottomSheetDefaults.INSTANCE.getProperties() : modalBottomSheetProperties;
                                shape4 = expandedShape;
                                modifier4 = modifier2;
                                long j11 = containerColor;
                                f5 = fM3326getSheetMaxWidthD9Ej5fM;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                j9 = j5;
                                j10 = scrimColor;
                                f6 = fM9114constructorimpl;
                                function23 = function2M3517getLambda$1294623166$material3;
                                j4 = j11;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                if ((i3 & 1024) != 0) {
                                    i12 &= -15;
                                }
                                function23 = function2;
                                properties = modalBottomSheetProperties;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                j9 = j5;
                                f5 = f;
                                f6 = f2;
                                j10 = j3;
                                windowInsets3 = windowInsets;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1342054200, i4, i12, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:343)");
                            }
                            int i16 = i4 << 3;
                            int i17 = i12 << 3;
                            composer2 = composerStartRestartGroup;
                            ModalBottomSheetKt.m3826ModalBottomSheetYbuCTN8(function0, modifier4, sheetState3, f5, false, shape4, j4, j9, f6, j10, function23, new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1
                                public final WindowInsets invoke(Composer composer3, int i18) {
                                    composer3.startReplaceGroup(-677688734);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-677688734, i18, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:354)");
                                    }
                                    WindowInsets windowInsets4 = windowInsets3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return windowInsets4;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                    return invoke(composer3, num.intValue());
                                }
                            }, properties, function3, composer2, (i4 & 8190) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), ((i4 >> 27) & 14) | (i17 & 896) | (i17 & 7168), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            f3 = f5;
                            shape3 = shape4;
                            j7 = j9;
                            function22 = function23;
                            float f7 = f6;
                            windowInsets2 = windowInsets3;
                            sheetState2 = sheetState3;
                            j6 = j4;
                            f4 = f7;
                            j8 = j10;
                            modalBottomSheetProperties2 = properties;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            f3 = f;
                            shape3 = shape2;
                            j6 = j4;
                            modifier3 = modifier2;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            j7 = j5;
                            f4 = f2;
                            j8 = j3;
                            function22 = function2;
                            windowInsets2 = windowInsets;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheet_androidKt.ModalBottomSheet_dYc4hso$lambda$0(function0, modifier3, sheetState2, f3, shape3, j6, j7, f4, j8, function22, windowInsets2, modalBottomSheetProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i12 |= 384;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 147) == 146) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i2 & 6) != 0) {
                }
                i10 = i3 & 2048;
                if (i10 == 0) {
                }
                i12 = i9;
                if ((i3 & 4096) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 147) == 146) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            if ((i & 24576) == 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i3 & 128;
            if (i6 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i2 & 6) != 0) {
            }
            i10 = i3 & 2048;
            if (i10 == 0) {
            }
            i12 = i9;
            if ((i3 & 4096) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 147) == 146) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i3 & 128;
        if (i6 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i2 & 6) != 0) {
        }
        i10 = i3 & 2048;
        if (i10 == 0) {
        }
        i12 = i9;
        if ((i3 & 4096) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i12 & 147) == 146) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: ModalBottomSheetDialog-sW7UJKQ, reason: not valid java name */
    public static final void m3832ModalBottomSheetDialogsW7UJKQ(final Function0<Unit> function0, final long j, final ModalBottomSheetProperties modalBottomSheetProperties, final Animatable<Float, AnimationVector1D> animatable, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        ModalBottomSheetProperties modalBottomSheetProperties2;
        int i3;
        int i4;
        boolean z;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(766784632);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetDialog)N(onDismissRequest,contentColor:c#ui.graphics.Color,properties,predictiveBackProgress,content)370@16794L7,371@16833L7,372@16888L7,373@16918L28,374@16973L29,375@17039L21,375@17022L38,376@17077L24,378@17127L586,397@17744L129,397@17719L154,406@17890L224,406@17879L235:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            modalBottomSheetProperties2 = modalBottomSheetProperties;
            i2 |= composerStartRestartGroup.changed(modalBottomSheetProperties2) ? 256 : 128;
        } else {
            modalBottomSheetProperties2 = modalBottomSheetProperties;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(766784632, i2, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:369)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View view = (View) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i2 >> 12) & 14);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1854325107, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1854321726, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                i4 = 256;
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = new ModalBottomSheetDialogWrapper(function0, modalBottomSheetProperties2, j, view, layoutDirection, density, uuid, animatable, coroutineScope, null);
                layoutDirection = layoutDirection;
                z = true;
                modalBottomSheetDialogWrapper.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-1051373467, true, new ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper);
                obj = modalBottomSheetDialogWrapper;
            } else {
                i3 = i2;
                z = true;
                i4 = 256;
                obj = objRememberedValue3;
            }
            final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper2 = (ModalBottomSheetDialogWrapper) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1854302439, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7(modalBottomSheetDialogWrapper2, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(modalBottomSheetDialogWrapper2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1854297672, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            int i5 = i3;
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper2) | ((i5 & 14) == 4 ? z : false) | ((i5 & 896) == i4 ? z : false) | ((i5 & 112) == 32 ? z : false) | composerStartRestartGroup.changed(layoutDirection.ordinal());
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$10$lambda$9(modalBottomSheetDialogWrapper2, function0, modalBottomSheetProperties, j, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$11(function0, j, modalBottomSheetProperties, animatable, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog_sW7UJKQ$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$10$lambda$9(ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper, Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, LayoutDirection layoutDirection) {
        modalBottomSheetDialogWrapper.m3825updateParameters9LQNqLg(function0, modalBottomSheetProperties, j, layoutDirection);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$11(Function0 function0, long j, ModalBottomSheetProperties modalBottomSheetProperties, Animatable animatable, Function2 function2, int i, Composer composer, int i2) {
        m3832ModalBottomSheetDialogsW7UJKQ(function0, j, modalBottomSheetProperties, animatable, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7(final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper, DisposableEffectScope disposableEffectScope) {
        modalBottomSheetDialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                modalBottomSheetDialogWrapper.dismiss();
                modalBottomSheetDialogWrapper.disposeComposition();
            }
        };
    }

    static final Unit ModalBottomSheet_dYc4hso$lambda$0(Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, WindowInsets windowInsets, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3831ModalBottomSheetdYc4hso(function0, modifier, sheetState, f, shape, j, j2, f2, j3, function2, windowInsets, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isDark-8_81llA, reason: not valid java name */
    public static final boolean m3833isDark8_81llA(long j) {
        return !Color.m6326equalsimpl0(j, Color.INSTANCE.m6360getTransparent0d7_KjU()) && ((double) ColorKt.m6377luminance8_81llA(j)) <= 0.5d;
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }
}
