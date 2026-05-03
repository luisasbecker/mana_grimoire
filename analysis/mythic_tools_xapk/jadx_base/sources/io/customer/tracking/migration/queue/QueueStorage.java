package io.customer.tracking.migration.queue;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H&J\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0014\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lio/customer/tracking/migration/queue/QueueStorage;", "", "getInventory", "", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueInventory;", "get", "Lio/customer/tracking/migration/queue/QueueTask;", "taskStorageId", "", "delete", "", "Lio/customer/tracking/migration/queue/QueueModifyResult;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface QueueStorage {
    boolean delete(String taskStorageId);

    JSONObject get(String taskStorageId);

    List<JSONObject> getInventory();
}
