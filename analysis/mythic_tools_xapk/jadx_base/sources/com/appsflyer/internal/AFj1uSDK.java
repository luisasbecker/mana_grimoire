package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1zSDK;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1uSDK extends AFi1hSDK {
    public AFj1uSDK(AFc1kSDK aFc1kSDK, Runnable runnable) {
        super(ProductResponseJsonKeys.STORE, "xiaomi", aFc1kSDK, runnable);
    }

    private boolean AFAdRevenueData() {
        if (!getMonetizationNetwork()) {
            return false;
        }
        try {
            Class.forName("com.miui.referrer.api.GetAppsReferrerClient");
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Xiaomi Install Referrer is allowed");
            return true;
        } catch (ClassNotFoundException unused) {
            AFLogger.INSTANCE.v(AFg1cSDK.REFERRER, "Class com.miui.referrer.api.GetAppsReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, "An error occurred while trying to access GetAppsReferrerClient", th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(final Context context) {
        if (AFAdRevenueData()) {
            this.areAllFieldsValid = System.currentTimeMillis();
            this.component2 = AFj1zSDK.AFa1ySDK.STARTED;
            addObserver(new AFj1zSDK.AnonymousClass3());
            final GetAppsReferrerClient getAppsReferrerClientBuild = GetAppsReferrerClient.Companion.newBuilder(context).build();
            getAppsReferrerClientBuild.startConnection(new GetAppsReferrerStateListener() { // from class: com.appsflyer.internal.AFj1uSDK.5
                public final void onGetAppsReferrerSetupFinished(int i) {
                    AFj1uSDK.this.getCurrencyIso4217Code.put("api_ver", Long.valueOf(AFj1pSDK.getCurrencyIso4217Code(context, "com.xiaomi.mipicks")));
                    AFj1uSDK.this.getCurrencyIso4217Code.put("api_ver_name", AFj1pSDK.getMonetizationNetwork(context, "com.xiaomi.mipicks"));
                    if (i == -1) {
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiInstallReferrer SERVICE_DISCONNECTED");
                        AFj1uSDK.this.getCurrencyIso4217Code.put("response", "SERVICE_DISCONNECTED");
                    } else if (i == 0) {
                        AFj1uSDK aFj1uSDK = AFj1uSDK.this;
                        GetAppsReferrerClient getAppsReferrerClient = getAppsReferrerClientBuild;
                        aFj1uSDK.getCurrencyIso4217Code.put("response", "OK");
                        try {
                            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "XiaomiInstallReferrer connected");
                            if (getAppsReferrerClient.isReady()) {
                                GetAppsReferrerDetails installReferrer = getAppsReferrerClient.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    aFj1uSDK.getCurrencyIso4217Code.put("referrer", installReferrer2);
                                }
                                aFj1uSDK.getCurrencyIso4217Code.put("click_ts", Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                                aFj1uSDK.getCurrencyIso4217Code.put("install_begin_ts", Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                                HashMap map = new HashMap();
                                map.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                map.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                map.put("install_version", installReferrer.getInstallVersion());
                                aFj1uSDK.getCurrencyIso4217Code.put("xiaomi_custom", map);
                            } else {
                                AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiReferrerClient: XiaomiInstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, new StringBuilder("Failed to get Xiaomi install referrer: ").append(th.getMessage()).toString());
                        }
                    } else if (i == 1) {
                        AFj1uSDK.this.getCurrencyIso4217Code.put("response", "SERVICE_UNAVAILABLE");
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiInstallReferrer not supported");
                    } else if (i == 2) {
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiInstallReferrer FEATURE_NOT_SUPPORTED");
                        AFj1uSDK.this.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
                    } else if (i == 3) {
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFj1uSDK.this.getCurrencyIso4217Code.put("response", "DEVELOPER_ERROR");
                    } else if (i != 4) {
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "responseCode not found.");
                    } else {
                        AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFj1uSDK.this.getCurrencyIso4217Code.put("response", "PERMISSION_ERROR");
                    }
                    AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Xiaomi Install Referrer collected locally");
                    AFj1uSDK.this.getCurrencyIso4217Code();
                    getAppsReferrerClientBuild.endConnection();
                }

                public final void onGetAppsServiceDisconnected() {
                }
            });
        }
    }
}
