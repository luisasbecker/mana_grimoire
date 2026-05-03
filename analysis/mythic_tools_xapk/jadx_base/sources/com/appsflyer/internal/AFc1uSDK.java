package com.appsflyer.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1uSDK {
    final String getCurrencyIso4217Code;
    final int getMediationNetwork;
    final List<AFe1lSDK> getMonetizationNetwork;

    /* JADX WARN: Multi-variable type inference failed */
    public AFc1uSDK(String str, List<? extends AFe1lSDK> list, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getCurrencyIso4217Code = str;
        this.getMonetizationNetwork = list;
        this.getMediationNetwork = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1uSDK)) {
            return false;
        }
        AFc1uSDK aFc1uSDK = (AFc1uSDK) obj;
        return Intrinsics.areEqual(this.getCurrencyIso4217Code, aFc1uSDK.getCurrencyIso4217Code) && Intrinsics.areEqual(this.getMonetizationNetwork, aFc1uSDK.getMonetizationNetwork) && this.getMediationNetwork == aFc1uSDK.getMediationNetwork;
    }

    public final int hashCode() {
        return (((this.getCurrencyIso4217Code.hashCode() * 31) + this.getMonetizationNetwork.hashCode()) * 31) + Integer.hashCode(this.getMediationNetwork);
    }

    public final String toString() {
        return "StorageConfigTypeEntry(cacheDirName=" + this.getCurrencyIso4217Code + ", eventTypes=" + this.getMonetizationNetwork + ", maxCapacity=" + this.getMediationNetwork + ")";
    }
}
