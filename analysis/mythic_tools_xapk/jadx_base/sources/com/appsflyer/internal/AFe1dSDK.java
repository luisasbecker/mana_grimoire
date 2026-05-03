package com.appsflyer.internal;

import com.appsflyer.AFPurchaseDetails;
import com.appsflyer.AFPurchaseType;
import com.appsflyer.AppsFlyerInAppPurchaseValidationCallback;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001*BK\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0017\u001a\u000e\u0012\b\u0012\u0006*\u00020\t0\t\u0018\u00010\u00162\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0005\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0017¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0014\u001a\u00020\t2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0015¢\u0006\u0004\b\u0014\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u001dR\"\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u0004\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lcom/appsflyer/internal/AFe1dSDK;", "Lcom/appsflyer/internal/AFe1hSDK;", "Lcom/appsflyer/internal/AFd1zSDK;", "p0", "Lcom/appsflyer/AppsFlyerProperties;", "p1", "Lcom/appsflyer/AFPurchaseDetails;", "p2", "", "", "p3", "Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;", "p4", "Lcom/appsflyer/internal/AFj1gSDK;", "p5", "<init>", "(Lcom/appsflyer/internal/AFd1zSDK;Lcom/appsflyer/AppsFlyerProperties;Lcom/appsflyer/AFPurchaseDetails;Ljava/util/Map;Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;Lcom/appsflyer/internal/AFj1gSDK;)V", "", "", "", "getMonetizationNetwork", "(Ljava/util/Map;Ljava/lang/String;)V", "Lcom/appsflyer/internal/AFd1fSDK;", "getCurrencyIso4217Code", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/appsflyer/internal/AFd1fSDK;", "(Ljava/util/Map;)Ljava/lang/String;", "", "AFAdRevenueData", "(Ljava/lang/String;I)V", "()V", "equals", "Ljava/util/Map;", "copydefault", "Lcom/appsflyer/internal/AFj1gSDK;", "getRevenue", InAppPurchaseConstants.METHOD_TO_STRING, "Lcom/appsflyer/AppsFlyerInAppPurchaseValidationCallback;", "getMediationNetwork", "component2", "Lcom/appsflyer/AppsFlyerProperties;", "hashCode", "Lcom/appsflyer/AFPurchaseDetails;", "AFa1vSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFe1dSDK extends AFe1hSDK {

    /* JADX INFO: renamed from: component2, reason: from kotlin metadata */
    private final AppsFlyerProperties AFAdRevenueData;

    /* JADX INFO: renamed from: copydefault, reason: from kotlin metadata */
    private final AFj1gSDK getRevenue;

    /* JADX INFO: renamed from: equals, reason: from kotlin metadata */
    private final Map<String, String> getCurrencyIso4217Code;

    /* JADX INFO: renamed from: hashCode, reason: from kotlin metadata */
    private final AFPurchaseDetails getMonetizationNetwork;

    /* JADX INFO: renamed from: toString, reason: from kotlin metadata */
    private final AppsFlyerInAppPurchaseValidationCallback getMediationNetwork;

    public /* synthetic */ class AFa1uSDK {
        public static final /* synthetic */ int[] getMediationNetwork;

        static {
            int[] iArr = new int[AFPurchaseType.values().length];
            try {
                iArr[AFPurchaseType.SUBSCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFPurchaseType.ONE_TIME_PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            getMediationNetwork = iArr;
        }
    }

    public static final class AFa1vSDK extends RuntimeException {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AFe1dSDK(AFd1zSDK aFd1zSDK, AppsFlyerProperties appsFlyerProperties, AFPurchaseDetails aFPurchaseDetails, Map<String, String> map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback) {
        this(aFd1zSDK, appsFlyerProperties, aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback, null, 32, null);
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        Intrinsics.checkNotNullParameter(aFPurchaseDetails, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AFe1dSDK(AFd1zSDK aFd1zSDK, AppsFlyerProperties appsFlyerProperties, AFPurchaseDetails aFPurchaseDetails, Map<String, String> map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback, AFj1gSDK aFj1gSDK) {
        super(AFe1lSDK.MANUAL_PURCHASE_VALIDATION, new AFe1lSDK[]{AFe1lSDK.RC_CDN, AFe1lSDK.FETCH_ADVERTISING_ID}, aFd1zSDK, null, MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(aFd1zSDK, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        Intrinsics.checkNotNullParameter(aFPurchaseDetails, "");
        Intrinsics.checkNotNullParameter(aFj1gSDK, "");
        this.AFAdRevenueData = appsFlyerProperties;
        this.getMonetizationNetwork = aFPurchaseDetails;
        this.getCurrencyIso4217Code = map;
        this.getMediationNetwork = appsFlyerInAppPurchaseValidationCallback;
        this.getRevenue = aFj1gSDK;
        this.getMediationNetwork.add(AFe1lSDK.CONVERSION);
    }

    public /* synthetic */ AFe1dSDK(AFd1zSDK aFd1zSDK, AppsFlyerProperties appsFlyerProperties, AFPurchaseDetails aFPurchaseDetails, Map map, AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback, AFj1iSDK aFj1iSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFd1zSDK, appsFlyerProperties, aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback, (i & 32) != 0 ? new AFj1iSDK() : aFj1iSDK);
    }

    private final void AFAdRevenueData(String p0, int p1) {
        AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback = this.getMediationNetwork;
        if (appsFlyerInAppPurchaseValidationCallback != null) {
            appsFlyerInAppPurchaseValidationCallback.onInAppPurchaseValidationError(MapsKt.mapOf(TuplesKt.to("error_code", Integer.valueOf(p1)), TuplesKt.to("error_message", p0)));
        }
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    public final AFd1fSDK<String> getCurrencyIso4217Code(Map<String, Object> p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int i = AFa1uSDK.getMediationNetwork[this.getMonetizationNetwork.getPurchaseType().ordinal()];
        if (i == 1) {
            return ((AFe1bSDK) this).component3.getMediationNetwork(p0, p1);
        }
        if (i == 2) {
            return ((AFe1bSDK) this).component3.getRevenue(p0, p1);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    protected final String getMonetizationNetwork(Map<String, Object> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.getRevenue.getRevenue();
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        Object objM11445constructorimpl;
        Unit unit;
        super.getMonetizationNetwork();
        Throwable thComponent2 = component2();
        if (thComponent2 != null && !(thComponent2 instanceof AFe1nSDK)) {
            if (thComponent2 instanceof AFe1pSDK) {
                AFAdRevenueData("No dev key", -1);
            } else if (thComponent2 instanceof AFa1vSDK) {
                AFAdRevenueData("One or more of provided arguments is empty", -1);
            } else {
                AFAdRevenueData("Error while sending request to server", -1);
            }
        }
        ResponseNetwork responseNetwork = ((AFe1bSDK) this).component4;
        if (responseNetwork != null) {
            if (responseNetwork.getStatusCode() != 200) {
                AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback = this.getMediationNetwork;
                if (appsFlyerInAppPurchaseValidationCallback != null) {
                    appsFlyerInAppPurchaseValidationCallback.onInAppPurchaseValidationError(MapsKt.mapOf(TuplesKt.to("error_code", Integer.valueOf(responseNetwork.getStatusCode())), TuplesKt.to("error_message", responseNetwork.getBody())));
                    return;
                }
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                AFe1dSDK aFe1dSDK = this;
                AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback2 = this.getMediationNetwork;
                if (appsFlyerInAppPurchaseValidationCallback2 != null) {
                    appsFlyerInAppPurchaseValidationCallback2.onInAppPurchaseValidationFinished(AFj1eSDK.getMonetizationNetwork(new JSONObject((String) responseNetwork.getBody())));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                objM11445constructorimpl = Result.m11445constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m11448exceptionOrNullimpl(objM11445constructorimpl) != null) {
                AFAdRevenueData("Error while trying to parse JSON response", responseNetwork.getStatusCode());
            }
            Result.m11444boximpl(objM11445constructorimpl);
        }
    }

    @Override // com.appsflyer.internal.AFe1hSDK
    protected final void getMonetizationNetwork(Map<String, Object> p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.getMonetizationNetwork(p0, p1);
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{this.getMonetizationNetwork.getPurchaseToken(), this.getMonetizationNetwork.getProductId()});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).length() == 0) {
                    throw new AFa1vSDK();
                }
            }
        }
        p0.put("purchase_token", this.getMonetizationNetwork.getPurchaseToken());
        p0.put("product_id", this.getMonetizationNetwork.getProductId());
        p0.put("purchase_type", this.getMonetizationNetwork.getPurchaseType().getValue());
        Map<String, String> map = this.getCurrencyIso4217Code;
        if (map != null && !map.isEmpty()) {
            p0.put("purchase_additional_details", this.getCurrencyIso4217Code);
        }
        String string = this.AFAdRevenueData.getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        String str = string;
        p0.put("custom_data", (str == null || str.length() == 0) ? MapsKt.emptyMap() : AFj1eSDK.getMonetizationNetwork(new JSONObject(string)));
    }
}
