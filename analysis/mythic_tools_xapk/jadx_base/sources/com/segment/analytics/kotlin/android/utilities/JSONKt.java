package com.segment.analytics.kotlin.android.utilities;

import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSON.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¨\u0006\b"}, d2 = {"toJSONArray", "Lorg/json/JSONArray;", "", "Lkotlinx/serialization/json/JsonElement;", "toJSONObject", "Lorg/json/JSONObject;", "", "", "android_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JSONKt {
    public static final JSONArray toJSONArray(List<? extends JsonElement> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof JsonPrimitive) {
                jSONArray.put(JsonUtils.toContent((JsonPrimitive) obj));
            } else if (obj instanceof JsonObject) {
                jSONArray.put(toJSONObject((Map) obj));
            } else if (obj instanceof JsonArray) {
                jSONArray.put(toJSONArray((List) obj));
            }
        }
        return jSONArray;
    }

    public static final JSONObject toJSONObject(Map<String, ? extends JsonElement> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends JsonElement> entry : map.entrySet()) {
            String key = entry.getKey();
            Object obj = (JsonElement) entry.getValue();
            if (obj instanceof JsonPrimitive) {
                jSONObject.put(key, JsonUtils.toContent((JsonPrimitive) obj));
            } else if (obj instanceof JsonObject) {
                jSONObject.put(key, toJSONObject((Map) obj));
            } else if (obj instanceof JsonArray) {
                jSONObject.put(key, toJSONArray((List) obj));
            }
        }
        return jSONObject;
    }
}
