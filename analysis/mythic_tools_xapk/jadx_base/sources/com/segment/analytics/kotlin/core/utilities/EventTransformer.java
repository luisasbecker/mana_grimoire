package com.segment.analytics.kotlin.core.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.EventsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: EventManipulationFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0004\u001a.\u0010\t\u001a\u00020\u0001\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\nH\u0086\b¢\u0006\u0002\u0010\u000e\u001a7\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010¢\u0006\u0002\u0010\u0011\u001a!\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0014\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016\u001a6\u0010\u0017\u001a\u00020\u0001\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\nH\u0086\b¢\u0006\u0002\u0010\u0019\u001a?\u0010\u0017\u001a\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010¢\u0006\u0002\u0010\u001a\u001a\"\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016\u001a.\u0010\u001b\u001a\u00020\u0001\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\nH\u0086\b¢\u0006\u0002\u0010\u000e\u001a7\u0010\u001b\u001a\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u0002H\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0012\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004¨\u0006\u001d"}, d2 = {"disableCloudIntegrations", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "exceptKeys", "", "", "disableIntegration", "integrationName", "enableCloudIntegrations", "enableIntegration", "putInContext", ExifInterface.GPS_DIRECTION_TRUE, "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/kotlin/core/BaseEvent;", "serializationStrategy", "Lkotlinx/serialization/SerializationStrategy;", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lcom/segment/analytics/kotlin/core/BaseEvent;", "", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/segment/analytics/kotlin/core/BaseEvent;", "", "jsonElement", "Lkotlinx/serialization/json/JsonElement;", "putInContextUnderKey", "parentKey", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/kotlin/core/BaseEvent;", "(Lcom/segment/analytics/kotlin/core/BaseEvent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lcom/segment/analytics/kotlin/core/BaseEvent;", "putIntegrations", "removeFromContext", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EventTransformer {
    public static final BaseEvent disableCloudIntegrations(BaseEvent baseEvent, List<String> list) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, BaseEvent.ALL_INTEGRATIONS_KEY, (Boolean) false);
        if (list != null) {
            for (String str : list) {
                if (baseEvent.getIntegrations().containsKey((Object) str)) {
                    if (JsonUtils.getBoolean(baseEvent.getIntegrations(), str) != null) {
                        JsonElementBuildersKt.put(jsonObjectBuilder, str, (Boolean) true);
                    } else {
                        Object obj = baseEvent.getIntegrations().get((Object) str);
                        Intrinsics.checkNotNull(obj);
                        jsonObjectBuilder.put(str, (JsonElement) obj);
                    }
                }
            }
        }
        baseEvent.setIntegrations(jsonObjectBuilder.build());
        return baseEvent;
    }

    public static /* synthetic */ BaseEvent disableCloudIntegrations$default(BaseEvent baseEvent, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return disableCloudIntegrations(baseEvent, list);
    }

    public static final BaseEvent disableIntegration(BaseEvent baseEvent, String integrationName) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(integrationName, "integrationName");
        Json.INSTANCE.getSerializersModule();
        return putIntegrations(baseEvent, integrationName, false, BooleanSerializer.INSTANCE);
    }

    public static final BaseEvent enableCloudIntegrations(BaseEvent baseEvent, List<String> list) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, BaseEvent.ALL_INTEGRATIONS_KEY, (Boolean) true);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                JsonElementBuildersKt.put(jsonObjectBuilder, (String) it.next(), (Boolean) false);
            }
        }
        baseEvent.setIntegrations(jsonObjectBuilder.build());
        return baseEvent;
    }

    public static /* synthetic */ BaseEvent enableCloudIntegrations$default(BaseEvent baseEvent, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return enableCloudIntegrations(baseEvent, list);
    }

    public static final BaseEvent enableIntegration(BaseEvent baseEvent, String integrationName) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(integrationName, "integrationName");
        if (!baseEvent.getIntegrations().containsKey((Object) integrationName)) {
            Json.INSTANCE.getSerializersModule();
            return putIntegrations(baseEvent, integrationName, true, BooleanSerializer.INSTANCE);
        }
        Boolean bool = JsonUtils.getBoolean(baseEvent.getIntegrations(), integrationName);
        if (bool == null || bool.booleanValue()) {
            return baseEvent;
        }
        Json.INSTANCE.getSerializersModule();
        return putIntegrations(baseEvent, integrationName, true, BooleanSerializer.INSTANCE);
    }

    public static final BaseEvent putInContext(BaseEvent baseEvent, String key, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return putInContext(baseEvent, key, (JsonElement) JsonElementKt.JsonPrimitive(bool));
    }

    public static final BaseEvent putInContext(BaseEvent baseEvent, String key, Number number) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return putInContext(baseEvent, key, (JsonElement) JsonElementKt.JsonPrimitive(number));
    }

    public static final /* synthetic */ <T> BaseEvent putInContext(BaseEvent baseEvent, String key, T value) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return putInContext(baseEvent, key, value, SerializersKt.serializer(serializersModule, (KType) null));
    }

    public static final <T> BaseEvent putInContext(BaseEvent baseEvent, String key, T value, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        return putInContext(baseEvent, key, Json.INSTANCE.encodeToJsonElement(serializationStrategy, value));
    }

    public static final BaseEvent putInContext(BaseEvent baseEvent, String key, String str) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return putInContext(baseEvent, key, (JsonElement) JsonElementKt.JsonPrimitive(str));
    }

    public static final BaseEvent putInContext(BaseEvent baseEvent, String key, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, baseEvent.getContext());
        jsonObjectBuilder.put(key, jsonElement);
        baseEvent.setContext(jsonObjectBuilder.build());
        return baseEvent;
    }

    public static final /* synthetic */ <T> BaseEvent putInContextUnderKey(BaseEvent baseEvent, String parentKey, String key, T value) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return putInContextUnderKey(baseEvent, parentKey, key, value, SerializersKt.serializer(serializersModule, (KType) null));
    }

    public static final <T> BaseEvent putInContextUnderKey(BaseEvent baseEvent, String parentKey, String key, T value, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        return putInContextUnderKey(baseEvent, parentKey, key, Json.INSTANCE.encodeToJsonElement(serializationStrategy, value));
    }

    public static final BaseEvent putInContextUnderKey(BaseEvent baseEvent, String parentKey, String key, JsonElement jsonElement) {
        JsonObject emptyJsonObject;
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(parentKey, "parentKey");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonElement jsonElement2 = (JsonElement) baseEvent.getContext().get((Object) parentKey);
        if (jsonElement2 == null || (emptyJsonObject = JsonUtils.getSafeJsonObject(jsonElement2)) == null) {
            emptyJsonObject = EventsKt.getEmptyJsonObject();
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, baseEvent.getContext());
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder2, emptyJsonObject);
        jsonObjectBuilder2.put(key, jsonElement);
        jsonObjectBuilder.put(parentKey, jsonObjectBuilder2.build());
        baseEvent.setContext(jsonObjectBuilder.build());
        return baseEvent;
    }

    public static final /* synthetic */ <T> BaseEvent putIntegrations(BaseEvent baseEvent, String key, T value) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return putIntegrations(baseEvent, key, value, SerializersKt.serializer(serializersModule, (KType) null));
    }

    public static final <T> BaseEvent putIntegrations(BaseEvent baseEvent, String key, T value, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        return putIntegrations(baseEvent, key, Json.INSTANCE.encodeToJsonElement(serializationStrategy, value));
    }

    public static final BaseEvent putIntegrations(BaseEvent baseEvent, String key, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, baseEvent.getIntegrations());
        jsonObjectBuilder.put(key, jsonElement);
        baseEvent.setIntegrations(jsonObjectBuilder.build());
        return baseEvent;
    }

    public static final BaseEvent removeFromContext(BaseEvent baseEvent, String key) {
        Intrinsics.checkNotNullParameter(baseEvent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonObject context = baseEvent.getContext();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : context.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        baseEvent.setContext(new JsonObject(linkedHashMap));
        return baseEvent;
    }
}
