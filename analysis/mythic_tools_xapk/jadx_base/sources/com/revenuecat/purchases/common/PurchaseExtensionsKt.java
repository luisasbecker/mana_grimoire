package com.revenuecat.purchases.common;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: purchaseExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"firstProductId", "", "Lcom/android/billingclient/api/Purchase;", "getFirstProductId", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "toHumanReadableDescription", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseExtensionsKt {
    public static final String getFirstProductId(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        String str = purchase.getProducts().get(0);
        Intrinsics.checkNotNullExpressionValue(str, "products[0]");
        return str;
    }

    public static final String toHumanReadableDescription(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        StringBuilder sb = new StringBuilder("productIds: ");
        List<String> products = purchase.getProducts();
        Intrinsics.checkNotNullExpressionValue(products, "this.products");
        return sb.append(CollectionsKt.joinToString$default(products, null, "[", "]", 0, null, null, 57, null)).append(", orderId: ").append(purchase.getOrderId()).append(", purchaseToken: ").append(purchase.getPurchaseToken()).toString();
    }
}
