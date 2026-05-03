package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Plugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0014H\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/Plugin;", "", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "setup", "", "update", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "Lcom/segment/analytics/kotlin/core/platform/Plugin$UpdateType;", "Type", "UpdateType", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Plugin {

    /* JADX INFO: compiled from: Plugin.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static BaseEvent execute(Plugin plugin, BaseEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return event;
        }

        public static void setup(Plugin plugin, Analytics analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            plugin.setAnalytics(analytics);
        }

        public static void update(Plugin plugin, Settings settings, UpdateType type) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* JADX INFO: compiled from: Plugin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "", "(Ljava/lang/String;I)V", "Before", "Enrichment", "Destination", "After", "Utility", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Type {
        Before,
        Enrichment,
        Destination,
        After,
        Utility
    }

    /* JADX INFO: compiled from: Plugin.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/Plugin$UpdateType;", "", "(Ljava/lang/String;I)V", "Initial", HttpHeaders.REFRESH, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum UpdateType {
        Initial,
        Refresh
    }

    BaseEvent execute(BaseEvent event);

    Analytics getAnalytics();

    Type getType();

    void setAnalytics(Analytics analytics);

    void setup(Analytics analytics);

    void update(Settings settings, UpdateType type);
}
