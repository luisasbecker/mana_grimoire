package io.customer.tracking.migration.queue;

import io.customer.tracking.migration.extensions.JsonExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Aliases.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00060\u0002j\u0002`\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*\f\b\u0000\u0010\u0003\"\u00020\u00042\u00020\u0004*\u0018\b\u0000\u0010\u0005\"\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0012\u0004\u0012\u00020\u00070\u0006*\f\b\u0000\u0010\b\"\u00020\u00022\u00020\u0002*\f\b\u0000\u0010\t\"\u00020\u00022\u00020\u0002¨\u0006\u000f"}, d2 = {"QueueInventory", "", "Lorg/json/JSONObject;", "QueueModifyResult", "", "QueueRunTaskResult", "Lkotlin/Result;", "", "QueueTask", "QueueTaskMetadata", "taskPersistedId", "", "Lio/customer/tracking/migration/queue/QueueTaskMetadata;", "getTaskPersistedId", "(Lorg/json/JSONObject;)Ljava/lang/String;", "tracking-migration_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AliasesKt {
    public static final String getTaskPersistedId(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return JsonExtensionsKt.stringOrNull(jSONObject, "taskPersistedId");
    }
}
