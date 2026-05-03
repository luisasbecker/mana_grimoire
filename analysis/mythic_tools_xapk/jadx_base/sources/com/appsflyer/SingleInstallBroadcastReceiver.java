package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.appsflyer.internal.AFa1tSDK;

/* JADX INFO: loaded from: classes3.dex */
public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null) {
            return;
        }
        try {
            stringExtra = intent.getStringExtra("referrer");
        } catch (Throwable th) {
            AFLogger.afErrorLog("error in BroadcastReceiver ", th);
            stringExtra = null;
        }
        if (stringExtra != null && ((SharedPreferences) AFa1tSDK.getMonetizationNetwork(new Object[]{context}, 1469250199, -1469250196, (int) System.currentTimeMillis())).getString("referrer", null) != null) {
            AFa1tSDK.getMediationNetwork().getMediationNetwork(context, stringExtra);
            return;
        }
        String string = AppsFlyerProperties.getInstance().getString("referrer_timestamp");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (string == null || jCurrentTimeMillis - Long.parseLong(string) >= 2000) {
            AFLogger.afInfoLog("SingleInstallBroadcastReceiver called");
            AFa1tSDK.getMediationNetwork().b_(context, intent);
            AppsFlyerProperties.getInstance().set("referrer_timestamp", String.valueOf(System.currentTimeMillis()));
        }
    }
}
