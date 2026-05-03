package com.appsflyer.internal;

import android.os.Build;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AFe1hSDK extends AFe1bSDK<String> {
    private final AFe1lSDK component2;
    private final Map<String, Object> copy;
    private final AFg1vSDK copydefault;
    private final AFc1jSDK equals;
    private final AFc1kSDK hashCode;
    private final AFf1gSDK toString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1hSDK(AFe1lSDK aFe1lSDK, AFe1lSDK[] aFe1lSDKArr, AFd1zSDK aFd1zSDK, String str, Map<String, ? extends Object> map) {
        super(aFe1lSDK, aFe1lSDKArr, aFd1zSDK, null);
        Intrinsics.checkNotNullParameter(aFe1lSDK, "");
        Intrinsics.checkNotNullParameter(aFe1lSDKArr, "");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.component2 = aFe1lSDK;
        this.copy = map;
        AFc1kSDK aFc1kSDKAFAdRevenueData = aFd1zSDK.AFAdRevenueData();
        Intrinsics.checkNotNullExpressionValue(aFc1kSDKAFAdRevenueData, "");
        this.hashCode = aFc1kSDKAFAdRevenueData;
        AFc1jSDK mediationNetwork = aFd1zSDK.getMediationNetwork();
        Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
        this.equals = mediationNetwork;
        AFg1vSDK aFg1vSDKAreAllFieldsValid = aFd1zSDK.areAllFieldsValid();
        Intrinsics.checkNotNullExpressionValue(aFg1vSDKAreAllFieldsValid, "");
        this.copydefault = aFg1vSDKAreAllFieldsValid;
        AFf1gSDK aFf1gSDKForce = aFd1zSDK.force();
        Intrinsics.checkNotNullExpressionValue(aFf1gSDKForce, "");
        this.toString = aFf1gSDKForce;
    }

    protected boolean areAllFieldsValid() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return true;
    }

    public abstract AFd1fSDK<String> getCurrencyIso4217Code(Map<String, Object> map, String str, String str2);

    protected String getCurrencyIso4217Code(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    protected String getMonetizationNetwork(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    protected void getMonetizationNetwork(Map<String, Object> map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("app_id", this.hashCode.getRevenue.getCurrencyIso4217Code.getPackageName());
        String currencyIso4217Code = AFc1kSDK.getCurrencyIso4217Code();
        if (currencyIso4217Code != null) {
            map.put("cuid", currencyIso4217Code);
        }
        map.put("app_version_name", this.hashCode.n_().versionName);
        if (areAllFieldsValid()) {
            map.put("event_timestamp", Long.valueOf(this.copydefault.getCurrencyIso4217Code()));
        }
        if (str != null) {
            map.put("billing_lib_version", str);
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AFd1fSDK<String> getRevenue(String str) {
        AFd1cSDK aFd1cSDK;
        Intrinsics.checkNotNullParameter(str, "");
        Map<String, Object> mutableMap = MapsKt.toMutableMap(this.copy);
        String monetizationNetwork = getMonetizationNetwork(mutableMap);
        String currencyIso4217Code = getCurrencyIso4217Code(mutableMap);
        Map<String, Object> mutableMap2 = MapsKt.toMutableMap(mutableMap);
        getMonetizationNetwork(mutableMap2, monetizationNetwork);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String monetizationNetwork2 = this.hashCode.getMonetizationNetwork();
        String str2 = monetizationNetwork2;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            linkedHashMap.put("advertising_id", monetizationNetwork2);
        }
        AFb1mSDK revenue = AFb1jSDK.getRevenue(this.hashCode.getRevenue.getCurrencyIso4217Code);
        String str3 = null;
        String str4 = revenue != null ? revenue.getRevenue : null;
        String str5 = str4;
        if (str5 != null && !StringsKt.isBlank(str5)) {
            linkedHashMap.put("oaid", str4);
        }
        AFb1mSDK aFb1mSDKL_ = AFb1jSDK.l_(this.hashCode.getRevenue.getCurrencyIso4217Code.getContentResolver());
        String str6 = aFb1mSDKL_ != null ? aFb1mSDKL_.getRevenue : null;
        String str7 = str6;
        if (str7 != null && !StringsKt.isBlank(str7)) {
            linkedHashMap.put("amazon_aid", str6);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            mutableMap2.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        } else {
            String revenue2 = ((AFe1bSDK) this).component1.getRevenue(this.equals);
            String str8 = revenue2;
            if (str8 != null && !StringsKt.isBlank(str8)) {
                linkedHashMap.put("imei", revenue2);
            }
        }
        String currencyIso4217Code2 = AFb1iSDK.getCurrencyIso4217Code(this.hashCode.getCurrencyIso4217Code);
        if (currencyIso4217Code2 == null) {
            currencyIso4217Code2 = "";
        }
        linkedHashMap.put("appsflyer_id", currencyIso4217Code2);
        linkedHashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        linkedHashMap.put("sdk_version", "6.18.0");
        String str9 = currencyIso4217Code;
        if (str9 != null && !StringsKt.isBlank(str9)) {
            linkedHashMap.put("sdk_connector_version", currencyIso4217Code);
        }
        this.copydefault.getRevenue(linkedHashMap, this.component2);
        mutableMap2.put("device_data", linkedHashMap);
        this.toString.getCurrencyIso4217Code(mutableMap2, this.component2);
        AFd1fSDK<String> currencyIso4217Code3 = getCurrencyIso4217Code(mutableMap2, str, monetizationNetwork);
        if (currencyIso4217Code3 != null && (aFd1cSDK = currencyIso4217Code3.getMediationNetwork) != null) {
            str3 = aFd1cSDK.AFAdRevenueData;
        }
        if (str3 != null) {
            JSONObject jSONObject = new JSONObject(mutableMap2);
            AFg1fSDK.AFAdRevenueData(toString() + ": preparing data: ", jSONObject);
            AFd1lSDK aFd1lSDK = ((AFe1bSDK) this).areAllFieldsValid;
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "");
            aFd1lSDK.getMonetizationNetwork(str3, string);
        }
        return currencyIso4217Code3;
    }
}
