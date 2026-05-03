package com.segment.analytics.kotlin.core.platform.plugins;

import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.AliasEvent;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.GroupEvent;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.TrackEvent;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.platform.EventPipeline;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.platform.VersionedPlugin;
import com.segment.analytics.kotlin.core.platform.policies.CountBasedFlushPolicy;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import com.segment.analytics.kotlin.core.platform.policies.FrequencyFlushPolicy;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: SegmentDestination.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001cH\u0016J\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\rH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/SegmentDestination;", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", "Lcom/segment/analytics/kotlin/core/platform/VersionedPlugin;", "Lsovran/kotlin/Subscriber;", "()V", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "getFlushPolicies", "()Ljava/util/List;", "setFlushPolicies", "(Ljava/util/List;)V", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "pipeline", "Lcom/segment/analytics/kotlin/core/platform/EventPipeline;", "alias", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "payload", "Lcom/segment/analytics/kotlin/core/AliasEvent;", "enqueue", "", "flush", "group", "Lcom/segment/analytics/kotlin/core/GroupEvent;", "identify", "Lcom/segment/analytics/kotlin/core/IdentifyEvent;", "onEnableToggled", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/segment/analytics/kotlin/core/System;", "onEnableToggled$core", AndroidContextPlugin.SCREEN_KEY, "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "setup", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "track", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "update", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$UpdateType;", "version", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentDestination extends DestinationPlugin implements VersionedPlugin, Subscriber {
    private List<? extends FlushPolicy> flushPolicies = CollectionsKt.emptyList();
    private final String key = "Segment.io";
    private EventPipeline pipeline;

    private final void enqueue(BaseEvent payload) {
        EventPipeline eventPipeline = this.pipeline;
        if (eventPipeline != null) {
            eventPipeline.put(payload);
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent alias(AliasEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        AliasEvent aliasEvent = payload;
        enqueue(aliasEvent);
        return aliasEvent;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public void flush() {
        EventPipeline eventPipeline = this.pipeline;
        if (eventPipeline != null) {
            eventPipeline.flush();
        }
    }

    public final List<FlushPolicy> getFlushPolicies() {
        return this.flushPolicies;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin
    public String getKey() {
        return this.key;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent group(GroupEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        GroupEvent groupEvent = payload;
        enqueue(groupEvent);
        return groupEvent;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent identify(IdentifyEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        IdentifyEvent identifyEvent = payload;
        enqueue(identifyEvent);
        return identifyEvent;
    }

    public final void onEnableToggled$core(System state) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean enabled = state.getEnabled();
        EventPipeline eventPipeline = this.pipeline;
        if (enabled) {
            if (eventPipeline != null) {
                eventPipeline.start();
            }
        } else if (eventPipeline != null) {
            eventPipeline.stop();
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent screen(ScreenEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        ScreenEvent screenEvent = payload;
        enqueue(screenEvent);
        return screenEvent;
    }

    public final void setFlushPolicies(List<? extends FlushPolicy> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.flushPolicies = list;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        super.setup(analytics);
        this.flushPolicies = analytics.getConfiguration().getFlushPolicies().isEmpty() ? CollectionsKt.listOf((Object[]) new FlushPolicy[]{new CountBasedFlushPolicy(analytics.getConfiguration().getFlushAt()), new FrequencyFlushPolicy(((long) analytics.getConfiguration().getFlushInterval()) * 1000)}) : analytics.getConfiguration().getFlushPolicies();
        add(new DestinationMetadataPlugin());
        this.pipeline = new EventPipeline(analytics, getKey(), analytics.getConfiguration().getWriteKey(), this.flushPolicies, analytics.getConfiguration().getApiHost());
        BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getAnalyticsDispatcher(), null, new SegmentDestination$setup$1$1(analytics, this, null), 2, null);
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent track(TrackEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        TrackEvent trackEvent = payload;
        enqueue(trackEvent);
        return trackEvent;
    }

    @Override // com.segment.analytics.kotlin.core.platform.DestinationPlugin, com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType type) {
        String apiHost;
        EventPipeline eventPipeline;
        JsonObject safeJsonObject;
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(type, "type");
        super.update(settings, type);
        if (settings.hasIntegrationSettings(this)) {
            String key = getKey();
            Json.INSTANCE.getSerializersModule();
            KSerializer<SegmentSettings> kSerializerSerializer = SegmentSettings.INSTANCE.serializer();
            JsonElement jsonElement = (JsonElement) settings.getIntegrations().get((Object) key);
            SegmentSettings segmentSettings = (SegmentSettings) ((jsonElement == null || (safeJsonObject = JsonUtils.getSafeJsonObject(jsonElement)) == null) ? null : JsonUtils.getLenientJson().decodeFromJsonElement(kSerializerSerializer, safeJsonObject));
            if (segmentSettings == null || (apiHost = segmentSettings.getApiHost()) == null || (eventPipeline = this.pipeline) == null) {
                return;
            }
            eventPipeline.setApiHost(apiHost);
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.VersionedPlugin
    public String version() {
        return "1.19.2";
    }
}
