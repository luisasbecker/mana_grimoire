package com.appsflyer.internal;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFh1aSDK {
    public AFi1zSDK AFAdRevenueData;
    public final AFh1bSDK getCurrencyIso4217Code;
    public final AFh1dSDK getMonetizationNetwork;

    public AFh1aSDK(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.AFAdRevenueData = getCurrencyIso4217Code(jSONObject);
        this.getCurrencyIso4217Code = getMonetizationNetwork(jSONObject);
        this.getMonetizationNetwork = getMediationNetwork(jSONObject);
    }

    private static AFi1zSDK getCurrencyIso4217Code(JSONObject jSONObject) {
        Object objM11445constructorimpl;
        AFi1zSDK aFi1zSDK;
        ArrayList arrayListEmptyList;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject mediationNetwork = getMediationNetwork(jSONObject, "r_debugger");
            if (mediationNetwork != null) {
                long j = mediationNetwork.getLong("ttl");
                int i = mediationNetwork.getInt("counter");
                String strOptString = mediationNetwork.optString("app_ver", "");
                String strOptString2 = mediationNetwork.optString("sdk_ver", "");
                float fOptDouble = (float) mediationNetwork.optDouble("ratio", 1.0d);
                JSONArray jSONArrayOptJSONArray = mediationNetwork.optJSONArray("tags");
                if (jSONArrayOptJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "");
                    arrayListEmptyList = new ArrayList();
                    int length = jSONArrayOptJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = jSONArrayOptJSONArray.getString(i2);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        arrayListEmptyList.add(string);
                    }
                } else {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                Intrinsics.checkNotNullExpressionValue(strOptString, "");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "");
                aFi1zSDK = new AFi1zSDK(j, fOptDouble, arrayListEmptyList, i, strOptString, strOptString2);
            } else {
                aFi1zSDK = null;
            }
            objM11445constructorimpl = Result.m11445constructorimpl(aFi1zSDK);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (AFi1zSDK) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }

    private static AFh1dSDK getMediationNetwork(JSONObject jSONObject) {
        Object objM11445constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject mediationNetwork = getMediationNetwork(jSONObject, "meta_data");
            objM11445constructorimpl = Result.m11445constructorimpl(mediationNetwork != null ? new AFh1dSDK(mediationNetwork.optDouble("send_rate", 1.0d)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (AFh1dSDK) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }

    private static JSONObject getMediationNetwork(JSONObject jSONObject, String str) throws JSONException, NullPointerException {
        JSONObject jSONObjectOptJSONObject;
        if (!jSONObject.has(str) || (jSONObjectOptJSONObject = jSONObject.getJSONArray(str).optJSONObject(0).optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("v1");
    }

    private static AFh1bSDK getMonetizationNetwork(JSONObject jSONObject) {
        Object objM11445constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject mediationNetwork = getMediationNetwork(jSONObject, "exc_mngr");
            objM11445constructorimpl = Result.m11445constructorimpl(mediationNetwork != null ? new AFh1bSDK(mediationNetwork.getString("sdk_ver"), mediationNetwork.optInt("min", -1), mediationNetwork.optInt("expire", -1), mediationNetwork.optLong("ttl", -1L)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        return (AFh1bSDK) (Result.m11451isFailureimpl(objM11445constructorimpl) ? null : objM11445constructorimpl);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "");
        AFh1aSDK aFh1aSDK = (AFh1aSDK) obj;
        return Intrinsics.areEqual(this.getCurrencyIso4217Code, aFh1aSDK.getCurrencyIso4217Code) && Intrinsics.areEqual(this.getMonetizationNetwork, aFh1aSDK.getMonetizationNetwork) && Intrinsics.areEqual(this.AFAdRevenueData, aFh1aSDK.AFAdRevenueData);
    }

    public final int hashCode() {
        AFh1bSDK aFh1bSDK = this.getCurrencyIso4217Code;
        int iHashCode = (aFh1bSDK != null ? aFh1bSDK.hashCode() : 0) * 31;
        AFh1dSDK aFh1dSDK = this.getMonetizationNetwork;
        int iHashCode2 = (iHashCode + (aFh1dSDK != null ? aFh1dSDK.hashCode() : 0)) * 31;
        AFi1zSDK aFi1zSDK = this.AFAdRevenueData;
        return iHashCode2 + (aFi1zSDK != null ? aFi1zSDK.hashCode() : 0);
    }
}
