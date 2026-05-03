package com.segment.analytics.kotlin.core.compat;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.compat.Builders;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/Builders;", "", "()V", "Companion", "JsonArrayBuilder", "JsonDslMarker", "JsonObjectBuilder", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Builders {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: Builders.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006H\u0007J!\u0010\b\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000e0\u0006H\u0007J!\u0010\u000f\u001a\u00020\r2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0007¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/Builders$Companion;", "", "()V", "buildJsonArray", "Lkotlinx/serialization/json/JsonArray;", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/util/function/Consumer;", "Lcom/segment/analytics/kotlin/core/compat/Builders$JsonArrayBuilder;", "buildJsonArrayFunc", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "buildJsonObject", "Lkotlinx/serialization/json/JsonObject;", "Lcom/segment/analytics/kotlin/core/compat/Builders$JsonObjectBuilder;", "buildJsonObjectFunc", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final JsonArray buildJsonArray(Consumer<? super JsonArrayBuilder> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return buildJsonArrayFunc(new Builders$Companion$buildJsonArray$1(action));
        }

        @JvmStatic
        public final JsonArray buildJsonArrayFunc(Function1<? super JsonArrayBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
            action.invoke(jsonArrayBuilder);
            return jsonArrayBuilder.build$core();
        }

        @JvmStatic
        public final JsonObject buildJsonObject(Consumer<? super JsonObjectBuilder> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return buildJsonObjectFunc(new Builders$Companion$buildJsonObject$1(action));
        }

        @JvmStatic
        public final JsonObject buildJsonObjectFunc(Function1<? super JsonObjectBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            action.invoke(jsonObjectBuilder);
            return jsonObjectBuilder.build$core();
        }
    }

    /* JADX INFO: compiled from: Builders.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u000eJ\u001f\u0010\u000f\u001a\u00020\u00002\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00140\u000eJ\u001f\u0010\u0015\u001a\u00020\u00002\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/Builders$JsonArrayBuilder;", "", "()V", FirebaseAnalytics.Param.CONTENT, "", "Lkotlinx/serialization/json/JsonElement;", "add", "element", "", "(Ljava/lang/Boolean;)Lcom/segment/analytics/kotlin/core/compat/Builders$JsonArrayBuilder;", "", "", "addJsonArray", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/util/function/Consumer;", "addJsonArrayFunc", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "addJsonObject", "Lcom/segment/analytics/kotlin/core/compat/Builders$JsonObjectBuilder;", "addJsonObjectFunc", "build", "Lkotlinx/serialization/json/JsonArray;", "build$core", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JsonDslMarker
    public static final class JsonArrayBuilder {
        private final List<JsonElement> content = new ArrayList();

        static final void addJsonArrayFunc$lambda$9$lambda$8(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        static final void addJsonObjectFunc$lambda$7$lambda$6(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        public final JsonArrayBuilder add(Boolean element) {
            add(JsonElementKt.JsonPrimitive(element));
            return this;
        }

        public final JsonArrayBuilder add(Number element) {
            add(JsonElementKt.JsonPrimitive(element));
            return this;
        }

        public final JsonArrayBuilder add(String element) {
            add(JsonElementKt.JsonPrimitive(element));
            return this;
        }

        public final JsonArrayBuilder add(JsonElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            this.content.add(element);
            return this;
        }

        public final JsonArrayBuilder addJsonArray(Consumer<? super JsonArrayBuilder> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            add(Builders.INSTANCE.buildJsonArray(action));
            return this;
        }

        public final JsonArrayBuilder addJsonArrayFunc(final Function1<? super JsonArrayBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            add(Builders.INSTANCE.buildJsonArray(new Consumer() { // from class: com.segment.analytics.kotlin.core.compat.Builders$JsonArrayBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Builders.JsonArrayBuilder.addJsonArrayFunc$lambda$9$lambda$8(action, obj);
                }
            }));
            return this;
        }

        public final JsonArrayBuilder addJsonObject(Consumer<? super JsonObjectBuilder> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            add(Builders.INSTANCE.buildJsonObject(action));
            return this;
        }

        public final JsonArrayBuilder addJsonObjectFunc(final Function1<? super JsonObjectBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            add(Builders.INSTANCE.buildJsonObject(new Consumer() { // from class: com.segment.analytics.kotlin.core.compat.Builders$JsonArrayBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Builders.JsonArrayBuilder.addJsonObjectFunc$lambda$7$lambda$6(action, obj);
                }
            }));
            return this;
        }

        public final JsonArray build$core() {
            return new JsonArray(this.content);
        }
    }

    /* JADX INFO: compiled from: Builders.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/Builders$JsonDslMarker;", "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public @interface JsonDslMarker {
    }

    /* JADX INFO: compiled from: Builders.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00140\u0013J'\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018J\u001e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u0013J'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/Builders$JsonObjectBuilder;", "", "()V", FirebaseAnalytics.Param.CONTENT, "", "", "Lkotlinx/serialization/json/JsonElement;", "build", "Lkotlinx/serialization/json/JsonObject;", "build$core", "put", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/segment/analytics/kotlin/core/compat/Builders$JsonObjectBuilder;", "", "element", "putJsonArray", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/util/function/Consumer;", "Lcom/segment/analytics/kotlin/core/compat/Builders$JsonArrayBuilder;", "putJsonArrayFunc", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "putJsonObject", "putJsonObjectFunc", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JsonDslMarker
    public static final class JsonObjectBuilder {
        private final Map<String, JsonElement> content = new LinkedHashMap();

        static final void putJsonArrayFunc$lambda$9$lambda$8(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        static final void putJsonObjectFunc$lambda$7$lambda$6(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        public final JsonObject build$core() {
            return new JsonObject(this.content);
        }

        public final JsonObjectBuilder put(String key, Boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, JsonElementKt.JsonPrimitive(value));
            return this;
        }

        public final JsonObjectBuilder put(String key, Number value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, JsonElementKt.JsonPrimitive(value));
            return this;
        }

        public final JsonObjectBuilder put(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            put(key, JsonElementKt.JsonPrimitive(value));
            return this;
        }

        public final JsonObjectBuilder put(String key, JsonElement element) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(element, "element");
            this.content.put(key, element);
            return this;
        }

        public final JsonObjectBuilder putJsonArray(String key, Consumer<? super JsonArrayBuilder> action) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(action, "action");
            put(key, Builders.INSTANCE.buildJsonArray(action));
            return this;
        }

        public final JsonObjectBuilder putJsonArrayFunc(String key, final Function1<? super JsonArrayBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(action, "action");
            put(key, Builders.INSTANCE.buildJsonArray(new Consumer() { // from class: com.segment.analytics.kotlin.core.compat.Builders$JsonObjectBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Builders.JsonObjectBuilder.putJsonArrayFunc$lambda$9$lambda$8(action, obj);
                }
            }));
            return this;
        }

        public final JsonObjectBuilder putJsonObject(String key, Consumer<? super JsonObjectBuilder> action) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(action, "action");
            put(key, Builders.INSTANCE.buildJsonObject(action));
            return this;
        }

        public final JsonObjectBuilder putJsonObjectFunc(String key, final Function1<? super JsonObjectBuilder, Unit> action) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(action, "action");
            put(key, Builders.INSTANCE.buildJsonObject(new Consumer() { // from class: com.segment.analytics.kotlin.core.compat.Builders$JsonObjectBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Builders.JsonObjectBuilder.putJsonObjectFunc$lambda$7$lambda$6(action, obj);
                }
            }));
            return this;
        }
    }

    @JvmStatic
    public static final JsonArray buildJsonArray(Consumer<? super JsonArrayBuilder> consumer) {
        return INSTANCE.buildJsonArray(consumer);
    }

    @JvmStatic
    public static final JsonArray buildJsonArrayFunc(Function1<? super JsonArrayBuilder, Unit> function1) {
        return INSTANCE.buildJsonArrayFunc(function1);
    }

    @JvmStatic
    public static final JsonObject buildJsonObject(Consumer<? super JsonObjectBuilder> consumer) {
        return INSTANCE.buildJsonObject(consumer);
    }

    @JvmStatic
    public static final JsonObject buildJsonObjectFunc(Function1<? super JsonObjectBuilder, Unit> function1) {
        return INSTANCE.buildJsonObjectFunc(function1);
    }
}
