package com.segment.analytics.kotlin.core;

import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/segment/analytics/kotlin/core/BaseEventSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "()V", "selectDeserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BaseEventSerializer extends JsonContentPolymorphicSerializer<BaseEvent> {
    public static final BaseEventSerializer INSTANCE = new BaseEventSerializer();

    private BaseEventSerializer() {
        super(Reflection.getOrCreateKotlinClass(BaseEvent.class));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    protected DeserializationStrategy<BaseEvent> selectDeserializer(JsonElement element) throws Exception {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(element, "element");
        JsonElement jsonElement = (JsonElement) JsonElementKt.getJsonObject(element).get((Object) "type");
        String content = (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : jsonPrimitive.getContent();
        if (content != null) {
            switch (content.hashCode()) {
                case -907689876:
                    if (content.equals(AndroidContextPlugin.SCREEN_KEY)) {
                        return ScreenEvent.INSTANCE.serializer();
                    }
                    break;
                case -135762164:
                    if (content.equals("identify")) {
                        return IdentifyEvent.INSTANCE.serializer();
                    }
                    break;
                case 92902992:
                    if (content.equals("alias")) {
                        return AliasEvent.INSTANCE.serializer();
                    }
                    break;
                case 98629247:
                    if (content.equals("group")) {
                        return GroupEvent.INSTANCE.serializer();
                    }
                    break;
                case 110621003:
                    if (content.equals("track")) {
                        return TrackEvent.INSTANCE.serializer();
                    }
                    break;
            }
        }
        throw new Exception("Unknown Event: key 'type' not found or does not matches any event type");
    }
}
