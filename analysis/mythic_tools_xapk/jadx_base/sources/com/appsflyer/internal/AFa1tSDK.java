package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ExpandableListView;
import com.appsflyer.AFAdRevenueData;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFPurchaseDetails;
import com.appsflyer.AppsFlyerConsent;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidationCallback;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.AFe1qSDK.AnonymousClass1;
import com.appsflyer.internal.AFj1zSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.caverock.androidsvg.SVGParser;
import com.google.android.gms.common.GoogleApiAvailability;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFa1tSDK extends AppsFlyerLib {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String AFAdRevenueData;
    private static long AFInAppEventParameterName = 0;
    private static int AFLogger = 0;
    private static AFa1tSDK areAllFieldsValid = null;
    static AppsFlyerInAppPurchaseValidatorListener getMediationNetwork = null;
    public static final String getMonetizationNetwork;
    private static int registerClient = 1;
    Application component3;
    private AFf1uSDK copy;
    private volatile SharedPreferences equals;
    private Map<Long, String> hashCode;
    private boolean toString;
    public volatile AppsFlyerConversionListener getCurrencyIso4217Code = null;
    private long component4 = -1;
    long getRevenue = -1;
    private long component2 = TimeUnit.SECONDS.toMillis(5);
    boolean component1 = false;
    private final AFc1cSDK copydefault = new AFc1cSDK();

    /* JADX INFO: renamed from: com.appsflyer.internal.AFa1tSDK$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] getMonetizationNetwork;

        static {
            int[] iArr = new int[AppsFlyerProperties.EmailsCryptType.values().length];
            getMonetizationNetwork = iArr;
            try {
                iArr[AppsFlyerProperties.EmailsCryptType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getMonetizationNetwork[AppsFlyerProperties.EmailsCryptType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    class AFa1ySDK implements AFe1tSDK {
        AFa1ySDK() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit getCurrencyIso4217Code() {
            AFa1tSDK.this.getRevenue(new AFh1pSDK());
            return Unit.INSTANCE;
        }

        private boolean getMonetizationNetwork() {
            return AFa1tSDK.this.getCurrencyIso4217Code != null;
        }

        @Override // com.appsflyer.internal.AFe1tSDK
        public final void getMediationNetwork(AFe1uSDK<?> aFe1uSDK, AFe1rSDK aFe1rSDK) {
            JSONObject jSONObjectAFAdRevenueData;
            AFg1xSDK monetizationNetwork;
            if (!(aFe1uSDK instanceof AFf1rSDK)) {
                if (!(aFe1uSDK instanceof AFg1nSDK) || aFe1rSDK == AFe1rSDK.SUCCESS) {
                    return;
                }
                AFg1qSDK aFg1qSDK = new AFg1qSDK(AFa1tSDK.this.getRevenue());
                AFe1qSDK aFe1qSDKEquals = AFa1tSDK.this.getRevenue().equals();
                aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(aFg1qSDK));
                return;
            }
            AFf1rSDK aFf1rSDK = (AFf1rSDK) aFe1uSDK;
            boolean z = aFe1uSDK instanceof AFf1tSDK;
            if (z && getMonetizationNetwork()) {
                AFf1tSDK aFf1tSDK = (AFf1tSDK) aFe1uSDK;
                if (aFf1tSDK.AFAdRevenueData == AFe1rSDK.SUCCESS || aFf1tSDK.getCurrencyIso4217Code == 1) {
                    AFg1nSDK aFg1nSDK = new AFg1nSDK(aFf1tSDK, AFa1tSDK.this.getRevenue().getMediationNetwork());
                    AFe1qSDK aFe1qSDKEquals2 = AFa1tSDK.this.getRevenue().equals();
                    aFe1qSDKEquals2.getMonetizationNetwork.execute(aFe1qSDKEquals2.new AnonymousClass1(aFg1nSDK));
                }
            }
            AFh1wSDK aFh1wSDKAfErrorLogForExcManagerOnly = AFa1tSDK.this.getRevenue().afErrorLogForExcManagerOnly();
            if (aFh1wSDKAfErrorLogForExcManagerOnly != null && z) {
                aFh1wSDKAfErrorLogForExcManagerOnly.getCurrencyIso4217Code((AFf1tSDK) aFe1uSDK, new Function0() { // from class: com.appsflyer.internal.AFa1tSDK$AFa1ySDK$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.getCurrencyIso4217Code();
                    }
                });
            }
            if (aFe1rSDK == AFe1rSDK.SUCCESS) {
                AFa1tSDK aFa1tSDK = AFa1tSDK.this;
                aFa1tSDK.getMediationNetwork(aFa1tSDK.component3).getMediationNetwork("sentSuccessfully", "true");
                if (!(aFe1uSDK instanceof AFf1sSDK) && (monetizationNetwork = new AFf1bSDK(AFa1tSDK.this.component3).getMonetizationNetwork()) != null && monetizationNetwork.getMediationNetwork) {
                    String str = monetizationNetwork.AFAdRevenueData;
                    AFLogger.INSTANCE.d(AFg1cSDK.UNINSTALL, "Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                    AFd1zSDK revenue = AFa1tSDK.getMediationNetwork().getRevenue();
                    AFf1sSDK aFf1sSDK = new AFf1sSDK(str, revenue);
                    AFe1qSDK aFe1qSDKEquals3 = revenue.equals();
                    aFe1qSDKEquals3.getMonetizationNetwork.execute(aFe1qSDKEquals3.new AnonymousClass1(aFf1sSDK));
                }
                ResponseNetwork responseNetwork = ((AFe1bSDK) aFf1rSDK).component4;
                if (responseNetwork != null && (jSONObjectAFAdRevenueData = AFa1qSDK.AFAdRevenueData((String) responseNetwork.getBody())) != null) {
                    AFa1tSDK.this.component1 = jSONObjectAFAdRevenueData.optBoolean("send_background", false);
                }
                if (z) {
                    AFa1tSDK.this.getRevenue = System.currentTimeMillis();
                }
            }
        }

        @Override // com.appsflyer.internal.AFe1tSDK
        public final void getMonetizationNetwork(AFe1uSDK<?> aFe1uSDK) {
        }
    }

    static {
        component4();
        getMonetizationNetwork = "374";
        AFAdRevenueData = "6.18.0".substring(0, "6.18.0".lastIndexOf("."));
        getMediationNetwork = null;
        areAllFieldsValid = new AFa1tSDK();
        int i = registerClient + 109;
        AFLogger = i % 128;
        int i2 = i % 2;
    }

    public AFa1tSDK() {
        getRevenue().afDebugLog().getMediationNetwork();
        getRevenue().afDebugLog().AFAdRevenueData();
    }

    private static int AFAdRevenueData(AFc1jSDK aFc1jSDK, String str, boolean z) {
        return ((Integer) getMonetizationNetwork(new Object[]{aFc1jSDK, str, Boolean.valueOf(z)}, -1820164421, 1820164423, (int) System.currentTimeMillis())).intValue();
    }

    private static int AFAdRevenueData(AFc1jSDK aFc1jSDK, boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 49;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        int iIntValue = ((Integer) getMonetizationNetwork(new Object[]{aFc1jSDK, "appsFlyerInAppEventCount", Boolean.valueOf(z)}, -1820164421, 1820164423, (int) System.currentTimeMillis())).intValue();
        int i4 = AFLogger + 19;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 63 / 0;
        }
        return iIntValue;
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFc1jSDK aFc1jSDK = (AFc1jSDK) objArr[0];
        String str = (String) objArr[1];
        int i = 2 % 2;
        int i2 = registerClient + 5;
        AFLogger = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            aFc1jSDK.getRevenue("CACHED_CHANNEL", (String) null);
            obj.hashCode();
            throw null;
        }
        String revenue = aFc1jSDK.getRevenue("CACHED_CHANNEL", (String) null);
        if (revenue != null) {
            return revenue;
        }
        aFc1jSDK.getMediationNetwork("CACHED_CHANNEL", str);
        int i3 = registerClient + 41;
        AFLogger = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static String AFAdRevenueData() {
        int i = 2 % 2;
        int i2 = AFLogger + 61;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        String str = (String) getMonetizationNetwork(new Object[]{AppsFlyerProperties.APP_USER_ID}, -1072478610, 1072478634, (int) System.currentTimeMillis());
        int i4 = registerClient + 35;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 59 / 0;
        }
        return str;
    }

    private static String AFAdRevenueData(Activity activity) {
        Intent intent;
        int i = 2 % 2;
        String str = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("af");
                    if (string != null) {
                        int i2 = AFLogger + 115;
                        registerClient = i2 % 128;
                        try {
                            if (i2 % 2 == 0) {
                                AFLogger.INSTANCE.w(AFg1cSDK.ENGAGEMENT, "Push Notification received af payload = ".concat(String.valueOf(string)));
                                extras.remove("af");
                                activity.setIntent(intent.putExtras(extras));
                                str.hashCode();
                                throw null;
                            }
                            AFLogger.INSTANCE.w(AFg1cSDK.ENGAGEMENT, "Push Notification received af payload = ".concat(String.valueOf(string)));
                            extras.remove("af");
                            activity.setIntent(intent.putExtras(extras));
                        } catch (Throwable th) {
                            th = th;
                            str = string;
                            AFLogger.INSTANCE.e(AFg1cSDK.ENGAGEMENT, th.getMessage(), th);
                            return str;
                        }
                    }
                    str = string;
                }
                int i3 = registerClient + 47;
                AFLogger = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return str;
    }

    private String AFAdRevenueData(Context context, String str) {
        int i = 2 % 2;
        Object obj = null;
        if (context == null) {
            int i2 = AFLogger + 87;
            registerClient = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 65 / 0;
            }
            return null;
        }
        getMonetizationNetwork(context);
        String monetizationNetwork = getRevenue().AFAdRevenueData().getMonetizationNetwork(str);
        int i4 = registerClient + 111;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return monetizationNetwork;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFAdRevenueData(AFf1nSDK aFf1nSDK) {
        int i = 2 % 2;
        int i2 = registerClient + 113;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFd1zSDK revenue = getRevenue();
        if (aFf1nSDK == AFf1nSDK.SUCCESS) {
            revenue.afLogForce().getRevenue();
            int i4 = AFLogger + 105;
            registerClient = i4 % 128;
            int i5 = i4 % 2;
        }
        if (revenue.copy().getRevenue()) {
            revenue.afDebugLog().getMediationNetwork();
        } else {
            revenue.afDebugLog().getMonetizationNetwork();
        }
    }

    private static void AFAdRevenueData(String str) {
        int i = 2 % 2;
        AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, new StringBuilder("ERROR: AppsFlyer SDK is not initialized! The API call '").append(str).append("()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.").toString());
        int i2 = registerClient + 87;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static void AFAdRevenueData(String str, boolean z) {
        getMonetizationNetwork(new Object[]{str, Boolean.valueOf(z)}, 1660171217, -1660171210, (int) System.currentTimeMillis());
    }

    private static /* synthetic */ Object AFInAppEventParameterName(Object[] objArr) {
        String string;
        String str = (String) objArr[0];
        int i = 2 % 2;
        int i2 = AFLogger + 63;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            string = AppsFlyerProperties.getInstance().getString(str);
            int i3 = 32 / 0;
        } else {
            string = AppsFlyerProperties.getInstance().getString(str);
        }
        int i4 = AFLogger + 83;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
        return string;
    }

    private static /* synthetic */ Object AFInAppEventType(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        Context context = (Context) objArr[1];
        String str = (String) objArr[2];
        int i = 2 % 2;
        int i2 = registerClient + 19;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            aFa1tSDK.start(context, str, null);
            return null;
        }
        aFa1tSDK.start(context, str, null);
        throw null;
    }

    private static void a(String str, int i, Object[] objArr) {
        int i2;
        int i3 = 2 % 2;
        Object charArray = str;
        if (str != null) {
            int i4 = $10 + 19;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        AFk1qSDK aFk1qSDK = new AFk1qSDK();
        aFk1qSDK.getMonetizationNetwork = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        aFk1qSDK.getMediationNetwork = 0;
        while (aFk1qSDK.getMediationNetwork < cArr.length) {
            jArr[aFk1qSDK.getMediationNetwork] = (((long) cArr[aFk1qSDK.getMediationNetwork]) ^ (((long) aFk1qSDK.getMediationNetwork) * ((long) aFk1qSDK.getMonetizationNetwork))) ^ (AFInAppEventParameterName ^ 4058599813193289363L);
            aFk1qSDK.getMediationNetwork++;
        }
        char[] cArr2 = new char[length];
        aFk1qSDK.getMediationNetwork = 0;
        while (aFk1qSDK.getMediationNetwork < cArr.length) {
            int i6 = $11 + 17;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                cArr2[aFk1qSDK.getMediationNetwork] = (char) jArr[aFk1qSDK.getMediationNetwork];
                i2 = aFk1qSDK.getMediationNetwork;
            } else {
                cArr2[aFk1qSDK.getMediationNetwork] = (char) jArr[aFk1qSDK.getMediationNetwork];
                i2 = aFk1qSDK.getMediationNetwork + 1;
            }
            aFk1qSDK.getMediationNetwork = i2;
        }
        objArr[0] = new String(cArr2);
    }

    private static /* synthetic */ Object areAllFieldsValid(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
        Context context = (Context) objArr[2];
        int i = 2 % 2;
        int i2 = AFLogger + 115;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            aFa1tSDK.getMonetizationNetwork(context);
            final AFd1zSDK revenue = aFa1tSDK.getRevenue();
            revenue.AFInAppEventParameterName().getRevenue(zBooleanValue);
            revenue.getCurrencyIso4217Code().submit(new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    AFa1tSDK.getMediationNetwork(revenue);
                }
            });
            throw null;
        }
        aFa1tSDK.getMonetizationNetwork(context);
        final AFd1zSDK revenue2 = aFa1tSDK.getRevenue();
        revenue2.AFInAppEventParameterName().getRevenue(zBooleanValue);
        revenue2.getCurrencyIso4217Code().submit(new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AFa1tSDK.getMediationNetwork(revenue2);
            }
        });
        if (zBooleanValue) {
            int i3 = registerClient + 111;
            AFLogger = i3 % 128;
            int i4 = i3 % 2;
            revenue2.getMediationNetwork().getRevenue("is_stop_tracking_used", true);
        }
        return null;
    }

    private void areAllFieldsValid() {
        int i = 2 % 2;
        int i2 = registerClient + Imgproc.COLOR_YUV2RGB_YVYU;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        try {
            final AFi1nSDK aFi1nSDKV = getRevenue().v();
            if (aFi1nSDKV == null) {
                return;
            }
            if (aFi1nSDKV.AFAdRevenueData()) {
                aFi1nSDKV.getMediationNetwork(new AFi1iSDK() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda1
                    @Override // com.appsflyer.internal.AFi1iSDK
                    public final void onRequestFinished() {
                        this.f$0.getMonetizationNetwork(aFi1nSDKV);
                    }
                });
                return;
            }
            if (!aFi1nSDKV.getMediationNetwork()) {
                getRevenue(aFi1nSDKV);
            }
            int i4 = registerClient + 15;
            AFLogger = i4 % 128;
            if (i4 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("Error at attempt to request PIA token", th);
            AFLogger.afRDLog("Get PIA token failed with exception:".concat(String.valueOf(th)));
        }
    }

    private static void c_(Context context, PackageInfo packageInfo) {
        int i = 2 % 2;
        try {
            Object obj = null;
            if (packageInfo.applicationInfo != null) {
                int i2 = registerClient + 63;
                AFLogger = i2 % 128;
                if (i2 % 2 != 0) {
                    int i3 = packageInfo.applicationInfo.flags;
                    obj.hashCode();
                    throw null;
                }
                if ((packageInfo.applicationInfo.flags & 32768) != 0) {
                    int i4 = registerClient + 91;
                    AFLogger = i4 % 128;
                    int i5 = i4 % 2;
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i6 = AFLogger + 79;
                        registerClient = i6 % 128;
                        int i7 = i6 % 2;
                        if (context.getResources().getIdentifier("appsflyer_data_extraction_rules", "xml", context.getPackageName()) == 0) {
                            AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_data_extraction_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <data-extraction-rules> both in <device-transfer> and <cloud-backup>.\nIf Appsflyer's Purchase Connector is in use then you also must add to <device-transfer> and <cloud-backup> the following excludes: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
                            return;
                        }
                        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_data_extraction_rules.xml detected, using AppsFlyer data extraction rules for AppsFlyer SDK data", true);
                        int i8 = AFLogger + 9;
                        registerClient = i8 % 128;
                        if (i8 % 2 == 0) {
                            int i9 = 61 / 0;
                            return;
                        }
                        return;
                    }
                    if (context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) != 0) {
                        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                        return;
                    }
                    AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_backup_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules.\nIf Appsflyer's Purchase Connector is in use then you also must add the following to your rules: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
                }
            }
            int i10 = registerClient + 73;
            AFLogger = i10 % 128;
            if (i10 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while checking BackupRules: ", th);
        }
    }

    private static /* synthetic */ Object component1(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        int i = 2 % 2;
        int i2 = AFLogger + 7;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        String monetizationNetwork = aFa1tSDK.getRevenue().AFInAppEventType().getMonetizationNetwork();
        int i4 = registerClient + 93;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 19 / 0;
        }
        return monetizationNetwork;
    }

    private AFj1zSDK[] component1() {
        int i = 2 % 2;
        int i2 = registerClient + 1;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFj1zSDK[] aFj1zSDKArr = (AFj1zSDK[]) getRevenue().copydefault().AFAdRevenueData.toArray(new AFj1zSDK[0]);
        int i4 = registerClient + 11;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return aFj1zSDKArr;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component2(Object[] objArr) {
        boolean z;
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        AFLogger.LogLevel logLevel = (AFLogger.LogLevel) objArr[1];
        int i = 2 % 2;
        int i2 = registerClient + 95;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            int i4 = registerClient + Imgproc.COLOR_YUV2RGB_YVYU;
            AFLogger = i4 % 128;
            int i5 = i4 % 2;
            z = true;
        } else {
            z = false;
        }
        aFa1tSDK.getRevenue().copy().getMediationNetwork("log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
        if (z) {
            aFa1tSDK.getRevenue().afDebugLog().areAllFieldsValid();
            return null;
        }
        int i6 = AFLogger + Imgproc.COLOR_YUV2RGBA_YVYU;
        registerClient = i6 % 128;
        if (i6 % 2 != 0) {
            aFa1tSDK.getRevenue().afDebugLog().AFAdRevenueData();
            return null;
        }
        aFa1tSDK.getRevenue().afDebugLog().AFAdRevenueData();
        throw null;
    }

    private static void component2(Context context) {
        getMonetizationNetwork(new Object[]{context}, 847967095, -847967080, (int) System.currentTimeMillis());
    }

    private boolean component2() {
        String str;
        int i = 2 % 2;
        int i2 = registerClient + 41;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        long j = this.component4;
        if (i3 == 0 ? j <= 0 : j <= 1) {
            if (isStopped()) {
                return false;
            }
            int i4 = registerClient + 41;
            AFLogger = i4 % 128;
            int i5 = i4 % 2;
            AFLogger.afInfoLog("Sending first launch for this session!");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.component4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
        String currencyIso4217Code = getCurrencyIso4217Code(simpleDateFormat, this.component4);
        String currencyIso4217Code2 = getCurrencyIso4217Code(simpleDateFormat, this.getRevenue);
        if (jCurrentTimeMillis >= this.component2 || isStopped()) {
            if (isStopped()) {
                return false;
            }
            AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", currencyIso4217Code, currencyIso4217Code2, Long.valueOf(jCurrentTimeMillis)));
            return false;
        }
        int i6 = registerClient + 21;
        AFLogger = i6 % 128;
        if (i6 % 2 != 0) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[1] = currencyIso4217Code;
            objArr[1] = currencyIso4217Code2;
            objArr[3] = Long.valueOf(jCurrentTimeMillis);
            objArr[3] = Long.valueOf(this.component2);
            str = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", objArr);
        } else {
            str = String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", currencyIso4217Code, currencyIso4217Code2, Long.valueOf(jCurrentTimeMillis), Long.valueOf(this.component2));
        }
        AFLogger.afInfoLog(str);
        return true;
    }

    private static /* synthetic */ Object component3(Object[] objArr) {
        Context context = (Context) objArr[0];
        int i = 2 % 2;
        int i2 = AFLogger + 75;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        try {
            List listAsList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            if (!listAsList.contains("android.permission.INTERNET")) {
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
            }
            if (!listAsList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                int i4 = registerClient + 109;
                AFLogger = i4 % 128;
                if (i4 % 2 != 0) {
                    AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
                    throw null;
                }
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (Build.VERSION.SDK_INT > 32) {
                int i5 = registerClient + 95;
                AFLogger = i5 % 128;
                int i6 = i5 % 2;
                if (!listAsList.contains("com.google.android.gms.permission.AD_ID")) {
                    AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml");
                    int i7 = registerClient + 39;
                    AFLogger = i7 % 128;
                    int i8 = i7 % 2;
                }
            }
            return null;
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while validation permissions. ", e);
            return null;
        }
    }

    private static /* synthetic */ Object component4(Object[] objArr) {
        final AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        String str = (String) objArr[1];
        int i = 2 % 2;
        final AFh1sSDK monetizationNetwork = new AFh1nSDK().getMonetizationNetwork(aFa1tSDK.getRevenue().AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0));
        monetizationNetwork.component2 = str;
        Object obj = null;
        if (str != null && str.length() > 5 && aFa1tSDK.getRevenue().copydefault().getCurrencyIso4217Code(monetizationNetwork)) {
            int i2 = AFLogger + 33;
            registerClient = i2 % 128;
            if (i2 % 2 == 0) {
                AFj1cSDK.getMonetizationNetwork(aFa1tSDK.getRevenue().getMonetizationNetwork(), new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.getMediationNetwork(monetizationNetwork);
                    }
                }, 5L, TimeUnit.MILLISECONDS);
                obj.hashCode();
                throw null;
            }
            AFj1cSDK.getMonetizationNetwork(aFa1tSDK.getRevenue().getMonetizationNetwork(), new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getMediationNetwork(monetizationNetwork);
                }
            }, 5L, TimeUnit.MILLISECONDS);
            int i3 = registerClient + 95;
            AFLogger = i3 % 128;
            int i4 = i3 % 2;
        }
        return null;
    }

    static void component4() {
        AFInAppEventParameterName = 8065615358880487326L;
    }

    private static /* synthetic */ Object copy(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        Context context = (Context) objArr[1];
        int i = 2 % 2;
        int i2 = AFLogger + 95;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        Object obj = null;
        aFa1tSDK.start(context, null);
        int i4 = registerClient + 105;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void copy() {
        int i = 2 % 2;
        getRevenue(new AFh1pSDK());
        int i2 = AFLogger + 67;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    private static /* synthetic */ Object copydefault(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        Context context = (Context) objArr[1];
        int i = 2 % 2;
        int i2 = registerClient + 67;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        Object obj = null;
        if (!(context instanceof Activity)) {
            return null;
        }
        AFh1oSDK aFh1oSDK = new AFh1oSDK((Activity) context, aFa1tSDK.getRevenue().w());
        int i4 = AFLogger + 73;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return aFh1oSDK;
        }
        obj.hashCode();
        throw null;
    }

    private static void copydefault() {
        getMonetizationNetwork(new Object[0], -1617966880, 1617966902, (int) System.currentTimeMillis());
    }

    public static SharedPreferences d_(Context context) {
        return (SharedPreferences) getMonetizationNetwork(new Object[]{context}, 1469250199, -1469250196, (int) System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void e_(Context context, Intent intent) {
        Uri data;
        int i = 2 % 2;
        getMonetizationNetwork(context);
        AFa1oSDK aFa1oSDKI = getRevenue().i();
        AFc1jSDK mediationNetwork = getRevenue().getMediationNetwork();
        boolean z = true;
        if (intent != null) {
            int i2 = AFLogger + 1;
            registerClient = i2 % 128;
            int i3 = i2 % 2;
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                data = intent.getData();
                int i4 = AFLogger + 67;
                registerClient = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 4 % 2;
                }
            } else {
                data = null;
            }
        }
        if (data == null || data.toString().isEmpty()) {
            z = false;
        } else {
            int i6 = AFLogger + 23;
            registerClient = i6 % 128;
            int i7 = i6 % 2;
        }
        if (!mediationNetwork.getRevenue("ddl_sent") || z) {
            aFa1oSDKI.f_(AFa1jSDK.getMediationNetwork(aFa1oSDKI.component4.afErrorLog()), intent, context);
            int i8 = registerClient + 99;
            AFLogger = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 16 / 0;
                return;
            }
            return;
        }
        int i10 = registerClient + 9;
        AFLogger = i10 % 128;
        if (i10 % 2 == 0) {
            aFa1oSDKI.AFAdRevenueData("No direct deep link", null);
        } else {
            aFa1oSDKI.AFAdRevenueData("No direct deep link", null);
            int i11 = 68 / 0;
        }
    }

    private static /* synthetic */ Object equals(Object[] objArr) {
        boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
        int i = 2 % 2;
        int i2 = AFLogger + 113;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(zBooleanValue)), true);
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, Boolean.valueOf(zBooleanValue)}, 1660171217, -1660171210, (int) System.currentTimeMillis());
        int i4 = registerClient + 65;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 88 / 0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void equals() {
        getMonetizationNetwork(new Object[]{this}, -1455645768, 1455645787, System.identityHashCode(this));
    }

    private AFh1oSDK getCurrencyIso4217Code(Context context) {
        return (AFh1oSDK) getMonetizationNetwork(new Object[]{this, context}, -536448515, 536448536, System.identityHashCode(this));
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        String str = (String) objArr[0];
        boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
        int i = 2 % 2;
        int i2 = registerClient + 19;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AppsFlyerProperties.getInstance().set(str, zBooleanValue);
        int i4 = registerClient + 5;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return null;
        }
        throw null;
    }

    public static String getCurrencyIso4217Code(AFc1jSDK aFc1jSDK, String str) {
        return (String) getMonetizationNetwork(new Object[]{aFc1jSDK, str}, -195097357, 195097363, (int) System.currentTimeMillis());
    }

    private static String getCurrencyIso4217Code(String str) {
        return (String) getMonetizationNetwork(new Object[]{str}, -1072478610, 1072478634, (int) System.currentTimeMillis());
    }

    public static String getCurrencyIso4217Code(SimpleDateFormat simpleDateFormat, long j) {
        int i = 2 % 2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str = simpleDateFormat.format(new Date(j));
        int i2 = AFLogger + 9;
        registerClient = i2 % 128;
        if (i2 % 2 != 0) {
            return str;
        }
        throw null;
    }

    private void getCurrencyIso4217Code(Context context, AFh1xSDK aFh1xSDK) {
        int i = 2 % 2;
        getMonetizationNetwork(context);
        AFh1uSDK aFh1uSDKComponent2 = getRevenue().component2();
        AFh1zSDK aFh1zSDKAFAdRevenueData = AFh1zSDK.AFAdRevenueData(context);
        if (aFh1uSDKComponent2.getMediationNetwork()) {
            int i2 = registerClient + 29;
            AFLogger = i2 % 128;
            int i3 = i2 % 2;
            aFh1uSDKComponent2.getCurrencyIso4217Code.put("api_name", aFh1xSDK.toString());
            aFh1uSDKComponent2.getRevenue(aFh1zSDKAFAdRevenueData);
            int i4 = registerClient + 81;
            AFLogger = i4 % 128;
            int i5 = i4 % 2;
        }
        aFh1uSDKComponent2.getMonetizationNetwork();
    }

    private void getCurrencyIso4217Code(Context context, String str) {
        int i = 2 % 2;
        AFh1mSDK aFh1mSDK = new AFh1mSDK();
        getMonetizationNetwork(context);
        aFh1mSDK.areAllFieldsValid = null;
        aFh1mSDK.getMediationNetwork = null;
        aFh1mSDK.component2 = str;
        aFh1mSDK.getMonetizationNetwork = null;
        getCurrencyIso4217Code(aFh1mSDK);
        int i2 = AFLogger + 91;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
    }

    private void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        boolean z;
        int i = 2 % 2;
        int i2 = registerClient + 95;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            String str = aFh1sSDK.areAllFieldsValid;
            throw null;
        }
        if (aFh1sSDK.areAllFieldsValid == null) {
            int i3 = AFLogger + 35;
            registerClient = i3 % 128;
            int i4 = i3 % 2;
            z = true;
        } else {
            z = false;
        }
        if (getCurrencyIso4217Code()) {
            AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
                int i5 = AFLogger + 77;
                registerClient = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 3 % 2;
                }
            } else if (component2()) {
                AppsFlyerRequestListener appsFlyerRequestListener = aFh1sSDK.getCurrencyIso4217Code;
                if (appsFlyerRequestListener != null) {
                    int i7 = AFLogger + 25;
                    registerClient = i7 % 128;
                    int i8 = i7 % 2;
                    appsFlyerRequestListener.onError(10, "Event timeout. Check 'minTimeBetweenSessions' param");
                    return;
                }
                return;
            }
            this.component4 = System.currentTimeMillis();
        }
        getRevenue(aFh1sSDK);
    }

    private static void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK, AFh1oSDK aFh1oSDK) {
        int i = 2 % 2;
        int i2 = registerClient;
        int i3 = i2 + 85;
        AFLogger = i3 % 128;
        int i4 = i3 % 2;
        if (aFh1oSDK != null) {
            int i5 = i2 + 99;
            AFLogger = i5 % 128;
            int i6 = i5 % 2;
            aFh1sSDK.getMonetizationNetwork = aFh1oSDK.getCurrencyIso4217Code;
            aFh1sSDK.equals = aFh1oSDK.AFAdRevenueData;
            int i7 = registerClient + 33;
            AFLogger = i7 % 128;
            int i8 = i7 % 2;
        }
    }

    private static void getCurrencyIso4217Code(JSONObject jSONObject) {
        String str;
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject.keys();
        while (true) {
            if (!itKeys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(itKeys.next()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
                }
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> itKeys2 = jSONObject.keys();
        Object obj = null;
        loop2: while (true) {
            str = null;
            while (itKeys2.hasNext()) {
                int i3 = AFLogger + 27;
                registerClient = i3 % 128;
                if (i3 % 2 == 0) {
                    obj.hashCode();
                    throw null;
                }
                if (str != null) {
                    break loop2;
                }
                String next = itKeys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i4 = registerClient + 89;
                    AFLogger = i4 % 128;
                    int i5 = i4 % 2;
                    int i6 = 0;
                    while (i6 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i6) == ((Long) arrayList.get(0)).longValue() || jSONArray2.getLong(i6) == ((Long) arrayList.get(1)).longValue()) {
                            break;
                        }
                        int i7 = registerClient + 105;
                        AFLogger = i7 % 128;
                        int i8 = i7 % 2;
                        if (jSONArray2.getLong(i6) == ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            break;
                        }
                        i6++;
                        str = next;
                    }
                } catch (JSONException e2) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e2);
                }
            }
            break loop2;
        }
        if (str != null) {
            jSONObject.remove(str);
        }
        int i9 = registerClient + 37;
        AFLogger = i9 % 128;
        int i10 = i9 % 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getCurrencyIso4217Code(boolean z) {
        getMonetizationNetwork(new Object[]{this, Boolean.valueOf(z)}, -1121211786, 1121211791, System.identityHashCode(this));
    }

    public static int getMediationNetwork(AFc1jSDK aFc1jSDK, boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 17;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        Object[] objArr = {aFc1jSDK, "appsFlyerCount", Boolean.valueOf(z)};
        if (i3 == 0) {
            ((Integer) getMonetizationNetwork(objArr, -1820164421, 1820164423, (int) System.currentTimeMillis())).intValue();
            throw null;
        }
        int iIntValue = ((Integer) getMonetizationNetwork(objArr, -1820164421, 1820164423, (int) System.currentTimeMillis())).intValue();
        int i4 = registerClient + 71;
        AFLogger = i4 % 128;
        int i5 = i4 % 2;
        return iIntValue;
    }

    public static AFa1tSDK getMediationNetwork() {
        int i = 2 % 2;
        int i2 = AFLogger + 115;
        registerClient = i2 % 128;
        if (i2 % 2 != 0) {
            return areAllFieldsValid;
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.os.StrictMode$ThreadPolicy] */
    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFa1tSDK mediationNetwork;
        SharedPreferences sharedPreferences;
        Context context = (Context) objArr[0];
        int i = 2 % 2;
        if (getMediationNetwork().equals == null) {
            int i2 = registerClient + 95;
            AFLogger = i2 % 128;
            StrictMode.ThreadPolicy threadPolicy = i2 % 2;
            try {
                if (threadPolicy != 0) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    mediationNetwork = getMediationNetwork();
                    sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                    threadPolicy = threadPolicyAllowThreadDiskReads;
                } else {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                    mediationNetwork = getMediationNetwork();
                    sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                    threadPolicy = threadPolicyAllowThreadDiskReads2;
                }
                mediationNetwork.equals = sharedPreferences;
                StrictMode.setThreadPolicy(threadPolicy);
                int i3 = AFLogger + 59;
                registerClient = i3 % 128;
                int i4 = i3 % 2;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        }
        return getMediationNetwork().equals;
    }

    private void getMediationNetwork(Context context, String str, Map<String, Object> map) {
        int i = 2 % 2;
        AFh1lSDK aFh1lSDK = new AFh1lSDK();
        aFh1lSDK.areAllFieldsValid = str;
        aFh1lSDK.getMediationNetwork = map;
        getMonetizationNetwork(aFh1lSDK, (AFh1oSDK) getMonetizationNetwork(new Object[]{this, context}, -536448515, 536448536, System.identityHashCode(this)));
        int i2 = registerClient + 115;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void getMediationNetwork(AFd1zSDK aFd1zSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 31;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        aFd1zSDK.AFKeystoreWrapper().getMonetizationNetwork();
        int i4 = AFLogger + 95;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 79;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue(aFh1sSDK);
        int i4 = AFLogger + 111;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    private static void getMediationNetwork(String str) {
        int i = 2 % 2;
        try {
            if (new JSONObject(str).has("pid")) {
                int i2 = AFLogger + 113;
                registerClient = i2 % 128;
                int i3 = i2 % 2;
                getMediationNetwork("preInstallName", str);
                return;
            }
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
            int i4 = AFLogger + 15;
            registerClient = i4 % 128;
            int i5 = i4 % 2;
        } catch (JSONException e) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
        }
    }

    private static void getMediationNetwork(String str, String str2) {
        int i = 2 % 2;
        int i2 = registerClient + 59;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            AppsFlyerProperties.getInstance().set(str, str2);
            return;
        }
        AppsFlyerProperties.getInstance().set(str, str2);
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private void getMediationNetwork(Map<String, Object> map) {
        int i = 2 % 2;
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) && !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) && map.get("advertiserId") != null) {
            int i2 = AFLogger + Imgproc.COLOR_YUV2RGB_YVYU;
            registerClient = i2 % 128;
            int i3 = i2 % 2;
            try {
                if (AFk1zSDK.getMediationNetwork(getRevenue().e().getCurrencyIso4217Code) && map.remove("android_id") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                AFf1kSDK aFf1kSDKAFInAppEventParameterName = getRevenue().AFInAppEventParameterName();
                if (!AFk1zSDK.getMediationNetwork((String) AFf1kSDK.getMonetizationNetwork(new Object[]{aFf1kSDKAFInAppEventParameterName}, -211782084, 211782085, System.identityHashCode(aFf1kSDKAFInAppEventParameterName))) || map.remove("imei") == null) {
                    return;
                }
                AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                return;
            } catch (Exception e) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e);
            }
        }
        int i4 = AFLogger + 119;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 73 / 0;
        }
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        String str = (String) objArr[1];
        int i = 2 % 2;
        int i2 = AFLogger + 123;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        aFa1tSDK.getRevenue().copy().getMediationNetwork("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        int i4 = registerClient + 17;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 93 / 0;
        }
        return null;
    }

    public static /* synthetic */ Object getMonetizationNetwork(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~i;
        int i5 = ~(i4 | i2);
        int i6 = ~i2;
        int i7 = (i * 615) + (i2 * (-613)) + ((i3 | i5 | (~(i6 | i))) * 614);
        int i8 = ~i3;
        switch (i7 + ((i5 | (~(i4 | i8)) | (~(i8 | i2))) * (-1228)) + (((~(i | i8 | i2)) | (~(i4 | i6 | i8))) * 614)) {
            case 1:
                return getMonetizationNetwork(objArr);
            case 2:
                AFc1jSDK aFc1jSDK = (AFc1jSDK) objArr[0];
                String str = (String) objArr[1];
                boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                int i9 = 2 % 2;
                int currencyIso4217Code = aFc1jSDK.getCurrencyIso4217Code(str, 0);
                if (zBooleanValue) {
                    int i10 = AFLogger + 21;
                    registerClient = i10 % 128;
                    currencyIso4217Code = i10 % 2 == 0 ? currencyIso4217Code + 81 : currencyIso4217Code + 1;
                    aFc1jSDK.AFAdRevenueData(str, currencyIso4217Code);
                    int i11 = AFLogger + 9;
                    registerClient = i11 % 128;
                    int i12 = i11 % 2;
                }
                return Integer.valueOf(currencyIso4217Code);
            case 3:
                return getMediationNetwork(objArr);
            case 4:
                AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
                AFPurchaseDetails aFPurchaseDetails = (AFPurchaseDetails) objArr[1];
                Map map = (Map) objArr[2];
                AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback = (AppsFlyerInAppPurchaseValidationCallback) objArr[3];
                int i13 = 2 % 2;
                AFe1qSDK aFe1qSDKEquals = aFa1tSDK.copydefault.equals();
                aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(new AFe1dSDK(aFa1tSDK.copydefault, AppsFlyerProperties.getInstance(), aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback)));
                int i14 = registerClient + 69;
                AFLogger = i14 % 128;
                int i15 = i14 % 2;
                return null;
            case 5:
                return getRevenue(objArr);
            case 6:
                return AFAdRevenueData(objArr);
            case 7:
                return getCurrencyIso4217Code(objArr);
            case 8:
                return component4(objArr);
            case 9:
                return component1(objArr);
            case 10:
                return areAllFieldsValid(objArr);
            case 11:
                AFa1tSDK aFa1tSDK2 = (AFa1tSDK) objArr[0];
                String str2 = (String) objArr[1];
                int i16 = 2 % 2;
                int i17 = registerClient + 51;
                AFLogger = i17 % 128;
                if (i17 % 2 != 0) {
                    AFd1lSDK aFd1lSDKCopy = aFa1tSDK2.getRevenue().copy();
                    String[] strArr = new String[0];
                    strArr[0] = str2;
                    aFd1lSDKCopy.getMediationNetwork("setAndroidIdData", strArr);
                } else {
                    aFa1tSDK2.getRevenue().copy().getMediationNetwork("setAndroidIdData", str2);
                }
                aFa1tSDK2.getRevenue().e().getCurrencyIso4217Code = str2;
                return null;
            case 12:
                String str3 = (String) objArr[0];
                int i18 = 2 % 2;
                int i19 = AFLogger + 3;
                registerClient = i19 % 128;
                int i20 = i19 % 2;
                return Boolean.valueOf(AppsFlyerProperties.getInstance().getBoolean(str3, false));
            case 13:
                AFa1tSDK aFa1tSDK3 = (AFa1tSDK) objArr[0];
                AppsFlyerConversionListener appsFlyerConversionListener = (AppsFlyerConversionListener) objArr[2];
                int i21 = 2 % 2;
                int i22 = AFLogger + 53;
                registerClient = i22 % 128;
                if (i22 % 2 == 0) {
                    aFa1tSDK3.getRevenue().copy().getMediationNetwork("registerConversionListener", new String[1]);
                } else {
                    aFa1tSDK3.getRevenue().copy().getMediationNetwork("registerConversionListener", new String[0]);
                }
                aFa1tSDK3.getMonetizationNetwork(appsFlyerConversionListener);
                int i23 = AFLogger + 23;
                registerClient = i23 % 128;
                int i24 = i23 % 2;
                return null;
            case 14:
                AFa1tSDK aFa1tSDK4 = (AFa1tSDK) objArr[0];
                Context context = (Context) objArr[1];
                Map<String, Object> map2 = (Map) objArr[2];
                PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback = (PurchaseHandler.PurchaseValidationCallback) objArr[3];
                int i25 = 2 % 2;
                int i26 = AFLogger + 63;
                registerClient = i26 % 128;
                int i27 = i26 % 2;
                aFa1tSDK4.getMonetizationNetwork(context);
                PurchaseHandler purchaseHandlerComponent1 = aFa1tSDK4.getRevenue().component1();
                if (purchaseHandlerComponent1.getRevenue(map2, purchaseValidationCallback, "purchases")) {
                    AFe1eSDK aFe1eSDK = new AFe1eSDK(map2, purchaseValidationCallback, purchaseHandlerComponent1.getCurrencyIso4217Code);
                    AFe1qSDK aFe1qSDK = purchaseHandlerComponent1.AFAdRevenueData;
                    aFe1qSDK.getMonetizationNetwork.execute(aFe1qSDK.new AnonymousClass1(aFe1eSDK));
                }
                int i28 = registerClient + 79;
                AFLogger = i28 % 128;
                int i29 = i28 % 2;
                return null;
            case 15:
                return component3(objArr);
            case 16:
                return component2(objArr);
            case 17:
                return equals(objArr);
            case 18:
                return copy(objArr);
            case 19:
                return hashCode(objArr);
            case 20:
                return toString(objArr);
            case 21:
                return copydefault(objArr);
            case 22:
                return registerClient(objArr);
            case 23:
                return AFInAppEventType(objArr);
            case 24:
                return AFInAppEventParameterName(objArr);
            default:
                AFa1tSDK aFa1tSDK5 = (AFa1tSDK) objArr[0];
                Context context2 = (Context) objArr[1];
                int i30 = 2 % 2;
                int i31 = registerClient + 73;
                AFLogger = i31 % 128;
                int i32 = i31 % 2;
                aFa1tSDK5.getMonetizationNetwork(context2);
                String currencyIso4217Code2 = aFa1tSDK5.getRevenue().AFAdRevenueData().getCurrencyIso4217Code(context2);
                int i33 = registerClient + 81;
                AFLogger = i33 % 128;
                int i34 = i33 % 2;
                return currencyIso4217Code2;
        }
    }

    @Deprecated
    public static Map<String, Object> getMonetizationNetwork(Map<String, Object> map) {
        int i = 2 % 2;
        int i2 = registerClient + 67;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (!map.containsKey("meta")) {
            HashMap map2 = new HashMap();
            map.put("meta", map2);
            return map2;
        }
        int i4 = AFLogger + 73;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return (Map) map.get("meta");
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private void getMonetizationNetwork(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = 2 % 2;
        int i2 = registerClient + 31;
        int i3 = i2 % 128;
        AFLogger = i3;
        int i4 = i2 % 2;
        if (appsFlyerConversionListener != null) {
            this.getCurrencyIso4217Code = appsFlyerConversionListener;
            return;
        }
        int i5 = i3 + 69;
        registerClient = i5 % 128;
        if (i5 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMonetizationNetwork(AFi1nSDK aFi1nSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 17;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue(aFi1nSDK);
        if (i3 == 0) {
            int i4 = 12 / 0;
        }
    }

    private void getMonetizationNetwork(String str) {
        getMonetizationNetwork(new Object[]{this, str}, -1378401160, 1378401168, System.identityHashCode(this));
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
        int i = 2 % 2;
        int i2 = registerClient + 11;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (!zBooleanValue) {
            aFa1tSDK.getRevenue().afDebugLog().getRevenue();
            return null;
        }
        aFa1tSDK.getRevenue().afDebugLog().getCurrencyIso4217Code();
        int i4 = AFLogger + 27;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 52 / 0;
        }
        return null;
    }

    private void getRevenue(AFi1nSDK aFi1nSDK) {
        int i = 2 % 2;
        AFe1cSDK aFe1cSDK = new AFe1cSDK(aFi1nSDK, getRevenue().AFAdRevenueData(), getRevenue(), getRevenue().areAllFieldsValid(), getRevenue().registerClient());
        AFe1qSDK aFe1qSDKEquals = getRevenue().equals();
        aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(aFe1cSDK));
        int i2 = registerClient + 105;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static boolean getRevenue(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 95;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        try {
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            return true;
        }
        int i4 = AFLogger + 113;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    private static boolean getRevenue(String str) {
        return ((Boolean) getMonetizationNetwork(new Object[]{str}, -970221310, 970221322, (int) System.currentTimeMillis())).booleanValue();
    }

    private static /* synthetic */ Object hashCode(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        int i = 2 % 2;
        int i2 = AFLogger + 101;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        if (aFa1tSDK.getRevenue().afVerboseLog().getCurrencyIso4217Code()) {
            aFa1tSDK.getRevenue().afVerboseLog().getMonetizationNetwork();
            int i4 = registerClient + 111;
            AFLogger = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = 3 % 2;
            }
        }
        AFi1xSDK aFi1xSDKD = aFa1tSDK.getRevenue().d();
        aFi1xSDKD.getRevenue = Build.VERSION.SDK_INT >= 31 ? new AFi1tSDK(aFi1xSDKD.getCurrencyIso4217Code) : new AFi1qSDK(aFi1xSDKD.getCurrencyIso4217Code);
        aFa1tSDK.getRevenue().AFInAppEventParameterName().AFAdRevenueData(aFa1tSDK.getRevenue().AFAdRevenueData());
        AFh1uSDK aFh1uSDKComponent2 = aFa1tSDK.getRevenue().component2();
        aFh1uSDKComponent2.component3 = System.currentTimeMillis();
        int currencyIso4217Code = aFh1uSDKComponent2.getMediationNetwork.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0);
        if (currencyIso4217Code == 1 && aFh1uSDKComponent2.AFAdRevenueData.getMonetizationNetwork("first_launch")) {
            aFh1uSDKComponent2.getCurrencyIso4217Code.putAll(aFh1uSDKComponent2.AFAdRevenueData("first_launch"));
        }
        if (currencyIso4217Code > 0) {
            int i6 = AFLogger + 75;
            registerClient = i6 % 128;
            int i7 = i6 % 2;
            if (aFh1uSDKComponent2.AFAdRevenueData.getMonetizationNetwork("gcd")) {
                aFh1uSDKComponent2.getRevenue.putAll(aFh1uSDKComponent2.AFAdRevenueData("gcd"));
            }
        }
        aFh1uSDKComponent2.equals = aFh1uSDKComponent2.AFAdRevenueData.getMediationNetwork("prev_session_dur", 0L);
        aFa1tSDK.getRevenue().component3().AFAdRevenueData(aFa1tSDK.getMonetizationNetwork());
        aFa1tSDK.areAllFieldsValid();
        aFa1tSDK.getRevenue().AFKeystoreWrapper().getCurrencyIso4217Code();
        int i8 = AFLogger + 105;
        registerClient = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 26 / 0;
        }
        return null;
    }

    private static /* synthetic */ Object registerClient(Object[] objArr) {
        int i = 2 % 2;
        int i2 = AFLogger + 115;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, "ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
        int i4 = registerClient + 5;
        AFLogger = i4 % 128;
        Object obj = null;
        if (i4 % 2 == 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object toString(Object[] objArr) {
        AFa1tSDK aFa1tSDK = (AFa1tSDK) objArr[0];
        Map map = (Map) objArr[1];
        int i = 2 % 2;
        int i2 = registerClient + 3;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (map != null) {
            aFa1tSDK.getRevenue().copy().getMediationNetwork("setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
        }
        int i4 = AFLogger + 97;
        registerClient = i4 % 128;
        Object obj = null;
        if (i4 % 2 != 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    final Map<String, Object> AFAdRevenueData(AFh1sSDK aFh1sSDK) {
        String str;
        int i = 2 % 2;
        Context context = getRevenue().registerClient().getCurrencyIso4217Code;
        AFc1jSDK mediationNetwork = getMediationNetwork(context);
        AFg1vSDK aFg1vSDKAreAllFieldsValid = getRevenue().areAllFieldsValid();
        boolean revenue = getRevenue().AFInAppEventParameterName().getRevenue();
        boolean zAFAdRevenueData = aFh1sSDK.AFAdRevenueData();
        Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
        long time = new Date().getTime();
        Object[] objArr = new Object[1];
        a("\ud96c\uf8bc髼볼常灓ቢ㖟ퟁ\ue9e3謆굀", ExpandableListView.getPackedPositionGroup(0L) + 8663, objArr);
        boolean z = false;
        map.put(((String) objArr[0]).intern(), Long.toString(time));
        try {
            if (revenue) {
                int i2 = registerClient + 109;
                AFLogger = i2 % 128;
                int i3 = i2 % 2;
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer SDK Reporting has been stopped", true);
            } else {
                AFLogger aFLogger = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK = AFg1cSDK.GENERAL;
                StringBuilder sb = new StringBuilder("******* sendTrackingWithEvent: ");
                if (zAFAdRevenueData) {
                    int i4 = registerClient + 73;
                    AFLogger = i4 % 128;
                    str = "Launch";
                    if (i4 % 2 != 0) {
                        int i5 = 2 / 0;
                    }
                } else {
                    str = aFh1sSDK.areAllFieldsValid;
                }
                aFLogger.i(aFg1cSDK, sb.append(str).toString(), true);
            }
            getMonetizationNetwork(new Object[]{context}, 847967095, -847967080, (int) System.currentTimeMillis());
            int mediationNetwork2 = getMediationNetwork(mediationNetwork, zAFAdRevenueData);
            if (aFh1sSDK.areAllFieldsValid != null) {
                int i6 = registerClient;
                int i7 = i6 + 33;
                AFLogger = i7 % 128;
                int i8 = i7 % 2;
                int i9 = i6 + 71;
                AFLogger = i9 % 128;
                int i10 = i9 % 2;
                z = true;
            }
            int iAFAdRevenueData = AFAdRevenueData(mediationNetwork, z);
            if (zAFAdRevenueData && mediationNetwork2 == 1) {
                int i11 = AFLogger + 109;
                registerClient = i11 % 128;
                int i12 = i11 % 2;
                AppsFlyerProperties.getInstance().getMonetizationNetwork = true;
            }
            aFg1vSDKAreAllFieldsValid.getMonetizationNetwork(map, mediationNetwork2, iAFAdRevenueData);
            return map;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Error while preparing to send event", th, true, true, true);
            return map;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void addPushNotificationDeepLinkPath(String... strArr) {
        int i = 2 % 2;
        List<String> listAsList = Arrays.asList(strArr);
        List<List<String>> list = getRevenue().i().getMediationNetwork;
        if (!list.contains(listAsList)) {
            int i2 = AFLogger + 39;
            registerClient = i2 % 128;
            if (i2 % 2 == 0) {
                list.add(listAsList);
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            list.add(listAsList);
        }
        int i3 = AFLogger + 23;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void anonymizeUser(boolean z) {
        int i = 2 % 2;
        int i2 = registerClient + 93;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            AFd1lSDK aFd1lSDKCopy = getRevenue().copy();
            String[] strArr = new String[1];
            strArr[1] = String.valueOf(z);
            aFd1lSDKCopy.getMediationNetwork("anonymizeUser", strArr);
        } else {
            getRevenue().copy().getMediationNetwork("anonymizeUser", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i = 2 % 2;
        int i2 = AFLogger + 27;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFa1oSDK aFa1oSDKI = getRevenue().i();
        aFa1oSDKI.getMonetizationNetwork = str;
        aFa1oSDKI.getCurrencyIso4217Code = map;
        int i4 = AFLogger + 107;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void b_(Context context, Intent intent) {
        int i = 2 % 2;
        AFj1nSDK aFj1nSDK = new AFj1nSDK(intent);
        if (aFj1nSDK.getMediationNetwork("appsflyer_preinstall") != null) {
            int i2 = AFLogger + 9;
            registerClient = i2 % 128;
            if (i2 % 2 == 0) {
                getMediationNetwork(aFj1nSDK.getMediationNetwork("appsflyer_preinstall"));
                throw null;
            }
            getMediationNetwork(aFj1nSDK.getMediationNetwork("appsflyer_preinstall"));
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String mediationNetwork = aFj1nSDK.getMediationNetwork("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(mediationNetwork)));
        if (mediationNetwork != null) {
            int i3 = AFLogger + 75;
            registerClient = i3 % 128;
            int i4 = i3 % 2;
            getMediationNetwork(context).getMediationNetwork("referrer", mediationNetwork);
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            appsFlyerProperties.set("AF_REFERRER", mediationNetwork);
            appsFlyerProperties.getRevenue = mediationNetwork;
            if (AppsFlyerProperties.getInstance().getCurrencyIso4217Code()) {
                int i5 = registerClient + 69;
                AFLogger = i5 % 128;
                int i6 = i5 % 2;
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                getCurrencyIso4217Code(context, AFh1xSDK.onReceive);
                getMonetizationNetwork(new Object[]{this, mediationNetwork}, -1378401160, 1378401168, System.identityHashCode(this));
            }
        }
    }

    final void component3() {
        int i = 2 % 2;
        int i2 = registerClient + 15;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (!AFe1fSDK.areAllFieldsValid()) {
            AFd1zSDK revenue = getRevenue();
            AFe1qSDK aFe1qSDKEquals = revenue.equals();
            aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(new AFe1fSDK(revenue)));
            return;
        }
        int i4 = AFLogger + 89;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void disableAppSetId() {
        int i = 2 % 2;
        int i2 = AFLogger + 73;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().e().component1 = true;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableFacebookDeferredApplinks(boolean z) {
        int i = 2 % 2;
        int i2 = registerClient + 41;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().unregisterClient().getMonetizationNetwork(z);
        int i4 = AFLogger + 63;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableTCFDataCollection(boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 69;
        registerClient = i2 % 128;
        if (i2 % 2 != 0) {
            getMediationNetwork(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, Boolean.toString(z));
        } else {
            getMediationNetwork(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, Boolean.toString(z));
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAppsFlyerUID(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 15;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            getRevenue().copy().getMediationNetwork("getAppsFlyerUID", new String[1]);
            if (context == null) {
                return null;
            }
        } else {
            getRevenue().copy().getMediationNetwork("getAppsFlyerUID", new String[0]);
            if (context == null) {
                return null;
            }
        }
        getMonetizationNetwork(context);
        String currencyIso4217Code = AFb1iSDK.getCurrencyIso4217Code(getRevenue().AFAdRevenueData().getCurrencyIso4217Code);
        int i3 = AFLogger + 7;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
        return currencyIso4217Code;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAttributionId(Context context) {
        return (String) getMonetizationNetwork(new Object[]{this, context}, 1233339105, -1233339105, System.identityHashCode(this));
    }

    public final boolean getCurrencyIso4217Code() {
        int i = 2 % 2;
        int i2 = AFLogger + 53;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            getRevenue(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID);
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (getRevenue(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID) && AFAdRevenueData() == null) {
            int i3 = registerClient + Imgproc.COLOR_YUV2RGBA_YVYU;
            AFLogger = i3 % 128;
            int i4 = i3 % 2;
            return true;
        }
        int i5 = AFLogger + 53;
        registerClient = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 27 / 0;
        }
        return false;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostName() {
        int i = 2 % 2;
        int i2 = registerClient + 75;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFe1vSDK aFe1vSDKAFInAppEventType = getRevenue().AFInAppEventType();
        if (i3 != 0) {
            aFe1vSDKAFInAppEventType.getCurrencyIso4217Code();
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        String currencyIso4217Code = aFe1vSDKAFInAppEventType.getCurrencyIso4217Code();
        int i4 = AFLogger + 55;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 3 / 0;
        }
        return currencyIso4217Code;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostPrefix() {
        return (String) getMonetizationNetwork(new Object[]{this}, 595451129, -595451120, System.identityHashCode(this));
    }

    public final AFc1jSDK getMediationNetwork(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 119;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            getMonetizationNetwork(context);
            getRevenue().getMediationNetwork();
            throw null;
        }
        getMonetizationNetwork(context);
        AFc1jSDK mediationNetwork = getRevenue().getMediationNetwork();
        int i3 = AFLogger + 7;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
        return mediationNetwork;
    }

    public final void getMediationNetwork(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        int i = 2 % 2;
        int i2 = AFLogger + 103;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String revenue = getMediationNetwork(context).getRevenue("extraReferrers", (String) null);
            if (revenue == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(revenue);
                jSONArray = jSONObject2.has(str) ? new JSONArray((String) jSONObject2.get(str)) : new JSONArray();
                jSONObject = jSONObject2;
            }
            if (jSONArray.length() < 5) {
                jSONArray.put(jCurrentTimeMillis);
                int i4 = registerClient + 105;
                AFLogger = i4 % 128;
                int i5 = i4 % 2;
            }
            if (jSONObject.length() >= 4) {
                getCurrencyIso4217Code(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            getMediationNetwork(context).getMediationNetwork("extraReferrers", jSONObject.toString());
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e);
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Couldn't save referrer - ").append(str).append(": ").toString(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[Catch: all -> 0x0031, TryCatch #0 {, blocks: (B:4:0x0002, B:15:0x002d, B:14:0x001c, B:12:0x0019, B:8:0x0013), top: B:21:0x0002, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final synchronized AFf1uSDK getMonetizationNetwork() {
        int i = 2 % 2;
        int i2 = AFLogger + 13;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFf1uSDK aFf1uSDK = this.copy;
        if (i3 == 0) {
            int i4 = 43 / 0;
            if (aFf1uSDK == null) {
                this.copy = new AFf1uSDK() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda0
                    @Override // com.appsflyer.internal.AFf1uSDK
                    public final void onRemoteConfigUpdateFinished(AFf1nSDK aFf1nSDK) {
                        this.f$0.AFAdRevenueData(aFf1nSDK);
                    }
                };
                int i5 = AFLogger + 45;
                registerClient = i5 % 128;
                int i6 = i5 % 2;
                int i7 = 2 % 2;
            }
        } else if (aFf1uSDK == null) {
        }
        return this.copy;
    }

    public final void getMonetizationNetwork(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 19;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        AFc1cSDK aFc1cSDK = this.copydefault;
        if (context != null) {
            AFc1fSDK aFc1fSDK = aFc1cSDK.AFAdRevenueData;
            if (context != null) {
                int i4 = AFLogger + 57;
                registerClient = i4 % 128;
                int i5 = i4 % 2;
                aFc1fSDK.getCurrencyIso4217Code = context.getApplicationContext();
                int i6 = AFLogger + 29;
                registerClient = i6 % 128;
                int i7 = i6 % 2;
            }
        }
    }

    final void getMonetizationNetwork(AFh1sSDK aFh1sSDK, AFh1oSDK aFh1oSDK) {
        int i = 2 % 2;
        getCurrencyIso4217Code(aFh1sSDK, aFh1oSDK);
        if (getRevenue().AFInAppEventParameterName().getMonetizationNetwork() != null) {
            String referrer = AppsFlyerProperties.getInstance().getReferrer(getRevenue().getMediationNetwork());
            if (referrer == null) {
                int i2 = registerClient + 17;
                AFLogger = i2 % 128;
                int i3 = i2 % 2;
                referrer = "";
            }
            aFh1sSDK.component2 = referrer;
            getCurrencyIso4217Code(aFh1sSDK);
            return;
        }
        AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
        AppsFlyerRequestListener appsFlyerRequestListener = aFh1sSDK.getCurrencyIso4217Code;
        if (appsFlyerRequestListener != null) {
            int i4 = AFLogger + 31;
            registerClient = i4 % 128;
            int i5 = i4 % 2;
            appsFlyerRequestListener.onError(41, "No dev key");
            int i6 = registerClient + 25;
            AFLogger = i6 % 128;
            int i7 = i6 % 2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getOutOfStore(Context context) {
        int i = 2 % 2;
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        if (string == null) {
            String strAFAdRevenueData = AFAdRevenueData(context, "AF_STORE");
            if (strAFAdRevenueData != null) {
                return strAFAdRevenueData;
            }
            AFLogger.afInfoLog("No out-of-store value set");
            return null;
        }
        int i2 = registerClient + 109;
        int i3 = i2 % 128;
        AFLogger = i3;
        int i4 = i2 % 2;
        int i5 = i3 + 13;
        registerClient = i5 % 128;
        int i6 = i5 % 2;
        return string;
    }

    public final AFd1zSDK getRevenue() {
        int i = 2 % 2;
        int i2 = registerClient + 47;
        int i3 = i2 % 128;
        AFLogger = i3;
        int i4 = i2 % 2;
        AFc1cSDK aFc1cSDK = this.copydefault;
        int i5 = i3 + 97;
        registerClient = i5 % 128;
        if (i5 % 2 != 0) {
            return aFc1cSDK;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void getRevenue(AFh1sSDK aFh1sSDK) {
        long j;
        int i = 2 % 2;
        Context context = getRevenue().registerClient().getCurrencyIso4217Code;
        boolean z = true;
        if (context == null) {
            AFLogger.INSTANCE.d(AFg1cSDK.ATTRIBUTION, "sendWithEvent - got null context. skipping event/launch.", true);
            return;
        }
        String monetizationNetwork = getRevenue().AFInAppEventParameterName().getMonetizationNetwork();
        AppsFlyerRequestListener appsFlyerRequestListener = aFh1sSDK.getCurrencyIso4217Code;
        if (monetizationNetwork == null || monetizationNetwork.length() == 0) {
            AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ", true);
            AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer will not track this event.", true);
            if (appsFlyerRequestListener != null) {
                int i2 = AFLogger + 39;
                registerClient = i2 % 128;
                int i3 = i2 % 2;
                appsFlyerRequestListener.onError(41, "No dev key");
                return;
            }
            return;
        }
        AFc1jSDK mediationNetwork = getMediationNetwork(context);
        AppsFlyerProperties.getInstance().saveProperties(mediationNetwork);
        if (!getRevenue().AFInAppEventParameterName().getRevenue()) {
            AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, new StringBuilder("sendWithEvent from activity: ").append(context.getClass().getName()).toString(), true);
        }
        boolean zAFAdRevenueData = aFh1sSDK.AFAdRevenueData();
        Map<String, ?> mapAFAdRevenueData = AFAdRevenueData(aFh1sSDK);
        if (getRevenue().AFInAppEventParameterName().getRevenue()) {
            AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyerLib.sendWithEvent");
        }
        int mediationNetwork2 = getMediationNetwork(mediationNetwork, false);
        getMediationNetwork(mapAFAdRevenueData);
        AFa1uSDK aFa1uSDK = new AFa1uSDK(getRevenue(), aFh1sSDK.getCurrencyIso4217Code(mapAFAdRevenueData).getMonetizationNetwork(mediationNetwork2), getRevenue().unregisterClient().getRevenue());
        if (zAFAdRevenueData) {
            boolean z2 = false;
            for (AFj1zSDK aFj1zSDK : component1()) {
                int i4 = registerClient + 27;
                AFLogger = i4 % 128;
                int i5 = i4 % 2;
                if (aFj1zSDK.component2 == AFj1zSDK.AFa1ySDK.STARTED) {
                    AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, new StringBuilder("Failed to get ").append(aFj1zSDK.AFAdRevenueData).append(" referrer, wait ...").toString());
                    z2 = true;
                }
            }
            if (getRevenue().unregisterClient().getMonetizationNetwork()) {
                int i6 = AFLogger + 53;
                registerClient = i6 % 128;
                int i7 = i6 % 2;
                AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "fetching Facebook deferred AppLink data, wait ...");
                int i8 = AFLogger + 73;
                registerClient = i8 % 128;
                int i9 = i8 % 2;
                z2 = true;
            }
            if (getRevenue().AFInAppEventParameterName().getMediationNetwork()) {
                int i10 = registerClient + 29;
                AFLogger = i10 % 128;
                if (i10 % 2 != 0) {
                    z = false;
                }
            } else {
                z = z2;
            }
        }
        ScheduledExecutorService monetizationNetwork2 = getRevenue().getMonetizationNetwork();
        if (z) {
            j = 500;
        } else {
            int i11 = registerClient + 35;
            AFLogger = i11 % 128;
            int i12 = i11 % 2;
            j = 0;
        }
        AFj1cSDK.getMonetizationNetwork(monetizationNetwork2, aFa1uSDK, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getSdkVersion() {
        int i = 2 % 2;
        int i2 = AFLogger + 95;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("getSdkVersion", new String[0]);
        String strAreAllFieldsValid = AFc1kSDK.areAllFieldsValid();
        int i4 = AFLogger + 53;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return strAreAllFieldsValid;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        String str2;
        int i = 2 % 2;
        if (this.toString) {
            int i2 = AFLogger + 71;
            registerClient = i2 % 128;
            int i3 = i2 % 2;
            return this;
        }
        this.toString = true;
        getRevenue().AFInAppEventParameterName().getRevenue(str);
        if (context != null) {
            int i4 = AFLogger + 27;
            registerClient = i4 % 128;
            int i5 = i4 % 2;
            getMonetizationNetwork(context);
            Application applicationO_ = AFj1pSDK.O_(context);
            if (applicationO_ == null) {
                return this;
            }
            int i6 = AFLogger + 47;
            registerClient = i6 % 128;
            int i7 = i6 % 2;
            this.component3 = applicationO_;
            getRevenue().getCurrencyIso4217Code().execute(new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.equals();
                }
            });
            getRevenue().equals().getMediationNetwork.add(new AFa1ySDK());
            AFe1qSDK aFe1qSDKEquals = getRevenue().equals();
            aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(new AFe1jSDK(getRevenue())));
            getRevenue().afLogForce().getMonetizationNetwork(new AFd1xSDK.AFa1tSDK() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda3
                @Override // com.appsflyer.internal.AFd1xSDK.AFa1tSDK
                public final void onConfigurationChanged(boolean z) {
                    this.f$0.getCurrencyIso4217Code(z);
                }
            });
            AFj1rSDK aFj1rSDKCopydefault = getRevenue().copydefault();
            Runnable runnable = new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.copy();
                }
            };
            AFi1aSDK aFi1aSDKAFAdRevenueData = aFj1rSDKCopydefault.AFAdRevenueData(runnable);
            Runnable currencyIso4217Code = aFj1rSDKCopydefault.getCurrencyIso4217Code(aFi1aSDKAFAdRevenueData, runnable);
            aFj1rSDKCopydefault.AFAdRevenueData.add(aFi1aSDKAFAdRevenueData);
            aFj1rSDKCopydefault.AFAdRevenueData.add(new AFj1uSDK(aFj1rSDKCopydefault.getCurrencyIso4217Code.AFAdRevenueData(), currencyIso4217Code));
            aFj1rSDKCopydefault.AFAdRevenueData.add(new AFi1eSDK(currencyIso4217Code, aFj1rSDKCopydefault.getCurrencyIso4217Code, new AFi1dSDK()));
            aFj1rSDKCopydefault.AFAdRevenueData.add(new AFj1sSDK(currencyIso4217Code, aFj1rSDKCopydefault.getCurrencyIso4217Code));
            aFj1rSDKCopydefault.AFAdRevenueData.add(new AFj1qSDK(aFj1rSDKCopydefault.getCurrencyIso4217Code.getCurrencyIso4217Code(), aFj1rSDKCopydefault.getCurrencyIso4217Code.AFAdRevenueData(), currencyIso4217Code));
            aFj1rSDKCopydefault.getRevenue(currencyIso4217Code);
            AFj1zSDK[] aFj1zSDKArr = (AFj1zSDK[]) aFj1rSDKCopydefault.AFAdRevenueData.toArray(new AFj1zSDK[0]);
            int length = aFj1zSDKArr.length;
            int i8 = 0;
            while (i8 < length) {
                int i9 = registerClient + 61;
                AFLogger = i9 % 128;
                if (i9 % 2 != 0) {
                    aFj1zSDKArr[i8].getMonetizationNetwork(aFj1rSDKCopydefault.getCurrencyIso4217Code.registerClient().getCurrencyIso4217Code);
                    i8 += 63;
                } else {
                    aFj1zSDKArr[i8].getMonetizationNetwork(aFj1rSDKCopydefault.getCurrencyIso4217Code.registerClient().getCurrencyIso4217Code);
                    i8++;
                }
            }
            if (!aFj1rSDKCopydefault.getCurrencyIso4217Code()) {
                aFj1rSDKCopydefault.getMediationNetwork(aFj1rSDKCopydefault.getCurrencyIso4217Code.registerClient().getCurrencyIso4217Code, currencyIso4217Code, aFj1rSDKCopydefault.getCurrencyIso4217Code);
            }
        } else {
            AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "context is null, Google Install Referrer will be not initialized");
        }
        AFd1lSDK aFd1lSDKCopy = getRevenue().copy();
        String[] strArr = new String[2];
        strArr[0] = str;
        if (appsFlyerConversionListener == null) {
            int i10 = AFLogger + 95;
            registerClient = i10 % 128;
            int i11 = i10 % 2;
            str2 = AbstractJsonLexerKt.NULL;
        } else {
            str2 = "conversionDataListener";
        }
        strArr[1] = str2;
        aFd1lSDKCopy.getMediationNetwork("init", strArr);
        AFLogger.INSTANCE.force(AFg1cSDK.GENERAL, String.format("Initializing AppsFlyer SDK: (v%s.%s)", "6.18.0", getMonetizationNetwork));
        this.getCurrencyIso4217Code = appsFlyerConversionListener;
        return this;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isPreInstalledApp(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 11;
        registerClient = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            getMonetizationNetwork(context);
            getRevenue().AFAdRevenueData().getMonetizationNetwork(context);
            throw null;
        }
        getMonetizationNetwork(context);
        boolean monetizationNetwork = getRevenue().AFAdRevenueData().getMonetizationNetwork(context);
        int i3 = AFLogger + 51;
        registerClient = i3 % 128;
        if (i3 % 2 != 0) {
            return monetizationNetwork;
        }
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final boolean isStopped() {
        int i = 2 % 2;
        int i2 = registerClient + 99;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        boolean revenue = getRevenue().AFInAppEventParameterName().getRevenue();
        if (i3 != 0) {
            int i4 = 48 / 0;
        }
        int i5 = registerClient + 83;
        AFLogger = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 98 / 0;
        }
        return revenue;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logAdRevenue(AFAdRevenueData aFAdRevenueData, Map<String, Object> map) {
        int i = 2 % 2;
        if (!this.toString) {
            AFAdRevenueData("logAdRevenue");
            int i2 = registerClient + 1;
            AFLogger = i2 % 128;
            if (i2 % 2 == 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (!aFAdRevenueData.areAllFieldsValid()) {
            int i3 = registerClient + 57;
            AFLogger = i3 % 128;
            int i4 = i3 % 2;
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "Invalid ad revenue parameters provided");
            return;
        }
        if (getRevenue().AFInAppEventParameterName().getRevenue()) {
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "SDK is stopped");
        } else if (AFk1zSDK.getMediationNetwork(getRevenue().AFInAppEventParameterName().getMonetizationNetwork())) {
            getMonetizationNetwork(new Object[0], -1617966880, 1617966902, (int) System.currentTimeMillis());
        } else {
            getCurrencyIso4217Code(new AFh1qSDK(aFAdRevenueData, map));
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i = 2 % 2;
        int i2 = registerClient + 57;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        logEvent(context, str, map, null);
        int i4 = AFLogger + 103;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap map2 = map == null ? null : new HashMap(map);
        getMonetizationNetwork(context);
        AFh1lSDK aFh1lSDK = new AFh1lSDK();
        aFh1lSDK.areAllFieldsValid = str;
        aFh1lSDK.getCurrencyIso4217Code = appsFlyerRequestListener;
        if (map2 != null && map2.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap map3 = new HashMap();
            Object obj = map2.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap map4 = new HashMap();
                map4.put("x", Float.valueOf(motionEvent.getX()));
                map4.put("y", Float.valueOf(motionEvent.getY()));
                map3.put("loc", map4);
                map3.put("pf", Float.valueOf(motionEvent.getPressure()));
                map3.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                map3.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.INSTANCE.w(AFg1cSDK.PREDICT, "Parsing failed due to invalid input in 'af_touch_obj'.", true);
            }
            Map<String, ?> mapSingletonMap = Collections.singletonMap("tch_data", map3);
            map2.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFh1lSDK.getCurrencyIso4217Code(mapSingletonMap);
        }
        aFh1lSDK.getMediationNetwork = map2;
        AFd1lSDK aFd1lSDKCopy = getRevenue().copy();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject(aFh1lSDK.getMediationNetwork == null ? new HashMap() : aFh1lSDK.getMediationNetwork).toString();
        aFd1lSDKCopy.getMediationNetwork("logEvent", strArr);
        if (str == null) {
            getCurrencyIso4217Code(context, AFh1xSDK.logEvent);
        }
        getMonetizationNetwork(aFh1lSDK, (AFh1oSDK) getMonetizationNetwork(new Object[]{this, context}, -536448515, 536448536, System.identityHashCode(this)));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logLocation(Context context, double d, double d2) {
        int i = 2 % 2;
        getRevenue().copy().getMediationNetwork("logLocation", String.valueOf(d), String.valueOf(d2));
        HashMap map = new HashMap();
        map.put(AFInAppEventParameterName.LONGITUDE, Double.toString(d2));
        map.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        getMediationNetwork(context, AFInAppEventType.LOCATION_COORDINATES, map);
        int i2 = registerClient + 43;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logSession(Context context) {
        int i = 2 % 2;
        int i2 = AFLogger + 113;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("logSession", new String[0]);
        getRevenue().copy().getMonetizationNetwork();
        getCurrencyIso4217Code(context, AFh1xSDK.logSession);
        getMediationNetwork(context, null, null);
        int i4 = registerClient + 39;
        AFLogger = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void onPause(Context context) {
        int i = 2 % 2;
        int i2 = registerClient + 103;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().afInfoLog().getMediationNetwork();
        int i4 = registerClient + 19;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        int i = 2 % 2;
        int i2 = registerClient + 77;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        if (uri == null || uri.toString().isEmpty()) {
            getRevenue().i().AFAdRevenueData(new StringBuilder("Link is \"").append(uri).append("\"").toString(), DeepLinkResult.Error.NETWORK);
            int i4 = registerClient + 87;
            AFLogger = i4 % 128;
            int i5 = i4 % 2;
            return;
        }
        if (context == null) {
            getRevenue().i().AFAdRevenueData(new StringBuilder("Context is \"").append(context).append("\"").toString(), DeepLinkResult.Error.NETWORK);
        } else {
            getMonetizationNetwork(context);
            getRevenue().i().g_(AFa1jSDK.getMediationNetwork(getRevenue().afErrorLog()), Uri.parse(uri.toString()));
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void performOnDeepLinking(final Intent intent, Context context) {
        int i = 2 % 2;
        if (intent == null) {
            getRevenue().i().AFAdRevenueData("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
            int i2 = registerClient + 73;
            AFLogger = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        if (context == null) {
            getRevenue().i().AFAdRevenueData("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        getMonetizationNetwork(applicationContext);
        getRevenue().getCurrencyIso4217Code().execute(new Runnable() { // from class: com.appsflyer.internal.AFa1tSDK$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e_(applicationContext, intent);
            }
        });
        int i4 = registerClient + 115;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        getMonetizationNetwork(new Object[]{this, context, appsFlyerConversionListener}, 584622117, -584622104, System.identityHashCode(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        com.appsflyer.internal.AFa1tSDK.getMediationNetwork = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0025, code lost:
    
        if (r6 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
    
        if (r6 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
    
        r4 = com.appsflyer.internal.AFa1tSDK.AFLogger + 99;
        com.appsflyer.internal.AFa1tSDK.registerClient = r4 % 128;
        r4 = r4 % 2;
        com.appsflyer.AFLogger.afDebugLog("registerValidatorListener null listener");
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        int i = 2 % 2;
        int i2 = registerClient + 7;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            getRevenue().copy().getMediationNetwork("registerValidatorListener", new String[0]);
            AFLogger.afDebugLog("registerValidatorListener called");
        } else {
            getRevenue().copy().getMediationNetwork("registerValidatorListener", new String[0]);
            AFLogger.afDebugLog("registerValidatorListener called");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendInAppPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        getMonetizationNetwork(new Object[]{this, context, map, purchaseValidationCallback}, 1377152571, -1377152557, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        int i = 2 % 2;
        int i2 = registerClient + 17;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getMonetizationNetwork(context);
        PurchaseHandler purchaseHandlerComponent1 = getRevenue().component1();
        if (purchaseHandlerComponent1.getRevenue(map, purchaseValidationCallback, "subscriptions")) {
            AFe1oSDK aFe1oSDK = new AFe1oSDK(map, purchaseValidationCallback, purchaseHandlerComponent1.getCurrencyIso4217Code);
            AFe1qSDK aFe1qSDK = purchaseHandlerComponent1.AFAdRevenueData;
            aFe1qSDK.getMonetizationNetwork.execute(aFe1qSDK.new AnonymousClass1(aFe1oSDK));
        }
        int i4 = AFLogger + 45;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x019a  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sendPushNotificationData(Activity activity) {
        int i;
        long j;
        long jLongValue;
        int i2 = 2;
        int i3 = 2 % 2;
        int i4 = AFLogger + 39;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
        if (activity != null && activity.getIntent() != null) {
            getRevenue().copy().getMediationNetwork("sendPushNotificationData", activity.getLocalClassName(), new StringBuilder("activity_intent_").append(activity.getIntent().toString()).toString());
        } else if (activity != null) {
            getRevenue().copy().getMediationNetwork("sendPushNotificationData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            getRevenue().copy().getMediationNetwork("sendPushNotificationData", "activity_null");
        }
        AFc1gSDK aFc1gSDKE = getRevenue().e();
        aFc1gSDKE.getRevenue = AFAdRevenueData(activity);
        if (aFc1gSDKE.getRevenue != null) {
            int i6 = registerClient + 43;
            AFLogger = i6 % 128;
            int i7 = i6 % 2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.hashCode == null) {
                AFLogger.afInfoLog("pushes: initializing pushes history..");
                this.hashCode = new ConcurrentHashMap();
                i = 2;
                jLongValue = jCurrentTimeMillis;
                j = jLongValue;
            } else {
                try {
                    long j2 = AppsFlyerProperties.getInstance().getLong("pushPayloadMaxAging", 1800000L);
                    jLongValue = jCurrentTimeMillis;
                    for (Long l : this.hashCode.keySet()) {
                        try {
                            JSONObject jSONObject = new JSONObject(aFc1gSDKE.getRevenue);
                            i = i2;
                            try {
                                JSONObject jSONObject2 = new JSONObject(this.hashCode.get(l));
                                j = jCurrentTimeMillis;
                                try {
                                    if (jSONObject.opt("pid").equals(jSONObject2.opt("pid")) && jSONObject.opt("c").equals(jSONObject2.opt("c"))) {
                                        AFLogger.afInfoLog(new StringBuilder("PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: ").append(jSONObject2).append(", new: ").append(jSONObject).append(")").toString());
                                        aFc1gSDKE.getRevenue = null;
                                        return;
                                    }
                                    if (j - l.longValue() > j2) {
                                        int i8 = registerClient + 125;
                                        AFLogger = i8 % 128;
                                        int i9 = i8 % 2;
                                        this.hashCode.remove(l);
                                    }
                                    if (l.longValue() <= jLongValue) {
                                        jLongValue = l.longValue();
                                    }
                                    i2 = i;
                                    jCurrentTimeMillis = j;
                                } catch (Throwable th) {
                                    th = th;
                                    AFLogger.afErrorLog(new StringBuilder("Error while handling push notification measurement: ").append(th.getClass().getSimpleName()).toString(), th);
                                    if (this.hashCode.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", i)) {
                                    }
                                    this.hashCode.put(Long.valueOf(j), aFc1gSDKE.getRevenue);
                                    start(activity);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                j = jCurrentTimeMillis;
                                AFLogger.afErrorLog(new StringBuilder("Error while handling push notification measurement: ").append(th.getClass().getSimpleName()).toString(), th);
                                if (this.hashCode.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", i)) {
                                }
                                this.hashCode.put(Long.valueOf(j), aFc1gSDKE.getRevenue);
                                start(activity);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i = i2;
                        }
                    }
                    i = i2;
                    j = jCurrentTimeMillis;
                } catch (Throwable th4) {
                    th = th4;
                    i = 2;
                    j = jCurrentTimeMillis;
                    jLongValue = j;
                }
            }
            if (this.hashCode.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", i)) {
                AFLogger.afInfoLog(new StringBuilder("pushes: removing oldest overflowing push (oldest push:").append(jLongValue).append(")").toString());
                this.hashCode.remove(Long.valueOf(jLongValue));
                int i10 = registerClient + 113;
                AFLogger = i10 % 128;
                if (i10 % 2 != 0) {
                    int i11 = 5 / 3;
                }
            }
            this.hashCode.put(Long.valueOf(j), aFc1gSDKE.getRevenue);
            start(activity);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAdditionalData(Map<String, Object> map) {
        getMonetizationNetwork(new Object[]{this, map}, -123240693, 123240713, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAndroidIdData(String str) {
        getMonetizationNetwork(new Object[]{this, str}, 2094756740, -2094756729, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppId(String str) {
        int i = 2 % 2;
        int i2 = registerClient + 111;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setAppId", str);
        getMediationNetwork(AppsFlyerProperties.APP_ID, str);
        int i4 = registerClient + 37;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0051  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setAppInviteOneLink(String str) {
        int i = 2 % 2;
        int i2 = registerClient + 91;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            getRevenue().copy().getMediationNetwork("setAppInviteOneLink", str);
            AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
            if (str != null) {
                if (!str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
                    AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
                    AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_VERSION);
                    AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
                }
            }
        } else {
            getRevenue().copy().getMediationNetwork("setAppInviteOneLink", str);
            AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
            if (str != null) {
            }
        }
        getMediationNetwork(AppsFlyerProperties.ONELINK_ID, str);
        int i3 = AFLogger + 7;
        registerClient = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectAndroidID(boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 77;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setCollectAndroidID", String.valueOf(z));
        getMediationNetwork(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        getMediationNetwork(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
        int i4 = registerClient + 47;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 16 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectIMEI(boolean z) {
        int i = 2 % 2;
        int i2 = registerClient + 85;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setCollectIMEI", String.valueOf(z));
        getMediationNetwork(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        getMediationNetwork(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
        int i4 = AFLogger + 115;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setCollectOaid(boolean z) {
        int i = 2 % 2;
        int i2 = registerClient + 17;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setCollectOaid", String.valueOf(z));
        getMediationNetwork(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
        int i4 = AFLogger + 83;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 70 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setConsentData(AppsFlyerConsent appsFlyerConsent) {
        int i = 2 % 2;
        int i2 = registerClient + 107;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        Objects.requireNonNull(appsFlyerConsent);
        getRevenue().e().areAllFieldsValid = appsFlyerConsent;
        int i4 = AFLogger + Imgproc.COLOR_YUV2RGB_YVYU;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCurrencyCode(String str) {
        getMonetizationNetwork(new Object[]{this, str}, -1615724461, 1615724462, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerIdAndLogSession(String str, Context context) {
        int i = 2 % 2;
        if (context != null) {
            int i2 = AFLogger + 17;
            registerClient = i2 % 128;
            if (i2 % 2 == 0) {
                getCurrencyIso4217Code();
                throw null;
            }
            if (!getCurrencyIso4217Code()) {
                setCustomerUserId(str);
                AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
                int i3 = AFLogger + 113;
                registerClient = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog(new StringBuilder("CustomerUserId set: ").append(str).append(" - Initializing AppsFlyer Tacking").toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(getRevenue().getMediationNetwork());
            getCurrencyIso4217Code(context, AFh1xSDK.setCustomerIdAndLogSession);
            getRevenue().AFInAppEventParameterName().getMonetizationNetwork();
            if (referrer == null) {
                int i5 = registerClient + 57;
                AFLogger = i5 % 128;
                if (i5 % 2 != 0) {
                    throw null;
                }
                referrer = "";
            }
            if (context instanceof Activity) {
                int i6 = AFLogger + 31;
                registerClient = i6 % 128;
                int i7 = i6 % 2;
                ((Activity) context).getIntent();
            }
            getCurrencyIso4217Code(context, referrer);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerUserId(String str) {
        int i = 2 % 2;
        int i2 = AFLogger + 101;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        getMediationNetwork(AppsFlyerProperties.APP_USER_ID, str);
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false}, 1660171217, -1660171210, (int) System.currentTimeMillis());
        int i4 = registerClient + 35;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 50 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDebugLog(boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 7;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
        int i4 = AFLogger + 123;
        registerClient = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 45 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setDisableAdvertisingIdentifiers(boolean z) {
        boolean z2;
        int i = 2 % 2;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z)));
        if (!z) {
            int i2 = registerClient + 81;
            AFLogger = i2 % 128;
            z2 = i2 % 2 == 0;
        }
        AFb1jSDK.getRevenue = Boolean.valueOf(z2);
        AFd1zSDK revenue = getRevenue();
        revenue.e().component4 = z;
        if (!z) {
            AFe1qSDK aFe1qSDKEquals = revenue.equals();
            aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(new AFe1jSDK(getRevenue())));
            return;
        }
        int i3 = registerClient + 29;
        AFLogger = i3 % 128;
        Object obj = null;
        if (i3 % 2 != 0) {
            revenue.e().component2 = null;
            int i4 = 11 / 0;
        } else {
            revenue.e().component2 = null;
        }
        int i5 = AFLogger + 15;
        registerClient = i5 % 128;
        if (i5 % 2 != 0) {
            return;
        }
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableNetworkData(boolean z) {
        int i = 2 % 2;
        int i2 = registerClient + 65;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z)));
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.DISABLE_NETWORK_DATA, Boolean.valueOf(z)}, 1660171217, -1660171210, (int) System.currentTimeMillis());
        int i4 = AFLogger + 65;
        registerClient = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setExtension(String str) {
        int i = 2 % 2;
        int i2 = registerClient + 115;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            getRevenue().copy().getMediationNetwork("setExtension", str);
        } else {
            getRevenue().copy().getMediationNetwork("setExtension", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setHost(String str, String str2) {
        String strTrim;
        int i = 2 % 2;
        int i2 = AFLogger + 91;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        if (AFk1zSDK.getRevenue(str2)) {
            AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
            return;
        }
        if (str != null) {
            strTrim = str.trim();
        } else {
            int i4 = registerClient + 15;
            AFLogger = i4 % 128;
            int i5 = i4 % 2;
            strTrim = "";
        }
        AFe1vSDK.getMediationNetwork(new AFe1xSDK(strTrim, str2.trim()));
        int i6 = registerClient + 15;
        AFLogger = i6 % 128;
        int i7 = i6 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setImeiData(String str) {
        int i = 2 % 2;
        int i2 = AFLogger + 53;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setImeiData", str);
        AFf1kSDK aFf1kSDKAFInAppEventParameterName = getRevenue().AFInAppEventParameterName();
        AFf1kSDK.getMonetizationNetwork(new Object[]{aFf1kSDKAFInAppEventParameterName, str}, 1176564115, -1176564113, System.identityHashCode(aFf1kSDKAFInAppEventParameterName));
        int i4 = registerClient + 7;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setInstallId(String str) {
        int i = 2 % 2;
        getRevenue().copy().getMediationNetwork("setInstallId", new String[0]);
        if (!this.toString) {
            int i2 = AFLogger + 61;
            registerClient = i2 % 128;
            if (i2 % 2 != 0) {
                AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "AppsFlyerLib.init() method should be called first");
                return;
            } else {
                AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "AppsFlyerLib.init() method should be called first");
                throw null;
            }
        }
        if (!getRevenue().AFAdRevenueData().getMediationNetwork("APPSFLYER_ALLOW_CUSTOM_INSTALL_ID")) {
            int i3 = AFLogger + 21;
            registerClient = i3 % 128;
            if (i3 % 2 != 0) {
                AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "APPSFLYER_ALLOW_CUSTOM_INSTALL_ID Manifest flag should be set to true first");
                return;
            } else {
                AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "APPSFLYER_ALLOW_CUSTOM_INSTALL_ID Manifest flag should be set to true first");
                throw null;
            }
        }
        if (str != null) {
            AFb1iSDK.getCurrencyIso4217Code(str, getRevenue().getMediationNetwork());
            return;
        }
        int i4 = AFLogger + 11;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
        AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "AppsFlyer installId can't be null");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setIsUpdate(boolean z) {
        int i = 2 % 2;
        int i2 = AFLogger + 97;
        registerClient = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
        int i4 = registerClient + 109;
        AFLogger = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setLogLevel(AFLogger.LogLevel logLevel) {
        getMonetizationNetwork(new Object[]{this, logLevel}, -1560585851, 1560585867, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setMinTimeBetweenSessions(int i) {
        int i2 = 2 % 2;
        int i3 = registerClient + 107;
        AFLogger = i3 % 128;
        if (i3 % 2 == 0) {
            this.component2 = TimeUnit.SECONDS.toMillis(i);
            return;
        }
        this.component2 = TimeUnit.SECONDS.toMillis(i);
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOaidData(String str) {
        int i = 2 % 2;
        int i2 = registerClient + 75;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setOaidData", str);
        AFb1jSDK.getCurrencyIso4217Code = str;
        int i4 = registerClient + 65;
        AFLogger = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOneLinkCustomDomain(String... strArr) {
        String str;
        int i = 2 % 2;
        int i2 = registerClient + 9;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            Object[] objArr = new Object[0];
            objArr[1] = Arrays.toString(strArr);
            str = String.format("setOneLinkCustomDomain %s", objArr);
        } else {
            str = String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr));
        }
        AFLogger.afDebugLog(str);
        getRevenue().i().component2 = strArr;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOutOfStore(String str) {
        int i = 2 % 2;
        int i2 = AFLogger;
        int i3 = i2 + 65;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
        if (str == null) {
            AFLogger.afWarnLog("Cannot set setOutOfStore with null", true);
            return;
        }
        int i5 = i2 + 83;
        registerClient = i5 % 128;
        int i6 = i5 % 2;
        String lowerCase = str.toLowerCase(Locale.getDefault());
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_STORE_FROM_API, lowerCase);
        AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r5.isEmpty() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r5.isEmpty() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        com.appsflyer.AFLogger.afDebugLog(new java.lang.StringBuilder("Setting partner data for ").append(r4).append(": ").append(r5).toString());
        r0 = new org.json.JSONObject(r5).toString().length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        if (r0 <= 1000) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        com.appsflyer.AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
        r5 = new java.util.HashMap();
        r5.put("error", "limit exceeded: ".concat(java.lang.String.valueOf(r0)));
        r3.getMediationNetwork.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        r3.getMonetizationNetwork.put(r4, r5);
        r3.getMediationNetwork.remove(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a0, code lost:
    
        return;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPartnerData(String str, Map<String, Object> map) {
        String strConcat;
        int i = 2 % 2;
        AFc1gSDK aFc1gSDKE = getRevenue().e();
        if (aFc1gSDKE.getMediationNetwork == null) {
            aFc1gSDKE.getMediationNetwork = new AFb1qSDK();
            int i2 = AFLogger + 49;
            registerClient = i2 % 128;
            int i3 = i2 % 2;
        }
        AFb1qSDK aFb1qSDK = aFc1gSDKE.getMediationNetwork;
        if (str == null || str.isEmpty()) {
            AFLogger.afWarnLog("Partner ID is missing or `null`");
            return;
        }
        if (map != null) {
            int i4 = AFLogger + 47;
            registerClient = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 14 / 0;
            }
        }
        if (aFb1qSDK.getMonetizationNetwork.remove(str) == null) {
            int i6 = registerClient + 119;
            AFLogger = i6 % 128;
            strConcat = "Partner data is missing or `null`";
            if (i6 % 2 != 0) {
                int i7 = 24 / 0;
            }
        } else {
            strConcat = "Cleared partner data for ".concat(String.valueOf(str));
            int i8 = registerClient + 87;
            AFLogger = i8 % 128;
            int i9 = i8 % 2;
        }
        AFLogger.afWarnLog(strConcat);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPhoneNumber(String str) {
        int i = 2 % 2;
        int i2 = registerClient + 83;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            getRevenue().e().AFAdRevenueData = AFj1jSDK.getCurrencyIso4217Code(str);
        } else {
            getRevenue().e().AFAdRevenueData = AFj1jSDK.getCurrencyIso4217Code(str);
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPluginInfo(PluginInfo pluginInfo) {
        int i = 2 % 2;
        int i2 = registerClient + 9;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            Objects.requireNonNull(pluginInfo);
            getRevenue().AFLogger().getRevenue(pluginInfo);
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        Objects.requireNonNull(pluginInfo);
        getRevenue().AFLogger().getRevenue(pluginInfo);
        int i3 = AFLogger + 45;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPreinstallAttribution(String str, String str2, String str3) {
        int i = 2 % 2;
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        try {
            if (str != null) {
                int i2 = AFLogger + 57;
                registerClient = i2 % 128;
                if (i2 % 2 == 0) {
                    jSONObject.put("pid", str);
                    throw null;
                }
                jSONObject.put("pid", str);
            }
            if (str2 != null) {
                int i3 = registerClient + 59;
                AFLogger = i3 % 128;
                int i4 = i3 % 2;
                jSONObject.put("c", str2);
            }
            if (str3 != null) {
                jSONObject.put("af_siteid", str3);
            }
        } catch (JSONException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
        }
        if (jSONObject.has("pid")) {
            getMediationNetwork("preInstallName", jSONObject.toString());
        } else {
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setResolveDeepLinkURLs(String... strArr) {
        int i = 2 % 2;
        int i2 = registerClient + 55;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr)));
        AFa1oSDK aFa1oSDKI = getRevenue().i();
        aFa1oSDKI.areAllFieldsValid.clear();
        aFa1oSDKI.areAllFieldsValid.addAll(Arrays.asList(strArr));
        int i4 = AFLogger + 3;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilter(String... strArr) {
        int i = 2 % 2;
        int i2 = registerClient + 5;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            setSharingFilterForPartners(strArr);
        } else {
            setSharingFilterForPartners(strArr);
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i = 2 % 2;
        int i2 = AFLogger + 75;
        registerClient = i2 % 128;
        if (i2 % 2 == 0) {
            String[] strArr = new String[1];
            strArr[1] = SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL;
            setSharingFilterForPartners(strArr);
        } else {
            setSharingFilterForPartners(SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL);
        }
        int i3 = AFLogger + 95;
        registerClient = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setSharingFilterForPartners(String... strArr) {
        int i = 2 % 2;
        getRevenue().e().getMonetizationNetwork = new AFb1uSDK(strArr);
        int i2 = registerClient + 119;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        getRevenue().copy().getMediationNetwork("setUserEmails", (String[]) arrayList.toArray(new String[strArr.length + 1]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        String str = null;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            if (AnonymousClass3.getMonetizationNetwork[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(AFj1jSDK.getCurrencyIso4217Code(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                int i3 = registerClient + 103;
                AFLogger = i3 % 128;
                int i4 = i3 % 2;
                str = "plain_el_arr";
            }
            i2++;
            int i5 = AFLogger + 1;
            registerClient = i5 % 128;
            int i6 = i5 % 2;
        }
        map.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(map).toString());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(String... strArr) {
        int i = 2 % 2;
        int i2 = registerClient + 101;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        getRevenue().copy().getMediationNetwork("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        int i4 = AFLogger + 95;
        registerClient = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context) {
        getMonetizationNetwork(new Object[]{this, context}, 614179736, -614179718, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str) {
        getMonetizationNetwork(new Object[]{this, context, str}, -1960394132, 1960394155, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i = 2 % 2;
        if (getRevenue().afInfoLog().getMonetizationNetwork()) {
            return;
        }
        if (!this.toString) {
            int i2 = registerClient + 47;
            AFLogger = i2 % 128;
            int i3 = i2 % 2;
            AFAdRevenueData("start");
            if (str == null) {
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(41, "No dev key");
                }
                int i4 = registerClient + 27;
                AFLogger = i4 % 128;
                int i5 = i4 % 2;
                return;
            }
        }
        getMonetizationNetwork(context);
        final AFh1uSDK aFh1uSDKComponent2 = getRevenue().component2();
        aFh1uSDKComponent2.getRevenue(AFh1zSDK.AFAdRevenueData(context));
        if (this.component3 == null) {
            Application applicationO_ = AFj1pSDK.O_(context);
            if (applicationO_ == null) {
                return;
            }
            int i6 = registerClient + 87;
            AFLogger = i6 % 128;
            if (i6 % 2 != 0) {
                this.component3 = applicationO_;
                throw null;
            }
            this.component3 = applicationO_;
        }
        getRevenue().copy().getMediationNetwork("start", str);
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.GENERAL;
        String str2 = getMonetizationNetwork;
        aFLogger.i(aFg1cSDK, String.format("Starting AppsFlyer: (v%s.%s)", "6.18.0", str2));
        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, new StringBuilder("Build Number: ").append(str2).toString());
        AppsFlyerProperties.getInstance().loadProperties(getRevenue().getMediationNetwork());
        if (!TextUtils.isEmpty(str)) {
            int i7 = AFLogger + 95;
            registerClient = i7 % 128;
            int i8 = i7 % 2;
            getRevenue().AFInAppEventParameterName().getRevenue(str);
        } else if (TextUtils.isEmpty(getRevenue().AFInAppEventParameterName().getMonetizationNetwork())) {
            getMonetizationNetwork(new Object[0], -1617966880, 1617966902, (int) System.currentTimeMillis());
            if (appsFlyerRequestListener != null) {
                appsFlyerRequestListener.onError(41, "No dev key");
                return;
            }
            return;
        }
        getRevenue().component3().AFAdRevenueData(getMonetizationNetwork());
        component3();
        c_(this.component3.getBaseContext(), this.copydefault.AFAdRevenueData().n_());
        getRevenue().unregisterClient().getCurrencyIso4217Code();
        this.copydefault.afInfoLog().getMonetizationNetwork(context, new AFb1bSDK.AFa1zSDK() { // from class: com.appsflyer.internal.AFa1tSDK.1
            @Override // com.appsflyer.internal.AFb1bSDK.AFa1zSDK
            public final void getCurrencyIso4217Code() {
                Context context2 = AFa1tSDK.this.getRevenue().registerClient().getCurrencyIso4217Code;
                AFLogger.afInfoLog("onBecameBackground");
                AFh1uSDK aFh1uSDK = aFh1uSDKComponent2;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (aFh1uSDK.component1 != 0) {
                    long j = jCurrentTimeMillis - aFh1uSDK.component1;
                    if (j > 0 && j < 1000) {
                        j = 1000;
                    }
                    aFh1uSDK.equals = TimeUnit.MILLISECONDS.toSeconds(j);
                    aFh1uSDK.AFAdRevenueData.getRevenue("prev_session_dur", aFh1uSDK.equals);
                } else {
                    AFLogger.afInfoLog("Metrics: fg ts is missing");
                }
                AFLogger.afInfoLog("callStatsBackground background call");
                AFa1tSDK.this.getRevenue().afLogForce().getCurrencyIso4217Code();
                AFd1lSDK aFd1lSDKCopy = AFa1tSDK.this.getRevenue().copy();
                if (aFd1lSDKCopy.component3()) {
                    aFd1lSDKCopy.AFAdRevenueData();
                    if (context2 != null && !AppsFlyerLib.getInstance().isStopped()) {
                        aFd1lSDKCopy.q_(context2.getPackageName(), context2.getPackageManager());
                    }
                    aFd1lSDKCopy.getCurrencyIso4217Code();
                } else {
                    AFLogger.afDebugLog("RD status is OFF");
                }
                AFa1tSDK.this.getRevenue().component4().getMediationNetwork();
                AFa1tSDK.this.getRevenue().afErrorLog().getRevenue();
                AFh1wSDK aFh1wSDKAfErrorLogForExcManagerOnly = AFa1tSDK.this.getRevenue().afErrorLogForExcManagerOnly();
                if (aFh1wSDKAfErrorLogForExcManagerOnly != null) {
                    aFh1wSDKAfErrorLogForExcManagerOnly.getRevenue();
                }
            }

            @Override // com.appsflyer.internal.AFb1bSDK.AFa1zSDK
            public final void getMediationNetwork(AFh1oSDK aFh1oSDK) {
                aFh1uSDKComponent2.getMonetizationNetwork();
                AFd1zSDK revenue = AFa1tSDK.this.getRevenue();
                revenue.component3().AFAdRevenueData(AFa1tSDK.this.getMonetizationNetwork());
                AFa1tSDK.this.component3();
                int currencyIso4217Code = revenue.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0);
                AFLogger.afInfoLog("onBecameForeground");
                if (currencyIso4217Code < 2) {
                    AFa1tSDK.this.getRevenue().component4().getMonetizationNetwork();
                }
                AFh1mSDK aFh1mSDK = new AFh1mSDK();
                if (aFh1oSDK != null) {
                    AFa1tSDK.this.getRevenue().i().f_(AFa1jSDK.getRevenue(aFh1mSDK), aFh1oSDK.getMonetizationNetwork, revenue.registerClient().getCurrencyIso4217Code);
                    AFh1wSDK aFh1wSDKAfErrorLogForExcManagerOnly = revenue.afErrorLogForExcManagerOnly();
                    if (aFh1wSDKAfErrorLogForExcManagerOnly != null && aFh1oSDK.getMonetizationNetwork != null) {
                        aFh1wSDKAfErrorLogForExcManagerOnly.u_(aFh1oSDK.getMonetizationNetwork, AFa1tSDK.this.getRevenue().i());
                    }
                }
                AFa1tSDK aFa1tSDK = AFa1tSDK.this;
                aFh1mSDK.getCurrencyIso4217Code = appsFlyerRequestListener;
                aFa1tSDK.getMonetizationNetwork(aFh1mSDK, aFh1oSDK);
            }
        });
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void stop(boolean z, Context context) {
        getMonetizationNetwork(new Object[]{this, Boolean.valueOf(z), context}, -62521364, 62521374, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        int i = 2 % 2;
        int i2 = AFLogger + 107;
        registerClient = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3L));
            obj.hashCode();
            throw null;
        }
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3L));
        int i3 = AFLogger + 31;
        registerClient = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j) {
        int i = 2 % 2;
        int i2 = AFLogger + 97;
        registerClient = i2 % 128;
        if (i2 % 2 != 0) {
            getRevenue().i().getRevenue = deepLinkListener;
            getRevenue().i().component3 = j;
        } else {
            getRevenue().i().getRevenue = deepLinkListener;
            getRevenue().i().component3 = j;
            int i3 = 71 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void unregisterConversionListener() {
        int i = 2 % 2;
        int i2 = registerClient + 39;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            getRevenue().copy().getMediationNetwork("unregisterConversionListener", new String[1]);
        } else {
            getRevenue().copy().getMediationNetwork("unregisterConversionListener", new String[0]);
        }
        this.getCurrencyIso4217Code = null;
        int i3 = AFLogger + 3;
        registerClient = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void updateServerUninstallToken(Context context, String str) {
        getMonetizationNetwork(context);
        AFf1bSDK aFf1bSDK = new AFf1bSDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.INSTANCE.w(AFg1cSDK.UNINSTALL, "Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.INSTANCE.i(AFg1cSDK.UNINSTALL, "Firebase Refreshed Token = ".concat(String.valueOf(str)));
        AFg1xSDK monetizationNetwork = aFf1bSDK.getMonetizationNetwork();
        if (monetizationNetwork == null || !str.equals(monetizationNetwork.AFAdRevenueData)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = monetizationNetwork == null || jCurrentTimeMillis - monetizationNetwork.getMonetizationNetwork > TimeUnit.SECONDS.toMillis(2L);
            AFg1xSDK aFg1xSDK = new AFg1xSDK(str, jCurrentTimeMillis, !z);
            aFf1bSDK.getCurrencyIso4217Code.getMediationNetwork("afUninstallToken", aFg1xSDK.AFAdRevenueData);
            aFf1bSDK.getCurrencyIso4217Code.getRevenue("afUninstallToken_received_time", aFg1xSDK.getMonetizationNetwork);
            aFf1bSDK.getCurrencyIso4217Code.getRevenue("afUninstallToken_queued", aFg1xSDK.getMediationNetwork);
            if (z) {
                AFd1zSDK revenue = getMediationNetwork().getRevenue();
                AFf1sSDK aFf1sSDK = new AFf1sSDK(str, revenue);
                AFe1qSDK aFe1qSDKEquals = revenue.equals();
                aFe1qSDKEquals.getMonetizationNetwork.execute(aFe1qSDKEquals.new AnonymousClass1(aFf1sSDK));
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String string;
        int i = 2 % 2;
        int i2 = registerClient + 7;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        AFd1lSDK aFd1lSDKCopy = getRevenue().copy();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str3;
        strArr[3] = str4;
        strArr[4] = str5;
        if (map == null) {
            string = "";
        } else {
            string = map.toString();
            int i4 = AFLogger + 37;
            registerClient = i4 % 128;
            int i5 = i4 % 2;
        }
        strArr[5] = string;
        aFd1lSDKCopy.getMediationNetwork("validateAndTrackInAppPurchase", strArr);
        if (!getRevenue().AFInAppEventParameterName().getRevenue()) {
            AFLogger.INSTANCE.i(AFg1cSDK.PURCHASE_VALIDATION, new StringBuilder("Validate in app called with parameters: ").append(str3).append(" ").append(str4).append(" ").append(str5).toString());
            int i6 = registerClient + 115;
            AFLogger = i6 % 128;
            int i7 = i6 % 2;
        }
        if (str != null && str4 != null && str2 != null && str5 != null) {
            int i8 = AFLogger + 43;
            registerClient = i8 % 128;
            int i9 = i8 % 2;
            if (str3 != null) {
                new Thread(new com.appsflyer.internal.AFa1ySDK(context.getApplicationContext(), getRevenue().AFInAppEventParameterName().getMonetizationNetwork(), str, str2, str3, str4, str5, map)).start();
                return;
            }
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = getMediationNetwork;
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            int i10 = AFLogger + 99;
            registerClient = i10 % 128;
            if (i10 % 2 != 0) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
            } else {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                int i11 = 71 / 0;
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(AFPurchaseDetails aFPurchaseDetails, Map<String, String> map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback) {
        getMonetizationNetwork(new Object[]{this, aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback}, -1225547846, 1225547850, System.identityHashCode(this));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void waitForCustomerUserId(boolean z) {
        getMonetizationNetwork(new Object[]{this, Boolean.valueOf(z)}, -680096747, 680096764, System.identityHashCode(this));
    }
}
