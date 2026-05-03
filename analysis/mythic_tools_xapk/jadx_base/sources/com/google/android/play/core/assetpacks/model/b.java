package com.google.android.play.core.assetpacks.model;

import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static String a(String str, String str2) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
    }

    public static String b(String str, String str2, String str3) {
        return str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str3;
    }
}
