package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1cSDK {
    public final String AFAdRevenueData;
    public final AFh1gSDK getCurrencyIso4217Code;
    public final AFh1aSDK getMediationNetwork;
    private final boolean getMonetizationNetwork;
    public final String getRevenue;

    public AFh1cSDK(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("ver");
            this.AFAdRevenueData = string;
            this.getMonetizationNetwork = jSONObject.optBoolean("test_mode");
            this.getRevenue = str;
            this.getCurrencyIso4217Code = string.startsWith("default") ? AFh1gSDK.DEFAULT : AFh1gSDK.CUSTOM;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("features");
            this.getMediationNetwork = jSONObjectOptJSONObject != null ? new AFh1aSDK(jSONObjectOptJSONObject) : null;
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e);
            throw new JSONException("Failed to parse remote configuration JSON");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFh1cSDK aFh1cSDK = (AFh1cSDK) obj;
        if (this.getMonetizationNetwork == aFh1cSDK.getMonetizationNetwork && this.AFAdRevenueData.equals(aFh1cSDK.AFAdRevenueData)) {
            return this.getRevenue.equals(aFh1cSDK.getRevenue);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.getMonetizationNetwork ? 1 : 0) * 31) + this.AFAdRevenueData.hashCode()) * 31) + this.getRevenue.hashCode();
        AFh1aSDK aFh1aSDK = this.getMediationNetwork;
        return aFh1aSDK != null ? (iHashCode * 31) + aFh1aSDK.hashCode() : iHashCode;
    }
}
