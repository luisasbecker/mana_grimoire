package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFb1cSDK implements AFb1hSDK {
    private final AFc1gSDK AFAdRevenueData;
    private final AFc1fSDK getCurrencyIso4217Code;
    private final AFf1kSDK getMediationNetwork;

    public AFb1cSDK(AFc1gSDK aFc1gSDK, AFc1fSDK aFc1fSDK, AFf1kSDK aFf1kSDK) {
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        Intrinsics.checkNotNullParameter(aFf1kSDK, "");
        this.AFAdRevenueData = aFc1gSDK;
        this.getCurrencyIso4217Code = aFc1fSDK;
        this.getMediationNetwork = aFf1kSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFAdRevenueData(AFb1cSDK aFb1cSDK, AppSetIdInfo appSetIdInfo) {
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        AFc1gSDK aFc1gSDK = aFb1cSDK.AFAdRevenueData;
        int scope = appSetIdInfo.getScope();
        String id = appSetIdInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "");
        aFc1gSDK.equals = new AFb1gSDK(scope, id);
    }

    @Override // com.appsflyer.internal.AFb1hSDK
    public final boolean getCurrencyIso4217Code() {
        return !this.getMediationNetwork.getRevenue() && !this.AFAdRevenueData.getMonetizationNetwork() && AFj1pSDK.getMediationNetwork(this.getCurrencyIso4217Code.getCurrencyIso4217Code) && AFj1pSDK.getCurrencyIso4217Code(this.getCurrencyIso4217Code.getCurrencyIso4217Code);
    }

    @Override // com.appsflyer.internal.AFb1hSDK
    public final void getMonetizationNetwork() {
        Context context = this.getCurrencyIso4217Code.getCurrencyIso4217Code;
        if (context != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appsflyer.internal.AFb1cSDK$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        AFb1cSDK.AFAdRevenueData(this.f$0, (AppSetIdInfo) obj);
                    }
                }), "");
            } catch (Throwable th) {
                AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "Error while trying to  fetch App set ID", th, false, false, false, false, 120, null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
