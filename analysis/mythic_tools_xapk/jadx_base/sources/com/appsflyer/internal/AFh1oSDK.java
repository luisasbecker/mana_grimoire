package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1oSDK {
    public final String AFAdRevenueData;
    public final String getCurrencyIso4217Code;
    public final Intent getMonetizationNetwork;

    public AFh1oSDK(Activity activity, AFi1rSDK aFi1rSDK) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(aFi1rSDK, "");
        this.getMonetizationNetwork = activity.getIntent();
        this.getCurrencyIso4217Code = aFi1rSDK.getMediationNetwork(activity);
        this.AFAdRevenueData = aFi1rSDK.getMonetizationNetwork(activity);
    }
}
