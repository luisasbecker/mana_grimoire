package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AFi1hSDK extends AFj1zSDK {
    private AFc1kSDK getMediationNetwork;

    public AFi1hSDK(String str, String str2, AFc1kSDK aFc1kSDK, Runnable runnable) {
        super(str, str2, runnable);
        this.getMediationNetwork = aFc1kSDK;
    }

    protected final boolean getMonetizationNetwork() {
        if (this.getMediationNetwork.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) <= 0) {
            return true;
        }
        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install referrer will not load, the counter >= 1, ");
        return false;
    }
}
