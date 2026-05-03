package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CoroutinesExtensionsCommonKt;
import com.revenuecat.purchases.CoroutinesExtensionsKt;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.PurchasesTransactionException;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleStoreProductKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: PurchasesType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010.\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001aJ\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u00064"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesImpl;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "(Lcom/revenuecat/purchases/Purchases;)V", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "preferredUILocaleOverride", "", "getPreferredUILocaleOverride", "()Ljava/lang/String;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "storefrontCountryCode", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "email", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasesImpl implements PurchasesType {
    public static final int $stable = 8;
    private final Purchases purchases;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1, reason: invalid class name */
    /* JADX INFO: compiled from: PurchasesType.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl", f = "PurchasesType.kt", i = {0}, l = {Imgproc.COLOR_YUV2BGR_NV12}, m = "awaitGetProduct", n = {"basePlan"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PurchasesImpl.this.awaitGetProduct(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PurchasesImpl(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    public /* synthetic */ PurchasesImpl(Purchases purchases, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Purchases.INSTANCE.getSharedInstance() : purchases);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitCreateSupportTicket(this.purchases, str, str2, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerCenterConfigData(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerInfo(this.purchases, cacheFetchPolicy, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation) throws PurchasesTransactionException {
        AnonymousClass1 anonymousClass1;
        Object obj;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object objAwaitGetProducts$default = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitGetProducts$default);
            Purchases purchases = this.purchases;
            List listListOf = CollectionsKt.listOf(str);
            anonymousClass12.L$0 = str2;
            anonymousClass12.label = 1;
            objAwaitGetProducts$default = CoroutinesExtensionsCommonKt.awaitGetProducts$default(purchases, listListOf, null, anonymousClass12, 2, null);
            if (objAwaitGetProducts$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass12.L$0;
            ResultKt.throwOnFailure(objAwaitGetProducts$default);
        }
        List list = (List) objAwaitGetProducts$default;
        if (str2 == null) {
            return (StoreProduct) CollectionsKt.firstOrNull(list);
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GoogleStoreProduct googleProduct = GoogleStoreProductKt.getGoogleProduct((StoreProduct) next);
            if (Intrinsics.areEqual(googleProduct != null ? googleProduct.getBasePlanId() : null, str2)) {
                obj = next;
                break;
            }
        }
        return (StoreProduct) obj;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitGetVirtualCurrencies(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation<? super Offerings> continuation) {
        return CoroutinesExtensionsCommonKt.awaitOfferings(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation) {
        return CoroutinesExtensionsCommonKt.awaitPurchase(this.purchases, builder.build(), continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsCommonKt.awaitRestore(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitSyncPurchases(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.purchases.getCustomerCenterListener();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.purchases.getPreferredUILocaleOverride();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchases.getPurchasesAreCompletedBy();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.purchases.getStorefrontCountryCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchases.track(event);
    }
}
