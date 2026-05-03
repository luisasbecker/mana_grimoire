package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFa1rSDK implements AFe1wSDK<AFa1mSDK> {
    @Override // com.appsflyer.internal.AFe1wSDK
    public final /* synthetic */ AFa1mSDK getCurrencyIso4217Code(String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        String str2 = str;
        DeepLink mediationNetwork = null;
        if (str2 == null || str2.length() == 0) {
            return new AFa1mSDK(false, null, 3, null);
        }
        JSONObject jSONObject = new JSONObject(str);
        boolean zOptBoolean = jSONObject.optBoolean("found", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("is_second_ping", true);
        if (zOptBoolean && (jSONObjectOptJSONObject = jSONObject.optJSONObject("click_event")) != null) {
            mediationNetwork = DeepLink.getMediationNetwork(jSONObjectOptJSONObject);
            mediationNetwork.getMediationNetwork.put("is_deferred", true);
        }
        return new AFa1mSDK(zOptBoolean2, mediationNetwork);
    }
}
