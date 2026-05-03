package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageItemInfo;
import android.content.pm.ResolveInfo;
import com.appsflyer.internal.AFa1tSDK;

/* JADX INFO: loaded from: classes3.dex */
public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
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
        AFLogger.afInfoLog("MultipleInstallBroadcastReceiver called");
        AFa1tSDK.getMediationNetwork().b_(context, intent);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
            String action = intent.getAction();
            if (((PackageItemInfo) resolveInfo.activityInfo).packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !getClass().getName().equals(((PackageItemInfo) resolveInfo.activityInfo).name)) {
                AFLogger.afInfoLog(new StringBuilder("trigger onReceive: class: ").append(((PackageItemInfo) resolveInfo.activityInfo).name).toString());
                try {
                    ((BroadcastReceiver) Class.forName(((PackageItemInfo) resolveInfo.activityInfo).name).newInstance()).onReceive(context, intent);
                } catch (Throwable th2) {
                    AFLogger.afErrorLog(new StringBuilder("error in BroadcastReceiver ").append(((PackageItemInfo) resolveInfo.activityInfo).name).toString(), th2);
                }
            }
        }
    }
}
