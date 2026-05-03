package com.appsflyer.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class AFf1zSDK extends AFe1bSDK<Map<String, String>> {
    private final UUID AFLogger;
    public AFa1vSDK component2;
    private final AFd1mSDK copy;
    private String copydefault;
    private String equals;
    private String hashCode;
    private final boolean toString;

    public interface AFa1vSDK {
        void getMonetizationNetwork(Map<String, String> map);

        void getRevenue(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1zSDK(AFd1zSDK aFd1zSDK, UUID uuid, Uri uri) throws Throwable {
        super(AFe1lSDK.ONELINK, new AFe1lSDK[]{AFe1lSDK.RC_CDN}, aFd1zSDK, uuid.toString());
        boolean zBooleanValue = false;
        this.copy = aFd1zSDK.getRevenue();
        this.AFLogger = uuid;
        try {
            if (!AFk1zSDK.getMediationNetwork(uri.getHost()) && !AFk1zSDK.getMediationNetwork(uri.getPath())) {
                try {
                    Object[] objArr = {uri, aFd1zSDK.i()};
                    Object declaredConstructor = AFa1kSDK.i.get(-1523018365);
                    if (declaredConstructor == null) {
                        declaredConstructor = ((Class) AFa1kSDK.getMediationNetwork((char) (AndroidCharacter.getMirror('0') - '0'), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 37, KeyEvent.normalizeMetaState(0))).getDeclaredConstructor(Uri.class, AFa1oSDK.class);
                        AFa1kSDK.i.put(-1523018365, declaredConstructor);
                    }
                    Object objNewInstance = ((Constructor) declaredConstructor).newInstance(objArr);
                    try {
                        Object method = AFa1kSDK.i.get(275685916);
                        if (method == null) {
                            method = ((Class) AFa1kSDK.getMediationNetwork((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 37 - View.MeasureSpec.getSize(0), TextUtils.getCapsMode("", 0, 0))).getMethod("getMediationNetwork", null);
                            AFa1kSDK.i.put(275685916, method);
                        }
                        Object objInvoke = ((Method) method).invoke(objNewInstance, null);
                        try {
                            Object method2 = AFa1kSDK.i.get(-1366801308);
                            if (method2 == null) {
                                method2 = ((Class) AFa1kSDK.getMediationNetwork((char) (44102 - (KeyEvent.getMaxKeyCode() >> 16)), 50 - (ViewConfiguration.getPressedStateDuration() >> 16), View.MeasureSpec.getSize(0) + 37)).getMethod("getMediationNetwork", null);
                                AFa1kSDK.i.put(-1366801308, method2);
                            }
                            boolean zBooleanValue2 = ((Boolean) ((Method) method2).invoke(objInvoke, null)).booleanValue();
                            try {
                                Object method3 = AFa1kSDK.i.get(-1632086821);
                                if (method3 == null) {
                                    method3 = ((Class) AFa1kSDK.getMediationNetwork((char) ((-16733114) - Color.rgb(0, 0, 0)), 50 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), KeyEvent.keyCodeFromString("") + 37)).getMethod("getMonetizationNetwork", null);
                                    AFa1kSDK.i.put(-1632086821, method3);
                                }
                                zBooleanValue = ((Boolean) ((Method) method3).invoke(objInvoke, null)).booleanValue();
                                String[] strArrSplit = uri.getPath().split(DomExceptionUtils.SEPARATOR);
                                if (zBooleanValue2 && strArrSplit.length == 3) {
                                    this.hashCode = strArrSplit[1];
                                    this.copydefault = strArrSplit[2];
                                    this.equals = uri.toString();
                                }
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("OneLinkValidator: reflection init failed", e);
        }
        this.toString = zBooleanValue;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean a_() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return false;
    }

    public final boolean copydefault() {
        return (TextUtils.isEmpty(this.hashCode) || TextUtils.isEmpty(this.copydefault) || this.hashCode.equals(AndroidContextPlugin.APP_KEY)) ? false : true;
    }

    public final boolean equals() {
        return this.toString;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        super.getMonetizationNetwork();
        AFa1vSDK aFa1vSDK = this.component2;
        if (aFa1vSDK != null) {
            if (this.AFAdRevenueData == AFe1rSDK.SUCCESS && ((AFe1bSDK) this).component4 != null) {
                aFa1vSDK.getMonetizationNetwork((Map) ((AFe1bSDK) this).component4.getBody());
                return;
            }
            Throwable thComponent2 = component2();
            if (!(thComponent2 instanceof ParsingException)) {
                String str = this.equals;
                aFa1vSDK.getRevenue(str != null ? str : "Can't get OneLink data");
            } else if (((ParsingException) thComponent2).getRawResponse().isSuccessful()) {
                aFa1vSDK.getRevenue("Can't parse one link data");
            } else {
                String str2 = this.equals;
                aFa1vSDK.getRevenue(str2 != null ? str2 : "Can't get OneLink data");
            }
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AFd1fSDK<Map<String, String>> getRevenue(String str) {
        return this.copy.getMediationNetwork(this.hashCode, this.copydefault, this.AFLogger, str);
    }
}
