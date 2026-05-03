package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u00108\u001a\u00020\u0007H\u0016J\u001f\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J'\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\bB\u0010CJ\u0018\u0010D\u001a\u00020E2\u0006\u0010;\u001a\u00020EH\u0096@¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001a\u00020\u0007J\u0017\u0010I\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\bJ\u0010KJ\u0016\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&H\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020&H\u0002J\u000e\u0010P\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010QR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR+\u0010,\u001a\u00020&2\u0006\u0010%\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u0014\u00100\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001d¨\u0006S"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "setRefreshing", "(Z)V", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "getEnabled", "setEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "()F", "setThreshold-0680j_4", "(F)V", "F", "shouldAutoInvalidate", "getShouldAutoInvalidate", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<set-?>", "", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "thresholdPx", "", "getThresholdPx", "()I", "progress", "getProgress", "onAttach", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "consumeAvailableOffset", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateVerticalOffset", "animateToThreshold", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToHidden", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshModifierNode extends DelegatingNode implements NestedScrollConnection {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: distancePulled$delegate, reason: from kotlin metadata */
    private final MutableFloatState distancePulled;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0<Unit> onRefresh;
    private PullToRefreshState state;
    private float threshold;

    /* JADX INFO: renamed from: verticalOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState verticalOffset;

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1, reason: invalid class name */
    /* JADX INFO: compiled from: PullToRefresh.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {}, l = {384}, m = "animateToHidden", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.animateToHidden(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PullToRefresh.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {}, l = {371}, m = "animateToThreshold", n = {}, s = {})
    static final class C04621 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04621(Continuation<? super C04621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.animateToThreshold(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PullToRefresh.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1", f = "PullToRefresh.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
    static final class C04631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04631(Continuation<? super C04631> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PullToRefreshModifierNode.this.new C04631(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PullToRefreshState state = PullToRefreshModifierNode.this.getState();
                float f = PullToRefreshModifierNode.this.getIsRefreshing() ? 1.0f : 0.0f;
                this.label = 1;
                if (state.snapTo(f, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PullToRefresh.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode", f = "PullToRefresh.kt", i = {0}, l = {345}, m = "onRelease", n = {"consumed"}, s = {"F$0"})
    static final class C04641 extends ContinuationImpl {
        float F$0;
        int label;
        /* synthetic */ Object result;

        C04641(Continuation<? super C04641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PullToRefreshModifierNode.this.onRelease(0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PullToRefresh.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1", f = "PullToRefresh.kt", i = {}, l = {304, 306}, m = "invokeSuspend", n = {}, s = {})
    static final class C04651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04651(Continuation<? super C04651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PullToRefreshModifierNode.this.new C04651(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        
            if (r1.animateToHidden(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        
            if (r1.animateToThreshold(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean isRefreshing = PullToRefreshModifierNode.this.getIsRefreshing();
                PullToRefreshModifierNode pullToRefreshModifierNode = PullToRefreshModifierNode.this;
                if (isRefreshing) {
                    this.label = 2;
                } else {
                    this.label = 1;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private PullToRefreshModifierNode(boolean z, Function0<Unit> function0, boolean z2, PullToRefreshState pullToRefreshState, float f) {
        this.isRefreshing = z;
        this.onRefresh = function0;
        this.enabled = z2;
        this.state = pullToRefreshState;
        this.threshold = f;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode(this, null);
        this.verticalOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    public /* synthetic */ PullToRefreshModifierNode(boolean z, Function0 function0, boolean z2, PullToRefreshState pullToRefreshState, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, z2, pullToRefreshState, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, kotlin.Unit] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToHidden(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PullToRefreshState pullToRefreshState = this.state;
                anonymousClass1.label = 1;
                if (pullToRefreshState.animateToHidden(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            setDistancePulled(0.0f);
            setVerticalOffset(0.0f);
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            this.setDistancePulled(0.0f);
            this.setVerticalOffset(0.0f);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToThreshold(Continuation<? super Unit> continuation) {
        C04621 c04621;
        if (continuation instanceof C04621) {
            c04621 = (C04621) continuation;
            if ((c04621.label & Integer.MIN_VALUE) != 0) {
                c04621.label -= Integer.MIN_VALUE;
            } else {
                c04621 = new C04621(continuation);
            }
        }
        Object obj = c04621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04621.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PullToRefreshState pullToRefreshState = this.state;
                c04621.label = 1;
                if (pullToRefreshState.animateToThreshold(c04621) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (getIsAttached()) {
                setDistancePulled(getThresholdPx());
                setVerticalOffset(getThresholdPx());
            }
            return Unit.INSTANCE;
        } finally {
            if (getIsAttached()) {
                setDistancePulled(getThresholdPx());
                setVerticalOffset(getThresholdPx());
            }
        }
    }

    private final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= getThresholdPx()) {
            return getAdjustedDistancePulled();
        }
        float fCoerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return getThresholdPx() + (getThresholdPx() * (fCoerceIn - (((float) Math.pow(fCoerceIn, 2.0d)) / 4.0f)));
    }

    /* JADX INFO: renamed from: consumeAvailableOffset-MK-Hz9U, reason: not valid java name */
    private final long m4697consumeAvailableOffsetMKHz9U(long available) {
        float distancePulled;
        if (this.isRefreshing) {
            distancePulled = 0.0f;
        } else {
            float fCoerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + Float.intBitsToFloat((int) (available & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f);
            distancePulled = fCoerceAtLeast - getDistancePulled();
            setDistancePulled(fCoerceAtLeast);
            setVerticalOffset(calculateVerticalOffset());
        }
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(distancePulled)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled() * 0.5f;
    }

    private final float getDistancePulled() {
        return this.distancePulled.getFloatValue();
    }

    private final float getProgress() {
        return getAdjustedDistancePulled() / getThresholdPx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getThresholdPx() {
        return DelegatableNodeKt.requireDensity(this).mo1618roundToPx0680j_4(this.threshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getVerticalOffset() {
        return this.verticalOffset.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onRelease(float f, Continuation<? super Float> continuation) {
        C04641 c04641;
        if (continuation instanceof C04641) {
            c04641 = (C04641) continuation;
            if ((c04641.label & Integer.MIN_VALUE) != 0) {
                c04641.label -= Integer.MIN_VALUE;
            } else {
                c04641 = new C04641(continuation);
            }
        }
        Object obj = c04641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04641.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isRefreshing) {
                return Boxing.boxFloat(0.0f);
            }
            if (getAdjustedDistancePulled() > getThresholdPx()) {
                this.onRefresh.invoke();
            }
            if (getDistancePulled() == 0.0f || f < 0.0f) {
                f = 0.0f;
            }
            c04641.F$0 = f;
            c04641.label = 1;
            if (animateToHidden(c04641) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = c04641.F$0;
            ResultKt.throwOnFailure(obj);
        }
        setDistancePulled(0.0f);
        return Boxing.boxFloat(f);
    }

    private final void setDistancePulled(float f) {
        this.distancePulled.setFloatValue(f);
    }

    private final void setVerticalOffset(float f) {
        this.verticalOffset.setFloatValue(f);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: getThreshold-D9Ej5fM, reason: not valid java name and from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    /* JADX INFO: renamed from: isRefreshing, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        delegate(this.nestedScrollNode);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C04631(null), 3, null);
        setVerticalOffset(this.isRefreshing ? getThresholdPx() : 0.0f);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo1792onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.state.isAnimating() && this.enabled && NestedScrollSource.m7506equalsimpl0(source, NestedScrollSource.INSTANCE.m7518getUserInputWNlRxjI())) {
            long jM4697consumeAvailableOffsetMKHz9U = m4697consumeAvailableOffsetMKHz9U(available);
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3, null);
            return jM4697consumeAvailableOffsetMKHz9U;
        }
        return Offset.INSTANCE.m6096getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2114onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        PullToRefreshModifierNode$onPreFling$1 pullToRefreshModifierNode$onPreFling$1;
        float f;
        if (continuation instanceof PullToRefreshModifierNode$onPreFling$1) {
            pullToRefreshModifierNode$onPreFling$1 = (PullToRefreshModifierNode$onPreFling$1) continuation;
            if ((pullToRefreshModifierNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                pullToRefreshModifierNode$onPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                pullToRefreshModifierNode$onPreFling$1 = new PullToRefreshModifierNode$onPreFling$1(this, continuation);
            }
        }
        Object objOnRelease = pullToRefreshModifierNode$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = pullToRefreshModifierNode$onPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objOnRelease);
            float fM9353getYimpl = Velocity.m9353getYimpl(j);
            pullToRefreshModifierNode$onPreFling$1.F$0 = 0.0f;
            pullToRefreshModifierNode$onPreFling$1.label = 1;
            objOnRelease = onRelease(fM9353getYimpl, pullToRefreshModifierNode$onPreFling$1);
            if (objOnRelease == coroutine_suspended) {
                return coroutine_suspended;
            }
            f = 0.0f;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = pullToRefreshModifierNode$onPreFling$1.F$0;
            ResultKt.throwOnFailure(objOnRelease);
        }
        return Velocity.m9343boximpl(VelocityKt.Velocity(f, ((Number) objOnRelease).floatValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo2115onPreScrollOzD1aCk(long available, int source) {
        if (!this.state.isAnimating() && this.enabled) {
            return (!NestedScrollSource.m7506equalsimpl0(source, NestedScrollSource.INSTANCE.m7518getUserInputWNlRxjI()) || Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & available)) >= 0.0f) ? Offset.INSTANCE.m6096getZeroF1C5BW0() : m4697consumeAvailableOffsetMKHz9U(available);
        }
        return Offset.INSTANCE.m6096getZeroF1C5BW0();
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setOnRefresh(Function0<Unit> function0) {
        this.onRefresh = function0;
    }

    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
    }

    public final void setState(PullToRefreshState pullToRefreshState) {
        this.state = pullToRefreshState;
    }

    /* JADX INFO: renamed from: setThreshold-0680j_4, reason: not valid java name */
    public final void m4699setThreshold0680j_4(float f) {
        this.threshold = f;
    }

    public final void update() {
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C04651(null), 3, null);
    }
}
