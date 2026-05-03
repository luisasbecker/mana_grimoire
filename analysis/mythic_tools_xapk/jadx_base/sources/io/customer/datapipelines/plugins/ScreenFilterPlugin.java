package io.customer.datapipelines.plugins;

import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
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
import io.customer.datapipelines.config.ScreenView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenFilterPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lio/customer/datapipelines/plugins/ScreenFilterPlugin;", "Lcom/segment/analytics/kotlin/core/platform/EventPlugin;", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", "<init>", "(Lio/customer/datapipelines/config/ScreenView;)V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", AndroidContextPlugin.SCREEN_KEY, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "payload", "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenFilterPlugin implements EventPlugin {
    public Analytics analytics;
    private final ScreenView screenViewUse;
    private final Plugin.Type type;

    public ScreenFilterPlugin(ScreenView screenViewUse) {
        Intrinsics.checkNotNullParameter(screenViewUse, "screenViewUse");
        this.screenViewUse = screenViewUse;
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
    public BaseEvent identify(IdentifyEvent identifyEvent) {
        return EventPlugin.DefaultImpls.identify(this, identifyEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public void reset() {
        EventPlugin.DefaultImpls.reset(this);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent screen(ScreenEvent payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        ScreenView screenView = this.screenViewUse;
        if (Intrinsics.areEqual(screenView, ScreenView.All.INSTANCE)) {
            return payload;
        }
        if (Intrinsics.areEqual(screenView, ScreenView.InApp.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
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
