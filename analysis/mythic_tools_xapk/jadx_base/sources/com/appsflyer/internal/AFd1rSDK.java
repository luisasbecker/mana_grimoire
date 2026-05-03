package com.appsflyer.internal;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1rSDK {
    public static boolean getRevenue(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int iAFAdRevenueData = AFj1aSDK.AFAdRevenueData(str);
        int iAFAdRevenueData2 = AFj1aSDK.AFAdRevenueData(str2);
        Pair<Integer, Integer> mediationNetwork = AFd1pSDK.getMediationNetwork(str2);
        Pair<Integer, Integer> currencyIso4217Code = AFd1pSDK.getCurrencyIso4217Code(str2);
        return (iAFAdRevenueData2 == -1 || mediationNetwork != null) ? currencyIso4217Code != null ? currencyIso4217Code.getFirst().intValue() <= iAFAdRevenueData && iAFAdRevenueData <= currencyIso4217Code.getSecond().intValue() : mediationNetwork != null && mediationNetwork.getFirst().intValue() <= iAFAdRevenueData && iAFAdRevenueData <= mediationNetwork.getSecond().intValue() : iAFAdRevenueData2 == iAFAdRevenueData;
    }
}
