package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@SerialName(AndroidContextPlugin.SCREEN_KEY)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJB\u0099\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u000f\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0002\u0010\u0019J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\r\u0010:\u001a\u00060\bj\u0002`\tHÆ\u0003J+\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tHÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0002J\b\u0010@\u001a\u00020\u0003H\u0016J\t\u0010A\u001a\u00020\u0005HÖ\u0001J!\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HHÇ\u0001R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001e\u0010\u000e\u001a\u00060\bj\u0002`\u000fX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u0010\u001a\u00060\bj\u0002`\u0011X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\f\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001a\u0010\u0013\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0012\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!¨\u0006K"}, d2 = {"Lcom/segment/analytics/kotlin/core/ScreenEvent;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "seen1", "", "name", "", "category", DiagnosticsEntry.PROPERTIES_KEY, "Lkotlinx/serialization/json/JsonObject;", "Lcom/segment/analytics/kotlin/core/Properties;", "type", "Lcom/segment/analytics/kotlin/core/EventType;", "messageId", "anonymousId", "context", "Lcom/segment/analytics/kotlin/core/AnalyticsContext;", "integrations", "Lcom/segment/analytics/kotlin/core/Integrations;", "userId", DiagnosticsEntry.TIMESTAMP_KEY, "_metadata", "Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/segment/analytics/kotlin/core/EventType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/DestinationMetadata;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)V", "get_metadata", "()Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "set_metadata", "(Lcom/segment/analytics/kotlin/core/DestinationMetadata;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "(Ljava/lang/String;)V", "getCategory", "setCategory", "getContext", "()Lkotlinx/serialization/json/JsonObject;", "setContext", "(Lkotlinx/serialization/json/JsonObject;)V", "getIntegrations", "setIntegrations", "getMessageId", "setMessageId", "getName", "setName", "getProperties", "setProperties", "getTimestamp", "setTimestamp", "getType", "()Lcom/segment/analytics/kotlin/core/EventType;", "setType", "(Lcom/segment/analytics/kotlin/core/EventType;)V", "getUserId", "setUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class ScreenEvent extends BaseEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DestinationMetadata _metadata;
    public String anonymousId;
    private String category;
    public JsonObject context;
    public JsonObject integrations;
    public String messageId;
    private String name;
    private JsonObject properties;
    public String timestamp;
    private EventType type;
    private String userId;

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/ScreenEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ScreenEvent> serializer() {
            return ScreenEvent$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ScreenEvent(int i, String str, String str2, JsonObject jsonObject, EventType eventType, String str3, String str4, JsonObject jsonObject2, JsonObject jsonObject3, String str5, String str6, DestinationMetadata destinationMetadata, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (759 != (i & 759)) {
            PluginExceptionsKt.throwMissingFieldException(i, 759, ScreenEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.category = str2;
        this.properties = jsonObject;
        if ((i & 8) == 0) {
            this.type = EventType.Screen;
        } else {
            this.type = eventType;
        }
        this.messageId = str3;
        this.anonymousId = str4;
        this.context = jsonObject2;
        this.integrations = jsonObject3;
        if ((i & 256) == 0) {
            this.userId = "";
        } else {
            this.userId = str5;
        }
        this.timestamp = str6;
        if ((i & 1024) == 0) {
            this._metadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        } else {
            this._metadata = destinationMetadata;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenEvent(String name, String category, JsonObject properties) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.name = name;
        this.category = category;
        this.properties = properties;
        this.type = EventType.Screen;
        this.userId = "";
        this._metadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ScreenEvent copy$default(ScreenEvent screenEvent, String str, String str2, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = screenEvent.name;
        }
        if ((i & 2) != 0) {
            str2 = screenEvent.category;
        }
        if ((i & 4) != 0) {
            jsonObject = screenEvent.properties;
        }
        return screenEvent.copy(str, str2, jsonObject);
    }

    @JvmStatic
    public static final void write$Self(ScreenEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.category);
        output.encodeSerializableElement(serialDesc, 2, JsonObjectSerializer.INSTANCE, self.properties);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getType() != EventType.Screen) {
            output.encodeSerializableElement(serialDesc, 3, EventType.INSTANCE.serializer(), self.getType());
        }
        output.encodeStringElement(serialDesc, 4, self.getMessageId());
        output.encodeStringElement(serialDesc, 5, self.getAnonymousId());
        output.encodeSerializableElement(serialDesc, 6, JsonObjectSerializer.INSTANCE, self.getContext());
        output.encodeSerializableElement(serialDesc, 7, JsonObjectSerializer.INSTANCE, self.getIntegrations());
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.getUserId(), "")) {
            output.encodeStringElement(serialDesc, 8, self.getUserId());
        }
        output.encodeStringElement(serialDesc, 9, self.getTimestamp());
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && Intrinsics.areEqual(self.get_metadata(), new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null))) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 10, DestinationMetadata$$serializer.INSTANCE, self.get_metadata());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JsonObject getProperties() {
        return this.properties;
    }

    public final ScreenEvent copy(String name, String category, JsonObject properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new ScreenEvent(name, category, properties);
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.ScreenEvent");
        ScreenEvent screenEvent = (ScreenEvent) other;
        return Intrinsics.areEqual(this.name, screenEvent.name) && Intrinsics.areEqual(this.category, screenEvent.category) && Intrinsics.areEqual(this.properties, screenEvent.properties);
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public String getAnonymousId() {
        String str = this.anonymousId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anonymousId");
        return null;
    }

    public final String getCategory() {
        return this.category;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public JsonObject getContext() {
        JsonObject jsonObject = this.context;
        if (jsonObject != null) {
            return jsonObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public JsonObject getIntegrations() {
        JsonObject jsonObject = this.integrations;
        if (jsonObject != null) {
            return jsonObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("integrations");
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public String getMessageId() {
        String str = this.messageId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("messageId");
        return null;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonObject getProperties() {
        return this.properties;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public String getTimestamp() {
        String str = this.timestamp;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DiagnosticsEntry.TIMESTAMP_KEY);
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public String getUserId() {
        return this.userId;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public DestinationMetadata get_metadata() {
        return this._metadata;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.name.hashCode()) * 31) + this.category.hashCode()) * 31) + this.properties.hashCode();
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setAnonymousId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anonymousId = str;
    }

    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setContext(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.context = jsonObject;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setIntegrations(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.integrations = jsonObject;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setMessageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageId = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setProperties(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.properties = jsonObject;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setTimestamp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timestamp = str;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setType(EventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "<set-?>");
        this.type = eventType;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void set_metadata(DestinationMetadata destinationMetadata) {
        Intrinsics.checkNotNullParameter(destinationMetadata, "<set-?>");
        this._metadata = destinationMetadata;
    }

    public String toString() {
        return "ScreenEvent(name=" + this.name + ", category=" + this.category + ", properties=" + this.properties + ')';
    }
}
