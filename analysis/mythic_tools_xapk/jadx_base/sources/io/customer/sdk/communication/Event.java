package io.customer.sdk.communication;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.customer.sdk.events.Metric;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0007\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lio/customer/sdk/communication/Event;", "", "<init>", "()V", "storageId", "", "getStorageId", "()Ljava/lang/String;", NativeProtocol.WEB_DIALOG_PARAMS, "", "getParams", "()Ljava/util/Map;", DiagnosticsEntry.TIMESTAMP_KEY, "Ljava/util/Date;", "getTimestamp", "()Ljava/util/Date;", "UserChangedEvent", "ScreenViewedEvent", "ResetEvent", "TrackPushMetricEvent", "TrackInAppMetricEvent", "RegisterDeviceTokenEvent", "DeleteDeviceTokenEvent", "Lio/customer/sdk/communication/Event$DeleteDeviceTokenEvent;", "Lio/customer/sdk/communication/Event$RegisterDeviceTokenEvent;", "Lio/customer/sdk/communication/Event$ResetEvent;", "Lio/customer/sdk/communication/Event$ScreenViewedEvent;", "Lio/customer/sdk/communication/Event$TrackInAppMetricEvent;", "Lio/customer/sdk/communication/Event$TrackPushMetricEvent;", "Lio/customer/sdk/communication/Event$UserChangedEvent;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Event {
    private final Map<String, String> params;
    private final String storageId;
    private final Date timestamp;

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/sdk/communication/Event$DeleteDeviceTokenEvent;", "Lio/customer/sdk/communication/Event;", "<init>", "()V", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeleteDeviceTokenEvent extends Event {
        public DeleteDeviceTokenEvent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/customer/sdk/communication/Event$RegisterDeviceTokenEvent;", "Lio/customer/sdk/communication/Event;", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class RegisterDeviceTokenEvent extends Event {
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RegisterDeviceTokenEvent(String token) {
            super(null);
            Intrinsics.checkNotNullParameter(token, "token");
            this.token = token;
        }

        public static /* synthetic */ RegisterDeviceTokenEvent copy$default(RegisterDeviceTokenEvent registerDeviceTokenEvent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registerDeviceTokenEvent.token;
            }
            return registerDeviceTokenEvent.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final RegisterDeviceTokenEvent copy(String token) {
            Intrinsics.checkNotNullParameter(token, "token");
            return new RegisterDeviceTokenEvent(token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RegisterDeviceTokenEvent) && Intrinsics.areEqual(this.token, ((RegisterDeviceTokenEvent) other).token);
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        public String toString() {
            return "RegisterDeviceTokenEvent(token=" + this.token + ")";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/sdk/communication/Event$ResetEvent;", "Lio/customer/sdk/communication/Event;", "<init>", "()V", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResetEvent extends Event {
        public static final ResetEvent INSTANCE = new ResetEvent();

        private ResetEvent() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/customer/sdk/communication/Event$ScreenViewedEvent;", "Lio/customer/sdk/communication/Event;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ScreenViewedEvent extends Event {
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenViewedEvent(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public static /* synthetic */ ScreenViewedEvent copy$default(ScreenViewedEvent screenViewedEvent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = screenViewedEvent.name;
            }
            return screenViewedEvent.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final ScreenViewedEvent copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new ScreenViewedEvent(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScreenViewedEvent) && Intrinsics.areEqual(this.name, ((ScreenViewedEvent) other).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "ScreenViewedEvent(name=" + this.name + ")";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/customer/sdk/communication/Event$TrackInAppMetricEvent;", "Lio/customer/sdk/communication/Event;", "deliveryID", "", NotificationCompat.CATEGORY_EVENT, "Lio/customer/sdk/events/Metric;", NativeProtocol.WEB_DIALOG_PARAMS, "", "<init>", "(Ljava/lang/String;Lio/customer/sdk/events/Metric;Ljava/util/Map;)V", "getDeliveryID", "()Ljava/lang/String;", "getEvent", "()Lio/customer/sdk/events/Metric;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TrackInAppMetricEvent extends Event {
        private final String deliveryID;
        private final Metric event;
        private final Map<String, String> params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackInAppMetricEvent(String deliveryID, Metric event, Map<String, String> params) {
            super(null);
            Intrinsics.checkNotNullParameter(deliveryID, "deliveryID");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            this.deliveryID = deliveryID;
            this.event = event;
            this.params = params;
        }

        public /* synthetic */ TrackInAppMetricEvent(String str, Metric metric, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, metric, (i & 4) != 0 ? MapsKt.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TrackInAppMetricEvent copy$default(TrackInAppMetricEvent trackInAppMetricEvent, String str, Metric metric, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trackInAppMetricEvent.deliveryID;
            }
            if ((i & 2) != 0) {
                metric = trackInAppMetricEvent.event;
            }
            if ((i & 4) != 0) {
                map = trackInAppMetricEvent.params;
            }
            return trackInAppMetricEvent.copy(str, metric, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeliveryID() {
            return this.deliveryID;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Metric getEvent() {
            return this.event;
        }

        public final Map<String, String> component3() {
            return this.params;
        }

        public final TrackInAppMetricEvent copy(String deliveryID, Metric event, Map<String, String> params) {
            Intrinsics.checkNotNullParameter(deliveryID, "deliveryID");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            return new TrackInAppMetricEvent(deliveryID, event, params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackInAppMetricEvent)) {
                return false;
            }
            TrackInAppMetricEvent trackInAppMetricEvent = (TrackInAppMetricEvent) other;
            return Intrinsics.areEqual(this.deliveryID, trackInAppMetricEvent.deliveryID) && this.event == trackInAppMetricEvent.event && Intrinsics.areEqual(this.params, trackInAppMetricEvent.params);
        }

        public final String getDeliveryID() {
            return this.deliveryID;
        }

        public final Metric getEvent() {
            return this.event;
        }

        @Override // io.customer.sdk.communication.Event
        public Map<String, String> getParams() {
            return this.params;
        }

        public int hashCode() {
            return (((this.deliveryID.hashCode() * 31) + this.event.hashCode()) * 31) + this.params.hashCode();
        }

        public String toString() {
            return "TrackInAppMetricEvent(deliveryID=" + this.deliveryID + ", event=" + this.event + ", params=" + this.params + ")";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lio/customer/sdk/communication/Event$TrackPushMetricEvent;", "Lio/customer/sdk/communication/Event;", "deliveryId", "", NotificationCompat.CATEGORY_EVENT, "Lio/customer/sdk/events/Metric;", "deviceToken", "<init>", "(Ljava/lang/String;Lio/customer/sdk/events/Metric;Ljava/lang/String;)V", "getDeliveryId", "()Ljava/lang/String;", "getEvent", "()Lio/customer/sdk/events/Metric;", "getDeviceToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TrackPushMetricEvent extends Event {
        private final String deliveryId;
        private final String deviceToken;
        private final Metric event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackPushMetricEvent(String deliveryId, Metric event, String deviceToken) {
            super(null);
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            this.deliveryId = deliveryId;
            this.event = event;
            this.deviceToken = deviceToken;
        }

        public static /* synthetic */ TrackPushMetricEvent copy$default(TrackPushMetricEvent trackPushMetricEvent, String str, Metric metric, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trackPushMetricEvent.deliveryId;
            }
            if ((i & 2) != 0) {
                metric = trackPushMetricEvent.event;
            }
            if ((i & 4) != 0) {
                str2 = trackPushMetricEvent.deviceToken;
            }
            return trackPushMetricEvent.copy(str, metric, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeliveryId() {
            return this.deliveryId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Metric getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDeviceToken() {
            return this.deviceToken;
        }

        public final TrackPushMetricEvent copy(String deliveryId, Metric event, String deviceToken) {
            Intrinsics.checkNotNullParameter(deliveryId, "deliveryId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
            return new TrackPushMetricEvent(deliveryId, event, deviceToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackPushMetricEvent)) {
                return false;
            }
            TrackPushMetricEvent trackPushMetricEvent = (TrackPushMetricEvent) other;
            return Intrinsics.areEqual(this.deliveryId, trackPushMetricEvent.deliveryId) && this.event == trackPushMetricEvent.event && Intrinsics.areEqual(this.deviceToken, trackPushMetricEvent.deviceToken);
        }

        public final String getDeliveryId() {
            return this.deliveryId;
        }

        public final String getDeviceToken() {
            return this.deviceToken;
        }

        public final Metric getEvent() {
            return this.event;
        }

        public int hashCode() {
            return (((this.deliveryId.hashCode() * 31) + this.event.hashCode()) * 31) + this.deviceToken.hashCode();
        }

        public String toString() {
            return "TrackPushMetricEvent(deliveryId=" + this.deliveryId + ", event=" + this.event + ", deviceToken=" + this.deviceToken + ")";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lio/customer/sdk/communication/Event$UserChangedEvent;", "Lio/customer/sdk/communication/Event;", "userId", "", "anonymousId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getAnonymousId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class UserChangedEvent extends Event {
        private final String anonymousId;
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserChangedEvent(String str, String anonymousId) {
            super(null);
            Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
            this.userId = str;
            this.anonymousId = anonymousId;
        }

        public static /* synthetic */ UserChangedEvent copy$default(UserChangedEvent userChangedEvent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userChangedEvent.userId;
            }
            if ((i & 2) != 0) {
                str2 = userChangedEvent.anonymousId;
            }
            return userChangedEvent.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAnonymousId() {
            return this.anonymousId;
        }

        public final UserChangedEvent copy(String userId, String anonymousId) {
            Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
            return new UserChangedEvent(userId, anonymousId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserChangedEvent)) {
                return false;
            }
            UserChangedEvent userChangedEvent = (UserChangedEvent) other;
            return Intrinsics.areEqual(this.userId, userChangedEvent.userId) && Intrinsics.areEqual(this.anonymousId, userChangedEvent.anonymousId);
        }

        public final String getAnonymousId() {
            return this.anonymousId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            String str = this.userId;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.anonymousId.hashCode();
        }

        public String toString() {
            return "UserChangedEvent(userId=" + this.userId + ", anonymousId=" + this.anonymousId + ")";
        }
    }

    private Event() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.storageId = string;
        this.params = MapsKt.emptyMap();
        this.timestamp = new Date();
    }

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String getStorageId() {
        return this.storageId;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }
}
