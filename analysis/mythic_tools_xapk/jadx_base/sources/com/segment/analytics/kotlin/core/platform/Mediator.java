package com.segment.analytics.kotlin.core.platform;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.Telemetry;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogKind;
import com.segment.analytics.kotlin.core.platform.plugins.logger.SegmentLogKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: Mediator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u001a\u0010\f\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010J%\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0018\"\b\b\u0000\u0010\u0013*\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/Mediator;", "", "plugins", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getPlugins$core", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setPlugins$core", "add", "", "plugin", "applyClosure", "closure", "Lkotlin/Function1;", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "find", ExifInterface.GPS_DIRECTION_TRUE, "pluginClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/segment/analytics/kotlin/core/platform/Plugin;", "findAll", "", "remove", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Mediator {
    private CopyOnWriteArrayList<Plugin> plugins;

    /* JADX WARN: Multi-variable type inference failed */
    public Mediator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Mediator(CopyOnWriteArrayList<Plugin> plugins) {
        Intrinsics.checkNotNullParameter(plugins, "plugins");
        this.plugins = plugins;
    }

    public /* synthetic */ Mediator(CopyOnWriteArrayList copyOnWriteArrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList);
    }

    public final void add(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.plugins.add(plugin);
    }

    public final void applyClosure(Function1<? super Plugin, Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        for (final Plugin plugin : this.plugins) {
            try {
                Intrinsics.checkNotNullExpressionValue(plugin, "plugin");
                closure.invoke(plugin);
            } catch (Throwable th) {
                ErrorsKt.reportErrorWithMetrics(null, th, "Caught Exception applying closure to plugin: " + plugin, Telemetry.INTEGRATION_ERROR_METRIC, ExceptionsKt.stackTraceToString(th), new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Mediator$applyClosure$1$1
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
                        it.put("writekey", plugin.getAnalytics().getConfiguration().getWriteKey());
                        it.put("message", "Exception executing plugin");
                    }
                });
            }
        }
    }

    public final BaseEvent execute(final BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        for (final Plugin plugin : this.plugins) {
            if (event != null) {
                BaseEvent baseEventCopy = event.copy();
                try {
                    Telemetry.INSTANCE.increment(Telemetry.INTEGRATION_METRIC, new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Mediator$execute$1$1$1
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
                            it.put("message", "event-" + event.getType());
                            Plugin plugin2 = plugin;
                            if (!(plugin2 instanceof DestinationPlugin) || Intrinsics.areEqual(((DestinationPlugin) plugin2).getKey(), "")) {
                                it.put("plugin", new StringBuilder().append(plugin.getType()).append(Soundex.SILENT_MARKER).append(plugin.getClass()).toString());
                            } else {
                                it.put("plugin", plugin.getType() + Soundex.SILENT_MARKER + ((DestinationPlugin) plugin).getKey());
                            }
                        }
                    });
                    if (plugin instanceof DestinationPlugin) {
                        plugin.execute(baseEventCopy);
                    } else {
                        event = plugin.execute(baseEventCopy);
                    }
                } catch (Throwable th) {
                    SegmentLogKt.segmentLog(Analytics.INSTANCE, "Skipping plugin due to Exception: " + plugin, LogKind.WARNING);
                    ErrorsKt.reportErrorWithMetrics(null, th, "Caught Exception in plugin", Telemetry.INTEGRATION_ERROR_METRIC, ExceptionsKt.stackTraceToString(th), new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.platform.Mediator$execute$1$1$2
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
                            it.put("writekey", plugin.getAnalytics().getConfiguration().getWriteKey());
                            it.put("message", "Exception executing plugin");
                        }
                    });
                }
            }
        }
        return event;
    }

    public final <T extends Plugin> T find(KClass<T> pluginClass) {
        Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (pluginClass.isInstance(t)) {
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.segment.analytics.kotlin.core.platform.Mediator.find$lambda$3");
                return t;
            }
        }
        return null;
    }

    public final <T extends Plugin> List<T> findAll(KClass<T> pluginClass) {
        Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
        CopyOnWriteArrayList<Plugin> copyOnWriteArrayList = this.plugins;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (pluginClass.isInstance((Plugin) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final CopyOnWriteArrayList<Plugin> getPlugins$core() {
        return this.plugins;
    }

    public final void remove(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.plugins.removeAll(SetsKt.setOf(plugin));
    }

    public final void setPlugins$core(CopyOnWriteArrayList<Plugin> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.plugins = copyOnWriteArrayList;
    }
}
