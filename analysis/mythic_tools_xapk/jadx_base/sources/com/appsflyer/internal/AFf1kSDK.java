package com.appsflyer.internal;

import android.content.Context;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.AndroidCharacter;
import android.util.Base64;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFf1jSDK;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1kSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int component2 = 0;
    private static int toString = 1;
    private final AFc1fSDK AFAdRevenueData;
    private volatile String component1;
    private volatile String getCurrencyIso4217Code;
    Map<String, Object> getMediationNetwork;
    private long getRevenue;
    private static char[] component3 = {28704, 28722, 28716, 28702, 28712, 28711, 28721, 28708, 28725};
    private static char areAllFieldsValid = 17880;
    private boolean getMonetizationNetwork = false;
    private volatile boolean component4 = false;

    public AFf1kSDK(AFc1fSDK aFc1fSDK) {
        this.AFAdRevenueData = aFc1fSDK;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(byte b, String str, int i, Object[] objArr) {
        int i2;
        int i3 = 2 % 2;
        int i4 = $11 + 97;
        $10 = i4 % 128;
        Object charArray = str;
        if (i4 % 2 != 0) {
            int i5 = 77 / 0;
            charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
        } else if (str != null) {
        }
        char[] cArr = (char[]) charArray;
        AFk1oSDK aFk1oSDK = new AFk1oSDK();
        char[] cArr2 = component3;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                cArr3[i6] = (char) (((long) cArr2[i6]) ^ 3069006688033654235L);
                i6++;
                int i7 = $11 + 41;
                $10 = i7 % 128;
                int i8 = i7 % 2;
            }
            cArr2 = cArr3;
        }
        char c = (char) (3069006688033654235L ^ ((long) areAllFieldsValid));
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i9 = $11 + 5;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            aFk1oSDK.AFAdRevenueData = 0;
            while (aFk1oSDK.AFAdRevenueData < i2) {
                aFk1oSDK.getCurrencyIso4217Code = cArr[aFk1oSDK.AFAdRevenueData];
                aFk1oSDK.getRevenue = cArr[aFk1oSDK.AFAdRevenueData + 1];
                if (aFk1oSDK.getCurrencyIso4217Code == aFk1oSDK.getRevenue) {
                    cArr4[aFk1oSDK.AFAdRevenueData] = (char) (aFk1oSDK.getCurrencyIso4217Code - b);
                    cArr4[aFk1oSDK.AFAdRevenueData + 1] = (char) (aFk1oSDK.getRevenue - b);
                    int i11 = $10 + 15;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                } else {
                    aFk1oSDK.getMonetizationNetwork = aFk1oSDK.getCurrencyIso4217Code / c;
                    aFk1oSDK.component3 = aFk1oSDK.getCurrencyIso4217Code % c;
                    aFk1oSDK.getMediationNetwork = aFk1oSDK.getRevenue / c;
                    aFk1oSDK.component1 = aFk1oSDK.getRevenue % c;
                    if (aFk1oSDK.component3 == aFk1oSDK.component1) {
                        aFk1oSDK.getMonetizationNetwork = ((aFk1oSDK.getMonetizationNetwork + c) - 1) % c;
                        aFk1oSDK.getMediationNetwork = ((aFk1oSDK.getMediationNetwork + c) - 1) % c;
                        int i13 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component3;
                        int i14 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component1;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i13];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i14];
                    } else if (aFk1oSDK.getMonetizationNetwork == aFk1oSDK.getMediationNetwork) {
                        aFk1oSDK.component3 = ((aFk1oSDK.component3 + c) - 1) % c;
                        aFk1oSDK.component1 = ((aFk1oSDK.component1 + c) - 1) % c;
                        int i15 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component3;
                        int i16 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component1;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i15];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i16];
                    } else {
                        int i17 = (aFk1oSDK.getMonetizationNetwork * c) + aFk1oSDK.component1;
                        int i18 = (aFk1oSDK.getMediationNetwork * c) + aFk1oSDK.component3;
                        cArr4[aFk1oSDK.AFAdRevenueData] = cArr2[i17];
                        cArr4[aFk1oSDK.AFAdRevenueData + 1] = cArr2[i18];
                    }
                }
                aFk1oSDK.AFAdRevenueData += 2;
            }
        }
        int i19 = 0;
        while (i19 < i) {
            int i20 = $10 + 15;
            $11 = i20 % 128;
            if (i20 % 2 == 0) {
                cArr4[i19] = (char) (cArr4[i19] ^ 23386);
                i19 += 116;
            } else {
                cArr4[i19] = (char) (cArr4[i19] ^ 13722);
                i19++;
            }
        }
        objArr[0] = new String(cArr4);
    }

    private long component2() {
        int i = 2 % 2;
        int i2 = component2;
        int i3 = i2 + 9;
        toString = i3 % 128;
        int i4 = i3 % 2;
        long j = this.getRevenue;
        int i5 = i2 + 69;
        toString = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 56 / 0;
        }
        return j;
    }

    private boolean component3() {
        int i = 2 % 2;
        int i2 = toString;
        int i3 = i2 + 119;
        component2 = i3 % 128;
        int i4 = i3 % 2;
        Map<String, Object> map = this.getMediationNetwork;
        if (map == null) {
            return false;
        }
        int i5 = i2 + 83;
        component2 = i5 % 128;
        int i6 = i5 % 2;
        if (map.isEmpty()) {
            return false;
        }
        int i7 = component2 + 37;
        toString = i7 % 128;
        int i8 = i7 % 2;
        return true;
    }

    private static AFf1jSDK component4() {
        int i = 2 % 2;
        AFf1jSDK aFf1jSDK = new AFf1jSDK();
        int i2 = toString + 43;
        component2 = i2 % 128;
        if (i2 % 2 == 0) {
            return aFf1jSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFf1kSDK aFf1kSDK = (AFf1kSDK) objArr[0];
        int i = 2 % 2;
        int i2 = component2 + 115;
        toString = i2 % 128;
        int i3 = i2 % 2;
        String str = aFf1kSDK.component1;
        if (i3 == 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        int i4 = component2 + 113;
        toString = i4 % 128;
        int i5 = i4 % 2;
        return str;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        String str;
        AFh1sSDK aFh1sSDK = (AFh1sSDK) objArr[0];
        AFc1kSDK aFc1kSDK = (AFc1kSDK) objArr[1];
        int i = 2 % 2;
        if (AFk1zSDK.getMediationNetwork(aFc1kSDK.AFAdRevenueData)) {
            String monetizationNetwork = aFc1kSDK.getMonetizationNetwork("com.appsflyer.security.uuid");
            if (AFk1zSDK.getMediationNetwork(monetizationNetwork)) {
                int i2 = toString + 39;
                component2 = i2 % 128;
                int i3 = i2 % 2;
                str = null;
            } else {
                aFc1kSDK.AFAdRevenueData = monetizationNetwork.substring(0, 8);
                str = aFc1kSDK.AFAdRevenueData;
            }
        } else {
            str = aFc1kSDK.AFAdRevenueData;
            int i4 = toString + 67;
            component2 = i4 % 128;
            int i5 = i4 % 2;
        }
        if (str != null) {
            int i6 = toString + 97;
            component2 = i6 % 128;
            int i7 = i6 % 2;
            if (!str.isEmpty()) {
                try {
                    Map<String, Object> map = aFh1sSDK.AFAdRevenueData;
                    Object[] objArr2 = new Object[1];
                    a((byte) (104 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), "\u0002\u0003\u0005\u0006\u0005\u0001\u0001\u0004\u0006\u0002\u0000\b", '<' - AndroidCharacter.getMirror('0'), objArr2);
                    long j = Long.parseLong(String.valueOf(map.get(((String) objArr2[0]).intern())));
                    char[] charArray = str.toCharArray();
                    int i8 = ((int) (j % 94)) + 33;
                    for (int i9 = 0; i9 < charArray.length; i9++) {
                        charArray[i9] = (char) (charArray[i9] ^ i8);
                    }
                    aFh1sSDK.getRevenue.put("af-sdk-sbid", Base64.encodeToString(new String(charArray).getBytes(Charset.defaultCharset()), 2));
                    return true;
                } catch (Exception e) {
                    AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception occurred while generating sbid ", e);
                    return false;
                }
            }
        }
        int i10 = toString + 43;
        component2 = i10 % 128;
        int i11 = i10 % 2;
        return false;
    }

    private static boolean getMediationNetwork(Context context) {
        int i = 2 % 2;
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) {
            int i2 = component2 + 77;
            toString = i2 % 128;
            int i3 = i2 % 2;
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
                AFa1tSDK.getMediationNetwork();
                return !AFa1tSDK.getRevenue(context);
            }
        }
        int i4 = component2 + 75;
        toString = i4 % 128;
        int i5 = i4 % 2;
        return true;
    }

    private long getMonetizationNetwork(AFc1kSDK aFc1kSDK) {
        int i = 2 % 2;
        long jAFAdRevenueData = AFj1jSDK.AFAdRevenueData(AFj1jSDK.AFAdRevenueData(new StringBuilder().append(AFb1iSDK.getCurrencyIso4217Code(aFc1kSDK.getCurrencyIso4217Code)).append(component2()).toString()));
        int i2 = component2 + 119;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            return jAFAdRevenueData;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) throws Throwable {
        int i = 2 % 2;
        try {
            new AFb1sSDK((AFh1sSDK) objArr[0], (byte[]) objArr[1]).afInfoLog();
            int i2 = toString + 97;
            component2 = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.SECURITY, "native: reflection init failed", e, false, false, true);
            return null;
        }
    }

    public static /* synthetic */ Object getMonetizationNetwork(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * Videoio.CAP_PROP_XI_DEVICE_SN) + (i2 * (-520));
        int i5 = ~i3;
        int i6 = i4 + (((~(i5 | i2)) | i) * (-1042)) + ((i2 | i3) * Videoio.CAP_PROP_XI_DEVICE_MODEL_ID);
        int i7 = ~i;
        int i8 = i6 + (((~(i | i5 | i2)) | (~(i3 | i7)) | (~((~i2) | i7))) * Videoio.CAP_PROP_XI_DEVICE_MODEL_ID);
        if (i8 == 1) {
            return getCurrencyIso4217Code(objArr);
        }
        if (i8 != 2) {
            return i8 != 3 ? getMediationNetwork(objArr) : getMonetizationNetwork(objArr);
        }
        AFf1kSDK aFf1kSDK = (AFf1kSDK) objArr[0];
        String str = (String) objArr[1];
        int i9 = 2 % 2;
        int i10 = component2 + 35;
        toString = i10 % 128;
        int i11 = i10 % 2;
        aFf1kSDK.component1 = str;
        int i12 = toString + 3;
        component2 = i12 % 128;
        int i13 = i12 % 2;
        return null;
    }

    public static void getMonetizationNetwork(AFh1sSDK aFh1sSDK, byte[] bArr) {
        getMonetizationNetwork(new Object[]{aFh1sSDK, bArr}, -254860318, 254860321, (int) System.currentTimeMillis());
    }

    public static boolean getRevenue(AFh1sSDK aFh1sSDK, AFc1kSDK aFc1kSDK) {
        return ((Boolean) getMonetizationNetwork(new Object[]{aFh1sSDK, aFc1kSDK}, 2120438480, -2120438480, (int) System.currentTimeMillis())).booleanValue();
    }

    public final String AFAdRevenueData() {
        return (String) getMonetizationNetwork(new Object[]{this}, -211782084, 211782085, System.identityHashCode(this));
    }

    public final Map<String, Object> AFAdRevenueData(Map<String, Object> map) {
        int i = 2 % 2;
        AFc1hSDK aFc1hSDK = new AFc1hSDK(map, this.AFAdRevenueData.getCurrencyIso4217Code);
        int i2 = toString + 115;
        component2 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 33 / 0;
        }
        return aFc1hSDK;
    }

    public final void AFAdRevenueData(AFc1kSDK aFc1kSDK) {
        int i = 2 % 2;
        this.getRevenue = System.currentTimeMillis();
        this.getMonetizationNetwork = component4().getMediationNetwork(getMonetizationNetwork(aFc1kSDK), this.AFAdRevenueData.getCurrencyIso4217Code, new AFf1jSDK.AFa1ySDK() { // from class: com.appsflyer.internal.AFf1kSDK.3
            @Override // com.appsflyer.internal.AFf1jSDK.AFa1ySDK
            public final void getMonetizationNetwork(String str, Exception exc) {
                AFf1kSDK.this.getMediationNetwork = new ConcurrentHashMap();
                String message = exc.getMessage();
                if (message == null) {
                    message = "unknown";
                }
                AFf1kSDK.this.areAllFieldsValid();
                AFf1kSDK.this.getMediationNetwork.put("error", message);
                AFLogger.afErrorLog(str, exc, true, true, false);
            }

            @Override // com.appsflyer.internal.AFf1jSDK.AFa1ySDK
            public final void getRevenue(String str, String str2) {
                AFf1kSDK.this.getMediationNetwork = new ConcurrentHashMap();
                AFf1kSDK.this.getMediationNetwork.put("signedData", str);
                AFf1kSDK.this.getMediationNetwork.put("signature", str2);
                AFf1kSDK.this.areAllFieldsValid();
                AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
            }
        });
        int i2 = toString + 53;
        component2 = i2 % 128;
        int i3 = i2 % 2;
    }

    final void areAllFieldsValid() {
        int i = 2 % 2;
        int i2 = component2 + 17;
        toString = i2 % 128;
        this.getMediationNetwork.put("ttr", Long.valueOf(i2 % 2 == 0 ? System.currentTimeMillis() & this.getRevenue : System.currentTimeMillis() - this.getRevenue));
        this.getMediationNetwork.put("lvl_timestamp", Long.valueOf(component2()));
    }

    public final Map<String, Object> getCurrencyIso4217Code() {
        int i = 2 % 2;
        HashMap map = new HashMap();
        if (!component3()) {
            if (this.getMonetizationNetwork) {
                this.getMediationNetwork = new HashMap();
                areAllFieldsValid();
                this.getMediationNetwork.put("error", "pending LVL response");
                map.put("lvl", this.getMediationNetwork);
            }
            return map;
        }
        int i2 = toString + 53;
        component2 = i2 % 128;
        int i3 = i2 % 2;
        map.put("lvl", this.getMediationNetwork);
        int i4 = toString + 59;
        component2 = i4 % 128;
        int i5 = i4 % 2;
        return map;
    }

    public final void getCurrencyIso4217Code(String str) {
        getMonetizationNetwork(new Object[]{this, str}, 1176564115, -1176564113, System.identityHashCode(this));
    }

    public final Map<String, Object> getMediationNetwork(Map<String, Object> map) {
        int i = 2 % 2;
        try {
            try {
                Object[] objArr = {map, this.AFAdRevenueData.getCurrencyIso4217Code};
                Object declaredConstructor = AFa1kSDK.i.get(1656961623);
                if (declaredConstructor == null) {
                    declaredConstructor = ((Class) AFa1kSDK.getMediationNetwork((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), AndroidCharacter.getMirror('0') - 11, 123 - (Process.myTid() >> 22))).getDeclaredConstructor(Map.class, Context.class);
                    AFa1kSDK.i.put(1656961623, declaredConstructor);
                }
                Map<String, Object> map2 = (Map) ((Constructor) declaredConstructor).newInstance(objArr);
                int i2 = toString + 69;
                component2 = i2 % 128;
                int i3 = i2 % 2;
                return map2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            AFLogger.INSTANCE.e(AFg1cSDK.ANTI_FRAUD, "AFCksmV3: reflection init failed", th2, false, false, true);
            return new HashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getMediationNetwork() {
        int i = 2 % 2;
        int i2 = toString + 101;
        component2 = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.getMonetizationNetwork;
        if (i3 != 0) {
            int i4 = 51 / 0;
            if (z) {
                if (!component3()) {
                    int i5 = component2;
                    int i6 = i5 + 21;
                    toString = i6 % 128;
                    int i7 = i6 % 2;
                    int i8 = i5 + 103;
                    toString = i8 % 128;
                    if (i8 % 2 != 0) {
                        return true;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
            }
        } else if (z) {
        }
        return false;
    }

    public final String getMonetizationNetwork() {
        int i = 2 % 2;
        int i2 = component2 + 3;
        toString = i2 % 128;
        int i3 = i2 % 2;
        String str = this.getCurrencyIso4217Code;
        if (i3 == 0) {
            int i4 = 56 / 0;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035 A[PHI: r3
      0x0035: PHI (r3v3 java.lang.String) = (r3v2 java.lang.String), (r3v10 java.lang.String) binds: [B:8:0x0033, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getRevenue(AFc1jSDK aFc1jSDK) {
        String revenue;
        String str;
        int i = 2 % 2;
        int i2 = toString + 73;
        component2 = i2 % 128;
        if (i2 % 2 != 0) {
            boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, true);
            revenue = aFc1jSDK.getRevenue("imeiCached", (String) null);
            if (z) {
                if (AFk1zSDK.getMediationNetwork(this.component1)) {
                    Context context = this.AFAdRevenueData.getCurrencyIso4217Code;
                    if (context == null || !getMediationNetwork(context)) {
                        str = null;
                    } else {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            str = (String) telephonyManager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonyManager, new Object[0]);
                            if (str == null) {
                                if (revenue != null) {
                                    AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(revenue)));
                                } else {
                                    revenue = null;
                                }
                            }
                        } catch (InvocationTargetException e) {
                            if (revenue != null) {
                                AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(revenue)));
                            } else {
                                revenue = null;
                            }
                            AFLogger.afErrorLog(new StringBuilder("WARNING: Can't collect IMEI because of missing permissions: ").append(e.getMessage()).toString(), e);
                        } catch (Exception e2) {
                            if (revenue != null) {
                                AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(revenue)));
                            } else {
                                revenue = null;
                            }
                            AFLogger.afErrorLog(new StringBuilder("WARNING: Can't collect IMEI: other reason: ").append(e2.getMessage()).toString(), e2);
                        }
                        str = revenue;
                    }
                } else if (this.component1 != null) {
                    int i3 = component2 + 109;
                    toString = i3 % 128;
                    int i4 = i3 % 2;
                    str = this.component1;
                }
            }
        } else {
            boolean z2 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, false);
            revenue = aFc1jSDK.getRevenue("imeiCached", (String) null);
            if (z2) {
            }
        }
        if (AFk1zSDK.getMediationNetwork(str)) {
            AFLogger.afInfoLog("IMEI was not collected.");
            return null;
        }
        int i5 = toString + 125;
        component2 = i5 % 128;
        if (i5 % 2 == 0) {
            aFc1jSDK.getMediationNetwork("imeiCached", str);
            return str;
        }
        aFc1jSDK.getMediationNetwork("imeiCached", str);
        throw null;
    }

    public final void getRevenue(String str) {
        int i = 2 % 2;
        int i2 = toString + 93;
        component2 = i2 % 128;
        int i3 = i2 % 2;
        this.getCurrencyIso4217Code = str;
        int i4 = component2 + 5;
        toString = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void getRevenue(boolean z) {
        int i = 2 % 2;
        int i2 = component2 + 87;
        toString = i2 % 128;
        int i3 = i2 % 2;
        this.component4 = z;
        int i4 = component2 + 109;
        toString = i4 % 128;
        if (i4 % 2 == 0) {
            throw null;
        }
    }

    public final boolean getRevenue() {
        int i = 2 % 2;
        int i2 = component2 + 7;
        toString = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.component4;
        int i4 = component2 + 111;
        toString = i4 % 128;
        int i5 = i4 % 2;
        return z;
    }
}
