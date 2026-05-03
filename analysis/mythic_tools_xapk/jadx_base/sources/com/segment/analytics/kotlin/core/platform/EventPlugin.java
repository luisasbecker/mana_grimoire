package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.AliasEvent;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.GroupEvent;
import com.segment.analytics.kotlin.core.IdentifyEvent;
import com.segment.analytics.kotlin.core.ScreenEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.TrackEvent;
import com.segment.analytics.kotlin.core.platform.Plugin;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Plugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/EventPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "alias", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "payload", "Lcom/segment/analytics/kotlin/core/AliasEvent;", "execute", NotificationCompat.CATEGORY_EVENT, "flush", "", "group", "Lcom/segment/analytics/kotlin/core/GroupEvent;", "identify", "Lcom/segment/analytics/kotlin/core/IdentifyEvent;", "reset", AndroidContextPlugin.SCREEN_KEY, "Lcom/segment/analytics/kotlin/core/ScreenEvent;", "track", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventPlugin extends Plugin {

    /* JADX INFO: compiled from: Plugin.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static BaseEvent alias(EventPlugin eventPlugin, AliasEvent payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            return payload;
        }

        public static BaseEvent execute(EventPlugin eventPlugin, BaseEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof IdentifyEvent) {
                return eventPlugin.identify((IdentifyEvent) event);
            }
            if (event instanceof TrackEvent) {
                return eventPlugin.track((TrackEvent) event);
            }
            if (event instanceof GroupEvent) {
                return eventPlugin.group((GroupEvent) event);
            }
            if (event instanceof ScreenEvent) {
                return eventPlugin.screen((ScreenEvent) event);
            }
            if (event instanceof AliasEvent) {
                return eventPlugin.alias((AliasEvent) event);
            }
            throw new NoWhenBranchMatchedException();
        }

        public static void flush(EventPlugin eventPlugin) {
        }

        public static BaseEvent group(EventPlugin eventPlugin, GroupEvent payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            return payload;
        }

        public static BaseEvent identify(EventPlugin eventPlugin, IdentifyEvent payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            return payload;
        }

        public static void reset(EventPlugin eventPlugin) {
        }

        public static BaseEvent screen(EventPlugin eventPlugin, ScreenEvent payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            return payload;
        }

        public static void setup(EventPlugin eventPlugin, Analytics analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Plugin.DefaultImpls.setup(eventPlugin, analytics);
        }

        public static BaseEvent track(EventPlugin eventPlugin, TrackEvent payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            return payload;
        }

        public static void update(EventPlugin eventPlugin, Settings settings, Plugin.UpdateType type) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            Intrinsics.checkNotNullParameter(type, "type");
            Plugin.DefaultImpls.update(eventPlugin, settings, type);
        }
    }

    BaseEvent alias(AliasEvent payload);

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    BaseEvent execute(BaseEvent event);

    void flush();

    BaseEvent group(GroupEvent payload);

    BaseEvent identify(IdentifyEvent payload);

    void reset();

    BaseEvent screen(ScreenEvent payload);

    BaseEvent track(TrackEvent payload);
}
