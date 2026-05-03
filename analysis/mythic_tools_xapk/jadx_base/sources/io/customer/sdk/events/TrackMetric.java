package io.customer.sdk.events;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.customer.sdk.DataPipelinesLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackMetric.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/customer/sdk/events/TrackMetric;", "", "metric", "Lio/customer/sdk/events/Metric;", "getMetric", "()Lio/customer/sdk/events/Metric;", "deliveryId", "", "getDeliveryId", "()Ljava/lang/String;", DataPipelinesLogger.PUSH_TAG, "InApp", "Lio/customer/sdk/events/TrackMetric$InApp;", "Lio/customer/sdk/events/TrackMetric$Push;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TrackMetric {

    /* JADX INFO: compiled from: TrackMetric.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/customer/sdk/events/TrackMetric$InApp;", "Lio/customer/sdk/events/TrackMetric;", "metric", "Lio/customer/sdk/events/Metric;", "deliveryId", "", "metadata", "", "<init>", "(Lio/customer/sdk/events/Metric;Ljava/lang/String;Ljava/util/Map;)V", "getMetric", "()Lio/customer/sdk/events/Metric;", "getDeliveryId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class InApp implements TrackMetric {
        private final String deliveryId;
        private final Map<String, String> metadata;
        private final Metric metric;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InApp(Metric metric, String deliveryId) {
            this(metric, deliveryId, null, 4, null);
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
        }

        public InApp(Metric metric, String deliveryId, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metric = metric;
            this.deliveryId = deliveryId;
            this.metadata = metadata;
        }

        public /* synthetic */ InApp(Metric metric, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(metric, str, (i & 4) != 0 ? MapsKt.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InApp copy$default(InApp inApp, Metric metric, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                metric = inApp.metric;
            }
            if ((i & 2) != 0) {
                str = inApp.deliveryId;
            }
            if ((i & 4) != 0) {
                map = inApp.metadata;
            }
            return inApp.copy(metric, str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Metric getMetric() {
            return this.metric;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDeliveryId() {
            return this.deliveryId;
        }

        public final Map<String, String> component3() {
            return this.metadata;
        }

        public final InApp copy(Metric metric, String deliveryId, Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            return new InApp(metric, deliveryId, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InApp)) {
                return false;
            }
            InApp inApp = (InApp) other;
            return this.metric == inApp.metric && Intrinsics.areEqual(this.deliveryId, inApp.deliveryId) && Intrinsics.areEqual(this.metadata, inApp.metadata);
        }

        @Override // io.customer.sdk.events.TrackMetric
        public String getDeliveryId() {
            return this.deliveryId;
        }

        public final Map<String, String> getMetadata() {
            return this.metadata;
        }

        @Override // io.customer.sdk.events.TrackMetric
        public Metric getMetric() {
            return this.metric;
        }

        public int hashCode() {
            return (((this.metric.hashCode() * 31) + this.deliveryId.hashCode()) * 31) + this.metadata.hashCode();
        }

        public String toString() {
            return "InApp(metric=" + this.metric + ", deliveryId=" + this.deliveryId + ", metadata=" + this.metadata + ")";
        }
    }

    /* JADX INFO: compiled from: TrackMetric.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lio/customer/sdk/events/TrackMetric$Push;", "Lio/customer/sdk/events/TrackMetric;", "metric", "Lio/customer/sdk/events/Metric;", "deliveryId", "", "deviceToken", "<init>", "(Lio/customer/sdk/events/Metric;Ljava/lang/String;Ljava/lang/String;)V", "getMetric", "()Lio/customer/sdk/events/Metric;", "getDeliveryId", "()Ljava/lang/String;", "getDeviceToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Push implements TrackMetric {
        private final String deliveryId;
        private final String deviceToken;
        private final Metric metric;

        public Push(Metric metric, String deliveryId, String deviceToken) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            this.metric = metric;
            this.deliveryId = deliveryId;
            this.deviceToken = deviceToken;
        }

        public static /* synthetic */ Push copy$default(Push push, Metric metric, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                metric = push.metric;
            }
            if ((i & 2) != 0) {
                str = push.deliveryId;
            }
            if ((i & 4) != 0) {
                str2 = push.deviceToken;
            }
            return push.copy(metric, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Metric getMetric() {
            return this.metric;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDeliveryId() {
            return this.deliveryId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDeviceToken() {
            return this.deviceToken;
        }

        public final Push copy(Metric metric, String deliveryId, String deviceToken) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            return new Push(metric, deliveryId, deviceToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Push)) {
                return false;
            }
            Push push = (Push) other;
            return this.metric == push.metric && Intrinsics.areEqual(this.deliveryId, push.deliveryId) && Intrinsics.areEqual(this.deviceToken, push.deviceToken);
        }

        @Override // io.customer.sdk.events.TrackMetric
        public String getDeliveryId() {
            return this.deliveryId;
        }

        public final String getDeviceToken() {
            return this.deviceToken;
        }

        @Override // io.customer.sdk.events.TrackMetric
        public Metric getMetric() {
            return this.metric;
        }

        public int hashCode() {
            return (((this.metric.hashCode() * 31) + this.deliveryId.hashCode()) * 31) + this.deviceToken.hashCode();
        }

        public String toString() {
            return "Push(metric=" + this.metric + ", deliveryId=" + this.deliveryId + ", deviceToken=" + this.deviceToken + ")";
        }
    }

    String getDeliveryId();

    Metric getMetric();
}
