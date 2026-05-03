package io.customer.tracking.migration.queue;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: QueueRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.customer.tracking.migration.queue.QueueRunnerImpl", f = "QueueRunner.kt", i = {}, l = {21}, m = "runTask-gIAlu-s", n = {}, s = {})
final class QueueRunnerImpl$runTask$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueueRunnerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueueRunnerImpl$runTask$1(QueueRunnerImpl queueRunnerImpl, Continuation<? super QueueRunnerImpl$runTask$1> continuation) {
        super(continuation);
        this.this$0 = queueRunnerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo11439runTaskgIAlus = this.this$0.mo11439runTaskgIAlus(null, this);
        return objMo11439runTaskgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo11439runTaskgIAlus : Result.m11444boximpl(objMo11439runTaskgIAlus);
    }
}
