package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.camera.video.AudioStats;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.messaging.Constants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1kSDK implements AFd1lSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] component3 = null;
    private static int copydefault = 1;
    private static final int getRevenue;
    private static long hashCode;
    private static int toString;
    private final AFd1zSDK component4;
    private List<String> getCurrencyIso4217Code = new ArrayList();
    private boolean getMediationNetwork = true;
    private final Map<String, Object> AFAdRevenueData = new HashMap();
    private SecureRandom areAllFieldsValid = new SecureRandom();
    private boolean component2 = true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
    private int getMonetizationNetwork = 0;
    private boolean component1 = false;

    static {
        component2();
        getRevenue = 98166;
        int i = copydefault + 75;
        toString = i % 128;
        int i2 = i % 2;
    }

    public AFd1kSDK(AFd1zSDK aFd1zSDK) {
        this.component4 = aFd1zSDK;
    }

    public static /* synthetic */ Object AFAdRevenueData(Object[] objArr, int i, int i2, int i3) {
        String message;
        int i4 = (i * (-559)) + (i2 * Videoio.CAP_PROP_XI_HDR_T1);
        int i5 = ~i3;
        int i6 = i4 + ((~(i5 | i)) * (-560)) + ((~(i3 | (~i2) | i)) * (-560)) + (((~((~i) | i2)) | (~(i2 | i5))) * Videoio.CAP_PROP_XI_HDR_KNEEPOINT_COUNT);
        if (i6 != 1) {
            if (i6 == 2) {
                return getMediationNetwork(objArr);
            }
            if (i6 != 3) {
                return getCurrencyIso4217Code(objArr);
            }
            AFd1kSDK aFd1kSDK = (AFd1kSDK) objArr[0];
            int i7 = 2 % 2;
            int i8 = copydefault + 29;
            toString = i8 % 128;
            int i9 = i8 % 2;
            aFd1kSDK.component2 = false;
            return null;
        }
        AFd1kSDK aFd1kSDK2 = (AFd1kSDK) objArr[0];
        Throwable th = (Throwable) objArr[1];
        int i10 = 2 % 2;
        int i11 = toString + 49;
        copydefault = i11 % 128;
        int i12 = i11 % 2;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        if (cause == null) {
            int i13 = toString + 35;
            copydefault = i13 % 128;
            int i14 = i13 % 2;
            message = th.getMessage();
        } else {
            message = cause.getMessage();
        }
        aFd1kSDK2.AFAdRevenueData("exception", simpleName, getRevenue(message, cause == null ? th.getStackTrace() : cause.getStackTrace()));
        return null;
    }

    private synchronized void AFAdRevenueData(String str, AFf1kSDK aFf1kSDK, AFc1gSDK aFc1gSDK) {
        int i = 2 % 2;
        int i2 = copydefault + 37;
        toString = i2 % 128;
        int i3 = i2 % 2;
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        String string = appsFlyerProperties.getString("remote_debug_static_data");
        this.AFAdRevenueData.clear();
        if (string != null) {
            try {
                this.AFAdRevenueData.putAll(AFg1lSDK.getMediationNetwork(new JSONObject(string)));
            } catch (Throwable unused) {
            }
        } else {
            getMonetizationNetwork(this.component4.AFAdRevenueData().getMonetizationNetwork(), (String) AFf1kSDK.getMonetizationNetwork(new Object[]{aFf1kSDK}, -211782084, 211782085, System.identityHashCode(aFf1kSDK)), aFc1gSDK.getCurrencyIso4217Code);
            getRevenue(new StringBuilder("6.18.0.").append(AFa1tSDK.getMonetizationNetwork).toString(), this.component4.AFInAppEventParameterName().getMonetizationNetwork(), appsFlyerProperties.getString("KSAppsFlyerId"), AFb1iSDK.getCurrencyIso4217Code(this.component4.AFAdRevenueData().getCurrencyIso4217Code));
            try {
                int i4 = this.component4.AFAdRevenueData().n_().versionCode;
                AFAdRevenueData(str, String.valueOf(i4), appsFlyerProperties.getString(AppsFlyerProperties.CHANNEL), appsFlyerProperties.getString("preInstallName"));
                int i5 = 2 % 2;
            } catch (Throwable unused2) {
            }
            appsFlyerProperties.set("remote_debug_static_data", new JSONObject(this.AFAdRevenueData).toString());
            int i6 = copydefault + Imgproc.COLOR_YUV2RGB_YVYU;
            toString = i6 % 128;
            int i7 = i6 % 2;
            int i8 = 2 % 2;
        }
        this.AFAdRevenueData.put("launch_counter", String.valueOf(this.component4.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0)));
        int i9 = toString + 71;
        copydefault = i9 % 128;
        int i10 = i9 % 2;
    }

    private synchronized void AFAdRevenueData(String str, String str2, String str3, String str4) {
        int i = 2 % 2;
        int i2 = toString + 113;
        copydefault = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 == 0) {
                obj.hashCode();
                throw null;
            }
            if (str != null && str.length() > 0) {
                int i3 = toString + 57;
                copydefault = i3 % 128;
                int i4 = i3 % 2;
                Map<String, Object> map = this.AFAdRevenueData;
                if (i4 == 0) {
                    map.put("app_id", str);
                    throw null;
                }
                map.put("app_id", str);
            }
            if (str2 != null) {
                int i5 = toString + 41;
                copydefault = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 41 / 0;
                    if (str2.length() > 0) {
                        this.AFAdRevenueData.put("app_version", str2);
                        int i7 = 2 % 2;
                    }
                } else if (str2.length() > 0) {
                    this.AFAdRevenueData.put("app_version", str2);
                    int i72 = 2 % 2;
                }
            }
            if (str3 != null && str3.length() > 0) {
                this.AFAdRevenueData.put(AppsFlyerProperties.CHANNEL, str3);
                int i8 = 2 % 2;
            }
            if (str4 != null) {
                int i9 = copydefault + 51;
                toString = i9 % 128;
                int i10 = i9 % 2;
                if (str4.length() > 0) {
                    this.AFAdRevenueData.put("preInstall", str4);
                    int i11 = toString + 3;
                    copydefault = i11 % 128;
                    if (i11 % 2 != 0) {
                        int i12 = 2 % 2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void AFAdRevenueData(String str, String str2, String... strArr) {
        int i = 2 % 2;
        if (copy()) {
            int i2 = toString + 123;
            copydefault = i2 % 128;
            int i3 = i2 % 2;
            if (this.getMonetizationNetwork < 98304) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strJoin = TextUtils.join(", ", strArr);
                    String string = str != null ? new StringBuilder().append(jCurrentTimeMillis).append(" ").append(Thread.currentThread().getId()).append(" _/AppsFlyer_6.18.0 [").append(str).append("] ").append(str2).append(" ").append(strJoin).toString() : new StringBuilder().append(jCurrentTimeMillis).append(" ").append(Thread.currentThread().getId()).append(" ").append(str2).append("/AppsFlyer_6.18.0 ").append(strJoin).toString();
                    int length = this.getMonetizationNetwork + (string.length() << 1);
                    int i4 = getRevenue;
                    boolean z = false;
                    if (length > i4) {
                        int i5 = toString + 25;
                        copydefault = i5 % 128;
                        int i6 = i5 % 2;
                        string = string.substring(0, (i4 - this.getMonetizationNetwork) / 2);
                        z = true;
                    }
                    this.getCurrencyIso4217Code.add(string);
                    this.getMonetizationNetwork += string.length() << 1;
                    if (z) {
                        int i7 = copydefault + 1;
                        toString = i7 % 128;
                        int i8 = i7 % 2;
                        List<String> list = this.getCurrencyIso4217Code;
                        if (i8 != 0) {
                            list.add("+~+~ The limit has been exceeded, and no more data is available. +~+~");
                            this.getMonetizationNetwork >>= 1297;
                        } else {
                            list.add("+~+~ The limit has been exceeded, and no more data is available. +~+~");
                            this.getMonetizationNetwork += 138;
                        }
                        int i9 = 2 % 2;
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void AFAdRevenueData(boolean z) {
        int i = 2 % 2;
        int i2 = toString + 23;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        this.component4.getMediationNetwork().getRevenue("participantInProxy", z);
        int i4 = copydefault + 29;
        toString = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private void AFInAppEventParameterName() {
        int i = 2 % 2;
        int i2 = toString + 101;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        this.component4.getMediationNetwork().getCurrencyIso4217Code("participantInProxy");
        int i4 = copydefault + 3;
        toString = i4 % 128;
        int i5 = i4 % 2;
    }

    private boolean AFInAppEventType() {
        int i = 2 % 2;
        int i2 = copydefault + 49;
        toString = i2 % 128;
        int i3 = i2 % 2;
        AFc1jSDK mediationNetwork = this.component4.getMediationNetwork();
        if (i3 != 0) {
            mediationNetwork.getRevenue("participantInProxy");
            throw null;
        }
        boolean revenue = mediationNetwork.getRevenue("participantInProxy");
        int i4 = copydefault + 71;
        toString = i4 % 128;
        if (i4 % 2 == 0) {
            return revenue;
        }
        throw null;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3 = 2 % 2;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        long[] jArr = new long[i];
        aFk1kSDK.getMediationNetwork = 0;
        while (aFk1kSDK.getMediationNetwork < i) {
            int i4 = $10 + 85;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            jArr[aFk1kSDK.getMediationNetwork] = (((long) ((char) (((long) component3[aFk1kSDK.getMediationNetwork + i2]) ^ 5211070536272185776L))) ^ (((long) aFk1kSDK.getMediationNetwork) * (5211070536272185776L ^ hashCode))) ^ ((long) c);
            aFk1kSDK.getMediationNetwork++;
            int i6 = $10 + Imgproc.COLOR_YUV2RGBA_YVYU;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = 3 / 3;
            }
        }
        char[] cArr = new char[i];
        aFk1kSDK.getMediationNetwork = 0;
        while (aFk1kSDK.getMediationNetwork < i) {
            cArr[aFk1kSDK.getMediationNetwork] = (char) jArr[aFk1kSDK.getMediationNetwork];
            aFk1kSDK.getMediationNetwork++;
        }
        objArr[0] = new String(cArr);
    }

    private synchronized void areAllFieldsValid() {
        int i = 2 % 2;
        int i2 = toString;
        int i3 = i2 + 113;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        if (this.component1) {
            int i5 = i2 + 69;
            copydefault = i5 % 128;
            int i6 = i5 % 2;
        } else {
            this.component1 = true;
            try {
                AFAdRevenueData("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.PROXY, "Error while starting remote debugger", th, true, true, true);
            }
        }
    }

    private float component1() {
        int i = 2 % 2;
        int i2 = toString + 51;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        float fNextFloat = this.areAllFieldsValid.nextFloat();
        int i4 = toString + 21;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            return fNextFloat;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    static void component2() {
        component3 = new char[]{62651, 61828, 65254, 64314, 57345};
        hashCode = 266560491673881759L;
    }

    private static String component4() {
        int i = 2 % 2;
        int i2 = copydefault;
        int i3 = i2 + 51;
        toString = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i2 + 107;
        toString = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 13 / 0;
        }
        return "6.18.0";
    }

    private boolean copy() {
        int i = 2 % 2;
        if (!this.component2) {
            return false;
        }
        int i2 = toString;
        int i3 = i2 + 119;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        if (this.getMediationNetwork) {
            return true;
        }
        int i5 = i2 + 5;
        copydefault = i5 % 128;
        int i6 = i5 % 2;
        boolean z = this.component1;
        if (i6 != 0) {
            return z;
        }
        throw null;
    }

    private synchronized Map<String, Object> copydefault() {
        int i = 2 % 2;
        int i2 = copydefault + 91;
        toString = i2 % 128;
        int i3 = i2 % 2;
        this.AFAdRevenueData.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, this.getCurrencyIso4217Code);
        equals();
        Map<String, Object> map = this.AFAdRevenueData;
        int i4 = toString + 111;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            return map;
        }
        int i5 = 89 / 0;
        return map;
    }

    private synchronized void equals() {
        int i = 2 % 2;
        this.getCurrencyIso4217Code = new ArrayList();
        this.getMonetizationNetwork = 0;
        int i2 = toString + 41;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1kSDK aFd1kSDK = (AFd1kSDK) objArr[0];
        String str = (String) objArr[1];
        String[] strArr = (String[]) objArr[2];
        int i = 2 % 2;
        int i2 = copydefault + 91;
        toString = i2 % 128;
        int i3 = i2 % 2;
        aFd1kSDK.AFAdRevenueData("public_api_call", str, strArr);
        int i4 = copydefault + 65;
        toString = i4 % 128;
        if (i4 % 2 == 0) {
            return null;
        }
        throw null;
    }

    private boolean getCurrencyIso4217Code(AFi1zSDK aFi1zSDK, AFi1zSDK aFi1zSDK2) {
        boolean zAFInAppEventType;
        int i = 2 % 2;
        int i2 = toString + 73;
        copydefault = i2 % 128;
        if (i2 % 2 == 0) {
            aFi1zSDK.equals(aFi1zSDK2);
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (aFi1zSDK.equals(aFi1zSDK2)) {
            zAFInAppEventType = AFInAppEventType();
        } else {
            boolean revenue = getRevenue(aFi1zSDK.AFAdRevenueData);
            AFAdRevenueData(revenue);
            zAFInAppEventType = revenue;
        }
        int i3 = toString + 9;
        copydefault = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 63 / 0;
        }
        return zAFInAppEventType;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFd1kSDK aFd1kSDK = (AFd1kSDK) objArr[0];
        int i = 2 % 2;
        int i2 = copydefault + 107;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            aFd1kSDK.getRevenue(getRevenue(aFd1kSDK.component4.component3().getCurrencyIso4217Code.AFAdRevenueData), getRevenue(aFd1kSDK.component4.component3().getCurrencyIso4217Code.getMonetizationNetwork));
            throw null;
        }
        boolean revenue = aFd1kSDK.getRevenue(getRevenue(aFd1kSDK.component4.component3().getCurrencyIso4217Code.AFAdRevenueData), getRevenue(aFd1kSDK.component4.component3().getCurrencyIso4217Code.getMonetizationNetwork));
        if (revenue) {
            aFd1kSDK.areAllFieldsValid();
            int i3 = toString + 73;
            copydefault = i3 % 128;
            int i4 = i3 % 2;
        } else {
            aFd1kSDK.getMediationNetwork();
            aFd1kSDK.AFAdRevenueData();
        }
        return Boolean.valueOf(revenue);
    }

    private Map<String, Object> getMediationNetwork(String str) {
        int i = 2 % 2;
        int i2 = copydefault + 113;
        toString = i2 % 128;
        int i3 = i2 % 2;
        AFAdRevenueData(str, this.component4.AFInAppEventParameterName(), this.component4.e());
        Map<String, Object> mapCopydefault = copydefault();
        int i4 = toString + 103;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            return mapCopydefault;
        }
        throw null;
    }

    private synchronized void getMonetizationNetwork(String str, String str2, String str3) {
        int i = 2 % 2;
        try {
            Map<String, Object> map = this.AFAdRevenueData;
            Object[] objArr = new Object[1];
            a(View.MeasureSpec.getMode(0) + 5, ViewConfiguration.getKeyRepeatTimeout() >> 16, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 64874), objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.AFAdRevenueData.put(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL);
            this.AFAdRevenueData.put("platform", "Android");
            this.AFAdRevenueData.put("platform_version", Build.VERSION.RELEASE);
            if (str != null && str.length() > 0) {
                int i2 = toString + 87;
                copydefault = i2 % 128;
                int i3 = i2 % 2;
                Map<String, Object> map2 = this.AFAdRevenueData;
                if (i3 == 0) {
                    map2.put("advertiserId", str);
                    throw null;
                }
                map2.put("advertiserId", str);
            }
            if (str2 != null) {
                int i4 = toString + 15;
                copydefault = i4 % 128;
                if (i4 % 2 == 0) {
                    str2.length();
                    throw null;
                }
                if (str2.length() > 0) {
                    int i5 = toString + 75;
                    copydefault = i5 % 128;
                    int i6 = i5 % 2;
                    Map<String, Object> map3 = this.AFAdRevenueData;
                    if (i6 == 0) {
                        map3.put("imei", str2);
                        throw null;
                    }
                    map3.put("imei", str2);
                }
            }
            if (str3 != null && str3.length() > 0) {
                this.AFAdRevenueData.put("android_id", str3);
                int i7 = toString + 89;
                copydefault = i7 % 128;
                if (i7 % 2 == 0) {
                    int i8 = 2 / 5;
                } else {
                    int i9 = 2 % 2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean getMonetizationNetwork(String str) {
        int i = 2 % 2;
        int i2 = toString + 85;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        if (AFk1zSDK.getRevenue(str)) {
            return true;
        }
        boolean zEquals = str.equals(this.component4.AFAdRevenueData().n_().versionName);
        int i4 = toString + 71;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            return zEquals;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static AFi1zSDK getRevenue(AFh1cSDK aFh1cSDK) {
        int i = 2 % 2;
        if (aFh1cSDK != null) {
            int i2 = toString + 89;
            copydefault = i2 % 128;
            if (i2 % 2 == 0) {
                AFh1aSDK aFh1aSDK = aFh1cSDK.getMediationNetwork;
                throw null;
            }
            AFh1aSDK aFh1aSDK2 = aFh1cSDK.getMediationNetwork;
            if (aFh1aSDK2 != null) {
                return aFh1aSDK2.AFAdRevenueData;
            }
        }
        int i3 = copydefault + 77;
        toString = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 30 / 0;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x0065, TryCatch #1 {all -> 0x0065, blocks: (B:7:0x0011, B:12:0x0026, B:14:0x002c, B:16:0x0035, B:18:0x003b, B:20:0x0044, B:22:0x004a, B:10:0x001e), top: B:39:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void getRevenue(String str, String str2, String str3, String str4) {
        int i;
        int i2 = 2 % 2;
        int i3 = toString + Imgproc.COLOR_YUV2RGB_YVYU;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        Map<String, Object> map = this.AFAdRevenueData;
        try {
            if (i4 == 0) {
                map.put("sdk_version", str);
                int i5 = 68 / 0;
                if (str2 != null) {
                    if (str2.length() > 0) {
                        this.AFAdRevenueData.put("devkey", str2);
                    }
                }
                if (str3 != null && str3.length() > 0) {
                    this.AFAdRevenueData.put("originalAppsFlyerId", str3);
                }
                if (str4 != null && str4.length() > 0) {
                    this.AFAdRevenueData.put("uid", str4);
                    int i6 = 2 % 2;
                }
                i = toString + 67;
                copydefault = i % 128;
                if (i % 2 != 0) {
                    throw null;
                }
            } else {
                map.put("sdk_version", str);
                if (str2 != null) {
                    if (str2.length() > 0) {
                    }
                }
                if (str3 != null) {
                    this.AFAdRevenueData.put("originalAppsFlyerId", str3);
                }
                if (str4 != null) {
                    this.AFAdRevenueData.put("uid", str4);
                    int i62 = 2 % 2;
                }
                i = toString + 67;
                copydefault = i % 128;
                if (i % 2 != 0) {
                }
            }
        } catch (Throwable unused) {
            return;
        }
    }

    private boolean getRevenue(float f) {
        int i = 2 % 2;
        double d = f;
        if (d < 1.0d) {
            return d > AudioStats.AUDIO_AMPLITUDE_NONE && component1() <= f;
        }
        int i2 = copydefault;
        int i3 = i2 + 15;
        toString = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i2 + 47;
        toString = i5 % 128;
        if (i5 % 2 == 0) {
            return true;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private synchronized boolean getRevenue(AFi1zSDK aFi1zSDK, AFi1zSDK aFi1zSDK2) {
        int i = 2 % 2;
        if (aFi1zSDK == null) {
            AFInAppEventParameterName();
            return false;
        }
        if (!aFi1zSDK.getMonetizationNetwork()) {
            int i2 = copydefault + 71;
            toString = i2 % 128;
            int i3 = i2 % 2;
            return false;
        }
        if (this.component4.AFAdRevenueData().getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0) <= aFi1zSDK.getCurrencyIso4217Code) {
            int i4 = toString + 63;
            copydefault = i4 % 128;
            if (i4 % 2 != 0) {
                if (!getCurrencyIso4217Code(aFi1zSDK, aFi1zSDK2)) {
                    return false;
                }
                if (getMonetizationNetwork(aFi1zSDK.getMonetizationNetwork)) {
                    return getRevenue(aFi1zSDK.getRevenue);
                }
                return false;
            }
        }
        int i5 = toString + 17;
        copydefault = i5 % 128;
        int i6 = i5 % 2;
        return false;
    }

    private static boolean getRevenue(String str) {
        int i = 2 % 2;
        if (!AFk1zSDK.getRevenue(str)) {
            new AFd1rSDK();
            return AFd1rSDK.getRevenue(component4(), str);
        }
        int i2 = copydefault;
        int i3 = i2 + 61;
        toString = i3 % 128;
        int i4 = i3 % 2;
        int i5 = i2 + 73;
        toString = i5 % 128;
        int i6 = i5 % 2;
        return true;
    }

    private static String[] getRevenue(String str, StackTraceElement[] stackTraceElementArr) {
        int i = 2 % 2;
        int i2 = copydefault + 113;
        int i3 = i2 % 128;
        toString = i3;
        if (i2 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (stackTraceElementArr == null) {
            return new String[]{str};
        }
        String[] strArr = new String[stackTraceElementArr.length + 1];
        strArr[0] = str;
        int i4 = i3 + 97;
        copydefault = i4 % 128;
        int i5 = i4 % 2;
        for (int i6 = 1; i6 < stackTraceElementArr.length; i6++) {
            int i7 = copydefault + 9;
            toString = i7 % 128;
            int i8 = i7 % 2;
            strArr[i6] = stackTraceElementArr[i6].toString();
        }
        return strArr;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final synchronized void AFAdRevenueData() {
        int i = 2 % 2;
        if (!this.component1) {
            int i2 = toString + 89;
            int i3 = i2 % 128;
            copydefault = i3;
            int i4 = i2 % 2;
            if (!this.getMediationNetwork) {
                int i5 = i3 + 99;
                toString = i5 % 128;
                int i6 = i5 % 2;
                return;
            }
        }
        this.component1 = false;
        this.getMediationNetwork = false;
        try {
            AFAdRevenueData("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PROXY, "Error while stopping remote debugger", th, true, true, true);
        }
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final boolean component3() {
        int i = 2 % 2;
        int i2 = toString + 79;
        int i3 = i2 % 128;
        copydefault = i3;
        int i4 = i2 % 2;
        boolean z = this.component1;
        int i5 = i3 + 41;
        toString = i5 % 128;
        if (i5 % 2 == 0) {
            return z;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final synchronized void getCurrencyIso4217Code() {
        int i = 2 % 2;
        int i2 = copydefault + 31;
        toString = i2 % 128;
        int i3 = i2 % 2;
        Map<String, Object> map = this.AFAdRevenueData;
        if (i3 != 0) {
            map.clear();
            this.getCurrencyIso4217Code.clear();
            this.getMonetizationNetwork = 1;
        } else {
            map.clear();
            this.getCurrencyIso4217Code.clear();
            this.getMonetizationNetwork = 0;
        }
        int i4 = toString + 49;
        copydefault = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getCurrencyIso4217Code(Throwable th) {
        AFAdRevenueData(new Object[]{this, th}, 1500974607, -1500974606, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final synchronized void getMediationNetwork() {
        int i = 2 % 2;
        int i2 = copydefault + 17;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            this.getMediationNetwork = false;
        } else {
            this.getMediationNetwork = false;
        }
        getCurrencyIso4217Code();
        equals();
        int i3 = copydefault + 17;
        toString = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getMediationNetwork(String str, String str2) {
        int i = 2 % 2;
        int i2 = toString + 107;
        copydefault = i2 % 128;
        if (i2 % 2 != 0) {
            AFAdRevenueData((String) null, str, str2);
            return;
        }
        String[] strArr = new String[0];
        strArr[0] = str2;
        AFAdRevenueData((String) null, str, strArr);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getMediationNetwork(String str, String... strArr) {
        AFAdRevenueData(new Object[]{this, str, strArr}, 1230732210, -1230732210, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getMonetizationNetwork() {
        AFAdRevenueData(new Object[]{this}, -1717475168, 1717475171, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getMonetizationNetwork(String str, String str2) {
        int i = 2 % 2;
        int i2 = copydefault + 99;
        toString = i2 % 128;
        int i3 = i2 % 2;
        AFAdRevenueData("server_request", str, str2);
        int i4 = copydefault + 105;
        toString = i4 % 128;
        if (i4 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void getRevenue(String str, int i, String str2) {
        int i2 = 2 % 2;
        int i3 = copydefault + 107;
        toString = i3 % 128;
        int i4 = i3 % 2;
        AFAdRevenueData("server_response", str, String.valueOf(i), str2);
        int i5 = copydefault + 41;
        toString = i5 % 128;
        if (i5 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final boolean getRevenue() {
        return ((Boolean) AFAdRevenueData(new Object[]{this}, 2123307937, -2123307935, System.identityHashCode(this))).booleanValue();
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final void q_(String str, PackageManager packageManager) {
        int i = 2 % 2;
        int i2 = toString + 9;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        try {
            final AFd1nSDK aFd1nSDKAFAdRevenueData = this.component4.getRevenue().AFAdRevenueData(getMediationNetwork(str), this.component4.AFInAppEventParameterName().getMonetizationNetwork());
            if (aFd1nSDKAFAdRevenueData == null) {
                AFLogger.afErrorLogForExcManagerOnly("could not send null proxy data", new NullPointerException("request was null"));
                return;
            }
            ExecutorService currencyIso4217Code = this.component4.getCurrencyIso4217Code();
            Objects.requireNonNull(aFd1nSDKAFAdRevenueData);
            currencyIso4217Code.execute(new Runnable() { // from class: com.appsflyer.internal.AFd1kSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    aFd1nSDKAFAdRevenueData.getMediationNetwork();
                }
            });
            int i4 = toString + 103;
            copydefault = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
        }
    }
}
