package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1bSDK {
    public final AFc1jSDK getCurrencyIso4217Code;

    public AFf1bSDK(Context context) {
        this.getCurrencyIso4217Code = AFa1tSDK.getMediationNetwork().getMediationNetwork(context);
    }

    public static boolean getMonetizationNetwork(AFc1jSDK aFc1jSDK) {
        return aFc1jSDK.getRevenue("sentRegisterRequestToAF");
    }

    public static boolean getRevenue(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.UNINSTALL, "An error occurred while trying to verify manifest declarations: ", th);
        }
        return AFj1pSDK.L_(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class));
    }

    public final AFg1xSDK getMonetizationNetwork() {
        String string;
        String string2;
        String revenue = this.getCurrencyIso4217Code.getRevenue("afUninstallToken", (String) null);
        long mediationNetwork = this.getCurrencyIso4217Code.getMediationNetwork("afUninstallToken_received_time", 0L);
        boolean revenue2 = this.getCurrencyIso4217Code.getRevenue("afUninstallToken_queued");
        this.getCurrencyIso4217Code.getRevenue("afUninstallToken_queued", false);
        if (revenue == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            revenue = string2.split(",")[r0.length - 1];
        }
        if (mediationNetwork == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length >= 2) {
                try {
                    mediationNetwork = Long.parseLong(strArrSplit[strArrSplit.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (revenue != null) {
            return new AFg1xSDK(revenue, mediationNetwork, revenue2);
        }
        return null;
    }
}
