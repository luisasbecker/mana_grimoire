package com.appsflyer.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1aSDK extends AFg1hSDK {
    private final boolean AFAdRevenueData;
    private final AFd1zSDK getMediationNetwork;

    public AFg1aSDK(AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.getMediationNetwork = aFd1zSDK;
        this.AFAdRevenueData = true;
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void d(AFg1cSDK aFg1cSDK, String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMediationNetwork.copy().getMediationNetwork("D", getMonetizationNetwork(str, aFg1cSDK));
        }
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void e(AFg1cSDK aFg1cSDK, String str, Throwable th, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (z4) {
            this.getMediationNetwork.copy().getMediationNetwork(ExifInterface.LONGITUDE_EAST, getMonetizationNetwork(str, aFg1cSDK));
        }
        if (z4) {
            this.getMediationNetwork.copy().getCurrencyIso4217Code(th);
        }
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void force(AFg1cSDK aFg1cSDK, String str) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getMediationNetwork.copy().getMediationNetwork("F", getMonetizationNetwork(str, aFg1cSDK));
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final boolean getShouldExtendMsg() {
        return this.AFAdRevenueData;
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void i(AFg1cSDK aFg1cSDK, String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMediationNetwork.copy().getMediationNetwork("I", getMonetizationNetwork(str, aFg1cSDK));
        }
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void v(AFg1cSDK aFg1cSDK, String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMediationNetwork.copy().getMediationNetwork(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, getMonetizationNetwork(str, aFg1cSDK));
        }
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void w(AFg1cSDK aFg1cSDK, String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMediationNetwork.copy().getMediationNetwork(ExifInterface.LONGITUDE_WEST, getMonetizationNetwork(str, aFg1cSDK));
        }
    }
}
