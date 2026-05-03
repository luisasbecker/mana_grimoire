package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b \u0010!\u001a!\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010&\u001a7\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020)2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,\u001a\u008a\u0001\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b4\u00105\u001aq\u00106\u001a\u00020\u00012\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00162\u0006\u0010;\u001a\u00020$H\u0003¢\u0006\u0002\u0010<\u001a\u0014\u0010=\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000\u001a\u0014\u0010>\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000¨\u0006?"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "Landroidx/compose/material3/SheetState;", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "StandardBottomSheet", ServerProtocol.DIALOG_PARAM_STATE, "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;Landroidx/compose/runtime/Composer;I)V", "verticalScaleUp", "verticalScaleDown", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    /* JADX INFO: renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3329BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        int i5;
        float fM3327getSheetPeekHeightD9Ej5fM;
        int i6;
        float fM3326getSheetMaxWidthD9Ej5fM;
        Shape expandedShape;
        long containerColor;
        int i7;
        long jM3479contentColorForek8zF_U;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final long j5;
        final long j6;
        Composer composer2;
        final float f5;
        final float f6;
        final Shape shape2;
        final long j7;
        final BottomSheetScaffoldState bottomSheetScaffoldState3;
        final long j8;
        final float f7;
        final float f8;
        final boolean z2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        float fM9114constructorimpl;
        float fM3324getElevationD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> lambda$1392012807$material3;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$1768941633$material3;
        Modifier modifier3;
        long surface;
        long j9;
        long j10;
        int i20;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(920075480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffold)N(sheetContent,modifier,scaffoldState,sheetPeekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetShape,sheetContainerColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetTonalElevation:c#ui.unit.Dp,sheetShadowElevation:c#ui.unit.Dp,sheetDragHandle,sheetSwipeEnabled,topBar,snackbarHost,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)136@7263L1424:BottomSheetScaffold.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i21 = i3 & 2;
        if (i21 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    int i22 = composerStartRestartGroup.changed(bottomSheetScaffoldState2) ? 256 : 128;
                    i4 |= i22;
                } else {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                }
                i4 |= i22;
            } else {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    fM3327getSheetPeekHeightD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM3327getSheetPeekHeightD9Ej5fM) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                int i23 = 8192;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        fM3326getSheetMaxWidthD9Ej5fM = f2;
                        i4 |= composerStartRestartGroup.changed(fM3326getSheetMaxWidthD9Ej5fM) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        expandedShape = shape;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(expandedShape)) ? 131072 : 65536;
                    } else {
                        expandedShape = shape;
                    }
                    if ((i & 1572864) != 0) {
                        containerColor = j;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(containerColor)) ? 1048576 : 524288;
                    } else {
                        containerColor = j;
                    }
                    if ((i & 12582912) != 0) {
                        i7 = i5;
                        jM3479contentColorForek8zF_U = j2;
                        i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 8388608 : 4194304;
                    } else {
                        i7 = i5;
                        jM3479contentColorForek8zF_U = j2;
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= composerStartRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    i9 = i3 & 512;
                    if (i9 != 0) {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(f4) ? 536870912 : 268435456;
                        }
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 6) == 0) {
                            i12 = i11;
                            i13 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        i14 = i3 & 2048;
                        if (i14 != 0) {
                            i13 |= 48;
                            i15 = i14;
                        } else if ((i2 & 48) == 0) {
                            i15 = i14;
                            i13 |= composerStartRestartGroup.changed(z) ? 32 : 16;
                        } else {
                            i15 = i14;
                        }
                        int i24 = i13;
                        i16 = i3 & 4096;
                        if (i16 != 0) {
                            i17 = i24 | 384;
                        } else {
                            int i25 = i24;
                            if ((i2 & 384) == 0) {
                                i25 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
                            }
                            i17 = i25;
                        }
                        i18 = i3 & 8192;
                        if (i18 != 0) {
                            i19 = i17 | 3072;
                        } else {
                            int i26 = i17;
                            if ((i2 & 3072) == 0) {
                                i19 = i26 | (composerStartRestartGroup.changedInstance(function32) ? 2048 : 1024);
                            } else {
                                i19 = i26;
                            }
                        }
                        if ((i2 & 24576) == 0) {
                            if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(j3)) {
                                i23 = 16384;
                            }
                            i19 |= i23;
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i19 |= ((i3 & 32768) == 0 && composerStartRestartGroup.changed(j4)) ? 131072 : 65536;
                        }
                        if ((i3 & 65536) != 0) {
                            i19 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i19 |= composerStartRestartGroup.changedInstance(function33) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i19 & 599187) == 599186) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "120@6376L34,123@6578L13,124@6646L14,125@6693L36,132@7125L11,133@7172L31");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i21 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                                }
                                if (i7 != 0) {
                                    fM3327getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m3327getSheetPeekHeightD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM3326getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3326getSheetMaxWidthD9Ej5fM();
                                }
                                if ((i3 & 32) != 0) {
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 18) & 14);
                                    i4 &= -29360129;
                                }
                                fM9114constructorimpl = i8 != 0 ? Dp.m9114constructorimpl(0.0f) : f3;
                                fM3324getElevationD9Ej5fM = i10 != 0 ? BottomSheetDefaults.INSTANCE.m3324getElevationD9Ej5fM() : f4;
                                lambda$1392012807$material3 = i12 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3() : function2;
                                z3 = i15 != 0 ? true : z;
                                function25 = i16 != 0 ? null : function22;
                                lambda$1768941633$material3 = i18 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3() : function32;
                                if ((i3 & 16384) != 0) {
                                    i19 &= -57345;
                                    modifier3 = companion;
                                    surface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getSurface();
                                } else {
                                    modifier3 = companion;
                                    surface = j3;
                                }
                                if ((32768 & i3) != 0) {
                                    long jM3479contentColorForek8zF_U2 = ColorSchemeKt.m3479contentColorForek8zF_U(surface, composerStartRestartGroup, (i19 >> 12) & 14);
                                    i19 &= -458753;
                                    j9 = jM3479contentColorForek8zF_U2;
                                } else {
                                    j9 = j4;
                                }
                                j10 = surface;
                                i20 = i19;
                                modifier4 = modifier3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 16384) != 0) {
                                    i19 &= -57345;
                                }
                                if ((32768 & i3) != 0) {
                                    i19 &= -458753;
                                }
                                modifier4 = modifier;
                                fM3324getElevationD9Ej5fM = f4;
                                lambda$1392012807$material3 = function2;
                                z3 = z;
                                function25 = function22;
                                lambda$1768941633$material3 = function32;
                                j10 = j3;
                                j9 = j4;
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState2;
                                i20 = i19;
                                fM9114constructorimpl = f3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(920075480, i4, i20, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:135)");
                            }
                            long j11 = j10;
                            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), j11, null, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            Modifier modifier5 = modifier4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            float f9 = fM3327getSheetPeekHeightD9Ej5fM;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1080463218, "C139@7540L1141,139@7474L1207:BottomSheetScaffold.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j9)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1$1(bottomSheetScaffoldStateRememberBottomSheetScaffoldState, function25, function33, f9, fM3326getSheetMaxWidthD9Ej5fM, z3, expandedShape, containerColor, jM3479contentColorForek8zF_U, fM9114constructorimpl, fM3324getElevationD9Ej5fM, lambda$1392012807$material3, function3, lambda$1768941633$material3), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            f5 = f9;
                            f6 = fM3326getSheetMaxWidthD9Ej5fM;
                            bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            shape2 = expandedShape;
                            j7 = containerColor;
                            f7 = fM9114constructorimpl;
                            f8 = fM3324getElevationD9Ej5fM;
                            j8 = jM3479contentColorForek8zF_U;
                            modifier2 = modifier5;
                            function34 = lambda$1768941633$material3;
                            j5 = j11;
                            function23 = lambda$1392012807$material3;
                            function24 = function25;
                            z2 = z3;
                            j6 = j9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function23 = function2;
                            function34 = function32;
                            j5 = j3;
                            j6 = j4;
                            composer2 = composerStartRestartGroup;
                            f5 = fM3327getSheetPeekHeightD9Ej5fM;
                            f6 = fM3326getSheetMaxWidthD9Ej5fM;
                            shape2 = expandedShape;
                            j7 = containerColor;
                            bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                            j8 = jM3479contentColorForek8zF_U;
                            f7 = f3;
                            f8 = f4;
                            z2 = z;
                            function24 = function22;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BottomSheetScaffoldKt.BottomSheetScaffold_sdMYb0k$lambda$1(function3, modifier2, bottomSheetScaffoldState3, f5, f6, shape2, j7, j8, f7, f8, function23, z2, function24, function34, j5, j6, function33, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    i14 = i3 & 2048;
                    if (i14 != 0) {
                    }
                    int i242 = i13;
                    i16 = i3 & 4096;
                    if (i16 != 0) {
                    }
                    i18 = i3 & 8192;
                    if (i18 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i19 & 599187) == 599186) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                fM3326getSheetMaxWidthD9Ej5fM = f2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                i14 = i3 & 2048;
                if (i14 != 0) {
                }
                int i2422 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                }
                i18 = i3 & 8192;
                if (i18 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i3 & 65536) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i19 & 599187) == 599186) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM3327getSheetPeekHeightD9Ej5fM = f;
            i6 = i3 & 16;
            int i232 = 8192;
            if (i6 != 0) {
            }
            fM3326getSheetMaxWidthD9Ej5fM = f2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            i14 = i3 & 2048;
            if (i14 != 0) {
            }
            int i24222 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
            }
            i18 = i3 & 8192;
            if (i18 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i3 & 65536) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i19 & 599187) == 599186) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        fM3327getSheetPeekHeightD9Ej5fM = f;
        i6 = i3 & 16;
        int i2322 = 8192;
        if (i6 != 0) {
        }
        fM3326getSheetMaxWidthD9Ej5fM = f2;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        i14 = i3 & 2048;
        if (i14 != 0) {
        }
        int i242222 = i13;
        i16 = i3 & 4096;
        if (i16 != 0) {
        }
        i18 = i3 & 8192;
        if (i18 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i3 & 65536) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((306783379 & i4) == 306783378 && (i19 & 599187) == 599186) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomSheetScaffoldLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function0<Float> function0, final SheetState sheetState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1217723575);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)N(topBar,body,bottomSheet,snackbarHost,sheetOffset,sheetState)416@20022L1942,414@19911L2053:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(sheetState) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1217723575, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:413)");
            }
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m3513getLambda$788244078$material3() : function2;
            function2Arr[1] = function22;
            function2Arr[2] = function23;
            function2Arr[3] = function24;
            List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001235553, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((458752 & i2) == 131072) | ((i2 & 57344) == 16384);
            BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetState, function0);
                composerStartRestartGroup.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicy);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffoldLayout$lambda$16(function2, function22, function23, function24, function0, sheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BottomSheetScaffoldLayout$lambda$16(Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function0 function0, SheetState sheetState, int i, Composer composer, int i2) {
        BottomSheetScaffoldLayout(function2, function22, function23, function24, function0, sheetState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit BottomSheetScaffold_sdMYb0k$lambda$1(Function3 function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2 function2, boolean z, Function2 function22, Function3 function32, long j3, long j4, Function3 function33, int i, int i2, int i3, Composer composer, int i4) {
        m3329BottomSheetScaffoldsdMYb0k(function3, modifier, bottomSheetScaffoldState, f, f2, shape, j, j2, f3, f4, function2, z, function22, function32, j3, j4, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cb  */
    /* JADX INFO: renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3330StandardBottomSheetw7I5h1o(final SheetState sheetState, final float f, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int i5;
        Object objRememberedValue;
        final float fMo1624toPx0680j_4;
        CoroutineScope coroutineScope;
        Modifier.Companion companionNestedScroll$default;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2108849428);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StandardBottomSheet)N(state,peekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetSwipeEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,dragHandle,content)238@11171L7,239@11265L7,240@11356L7,242@11380L159,242@11369L170,248@11557L24,250@11666L7,271@12473L1938,322@15222L4372,265@12198L7396:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(f4) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2108849428, i3, i4, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:235)");
            }
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620288715, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i6 = i3 & 14;
            boolean zChangedInstance = (i6 == 4) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                i5 = i3;
            } else {
                i5 = i3;
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Orientation orientation = Orientation.Vertical;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(f);
                if (z) {
                    coroutineScope = coroutineScope2;
                    composerStartRestartGroup.startReplaceGroup(2049851798);
                    composerStartRestartGroup.endReplaceGroup();
                    companionNestedScroll$default = Modifier.INSTANCE;
                } else {
                    composerStartRestartGroup.startReplaceGroup(2049456610);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "254@11804L327");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    AnchoredDraggableState<SheetValue> anchoredDraggableState$material3 = sheetState.getAnchoredDraggableState$material3();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620302451, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState$material3);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$10$lambda$9(coroutineScope2, sheetState, ((Float) obj).floatValue());
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    coroutineScope = coroutineScope2;
                    companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) objRememberedValue4, null, 2, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierThen = SizeKt.m2074requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), 0.0f, 1, null), f, 0.0f, 2, null).then(companionNestedScroll$default);
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material32 = sheetState.getAnchoredDraggableState$material3();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620325470, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                zChanged = (i6 != 4) | composerStartRestartGroup.changed(fMo1624toPx0680j_4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(sheetState, fMo1624toPx0680j_4, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierVerticalScaleUp = verticalScaleUp(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifierThen, anchoredDraggableState$material32, orientation, (Function2) objRememberedValue2), sheetState.getAnchoredDraggableState$material3(), orientation, z, false, null, 24, null), sheetState);
                final CoroutineScope coroutineScope3 = coroutineScope;
                int i7 = i5 >> 9;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4145SurfaceT9BRK9s(modifierVerticalScaleUp, shape, j, j2, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(1508311921, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i8) {
                        ComposerKt.sourceInformation(composer3, "C323@15232L4356:BottomSheetScaffold.kt#uh7d8r");
                        if (!composer3.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1508311921, i8, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:323)");
                        }
                        Modifier modifierVerticalScaleDown = BottomSheetScaffoldKt.verticalScaleDown(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), sheetState);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        SheetState sheetState2 = sheetState;
                        CoroutineScope coroutineScope4 = coroutineScope3;
                        boolean z2 = z;
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScaleDown);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1044090540, "C399@19569L9:BottomSheetScaffold.kt#uh7d8r");
                        if (function22 != null) {
                            composer3.startReplaceGroup(-1044068159);
                            ComposerKt.sourceInformation(composer3, "332@15663L54,333@15759L48,334@15848L47,335@15934L3608,335@15912L3630");
                            Strings.Companion companion2 = Strings.INSTANCE;
                            String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer3, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            String strM4676getString2EP1pXo2 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer3, 0);
                            Strings.Companion companion4 = Strings.INSTANCE;
                            SheetDefaultsKt.DragHandleWithTooltip(columnScopeInstance, ComposableLambdaKt.rememberComposableLambda(-511691176, true, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(sheetState2, coroutineScope4, z2, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer3, 0), strM4676getString2EP1pXo, strM4676getString2EP1pXo2, function22), composer3, 54), composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-1040260677);
                            composer3.endReplaceGroup();
                        }
                        function32.invoke(columnScopeInstance, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (i7 & 458752), 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$7$lambda$6(sheetState, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final CoroutineScope coroutineScope22 = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Orientation orientation2 = Orientation.Vertical;
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fMo1624toPx0680j_4 = ((Density) objConsume2).mo1624toPx0680j_4(f);
            if (z) {
            }
            Modifier modifierThen2 = SizeKt.m2074requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), 0.0f, 1, null), f, 0.0f, 2, null).then(companionNestedScroll$default);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material322 = sheetState.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620325470, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            zChanged = (i6 != 4) | composerStartRestartGroup.changed(fMo1624toPx0680j_4);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(sheetState, fMo1624toPx0680j_4, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierVerticalScaleUp2 = verticalScaleUp(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifierThen2, anchoredDraggableState$material322, orientation2, (Function2) objRememberedValue2), sheetState.getAnchoredDraggableState$material3(), orientation2, z, false, null, 24, null), sheetState);
                final CoroutineScope coroutineScope32 = coroutineScope;
                int i72 = i5 >> 9;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4145SurfaceT9BRK9s(modifierVerticalScaleUp2, shape, j, j2, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(1508311921, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i8) {
                        ComposerKt.sourceInformation(composer3, "C323@15232L4356:BottomSheetScaffold.kt#uh7d8r");
                        if (!composer3.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1508311921, i8, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:323)");
                        }
                        Modifier modifierVerticalScaleDown = BottomSheetScaffoldKt.verticalScaleDown(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), sheetState);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        SheetState sheetState2 = sheetState;
                        CoroutineScope coroutineScope4 = coroutineScope32;
                        boolean z2 = z;
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScaleDown);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1044090540, "C399@19569L9:BottomSheetScaffold.kt#uh7d8r");
                        if (function22 != null) {
                            composer3.startReplaceGroup(-1044068159);
                            ComposerKt.sourceInformation(composer3, "332@15663L54,333@15759L48,334@15848L47,335@15934L3608,335@15912L3630");
                            Strings.Companion companion2 = Strings.INSTANCE;
                            String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer3, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            String strM4676getString2EP1pXo2 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer3, 0);
                            Strings.Companion companion4 = Strings.INSTANCE;
                            SheetDefaultsKt.DragHandleWithTooltip(columnScopeInstance, ComposableLambdaKt.rememberComposableLambda(-511691176, true, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(sheetState2, coroutineScope4, z2, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer3, 0), strM4676getString2EP1pXo, strM4676getString2EP1pXo2, function22), composer3, 54), composer3, 54);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-1040260677);
                            composer3.endReplaceGroup();
                        }
                        function32.invoke(columnScopeInstance, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, (i72 & 112) | 12582912 | (i72 & 896) | (i72 & 7168) | (57344 & i72) | (i72 & 458752), 64);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$14(sheetState, f, f2, z, shape, j, j2, f3, f4, function2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$10$lambda$9(CoroutineScope coroutineScope, SheetState sheetState, float f) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1(sheetState, f, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Pair StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(final SheetState sheetState, final float f, IntSize intSize, Constraints constraints) {
        final float fM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(constraints.getValue());
        final float fM9289unboximpl = (int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.StandardBottomSheet_w7I5h1o$lambda$13$lambda$12$lambda$11(sheetState, fM9066getMaxHeightimpl, f, fM9289unboximpl, (DraggableAnchorsConfig) obj);
            }
        });
        SheetValue targetValue = sheetState.getAnchoredDraggableState$material3().getTargetValue();
        int i = WhenMappings.$EnumSwitchMapping$0[targetValue.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (DraggableAnchors.hasAnchorFor(SheetValue.Expanded)) {
                    targetValue = SheetValue.Expanded;
                } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                    targetValue = SheetValue.PartiallyExpanded;
                } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
                    targetValue = SheetValue.Hidden;
                }
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                targetValue = SheetValue.PartiallyExpanded;
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.Expanded)) {
                targetValue = SheetValue.Expanded;
            } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
                targetValue = SheetValue.Hidden;
            }
        } else if (DraggableAnchors.hasAnchorFor(SheetValue.Hidden)) {
            targetValue = SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, targetValue);
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$13$lambda$12$lambda$11(SheetState sheetState, float f, float f2, float f3, DraggableAnchorsConfig draggableAnchorsConfig) {
        if (!sheetState.getSkipPartiallyExpanded()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f - f2);
        }
        if (f3 != f2) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(f - f3, 0.0f));
        }
        if (!sheetState.getSkipHiddenState()) {
            draggableAnchorsConfig.at(SheetValue.Hidden, f);
        }
        return Unit.INSTANCE;
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$14(SheetState sheetState, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2 function2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3330StandardBottomSheetw7I5h1o(sheetState, f, f2, z, shape, j, j2, f3, f4, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$7$lambda$6(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1474606134, "C(rememberBottomSheetScaffoldState)N(bottomSheetState,snackbarHostState)189@9451L34,190@9530L32,192@9605L197:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            sheetState = rememberStandardBottomSheetState(null, null, false, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 242719018, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 242721583, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(sheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        Function1<? super SheetValue, Boolean> function12;
        ComposerKt.sourceInformationMarkerStart(composer, 678511581, "C(rememberStandardBottomSheetState)N(initialValue,confirmValueChange,skipHiddenState)212@10383L8,215@10438L154:BottomSheetScaffold.kt#uh7d8r");
        SheetValue sheetValue2 = (i2 & 1) != 0 ? SheetValue.PartiallyExpanded : sheetValue;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -785394011, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BottomSheetScaffoldKt.rememberStandardBottomSheetState$lambda$5$lambda$4((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function12 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            function12 = function1;
        }
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:215)");
        }
        SheetState sheetStateM4054rememberSheetStateAGcomas = SheetDefaultsKt.m4054rememberSheetStateAGcomas(false, function12, sheetValue2, z2, 0.0f, 0.0f, composer, (i & 112) | ((i << 6) & 896) | ((i << 3) & 7168), 49);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM4054rememberSheetStateAGcomas;
    }

    static final boolean rememberStandardBottomSheetState$lambda$5$lambda$4(SheetValue sheetValue) {
        return true;
    }

    public static final Modifier verticalScaleDown(Modifier modifier, final SheetState sheetState) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.verticalScaleDown$lambda$18(sheetState, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit verticalScaleDown$lambda$18(SheetState sheetState, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fMinAnchor = sheetState.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        float f = offset < fMinAnchor ? fMinAnchor - offset : 0.0f;
        graphicsLayerScope.setScaleY(f > 0.0f ? 1.0f / ((Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + f) / Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : 1.0f);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0.0f));
        return Unit.INSTANCE;
    }

    public static final Modifier verticalScaleUp(Modifier modifier, final SheetState sheetState) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.verticalScaleUp$lambda$17(sheetState, (GraphicsLayerScope) obj);
            }
        });
    }

    static final Unit verticalScaleUp$lambda$17(SheetState sheetState, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fMinAnchor = sheetState.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        float f = offset < fMinAnchor ? fMinAnchor - offset : 0.0f;
        graphicsLayerScope.setScaleY(f > 0.0f ? (Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + f) / Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & graphicsLayerScope.getSize())) : 1.0f);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0.0f));
        return Unit.INSTANCE;
    }
}
