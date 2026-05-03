package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFg1ySDK;
import com.caverock.androidsvg.SVGParser;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1wSDK implements AFg1ySDK {
    private static IntentFilter getMonetizationNetwork = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    @Override // com.appsflyer.internal.AFg1ySDK
    public final AFg1ySDK.AFa1tSDK getMonetizationNetwork(Context context) {
        String str = null;
        float f = 0.0f;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, getMonetizationNetwork);
            if (intentRegisterReceiver != null) {
                if (2 == intentRegisterReceiver.getIntExtra("status", -1)) {
                    int intExtra = intentRegisterReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO;
                }
                int intExtra2 = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (-1 != intExtra2 && -1 != intExtra3) {
                    f = (intExtra2 * 100.0f) / intExtra3;
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("Device that failed to register receiver", th);
        }
        return new AFg1ySDK.AFa1tSDK(f, str);
    }
}
