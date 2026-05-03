package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFb1qSDK {
    public final Map<String, Object> getMonetizationNetwork = new HashMap();
    public Map<String, Object> getMediationNetwork = new HashMap();

    public final void AFAdRevenueData(Map<String, Object> map) {
        if (!this.getMonetizationNetwork.isEmpty()) {
            map.put("partner_data", this.getMonetizationNetwork);
        }
        if (this.getMediationNetwork.isEmpty()) {
            return;
        }
        AFa1tSDK.getMonetizationNetwork(map).put("partner_data", this.getMediationNetwork);
        this.getMediationNetwork = new HashMap();
    }
}
