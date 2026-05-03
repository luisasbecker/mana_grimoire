package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1xSDK {
    public final String AFAdRevenueData;
    public final boolean getMediationNetwork;
    public final long getMonetizationNetwork;

    public AFg1xSDK(String str, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.AFAdRevenueData = str;
        this.getMonetizationNetwork = j;
        this.getMediationNetwork = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFg1xSDK)) {
            return false;
        }
        AFg1xSDK aFg1xSDK = (AFg1xSDK) obj;
        return Intrinsics.areEqual(this.AFAdRevenueData, aFg1xSDK.AFAdRevenueData) && this.getMonetizationNetwork == aFg1xSDK.getMonetizationNetwork && this.getMediationNetwork == aFg1xSDK.getMediationNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        int iHashCode = ((this.AFAdRevenueData.hashCode() * 31) + Long.hashCode(this.getMonetizationNetwork)) * 31;
        boolean z = this.getMediationNetwork;
        ?? r3 = z;
        if (z) {
            r3 = 1;
        }
        return iHashCode + r3;
    }

    public final String toString() {
        return "AFUninstallToken(token=" + this.AFAdRevenueData + ", receivedTime=" + this.getMonetizationNetwork + ", isQueued=" + this.getMediationNetwork + ")";
    }
}
