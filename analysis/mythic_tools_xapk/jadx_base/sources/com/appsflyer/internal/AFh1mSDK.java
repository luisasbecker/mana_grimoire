package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1mSDK extends AFh1sSDK {
    @Override // com.appsflyer.internal.AFh1sSDK
    public final boolean component3() {
        return true;
    }

    @Override // com.appsflyer.internal.AFh1sSDK
    public final AFe1lSDK getRevenue() {
        return this.component1 == 1 ? AFe1lSDK.CONVERSION : AFe1lSDK.LAUNCH;
    }
}
