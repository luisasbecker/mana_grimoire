package io.customer.tracking.migration.queue;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: QueueRunRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.customer.tracking.migration.queue.QueueRunRequestImpl", f = "QueueRunRequest.kt", i = {0, 0}, l = {56}, m = "executeOrThrows-0E7RQCE", n = {"$this$executeOrThrows_0E7RQCE_u24lambda_u244", "taskStorageId"}, s = {"L$0", "L$1"})
final class QueueRunRequestImpl$executeOrThrows$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueueRunRequestImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueueRunRequestImpl$executeOrThrows$1(QueueRunRequestImpl queueRunRequestImpl, Continuation<? super QueueRunRequestImpl$executeOrThrows$1> continuation) {
        super(continuation);
        this.this$0 = queueRunRequestImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM11438executeOrThrows0E7RQCE = this.this$0.m11438executeOrThrows0E7RQCE(null, null, this);
        return objM11438executeOrThrows0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM11438executeOrThrows0E7RQCE : Result.m11444boximpl(objM11438executeOrThrows0E7RQCE);
    }
}
