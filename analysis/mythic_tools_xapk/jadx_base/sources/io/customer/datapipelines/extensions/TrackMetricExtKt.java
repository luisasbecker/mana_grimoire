package io.customer.datapipelines.extensions;

import io.customer.sdk.events.MetricKt;
import io.customer.sdk.events.TrackMetric;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackMetricExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000\"\u0018\u0010\u0005\u001a\u00020\u0002*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"asMap", "", "", "", "Lio/customer/sdk/events/TrackMetric;", "type", "getType", "(Lio/customer/sdk/events/TrackMetric;)Ljava/lang/String;", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TrackMetricExtKt {
    public static final Map<String, Object> asMap(TrackMetric trackMetric) {
        Intrinsics.checkNotNullParameter(trackMetric, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (trackMetric instanceof TrackMetric.Push) {
            linkedHashMap.put("recipient", ((TrackMetric.Push) trackMetric).getDeviceToken());
        } else {
            if (!(trackMetric instanceof TrackMetric.InApp)) {
                throw new NoWhenBranchMatchedException();
            }
            linkedHashMap.putAll(((TrackMetric.InApp) trackMetric).getMetadata());
        }
        linkedHashMap.put("metric", MetricKt.getSerializedName(trackMetric.getMetric()));
        linkedHashMap.put("deliveryId", trackMetric.getDeliveryId());
        return linkedHashMap;
    }

    public static final String getType(TrackMetric trackMetric) {
        Intrinsics.checkNotNullParameter(trackMetric, "<this>");
        if (trackMetric instanceof TrackMetric.Push) {
            return "push";
        }
        if (trackMetric instanceof TrackMetric.InApp) {
            return "in-app";
        }
        throw new NoWhenBranchMatchedException();
    }
}
