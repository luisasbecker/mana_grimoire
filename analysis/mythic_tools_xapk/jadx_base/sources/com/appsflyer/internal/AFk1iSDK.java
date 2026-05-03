package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class AFk1iSDK {
    public int getMediationNetwork;
    public int getMonetizationNetwork;
    public int getRevenue;

    public static int getMediationNetwork(int i) {
        AFk1xSDK aFk1xSDK = AFk1xSDK.getMonetizationNetwork;
        return ((aFk1xSDK.AFAdRevenueData[0][(i >>> 24) & 255] + aFk1xSDK.AFAdRevenueData[1][(i >>> 16) & 255]) ^ aFk1xSDK.AFAdRevenueData[2][(i >>> 8) & 255]) + aFk1xSDK.AFAdRevenueData[3][i & 255];
    }

    public static void getMonetizationNetwork(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }
}
