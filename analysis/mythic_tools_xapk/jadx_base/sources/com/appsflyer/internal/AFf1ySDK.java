package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1ySDK extends AFe1uSDK<Map<String, Object>> {
    private static final int component2 = (int) TimeUnit.SECONDS.toMillis(2);
    private Map<String, Object> areAllFieldsValid;
    private final AFa1oSDK component1;
    private final AFa1jSDK component3;
    private final Uri component4;
    private final List<String> hashCode;

    public AFf1ySDK(AFa1oSDK aFa1oSDK, AFa1jSDK aFa1jSDK, Uri uri, List<String> list) {
        super(AFe1lSDK.RESOLVE_ESP, new AFe1lSDK[]{AFe1lSDK.RC_CDN}, "ResolveEsp");
        this.component1 = aFa1oSDK;
        this.component3 = aFa1jSDK;
        this.component4 = uri;
        this.hashCode = list;
    }

    private boolean getRevenue(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        AFLogger.afRDLog(new StringBuilder("Validate if link ").append(str).append(" belongs to ESP domains: ").append(this.hashCode).toString());
        try {
            return this.hashCode.contains(new URL(str).getHost());
        } catch (MalformedURLException e) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e);
            return false;
        }
    }

    private static Map<String, Object> r_(Uri uri) {
        HashMap map = new HashMap();
        try {
            AFLogger.afDebugLog(new StringBuilder("ESP deeplink resolving is started: ").append(uri.toString()).toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            int i = component2;
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.18.0");
            int responseCode = httpURLConnection.getResponseCode();
            map.put("status", Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                map.put("res", httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
            return map;
        } catch (Throwable th) {
            map.put("error", th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
            return map;
        }
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final AFe1rSDK getMediationNetwork() throws Exception {
        Integer num = null;
        if (!getRevenue(this.component4.toString())) {
            this.component1.j_(this.component3, this.component4, null);
            return AFe1rSDK.SUCCESS;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = this.component4.toString();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String str = null;
        while (i < 5) {
            Map<String, Object> mapR_ = r_(Uri.parse(string));
            String str2 = (String) mapR_.get("res");
            Integer num2 = (Integer) mapR_.get("status");
            String str3 = (String) mapR_.get("error");
            if (str2 == null || !getRevenue(str2)) {
                str = str3;
                string = str2;
                num = num2;
                break;
            }
            if (i < 4) {
                arrayList.add(str2);
            }
            i++;
            str = str3;
            string = str2;
            num = num2;
        }
        HashMap map = new HashMap();
        map.put("res", string != null ? string : "");
        map.put("status", Integer.valueOf(num != null ? num.intValue() : -1));
        if (str != null) {
            map.put("error", str);
        }
        if (!arrayList.isEmpty()) {
            map.put("redirects", arrayList);
        }
        map.put("latency", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        synchronized (this.component3) {
            this.component3.getMediationNetwork("af_deeplink_r", map);
            this.component3.getMediationNetwork("af_deeplink", this.component4.toString());
        }
        this.component1.j_(this.component3, string != null ? Uri.parse(string) : this.component4, this.component4);
        this.areAllFieldsValid = map;
        return AFe1rSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return DurationKt.MILLIS_IN_MINUTE;
    }
}
