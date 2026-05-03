package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public final class AFe1aSDK extends AFe1bSDK<String> {
    private final AFh1jSDK component2;

    public AFe1aSDK(AFh1jSDK aFh1jSDK, AFd1zSDK aFd1zSDK) {
        super(aFh1jSDK.hashCode != null ? aFh1jSDK.hashCode : AFe1lSDK.CACHED_EVENT, new AFe1lSDK[]{AFe1lSDK.RC_CDN}, aFd1zSDK, new StringBuilder().append(aFh1jSDK.component4).append("-").append(getMonetizationNetwork(aFh1jSDK)).toString(), aFh1jSDK.component4);
        this.component2 = aFh1jSDK;
    }

    private boolean copydefault() {
        AFh1jSDK aFh1jSDK = this.component2;
        return (aFh1jSDK.hashCode != null ? aFh1jSDK.hashCode : AFe1lSDK.CACHED_EVENT) == AFe1lSDK.ARS_VALIDATE && ((AFe1bSDK) this).component4 != null && ((AFe1bSDK) this).component4.getStatusCode() == 424;
    }

    private boolean equals() {
        ResponseNetwork responseNetwork = ((AFe1bSDK) this).component4;
        return (this.AFAdRevenueData == AFe1rSDK.FAILURE && responseNetwork != null && responseNetwork.getStatusCode() / 500 == 1) && (this.getMonetizationNetwork == AFe1lSDK.CONVERSION || this.getMonetizationNetwork == AFe1lSDK.ATTR);
    }

    private static String getMonetizationNetwork(AFh1jSDK aFh1jSDK) {
        try {
            return new URL(aFh1jSDK.component3).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return super.AFAdRevenueData() || copydefault() || equals();
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return this.component2.getCurrencyIso4217Code;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AFd1fSDK<String> getRevenue(String str) {
        String strEncodeToString = Base64.encodeToString(this.component2.getCurrencyIso4217Code(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(strEncodeToString)));
        ((AFe1bSDK) this).areAllFieldsValid.getMonetizationNetwork(this.component2.component3, strEncodeToString);
        return ((AFe1bSDK) this).component3.getRevenue(this.component2);
    }
}
