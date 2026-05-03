package com.segment.analytics.kotlin.core.platform.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.EventType;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.Plugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserInfoPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/UserInfoPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserInfoPlugin implements Plugin {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Before;

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType() == EventType.Identify) {
            getAnalytics().getUserInfo().setUserId(event.getUserId());
            getAnalytics().getUserInfo().setAnonymousId(event.getAnonymousId());
            getAnalytics().getUserInfo().setTraits(((IdentifyEvent) event).getTraits());
            return event;
        }
        if (event.getType() == EventType.Alias) {
            getAnalytics().getUserInfo().setAnonymousId(event.getAnonymousId());
            return event;
        }
        if (getAnalytics().getUserInfo().getUserId() != null) {
            event.setUserId(String.valueOf(getAnalytics().getUserInfo().getUserId()));
        }
        if (getAnalytics().getUserInfo().getAnonymousId() != null) {
            event.setAnonymousId(getAnalytics().getUserInfo().getAnonymousId().toString());
        }
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
