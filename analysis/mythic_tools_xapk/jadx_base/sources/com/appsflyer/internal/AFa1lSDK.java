package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFa1lSDK implements AFa1gSDK {
    private final AFc1jSDK getMediationNetwork;

    public AFa1lSDK(AFc1jSDK aFc1jSDK) {
        Intrinsics.checkNotNullParameter(aFc1jSDK, "");
        this.getMediationNetwork = aFc1jSDK;
    }

    @Override // com.appsflyer.internal.AFa1gSDK
    public final Map<String, Object> getMediationNetwork() {
        if (this.getMediationNetwork.getMonetizationNetwork("deeplink_data")) {
            try {
                String revenue = this.getMediationNetwork.getRevenue("deeplink_data", (String) null);
                return revenue == null ? MapsKt.emptyMap() : AFj1eSDK.getMonetizationNetwork(new JSONObject(revenue));
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while parsing stored deeplink data", th, true, false);
            }
        }
        return MapsKt.emptyMap();
    }

    @Override // com.appsflyer.internal.AFa1gSDK
    public final void getMonetizationNetwork(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.getMediationNetwork.getMediationNetwork("deeplink_data", new JSONObject(map).toString());
    }

    @Override // com.appsflyer.internal.AFa1gSDK
    public final void getRevenue() {
        this.getMediationNetwork.getCurrencyIso4217Code("deeplink_data");
    }
}
