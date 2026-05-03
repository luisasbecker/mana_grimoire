package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFj1zSDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1rSDK {
    public final CopyOnWriteArrayList<AFj1zSDK> AFAdRevenueData = new CopyOnWriteArrayList<>();
    public final AFd1zSDK getCurrencyIso4217Code;

    public AFj1rSDK(AFd1zSDK aFd1zSDK) {
        this.getCurrencyIso4217Code = aFd1zSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void areAllFieldsValid(final Runnable runnable) {
        AFj1xSDK aFj1xSDK = new AFj1xSDK(this.getCurrencyIso4217Code.AFAdRevenueData(), this.getCurrencyIso4217Code.getCurrencyIso4217Code(), AFj1vSDK.INSTAGRAM, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getMonetizationNetwork(runnable);
            }
        });
        this.AFAdRevenueData.add(aFj1xSDK);
        aFj1xSDK.getMonetizationNetwork(this.getCurrencyIso4217Code.registerClient().getCurrencyIso4217Code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getCurrencyIso4217Code(final Runnable runnable) {
        this.getCurrencyIso4217Code.getCurrencyIso4217Code().execute(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getMediationNetwork(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(AFi1aSDK aFi1aSDK, Runnable runnable) {
        AFc1jSDK mediationNetwork = this.getCurrencyIso4217Code.getMediationNetwork();
        int currencyIso4217Code = this.getCurrencyIso4217Code.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0);
        boolean revenue = mediationNetwork.getRevenue(AppsFlyerProperties.NEW_REFERRER_SENT);
        boolean z = aFi1aSDK.component2 == AFj1zSDK.AFa1ySDK.NOT_STARTED;
        if (currencyIso4217Code == 1) {
            if (z || revenue) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(Runnable runnable) {
        try {
            if (getCurrencyIso4217Code(new AFh1pSDK())) {
                runnable.run();
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMonetizationNetwork(Context context, Runnable runnable, AFd1zSDK aFd1zSDK) {
        List<ResolveInfo> listQueryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
        if (listQueryIntentContentProviders == null || listQueryIntentContentProviders.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = listQueryIntentContentProviders.iterator();
        while (it.hasNext()) {
            ProviderInfo providerInfo = it.next().providerInfo;
            if (providerInfo != null) {
                arrayList.add(new AFj1wSDK(providerInfo, runnable, aFd1zSDK));
            } else {
                AFLogger.INSTANCE.w(AFg1cSDK.PREINSTALL, "com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.AFAdRevenueData.addAll(arrayList);
        AFLogger.INSTANCE.d(AFg1cSDK.PREINSTALL, new StringBuilder("Detected ").append(arrayList.size()).append(" valid preinstall provider(s)").toString());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((AFj1zSDK) it2.next()).getMonetizationNetwork(aFd1zSDK.registerClient().getCurrencyIso4217Code);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMonetizationNetwork(Runnable runnable) {
        AFj1xSDK aFj1xSDK = new AFj1xSDK(this.getCurrencyIso4217Code.AFAdRevenueData(), this.getCurrencyIso4217Code.getCurrencyIso4217Code(), AFj1vSDK.FACEBOOK_LITE, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.getRevenue();
            }
        });
        this.AFAdRevenueData.add(aFj1xSDK);
        aFj1xSDK.getMonetizationNetwork(this.getCurrencyIso4217Code.registerClient().getCurrencyIso4217Code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void getRevenue() {
    }

    public final AFi1aSDK AFAdRevenueData(final Runnable runnable) {
        return new AFi1aSDK(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getCurrencyIso4217Code(runnable);
            }
        }, this.getCurrencyIso4217Code.getCurrencyIso4217Code(), this.getCurrencyIso4217Code.AFAdRevenueData());
    }

    public final boolean AFAdRevenueData() {
        Iterator<AFj1zSDK> it = this.AFAdRevenueData.iterator();
        while (it.hasNext()) {
            if (it.next().component2 == AFj1zSDK.AFa1ySDK.STARTED) {
                return false;
            }
        }
        return true;
    }

    public final Runnable getCurrencyIso4217Code(final AFi1aSDK aFi1aSDK, final Runnable runnable) {
        return new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getMediationNetwork(aFi1aSDK, runnable);
            }
        };
    }

    public final boolean getCurrencyIso4217Code() {
        return this.getCurrencyIso4217Code.AFAdRevenueData().getMediationNetwork("AF_PREINSTALL_DISABLED");
    }

    public final boolean getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        int currencyIso4217Code = this.getCurrencyIso4217Code.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0);
        return (!this.getCurrencyIso4217Code.getMediationNetwork().getRevenue(AppsFlyerProperties.NEW_REFERRER_SENT) && currencyIso4217Code == 1) || (currencyIso4217Code == 1 && !(aFh1sSDK instanceof AFh1pSDK));
    }

    public final void getMediationNetwork(final Context context, final Runnable runnable, final AFd1zSDK aFd1zSDK) {
        if (aFd1zSDK.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) > 0) {
            AFLogger.INSTANCE.d(AFg1cSDK.PREINSTALL, "Preinstall referrer will not load, the counter >= 1, ");
        } else {
            aFd1zSDK.getCurrencyIso4217Code().execute(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getMonetizationNetwork(context, runnable, aFd1zSDK);
                }
            });
        }
    }

    public final void getRevenue(final Runnable runnable) {
        this.AFAdRevenueData.add(new AFj1xSDK(this.getCurrencyIso4217Code.AFAdRevenueData(), this.getCurrencyIso4217Code.getCurrencyIso4217Code(), AFj1vSDK.FACEBOOK, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.areAllFieldsValid(runnable);
            }
        }));
    }
}
