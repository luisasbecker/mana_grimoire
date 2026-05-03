package com.appsflyer.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.migration.internal.MigrationDataProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1vSDK implements AFh1wSDK {
    private final AFj1rSDK AFAdRevenueData;
    private boolean component2;
    private boolean component3;
    private final AFc1kSDK getCurrencyIso4217Code;
    private Long getMediationNetwork;
    private Long getMonetizationNetwork;
    private JSONObject getRevenue;

    public /* synthetic */ class AFa1uSDK {
        public static final /* synthetic */ int[] getRevenue;

        static {
            int[] iArr = new int[AFe1lSDK.values().length];
            try {
                iArr[AFe1lSDK.LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1lSDK.ATTR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            getRevenue = iArr;
        }
    }

    public AFh1vSDK(AFc1kSDK aFc1kSDK, AFj1rSDK aFj1rSDK) {
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(aFj1rSDK, "");
        this.getCurrencyIso4217Code = aFc1kSDK;
        this.AFAdRevenueData = aFj1rSDK;
    }

    private final JSONObject getCurrencyIso4217Code() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectWaitForAttributionData = MigrationDataProvider.waitForAttributionData(3000L);
        if (jSONObjectWaitForAttributionData != null) {
            this.getMonetizationNetwork = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
        }
        return jSONObjectWaitForAttributionData;
    }

    private final void getMonetizationNetwork(String str, AFh1sSDK aFh1sSDK, JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put(str, jSONObject);
        HashMap map2 = new HashMap();
        map2.put("branch", map);
        HashMap map3 = new HashMap();
        map3.put("external", map2);
        aFh1sSDK.getCurrencyIso4217Code(map3);
        Map<String, Object> map4 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map4, "");
        AFe1lSDK revenue = aFh1sSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        getMonetizationNetwork(map4, revenue);
    }

    private final void getMonetizationNetwork(Map<String, Object> map, AFe1lSDK aFe1lSDK) {
        int i = AFa1uSDK.getRevenue[aFe1lSDK.ordinal()];
        Long l = i != 1 ? i != 2 ? null : this.getMonetizationNetwork : this.getMediationNetwork;
        if (l != null) {
            long jLongValue = l.longValue();
            Map<String, Object> monetizationNetwork = AFa1tSDK.getMonetizationNetwork(map);
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
            monetizationNetwork.put("migration", MapsKt.mapOf(TuplesKt.to("delay", Long.valueOf(jLongValue))));
        }
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final boolean AFAdRevenueData() {
        return this.component3;
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void getCurrencyIso4217Code(AFf1tSDK aFf1tSDK, Function0<Unit> function0) {
        JSONObject currencyIso4217Code;
        Intrinsics.checkNotNullParameter(aFf1tSDK, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (this.getCurrencyIso4217Code.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) == 1 && aFf1tSDK.getMonetizationNetwork == AFe1lSDK.CONVERSION && this.AFAdRevenueData.AFAdRevenueData() && !AFAdRevenueData() && (currencyIso4217Code = getCurrencyIso4217Code()) != null) {
            this.getRevenue = currencyIso4217Code;
            function0.invoke();
        }
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        JSONObject jSONObject = this.getRevenue;
        if (jSONObject != null) {
            Intrinsics.checkNotNull(jSONObject);
            getMonetizationNetwork("attr", aFh1sSDK, jSONObject);
        } else {
            JSONObject currencyIso4217Code = getCurrencyIso4217Code();
            if (currencyIso4217Code != null) {
                getMonetizationNetwork("attr", aFh1sSDK, currencyIso4217Code);
            }
        }
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void getMediationNetwork(AFh1sSDK aFh1sSDK) {
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectWaitForDeepLinkingData = MigrationDataProvider.waitForDeepLinkingData(3000L);
        if (jSONObjectWaitForDeepLinkingData != null) {
            this.getMediationNetwork = Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis);
            getMonetizationNetwork("dl", aFh1sSDK, jSONObjectWaitForDeepLinkingData);
        }
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final boolean getMediationNetwork() {
        return this.component2;
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void getMonetizationNetwork(AFh1sSDK aFh1sSDK) {
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        JSONObject attributionData = MigrationDataProvider.getAttributionData();
        if (attributionData != null) {
            getMonetizationNetwork("attr", aFh1sSDK, attributionData);
            this.component3 = true;
        }
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void getRevenue() {
        this.component2 = false;
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1wSDK
    public final void u_(Intent intent, AFa1oSDK aFa1oSDK) throws Throwable {
        Intrinsics.checkNotNullParameter(intent, "");
        Intrinsics.checkNotNullParameter(aFa1oSDK, "");
        if (MigrationDataProvider.waitForDeepLinkingData(0L) != null) {
            this.component2 = true;
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        try {
            Object[] objArr = {data, aFa1oSDK};
            Object declaredConstructor = AFa1kSDK.i.get(-1523018365);
            if (declaredConstructor == null) {
                declaredConstructor = ((Class) AFa1kSDK.getMediationNetwork((char) (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 37, View.MeasureSpec.getMode(0))).getDeclaredConstructor(Uri.class, AFa1oSDK.class);
                AFa1kSDK.i.put(-1523018365, declaredConstructor);
            }
            Object objNewInstance = ((Constructor) declaredConstructor).newInstance(objArr);
            Object method = AFa1kSDK.i.get(275685916);
            if (method == null) {
                method = ((Class) AFa1kSDK.getMediationNetwork((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 37, TextUtils.indexOf("", "", 0))).getMethod("getMediationNetwork", null);
                AFa1kSDK.i.put(275685916, method);
            }
            Object objInvoke = ((Method) method).invoke(objNewInstance, null);
            Object method2 = AFa1kSDK.i.get(-1366801308);
            if (method2 == null) {
                method2 = ((Class) AFa1kSDK.getMediationNetwork((char) (44102 - View.MeasureSpec.getMode(0)), 50 - (ViewConfiguration.getFadingEdgeLength() >> 16), 36 - ((byte) KeyEvent.getModifierMetaStateMask()))).getMethod("getMediationNetwork", null);
                AFa1kSDK.i.put(-1366801308, method2);
            }
            this.component2 = !((Boolean) ((Method) method2).invoke(objInvoke, null)).booleanValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
