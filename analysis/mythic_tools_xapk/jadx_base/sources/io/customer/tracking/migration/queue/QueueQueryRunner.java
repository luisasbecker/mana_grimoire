package io.customer.tracking.migration.queue;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueQueryRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0006H&¨\u0006\u0007"}, d2 = {"Lio/customer/tracking/migration/queue/QueueQueryRunner;", "", "getNextTask", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueTaskMetadata;", "queue", "", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface QueueQueryRunner {
    JSONObject getNextTask(List<? extends JSONObject> queue);
}
