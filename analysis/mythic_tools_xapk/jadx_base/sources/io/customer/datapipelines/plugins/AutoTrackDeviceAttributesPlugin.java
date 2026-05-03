package io.customer.datapipelines.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.TrackEvent;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import io.customer.sdk.util.EventNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: AutoTrackDeviceAttributesPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/customer/datapipelines/plugins/AutoTrackDeviceAttributesPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "<init>", "()V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoTrackDeviceAttributesPlugin implements Plugin {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Before;

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        JsonObject jsonObject;
        JsonObject jsonObject2;
        Intrinsics.checkNotNullParameter(event, "event");
        TrackEvent trackEvent = event instanceof TrackEvent ? (TrackEvent) event : null;
        if (!Intrinsics.areEqual(trackEvent != null ? trackEvent.getEvent() : null, EventNames.DEVICE_UPDATE)) {
            return event;
        }
        TrackEvent trackEvent2 = (TrackEvent) event;
        JsonObject context = trackEvent2.getContext();
        JsonObject properties = trackEvent2.getProperties();
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, properties);
        JsonElement jsonElement = (JsonElement) context.get((Object) AndroidContextPlugin.NETWORK_KEY);
        if (jsonElement != null && (jsonObject2 = JsonElementKt.getJsonObject(jsonElement)) != null) {
            JsonElement jsonElement2 = (JsonElement) jsonObject2.get((Object) AndroidContextPlugin.NETWORK_BLUETOOTH_KEY);
            if (jsonElement2 != null) {
                jsonObjectBuilder.put("network_bluetooth", jsonElement2);
            }
            JsonElement jsonElement3 = (JsonElement) jsonObject2.get((Object) AndroidContextPlugin.NETWORK_CELLULAR_KEY);
            if (jsonElement3 != null) {
                jsonObjectBuilder.put("network_cellular", jsonElement3);
            }
            JsonElement jsonElement4 = (JsonElement) jsonObject2.get((Object) AndroidContextPlugin.NETWORK_WIFI_KEY);
            if (jsonElement4 != null) {
                jsonObjectBuilder.put("network_wifi", jsonElement4);
            }
        }
        JsonElement jsonElement5 = (JsonElement) context.get((Object) AndroidContextPlugin.SCREEN_KEY);
        if (jsonElement5 != null && (jsonObject = JsonElementKt.getJsonObject(jsonElement5)) != null) {
            JsonElement jsonElement6 = (JsonElement) jsonObject.get((Object) "width");
            if (jsonElement6 != null) {
                jsonObjectBuilder.put("screen_width", jsonElement6);
            }
            JsonElement jsonElement7 = (JsonElement) jsonObject.get((Object) "height");
            if (jsonElement7 != null) {
                jsonObjectBuilder.put("screen_height", jsonElement7);
            }
        }
        JsonElement jsonElement8 = (JsonElement) context.get((Object) "ip");
        if (jsonElement8 != null) {
            jsonObjectBuilder.put("ip", jsonElement8);
        }
        JsonElement jsonElement9 = (JsonElement) context.get((Object) AndroidContextPlugin.TIMEZONE_KEY);
        if (jsonElement9 != null) {
            jsonObjectBuilder.put(AndroidContextPlugin.TIMEZONE_KEY, jsonElement9);
        }
        trackEvent2.setProperties(jsonObjectBuilder.build());
        return event;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Plugin.Type getType() {
        return this.type;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Plugin.DefaultImpls.setup(this, analytics);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
