package io.customer.tracking.migration.queue;

import io.customer.sdk.core.util.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueQueryRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/customer/tracking/migration/queue/QueueQueryRunnerImpl;", "Lio/customer/tracking/migration/queue/QueueQueryRunner;", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Lio/customer/sdk/core/util/Logger;)V", "getNextTask", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueTaskMetadata;", "queue", "", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueQueryRunnerImpl implements QueueQueryRunner {
    private final Logger logger;

    public QueueQueryRunnerImpl(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // io.customer.tracking.migration.queue.QueueQueryRunner
    public JSONObject getNextTask(List<? extends JSONObject> queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        if (queue.isEmpty()) {
            return null;
        }
        Logger.DefaultImpls.debug$default(this.logger, "queue querying next task", null, 2, null);
        return (JSONObject) CollectionsKt.firstOrNull((List) queue);
    }
}
