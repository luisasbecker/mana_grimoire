package com.appsflyer.internal;

import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.camera.video.AudioStats;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1mSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int component2 = 0;
    private static long component3 = 0;
    private static int copy = 1;
    private static char equals;
    private static String getCurrencyIso4217Code;
    public static String getRevenue;
    private static int toString;
    private final AppsFlyerProperties AFAdRevenueData;
    private final AFf1kSDK areAllFieldsValid;
    private final AFe1vSDK component1;
    private final AFj1kSDK component4;
    private final AFc1kSDK getMediationNetwork;
    private final AFd1oSDK getMonetizationNetwork;

    static {
        getMediationNetwork();
        getRevenue = "https://%sgcdsdk.%s/install_data/v5.0/";
        getCurrencyIso4217Code = "https://%sonelink.%s/shortlink-sdk/v2";
        int i = copy + 37;
        toString = i % 128;
        int i2 = i % 2;
    }

    public AFd1mSDK(AFd1oSDK aFd1oSDK, AFc1kSDK aFc1kSDK, AppsFlyerProperties appsFlyerProperties, AFe1vSDK aFe1vSDK, AFj1kSDK aFj1kSDK, AFf1kSDK aFf1kSDK) {
        this.getMonetizationNetwork = aFd1oSDK;
        this.getMediationNetwork = aFc1kSDK;
        this.AFAdRevenueData = appsFlyerProperties;
        this.component1 = aFe1vSDK;
        this.component4 = aFj1kSDK;
        this.areAllFieldsValid = aFf1kSDK;
    }

    private <T> AFd1fSDK<T> AFAdRevenueData(AFd1cSDK aFd1cSDK, AFe1wSDK<T> aFe1wSDK, boolean z) {
        int i = 2 % 2;
        aFd1cSDK.getCurrencyIso4217Code = z;
        AFd1oSDK aFd1oSDK = this.getMonetizationNetwork;
        AFd1fSDK<T> aFd1fSDK = new AFd1fSDK<>(aFd1cSDK, aFd1oSDK.getMonetizationNetwork, aFd1oSDK.getRevenue, aFe1wSDK);
        int i2 = toString + 29;
        copy = i2 % 128;
        if (i2 % 2 != 0) {
            return aFd1fSDK;
        }
        throw null;
    }

    private boolean AFAdRevenueData() {
        int i = 2 % 2;
        int i2 = toString + 49;
        copy = i2 % 128;
        int i3 = i2 % 2;
        AppsFlyerProperties appsFlyerProperties = this.AFAdRevenueData;
        if (i3 != 0 ? appsFlyerProperties.getBoolean(AppsFlyerProperties.HTTP_CACHE, true) : appsFlyerProperties.getBoolean(AppsFlyerProperties.HTTP_CACHE, false)) {
            return false;
        }
        int i4 = copy + 107;
        toString = i4 % 128;
        int i5 = i4 % 2;
        return true;
    }

    private static void a(String str, int i, String str2, char c, String str3, Object[] objArr) {
        char[] charArray;
        int i2 = 2 % 2;
        int i3 = $11 + 17;
        $10 = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        char[] charArray2 = str3 != null ? str3.toCharArray() : str3;
        if (str2 != null) {
            charArray = str2.toCharArray();
            int i4 = $10 + 45;
            $11 = i4 % 128;
            int i5 = i4 % 2;
        } else {
            charArray = str2;
        }
        char[] cArr = charArray;
        char[] charArray3 = str != null ? str.toCharArray() : str;
        AFk1hSDK aFk1hSDK = new AFk1hSDK();
        int length = charArray3.length;
        char[] cArr2 = new char[length];
        int length2 = cArr.length;
        char[] cArr3 = new char[length2];
        System.arraycopy(charArray3, 0, cArr2, 0, length);
        System.arraycopy(cArr, 0, cArr3, 0, length2);
        cArr2[0] = (char) (cArr2[0] ^ c);
        cArr3[2] = (char) (cArr3[2] + ((char) i));
        int length3 = charArray2.length;
        char[] cArr4 = new char[length3];
        aFk1hSDK.AFAdRevenueData = 0;
        while (aFk1hSDK.AFAdRevenueData < length3) {
            int i6 = $10 + 105;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = (aFk1hSDK.AFAdRevenueData + 2) % 4;
            int i9 = (aFk1hSDK.AFAdRevenueData + 3) % 4;
            aFk1hSDK.getCurrencyIso4217Code = (char) (((cArr2[aFk1hSDK.AFAdRevenueData % 4] * 32718) + cArr3[i8]) % 65535);
            cArr3[i9] = (char) (((cArr2[i9] * 32718) + cArr3[i8]) / 65535);
            cArr2[i9] = aFk1hSDK.getCurrencyIso4217Code;
            cArr4[aFk1hSDK.AFAdRevenueData] = (char) (((((long) (cArr2[i9] ^ charArray2[aFk1hSDK.AFAdRevenueData])) ^ (component3 ^ 3492843682015808844L)) ^ ((long) ((int) (((long) component2) ^ 3492843682015808844L)))) ^ ((long) ((char) (((long) equals) ^ 3492843682015808844L))));
            aFk1hSDK.AFAdRevenueData++;
        }
        objArr[0] = new String(cArr4);
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1mSDK aFd1mSDK = (AFd1mSDK) objArr[0];
        int i = 2 % 2;
        HashMap map = new HashMap();
        map.put("build_number", "6.18.0");
        map.put("counter", Integer.valueOf(aFd1mSDK.getMediationNetwork.getCurrencyIso4217Code.getCurrencyIso4217Code("appsFlyerCount", 0)));
        map.put(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL);
        Object[] objArr2 = new Object[1];
        a("糯\uf4ba醲ᕼ", View.resolveSizeAndState(0, 0, 0) - 1292584324, "\u0000\u0000\u0000\u0000", (char) (TextUtils.lastIndexOf("", '0', 0) + 31890), "鷋蝗\uebe1黗⟿", objArr2);
        map.put(((String) objArr2[0]).intern(), Build.BRAND);
        map.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        map.put("app_version_name", aFd1mSDK.getMediationNetwork.n_().versionName);
        map.put("app_id", aFd1mSDK.getMediationNetwork.getRevenue.getCurrencyIso4217Code.getPackageName());
        map.put("platformextension", new AFa1vSDK().getRevenue());
        int i2 = copy + 115;
        toString = i2 % 128;
        if (i2 % 2 == 0) {
            return map;
        }
        throw null;
    }

    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * (-300)) + (i2 * 302) + ((~(i | i2 | i3)) * (-301));
        int i5 = ~i2;
        int i6 = i4 + (((~(i5 | i3)) | (~((~i3) | i))) * (-301)) + (((~((~i) | i3)) | i5) * 301);
        return i6 != 1 ? i6 != 2 ? getMediationNetwork(objArr) : getMonetizationNetwork(objArr) : getCurrencyIso4217Code(objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        String revenue;
        AFd1mSDK aFd1mSDK = (AFd1mSDK) objArr[0];
        Map map = (Map) objArr[1];
        String str = (String) objArr[2];
        String str2 = (String) objArr[3];
        int i = 2 % 2;
        try {
            Object[] objArr2 = {map, str};
            Object method = AFa1kSDK.i.get(-1325765758);
            if (method == null) {
                method = ((Class) AFa1kSDK.getMediationNetwork((char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 38 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 197 - (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                AFa1kSDK.i.put(-1325765758, method);
            }
            byte[] bArr = (byte[]) ((Method) method).invoke(null, objArr2);
            int i2 = copy + 23;
            toString = i2 % 128;
            if (i2 % 2 != 0) {
                AFj1kSDK aFj1kSDK = aFd1mSDK.component4;
                throw null;
            }
            AFj1kSDK aFj1kSDK2 = aFd1mSDK.component4;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                int i3 = copy + 1;
                toString = i3 % 128;
                int i4 = i3 % 2;
                revenue = aFj1kSDK2.getMonetizationNetwork.getRevenue("https://%sars.%s/api/v2/android/validate_subscription?app_id=");
            } else {
                String str4 = str2;
                if (!new Regex("4.?(\\d+)?.?(\\d+)").matches(str4) && !new Regex("3.?(\\d+)?.?(\\d+)").matches(str4)) {
                    revenue = aFj1kSDK2.getMonetizationNetwork.getRevenue("https://%sars.%s/api/v2/android/validate_subscription_v2?app_id=");
                }
            }
            return aFd1mSDK.getRevenue(new AFd1cSDK(aFj1kSDK2.getRevenue(aFj1kSDK2.AFAdRevenueData(revenue), false), bArr, ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFd1aSDK());
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (Throwable th2) {
                AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th2, false, false);
                return null;
            }
        }
    }

    static void getMediationNetwork() {
        component3 = 3492843682015808844L;
        component2 = -1434120884;
        equals = (char) 13050;
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        String revenue;
        String revenue2;
        AFd1mSDK aFd1mSDK = (AFd1mSDK) objArr[0];
        AFh1sSDK aFh1sSDK = (AFh1sSDK) objArr[1];
        int i = 2 % 2;
        try {
            try {
                Object[] objArr2 = {aFh1sSDK, (String) objArr[2], (AFc1fSDK) objArr[3]};
                Object method = AFa1kSDK.i.get(-191513370);
                if (method == null) {
                    method = ((Class) AFa1kSDK.getMediationNetwork((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.MeasureSpec.getMode(0) + 37, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 196)).getMethod("AFAdRevenueData", AFh1sSDK.class, String.class, AFc1fSDK.class);
                    AFa1kSDK.i.put(-191513370, method);
                }
                byte[] bArr = (byte[]) ((Method) method).invoke(null, objArr2);
                aFd1mSDK.getMonetizationNetwork(aFh1sSDK, bArr);
                AFj1kSDK aFj1kSDK = aFd1mSDK.component4;
                Intrinsics.checkNotNullParameter(aFh1sSDK, "");
                boolean zAFAdRevenueData = aFh1sSDK.AFAdRevenueData();
                boolean z = aFh1sSDK instanceof AFh1qSDK;
                boolean z2 = aFh1sSDK instanceof AFh1nSDK;
                boolean z3 = aFh1sSDK instanceof AFh1pSDK;
                boolean z4 = aFh1sSDK instanceof AFh1hSDK;
                boolean z5 = aFh1sSDK instanceof AFh1fSDK;
                boolean z6 = aFh1sSDK instanceof AFf1aSDK;
                if (aFh1sSDK instanceof AFh1eSDK) {
                    revenue = aFj1kSDK.getMonetizationNetwork.getRevenue("https://%spia.%s/api/v1.0/pia-android-event?app_id=");
                } else if (z3 || z2) {
                    revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.getCurrencyIso4217Code);
                } else if (z) {
                    revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.AFAdRevenueData);
                } else if (z4) {
                    int i2 = copy + 9;
                    toString = i2 % 128;
                    int i3 = i2 % 2;
                    revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.component1);
                } else {
                    if (z5) {
                        int i4 = copy + 93;
                        toString = i4 % 128;
                        if (i4 % 2 != 0) {
                            aFj1kSDK.getMonetizationNetwork.getRevenue("https://%ssdk-services.%s/validate-android-signature");
                            throw null;
                        }
                        revenue2 = aFj1kSDK.getMonetizationNetwork.getRevenue("https://%ssdk-services.%s/validate-android-signature");
                        AFd1fSDK revenue3 = aFd1mSDK.getRevenue(new AFd1cSDK(revenue2, bArr, ShareTarget.METHOD_POST, aFh1sSDK.getRevenue, aFh1sSDK.getMediationNetwork()), new AFd1aSDK());
                        int i5 = toString + 123;
                        copy = i5 % 128;
                        int i6 = i5 % 2;
                        return revenue3;
                    }
                    if (z6) {
                        revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.component3);
                    } else if (!zAFAdRevenueData) {
                        revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.component4);
                    } else if (aFh1sSDK.component1 < 2) {
                        revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.getRevenue);
                        int i7 = copy + 25;
                        toString = i7 % 128;
                        int i8 = i7 % 2;
                    } else {
                        revenue = aFj1kSDK.getMonetizationNetwork.getRevenue(AFj1kSDK.component2);
                    }
                }
                revenue2 = aFj1kSDK.getRevenue(AFj1kSDK.getMediationNetwork(aFj1kSDK.AFAdRevenueData(revenue), z), z6);
                AFd1fSDK revenue32 = aFd1mSDK.getRevenue(new AFd1cSDK(revenue2, bArr, ShareTarget.METHOD_POST, aFh1sSDK.getRevenue, aFh1sSDK.getMediationNetwork()), new AFd1aSDK());
                int i52 = toString + 123;
                copy = i52 % 128;
                int i62 = i52 % 2;
                return revenue32;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", th2, false, false);
            return null;
        }
    }

    private static String getMonetizationNetwork(String str, String str2, String... strArr) {
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String currencyIso4217Code = AFj1jSDK.getCurrencyIso4217Code(TextUtils.join("\u2063", (String[]) arrayList.toArray(new String[0])), new StringBuilder().append(str).append(str2).append("v2").toString());
        int i2 = copy + Imgproc.COLOR_YUV2RGB_YVYU;
        toString = i2 % 128;
        int i3 = i2 % 2;
        return currencyIso4217Code;
    }

    private void getMonetizationNetwork(AFh1sSDK aFh1sSDK, byte[] bArr) {
        int i = 2 % 2;
        int i2 = copy + 59;
        toString = i2 % 128;
        int i3 = i2 % 2;
        boolean mediationNetwork = this.getMediationNetwork.getMediationNetwork("com.appsflyer.security.enable");
        if (aFh1sSDK.getMonetizationNetwork() && mediationNetwork && AFf1kSDK.getRevenue(aFh1sSDK, this.getMediationNetwork)) {
            int i4 = toString + 5;
            copy = i4 % 128;
            int i5 = i4 % 2;
            AFf1kSDK.getMonetizationNetwork(new Object[]{aFh1sSDK, bArr}, -254860318, 254860321, (int) System.currentTimeMillis());
        }
    }

    private <T> AFd1fSDK<T> getRevenue(AFd1cSDK aFd1cSDK, AFe1wSDK<T> aFe1wSDK) {
        int i = 2 % 2;
        int i2 = copy + 25;
        toString = i2 % 128;
        if (i2 % 2 != 0) {
            AFAdRevenueData(aFd1cSDK, aFe1wSDK, AFAdRevenueData());
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        AFd1fSDK<T> aFd1fSDKAFAdRevenueData = AFAdRevenueData(aFd1cSDK, aFe1wSDK, AFAdRevenueData());
        int i3 = toString + 105;
        copy = i3 % 128;
        int i4 = i3 % 2;
        return aFd1fSDKAFAdRevenueData;
    }

    private Map<String, Object> getRevenue() {
        return (Map) getCurrencyIso4217Code(new Object[]{this}, 27881414, -27881413, System.identityHashCode(this));
    }

    public final AFd1fSDK<AFh1cSDK> AFAdRevenueData(boolean z, boolean z2, String str, int i) {
        String str2;
        String str3;
        int i2 = 2 % 2;
        AFe1vSDK aFe1vSDK = this.component1;
        Intrinsics.checkNotNullParameter(str, "");
        String str4 = z ? AFe1vSDK.getMediationNetwork : AFe1vSDK.getMonetizationNetwork;
        if (z2) {
            int i3 = copy + 47;
            toString = i3 % 128;
            int i4 = i3 % 2;
            str2 = "stg";
        } else {
            str2 = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        if (AFe1vSDK.getMediationNetwork()) {
            int i5 = toString + Imgproc.COLOR_YUV2RGBA_YVYU;
            copy = i5 % 128;
            int i6 = i5 % 2;
            str3 = (String) aFe1vSDK.getRevenue.getValue();
        } else {
            str3 = "";
        }
        String str5 = String.format(str4, Arrays.copyOf(new Object[]{str3, str2, aFe1vSDK.getCurrencyIso4217Code(), str}, 4));
        Intrinsics.checkNotNullExpressionValue(str5, "");
        AFd1cSDK aFd1cSDK = new AFd1cSDK(str5, ShareTarget.METHOD_GET);
        aFd1cSDK.areAllFieldsValid = 1500;
        return getRevenue(aFd1cSDK, new AFd1eSDK());
    }

    public final AFd1nSDK AFAdRevenueData(Map<String, Object> map, String str) {
        int i = 2 % 2;
        int i2 = toString + 61;
        copy = i2 % 128;
        int i3 = i2 % 2;
        Object obj = null;
        try {
            try {
                Object[] objArr = {map, str};
                Object method = AFa1kSDK.i.get(-1325765758);
                if (method == null) {
                    method = ((Class) AFa1kSDK.getMediationNetwork((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 37 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getTapTimeout() >> 16) + 197)).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                    AFa1kSDK.i.put(-1325765758, method);
                }
                byte[] bArr = (byte[]) ((Method) method).invoke(null, objArr);
                if (bArr != null) {
                    return new AFd1nSDK(this.getMediationNetwork, bArr);
                }
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: failed to create bytes.", new IllegalArgumentException("Failed to create bytes from proxyData, bytes are null"), false, false);
                int i4 = copy + 7;
                toString = i4 % 128;
                if (i4 % 2 == 0) {
                    return null;
                }
                obj.hashCode();
                throw null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", th2, false, false);
            return null;
        }
    }

    public final AFd1fSDK<AFa1mSDK> getCurrencyIso4217Code(AFa1pSDK aFa1pSDK) {
        int i = 2 % 2;
        AFd1fSDK<AFa1mSDK> revenue = getRevenue(new AFd1cSDK(aFa1pSDK.component3, AFg1lSDK.getMonetizationNetwork(aFa1pSDK.AFAdRevenueData).toString().getBytes(Charset.defaultCharset()), ShareTarget.METHOD_POST, Collections.emptyMap(), aFa1pSDK.getMediationNetwork()), new AFa1rSDK());
        int i2 = toString + 93;
        copy = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 0 / 0;
        }
        return revenue;
    }

    public final AFd1fSDK<String> getCurrencyIso4217Code(String str) {
        int i = 2 % 2;
        AFd1cSDK aFd1cSDK = new AFd1cSDK(str, null, ShareTarget.METHOD_GET, Collections.emptyMap(), false);
        aFd1cSDK.areAllFieldsValid = 10000;
        aFd1cSDK.getMonetizationNetwork = false;
        AFd1fSDK<String> revenue = getRevenue(aFd1cSDK, new AFd1aSDK());
        int i2 = copy + 123;
        toString = i2 % 128;
        if (i2 % 2 == 0) {
            return revenue;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final AFd1fSDK<String> getCurrencyIso4217Code(String str, Map<String, String> map, String str2, UUID uuid, String str3) {
        int i = 2 % 2;
        String string = uuid.toString();
        HashMap map2 = new HashMap();
        map2.put("ttl", "-1");
        map2.put("uuid", string);
        map2.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, map);
        map2.put("meta", (Map) getCurrencyIso4217Code(new Object[]{this}, 27881414, -27881413, System.identityHashCode(this)));
        if (str2 != null) {
            int i2 = toString + 41;
            copy = i2 % 128;
            if (i2 % 2 == 0) {
                map2.put("brand_domain", str2);
                int i3 = 97 / 0;
            } else {
                map2.put("brand_domain", str2);
            }
            int i4 = toString + 13;
            copy = i4 % 128;
            int i5 = i4 % 2;
        }
        String string2 = AFg1lSDK.getMonetizationNetwork(map2).toString();
        HashMap map3 = new HashMap();
        Object[] objArr = new Object[1];
        a("縡⪔뽔ᒪ", (CdmaCellLocation.convertQuartSecToDecDegrees(0) > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == AudioStats.AUDIO_AMPLITUDE_NONE ? 0 : -1)), "\u0000\u0000\u0000\u0000", (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), "⍱\uf17a美꺶嚡ᗰ\uf25c藛鳡䢿\u2456擥", objArr);
        map3.put(((String) objArr[0]).intern(), getMonetizationNetwork(str3, string, ShareTarget.METHOD_POST, string2));
        return AFAdRevenueData(new AFd1cSDK(new StringBuilder().append(String.format(getCurrencyIso4217Code, AppsFlyerLib.getInstance().getHostPrefix(), AFa1tSDK.getMediationNetwork().getHostName())).append(DomExceptionUtils.SEPARATOR).append(str).toString(), string2.getBytes(Charset.defaultCharset()), ShareTarget.METHOD_POST, map3, false), new AFd1aSDK(), true);
    }

    public final AFd1fSDK<String> getMediationNetwork(AFh1sSDK aFh1sSDK, String str, AFc1fSDK aFc1fSDK) {
        return (AFd1fSDK) getCurrencyIso4217Code(new Object[]{this, aFh1sSDK, str, aFc1fSDK}, -846475552, 846475554, System.identityHashCode(this));
    }

    public final AFd1fSDK<Map<String, String>> getMediationNetwork(String str, String str2, UUID uuid, String str3) {
        int i = 2 % 2;
        String string = uuid.toString();
        String string2 = new StringBuilder().append(String.format(getCurrencyIso4217Code, AppsFlyerLib.getInstance().getHostPrefix(), AFa1tSDK.getMediationNetwork().getHostName())).append(DomExceptionUtils.SEPARATOR).append(str).append("?id=").append(str2).toString();
        Map map = (Map) getCurrencyIso4217Code(new Object[]{this}, 27881414, -27881413, System.identityHashCode(this));
        String strValueOf = String.valueOf(map.get("build_number"));
        HashMap map2 = new HashMap();
        map2.put("Af-UUID", uuid.toString());
        map2.put("Af-Meta-Sdk-Ver", strValueOf);
        map2.put("Af-Meta-Counter", String.valueOf(map.get("counter")));
        map2.put("Af-Meta-Model", String.valueOf(map.get(AndroidContextPlugin.DEVICE_MODEL_KEY)));
        map2.put("Af-Meta-Platform", String.valueOf(map.get("platformextension")));
        map2.put("Af-Meta-System-Version", String.valueOf(map.get(ServerProtocol.DIALOG_PARAM_SDK_VERSION)));
        Object[] objArr = new Object[1];
        a("縡⪔뽔ᒪ", ViewConfiguration.getFadingEdgeLength() >> 16, "\u0000\u0000\u0000\u0000", (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), "⍱\uf17a美꺶嚡ᗰ\uf25c藛鳡䢿\u2456擥", objArr);
        map2.put(((String) objArr[0]).intern(), getMonetizationNetwork(str3, string, ShareTarget.METHOD_GET, string, str, str2, strValueOf));
        AFd1fSDK<Map<String, String>> revenue = getRevenue(new AFd1cSDK(string2, null, ShareTarget.METHOD_GET, map2, false), new AFd1bSDK());
        int i2 = toString + 9;
        copy = i2 % 128;
        if (i2 % 2 != 0) {
            return revenue;
        }
        throw null;
    }

    public final AFd1fSDK<String> getMediationNetwork(Map<String, Object> map, String str) {
        int i = 2 % 2;
        int i2 = copy + 63;
        toString = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 != 0) {
                try {
                    Object[] objArr = {map, str};
                    Object method = AFa1kSDK.i.get(-1325765758);
                    if (method == null) {
                        method = ((Class) AFa1kSDK.getMediationNetwork((char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), View.MeasureSpec.getSize(0) + 37, TextUtils.lastIndexOf("", '0') + 198)).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                        AFa1kSDK.i.put(-1325765758, method);
                    }
                    obj.hashCode();
                    throw null;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            try {
                Object[] objArr2 = {map, str};
                Object method2 = AFa1kSDK.i.get(-1325765758);
                if (method2 == null) {
                    method2 = ((Class) AFa1kSDK.getMediationNetwork((char) TextUtils.getOffsetAfter("", 0), 37 - KeyEvent.keyCodeFromString(""), 197 - KeyEvent.normalizeMetaState(0))).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                    AFa1kSDK.i.put(-1325765758, method2);
                }
                byte[] bArr = (byte[]) ((Method) method2).invoke(null, objArr2);
                AFj1kSDK aFj1kSDK = this.component4;
                AFd1fSDK<String> revenue = getRevenue(new AFd1cSDK(aFj1kSDK.AFAdRevenueData(aFj1kSDK.getMonetizationNetwork.getRevenue("https://%svalidate-and-log.%s/api/v4.0/android/subscription/validateAndLog?app_id=")), bArr, ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFd1aSDK());
                int i3 = copy + 9;
                toString = i3 % 128;
                if (i3 % 2 == 0) {
                    return revenue;
                }
                throw null;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (Throwable th3) {
            AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th3, false, false);
            return null;
        }
        AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th3, false, false);
        return null;
    }

    public final AFd1fSDK<String> getMediationNetwork(Map<String, Object> map, String str, String str2) {
        String revenue;
        int i = 2 % 2;
        try {
            Object[] objArr = {map, str};
            Object method = AFa1kSDK.i.get(-1325765758);
            if (method == null) {
                method = ((Class) AFa1kSDK.getMediationNetwork((char) (ViewConfiguration.getEdgeSlop() >> 16), 37 - (ViewConfiguration.getPressedStateDuration() >> 16), Gravity.getAbsoluteGravity(0, 0) + 197)).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                AFa1kSDK.i.put(-1325765758, method);
            }
            byte[] bArr = (byte[]) ((Method) method).invoke(null, objArr);
            int i2 = toString + 51;
            copy = i2 % 128;
            int i3 = i2 % 2;
            AFj1kSDK aFj1kSDK = this.component4;
            String str3 = str2;
            if (str3 == null || str3.length() == 0 || new Regex("4.?(\\d+)?.?(\\d+)").matches(str3) || new Regex("3.?(\\d+)?.?(\\d+)").matches(str3)) {
                int i4 = toString;
                int i5 = i4 + 105;
                copy = i5 % 128;
                int i6 = i5 % 2;
                int i7 = i4 + 33;
                copy = i7 % 128;
                int i8 = i7 % 2;
                revenue = aFj1kSDK.getMonetizationNetwork.getRevenue("https://%sviap.%s/api/v1/android/validate_purchase?app_id=");
            } else {
                revenue = aFj1kSDK.getMonetizationNetwork.getRevenue("https://%sviap.%s/api/v1/android/validate_purchase_v2?app_id=");
            }
            return getRevenue(new AFd1cSDK(aFj1kSDK.getRevenue(aFj1kSDK.AFAdRevenueData(revenue), false), bArr, ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFd1aSDK());
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (Throwable th2) {
                AFLogger.INSTANCE.e(AFg1cSDK.ENGAGEMENT, "AFFinalizer: reflection init failed.", th2, false, false);
                return null;
            }
        }
    }

    public final AFd1fSDK<String> getMonetizationNetwork(Map<String, Object> map, String str, String str2) {
        return (AFd1fSDK) getCurrencyIso4217Code(new Object[]{this, map, str, str2}, 158494896, -158494896, System.identityHashCode(this));
    }

    public final AFd1fSDK<String> getRevenue(AFh1jSDK aFh1jSDK) {
        int i = 2 % 2;
        AFd1fSDK<String> revenue = getRevenue(new AFd1cSDK(aFh1jSDK.component3, aFh1jSDK.getCurrencyIso4217Code(), ShareTarget.METHOD_POST, aFh1jSDK.getRevenue, true), new AFd1aSDK());
        int i2 = toString + 111;
        copy = i2 % 128;
        if (i2 % 2 != 0) {
            return revenue;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final AFd1fSDK<Map<String, Object>> getRevenue(String str, String str2) {
        int i = 2 % 2;
        AFd1fSDK<Map<String, Object>> revenue = getRevenue(AFd1iSDK.getMonetizationNetwork(this.getMediationNetwork.getRevenue.getCurrencyIso4217Code.getPackageName(), AFb1iSDK.getCurrencyIso4217Code(this.getMediationNetwork.getCurrencyIso4217Code), str, str2), new AFd1gSDK());
        int i2 = toString + 91;
        copy = i2 % 128;
        if (i2 % 2 != 0) {
            return revenue;
        }
        throw null;
    }

    public final AFd1fSDK<String> getRevenue(Map<String, Object> map, String str) {
        byte[] bArr;
        int i = 2 % 2;
        int i2 = toString + 5;
        copy = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                try {
                    Object[] objArr = {map, str};
                    Object method = AFa1kSDK.i.get(-1325765758);
                    if (method == null) {
                        method = ((Class) AFa1kSDK.getMediationNetwork((char) Gravity.getAbsoluteGravity(0, 0), 36 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 197 - TextUtils.getOffsetBefore("", 0))).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                        AFa1kSDK.i.put(-1325765758, method);
                    }
                    bArr = (byte[]) ((Method) method).invoke(null, objArr);
                    int i3 = 17 / 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } else {
                try {
                    Object[] objArr2 = {map, str};
                    Object method2 = AFa1kSDK.i.get(-1325765758);
                    if (method2 == null) {
                        method2 = ((Class) AFa1kSDK.getMediationNetwork((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 38 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 196 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))).getMethod("getCurrencyIso4217Code", Map.class, String.class);
                        AFa1kSDK.i.put(-1325765758, method2);
                    }
                    bArr = (byte[]) ((Method) method2).invoke(null, objArr2);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            byte[] bArr2 = bArr;
            AFj1kSDK aFj1kSDK = this.component4;
            AFd1fSDK<String> revenue = getRevenue(new AFd1cSDK(aFj1kSDK.AFAdRevenueData(aFj1kSDK.getMonetizationNetwork.getRevenue("https://%svalidate-and-log.%s/api/v4.0/android/one_time_purchase/validateAndLog?app_id=")), bArr2, ShareTarget.METHOD_POST, Collections.emptyMap(), true), new AFd1aSDK());
            int i4 = toString + 99;
            copy = i4 % 128;
            if (i4 % 2 != 0) {
                return revenue;
            }
            throw null;
        } catch (Throwable th3) {
            AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th3, false, false);
            return null;
        }
    }
}
