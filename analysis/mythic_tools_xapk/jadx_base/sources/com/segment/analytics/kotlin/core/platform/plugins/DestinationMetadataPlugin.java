package com.segment.analytics.kotlin.core.platform.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.DestinationMetadata;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.platform.Mediator;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: DestinationMetadataPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/DestinationMetadataPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "analyticsSettings", "Lcom/segment/analytics/kotlin/core/Settings;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "update", "", "settings", "Lcom/segment/analytics/kotlin/core/platform/Plugin$UpdateType;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DestinationMetadataPlugin implements Plugin {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Enrichment;
    private Settings analyticsSettings = new Settings((JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, 63, (DefaultConstructorMarker) null);

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        ArrayList arrayList;
        JsonObject safeJsonObject;
        JsonElement jsonElement;
        JsonArray safeJsonArray;
        CopyOnWriteArrayList<Plugin> plugins$core;
        Intrinsics.checkNotNullParameter(event, "event");
        Mediator mediator = getAnalytics().getTimeline$core().getPlugins$core().get(Plugin.Type.Destination);
        if (mediator == null || (plugins$core = mediator.getPlugins$core()) == null) {
            arrayList = null;
        } else {
            CopyOnWriteArrayList<Plugin> copyOnWriteArrayList = plugins$core;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(copyOnWriteArrayList, 10));
            for (Plugin plugin : copyOnWriteArrayList) {
                Intrinsics.checkNotNull(plugin, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.platform.DestinationPlugin");
                arrayList2.add((DestinationPlugin) plugin);
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                DestinationPlugin destinationPlugin = (DestinationPlugin) obj;
                if (destinationPlugin.getEnabled() && !(destinationPlugin instanceof SegmentDestination)) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        DestinationMetadata destinationMetadata = new DestinationMetadata((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                setCreateSetBuilder.add(((DestinationPlugin) it.next()).getKey());
            }
        }
        Set setBuild = SetsKt.build(setCreateSetBuilder);
        Set setCreateSetBuilder2 = SetsKt.createSetBuilder();
        for (String str : this.analyticsSettings.getIntegrations().keySet()) {
            if (!Intrinsics.areEqual(str, "Segment.io") && !setBuild.contains(str)) {
                setCreateSetBuilder2.add(str);
            }
        }
        JsonElement jsonElement2 = (JsonElement) this.analyticsSettings.getIntegrations().get((Object) "Segment.io");
        if (jsonElement2 != null && (safeJsonObject = JsonUtils.getSafeJsonObject(jsonElement2)) != null && (jsonElement = (JsonElement) safeJsonObject.get((Object) "unbundledIntegrations")) != null && (safeJsonArray = JsonUtils.getSafeJsonArray(jsonElement)) != null) {
            for (JsonElement jsonElement3 : safeJsonArray) {
                Intrinsics.checkNotNull(jsonElement3, "null cannot be cast to non-null type kotlinx.serialization.json.JsonPrimitive");
                String content = ((JsonPrimitive) jsonElement3).getContent();
                if (!setBuild.contains(content)) {
                    setCreateSetBuilder2.add(content);
                }
            }
        }
        Set setBuild2 = SetsKt.build(setCreateSetBuilder2);
        destinationMetadata.setBundledIds(CollectionsKt.emptyList());
        destinationMetadata.setBundled(CollectionsKt.toList(setBuild));
        destinationMetadata.setUnbundled(CollectionsKt.toList(setBuild2));
        BaseEvent baseEventCopy = event.copy();
        baseEventCopy.set_metadata(destinationMetadata);
        return baseEventCopy;
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
    public void update(Settings settings, Plugin.UpdateType type) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(type, "type");
        Plugin.DefaultImpls.update(this, settings, type);
        this.analyticsSettings = settings;
    }
}
