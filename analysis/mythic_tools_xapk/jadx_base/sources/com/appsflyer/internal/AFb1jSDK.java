package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.oaid.OaidClient;

/* JADX INFO: loaded from: classes3.dex */
public final class AFb1jSDK {
    public static String getCurrencyIso4217Code;
    public static Boolean getRevenue;

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AFb1mSDK getRevenue(Context context) {
        Boolean lat;
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        String str = getCurrencyIso4217Code;
        boolean z = str != null;
        if (z) {
            lat = null;
        } else {
            Boolean bool = getRevenue;
            if ((bool == null || !bool.booleanValue()) && !(getRevenue == null && appsFlyerProperties.getBoolean(AppsFlyerProperties.COLLECT_OAID, true))) {
                lat = null;
                str = null;
            } else {
                try {
                    OaidClient oaidClient = new OaidClient(context);
                    oaidClient.setLogging(appsFlyerProperties.isEnableLog());
                    OaidClient.Info infoFetch = oaidClient.fetch();
                    if (infoFetch != null) {
                        String id = infoFetch.getId();
                        try {
                            lat = infoFetch.getLat();
                            str = id;
                        } catch (Throwable unused) {
                            str = id;
                            AFLogger.afDebugLog("No OAID library");
                            lat = null;
                        }
                    }
                } catch (Throwable unused2) {
                    str = null;
                }
            }
        }
        if (str == null) {
            return null;
        }
        AFb1mSDK aFb1mSDK = new AFb1mSDK(str, lat);
        aFb1mSDK.getCurrencyIso4217Code = Boolean.valueOf(z);
        return aFb1mSDK;
    }

    private static boolean getRevenue() {
        Boolean bool = getRevenue;
        return bool == null || bool.booleanValue();
    }

    public static AFb1mSDK l_(ContentResolver contentResolver) {
        String string;
        if (!getRevenue() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i == 0) {
            return new AFb1mSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i == 2) {
            return null;
        }
        try {
            string = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            string = "";
        }
        return new AFb1mSDK(string, Boolean.TRUE);
    }
}
