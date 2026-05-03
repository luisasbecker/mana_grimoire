package com.appsflyer.internal;

import android.os.Build;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFj1zSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1wSDK extends AFe1bSDK<AFa1mSDK> {
    private int AFInAppEventParameterName;
    private int AFInAppEventType;
    private final List<AFj1zSDK> AFKeystoreWrapper;
    private final CountDownLatch AFLogger;
    private final AFa1pSDK component2;
    private final AFj1rSDK copy;
    private final AFa1oSDK copydefault;
    private final AFc1gSDK equals;
    private final AFc1kSDK hashCode;
    private int registerClient;
    private final AFh1uSDK toString;

    public /* synthetic */ class AFa1tSDK {
        public static final /* synthetic */ int[] getCurrencyIso4217Code;
        public static final /* synthetic */ int[] getMediationNetwork;

        static {
            int[] iArr = new int[AFe1rSDK.values().length];
            try {
                iArr[AFe1rSDK.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1rSDK.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            getCurrencyIso4217Code = iArr;
            int[] iArr2 = new int[AFj1zSDK.AFa1ySDK.values().length];
            try {
                iArr2[AFj1zSDK.AFa1ySDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AFj1zSDK.AFa1ySDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            getMediationNetwork = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1wSDK(AFa1pSDK aFa1pSDK, AFd1zSDK aFd1zSDK) {
        super(AFe1lSDK.DLSDK, new AFe1lSDK[]{AFe1lSDK.RC_CDN, AFe1lSDK.FETCH_ADVERTISING_ID}, aFd1zSDK, "DdlSdk");
        Intrinsics.checkNotNullParameter(aFa1pSDK, "");
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.component2 = aFa1pSDK;
        this.AFLogger = new CountDownLatch(1);
        this.AFKeystoreWrapper = new ArrayList();
        AFc1kSDK aFc1kSDKAFAdRevenueData = aFd1zSDK.AFAdRevenueData();
        Intrinsics.checkNotNullExpressionValue(aFc1kSDKAFAdRevenueData, "");
        this.hashCode = aFc1kSDKAFAdRevenueData;
        AFc1gSDK aFc1gSDKE = aFd1zSDK.e();
        Intrinsics.checkNotNullExpressionValue(aFc1gSDKE, "");
        this.equals = aFc1gSDKE;
        AFa1oSDK aFa1oSDKI = aFd1zSDK.i();
        Intrinsics.checkNotNullExpressionValue(aFa1oSDKI, "");
        this.copydefault = aFa1oSDKI;
        AFh1uSDK aFh1uSDKComponent2 = aFd1zSDK.component2();
        Intrinsics.checkNotNullExpressionValue(aFh1uSDKComponent2, "");
        this.toString = aFh1uSDKComponent2;
        AFj1rSDK aFj1rSDKCopydefault = aFd1zSDK.copydefault();
        Intrinsics.checkNotNullExpressionValue(aFj1rSDKCopydefault, "");
        this.copy = aFj1rSDKCopydefault;
        AFj1zSDK[] aFj1zSDKArr = (AFj1zSDK[]) aFj1rSDKCopydefault.AFAdRevenueData.toArray(new AFj1zSDK[0]);
        Intrinsics.checkNotNullExpressionValue(aFj1zSDKArr, "");
        ArrayList arrayList = new ArrayList();
        for (AFj1zSDK aFj1zSDK : aFj1zSDKArr) {
            AFj1zSDK aFj1zSDK2 = aFj1zSDK;
            if (aFj1zSDK2 != null && aFj1zSDK2.component2 != AFj1zSDK.AFa1ySDK.NOT_STARTED) {
                arrayList.add(aFj1zSDK);
            }
        }
        ArrayList<AFj1zSDK> arrayList2 = arrayList;
        this.registerClient = arrayList2.size();
        for (final AFj1zSDK aFj1zSDK3 : arrayList2) {
            AFj1zSDK.AFa1ySDK aFa1ySDK = aFj1zSDK3.component2;
            int i = aFa1ySDK == null ? -1 : AFa1tSDK.getMediationNetwork[aFa1ySDK.ordinal()];
            if (i == 1) {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, aFj1zSDK3.getCurrencyIso4217Code.get("source") + " referrer collected earlier", false, 4, null);
                Intrinsics.checkNotNullExpressionValue(aFj1zSDK3, "");
                AFAdRevenueData(aFj1zSDK3);
            } else if (i == 2) {
                aFj1zSDK3.addObserver(new Observer() { // from class: com.appsflyer.internal.AFf1wSDK$$ExternalSyntheticLambda0
                    @Override // java.util.Observer
                    public final void update(Observable observable, Object obj) {
                        AFf1wSDK.AFAdRevenueData(aFj1zSDK3, this, observable, obj);
                    }
                });
            }
        }
    }

    private static Map<String, String> AFAdRevenueData(AFb1mSDK aFb1mSDK) {
        String str;
        if (aFb1mSDK == null || (str = aFb1mSDK.getRevenue) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        Boolean bool = aFb1mSDK.getMonetizationNetwork;
        if (bool == null || !bool.booleanValue()) {
            return MapsKt.mapOf(TuplesKt.to("type", "unhashed"), TuplesKt.to("value", str));
        }
        return null;
    }

    private final void AFAdRevenueData(AFj1zSDK aFj1zSDK) {
        if (!getRevenue(aFj1zSDK)) {
            int i = this.AFInAppEventParameterName + 1;
            this.AFInAppEventParameterName = i;
            if (i == this.registerClient) {
                this.AFLogger.countDown();
                return;
            }
            return;
        }
        this.AFKeystoreWrapper.add(aFj1zSDK);
        this.AFLogger.countDown();
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Added non-organic " + aFj1zSDK.getClass().getSimpleName(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFAdRevenueData(AFj1zSDK aFj1zSDK, AFf1wSDK aFf1wSDK, Observable observable, Object obj) {
        Intrinsics.checkNotNullParameter(aFf1wSDK, "");
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, aFj1zSDK.getCurrencyIso4217Code.get("source") + " referrer collected via observer", false, 4, null);
        Intrinsics.checkNotNull(observable, "");
        aFf1wSDK.AFAdRevenueData((AFj1zSDK) observable);
    }

    private final boolean equals() {
        Object obj = this.component2.AFAdRevenueData.get("referrers");
        List list = obj instanceof List ? (List) obj : null;
        return (list != null ? list.size() : 0) < this.registerClient && !this.component2.AFAdRevenueData.containsKey("referrers");
    }

    private static boolean getRevenue(AFj1zSDK aFj1zSDK) {
        Object obj = aFj1zSDK.getCurrencyIso4217Code.get("click_ts");
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            if (System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1L)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean a_() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    public final /* bridge */ /* synthetic */ AppsFlyerRequestListener component1() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final AFe1rSDK getMediationNetwork() {
        AFe1rSDK mediationNetwork;
        AFe1rSDK aFe1rSDK = AFe1rSDK.FAILURE;
        try {
            mediationNetwork = super.getMediationNetwork();
            Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
        } catch (Exception e) {
            e = e;
        }
        try {
            AFh1uSDK aFh1uSDK = this.toString;
            int i = this.AFInAppEventType;
            if (i <= 0 || i > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - end", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i))));
            } else {
                int i2 = i - 1;
                aFh1uSDK.component2[i2] = System.currentTimeMillis();
                if (aFh1uSDK.areAllFieldsValid[i2] != 0) {
                    aFh1uSDK.component4[i2] = aFh1uSDK.component2[i2] - aFh1uSDK.areAllFieldsValid[i2];
                    aFh1uSDK.getMonetizationNetwork.put("net", aFh1uSDK.component4);
                } else {
                    AFLogger.afInfoLog(new StringBuilder("Metrics: ddlStart[").append(i2).append("] ts is missing").toString());
                }
            }
            int i3 = AFa1tSDK.getCurrencyIso4217Code[mediationNetwork.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return mediationNetwork;
                }
                AFLogger aFLogger = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK = AFg1cSDK.DDL;
                ResponseNetwork responseNetwork = ((AFe1bSDK) this).component4;
                AFg1hSDK.d$default(aFLogger, aFg1cSDK, "Error occurred. Server response code = " + (responseNetwork != null ? Integer.valueOf(responseNetwork.getStatusCode()) : null), false, 4, null);
                DeepLinkResult deepLinkResult = new DeepLinkResult(null, DeepLinkResult.Error.HTTP_STATUS_CODE);
                this.toString.getMediationNetwork(deepLinkResult, this.copydefault.component3);
                this.copydefault.getCurrencyIso4217Code(deepLinkResult);
                return mediationNetwork;
            }
            ResponseNetwork responseNetwork2 = ((AFe1bSDK) this).component4;
            Intrinsics.checkNotNull(responseNetwork2);
            Object body = responseNetwork2.getBody();
            Intrinsics.checkNotNullExpressionValue(body, "");
            AFa1mSDK aFa1mSDK = (AFa1mSDK) body;
            if (aFa1mSDK.AFAdRevenueData != null) {
                DeepLinkResult deepLinkResult2 = new DeepLinkResult(aFa1mSDK.AFAdRevenueData, null);
                this.toString.getMediationNetwork(deepLinkResult2, this.copydefault.component3);
                this.copydefault.getCurrencyIso4217Code(deepLinkResult2);
                return mediationNetwork;
            }
            if (this.AFInAppEventType > 1 || !aFa1mSDK.getGetMonetizationNetwork() || !equals()) {
                DeepLinkResult deepLinkResult3 = new DeepLinkResult(null, null);
                this.toString.getMediationNetwork(deepLinkResult3, this.copydefault.component3);
                this.copydefault.getCurrencyIso4217Code(deepLinkResult3);
                return mediationNetwork;
            }
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Waiting for referrers...", false, 4, null);
            this.AFLogger.await();
            AFh1uSDK aFh1uSDK2 = this.toString;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (aFh1uSDK2.component2[0] != 0) {
                aFh1uSDK2.getMonetizationNetwork.put("rfr_wait", Long.valueOf(jCurrentTimeMillis - aFh1uSDK2.component2[0]));
            } else {
                AFLogger.afInfoLog("Metrics: ddlEnd[0] ts is missing");
            }
            if (this.AFInAppEventParameterName != this.registerClient) {
                return getMediationNetwork();
            }
            DeepLinkResult deepLinkResult4 = new DeepLinkResult(null, null);
            this.toString.getMediationNetwork(deepLinkResult4, this.copydefault.component3);
            this.copydefault.getCurrencyIso4217Code(deepLinkResult4);
            return AFe1rSDK.SUCCESS;
        } catch (Exception e2) {
            e = e2;
            aFe1rSDK = mediationNetwork;
            Throwable cause = e.getCause();
            if (cause instanceof InterruptedException ? true : cause instanceof InterruptedIOException) {
                AFLogger.afErrorLogForExcManagerOnly("[DDL] Timeout", new TimeoutException());
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Timeout, didn't manage to find deferred deeplink after " + this.AFInAppEventType + " attempt(s) within " + this.copydefault.component3 + " milliseconds", false, 4, null);
                DeepLinkResult deepLinkResult5 = new DeepLinkResult(null, DeepLinkResult.Error.TIMEOUT);
                this.toString.getMediationNetwork(deepLinkResult5, this.copydefault.component3);
                this.copydefault.getCurrencyIso4217Code(deepLinkResult5);
                return AFe1rSDK.TIMEOUT;
            }
            if (cause instanceof IOException) {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Http Exception: the request was not sent to the server", false, 4, null);
                DeepLinkResult deepLinkResult6 = new DeepLinkResult(null, DeepLinkResult.Error.NETWORK);
                this.toString.getMediationNetwork(deepLinkResult6, this.copydefault.component3);
                this.copydefault.getCurrencyIso4217Code(deepLinkResult6);
                return aFe1rSDK;
            }
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Unexpected Exception: " + e, false, 4, null);
            DeepLinkResult deepLinkResult7 = new DeepLinkResult(null, DeepLinkResult.Error.UNEXPECTED);
            this.toString.getMediationNetwork(deepLinkResult7, this.copydefault.component3);
            this.copydefault.getCurrencyIso4217Code(deepLinkResult7);
            return aFe1rSDK;
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return this.copydefault.component3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0165  */
    @Override // com.appsflyer.internal.AFe1bSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final AFd1fSDK<AFa1mSDK> getRevenue(String str) {
        int i;
        Map mapMapOf;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "");
        this.AFInAppEventType++;
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Preparing request " + this.AFInAppEventType, false, 4, null);
        Map<String, Object> map = this.component2.AFAdRevenueData;
        AFj1bSDK aFj1bSDK = null;
        Object[] objArr = 0;
        if (this.AFInAppEventType == 1) {
            map.put("is_first", Boolean.valueOf(this.hashCode.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) == 0));
            map.put("lang", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
            map.put(AndroidContextPlugin.OS_KEY, Build.VERSION.RELEASE);
            map.put("type", Build.MODEL);
            map.put(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, AFb1iSDK.getCurrencyIso4217Code(this.hashCode.getCurrencyIso4217Code));
            AFb1uSDK aFb1uSDK = this.equals.getMonetizationNetwork;
            if (aFb1uSDK != null && (obj = aFb1uSDK.getRevenue) != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "");
                map.put("sharing_filter", obj);
            }
            AFh1rSDK aFh1rSDK = this.hashCode.getMediationNetwork.component2;
            Object objAFAdRevenueData = AFAdRevenueData(aFh1rSDK != null ? new AFb1mSDK(aFh1rSDK.AFAdRevenueData, aFh1rSDK.component4) : null);
            if (objAFAdRevenueData != null) {
                map.put("gaid", objAFAdRevenueData);
            }
            Object objAFAdRevenueData2 = AFAdRevenueData(AFb1jSDK.getRevenue(this.hashCode.getRevenue.getCurrencyIso4217Code));
            if (objAFAdRevenueData2 != null) {
                map.put("oaid", objAFAdRevenueData2);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        map.put(DiagnosticsEntry.TIMESTAMP_KEY, simpleDateFormat.format(new Date(jCurrentTimeMillis)));
        map.put("request_count", Integer.valueOf(this.AFInAppEventType));
        List<AFj1zSDK> list = this.AFKeystoreWrapper;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            AFj1zSDK aFj1zSDK = (AFj1zSDK) it.next();
            if (aFj1zSDK.component2 == AFj1zSDK.AFa1ySDK.FINISHED) {
                Object obj2 = aFj1zSDK.getCurrencyIso4217Code.get("referrer");
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 != null) {
                    Object obj3 = aFj1zSDK.getCurrencyIso4217Code.get("source");
                    Intrinsics.checkNotNull(obj3, "");
                    mapMapOf = MapsKt.mapOf(TuplesKt.to("source", (String) obj3), TuplesKt.to("value", str2));
                } else {
                    mapMapOf = null;
                }
            }
            if (mapMapOf != null) {
                arrayList.add(mapMapOf);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            map.put("referrers", arrayList2);
        }
        AFa1pSDK aFa1pSDK = this.component2;
        AFj1kSDK aFj1kSDK = new AFj1kSDK(this.hashCode, aFj1bSDK, i, objArr == true ? 1 : 0);
        String monetizationNetwork = ((AFe1bSDK) this).component1.getMonetizationNetwork();
        Object obj4 = this.component2.AFAdRevenueData.get(DiagnosticsEntry.TIMESTAMP_KEY);
        Intrinsics.checkNotNull(obj4, "");
        aFa1pSDK.component3 = aFj1kSDK.getCurrencyIso4217Code(monetizationNetwork, (String) obj4);
        AFh1uSDK aFh1uSDK = this.toString;
        int i2 = this.AFInAppEventType;
        if (i2 <= 0 || i2 > 2) {
            AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - start", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i2))));
        } else {
            int i3 = i2 - 1;
            aFh1uSDK.areAllFieldsValid[i3] = System.currentTimeMillis();
            if (i3 == 0) {
                if (aFh1uSDK.component1 != 0) {
                    aFh1uSDK.getMonetizationNetwork.put("from_fg", Long.valueOf(aFh1uSDK.areAllFieldsValid[i3] - aFh1uSDK.component1));
                } else {
                    AFLogger.afInfoLog("Metrics: fg ts is missing");
                }
            }
        }
        AFd1fSDK<AFa1mSDK> currencyIso4217Code = ((AFe1bSDK) this).component3.getCurrencyIso4217Code(this.component2);
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        return currencyIso4217Code;
    }
}
