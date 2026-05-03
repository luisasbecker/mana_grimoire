package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFe1qSDK.AnonymousClass1;

/* JADX INFO: loaded from: classes3.dex */
public final class AFe1fSDK extends AFe1uSDK<Boolean> {
    private static volatile boolean component1 = false;
    private final AFd1zSDK areAllFieldsValid;
    private final AFc1vSDK component2;
    private final AFe1qSDK component3;
    private Boolean component4;

    public AFe1fSDK(AFd1zSDK aFd1zSDK) {
        super(AFe1lSDK.LOAD_CACHE, new AFe1lSDK[0], "LoadCachedRequests");
        this.component2 = aFd1zSDK.AFKeystoreWrapper();
        this.component3 = aFd1zSDK.equals();
        this.areAllFieldsValid = aFd1zSDK;
    }

    private static String AFAdRevenueData(AFc1rSDK aFc1rSDK) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = Long.parseLong(aFc1rSDK.AFAdRevenueData, 10);
        String str = aFc1rSDK.getRevenue;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", "true").appendQueryParameter("timeincache", String.valueOf((jCurrentTimeMillis - j) / 1000)).toString();
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e);
            return str;
        }
    }

    public static boolean areAllFieldsValid() {
        return component1;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final AFe1rSDK getMediationNetwork() throws Exception {
        for (AFc1rSDK aFc1rSDK : this.component2.AFAdRevenueData()) {
            AFLogger.INSTANCE.i(AFg1cSDK.CACHE, new StringBuilder("resending request: ").append(aFc1rSDK.getRevenue).toString());
            try {
                AFh1jSDK aFh1jSDK = new AFh1jSDK(AFAdRevenueData(aFc1rSDK), aFc1rSDK.getCurrencyIso4217Code(), aFc1rSDK.AFAdRevenueData, aFc1rSDK.getMonetizationNetwork, aFc1rSDK.getCurrencyIso4217Code);
                AFe1qSDK aFe1qSDK = this.component3;
                aFe1qSDK.getMonetizationNetwork.execute(aFe1qSDK.new AnonymousClass1(new AFe1aSDK(aFh1jSDK, this.areAllFieldsValid)));
            } catch (Exception e) {
                AFLogger.INSTANCE.e(AFg1cSDK.QUEUE, "Failed to resend cached request", e);
            }
        }
        this.component4 = Boolean.TRUE;
        component1 = true;
        return AFe1rSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return 30000L;
    }
}
