package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1oSDK {
    static void AFAdRevenueData(String str) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1tSDK.getMediationNetwork().getCurrencyIso4217Code;
        if (appsFlyerConversionListener != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            appsFlyerConversionListener.onConversionDataFail(str);
        }
    }

    static void getMonetizationNetwork(Map<String, Object> map) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1tSDK.getMediationNetwork().getCurrencyIso4217Code;
        if (appsFlyerConversionListener != null) {
            AFLogger.afDebugLog(new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n").append(map.toString()).toString());
            appsFlyerConversionListener.onConversionDataSuccess(map);
        }
    }
}
