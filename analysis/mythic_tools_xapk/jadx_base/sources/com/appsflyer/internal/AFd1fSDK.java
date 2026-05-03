package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1fSDK<ResponseBody> {
    private final AtomicBoolean AFAdRevenueData = new AtomicBoolean(false);
    private final AFd1jSDK getCurrencyIso4217Code;
    public final AFd1cSDK getMediationNetwork;
    private final ExecutorService getMonetizationNetwork;
    private final AFe1wSDK<ResponseBody> getRevenue;

    public AFd1fSDK(AFd1cSDK aFd1cSDK, ExecutorService executorService, AFd1jSDK aFd1jSDK, AFe1wSDK<ResponseBody> aFe1wSDK) {
        this.getMediationNetwork = aFd1cSDK;
        this.getMonetizationNetwork = executorService;
        this.getCurrencyIso4217Code = aFd1jSDK;
        this.getRevenue = aFe1wSDK;
    }

    public final AFe1ySDK<ResponseBody> getRevenue() throws IOException {
        if (this.AFAdRevenueData.getAndSet(true)) {
            throw new IllegalStateException("Http call is already executed");
        }
        AFe1ySDK<String> monetizationNetwork = this.getCurrencyIso4217Code.getMonetizationNetwork(this.getMediationNetwork);
        try {
            return new AFe1ySDK<>(this.getRevenue.getCurrencyIso4217Code(monetizationNetwork.getBody()), monetizationNetwork.getRevenue, monetizationNetwork.getMonetizationNetwork, monetizationNetwork.getMediationNetwork, monetizationNetwork.AFAdRevenueData);
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e);
            throw new ParsingException(e.getMessage(), e, monetizationNetwork);
        }
    }
}
