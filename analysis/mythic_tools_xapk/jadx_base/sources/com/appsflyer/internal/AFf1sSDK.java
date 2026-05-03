package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1sSDK extends AFf1rSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFInAppEventType = 0;
    private static long AFKeystoreWrapper = -7016867683534703567L;
    private static int AFLogger = 1;
    private final AFc1fSDK copy;
    private final AFg1vSDK copydefault;
    private final String hashCode;
    private final AFc1kSDK toString;

    public AFf1sSDK(String str, AFd1zSDK aFd1zSDK) {
        super(new AFf1aSDK(), aFd1zSDK, str);
        this.toString = aFd1zSDK.AFAdRevenueData();
        this.copy = aFd1zSDK.registerClient();
        this.hashCode = str;
        this.copydefault = aFd1zSDK.areAllFieldsValid();
    }

    public static /* synthetic */ Object AFAdRevenueData(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~((~i) | (~i2));
        int i5 = ~i3;
        int i6 = (i * 829) + (i2 * 829) + ((i4 | (~(i5 | i | i2))) * (-828));
        int i7 = i | i2;
        if (i6 + ((i7 | i5) * (-828)) + ((~i7) * 828) == 1) {
            return getMediationNetwork(objArr);
        }
        AFf1sSDK aFf1sSDK = (AFf1sSDK) objArr[0];
        int i8 = 2 % 2;
        int i9 = AFInAppEventType + 9;
        AFLogger = i9 % 128;
        int i10 = i9 % 2;
        ((AFf1rSDK) aFf1sSDK).component2.getRevenue("sentRegisterRequestToAF", true);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        int i11 = AFLogger + 5;
        AFInAppEventType = i11 % 128;
        int i12 = i11 % 2;
        return null;
    }

    private static void a(String str, int i, Object[] objArr) {
        int i2 = 2 % 2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        AFk1qSDK aFk1qSDK = new AFk1qSDK();
        aFk1qSDK.getMonetizationNetwork = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        aFk1qSDK.getMediationNetwork = 0;
        while (aFk1qSDK.getMediationNetwork < cArr.length) {
            int i3 = $10 + 45;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[aFk1qSDK.getMediationNetwork] = (((long) cArr[aFk1qSDK.getMediationNetwork]) ^ (((long) aFk1qSDK.getMediationNetwork) * ((long) aFk1qSDK.getMonetizationNetwork))) ^ (AFKeystoreWrapper ^ 4058599813193289363L);
            aFk1qSDK.getMediationNetwork++;
        }
        char[] cArr2 = new char[length];
        aFk1qSDK.getMediationNetwork = 0;
        while (aFk1qSDK.getMediationNetwork < cArr.length) {
            int i5 = $11 + 1;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr2[aFk1qSDK.getMediationNetwork] = (char) jArr[aFk1qSDK.getMediationNetwork];
            aFk1qSDK.getMediationNetwork++;
        }
        String str2 = new String(cArr2);
        int i7 = $11 + 7;
        $10 = i7 % 128;
        if (i7 % 2 == 0) {
            objArr[0] = str2;
        } else {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    private void copydefault() {
        AFAdRevenueData(new Object[]{this}, 2011239149, -2011239149, System.identityHashCode(this));
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFf1sSDK aFf1sSDK = (AFf1sSDK) objArr[0];
        PackageManager packageManager = (PackageManager) objArr[1];
        int i = 2 % 2;
        int i2 = AFLogger + 13;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 != 0) {
            ApplicationInfo applicationInfo = aFf1sSDK.toString.n_().applicationInfo;
            throw null;
        }
        ApplicationInfo applicationInfo2 = aFf1sSDK.toString.n_().applicationInfo;
        if (applicationInfo2 == null) {
            int i3 = AFLogger + 15;
            AFInAppEventType = i3 % 128;
            int i4 = i3 % 2;
            return "";
        }
        String string = packageManager.getApplicationLabel(applicationInfo2).toString();
        int i5 = AFLogger + 59;
        AFInAppEventType = i5 % 128;
        int i6 = i5 % 2;
        return string;
    }

    private String s_(PackageManager packageManager) {
        return (String) AFAdRevenueData(new Object[]{this, packageManager}, -1805871763, 1805871764, System.identityHashCode(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if (r3.getCurrencyIso4217Code() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r10.getMonetizationNetwork("app_version_code", java.lang.Integer.toString(r9.toString.n_().versionCode));
        r10.getMonetizationNetwork("app_version_name", r9.toString.n_().versionName);
        r10.getMonetizationNetwork(com.facebook.internal.NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, (java.lang.String) AFAdRevenueData(new java.lang.Object[]{r9, r1.getPackageManager()}, -1805871763, 1805871764, java.lang.System.identityHashCode(r9)));
        r10.getMonetizationNetwork("installDate", com.appsflyer.internal.AFa1tSDK.getCurrencyIso4217Code(new java.text.SimpleDateFormat("yyyy-MM-dd_HHmmssZ", java.util.Locale.US), r9.toString.n_().firstInstallTime));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008b, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008c, code lost:
    
        com.appsflyer.AFLogger.afErrorLog("Exception while collecting application version info.", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0174, code lost:
    
        com.appsflyer.AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0180, code lost:
    
        throw new java.lang.IllegalStateException("CustomerUserId not set, register is not sent");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0188, code lost:
    
        throw new java.lang.IllegalStateException("Context is not provided, can't send register request");
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
    
        if (r1 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        if (r1 != null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // com.appsflyer.internal.AFf1rSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void AFAdRevenueData(AFh1sSDK aFh1sSDK) {
        Context context;
        AFa1tSDK mediationNetwork;
        AFb1mSDK aFb1mSDKL_;
        String strComponent1;
        int i = 2 % 2;
        int i2 = AFLogger + Imgproc.COLOR_YUV2RGB_YVYU;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 != 0) {
            super.AFAdRevenueData(aFh1sSDK);
            context = this.copy.getCurrencyIso4217Code;
            mediationNetwork = AFa1tSDK.getMediationNetwork();
            int i3 = 61 / 0;
        } else {
            super.AFAdRevenueData(aFh1sSDK);
            context = this.copy.getCurrencyIso4217Code;
            mediationNetwork = AFa1tSDK.getMediationNetwork();
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            aFh1sSDK.getMonetizationNetwork(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        aFb1mSDKL_ = AFb1jSDK.l_(context.getContentResolver());
        if (aFb1mSDKL_ != null) {
            aFh1sSDK.getMonetizationNetwork("amazon_aid", aFb1mSDKL_.getRevenue);
            aFh1sSDK.getMonetizationNetwork("amazon_aid_limit", String.valueOf(aFb1mSDKL_.getMonetizationNetwork));
            int i4 = AFLogger + 59;
            AFInAppEventType = i4 % 128;
            int i5 = i4 % 2;
        }
        aFh1sSDK.getMonetizationNetwork("devkey", ((AFe1bSDK) this).component1.getMonetizationNetwork());
        aFh1sSDK.getMonetizationNetwork("uid", AFb1iSDK.getCurrencyIso4217Code(this.toString.getCurrencyIso4217Code));
        aFh1sSDK.getMonetizationNetwork("af_gcm_token", this.hashCode);
        aFh1sSDK.getMonetizationNetwork("launch_counter", Integer.toString(((AFf1rSDK) this).component2.getCurrencyIso4217Code("appsFlyerCount", 0)));
        aFh1sSDK.getMonetizationNetwork(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        strComponent1 = this.toString.component1();
        if (strComponent1 == null) {
            int i6 = AFInAppEventType + 33;
            AFLogger = i6 % 128;
            int i7 = i6 % 2;
            aFh1sSDK.getMonetizationNetwork(AppsFlyerProperties.CHANNEL, strComponent1);
            return;
        }
        return;
        this.copydefault.getCurrencyIso4217Code(aFh1sSDK.AFAdRevenueData);
        aFh1sSDK.AFAdRevenueData.remove("ivc");
        String strAFAdRevenueData = AFa1tSDK.AFAdRevenueData();
        if (strAFAdRevenueData != null) {
            int i8 = AFLogger + 55;
            AFInAppEventType = i8 % 128;
            if (i8 % 2 != 0) {
                aFh1sSDK.getMonetizationNetwork("appUserId", strAFAdRevenueData);
                int i9 = 94 / 0;
            } else {
                aFh1sSDK.getMonetizationNetwork("appUserId", strAFAdRevenueData);
            }
        }
        try {
            aFh1sSDK.getMonetizationNetwork(AndroidContextPlugin.DEVICE_MODEL_KEY, Build.MODEL);
            Object[] objArr = new Object[1];
            a("뫀矡₡\udd5f踂", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 52529, objArr);
            aFh1sSDK.getMonetizationNetwork(((String) objArr[0]).intern(), Build.BRAND);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
        }
        aFb1mSDKL_ = AFb1jSDK.l_(context.getContentResolver());
        if (aFb1mSDKL_ != null) {
        }
        aFh1sSDK.getMonetizationNetwork("devkey", ((AFe1bSDK) this).component1.getMonetizationNetwork());
        aFh1sSDK.getMonetizationNetwork("uid", AFb1iSDK.getCurrencyIso4217Code(this.toString.getCurrencyIso4217Code));
        aFh1sSDK.getMonetizationNetwork("af_gcm_token", this.hashCode);
        aFh1sSDK.getMonetizationNetwork("launch_counter", Integer.toString(((AFf1rSDK) this).component2.getCurrencyIso4217Code("appsFlyerCount", 0)));
        aFh1sSDK.getMonetizationNetwork(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        strComponent1 = this.toString.component1();
        if (strComponent1 == null) {
        }
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void component3(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 31;
        AFInAppEventType = i2 % 128;
        int i3 = i2 % 2;
        String monetizationNetwork = this.toString.getMonetizationNetwork();
        if (monetizationNetwork != null) {
            int i4 = AFInAppEventType + 91;
            AFLogger = i4 % 128;
            if (i4 % 2 == 0) {
                aFh1sSDK.getMonetizationNetwork("advertiserId", monetizationNetwork);
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            aFh1sSDK.getMonetizationNetwork("advertiserId", monetizationNetwork);
        }
        int i5 = AFInAppEventType + 29;
        AFLogger = i5 % 128;
        int i6 = i5 % 2;
    }

    @Override // com.appsflyer.internal.AFf1rSDK, com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        int i = 2 % 2;
        int i2 = AFInAppEventType + 7;
        int i3 = i2 % 128;
        AFLogger = i3;
        int i4 = i2 % 2;
        int i5 = i3 + 85;
        AFInAppEventType = i5 % 128;
        if (i5 % 2 == 0) {
            return false;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFInAppEventType + 115;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void getMediationNetwork(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 125;
        AFInAppEventType = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        int i = 2 % 2;
        int i2 = AFInAppEventType + 61;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
        super.getMonetizationNetwork();
        ResponseNetwork responseNetwork = ((AFe1bSDK) this).component4;
        if (responseNetwork != null) {
            int i4 = AFLogger + 97;
            AFInAppEventType = i4 % 128;
            int i5 = i4 % 2;
            if (responseNetwork.isSuccessful()) {
                int i6 = AFInAppEventType + 47;
                AFLogger = i6 % 128;
                int i7 = i6 % 2;
                AFAdRevenueData(new Object[]{this}, 2011239149, -2011239149, System.identityHashCode(this));
            }
        }
        int i8 = AFLogger + 95;
        AFInAppEventType = i8 % 128;
        int i9 = i8 % 2;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void getMonetizationNetwork(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFInAppEventType + 7;
        AFLogger = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    protected final void getRevenue(AFh1sSDK aFh1sSDK) {
        int i = 2 % 2;
        int i2 = AFLogger + 19;
        AFInAppEventType = i2 % 128;
        int i3 = i2 % 2;
    }
}
