package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u0002H\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\u001a%\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"collectAsState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "R", "Lkotlinx/coroutines/flow/Flow;", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "snapshotFlow", "block", "Lkotlin/Function0;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {143, 147, 170}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends T> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        static final Unit invokeSuspend$lambda$0(MutableScatterSet mutableScatterSet, Object obj) {
            if (obj instanceof StateObjectImpl) {
                ReaderKind.Companion companion = ReaderKind.INSTANCE;
                ((StateObjectImpl) obj).m5787recordReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(4));
            }
            mutableScatterSet.add(obj);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static final Unit invokeSuspend$lambda$1(Channel channel, Set set, Snapshot snapshot) {
            if (set instanceof ScatterSetWrapper) {
                ScatterSet<T> set$runtime = ((ScatterSetWrapper) set).getSet$runtime();
                Object[] objArr = set$runtime.elements;
                long[] jArr = set$runtime.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    loop0: while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    Object obj = objArr[(i << 3) + i3];
                                    if (!(obj instanceof StateObjectImpl)) {
                                        break loop0;
                                    }
                                    ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                    if (((StateObjectImpl) obj).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(4))) {
                                        break loop0;
                                    }
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                            if (i == length) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                Set set2 = set;
                if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                    for (T t : set2) {
                        if (t instanceof StateObjectImpl) {
                            ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                            if (((StateObjectImpl) t).m5786isReadInh_f27i8$runtime(ReaderKind.m5774constructorimpl(4))) {
                            }
                        }
                        channel.mo12955trySendJP2dKIU(set);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:31:0x00d0, B:35:0x00d9], limit reached: 74 */
        /* JADX WARN: Path cross not found for [B:39:0x00e8, B:54:0x0129], limit reached: 74 */
        /* JADX WARN: Path cross not found for [B:54:0x0129, B:39:0x00e8], limit reached: 74 */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x004d, B:29:0x00cc, B:31:0x00d0, B:36:0x00da, B:39:0x00e8, B:43:0x00fe, B:45:0x0107, B:52:0x0125, B:53:0x0128, B:40:0x00f3, B:42:0x00fb, B:49:0x0120, B:50:0x0123), top: B:67:0x004d, inners: #2 }] */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v8, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ObserverHandle observerHandleRegisterApplyObserver;
            ?? r10;
            final MutableScatterSet mutableScatterSet;
            Function1<Object, Unit> function1;
            final Channel channelChannel$default;
            Object objInvoke;
            ObserverHandle observerHandle;
            ?? r11;
            MutableScatterSet mutableScatterSet2;
            Function1<Object, Unit> function12;
            Channel channel;
            Object obj2;
            int i;
            Set set;
            Snapshot snapshotTakeSnapshot;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 0;
            int i4 = 1;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    r10 = (FlowCollector) this.L$0;
                    mutableScatterSet = new MutableScatterSet(i3, i4, null);
                    function1 = new Function1() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$0(mutableScatterSet, obj3);
                        }
                    };
                    channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    observerHandleRegisterApplyObserver = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$1(channelChannel$default, (Set) obj3, (Snapshot) obj4);
                        }
                    });
                    Snapshot snapshotTakeSnapshot2 = Snapshot.INSTANCE.takeSnapshot(function1);
                    Function0<T> function0 = this.$block;
                    try {
                        Snapshot snapshotMakeCurrent = snapshotTakeSnapshot2.makeCurrent();
                        try {
                            objInvoke = function0.invoke();
                            snapshotTakeSnapshot2.dispose();
                            this.L$0 = r10;
                            this.L$1 = mutableScatterSet;
                            this.L$2 = function1;
                            this.L$3 = channelChannel$default;
                            this.L$4 = observerHandleRegisterApplyObserver;
                            this.L$5 = objInvoke;
                            this.label = 1;
                            if (r10.emit(objInvoke, this) == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } finally {
                        }
                    } finally {
                    }
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        i = this.I$0;
                        obj2 = this.L$5;
                        observerHandle = (ObserverHandle) this.L$4;
                        channel = (Channel) this.L$3;
                        function12 = (Function1) this.L$2;
                        mutableScatterSet2 = (MutableScatterSet) this.L$1;
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r11 = flowCollector;
                            set = (Set) obj;
                            do {
                                i = (i == 0 || SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(mutableScatterSet2, set)) ? 1 : 0;
                                set = (Set) ChannelResult.m12974getOrNullimpl(channel.mo12962tryReceivePtdJZtk());
                            } while (set != null);
                            if (i != 0) {
                                try {
                                    mutableScatterSet2.clear();
                                    snapshotTakeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                                    Function0<T> function02 = this.$block;
                                    try {
                                        objInvoke = function02.invoke();
                                        snapshotTakeSnapshot.dispose();
                                        if (!Intrinsics.areEqual(objInvoke, obj2)) {
                                            this.L$0 = r11;
                                            this.L$1 = mutableScatterSet2;
                                            this.L$2 = function12;
                                            this.L$3 = channel;
                                            this.L$4 = observerHandle;
                                            this.L$5 = objInvoke;
                                            this.label = 3;
                                            if (r11.emit(objInvoke, this) != coroutine_suspended) {
                                                observerHandleRegisterApplyObserver = observerHandle;
                                                channelChannel$default = channel;
                                                function1 = function12;
                                                mutableScatterSet = mutableScatterSet2;
                                                r10 = r11;
                                            }
                                            return coroutine_suspended;
                                        }
                                    } finally {
                                    }
                                } finally {
                                }
                                Snapshot snapshotMakeCurrent2 = snapshotTakeSnapshot.makeCurrent();
                            }
                            objInvoke = obj2;
                            observerHandleRegisterApplyObserver = observerHandle;
                            channelChannel$default = channel;
                            function1 = function12;
                            mutableScatterSet = mutableScatterSet2;
                            r10 = r11;
                        } catch (Throwable th) {
                            th = th;
                            observerHandleRegisterApplyObserver = observerHandle;
                            observerHandleRegisterApplyObserver.dispose();
                            throw th;
                        }
                    } else if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                objInvoke = this.L$5;
                observerHandleRegisterApplyObserver = (ObserverHandle) this.L$4;
                channelChannel$default = (Channel) this.L$3;
                function1 = (Function1) this.L$2;
                mutableScatterSet = (MutableScatterSet) this.L$1;
                r10 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = r10;
                this.L$1 = mutableScatterSet;
                this.L$2 = function1;
                this.L$3 = channelChannel$default;
                this.L$4 = observerHandleRegisterApplyObserver;
                this.L$5 = objInvoke;
                this.I$0 = 0;
                this.label = 2;
                obj = channelChannel$default.receive(this);
                if (obj != coroutine_suspended) {
                    r11 = r10;
                    mutableScatterSet2 = mutableScatterSet;
                    function12 = function1;
                    channel = channelChannel$default;
                    observerHandle = observerHandleRegisterApplyObserver;
                    obj2 = objInvoke;
                    i = 0;
                    set = (Set) obj;
                    do {
                        if (i == 0) {
                        }
                        set = (Set) ChannelResult.m12974getOrNullimpl(channel.mo12962tryReceivePtdJZtk());
                    } while (set != null);
                    if (i != 0) {
                    }
                    objInvoke = obj2;
                    observerHandleRegisterApplyObserver = observerHandle;
                    channelChannel$default = channel;
                    function1 = function12;
                    mutableScatterSet = mutableScatterSet2;
                    r10 = r11;
                    this.L$0 = r10;
                    this.L$1 = mutableScatterSet;
                    this.L$2 = function1;
                    this.L$3 = channelChannel$default;
                    this.L$4 = observerHandleRegisterApplyObserver;
                    this.L$5 = objInvoke;
                    this.I$0 = 0;
                    this.label = 2;
                    obj = channelChannel$default.receive(this);
                    if (obj != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                observerHandleRegisterApplyObserver.dispose();
                throw th;
            }
        }
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -606625098, "C(collectAsState)N(initial,context)65@2592L153,65@2555L190:SnapshotFlow.kt#9igjgp");
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1148838511, "CC(remember):SnapshotFlow.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(coroutineContext2) | composer.changedInstance(flow);
        SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(coroutineContext2, flow, null);
            composer.updateRememberedValue(snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<R> stateProduceState = SnapshotStateKt.produceState(r, flow, coroutineContext2, (Function2) snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue, composer, ((i >> 3) & 14) | ((i << 3) & 112) | (i & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateProduceState;
    }

    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1439883919, "C(collectAsState)N(context)49@1914L30:SnapshotFlow.kt#9igjgp");
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer, (i & 14) | ((i << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCollectAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> mutableScatterSet, Set<? extends Object> set) {
        MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return FlowKt.flow(new AnonymousClass1(function0, null));
    }
}
