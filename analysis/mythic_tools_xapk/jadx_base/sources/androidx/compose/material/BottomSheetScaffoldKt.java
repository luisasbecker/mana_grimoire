package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001aý\u0001\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020&2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b-\u0010.\u001ao\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020$2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0004\b1\u00102\u001a\u0098\u0001\u00103\u001a\u00020\u00122\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0006\u0010(\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0001H\u0003¢\u0006\u0004\b8\u00109\u001a\u001c\u0010:\u001a\u00020;2\n\u00100\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0002\"\u0010\u0010?\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@¨\u0006C"}, d2 = {"rememberBottomSheetState", "Landroidx/compose/material/BottomSheetState;", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "rememberBottomSheetScaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "bottomSheetState", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "BottomSheetScaffold", "", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "topBar", "Lkotlin/Function0;", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "backgroundColor", "contentColor", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheet", ServerProtocol.DIALOG_PARAM_STATE, "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "FabSpacing", "F", "BottomSheetScaffoldPositionalThreshold", "BottomSheetScaffoldVelocityThreshold", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m9114constructorimpl(16.0f);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m9114constructorimpl(56.0f);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m9114constructorimpl(125.0f);

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = orientation;
        }

        private final float offsetToFloat(long j) {
            return Float.intBitsToFloat((int) (this.$orientation == Orientation.Horizontal ? j >> 32 : j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }

        private final long toOffset(float f) {
            float f2 = this.$orientation == Orientation.Horizontal ? f : 0.0f;
            if (this.$orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(f2)) << 32));
        }

        private final float velocityToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m9352getXimpl(j) : Velocity.m9353getYimpl(j);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object mo1791onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
                if ((bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            }
            Object obj = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9343boximpl(j2);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo1792onPostScrollDzOQY0M(long consumed, long available, int source) {
            return NestedScrollSource.m7506equalsimpl0(source, NestedScrollSource.INSTANCE.m7518getUserInputWNlRxjI()) ? toOffset(this.$state.dispatchRawDelta(offsetToFloat(available))) : Offset.INSTANCE.m6096getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object mo2114onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
                if ((bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            }
            Object obj = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= this.$state.getAnchors().minAnchor()) {
                    j = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                } else {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9343boximpl(j);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo2115onPreScrollOzD1aCk(long available, int source) {
            float fOffsetToFloat = offsetToFloat(available);
            return (fOffsetToFloat >= 0.0f || !NestedScrollSource.m7506equalsimpl0(source, NestedScrollSource.INSTANCE.m7518getUserInputWNlRxjI())) ? Offset.INSTANCE.m6096getZeroF1C5BW0() : toOffset(this.$state.dispatchRawDelta(fOffsetToFloat));
        }
    }

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: BottomSheet-dAqlCkY, reason: not valid java name */
    private static final void m2942BottomSheetdAqlCkY(final BottomSheetState bottomSheetState, final boolean z, final Shape shape, final float f, final long j, final long j2, final float f2, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-426833549);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheet)N(state,sheetGesturesEnabled,sheetShape,sheetElevation:c#ui.unit.Dp,sheetBackgroundColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetPeekHeight:c#ui.unit.Dp,modifier,content)388@16491L24,389@16557L7,392@16705L816,415@17745L893,440@18802L29,390@16597L2241:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(bottomSheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        int i5 = i2 & 128;
        if (i5 != 0) {
            i3 |= 12582912;
            i4 = 1572864;
            modifier2 = modifier;
        } else {
            i4 = 1572864;
            modifier2 = modifier;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            if (i5 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-426833549, i3, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:387)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(f2);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material = bottomSheetState.getAnchoredDraggableState$material();
            Orientation orientation = Orientation.Vertical;
            int i6 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2129837731, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i7 = i6 & 14;
            boolean zChanged = composerStartRestartGroup.changed(fMo1624toPx0680j_4) | (i7 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$1$0(bottomSheetState, fMo1624toPx0680j_4, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifier2, anchoredDraggableState$material, orientation, (Function2) objRememberedValue2), bottomSheetState.getAnchoredDraggableState$material(), Orientation.Vertical, z, false, null, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2129871088, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChangedInstance = (i7 == 4) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0(bottomSheetState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i8 = i6 >> 6;
            int i9 = ((i6 >> 3) & 112) | i4 | (i8 & 896) | (i8 & 7168) | (458752 & (i6 << 6));
            composer2 = composerStartRestartGroup;
            SurfaceKt.m3172SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default, false, (Function1) objRememberedValue3, 1, null), shape, j, j2, null, f, ComposableLambdaKt.rememberComposableLambda(1065607095, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i9, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$4(bottomSheetState, z, shape, f, j, j2, f2, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120  */
    /* JADX INFO: renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2943BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, int i, boolean z, Shape shape, float f, long j, long j2, float f2, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        int i6;
        int i7;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$937349512$material;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        long jM2976getBackground0d7_KjU;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape2;
        final long j5;
        final long j6;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final int i14;
        final Modifier modifier3;
        final BottomSheetScaffoldState bottomSheetScaffoldState2;
        final boolean z3;
        final float f3;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM3052getEnd5ygKITE;
        CornerBasedShape large;
        float fM2937getSheetElevationD9Ej5fM;
        boolean z4;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U;
        float fM2938getSheetPeekHeightD9Ej5fM;
        int i15;
        float f5;
        long j9;
        long j10;
        long j11;
        int i16;
        final float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(194495313);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffold)N(sheetContent,modifier,scaffoldState,topBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material.FabPosition,sheetGesturesEnabled,sheetShape,sheetElevation:c#ui.unit.Dp,sheetBackgroundColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetPeekHeight:c#ui.unit.Dp,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)337@14316L1792,337@14230L1878:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i17 = i4 & 2;
        if (i17 != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i4 & 4) == 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    int i18 = composerStartRestartGroup.changed(bottomSheetScaffoldStateRememberBottomSheetScaffoldState) ? 256 : 128;
                    i5 |= i18;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                i5 |= i18;
            } else {
                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    i5 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 == 0) {
                    if ((i2 & 24576) == 0) {
                        lambda$937349512$material = function32;
                        i5 |= composerStartRestartGroup.changedInstance(lambda$937349512$material) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function23 = function22;
                    } else {
                        function23 = function22;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        i10 = i;
                    } else {
                        i10 = i;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
                        }
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                        i5 |= 12582912;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
                        }
                    }
                    if ((i2 & 100663296) == 0) {
                        i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 805306368) == 0) {
                        i5 |= ((i4 & 512) == 0 && composerStartRestartGroup.changed(f)) ? 536870912 : 268435456;
                    }
                    if ((i3 & 6) != 0) {
                        i12 = i3 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(j)) ? 4 : 2);
                    } else {
                        i12 = i3;
                    }
                    if ((i3 & 48) != 0) {
                        i12 |= ((i4 & 2048) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
                    }
                    int i19 = i12;
                    if ((i3 & 384) != 0) {
                        i13 = i19 | (((i4 & 4096) == 0 && composerStartRestartGroup.changed(f2)) ? 256 : 128);
                    } else {
                        i13 = i19;
                    }
                    if ((i3 & 3072) != 0) {
                        jM2976getBackground0d7_KjU = j3;
                        i13 |= ((i4 & 8192) == 0 && composerStartRestartGroup.changed(jM2976getBackground0d7_KjU)) ? 2048 : 1024;
                    } else {
                        jM2976getBackground0d7_KjU = j3;
                    }
                    if ((i3 & 24576) == 0) {
                        i13 |= ((i4 & 16384) == 0 && composerStartRestartGroup.changed(j4)) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i13 |= composerStartRestartGroup.changedInstance(function33) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i13 & 74899) != 74898, i5 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function24 = function2;
                        shape2 = shape;
                        j5 = j4;
                        j6 = jM2976getBackground0d7_KjU;
                        function34 = lambda$937349512$material;
                        function25 = function23;
                        i14 = i10;
                        modifier3 = modifier2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        z3 = z2;
                        f3 = f;
                        j7 = j;
                        j8 = j2;
                        f4 = f2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            Function2<? super Composer, ? super Integer, Unit> function26 = i6 != 0 ? null : function2;
                            if (i7 != 0) {
                                lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                            }
                            if (i8 != 0) {
                                function23 = null;
                            }
                            iM3052getEnd5ygKITE = i9 != 0 ? FabPosition.INSTANCE.m3052getEnd5ygKITE() : i10;
                            if (i11 != 0) {
                                z2 = true;
                            }
                            if ((i4 & 256) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i5 &= -234881025;
                            } else {
                                large = shape;
                            }
                            if ((i4 & 512) != 0) {
                                fM2937getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2937getSheetElevationD9Ej5fM();
                                i5 &= -1879048193;
                            } else {
                                fM2937getSheetElevationD9Ej5fM = f;
                            }
                            if ((i4 & 1024) != 0) {
                                i13 &= -15;
                                z4 = z2;
                                jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                            } else {
                                z4 = z2;
                                jM2987getSurface0d7_KjU = j;
                            }
                            if ((i4 & 2048) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, i13 & 14);
                                i13 &= -113;
                            } else {
                                jM3001contentColorForek8zF_U = j2;
                            }
                            int i20 = i13;
                            function2 = function26;
                            if ((i4 & 4096) != 0) {
                                fM2938getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2938getSheetPeekHeightD9Ej5fM();
                                i20 &= -897;
                            } else {
                                fM2938getSheetPeekHeightD9Ej5fM = f2;
                            }
                            float f7 = fM2938getSheetPeekHeightD9Ej5fM;
                            if ((i4 & 8192) != 0) {
                                jM2976getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2976getBackground0d7_KjU();
                                i15 = i20 & (-7169);
                            } else {
                                i15 = i20;
                            }
                            if ((i4 & 16384) != 0) {
                                long jM3001contentColorForek8zF_U2 = ColorsKt.m3001contentColorForek8zF_U(jM2976getBackground0d7_KjU, composerStartRestartGroup, (i15 >> 9) & 14);
                                i15 &= -57345;
                                f5 = f7;
                                j9 = jM3001contentColorForek8zF_U2;
                            } else {
                                f5 = f7;
                                j9 = j4;
                            }
                            j10 = jM2976getBackground0d7_KjU;
                            j11 = jM2987getSurface0d7_KjU;
                            z2 = z4;
                            i16 = i5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if ((i4 & 256) != 0) {
                                i5 &= -234881025;
                            }
                            if ((i4 & 512) != 0) {
                                i5 &= -1879048193;
                            }
                            if ((i4 & 1024) != 0) {
                                i13 &= -15;
                            }
                            if ((i4 & 2048) != 0) {
                                i13 &= -113;
                            }
                            i15 = i13;
                            if ((i4 & 4096) != 0) {
                                i15 &= -897;
                            }
                            if ((i4 & 8192) != 0) {
                                i15 &= -7169;
                            }
                            if ((i4 & 16384) != 0) {
                                i15 &= -57345;
                            }
                            fM2937getSheetElevationD9Ej5fM = f;
                            jM3001contentColorForek8zF_U = j2;
                            f5 = f2;
                            j9 = j4;
                            j10 = jM2976getBackground0d7_KjU;
                            i16 = i5;
                            iM3052getEnd5ygKITE = i10;
                            large = shape;
                            j11 = j;
                        }
                        int i21 = i15;
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            f6 = fM2937getSheetElevationD9Ej5fM;
                            ComposerKt.traceEventStart(194495313, i16, i21, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                        } else {
                            f6 = fM2937getSheetElevationD9Ej5fM;
                        }
                        final float f8 = f5;
                        final long j12 = j11;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35 = lambda$937349512$material;
                        final int i22 = iM3052getEnd5ygKITE;
                        final Function2<? super Composer, ? super Integer, Unit> function28 = function23;
                        final Shape shape3 = large;
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final boolean z5 = z2;
                        final long j13 = jM3001contentColorForek8zF_U;
                        float f9 = f6;
                        int i23 = i21 >> 3;
                        long j14 = j10;
                        long j15 = j9;
                        SurfaceKt.m3172SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j14, j15, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState3, function27, function28, f8, i22, function33, z5, shape3, f6, j12, j13, function3, function35, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i23 & 7168) | (i23 & 896) | 1572864, 50);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function24 = function27;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        z3 = z2;
                        j5 = j15;
                        j8 = j13;
                        f4 = f8;
                        function25 = function23;
                        f3 = f9;
                        function34 = lambda$937349512$material;
                        i14 = iM3052getEnd5ygKITE;
                        shape2 = large;
                        modifier3 = modifier2;
                        j7 = j12;
                        j6 = j14;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function24, function34, function25, i14, z3, shape2, f3, j7, j8, f4, j6, j5, function33, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= 24576;
                lambda$937349512$material = function32;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                if ((i2 & 100663296) == 0) {
                }
                if ((i2 & 805306368) == 0) {
                }
                if ((i3 & 6) != 0) {
                }
                if ((i3 & 48) != 0) {
                }
                int i192 = i12;
                if ((i3 & 384) != 0) {
                }
                if ((i3 & 3072) != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i13 & 74899) != 74898, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i7 = i4 & 16;
            if (i7 == 0) {
            }
            lambda$937349512$material = function32;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            if ((i2 & 805306368) == 0) {
            }
            if ((i3 & 6) != 0) {
            }
            if ((i3 & 48) != 0) {
            }
            int i1922 = i12;
            if ((i3 & 384) != 0) {
            }
            if ((i3 & 3072) != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i13 & 74899) != 74898, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        lambda$937349512$material = function32;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        if ((i2 & 805306368) == 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i3 & 48) != 0) {
        }
        int i19222 = i12;
        if ((i3 & 384) != 0) {
        }
        if ((i3 & 3072) != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i13 & 74899) != 74898, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    private static final void m2944BottomSheetScaffoldLayoutHJHHjMs(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final float f, final Function0<Float> function0, final int i, final BottomSheetState bottomSheetState, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(757616750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)N(topBar,body,bottomSheet,floatingActionButton,snackbarHost,sheetPeekHeight:c#ui.unit.Dp,sheetOffset,floatingActionButtonPosition:c#material.FabPosition,sheetState)479@20010L2783,470@19764L3029:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(bottomSheetState) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757616750, i3, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:469)");
            }
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m3006getLambda$505419337$material() : function2;
            function2Arr[1] = function22;
            function2Arr[2] = function23;
            function2Arr[3] = function24 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$687232378$material() : function24;
            function2Arr[4] = function25;
            List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2074720627, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((3670016 & i3) == 1048576) | ((29360128 & i3) == 8388608) | ((458752 & i3) == 131072) | ((i3 & 234881024) == 67108864);
            BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(function0, i, f, bottomSheetState);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffoldLayout_HJHHjMs$lambda$1(function2, function22, function23, function24, function25, f, function0, i, bottomSheetState, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BottomSheetScaffoldLayout_HJHHjMs$lambda$1(Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, float f, Function0 function0, int i, BottomSheetState bottomSheetState, int i2, Composer composer, int i3) {
        m2944BottomSheetScaffoldLayoutHJHHjMs(function2, function22, function23, function24, function25, f, function0, i, bottomSheetState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit BottomSheetScaffold_HnlDQGw$lambda$0(final BottomSheetScaffoldState bottomSheetScaffoldState, Function2 function2, Function2 function22, final float f, int i, final Function3 function3, final boolean z, final Shape shape, final float f2, final long j, final long j2, final Function3 function32, final Function3 function33, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C340@14401L52,341@14481L1220,366@15787L49,369@15968L50,338@14326L1776:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-747577963, i2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:338)");
            }
            BottomSheetState bottomSheetState = bottomSheetScaffoldState.getBottomSheetState();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(601061661, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$0(function3, f, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1835125948, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$1(z, bottomSheetScaffoldState, f, shape, f2, j, j2, function32, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(8287226, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$2(function33, bottomSheetScaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1162831097, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChanged = composer.changed(bottomSheetScaffoldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$3$0(bottomSheetScaffoldState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m2944BottomSheetScaffoldLayoutHJHHjMs(function2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, function22, composableLambdaRememberComposableLambda3, f, (Function0) objRememberedValue, i, bottomSheetState, composer, 25008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$0(Function3 function3, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C340@14403L48:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(601061661, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:340)");
            }
            function3.invoke(PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$1(boolean z, BottomSheetScaffoldState bottomSheetScaffoldState, float f, Shape shape, float f2, long j, long j2, Function3 function3, Composer composer, int i) {
        Modifier.Companion companionNestedScroll$default;
        ComposerKt.sourceInformation(composer, "C353@15111L576:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1835125948, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:342)");
            }
            if (z) {
                composer.startReplaceGroup(-401495582);
                ComposerKt.sourceInformation(composer, "345@14641L391");
                Modifier.Companion companion = Modifier.INSTANCE;
                AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material = bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material();
                ComposerKt.sourceInformationMarkerStart(composer, -1675517117, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean zChanged = composer.changed(anchoredDraggableState$material);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material(), Orientation.Vertical);
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) objRememberedValue, null, 2, null);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1675503260);
                composer.endReplaceGroup();
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            m2942BottomSheetdAqlCkY(bottomSheetScaffoldState.getBottomSheetState(), z, shape, f2, j, j2, f, SizeKt.m2074requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companionNestedScroll$default, 0.0f, 1, null), f, 0.0f, 2, null), function3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$2(Function3 function3, BottomSheetScaffoldState bottomSheetScaffoldState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C366@15789L45:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(8287226, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:366)");
            }
            function3.invoke(bottomSheetScaffoldState.getSnackbarHostState(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomSheetScaffold_HnlDQGw$lambda$0$3$0(BottomSheetScaffoldState bottomSheetScaffoldState) {
        return bottomSheetScaffoldState.getBottomSheetState().requireOffset();
    }

    static final Unit BottomSheetScaffold_HnlDQGw$lambda$1(Function3 function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2 function2, Function3 function32, Function2 function22, int i, boolean z, Shape shape, float f, long j, long j2, float f2, long j3, long j4, Function3 function33, int i2, int i3, int i4, Composer composer, int i5) {
        m2943BottomSheetScaffoldHnlDQGw(function3, modifier, bottomSheetScaffoldState, function2, function32, function22, i, z, shape, f, j, j2, f2, j3, j4, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair BottomSheet_dAqlCkY$lambda$1$0(BottomSheetState bottomSheetState, final float f, IntSize intSize, Constraints constraints) {
        BottomSheetValue bottomSheetValue;
        final int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(constraints.getValue());
        final float fM9289unboximpl = (int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$1$0$0(iM9066getMaxHeightimpl, f, fM9289unboximpl, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material().getTargetValue().ordinal()];
        if (i == 1) {
            bottomSheetValue = BottomSheetValue.Collapsed;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            bottomSheetValue = DraggableAnchors.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
        }
        return TuplesKt.to(DraggableAnchors, bottomSheetValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$1$0$0(int i, float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        float f3 = i;
        draggableAnchorsConfig.at(BottomSheetValue.Collapsed, f3 - f);
        if (f2 > 0.0f && f2 != f) {
            draggableAnchorsConfig.at(BottomSheetValue.Expanded, f3 - f2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$2$0(final BottomSheetState bottomSheetState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (bottomSheetState.getAnchoredDraggableState$material().getAnchors().getSize() > 1) {
            if (bottomSheetState.isCollapsed()) {
                SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0$0(bottomSheetState, coroutineScope));
                    }
                }, 1, null);
            } else {
                SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0$1(bottomSheetState, coroutineScope));
                    }
                }, 1, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomSheet_dAqlCkY$lambda$2$0$0(BottomSheetState bottomSheetState, CoroutineScope coroutineScope) {
        if (!bottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Expanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$1$1(bottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomSheet_dAqlCkY$lambda$2$0$1(BottomSheetState bottomSheetState, CoroutineScope coroutineScope) {
        if (!bottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Collapsed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$2$1(bottomSheetState, null), 3, null);
        return true;
    }

    static final Unit BottomSheet_dAqlCkY$lambda$3(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C440@18804L25:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065607095, i, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:440)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit BottomSheet_dAqlCkY$lambda$4(BottomSheetState bottomSheetState, boolean z, Shape shape, float f, long j, long j2, float f2, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2942BottomSheetdAqlCkY(bottomSheetState, z, shape, f, j, j2, f2, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1022285988, "C(rememberBottomSheetScaffoldState)N(bottomSheetState,snackbarHostState)264@10031L35,265@10111L32,267@10186L197:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 1130681436, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:266)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1130684001, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(bottomSheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
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

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue bottomSheetValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1808153344, "C(rememberBottomSheetState)N(initialValue,animationSpec,confirmStateChange)223@8800L8,225@8863L7,234@9135L211,226@8882L464:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1826384664, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BottomSheetScaffoldKt.rememberBottomSheetState$lambda$0$0((BottomSheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:224)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {animationSpec};
        Saver<BottomSheetState, ?> Saver = BottomSheetState.INSTANCE.Saver(animationSpec, function1, density);
        ComposerKt.sourceInformationMarkerStart(composer, -1826373741, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(bottomSheetValue.ordinal())) || (i & 6) == 4) | composer.changed(density) | composer.changedInstance(animationSpec);
        if ((((i & 896) ^ 384) <= 256 || !composer.changed(function1)) && (i & 384) != 256) {
            z = false;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BottomSheetScaffoldKt.rememberBottomSheetState$lambda$1$0(bottomSheetValue, density, animationSpec, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bottomSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberBottomSheetState$lambda$0$0(BottomSheetValue bottomSheetValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomSheetState rememberBottomSheetState$lambda$1$0(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1) {
        return new BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }
}
