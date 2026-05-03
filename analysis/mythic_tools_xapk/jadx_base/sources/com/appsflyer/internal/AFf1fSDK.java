package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1fSDK {
    final int AFAdRevenueData;
    final int getCurrencyIso4217Code;
    final int getMediationNetwork;
    final int getMonetizationNetwork;
    final String getRevenue;

    public AFf1fSDK(int i, int i2, int i3, int i4, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getCurrencyIso4217Code = i;
        this.getMediationNetwork = i2;
        this.getMonetizationNetwork = i3;
        this.AFAdRevenueData = i4;
        this.getRevenue = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFf1fSDK)) {
            return false;
        }
        AFf1fSDK aFf1fSDK = (AFf1fSDK) obj;
        return this.getCurrencyIso4217Code == aFf1fSDK.getCurrencyIso4217Code && this.getMediationNetwork == aFf1fSDK.getMediationNetwork && this.getMonetizationNetwork == aFf1fSDK.getMonetizationNetwork && this.AFAdRevenueData == aFf1fSDK.AFAdRevenueData && Intrinsics.areEqual(this.getRevenue, aFf1fSDK.getRevenue);
    }

    public final int hashCode() {
        return (((((((Integer.hashCode(this.getCurrencyIso4217Code) * 31) + Integer.hashCode(this.getMediationNetwork)) * 31) + Integer.hashCode(this.getMonetizationNetwork)) * 31) + Integer.hashCode(this.AFAdRevenueData)) * 31) + this.getRevenue.hashCode();
    }

    public final String toString() {
        return "CmpTcfData(policyVersion=" + this.getCurrencyIso4217Code + ", gdprApplies=" + this.getMediationNetwork + ", cmpSdkId=" + this.getMonetizationNetwork + ", cmpSdkVersion=" + this.AFAdRevenueData + ", tcString=" + this.getRevenue + ")";
    }
}
