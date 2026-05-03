package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001aE\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0010\u001aï\u0001\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\n¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020#H\u0007¢\u0006\u0004\b+\u0010,\u001a-\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u00100\u001a\u00020\u000bH\u0003¢\u0006\u0004\b1\u00102\u001a;\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00032\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0002\u00106\u001a[\u00107\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u00152\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:0\n2\u001d\u0010;\u001a\u0019\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120<¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0002\u0010=\u001a\u001c\u0010B\u001a\u00020C2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030E2\u0006\u0010F\u001a\u00020GH\u0000\"\u0010\u0010>\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010@\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010A\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?¨\u0006H²\u0006\n\u0010I\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"BackdropScaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "initialValue", "Landroidx/compose/material/BackdropValue;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "rememberBackdropScaffoldState", "confirmStateChange", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "BackdropScaffold", "", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "snackbarHost", "gesturesEnabled", "peekHeight", "Landroidx/compose/ui/unit/Dp;", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "BackdropScaffold-0hNv9B8", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;Lkotlin/jvm/functions/Function3;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLandroidx/compose/runtime/Composer;III)V", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BackLayerTransition", TypedValues.AttributesType.S_TARGET, FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropStack", "backLayer", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "AnimationSlideOffset", "F", "VelocityThreshold", "PositionalThreshold", "ConsumeSwipeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "material", "alpha", "animationProgress"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m9114constructorimpl(20.0f);
    private static final float VelocityThreshold = Dp.m9114constructorimpl(125.0f);
    private static final float PositionalThreshold = Dp.m9114constructorimpl(56.0f);

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) {
                backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 = (BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) continuation;
                if ((backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1 = new BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            }
            Object obj = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPostFling$1.J$0;
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
            BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) {
                backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 = (BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) continuation;
                if ((backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 = new BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            }
            Object obj = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= this.$state.getAnchors().minAnchor()) {
                    j = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                } else {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = backdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1.J$0;
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

    /* JADX INFO: compiled from: BackdropScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackdropValue.values().length];
            try {
                iArr[BackdropValue.Concealed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackdropValue.Revealed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void BackLayerTransition(final BackdropValue backdropValue, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2129748230);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackLayerTransition)N(target,appBar,content)523@23139L133,527@23322L7,529@23368L1451:BackdropScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(backdropValue.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        int i3 = i2;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2129748230, i3, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:519)");
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(AnimationSlideOffset);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -287273344, "C531@23415L351,538@23798L218,530@23382L677,548@24163L353,555@24548L221,546@24068L745:BackdropScaffold.kt#jmzs0o");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1237659083, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BackdropScaffoldKt.BackLayerTransition$lambda$2$0$0(stateAnimateFloatAsState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1237671206, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState) | composerStartRestartGroup.changed(fMo1624toPx0680j_4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdropScaffoldKt.BackLayerTransition$lambda$2$1$0(fMo1624toPx0680j_4, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierLayout, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327736681, "C544@24041L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1237683021, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function3() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BackdropScaffoldKt.BackLayerTransition$lambda$2$3$0(stateAnimateFloatAsState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout2 = LayoutModifierKt.layout(companion3, (Function3) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1237695209, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState) | composerStartRestartGroup.changed(fMo1624toPx0680j_4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdropScaffoldKt.BackLayerTransition$lambda$2$4$0(fMo1624toPx0680j_4, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierLayout2, (Function1) objRememberedValue4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -786845391, "C561@24794L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldKt.BackLayerTransition$lambda$3(backdropValue, function2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float BackLayerTransition$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BackLayerTransition$lambda$2$0$0(State state, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fBackLayerTransition$lambda$0 = BackLayerTransition$lambda$0(state) - 1.0f;
        if (fBackLayerTransition$lambda$0 < 0.0f) {
            fBackLayerTransition$lambda$0 = 0.0f;
        }
        final float f = fBackLayerTransition$lambda$0 <= 1.0f ? fBackLayerTransition$lambda$0 : 1.0f;
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdropScaffoldKt.BackLayerTransition$lambda$2$0$0$0(placeableMo7769measureBRTryo0, f, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackLayerTransition$lambda$2$0$0$0(Placeable placeable, float f, Placeable.PlacementScope placementScope) {
        placementScope.place(placeable, 0, 0, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackLayerTransition$lambda$2$1$0(float f, State state, GraphicsLayerScope graphicsLayerScope) {
        float fBackLayerTransition$lambda$0 = BackLayerTransition$lambda$0(state) - 1.0f;
        if (fBackLayerTransition$lambda$0 < 0.0f) {
            fBackLayerTransition$lambda$0 = 0.0f;
        }
        if (fBackLayerTransition$lambda$0 > 1.0f) {
            fBackLayerTransition$lambda$0 = 1.0f;
        }
        graphicsLayerScope.setAlpha(fBackLayerTransition$lambda$0);
        graphicsLayerScope.setTranslationY((1.0f - fBackLayerTransition$lambda$0) * f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BackLayerTransition$lambda$2$3$0(State state, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fBackLayerTransition$lambda$0 = 1.0f - BackLayerTransition$lambda$0(state);
        if (fBackLayerTransition$lambda$0 < 0.0f) {
            fBackLayerTransition$lambda$0 = 0.0f;
        }
        final float f = fBackLayerTransition$lambda$0 <= 1.0f ? fBackLayerTransition$lambda$0 : 1.0f;
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdropScaffoldKt.BackLayerTransition$lambda$2$3$0$0(placeableMo7769measureBRTryo0, f, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackLayerTransition$lambda$2$3$0$0(Placeable placeable, float f, Placeable.PlacementScope placementScope) {
        placementScope.place(placeable, 0, 0, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackLayerTransition$lambda$2$4$0(float f, State state, GraphicsLayerScope graphicsLayerScope) {
        float fBackLayerTransition$lambda$0 = 1.0f - BackLayerTransition$lambda$0(state);
        if (fBackLayerTransition$lambda$0 < 0.0f) {
            fBackLayerTransition$lambda$0 = 0.0f;
        }
        if (fBackLayerTransition$lambda$0 > 1.0f) {
            fBackLayerTransition$lambda$0 = 1.0f;
        }
        graphicsLayerScope.setAlpha(fBackLayerTransition$lambda$0);
        graphicsLayerScope.setTranslationY((1.0f - fBackLayerTransition$lambda$0) * f);
        return Unit.INSTANCE;
    }

    static final Unit BackLayerTransition$lambda$3(BackdropValue backdropValue, Function2 function2, Function2 function22, int i, Composer composer, int i2) {
        BackLayerTransition(backdropValue, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /* JADX INFO: renamed from: BackdropScaffold-0hNv9B8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2924BackdropScaffold0hNv9B8(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Modifier modifier, BackdropScaffoldState backdropScaffoldState, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, boolean z, float f, float f2, boolean z2, boolean z3, long j, long j2, Shape shape, float f3, long j3, long j4, long j5, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        float f4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Shape shape2;
        float f5;
        final BackdropScaffoldState backdropScaffoldState2;
        final boolean z4;
        final float f6;
        final float f7;
        final boolean z5;
        long j6;
        final Shape shape3;
        final float f8;
        final long j7;
        final long j8;
        final long j9;
        Composer composer2;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33;
        final Modifier modifier3;
        final boolean z6;
        final long j10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        boolean z7;
        final BackdropScaffoldState backdropScaffoldStateRememberBackdropScaffoldState;
        float fM2916getPeekHeightD9Ej5fM;
        float fM2915getHeaderHeightD9Ej5fM;
        long jM2983getPrimary0d7_KjU;
        int i13;
        long jM3001contentColorForek8zF_U;
        long j11;
        Shape frontLayerShape;
        float fM2914getFrontLayerElevationD9Ej5fM;
        float f9;
        Shape shape4;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U2;
        long j12;
        final Shape shape5;
        final long frontLayerScrimColor;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final boolean z8;
        final boolean z9;
        long j13;
        long j14;
        final float f10;
        final long j15;
        final long j16;
        final boolean z10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1364899063);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackdropScaffold)N(appBar,backLayerContent,frontLayerContent,modifier,scaffoldState,snackbarHost,gesturesEnabled,peekHeight:c#ui.unit.Dp,headerHeight:c#ui.unit.Dp,persistentAppBar,stickyFrontLayer,backLayerBackgroundColor:c#ui.graphics.Color,backLayerContentColor:c#ui.graphics.Color,frontLayerShape,frontLayerElevation:c#ui.unit.Dp,frontLayerBackgroundColor:c#ui.graphics.Color,frontLayerContentColor:c#ui.graphics.Color,frontLayerScrimColor:c#ui.graphics.Color)365@16886L7,366@16909L35,366@16898L46,368@16987L7,369@17061L7,372@17135L384,386@17590L100,393@17848L4098,393@17768L4178:BackdropScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        int i14 = i3 & 8;
        int i15 = 1024;
        if (i14 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            int i16 = 8192;
            if ((i & 24576) == 0) {
                i4 |= ((i3 & 16) == 0 && composerStartRestartGroup.changed(backdropScaffoldState)) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function32 = function3;
            } else {
                function32 = function3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
            }
            if ((i & 12582912) == 0) {
                i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(f)) ? 8388608 : 4194304;
            }
            if ((i & 100663296) != 0) {
                if ((i3 & 256) == 0) {
                    f4 = f2;
                    int i17 = composerStartRestartGroup.changed(f4) ? 67108864 : 33554432;
                    i4 |= i17;
                } else {
                    f4 = f2;
                }
                i4 |= i17;
            } else {
                f4 = f2;
            }
            i7 = i3 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    i8 = i7;
                    i4 |= composerStartRestartGroup.changed(z2) ? 536870912 : 268435456;
                }
                i9 = i3 & 1024;
                if (i9 != 0) {
                    i11 = i2 | 6;
                    i10 = i9;
                } else if ((i2 & 6) == 0) {
                    i10 = i9;
                    i11 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                } else {
                    i10 = i9;
                    i11 = i2;
                }
                if ((i2 & 48) == 0) {
                    i11 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(j)) ? 32 : 16;
                }
                if ((i2 & 384) == 0) {
                    i11 |= ((i3 & 4096) == 0 && composerStartRestartGroup.changed(j2)) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8192) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                            i15 = 2048;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 |= i15;
                } else {
                    shape2 = shape;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16384) == 0) {
                        f5 = f3;
                        if (composerStartRestartGroup.changed(f5)) {
                            i16 = 16384;
                        }
                    } else {
                        f5 = f3;
                    }
                    i11 |= i16;
                } else {
                    f5 = f3;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i11 |= ((i3 & 32768) == 0 && composerStartRestartGroup.changed(j3)) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    i11 |= ((i3 & 65536) == 0 && composerStartRestartGroup.changed(j4)) ? 1048576 : 524288;
                }
                if ((i2 & 12582912) == 0) {
                    i11 |= ((i3 & 131072) == 0 && composerStartRestartGroup.changed(j5)) ? 8388608 : 4194304;
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 4793491) == 4793490) ? false : true, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "349@15888L40,356@16297L6,357@16348L41,358@16445L15,360@16591L6,361@16643L42,362@16746L20");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 16) != 0) {
                            i12 = -29360129;
                            z7 = true;
                            backdropScaffoldStateRememberBackdropScaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, composerStartRestartGroup, 6, 14);
                            i4 &= -57345;
                        } else {
                            i12 = -29360129;
                            z7 = true;
                            backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
                        }
                        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$2057676608$material = i5 != 0 ? ComposableSingletons$BackdropScaffoldKt.INSTANCE.getLambda$2057676608$material() : function32;
                        boolean z11 = i6 != 0 ? z7 : z;
                        if ((i3 & 128) != 0) {
                            fM2916getPeekHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m2916getPeekHeightD9Ej5fM();
                            i4 &= i12;
                        } else {
                            fM2916getPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 256) != 0) {
                            fM2915getHeaderHeightD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m2915getHeaderHeightD9Ej5fM();
                            i4 &= -234881025;
                        } else {
                            fM2915getHeaderHeightD9Ej5fM = f2;
                        }
                        boolean z12 = i8 != 0 ? z7 : z2;
                        boolean z13 = i10 != 0 ? z7 : z3;
                        if ((i3 & 2048) != 0) {
                            i11 &= -113;
                            jM2983getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2983getPrimary0d7_KjU();
                        } else {
                            jM2983getPrimary0d7_KjU = j;
                        }
                        i13 = i11;
                        int i18 = i4;
                        if ((i3 & 4096) != 0) {
                            jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2983getPrimary0d7_KjU, composerStartRestartGroup, (i13 >> 3) & 14);
                            i13 &= -897;
                        } else {
                            jM3001contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 8192) != 0) {
                            j11 = jM2983getPrimary0d7_KjU;
                            frontLayerShape = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(composerStartRestartGroup, 0);
                            i13 &= -7169;
                        } else {
                            j11 = jM2983getPrimary0d7_KjU;
                            frontLayerShape = shape;
                        }
                        if ((i3 & 16384) != 0) {
                            fM2914getFrontLayerElevationD9Ej5fM = BackdropScaffoldDefaults.INSTANCE.m2914getFrontLayerElevationD9Ej5fM();
                            i13 &= -57345;
                        } else {
                            fM2914getFrontLayerElevationD9Ej5fM = f3;
                        }
                        if ((i3 & 32768) != 0) {
                            f9 = fM2914getFrontLayerElevationD9Ej5fM;
                            i13 &= -458753;
                            shape4 = frontLayerShape;
                            jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                        } else {
                            f9 = fM2914getFrontLayerElevationD9Ej5fM;
                            shape4 = frontLayerShape;
                            jM2987getSurface0d7_KjU = j3;
                        }
                        if ((i3 & 65536) != 0) {
                            jM3001contentColorForek8zF_U2 = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i13 >> 15) & 14);
                            i13 &= -3670017;
                        } else {
                            jM3001contentColorForek8zF_U2 = j4;
                        }
                        if ((i3 & 131072) != 0) {
                            j12 = jM2987getSurface0d7_KjU;
                            shape5 = shape4;
                            i4 = i18;
                            i13 &= i12;
                            function34 = lambda$2057676608$material;
                            z8 = z11;
                            z9 = z12;
                            j13 = jM3001contentColorForek8zF_U;
                            j14 = j11;
                            frontLayerScrimColor = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(composerStartRestartGroup, 0);
                        } else {
                            j12 = jM2987getSurface0d7_KjU;
                            shape5 = shape4;
                            i4 = i18;
                            frontLayerScrimColor = j5;
                            function34 = lambda$2057676608$material;
                            z8 = z11;
                            z9 = z12;
                            j13 = jM3001contentColorForek8zF_U;
                            j14 = j11;
                        }
                        f10 = f9;
                        j15 = jM3001contentColorForek8zF_U2;
                        j16 = j12;
                        z10 = z13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i4 &= -234881025;
                        }
                        if ((i3 & 2048) != 0) {
                            i11 &= -113;
                        }
                        int i19 = i11;
                        if ((i3 & 4096) != 0) {
                            i19 &= -897;
                        }
                        if ((i3 & 8192) != 0) {
                            i19 &= -7169;
                        }
                        if ((i3 & 16384) != 0) {
                            i19 &= -57345;
                        }
                        if ((i3 & 32768) != 0) {
                            i19 &= -458753;
                        }
                        if ((i3 & 65536) != 0) {
                            i19 &= -3670017;
                        }
                        if ((i3 & 131072) != 0) {
                            i19 &= -29360129;
                        }
                        backdropScaffoldStateRememberBackdropScaffoldState = backdropScaffoldState;
                        z8 = z;
                        z10 = z3;
                        j13 = j2;
                        j16 = j3;
                        j15 = j4;
                        frontLayerScrimColor = j5;
                        i13 = i19;
                        shape5 = shape2;
                        f10 = f5;
                        function34 = function32;
                        z9 = z2;
                        j14 = j;
                        fM2915getHeaderHeightD9Ej5fM = f4;
                        fM2916getPeekHeightD9Ej5fM = f;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1364899063, i4, i13, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:363)");
                    }
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Density density = (Density) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1702934228, "CC(remember):BackdropScaffold.kt#9igjgp");
                    boolean zChanged = ((((57344 & i4) ^ 24576) > 16384 && composerStartRestartGroup.changed(backdropScaffoldStateRememberBackdropScaffoldState)) || (i4 & 24576) == 16384) | composerStartRestartGroup.changed(density);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$0$0(backdropScaffoldStateRememberBackdropScaffoldState, density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fMo1624toPx0680j_4 = ((Density) objConsume2).mo1624toPx0680j_4(fM2916getPeekHeightD9Ej5fM);
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fMo1624toPx0680j_42 = ((Density) objConsume3).mo1624toPx0680j_4(fM2915getHeaderHeightD9Ej5fM);
                    boolean z14 = z9;
                    final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(998762775, true, new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$3(z9, backdropScaffoldStateRememberBackdropScaffoldState, function2, function22, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1702912371, "CC(remember):BackdropScaffold.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(fMo1624toPx0680j_42);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$4$0(fMo1624toPx0680j_42, (Constraints) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final Function1 function1 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final AnchoredDraggableState<BackdropValue> anchoredDraggableState$material = backdropScaffoldStateRememberBackdropScaffoldState.getAnchoredDraggableState$material();
                    final BackdropScaffoldState backdropScaffoldState3 = backdropScaffoldStateRememberBackdropScaffoldState;
                    final float f11 = fM2916getPeekHeightD9Ej5fM;
                    final float f12 = fM2915getHeaderHeightD9Ej5fM;
                    modifier3 = modifier2;
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1243386547, true, new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5(modifier3, composableLambdaRememberComposableLambda, function1, fMo1624toPx0680j_42, z10, z8, backdropScaffoldState3, anchoredDraggableState$material, shape5, j16, j15, f10, f12, fMo1624toPx0680j_4, f11, function23, frontLayerScrimColor, function34, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i20 = i13 << 3;
                    long j17 = j14;
                    long j18 = j13;
                    SurfaceKt.m3172SurfaceFjzlyU(null, null, j17, j18, null, 0.0f, composableLambdaRememberComposableLambda2, composerStartRestartGroup, (i20 & 7168) | (i20 & 896) | 1572864, 51);
                    j6 = j17;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j10 = j18;
                    composer2 = composerStartRestartGroup;
                    z5 = z10;
                    z4 = z8;
                    backdropScaffoldState2 = backdropScaffoldState3;
                    shape3 = shape5;
                    j7 = j16;
                    j8 = j15;
                    f8 = f10;
                    f7 = f12;
                    f6 = f11;
                    j9 = frontLayerScrimColor;
                    function33 = function34;
                    z6 = z14;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    backdropScaffoldState2 = backdropScaffoldState;
                    z4 = z;
                    f6 = f;
                    f7 = f2;
                    z5 = z3;
                    j6 = j;
                    shape3 = shape;
                    f8 = f3;
                    j7 = j3;
                    j8 = j4;
                    j9 = j5;
                    composer2 = composerStartRestartGroup;
                    function33 = function32;
                    modifier3 = modifier2;
                    z6 = z2;
                    j10 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final long j19 = j6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$6(function2, function22, function23, modifier4, backdropScaffoldState2, function33, z4, f6, f7, z6, z5, j19, j10, shape3, f8, j7, j8, j9, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 805306368;
            i8 = i7;
            i9 = i3 & 1024;
            if (i9 != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            if ((i2 & 384) == 0) {
            }
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 4793491) == 4793490) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        int i162 = 8192;
        if ((i & 24576) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) != 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3 & 1024;
        if (i9 != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 4793491) == 4793490) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static final BackdropScaffoldState BackdropScaffoldState(BackdropValue backdropValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        BackdropScaffoldState backdropScaffoldState = new BackdropScaffoldState(backdropValue, animationSpec, function1, snackbarHostState);
        backdropScaffoldState.setDensity$material(density);
        return backdropScaffoldState;
    }

    public static /* synthetic */ BackdropScaffoldState BackdropScaffoldState$default(BackdropValue backdropValue, Density density, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(BackdropScaffoldKt.BackdropScaffoldState$lambda$0((BackdropValue) obj2));
                }
            };
        }
        if ((i & 16) != 0) {
            snackbarHostState = new SnackbarHostState();
        }
        return BackdropScaffoldState(backdropValue, density, animationSpec, function1, snackbarHostState);
    }

    static final boolean BackdropScaffoldState$lambda$0(BackdropValue backdropValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropScaffold_0hNv9B8$lambda$0$0(BackdropScaffoldState backdropScaffoldState, Density density) {
        backdropScaffoldState.setDensity$material(density);
        return Unit.INSTANCE;
    }

    static final Unit BackdropScaffold_0hNv9B8$lambda$3(boolean z, BackdropScaffoldState backdropScaffoldState, Function2 function2, Function2 function22, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BackdropScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(998762775, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:373)");
            }
            if (z) {
                composer.startReplaceGroup(-1391557043);
                ComposerKt.sourceInformation(composer, "374@17189L94");
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
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -541208306, "C375@17218L8,376@17247L18:BackdropScaffold.kt#jmzs0o");
                function2.invoke(composer, 0);
                function22.invoke(composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1391423619);
                ComposerKt.sourceInformation(composer, "379@17321L174");
                BackLayerTransition(backdropScaffoldState.getAnchoredDraggableState$material().getTargetValue(), function2, function22, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Constraints BackdropScaffold_0hNv9B8$lambda$4$0(float f, Constraints constraints) {
        return Constraints.m9054boximpl(ConstraintsKt.m9087offsetNN6EwU$default(Constraints.m9057copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(f), 1, null));
    }

    static final Unit BackdropScaffold_0hNv9B8$lambda$5(Modifier modifier, Function2 function2, Function1 function1, final float f, final boolean z, final boolean z2, final BackdropScaffoldState backdropScaffoldState, final AnchoredDraggableState anchoredDraggableState, final Shape shape, final long j, final long j2, final float f2, final float f3, final float f4, final float f5, final Function2 function22, final long j3, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C394@17870L24,395@17983L3957,395@17903L4037:BackdropScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1243386547, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:394)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BackdropStack(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), function2, function1, ComposableLambdaKt.rememberComposableLambda(-323178911, true, new Function4() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0(f, z, z2, backdropScaffoldState, anchoredDraggableState, coroutineScope, shape, j, j2, f2, f3, f4, f5, function22, j3, function3, (Constraints) obj, ((Float) obj2).floatValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 3120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropScaffold_0hNv9B8$lambda$5$0(float f, boolean z, final boolean z2, final BackdropScaffoldState backdropScaffoldState, AnchoredDraggableState anchoredDraggableState, final CoroutineScope coroutineScope, Shape shape, long j, long j2, float f2, float f3, final float f4, final float f5, final Function2 function2, final long j3, Function3 function3, Constraints constraints, float f6, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(constraints:c#ui.unit.Constraints,backLayerHeight)437@19852L735,458@20799L576,411@18496L2879,474@21418L512:BackdropScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(constraints.getValue()) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composer.changed(f6) ? 32 : 16;
        }
        if (composer.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-323178911, i2, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:398)");
            }
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = Constraints.m9066getMaxHeightimpl(constraints.getValue()) - f;
            if (z) {
                floatRef.element = Math.min(floatRef.element, f6);
            }
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(z2 ? NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState.getNestedScrollConnection(), null, 2, null) : Modifier.INSTANCE, anchoredDraggableState, Orientation.Vertical, new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$0(f4, backdropScaffoldState, floatRef, (IntSize) obj, (Constraints) obj2);
                }
            }), anchoredDraggableState, Orientation.Vertical, z2, false, null, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1337227616, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged = composer.changed(backdropScaffoldState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$1$0(backdropScaffoldState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.m3172SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default, false, (Function1) objRememberedValue, 1, null), shape, j, j2, null, f2, ComposableLambdaKt.rememberComposableLambda(356452509, true, new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$2(f5, function2, j3, z2, backdropScaffoldState, coroutineScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 16);
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, (backdropScaffoldState.isRevealed() && floatRef.element == ((float) Constraints.m9066getMaxHeightimpl(constraints.getValue())) - f) ? f3 : Dp.m9114constructorimpl(0.0f), 7, null);
            Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2041paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -725880465, "C486@21871L45:BackdropScaffold.kt#jmzs0o");
            function3.invoke(backdropScaffoldState.getSnackbarHostState(), composer, 0);
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
    public static final Pair BackdropScaffold_0hNv9B8$lambda$5$0$0(final float f, BackdropScaffoldState backdropScaffoldState, final Ref.FloatRef floatRef, IntSize intSize, Constraints constraints) {
        BackdropValue backdropValue;
        final float fM9289unboximpl = (int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        final float fM9289unboximpl2 = ((int) (intSize.m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - f;
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$0$0(fM9289unboximpl, f, fM9289unboximpl2, floatRef, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[backdropScaffoldState.getTargetValue().ordinal()];
        if (i == 1) {
            backdropValue = BackdropValue.Concealed;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            backdropValue = DraggableAnchors.hasAnchorFor(BackdropValue.Revealed) ? BackdropValue.Revealed : BackdropValue.Concealed;
        }
        return TuplesKt.to(DraggableAnchors, backdropValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropScaffold_0hNv9B8$lambda$5$0$0$0(float f, float f2, float f3, Ref.FloatRef floatRef, DraggableAnchorsConfig draggableAnchorsConfig) {
        if (f == 0.0f || f == f2) {
            draggableAnchorsConfig.at(BackdropValue.Concealed, f3);
        } else {
            draggableAnchorsConfig.at(BackdropValue.Concealed, f2);
            draggableAnchorsConfig.at(BackdropValue.Revealed, floatRef.element);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropScaffold_0hNv9B8$lambda$5$0$1$0(final BackdropScaffoldState backdropScaffoldState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (backdropScaffoldState.isConcealed()) {
            SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$1$0$0(backdropScaffoldState, coroutineScope));
                }
            }, 1, null);
        } else {
            SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$1$0$1(backdropScaffoldState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BackdropScaffold_0hNv9B8$lambda$5$0$1$0$0(BackdropScaffoldState backdropScaffoldState, CoroutineScope coroutineScope) {
        if (!backdropScaffoldState.getConfirmValueChange().invoke(BackdropValue.Revealed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BackdropScaffoldKt$BackdropScaffold$2$1$2$1$1$1(backdropScaffoldState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BackdropScaffold_0hNv9B8$lambda$5$0$1$0$1(BackdropScaffoldState backdropScaffoldState, CoroutineScope coroutineScope) {
        if (!backdropScaffoldState.getConfirmValueChange().invoke(BackdropValue.Concealed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BackdropScaffoldKt$BackdropScaffold$2$1$2$1$2$1(backdropScaffoldState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropScaffold_0hNv9B8$lambda$5$0$2(float f, Function2 function2, long j, final boolean z, final BackdropScaffoldState backdropScaffoldState, final CoroutineScope coroutineScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C459@20817L544:BackdropScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(356452509, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:459)");
            }
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f, 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2041paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1810730913, "C460@20882L19,463@21019L228,461@20922L421:BackdropScaffold.kt#jmzs0o");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1443879845, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean zChanged = composer.changed(z) | composer.changed(backdropScaffoldState) | composer.changedInstance(coroutineScope);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdropScaffoldKt.BackdropScaffold_0hNv9B8$lambda$5$0$2$0$0$0(z, backdropScaffoldState, coroutineScope);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            m2925Scrim3JVO9M(j, function0, backdropScaffoldState.getTargetValue() == BackdropValue.Revealed, composer, 0);
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
    public static final Unit BackdropScaffold_0hNv9B8$lambda$5$0$2$0$0$0(boolean z, BackdropScaffoldState backdropScaffoldState, CoroutineScope coroutineScope) {
        if (z && backdropScaffoldState.getConfirmValueChange().invoke(BackdropValue.Concealed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BackdropScaffoldKt$BackdropScaffold$2$1$3$1$1$1$1(backdropScaffoldState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit BackdropScaffold_0hNv9B8$lambda$6(Function2 function2, Function2 function22, Function2 function23, Modifier modifier, BackdropScaffoldState backdropScaffoldState, Function3 function3, boolean z, float f, float f2, boolean z2, boolean z3, long j, long j2, Shape shape, float f3, long j3, long j4, long j5, int i, int i2, int i3, Composer composer, int i4) {
        m2924BackdropScaffold0hNv9B8(function2, function22, function23, modifier, backdropScaffoldState, function3, z, f, f2, z2, z3, j, j2, shape, f3, j3, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    private static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1490100844);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackdropStack)N(modifier,backLayer,calculateBackLayerConstraints,frontLayer)574@25128L896,574@25101L923:BackdropScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1490100844, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:573)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1762810092, "CC(remember):BackdropScaffold.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((i2 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BackdropScaffoldKt.BackdropStack$lambda$0$0(function2, function1, function4, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) objRememberedValue, composerStartRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldKt.BackdropStack$lambda$1(modifier, function2, function1, function4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BackdropStack$lambda$0$0(Function2 function2, Function1 function1, final Function4 function4, SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(BackdropLayers.Back, function2))).mo7769measureBRTryo0(((Constraints) function1.invoke(constraints)).getValue());
        final float height = placeableMo7769measureBRTryo0.getHeight();
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-344317043, true, new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BackdropScaffoldKt.BackdropStack$lambda$0$0$0(function4, constraints, height, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size = listSubcompose.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(listSubcompose.get(i).mo7769measureBRTryo0(constraints.getValue()));
        }
        final ArrayList arrayList2 = arrayList;
        int iMax = Math.max(Constraints.m9069getMinWidthimpl(constraints.getValue()), placeableMo7769measureBRTryo0.getWidth());
        int iMax2 = Math.max(Constraints.m9068getMinHeightimpl(constraints.getValue()), placeableMo7769measureBRTryo0.getHeight());
        int size2 = arrayList2.size();
        int iMax3 = iMax;
        int iMax4 = iMax2;
        for (int i2 = 0; i2 < size2; i2++) {
            Placeable placeable = (Placeable) arrayList2.get(i2);
            iMax3 = Math.max(iMax3, placeable.getWidth());
            iMax4 = Math.max(iMax4, placeable.getHeight());
        }
        return MeasureScope.layout$default(subcomposeMeasureScope, iMax3, iMax4, null, new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdropScaffoldKt.BackdropStack$lambda$0$0$3(placeableMo7769measureBRTryo0, arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropStack$lambda$0$0$0(Function4 function4, Constraints constraints, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C583@25467L40:BackdropScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-344317043, i, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:583)");
            }
            function4.invoke(constraints, Float.valueOf(f), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackdropStack$lambda$0$0$3(Placeable placeable, List list, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit BackdropStack$lambda$1(Modifier modifier, Function2 function2, Function1 function1, Function4 function4, int i, Composer composer, int i2) {
        BackdropStack(modifier, function2, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final NestedScrollConnection ConsumeSwipeNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }

    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    private static final void m2925Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionPointerInput;
        Composer composerStartRestartGroup = composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismiss,visible):BackdropScaffold.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:493)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-503366080);
                ComposerKt.sourceInformation(composerStartRestartGroup, "496@22099L87,503@22447L62,503@22394L115");
                int i3 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-503200478);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "499@22288L37");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646337124, "CC(remember):BackdropScaffold.kt#9igjgp");
                    boolean z2 = (i3 & 112) == 32;
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (PointerInputEventHandler) backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-503100069);
                    composerStartRestartGroup.endReplaceGroup();
                    companionPointerInput = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionPointerInput);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646342237, "CC(remember):BackdropScaffold.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i3 & 14) == 4);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BackdropScaffoldKt.Scrim_3J_VO9M$lambda$2$0(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-525268541);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldKt.Scrim_3J_VO9M$lambda$3(j, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float Scrim_3J_VO9M$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$2$0(long j, State state, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, 0L, 0L, Scrim_3J_VO9M$lambda$0(state), null, null, 0, Imgproc.COLOR_YUV2BGR_YVYU, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_3J_VO9M$lambda$3(long j, Function0 function0, boolean z, int i, Composer composer, int i2) {
        m2925Scrim3JVO9M(j, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue backdropValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -862178912, "C(rememberBackdropScaffoldState)N(initialValue,animationSpec,confirmStateChange,snackbarHostState)255@10390L8,256@10443L32,258@10535L7,270@10922L267,259@10554L635:BackdropScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        final AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 374760200, "CC(remember):BackdropScaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BackdropScaffoldKt.rememberBackdropScaffoldState$lambda$0$0((BackdropValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        final Function1<? super BackdropValue, Boolean> function12 = function1;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 374761920, "CC(remember):BackdropScaffold.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue2);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        final SnackbarHostState snackbarHostState2 = snackbarHostState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:257)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {animationSpec2, function12, snackbarHostState2};
        Saver<BackdropScaffoldState, ?> Saver = BackdropScaffoldState.INSTANCE.Saver(animationSpec2, function12, snackbarHostState2, density);
        ComposerKt.sourceInformationMarkerStart(composer, 374777483, "CC(remember):BackdropScaffold.kt#9igjgp");
        boolean z = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(backdropValue.ordinal())) || (i & 6) == 4) | composer.changed(density) | composer.changedInstance(animationSpec2) | ((((i & 896) ^ 384) > 256 && composer.changed(function12)) || (i & 384) == 256);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(snackbarHostState2)) && (i & 3072) != 2048) {
            z = false;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function0() { // from class: androidx.compose.material.BackdropScaffoldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackdropScaffoldKt.BackdropScaffoldState(backdropValue, density, animationSpec2, function12, snackbarHostState2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue3 = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return backdropScaffoldState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberBackdropScaffoldState$lambda$0$0(BackdropValue backdropValue) {
        return true;
    }
}
