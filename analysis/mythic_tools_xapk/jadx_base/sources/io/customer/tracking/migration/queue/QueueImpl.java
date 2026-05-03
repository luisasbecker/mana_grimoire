package io.customer.tracking.migration.queue;

import io.customer.sdk.core.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Queue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/customer/tracking/migration/queue/QueueImpl;", "Lio/customer/tracking/migration/queue/Queue;", "logger", "Lio/customer/sdk/core/util/Logger;", "runRequest", "Lio/customer/tracking/migration/queue/QueueRunRequest;", "<init>", "(Lio/customer/sdk/core/util/Logger;Lio/customer/tracking/migration/queue/QueueRunRequest;)V", "isRunningRequest", "", "()Z", "setRunningRequest", "(Z)V", "run", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueImpl implements Queue {
    private volatile boolean isRunningRequest;
    private final Logger logger;
    private final QueueRunRequest runRequest;

    /* JADX INFO: renamed from: io.customer.tracking.migration.queue.QueueImpl$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: Queue.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.tracking.migration.queue.QueueImpl", f = "Queue.kt", i = {}, l = {26}, m = "run", n = {}, s = {})
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
            return QueueImpl.this.run(this);
        }
    }

    public QueueImpl(Logger logger, QueueRunRequest runRequest) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(runRequest, "runRequest");
        this.logger = logger;
        this.runRequest = runRequest;
    }

    /* JADX INFO: renamed from: isRunningRequest, reason: from getter */
    public final boolean getIsRunningRequest() {
        return this.isRunningRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.customer.tracking.migration.queue.Queue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object run(Continuation<? super Unit> continuation) {
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            synchronized (this) {
                if (this.isRunningRequest) {
                    return Unit.INSTANCE;
                }
                this.isRunningRequest = true;
                Unit unit = Unit.INSTANCE;
                Logger.DefaultImpls.debug$default(this.logger, "Running migration queue...", null, 2, null);
                QueueRunRequest queueRunRequest = this.runRequest;
                anonymousClass1.label = 1;
                if (queueRunRequest.run(anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        synchronized (this) {
            this.isRunningRequest = false;
            Unit unit2 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void setRunningRequest(boolean z) {
        this.isRunningRequest = z;
    }
}
