package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFi1wSDK {
    public final String AFAdRevenueData;
    public final String getCurrencyIso4217Code;
    private final boolean getMediationNetwork;
    public final String getMonetizationNetwork;

    public AFi1wSDK(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.AFAdRevenueData = str;
        this.getMonetizationNetwork = str2;
        this.getCurrencyIso4217Code = str3;
        this.getMediationNetwork = z;
    }

    public final boolean getRevenue() {
        return this.getMediationNetwork;
    }
}
