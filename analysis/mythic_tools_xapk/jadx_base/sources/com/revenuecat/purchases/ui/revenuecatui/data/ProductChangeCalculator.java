package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProductChangeCalculator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;", "", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;)V", "calculateProductChange", "Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeInfo;", "activePlayStoreSubscription", "Lcom/revenuecat/purchases/SubscriptionInfo;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "(Lcom/revenuecat/purchases/SubscriptionInfo;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateProductChangeInfo", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProductChangeCalculator {
    private static final int MONTHS_IN_HALF_YEAR = 6;
    private static final int MONTHS_IN_QUARTER = 3;
    private static final int MONTHS_IN_YEAR = 12;
    private static final long SANDBOX_HALF_YEAR_MINUTES = 15;
    private static final long SANDBOX_MONTHLY_MINUTES = 5;
    private static final long SANDBOX_QUARTER_MINUTES = 10;
    private static final long SANDBOX_YEARLY_MINUTES = 30;
    private final PurchasesType purchases;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ#\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011*\u00020\u0016H\u0000¢\u0006\u0002\b\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator$Companion;", "", "()V", "MONTHS_IN_HALF_YEAR", "", "MONTHS_IN_QUARTER", "MONTHS_IN_YEAR", "SANDBOX_HALF_YEAR_MINUTES", "", "SANDBOX_MONTHLY_MINUTES", "SANDBOX_QUARTER_MINUTES", "SANDBOX_YEARLY_MINUTES", "getSandboxRenewalMinutes", TypedValues.CycleType.S_WAVE_PERIOD, "Lcom/revenuecat/purchases/models/Period;", "getSandboxRenewalMinutes$revenuecatui_defaultsBc8Release", "parseProductIdentifier", "Lkotlin/Pair;", "", "productIdentifier", "parseProductIdentifier$revenuecatui_defaultsBc8Release", "getNormalizedPrice", "Lcom/revenuecat/purchases/models/StoreProduct;", "isSandbox", "", "getNormalizedPrice$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/StoreProduct;Z)Ljava/lang/Long;", "subscriptionIdentifiers", "subscriptionIdentifiers$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Long getNormalizedPrice$revenuecatui_defaultsBc8Release(StoreProduct storeProduct, boolean z) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            Period period = storeProduct.getPeriod();
            if (period == null) {
                return null;
            }
            long amountMicros = storeProduct.getPrice().getAmountMicros();
            if (z) {
                return Long.valueOf(amountMicros / getSandboxRenewalMinutes$revenuecatui_defaultsBc8Release(period));
            }
            Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
            if (pricePricePerMonth$default != null) {
                return Long.valueOf(pricePricePerMonth$default.getAmountMicros());
            }
            return null;
        }

        public final long getSandboxRenewalMinutes$revenuecatui_defaultsBc8Release(Period period) {
            Intrinsics.checkNotNullParameter(period, "period");
            double valueInMonths = period.getValueInMonths();
            if (valueInMonths >= 12.0d) {
                return ProductChangeCalculator.SANDBOX_YEARLY_MINUTES;
            }
            if (valueInMonths >= 6.0d) {
                return ProductChangeCalculator.SANDBOX_HALF_YEAR_MINUTES;
            }
            if (valueInMonths >= 3.0d) {
                return 10L;
            }
            return ProductChangeCalculator.SANDBOX_MONTHLY_MINUTES;
        }

        public final Pair<String, String> parseProductIdentifier$revenuecatui_defaultsBc8Release(String productIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            String strSubstringBefore$default = StringsKt.substringBefore$default(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
            String strSubstringAfter = StringsKt.substringAfter(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "");
            return TuplesKt.to(strSubstringBefore$default, strSubstringAfter.length() > 0 ? strSubstringAfter : null);
        }

        public final Pair<String, String> subscriptionIdentifiers$revenuecatui_defaultsBc8Release(StoreProduct storeProduct) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            if (!(storeProduct instanceof GoogleStoreProduct)) {
                return parseProductIdentifier$revenuecatui_defaultsBc8Release(storeProduct.getId());
            }
            GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) storeProduct;
            return TuplesKt.to(googleStoreProduct.getProductId(), googleStoreProduct.getBasePlanId());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", f = "ProductChangeCalculator.kt", i = {0, 0, 0, 0, 0}, l = {72}, m = "calculateProductChange", n = {"activePlayStoreSubscription", "packageToPurchase", "productChangeConfig", "oldSubscriptionId", "newSubscriptionId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChange(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChangeInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", f = "ProductChangeCalculator.kt", i = {0, 0, 0}, l = {40, 45}, m = "calculateProductChangeInfo", n = {"this", "packageToPurchase", "productChangeConfig"}, s = {"L$0", "L$1", "L$2"})
    static final class C09711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09711(Continuation<? super C09711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChangeInfo(null, null, this);
        }
    }

    public ProductChangeCalculator(PurchasesType purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateProductChange(SubscriptionInfo subscriptionInfo, Package r13, ProductChangeConfig productChangeConfig, Continuation<? super ProductChangeInfo> continuation) {
        AnonymousClass1 anonymousClass1;
        String productIdentifier;
        Object obj;
        String str;
        GoogleReplacementMode downgradeReplacementMode;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            productIdentifier = subscriptionInfo.getProductIdentifier();
            String productPlanIdentifier = subscriptionInfo.getProductPlanIdentifier();
            String strComponent1 = INSTANCE.subscriptionIdentifiers$revenuecatui_defaultsBc8Release(r13.getProduct()).component1();
            if (Intrinsics.areEqual(productIdentifier, strComponent1)) {
                Logger.INSTANCE.d("Same product (" + strComponent1 + "), Google handles base plan change automatically");
                return null;
            }
            PurchasesType purchasesType = this.purchases;
            anonymousClass1.L$0 = subscriptionInfo;
            anonymousClass1.L$1 = r13;
            anonymousClass1.L$2 = productChangeConfig;
            anonymousClass1.L$3 = productIdentifier;
            anonymousClass1.L$4 = strComponent1;
            anonymousClass1.label = 1;
            Object objAwaitGetProduct = purchasesType.awaitGetProduct(productIdentifier, productPlanIdentifier, anonymousClass1);
            if (objAwaitGetProduct == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objAwaitGetProduct;
            str = strComponent1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass1.L$4;
            String str2 = (String) anonymousClass1.L$3;
            productChangeConfig = (ProductChangeConfig) anonymousClass1.L$2;
            r13 = (Package) anonymousClass1.L$1;
            SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
            productIdentifier = str2;
            subscriptionInfo = subscriptionInfo2;
            obj = obj2;
        }
        StoreProduct storeProduct = (StoreProduct) obj;
        boolean isSandbox = subscriptionInfo.getIsSandbox();
        Long normalizedPrice$revenuecatui_defaultsBc8Release = storeProduct != null ? INSTANCE.getNormalizedPrice$revenuecatui_defaultsBc8Release(storeProduct, isSandbox) : null;
        Long normalizedPrice$revenuecatui_defaultsBc8Release2 = INSTANCE.getNormalizedPrice$revenuecatui_defaultsBc8Release(r13.getProduct(), isSandbox);
        if (normalizedPrice$revenuecatui_defaultsBc8Release == null || normalizedPrice$revenuecatui_defaultsBc8Release2 == null || normalizedPrice$revenuecatui_defaultsBc8Release2.longValue() <= normalizedPrice$revenuecatui_defaultsBc8Release.longValue()) {
            Logger.INSTANCE.d("Detected downgrade: " + productIdentifier + " -> " + str + " (old: " + normalizedPrice$revenuecatui_defaultsBc8Release + ", new: " + normalizedPrice$revenuecatui_defaultsBc8Release2 + ", sandbox: " + isSandbox + ')');
            downgradeReplacementMode = productChangeConfig.getDowngradeReplacementMode();
        } else {
            Logger.INSTANCE.d("Detected upgrade: " + productIdentifier + " -> " + str + " (old: " + normalizedPrice$revenuecatui_defaultsBc8Release + ", new: " + normalizedPrice$revenuecatui_defaultsBc8Release2 + ", sandbox: " + isSandbox + ')');
            downgradeReplacementMode = productChangeConfig.getUpgradeReplacementMode();
        }
        return new ProductChangeInfo(productIdentifier, downgradeReplacementMode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        if (r10 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateProductChangeInfo(Package r8, ProductChangeConfig productChangeConfig, Continuation<? super ProductChangeInfo> continuation) {
        C09711 c09711;
        Object next;
        if (continuation instanceof C09711) {
            c09711 = (C09711) continuation;
            if ((c09711.label & Integer.MIN_VALUE) != 0) {
                c09711.label -= Integer.MIN_VALUE;
            } else {
                c09711 = new C09711(continuation);
            }
        }
        Object objAwaitCustomerInfo$default = c09711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09711.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
                if (r8.getProduct().getType() != ProductType.SUBS) {
                    return null;
                }
                PurchasesType purchasesType = this.purchases;
                c09711.L$0 = this;
                c09711.L$1 = r8;
                c09711.L$2 = productChangeConfig;
                c09711.label = 1;
                objAwaitCustomerInfo$default = PurchasesType.DefaultImpls.awaitCustomerInfo$default(purchasesType, null, c09711, 1, null);
                if (objAwaitCustomerInfo$default == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
                return (ProductChangeInfo) objAwaitCustomerInfo$default;
            }
            productChangeConfig = (ProductChangeConfig) c09711.L$2;
            r8 = (Package) c09711.L$1;
            this = (ProductChangeCalculator) c09711.L$0;
            ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
            Iterator<T> it = ((CustomerInfo) objAwaitCustomerInfo$default).getSubscriptionsByProductIdentifier().values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubscriptionInfo subscriptionInfo = (SubscriptionInfo) next;
                if (subscriptionInfo.getIsActive() && subscriptionInfo.getStore() == Store.PLAY_STORE) {
                    break;
                }
            }
            SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) next;
            if (subscriptionInfo2 == null) {
                return null;
            }
            c09711.L$0 = null;
            c09711.L$1 = null;
            c09711.L$2 = null;
            c09711.label = 2;
            objAwaitCustomerInfo$default = this.calculateProductChange(subscriptionInfo2, r8, productChangeConfig, c09711);
        } catch (PurchasesException e) {
            Logger.INSTANCE.e("Error determining product change info: " + e.getMessage());
            return null;
        }
    }
}
