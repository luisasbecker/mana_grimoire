package com.segment.analytics.kotlin.core.platform.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: ContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/ContextPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", ContextPlugin.INSTANCE_ID_KEY, "", ContextPlugin.LIBRARY_KEY, "Lkotlinx/serialization/json/JsonObject;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "applyContextData", "", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "execute", "setup", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextPlugin implements Plugin {
    public static final String INSTANCE_ID_KEY = "instanceId";
    public static final String LIBRARY_KEY = "library";
    public static final String LIBRARY_NAME_KEY = "name";
    public static final String LIBRARY_VERSION_KEY = "version";
    public Analytics analytics;
    private final String instanceId;
    private JsonObject library;
    private final Plugin.Type type = Plugin.Type.Before;

    public ContextPlugin() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.instanceId = string;
    }

    private final void applyContextData(BaseEvent event) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonUtils.putAll(jsonObjectBuilder, event.getContext());
        JsonObject jsonObject = this.library;
        if (jsonObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException(LIBRARY_KEY);
            jsonObject = null;
        }
        jsonObjectBuilder.put(LIBRARY_KEY, jsonObject);
        JsonElementBuildersKt.put(jsonObjectBuilder, INSTANCE_ID_KEY, this.instanceId);
        event.setContext(jsonObjectBuilder.build());
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        applyContextData(event);
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
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Plugin.DefaultImpls.setup(this, analytics);
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, "name", "analytics-kotlin");
        JsonElementBuildersKt.put(jsonObjectBuilder, "version", "1.19.2");
        this.library = jsonObjectBuilder.build();
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
