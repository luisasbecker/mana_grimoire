package com.appsflyer.internal;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0010\u0010$\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0016\u0010)\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010*\u001a\u00020+H\u0002J\u0016\u0010,\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010-\u001a\u00020+H\u0002J\f\u0010.\u001a\u00020\b*\u00020\bH\u0002J \u0010/\u001a\u000200*\u0002002\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/appsflyer/internal/util/EventUrlResolver;", "", "idProvider", "Lcom/appsflyer/internal/components/IdProvider;", "serverConfigUrlFormatter", "Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;", "(Lcom/appsflyer/internal/components/IdProvider;Lcom/appsflyer/internal/util/ServerConfigUrlFormatter;)V", "getAdRevenueUrl", "", "getAppsTrackingUrl", "getArsBilling4", "getArsBilling5", "getDdlUrl", "getEventsTrackingUrl", "getFirstLaunchUrl", "getLaunchUrl", NotificationCompat.CATEGORY_EVENT, "Lcom/appsflyer/internal/model/event/AFEvent;", "getManualValidateOneTimePurchaseUrl", "getManualValidateSubscriptionPurchaseUrl", "getPlayIntegrityUrl", "getReferrerTrackingUrl", "getRegisterUrl", "getUrlForArs", "billingVersion", "getUrlForDdlEvent", "devKey", DiagnosticsEntry.TIMESTAMP_KEY, "getUrlForEvent", "getUrlForManualOneTimePurchaseValidation", "getUrlForManualSubscriptionPurchaseValidation", "getUrlForPlayIntegrityReporting", "getUrlForRdMonitor", "getUrlForRegister", "getUrlForValidatePurchase", "getUrlForValidatePurchaseWithWebHandler", "getUrlForViap", "getValidatePurchaseUrl", "getValidatePurchaseWithWebHandlerUrl", "getViapBilling4", "getViapBilling5", "appendBuildNumber", "isAdRevenueEvent", "", "appendConfiguredChannel", "isRegisterEvent", "appendPackageName", "appendSigQueryParam", "Landroid/net/Uri$Builder;", "Companion", "SDK_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFj1kSDK {
    public static final String AFAdRevenueData;
    public static final String areAllFieldsValid;
    public static final String component1;
    public static final String component2;
    public static final String component3;
    public static final String component4;
    private static final String copy;
    public static final String getCurrencyIso4217Code;
    public static final AFa1uSDK getMediationNetwork = new AFa1uSDK(null);
    public static final String getRevenue;
    private final AFc1kSDK copydefault;
    public final AFj1bSDK getMonetizationNetwork;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFj1kSDK$AFa1uSDK;", "", "<init>", "()V", "", "copy", "Ljava/lang/String;", "getMediationNetwork", "AFAdRevenueData", "getRevenue", "getCurrencyIso4217Code", "component4", "component2", "getMonetizationNetwork", "areAllFieldsValid", "component1", "component3"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1uSDK {
        private AFa1uSDK() {
        }

        public /* synthetic */ AFa1uSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String str = AFa1tSDK.AFAdRevenueData + "/androidevent?app_id=";
        copy = str;
        getCurrencyIso4217Code = "https://%sattr.%s/api/v" + str;
        AFAdRevenueData = "https://%sadrevenue.%s/api/v2/generic/v6.18.0/android?app_id=";
        getRevenue = "https://%sconversions.%s/api/v" + str;
        component2 = "https://%slaunches.%s/api/v" + str;
        component4 = "https://%sinapps.%s/api/v" + str;
        component3 = "https://%sregister.%s/api/v" + str;
        component1 = "https://%svalidate.%s/api/v" + str;
        areAllFieldsValid = "https://%smonitorsdk.%s/api/remote-debug/v2.0?app_id=";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AFj1kSDK(AFc1kSDK aFc1kSDK) {
        this(aFc1kSDK, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
    }

    private AFj1kSDK(AFc1kSDK aFc1kSDK, AFj1bSDK aFj1bSDK) {
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        Intrinsics.checkNotNullParameter(aFj1bSDK, "");
        this.copydefault = aFc1kSDK;
        this.getMonetizationNetwork = aFj1bSDK;
    }

    public /* synthetic */ AFj1kSDK(AFc1kSDK aFc1kSDK, AFj1fSDK aFj1fSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1kSDK, (i & 2) != 0 ? new AFj1fSDK() : aFj1fSDK);
    }

    public static String getMediationNetwork(String str, boolean z) {
        return str + (!z ? "&buildnumber=6.18.0" : "");
    }

    public final String AFAdRevenueData(String str) {
        return str + this.copydefault.getRevenue.getCurrencyIso4217Code.getPackageName();
    }

    public final String getCurrencyIso4217Code(String str, String str2) {
        String packageName = this.copydefault.getRevenue.getCurrencyIso4217Code.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        String strComponent1 = this.copydefault.component1();
        String str3 = strComponent1;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            strComponent1 = "-" + StringsKt.trim((CharSequence) str3).toString();
        }
        if (strComponent1 == null) {
            strComponent1 = "";
        }
        Uri.Builder builderAppendPath = Uri.parse(this.getMonetizationNetwork.getRevenue("https://%sdlsdk.%s/v1.0/android/")).buildUpon().appendPath(packageName + StringsKt.trim((CharSequence) strComponent1).toString());
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "");
        if (str == null || str2 == null) {
            String str4 = str == null ? "devKey" : DiagnosticsEntry.TIMESTAMP_KEY;
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, str4.concat(" is null at attempt to generate ddl event url"), new IllegalStateException(str4.concat(" is null")), true, false, false, true);
        } else {
            builderAppendPath.appendQueryParameter("af_sig", AFj1jSDK.getCurrencyIso4217Code(str2 + str, str));
        }
        String string = builderAppendPath.appendQueryParameter("sdk_version", AFa1tSDK.AFAdRevenueData).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    public final String getRevenue(String str, boolean z) {
        if (z) {
            return str;
        }
        String strComponent1 = this.copydefault.component1();
        String str2 = strComponent1 != null ? "&channel=" + strComponent1 : null;
        if (str2 == null) {
            str2 = "";
        }
        return str + str2;
    }
}
