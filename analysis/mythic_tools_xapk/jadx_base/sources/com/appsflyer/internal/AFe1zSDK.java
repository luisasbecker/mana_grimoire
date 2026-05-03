package com.appsflyer.internal;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014"}, d2 = {"Lcom/appsflyer/internal/AFe1zSDK;", "", "", "p0", "p1", "Lcom/appsflyer/internal/AFe1sSDK;", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/appsflyer/internal/AFe1sSDK;)V", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "getMonetizationNetwork", "Lcom/appsflyer/internal/AFe1sSDK;", "getRevenue", "Ljava/lang/String;", "AFAdRevenueData", "getCurrencyIso4217Code", "getMediationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AFe1zSDK {

    /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: from kotlin metadata */
    public final String getMediationNetwork;
    public final AFe1sSDK getMonetizationNetwork;

    /* JADX INFO: renamed from: getRevenue, reason: from kotlin metadata */
    public final String AFAdRevenueData;

    public AFe1zSDK(String str, String str2, AFe1sSDK aFe1sSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(aFe1sSDK, "");
        this.AFAdRevenueData = str;
        this.getMediationNetwork = str2;
        this.getMonetizationNetwork = aFe1sSDK;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (!(p0 instanceof AFe1zSDK)) {
            return false;
        }
        AFe1zSDK aFe1zSDK = (AFe1zSDK) p0;
        return Intrinsics.areEqual(this.AFAdRevenueData, aFe1zSDK.AFAdRevenueData) && Intrinsics.areEqual(this.getMediationNetwork, aFe1zSDK.getMediationNetwork) && this.getMonetizationNetwork == aFe1zSDK.getMonetizationNetwork;
    }

    public final int hashCode() {
        int iHashCode = this.AFAdRevenueData.hashCode() * 31;
        String str = this.getMediationNetwork;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.getMonetizationNetwork.hashCode();
    }

    public final String toString() {
        return "HostMeta(name=" + this.AFAdRevenueData + ", prefix=" + this.getMediationNetwork + ", method=" + this.getMonetizationNetwork + ")";
    }
}
