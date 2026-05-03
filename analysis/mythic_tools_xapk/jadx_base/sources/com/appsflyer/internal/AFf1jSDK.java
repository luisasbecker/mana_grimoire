package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.lvl.AppsFlyerLVL;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1jSDK {

    interface AFa1ySDK {
        void getMonetizationNetwork(String str, Exception exc);

        void getRevenue(String str, String str2);
    }

    public final boolean getMediationNetwork(long j, Context context, final AFa1ySDK aFa1ySDK) {
        try {
            AppsFlyerLVL.checkLicense(j, context, new AppsFlyerLVL.resultListener() { // from class: com.appsflyer.internal.AFf1jSDK.5
                public final void onLvlFailure(Exception exc) {
                    aFa1ySDK.getMonetizationNetwork("onLvlFailure with exception", exc);
                }

                public final void onLvlResult(String str, String str2) {
                    if (str != null && str2 != null) {
                        aFa1ySDK.getRevenue(str, str2);
                        return;
                    }
                    AFa1ySDK aFa1ySDK2 = aFa1ySDK;
                    if (str2 == null) {
                        aFa1ySDK2.getMonetizationNetwork("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                    } else {
                        aFa1ySDK2.getMonetizationNetwork("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                    }
                }
            });
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
