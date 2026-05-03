package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface AFd1zSDK {
    AFc1kSDK AFAdRevenueData();

    AFf1kSDK AFInAppEventParameterName();

    AFe1vSDK AFInAppEventType();

    AFc1vSDK AFKeystoreWrapper();

    AFi1lSDK AFLogger();

    AFh1ySDK afDebugLog();

    AFa1gSDK afErrorLog();

    AFh1wSDK afErrorLogForExcManagerOnly();

    AFb1bSDK afInfoLog();

    AFd1xSDK afLogForce();

    AFb1hSDK afVerboseLog();

    AFg1vSDK areAllFieldsValid();

    PurchaseHandler component1();

    AFh1uSDK component2();

    AFf1mSDK component3();

    AFj1oSDK component4();

    AFd1lSDK copy();

    AFj1rSDK copydefault();

    AFi1xSDK d();

    AFc1gSDK e();

    AFe1qSDK equals();

    AFf1gSDK force();

    ExecutorService getCurrencyIso4217Code();

    AFc1jSDK getMediationNetwork();

    ScheduledExecutorService getMonetizationNetwork();

    AFd1mSDK getRevenue();

    AFa1oSDK i();

    AFc1fSDK registerClient();

    AFa1aSDK unregisterClient();

    AFi1nSDK v();

    AFi1rSDK w();
}
