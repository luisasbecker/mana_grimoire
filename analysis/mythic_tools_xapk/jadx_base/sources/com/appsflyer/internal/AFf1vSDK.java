package com.appsflyer.internal;

import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1vSDK extends AFe1uSDK<AFf1nSDK> {
    private final AFc1gSDK AFKeystoreWrapper;
    private final AFf1qSDK areAllFieldsValid;
    public AFi1vSDK component1;
    private final AFc1kSDK component2;
    public AFf1nSDK component3;
    public final AFf1uSDK component4;
    private final String copy;
    private final AFf1oSDK copydefault;
    private final AFf1kSDK equals;
    private final AFf1pSDK hashCode;
    private final AFd1mSDK toString;

    public AFf1vSDK(AFf1qSDK aFf1qSDK, AFc1kSDK aFc1kSDK, AFf1kSDK aFf1kSDK, AFf1pSDK aFf1pSDK, AFd1mSDK aFd1mSDK, AFf1oSDK aFf1oSDK, String str, AFf1uSDK aFf1uSDK, AFc1gSDK aFc1gSDK) {
        super(AFe1lSDK.RC_CDN, new AFe1lSDK[0], "UpdateRemoteConfiguration");
        this.component3 = null;
        this.areAllFieldsValid = aFf1qSDK;
        this.component2 = aFc1kSDK;
        this.equals = aFf1kSDK;
        this.hashCode = aFf1pSDK;
        this.toString = aFd1mSDK;
        this.copydefault = aFf1oSDK;
        this.copy = str;
        this.component4 = aFf1uSDK;
        this.AFKeystoreWrapper = aFc1gSDK;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AFf1nSDK areAllFieldsValid() throws InterruptedException, InterruptedIOException {
        String currencyIso4217Code;
        String strAFAdRevenueData;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.copy;
        String monetizationNetwork = this.equals.getMonetizationNetwork();
        if (monetizationNetwork == null || monetizationNetwork.trim().length() == 0) {
            AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "Dev key is not set, SDK is not started.");
        } else {
            if (str != null) {
                currencyIso4217Code = AFj1jSDK.getCurrencyIso4217Code(TextUtils.join("\u2063", new String[]{"appsflyersdk.com", str, this.component2.getRevenue.getCurrencyIso4217Code.getPackageName()}), monetizationNetwork);
                if (currencyIso4217Code != null) {
                    AFLogger.INSTANCE.v(AFg1cSDK.REMOTE_CONTROL, "can't create CDN token, skipping fetch config");
                    return AFf1nSDK.FAILURE;
                }
                try {
                    if (!this.copydefault.getMonetizationNetwork()) {
                        AFLogger.INSTANCE.d(AFg1cSDK.REMOTE_CONTROL, "active config is valid, skipping fetch");
                        return AFf1nSDK.USE_CACHED;
                    }
                    AFLogger.INSTANCE.i(AFg1cSDK.REMOTE_CONTROL, "Cached config is expired or net token is null, updating...");
                    AFe1ySDK<AFh1cSDK> revenue = this.toString.AFAdRevenueData(this.copydefault.AFAdRevenueData(), this.copydefault.getCurrencyIso4217Code(), currencyIso4217Code, 1500).getRevenue();
                    if (!revenue.isSuccessful()) {
                        getMonetizationNetwork(currencyIso4217Code, jCurrentTimeMillis, null, null, revenue);
                        AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, new StringBuilder("failed to fetch remote config from CDN with status code: ").append(revenue.getStatusCode()).toString());
                        return AFf1nSDK.FAILURE;
                    }
                    if (this.AFKeystoreWrapper != null && (strAFAdRevenueData = revenue.AFAdRevenueData("af-net-tkn")) != null && !strAFAdRevenueData.isEmpty()) {
                        this.AFKeystoreWrapper.hashCode = strAFAdRevenueData;
                        AFLogger.INSTANCE.d(AFg1cSDK.REMOTE_CONTROL, "Network token saved");
                    }
                    AFh1cSDK body = revenue.getBody();
                    String strAFAdRevenueData2 = revenue.AFAdRevenueData("x-amz-meta-af-auth-v1");
                    String strAFAdRevenueData3 = revenue.AFAdRevenueData("CF-Cache-Status");
                    String monetizationNetwork2 = this.equals.getMonetizationNetwork();
                    if (monetizationNetwork2 != null && monetizationNetwork2.trim().length() != 0) {
                        AFi1uSDK monetizationNetwork3 = this.areAllFieldsValid.getMonetizationNetwork(body, strAFAdRevenueData2, currencyIso4217Code, monetizationNetwork2);
                        if (!monetizationNetwork3.getMonetizationNetwork()) {
                            getMonetizationNetwork(currencyIso4217Code, jCurrentTimeMillis, monetizationNetwork3.getMediationNetwork, strAFAdRevenueData3, revenue);
                            AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "fetched config is not valid (MITM?) refuse to use it.");
                            return AFf1nSDK.FAILURE;
                        }
                        long revenue2 = this.copydefault.getRevenue();
                        AFLogger.INSTANCE.v(AFg1cSDK.REMOTE_CONTROL, new StringBuilder("using max-age fallback: ").append(revenue2).append(" seconds").toString());
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        AFf1pSDK aFf1pSDK = this.hashCode;
                        aFf1pSDK.getCurrencyIso4217Code.getMediationNetwork("af_remote_config", Base64.encodeToString(body.getRevenue.getBytes(Charset.defaultCharset()), 2));
                        aFf1pSDK.getMonetizationNetwork = aFf1pSDK.AFAdRevenueData;
                        aFf1pSDK.getCurrencyIso4217Code.getRevenue("af_rc_timestamp", jCurrentTimeMillis2);
                        aFf1pSDK.getCurrencyIso4217Code.getRevenue("af_rc_max_age", revenue2);
                        aFf1pSDK.AFAdRevenueData = body;
                        aFf1pSDK.getRevenue = jCurrentTimeMillis2;
                        aFf1pSDK.getMediationNetwork = revenue2;
                        AFLogger.INSTANCE.d(AFg1cSDK.REMOTE_CONTROL, new StringBuilder("Config successfully updated, timeToLive: ").append(revenue2).append(" seconds").toString());
                        getMonetizationNetwork(currencyIso4217Code, jCurrentTimeMillis, monetizationNetwork3.getMediationNetwork, strAFAdRevenueData3, revenue);
                        return AFf1nSDK.SUCCESS;
                    }
                    AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "Dev key is not set, SDK is not started.");
                    return AFf1nSDK.FAILURE;
                } catch (IOException e) {
                    AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, new StringBuilder("failed to fetch remote config: ").append(e.getMessage()).toString(), e, true, false, false);
                    getCurrencyIso4217Code(currencyIso4217Code, jCurrentTimeMillis, e instanceof ParsingException ? ((ParsingException) e).getRawResponse() : null, null, null, null, e);
                    if (e.getCause() instanceof InterruptedIOException) {
                        throw ((InterruptedIOException) e.getCause());
                    }
                    return AFf1nSDK.FAILURE;
                } catch (Throwable th) {
                    AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, new StringBuilder("failed to update remote config: ").append(th.getMessage()).toString(), th, true, false, false);
                    getCurrencyIso4217Code(currencyIso4217Code, jCurrentTimeMillis, null, null, null, null, th);
                    if (th.getCause() instanceof InterruptedException) {
                        throw ((InterruptedException) th.getCause());
                    }
                    return AFf1nSDK.FAILURE;
                }
            }
            AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "Can't create CDN token, domain or version is not provided.");
        }
        currencyIso4217Code = null;
        if (currencyIso4217Code != null) {
        }
    }

    private void getCurrencyIso4217Code(String str, long j, AFe1ySDK<?> aFe1ySDK, AFh1cSDK aFh1cSDK, AFi1ySDK aFi1ySDK, String str2, Throwable th) {
        long j2;
        int statusCode;
        Throwable th2;
        if (aFe1ySDK != null) {
            j2 = aFe1ySDK.AFAdRevenueData.AFAdRevenueData;
            statusCode = aFe1ySDK.getStatusCode();
        } else {
            j2 = 0;
            statusCode = 0;
        }
        int i = statusCode;
        if (th instanceof HttpException) {
            Throwable cause = th.getCause();
            j2 = ((HttpException) th).getMetrics().AFAdRevenueData;
            th2 = cause;
        } else {
            th2 = th;
        }
        this.component1 = new AFi1vSDK(aFh1cSDK != null ? aFh1cSDK.AFAdRevenueData : null, str, j2, System.currentTimeMillis() - j, i, aFi1ySDK, str2, th2);
    }

    private void getMonetizationNetwork(String str, long j, AFi1ySDK aFi1ySDK, String str2, AFe1ySDK<AFh1cSDK> aFe1ySDK) {
        getCurrencyIso4217Code(str, j, aFe1ySDK, aFe1ySDK != null ? aFe1ySDK.getBody() : null, aFi1ySDK, str2 != null ? str2 : null, null);
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final AFe1rSDK getMediationNetwork() throws Exception {
        try {
            AFf1nSDK aFf1nSDKAreAllFieldsValid = areAllFieldsValid();
            this.component3 = aFf1nSDKAreAllFieldsValid;
            return aFf1nSDKAreAllFieldsValid == AFf1nSDK.FAILURE ? AFe1rSDK.FAILURE : AFe1rSDK.SUCCESS;
        } catch (InterruptedIOException e) {
            e = e;
            AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, "RC update config failed", e, false, false, false);
            this.component3 = AFf1nSDK.FAILURE;
            return AFe1rSDK.TIMEOUT;
        } catch (InterruptedException e2) {
            e = e2;
            AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, "RC update config failed", e, false, false, false);
            this.component3 = AFf1nSDK.FAILURE;
            return AFe1rSDK.TIMEOUT;
        } catch (SocketTimeoutException unused) {
            this.component3 = AFf1nSDK.FAILURE;
            return AFe1rSDK.TIMEOUT;
        }
    }

    @Override // com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return 1500L;
    }
}
