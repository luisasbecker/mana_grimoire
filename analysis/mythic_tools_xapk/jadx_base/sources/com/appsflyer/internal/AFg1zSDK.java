package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1zSDK {
    private final PackageManager AFAdRevenueData;
    private final Map<String, Object> getCurrencyIso4217Code;
    private final String getMonetizationNetwork;

    public AFg1zSDK(AFc1fSDK aFc1fSDK, AFc1kSDK aFc1kSDK) {
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        this.getCurrencyIso4217Code = new LinkedHashMap();
        Context context = aFc1fSDK.getCurrencyIso4217Code;
        this.AFAdRevenueData = context != null ? context.getPackageManager() : null;
        String packageName = aFc1kSDK.getRevenue.getCurrencyIso4217Code.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        this.getMonetizationNetwork = packageName;
    }

    private final Map<String, Object> getMonetizationNetwork() {
        InstallSourceInfo installSourceInfo;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String str = this.getMonetizationNetwork;
            PackageManager packageManager = this.AFAdRevenueData;
            if (packageManager != null && (installSourceInfo = packageManager.getInstallSourceInfo(str)) != null) {
                Intrinsics.checkNotNullExpressionValue(installSourceInfo, "");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                if (initiatingPackageName != null) {
                    linkedHashMap2.put("initiating_package", initiatingPackageName);
                }
                String installingPackageName = installSourceInfo.getInstallingPackageName();
                if (installingPackageName != null) {
                    linkedHashMap2.put("installing_package", installingPackageName);
                }
                String originatingPackageName = installSourceInfo.getOriginatingPackageName();
                if (originatingPackageName != null) {
                    linkedHashMap2.put("originating_package", originatingPackageName);
                }
                return linkedHashMap2;
            }
        } catch (Throwable th) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DEVICE_DATA, "Failed to get the app install source info", th, true, false, true, true, 16, null);
        }
        return linkedHashMap;
    }

    public final Map<String, Object> getCurrencyIso4217Code() {
        String installerPackageName;
        if (this.getCurrencyIso4217Code.isEmpty()) {
            try {
                PackageManager packageManager = this.AFAdRevenueData;
                if (packageManager != null && (installerPackageName = packageManager.getInstallerPackageName(this.getMonetizationNetwork)) != null) {
                    this.getCurrencyIso4217Code.put("installer_package", installerPackageName);
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("Exception while getting the app's installer package. ", e);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.getCurrencyIso4217Code.put("install_source_info", getMonetizationNetwork());
            }
        }
        return this.getCurrencyIso4217Code;
    }
}
