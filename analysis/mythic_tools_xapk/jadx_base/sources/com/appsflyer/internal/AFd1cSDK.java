package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AFd1cSDK {
    public final String AFAdRevenueData;
    public int areAllFieldsValid;
    private boolean component1;
    private final boolean component2;
    private final boolean component3;
    private final byte[] component4;
    public boolean getCurrencyIso4217Code;
    final String getMediationNetwork;
    public boolean getMonetizationNetwork;
    public final Map<String, String> getRevenue;

    public AFd1cSDK(String str, String str2) {
        this(str, null, str2, new HashMap(), false);
    }

    public AFd1cSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z) {
        this(str, bArr, str2, map, z, (byte) 0);
    }

    private AFd1cSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z, byte b) {
        this.component1 = true;
        this.getCurrencyIso4217Code = false;
        this.getMonetizationNetwork = true;
        this.areAllFieldsValid = -1;
        this.AFAdRevenueData = str;
        this.component4 = bArr;
        this.getMediationNetwork = str2;
        this.getRevenue = map;
        this.component3 = z;
        this.component2 = true;
    }

    public final boolean AFAdRevenueData() {
        return this.getCurrencyIso4217Code;
    }

    public final boolean component3() {
        return this.getMonetizationNetwork;
    }

    public final boolean getCurrencyIso4217Code() {
        return this.component1;
    }

    public final byte[] getMediationNetwork() {
        return this.component4;
    }

    public final boolean getMonetizationNetwork() {
        return this.component3;
    }

    public final boolean getRevenue() {
        return this.component2;
    }
}
