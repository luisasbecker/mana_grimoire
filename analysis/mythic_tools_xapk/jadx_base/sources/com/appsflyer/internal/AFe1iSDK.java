package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.common.net.HttpHeaders;

/* JADX INFO: loaded from: classes3.dex */
public final class AFe1iSDK extends AFe1bSDK<String> {
    private final String component2;
    private final AFk1ySDK copy;
    private final AFc1kSDK copydefault;

    public AFe1iSDK(AFd1zSDK aFd1zSDK, String str, AFk1ySDK aFk1ySDK) {
        super(AFe1lSDK.IMPRESSIONS, new AFe1lSDK[]{AFe1lSDK.RC_CDN, AFe1lSDK.FETCH_ADVERTISING_ID}, aFd1zSDK, str);
        this.component2 = str;
        this.copy = aFk1ySDK;
        this.copydefault = aFd1zSDK.AFAdRevenueData();
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        super.getMonetizationNetwork();
        AFe1ySDK<Result> aFe1ySDK = ((AFe1bSDK) this).component4;
        if (aFe1ySDK != 0) {
            int statusCode = aFe1ySDK.getStatusCode();
            if (statusCode == 200) {
                AFLogger.afInfoLog(new StringBuilder("Cross promotion impressions success: ").append(this.component2).toString(), false);
                return;
            }
            if (statusCode != 301 && statusCode != 302) {
                AFLogger.afInfoLog(new StringBuilder("call to ").append(this.component2).append(" failed: ").append(statusCode).toString());
                return;
            }
            AFLogger.afInfoLog(new StringBuilder("Cross promotion redirection success: ").append(this.component2).toString(), false);
            String strAFAdRevenueData = aFe1ySDK.AFAdRevenueData(HttpHeaders.LOCATION);
            AFk1ySDK aFk1ySDK = this.copy;
            if (aFk1ySDK == null || strAFAdRevenueData == null) {
                return;
            }
            aFk1ySDK.getMonetizationNetwork = strAFAdRevenueData;
            AFk1ySDK aFk1ySDK2 = this.copy;
            Context context = aFk1ySDK2.getRevenue.get();
            if (context != null) {
                try {
                    if (aFk1ySDK2.getMonetizationNetwork != null) {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFk1ySDK2.getMonetizationNetwork)).setFlags(268435456));
                    }
                } catch (Exception e) {
                    AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e)), e);
                }
            }
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AFd1fSDK<String> getRevenue(String str) {
        AFd1mSDK aFd1mSDK = ((AFe1bSDK) this).component3;
        String monetizationNetwork = this.copydefault.getMonetizationNetwork();
        boolean mediationNetwork = AFk1zSDK.getMediationNetwork(monetizationNetwork);
        String string = this.component2;
        if (!mediationNetwork) {
            string = Uri.parse(string).buildUpon().appendQueryParameter("advertising_id", monetizationNetwork).build().toString();
        }
        return aFd1mSDK.getCurrencyIso4217Code(string);
    }
}
