package com.appsflyer.internal;

import android.util.Base64;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018"}, d2 = {"Lcom/appsflyer/internal/AFc1bSDK;", "", "", "p0", "p1", "p2", "", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lorg/json/JSONObject;", "getMonetizationNetwork", "()Lorg/json/JSONObject;", "getRevenue", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "AFAdRevenueData", "I", "getMediationNetwork", "Ljava/lang/String;", "AFa1tSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AFc1bSDK {

    /* JADX INFO: renamed from: AFa1tSDK, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: AFAdRevenueData, reason: from kotlin metadata */
    int getRevenue;

    /* JADX INFO: renamed from: getMediationNetwork, reason: from kotlin metadata */
    final String getMonetizationNetwork;

    /* JADX INFO: renamed from: getMonetizationNetwork, reason: from kotlin metadata */
    public String AFAdRevenueData;

    /* JADX INFO: renamed from: getRevenue, reason: from kotlin metadata */
    public String getMediationNetwork;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFc1bSDK$AFa1tSDK, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000f"}, d2 = {"Lcom/appsflyer/internal/AFc1bSDK$AFa1tSDK;", "", "<init>", "()V", "", "p0", "", "", "p1", "", "getMediationNetwork", "(Ljava/lang/Integer;[Ljava/lang/String;)Z", "Lcom/appsflyer/internal/AFc1bSDK;", "AFAdRevenueData", "(Ljava/lang/String;)Lcom/appsflyer/internal/AFc1bSDK;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static AFc1bSDK AFAdRevenueData(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<String> listSplit$default = StringsKt.split$default((CharSequence) p0, new String[]{"\n"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 4) {
                return null;
            }
            String strAFAdRevenueData = null;
            String strAFAdRevenueData2 = null;
            String strAFAdRevenueData3 = null;
            Integer numValueOf = null;
            for (String str : listSplit$default) {
                if (StringsKt.startsWith$default(str, "label=", false, 2, (Object) null)) {
                    strAFAdRevenueData = AFAdRevenueData(str, "label=");
                } else if (StringsKt.startsWith$default(str, "hashName=", false, 2, (Object) null)) {
                    strAFAdRevenueData2 = AFAdRevenueData(str, "hashName=");
                } else if (!StringsKt.startsWith$default(str, "stackTrace=", false, 2, (Object) null)) {
                    if (!StringsKt.startsWith$default(str, "c=", false, 2, (Object) null)) {
                        break;
                    }
                    String strSubstring = str.substring(2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "");
                    numValueOf = Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) strSubstring).toString()));
                } else {
                    strAFAdRevenueData3 = AFAdRevenueData(str, "stackTrace=");
                }
            }
            if (getMediationNetwork(numValueOf, strAFAdRevenueData, strAFAdRevenueData2, strAFAdRevenueData3)) {
                return null;
            }
            Intrinsics.checkNotNull(strAFAdRevenueData);
            Intrinsics.checkNotNull(strAFAdRevenueData2);
            Intrinsics.checkNotNull(strAFAdRevenueData3);
            Intrinsics.checkNotNull(numValueOf);
            return new AFc1bSDK(strAFAdRevenueData, strAFAdRevenueData2, strAFAdRevenueData3, numValueOf.intValue());
        }

        private static String AFAdRevenueData(String str, String str2) {
            String strSubstring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "");
            String string = StringsKt.trim((CharSequence) strSubstring).toString();
            Intrinsics.checkNotNullParameter(string, "");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            Intrinsics.checkNotNullParameter(bytes, "");
            byte[] bArrDecode = Base64.decode(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "");
            return new String(bArrDecode, Charsets.UTF_8);
        }

        private static boolean getMediationNetwork(Integer p0, String... p1) {
            String str;
            boolean z = p0 == null;
            int length = p1.length;
            for (int i = 0; i < 3; i++) {
                z = z || (str = p1[i]) == null || str.length() == 0;
            }
            return z;
        }
    }

    public AFc1bSDK(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getMediationNetwork = str;
        this.getMonetizationNetwork = str2;
        this.AFAdRevenueData = str3;
        this.getRevenue = i;
    }

    public /* synthetic */ AFc1bSDK(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 1 : i);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (!(p0 instanceof AFc1bSDK)) {
            return false;
        }
        AFc1bSDK aFc1bSDK = (AFc1bSDK) p0;
        return Intrinsics.areEqual(this.getMediationNetwork, aFc1bSDK.getMediationNetwork) && Intrinsics.areEqual(this.getMonetizationNetwork, aFc1bSDK.getMonetizationNetwork) && Intrinsics.areEqual(this.AFAdRevenueData, aFc1bSDK.AFAdRevenueData) && this.getRevenue == aFc1bSDK.getRevenue;
    }

    public final JSONObject getMonetizationNetwork() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, this.getMediationNetwork);
        jSONObject.put("hash_name", this.getMonetizationNetwork);
        jSONObject.put(UserDataStore.STATE, this.AFAdRevenueData);
        jSONObject.put("c", String.valueOf(this.getRevenue));
        return jSONObject;
    }

    public final String getRevenue() {
        String str = this.getMediationNetwork;
        Intrinsics.checkNotNullParameter(str, "");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        String str2 = this.getMonetizationNetwork;
        Intrinsics.checkNotNullParameter(str2, "");
        byte[] bytes2 = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "");
        String strEncodeToString2 = Base64.encodeToString(bytes2, 2);
        String str3 = this.AFAdRevenueData;
        Intrinsics.checkNotNullParameter(str3, "");
        byte[] bytes3 = str3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "");
        return "label=" + strEncodeToString + "\nhashName=" + strEncodeToString2 + "\nstackTrace=" + Base64.encodeToString(bytes3, 2) + "\nc=" + this.getRevenue;
    }

    public final int hashCode() {
        return (((((this.getMediationNetwork.hashCode() * 31) + this.getMonetizationNetwork.hashCode()) * 31) + this.AFAdRevenueData.hashCode()) * 31) + Integer.hashCode(this.getRevenue);
    }

    public final String toString() {
        return "ExceptionInfo(label=" + this.getMediationNetwork + ", hashName=" + this.getMonetizationNetwork + ", stackTrace=" + this.AFAdRevenueData + ", counter=" + this.getRevenue + ")";
    }
}
