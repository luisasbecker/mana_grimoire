package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u001c\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0003H\u0014J\u001d\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,2\u0006\u0010-\u001a\u00020\u000eH\u0014¢\u0006\u0002\u0010.J&\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0000002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016R\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "<init>", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "sequence", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "tryEmit", "(Ljava/lang/Object;)Z", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {389, 401, Videoio.CAP_PROP_XI_GPI_SELECTOR}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StateFlowImpl<T> stateFlowImpl, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = stateFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i;
        StateFlowSlot[] slots;
        synchronized (this) {
            Object obj = _state$volatile$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            _state$volatile$FU.set(this, newState);
            int i2 = this.sequence;
            if ((i2 & 1) != 0) {
                this.sequence = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.sequence = i3;
            StateFlowSlot[] slots2 = getSlots();
            Unit unit = Unit.INSTANCE;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = slots2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i = this.sequence;
                    if (i == i3) {
                        this.sequence = i3 + 1;
                        return true;
                    }
                    slots = getSlots();
                    Unit unit2 = Unit.INSTANCE;
                }
                slots2 = slots;
                i3 = i;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:33:0x00aa, B:50:0x00e4], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:50:0x00e4, B:33:0x00aa], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4 A[Catch: all -> 0x00f7, TryCatch #1 {all -> 0x00f7, blocks: (B:33:0x00aa, B:35:0x00b4, B:37:0x00b9, B:48:0x00de, B:50:0x00e4, B:39:0x00bf, B:43:0x00c6, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:58:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[Catch: all -> 0x00f7, TryCatch #1 {all -> 0x00f7, blocks: (B:33:0x00aa, B:35:0x00b4, B:37:0x00b9, B:48:0x00de, B:50:0x00e4, B:39:0x00bf, B:43:0x00c6, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:58:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4 A[Catch: all -> 0x00f7, TRY_LEAVE, TryCatch #1 {all -> 0x00f7, blocks: (B:33:0x00aa, B:35:0x00b4, B:37:0x00b9, B:48:0x00de, B:50:0x00e4, B:39:0x00bf, B:43:0x00c6, B:24:0x0075, B:32:0x0099, B:27:0x0083, B:29:0x0087), top: B:58:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e2 -> B:33:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f4 -> B:33:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        StateFlowImpl<T> stateFlowImpl;
        Throwable th;
        Job job;
        Object obj;
        StateFlowImpl<T> stateFlowImpl2;
        ?? r6;
        ?? r2;
        Object obj2;
        ?? r62;
        ?? r22;
        boolean zTakePending;
        ?? r63;
        Object obj3;
        StateFlowSlot stateFlowSlot;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        Object obj4 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r23 = anonymousClass1.label;
        try {
            if (r23 == 0) {
                ResultKt.throwOnFailure(obj4);
                StateFlowSlot stateFlowSlotAllocateSlot = allocateSlot();
                stateFlowSlot = stateFlowSlotAllocateSlot;
                if (flowCollector instanceof SubscribedFlowCollector) {
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = stateFlowSlotAllocateSlot;
                    anonymousClass1.label = 1;
                    stateFlowSlot = stateFlowSlotAllocateSlot;
                    if (((SubscribedFlowCollector) flowCollector).onSubscription(anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (r23 != 1) {
                try {
                    if (r23 == 2) {
                        obj = anonymousClass1.L$4;
                        job = (Job) anonymousClass1.L$3;
                        StateFlowSlot stateFlowSlot2 = (StateFlowSlot) anonymousClass1.L$2;
                        FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                        stateFlowImpl2 = (StateFlowImpl) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        r2 = stateFlowSlot2;
                        r6 = flowCollector2;
                        obj2 = obj;
                        this = stateFlowImpl2;
                        r22 = r2;
                        r62 = r6;
                        zTakePending = r22.takePending();
                        r23 = r22;
                        r63 = r62;
                        if (!zTakePending) {
                        }
                        Object obj5 = _state$volatile$FU.get(this);
                        if (job != null) {
                        }
                        if (obj2 != null) {
                        }
                        if (obj5 != NullSurrogateKt.NULL) {
                        }
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = r63;
                        anonymousClass1.L$2 = r23;
                        anonymousClass1.L$3 = job;
                        anonymousClass1.L$4 = obj5;
                        anonymousClass1.label = 2;
                        if (r63.emit(obj3, anonymousClass1) != coroutine_suspended) {
                        }
                    } else {
                        if (r23 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Object obj6 = anonymousClass1.L$4;
                        job = (Job) anonymousClass1.L$3;
                        StateFlowSlot stateFlowSlot3 = (StateFlowSlot) anonymousClass1.L$2;
                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                        StateFlowImpl<T> stateFlowImpl3 = (StateFlowImpl) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        obj2 = obj6;
                        this = stateFlowImpl3;
                        r23 = stateFlowSlot3;
                        r63 = flowCollector3;
                        Object obj52 = _state$volatile$FU.get(this);
                        if (job != null) {
                            JobKt.ensureActive(job);
                        }
                        if (obj2 != null) {
                            r22 = r23;
                            r62 = r63;
                            if (Intrinsics.areEqual(obj2, obj52)) {
                                zTakePending = r22.takePending();
                                r23 = r22;
                                r63 = r62;
                                if (!zTakePending) {
                                    anonymousClass1.L$0 = this;
                                    anonymousClass1.L$1 = r62;
                                    anonymousClass1.L$2 = r22;
                                    anonymousClass1.L$3 = job;
                                    anonymousClass1.L$4 = obj2;
                                    anonymousClass1.label = 3;
                                    Object objAwaitPending = r22.awaitPending(anonymousClass1);
                                    r23 = r22;
                                    r63 = r62;
                                    if (objAwaitPending != coroutine_suspended) {
                                    }
                                }
                                Object obj522 = _state$volatile$FU.get(this);
                                if (job != null) {
                                }
                                if (obj2 != null) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        obj3 = obj522 != NullSurrogateKt.NULL ? null : obj522;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = r63;
                        anonymousClass1.L$2 = r23;
                        anonymousClass1.L$3 = job;
                        anonymousClass1.L$4 = obj522;
                        anonymousClass1.label = 2;
                        if (r63.emit(obj3, anonymousClass1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stateFlowImpl2 = this;
                        obj = obj522;
                        r2 = r23;
                        r6 = r63;
                        obj2 = obj;
                        this = stateFlowImpl2;
                        r22 = r2;
                        r62 = r6;
                        zTakePending = r22.takePending();
                        r23 = r22;
                        r63 = r62;
                        if (!zTakePending) {
                        }
                        Object obj5222 = _state$volatile$FU.get(this);
                        if (job != null) {
                        }
                        if (obj2 != null) {
                        }
                        if (obj5222 != NullSurrogateKt.NULL) {
                        }
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = r63;
                        anonymousClass1.L$2 = r23;
                        anonymousClass1.L$3 = job;
                        anonymousClass1.L$4 = obj5222;
                        anonymousClass1.label = 2;
                        if (r63.emit(obj3, anonymousClass1) != coroutine_suspended) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    stateFlowImpl.freeSlot((AbstractSharedFlowSlot) r23);
                    throw th;
                }
            } else {
                StateFlowSlot stateFlowSlot4 = (StateFlowSlot) anonymousClass1.L$2;
                flowCollector = (FlowCollector) anonymousClass1.L$1;
                this = (StateFlowImpl) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj4);
                stateFlowSlot = stateFlowSlot4;
            }
            r63 = flowCollector;
            job = (Job) anonymousClass1.get$context().get(Job.INSTANCE);
            obj2 = null;
            r23 = stateFlowSlot;
            Object obj52222 = _state$volatile$FU.get(this);
            if (job != null) {
            }
            if (obj2 != null) {
            }
            if (obj52222 != NullSurrogateKt.NULL) {
            }
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = r63;
            anonymousClass1.L$2 = r23;
            anonymousClass1.L$3 = job;
            anonymousClass1.L$4 = obj52222;
            anonymousClass1.label = 2;
            if (r63.emit(obj3, anonymousClass1) != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            stateFlowImpl = this;
            th = th3;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.NULL;
        }
        return updateState(expect, update);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) _state$volatile$FU.get(this);
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        setValue(value);
        return true;
    }
}
