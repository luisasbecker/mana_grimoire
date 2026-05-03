package io.customer.tracking.migration.queue;

import io.customer.sdk.core.util.Logger;
import io.customer.tracking.migration.extensions.JsonExtensionsKt;
import io.customer.tracking.migration.store.FileStorage;
import io.customer.tracking.migration.store.FileType;
import io.customer.tracking.migration.util.JsonAdapter;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rH\u0016J\u0018\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/customer/tracking/migration/queue/QueueStorageImpl;", "Lio/customer/tracking/migration/queue/QueueStorage;", "fileStorage", "Lio/customer/tracking/migration/store/FileStorage;", "jsonAdapter", "Lio/customer/tracking/migration/util/JsonAdapter;", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Lio/customer/tracking/migration/store/FileStorage;Lio/customer/tracking/migration/util/JsonAdapter;Lio/customer/sdk/core/util/Logger;)V", "getInventory", "", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueInventory;", "get", "Lio/customer/tracking/migration/queue/QueueTask;", "taskStorageId", "", "delete", "", "Lio/customer/tracking/migration/queue/QueueModifyResult;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueStorageImpl implements QueueStorage {
    private final FileStorage fileStorage;
    private final JsonAdapter jsonAdapter;
    private final Logger logger;

    public QueueStorageImpl(FileStorage fileStorage, JsonAdapter jsonAdapter, Logger logger) {
        Intrinsics.checkNotNullParameter(fileStorage, "fileStorage");
        Intrinsics.checkNotNullParameter(jsonAdapter, "jsonAdapter");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.fileStorage = fileStorage;
        this.jsonAdapter = jsonAdapter;
        this.logger = logger;
    }

    static final boolean delete$lambda$0(String str, JSONObject it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(AliasesKt.getTaskPersistedId(it), str);
    }

    @Override // io.customer.tracking.migration.queue.QueueStorage
    public synchronized boolean delete(final String taskStorageId) {
        Intrinsics.checkNotNullParameter(taskStorageId, "taskStorageId");
        CollectionsKt.removeAll(CollectionsKt.toMutableList((Collection) getInventory()), new Function1() { // from class: io.customer.tracking.migration.queue.QueueStorageImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(QueueStorageImpl.delete$lambda$0(taskStorageId, (JSONObject) obj));
            }
        });
        if (this.fileStorage.delete(new FileType.QueueTask(taskStorageId))) {
            return true;
        }
        Logger.DefaultImpls.error$default(this.logger, "error trying to delete task with storage id: " + taskStorageId + " from queue", null, null, 6, null);
        return false;
    }

    @Override // io.customer.tracking.migration.queue.QueueStorage
    public synchronized JSONObject get(String taskStorageId) {
        Intrinsics.checkNotNullParameter(taskStorageId, "taskStorageId");
        String str = this.fileStorage.get(new FileType.QueueTask(taskStorageId));
        if (str == null) {
            return null;
        }
        return this.jsonAdapter.fromJsonOrNull(str);
    }

    @Override // io.customer.tracking.migration.queue.QueueStorage
    public synchronized List<JSONObject> getInventory() {
        List<JSONObject> listEmptyList;
        String str = this.fileStorage.get(new FileType.QueueInventory());
        if (str == null) {
            return CollectionsKt.emptyList();
        }
        JSONArray jSONArrayFromJsonToListOrNull = this.jsonAdapter.fromJsonToListOrNull(str);
        if (jSONArrayFromJsonToListOrNull == null || (listEmptyList = JsonExtensionsKt.toList(jSONArrayFromJsonToListOrNull)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return listEmptyList;
    }
}
