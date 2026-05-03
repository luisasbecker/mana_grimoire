package com.appsflyer.internal;

import com.appsflyer.internal.AFe1qSDK.AnonymousClass1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFa1uSDK implements Runnable {
    private final Map<String, Object> getCurrencyIso4217Code;
    private final AFd1zSDK getMediationNetwork;
    private final AFh1sSDK getRevenue;

    public AFa1uSDK(AFd1zSDK aFd1zSDK, AFh1sSDK aFh1sSDK, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        this.getMediationNetwork = aFd1zSDK;
        this.getRevenue = aFh1sSDK;
        this.getCurrencyIso4217Code = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AFf1xSDK aFf1xSDK;
        if (this.getRevenue.AFAdRevenueData()) {
            AFf1tSDK aFf1tSDK = new AFf1tSDK(this.getRevenue, this.getMediationNetwork);
            aFf1tSDK.copy = this.getCurrencyIso4217Code;
            aFf1xSDK = aFf1tSDK;
        } else {
            aFf1xSDK = this.getRevenue instanceof AFh1qSDK ? new AFf1xSDK((AFh1qSDK) this.getRevenue, this.getMediationNetwork) : new AFf1rSDK(this.getRevenue, this.getMediationNetwork);
        }
        AFe1qSDK aFe1qSDKEquals = this.getMediationNetwork.equals();
        aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(aFf1xSDK));
    }
}
