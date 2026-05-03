package io.customer.tracking.migration.queue;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: QueueRunRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/customer/tracking/migration/queue/QueueRunRequest;", "", "run", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface QueueRunRequest {
    Object run(Continuation<? super Unit> continuation);
}
