package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.media3.muxer.MuxerUtil;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AndroidOverscroll.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001a\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0013H\u0002J\u0017\u0010E\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u00102\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006S"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation$annotations", "()V", "getInvalidationEnabled$foundation", "()Z", "setInvalidationEnabled$foundation", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", "scroll", "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    private AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues) {
        this.density = density;
        this.pointerPosition = Offset.INSTANCE.m6095getUnspecifiedF1C5BW0();
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m6379toArgb8_81llA(j));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m6158getZeroNHjbRc();
        this.pointerId = PointerId.m7618constructorimpl(-1L);
        SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1

            /* JADX INFO: renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: AndroidOverscroll.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {783, 787}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"}, v = 1)
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = androidEdgeEffectOverscrollEffect;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
                
                    if (r15 != r0) goto L18;
                 */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0061 -> B:18:0x0064). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object obj2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                        if (obj != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                        ArrayList arrayList = new ArrayList(changes.size());
                        int size = changes.size();
                        int i2 = 0;
                        for (int i3 = 0; i3 < size; i3++) {
                            PointerInputChange pointerInputChange = changes.get(i3);
                            if (pointerInputChange.getPressed()) {
                                arrayList.add(pointerInputChange);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
                        ArrayList arrayList3 = arrayList2;
                        int size2 = arrayList3.size();
                        while (true) {
                            if (i2 >= size2) {
                                obj2 = null;
                                break;
                            }
                            obj2 = arrayList2.get(i2);
                            if (PointerId.m7620equalsimpl0(((PointerInputChange) obj2).getId(), androidEdgeEffectOverscrollEffect.pointerId)) {
                                break;
                            }
                            i2++;
                        }
                        PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                        if (pointerInputChange2 == null) {
                            pointerInputChange2 = (PointerInputChange) CollectionsKt.firstOrNull((List) arrayList2);
                        }
                        if (pointerInputChange2 != null) {
                            this.this$0.pointerId = pointerInputChange2.getId();
                            this.this$0.pointerPosition = pointerInputChange2.getPosition();
                        }
                        if (arrayList3.isEmpty()) {
                            this.this$0.pointerId = PointerId.m7618constructorimpl(-1L);
                            return Unit.INSTANCE;
                        }
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                    this.this$0.pointerId = pointerInputChange3.getId();
                    this.this$0.pointerPosition = pointerInputChange3.getPosition();
                    this.L$0 = awaitPointerEventScope;
                    this.label = 2;
                    obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(this.this$0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        });
        this.pointerInputNode = SuspendingPointerInputModifierNode;
        this.node = Build.VERSION.SDK_INT >= 31 ? new StretchOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper) : new GlowOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper, paddingValues);
    }

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j, paddingValues);
    }

    private final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation();
        }
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation$annotations() {
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m1455pullBottomk4lQ0M(long scroll) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m1462displacementF1C5BW0$foundation() >> 32));
        int i = (int) (scroll & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateBottomEffect, -fIntBitsToFloat2, 1.0f - fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m1456pullLeftk4lQ0M(long scroll) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m1462displacementF1C5BW0$foundation() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        int i = (int) (scroll >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateLeftEffect, fIntBitsToFloat2, 1.0f - fIntBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m1457pullRightk4lQ0M(long scroll) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m1462displacementF1C5BW0$foundation() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        int i = (int) (scroll >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateRightEffect, -fIntBitsToFloat2, fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize >> 32)) : Float.intBitsToFloat(i);
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m1458pullTopk4lQ0M(long scroll) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (m1462displacementF1C5BW0$foundation() >> 32));
        int i = (int) (scroll & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateTopEffect, fIntBitsToFloat2, fIntBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Float.intBitsToFloat(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m1459releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean zIsLeftAnimating;
        if (this.edgeEffectWrapper.isLeftAnimating()) {
            int i = (int) (delta >> 32);
            if (Float.intBitsToFloat(i) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(i));
                zIsLeftAnimating = this.edgeEffectWrapper.isLeftAnimating();
            } else {
                zIsLeftAnimating = false;
            }
        }
        if (this.edgeEffectWrapper.isRightAnimating()) {
            int i2 = (int) (delta >> 32);
            if (Float.intBitsToFloat(i2) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(i2));
                zIsLeftAnimating = zIsLeftAnimating || this.edgeEffectWrapper.isRightAnimating();
            }
        }
        if (this.edgeEffectWrapper.isTopAnimating()) {
            int i3 = (int) (delta & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            if (Float.intBitsToFloat(i3) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(i3));
                zIsLeftAnimating = zIsLeftAnimating || this.edgeEffectWrapper.isTopAnimating();
            }
        }
        if (this.edgeEffectWrapper.isBottomAnimating()) {
            int i4 = (int) (delta & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            if (Float.intBitsToFloat(i4) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(i4));
                return zIsLeftAnimating || this.edgeEffectWrapper.isBottomAnimating();
            }
        }
        return zIsLeftAnimating;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r14.invoke(r11, r0) == r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0135, code lost:
    
        if (r15 == r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1460applyToFlingBMRW4eQ(long j, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        long jM9355minusAH228Gc;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            if ((androidEdgeEffectOverscrollEffect$applyToFling$1.label & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label -= Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
            }
        }
        Object objInvoke = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (Size.m6151isEmptyimpl(this.containerSize)) {
                Velocity velocityM9343boximpl = Velocity.m9343boximpl(j);
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
            } else {
                long jVelocity = VelocityKt.Velocity((!this.edgeEffectWrapper.isLeftStretched() || Velocity.m9352getXimpl(j) >= 0.0f) ? (!this.edgeEffectWrapper.isRightStretched() || Velocity.m9352getXimpl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.m9352getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density) : EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.m9352getXimpl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density), (!this.edgeEffectWrapper.isTopStretched() || Velocity.m9353getYimpl(j) >= 0.0f) ? (!this.edgeEffectWrapper.isBottomStretched() || Velocity.m9353getYimpl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.m9353getYimpl(j), Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & this.containerSize)), this.density) : EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.m9353getYimpl(j), Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & this.containerSize)), this.density));
                if (!Velocity.m9351equalsimpl0(jVelocity, Velocity.INSTANCE.m9363getZero9UxMQ8M())) {
                    invalidateOverscroll$foundation();
                }
                jM9355minusAH228Gc = Velocity.m9355minusAH228Gc(j, jVelocity);
                Velocity velocityM9343boximpl2 = Velocity.m9343boximpl(jM9355minusAH228Gc);
                androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = jM9355minusAH228Gc;
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                objInvoke = function2.invoke(velocityM9343boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objInvoke);
            return Unit.INSTANCE;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        jM9355minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
        ResultKt.throwOnFailure(objInvoke);
        long jM9355minusAH228Gc2 = Velocity.m9355minusAH228Gc(jM9355minusAH228Gc, ((Velocity) objInvoke).getPackedValue());
        this.scrollCycleInProgress = false;
        if (Velocity.m9352getXimpl(jM9355minusAH228Gc2) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.m9352getXimpl(jM9355minusAH228Gc2)));
        } else if (Velocity.m9352getXimpl(jM9355minusAH228Gc2) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.m9352getXimpl(jM9355minusAH228Gc2)));
        }
        if (Velocity.m9353getYimpl(jM9355minusAH228Gc2) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.m9353getYimpl(jM9355minusAH228Gc2)));
        } else if (Velocity.m9353getYimpl(jM9355minusAH228Gc2) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.m9353getYimpl(jM9355minusAH228Gc2)));
        }
        animateToReleaseIfNeeded();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[PHI: r11
      0x00b8: PHI (r11v9 float) = (r11v8 float), (r11v12 float) binds: [B:43:0x00e9, B:32:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132 A[PHI: r14
      0x0132: PHI (r14v9 float) = (r14v8 float), (r14v12 float) binds: [B:67:0x0162, B:56:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo1461applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float fM1455pullBottomk4lQ0M;
        float fIntBitsToFloat;
        float fM1457pullRightk4lQ0M;
        float fIntBitsToFloat2;
        long j;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        if (Size.m6151isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m6069boximpl(delta)).m6090unboximpl();
        }
        if (!this.scrollCycleInProgress) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                m1456pullLeftk4lQ0M(Offset.INSTANCE.m6096getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isRightStretched()) {
                m1457pullRightk4lQ0M(Offset.INSTANCE.m6096getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isTopStretched()) {
                m1458pullTopk4lQ0M(Offset.INSTANCE.m6096getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isBottomStretched()) {
                m1455pullBottomk4lQ0M(Offset.INSTANCE.m6096getZeroF1C5BW0());
            }
            this.scrollCycleInProgress = true;
        }
        float fM1480destretchMultiplierGyEprt8 = AndroidOverscroll_androidKt.m1480destretchMultiplierGyEprt8(source);
        long jM6087timestuRUvjQ = Offset.m6087timestuRUvjQ(delta, fM1480destretchMultiplierGyEprt8);
        int i2 = (int) (delta & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        if (Float.intBitsToFloat(i2) != 0.0f) {
            if (this.edgeEffectWrapper.isTopStretched() && Float.intBitsToFloat(i2) < 0.0f) {
                fM1455pullBottomk4lQ0M = m1458pullTopk4lQ0M(jM6087timestuRUvjQ);
                if (!this.edgeEffectWrapper.isTopStretched()) {
                    this.edgeEffectWrapper.getOrCreateTopEffect().finish();
                }
                if (fM1455pullBottomk4lQ0M == Float.intBitsToFloat((int) (jM6087timestuRUvjQ & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) {
                    fIntBitsToFloat = Float.intBitsToFloat(i2);
                }
            } else if (!this.edgeEffectWrapper.isBottomStretched() || Float.intBitsToFloat(i2) <= 0.0f) {
                fIntBitsToFloat = 0.0f;
            } else {
                fM1455pullBottomk4lQ0M = m1455pullBottomk4lQ0M(jM6087timestuRUvjQ);
                if (!this.edgeEffectWrapper.isBottomStretched()) {
                    this.edgeEffectWrapper.getOrCreateBottomEffect().finish();
                }
                fIntBitsToFloat = fM1455pullBottomk4lQ0M == Float.intBitsToFloat((int) (jM6087timestuRUvjQ & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? Float.intBitsToFloat(i2) : fM1455pullBottomk4lQ0M / fM1480destretchMultiplierGyEprt8;
            }
        }
        int i3 = (int) (delta >> 32);
        if (Float.intBitsToFloat(i3) != 0.0f) {
            if (this.edgeEffectWrapper.isLeftStretched() && Float.intBitsToFloat(i3) < 0.0f) {
                fM1457pullRightk4lQ0M = m1456pullLeftk4lQ0M(jM6087timestuRUvjQ);
                if (!this.edgeEffectWrapper.isLeftStretched()) {
                    this.edgeEffectWrapper.getOrCreateLeftEffect().finish();
                }
                if (fM1457pullRightk4lQ0M == Float.intBitsToFloat((int) (jM6087timestuRUvjQ >> 32))) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i3);
                }
            } else if (!this.edgeEffectWrapper.isRightStretched() || Float.intBitsToFloat(i3) <= 0.0f) {
                fIntBitsToFloat2 = 0.0f;
            } else {
                fM1457pullRightk4lQ0M = m1457pullRightk4lQ0M(jM6087timestuRUvjQ);
                if (!this.edgeEffectWrapper.isRightStretched()) {
                    this.edgeEffectWrapper.getOrCreateRightEffect().finish();
                }
                fIntBitsToFloat2 = fM1457pullRightk4lQ0M == Float.intBitsToFloat((int) (jM6087timestuRUvjQ >> 32)) ? Float.intBitsToFloat(i3) : fM1457pullRightk4lQ0M / fM1480destretchMultiplierGyEprt8;
            }
        }
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (!Offset.m6077equalsimpl0(jM6072constructorimpl, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
            invalidateOverscroll$foundation();
        }
        long jM6084minusMKHz9U = Offset.m6084minusMKHz9U(delta, jM6072constructorimpl);
        long jM6090unboximpl = performScroll.invoke(Offset.m6069boximpl(jM6084minusMKHz9U)).m6090unboximpl();
        long jM6084minusMKHz9U2 = Offset.m6084minusMKHz9U(jM6084minusMKHz9U, jM6090unboximpl);
        if ((Float.intBitsToFloat((int) (jM6084minusMKHz9U >> 32)) != 0.0f || Float.intBitsToFloat((int) (jM6084minusMKHz9U & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != 0.0f) && (Float.intBitsToFloat((int) (jM6090unboximpl >> 32)) != 0.0f || Float.intBitsToFloat((int) (jM6090unboximpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != 0.0f)) {
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            if (edgeEffectWrapper.isLeftStretched() || edgeEffectWrapper.isTopStretched() || edgeEffectWrapper.isRightStretched() || edgeEffectWrapper.isBottomStretched()) {
                animateToReleaseIfNeeded();
            }
        }
        if (NestedScrollSource.m7506equalsimpl0(source, NestedScrollSource.INSTANCE.m7518getUserInputWNlRxjI())) {
            int i4 = (int) (jM6084minusMKHz9U2 >> 32);
            if (Float.intBitsToFloat(i4) > 0.5f) {
                m1456pullLeftk4lQ0M(jM6084minusMKHz9U2);
            } else {
                if (Float.intBitsToFloat(i4) >= -0.5f) {
                    j = jM6072constructorimpl;
                    z2 = false;
                    i = (int) (jM6084minusMKHz9U2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
                    if (Float.intBitsToFloat(i) <= 0.5f) {
                        m1458pullTopk4lQ0M(jM6084minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i) >= -0.5f) {
                            z3 = false;
                            z = !z2 || z3;
                            if (!Offset.m6077equalsimpl0(jM6084minusMKHz9U, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
                                z = m1459releaseOppositeOverscrollk4lQ0M(delta) || z;
                            }
                            if (z) {
                                invalidateOverscroll$foundation();
                            }
                            return Offset.m6085plusMKHz9U(j, jM6090unboximpl);
                        }
                        m1455pullBottomk4lQ0M(jM6084minusMKHz9U2);
                    }
                    z3 = true;
                    if (z2) {
                    }
                    if (!Offset.m6077equalsimpl0(jM6084minusMKHz9U, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
                    }
                    if (z) {
                    }
                    return Offset.m6085plusMKHz9U(j, jM6090unboximpl);
                }
                m1457pullRightk4lQ0M(jM6084minusMKHz9U2);
            }
            z2 = true;
            j = jM6072constructorimpl;
            i = (int) (jM6084minusMKHz9U2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            if (Float.intBitsToFloat(i) <= 0.5f) {
            }
            z3 = true;
            if (z2) {
            }
            if (!Offset.m6077equalsimpl0(jM6084minusMKHz9U, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
            }
            if (z) {
            }
            return Offset.m6085plusMKHz9U(j, jM6090unboximpl);
        }
        j = jM6072constructorimpl;
        if (!Offset.m6077equalsimpl0(jM6084minusMKHz9U, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
        }
        if (z) {
        }
        return Offset.m6085plusMKHz9U(j, jM6090unboximpl);
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation, reason: not valid java name */
    public final long m1462displacementF1C5BW0$foundation() {
        long jM6159getCenteruvyYCjk = this.pointerPosition;
        if ((9223372034707292159L & jM6159getCenteruvyYCjk) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM6159getCenteruvyYCjk = SizeKt.m6159getCenteruvyYCjk(this.containerSize);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM6159getCenteruvyYCjk >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jM6159getCenteruvyYCjk & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / Float.intBitsToFloat((int) (this.containerSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    /* JADX INFO: renamed from: getInvalidationEnabled$foundation, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final MutableState<Unit> getRedrawSignal$foundation() {
        return this.redrawSignal;
    }

    public final void invalidateOverscroll$foundation() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null && EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        return (edgeEffect4 == null || EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f) ? false : true;
    }

    public final void setInvalidationEnabled$foundation(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation, reason: not valid java name */
    public final void m1463updateSizeuvyYCjk$foundation(long size) {
        boolean zM6145equalsimpl0 = Size.m6145equalsimpl0(this.containerSize, Size.INSTANCE.m6158getZeroNHjbRc());
        boolean zM6145equalsimpl02 = Size.m6145equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (!zM6145equalsimpl02) {
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (size >> 32)));
            edgeEffectWrapper.m1537updateSizeozmzZPI(IntSize.m9280constructorimpl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (size & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iRoundToInt) << 32)));
        }
        if (zM6145equalsimpl0 || zM6145equalsimpl02) {
            return;
        }
        animateToReleaseIfNeeded();
    }
}
