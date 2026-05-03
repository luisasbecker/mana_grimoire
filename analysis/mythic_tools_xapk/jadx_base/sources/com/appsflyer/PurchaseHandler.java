package com.appsflyer;

import com.appsflyer.internal.AFc1kSDK;
import com.appsflyer.internal.AFd1zSDK;
import com.appsflyer.internal.AFe1qSDK;
import com.appsflyer.internal.AFj1jSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class PurchaseHandler {
    public final AFe1qSDK AFAdRevenueData;
    public final AFd1zSDK getCurrencyIso4217Code;
    private final AFc1kSDK getRevenue;

    public interface PurchaseValidationCallback {
        void onFailure(Throwable th);

        void onResponse(ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(AFd1zSDK aFd1zSDK) {
        this.getCurrencyIso4217Code = aFd1zSDK;
        this.getRevenue = aFd1zSDK.AFAdRevenueData();
        this.AFAdRevenueData = aFd1zSDK.equals();
    }

    public final boolean getRevenue(Map<String, Object> map, PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean revenue = AFj1jSDK.getRevenue(map, strArr, this.getRevenue);
        if (!revenue && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return revenue;
    }
}
