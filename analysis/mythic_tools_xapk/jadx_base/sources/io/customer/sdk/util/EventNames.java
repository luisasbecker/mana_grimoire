package io.customer.sdk.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: EventNames.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/customer/sdk/util/EventNames;", "", "<init>", "()V", "DEVICE_UPDATE", "", "DEVICE_DELETE", "METRIC_DELIVERY", "APPLICATION_BACKGROUNDED", "LOCATION_UPDATE", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventNames {
    public static final String APPLICATION_BACKGROUNDED = "Application Backgrounded";
    public static final String DEVICE_DELETE = "Device Deleted";
    public static final String DEVICE_UPDATE = "Device Created or Updated";
    public static final EventNames INSTANCE = new EventNames();
    public static final String LOCATION_UPDATE = "CIO Location Update";
    public static final String METRIC_DELIVERY = "Report Delivery Event";

    private EventNames() {
    }
}
