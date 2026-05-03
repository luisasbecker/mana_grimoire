package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.Telemetry;
import com.segment.analytics.kotlin.core.platform.Plugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: Timeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0015J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ%\u0010\u001b\u001a\u0004\u0018\u0001H\u001f\"\b\b\u0000\u0010\u001f*\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!¢\u0006\u0002\u0010\"J$\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u001f0$\"\b\b\u0000\u0010\u001f*\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!J\u0010\u0010%\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/Timeline;", "", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "plugins", "", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "Lcom/segment/analytics/kotlin/core/platform/Mediator;", "getPlugins$core", "()Ljava/util/Map;", "add", "", "plugin", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "applyClosure", "closure", "Lkotlin/Function1;", "applyPlugins", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "mediator", NotificationCompat.CATEGORY_EVENT, "type", "find", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", FirebaseAnalytics.Param.DESTINATION, "", ExifInterface.GPS_DIRECTION_TRUE, "pluginClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/segment/analytics/kotlin/core/platform/Plugin;", "findAll", "", "process", "incomingEvent", "remove", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Timeline {
    public Analytics analytics;
    private final Map<Plugin.Type, Mediator> plugins;

    /* JADX WARN: Multi-variable type inference failed */
    public Timeline() {
        int i = 1;
        this.plugins = MapsKt.mapOf(TuplesKt.to(Plugin.Type.Before, new Mediator(null, i, 0 == true ? 1 : 0)), TuplesKt.to(Plugin.Type.Enrichment, new Mediator(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), TuplesKt.to(Plugin.Type.Destination, new Mediator(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), TuplesKt.to(Plugin.Type.After, new Mediator(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), TuplesKt.to(Plugin.Type.Utility, new Mediator(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)));
    }

    public final void add(final Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        try {
            plugin.setup(getAnalytics());
        } catch (Throwable th) {
            ErrorsKt.reportErrorWithMetrics(getAnalytics(), th, "Caught Exception while setting up plugin " + plugin, Telemetry.INTEGRATION_ERROR_METRIC, ExceptionsKt.stackTraceToString(th), new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Timeline.add.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.put("error", th.toString());
                    Plugin plugin2 = plugin;
                    if (!(plugin2 instanceof DestinationPlugin) || Intrinsics.areEqual(((DestinationPlugin) plugin2).getKey(), "")) {
                        it.put("plugin", new StringBuilder().append(plugin.getType()).append(Soundex.SILENT_MARKER).append(plugin.getClass()).toString());
                    } else {
                        it.put("plugin", plugin.getType() + Soundex.SILENT_MARKER + ((DestinationPlugin) plugin).getKey());
                    }
                    it.put("writekey", this.getAnalytics().getConfiguration().getWriteKey());
                    it.put("message", "Exception executing plugin");
                }
            });
        }
        Mediator mediator = this.plugins.get(plugin.getType());
        if (mediator != null) {
            mediator.add(plugin);
        }
        Analytics analytics = getAnalytics();
        BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getAnalyticsDispatcher(), null, new Timeline$add$2$1(analytics, plugin, null), 2, null);
        Telemetry.INSTANCE.increment(Telemetry.INTEGRATION_METRIC, new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Timeline.add.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.put("message", "added");
                Plugin plugin2 = plugin;
                if (!(plugin2 instanceof DestinationPlugin) || Intrinsics.areEqual(((DestinationPlugin) plugin2).getKey(), "")) {
                    it.put("plugin", new StringBuilder().append(plugin.getType()).append(Soundex.SILENT_MARKER).append(plugin.getClass()).toString());
                } else {
                    it.put("plugin", plugin.getType() + Soundex.SILENT_MARKER + ((DestinationPlugin) plugin).getKey());
                }
            }
        });
    }

    public final void applyClosure(Function1<? super Plugin, Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        Iterator<Map.Entry<Plugin.Type, Mediator>> it = this.plugins.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().applyClosure(closure);
        }
    }

    public final BaseEvent applyPlugins(Mediator mediator, BaseEvent event) {
        if (event == null) {
            return event;
        }
        if (mediator != null) {
            return mediator.execute(event);
        }
        return null;
    }

    public final BaseEvent applyPlugins(Plugin.Type type, BaseEvent event) {
        Intrinsics.checkNotNullParameter(type, "type");
        return applyPlugins(this.plugins.get(type), event);
    }

    public final DestinationPlugin find(String destination) {
        Plugin plugin;
        CopyOnWriteArrayList<Plugin> plugins$core;
        Object next;
        Intrinsics.checkNotNullParameter(destination, "destination");
        Mediator mediator = this.plugins.get(Plugin.Type.Destination);
        if (mediator == null || (plugins$core = mediator.getPlugins$core()) == null) {
            plugin = null;
        } else {
            Iterator<T> it = plugins$core.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Plugin plugin2 = (Plugin) next;
                if ((plugin2 instanceof DestinationPlugin) && Intrinsics.areEqual(((DestinationPlugin) plugin2).getKey(), destination)) {
                    break;
                }
            }
            plugin = (Plugin) next;
        }
        if (plugin instanceof DestinationPlugin) {
            return (DestinationPlugin) plugin;
        }
        return null;
    }

    public final <T extends Plugin> T find(KClass<T> pluginClass) {
        Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
        Iterator<Map.Entry<Plugin.Type, Mediator>> it = this.plugins.entrySet().iterator();
        while (it.hasNext()) {
            T t = (T) it.next().getValue().find(pluginClass);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public final <T extends Plugin> List<T> findAll(KClass<T> pluginClass) {
        Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Plugin.Type, Mediator>> it = this.plugins.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue().findAll(pluginClass));
        }
        return arrayList;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final Map<Plugin.Type, Mediator> getPlugins$core() {
        return this.plugins;
    }

    public final BaseEvent process(BaseEvent incomingEvent) {
        Function1<BaseEvent, BaseEvent> enrichment;
        Intrinsics.checkNotNullParameter(incomingEvent, "incomingEvent");
        BaseEvent baseEventApplyPlugins = applyPlugins(Plugin.Type.Enrichment, applyPlugins(Plugin.Type.Before, incomingEvent));
        if (baseEventApplyPlugins != null && (enrichment = baseEventApplyPlugins.getEnrichment()) != null) {
            baseEventApplyPlugins = enrichment.invoke(baseEventApplyPlugins);
        }
        BaseEvent baseEvent = baseEventApplyPlugins;
        applyPlugins(Plugin.Type.Destination, baseEvent);
        return applyPlugins(Plugin.Type.After, baseEvent);
    }

    public final void remove(final Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Iterator<Map.Entry<Plugin.Type, Mediator>> it = this.plugins.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(plugin);
            Telemetry.INSTANCE.increment(Telemetry.INTEGRATION_METRIC, new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Timeline$remove$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    it2.put("message", "removed");
                    Plugin plugin2 = plugin;
                    if (!(plugin2 instanceof DestinationPlugin) || Intrinsics.areEqual(((DestinationPlugin) plugin2).getKey(), "")) {
                        it2.put("plugin", new StringBuilder().append(plugin.getType()).append(Soundex.SILENT_MARKER).append(plugin.getClass()).toString());
                    } else {
                        it2.put("plugin", plugin.getType() + Soundex.SILENT_MARKER + ((DestinationPlugin) plugin).getKey());
                    }
                }
            });
        }
    }

    public final void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }
}
