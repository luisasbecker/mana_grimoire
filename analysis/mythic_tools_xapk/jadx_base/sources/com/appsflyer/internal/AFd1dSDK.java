package com.appsflyer.internal;

/* JADX INFO: loaded from: classes3.dex */
public class AFd1dSDK {
    public final long AFAdRevenueData;

    public AFd1dSDK(long j) {
        this.AFAdRevenueData = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.AFAdRevenueData == ((AFd1dSDK) obj).AFAdRevenueData;
    }

    public int hashCode() {
        long j = this.AFAdRevenueData;
        return (int) (j ^ (j >>> 32));
    }
}
