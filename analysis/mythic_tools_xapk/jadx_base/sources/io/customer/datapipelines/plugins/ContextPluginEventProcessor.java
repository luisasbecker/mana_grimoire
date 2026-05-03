package io.customer.datapipelines.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.BaseEvent;
import io.customer.sdk.data.store.DeviceStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH&¨\u0006\n"}, d2 = {"Lio/customer/datapipelines/plugins/ContextPluginEventProcessor;", "", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "deviceTokenProvider", "Lkotlin/Function0;", "", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContextPluginEventProcessor {
    BaseEvent execute(BaseEvent event, DeviceStore deviceStore, Function0<String> deviceTokenProvider);
}
