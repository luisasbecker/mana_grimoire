package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\n2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0090\u0001\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b#\u0010$\u001a\u0090\u0001\u0010%\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002\u001a-\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\u0006\u0010/\u001a\u00020\u0006H\u0003¢\u0006\u0004\b0\u00101\u001a;\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\"2\u0006\u0010-\u001a\u00020\u001eH\u0003¢\u0006\u0004\b6\u00107\u001a\u0014\u0010?\u001a\u00020@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0002\"\u0010\u00108\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010:\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010;\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010D\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material/DrawerState;", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "rememberBottomDrawerState", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "ModalDrawer", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "Landroidx/compose/ui/unit/Dp;", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawer", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", "pos", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "EndDrawerPadding", "F", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomDrawerOpenFraction", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/AnchoredDraggableState;", "material", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = Dp.m9114constructorimpl(56.0f);
    private static final float DrawerPositionalThreshold = Dp.m9114constructorimpl(56.0f);
    private static final float DrawerVelocityThreshold = Dp.m9114constructorimpl(400.0f);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: Drawer.kt */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0007*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0012H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation = Orientation.Vertical;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState) {
            this.$state = anchoredDraggableState;
        }

        private final float offsetToFloat(long j) {
            return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }

        private final long toOffset(float f) {
            float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
            if (this.orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(f2)) << 32));
        }

        private final float velocityToFloat(long j) {
            return this.orientation == Orientation.Horizontal ? Velocity.m9352getXimpl(j) : Velocity.m9353getYimpl(j);
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object mo1791onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
                if ((drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            }
            Object obj = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
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
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
                if ((drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            }
            Object obj = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= this.$state.getAnchors().minAnchor()) {
                    j = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                } else {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
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

    /* JADX INFO: compiled from: Drawer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomDrawerValue.values().length];
            try {
                iArr[BottomDrawerValue.Closed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomDrawerValue.Open.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Type inference failed for: r0v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3026BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomDrawerState bottomDrawerState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        BottomDrawerState bottomDrawerState2;
        int i4;
        boolean z2;
        Shape shape2;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        final Modifier modifier2;
        final long j4;
        Composer composer2;
        final BottomDrawerState bottomDrawerState3;
        final boolean z3;
        final Shape shape3;
        final float f3;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        BottomDrawerState bottomDrawerStateRememberBottomDrawerState;
        Shape shape4;
        long backgroundColor;
        long jM3001contentColorForek8zF_U;
        final long scrimColor;
        final BottomDrawerState bottomDrawerState4;
        final Shape shape5;
        final float f4;
        final boolean z5;
        final long j7;
        final long j8;
        ?? r0;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1403479060);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,drawerShape,drawerElevation:c#ui.unit.Dp,drawerBackgroundColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,scrimColor:c#ui.graphics.Color,content)589@23753L24,590@23825L4662,590@23782L4705:Drawer.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    bottomDrawerState2 = bottomDrawerState;
                    int i10 = composerStartRestartGroup.changedInstance(bottomDrawerState2) ? 256 : 128;
                    i3 |= i10;
                } else {
                    bottomDrawerState2 = bottomDrawerState;
                }
                i3 |= i10;
            } else {
                bottomDrawerState2 = bottomDrawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
                z2 = z;
            } else {
                z2 = z;
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
            }
            if ((i & 24576) != 0) {
                shape2 = shape;
                i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(shape2)) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            i5 = i2 & 32;
            if (i5 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
            } else {
                f2 = f;
                if ((196608 & i) == 0) {
                    i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                }
            }
            if ((1572864 & i) != 0) {
                i6 = i3 | (((i2 & 64) == 0 && composerStartRestartGroup.changed(j)) ? 1048576 : 524288);
            } else {
                i6 = i3;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i7 = i9;
                    int i11 = composerStartRestartGroup.changed(j2) ? 8388608 : 4194304;
                    i6 |= i11;
                } else {
                    i7 = i9;
                }
                i6 |= i11;
            } else {
                i7 = i9;
            }
            if ((i & 100663296) == 0) {
                i6 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j3)) ? 67108864 : 33554432;
            }
            if ((i & 805306368) == 0) {
                i6 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
            }
            i8 = i6;
            if (composerStartRestartGroup.shouldExecute((306783379 & i8) == 306783378, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                j4 = j;
                composer2 = composerStartRestartGroup;
                bottomDrawerState3 = bottomDrawerState2;
                z3 = z2 ? 1 : 0;
                shape3 = shape2;
                f3 = f2;
                j5 = j2;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "580@23335L33,582@23447L5,584@23556L15,585@23605L38,586@23684L10");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier;
                    if ((i2 & 4) != 0) {
                        modifier = companion;
                        z4 = true;
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, null, composerStartRestartGroup, 6, 6);
                        i8 &= -897;
                    } else {
                        modifier = companion;
                        z4 = true;
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState2;
                    }
                    if (i4 != 0) {
                        z2 = z4 ? 1 : 0;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i8 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    float fM3021getElevationD9Ej5fM = i5 != 0 ? DrawerDefaults.INSTANCE.m3021getElevationD9Ej5fM() : f2;
                    if ((i2 & 64) != 0) {
                        backgroundColor = DrawerDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    } else {
                        backgroundColor = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(backgroundColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3001contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i8 &= -234881025;
                        shape5 = shape4;
                        f4 = fM3021getElevationD9Ej5fM;
                        j7 = backgroundColor;
                        j8 = jM3001contentColorForek8zF_U;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        bottomDrawerState4 = bottomDrawerStateRememberBottomDrawerState;
                        z5 = z2;
                        r0 = z4;
                    } else {
                        scrimColor = j3;
                        bottomDrawerState4 = bottomDrawerStateRememberBottomDrawerState;
                        shape5 = shape4;
                        f4 = fM3021getElevationD9Ej5fM;
                        z5 = z2;
                        j7 = backgroundColor;
                        j8 = jM3001contentColorForek8zF_U;
                        r0 = z4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i8 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i8 &= -57345;
                    }
                    if ((i2 & 64) != 0) {
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i8 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i8 &= -234881025;
                    }
                    j7 = j;
                    j8 = j2;
                    scrimColor = j3;
                    r0 = 1;
                    bottomDrawerState4 = bottomDrawerState2;
                    z5 = z2 ? 1 : 0;
                    shape5 = shape2;
                    f4 = f2;
                }
                Modifier modifier3 = modifier;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1403479060, i8, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:588)");
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
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, r0, null), null, false, ComposableLambdaKt.rememberComposableLambda(468886998, r0, new Function3() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0(z5, bottomDrawerState4, function2, scrimColor, coroutineScope, shape5, j7, j8, f4, function3, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                composer2 = composerStartRestartGroup;
                z3 = z5;
                bottomDrawerState3 = bottomDrawerState4;
                j6 = scrimColor;
                shape3 = shape5;
                j4 = j7;
                j5 = j8;
                f3 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$1(function3, modifier2, bottomDrawerState3, z3, shape3, f3, j4, j5, j6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i6;
        if (composerStartRestartGroup.shouldExecute((306783379 & i8) == 306783378, i8 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    private static final void m3027BottomDrawerScrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomDrawerScrim)N(color:c#ui.graphics.Color,onDismiss,visible):Drawer.kt#jmzs0o");
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
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:725)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(1001814516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "728@29733L87,729@29847L30,744@30414L62,744@30361L115");
                int i3 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                final String strM3171getString4foXLRw = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3163getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(1002034864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "732@29984L37,733@30078L213");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 863608995, "CC(remember):Drawer.kt#9igjgp");
                    int i4 = i3 & 112;
                    boolean z2 = i4 == 32;
                    DrawerKt$BottomDrawerScrim$dismissModifier$1$1 drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (PointerInputEventHandler) drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 863612179, "CC(remember):Drawer.kt#9igjgp");
                    boolean zChanged = (i4 == 32) | composerStartRestartGroup.changed(strM3171getString4foXLRw);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$2$0(strM3171getString4foXLRw, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1002399548);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 863622780, "CC(remember):Drawer.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i3 & 14) == 4);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$3$0(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(972328804);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$4(j, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float BottomDrawerScrim_3J_VO9M$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawerScrim_3J_VO9M$lambda$2$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$2$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomDrawerScrim_3J_VO9M$lambda$2$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawerScrim_3J_VO9M$lambda$3$0(long j, State state, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, BottomDrawerScrim_3J_VO9M$lambda$0(state), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit BottomDrawerScrim_3J_VO9M$lambda$4(long j, Function0 function0, boolean z, int i, Composer composer, int i2) {
        m3027BottomDrawerScrim3JVO9M(j, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit BottomDrawer_Gs3lGvM$lambda$0(final boolean z, final BottomDrawerState bottomDrawerState, Function2 function2, long j, final CoroutineScope coroutineScope, Shape shape, long j2, long j3, float f, final Function3 function3, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        ComposerKt.sourceInformation(composer, "C594@24017L7,606@24452L7,617@24824L3657:Drawer.kt#jmzs0o");
        if ((i & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(468886998, i2, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:591)");
            }
            final float fM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk());
            final boolean z2 = Constraints.m9067getMaxWidthimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk()) > Constraints.m9066getMaxHeightimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk());
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            Modifier modifierM2087sizeInqDBjuR0$default = SizeKt.m2087sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density.mo1621toDpu2uoSUM(Constraints.m9067getMaxWidthimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk())), density.mo1621toDpu2uoSUM(Constraints.m9066getMaxHeightimpl(boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk())), 3, null);
            Modifier.Companion companionNestedScroll$default = z ? NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState.getNestedScrollConnection(), null, 2, null) : Modifier.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companionNestedScroll$default), bottomDrawerState.getAnchoredDraggableState$material(), Orientation.Vertical, z, objConsume2 == LayoutDirection.Rtl, null, false, 48, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAnchoredDraggable$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -195134127, "C618@24853L9,621@24958L187,619@24875L346,628@25255L33,631@25379L2130,668@27538L66,669@27636L576,686@28408L63,629@25301L3170:Drawer.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -699031381, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged = composer.changed(z) | composer.changedInstance(bottomDrawerState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$0$0(z, bottomDrawerState, coroutineScope);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3027BottomDrawerScrim3JVO9M(j, function0, bottomDrawerState.getTargetValue() != BottomDrawerValue.Closed, composer, 0);
            final String strM3171getString4foXLRw = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3167getNavigationMenuUdPEhr4(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -699015966, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged2 = composer.changed(fM9066getMaxHeightimpl) | composer.changed(z2) | composer.changedInstance(bottomDrawerState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$1$0(bottomDrawerState, fM9066getMaxHeightimpl, z2, (IntSize) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM2087sizeInqDBjuR0$default, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer, -698948942, "CC(remember):Drawer.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(bottomDrawerState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$2$0(bottomDrawerState, (Density) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOffset = OffsetKt.offset(modifierOnSizeChanged, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -698945296, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged3 = composer.changed(strM3171getString4foXLRw) | composer.changedInstance(bottomDrawerState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$3$0(strM3171getString4foXLRw, bottomDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.m3172SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierOffset, false, (Function1) objRememberedValue4, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.rememberComposableLambda(1691510868, true, new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$4(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 16);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawer_Gs3lGvM$lambda$0$1$0$0(boolean z, BottomDrawerState bottomDrawerState, CoroutineScope coroutineScope) {
        if (z && bottomDrawerState.confirmStateChange$material(BottomDrawerValue.Closed)) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DrawerKt$BottomDrawer$1$1$1$1$1(bottomDrawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawer_Gs3lGvM$lambda$0$1$1$0(BottomDrawerState bottomDrawerState, final float f, final boolean z, IntSize intSize) {
        BottomDrawerValue currentValue;
        final float fM9289unboximpl = (int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$1$0$0(f, fM9289unboximpl, z, (DraggableAnchorsConfig) obj);
            }
        });
        if (bottomDrawerState.getAnchoredDraggableState$material().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(bottomDrawerState.getCurrentValue())) {
            currentValue = bottomDrawerState.getCurrentValue();
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[bottomDrawerState.getTargetValue().ordinal()];
            if (i == 1) {
                currentValue = BottomDrawerValue.Closed;
            } else {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                currentValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open) ? BottomDrawerValue.Open : DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
            }
        }
        bottomDrawerState.getAnchoredDraggableState$material().updateAnchors(DraggableAnchors, currentValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawer_Gs3lGvM$lambda$0$1$1$0$0(float f, float f2, boolean z, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(BottomDrawerValue.Closed, f);
        float f3 = 0.5f * f;
        if (f2 > f3 || z) {
            draggableAnchorsConfig.at(BottomDrawerValue.Open, f3);
        }
        if (f2 > 0.0f) {
            draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f - f2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset BottomDrawer_Gs3lGvM$lambda$0$1$2$0(BottomDrawerState bottomDrawerState, Density density) {
        return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl(((long) MathKt.roundToInt(bottomDrawerState.requireOffset$material())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawer_Gs3lGvM$lambda$0$1$3$0(String str, final BottomDrawerState bottomDrawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (bottomDrawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DrawerKt.BottomDrawer_Gs3lGvM$lambda$0$1$3$0$0(bottomDrawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomDrawer_Gs3lGvM$lambda$0$1$3$0$0(BottomDrawerState bottomDrawerState, CoroutineScope coroutineScope) {
        if (!bottomDrawerState.confirmStateChange$material(BottomDrawerValue.Closed)) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DrawerKt$BottomDrawer$1$1$4$1$1$1(bottomDrawerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomDrawer_Gs3lGvM$lambda$0$1$4(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C687@28426L31:Drawer.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691510868, i, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:687)");
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

    static final Unit BottomDrawer_Gs3lGvM$lambda$1(Function3 function3, Modifier modifier, BottomDrawerState bottomDrawerState, boolean z, Shape shape, float f, long j, long j2, long j3, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3026BottomDrawerGs3lGvM(function3, modifier, bottomDrawerState, z, shape, f, j, j2, j3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new AnonymousClass1(anchoredDraggableState);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010a  */
    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3028ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerState2;
        int i4;
        boolean z2;
        Shape shape2;
        int i5;
        float f2;
        int i6;
        final Modifier modifier3;
        final DrawerState drawerState3;
        final boolean z3;
        final Shape shape3;
        final float f3;
        final long j4;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        DrawerState drawerStateRememberDrawerState;
        Shape shape4;
        long backgroundColor;
        long jM3001contentColorForek8zF_U;
        final long scrimColor;
        final Shape shape5;
        final float f4;
        final long j7;
        final long j8;
        final DrawerState drawerState4;
        final boolean z4;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1979404999);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,drawerShape,drawerElevation:c#ui.unit.Dp,drawerBackgroundColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,scrimColor:c#ui.graphics.Color,content)462@17984L24,463@18056L3421,463@18013L3464:Drawer.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    int i9 = composerStartRestartGroup.changed(drawerState2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    drawerState2 = drawerState;
                }
                i3 |= i9;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        f2 = f;
                        i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            i7 = i3;
                            int i11 = composerStartRestartGroup.changed(j) ? 1048576 : 524288;
                            i6 = i7 | i11;
                        } else {
                            i7 = i3;
                        }
                        i6 = i7 | i11;
                    } else {
                        i6 = i3;
                    }
                    if ((i & 12582912) == 0) {
                        i6 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i) == 0) {
                        i6 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j3)) ? 67108864 : 33554432;
                    }
                    if ((805306368 & i) == 0) {
                        i6 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i6) == 306783378, i6 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        drawerState3 = drawerState2;
                        z3 = z2;
                        shape3 = shape2;
                        f3 = f2;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "453@17560L39,455@17678L5,457@17787L15,458@17836L38,459@17915L10");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i6 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                shape4 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i6 &= -57345;
                            } else {
                                shape4 = shape2;
                            }
                            float fM3021getElevationD9Ej5fM = i5 != 0 ? DrawerDefaults.INSTANCE.m3021getElevationD9Ej5fM() : f2;
                            if ((i2 & 64) != 0) {
                                backgroundColor = DrawerDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                                i6 &= -3670017;
                            } else {
                                backgroundColor = j;
                            }
                            if ((i2 & 128) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(backgroundColor, composerStartRestartGroup, (i6 >> 18) & 14);
                                i6 = (-29360129) & i6;
                            } else {
                                jM3001contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i6 &= -234881025;
                            } else {
                                scrimColor = j3;
                            }
                            shape5 = shape4;
                            f4 = fM3021getElevationD9Ej5fM;
                            j7 = backgroundColor;
                            j8 = jM3001contentColorForek8zF_U;
                            drawerState4 = drawerStateRememberDrawerState;
                            z4 = z2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i6 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i6 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            j7 = j;
                            j8 = j2;
                            scrimColor = j3;
                            companion = modifier2;
                            drawerState4 = drawerState2;
                            z4 = z2;
                            shape5 = shape2;
                            f4 = f2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1979404999, i6, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:461)");
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
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(-1549911011, true, new Function3() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0(drawerState4, z4, coroutineScope, scrimColor, shape5, j7, j8, f4, function2, function3, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        drawerState3 = drawerState4;
                        z3 = z4;
                        j6 = scrimColor;
                        shape3 = shape5;
                        j4 = j7;
                        j5 = j8;
                        f3 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DrawerKt.ModalDrawer_Gs3lGvM$lambda$1(function3, modifier3, drawerState3, z3, shape3, f3, j4, j5, j6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((100663296 & i) == 0) {
                }
                if ((805306368 & i) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i6) == 306783378, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            f2 = f;
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((805306368 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i6) == 306783378, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((805306368 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i6) == 306783378, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ModalDrawer_Gs3lGvM$lambda$0(final DrawerState drawerState, final boolean z, final CoroutineScope coroutineScope, long j, Shape shape, long j2, long j3, float f, Function2 function2, final Function3 function3, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        ComposerKt.sourceInformation(composer, "C472@18435L7,473@18462L274,473@18451L285,482@18779L7,483@18818L2653:Drawer.kt#jmzs0o");
        if ((i & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1549911011, i2, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:464)");
            }
            long jMo1931getConstraintsmsEJaDk = boxWithConstraintsScope2.mo1931getConstraintsmsEJaDk();
            if (!Constraints.m9063getHasBoundedWidthimpl(jMo1931getConstraintsmsEJaDk)) {
                throw new IllegalStateException("Drawer shouldn't have infinite width");
            }
            final float f2 = -Constraints.m9067getMaxWidthimpl(jMo1931getConstraintsmsEJaDk);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 889183407, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged = composer.changed(drawerState) | composer.changed(density) | composer.changed(f2);
            Object objRememberedValue = composer.rememberedValue();
            final float f3 = 0.0f;
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$0$0(drawerState, density, f2, f3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) objRememberedValue, composer, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, drawerState.getAnchoredDraggableState$material(), Orientation.Horizontal, z, objConsume2 == LayoutDirection.Rtl, null, false, 48, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAnchoredDraggable$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -215522521, "C491@19100L17,494@19206L358,504@19593L70,492@19130L584,507@19748L33,510@19868L7,518@20348L58,520@20499L679,539@21374L87,508@19794L1667:Drawer.kt#jmzs0o");
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1269670255, "C491@19106L9:Drawer.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean zIsOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart(composer, -561140279, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged2 = composer.changed(z) | composer.changed(drawerState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$1$0(z, drawerState, coroutineScope);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -561128183, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged3 = composer.changed(f2) | composer.changed(drawerState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                final float f4 = 0.0f;
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$2$0(f2, f4, drawerState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3029ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue3, j, composer, 0);
            final String strM3171getString4foXLRw = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3167getNavigationMenuUdPEhr4(), composer, 6);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composer.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density2 = (Density) objConsume3;
            Modifier modifierM2086sizeInqDBjuR0 = SizeKt.m2086sizeInqDBjuR0(Modifier.INSTANCE, density2.mo1621toDpu2uoSUM(Constraints.m9069getMinWidthimpl(jMo1931getConstraintsmsEJaDk)), density2.mo1621toDpu2uoSUM(Constraints.m9068getMinHeightimpl(jMo1931getConstraintsmsEJaDk)), density2.mo1621toDpu2uoSUM(Constraints.m9067getMaxWidthimpl(jMo1931getConstraintsmsEJaDk)), density2.mo1621toDpu2uoSUM(Constraints.m9066getMaxHeightimpl(jMo1931getConstraintsmsEJaDk)));
            ComposerKt.sourceInformationMarkerStart(composer, -561104035, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged4 = composer.changed(drawerState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$4$0(drawerState, (Density) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(OffsetKt.offset(modifierM2086sizeInqDBjuR0, (Function1) objRememberedValue4), 0.0f, 0.0f, EndDrawerPadding, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer, -561098582, "CC(remember):Drawer.kt#9igjgp");
            boolean zChanged5 = composer.changed(strM3171getString4foXLRw) | composer.changed(drawerState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$5$0(strM3171getString4foXLRw, drawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.m3172SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierM2041paddingqDBjuR0$default, false, (Function1) objRememberedValue5, 1, null), shape, j2, j3, null, f, ComposableLambdaKt.rememberComposableLambda(1265707871, true, new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$6(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 16);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawer_Gs3lGvM$lambda$0$0$0(DrawerState drawerState, Density density, final float f, final float f2) {
        drawerState.setDensity$material(density);
        AnchoredDraggableState.updateAnchors$default(drawerState.getAnchoredDraggableState$material(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$0$0$0(f, f2, (DraggableAnchorsConfig) obj);
            }
        }), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawer_Gs3lGvM$lambda$0$0$0$0(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(DrawerValue.Closed, f);
        draggableAnchorsConfig.at(DrawerValue.Open, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawer_Gs3lGvM$lambda$0$1$1$0(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        if (z && drawerState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DrawerKt$ModalDrawer$1$2$2$1$1(drawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalDrawer_Gs3lGvM$lambda$0$1$2$0(float f, float f2, DrawerState drawerState) {
        return calculateFraction(f, f2, drawerState.requireOffset$material());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ModalDrawer_Gs3lGvM$lambda$0$1$4$0(DrawerState drawerState, Density density) {
        return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl(((long) MathKt.roundToInt(drawerState.requireOffset$material())) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawer_Gs3lGvM$lambda$0$1$5$0(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DrawerKt.ModalDrawer_Gs3lGvM$lambda$0$1$5$0$0(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalDrawer_Gs3lGvM$lambda$0$1$5$0$0(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DrawerKt$ModalDrawer$1$2$6$1$1$1(drawerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawer_Gs3lGvM$lambda$0$1$6(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C540@21392L55:Drawer.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1265707871, i, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:540)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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

    static final Unit ModalDrawer_Gs3lGvM$lambda$1(Function3 function3, Modifier modifier, DrawerState drawerState, boolean z, Shape shape, float f, long j, long j2, long j3, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3028ModalDrawerGs3lGvM(function3, modifier, drawerState, z, shape, f, j, j2, j3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m3029ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)752@30613L30,767@31111L39,767@31060L90:Drawer.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:751)");
            }
            final String strM3171getString4foXLRw = Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3163getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1716213970);
                ComposerKt.sourceInformation(composerStartRestartGroup, "755@30731L35,756@30819L187");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -914468439, "CC(remember):Drawer.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z2 = i3 == 32;
                DrawerKt$Scrim$dismissDrawer$1$1 drawerKt$Scrim$dismissDrawer$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || drawerKt$Scrim$dismissDrawer$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    drawerKt$Scrim$dismissDrawer$1$1RememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0);
                    composerStartRestartGroup.updateRememberedValue(drawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (PointerInputEventHandler) drawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -914465471, "CC(remember):Drawer.kt#9igjgp");
                boolean zChanged = (i3 == 32) | composerStartRestartGroup.changed(strM3171getString4foXLRw);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DrawerKt.Scrim_Bx497Mc$lambda$1$0(strM3171getString4foXLRw, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1716538044);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -914456275, "CC(remember):Drawer.kt#9igjgp");
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DrawerKt.Scrim_Bx497Mc$lambda$2$0(j, function02, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerKt.Scrim_Bx497Mc$lambda$3(z, function0, function02, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$1$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DrawerKt.Scrim_Bx497Mc$lambda$1$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_Bx497Mc$lambda$1$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$2$0(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function0.invoke()).floatValue(), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_Bx497Mc$lambda$3(boolean z, Function0 function0, Function0 function02, long j, int i, Composer composer, int i2) {
        m3029ScrimBx497Mc(z, function0, function02, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final float calculateFraction(float f, float f2, float f3) {
        float f4 = (f3 - f) / (f2 - f);
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f4 > 1.0f) {
            return 1.0f;
        }
        return f4;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue bottomDrawerValue, final Function1<? super BottomDrawerValue, Boolean> function1, final AnimationSpec<Float> animationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1477366969, "C(rememberBottomDrawerState)N(initialValue,confirmStateChange,animationSpec)407@15417L8,410@15553L7,414@15698L91,411@15572L217:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1884513759, "CC(remember):Drawer.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DrawerKt.rememberBottomDrawerState$lambda$0$0((BottomDrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if ((i2 & 4) != 0) {
            animationSpec = DrawerDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1477366969, i, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:409)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.INSTANCE.Saver(density, function1, animationSpec);
        ComposerKt.sourceInformationMarkerStart(composer, -1884504684, "CC(remember):Drawer.kt#9igjgp");
        boolean z = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(bottomDrawerValue.ordinal())) || (i & 6) == 4) | composer.changed(density);
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean zChangedInstance = zChanged | z | composer.changedInstance(animationSpec);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DrawerKt.rememberBottomDrawerState$lambda$1$0(bottomDrawerValue, density, function1, animationSpec);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bottomDrawerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberBottomDrawerState$lambda$0$0(BottomDrawerValue bottomDrawerValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomDrawerState rememberBottomDrawerState$lambda$1$0(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, AnimationSpec animationSpec) {
        return new BottomDrawerState(bottomDrawerValue, density, function1, animationSpec);
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1435874229, "C(rememberDrawerState)N(initialValue,confirmStateChange)389@14774L8,391@14876L61,391@14812L125:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1190628621, "CC(remember):Drawer.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DrawerKt.rememberDrawerState$lambda$0$0((DrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:390)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1190625304, "CC(remember):Drawer.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed(drawerValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material.DrawerKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DrawerKt.rememberDrawerState$lambda$1$0(drawerValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberDrawerState$lambda$0$0(DrawerValue drawerValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawerState rememberDrawerState$lambda$1$0(DrawerValue drawerValue, Function1 function1) {
        return new DrawerState(drawerValue, function1);
    }
}
