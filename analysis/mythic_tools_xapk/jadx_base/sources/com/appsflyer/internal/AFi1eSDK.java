package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1zSDK;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class AFi1eSDK extends AFi1hSDK {
    private final AFd1zSDK getMediationNetwork;
    private final AFi1cSDK getMonetizationNetwork;

    public AFi1eSDK(Runnable runnable, AFd1zSDK aFd1zSDK, AFi1cSDK aFi1cSDK) {
        super(ProductResponseJsonKeys.STORE, "huawei", aFd1zSDK.AFAdRevenueData(), runnable);
        this.getMediationNetwork = aFd1zSDK;
        this.getMonetizationNetwork = aFi1cSDK;
    }

    private boolean AFAdRevenueData(Context context) {
        if (!getMonetizationNetwork()) {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by counter.");
            return false;
        }
        if (!this.getMonetizationNetwork.getMediationNetwork(context)) {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by missing content provider.");
            return false;
        }
        if (this.getMonetizationNetwork.getCurrencyIso4217Code(context)) {
            return true;
        }
        AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by invalid content provider.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0101 A[PHI: r3
      0x0101: PHI (r3v5 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:24:0x00ff, B:15:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void getRevenue(Context context) {
        this.areAllFieldsValid = System.currentTimeMillis();
        this.component2 = AFj1zSDK.AFa1ySDK.STARTED;
        addObserver(new AFj1zSDK.AnonymousClass3());
        String str = ((PackageItemInfo) context.getPackageManager().resolveContentProvider("com.huawei.appmarket.commondata", 128)).packageName;
        this.getCurrencyIso4217Code.put("api_ver", Long.valueOf(AFj1pSDK.getCurrencyIso4217Code(context, str)));
        this.getCurrencyIso4217Code.put("api_ver_name", AFj1pSDK.getMonetizationNetwork(context, str));
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.huawei.appmarket.commondata/item/5"), null, null, new String[]{context.getPackageName()}, null);
            if (cursorQuery == null) {
                this.getCurrencyIso4217Code.put("response", "SERVICE_UNAVAILABLE");
            } else if (cursorQuery.moveToFirst()) {
                this.getCurrencyIso4217Code.put("response", "OK");
                this.getCurrencyIso4217Code.put("referrer", cursorQuery.getString(0));
                this.getCurrencyIso4217Code.put("click_ts", Long.valueOf(cursorQuery.getLong(1)));
                this.getCurrencyIso4217Code.put("install_end_ts", Long.valueOf(cursorQuery.getLong(2)));
                if (cursorQuery.getColumnCount() > 3) {
                    this.getCurrencyIso4217Code.put("install_begin_ts", Long.valueOf(cursorQuery.getLong(3)));
                    HashMap map = new HashMap();
                    String string = cursorQuery.getString(4);
                    if (string != null) {
                        map.put("track_id", string);
                    }
                    map.put("referrer_ex", cursorQuery.getString(5));
                    this.getCurrencyIso4217Code.put("huawei_custom", map);
                }
            } else {
                this.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
            }
        } catch (Throwable th) {
            try {
                this.getCurrencyIso4217Code.put("response", "FEATURE_NOT_SUPPORTED");
                AFLogger.INSTANCE.e(AFg1cSDK.REFERRER, th.getMessage() != null ? th.getMessage() : "", th, false, true);
                if (0 != 0) {
                }
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        getCurrencyIso4217Code();
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(final Context context) {
        if (AFAdRevenueData(context)) {
            this.getMediationNetwork.getCurrencyIso4217Code().execute(new Runnable() { // from class: com.appsflyer.internal.AFi1eSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getRevenue(context);
                }
            });
        }
    }
}
