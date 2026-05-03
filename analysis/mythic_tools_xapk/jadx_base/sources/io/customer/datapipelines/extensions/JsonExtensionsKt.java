package io.customer.datapipelines.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\bH\u0002\u001a2\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\n*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a%\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f*\u0004\u0018\u0001H\u000f2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012*\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0016"}, d2 = {"toJsonObject", "Lkotlinx/serialization/json/JsonObject;", "Lorg/json/JSONObject;", "toJsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lorg/json/JSONArray;", "toSerializableJson", "Lkotlinx/serialization/json/JsonElement;", "", "sanitizeForJson", "", "", "logger", "Lio/customer/sdk/core/util/Logger;", "sanitizeValue", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;Lio/customer/sdk/core/util/Logger;)Ljava/lang/Object;", "sanitizeList", "", "isInvalidJsonNumber", "", "value", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JsonExtensionsKt {
    private static final boolean isInvalidJsonNumber(Object obj) {
        if (obj instanceof Float) {
            Number number = (Number) obj;
            return Float.isNaN(number.floatValue()) || Float.isInfinite(number.floatValue());
        }
        if (!(obj instanceof Double)) {
            return false;
        }
        Number number2 = (Number) obj;
        return Double.isNaN(number2.doubleValue()) || Double.isInfinite(number2.doubleValue());
    }

    public static final Map<String, Object> sanitizeForJson(Map<String, ? extends Object> map, Logger logger) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            Object objSanitizeValue = sanitizeValue(entry.getValue(), logger);
            if (objSanitizeValue != null) {
                linkedHashMap.put(entry.getKey(), objSanitizeValue);
            } else {
                Logger.DefaultImpls.error$default(logger, "Removed invalid JSON numeric value (NaN or infinity) for key: " + ((Object) entry.getKey()), null, null, 6, null);
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Map sanitizeForJson$default(Map map, Logger logger, int i, Object obj) {
        if ((i & 1) != 0) {
            logger = SDKComponent.INSTANCE.getLogger();
        }
        return sanitizeForJson(map, logger);
    }

    private static final List<?> sanitizeList(List<?> list, Logger logger) {
        Logger logger2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object objSanitizeValue = sanitizeValue(it.next(), logger);
            if (objSanitizeValue == null) {
                logger2 = logger;
                Logger.DefaultImpls.error$default(logger2, "Removed invalid JSON numeric value (NaN or infinity)", null, null, 6, null);
            } else {
                logger2 = logger;
            }
            if (objSanitizeValue != null) {
                arrayList.add(objSanitizeValue);
            }
            logger = logger2;
        }
        return arrayList;
    }

    private static final <T> T sanitizeValue(T t, Logger logger) {
        if (t == null) {
            return (T) JsonNull.INSTANCE;
        }
        if (!(t instanceof Double) && !(t instanceof Float)) {
            boolean z = t instanceof Map;
            if (z) {
                Map map = z ? (Map) t : null;
                return (T) (map != null ? sanitizeForJson(map, logger) : null);
            }
            if (t instanceof List) {
                return (T) sanitizeList((List) t, logger);
            }
        } else if (isInvalidJsonNumber(t)) {
            return null;
        }
        return t;
    }

    static /* synthetic */ Object sanitizeValue$default(Object obj, Logger logger, int i, Object obj2) {
        if ((i & 1) != 0) {
            logger = SDKComponent.INSTANCE.getLogger();
        }
        return sanitizeValue(obj, logger);
    }

    public static final JsonArray toJsonArray(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        int first = intRangeUntil.getFirst();
        int last = intRangeUntil.getLast();
        if (first <= last) {
            while (true) {
                jsonArrayBuilder.add(toSerializableJson(jSONArray.opt(first)));
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        return jsonArrayBuilder.build();
    }

    public static final JsonObject toJsonObject(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkNotNull(next);
            jsonObjectBuilder.put(next, toSerializableJson(jSONObject.opt(next)));
        }
        return jsonObjectBuilder.build();
    }

    private static final JsonElement toSerializableJson(Object obj) {
        return obj == null ? JsonNull.INSTANCE : obj instanceof JSONObject ? toJsonObject((JSONObject) obj) : obj instanceof JSONArray ? toJsonArray((JSONArray) obj) : JsonUtils.toJsonElement(obj);
    }
}
