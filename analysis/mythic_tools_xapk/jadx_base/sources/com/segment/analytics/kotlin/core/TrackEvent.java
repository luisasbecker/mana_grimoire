package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
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
@SerialName("track")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u008f\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e\u0012\u000e\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017B\u0019\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u0018J\r\u00105\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J!\u00107\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\b\u0010<\u001a\u00020\u0003H\u0016J\t\u0010=\u001a\u00020\bHÖ\u0001J!\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DHÇ\u0001R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000f\u001a\u00060\u0005j\u0002`\u0010X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010\r\u001a\u00060\u0005j\u0002`\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010\u000b\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001e\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u0014\u001a\u00020\bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0011\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 ¨\u0006G"}, d2 = {"Lcom/segment/analytics/kotlin/core/TrackEvent;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "seen1", "", DiagnosticsEntry.PROPERTIES_KEY, "Lkotlinx/serialization/json/JsonObject;", "Lcom/segment/analytics/kotlin/core/Properties;", NotificationCompat.CATEGORY_EVENT, "", "type", "Lcom/segment/analytics/kotlin/core/EventType;", "messageId", "anonymousId", "integrations", "Lcom/segment/analytics/kotlin/core/Integrations;", "context", "Lcom/segment/analytics/kotlin/core/AnalyticsContext;", "userId", "_metadata", "Lcom/segment/analytics/kotlin/core/DestinationMetadata;", DiagnosticsEntry.TIMESTAMP_KEY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/EventType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/DestinationMetadata;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "get_metadata", "()Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "set_metadata", "(Lcom/segment/analytics/kotlin/core/DestinationMetadata;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "(Ljava/lang/String;)V", "getContext", "()Lkotlinx/serialization/json/JsonObject;", "setContext", "(Lkotlinx/serialization/json/JsonObject;)V", "getEvent", "setEvent", "getIntegrations", "setIntegrations", "getMessageId", "setMessageId", "getProperties", "setProperties", "getTimestamp", "setTimestamp", "getType", "()Lcom/segment/analytics/kotlin/core/EventType;", "setType", "(Lcom/segment/analytics/kotlin/core/EventType;)V", "getUserId", "setUserId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class TrackEvent extends BaseEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DestinationMetadata _metadata;
    public String anonymousId;
    public JsonObject context;
    private String event;
    public JsonObject integrations;
    public String messageId;
    private JsonObject properties;
    public String timestamp;
    private EventType type;
    private String userId;

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/TrackEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TrackEvent> serializer() {
            return TrackEvent$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TrackEvent(int i, JsonObject jsonObject, String str, EventType eventType, String str2, String str3, JsonObject jsonObject2, JsonObject jsonObject3, String str4, DestinationMetadata destinationMetadata, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (635 != (i & 635)) {
            PluginExceptionsKt.throwMissingFieldException(i, 635, TrackEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.properties = jsonObject;
        this.event = str;
        if ((i & 4) == 0) {
            this.type = EventType.Track;
        } else {
            this.type = eventType;
        }
        this.messageId = str2;
        this.anonymousId = str3;
        this.integrations = jsonObject2;
        this.context = jsonObject3;
        if ((i & 128) == 0) {
            this.userId = "";
        } else {
            this.userId = str4;
        }
        if ((i & 256) == 0) {
            this._metadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        } else {
            this._metadata = destinationMetadata;
        }
        this.timestamp = str5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackEvent(JsonObject properties, String event) {
        super(null);
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(event, "event");
        this.properties = properties;
        this.event = event;
        this.type = EventType.Track;
        this.userId = "";
        this._metadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TrackEvent copy$default(TrackEvent trackEvent, JsonObject jsonObject, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = trackEvent.properties;
        }
        if ((i & 2) != 0) {
            str = trackEvent.event;
        }
        return trackEvent.copy(jsonObject, str);
    }

    @JvmStatic
    public static final void write$Self(TrackEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeSerializableElement(serialDesc, 0, JsonObjectSerializer.INSTANCE, self.properties);
        output.encodeStringElement(serialDesc, 1, self.event);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getType() != EventType.Track) {
            output.encodeSerializableElement(serialDesc, 2, EventType.INSTANCE.serializer(), self.getType());
        }
        output.encodeStringElement(serialDesc, 3, self.getMessageId());
        output.encodeStringElement(serialDesc, 4, self.getAnonymousId());
        output.encodeSerializableElement(serialDesc, 5, JsonObjectSerializer.INSTANCE, self.getIntegrations());
        output.encodeSerializableElement(serialDesc, 6, JsonObjectSerializer.INSTANCE, self.getContext());
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.getUserId(), "")) {
            output.encodeStringElement(serialDesc, 7, self.getUserId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.get_metadata(), new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 8, DestinationMetadata$$serializer.INSTANCE, self.get_metadata());
        }
        output.encodeStringElement(serialDesc, 9, self.getTimestamp());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JsonObject getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    public final TrackEvent copy(JsonObject properties, String event) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(event, "event");
        return new TrackEvent(properties, event);
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.TrackEvent");
        TrackEvent trackEvent = (TrackEvent) other;
        return Intrinsics.areEqual(this.properties, trackEvent.properties) && Intrinsics.areEqual(this.event, trackEvent.event);
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

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public JsonObject getContext() {
        JsonObject jsonObject = this.context;
        if (jsonObject != null) {
            return jsonObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final String getEvent() {
        return this.event;
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
        return (((super.hashCode() * 31) + this.properties.hashCode()) * 31) + this.event.hashCode();
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setAnonymousId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.anonymousId = str;
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setContext(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.context = jsonObject;
    }

    public final void setEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.event = str;
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
        return "TrackEvent(properties=" + this.properties + ", event=" + this.event + ')';
    }
}
