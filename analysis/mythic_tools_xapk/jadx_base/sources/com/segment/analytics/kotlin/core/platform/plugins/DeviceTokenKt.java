package com.segment.analytics.kotlin.core.platform.plugins;

import com.segment.analytics.kotlin.core.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DeviceToken.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setDeviceToken", "", "Lcom/segment/analytics/kotlin/core/Analytics;", "token", "", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DeviceTokenKt {
    public static final void setDeviceToken(Analytics analytics, String token) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        DeviceToken deviceToken = (DeviceToken) analytics.find(Reflection.getOrCreateKotlinClass(DeviceToken.class));
        if (deviceToken != null) {
            deviceToken.setToken(token);
        } else {
            analytics.add(new DeviceToken(token));
        }
    }
}
