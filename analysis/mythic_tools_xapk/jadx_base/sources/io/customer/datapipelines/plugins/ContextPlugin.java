package io.customer.datapipelines.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.Plugin;
import io.customer.sdk.data.store.DeviceStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lio/customer/datapipelines/plugins/ContextPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "eventProcessor", "Lio/customer/datapipelines/plugins/ContextPluginEventProcessor;", "<init>", "(Lio/customer/sdk/data/store/DeviceStore;Lio/customer/datapipelines/plugins/ContextPluginEventProcessor;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "deviceToken", "", "getDeviceToken$datapipelines_release", "()Ljava/lang/String;", "setDeviceToken$datapipelines_release", "(Ljava/lang/String;)V", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextPlugin implements Plugin {
    public Analytics analytics;
    private final DeviceStore deviceStore;
    private volatile String deviceToken;
    private final ContextPluginEventProcessor eventProcessor;
    private final Plugin.Type type;

    public ContextPlugin(DeviceStore deviceStore, ContextPluginEventProcessor eventProcessor) {
        Intrinsics.checkNotNullParameter(deviceStore, "deviceStore");
        Intrinsics.checkNotNullParameter(eventProcessor, "eventProcessor");
        this.deviceStore = deviceStore;
        this.eventProcessor = eventProcessor;
        this.type = Plugin.Type.Before;
    }

    public /* synthetic */ ContextPlugin(DeviceStore deviceStore, DefaultContextPluginEventProcessor defaultContextPluginEventProcessor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceStore, (i & 2) != 0 ? new DefaultContextPluginEventProcessor() : defaultContextPluginEventProcessor);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.eventProcessor.execute(event, this.deviceStore, new Function0() { // from class: io.customer.datapipelines.plugins.ContextPlugin$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.deviceToken;
            }
        });
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

    /* JADX INFO: renamed from: getDeviceToken$datapipelines_release, reason: from getter */
    public final String getDeviceToken() {
        return this.deviceToken;
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

    public final void setDeviceToken$datapipelines_release(String str) {
        this.deviceToken = str;
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
