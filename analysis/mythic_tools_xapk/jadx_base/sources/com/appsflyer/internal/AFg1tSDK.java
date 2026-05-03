package com.appsflyer.internal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFg1ySDK;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1tSDK implements AFg1vSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char AFInAppEventType = 63402;
    private static char AFKeystoreWrapper = 61739;
    private static char AFLogger = 47673;
    private static int i = 1;
    private static char registerClient = 16862;
    private static int unregisterClient;
    private final Context AFAdRevenueData;
    private final Lazy AFInAppEventParameterName;
    private final AFc1jSDK areAllFieldsValid;
    private final AFg1uSDK component1;
    private final AFh1uSDK component2;
    private final AFc1kSDK component3;
    private final AFi1xSDK component4;
    private final AFg1zSDK copy;
    private final Lazy copydefault;
    private final AFc1gSDK equals;
    private final AFj1oSDK getCurrencyIso4217Code;
    private final AFi1lSDK getMediationNetwork;
    private final String getMonetizationNetwork;
    private final AFg1ySDK getRevenue;
    private final AFc1fSDK hashCode;
    private final AFf1kSDK toString;

    public AFg1tSDK(String str, Context context, AFi1lSDK aFi1lSDK, AFg1ySDK aFg1ySDK, AFj1oSDK aFj1oSDK, AFg1uSDK aFg1uSDK, AFh1uSDK aFh1uSDK, AFc1jSDK aFc1jSDK, AFc1kSDK aFc1kSDK, AFi1xSDK aFi1xSDK, AFf1kSDK aFf1kSDK, AFc1fSDK aFc1fSDK, AFg1zSDK aFg1zSDK, AFc1gSDK aFc1gSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFi1lSDK, "");
        Intrinsics.checkNotNullParameter(aFg1ySDK, "");
        Intrinsics.checkNotNullParameter(aFj1oSDK, "");
        Intrinsics.checkNotNullParameter(aFg1uSDK, "");
        Intrinsics.checkNotNullParameter(aFh1uSDK, "");
        Intrinsics.checkNotNullParameter(aFc1jSDK, "");
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(aFi1xSDK, "");
        Intrinsics.checkNotNullParameter(aFf1kSDK, "");
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        Intrinsics.checkNotNullParameter(aFg1zSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        this.getMonetizationNetwork = str;
        this.AFAdRevenueData = context;
        this.getMediationNetwork = aFi1lSDK;
        this.getRevenue = aFg1ySDK;
        this.getCurrencyIso4217Code = aFj1oSDK;
        this.component1 = aFg1uSDK;
        this.component2 = aFh1uSDK;
        this.areAllFieldsValid = aFc1jSDK;
        this.component3 = aFc1kSDK;
        this.component4 = aFi1xSDK;
        this.toString = aFf1kSDK;
        this.hashCode = aFc1fSDK;
        this.copy = aFg1zSDK;
        this.equals = aFc1gSDK;
        this.copydefault = LazyKt.lazy(new Function0<AppsFlyerProperties>() { // from class: com.appsflyer.internal.AFg1tSDK.3
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final AppsFlyerProperties invoke() {
                return AppsFlyerProperties.getInstance();
            }
        });
        this.AFInAppEventParameterName = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.appsflyer.internal.AFg1tSDK.4
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: merged with bridge method [inline-methods] */
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            }
        });
    }

    private static File AFAdRevenueData(String str) {
        return (File) getCurrencyIso4217Code(new Object[]{str}, -1713193942, 1713193943, (int) System.currentTimeMillis());
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        int i2 = 2 % 2;
        int i3 = unregisterClient + 49;
        i = i3 % 128;
        int i4 = i3 % 2;
        String revenue = aFg1tSDK.areAllFieldsValid.getRevenue("sentSuccessfully", (String) null);
        if (i4 != 0) {
            return Boolean.valueOf(Boolean.parseBoolean(revenue));
        }
        Boolean.parseBoolean(revenue);
        throw null;
    }

    private String AFAdRevenueData() throws NoSuchAlgorithmException, PackageManager.NameNotFoundException, CertificateException {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 75;
        i = i3 % 128;
        int i4 = i3 % 2;
        Context context = this.AFAdRevenueData;
        Object obj = null;
        if (i4 == 0) {
            AFj1pSDK.N_(context.getApplicationContext().getPackageManager(), this.AFAdRevenueData.getApplicationContext().getPackageName());
            obj.hashCode();
            throw null;
        }
        String strN_ = AFj1pSDK.N_(context.getApplicationContext().getPackageManager(), this.AFAdRevenueData.getApplicationContext().getPackageName());
        int i5 = unregisterClient + 3;
        i = i5 % 128;
        if (i5 % 2 != 0) {
            return strN_;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String AFAdRevenueData(SimpleDateFormat simpleDateFormat, int i2) {
        String revenue;
        int i3 = 2 % 2;
        int i4 = unregisterClient + 97;
        i = i4 % 128;
        if (i4 % 2 == 0) {
            Intrinsics.checkNotNullParameter(simpleDateFormat, "");
            revenue = this.areAllFieldsValid.getRevenue("appsFlyerFirstInstall", (String) null);
            int i5 = 94 / 0;
            if (revenue == null) {
                if (i2 <= 1) {
                    AFLogger.afDebugLog("AppsFlyer: first launch detected");
                    revenue = simpleDateFormat.format(new Date());
                } else {
                    int i6 = i + 109;
                    unregisterClient = i6 % 128;
                    int i7 = i6 % 2;
                    revenue = "";
                }
                this.areAllFieldsValid.getMediationNetwork("appsFlyerFirstInstall", revenue);
            }
        } else {
            Intrinsics.checkNotNullParameter(simpleDateFormat, "");
            revenue = this.areAllFieldsValid.getRevenue("appsFlyerFirstInstall", (String) null);
            if (revenue == null) {
            }
        }
        AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.GENERAL, "AppsFlyer: first launch date: " + revenue, false, 4, null);
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        return revenue;
    }

    private void AFAdRevenueData(Map<String, Object> map, String str) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        Object obj = null;
        if (getRevenue().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            int i3 = unregisterClient + Imgproc.COLOR_YUV2RGBA_YVYU;
            i = i3 % 128;
            if (i3 % 2 != 0) {
                map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                return;
            } else {
                map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                throw null;
            }
        }
        Object revenue = this.toString.getRevenue(this.areAllFieldsValid);
        String str2 = (CharSequence) revenue;
        if (str2 != null && str2.length() != 0) {
            int i4 = unregisterClient + 105;
            i = i4 % 128;
            if (i4 % 2 == 0) {
                map.put("imei", revenue);
                obj.hashCode();
                throw null;
            }
            map.put("imei", revenue);
        }
        String currencyIso4217Code = getCurrencyIso4217Code(str);
        if (currencyIso4217Code != null) {
            int i5 = unregisterClient + 71;
            i = i5 % 128;
            int i6 = i5 % 2;
            this.areAllFieldsValid.getMediationNetwork("androidIdCached", currencyIso4217Code);
            map.put("android_id", currencyIso4217Code);
        } else {
            AFLogger.afInfoLog("Android ID was not collected.");
        }
        AFb1mSDK revenue2 = AFb1jSDK.getRevenue(this.AFAdRevenueData);
        if (revenue2 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Boolean bool = revenue2.getCurrencyIso4217Code;
            Intrinsics.checkNotNullExpressionValue(bool, "");
            linkedHashMap.put("isManual", bool);
            String str3 = revenue2.getRevenue;
            Intrinsics.checkNotNullExpressionValue(str3, "");
            linkedHashMap.put("val", str3);
            Boolean bool2 = revenue2.getMonetizationNetwork;
            if (bool2 != null) {
                linkedHashMap.put("isLat", bool2);
            }
            map.put("oaid", linkedHashMap);
        }
    }

    private void AFInAppEventParameterName(Map<String, Object> map) {
        long j;
        int i2 = 2 % 2;
        int i3 = unregisterClient + 69;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            j = this.component2.equals;
            if (j == 0) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            j = this.component2.equals;
            if (j == 0) {
                return;
            }
        }
        int i4 = i + 123;
        unregisterClient = i4 % 128;
        int i5 = i4 % 2;
        map.put("prev_session_dur", Long.valueOf(j));
    }

    private void AFInAppEventType(Map<String, Object> map) {
        getCurrencyIso4217Code(new Object[]{this, map}, 381318277, -381318268, System.identityHashCode(this));
    }

    private final String AFKeystoreWrapper() {
        int i2 = 2 % 2;
        File file = (File) getCurrencyIso4217Code(new Object[]{getRevenue("ro.appsflyer.preinstall.path")}, -1713193942, 1713193943, (int) System.currentTimeMillis());
        Object obj = null;
        if (getRevenue(file)) {
            int i3 = unregisterClient + 55;
            i = i3 % 128;
            if (i3 % 2 == 0) {
                obj.hashCode();
                throw null;
            }
            file = (File) getCurrencyIso4217Code(new Object[]{getMediationNetwork("AF_PRE_INSTALL_PATH")}, -1713193942, 1713193943, (int) System.currentTimeMillis());
        }
        if (getRevenue(file)) {
            file = (File) getCurrencyIso4217Code(new Object[]{"/data/local/tmp/pre_install.appsflyer"}, -1713193942, 1713193943, (int) System.currentTimeMillis());
            int i4 = i + Imgproc.COLOR_YUV2RGBA_YVYU;
            unregisterClient = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = 3 % 3;
            }
        }
        if (getRevenue(file)) {
            file = (File) getCurrencyIso4217Code(new Object[]{"/etc/pre_install.appsflyer"}, -1713193942, 1713193943, (int) System.currentTimeMillis());
            int i6 = unregisterClient + 111;
            i = i6 % 128;
            int i7 = i6 % 2;
        }
        if (!getRevenue(file)) {
            String packageName = this.AFAdRevenueData.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            return (String) getCurrencyIso4217Code(new Object[]{file, packageName}, 1094427933, -1094427925, (int) System.currentTimeMillis());
        }
        int i8 = i + 113;
        unregisterClient = i8 % 128;
        if (i8 % 2 == 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    private void AFKeystoreWrapper(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 87;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        map.putAll(this.copy.getCurrencyIso4217Code());
        int i5 = unregisterClient + 49;
        i = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void AFLogger(Map<String, Object> map) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String strComponent1 = this.component3.component1();
        String monetizationNetwork = getMonetizationNetwork(this.areAllFieldsValid, strComponent1);
        boolean z = true;
        boolean z2 = (monetizationNetwork == null || Intrinsics.areEqual(monetizationNetwork, strComponent1)) ? false : true;
        if (monetizationNetwork != null || strComponent1 == null) {
            int i3 = i + 47;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            z = false;
        } else {
            int i5 = i + 85;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
        }
        if (!z2) {
            int i7 = i + 23;
            unregisterClient = i7 % 128;
            if (i7 % 2 != 0) {
                int i8 = 79 / 0;
                if (z) {
                    map.put("af_latestchannel", strComponent1);
                    int i9 = unregisterClient + 17;
                    i = i9 % 128;
                    if (i9 % 2 == 0) {
                        int i10 = 4 / 3;
                    }
                }
            } else if (z) {
            }
        }
        String strComponent4 = component4();
        if (strComponent4 != null) {
            int i11 = unregisterClient + 25;
            i = i11 % 128;
            int i12 = i11 % 2;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            Object lowerCase = strComponent4.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            map.put("af_installstore", lowerCase);
        }
        String strEquals = equals();
        if (strEquals != null) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "");
            Object lowerCase2 = strEquals.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
            map.put("af_preinstall_name", lowerCase2);
        }
        String strComponent2 = component2();
        if (strComponent2 != null) {
            Locale locale3 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale3, "");
            Object lowerCase3 = strComponent2.toLowerCase(locale3);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "");
            map.put("af_currentstore", lowerCase3);
        }
    }

    private static void a(String str, int i2, Object[] objArr) {
        char[] charArray;
        int i3;
        int i4 = 2 % 2;
        if (str != null) {
            int i5 = $11 + 113;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        AFk1mSDK aFk1mSDK = new AFk1mSDK();
        char[] cArr2 = new char[cArr.length];
        aFk1mSDK.getCurrencyIso4217Code = 0;
        char[] cArr3 = new char[2];
        while (aFk1mSDK.getCurrencyIso4217Code < cArr.length) {
            int i7 = $10 + 51;
            $11 = i7 % 128;
            int i8 = 58224;
            if (i7 % 2 == 0) {
                cArr3[0] = cArr[aFk1mSDK.getCurrencyIso4217Code];
                cArr3[1] = cArr[aFk1mSDK.getCurrencyIso4217Code];
                i3 = 1;
            } else {
                cArr3[0] = cArr[aFk1mSDK.getCurrencyIso4217Code];
                cArr3[1] = cArr[aFk1mSDK.getCurrencyIso4217Code + 1];
                i3 = 0;
            }
            while (i3 < 16) {
                int i9 = $10 + 31;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                char c = cArr3[1];
                char c2 = cArr3[0];
                char c3 = (char) (c - (((c2 + i8) ^ ((c2 << 4) + ((char) (((long) AFKeystoreWrapper) ^ (-8918198944764412327L))))) ^ ((c2 >>> 5) + ((char) (((long) registerClient) ^ (-8918198944764412327L))))));
                cArr3[1] = c3;
                cArr3[0] = (char) (c2 - (((c3 >>> 5) + ((char) (((long) AFLogger) ^ (-8918198944764412327L)))) ^ ((c3 + i8) ^ ((c3 << 4) + ((char) (((long) AFInAppEventType) ^ (-8918198944764412327L)))))));
                i8 -= 40503;
                i3++;
            }
            cArr2[aFk1mSDK.getCurrencyIso4217Code] = cArr3[0];
            cArr2[aFk1mSDK.getCurrencyIso4217Code + 1] = cArr3[1];
            aFk1mSDK.getCurrencyIso4217Code += 2;
        }
        String str2 = new String(cArr2, 0, i2);
        int i11 = $10 + 23;
        $11 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void afInfoLog(Map<String, Object> map) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String monetizationNetwork = this.toString.getMonetizationNetwork();
        String str = monetizationNetwork;
        if (str != null) {
            int i3 = unregisterClient + 63;
            i = i3 % 128;
            int i4 = i3 % 2;
            if (str.length() == 0) {
                int i5 = unregisterClient + 67;
                i = i5 % 128;
                int i6 = i5 % 2;
            } else {
                map.put("appsflyerKey", monetizationNetwork);
            }
        }
        int i7 = i + 97;
        unregisterClient = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 2 / 0;
        }
    }

    private static /* synthetic */ Object areAllFieldsValid(Object[] objArr) {
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        int i2 = 2 % 2;
        int i3 = unregisterClient + 81;
        i = i3 % 128;
        int i4 = i3 % 2;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) aFg1tSDK.AFInAppEventParameterName.getValue();
        if (i4 != 0) {
            return simpleDateFormat;
        }
        throw null;
    }

    private static String areAllFieldsValid() {
        int i2 = 2 % 2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        double dPow = Math.pow(2.0d, 20.0d);
        String str = ((long) (availableBlocksLong / dPow)) + DomExceptionUtils.SEPARATOR + ((long) (blockCountLong / dPow));
        int i3 = i + 3;
        unregisterClient = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 30 / 0;
        }
        return str;
    }

    private final void areAllFieldsValid(Map<String, Object> map) {
        int i2 = 2 % 2;
        if (!getRevenue().isOtherSdkStringDisabled()) {
            int i3 = i + 85;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            AFg1ySDK aFg1ySDK = this.getRevenue;
            if (i4 != 0) {
                map.put("batteryLevel", String.valueOf(aFg1ySDK.getMonetizationNetwork(this.AFAdRevenueData).getMonetizationNetwork));
                int i5 = 33 / 0;
            } else {
                map.put("batteryLevel", String.valueOf(aFg1ySDK.getMonetizationNetwork(this.AFAdRevenueData).getMonetizationNetwork));
            }
        }
        int i6 = i + 45;
        unregisterClient = i6 % 128;
        int i7 = i6 % 2;
    }

    private static long component1() {
        int i2 = 2 % 2;
        int i3 = i + 39;
        unregisterClient = i3 % 128;
        return i3 % 2 != 0 ? System.currentTimeMillis() + SystemClock.elapsedRealtime() : System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private static /* synthetic */ Object component1(Object[] objArr) {
        Map map = (Map) objArr[0];
        int i2 = 2 % 2;
        int i3 = i + 119;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        try {
            map.put("lang", Locale.getDefault().getDisplayLanguage());
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting display language name. ", e);
        }
        try {
            map.put("lang_code", Locale.getDefault().getLanguage());
            int i5 = i + 69;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e2) {
            AFLogger.afErrorLog("Exception while collecting display language code. ", e2);
        }
        try {
            map.put("country", Locale.getDefault().getCountry());
            int i7 = i + 7;
            unregisterClient = i7 % 128;
            if (i7 % 2 != 0) {
                int i8 = 67 / 0;
            }
            return null;
        } catch (Exception e3) {
            AFLogger.afErrorLog("Exception while collecting country name. ", e3);
            return null;
        }
    }

    private static void component1(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 41;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        Object[] objArr = new Object[1];
        a("\uf08a兙黴ꥱ蟩䓗", Color.blue(0) + 5, objArr);
        map.put(((String) objArr[0]).intern(), Build.BRAND);
        map.put(AndroidContextPlugin.DEVICE_KEY, Build.DEVICE);
        map.put("product", Build.PRODUCT);
        map.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        map.put(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL);
        map.put("deviceType", Build.TYPE);
        int i5 = i + 85;
        unregisterClient = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r8 = 33 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        r1 = new java.util.Properties();
        r4 = new java.io.InputStreamReader(new java.io.FileInputStream(r2), java.nio.charset.Charset.defaultCharset());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        r1.load(r4);
        com.appsflyer.AFLogger.afInfoLog("Found PreInstall property!");
        r8 = r1.getProperty(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        com.appsflyer.AFLogger.afErrorLog(r8.getMessage(), r8);
        r4 = r4;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (r4 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
    
        r4.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        com.appsflyer.AFLogger.afErrorLog(r8.getMessage(), r8);
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        com.appsflyer.AFLogger.afDebugLog("PreInstall file wasn't found: " + r2.getAbsolutePath());
        r4 = r4;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        if (r4 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
    
        if (r4 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:
    
        r0 = com.appsflyer.internal.AFg1tSDK.i + 69;
        com.appsflyer.internal.AFg1tSDK.unregisterClient = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
    
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
    
        if (r2 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        r5 = r5 + 5;
        r8 = r5 % 128;
        com.appsflyer.internal.AFg1tSDK.i = r8;
        r5 = r5 % 2;
        r8 = r8 + 11;
        com.appsflyer.internal.AFg1tSDK.unregisterClient = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if ((r8 % 2) == 0) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074 A[EXC_TOP_SPLITTER, PHI: r4
      0x0074: PHI (r4v10 java.io.InputStreamReader) = (r4v18 java.io.InputStreamReader), (r4v19 java.io.InputStreamReader) binds: [B:24:0x0072, B:31:0x0096] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ Object component2(Object[] objArr) {
        File file = (File) objArr[0];
        String str = (String) objArr[1];
        int i2 = 2 % 2;
        int i3 = i + 43;
        int i4 = i3 % 128;
        unregisterClient = i4;
        int i5 = i3 % 2;
        ?? r4 = i5;
        if (i5 != 0) {
            r4 = 89 / 0;
        }
    }

    private String component2() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 63;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            String string = getRevenue().getString(AppsFlyerProperties.AF_STORE_FROM_API);
            int i4 = 42 / 0;
            if (string != null) {
                return string;
            }
        } else {
            String string2 = getRevenue().getString(AppsFlyerProperties.AF_STORE_FROM_API);
            if (string2 != null) {
                return string2;
            }
        }
        String mediationNetwork = getMediationNetwork("AF_STORE");
        int i5 = i + 73;
        unregisterClient = i5 % 128;
        int i6 = i5 % 2;
        return mediationNetwork;
    }

    private void component2(Map<String, ? extends Object> map) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        AFh1uSDK aFh1uSDK = this.component2;
        HashMap map2 = new HashMap(aFh1uSDK.getRevenue);
        aFh1uSDK.getRevenue.clear();
        aFh1uSDK.AFAdRevenueData.getCurrencyIso4217Code("gcd");
        Intrinsics.checkNotNullExpressionValue(map2, "");
        if (!map2.isEmpty()) {
            int i3 = unregisterClient + 65;
            i = i3 % 128;
            if (i3 % 2 != 0) {
                Map<String, Object> monetizationNetwork = AFa1tSDK.getMonetizationNetwork(map);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                monetizationNetwork.put("gcd", map2);
            }
        }
        int i4 = i + 3;
        unregisterClient = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component3(Object[] objArr) {
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        Map map = (Map) objArr[1];
        int i2 = 2 % 2;
        int i3 = unregisterClient + 93;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("is_pc", Boolean.valueOf(aFg1tSDK.AFAdRevenueData.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("is_pc", Boolean.valueOf(aFg1tSDK.AFAdRevenueData.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
        int i4 = i + 33;
        unregisterClient = i4 % 128;
        int i5 = i4 % 2;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[PHI: r1 r5
      0x0043: PHI (r1v6 java.lang.String) = (r1v5 java.lang.String), (r1v11 java.lang.String) binds: [B:8:0x0041, B:5:0x002b] A[DONT_GENERATE, DONT_INLINE]
      0x0043: PHI (r5v3 java.lang.String) = (r5v2 java.lang.String), (r5v6 java.lang.String) binds: [B:8:0x0041, B:5:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void component3(Map<String, Object> map) {
        String string;
        String string2;
        int i2 = 2 % 2;
        int i3 = i + 59;
        unregisterClient = i3 % 128;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            string = getRevenue().getString(AppsFlyerProperties.ONELINK_ID);
            string2 = getRevenue().getString(AppsFlyerProperties.ONELINK_VERSION);
            int i4 = 79 / 0;
            if (string != null) {
                map.put("onelink_id", string);
                int i5 = i + 119;
                unregisterClient = i5 % 128;
                int i6 = i5 % 2;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            string = getRevenue().getString(AppsFlyerProperties.ONELINK_ID);
            string2 = getRevenue().getString(AppsFlyerProperties.ONELINK_VERSION);
            if (string != null) {
            }
        }
        if (string2 != null) {
            map.put("onelink_ver", string2);
        }
    }

    private boolean component3() {
        return ((Boolean) getCurrencyIso4217Code(new Object[]{this}, 1014234818, -1014234818, System.identityHashCode(this))).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ Object component4(Object[] objArr) {
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        Map map = (Map) objArr[1];
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String string = aFg1tSDK.getRevenue().getString(AppsFlyerProperties.EXTENSION);
        String str = string;
        if (str != null) {
            int i3 = unregisterClient + 43;
            i = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 14 / 0;
                if (str.length() != 0) {
                    int i5 = i + 99;
                    unregisterClient = i5 % 128;
                    int i6 = i5 % 2;
                    map.put(AppsFlyerProperties.EXTENSION, string);
                }
            } else if (str.length() != 0) {
            }
        }
        int i7 = unregisterClient + 1;
        i = i7 % 128;
        Object obj = null;
        if (i7 % 2 != 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    private String component4() {
        int i2 = 2 % 2;
        int i3 = i + 37;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        AFc1jSDK aFc1jSDK = this.areAllFieldsValid;
        if (i4 != 0) {
            aFc1jSDK.getRevenue("INSTALL_STORE", (String) null);
            throw null;
        }
        String revenue = aFc1jSDK.getRevenue("INSTALL_STORE", (String) null);
        if (revenue != null) {
            int i5 = i + 93;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
            return revenue;
        }
        String strComponent2 = component2();
        if (strComponent2 != null) {
            this.areAllFieldsValid.getMediationNetwork("INSTALL_STORE", strComponent2);
        }
        return strComponent2;
    }

    private final void component4(Map<String, Object> map) {
        int i2 = 2 % 2;
        AFg1ySDK.AFa1tSDK monetizationNetwork = this.getRevenue.getMonetizationNetwork(this.AFAdRevenueData);
        float f = monetizationNetwork.getMonetizationNetwork;
        String str = monetizationNetwork.AFAdRevenueData;
        map.put("btl", String.valueOf(f));
        if (str != null) {
            int i3 = unregisterClient + 1;
            i = i3 % 128;
            int i4 = i3 % 2;
            map.put("btch", str);
        }
        int i5 = i + 91;
        unregisterClient = i5 % 128;
        if (i5 % 2 != 0) {
            throw null;
        }
    }

    private static List<AFe1lSDK> copy() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 115;
        i = i3 % 128;
        int i4 = i3 % 2;
        List<AFe1lSDK> listListOf = CollectionsKt.listOf((Object[]) new AFe1lSDK[]{AFe1lSDK.CONVERSION, AFe1lSDK.LAUNCH, AFe1lSDK.INAPP, AFe1lSDK.MANUAL_PURCHASE_VALIDATION, AFe1lSDK.ARS_VALIDATE, AFe1lSDK.PURCHASE_VALIDATE, AFe1lSDK.ADREVENUE});
        int i5 = i + 19;
        unregisterClient = i5 % 128;
        if (i5 % 2 == 0) {
            return listListOf;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final void copy(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 93;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        AFc1gSDK aFc1gSDK = this.equals;
        Object obj = null;
        if (i4 != 0) {
            String str = aFc1gSDK.hashCode;
            obj.hashCode();
            throw null;
        }
        String str2 = aFc1gSDK.hashCode;
        if (str2 != null) {
            int i5 = unregisterClient + 15;
            i = i5 % 128;
            if (i5 % 2 != 0) {
                map.put("net_token", str2);
            } else {
                map.put("net_token", str2);
                obj.hashCode();
                throw null;
            }
        }
    }

    private final String copydefault() {
        return (String) getCurrencyIso4217Code(new Object[]{this}, -1753918154, 1753918160, System.identityHashCode(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void copydefault(Map<String, Object> map) {
        long mediationNetwork;
        long jCurrentTimeMillis;
        long seconds;
        int i2 = 2 % 2;
        int i3 = unregisterClient + 63;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            mediationNetwork = this.areAllFieldsValid.getMediationNetwork("AppsFlyerTimePassedSincePrevLaunch", 0L);
            jCurrentTimeMillis = System.currentTimeMillis();
            this.areAllFieldsValid.getRevenue("AppsFlyerTimePassedSincePrevLaunch", jCurrentTimeMillis);
            if (mediationNetwork > 1) {
                int i4 = unregisterClient + 1;
                i = i4 % 128;
                seconds = i4 % 2 != 0 ? TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis ^ mediationNetwork) : TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis - mediationNetwork);
            } else {
                seconds = -1;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            mediationNetwork = this.areAllFieldsValid.getMediationNetwork("AppsFlyerTimePassedSincePrevLaunch", 0L);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.areAllFieldsValid.getRevenue("AppsFlyerTimePassedSincePrevLaunch", jCurrentTimeMillis2);
            if (mediationNetwork > 0) {
                jCurrentTimeMillis = jCurrentTimeMillis2;
                int i42 = unregisterClient + 1;
                i = i42 % 128;
                if (i42 % 2 != 0) {
                }
            }
            seconds = -1;
        }
        map.put("timepassedsincelastlaunch", String.valueOf(seconds));
    }

    private static void d(Map<String, Object> map) {
        getCurrencyIso4217Code(new Object[]{map}, -1939346047, 1939346058, (int) System.currentTimeMillis());
    }

    private void e(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 19;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        boolean revenue = AFf1bSDK.getRevenue(this.AFAdRevenueData);
        AFLogger.afDebugLog("didConfigureTokenRefreshService=" + revenue);
        if (!revenue) {
            int i5 = i + 29;
            unregisterClient = i5 % 128;
            if (i5 % 2 != 0) {
                map.put("tokenRefreshConfigured", Boolean.FALSE);
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            map.put("tokenRefreshConfigured", Boolean.FALSE);
        }
        map.put("registeredUninstall", Boolean.valueOf(AFf1bSDK.getMonetizationNetwork(this.areAllFieldsValid)));
        int i6 = i + 81;
        unregisterClient = i6 % 128;
        if (i6 % 2 != 0) {
            int i7 = 71 / 0;
        }
    }

    private String equals() {
        int i2 = 2 % 2;
        int i3 = i + 9;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        String string = getRevenue().getString("preInstallName");
        if (string != null) {
            return string;
        }
        String revenue = this.areAllFieldsValid.getRevenue("preInstallName", (String) null);
        if (revenue == null) {
            String strAFKeystoreWrapper = AFKeystoreWrapper();
            if (strAFKeystoreWrapper == null) {
                strAFKeystoreWrapper = getMediationNetwork("AF_PRE_INSTALL_NAME");
            }
            if (strAFKeystoreWrapper != null) {
                this.areAllFieldsValid.getMediationNetwork("preInstallName", strAFKeystoreWrapper);
                getRevenue().set("preInstallName", strAFKeystoreWrapper);
            }
            return strAFKeystoreWrapper;
        }
        int i5 = unregisterClient + 43;
        i = i5 % 128;
        int i6 = i5 % 2;
        getRevenue().set("preInstallName", revenue);
        int i7 = unregisterClient + 21;
        i = i7 % 128;
        int i8 = i7 % 2;
        return revenue;
    }

    private void equals(Map<String, Object> map) {
        getCurrencyIso4217Code(new Object[]{this, map}, -2036410656, 2036410668, System.identityHashCode(this));
    }

    private void force(Map<String, Object> map) {
        String currencyIso4217Code;
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        if (getRevenue().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
            int i3 = unregisterClient + 105;
            i = i3 % 128;
            int i4 = i3 % 2;
            Object obj = null;
            try {
                this.AFAdRevenueData.getPackageManager().getApplicationInfo(RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE, 0);
                currencyIso4217Code = this.component3.getCurrencyIso4217Code(this.AFAdRevenueData);
                int i5 = i + 113;
                unregisterClient = i5 % 128;
                int i6 = i5 % 2;
            } catch (Throwable unused) {
                currencyIso4217Code = null;
            }
            if (currencyIso4217Code != null) {
                int i7 = i + 99;
                unregisterClient = i7 % 128;
                if (i7 % 2 == 0) {
                    map.put("fb", currencyIso4217Code);
                } else {
                    map.put("fb", currencyIso4217Code);
                    obj.hashCode();
                    throw null;
                }
            }
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        String str = (String) objArr[0];
        int i2 = 2 % 2;
        int i3 = i;
        int i4 = i3 + 105;
        unregisterClient = i4 % 128;
        try {
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        if (i4 % 2 != 0) {
            throw null;
        }
        if (str != null) {
            int i5 = i3 + 23;
            unregisterClient = i5 % 128;
            if (i5 % 2 != 0) {
                StringsKt.trim((CharSequence) str).toString().length();
                throw null;
            }
            if (StringsKt.trim((CharSequence) str).toString().length() > 0) {
                return new File(StringsKt.trim((CharSequence) str).toString());
            }
        }
        return null;
    }

    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr, int i2, int i3, int i4) {
        int i5 = (i2 * (-300)) + (i3 * 302) + ((~(i2 | i3 | i4)) * (-301));
        int i6 = ~i3;
        switch (i5 + (((~(i6 | i4)) | (~((~i4) | i2))) * (-301)) + (((~((~i2) | i4)) | i6) * 301)) {
            case 1:
                return getCurrencyIso4217Code(objArr);
            case 2:
                Map map = (Map) objArr[0];
                AFh1sSDK aFh1sSDK = (AFh1sSDK) objArr[1];
                Intrinsics.checkNotNullParameter(map, "");
                Intrinsics.checkNotNullParameter(aFh1sSDK, "");
                String str = aFh1sSDK.areAllFieldsValid;
                if (str != null) {
                    map.put("eventName", str);
                    map.put("eventValue", new JSONObject(aFh1sSDK.getMediationNetwork == null ? new HashMap() : aFh1sSDK.getMediationNetwork).toString());
                }
                return null;
            case 3:
                return getMediationNetwork(objArr);
            case 4:
                AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
                Map map2 = (Map) objArr[1];
                int i7 = 2 % 2;
                int i8 = unregisterClient + 33;
                i = i8 % 128;
                int i9 = i8 % 2;
                Intrinsics.checkNotNullParameter(map2, "");
                String currencyIso4217Code = AFb1iSDK.getCurrencyIso4217Code(aFg1tSDK.component3.getCurrencyIso4217Code);
                if (currencyIso4217Code != null) {
                    map2.put("uid", currencyIso4217Code);
                    Boolean boolValueOf = Boolean.valueOf(aFg1tSDK.component3.getCurrencyIso4217Code.getRevenue("CUSTOM_INSTALL_ID_APPLIED"));
                    Intrinsics.checkNotNullExpressionValue(boolValueOf, "");
                    if (boolValueOf.booleanValue()) {
                        map2.put("custom_install_id", Boolean.TRUE);
                        int i10 = i + 9;
                        unregisterClient = i10 % 128;
                        int i11 = i10 % 2;
                    }
                }
                return null;
            case 5:
                return getMonetizationNetwork(objArr);
            case 6:
                return getRevenue(objArr);
            case 7:
                return areAllFieldsValid(objArr);
            case 8:
                return component2(objArr);
            case 9:
                return component4(objArr);
            case 10:
                AFg1tSDK aFg1tSDK2 = (AFg1tSDK) objArr[0];
                Map map3 = (Map) objArr[1];
                String str2 = (String) objArr[2];
                int i12 = 2 % 2;
                Intrinsics.checkNotNullParameter(map3, "");
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    int i13 = i + 95;
                    unregisterClient = i13 % 128;
                    int i14 = i13 % 2;
                    map3.put("referrer", str2);
                }
                String revenue = aFg1tSDK2.areAllFieldsValid.getRevenue("extraReferrers", (String) null);
                if (revenue != null) {
                    map3.put("extraReferrers", revenue);
                }
                String referrer = aFg1tSDK2.getRevenue().getReferrer(aFg1tSDK2.areAllFieldsValid);
                String str4 = referrer;
                if (str4 != null && str4.length() != 0 && map3.get("referrer") == null) {
                    map3.put("referrer", referrer);
                }
                int i15 = i + 43;
                unregisterClient = i15 % 128;
                int i16 = i15 % 2;
                return null;
            case 11:
                return component1(objArr);
            case 12:
                return component3(objArr);
            default:
                return AFAdRevenueData(objArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r1 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r4.length() == 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[PHI: r4
      0x002a: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v8 java.lang.String) binds: [B:10:0x0028, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getCurrencyIso4217Code(String str) {
        String str2;
        int i2;
        int i3 = 2 % 2;
        if (getRevenue().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, false)) {
            int i4 = i;
            int i5 = i4 + 125;
            unregisterClient = i5 % 128;
            if (i5 % 2 == 0) {
                str2 = str;
                if (str2 != null) {
                }
                i2 = i + Imgproc.COLOR_YUV2RGBA_YVYU;
                unregisterClient = i2 % 128;
                if (i2 % 2 == 0) {
                }
                String str3 = (String) getCurrencyIso4217Code(new Object[]{this}, -1753918154, 1753918160, System.identityHashCode(this));
                int i6 = i + 63;
                unregisterClient = i6 % 128;
                int i7 = i6 % 2;
                return str3;
            }
            str2 = str;
            int i8 = 86 / 0;
            if (str2 != null) {
                int i9 = i4 + 51;
                unregisterClient = i9 % 128;
                if (i9 % 2 != 0) {
                    int length = str2.length();
                    int i10 = 56 / 0;
                }
            }
            i2 = i + Imgproc.COLOR_YUV2RGBA_YVYU;
            unregisterClient = i2 % 128;
            if (i2 % 2 == 0) {
                int i11 = 96 / 0;
                if (!registerClient()) {
                    return null;
                }
            } else if (!registerClient()) {
                return null;
            }
            String str32 = (String) getCurrencyIso4217Code(new Object[]{this}, -1753918154, 1753918160, System.identityHashCode(this));
            int i62 = i + 63;
            unregisterClient = i62 % 128;
            int i72 = i62 % 2;
            return str32;
        }
        if (str != null) {
            return str;
        }
        return null;
    }

    private void getCurrencyIso4217Code(Map<String, Object> map, String str) {
        getCurrencyIso4217Code(new Object[]{this, map, str}, 2080605436, -2080605426, System.identityHashCode(this));
    }

    private Long getMediationNetwork() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 73;
        i = i3 % 128;
        int i4 = i3 % 2;
        PackageInfo packageInfoN_ = this.component3.n_();
        if (i4 != 0) {
            return Long.valueOf(packageInfoN_.firstInstallTime);
        }
        Long.valueOf(packageInfoN_.firstInstallTime);
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        Map map = (Map) objArr[0];
        int i2 = 2 % 2;
        int i3 = unregisterClient + 9;
        i = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        AFa1zSDK aFa1zSDK = AFa1zSDK.INSTANCE;
        String revenue = AFa1zSDK.getRevenue();
        AFa1zSDK aFa1zSDK2 = AFa1zSDK.INSTANCE;
        String currencyIso4217Code = AFa1zSDK.getCurrencyIso4217Code();
        Object obj = null;
        if (revenue != null) {
            int i5 = i;
            int i6 = i5 + 101;
            unregisterClient = i6 % 128;
            if (i6 % 2 != 0) {
                obj.hashCode();
                throw null;
            }
            if (currencyIso4217Code != null) {
                int i7 = i5 + 101;
                unregisterClient = i7 % 128;
                if (i7 % 2 != 0) {
                    Integer.parseInt(currencyIso4217Code);
                    throw null;
                }
                if (Integer.parseInt(currencyIso4217Code) > 0) {
                    map.put("reinstallCounter", currencyIso4217Code);
                    map.put("originalAppsflyerId", revenue);
                }
            }
        }
        return null;
    }

    private static String getMediationNetwork(File file, String str) {
        return (String) getCurrencyIso4217Code(new Object[]{file, str}, 1094427933, -1094427925, (int) System.currentTimeMillis());
    }

    private final String getMediationNetwork(String str) {
        int i2 = 2 % 2;
        int i3 = i + 53;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        String monetizationNetwork = this.component3.getMonetizationNetwork(str);
        int i5 = unregisterClient + 33;
        i = i5 % 128;
        int i6 = i5 % 2;
        return monetizationNetwork;
    }

    private void getMediationNetwork(Map<String, Object> map, boolean z) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("platformextension", this.getMonetizationNetwork);
        if (z) {
            int i3 = i + 75;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            AFi1lSDK aFi1lSDK = this.getMediationNetwork;
            if (i4 != 0) {
                map.put("platform_extension_v2", aFi1lSDK.getRevenue());
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            map.put("platform_extension_v2", aFi1lSDK.getRevenue());
        }
        int i5 = unregisterClient + 93;
        i = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 23 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        boolean z = false;
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        Map map = (Map) objArr[1];
        int iIntValue = ((Number) objArr[2]).intValue();
        int iIntValue2 = ((Number) objArr[3]).intValue();
        int i2 = 2 % 2;
        int i3 = i + 9;
        unregisterClient = i3 % 128;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("counter", String.valueOf(iIntValue));
            map.put("iaecounter", String.valueOf(iIntValue2));
            boolean zComponent3 = aFg1tSDK.component3();
            int i4 = 12 / 0;
            if (zComponent3) {
                int i5 = i + 109;
                unregisterClient = i5 % 128;
                int i6 = i5 % 2;
            } else {
                z = true;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("counter", String.valueOf(iIntValue));
            map.put("iaecounter", String.valueOf(iIntValue2));
            if (!aFg1tSDK.component3()) {
            }
        }
        map.put("isFirstCall", String.valueOf(z));
        return null;
    }

    private static String getMonetizationNetwork(AFc1jSDK aFc1jSDK, String str) {
        int i2 = 2 % 2;
        int i3 = i + 113;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        String revenue = aFc1jSDK.getRevenue("CACHED_CHANNEL", (String) null);
        if (revenue == null) {
            aFc1jSDK.getMediationNetwork("CACHED_CHANNEL", str);
            return str;
        }
        int i5 = i + 71;
        unregisterClient = i5 % 128;
        int i6 = i5 % 2;
        return revenue;
    }

    private final SimpleDateFormat getMonetizationNetwork() {
        return (SimpleDateFormat) getCurrencyIso4217Code(new Object[]{this}, 1763970142, -1763970135, System.identityHashCode(this));
    }

    private void getMonetizationNetwork(AFh1sSDK aFh1sSDK, String str, String str2, AFb1qSDK aFb1qSDK) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + Imgproc.COLOR_YUV2RGB_YVYU;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(aFh1sSDK, "");
            Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
            aFh1sSDK.getRevenue();
            AFe1lSDK aFe1lSDK = AFe1lSDK.CONVERSION;
            throw null;
        }
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        Map<String, Object> map2 = aFh1sSDK.AFAdRevenueData;
        if (aFh1sSDK.getRevenue() == AFe1lSDK.CONVERSION) {
            Intrinsics.checkNotNullExpressionValue(map2, "");
            areAllFieldsValid(map2);
            hashCode(map2);
            toString(map2);
            AFa1zSDK.getCurrencyIso4217Code(this.hashCode, this.component3);
        }
        Intrinsics.checkNotNullExpressionValue(map2, "");
        copydefault(map2);
        component3(map2);
        component2((Map<String, ? extends Object>) map2);
        getMonetizationNetwork(map2, str2);
        getCurrencyIso4217Code(new Object[]{this, map2, str}, 2080605436, -2080605426, System.identityHashCode(this));
        AFInAppEventParameterName(map2);
        if (aFb1qSDK != null) {
            int i4 = unregisterClient + 15;
            i = i4 % 128;
            int i5 = i4 % 2;
            aFb1qSDK.AFAdRevenueData(map2);
        }
    }

    private final void getMonetizationNetwork(Map<String, Object> map) {
        int i2 = 2 % 2;
        try {
            long jLongValue = getMediationNetwork().longValue();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            map.put("installDate", simpleDateFormat.format(new Date(jLongValue)));
            int i3 = i + 95;
            unregisterClient = i3 % 128;
            if (i3 % 2 != 0) {
                throw null;
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting install date. ", e);
        }
    }

    private static void getMonetizationNetwork(Map<String, Object> map, AFh1sSDK aFh1sSDK) {
        getCurrencyIso4217Code(new Object[]{map, aFh1sSDK}, 840096267, -840096265, (int) System.currentTimeMillis());
    }

    private static void getMonetizationNetwork(Map<String, Object> map, String str) {
        int i2 = 2 % 2;
        int i3 = i + 59;
        unregisterClient = i3 % 128;
        Object obj = null;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            obj.hashCode();
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        if (str != null) {
            int i4 = i + 19;
            unregisterClient = i4 % 128;
            if (i4 % 2 != 0) {
                map.put("phone", str);
                obj.hashCode();
                throw null;
            }
            map.put("phone", str);
        }
        int i5 = unregisterClient + 57;
        i = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 4 / 0;
        }
    }

    private final AppsFlyerProperties getRevenue() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 63;
        i = i3 % 128;
        int i4 = i3 % 2;
        AppsFlyerProperties appsFlyerProperties = (AppsFlyerProperties) this.copydefault.getValue();
        int i5 = unregisterClient + 13;
        i = i5 % 128;
        int i6 = i5 % 2;
        return appsFlyerProperties;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFg1tSDK aFg1tSDK = (AFg1tSDK) objArr[0];
        int i2 = 2 % 2;
        String revenue = aFg1tSDK.areAllFieldsValid.getRevenue("androidIdCached", (String) null);
        try {
            String string = Settings.Secure.getString(aFg1tSDK.AFAdRevenueData.getContentResolver(), "android_id");
            if (string != null) {
                return string;
            }
        } catch (Exception e) {
            AFLogger.afErrorLog(e.getMessage(), e);
        }
        if (revenue != null) {
            AFLogger.afDebugLog("use cached AndroidId: " + revenue);
            int i3 = i + 101;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            return revenue;
        }
        int i5 = unregisterClient + 125;
        i = i5 % 128;
        if (i5 % 2 != 0) {
            return null;
        }
        throw null;
    }

    private static String getRevenue(String str) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 91;
        i = i3 % 128;
        int i4 = i3 % 2;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            Intrinsics.checkNotNull(objInvoke, "");
            String str2 = (String) objInvoke;
            int i5 = unregisterClient + 31;
            i = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = 57 / 0;
            }
            return str2;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    private final void getRevenue(Map<String, Object> map, int i2) {
        int i3 = 2 % 2;
        int i4 = i + 71;
        unregisterClient = i4 % 128;
        int i5 = i4 % 2;
        try {
            if (this.component3.n_().versionCode > this.areAllFieldsValid.getCurrencyIso4217Code("versionCode", 0)) {
                this.areAllFieldsValid.AFAdRevenueData("versionCode", this.component3.n_().versionCode);
                int i6 = unregisterClient + 63;
                i = i6 % 128;
                int i7 = i6 % 2;
            }
            map.put("app_version_code", String.valueOf(this.component3.n_().versionCode));
            map.put("app_version_name", this.component3.n_().versionName);
            map.put("targetSDKver", Integer.valueOf(this.component3.getRevenue.getCurrencyIso4217Code.getApplicationInfo().targetSdkVersion));
            map.put("date1", ((SimpleDateFormat) getCurrencyIso4217Code(new Object[]{this}, 1763970142, -1763970135, System.identityHashCode(this))).format(new Date(getMediationNetwork().longValue())));
            map.put("date2", ((SimpleDateFormat) getCurrencyIso4217Code(new Object[]{this}, 1763970142, -1763970135, System.identityHashCode(this))).format(new Date(this.component3.n_().lastUpdateTime)));
            Object[] objArr = new Object[1];
            a("맜㰣䟶抶⊃瘜던몔ꃴ説둻䚈䠷虙\uf39b×", KeyEvent.keyCodeFromString("") + 15, objArr);
            String strIntern = ((String) objArr[0]).intern();
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getCurrencyIso4217Code(new Object[]{this}, 1763970142, -1763970135, System.identityHashCode(this));
            Intrinsics.checkNotNullExpressionValue(simpleDateFormat, "");
            map.put(strIntern, AFAdRevenueData(simpleDateFormat, i2));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting app version data ", th, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: Exception -> 0x0074, PHI: r1
      0x0038: PHI (r1v6 java.lang.String) = (r1v5 java.lang.String), (r1v10 java.lang.String) binds: [B:14:0x0036, B:8:0x0025] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x0074, blocks: (B:5:0x001b, B:7:0x0023, B:17:0x0059, B:15:0x0038, B:13:0x0030), top: B:27:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getRevenue(Map<String, Object> map, String str) {
        String revenue;
        int i2 = 2 % 2;
        int i3 = i + 119;
        unregisterClient = i3 % 128;
        try {
            if (i3 % 2 != 0) {
                Intrinsics.checkNotNullParameter(map, "");
                Intrinsics.checkNotNullParameter(str, "");
                revenue = this.areAllFieldsValid.getRevenue("prev_event_name", (String) null);
                int i4 = 19 / 0;
                if (revenue != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("prev_event_timestamp", this.areAllFieldsValid.getMediationNetwork("prev_event_timestamp", -1L));
                    jSONObject.put("prev_event_name", revenue);
                    map.put("prev_event", jSONObject);
                    int i5 = unregisterClient + 51;
                    i = i5 % 128;
                    int i6 = i5 % 2;
                }
            } else {
                Intrinsics.checkNotNullParameter(map, "");
                Intrinsics.checkNotNullParameter(str, "");
                revenue = this.areAllFieldsValid.getRevenue("prev_event_name", (String) null);
                if (revenue != null) {
                }
            }
            this.areAllFieldsValid.getMediationNetwork("prev_event_name", str);
            this.areAllFieldsValid.getRevenue("prev_event_timestamp", System.currentTimeMillis());
            int i7 = unregisterClient + 15;
            i = i7 % 128;
            if (i7 % 2 == 0) {
                throw null;
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("Error while processing previous event.", e);
        }
    }

    private void getRevenue(Map<String, Object> map, boolean z) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        HashMap map2 = new HashMap();
        map2.put("cpu_abi", getRevenue("ro.product.cpu.abi"));
        map2.put("cpu_abi2", getRevenue("ro.product.cpu.abi2"));
        map2.put("arch", getRevenue("os.arch"));
        map2.put("build_display_id", getRevenue("ro.build.display.id"));
        if (z) {
            int i3 = unregisterClient + 125;
            i = i3 % 128;
            int i4 = i3 % 2;
            component4(map2);
            if (this.component3.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) <= 2) {
                int i5 = unregisterClient + 111;
                i = i5 % 128;
                int i6 = i5 % 2;
                AFj1oSDK aFj1oSDK = this.getCurrencyIso4217Code;
                if (i6 == 0) {
                    map2.putAll(aFj1oSDK.AFAdRevenueData());
                    int i7 = 75 / 0;
                } else {
                    map2.putAll(aFj1oSDK.AFAdRevenueData());
                }
                int i8 = unregisterClient + 15;
                i = i8 % 128;
                int i9 = i8 % 2;
            }
        }
        map2.put("dim", this.component1.getMonetizationNetwork(this.AFAdRevenueData));
        map.put("deviceData", map2);
        int i10 = i + 83;
        unregisterClient = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    private static boolean getRevenue(File file) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 113;
        i = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
        if (file != null && file.exists()) {
            return false;
        }
        int i4 = unregisterClient + 35;
        i = i4 % 128;
        int i5 = i4 % 2;
        return true;
    }

    private final void hashCode(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 9;
        i = i3 % 128;
        int i4 = i3 % 2;
        Context context = this.AFAdRevenueData;
        if (i4 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService(UiModeManager.class);
        if (uiModeManager != null) {
            int i5 = unregisterClient + 115;
            i = i5 % 128;
            if (i5 % 2 != 0 ? uiModeManager.getCurrentModeType() == 4 : uiModeManager.getCurrentModeType() == 2) {
                map.put("tv", Boolean.TRUE);
            }
        }
        int i6 = unregisterClient + 29;
        i = i6 % 128;
        if (i6 % 2 == 0) {
            int i7 = 98 / 0;
        }
    }

    private void i(Map<String, Object> map) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        AFb1mSDK aFb1mSDKL_ = AFb1jSDK.l_(this.AFAdRevenueData.getContentResolver());
        if (aFb1mSDKL_ != null) {
            int i3 = i + 83;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            map.put("amazon_aid", aFb1mSDKL_.getRevenue);
            map.put("amazon_aid_limit", String.valueOf(aFb1mSDKL_.getMonetizationNetwork));
            int i5 = i + 71;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private static void registerClient(Map<String, Object> map) {
        getCurrencyIso4217Code(new Object[]{map}, -1435534787, 1435534790, (int) System.currentTimeMillis());
    }

    private final boolean registerClient() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 107;
        i = i3 % 128;
        int i4 = i3 % 2;
        if (getRevenue().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) {
            return true;
        }
        int i5 = unregisterClient + 69;
        i = i5 % 128;
        int i6 = i5 % 2;
        if (getRevenue().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
            return true;
        }
        AFa1tSDK.getMediationNetwork();
        return !AFa1tSDK.getRevenue(this.AFAdRevenueData);
    }

    private final void toString(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 13;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Context context = this.AFAdRevenueData;
        Object obj = null;
        if (i4 != 0) {
            AFg1pSDK.getCurrencyIso4217Code(context);
            obj.hashCode();
            throw null;
        }
        if (AFg1pSDK.getCurrencyIso4217Code(context)) {
            map.put("inst_app", Boolean.TRUE);
        }
        int i5 = i + 1;
        unregisterClient = i5 % 128;
        if (i5 % 2 == 0) {
            return;
        }
        obj.hashCode();
        throw null;
    }

    private void unregisterClient(Map<String, Object> map) {
        int i2 = 2 % 2;
        int i3 = i + 3;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("af_preinstalled", String.valueOf(this.component3.getMonetizationNetwork(this.AFAdRevenueData)));
        int i5 = i + 123;
        unregisterClient = i5 % 128;
        int i6 = i5 % 2;
    }

    private void w(Map<String, Object> map) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        if (this.areAllFieldsValid.getMonetizationNetwork("is_stop_tracking_used")) {
            int i3 = unregisterClient + 19;
            i = i3 % 128;
            int i4 = i3 % 2;
            AFc1jSDK aFc1jSDK = this.areAllFieldsValid;
            if (i4 == 0) {
                map.put("istu", String.valueOf(aFc1jSDK.getRevenue("is_stop_tracking_used")));
                int i5 = 47 / 0;
            } else {
                map.put("istu", String.valueOf(aFc1jSDK.getRevenue("is_stop_tracking_used")));
            }
        }
        int i6 = i + 15;
        unregisterClient = i6 % 128;
        int i7 = i6 % 2;
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void AFAdRevenueData(AFh1sSDK aFh1sSDK) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 1;
        i = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("open_referrer", aFh1sSDK.getMonetizationNetwork);
        String str = aFh1sSDK.equals;
        if (str != null) {
            int i5 = i + 109;
            unregisterClient = i5 % 128;
            if (i5 % 2 != 0) {
                int i6 = 49 / 0;
                if (StringsKt.isBlank(str)) {
                    return;
                }
            } else if (StringsKt.isBlank(str)) {
                return;
            }
            int i7 = unregisterClient + Imgproc.COLOR_YUV2RGB_YVYU;
            i = i7 % 128;
            int i8 = i7 % 2;
            map.put("af_web_referrer", aFh1sSDK.equals);
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void AFAdRevenueData(Map<String, Object> map) {
        getCurrencyIso4217Code(new Object[]{this, map}, -140518467, 140518471, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final long getCurrencyIso4217Code() {
        int i2 = 2 % 2;
        int i3 = unregisterClient + Imgproc.COLOR_YUV2RGBA_YVYU;
        i = i3 % 128;
        if (i3 % 2 != 0) {
            return System.currentTimeMillis();
        }
        int i4 = 89 / 0;
        return System.currentTimeMillis();
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        int i2 = 2 % 2;
        int i3 = i + 69;
        unregisterClient = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        getMonetizationNetwork(map);
        Map<String, Object> map2 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        getRevenue(map2, aFh1sSDK.component1);
        Map<String, Object> map3 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map3, "");
        AFLogger(map3);
        Map<String, Object> map4 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map4, "");
        unregisterClient(map4);
        Map<String, Object> map5 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map5, "");
        force(map5);
        Map<String, Object> map6 = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map6, "");
        AFe1lSDK revenue = aFh1sSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        getRevenue(map6, revenue);
        int i5 = i + 15;
        unregisterClient = i5 % 128;
        if (i5 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getCurrencyIso4217Code(Map<String, Object> map) {
        AFi1wSDK aFi1wSDKAFAdRevenueData;
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        AFi1pSDK aFi1pSDK = this.component4.getRevenue;
        if (aFi1pSDK != null) {
            int i3 = unregisterClient + 29;
            i = i3 % 128;
            int i4 = i3 % 2;
            aFi1wSDKAFAdRevenueData = aFi1pSDK.AFAdRevenueData();
        } else {
            aFi1wSDKAFAdRevenueData = null;
        }
        if (aFi1wSDKAFAdRevenueData != null) {
            int i5 = i + Imgproc.COLOR_YUV2RGBA_YVYU;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
            map.put(AndroidContextPlugin.NETWORK_KEY, aFi1wSDKAFAdRevenueData.AFAdRevenueData);
            map.put("ivc", Boolean.valueOf(aFi1wSDKAFAdRevenueData.getRevenue()));
            if (getRevenue().getBoolean(AppsFlyerProperties.DISABLE_NETWORK_DATA, false)) {
                return;
            }
            int i7 = unregisterClient + 47;
            i = i7 % 128;
            if (i7 % 2 == 0) {
                String str = aFi1wSDKAFAdRevenueData.getCurrencyIso4217Code;
                throw null;
            }
            String str2 = aFi1wSDKAFAdRevenueData.getCurrencyIso4217Code;
            if (str2 != null) {
                map.put("operator", str2);
                int i8 = i + 61;
                unregisterClient = i8 % 128;
                int i9 = i8 % 2;
            }
            String str3 = aFi1wSDKAFAdRevenueData.getMonetizationNetwork;
            if (str3 != null) {
                map.put("carrier", str3);
            }
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getMediationNetwork(AFh1sSDK aFh1sSDK) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
        if (aFh1sSDK.AFAdRevenueData()) {
            int i3 = i + 111;
            unregisterClient = i3 % 128;
            int i4 = i3 % 2;
            getMonetizationNetwork(aFh1sSDK, aFh1sSDK.component2, this.equals.AFAdRevenueData, this.equals.getMediationNetwork);
        } else if (!(aFh1sSDK instanceof AFh1iSDK)) {
            int i5 = i + 53;
            unregisterClient = i5 % 128;
            int i6 = i5 % 2;
            Intrinsics.checkNotNullExpressionValue(map, "");
            String str = aFh1sSDK.areAllFieldsValid;
            Intrinsics.checkNotNullExpressionValue(str, "");
            getRevenue(map, str);
        }
        if (CollectionsKt.listOf((Object[]) new AFe1lSDK[]{AFe1lSDK.CONVERSION, AFe1lSDK.LAUNCH, AFe1lSDK.INAPP}).contains(aFh1sSDK.getRevenue())) {
            int i7 = unregisterClient + 37;
            i = i7 % 128;
            if (i7 % 2 == 0) {
                Intrinsics.checkNotNullExpressionValue(map, "");
                getCurrencyIso4217Code(new Object[]{this, map}, -2036410656, 2036410668, System.identityHashCode(this));
                int i8 = 5 / 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(map, "");
                getCurrencyIso4217Code(new Object[]{this, map}, -2036410656, 2036410668, System.identityHashCode(this));
            }
        }
        if (CollectionsKt.listOf((Object[]) new AFe1lSDK[]{AFe1lSDK.CONVERSION, AFe1lSDK.LAUNCH, AFe1lSDK.ATTR}).contains(aFh1sSDK.getRevenue())) {
            int i9 = i + 43;
            unregisterClient = i9 % 128;
            int i10 = i9 % 2;
            Intrinsics.checkNotNullExpressionValue(map, "");
            copy(map);
        }
        Intrinsics.checkNotNullExpressionValue(map, "");
        afInfoLog(map);
        getCurrencyIso4217Code(new Object[]{map}, -1435534787, 1435534790, (int) System.currentTimeMillis());
        AFKeystoreWrapper(map);
        getCurrencyIso4217Code(new Object[]{this, map}, 381318277, -381318268, System.identityHashCode(this));
        getCurrencyIso4217Code(new Object[]{this, map}, -140518467, 140518471, System.identityHashCode(this));
        getMediationNetwork(map, aFh1sSDK.AFAdRevenueData());
        e(map);
        w(map);
        getCurrencyIso4217Code(new Object[]{map, aFh1sSDK}, 840096267, -840096265, (int) System.currentTimeMillis());
        map.put("af_events_api", "1");
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getMediationNetwork(Map<String, Object> map) {
        Object objM11445constructorimpl;
        AFLogger aFLogger;
        AFg1cSDK aFg1cSDK;
        int i2;
        Object obj;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        int i3 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String str2 = this.equals.getRevenue;
        Object obj2 = null;
        if (str2 != null) {
            if (map.get("af_deeplink") != null) {
                int i4 = i + 101;
                unregisterClient = i4 % 128;
                if (i4 % 2 != 0) {
                    AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
                    obj2.hashCode();
                    throw null;
                }
                AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AFg1tSDK aFg1tSDK = this;
                    JSONObject jSONObject = new JSONObject(str2);
                    jSONObject.put("isPush", "true");
                    map.put("af_deeplink", jSONObject.toString());
                    objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
                    int i5 = unregisterClient + 71;
                    i = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
                if (thM11448exceptionOrNullimpl != null) {
                    int i7 = i + 65;
                    unregisterClient = i7 % 128;
                    if (i7 % 2 != 0) {
                        aFLogger = AFLogger.INSTANCE;
                        aFg1cSDK = AFg1cSDK.GENERAL;
                        i2 = 36;
                        obj = null;
                        str = "Exception while trying to create JSONObject from pushPayload";
                        z = false;
                        z2 = false;
                        z3 = true;
                    } else {
                        aFLogger = AFLogger.INSTANCE;
                        aFg1cSDK = AFg1cSDK.GENERAL;
                        i2 = 120;
                        obj = null;
                        str = "Exception while trying to create JSONObject from pushPayload";
                        z = false;
                        z2 = false;
                        z3 = false;
                    }
                    AFg1hSDK.e$default(aFLogger, aFg1cSDK, str, thM11448exceptionOrNullimpl, z, z2, z3, false, i2, obj);
                }
                Result.m11444boximpl(objM11445constructorimpl);
            }
        }
        this.equals.getRevenue = null;
        int i8 = i + 19;
        unregisterClient = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getMonetizationNetwork(AFh1sSDK aFh1sSDK) {
        int i2 = 2 % 2;
        int i3 = unregisterClient + 43;
        i = i3 % 128;
        int i4 = i3 % 2;
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        getRevenue(map, aFh1sSDK.AFAdRevenueData());
        component1(map);
        getCurrencyIso4217Code(new Object[]{map}, -1939346047, 1939346058, (int) System.currentTimeMillis());
        getCurrencyIso4217Code(map);
        AFAdRevenueData(map, this.equals.getCurrencyIso4217Code);
        i(map);
        map.put("cell", MapsKt.mapOf(TuplesKt.to("mcc", Integer.valueOf(this.AFAdRevenueData.getResources().getConfiguration().mcc)), TuplesKt.to("mnc", Integer.valueOf(this.AFAdRevenueData.getResources().getConfiguration().mnc))));
        map.put("sig", AFAdRevenueData());
        map.put("last_boot_time", Long.valueOf(component1()));
        map.put("disk", areAllFieldsValid());
        int i5 = unregisterClient + 33;
        i = i5 % 128;
        if (i5 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getMonetizationNetwork(Map<String, Object> map, int i2, int i3) {
        getCurrencyIso4217Code(new Object[]{this, map, Integer.valueOf(i2), Integer.valueOf(i3)}, -2094417187, 2094417192, i2);
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getRevenue(AFh1sSDK aFh1sSDK) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(aFh1sSDK, "");
        if (this.component3.getMediationNetwork()) {
            AFh1rSDK aFh1rSDK = this.component3.getMediationNetwork.component2;
            if (aFh1rSDK == null) {
                return;
            }
            String str = aFh1rSDK.getCurrencyIso4217Code;
            if (str == null || str.length() == 0) {
                int i3 = unregisterClient + 59;
                i = i3 % 128;
                int i4 = i3 % 2;
            } else {
                aFh1sSDK.getMonetizationNetwork("gaidError", aFh1rSDK.getCurrencyIso4217Code);
            }
            if (aFh1rSDK.AFAdRevenueData != null && aFh1rSDK.getMediationNetwork != null) {
                aFh1sSDK.getMonetizationNetwork("advertiserId", aFh1rSDK.AFAdRevenueData);
                aFh1sSDK.getMonetizationNetwork("advertiserIdEnabled", String.valueOf(aFh1rSDK.getMediationNetwork));
                aFh1sSDK.getMonetizationNetwork("isGaidWithGps", String.valueOf(aFh1rSDK.getMonetizationNetwork));
            }
        } else {
            int i5 = i + Imgproc.COLOR_YUV2RGBA_YVYU;
            unregisterClient = i5 % 128;
            if (i5 % 2 != 0) {
                Map<String, Object> monetizationNetwork = AFa1tSDK.getMonetizationNetwork(aFh1sSDK.AFAdRevenueData);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                monetizationNetwork.put("ad_ids_disabled", Boolean.TRUE);
                int i6 = 49 / 0;
            } else {
                Map<String, Object> monetizationNetwork2 = AFa1tSDK.getMonetizationNetwork(aFh1sSDK.AFAdRevenueData);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork2, "");
                monetizationNetwork2.put("ad_ids_disabled", Boolean.TRUE);
            }
        }
        AFh1rSDK aFh1rSDK2 = this.component3.getMediationNetwork.component2;
        aFh1sSDK.getMonetizationNetwork("GAID_retry", String.valueOf(aFh1rSDK2 != null ? Intrinsics.areEqual(aFh1rSDK2.component2, Boolean.TRUE) : false));
        if (CollectionsKt.listOf((Object[]) new AFe1lSDK[]{AFe1lSDK.CONVERSION, AFe1lSDK.LAUNCH}).contains(aFh1sSDK.getRevenue())) {
            int i7 = unregisterClient + 17;
            i = i7 % 128;
            int i8 = i7 % 2;
            AFc1gSDK aFc1gSDK = this.equals;
            if (i8 == 0) {
                AFd1dSDK aFd1dSDK = aFc1gSDK.component3;
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            AFd1dSDK aFd1dSDK2 = aFc1gSDK.component3;
            if (aFd1dSDK2 != null) {
                Map<String, Object> monetizationNetwork3 = AFa1tSDK.getMonetizationNetwork(aFh1sSDK.AFAdRevenueData);
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork3, "");
                monetizationNetwork3.put("fetchAdIdLatency", Long.valueOf(aFd1dSDK2.AFAdRevenueData));
            }
        }
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getRevenue(Map<String, Object> map) {
        String[] strArr;
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        String string = getRevenue().getString(AppsFlyerProperties.APP_ID);
        if (string != null) {
            int i3 = unregisterClient + 53;
            i = i3 % 128;
            if (i3 % 2 == 0) {
                map.put(AppsFlyerProperties.APP_ID, string);
                int i4 = 8 / 0;
            } else {
                map.put(AppsFlyerProperties.APP_ID, string);
            }
        }
        String string2 = getRevenue().getString(AppsFlyerProperties.CURRENCY_CODE);
        if (string2 != null) {
            if (string2.length() != 3) {
                String string3 = new StringBuilder("WARNING: currency code should be 3 characters!!! '").append(string2).append("' is not a legal value.").toString();
                Intrinsics.checkNotNullExpressionValue(string3, "");
                AFLogger.afWarnLog(string3);
            }
            map.put(FirebaseAnalytics.Param.CURRENCY, string2);
        }
        String string4 = getRevenue().getString(AppsFlyerProperties.IS_UPDATE);
        if (string4 != null) {
            map.put("isUpdate", string4);
        }
        String string5 = getRevenue().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        if (string5 != null) {
            map.put("customData", string5);
        }
        String string6 = getRevenue().getString(AppsFlyerProperties.APP_USER_ID);
        if (string6 != null) {
            int i5 = unregisterClient + 27;
            i = i5 % 128;
            int i6 = i5 % 2;
            map.put("appUserId", string6);
        }
        String string7 = getRevenue().getString(AppsFlyerProperties.USER_EMAILS);
        if (string7 != null) {
            map.put("user_emails", string7);
        } else {
            int i7 = i + 111;
            unregisterClient = i7 % 128;
            int i8 = i7 % 2;
        }
        AFb1uSDK aFb1uSDK = this.equals.getMonetizationNetwork;
        if (aFb1uSDK == null || (strArr = aFb1uSDK.getRevenue) == null) {
            return;
        }
        map.put("sharing_filter", strArr);
    }

    @Override // com.appsflyer.internal.AFg1vSDK
    public final void getRevenue(Map<String, Object> map, AFe1lSDK aFe1lSDK) {
        int i2 = 2 % 2;
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aFe1lSDK, "");
        if (copy().contains(aFe1lSDK)) {
            if (!this.equals.getMonetizationNetwork()) {
                AFb1gSDK aFb1gSDK = this.equals.equals;
                if (aFb1gSDK != null) {
                    int i3 = i + 111;
                    unregisterClient = i3 % 128;
                    int i4 = i3 % 2;
                    map.put("app_set_id", MapsKt.mapOf(TuplesKt.to("scope", Integer.valueOf(aFb1gSDK.getCurrencyIso4217Code)), TuplesKt.to("id", aFb1gSDK.AFAdRevenueData)));
                    return;
                }
                return;
            }
            int i5 = unregisterClient + 49;
            i = i5 % 128;
            int i6 = i5 % 2;
            map.put("app_set_id", MapsKt.mapOf(TuplesKt.to("app_set_id_disabled", Boolean.TRUE)));
            if (this.equals.equals != null) {
                AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "App Set Id was collected, but will not be included in the payload.To prevent collection entirely, call disableAppSetId() before initializing the SDK.", false, 4, null);
                return;
            }
            AFg1hSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "App Set ID collection is disabled. Skipping inclusion in the event payload.", false, 4, null);
            int i7 = i + 15;
            unregisterClient = i7 % 128;
            if (i7 % 2 != 0) {
                throw null;
            }
        }
    }
}
