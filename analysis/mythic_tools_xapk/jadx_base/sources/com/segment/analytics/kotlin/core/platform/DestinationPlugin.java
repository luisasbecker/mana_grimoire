package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
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
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: Plugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ$\u0010 \u001a\b\u0012\u0004\u0012\u0002H\"0!\"\b\b\u0000\u0010\"*\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$J\u0017\u0010%\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b&J\u0012\u0010'\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020-H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", "Lcom/segment/analytics/kotlin/core/platform/EventPlugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "enabled", "", "getEnabled$core", "()Z", "setEnabled$core", "(Z)V", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "timeline", "Lcom/segment/analytics/kotlin/core/platform/Timeline;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "add", "", "plugin", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "findAll", "", ExifInterface.GPS_DIRECTION_TRUE, "pluginClass", "Lkotlin/reflect/KClass;", "isDestinationEnabled", "isDestinationEnabled$core", "process", "remove", "setup", "update", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "Lcom/segment/analytics/kotlin/core/platform/Plugin$UpdateType;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DestinationPlugin implements EventPlugin {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Destination;
    private final Timeline timeline = new Timeline();
    private boolean enabled = true;

    public final void add(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        plugin.setAnalytics(getAnalytics());
        this.timeline.add(plugin);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent alias(AliasEvent aliasEvent) {
        return EventPlugin.DefaultImpls.alias(this, aliasEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin, com.segment.analytics.kotlin.core.platform.Plugin
    public final BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return process(event);
    }

    public final <T extends Plugin> List<T> findAll(KClass<T> pluginClass) {
        Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
        return this.timeline.findAll(pluginClass);
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

    /* JADX INFO: renamed from: getEnabled$core, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public abstract String getKey();

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

    public final boolean isDestinationEnabled$core(BaseEvent event) {
        JsonObject integrations;
        Boolean bool;
        return this.enabled && ((event == null || (integrations = event.getIntegrations()) == null || (bool = JsonUtils.getBoolean(integrations, getKey())) == null) ? true : bool.booleanValue());
    }

    public final BaseEvent process(BaseEvent event) {
        BaseEvent baseEventAlias;
        BaseEvent baseEvent = null;
        if (!isDestinationEnabled$core(event)) {
            return null;
        }
        BaseEvent baseEventApplyPlugins = this.timeline.applyPlugins(Plugin.Type.Enrichment, this.timeline.applyPlugins(Plugin.Type.Before, event));
        if (baseEventApplyPlugins != null) {
            if (baseEventApplyPlugins instanceof IdentifyEvent) {
                baseEventAlias = identify((IdentifyEvent) baseEventApplyPlugins);
            } else if (baseEventApplyPlugins instanceof TrackEvent) {
                baseEventAlias = track((TrackEvent) baseEventApplyPlugins);
            } else if (baseEventApplyPlugins instanceof GroupEvent) {
                baseEventAlias = group((GroupEvent) baseEventApplyPlugins);
            } else if (baseEventApplyPlugins instanceof ScreenEvent) {
                baseEventAlias = screen((ScreenEvent) baseEventApplyPlugins);
            } else {
                if (!(baseEventApplyPlugins instanceof AliasEvent)) {
                    throw new NoWhenBranchMatchedException();
                }
                baseEventAlias = alias((AliasEvent) baseEventApplyPlugins);
            }
            baseEvent = baseEventAlias;
        }
        return this.timeline.applyPlugins(Plugin.Type.After, baseEvent);
    }

    public final void remove(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.timeline.remove(plugin);
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

    public final void setEnabled$core(boolean z) {
        this.enabled = z;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        EventPlugin.DefaultImpls.setup(this, analytics);
        this.timeline.setAnalytics(analytics);
    }

    @Override // com.segment.analytics.kotlin.core.platform.EventPlugin
    public BaseEvent track(TrackEvent trackEvent) {
        return EventPlugin.DefaultImpls.track(this, trackEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(final Settings settings, final Plugin.UpdateType type) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(type, "type");
        this.enabled = settings.hasIntegrationSettings(this);
        this.timeline.applyClosure(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.DestinationPlugin.update.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                invoke2(plugin);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Plugin it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.update(settings, type);
            }
        });
    }
}
