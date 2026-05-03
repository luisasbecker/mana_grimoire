package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public interface AFd1xSDK {

    public interface AFa1tSDK {
        void onConfigurationChanged(boolean z);
    }

    void getCurrencyIso4217Code();

    void getMediationNetwork(Throwable th, String str);

    void getMonetizationNetwork(AFa1tSDK aFa1tSDK);

    void getRevenue();
}
