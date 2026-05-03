package com.appsflyer.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFj1ySDK;
import com.appsflyer.internal.AFj1zSDK;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1xSDK extends AFi1hSDK {
    private final Runnable component1;
    private final AFj1vSDK component3;
    private String equals;
    private final AFc1kSDK getMediationNetwork;
    private final ExecutorService getMonetizationNetwork;

    public /* synthetic */ class AFa1vSDK {
        public static final /* synthetic */ int[] getCurrencyIso4217Code;

        static {
            int[] iArr = new int[AFj1vSDK.values().length];
            try {
                iArr[AFj1vSDK.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFj1vSDK.INSTAGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AFj1vSDK.FACEBOOK_LITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            getCurrencyIso4217Code = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AFj1xSDK(AFc1kSDK aFc1kSDK, ExecutorService executorService, AFj1vSDK aFj1vSDK, Runnable runnable, Runnable runnable2) {
        String str;
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(executorService, "");
        Intrinsics.checkNotNullParameter(aFj1vSDK, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(runnable2, "");
        int i = AFj1ySDK.AFa1ySDK.getMediationNetwork[aFj1vSDK.ordinal()];
        if (i == 1) {
            str = AccessToken.DEFAULT_GRAPH_DOMAIN;
        } else if (i == 2) {
            str = FacebookSdk.INSTAGRAM;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "facebook_lite";
        }
        super(AndroidContextPlugin.APP_KEY, str, aFc1kSDK, runnable);
        this.getMediationNetwork = aFc1kSDK;
        this.getMonetizationNetwork = executorService;
        this.component3 = aFj1vSDK;
        this.component1 = runnable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115 A[Catch: all -> 0x026f, TRY_LEAVE, TryCatch #4 {all -> 0x026f, blocks: (B:9:0x004c, B:11:0x0052, B:26:0x0115, B:12:0x0078, B:13:0x008d, B:14:0x0092, B:15:0x0093, B:17:0x0099, B:18:0x00be, B:19:0x00d2, B:21:0x00d8, B:22:0x00fd), top: B:104:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a9 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ae A[DONT_GENERATE, PHI: r24
      0x02ae: PHI (r24v2 android.content.ContentProviderClient) = 
      (r24v1 android.content.ContentProviderClient)
      (r24v3 android.content.ContentProviderClient)
      (r24v3 android.content.ContentProviderClient)
     binds: [B:86:0x02ac, B:66:0x024b, B:71:0x0262] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AFAdRevenueData(AFj1xSDK aFj1xSDK, Context context) {
        String str;
        Throwable th;
        Cursor cursor;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        int i;
        Uri uri;
        Cursor cursorQuery;
        String string;
        String str2;
        Intrinsics.checkNotNullParameter(aFj1xSDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        aFj1xSDK.areAllFieldsValid = System.currentTimeMillis();
        aFj1xSDK.component2 = AFj1zSDK.AFa1ySDK.STARTED;
        aFj1xSDK.addObserver(new AFj1zSDK.AnonymousClass3());
        String str3 = aFj1xSDK.equals;
        Intrinsics.checkNotNull(str3);
        try {
            i = AFa1vSDK.getCurrencyIso4217Code[aFj1xSDK.component3.ordinal()];
            str = "Error while collecting Meta Install Referrer for ";
        } catch (Throwable th2) {
            th = th2;
            str = "Error while collecting Meta Install Referrer for ";
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            th = th;
            cursor = null;
            contentProviderClientAcquireUnstableContentProviderClient = null;
            try {
                AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, str + aFj1xSDK.component3.name() + " provider", th, false, false, false, false, 120, null);
                aFj1xSDK.getCurrencyIso4217Code();
                aFj1xSDK.component1.run();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (component1(context)) {
                    AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Found Facebook Lite content provider", false, 4, null);
                    uri = Uri.parse("content://com.facebook.lite.provider.InstallReferrerProvider/" + str3);
                    if (uri == null) {
                        contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                        try {
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient != null ? contentProviderClientAcquireUnstableContentProviderClient.query(uri, new String[]{"install_referrer", "is_ct", "actual_timestamp"}, null, null, null) : null;
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = null;
                        }
                        if (cursorQuery != null) {
                            try {
                            } catch (Throwable th5) {
                                cursor = cursorQuery;
                                th = th5;
                                AFg1hSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, str + aFj1xSDK.component3.name() + " provider", th, false, false, false, false, 120, null);
                            }
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex = cursorQuery.getColumnIndex("install_referrer");
                                if (columnIndex != -1) {
                                    string = cursorQuery.getString(columnIndex);
                                } else {
                                    AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "No such column, " + aFj1xSDK.component3 + " provider", false, 4, null);
                                    string = null;
                                }
                                if (string != null) {
                                    AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Collected " + aFj1xSDK.component3 + " attribution data.", false, 4, null);
                                    Map<String, Object> map = aFj1xSDK.getCurrencyIso4217Code;
                                    Intrinsics.checkNotNullExpressionValue(map, "");
                                    map.put("response", "OK");
                                    Map<String, Object> map2 = aFj1xSDK.getCurrencyIso4217Code;
                                    Intrinsics.checkNotNullExpressionValue(map2, "");
                                    map2.put("referrer", string);
                                    int columnIndex2 = cursorQuery.getColumnIndex("actual_timestamp");
                                    Long lValueOf = columnIndex2 != -1 ? Long.valueOf(cursorQuery.getLong(columnIndex2)) : null;
                                    if (lValueOf != null) {
                                        aFj1xSDK.getCurrencyIso4217Code.put("click_ts", Long.valueOf(lValueOf.longValue()));
                                    }
                                    int columnIndex3 = cursorQuery.getColumnIndex("is_ct");
                                    Integer numValueOf = columnIndex3 != -1 ? Integer.valueOf(cursorQuery.getInt(columnIndex3)) : null;
                                    if (numValueOf != null) {
                                        aFj1xSDK.getCurrencyIso4217Code.put("meta_custom", MapsKt.mutableMapOf(TuplesKt.to("is_ct", Integer.valueOf(numValueOf.intValue()))));
                                    }
                                    int i2 = AFa1vSDK.getCurrencyIso4217Code[aFj1xSDK.component3.ordinal()];
                                    if (i2 == 1) {
                                        str2 = RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE;
                                    } else if (i2 == 2) {
                                        str2 = "com.instagram.android";
                                    } else {
                                        if (i2 != 3) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str2 = "com.facebook.lite";
                                    }
                                    Map<String, Object> map3 = aFj1xSDK.getCurrencyIso4217Code;
                                    Intrinsics.checkNotNullExpressionValue(map3, "");
                                    map3.put("api_ver", Long.valueOf(AFj1pSDK.getCurrencyIso4217Code(context, str2)));
                                    Map<String, Object> map4 = aFj1xSDK.getCurrencyIso4217Code;
                                    Intrinsics.checkNotNullExpressionValue(map4, "");
                                    map4.put("api_ver_name", AFj1pSDK.getMonetizationNetwork(context, str2));
                                }
                                cursorQuery.close();
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                }
                            } else {
                                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Content provider returned no data", false, 4, null);
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                }
                            }
                        } else {
                            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Content provider returned no data", false, 4, null);
                            if (cursorQuery != null) {
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            }
                        }
                    }
                } else {
                    AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Facebook Lite content provider not found", false, 4, null);
                    uri = null;
                    if (uri == null) {
                    }
                }
            } else if (getRevenue(context)) {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Found Instagram content provider", false, 4, null);
                uri = Uri.parse("content://com.instagram.contentprovider.InstallReferrerProvider/" + str3);
                if (uri == null) {
                }
            } else {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Instagram content provider not found", false, 4, null);
                uri = null;
                if (uri == null) {
                }
            }
        } else if (AFAdRevenueData(context)) {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Found Facebook content provider", false, 4, null);
            uri = Uri.parse("content://com.facebook.katana.provider.InstallReferrerProvider/" + str3);
            if (uri == null) {
            }
        } else {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Facebook content provider not found", false, 4, null);
            uri = null;
            if (uri == null) {
            }
        }
        aFj1xSDK.getCurrencyIso4217Code();
        aFj1xSDK.component1.run();
    }

    private static boolean AFAdRevenueData(Context context) {
        return context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.InstallReferrerProvider", 0) != null;
    }

    private static boolean component1(Context context) {
        return context.getPackageManager().resolveContentProvider("com.facebook.lite.provider.InstallReferrerProvider", 0) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa A[PHI: r0
      0x00aa: PHI (r0v8 java.lang.String) = (r0v7 java.lang.String), (r0v15 java.lang.String), (r0v22 java.lang.String) binds: [B:15:0x0048, B:25:0x0078, B:35:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean getCurrencyIso4217Code(Context context) {
        if (!getMonetizationNetwork()) {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Referrer collection disallowed by counter.", false, 4, null);
            return false;
        }
        String monetizationNetwork = this.getMediationNetwork.getMonetizationNetwork(FacebookSdk.APPLICATION_ID_PROPERTY);
        String str = null;
        String strRemovePrefix = monetizationNetwork != null ? StringsKt.removePrefix(monetizationNetwork, (CharSequence) "fb") : null;
        String str2 = strRemovePrefix;
        if (str2 == null || str2.length() == 0) {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Facebook app id Manifest metadata is not found.", false, 4, null);
            strRemovePrefix = null;
        }
        if (strRemovePrefix != null) {
            str = strRemovePrefix;
        } else {
            String revenue = this.getMediationNetwork.getRevenue("facebook_application_id");
            strRemovePrefix = revenue != null ? StringsKt.removePrefix(revenue, (CharSequence) "fb") : null;
            String str3 = strRemovePrefix;
            if (str3 == null || str3.length() == 0) {
                AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Facebook app id string resource is not found.", false, 4, null);
                strRemovePrefix = null;
            }
            if (strRemovePrefix == null) {
                String monetizationNetwork2 = this.getMediationNetwork.getMonetizationNetwork("com.appsflyer.FacebookApplicationId");
                strRemovePrefix = monetizationNetwork2 != null ? StringsKt.removePrefix(monetizationNetwork2, (CharSequence) "fb") : null;
                String str4 = strRemovePrefix;
                if (str4 == null || str4.length() == 0) {
                    AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "AF Facebook app id Manifest metadata is not found.", false, 4, null);
                    strRemovePrefix = null;
                }
                if (strRemovePrefix != null) {
                }
            }
        }
        this.equals = str;
        if (str == null) {
            AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Referrer collection disallowed by missing Facebook app id.", false, 4, null);
            return false;
        }
        if (getMediationNetwork(context)) {
            return true;
        }
        AFg1hSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.META_REFERRER, "Referrer collection disallowed by missing content providers.", false, 4, null);
        return false;
    }

    private final boolean getMediationNetwork(Context context) {
        int i = AFa1vSDK.getCurrencyIso4217Code[this.component3.ordinal()];
        if (i == 1) {
            return AFAdRevenueData(context);
        }
        if (i == 2) {
            return getRevenue(context);
        }
        if (i == 3) {
            return component1(context);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static boolean getRevenue(Context context) {
        return context.getPackageManager().resolveContentProvider("com.instagram.contentprovider.InstallReferrerProvider", 0) != null;
    }

    @Override // com.appsflyer.internal.AFj1zSDK
    public final void getMonetizationNetwork(final Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (getCurrencyIso4217Code(context)) {
            this.getMonetizationNetwork.execute(new Runnable() { // from class: com.appsflyer.internal.AFj1xSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AFj1xSDK.AFAdRevenueData(this.f$0, context);
                }
            });
        } else {
            this.component1.run();
        }
    }
}
