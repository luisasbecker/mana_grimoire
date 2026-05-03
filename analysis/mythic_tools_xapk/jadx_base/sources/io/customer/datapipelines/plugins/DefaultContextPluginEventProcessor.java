package io.customer.datapipelines.plugins;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.utilities.EventTransformer;
import io.customer.sdk.data.store.DeviceStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: ContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lio/customer/datapipelines/plugins/DefaultContextPluginEventProcessor;", "Lio/customer/datapipelines/plugins/ContextPluginEventProcessor;", "<init>", "()V", "execute", "Lcom/segment/analytics/kotlin/core/BaseEvent;", NotificationCompat.CATEGORY_EVENT, "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "deviceTokenProvider", "Lkotlin/Function0;", "", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultContextPluginEventProcessor implements ContextPluginEventProcessor {
    @Override // io.customer.datapipelines.plugins.ContextPluginEventProcessor
    public BaseEvent execute(BaseEvent event, DeviceStore deviceStore, Function0<String> deviceTokenProvider) {
        String strInvoke;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(deviceStore, "deviceStore");
        Intrinsics.checkNotNullParameter(deviceTokenProvider, "deviceTokenProvider");
        EventTransformer.putInContext(event, AndroidContextPlugin.USER_AGENT_KEY, deviceStore.buildUserAgent());
        EventTransformer.removeFromContext(event, com.segment.analytics.kotlin.core.platform.plugins.ContextPlugin.LIBRARY_KEY);
        JsonPrimitive jsonPrimitive = (JsonPrimitive) CollectionsKt.firstOrNull((List) PluginExtensionsKt.findInContextAtPath(event, "device.token"));
        if ((jsonPrimitive == null || jsonPrimitive.getContent() == null) && (strInvoke = deviceTokenProvider.invoke()) != null) {
            Json.INSTANCE.getSerializersModule();
            EventTransformer.putInContextUnderKey(event, AndroidContextPlugin.DEVICE_KEY, "token", strInvoke, StringSerializer.INSTANCE);
        }
        return event;
    }
}
