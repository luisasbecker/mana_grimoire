package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1pSDK implements AFc1jSDK {
    private final AFc1eSDK<SharedPreferences> getMonetizationNetwork;
    private final Lazy getRevenue;

    public AFc1pSDK(AFc1eSDK<SharedPreferences> aFc1eSDK) {
        Intrinsics.checkNotNullParameter(aFc1eSDK, "");
        this.getMonetizationNetwork = aFc1eSDK;
        this.getRevenue = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.appsflyer.internal.AFc1pSDK.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: m_, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences invoke() {
                return (SharedPreferences) AFc1pSDK.this.getMonetizationNetwork.getMonetizationNetwork.invoke();
            }
        });
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final void AFAdRevenueData(String str, int i) {
        ((SharedPreferences) this.getRevenue.getValue()).edit().putInt(str, i).apply();
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final int getCurrencyIso4217Code(String str, int i) {
        try {
            return ((SharedPreferences) this.getRevenue.getValue()).getInt(str, i);
        } catch (ClassCastException e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, "Unexpected data type found for key " + str, e, false, false, false, false, 120, null);
            return i;
        }
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final void getCurrencyIso4217Code(String str) {
        ((SharedPreferences) this.getRevenue.getValue()).edit().remove(str).apply();
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final long getMediationNetwork(String str, long j) {
        try {
            return ((SharedPreferences) this.getRevenue.getValue()).getLong(str, j);
        } catch (ClassCastException e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, "Unexpected data type found for key " + str, e, false, false, false, false, 120, null);
            return j;
        }
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final void getMediationNetwork(String str, String str2) {
        ((SharedPreferences) this.getRevenue.getValue()).edit().putString(str, str2).apply();
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final boolean getMonetizationNetwork(String str) {
        return ((SharedPreferences) this.getRevenue.getValue()).contains(str);
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final String getRevenue(String str, String str2) {
        try {
            return ((SharedPreferences) this.getRevenue.getValue()).getString(str, str2);
        } catch (ClassCastException e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, "Unexpected data type found for key " + str, e, false, false, false, false, 120, null);
            return str2;
        }
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final void getRevenue(String str, long j) {
        ((SharedPreferences) this.getRevenue.getValue()).edit().putLong(str, j).apply();
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final void getRevenue(String str, boolean z) {
        ((SharedPreferences) this.getRevenue.getValue()).edit().putBoolean(str, z).apply();
    }

    @Override // com.appsflyer.internal.AFc1jSDK
    public final boolean getRevenue(String str) {
        try {
            return ((SharedPreferences) this.getRevenue.getValue()).getBoolean(str, false);
        } catch (ClassCastException e) {
            AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, "Unexpected data type found for key " + str, e, false, false, false, false, 120, null);
            return false;
        }
    }
}
