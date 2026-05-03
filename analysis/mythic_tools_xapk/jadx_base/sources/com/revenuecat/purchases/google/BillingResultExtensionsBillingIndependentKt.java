package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: BillingResultExtensionsBillingIndependent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getOnPurchasesUpdatedSubResponseCodeName", "", "", "toHumanReadableDescription", "Lcom/android/billingclient/api/BillingResult;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingResultExtensionsBillingIndependentKt {
    private static final String getOnPurchasesUpdatedSubResponseCodeName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN_SUB_RESPONSE_CODE (" + i + ')' : "USER_INELIGIBLE" : "PAYMENT_DECLINED_DUE_TO_INSUFFICIENT_FUNDS" : "NO_APPLICABLE_SUB_RESPONSE_CODE";
    }

    public static final String toHumanReadableDescription(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        return "DebugMessage: " + billingResult.getDebugMessage() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(billingResult.getResponseCode()) + ". SubResponseCode: " + getOnPurchasesUpdatedSubResponseCodeName(billingResult.getOnPurchasesUpdatedSubResponseCode()) + FilenameUtils.EXTENSION_SEPARATOR;
    }
}
