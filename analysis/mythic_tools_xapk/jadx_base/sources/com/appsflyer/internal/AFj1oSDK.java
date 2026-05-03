package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Lcom/appsflyer/internal/AFj1oSDK;", "", "", "", "AFAdRevenueData", "()Ljava/util/Map;", "", "getMonetizationNetwork", "()V", "getMediationNetwork", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AFj1oSDK {

    /* JADX INFO: renamed from: AFa1ySDK, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getMonetizationNetwork;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFj1oSDK$AFa1ySDK, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion getMonetizationNetwork = new Companion();

        private Companion() {
        }
    }

    Map<String, Object> AFAdRevenueData();

    void getMediationNetwork();

    void getMonetizationNetwork();
}
