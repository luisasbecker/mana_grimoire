package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1gSDK extends AFg1hSDK {
    private final AFd1zSDK AFAdRevenueData;

    public AFg1gSDK(AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.AFAdRevenueData = aFd1zSDK;
    }

    @Override // com.appsflyer.internal.AFg1hSDK
    public final void e(AFg1cSDK aFg1cSDK, String str, Throwable th, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (z3) {
            if (StringsKt.isBlank(str)) {
                str = "missing label";
            }
            this.AFAdRevenueData.afLogForce().getMediationNetwork(th, withTag$SDK_prodRelease(str, aFg1cSDK));
        }
    }
}
