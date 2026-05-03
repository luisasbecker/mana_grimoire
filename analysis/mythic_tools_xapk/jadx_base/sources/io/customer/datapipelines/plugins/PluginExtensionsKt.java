package io.customer.datapipelines.plugins;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.segment.analytics.kotlin.core.BaseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: PluginExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\u0002\u001a\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\f"}, d2 = {"findAtPath", "", "Lkotlinx/serialization/json/JsonPrimitive;", "Lkotlinx/serialization/json/JsonObject;", "path", "", "findAtPathRecursive", "element", "Lkotlinx/serialization/json/JsonElement;", UserMetadata.KEYDATA_FILENAME, "findInContextAtPath", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PluginExtensionsKt {
    public static final List<JsonPrimitive> findAtPath(JsonObject jsonObject, String path) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return findAtPathRecursive(jsonObject, StringsKt.split$default((CharSequence) path, new char[]{FilenameUtils.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<JsonPrimitive> findAtPathRecursive(JsonElement jsonElement, List<String> list) {
        if (list.isEmpty()) {
            return jsonElement instanceof JsonPrimitive ? CollectionsKt.listOf(jsonElement) : CollectionsKt.emptyList();
        }
        String str = (String) CollectionsKt.first((List) list);
        List listDrop = CollectionsKt.drop(list, 1);
        if (jsonElement instanceof JsonObject) {
            JsonElement jsonElement2 = (JsonElement) ((JsonObject) jsonElement).get((Object) str);
            return jsonElement2 != null ? findAtPathRecursive(jsonElement2, listDrop) : CollectionsKt.emptyList();
        }
        if (!(jsonElement instanceof JsonArray)) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) jsonElement).iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, findAtPathRecursive((JsonElement) it.next(), list));
        }
        return arrayList;
    }

    public static final List<JsonPrimitive> findInContextAtPath(BaseEvent baseEvent, String path) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return findAtPath(baseEvent.getContext(), path);
    }
}
