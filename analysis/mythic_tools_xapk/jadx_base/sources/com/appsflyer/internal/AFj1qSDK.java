package com.appsflyer.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1zSDK;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1qSDK extends AFi1hSDK {
    private final ExecutorService getMediationNetwork;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFj1qSDK(ExecutorService executorService, AFc1kSDK aFc1kSDK, Runnable runnable) {
        super("preload", "samsung", aFc1kSDK, runnable);
        Intrinsics.checkNotNullParameter(executorService, "");
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        this.getMediationNetwork = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AFAdRevenueData(AFj1qSDK aFj1qSDK, Context context) {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Cursor cursorQuery;
        Date monetizationNetwork;
        Intrinsics.checkNotNullParameter(aFj1qSDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        aFj1qSDK.areAllFieldsValid = System.currentTimeMillis();
        aFj1qSDK.component2 = AFj1zSDK.AFa1ySDK.STARTED;
        aFj1qSDK.addObserver(new AFj1zSDK.AnonymousClass3());
        Cursor cursor = null;
        lValueOf = null;
        Long lValueOf = null;
        cursor = null;
        try {
            Uri uri = Uri.parse("content://com.samsung.android.mapsagent.providers.apptracking/info");
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, context.getPackageName(), new String[]{"appsflyer001"}, null);
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    try {
                        AFLogger.INSTANCE.e(AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Error while collecting referrer data", th, false, false, true, true);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClient != null) {
                            contentProviderClient.close();
                        }
                        aFj1qSDK.getCurrencyIso4217Code();
                    } finally {
                    }
                }
            } else {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        if (C_(cursorQuery)) {
                            String strP_ = AFj1hSDK.P_(cursorQuery, "INSTALLED_TIME_TEXT");
                            if (strP_ != null && (monetizationNetwork = AFj1lSDK.getMonetizationNetwork(strP_, "yy:MM:dd:hh:mm")) != null) {
                                lValueOf = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(monetizationNetwork.getTime()));
                            }
                            if (lValueOf != null) {
                                long jLongValue = lValueOf.longValue();
                                Map<String, Object> map = aFj1qSDK.getCurrencyIso4217Code;
                                Intrinsics.checkNotNullExpressionValue(map, "");
                                map.put("install_begin_ts", Long.valueOf(jLongValue));
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            String strP_2 = AFj1hSDK.P_(cursorQuery, "MAPS_ID");
                            if (strP_2 != null) {
                                linkedHashMap.put("maps_id", strP_2);
                            }
                            String strP_3 = AFj1hSDK.P_(cursorQuery, "DEVICE_NAME");
                            if (strP_3 != null) {
                                linkedHashMap.put("device_model", strP_3);
                            }
                            String strP_4 = AFj1hSDK.P_(cursorQuery, "COUNTRY");
                            if (strP_4 != null) {
                                linkedHashMap.put("country", strP_4);
                            }
                            String strP_5 = AFj1hSDK.P_(cursorQuery, "CAMPAIGN_ID");
                            if (strP_5 != null) {
                                linkedHashMap.put(FirebaseAnalytics.Param.CAMPAIGN_ID, strP_5);
                            }
                            if (!linkedHashMap.isEmpty()) {
                                Map<String, Object> map2 = aFj1qSDK.getCurrencyIso4217Code;
                                Intrinsics.checkNotNullExpressionValue(map2, "");
                                map2.put("samsung_custom", linkedHashMap);
                            }
                            Map<String, Object> map3 = aFj1qSDK.getCurrencyIso4217Code;
                            Intrinsics.checkNotNullExpressionValue(map3, "");
                            map3.put("api_ver", Long.valueOf(AFj1pSDK.getCurrencyIso4217Code(context, "com.samsung.android.mapsagent")));
                            Map<String, Object> map4 = aFj1qSDK.getCurrencyIso4217Code;
                            Intrinsics.checkNotNullExpressionValue(map4, "");
                            map4.put("api_ver_name", AFj1pSDK.getMonetizationNetwork(context, "com.samsung.android.mapsagent"));
                        } else {
                            AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "App was not installed via Samsung MAPS.", false, 4, null);
                        }
                        cursorQuery.close();
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        }
                    } else {
                        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Content provider returned no data", false, 4, null);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorQuery;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    AFLogger.INSTANCE.e(AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Error while collecting referrer data", th, false, false, true, true);
                    if (cursor != null) {
                    }
                    if (contentProviderClient != null) {
                    }
                }
            } else {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Content provider returned no data", false, 4, null);
                if (cursorQuery != null) {
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            contentProviderClient = null;
        }
        aFj1qSDK.getCurrencyIso4217Code();
    }

    private static boolean C_(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("RESULT");
        if (columnIndex != -1) {
            return Boolean.parseBoolean(cursor.getString(columnIndex));
        }
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "No such column", false, 4, null);
        return false;
    }

    private static boolean getMediationNetwork(Context context) {
        return context.getPackageManager().resolveContentProvider("com.samsung.android.mapsagent.providers.apptracking", 0) != null;
    }

    private final boolean getRevenue(Context context) {
        if (!getMonetizationNetwork()) {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Referrer collection disallowed by counter.", false, 4, null);
            return false;
        }
        if (getMediationNetwork(context)) {
            return true;
        }
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Referrer collection disallowed by missing content provider.", false, 4, null);
        return false;
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(final Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (getRevenue(context)) {
            this.getMediationNetwork.execute(new Runnable() { // from class: com.appsflyer.internal.AFj1qSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AFj1qSDK.AFAdRevenueData(this.f$0, context);
                }
            });
        }
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    protected final void getRevenue() {
    }
}
