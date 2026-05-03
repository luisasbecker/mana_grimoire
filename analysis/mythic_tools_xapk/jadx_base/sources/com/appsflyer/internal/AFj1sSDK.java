package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1zSDK;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1sSDK extends AFi1bSDK {
    private final AFd1zSDK getMonetizationNetwork;

    public AFj1sSDK(Runnable runnable, AFd1zSDK aFd1zSDK) {
        super(ProductResponseJsonKeys.STORE, "samsung", runnable);
        this.getMonetizationNetwork = aFd1zSDK;
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(Context context) {
        AFb1tSDK<Map<String, Object>> aFb1tSDK = new AFb1tSDK<Map<String, Object>>(context, this.getMonetizationNetwork.getCurrencyIso4217Code(), "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") { // from class: com.appsflyer.internal.AFj1sSDK.5
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00d7 A[PHI: r3
              0x00d7: PHI (r3v1 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:24:0x00d5, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // com.appsflyer.internal.AFb1tSDK
            /* JADX INFO: renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Map<String, Object> getMediationNetwork() {
                String string;
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = this.getCurrencyIso4217Code.getContentResolver().query(Uri.parse(new StringBuilder("content://").append(this.getMonetizationNetwork).toString()), null, null, null, null);
                        if (cursorQuery != null) {
                            boolean zMoveToFirst = cursorQuery.moveToFirst();
                            AFj1sSDK aFj1sSDK = AFj1sSDK.this;
                            if (zMoveToFirst) {
                                aFj1sSDK.getCurrencyIso4217Code.put("response", "OK");
                                E_("referrer", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                D_("click_ts", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                D_("install_begin_ts", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                D_("install_end_ts", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                E_("organic_keywords", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                E_("attr_type", AFj1sSDK.this.getCurrencyIso4217Code, cursorQuery);
                                HashMap map = new HashMap();
                                int columnIndex = cursorQuery.getColumnIndex("instant");
                                if (columnIndex != -1 && (string = cursorQuery.getString(columnIndex)) != null) {
                                    map.put("instant", Boolean.valueOf(Boolean.parseBoolean(string)));
                                }
                                D_("click_server_ts", map, cursorQuery);
                                D_("install_begin_server_ts", map, cursorQuery);
                                E_("install_version", map, cursorQuery);
                                if (!map.isEmpty()) {
                                    AFj1sSDK.this.getCurrencyIso4217Code.put("custom", map);
                                }
                            } else {
                                aFj1sSDK.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
                            }
                        } else {
                            AFj1sSDK.this.getCurrencyIso4217Code.put("response", "SERVICE_UNAVAILABLE");
                        }
                    } catch (Exception e) {
                        AFj1sSDK.this.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
                        AFLogger.afErrorLog(e.getMessage(), e, false, true);
                        if (0 != 0) {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    String str = ((PackageItemInfo) this.getCurrencyIso4217Code.getPackageManager().resolveContentProvider(this.getMonetizationNetwork, 128)).packageName;
                    AFj1sSDK.this.getCurrencyIso4217Code.put("api_ver", Long.valueOf(AFj1pSDK.getCurrencyIso4217Code(this.getCurrencyIso4217Code, str)));
                    AFj1sSDK.this.getCurrencyIso4217Code.put("api_ver_name", AFj1pSDK.getMonetizationNetwork(this.getCurrencyIso4217Code, str));
                    AFj1sSDK.this.getCurrencyIso4217Code();
                    return AFj1sSDK.this.getCurrencyIso4217Code;
                } finally {
                }
            }

            private static void D_(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return;
                }
                long j = cursor.getLong(columnIndex);
                if (j == 0) {
                    return;
                }
                map.put(str, Long.valueOf(j));
            }

            private static void E_(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1 || (string = cursor.getString(columnIndex)) == null) {
                    return;
                }
                map.put(str, string);
            }
        };
        AFc1jSDK mediationNetwork = this.getMonetizationNetwork.getMediationNetwork();
        AFa1tSDK.getMediationNetwork();
        if (AFa1tSDK.getMediationNetwork(mediationNetwork, false) > 0 || !aFb1tSDK.getMonetizationNetwork()) {
            return;
        }
        aFb1tSDK.getRevenue.execute(aFb1tSDK.getMediationNetwork);
        this.areAllFieldsValid = System.currentTimeMillis();
        this.component2 = AFj1zSDK.AFa1ySDK.STARTED;
        addObserver(new AFj1zSDK.AnonymousClass3());
    }
}
