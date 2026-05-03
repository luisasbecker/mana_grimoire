package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1uSDK {
    public final AFc1jSDK AFAdRevenueData;
    public long equals;
    public final AFc1kSDK getMediationNetwork;
    public final Map<String, Object> getCurrencyIso4217Code = new ConcurrentHashMap();
    public final Map<String, Object> getMonetizationNetwork = new ConcurrentHashMap();
    public final Map<String, Object> getRevenue = new ConcurrentHashMap();
    public long component3 = 0;
    public long component1 = 0;
    public final long[] areAllFieldsValid = new long[2];
    public final long[] component2 = new long[2];
    public final long[] component4 = new long[2];
    public long hashCode = 0;
    public long copydefault = 0;

    public AFh1uSDK(AFc1jSDK aFc1jSDK, AFc1kSDK aFc1kSDK) {
        this.AFAdRevenueData = aFc1jSDK;
        this.getMediationNetwork = aFc1kSDK;
    }

    public final Map<String, Object> AFAdRevenueData(String str) {
        Map<String, Object> mapEmptyMap = Collections.emptyMap();
        String revenue = this.AFAdRevenueData.getRevenue(str, (String) null);
        if (revenue != null) {
            try {
                return AFg1lSDK.getMediationNetwork(new JSONObject(revenue));
            } catch (Exception e) {
                AFLogger.afErrorLog("Error while parsing cached json data", e, true);
            }
        }
        return mapEmptyMap;
    }

    public final boolean getCurrencyIso4217Code() {
        return this.getMediationNetwork.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) == 1;
    }

    public final void getMediationNetwork(DeepLinkResult deepLinkResult, long j) {
        this.getMonetizationNetwork.put("status", deepLinkResult.getStatus().toString());
        this.getMonetizationNetwork.put("timeout_value", Long.valueOf(j));
    }

    public final boolean getMediationNetwork() {
        return this.getMediationNetwork.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) == 0;
    }

    public final void getMonetizationNetwork() {
        this.component1 = System.currentTimeMillis();
        if (getMediationNetwork()) {
            long j = this.component3;
            if (j == 0) {
                AFLogger.afInfoLog("Metrics: init ts is missing");
                return;
            }
            this.getCurrencyIso4217Code.put("init_to_fg", Long.valueOf(this.component1 - j));
            this.AFAdRevenueData.getMediationNetwork("first_launch", new JSONObject(this.getCurrencyIso4217Code).toString());
        }
    }

    public final void getRevenue(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.copydefault;
        if (j != 0) {
            this.getRevenue.put("net", Long.valueOf(jCurrentTimeMillis - j));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.getRevenue.put("retries", Integer.valueOf(i));
        this.AFAdRevenueData.getMediationNetwork("gcd", new JSONObject(this.getRevenue).toString());
    }

    public final void getRevenue(AFh1zSDK aFh1zSDK) {
        if (getMediationNetwork()) {
            this.getCurrencyIso4217Code.put("start_with", aFh1zSDK.toString());
            this.AFAdRevenueData.getMediationNetwork("first_launch", new JSONObject(this.getCurrencyIso4217Code).toString());
        }
    }
}
