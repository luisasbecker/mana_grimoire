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
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import io.customer.sdk.util.EventNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationLifecyclePlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/customer/datapipelines/plugins/ApplicationLifecyclePlugin;", "Lcom/segment/analytics/kotlin/core/platform/EventPlugin;", "<init>", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "logger", "Lio/customer/sdk/core/util/Logger;", "track", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "payload", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationLifecyclePlugin implements EventPlugin {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.After;
    private final Logger logger = SDKComponent.INSTANCE.getLogger();

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
    public BaseEvent identify(IdentifyEvent identifyEvent) {
        return EventPlugin.DefaultImpls.identify(this, identifyEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public void reset() {
        EventPlugin.DefaultImpls.reset(this);
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
    public BaseEvent track(TrackEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (Intrinsics.areEqual(payload.getEvent(), EventNames.APPLICATION_BACKGROUNDED)) {
            Logger.DefaultImpls.debug$default(this.logger, "App backgrounded, flushing events queue", null, 2, null);
            getAnalytics().flush();
        }
        return EventPlugin.DefaultImpls.track(this, payload);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        EventPlugin.DefaultImpls.update(this, settings, updateType);
    }
}
