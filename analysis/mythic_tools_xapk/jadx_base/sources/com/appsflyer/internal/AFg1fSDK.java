package com.appsflyer.internal;

import androidx.webkit.ProxyConfig;
import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1fSDK {
    public static void AFAdRevenueData(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("appsflyerKey")) {
                    jSONObject.put("appsflyerKey", getCurrencyIso4217Code(jSONObject.getString("appsflyerKey")));
                }
                if (jSONObject.has("tcstring")) {
                    jSONObject.put("tcstring", getMediationNetwork("tcstring"));
                }
                if (jSONObject.has("referrer")) {
                    jSONObject.put("referrer", getMediationNetwork("referrer"));
                }
                AFLogger.INSTANCE.i(AFg1cSDK.OTHER, new StringBuilder().append(str).append(jSONObject).toString());
            } catch (JSONException e) {
                AFLogger.INSTANCE.e(AFg1cSDK.OTHER, "Not able to log the payload", e);
            }
        }
    }

    private static String getCurrencyIso4217Code(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                sb.append(str.charAt(i));
            } else {
                sb.append(ProxyConfig.MATCH_ALL_SCHEMES);
            }
        }
        return sb.toString();
    }

    public static String getMediationNetwork(String str) {
        return str.length() > 20 ? new StringBuilder().append(str.substring(0, 10)).append("...").toString() : str;
    }
}
