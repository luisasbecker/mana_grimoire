package com.appsflyer.internal;

import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AFf1rSDK extends AFe1bSDK<String> {
    private static final AFe1lSDK[] registerClient = {AFe1lSDK.DLSDK, AFe1lSDK.ONELINK, AFe1lSDK.REGISTER};
    private final AFc1fSDK AFInAppEventParameterName;
    private final AFf1gSDK AFLogger;
    protected final AFc1jSDK component2;
    private final AFc1kSDK copy;
    private final AFf1mSDK copydefault;
    protected final AFg1vSDK equals;
    private final AFe1vSDK hashCode;
    private final AFh1sSDK toString;

    public AFf1rSDK(AFh1sSDK aFh1sSDK, AFd1zSDK aFd1zSDK) {
        this(aFh1sSDK, aFd1zSDK, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1rSDK(AFh1sSDK aFh1sSDK, AFd1zSDK aFd1zSDK, String str) {
        super(aFh1sSDK.getRevenue(), new AFe1lSDK[]{AFe1lSDK.RC_CDN, AFe1lSDK.FETCH_ADVERTISING_ID}, aFd1zSDK, str);
        this.toString = aFh1sSDK;
        this.hashCode = aFd1zSDK.AFInAppEventType();
        this.component2 = aFd1zSDK.getMediationNetwork();
        this.copydefault = aFd1zSDK.component3();
        this.AFInAppEventParameterName = aFd1zSDK.registerClient();
        this.copy = aFd1zSDK.AFAdRevenueData();
        this.equals = aFd1zSDK.areAllFieldsValid();
        this.AFLogger = aFd1zSDK.force();
        for (AFe1lSDK aFe1lSDK : registerClient) {
            if (this.getMonetizationNetwork == aFe1lSDK) {
                return;
            }
        }
        int i = this.toString.component1;
        AFe1lSDK aFe1lSDK2 = this.getMonetizationNetwork;
        if (i > 0) {
            this.getMediationNetwork.add(AFe1lSDK.CONVERSION);
        } else if (aFe1lSDK2 != AFe1lSDK.CONVERSION) {
            this.getRevenue.add(AFe1lSDK.CONVERSION);
        }
    }

    protected void AFAdRevenueData(AFh1sSDK aFh1sSDK) {
        try {
            try {
                getRevenue(aFh1sSDK);
                getMonetizationNetwork(aFh1sSDK);
                getMediationNetwork(aFh1sSDK);
                getCurrencyIso4217Code(aFh1sSDK);
                component3(aFh1sSDK);
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.QUEUE, "Error while collecting payload params", th, true, true, false);
            }
            if (aFh1sSDK.getMonetizationNetwork()) {
                aFh1sSDK.getCurrencyIso4217Code(((AFe1bSDK) this).component1.AFAdRevenueData(aFh1sSDK.AFAdRevenueData));
                aFh1sSDK.getCurrencyIso4217Code(((AFe1bSDK) this).component1.getMediationNetwork(aFh1sSDK.AFAdRevenueData));
            }
            if (aFh1sSDK.component4()) {
                aFh1sSDK.getCurrencyIso4217Code(((AFe1bSDK) this).component1.getCurrencyIso4217Code());
            }
            Set<AFe1lSDK> set = this.getRevenue;
            boolean z = set.contains(AFe1lSDK.LAUNCH) || set.contains(AFe1lSDK.CONVERSION);
            if (component3() && z) {
                aFh1sSDK.getMonetizationNetwork(this.component2.getCurrencyIso4217Code("appsFlyerCount", 0));
            }
            if (aFh1sSDK.component3()) {
                Map<String, Object> mapAFAdRevenueData = AFj1cSDK.AFAdRevenueData(aFh1sSDK.AFAdRevenueData);
                AFe1vSDK aFe1vSDK = this.hashCode;
                AFe1zSDK aFe1zSDK = new AFe1zSDK(aFe1vSDK.getCurrencyIso4217Code(), aFe1vSDK.getMonetizationNetwork(), AFe1vSDK.getMediationNetwork() ? AFe1sSDK.DEFAULT : AFe1sSDK.API);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", aFe1zSDK.AFAdRevenueData);
                if (aFe1zSDK.getMonetizationNetwork != AFe1sSDK.DEFAULT) {
                    jSONObject.put(FirebaseAnalytics.Param.METHOD, aFe1zSDK.getMonetizationNetwork.getCurrencyIso4217Code);
                }
                String str = aFe1zSDK.getMediationNetwork;
                if (str != null && !StringsKt.isBlank(str)) {
                    jSONObject.put("prefix", aFe1zSDK.getMediationNetwork);
                }
                mapAFAdRevenueData.put(DiagnosticsTracker.HOST_KEY, jSONObject);
            }
            if (this.copy.getMediationNetwork("AF_PREINSTALL_DISABLED")) {
                AFj1cSDK.AFAdRevenueData(aFh1sSDK.AFAdRevenueData).put("preinstall_disabled", Boolean.TRUE);
            }
            this.AFLogger.getCurrencyIso4217Code(aFh1sSDK.AFAdRevenueData, aFh1sSDK.getRevenue());
        } catch (Throwable th2) {
            AFLogger.INSTANCE.e(AFg1cSDK.QUEUE, "Error while preparing to send event", th2, true, true, false);
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return this.toString.getCurrencyIso4217Code;
    }

    protected void component3(AFh1sSDK aFh1sSDK) {
        this.equals.getRevenue(aFh1sSDK);
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected boolean copy() {
        return true;
    }

    protected void getCurrencyIso4217Code(AFh1sSDK aFh1sSDK) {
        this.equals.getMonetizationNetwork(aFh1sSDK);
    }

    protected void getMediationNetwork(AFh1sSDK aFh1sSDK) {
        this.equals.getMediationNetwork(aFh1sSDK);
    }

    protected void getMonetizationNetwork(AFh1sSDK aFh1sSDK) {
        this.equals.getRevenue(aFh1sSDK.AFAdRevenueData);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f  */
    @Override // com.appsflyer.internal.AFe1bSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final AFd1fSDK<String> getRevenue(String str) {
        double d;
        JSONObject jSONObject;
        String string;
        String strReplaceAll;
        Exception exc;
        String str2;
        AFAdRevenueData(this.toString);
        if (this.toString.AFAdRevenueData.containsKey("meta")) {
            try {
                d = this.copydefault.getCurrencyIso4217Code.AFAdRevenueData.getMediationNetwork.getMonetizationNetwork.getCurrencyIso4217Code;
            } catch (NullPointerException unused) {
                d = 1.0d;
            }
            if (AFh1sSDK.getMonetizationNetwork(d)) {
                this.toString.AFAdRevenueData.remove("meta");
            }
        }
        AFd1mSDK aFd1mSDK = ((AFe1bSDK) this).component3;
        AFd1fSDK<String> aFd1fSDK = (AFd1fSDK) AFd1mSDK.getCurrencyIso4217Code(new Object[]{aFd1mSDK, this.toString, str, this.AFInAppEventParameterName}, -846475552, 846475554, System.identityHashCode(aFd1mSDK));
        Map<String, Object> map = this.toString.AFAdRevenueData;
        try {
            jSONObject = new JSONObject(map);
            try {
                string = jSONObject.toString();
                try {
                } catch (NullPointerException e) {
                    e = e;
                    AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "JSONObject return null String object. Trying to create AFJsonObject.", e);
                    try {
                        Object[] objArr = {map};
                        Object method = AFa1kSDK.i.get(2037700457);
                        if (method == null) {
                            method = ((Class) AFa1kSDK.getMediationNetwork((char) TextUtils.indexOf("", ""), (ViewConfiguration.getTouchSlop() >> 8) + 37, (Process.myPid() >> 22) + 197)).getMethod("getRevenue", Map.class);
                            AFa1kSDK.i.put(2037700457, method);
                        }
                        String str3 = (String) ((Method) method).invoke(null, objArr);
                        try {
                            if (str3 == null) {
                                throw new NullPointerException("JSON toString of eventParams map returns null");
                            }
                            strReplaceAll = str3.replaceAll("\\p{C}", "*Non-printing character*");
                            string = str3;
                        } catch (NullPointerException e2) {
                            e = e2;
                            string = str3;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFJsonObject return null String object.", e);
                            strReplaceAll = "";
                        } catch (Exception e3) {
                            exc = e3;
                            string = str3;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", exc, false, false, true);
                            strReplaceAll = "";
                        } catch (Throwable th) {
                            th = th;
                            string = str3;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Unexpected error", th);
                            strReplaceAll = "";
                        }
                    } catch (Throwable th2) {
                        try {
                            Throwable cause = th2.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th2;
                        } catch (NullPointerException e4) {
                            e = e4;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFJsonObject return null String object.", e);
                            strReplaceAll = "";
                            if (string != null) {
                            }
                            if (strReplaceAll.equals(str2)) {
                            }
                            AFg1fSDK.AFAdRevenueData(new StringBuilder().append(this).append(": preparing data: ").toString(), jSONObject);
                            ((AFe1bSDK) this).areAllFieldsValid.getMonetizationNetwork(aFd1fSDK != null ? aFd1fSDK.getMediationNetwork.AFAdRevenueData : null, strReplaceAll);
                            return aFd1fSDK;
                        } catch (Exception e5) {
                            exc = e5;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "AFFinalizer: reflection init failed.", exc, false, false, true);
                            strReplaceAll = "";
                            if (string != null) {
                            }
                            if (strReplaceAll.equals(str2)) {
                            }
                            AFg1fSDK.AFAdRevenueData(new StringBuilder().append(this).append(": preparing data: ").toString(), jSONObject);
                            ((AFe1bSDK) this).areAllFieldsValid.getMonetizationNetwork(aFd1fSDK != null ? aFd1fSDK.getMediationNetwork.AFAdRevenueData : null, strReplaceAll);
                            return aFd1fSDK;
                        } catch (Throwable th3) {
                            th = th3;
                            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Unexpected error", th);
                            strReplaceAll = "";
                            if (string != null) {
                            }
                            if (strReplaceAll.equals(str2)) {
                            }
                            AFg1fSDK.AFAdRevenueData(new StringBuilder().append(this).append(": preparing data: ").toString(), jSONObject);
                            ((AFe1bSDK) this).areAllFieldsValid.getMonetizationNetwork(aFd1fSDK != null ? aFd1fSDK.getMediationNetwork.AFAdRevenueData : null, strReplaceAll);
                            return aFd1fSDK;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Unexpected error", th);
                    strReplaceAll = "";
                }
            } catch (NullPointerException e6) {
                e = e6;
                string = null;
            } catch (Throwable th5) {
                th = th5;
                string = null;
            }
        } catch (NullPointerException e7) {
            e = e7;
            jSONObject = null;
            string = null;
        } catch (Throwable th6) {
            th = th6;
            jSONObject = null;
            string = null;
        }
        if (string == null) {
            throw new NullPointerException("JSON toString of eventParams map returns null");
        }
        strReplaceAll = string.replaceAll("\\p{C}", "*Non-printing character*");
        str2 = string != null ? string : "";
        if (strReplaceAll.equals(str2)) {
            AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "Payload contains non-printing characters");
            try {
                jSONObject = new JSONObject(strReplaceAll);
            } catch (JSONException e8) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Couldn't parse the payload to a json object", e8);
            }
        } else {
            strReplaceAll = str2;
        }
        AFg1fSDK.AFAdRevenueData(new StringBuilder().append(this).append(": preparing data: ").toString(), jSONObject);
        ((AFe1bSDK) this).areAllFieldsValid.getMonetizationNetwork(aFd1fSDK != null ? aFd1fSDK.getMediationNetwork.AFAdRevenueData : null, strReplaceAll);
        return aFd1fSDK;
    }

    protected void getRevenue(AFh1sSDK aFh1sSDK) {
        this.equals.getCurrencyIso4217Code(aFh1sSDK);
    }
}
