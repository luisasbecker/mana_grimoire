package io.customer.tracking.migration.queue;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH¦@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/customer/tracking/migration/queue/QueueRunner;", "", "runTask", "Lkotlin/Result;", "", "Lio/customer/tracking/migration/queue/QueueRunTaskResult;", "task", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueTask;", "runTask-gIAlu-s", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface QueueRunner {
    /* JADX INFO: renamed from: runTask-gIAlu-s, reason: not valid java name */
    Object mo11439runTaskgIAlus(JSONObject jSONObject, Continuation<? super Result<Unit>> continuation);
}
