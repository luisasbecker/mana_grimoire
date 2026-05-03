package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1aSDK extends AFh1sSDK {
    public AFf1aSDK() {
        super("Register", null, Boolean.FALSE);
    }

    @Override // com.appsflyer.internal.AFh1sSDK
    public final boolean getMonetizationNetwork() {
        return false;
    }

    @Override // com.appsflyer.internal.AFh1sSDK
    public final AFe1lSDK getRevenue() {
        return AFe1lSDK.REGISTER;
    }
}
