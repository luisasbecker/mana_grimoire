package com.appsflyer.internal;

import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface AFh1wSDK {
    boolean AFAdRevenueData();

    void getCurrencyIso4217Code(AFf1tSDK aFf1tSDK, Function0<Unit> function0);

    void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK);

    void getMediationNetwork(AFh1sSDK aFh1sSDK);

    boolean getMediationNetwork();

    void getMonetizationNetwork(AFh1sSDK aFh1sSDK);

    void getRevenue();

    void u_(Intent intent, AFa1oSDK aFa1oSDK);
}
