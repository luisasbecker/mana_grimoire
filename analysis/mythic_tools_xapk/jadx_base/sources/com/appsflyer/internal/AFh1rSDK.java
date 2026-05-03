package com.appsflyer.internal;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b8\u0006@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b!\u0010\u001c"}, d2 = {"Lcom/appsflyer/internal/AFh1rSDK;", "", "", "p0", "", "p1", "p2", "p3", "p4", "p5", "p6", "", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "getMonetizationNetwork", "Ljava/lang/String;", "AFAdRevenueData", "component3", "getCurrencyIso4217Code", "getMediationNetwork", "Ljava/lang/Boolean;", "getRevenue", "component4", "areAllFieldsValid", "Ljava/util/Map;", "component1", "component2"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AFh1rSDK {

    /* JADX INFO: renamed from: AFAdRevenueData, reason: from kotlin metadata */
    public Boolean component4;

    /* JADX INFO: renamed from: areAllFieldsValid, reason: from kotlin metadata */
    public Map<String, Object> component3;

    /* JADX INFO: renamed from: component1, reason: from kotlin metadata */
    public Boolean component2;

    /* JADX INFO: renamed from: component3, reason: from kotlin metadata */
    public String getCurrencyIso4217Code;

    /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: from kotlin metadata */
    public Boolean getMonetizationNetwork;
    public Boolean getMediationNetwork;

    /* JADX INFO: renamed from: getMonetizationNetwork, reason: from kotlin metadata */
    public String AFAdRevenueData;
    public Boolean getRevenue;

    public AFh1rSDK() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    private AFh1rSDK(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, Boolean bool5, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.AFAdRevenueData = str;
        this.component4 = bool;
        this.getMediationNetwork = bool2;
        this.getMonetizationNetwork = bool3;
        this.getRevenue = bool4;
        this.getCurrencyIso4217Code = str2;
        this.component2 = bool5;
        this.component3 = map;
    }

    public /* synthetic */ AFh1rSDK(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, Boolean bool5, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : bool5, (i & 128) != 0 ? new HashMap() : map);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (!(p0 instanceof AFh1rSDK)) {
            return false;
        }
        AFh1rSDK aFh1rSDK = (AFh1rSDK) p0;
        return Intrinsics.areEqual(this.AFAdRevenueData, aFh1rSDK.AFAdRevenueData) && Intrinsics.areEqual(this.component4, aFh1rSDK.component4) && Intrinsics.areEqual(this.getMediationNetwork, aFh1rSDK.getMediationNetwork) && Intrinsics.areEqual(this.getMonetizationNetwork, aFh1rSDK.getMonetizationNetwork) && Intrinsics.areEqual(this.getRevenue, aFh1rSDK.getRevenue) && Intrinsics.areEqual(this.getCurrencyIso4217Code, aFh1rSDK.getCurrencyIso4217Code) && Intrinsics.areEqual(this.component2, aFh1rSDK.component2) && Intrinsics.areEqual(this.component3, aFh1rSDK.component3);
    }

    public final int hashCode() {
        String str = this.AFAdRevenueData;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.component4;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.getMediationNetwork;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.getMonetizationNetwork;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.getRevenue;
        int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str2 = this.getCurrencyIso4217Code;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool5 = this.component2;
        return ((iHashCode6 + (bool5 != null ? bool5.hashCode() : 0)) * 31) + this.component3.hashCode();
    }

    public final String toString() {
        return "AdvertisingIdData(advertisingId=" + this.AFAdRevenueData + ", isLimited=" + this.component4 + ", isEnabled=" + this.getMediationNetwork + ", isGaidWithGps=" + this.getMonetizationNetwork + ", isGaidWithSamsungCloudDev=" + this.getRevenue + ", gaidError=" + this.getCurrencyIso4217Code + ", retry=" + this.component2 + ", metadata=" + this.component3 + ")";
    }
}
