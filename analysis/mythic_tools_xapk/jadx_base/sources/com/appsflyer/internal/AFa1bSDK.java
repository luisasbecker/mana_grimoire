package com.appsflyer.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1zSDK;
import com.facebook.bolts.AppLinks;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFa1bSDK implements AFa1aSDK {
    private final AFc1fSDK AFAdRevenueData;
    Map<String, Object> getCurrencyIso4217Code;
    private boolean getRevenue;

    public static final class AFa1zSDK implements AFb1zSDK.AFa1vSDK {
        private /* synthetic */ long getRevenue;

        AFa1zSDK(long j) {
            this.getRevenue = j;
        }

        @Override // com.appsflyer.internal.AFb1zSDK.AFa1vSDK
        public final void getCurrencyIso4217Code(String str) {
            Map<String, Object> map = AFa1bSDK.this.getCurrencyIso4217Code;
            if (map != null) {
                map.put("error", str);
            }
        }

        @Override // com.appsflyer.internal.AFb1zSDK.AFa1vSDK
        public final void getCurrencyIso4217Code(String str, String str2, String str3) {
            Map<String, Object> map;
            if (str != null) {
                AFLogger.afInfoLog("Facebook Deferred AppLink data received: " + str);
                Map<String, Object> map2 = AFa1bSDK.this.getCurrencyIso4217Code;
                if (map2 != null) {
                    map2.put("link", str);
                }
                if (str2 != null && (map = AFa1bSDK.this.getCurrencyIso4217Code) != null) {
                    map.put("target_url", str2);
                }
                if (str3 != null) {
                    AFa1bSDK aFa1bSDK = AFa1bSDK.this;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("promo_code", str3);
                    linkedHashMap.put("deeplink_context", linkedHashMap2);
                    Map<String, Object> map3 = aFa1bSDK.getCurrencyIso4217Code;
                    if (map3 != null) {
                        map3.put(AppLinks.KEY_NAME_EXTRAS, linkedHashMap);
                    }
                }
            } else {
                Map<String, Object> map4 = AFa1bSDK.this.getCurrencyIso4217Code;
                if (map4 != null) {
                    map4.put("link", "");
                }
            }
            String strValueOf = String.valueOf(System.currentTimeMillis() - this.getRevenue);
            Map<String, Object> map5 = AFa1bSDK.this.getCurrencyIso4217Code;
            if (map5 != null) {
                map5.put("ttr", strValueOf);
            }
        }
    }

    public AFa1bSDK(AFc1fSDK aFc1fSDK) {
        Intrinsics.checkNotNullParameter(aFc1fSDK, "");
        this.AFAdRevenueData = aFc1fSDK;
    }

    private boolean AFAdRevenueData() {
        return this.getRevenue;
    }

    @Override // com.appsflyer.internal.AFa1aSDK
    public final void getCurrencyIso4217Code() {
        Context context;
        if (AFAdRevenueData() && (context = this.AFAdRevenueData.getCurrencyIso4217Code) != null) {
            this.getCurrencyIso4217Code = new LinkedHashMap();
            AFa1zSDK aFa1zSDK = new AFa1zSDK(System.currentTimeMillis());
            try {
                Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", Context.class).invoke(null, context);
                Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                Method method = cls.getMethod("fetchDeferredAppLinkData", Context.class, String.class, cls2);
                Object objNewProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.internal.AFb1zSDK.1
                    private /* synthetic */ AFa1vSDK getCurrencyIso4217Code;
                    private /* synthetic */ Class getMediationNetwork;

                    AnonymousClass1(Class cls3, AFa1vSDK aFa1zSDK2) {
                        cls = cls3;
                        aFa1vSDK = aFa1zSDK2;
                    }

                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                        String string;
                        String string2;
                        String string3;
                        Bundle bundle;
                        if (!method2.getName().equals("onDeferredAppLinkDataFetched")) {
                            AFa1vSDK aFa1vSDK = aFa1vSDK;
                            if (aFa1vSDK != null) {
                                aFa1vSDK.getCurrencyIso4217Code("onDeferredAppLinkDataFetched invocation failed");
                            }
                            return null;
                        }
                        Object obj2 = objArr[0];
                        if (obj2 != null) {
                            Bundle bundle2 = (Bundle) Bundle.class.cast(cls.getMethod("getArgumentBundle", new Class[0]).invoke(cls.cast(obj2), new Object[0]));
                            if (bundle2 != null) {
                                string2 = bundle2.getString("com.facebook.platform.APPLINK_NATIVE_URL");
                                string3 = bundle2.getString("target_url");
                                Bundle bundle3 = bundle2.getBundle(AppLinks.KEY_NAME_EXTRAS);
                                string = (bundle3 == null || (bundle = bundle3.getBundle("deeplink_context")) == null) ? null : bundle.getString("promo_code");
                            } else {
                                string = null;
                                string2 = null;
                                string3 = null;
                            }
                            AFa1vSDK aFa1vSDK2 = aFa1vSDK;
                            if (aFa1vSDK2 != null) {
                                aFa1vSDK2.getCurrencyIso4217Code(string2, string3, string);
                            }
                        } else {
                            AFa1vSDK aFa1vSDK3 = aFa1vSDK;
                            if (aFa1vSDK3 != null) {
                                aFa1vSDK3.getCurrencyIso4217Code(null, null, null);
                            }
                        }
                        return null;
                    }
                });
                String string = context.getString(context.getResources().getIdentifier("facebook_app_id", TypedValues.Custom.S_STRING, context.getPackageName()));
                if (TextUtils.isEmpty(string)) {
                    aFa1zSDK2.getCurrencyIso4217Code("Facebook app id not defined in resources");
                } else {
                    method.invoke(null, context, string, objNewProxyInstance);
                }
            } catch (ClassNotFoundException e) {
                AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e);
                aFa1zSDK2.getCurrencyIso4217Code(e.toString());
            } catch (IllegalAccessException e2) {
                AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e2);
                aFa1zSDK2.getCurrencyIso4217Code(e2.toString());
            } catch (NoSuchMethodException e3) {
                AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e3);
                aFa1zSDK2.getCurrencyIso4217Code(e3.toString());
            } catch (InvocationTargetException e4) {
                AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e4);
                aFa1zSDK2.getCurrencyIso4217Code(e4.toString());
            }
        }
    }

    @Override // com.appsflyer.internal.AFa1aSDK
    public final void getMonetizationNetwork(boolean z) {
        this.getRevenue = z;
    }

    @Override // com.appsflyer.internal.AFa1aSDK
    public final boolean getMonetizationNetwork() {
        if (!AFAdRevenueData()) {
            return false;
        }
        Map<String, Object> map = this.getCurrencyIso4217Code;
        return map == null || map.isEmpty();
    }

    @Override // com.appsflyer.internal.AFa1aSDK
    public final Map<String, Object> getRevenue() {
        return this.getCurrencyIso4217Code;
    }
}
