package io.customer.datapipelines.plugins;

import com.segment.analytics.kotlin.core.AliasEvent;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.GroupEvent;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.TrackEvent;
import com.segment.analytics.kotlin.core.platform.EventPlugin;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.EventTransformer;
import io.customer.sdk.core.pipeline.IdentifyHook;
import io.customer.sdk.core.pipeline.IdentifyHookRegistry;
import io.customer.sdk.core.util.Logger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: IdentifyContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lio/customer/datapipelines/plugins/IdentifyContextPlugin;", "Lcom/segment/analytics/kotlin/core/platform/EventPlugin;", "registry", "Lio/customer/sdk/core/pipeline/IdentifyHookRegistry;", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Lio/customer/sdk/core/pipeline/IdentifyHookRegistry;Lio/customer/sdk/core/util/Logger;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "reset", "", "identify", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "payload", "Lcom/segment/analytics/kotlin/core/IdentifyEvent;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentifyContextPlugin implements EventPlugin {
    public Analytics analytics;
    private final Logger logger;
    private final IdentifyHookRegistry registry;
    private final Plugin.Type type;

    public IdentifyContextPlugin(IdentifyHookRegistry registry, Logger logger) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.registry = registry;
        this.logger = logger;
        this.type = Plugin.Type.Enrichment;
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent alias(AliasEvent aliasEvent) {
        return EventPlugin.DefaultImpls.alias(this, aliasEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin, com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent baseEvent) {
        return EventPlugin.DefaultImpls.execute(this, baseEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public void flush() {
        EventPlugin.DefaultImpls.flush(this);
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

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent group(GroupEvent groupEvent) {
        return EventPlugin.DefaultImpls.group(this, groupEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent identify(IdentifyEvent payload) {
        JsonPrimitive JsonPrimitive;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Iterator<IdentifyHook> it = this.registry.getAll().iterator();
        while (it.hasNext()) {
            try {
                Map<String, Object> identifyContext = it.next().getIdentifyContext();
                if (!identifyContext.isEmpty()) {
                    for (Map.Entry<String, Object> entry : identifyContext.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            JsonPrimitive = JsonElementKt.JsonPrimitive((String) value);
                        } else if (value instanceof Number) {
                            JsonPrimitive = JsonElementKt.JsonPrimitive((Number) value);
                        } else if (value instanceof Boolean) {
                            JsonPrimitive = JsonElementKt.JsonPrimitive((Boolean) value);
                        } else {
                            Logger.DefaultImpls.debug$default(this.logger, "Skipping non-primitive context entry: " + key, null, 2, null);
                        }
                        EventTransformer.putInContext((BaseEvent) payload, key, (JsonElement) JsonPrimitive);
                    }
                }
            } catch (Exception e) {
                Logger.DefaultImpls.error$default(this.logger, "IdentifyHook failed: " + e.getMessage(), null, null, 6, null);
            }
        }
        return payload;
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public void reset() {
        EventPlugin.DefaultImpls.reset(this);
        Iterator<IdentifyHook> it = this.registry.getAll().iterator();
        while (it.hasNext()) {
            try {
                it.next().resetContext();
            } catch (Exception e) {
                Logger.DefaultImpls.error$default(this.logger, "IdentifyHook reset failed: " + e.getMessage(), null, null, 6, null);
            }
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent screen(ScreenEvent screenEvent) {
        return EventPlugin.DefaultImpls.screen(this, screenEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        EventPlugin.DefaultImpls.setup(this, analytics);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent track(TrackEvent trackEvent) {
        return EventPlugin.DefaultImpls.track(this, trackEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        EventPlugin.DefaultImpls.update(this, settings, updateType);
    }
}
