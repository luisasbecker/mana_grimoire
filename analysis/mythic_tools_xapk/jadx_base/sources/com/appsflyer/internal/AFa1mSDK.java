package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/AFa1mSDK;", "", "", "p0", "Lcom/appsflyer/deeplink/DeepLink;", "p1", "<init>", "(ZLcom/appsflyer/deeplink/DeepLink;)V", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "getCurrencyIso4217Code", "Lcom/appsflyer/deeplink/DeepLink;", "AFAdRevenueData", "Z", "getMonetizationNetwork", "()Z"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AFa1mSDK {

    /* JADX INFO: renamed from: AFAdRevenueData, reason: from kotlin metadata */
    private final boolean getMonetizationNetwork;

    /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: from kotlin metadata */
    public final DeepLink AFAdRevenueData;

    /* JADX WARN: Multi-variable type inference failed */
    public AFa1mSDK() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public AFa1mSDK(boolean z, DeepLink deepLink) {
        this.getMonetizationNetwork = z;
        this.AFAdRevenueData = deepLink;
    }

    public /* synthetic */ AFa1mSDK(boolean z, DeepLink deepLink, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : deepLink);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (!(p0 instanceof AFa1mSDK)) {
            return false;
        }
        AFa1mSDK aFa1mSDK = (AFa1mSDK) p0;
        return this.getMonetizationNetwork == aFa1mSDK.getMonetizationNetwork && Intrinsics.areEqual(this.AFAdRevenueData, aFa1mSDK.AFAdRevenueData);
    }

    /* JADX INFO: renamed from: getMonetizationNetwork, reason: from getter */
    public final boolean getGetMonetizationNetwork() {
        return this.getMonetizationNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.getMonetizationNetwork;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        DeepLink deepLink = this.AFAdRevenueData;
        return i + (deepLink == null ? 0 : deepLink.hashCode());
    }

    public final String toString() {
        return "DdlResponse(secondPing=" + this.getMonetizationNetwork + ", deepLink=" + this.AFAdRevenueData + ")";
    }
}
