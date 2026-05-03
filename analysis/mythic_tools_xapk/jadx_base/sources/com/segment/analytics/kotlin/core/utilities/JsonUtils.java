package com.segment.analytics.kotlin.core.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.AliasEvent;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.GroupEvent;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.TrackEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: JSON.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010&\n\u0002\b\u0004\u001a-\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\n\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0\bH\u0086\b\u001a.\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#\u0012\u0004\u0012\u00020%0\"\u001a\u0019\u0010&\u001a\u0004\u0018\u00010'*\u00020\u00152\u0006\u0010(\u001a\u00020$¢\u0006\u0002\u0010)\u001a\u0019\u0010*\u001a\u0004\u0018\u00010+*\u00020\u00152\u0006\u0010(\u001a\u00020$¢\u0006\u0002\u0010,\u001a\u0019\u0010-\u001a\u0004\u0018\u00010.*\u00020\u00152\u0006\u0010(\u001a\u00020$¢\u0006\u0002\u0010/\u001a\u0019\u00100\u001a\u0004\u0018\u000101*\u00020\u00152\u0006\u0010(\u001a\u00020$¢\u0006\u0002\u00102\u001a(\u00103\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0018\u000104*\u00020\u00152\u0006\u0010(\u001a\u00020$\u001a\u0014\u00105\u001a\u0004\u0018\u00010$*\u00020\u00152\u0006\u0010(\u001a\u00020$\u001a\u001a\u00106\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000107*\u00020\u00152\u0006\u0010(\u001a\u00020$\u001aZ\u00108\u001a\u00020\u0010*\u00020\u00102\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u00072:\b\u0002\u0010:\u001a4\u0012\u0013\u0012\u00110$¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0011\u0018\u00010;\u001aZ\u00108\u001a\u00020\u0015*\u00020\u00152\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u00072:\b\u0002\u0010:\u001a4\u0012\u0013\u0012\u00110$¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0011\u0018\u00010;\u001a\u0012\u0010>\u001a\u00020%*\u00020?2\u0006\u0010@\u001a\u00020\u0015\u001a\u001e\u0010A\u001a\u0004\u0018\u00010\u0011*\u00020?2\u0006\u0010(\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010B\u001a)\u0010C\u001a\u00020%*\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#2\u0006\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020'H\u0086\u0002\u001a)\u0010C\u001a\u00020%*\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#2\u0006\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020DH\u0086\u0002\u001a+\u0010C\u001a\u00020%*\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#2\u0006\u0010(\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010$H\u0086\u0002\u001a\f\u0010E\u001a\u0004\u0018\u00010F*\u00020\u0015\u001a\u0012\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t04*\u00020\u0010\u001a\f\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0011\u001a\u0018\u0010G\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007*\u00020\u0015\u001a\f\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0019\u001a\n\u0010H\u001a\u00020\u0011*\u00020\t\u001a\u0015\u0010H\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\t0I¢\u0006\u0002\u0010J\u001a\u0016\u0010H\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0K\u001a\u001c\u0010H\u001a\u00020\u0011*\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0L\u001a\u0010\u0010H\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\t0M\u001a\u0016\u0010H\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0N\u001a\u0016\u0010H\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\t0\u0007\u001a\u001e\u0010O\u001a\u00020\u0015*\u00020\u00152\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\"\u001a\u001e\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\"\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"3\u0010\u0006\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\n0\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006R"}, d2 = {"EncodeDefaultsJson", "Lkotlinx/serialization/json/Json;", "getEncodeDefaultsJson", "()Lkotlinx/serialization/json/Json;", "LenientJson", "getLenientJson", "primitiveSerializers", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "getPrimitiveSerializers$annotations", "()V", "getPrimitiveSerializers", "()Ljava/util/Map;", "safeJsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "getSafeJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "safeJsonObject", "Lkotlinx/serialization/json/JsonObject;", "getSafeJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "safeJsonPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getSafeJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "serializerFor", ExifInterface.GPS_DIRECTION_TRUE, "value", "updateJsonObject", "jsonObject", "closure", "Lkotlin/Function1;", "", "", "", "getBoolean", "", SubscriberAttributeKt.JSON_NAME_KEY, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getDouble", "", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Double;", "getInt", "", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "getMapList", "", "getString", "getStringSet", "", "mapTransform", "keyMapper", "valueTransform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "putAll", "Lkotlinx/serialization/json/JsonObjectBuilder;", "obj", "putUndefinedIfNull", "", "set", "", "toBaseEvent", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "toContent", "toJsonElement", "", "([Ljava/lang/Object;)Lkotlinx/serialization/json/JsonArray;", "Lkotlin/Pair;", "Lkotlin/Triple;", "", "", "transformKeys", "transform", "transformValues", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonUtils {
    private static final Json EncodeDefaultsJson = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.JsonUtils$EncodeDefaultsJson$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setEncodeDefaults(true);
        }
    }, 1, null);
    private static final Json LenientJson = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.segment.analytics.kotlin.core.utilities.JsonUtils$LenientJson$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setLenient(true);
        }
    }, 1, null);
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> primitiveSerializers = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Character.TYPE), BuiltinSerializersKt.serializer(CharCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), BuiltinSerializersKt.CharArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), BuiltinSerializersKt.DoubleArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), BuiltinSerializersKt.FloatArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), BuiltinSerializersKt.LongArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), BuiltinSerializersKt.IntArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Short.TYPE), BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), BuiltinSerializersKt.ShortArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Byte.TYPE), BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), BuiltinSerializersKt.ByteArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), BuiltinSerializersKt.serializer(Unit.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UInt.class), BuiltinSerializersKt.serializer(UInt.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(ULong.class), BuiltinSerializersKt.serializer(ULong.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UByte.class), BuiltinSerializersKt.serializer(UByte.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(UShort.class), BuiltinSerializersKt.serializer(UShort.INSTANCE)));

    public static final Boolean getBoolean(JsonObject jsonObject, String key) {
        JsonPrimitive safeJsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonPrimitive = getSafeJsonPrimitive(jsonElement)) == null) {
            return null;
        }
        return JsonElementKt.getBooleanOrNull(safeJsonPrimitive);
    }

    public static final Double getDouble(JsonObject jsonObject, String key) {
        JsonPrimitive safeJsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonPrimitive = getSafeJsonPrimitive(jsonElement)) == null) {
            return null;
        }
        return JsonElementKt.getDoubleOrNull(safeJsonPrimitive);
    }

    public static final Json getEncodeDefaultsJson() {
        return EncodeDefaultsJson;
    }

    public static final Integer getInt(JsonObject jsonObject, String key) {
        JsonPrimitive safeJsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonPrimitive = getSafeJsonPrimitive(jsonElement)) == null) {
            return null;
        }
        return JsonElementKt.getIntOrNull(safeJsonPrimitive);
    }

    public static final Json getLenientJson() {
        return LenientJson;
    }

    public static final Long getLong(JsonObject jsonObject, String key) {
        JsonPrimitive safeJsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonPrimitive = getSafeJsonPrimitive(jsonElement)) == null) {
            return null;
        }
        return JsonElementKt.getLongOrNull(safeJsonPrimitive);
    }

    public static final List<Map<String, Object>> getMapList(JsonObject jsonObject, String key) {
        JsonArray safeJsonArray;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonArray = getSafeJsonArray(jsonElement)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement2 : safeJsonArray) {
            if (jsonElement2 instanceof JsonObject) {
                arrayList.add(jsonElement2);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(toContent(JsonElementKt.getJsonObject((JsonObject) it.next())));
        }
        return arrayList3;
    }

    public static final Map<KClass<? extends Object>, KSerializer<? extends Object>> getPrimitiveSerializers() {
        return primitiveSerializers;
    }

    public static /* synthetic */ void getPrimitiveSerializers$annotations() {
    }

    public static final JsonArray getSafeJsonArray(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonArray) {
            return (JsonArray) jsonElement;
        }
        return null;
    }

    public static final JsonObject getSafeJsonObject(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    public static final JsonPrimitive getSafeJsonPrimitive(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElement;
        }
        return null;
    }

    public static final String getString(JsonObject jsonObject, String key) {
        JsonPrimitive safeJsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonPrimitive = getSafeJsonPrimitive(jsonElement)) == null) {
            return null;
        }
        return JsonElementKt.getContentOrNull(safeJsonPrimitive);
    }

    public static final Set<String> getStringSet(JsonObject jsonObject, String key) {
        JsonArray safeJsonArray;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) key);
        if (jsonElement == null || (safeJsonArray = getSafeJsonArray(jsonElement)) == null) {
            return null;
        }
        JsonArray jsonArray = safeJsonArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(toContent(it.next())));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final JsonArray mapTransform(JsonArray jsonArray, Map<String, String> keyMapper, Function2<? super String, ? super JsonElement, ? extends JsonElement> function2) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        Intrinsics.checkNotNullParameter(keyMapper, "keyMapper");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        for (JsonArray jsonArrayMapTransform : jsonArray) {
            if (jsonArrayMapTransform instanceof JsonObject) {
                jsonArrayMapTransform = mapTransform((JsonObject) jsonArrayMapTransform, keyMapper, function2);
            } else if (jsonArrayMapTransform instanceof JsonArray) {
                jsonArrayMapTransform = mapTransform((JsonArray) jsonArrayMapTransform, keyMapper, function2);
            }
            jsonArrayBuilder.add(jsonArrayMapTransform);
        }
        return jsonArrayBuilder.build();
    }

    public static final JsonObject mapTransform(JsonObject jsonObject, Map<String, String> keyMapper, Function2<? super String, ? super JsonElement, ? extends JsonElement> function2) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(keyMapper, "keyMapper");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonArray value = entry.getValue();
            String str = keyMapper.get(key);
            if (str != null) {
                key = str;
            }
            if (value instanceof JsonObject) {
                value = mapTransform((JsonObject) value, keyMapper, function2);
            } else if (value instanceof JsonArray) {
                value = mapTransform((JsonArray) value, keyMapper, function2);
            }
            if (!(value instanceof JsonObject) && function2 != null) {
                value = function2.invoke(key, value);
            }
            jsonObjectBuilder.put(key, value);
        }
        return jsonObjectBuilder.build();
    }

    public static /* synthetic */ JsonArray mapTransform$default(JsonArray jsonArray, Map map, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return mapTransform(jsonArray, (Map<String, String>) map, (Function2<? super String, ? super JsonElement, ? extends JsonElement>) function2);
    }

    public static /* synthetic */ JsonObject mapTransform$default(JsonObject jsonObject, Map map, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return mapTransform(jsonObject, (Map<String, String>) map, (Function2<? super String, ? super JsonElement, ? extends JsonElement>) function2);
    }

    public static final void putAll(JsonObjectBuilder jsonObjectBuilder, JsonObject obj) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(obj, "obj");
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            jsonObjectBuilder.put(entry.getKey(), entry.getValue());
        }
    }

    public static final JsonElement putUndefinedIfNull(JsonObjectBuilder jsonObjectBuilder, String key, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (charSequence == null || charSequence.length() == 0) ? JsonElementBuildersKt.put(jsonObjectBuilder, key, "undefined") : JsonElementBuildersKt.put(jsonObjectBuilder, key, charSequence.toString());
    }

    public static final /* synthetic */ <T> KSerializer<T> serializerFor(KClass<? extends T> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer<T> kSerializer = (KSerializer) getPrimitiveSerializers().get(value);
        if (kSerializer == null) {
            return null;
        }
        return kSerializer;
    }

    public static final void set(Map<String, JsonElement> map, String key, Number value) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        map.put(key, JsonElementKt.JsonPrimitive(value));
    }

    public static final void set(Map<String, JsonElement> map, String key, String str) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (str == null) {
            map.remove(key);
        } else {
            map.put(key, JsonElementKt.JsonPrimitive(str));
        }
    }

    public static final void set(Map<String, JsonElement> map, String key, boolean z) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        map.put(key, JsonElementKt.JsonPrimitive(Boolean.valueOf(z)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final BaseEvent toBaseEvent(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        String string = getString(jsonObject, "type");
        if (string == null) {
            return null;
        }
        switch (string.hashCode()) {
            case -907689876:
                if (string.equals(AndroidContextPlugin.SCREEN_KEY)) {
                    return (BaseEvent) LenientJson.decodeFromJsonElement(ScreenEvent.INSTANCE.serializer(), jsonObject);
                }
                return null;
            case -135762164:
                if (string.equals("identify")) {
                    return (BaseEvent) LenientJson.decodeFromJsonElement(IdentifyEvent.INSTANCE.serializer(), jsonObject);
                }
                return null;
            case 92902992:
                if (string.equals("alias")) {
                    return (BaseEvent) LenientJson.decodeFromJsonElement(AliasEvent.INSTANCE.serializer(), jsonObject);
                }
                return null;
            case 98629247:
                if (string.equals("group")) {
                    return (BaseEvent) LenientJson.decodeFromJsonElement(GroupEvent.INSTANCE.serializer(), jsonObject);
                }
                return null;
            case 110621003:
                if (string.equals("track")) {
                    return (BaseEvent) LenientJson.decodeFromJsonElement(TrackEvent.INSTANCE.serializer(), jsonObject);
                }
                return null;
            default:
                return null;
        }
    }

    public static final Object toContent(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonPrimitive) {
            return toContent((JsonPrimitive) jsonElement);
        }
        if (jsonElement instanceof JsonObject) {
            return toContent((JsonObject) jsonElement);
        }
        if (jsonElement instanceof JsonArray) {
            return toContent((JsonArray) jsonElement);
        }
        return null;
    }

    public static final Object toContent(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
        if (booleanOrNull != null) {
            return Boolean.valueOf(booleanOrNull.booleanValue());
        }
        Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
        if (intOrNull != null) {
            return Integer.valueOf(intOrNull.intValue());
        }
        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
        if (longOrNull != null) {
            return Long.valueOf(longOrNull.longValue());
        }
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
        return doubleOrNull != null ? Double.valueOf(doubleOrNull.doubleValue()) : JsonElementKt.getContentOrNull(jsonPrimitive);
    }

    public static final List<Object> toContent(JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        JsonArray jsonArray2 = jsonArray;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
        Iterator<JsonElement> it = jsonArray2.iterator();
        while (it.hasNext()) {
            arrayList.add(toContent(it.next()));
        }
        return arrayList;
    }

    public static final Map<String, Object> toContent(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), toContent((JsonElement) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final JsonArray toJsonElement(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        for (Object obj : collection) {
            if (obj instanceof JsonElement) {
                jsonArrayBuilder.add((JsonElement) obj);
            } else {
                jsonArrayBuilder.add(toJsonElement(obj));
            }
        }
        return jsonArrayBuilder.build();
    }

    public static final JsonArray toJsonElement(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        for (Object obj : objArr) {
            if (obj instanceof JsonElement) {
                jsonArrayBuilder.add((JsonElement) obj);
            } else {
                jsonArrayBuilder.add(toJsonElement(obj));
            }
        }
        return jsonArrayBuilder.build();
    }

    public static final JsonElement toJsonElement(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof Map) {
            return toJsonElement((Map<String, ? extends Object>) obj);
        }
        if (obj instanceof Object[]) {
            return toJsonElement((Object[]) obj);
        }
        if (obj instanceof Collection) {
            return toJsonElement((Collection<? extends Object>) obj);
        }
        if (obj instanceof Pair) {
            return toJsonElement((Pair<? extends Object, ? extends Object>) obj);
        }
        if (obj instanceof Triple) {
            return toJsonElement((Triple<? extends Object, ? extends Object, ? extends Object>) obj);
        }
        if (obj instanceof Map.Entry) {
            return toJsonElement((Map.Entry<? extends Object, ? extends Object>) obj);
        }
        KSerializer<? extends Object> kSerializer = getPrimitiveSerializers().get(Reflection.getOrCreateKotlinClass(obj.getClass()));
        if (kSerializer == null) {
            kSerializer = null;
        } else {
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of com.segment.analytics.kotlin.core.utilities.JsonUtils.serializerFor>");
        }
        return kSerializer != null ? Json.INSTANCE.encodeToJsonElement(kSerializer, obj) : JsonNull.INSTANCE;
    }

    public static final JsonElement toJsonElement(Map.Entry<? extends Object, ? extends Object> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        JsonElement jsonElement = toJsonElement(entry.getKey());
        JsonElement jsonElement2 = toJsonElement(entry.getValue());
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.put(SubscriberAttributeKt.JSON_NAME_KEY, jsonElement);
        jsonObjectBuilder.put("value", jsonElement2);
        return jsonObjectBuilder.build();
    }

    public static final JsonElement toJsonElement(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonElement) {
                jsonObjectBuilder.put(key, (JsonElement) value);
            } else {
                jsonObjectBuilder.put(key, toJsonElement(value));
            }
        }
        return jsonObjectBuilder.build();
    }

    public static final JsonElement toJsonElement(Pair<? extends Object, ? extends Object> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        JsonElement jsonElement = toJsonElement(pair.getFirst());
        JsonElement jsonElement2 = toJsonElement(pair.getSecond());
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.put("first", jsonElement);
        jsonObjectBuilder.put("second", jsonElement2);
        return jsonObjectBuilder.build();
    }

    public static final JsonElement toJsonElement(Triple<? extends Object, ? extends Object, ? extends Object> triple) {
        Intrinsics.checkNotNullParameter(triple, "<this>");
        JsonElement jsonElement = toJsonElement(triple.getFirst());
        JsonElement jsonElement2 = toJsonElement(triple.getSecond());
        JsonElement jsonElement3 = toJsonElement(triple.getThird());
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.put("first", jsonElement);
        jsonObjectBuilder.put("second", jsonElement2);
        jsonObjectBuilder.put("third", jsonElement3);
        return jsonObjectBuilder.build();
    }

    public static final JsonObject transformKeys(JsonObject jsonObject, Function1<? super String, String> transform) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(transform.invoke(entry.getKey()), entry.getValue());
        }
        return new JsonObject(linkedHashMap);
    }

    public static final JsonObject transformValues(JsonObject jsonObject, Function1<? super JsonElement, ? extends JsonElement> transform) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), transform.invoke(entry.getValue()));
        }
        return new JsonObject(linkedHashMap);
    }

    public static final JsonObject updateJsonObject(JsonObject jsonObject, Function1<? super Map<String, JsonElement>, Unit> closure) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(closure, "closure");
        Map mutableMap = MapsKt.toMutableMap(jsonObject);
        closure.invoke(mutableMap);
        return new JsonObject(mutableMap);
    }
}
