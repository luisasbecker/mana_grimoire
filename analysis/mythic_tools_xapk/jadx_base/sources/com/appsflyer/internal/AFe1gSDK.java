package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AFe1gSDK extends AFe1hSDK {
    private final PurchaseHandler.PurchaseValidationCallback component2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1gSDK(AFe1lSDK aFe1lSDK, AFe1lSDK[] aFe1lSDKArr, AFd1zSDK aFd1zSDK, Map<String, ? extends Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFe1lSDK, aFe1lSDKArr, aFd1zSDK, null, map);
        Intrinsics.checkNotNullParameter(aFe1lSDK, "");
        Intrinsics.checkNotNullParameter(aFe1lSDKArr, "");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.component2 = purchaseValidationCallback;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public boolean AFAdRevenueData() {
        if (((AFe1bSDK) this).component4 != null) {
            ResponseNetwork responseNetwork = ((AFe1bSDK) this).component4;
            Intrinsics.checkNotNull(responseNetwork);
            if (responseNetwork.getStatusCode() == 503) {
                return true;
            }
        }
        return super.AFAdRevenueData();
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    protected final boolean areAllFieldsValid() {
        return true;
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    protected final String getCurrencyIso4217Code(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        if (map.containsKey("connector_version")) {
            Object objRemove = map.remove("connector_version");
            if (objRemove instanceof String) {
                return (String) objRemove;
            }
        }
        return null;
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    protected final String getMonetizationNetwork(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        if (map.containsKey("billing_library_version")) {
            Object objRemove = map.remove("billing_library_version");
            if (objRemove instanceof String) {
                return (String) objRemove;
            }
        }
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.getMonetizationNetwork();
        Throwable thComponent2 = component2();
        if (thComponent2 != null && (purchaseValidationCallback2 = this.component2) != null) {
            purchaseValidationCallback2.onFailure(thComponent2);
        }
        ResponseNetwork<String> responseNetwork = ((AFe1bSDK) this).component4;
        if (responseNetwork == null || (purchaseValidationCallback = this.component2) == null) {
            return;
        }
        purchaseValidationCallback.onResponse(responseNetwork);
    }
}
