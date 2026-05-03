package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aú\u0001\u0010!\u001a\u00020\u0001*\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0001¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a\u0014\u00103\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a-\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u000b2\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u00108\u001a5\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0003¢\u0006\u0004\b=\u0010>\"\u0010\u0010?\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006E²\u0006\n\u0010F\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/material3/ModalBottomSheetProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", "visible", "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final float PredictiveBackMaxScaleXDistance = Dp.m9114constructorimpl(48.0f);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m9114constructorimpl(24.0f);
    private static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
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

    /* JADX WARN: Removed duplicated region for block: B:106:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3826ModalBottomSheetYbuCTN8(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, ModalBottomSheetProperties modalBottomSheetProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        final SheetState sheetStateRememberModalBottomSheetState;
        int i5;
        float f3;
        int i6;
        boolean z2;
        Shape expandedShape;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final long j4;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function23;
        final ModalBottomSheetProperties modalBottomSheetProperties2;
        final float f4;
        final boolean z3;
        final Modifier modifier3;
        final SheetState sheetState2;
        final Shape shape2;
        final long j5;
        final float f5;
        final long j6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long containerColor;
        long jM3479contentColorForek8zF_U;
        long scrimColor;
        ModalBottomSheetKt$ModalBottomSheet$1 modalBottomSheetKt$ModalBottomSheet$1;
        float f6;
        ModalBottomSheetProperties modalBottomSheetProperties3;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25;
        float f7;
        long j7;
        boolean z4;
        Modifier modifier4;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        long j8;
        long j9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1904798512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)140@7306L7,141@7400L7,142@7491L7,144@7515L174,144@7504L185,149@7706L24,150@7770L327,161@8151L149,167@8335L42,172@8504L708,184@9277L883,169@8383L1777:ModalBottomSheet.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 2;
        if (i14 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    int i15 = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) ? 256 : 128;
                    i4 |= i15;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i4 |= i15;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    f3 = f;
                    i4 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        expandedShape = shape;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(expandedShape)) ? 131072 : 65536;
                    } else {
                        expandedShape = shape;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(j)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        i7 = i4 | (((i3 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304);
                    } else {
                        i7 = i4;
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i7 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i7 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i7 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(j3)) ? 536870912 : 268435456;
                    }
                    i9 = i3 & 1024;
                    if (i9 == 0) {
                        i11 = i2 | 6;
                        i10 = i9;
                    } else if ((i2 & 6) == 0) {
                        i10 = i9;
                        i11 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                    } else {
                        i10 = i9;
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i11 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changedInstance(function22)) ? 32 : 16;
                    }
                    int i16 = i11;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i16 | 384;
                    } else {
                        int i17 = i16;
                        if ((i2 & 384) == 0) {
                            i17 |= composerStartRestartGroup.changed(modalBottomSheetProperties) ? 256 : 128;
                        }
                        i13 = i17;
                    }
                    if ((i3 & 8192) != 0) {
                        if ((i2 & 3072) == 0) {
                            i13 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i13 & 1171) == 1170) ? false : true, i7 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "125@6423L31,128@6596L13,129@6659L14,130@6701L31,132@6809L10");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i7 &= -897;
                                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                }
                                float fM3326getSheetMaxWidthD9Ej5fM = i5 != 0 ? BottomSheetDefaults.INSTANCE.m3326getSheetMaxWidthD9Ej5fM() : f3;
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    i7 &= -458753;
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 64) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i7 >> 18) & 14);
                                    i7 &= -29360129;
                                } else {
                                    jM3479contentColorForek8zF_U = j2;
                                }
                                float fM9114constructorimpl = i8 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                if ((i3 & 512) != 0) {
                                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i7 &= -1879048193;
                                } else {
                                    scrimColor = j3;
                                }
                                Function2<? super Composer, ? super Integer, Unit> lambda$1121996006$material3 = i10 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3() : function2;
                                if ((i3 & 2048) != 0) {
                                    modalBottomSheetKt$ModalBottomSheet$1 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$1
                                        public final WindowInsets invoke(Composer composer3, int i18) {
                                            composer3.startReplaceGroup(-511854661);
                                            ComposerKt.sourceInformation(composer3, "C134@6983L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-511854661, i18, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:134)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                    i13 &= -113;
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$1 = function22;
                                }
                                int i18 = i13;
                                if (i12 != 0) {
                                    f6 = fM3326getSheetMaxWidthD9Ej5fM;
                                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, (DefaultConstructorMarker) null);
                                    function25 = modalBottomSheetKt$ModalBottomSheet$1;
                                    f7 = fM9114constructorimpl;
                                    j7 = containerColor;
                                    z4 = z2;
                                    modifier4 = modifier2;
                                    shape3 = expandedShape;
                                    function26 = lambda$1121996006$material3;
                                    j8 = jM3479contentColorForek8zF_U;
                                    j9 = scrimColor;
                                    i13 = i18;
                                } else {
                                    f6 = fM3326getSheetMaxWidthD9Ej5fM;
                                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                                    function25 = modalBottomSheetKt$ModalBottomSheet$1;
                                    f7 = fM9114constructorimpl;
                                    j7 = containerColor;
                                    z4 = z2;
                                    modifier4 = modifier2;
                                    shape3 = expandedShape;
                                    function26 = lambda$1121996006$material3;
                                    j8 = jM3479contentColorForek8zF_U;
                                    j9 = scrimColor;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i7 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i7 &= -1879048193;
                                }
                                if ((i3 & 2048) != 0) {
                                    i13 &= -113;
                                }
                                j7 = j;
                                j8 = j2;
                                f7 = f2;
                                j9 = j3;
                                function26 = function2;
                                function25 = function22;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                                f6 = f3;
                                z4 = z2;
                                modifier4 = modifier2;
                                shape3 = expandedShape;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1904798512, i7, i13, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:137)");
                            }
                            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                            final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342110, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i19 = (i7 & 896) ^ 384;
                            boolean zChangedInstance = ((i19 > 256 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i7 & 384) == 256) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(sheetStateRememberModalBottomSheetState, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855350423, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i20 = i7 & 14;
                            boolean zChangedInstance2 = ((i19 > 256 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i7 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | (i20 == 4);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function02 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855362437, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | ((i19 > 256 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i7 & 384) == 256) | (i20 == 4);
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(coroutineScope, sheetStateRememberModalBottomSheetState, function0, ((Float) obj).floatValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            Function1 function1 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855368218, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            final Animatable animatable = (Animatable) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855374292, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean zChangedInstance4 = (i20 == 4) | ((i19 > 256 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i7 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(sheetStateRememberModalBottomSheetState, coroutineScope, animatable, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ModalBottomSheet_androidKt.m3832ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue6, j8, modalBottomSheetProperties3, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new ModalBottomSheetKt$ModalBottomSheet$4(j9, function02, sheetStateRememberModalBottomSheetState, modalBottomSheetProperties3, animatable, coroutineScope, function1, modifier4, f6, z4, shape3, j7, j8, f7, function26, function25, function3), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 896) | ((i7 >> 18) & 112) | 24576 | (Animatable.$stable << 9));
                            composer2 = composerStartRestartGroup;
                            if (sheetStateRememberModalBottomSheetState.getHasExpandedState()) {
                                composer2.startReplaceGroup(748459762);
                                ComposerKt.sourceInformation(composer2, "212@10235L21,212@10208L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855428997, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                boolean z5 = (i19 > 256 && composer2.changed(sheetStateRememberModalBottomSheetState)) || (i7 & 384) == 256;
                                ModalBottomSheetKt$ModalBottomSheet$5$1 modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composer2.rememberedValue();
                                if (z5 || modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetStateRememberModalBottomSheetState, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetStateRememberModalBottomSheetState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composer2, (i7 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748521266);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            j6 = j9;
                            modalBottomSheetProperties2 = modalBottomSheetProperties3;
                            modifier3 = modifier4;
                            f4 = f6;
                            z3 = z4;
                            shape2 = shape3;
                            j4 = j7;
                            j5 = j8;
                            f5 = f7;
                            function24 = function26;
                            function23 = function25;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            j4 = j;
                            function23 = function22;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                            f4 = f3;
                            z3 = z2;
                            modifier3 = modifier2;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            shape2 = expandedShape;
                            j5 = j2;
                            f5 = f2;
                            j6 = j3;
                            function24 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$13(function0, modifier3, sheetState2, f4, z3, shape2, j4, j5, f5, j6, function24, function23, modalBottomSheetProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i13 |= 3072;
                    if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i13 & 1171) == 1170) ? false : true, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i9 = i3 & 1024;
                if (i9 == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i162 = i11;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                if ((i3 & 8192) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i13 & 1171) == 1170) ? false : true, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            f3 = f;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i9 = i3 & 1024;
            if (i9 == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i1622 = i11;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            if ((i3 & 8192) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i13 & 1171) == 1170) ? false : true, i7 & 1)) {
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
        f3 = f;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z2 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i9 = i3 & 1024;
        if (i9 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i16222 = i11;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        if ((i3 & 8192) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i13 & 1171) == 1170) ? false : true, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

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
    /* JADX WARN: Removed duplicated region for block: B:219:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
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
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary compatibility. Use overload with sheetGesturesEnabled param.")
    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3827ModalBottomSheetdYc4hso(final Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, final Function3 function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        SheetState sheetStateRememberModalBottomSheetState;
        int i5;
        Shape shape2;
        long j4;
        long jM3479contentColorForek8zF_U;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final float f3;
        ModalBottomSheetProperties properties;
        final Shape shape3;
        final long j5;
        final SheetState sheetState2;
        final long j6;
        final float f4;
        long j7;
        final Function2 function23;
        final Function2 function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape expandedShape;
        long containerColor;
        long scrimColor;
        ModalBottomSheetKt$ModalBottomSheet$7 modalBottomSheetKt$ModalBottomSheet$7;
        Function2 function25;
        Shape shape4;
        Modifier modifier3;
        float f5;
        Function2 function26;
        SheetState sheetState3;
        long j8;
        float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(953901324);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)237@11249L525:ModalBottomSheet.kt#uh7d8r");
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
                    jM3479contentColorForek8zF_U = j2;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(jM3479contentColorForek8zF_U)) ? 1048576 : 524288;
                } else {
                    jM3479contentColorForek8zF_U = j2;
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
                        i9 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changedInstance(function22)) ? 4 : 2);
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
                            ComposerKt.sourceInformation(composerStartRestartGroup, "225@10576L31,227@10707L13,228@10770L14,229@10812L31,231@10920L10");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
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
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 &= -3670017;
                                }
                                float fM9114constructorimpl = i6 != 0 ? Dp.m9114constructorimpl(0.0f) : f2;
                                if ((i3 & 256) != 0) {
                                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i4 = (-234881025) & i4;
                                } else {
                                    scrimColor = j3;
                                }
                                Function2 function2M3516getLambda$655173438$material3 = i8 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.m3516getLambda$655173438$material3() : function2;
                                if ((i3 & 1024) != 0) {
                                    modalBottomSheetKt$ModalBottomSheet$7 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$7
                                        public final WindowInsets invoke(Composer composer3, int i16) {
                                            composer3.startReplaceGroup(69134487);
                                            ComposerKt.sourceInformation(composer3, "C233@11094L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(69134487, i16, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:233)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                    i12 &= -15;
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$7 = function22;
                                }
                                properties = i11 != 0 ? ModalBottomSheetDefaults.INSTANCE.getProperties() : modalBottomSheetProperties;
                                function25 = modalBottomSheetKt$ModalBottomSheet$7;
                                j4 = containerColor;
                                shape4 = expandedShape;
                                modifier3 = modifier2;
                                float f7 = fM9114constructorimpl;
                                f5 = fM3326getSheetMaxWidthD9Ej5fM;
                                function26 = function2M3516getLambda$655173438$material3;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                j8 = jM3479contentColorForek8zF_U;
                                j7 = scrimColor;
                                f6 = f7;
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
                                function26 = function2;
                                function25 = function22;
                                properties = modalBottomSheetProperties;
                                shape4 = shape2;
                                modifier3 = modifier2;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                j8 = jM3479contentColorForek8zF_U;
                                f5 = f;
                                f6 = f2;
                                j7 = j3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(953901324, i4, i12, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:237)");
                            }
                            int i16 = i4 << 3;
                            int i17 = i12 << 3;
                            composer2 = composerStartRestartGroup;
                            m3826ModalBottomSheetYbuCTN8(function0, modifier3, sheetState3, f5, true, shape4, j4, j8, f6, j7, function26, function25, properties, function3, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), ((i4 >> 27) & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            long j9 = j8;
                            modifier2 = modifier3;
                            shape3 = shape4;
                            j6 = j9;
                            sheetState2 = sheetState3;
                            f3 = f5;
                            j5 = j4;
                            f4 = f6;
                            function23 = function26;
                            function24 = function25;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            f3 = f;
                            properties = modalBottomSheetProperties;
                            shape3 = shape2;
                            j5 = j4;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            j6 = jM3479contentColorForek8zF_U;
                            f4 = f2;
                            j7 = j3;
                            function23 = function2;
                            function24 = function22;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final ModalBottomSheetProperties modalBottomSheetProperties2 = properties;
                            final Modifier modifier4 = modifier2;
                            final long j10 = j7;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_dYc4hso$lambda$14(function0, modifier4, sheetState2, f3, shape3, j5, j6, f4, j10, function23, function24, modalBottomSheetProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /* JADX INFO: renamed from: ModalBottomSheetContent-7---e2Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3828ModalBottomSheetContent7e2Q(final BoxScope boxScope, final Animatable<Float, AnimationVector1D> animatable, final CoroutineScope coroutineScope, final Function0<Unit> function0, final Function1<? super Float, Unit> function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        final SheetState sheetStateRememberModalBottomSheetState;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        float f3;
        int i12;
        int i13;
        final float f4;
        final Shape shape2;
        final float f5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final SheetState sheetState2;
        final Modifier modifier3;
        final boolean z3;
        Composer composer2;
        final long j3;
        final long j4;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        Shape expandedShape;
        long containerColor;
        long jM3479contentColorForek8zF_U;
        Function2<? super Composer, ? super Integer, Unit> lambda$1716959002$material3;
        Shape shape3;
        long j5;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25;
        Modifier modifier4;
        int i15;
        float f6;
        float f7;
        Shape shape4;
        float f8;
        long j6;
        Modifier.Companion companionNestedScroll$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-37400432);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetContent)N(predictiveBackProgress,scope,animateToDismiss,settleToDismiss,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,dragHandle,contentWindowInsets,content)273@12729L48,294@13641L1602,331@15615L23,333@15685L112,338@15930L612,358@17107L4293,275@12783L8617:ModalBottomSheet.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= (i & 64) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 256 : 128;
            }
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function02 = function0;
                    i4 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
                }
                int i16 = 8192;
                if ((i3 & 8) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
                }
                i5 = i3 & 16;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) ? 1048576 : 524288;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 100663296;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i & 100663296) == 0) {
                        i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                }
                if ((i & 805306368) == 0) {
                    i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(shape)) ? 536870912 : 268435456;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 512) == 0) {
                        i8 = i4;
                        int i17 = composerStartRestartGroup.changed(j) ? 4 : 2;
                        i9 = i2 | i17;
                    } else {
                        i8 = i4;
                    }
                    i9 = i2 | i17;
                } else {
                    i8 = i4;
                    i9 = i2;
                }
                if ((i2 & 48) == 0) {
                    i10 = i8;
                    i9 |= ((i3 & 1024) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
                } else {
                    i10 = i8;
                }
                int i18 = i9;
                i11 = i3 & 2048;
                if (i11 != 0) {
                    i18 |= 384;
                } else {
                    if ((i2 & 384) == 0) {
                        f3 = f2;
                        i18 |= composerStartRestartGroup.changed(f3) ? 256 : 128;
                    }
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i18 | 3072;
                    } else {
                        int i19 = i18;
                        if ((i2 & 3072) == 0) {
                            i13 = i19 | (composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024);
                        } else {
                            i13 = i19;
                        }
                    }
                    if ((i2 & 24576) == 0) {
                        if ((i3 & 8192) == 0 && composerStartRestartGroup.changedInstance(function22)) {
                            i16 = 16384;
                        }
                        i13 |= i16;
                    }
                    if ((i3 & 16384) != 0) {
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i13 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i13 & 74899) == 74898) ? false : true, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "262@12100L31,265@12273L13,266@12336L14,267@12378L31");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i5 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 32) != 0) {
                                    i14 = i10 & (-3670017);
                                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                } else {
                                    i14 = i10;
                                }
                                float fM3326getSheetMaxWidthD9Ej5fM = i6 != 0 ? BottomSheetDefaults.INSTANCE.m3326getSheetMaxWidthD9Ej5fM() : f;
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 256) != 0) {
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i14 &= -1879048193;
                                } else {
                                    expandedShape = shape;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 &= -15;
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 1024) != 0) {
                                    jM3479contentColorForek8zF_U = ColorSchemeKt.m3479contentColorForek8zF_U(containerColor, composerStartRestartGroup, i13 & 14);
                                    i13 &= -113;
                                } else {
                                    jM3479contentColorForek8zF_U = j2;
                                }
                                float fM3324getElevationD9Ej5fM = i11 != 0 ? BottomSheetDefaults.INSTANCE.m3324getElevationD9Ej5fM() : f2;
                                lambda$1716959002$material3 = i12 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1716959002$material3() : function2;
                                float f9 = fM3326getSheetMaxWidthD9Ej5fM;
                                if ((i3 & 8192) != 0) {
                                    i13 &= -57345;
                                    shape3 = expandedShape;
                                    j5 = containerColor;
                                    function25 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$1
                                        public final WindowInsets invoke(Composer composer3, int i20) {
                                            composer3.startReplaceGroup(1023699493);
                                            ComposerKt.sourceInformation(composer3, "C270@12629L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1023699493, i20, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:270)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                } else {
                                    shape3 = expandedShape;
                                    j5 = containerColor;
                                    function25 = function22;
                                }
                                modifier4 = modifier2;
                                i15 = i13;
                                f6 = fM3324getElevationD9Ej5fM;
                                f7 = f9;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                int i20 = (i3 & 32) != 0 ? i10 & (-3670017) : i10;
                                if ((i3 & 256) != 0) {
                                    i20 &= -1879048193;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 &= -15;
                                }
                                if ((i3 & 1024) != 0) {
                                    i13 &= -113;
                                }
                                if ((i3 & 8192) != 0) {
                                    i13 &= -57345;
                                }
                                j5 = j;
                                jM3479contentColorForek8zF_U = j2;
                                lambda$1716959002$material3 = function2;
                                function25 = function22;
                                i14 = i20;
                                modifier4 = modifier2;
                                i15 = i13;
                                f7 = f;
                                f6 = f3;
                                shape3 = shape;
                            }
                            composerStartRestartGroup.endDefaults();
                            Function2<? super Composer, ? super Integer, ? extends WindowInsets> function26 = function25;
                            if (ComposerKt.isTraceInProgress()) {
                                shape4 = shape3;
                                ComposerKt.traceEventStart(-37400432, i14, i15, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:272)");
                            } else {
                                shape4 = shape3;
                            }
                            Strings.Companion companion = Strings.INSTANCE;
                            final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_bottom_sheet_pane_title), composerStartRestartGroup, 0);
                            Modifier modifier5 = modifier4;
                            int i21 = i15;
                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(boxScope.align(modifier4, Alignment.INSTANCE.getTopCenter()), 0.0f, f7, 1, null), 0.0f, 1, null);
                            if (z2) {
                                composerStartRestartGroup.startReplaceGroup(-1582035383);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "284@13098L373");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1582034107, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                f8 = f7;
                                boolean z4 = (((3670016 & i14) ^ 1572864) > 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i14 & 1572864) == 1048576;
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, function1);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                j6 = j5;
                                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) objRememberedValue, null, 2, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                f8 = f7;
                                j6 = j5;
                                composerStartRestartGroup.startReplaceGroup(-1582020872);
                                composerStartRestartGroup.endReplaceGroup();
                                companionNestedScroll$default = Modifier.INSTANCE;
                            }
                            Modifier modifierThen = modifierFillMaxWidth$default.then(companionNestedScroll$default);
                            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                            Orientation orientation = Orientation.Vertical;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1582015502, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i22 = (3670016 & i14) ^ 1572864;
                            boolean z5 = (i22 > 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i14 & 1572864) == 1048576;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(modifierThen, anchoredDraggableState$material3, orientation, (Function2) objRememberedValue2);
                            DraggableState draggableState = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3().getDraggableState();
                            Orientation orientation2 = Orientation.Vertical;
                            boolean z6 = z2 && sheetStateRememberModalBottomSheetState.isVisible();
                            boolean zIsAnimationRunning = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3().isAnimationRunning();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1581953913, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean z7 = (57344 & i14) == 16384;
                            ModalBottomSheetKt$ModalBottomSheetContent$4$1 modalBottomSheetKt$ModalBottomSheetContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7 || modalBottomSheetKt$ModalBottomSheetContent$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                modalBottomSheetKt$ModalBottomSheetContent$4$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheetContent$4$1(function1, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheetContent$4$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierDraggable$default = DraggableKt.draggable$default(modifierDraggableAnchors, draggableState, orientation2, z6, null, zIsAnimationRunning, null, (Function3) modalBottomSheetKt$ModalBottomSheetContent$4$1RememberedValue, false, 168, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1581951584, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(strM4676getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(modifierDraggable$default, false, (Function1) objRememberedValue3, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetStateRememberModalBottomSheetState.getOffset$material3(), 0), 0, 0, 13, null));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1581943244, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean z8 = ((i22 > 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i14 & 1572864) == 1048576) | ((i14 & 112) == 32 || ((i14 & 64) != 0 && composerStartRestartGroup.changedInstance(animatable)));
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (z8 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SheetState sheetState3 = sheetStateRememberModalBottomSheetState;
                            boolean z9 = z2;
                            Function2<? super Composer, ? super Integer, Unit> function27 = lambda$1716959002$material3;
                            int i23 = i21 << 6;
                            int i24 = ((i14 >> 24) & 112) | 12582912 | (i23 & 896) | (i23 & 7168) | (i23 & 57344);
                            Shape shape5 = shape4;
                            long j7 = jM3479contentColorForek8zF_U;
                            SurfaceKt.m4145SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(modifierConsumeWindowInsets, (Function1) objRememberedValue4), sheetStateRememberModalBottomSheetState), shape5, j6, j7, f6, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(728743275, true, new ModalBottomSheetKt$ModalBottomSheetContent$7(function26, animatable, sheetState3, function27, function3, function02, coroutineScope, z9), composerStartRestartGroup, 54), composerStartRestartGroup, i24, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z9;
                            sheetState2 = sheetState3;
                            function23 = function27;
                            shape2 = shape5;
                            f5 = f6;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f4 = f8;
                            function24 = function26;
                            j4 = j7;
                            j3 = j6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            f4 = f;
                            shape2 = shape;
                            f5 = f2;
                            function23 = function2;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            modifier3 = modifier2;
                            z3 = z2;
                            composer2 = composerStartRestartGroup;
                            j3 = j;
                            j4 = j2;
                            function24 = function22;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$24(boxScope, animatable, coroutineScope, function0, function1, modifier3, sheetState2, f4, z3, shape2, j3, j4, f5, function23, function24, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if (composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i13 & 74899) == 74898) ? false : true, i10 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                f3 = f2;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i3 & 16384) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i13 & 74899) == 74898) ? false : true, i10 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function02 = function0;
            int i162 = 8192;
            if ((i3 & 8) != 0) {
            }
            i5 = i3 & 16;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i182 = i9;
            i11 = i3 & 2048;
            if (i11 != 0) {
            }
            f3 = f2;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i3 & 16384) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i13 & 74899) == 74898) ? false : true, i10 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        function02 = function0;
        int i1622 = 8192;
        if ((i3 & 8) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i1822 = i9;
        i11 = i3 & 2048;
        if (i11 != 0) {
        }
        f3 = f2;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i3 & 16384) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i13 & 74899) == 74898) ? false : true, i10 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Pair ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(final SheetState sheetState, final IntSize intSize, Constraints constraints) {
        SheetValue sheetValue;
        final float fM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(constraints.getValue());
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(fM9066getMaxHeightimpl, intSize, sheetState, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3().getTargetValue().ordinal()];
        if (i == 1) {
            sheetValue = SheetValue.Hidden;
        } else if (i == 2) {
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded) ? SheetValue.PartiallyExpanded : DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, sheetValue);
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(float f, IntSize intSize, SheetState sheetState, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SheetValue.Hidden, f);
        if (((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) > f / 2.0f && !sheetState.getSkipPartiallyExpanded()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f / 2.0f);
        }
        if (((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != 0) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, f - ((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 0.0f);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState sheetState, Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (!Float.isNaN(offset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (offset + fIntBitsToFloat) / fIntBitsToFloat));
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope boxScope, Animatable animatable, CoroutineScope coroutineScope, Function0 function0, Function1 function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2 function2, Function2 function22, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3828ModalBottomSheetContent7e2Q(boxScope, animatable, coroutineScope, function0, function1, modifier, sheetState, f, z, shape, j, j2, f2, function2, function22, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState sheetState, CoroutineScope coroutineScope, Animatable animatable, final Function0 function0) {
        if (sheetState.getCurrentValue() == SheetValue.Expanded && sheetState.getHasPartiallyExpandedState()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(animatable, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(sheetState, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$13(Function0 function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3826ModalBottomSheetYbuCTN8(function0, modifier, sheetState, f, z, shape, j, j2, f2, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(final SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        if (sheetState.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(sheetState, function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope coroutineScope, final SheetState sheetState, final Function0 function0, float f) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(sheetState, f, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(sheetState, function0, (Throwable) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_dYc4hso$lambda$14(Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3827ModalBottomSheetdYc4hso(function0, modifier, sheetState, f, shape, j, j2, f2, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-KTwxG1Y, reason: not valid java name */
    public static final void m3829ScrimKTwxG1Y(final long j, final Function0<Unit> function0, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        int i3;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-391613911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible,dismissEnabled):ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391613911, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:514)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-1438582326);
                ComposerKt.sourceInformation(composerStartRestartGroup, "520@24316L7,518@24171L167,522@24364L29,537@24994L79,537@24944L129");
                int i4 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                Strings.Companion companion = Strings.INSTANCE;
                final String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.close_sheet), composerStartRestartGroup, 0);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1438283579);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "525@24511L44,526@24612L263");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616173205, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i5 = i4 & 112;
                    boolean z3 = i5 == 32;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (PointerInputEventHandler) new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616176656, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM4676getString2EP1pXo) | (i5 == 32);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30(strM4676getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 = 1;
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i3 = 1;
                    composerStartRestartGroup.startReplaceGroup(-1437857391);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616188696, "CC(remember):ModalBottomSheet.kt#9igjgp");
                int i6 = (composerStartRestartGroup.changed(stateAnimateFloatAsState) ? 1 : 0) | ((i4 & 14) == 4 ? i3 : 0);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (i6 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$33$lambda$32(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1437676103);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$34(j, function0, z, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float Scrim_KTwxG1Y$lambda$27(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit Scrim_KTwxG1Y$lambda$31$lambda$30(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0 function0) {
        function0.invoke();
        return true;
    }

    static final Unit Scrim_KTwxG1Y$lambda$33$lambda$32(long j, State state, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_KTwxG1Y$lambda$27(state), 0.0f, 1.0f), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_KTwxG1Y$lambda$34(long j, Function0 function0, boolean z, boolean z2, int i, Composer composer, int i2) {
        m3829ScrimKTwxG1Y(j, function0, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1624toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1624toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)500@23719L8,502@23737L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -573963974, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$26$lambda$25((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:502)");
        }
        SheetState sheetStateM4054rememberSheetStateAGcomas = SheetDefaultsKt.m4054rememberSheetStateAGcomas(z2, function12, SheetValue.Hidden, false, 0.0f, 0.0f, composer, (i & 14) | 384 | (i & 112), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM4054rememberSheetStateAGcomas;
    }

    static final boolean rememberModalBottomSheetState$lambda$26$lambda$25(SheetValue sheetValue) {
        return true;
    }
}
