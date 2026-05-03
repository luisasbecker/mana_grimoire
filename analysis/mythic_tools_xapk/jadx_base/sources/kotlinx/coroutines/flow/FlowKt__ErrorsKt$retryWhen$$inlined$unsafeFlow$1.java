package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {113, 115}, m = "collect", n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007f -> B:31:0x00a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0098 -> B:27:0x009b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        long j;
        long j2;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        int i;
        Throwable th;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objCatchImpl = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCatchImpl);
            j = 0;
            Flow flow = this.$this_retryWhen$inlined;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = flowCollector;
            anonymousClass1.L$2 = null;
            anonymousClass1.J$0 = j;
            i = 0;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objCatchImpl = FlowKt.catchImpl(flow, flowCollector, anonymousClass1);
            if (objCatchImpl != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            int i3 = anonymousClass1.I$0;
            long j3 = anonymousClass1.J$0;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) anonymousClass1.L$1;
            FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCatchImpl);
            i = i3;
            flowCollector2 = flowCollector3;
            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
            j2 = j3;
            th = (Throwable) objCatchImpl;
            if (th != null) {
            }
            long j4 = j2;
            flowCollector = flowCollector2;
            this = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
            j = j4;
            if (i == 0) {
            }
            Flow flow2 = this.$this_retryWhen$inlined;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = flowCollector;
            anonymousClass1.L$2 = null;
            anonymousClass1.J$0 = j;
            i = 0;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objCatchImpl = FlowKt.catchImpl(flow2, flowCollector, anonymousClass1);
            if (objCatchImpl != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j2 = anonymousClass1.J$0;
        Throwable th2 = (Throwable) anonymousClass1.L$2;
        flowCollector2 = (FlowCollector) anonymousClass1.L$1;
        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objCatchImpl);
        if (!((Boolean) objCatchImpl).booleanValue()) {
            j2++;
            i = 1;
            long j42 = j2;
            flowCollector = flowCollector2;
            this = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
            j = j42;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            Flow flow22 = this.$this_retryWhen$inlined;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = flowCollector;
            anonymousClass1.L$2 = null;
            anonymousClass1.J$0 = j;
            i = 0;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objCatchImpl = FlowKt.catchImpl(flow22, flowCollector, anonymousClass1);
            if (objCatchImpl != coroutine_suspended) {
                long j5 = j;
                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
                flowCollector2 = flowCollector;
                j2 = j5;
                th = (Throwable) objCatchImpl;
                if (th != null) {
                    Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$predicate$inlined;
                    Long lBoxLong = Boxing.boxLong(j2);
                    anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    anonymousClass1.L$1 = flowCollector2;
                    anonymousClass1.L$2 = th;
                    anonymousClass1.J$0 = j2;
                    anonymousClass1.label = 2;
                    Object objInvoke = function4.invoke(flowCollector2, th, lBoxLong, anonymousClass1);
                    if (objInvoke != coroutine_suspended) {
                        th2 = th;
                        objCatchImpl = objInvoke;
                        if (!((Boolean) objCatchImpl).booleanValue()) {
                            throw th2;
                        }
                    }
                }
                long j422 = j2;
                flowCollector = flowCollector2;
                this = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                j = j422;
                if (i == 0) {
                }
                Flow flow222 = this.$this_retryWhen$inlined;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = flowCollector;
                anonymousClass1.L$2 = null;
                anonymousClass1.J$0 = j;
                i = 0;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                objCatchImpl = FlowKt.catchImpl(flow222, flowCollector, anonymousClass1);
                if (objCatchImpl != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }
}
