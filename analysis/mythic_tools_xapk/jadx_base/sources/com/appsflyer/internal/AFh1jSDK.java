package com.appsflyer.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1jSDK extends AFh1sSDK {
    public final AFe1lSDK hashCode;

    @Deprecated
    public AFh1jSDK() {
        this.hashCode = null;
    }

    public AFh1jSDK(String str, byte[] bArr, String str2, AFe1lSDK aFe1lSDK, Map<String, String> map) {
        super(null, str, Boolean.FALSE);
        this.component4 = str2;
        getMediationNetwork(bArr);
        this.hashCode = aFe1lSDK;
        if (map != null) {
            this.getRevenue.putAll(map);
        }
    }

    @Override // com.appsflyer.internal.AFh1sSDK
    public final AFe1lSDK getRevenue() {
        AFe1lSDK aFe1lSDK = this.hashCode;
        return aFe1lSDK != null ? aFe1lSDK : AFe1lSDK.CACHED_EVENT;
    }
}
