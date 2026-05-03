package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1bSDK implements AFh1ySDK {
    private AFg1gSDK getCurrencyIso4217Code;
    private AFg1aSDK getMediationNetwork;
    private final AFd1zSDK getMonetizationNetwork;
    private AFg1eSDK getRevenue;

    public AFg1bSDK(AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.getMonetizationNetwork = aFd1zSDK;
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void AFAdRevenueData() {
        AFg1eSDK aFg1eSDK = this.getRevenue;
        if (aFg1eSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1hSDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFg1eSDK);
            this.getRevenue = null;
        }
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void areAllFieldsValid() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1hSDK[] aFg1hSDKArr = new AFg1hSDK[1];
        if (this.getRevenue == null) {
            this.getRevenue = new AFg1eSDK();
        }
        AFg1eSDK aFg1eSDK = this.getRevenue;
        Intrinsics.checkNotNull(aFg1eSDK);
        aFg1hSDKArr[0] = aFg1eSDK;
        aFLogger.registerClient(aFg1hSDKArr);
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void getCurrencyIso4217Code() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1hSDK[] aFg1hSDKArr = new AFg1hSDK[1];
        if (this.getCurrencyIso4217Code == null) {
            this.getCurrencyIso4217Code = new AFg1gSDK(this.getMonetizationNetwork);
        }
        AFg1gSDK aFg1gSDK = this.getCurrencyIso4217Code;
        Intrinsics.checkNotNull(aFg1gSDK);
        aFg1hSDKArr[0] = aFg1gSDK;
        aFLogger.registerClient(aFg1hSDKArr);
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void getMediationNetwork() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1hSDK[] aFg1hSDKArr = new AFg1hSDK[1];
        if (this.getMediationNetwork == null) {
            this.getMediationNetwork = new AFg1aSDK(this.getMonetizationNetwork);
        }
        AFg1aSDK aFg1aSDK = this.getMediationNetwork;
        Intrinsics.checkNotNull(aFg1aSDK);
        aFg1hSDKArr[0] = aFg1aSDK;
        aFLogger.registerClient(aFg1hSDKArr);
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void getMonetizationNetwork() {
        AFg1aSDK aFg1aSDK = this.getMediationNetwork;
        if (aFg1aSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1hSDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFg1aSDK);
            this.getMediationNetwork = null;
        }
    }

    @Override // com.appsflyer.internal.AFh1ySDK
    public final void getRevenue() {
        AFg1gSDK aFg1gSDK = this.getCurrencyIso4217Code;
        if (aFg1gSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1hSDK.v$default(aFLogger, AFg1cSDK.EXCEPTION_MANAGER, "Releasing Exception Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFg1gSDK);
            this.getCurrencyIso4217Code = null;
        }
    }
}
