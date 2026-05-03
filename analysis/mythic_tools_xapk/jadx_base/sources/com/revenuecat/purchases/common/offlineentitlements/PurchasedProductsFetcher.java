package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchasedProductsFetcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J<\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00140\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProductsFetcher;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/DateProvider;)V", "createPurchasedProducts", "", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "transaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "productEntitlementMapping", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "getExpirationDate", "Ljava/util/Date;", "purchaseAssociatedToProduct", "queryActiveProducts", "", "appUserID", "", "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasedProductsFetcher {
    private final BillingAbstract billing;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;

    /* JADX INFO: compiled from: PurchasedProductsFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.SUBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billing, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billingAbstract, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, billingAbstract, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchasedProduct> createPurchasedProducts(StoreTransaction transaction, ProductEntitlementMapping productEntitlementMapping) {
        List<String> listEmptyList;
        Date expirationDate = getExpirationDate(transaction);
        List<String> productIds = transaction.getProductIds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productIds, 10));
        for (String str : productIds) {
            ProductEntitlementMapping.Mapping mapping = productEntitlementMapping.getMappings().get(str);
            String basePlanId = mapping != null ? mapping.getBasePlanId() : null;
            if (mapping == null || (listEmptyList = mapping.getEntitlements()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<String> list = listEmptyList;
            String str2 = basePlanId;
            StoreTransaction storeTransaction = transaction;
            arrayList.add(new PurchasedProduct(str, str2, storeTransaction, list, expirationDate));
            transaction = storeTransaction;
        }
        return arrayList;
    }

    private final Date getExpirationDate(StoreTransaction purchaseAssociatedToProduct) {
        if (WhenMappings.$EnumSwitchMapping$0[purchaseAssociatedToProduct.getType().ordinal()] == 1) {
            return new Date(this.dateProvider.getNow().getTime() + TimeUnit.DAYS.toMillis(1L));
        }
        return null;
    }

    public final void queryActiveProducts(String appUserID, final Function1<? super List<PurchasedProduct>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final ProductEntitlementMapping productEntitlementMapping$purchases_defaultsBc8Release = this.deviceCache.getProductEntitlementMapping$purchases_defaultsBc8Release();
        if (productEntitlementMapping$purchases_defaultsBc8Release == null) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.CustomerInfoError, OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED));
        } else {
            this.billing.queryPurchases(appUserID, new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher.queryActiveProducts.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreTransaction> map) {
                    invoke2((Map<String, StoreTransaction>) map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, StoreTransaction> activePurchasesByHashedToken) {
                    Intrinsics.checkNotNullParameter(activePurchasesByHashedToken, "activePurchasesByHashedToken");
                    Collection<StoreTransaction> collectionValues = activePurchasesByHashedToken.values();
                    PurchasedProductsFetcher purchasedProductsFetcher = this;
                    ProductEntitlementMapping productEntitlementMapping = productEntitlementMapping$purchases_defaultsBc8Release;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        CollectionsKt.addAll(arrayList, purchasedProductsFetcher.createPurchasedProducts((StoreTransaction) it.next(), productEntitlementMapping));
                    }
                    onSuccess.invoke(arrayList);
                }
            }, onError);
        }
    }
}
