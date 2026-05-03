package com.appsflyer.internal;

import com.appsflyer.AFAdRevenueData;
import com.appsflyer.AdRevenueScheme;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1xSDK extends AFf1rSDK {
    private final AFh1qSDK copydefault;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1xSDK(AFh1qSDK aFh1qSDK, AFd1zSDK aFd1zSDK) {
        super(aFh1qSDK, aFd1zSDK);
        Intrinsics.checkNotNullParameter(aFh1qSDK, "");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.copydefault = aFh1qSDK;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void AFAdRevenueData(AFh1sSDK aFh1sSDK) {
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        super.AFAdRevenueData(aFh1sSDK);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        AFAdRevenueData aFAdRevenueData = this.copydefault.hashCode;
        Intrinsics.checkNotNullExpressionValue(aFAdRevenueData, "");
        linkedHashMap.put("monetization_network", aFAdRevenueData.getMonetizationNetwork());
        linkedHashMap.put("event_revenue_currency", aFAdRevenueData.getCurrencyIso4217Code());
        linkedHashMap.put("mediation_network", aFAdRevenueData.getMediationNetwork().getValue());
        linkedHashMap.put("event_revenue", Double.valueOf(aFAdRevenueData.getRevenue()));
        Map<String, Object> map = this.copydefault.toString;
        if (map != null && !map.isEmpty()) {
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"ad_type", AdRevenueScheme.AD_UNIT, "country", AdRevenueScheme.PLACEMENT});
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (listListOf.contains(key)) {
                    linkedHashMap.put(key, value);
                } else {
                    linkedHashMap2.put(key, value);
                }
            }
            linkedHashMap.put("custom_parameters", linkedHashMap2);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("name", "adrevenue_sdk");
        linkedHashMap3.put("payload", linkedHashMap);
        Map<String, Object> map2 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        map2.put("ad_network", linkedHashMap3);
    }
}
