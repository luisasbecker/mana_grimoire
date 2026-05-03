package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1pSDK {
    public final AFc1jSDK getCurrencyIso4217Code;
    public long getMediationNetwork;
    public long getRevenue;
    public AFh1cSDK getMonetizationNetwork = null;
    public AFh1cSDK AFAdRevenueData = getMonetizationNetwork();

    public AFf1pSDK(AFc1jSDK aFc1jSDK) {
        this.getCurrencyIso4217Code = aFc1jSDK;
        this.getRevenue = aFc1jSDK.getMediationNetwork("af_rc_timestamp", 0L);
        this.getMediationNetwork = aFc1jSDK.getMediationNetwork("af_rc_max_age", 0L);
    }

    private AFh1cSDK getMonetizationNetwork() {
        String revenue = this.getCurrencyIso4217Code.getRevenue("af_remote_config", (String) null);
        if (revenue == null) {
            AFLogger.INSTANCE.d(AFg1cSDK.REMOTE_CONTROL, "No configuration found in cache");
            return null;
        }
        try {
            return new AFh1cSDK(new String(Base64.decode(revenue, 2), Charset.defaultCharset()));
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, "Error reading malformed configuration from cache, requires fetching from remote again", e, true);
            return null;
        }
    }
}
