package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1fSDK implements AFj1bSDK {
    @Override // com.appsflyer.internal.AFj1bSDK
    public final String getRevenue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = String.format(str, AppsFlyerLib.getInstance().getHostPrefix(), AFa1tSDK.getMediationNetwork().getHostName());
        Intrinsics.checkNotNullExpressionValue(str2, "");
        return str2;
    }
}
