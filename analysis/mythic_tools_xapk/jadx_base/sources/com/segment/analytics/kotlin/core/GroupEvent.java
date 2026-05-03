package com.segment.analytics.kotlin.core;

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
@SerialName("group")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u008f\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e\u0012\u000e\u0010\u000f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\u0002\u0010\u0018J\t\u00105\u001a\u00020\u0005HÆ\u0003J\r\u00106\u001a\u00060\u0007j\u0002`\bHÆ\u0003J!\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\bHÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\b\u0010<\u001a\u00020\u0003H\u0016J\t\u0010=\u001a\u00020\u0005HÖ\u0001J!\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DHÇ\u0001R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000f\u001a\u00060\u0007j\u0002`\u0010X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010\r\u001a\u00060\u0007j\u0002`\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010\u000b\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001e\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 ¨\u0006G"}, d2 = {"Lcom/segment/analytics/kotlin/core/GroupEvent;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "seen1", "", "groupId", "", "traits", "Lkotlinx/serialization/json/JsonObject;", "Lcom/segment/analytics/kotlin/core/Traits;", "type", "Lcom/segment/analytics/kotlin/core/EventType;", "messageId", "anonymousId", "integrations", "Lcom/segment/analytics/kotlin/core/Integrations;", "context", "Lcom/segment/analytics/kotlin/core/AnalyticsContext;", "userId", "_metadata", "Lcom/segment/analytics/kotlin/core/DestinationMetadata;", DiagnosticsEntry.TIMESTAMP_KEY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/segment/analytics/kotlin/core/EventType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/DestinationMetadata;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)V", "get_metadata", "()Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "set_metadata", "(Lcom/segment/analytics/kotlin/core/DestinationMetadata;)V", "getAnonymousId", "()Ljava/lang/String;", "setAnonymousId", "(Ljava/lang/String;)V", "getContext", "()Lkotlinx/serialization/json/JsonObject;", "setContext", "(Lkotlinx/serialization/json/JsonObject;)V", "getGroupId", "setGroupId", "getIntegrations", "setIntegrations", "getMessageId", "setMessageId", "getTimestamp", "setTimestamp", "getTraits", "setTraits", "getType", "()Lcom/segment/analytics/kotlin/core/EventType;", "setType", "(Lcom/segment/analytics/kotlin/core/EventType;)V", "getUserId", "setUserId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class GroupEvent extends BaseEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DestinationMetadata _metadata;
    public String anonymousId;
    public JsonObject context;
    private String groupId;
    public JsonObject integrations;
    public String messageId;
    public String timestamp;
    private JsonObject traits;
    private EventType type;
    private String userId;

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/GroupEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/GroupEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<GroupEvent> serializer() {
            return GroupEvent$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GroupEvent(int i, String str, JsonObject jsonObject, EventType eventType, String str2, String str3, JsonObject jsonObject2, JsonObject jsonObject3, String str4, DestinationMetadata destinationMetadata, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (635 != (i & 635)) {
            PluginExceptionsKt.throwMissingFieldException(i, 635, GroupEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.groupId = str;
        this.traits = jsonObject;
        if ((i & 4) == 0) {
            this.type = EventType.Group;
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
    public GroupEvent(String groupId, JsonObject traits) {
        super(null);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        this.groupId = groupId;
        this.traits = traits;
        this.type = EventType.Group;
        this.userId = "";
        this._metadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GroupEvent copy$default(GroupEvent groupEvent, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupEvent.groupId;
        }
        if ((i & 2) != 0) {
            jsonObject = groupEvent.traits;
        }
        return groupEvent.copy(str, jsonObject);
    }

    @JvmStatic
    public static final void write$Self(GroupEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.groupId);
        output.encodeSerializableElement(serialDesc, 1, JsonObjectSerializer.INSTANCE, self.traits);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getType() != EventType.Group) {
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
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonObject getTraits() {
        return this.traits;
    }

    public final GroupEvent copy(String groupId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        return new GroupEvent(groupId, traits);
    }

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.GroupEvent");
        GroupEvent groupEvent = (GroupEvent) other;
        return Intrinsics.areEqual(this.groupId, groupEvent.groupId) && Intrinsics.areEqual(this.traits, groupEvent.traits);
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

    public final String getGroupId() {
        return this.groupId;
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

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public String getTimestamp() {
        String str = this.timestamp;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DiagnosticsEntry.TIMESTAMP_KEY);
        return null;
    }

    public final JsonObject getTraits() {
        return this.traits;
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
        return (((super.hashCode() * 31) + this.groupId.hashCode()) * 31) + this.traits.hashCode();
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

    public final void setGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
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

    @Override // com.segment.analytics.kotlin.core.BaseEvent
    public void setTimestamp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timestamp = str;
    }

    public final void setTraits(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<set-?>");
        this.traits = jsonObject;
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
        return "GroupEvent(groupId=" + this.groupId + ", traits=" + this.traits + ')';
    }
}
