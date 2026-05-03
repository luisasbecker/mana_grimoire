package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFe1qSDK.AnonymousClass1;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1mSDK implements AFe1tSDK {
    private final Object AFAdRevenueData = new Object();
    private final AFe1qSDK areAllFieldsValid;
    private AFi1vSDK component1;
    private final AFf1oSDK component2;
    private final AFc1gSDK component3;
    private final AFd1mSDK component4;
    private AFf1nSDK copydefault;
    public final AFf1pSDK getCurrencyIso4217Code;
    private final AFc1kSDK getMediationNetwork;
    private final AFf1kSDK getMonetizationNetwork;
    private final AFf1qSDK getRevenue;

    public AFf1mSDK(AFf1qSDK aFf1qSDK, AFc1kSDK aFc1kSDK, AFf1kSDK aFf1kSDK, AFf1pSDK aFf1pSDK, AFd1mSDK aFd1mSDK, AFf1oSDK aFf1oSDK, AFe1qSDK aFe1qSDK, AFc1gSDK aFc1gSDK) {
        this.getRevenue = aFf1qSDK;
        this.getMediationNetwork = aFc1kSDK;
        this.getMonetizationNetwork = aFf1kSDK;
        this.getCurrencyIso4217Code = aFf1pSDK;
        this.component4 = aFd1mSDK;
        this.component2 = aFf1oSDK;
        this.areAllFieldsValid = aFe1qSDK;
        this.component3 = aFc1gSDK;
        aFe1qSDK.getMediationNetwork.add(this);
    }

    private void getMediationNetwork(AFf1nSDK aFf1nSDK, AFf1uSDK aFf1uSDK) {
        synchronized (this.AFAdRevenueData) {
            this.copydefault = aFf1nSDK;
        }
        if (aFf1uSDK != null) {
            aFf1uSDK.onRemoteConfigUpdateFinished(aFf1nSDK);
        }
    }

    public final AFi1vSDK AFAdRevenueData() {
        AFi1vSDK aFi1vSDK;
        synchronized (this.AFAdRevenueData) {
            aFi1vSDK = this.component1;
            this.component1 = null;
        }
        return aFi1vSDK;
    }

    public final void AFAdRevenueData(AFf1uSDK aFf1uSDK) {
        AFf1vSDK aFf1vSDK = new AFf1vSDK(this.getRevenue, this.getMediationNetwork, this.getMonetizationNetwork, this.getCurrencyIso4217Code, this.component4, this.component2, "v1", aFf1uSDK, this.component3);
        AFe1qSDK aFe1qSDK = this.areAllFieldsValid;
        aFe1qSDK.getMonetizationNetwork.execute(aFe1qSDK.new AnonymousClass1(aFf1vSDK));
    }

    @Override // com.appsflyer.internal.AFe1tSDK
    public final void getMediationNetwork(AFe1uSDK<?> aFe1uSDK, AFe1rSDK aFe1rSDK) {
        if (aFe1uSDK instanceof AFf1vSDK) {
            AFf1vSDK aFf1vSDK = (AFf1vSDK) aFe1uSDK;
            AFf1nSDK aFf1nSDK = aFf1vSDK.component3;
            if (aFf1nSDK == null) {
                AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "update RC returned null result, something went wrong!");
                aFf1nSDK = AFf1nSDK.FAILURE;
            }
            if (aFf1nSDK != AFf1nSDK.USE_CACHED) {
                AFi1vSDK aFi1vSDK = aFf1vSDK.component1;
                synchronized (this.AFAdRevenueData) {
                    this.component1 = aFi1vSDK;
                }
            }
            getMediationNetwork(aFf1nSDK, aFf1vSDK.component4);
        }
    }

    @Override // com.appsflyer.internal.AFe1tSDK
    public final void getMonetizationNetwork(AFe1uSDK<?> aFe1uSDK) {
        if (aFe1uSDK instanceof AFf1vSDK) {
            AFf1vSDK aFf1vSDK = (AFf1vSDK) aFe1uSDK;
            synchronized (this.AFAdRevenueData) {
                this.component1 = null;
            }
            getMediationNetwork(AFf1nSDK.FAILURE, aFf1vSDK.component4);
        }
    }
}
