package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class AFa1vSDK {
    private final AFa1ySDK getCurrencyIso4217Code = new AFa1ySDK() { // from class: com.appsflyer.internal.AFa1vSDK.5
        @Override // com.appsflyer.internal.AFa1vSDK.AFa1ySDK
        public final Class<?> getCurrencyIso4217Code(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    interface AFa1ySDK {
        Class<?> getCurrencyIso4217Code(String str) throws ClassNotFoundException;
    }

    enum AFa1zSDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");

        final String AFAdRevenueData;
        final String getCurrencyIso4217Code;

        AFa1zSDK(String str, String str2) {
            this.getCurrencyIso4217Code = str;
            this.AFAdRevenueData = str2;
        }
    }

    private boolean getCurrencyIso4217Code(String str) {
        try {
            this.getCurrencyIso4217Code.getCurrencyIso4217Code(str);
            AFLogger.afRDLog(new StringBuilder("Class: ").append(str).append(" is found.").toString());
            return true;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly(new StringBuilder("Class: ").append(str).append(" is  not found. (Platform extension)").toString(), e, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    public final String getRevenue() {
        for (AFa1zSDK aFa1zSDK : AFa1zSDK.values()) {
            if (getCurrencyIso4217Code(aFa1zSDK.AFAdRevenueData)) {
                return aFa1zSDK.getCurrencyIso4217Code;
            }
        }
        return AFa1zSDK.DEFAULT.getCurrencyIso4217Code;
    }
}
