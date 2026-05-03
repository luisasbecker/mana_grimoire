package com.appsflyer.internal;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1xSDK;
import com.facebook.internal.ServerProtocol;
import com.google.common.net.HttpHeaders;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1wSDK implements AFd1xSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int copy = 1;
    private static int copydefault = 0;
    private static int equals = 400809482;
    private final Lazy AFAdRevenueData;
    private final Lazy areAllFieldsValid;
    private final String component1;
    private final Lazy component2;
    private AFd1xSDK.AFa1tSDK component3;
    private final Lazy component4;
    private final Lazy getCurrencyIso4217Code;
    private AFd1zSDK getMediationNetwork;
    private final Lazy getMonetizationNetwork;
    private final Lazy getRevenue;

    public AFd1wSDK(AFd1zSDK aFd1zSDK) {
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        this.getMediationNetwork = aFd1zSDK;
        this.getRevenue = LazyKt.lazy(new Function0<AFf1mSDK>() { // from class: com.appsflyer.internal.AFd1wSDK.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getRevenue, reason: merged with bridge method [inline-methods] */
            public final AFf1mSDK invoke() {
                AFf1mSDK aFf1mSDKComponent3 = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).component3();
                Intrinsics.checkNotNullExpressionValue(aFf1mSDKComponent3, "");
                return aFf1mSDKComponent3;
            }
        });
        this.AFAdRevenueData = LazyKt.lazy(new Function0<AFc1kSDK>() { // from class: com.appsflyer.internal.AFd1wSDK.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final AFc1kSDK invoke() {
                AFc1kSDK aFc1kSDKAFAdRevenueData = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).AFAdRevenueData();
                Intrinsics.checkNotNullExpressionValue(aFc1kSDKAFAdRevenueData, "");
                return aFc1kSDKAFAdRevenueData;
            }
        });
        this.getCurrencyIso4217Code = LazyKt.lazy(new Function0<AFc1jSDK>() { // from class: com.appsflyer.internal.AFd1wSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final AFc1jSDK invoke() {
                AFc1jSDK mediationNetwork = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).getMediationNetwork();
                Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
                return mediationNetwork;
            }
        });
        this.getMonetizationNetwork = LazyKt.lazy(new Function0<AFf1kSDK>() { // from class: com.appsflyer.internal.AFd1wSDK.10
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getRevenue, reason: merged with bridge method [inline-methods] */
            public final AFf1kSDK invoke() {
                AFf1kSDK aFf1kSDKAFInAppEventParameterName = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).AFInAppEventParameterName();
                Intrinsics.checkNotNullExpressionValue(aFf1kSDKAFInAppEventParameterName, "");
                return aFf1kSDKAFInAppEventParameterName;
            }
        });
        this.component4 = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFd1wSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final ExecutorService invoke() {
                ExecutorService currencyIso4217Code = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).getCurrencyIso4217Code();
                Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
                return currencyIso4217Code;
            }
        });
        this.component1 = "6.18.0";
        this.component2 = LazyKt.lazy(new Function0<AFd1ySDK>() { // from class: com.appsflyer.internal.AFd1wSDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getMediationNetwork, reason: merged with bridge method [inline-methods] */
            public final AFd1ySDK invoke() {
                AFc1fSDK aFc1fSDKRegisterClient = AFd1wSDK.getMonetizationNetwork(AFd1wSDK.this).registerClient();
                Intrinsics.checkNotNullExpressionValue(aFc1fSDKRegisterClient, "");
                return new AFd1ySDK(aFc1fSDKRegisterClient);
            }
        });
        this.areAllFieldsValid = LazyKt.lazy(new Function0<AFd1uSDK>() { // from class: com.appsflyer.internal.AFd1wSDK.7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: getRevenue, reason: merged with bridge method [inline-methods] */
            public final AFd1uSDK invoke() {
                return new AFd1uSDK(AFd1wSDK.this.AFAdRevenueData());
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027 A[PHI: r4
      0x0027: PHI (r4v6 com.appsflyer.internal.AFh1cSDK) = (r4v5 com.appsflyer.internal.AFh1cSDK), (r4v15 com.appsflyer.internal.AFh1cSDK) binds: [B:8:0x0025, B:5:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFh1cSDK aFh1cSDK;
        AFd1wSDK aFd1wSDK = (AFd1wSDK) objArr[0];
        int i = 2 % 2;
        int i2 = copy + 69;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFf1mSDK monetizationNetwork = aFd1wSDK.getMonetizationNetwork();
        if (i3 != 0) {
            aFh1cSDK = monetizationNetwork.getCurrencyIso4217Code.AFAdRevenueData;
            int i4 = 52 / 0;
            if (aFh1cSDK != null) {
                AFh1aSDK aFh1aSDK = aFh1cSDK.getMediationNetwork;
                if (aFh1aSDK != null) {
                    return aFh1aSDK.getCurrencyIso4217Code;
                }
            }
        } else {
            aFh1cSDK = monetizationNetwork.getCurrencyIso4217Code.AFAdRevenueData;
            if (aFh1cSDK != null) {
            }
        }
        int i5 = copydefault + 99;
        copy = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 96 / 0;
        }
        return null;
    }

    private final Map<String, String> AFAdRevenueData(AFh1bSDK aFh1bSDK) {
        int i = 2 % 2;
        Object[] objArr = new Object[1];
        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 144, View.MeasureSpec.getMode(0) + 1, false, 5 - TextUtils.indexOf("", "", 0, 0), "�\ufffb\u000b\ufffa\u0007", objArr);
        Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to(((String) objArr[0]).intern(), Build.BRAND), TuplesKt.to(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL), TuplesKt.to("app_id", getMediationNetwork().getRevenue.getCurrencyIso4217Code.getPackageName()), TuplesKt.to("p_ex", new AFa1vSDK().getRevenue()), TuplesKt.to("api", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to(ServerProtocol.DIALOG_PARAM_SDK_VERSION, this.component1), TuplesKt.to("uid", AFb1iSDK.getCurrencyIso4217Code(getMediationNetwork().getCurrencyIso4217Code)), TuplesKt.to("exc_config", aFh1bSDK.getMonetizationNetwork()));
        int i2 = copydefault + 99;
        copy = i2 % 128;
        int i3 = i2 % 2;
        return mapMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFAdRevenueData(AFd1wSDK aFd1wSDK) {
        int i = 2 % 2;
        int i2 = copydefault + 85;
        copy = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFd1wSDK, "");
        aFd1wSDK.copydefault();
        int i4 = copydefault + 105;
        copy = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFAdRevenueData(AFd1wSDK aFd1wSDK, Throwable th, String str) {
        int i = 2 % 2;
        Intrinsics.checkNotNullParameter(aFd1wSDK, "");
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        AFh1bSDK aFh1bSDK = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{aFd1wSDK}, 1447743159, -1447743158, System.identityHashCode(aFd1wSDK));
        if (aFh1bSDK != null) {
            int i2 = copydefault + 35;
            copy = i2 % 128;
            int i3 = i2 % 2;
            if (aFd1wSDK.getMonetizationNetwork(aFh1bSDK)) {
                aFd1wSDK.AFAdRevenueData().getCurrencyIso4217Code(th, str);
            }
        }
        int i4 = copy + 7;
        copydefault = i4 % 128;
        int i5 = i4 % 2;
    }

    private static void a(int i, int i2, boolean z, int i3, String str, Object[] objArr) {
        int i4 = 2 % 2;
        int i5 = $10 + 29;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        AFk1jSDK aFk1jSDK = new AFk1jSDK();
        char[] cArr2 = new char[i3];
        aFk1jSDK.getMonetizationNetwork = 0;
        while (aFk1jSDK.getMonetizationNetwork < i3) {
            int i7 = $10 + 97;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            aFk1jSDK.getMediationNetwork = cArr[aFk1jSDK.getMonetizationNetwork];
            cArr2[aFk1jSDK.getMonetizationNetwork] = (char) (aFk1jSDK.getMediationNetwork + i);
            int i9 = aFk1jSDK.getMonetizationNetwork;
            cArr2[i9] = (char) (cArr2[i9] - ((int) (((long) equals) ^ 4333921468659523104L)));
            aFk1jSDK.getMonetizationNetwork++;
        }
        if (i2 > 0) {
            int i10 = $10 + Imgproc.COLOR_YUV2RGBA_YVYU;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            aFk1jSDK.AFAdRevenueData = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - aFk1jSDK.AFAdRevenueData, aFk1jSDK.AFAdRevenueData);
            System.arraycopy(cArr3, aFk1jSDK.AFAdRevenueData, cArr2, 0, i3 - aFk1jSDK.AFAdRevenueData);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            aFk1jSDK.getMonetizationNetwork = 0;
            while (aFk1jSDK.getMonetizationNetwork < i3) {
                cArr4[aFk1jSDK.getMonetizationNetwork] = cArr2[(i3 - aFk1jSDK.getMonetizationNetwork) - 1];
                aFk1jSDK.getMonetizationNetwork++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    private final AFc1jSDK areAllFieldsValid() {
        int i = 2 % 2;
        int i2 = copy + 45;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFc1jSDK aFc1jSDK = (AFc1jSDK) this.getCurrencyIso4217Code.getValue();
        int i4 = copydefault + 81;
        copy = i4 % 128;
        if (i4 % 2 != 0) {
            return aFc1jSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final AFf1kSDK component1() {
        int i = 2 % 2;
        int i2 = copy + 11;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFf1kSDK aFf1kSDK = (AFf1kSDK) this.getMonetizationNetwork.getValue();
        int i4 = copydefault + 103;
        copy = i4 % 128;
        if (i4 % 2 != 0) {
            return aFf1kSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final ExecutorService component2() {
        return (ExecutorService) getCurrencyIso4217Code(new Object[]{this}, -1790300569, 1790300573, System.identityHashCode(this));
    }

    private final AFh1bSDK component3() {
        return (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
    }

    private AFd1vSDK component4() {
        int i = 2 % 2;
        int i2 = copy + 119;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFd1vSDK aFd1vSDK = (AFd1vSDK) this.areAllFieldsValid.getValue();
        if (i3 != 0) {
            int i4 = 28 / 0;
        }
        int i5 = copy + 73;
        copydefault = i5 % 128;
        if (i5 % 2 == 0) {
            return aFd1vSDK;
        }
        throw null;
    }

    private final synchronized void copy() {
        boolean monetizationNetwork;
        int i = 2 % 2;
        int i2 = copydefault + 39;
        copy = i2 % 128;
        int i3 = i2 % 2;
        AFh1bSDK aFh1bSDK = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
        if (aFh1bSDK != null) {
            if (aFh1bSDK.AFAdRevenueData == -1) {
                areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_to_server_window");
                int i4 = 2 % 2;
            } else if (areAllFieldsValid().getMediationNetwork("af_send_exc_to_server_window", -1L) == -1) {
                int i5 = copydefault + 57;
                copy = i5 % 128;
                int i6 = i5 % 2;
                getCurrencyIso4217Code(aFh1bSDK);
            }
            monetizationNetwork = getMonetizationNetwork(aFh1bSDK);
        } else {
            monetizationNetwork = false;
        }
        AFd1xSDK.AFa1tSDK aFa1tSDK = this.component3;
        if (aFa1tSDK != null) {
            aFa1tSDK.onConfigurationChanged(monetizationNetwork);
            int i7 = copy + 35;
            copydefault = i7 % 128;
            int i8 = i7 % 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void copydefault() {
        long j;
        Integer numValueOf;
        String str;
        String str2;
        int iIntValue;
        String value;
        Integer intOrNull;
        String value2;
        Integer intOrNull2;
        String value3;
        Integer intOrNull3;
        int i = 2 % 2;
        AFh1bSDK aFh1bSDK = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
        if (aFh1bSDK != null) {
            j = aFh1bSDK.getMediationNetwork;
        } else {
            int i2 = copy + 41;
            copydefault = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 2 % 2;
            }
            j = -1;
        }
        if (j < TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())) {
            AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "TTL is already passed", false, 4, null);
            areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_to_server_window");
            AFAdRevenueData().getMediationNetwork();
            return;
        }
        AFh1bSDK aFh1bSDK2 = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
        if (aFh1bSDK2 == null) {
            areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_to_server_window");
            AFAdRevenueData().getMediationNetwork();
        } else if (getRevenue(aFh1bSDK2)) {
            AFh1bSDK aFh1bSDK3 = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
            Pair<Integer, Integer> currencyIso4217Code = null;
            if (aFh1bSDK3 != null) {
                int i4 = copy + 65;
                copydefault = i4 % 128;
                if (i4 % 2 != 0) {
                    String str3 = aFh1bSDK3.getMonetizationNetwork;
                    currencyIso4217Code.hashCode();
                    throw null;
                }
                String str4 = aFh1bSDK3.getMonetizationNetwork;
                if (str4 != null) {
                    Intrinsics.checkNotNullParameter(str4, "");
                    MatchResult matchResultMatchEntire = new Regex("(\\d+).(\\d+).(\\d+).*").matchEntire(str4);
                    if (matchResultMatchEntire != null) {
                        MatchGroup matchGroup = matchResultMatchEntire.getGroups().get(1);
                        int iIntValue2 = ((matchGroup == null || (value3 = matchGroup.getValue()) == null || (intOrNull3 = StringsKt.toIntOrNull(value3)) == null) ? 0 : intOrNull3.intValue()) * 1000000;
                        MatchGroup matchGroup2 = matchResultMatchEntire.getGroups().get(2);
                        int iIntValue3 = iIntValue2 + (((matchGroup2 == null || (value2 = matchGroup2.getValue()) == null || (intOrNull2 = StringsKt.toIntOrNull(value2)) == null) ? 0 : intOrNull2.intValue()) * 1000);
                        MatchGroup matchGroup3 = matchResultMatchEntire.getGroups().get(3);
                        iIntValue = iIntValue3 + ((matchGroup3 == null || (value = matchGroup3.getValue()) == null || (intOrNull = StringsKt.toIntOrNull(value)) == null) ? 0 : intOrNull.intValue());
                    } else {
                        iIntValue = -1;
                    }
                    numValueOf = Integer.valueOf(iIntValue);
                    int i5 = 2 % 2;
                } else {
                    numValueOf = null;
                }
                AFh1bSDK aFh1bSDK4 = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
                Pair<Integer, Integer> mediationNetwork = (aFh1bSDK4 == null || (str2 = aFh1bSDK4.getMonetizationNetwork) == null) ? null : AFd1pSDK.getMediationNetwork(str2);
                AFh1bSDK aFh1bSDK5 = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
                if (aFh1bSDK5 != null && (str = aFh1bSDK5.getMonetizationNetwork) != null) {
                    currencyIso4217Code = AFd1pSDK.getCurrencyIso4217Code(str);
                }
                if (numValueOf != null && numValueOf.intValue() == -1) {
                    if (mediationNetwork != null) {
                        AFAdRevenueData().AFAdRevenueData(mediationNetwork.getFirst().intValue(), mediationNetwork.getSecond().intValue());
                    } else if (currencyIso4217Code != null) {
                        AFAdRevenueData().AFAdRevenueData(currencyIso4217Code.getFirst().intValue(), currencyIso4217Code.getSecond().intValue());
                    } else {
                        areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_to_server_window");
                        AFAdRevenueData().getMediationNetwork();
                    }
                } else if (mediationNetwork == null) {
                    AFAdRevenueData().getRevenue(this.component1);
                    int i6 = 2 % 2;
                }
            }
        } else {
            int i7 = copy + 109;
            copydefault = i7 % 128;
            if (i7 % 2 == 0) {
                int i8 = 2 % 2;
            }
            areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_to_server_window");
            AFAdRevenueData().getMediationNetwork();
        }
        AFd1xSDK.AFa1tSDK aFa1tSDK = this.component3;
        if (aFa1tSDK != null) {
            AFh1bSDK aFh1bSDK6 = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
            aFa1tSDK.onConfigurationChanged(aFh1bSDK6 != null ? getMonetizationNetwork(aFh1bSDK6) : false);
        }
    }

    private final void equals() {
        int i = 2 % 2;
        AFh1bSDK aFh1bSDK = (AFh1bSDK) getCurrencyIso4217Code(new Object[]{this}, 1447743159, -1447743158, System.identityHashCode(this));
        if (aFh1bSDK != null) {
            int i2 = copy + 69;
            copydefault = i2 % 128;
            int i3 = i2 % 2;
            if (!getMediationNetwork(aFh1bSDK)) {
                AFg1hSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "skipping", false, 4, null);
                return;
            }
            String monetizationNetwork = component1().getMonetizationNetwork();
            if (monetizationNetwork != null) {
                String string = new JSONObject((Map) getCurrencyIso4217Code(new Object[]{AFAdRevenueData(aFh1bSDK), AFAdRevenueData().AFAdRevenueData()}, -1431128038, 1431128041, (int) System.currentTimeMillis())).toString();
                Intrinsics.checkNotNullExpressionValue(string, "");
                Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
                getCurrencyIso4217Code(string, monetizationNetwork);
                int i4 = copy + 33;
                copydefault = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 40 / 0;
                }
            }
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        final AFd1wSDK aFd1wSDK = (AFd1wSDK) objArr[0];
        final Throwable th = (Throwable) objArr[1];
        final String str = (String) objArr[2];
        int i = 2 % 2;
        int i2 = copydefault + 119;
        copy = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getCurrencyIso4217Code(new Object[]{aFd1wSDK}, -1790300569, 1790300573, System.identityHashCode(aFd1wSDK))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1wSDK$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AFd1wSDK.AFAdRevenueData(this.f$0, th, str);
            }
        });
        int i4 = copydefault + 49;
        copy = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 23 / 0;
        }
        return null;
    }

    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~((~i) | i2);
        int i5 = (i * 71) + (i2 * (-69)) + (((~(i2 | i3)) | i4) * (-140)) + ((~(i | i2 | i3)) * 70) + (((~(i | i3)) | (~((~i2) | i)) | i4) * 70);
        if (i5 == 1) {
            return AFAdRevenueData(objArr);
        }
        if (i5 != 2) {
            return i5 != 3 ? i5 != 4 ? getCurrencyIso4217Code(objArr) : getRevenue(objArr) : getMonetizationNetwork(objArr);
        }
        AFd1wSDK aFd1wSDK = (AFd1wSDK) objArr[0];
        AFh1bSDK aFh1bSDK = (AFh1bSDK) objArr[1];
        int i6 = 2 % 2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long mediationNetwork = aFd1wSDK.areAllFieldsValid().getMediationNetwork("af_send_exc_to_server_window", -1L);
        if (aFh1bSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis)) {
            int i7 = copydefault + Imgproc.COLOR_YUV2RGB_YVYU;
            copy = i7 % 128;
            return Boolean.valueOf(i7 % 2 == 0);
        }
        if (mediationNetwork != -1) {
            int i8 = copydefault + 95;
            copy = i8 % 128;
            int i9 = i8 % 2;
            if (mediationNetwork >= jCurrentTimeMillis) {
                return Boolean.valueOf(aFd1wSDK.getRevenue(aFh1bSDK));
            }
        }
        return false;
    }

    private static Map<String, Object> getCurrencyIso4217Code(Map<String, ? extends Object> map, List<AFc1bSDK> list) {
        return (Map) getCurrencyIso4217Code(new Object[]{map, list}, -1431128038, 1431128041, (int) System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(AFd1wSDK aFd1wSDK) {
        int i = 2 % 2;
        int i2 = copydefault + 25;
        copy = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFd1wSDK, "");
        aFd1wSDK.copy();
        int i4 = copy + 59;
        copydefault = i4 % 128;
        int i5 = i4 % 2;
    }

    private final void getCurrencyIso4217Code(AFh1bSDK aFh1bSDK) {
        int i;
        long jCurrentTimeMillis;
        int i2 = 2 % 2;
        int i3 = copydefault + 13;
        copy = i3 % 128;
        if (i3 % 2 == 0) {
            i = aFh1bSDK.getCurrencyIso4217Code;
            jCurrentTimeMillis = System.currentTimeMillis() | TimeUnit.DAYS.toMillis(aFh1bSDK.AFAdRevenueData);
        } else {
            i = aFh1bSDK.getCurrencyIso4217Code;
            jCurrentTimeMillis = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(aFh1bSDK.AFAdRevenueData);
        }
        AFc1jSDK aFc1jSDKAreAllFieldsValid = areAllFieldsValid();
        aFc1jSDKAreAllFieldsValid.getRevenue("af_send_exc_to_server_window", jCurrentTimeMillis);
        aFc1jSDKAreAllFieldsValid.AFAdRevenueData("af_send_exc_min", i);
        int i4 = copy + Imgproc.COLOR_YUV2RGB_YVYU;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 3 / 0;
        }
    }

    private final void getCurrencyIso4217Code(String str, String str2) {
        int i = 2 % 2;
        int i2 = copy + 97;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        component4().getMediationNetwork(bytes, MapsKt.mapOf(TuplesKt.to(HttpHeaders.AUTHORIZATION, AFj1jSDK.getCurrencyIso4217Code(str, str2))), 2000);
        int i4 = copydefault + 115;
        copy = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final AFc1kSDK getMediationNetwork() {
        int i = 2 % 2;
        int i2 = copy + 31;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFc1kSDK aFc1kSDK = (AFc1kSDK) this.AFAdRevenueData.getValue();
        int i4 = copydefault + 53;
        copy = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 91 / 0;
        }
        return aFc1kSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1wSDK aFd1wSDK) {
        int i = 2 % 2;
        int i2 = copydefault + 111;
        copy = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(aFd1wSDK, "");
        aFd1wSDK.equals();
        int i4 = copy + Imgproc.COLOR_YUV2RGB_YVYU;
        copydefault = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    private final boolean getMediationNetwork(AFh1bSDK aFh1bSDK) {
        int currencyIso4217Code;
        int i = 2 % 2;
        int i2 = copydefault + 109;
        copy = i2 % 128;
        if (i2 % 2 == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            areAllFieldsValid().getMediationNetwork("af_send_exc_to_server_window", -1L);
            long j = aFh1bSDK.getMediationNetwork;
            TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis);
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long mediationNetwork = areAllFieldsValid().getMediationNetwork("af_send_exc_to_server_window", -1L);
        if (aFh1bSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis2)) {
            int i3 = copy + 47;
            copydefault = i3 % 128;
            int i4 = i3 % 2;
            return false;
        }
        if (mediationNetwork != -1 && mediationNetwork >= jCurrentTimeMillis2 && (currencyIso4217Code = areAllFieldsValid().getCurrencyIso4217Code("af_send_exc_min", -1)) != -1) {
            int i5 = copydefault + 71;
            copy = i5 % 128;
            int i6 = i5 % 2;
            if (AFAdRevenueData().getRevenue() >= currencyIso4217Code) {
                return getRevenue(aFh1bSDK);
            }
        }
        return false;
    }

    public static final /* synthetic */ AFd1zSDK getMonetizationNetwork(AFd1wSDK aFd1wSDK) {
        int i = 2 % 2;
        int i2 = copy;
        int i3 = i2 + 113;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        AFd1zSDK aFd1zSDK = aFd1wSDK.getMediationNetwork;
        int i5 = i2 + 33;
        copydefault = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 90 / 0;
        }
        return aFd1zSDK;
    }

    private final AFf1mSDK getMonetizationNetwork() {
        int i = 2 % 2;
        int i2 = copydefault + 45;
        copy = i2 % 128;
        int i3 = i2 % 2;
        AFf1mSDK aFf1mSDK = (AFf1mSDK) this.getRevenue.getValue();
        int i4 = copydefault + 77;
        copy = i4 % 128;
        int i5 = i4 % 2;
        return aFf1mSDK;
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        Map map = (Map) objArr[0];
        List list = (List) objArr[1];
        int i = 2 % 2;
        int i2 = copy + 71;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("deviceInfo", map), TuplesKt.to("excs", AFd1sSDK.getMediationNetwork((List<AFc1bSDK>) list)));
        int i4 = copy + Imgproc.COLOR_YUV2RGBA_YVYU;
        copydefault = i4 % 128;
        if (i4 % 2 == 0) {
            return mapMapOf;
        }
        throw null;
    }

    private final boolean getMonetizationNetwork(AFh1bSDK aFh1bSDK) {
        return ((Boolean) getCurrencyIso4217Code(new Object[]{this, aFh1bSDK}, 1535825086, -1535825084, System.identityHashCode(this))).booleanValue();
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFd1wSDK aFd1wSDK = (AFd1wSDK) objArr[0];
        int i = 2 % 2;
        int i2 = copy + 57;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        ExecutorService executorService = (ExecutorService) aFd1wSDK.component4.getValue();
        if (i3 != 0) {
            int i4 = 65 / 0;
        }
        return executorService;
    }

    private final boolean getRevenue(AFh1bSDK aFh1bSDK) {
        int i = 2 % 2;
        new AFd1rSDK();
        String str = this.component1;
        String str2 = aFh1bSDK.getMonetizationNetwork;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        boolean revenue = AFd1rSDK.getRevenue(str, str2);
        int i2 = copydefault + 107;
        copy = i2 % 128;
        int i3 = i2 % 2;
        return revenue;
    }

    public final AFc1aSDK AFAdRevenueData() {
        int i = 2 % 2;
        int i2 = copy + 43;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        AFc1aSDK aFc1aSDK = (AFc1aSDK) this.component2.getValue();
        if (i3 != 0) {
            throw null;
        }
        int i4 = copydefault + 89;
        copy = i4 % 128;
        int i5 = i4 % 2;
        return aFc1aSDK;
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getCurrencyIso4217Code() {
        int i = 2 % 2;
        int i2 = copy + 123;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        ((ExecutorService) getCurrencyIso4217Code(new Object[]{this}, -1790300569, 1790300573, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1wSDK$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AFd1wSDK.getMediationNetwork(this.f$0);
            }
        });
        int i4 = copydefault + 105;
        copy = i4 % 128;
        int i5 = i4 % 2;
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getMediationNetwork(Throwable th, String str) {
        getCurrencyIso4217Code(new Object[]{this, th, str}, 1429511836, -1429511836, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getMonetizationNetwork(AFd1xSDK.AFa1tSDK aFa1tSDK) {
        int i = 2 % 2;
        int i2 = copy + 57;
        copydefault = i2 % 128;
        if (i2 % 2 != 0) {
            this.component3 = aFa1tSDK;
            ((ExecutorService) getCurrencyIso4217Code(new Object[]{this}, -1790300569, 1790300573, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1wSDK$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1wSDK.AFAdRevenueData(this.f$0);
                }
            });
            throw null;
        }
        this.component3 = aFa1tSDK;
        ((ExecutorService) getCurrencyIso4217Code(new Object[]{this}, -1790300569, 1790300573, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1wSDK$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AFd1wSDK.AFAdRevenueData(this.f$0);
            }
        });
        int i3 = copy + Imgproc.COLOR_YUV2RGBA_YVYU;
        copydefault = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 69 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getRevenue() {
        int i = 2 % 2;
        int i2 = copydefault + 47;
        copy = i2 % 128;
        int i3 = i2 % 2;
        ((ExecutorService) getCurrencyIso4217Code(new Object[]{this}, -1790300569, 1790300573, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1wSDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AFd1wSDK.getCurrencyIso4217Code(this.f$0);
            }
        });
        int i4 = copydefault + 51;
        copy = i4 % 128;
        int i5 = i4 % 2;
    }
}
