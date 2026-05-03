package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: productTypeConversions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toRevenueCatProductType", "Lcom/revenuecat/purchases/ProductType;", "Lcom/amazon/device/iap/model/ProductType;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProductTypeConversionsKt {

    /* JADX INFO: compiled from: productTypeConversions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.CONSUMABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.ENTITLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.SUBSCRIPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final com.revenuecat.purchases.ProductType toRevenueCatProductType(ProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return com.revenuecat.purchases.ProductType.SUBS;
            }
            throw new NoWhenBranchMatchedException();
        }
        return com.revenuecat.purchases.ProductType.INAPP;
    }
}
