package com.segment.analytics.kotlin.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBA\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J4\u0010$\u001a\u0004\u0018\u0001H%\"\n\b\u0000\u0010%\u0018\u0001*\u00020\u00012\u0006\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u0002H%0)H\u0086\b¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200J\u000e\u0010.\u001a\u00020,2\u0006\u00101\u001a\u00020'J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020'HÖ\u0001J!\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:HÇ\u0001R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006="}, d2 = {"Lcom/segment/analytics/kotlin/core/Settings;", "", "seen1", "", "integrations", "Lkotlinx/serialization/json/JsonObject;", "plan", "edgeFunction", "middlewareSettings", "metrics", "consentSettings", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;)V", "getConsentSettings", "()Lkotlinx/serialization/json/JsonObject;", "setConsentSettings", "(Lkotlinx/serialization/json/JsonObject;)V", "getEdgeFunction", "setEdgeFunction", "getIntegrations", "setIntegrations", "getMetrics", "setMetrics", "getMiddlewareSettings", "setMiddlewareSettings", "getPlan", "setPlan", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "destinationSettings", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "equals", "", "other", "hasIntegrationSettings", "plugin", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", SubscriberAttributeKt.JSON_NAME_KEY, "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class Settings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private JsonObject consentSettings;
    private JsonObject edgeFunction;
    private JsonObject integrations;
    private JsonObject metrics;
    private JsonObject middlewareSettings;
    private JsonObject plan;

    /* JADX INFO: compiled from: Settings.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/Settings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/Settings;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Settings> serializer() {
            return Settings$$serializer.INSTANCE;
        }
    }

    public Settings() {
        this((JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, 63, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Settings(int i, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, JsonObject jsonObject4, JsonObject jsonObject5, JsonObject jsonObject6, SerializationConstructorMarker serializationConstructorMarker) {
        this.integrations = (i & 1) == 0 ? EventsKt.getEmptyJsonObject() : jsonObject;
        if ((i & 2) == 0) {
            this.plan = EventsKt.getEmptyJsonObject();
        } else {
            this.plan = jsonObject2;
        }
        if ((i & 4) == 0) {
            this.edgeFunction = EventsKt.getEmptyJsonObject();
        } else {
            this.edgeFunction = jsonObject3;
        }
        if ((i & 8) == 0) {
            this.middlewareSettings = EventsKt.getEmptyJsonObject();
        } else {
            this.middlewareSettings = jsonObject4;
        }
        if ((i & 16) == 0) {
            this.metrics = EventsKt.getEmptyJsonObject();
        } else {
            this.metrics = jsonObject5;
        }
        if ((i & 32) == 0) {
            this.consentSettings = EventsKt.getEmptyJsonObject();
        } else {
            this.consentSettings = jsonObject6;
        }
    }

    public Settings(JsonObject integrations, JsonObject plan, JsonObject edgeFunction, JsonObject middlewareSettings, JsonObject metrics, JsonObject consentSettings) {
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(edgeFunction, "edgeFunction");
        Intrinsics.checkNotNullParameter(middlewareSettings, "middlewareSettings");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(consentSettings, "consentSettings");
        this.integrations = integrations;
        this.plan = plan;
        this.edgeFunction = edgeFunction;
        this.middlewareSettings = middlewareSettings;
        this.metrics = metrics;
        this.consentSettings = consentSettings;
    }

    public /* synthetic */ Settings(JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, JsonObject jsonObject4, JsonObject jsonObject5, JsonObject jsonObject6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject, (i & 2) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject2, (i & 4) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject3, (i & 8) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject4, (i & 16) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject5, (i & 32) != 0 ? EventsKt.getEmptyJsonObject() : jsonObject6);
    }

    public static /* synthetic */ Settings copy$default(Settings settings, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, JsonObject jsonObject4, JsonObject jsonObject5, JsonObject jsonObject6, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = settings.integrations;
        }
        if ((i & 2) != 0) {
            jsonObject2 = settings.plan;
        }
        if ((i & 4) != 0) {
            jsonObject3 = settings.edgeFunction;
        }
        if ((i & 8) != 0) {
            jsonObject4 = settings.middlewareSettings;
        }
        if ((i & 16) != 0) {
            jsonObject5 = settings.metrics;
        }
        if ((i & 32) != 0) {
            jsonObject6 = settings.consentSettings;
        }
        JsonObject jsonObject7 = jsonObject5;
        JsonObject jsonObject8 = jsonObject6;
        return settings.copy(jsonObject, jsonObject2, jsonObject3, jsonObject4, jsonObject7, jsonObject8);
    }

    public static /* synthetic */ Object destinationSettings$default(Settings settings, String name, DeserializationStrategy strategy, int i, Object obj) {
        JsonObject safeJsonObject;
        if ((i & 2) != 0) {
            SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            strategy = SerializersKt.serializer(serializersModule, (KType) null);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        JsonElement jsonElement = (JsonElement) settings.getIntegrations().get((Object) name);
        if (jsonElement == null || (safeJsonObject = JsonUtils.getSafeJsonObject(jsonElement)) == null) {
            return null;
        }
        return JsonUtils.getLenientJson().decodeFromJsonElement(strategy, safeJsonObject);
    }

    @JvmStatic
    public static final void write$Self(Settings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.integrations, EventsKt.getEmptyJsonObject())) {
            output.encodeSerializableElement(serialDesc, 0, JsonObjectSerializer.INSTANCE, self.integrations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.plan, EventsKt.getEmptyJsonObject())) {
            output.encodeSerializableElement(serialDesc, 1, JsonObjectSerializer.INSTANCE, self.plan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.edgeFunction, EventsKt.getEmptyJsonObject())) {
            output.encodeSerializableElement(serialDesc, 2, JsonObjectSerializer.INSTANCE, self.edgeFunction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.middlewareSettings, EventsKt.getEmptyJsonObject())) {
            output.encodeSerializableElement(serialDesc, 3, JsonObjectSerializer.INSTANCE, self.middlewareSettings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.metrics, EventsKt.getEmptyJsonObject())) {
            output.encodeSerializableElement(serialDesc, 4, JsonObjectSerializer.INSTANCE, self.metrics);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.consentSettings, EventsKt.getEmptyJsonObject())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, JsonObjectSerializer.INSTANCE, self.consentSettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JsonObject getIntegrations() {
        return this.integrations;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonObject getPlan() {
        return this.plan;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonObject getEdgeFunction() {
        return this.edgeFunction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final JsonObject getMiddlewareSettings() {
        return this.middlewareSettings;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final JsonObject getMetrics() {
        return this.metrics;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final JsonObject getConsentSettings() {
        return this.consentSettings;
    }

    public final Settings copy(JsonObject integrations, JsonObject plan, JsonObject edgeFunction, JsonObject middlewareSettings, JsonObject metrics, JsonObject consentSettings) {
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(edgeFunction, "edgeFunction");
        Intrinsics.checkNotNullParameter(middlewareSettings, "middlewareSettings");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(consentSettings, "consentSettings");
        return new Settings(integrations, plan, edgeFunction, middlewareSettings, metrics, consentSettings);
    }

    public final /* synthetic */ <T> T destinationSettings(String name, DeserializationStrategy<? extends T> strategy) {
        JsonObject safeJsonObject;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        JsonElement jsonElement = (JsonElement) getIntegrations().get((Object) name);
        if (jsonElement == null || (safeJsonObject = JsonUtils.getSafeJsonObject(jsonElement)) == null) {
            return null;
        }
        return (T) JsonUtils.getLenientJson().decodeFromJsonElement(strategy, safeJsonObject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) other;
        return Intrinsics.areEqual(this.integrations, settings.integrations) && Intrinsics.areEqual(this.plan, settings.plan) && Intrinsics.areEqual(this.edgeFunction, settings.edgeFunction) && Intrinsics.areEqual(this.middlewareSettings, settings.middlewareSettings) && Intrinsics.areEqual(this.metrics, settings.metrics) && Intrinsics.areEqual(this.consentSettings, settings.consentSettings);
    }

    public final JsonObject getConsentSettings() {
        return this.consentSettings;
    }

    public final JsonObject getEdgeFunction() {
        return this.edgeFunction;
    }

    public final JsonObject getIntegrations() {
        return this.integrations;
    }

    public final JsonObject getMetrics() {
        return this.metrics;
    }

    public final JsonObject getMiddlewareSettings() {
        return this.middlewareSettings;
    }

    public final JsonObject getPlan() {
        return this.plan;
    }

    public final boolean hasIntegrationSettings(DestinationPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return hasIntegrationSettings(plugin.getKey());
    }

    public final boolean hasIntegrationSettings(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.integrations.containsKey((Object) key);
    }

    public int hashCode() {
        return (((((((((this.integrations.hashCode() * 31) + this.plan.hashCode()) * 31) + this.edgeFunction.hashCode()) * 31) + this.middlewareSettings.hashCode()) * 31) + this.metrics.hashCode()) * 31) + this.consentSettings.hashCode();
    }

    public final void setConsentSettings(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.consentSettings = jsonObject;
    }

    public final void setEdgeFunction(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.edgeFunction = jsonObject;
    }

    public final void setIntegrations(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.integrations = jsonObject;
    }

    public final void setMetrics(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.metrics = jsonObject;
    }

    public final void setMiddlewareSettings(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.middlewareSettings = jsonObject;
    }

    public final void setPlan(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.plan = jsonObject;
    }

    public String toString() {
        return "Settings(integrations=" + this.integrations + ", plan=" + this.plan + ", edgeFunction=" + this.edgeFunction + ", middlewareSettings=" + this.middlewareSettings + ", metrics=" + this.metrics + ", consentSettings=" + this.consentSettings + ')';
    }
}
