package com.appsflyer.internal;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AFc1aSDK {
    List<AFc1bSDK> AFAdRevenueData();

    void AFAdRevenueData(int i, int i2);

    String getCurrencyIso4217Code(Throwable th, String str);

    boolean getMediationNetwork();

    int getRevenue();

    boolean getRevenue(String... strArr);
}
