package com.appsflyer.internal;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1zSDK;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public class AFi1aSDK extends AFi1hSDK {
    public final Map<String, Object> getMediationNetwork;
    final ExecutorService getMonetizationNetwork;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFi1aSDK$4, reason: invalid class name */
    final class AnonymousClass4 implements InstallReferrerStateListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ InstallReferrerClient val$referrerClient;

        AnonymousClass4(InstallReferrerClient installReferrerClient, Context context) {
            this.val$referrerClient = installReferrerClient;
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInstallReferrerSetupFinished$0(InstallReferrerClient installReferrerClient, Context context, int i) {
            AFi1aSDK.this.getRevenue(installReferrerClient, context, i);
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerServiceDisconnected() {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install Referrer service disconnected");
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerSetupFinished(final int i) {
            ExecutorService executorService = AFi1aSDK.this.getMonetizationNetwork;
            final InstallReferrerClient installReferrerClient = this.val$referrerClient;
            final Context context = this.val$context;
            executorService.execute(new Runnable() { // from class: com.appsflyer.internal.AFi1aSDK$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onInstallReferrerSetupFinished$0(installReferrerClient, context, i);
                }
            });
        }
    }

    public AFi1aSDK(Runnable runnable, ExecutorService executorService, AFc1kSDK aFc1kSDK) {
        super(ProductResponseJsonKeys.STORE, "google", aFc1kSDK, runnable);
        this.getMediationNetwork = new HashMap();
        this.getMonetizationNetwork = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFAdRevenueData(Context context) {
        this.areAllFieldsValid = System.currentTimeMillis();
        this.component2 = AFj1zSDK.AFa1ySDK.STARTED;
        addObserver(new AFj1zSDK.AnonymousClass3());
        try {
            InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Connecting to Install Referrer Library...");
            installReferrerClientBuild.startConnection(new AnonymousClass4(installReferrerClientBuild, context));
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "referrerClient -> startConnection", th);
        }
    }

    private boolean getRevenue(Context context) {
        if (!getMonetizationNetwork()) {
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (AFj1pSDK.getRevenue(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install referrer is allowed");
                return true;
            }
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly("InstallReferrerClient not found", e);
            AFLogger.INSTANCE.v(AFg1cSDK.REFERRER, "Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "An error occurred while trying to verify manifest : ".concat(String.valueOf("com.android.installreferrer.api.InstallReferrerClient")), th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(final Context context) {
        if (getRevenue(context)) {
            this.getMonetizationNetwork.execute(new Runnable() { // from class: com.appsflyer.internal.AFi1aSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.AFAdRevenueData(context);
                }
            });
        }
    }

    protected final void getRevenue(InstallReferrerClient installReferrerClient, Context context, int i) {
        this.getMediationNetwork.put("code", String.valueOf(i));
        Pair<Long, String> pairAFAdRevenueData = AFj1pSDK.AFAdRevenueData(context, "com.android.vending");
        this.getCurrencyIso4217Code.put("api_ver", pairAFAdRevenueData.getFirst());
        this.getCurrencyIso4217Code.put("api_ver_name", pairAFAdRevenueData.getSecond());
        if (i == -1) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer SERVICE_DISCONNECTED");
            this.getCurrencyIso4217Code.put("response", "SERVICE_DISCONNECTED");
        } else if (i == 0) {
            this.getCurrencyIso4217Code.put("response", "OK");
            try {
                AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "InstallReferrer connected");
                if (installReferrerClient.isReady()) {
                    ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null) {
                        this.getMediationNetwork.put("val", installReferrer2);
                        this.getCurrencyIso4217Code.put("referrer", installReferrer2);
                    }
                    long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                    this.getMediationNetwork.put("clk", Long.toString(referrerClickTimestampSeconds));
                    this.getCurrencyIso4217Code.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                    long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                    this.getMediationNetwork.put("install", Long.toString(installBeginTimestampSeconds));
                    this.getCurrencyIso4217Code.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                    HashMap map = new HashMap();
                    try {
                        boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                        this.getMediationNetwork.put("instant", Boolean.valueOf(googlePlayInstantParam));
                        map.put("instant", Boolean.valueOf(googlePlayInstantParam));
                    } catch (NoSuchMethodError e) {
                        AFLogger.afErrorLogForExcManagerOnly("getGooglePlayInstantParam not exist", e);
                    }
                    try {
                        map.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                        map.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                        map.put("install_version", installReferrer.getInstallVersion());
                    } catch (NoSuchMethodError e2) {
                        AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "some method not exist", e2, false, false);
                    }
                    if (!map.isEmpty()) {
                        this.getCurrencyIso4217Code.put("google_custom", map);
                    }
                    installReferrerClient.endConnection();
                } else {
                    AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "ReferrerClient: InstallReferrer is not ready");
                    this.getMediationNetwork.put(NotificationCompat.CATEGORY_ERROR, "ReferrerClient: InstallReferrer is not ready");
                }
            } catch (Throwable th) {
                AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, new StringBuilder("Failed to get install referrer: ").append(th.getMessage()).toString());
                this.getMediationNetwork.put(NotificationCompat.CATEGORY_ERROR, th.getMessage());
                AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "Failed to get install referrer", th, false, false);
            }
        } else if (i == 1) {
            this.getCurrencyIso4217Code.put("response", "SERVICE_UNAVAILABLE");
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer not supported");
        } else if (i == 2) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer FEATURE_NOT_SUPPORTED");
            this.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
        } else if (i != 3) {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "responseCode not found.");
        } else {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "InstallReferrer DEVELOPER_ERROR");
            this.getCurrencyIso4217Code.put("response", "DEVELOPER_ERROR");
        }
        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Install Referrer collected locally");
        getCurrencyIso4217Code();
    }
}
