package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface AFg1ySDK {

    public static final class AFa1tSDK {
        final String AFAdRevenueData;
        final float getMonetizationNetwork;

        public AFa1tSDK(float f, String str) {
            this.getMonetizationNetwork = f;
            this.AFAdRevenueData = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1tSDK)) {
                return false;
            }
            AFa1tSDK aFa1tSDK = (AFa1tSDK) obj;
            return Float.compare(this.getMonetizationNetwork, aFa1tSDK.getMonetizationNetwork) == 0 && Intrinsics.areEqual(this.AFAdRevenueData, aFa1tSDK.AFAdRevenueData);
        }

        public final int hashCode() {
            int iHashCode = Float.hashCode(this.getMonetizationNetwork) * 31;
            String str = this.AFAdRevenueData;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "BatteryData(level=" + this.getMonetizationNetwork + ", charging=" + this.AFAdRevenueData + ")";
        }
    }

    AFa1tSDK getMonetizationNetwork(Context context);
}
