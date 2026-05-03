package com.revenuecat.purchases;

import android.content.Context;
import androidx.media3.muxer.WebmConstants;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a8\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u0012*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0012*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0017\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a\u0012\u0010\u001d\u001a\u00020\u001e*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010 \u001a\u00020\r*\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015¨\u0006!"}, d2 = {"awaitCanMakePayments", "", "Lcom/revenuecat/purchases/Purchases$Companion;", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "(Lcom/revenuecat/purchases/Purchases$Companion;Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProducts", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/Purchases;", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProductsResult", "Lkotlin/Result;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferingsResult", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/PurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPurchaseResult", "awaitRestore", "Lcom/revenuecat/purchases/CustomerInfo;", "awaitRestoreResult", "awaitStorefrontCountryCode", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutinesExtensionsCommonKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", i = {0, 0, 0}, l = {WebmConstants.MkvEbmlElement.PREV_SIZE}, m = "awaitGetProductsResult", n = {"$this$awaitGetProductsResult", "productIds", "type"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitGetProductsResult = CoroutinesExtensionsCommonKt.awaitGetProductsResult(null, null, null, this);
            return objAwaitGetProductsResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitGetProductsResult : Result.m11444boximpl(objAwaitGetProductsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", i = {0}, l = {50}, m = "awaitOfferingsResult", n = {"$this$awaitOfferingsResult"}, s = {"L$0"})
    static final class C05811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05811(Continuation<? super C05811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitOfferingsResult = CoroutinesExtensionsCommonKt.awaitOfferingsResult(null, this);
            return objAwaitOfferingsResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitOfferingsResult : Result.m11444boximpl(objAwaitOfferingsResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", i = {0, 0}, l = {109}, m = "awaitPurchaseResult", n = {"$this$awaitPurchaseResult", "purchaseParams"}, s = {"L$0", "L$1"})
    static final class C05821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05821(Continuation<? super C05821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitPurchaseResult = CoroutinesExtensionsCommonKt.awaitPurchaseResult(null, null, this);
            return objAwaitPurchaseResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPurchaseResult : Result.m11444boximpl(objAwaitPurchaseResult);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutinesExtensionsCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.CoroutinesExtensionsCommonKt", f = "CoroutinesExtensionsCommon.kt", i = {0}, l = {230}, m = "awaitRestoreResult", n = {"$this$awaitRestoreResult"}, s = {"L$0"})
    static final class C05831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05831(Continuation<? super C05831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAwaitRestoreResult = CoroutinesExtensionsCommonKt.awaitRestoreResult(null, this);
            return objAwaitRestoreResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitRestoreResult : Result.m11444boximpl(objAwaitRestoreResult);
        }
    }

    public static final /* synthetic */ Object awaitCanMakePayments(Purchases.Companion companion, Context context, List list, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        companion.canMakePayments(context, list, new Callback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitCanMakePayments$2$1
            @Override // com.revenuecat.purchases.interfaces.Callback
            public final void onReceived(Boolean bool) {
                Continuation<Boolean> continuation2 = safeContinuation2;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(bool));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object awaitCanMakePayments$default(Purchases.Companion companion, Context context, List list, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return awaitCanMakePayments(companion, context, list, continuation);
    }

    public static final /* synthetic */ Object awaitGetProducts(Purchases purchases, List list, ProductType productType, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProducts$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<List<? extends StoreProduct>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new CoroutinesExtensionsCommonKt$awaitGetProducts$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object awaitGetProducts$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i, Object obj) throws PurchasesTransactionException {
        if ((i & 2) != 0) {
            productType = null;
        }
        return awaitGetProducts(purchases, list, productType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitGetProductsResult(Purchases purchases, List list, ProductType productType, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object orThrow = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orThrow);
            anonymousClass1.L$0 = purchases;
            anonymousClass1.L$1 = list;
            anonymousClass1.L$2 = productType;
            anonymousClass1.label = 1;
            AnonymousClass1 anonymousClass12 = anonymousClass1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass12));
            final SafeContinuation safeContinuation2 = safeContinuation;
            ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Result<? extends List<? extends StoreProduct>>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            }, new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitGetProductsResult$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreProduct> list2) {
                    invoke2(list2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends StoreProduct> storeProducts) {
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    Continuation<Result<? extends List<? extends StoreProduct>>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(storeProducts));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            });
            orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass12);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orThrow);
        }
        return ((Result) orThrow).getValue();
    }

    public static /* synthetic */ Object awaitGetProductsResult$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        return awaitGetProductsResult(purchases, list, productType, continuation);
    }

    public static final /* synthetic */ Object awaitOfferings(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsCommonKt.getOfferingsWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferings$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<Offerings> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new CoroutinesExtensionsCommonKt$awaitOfferings$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitOfferingsResult(Purchases purchases, Continuation continuation) throws Throwable {
        C05811 c05811;
        if (continuation instanceof C05811) {
            c05811 = (C05811) continuation;
            if ((c05811.label & Integer.MIN_VALUE) != 0) {
                c05811.label -= Integer.MIN_VALUE;
            } else {
                c05811 = new C05811(continuation);
            }
        }
        Object orThrow = c05811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orThrow);
            c05811.L$0 = purchases;
            c05811.label = 1;
            C05811 c058112 = c05811;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c058112));
            final SafeContinuation safeContinuation2 = safeContinuation;
            ListenerConversionsCommonKt.getOfferingsWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Result<Offerings>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitOfferingsResult$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offerings offerings) {
                    invoke2(offerings);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Offerings it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Result<Offerings>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(it));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            });
            orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c058112);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orThrow);
        }
        return ((Result) orThrow).getValue();
    }

    public static final /* synthetic */ Object awaitPurchase(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                invoke2(storeTransaction, customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Continuation<PurchaseResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(new PurchaseResult(storeTransaction, customerInfo)));
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchase$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                invoke(purchasesError, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, boolean z) {
                Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                Continuation<PurchaseResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesTransactionException(purchasesError, z))));
            }
        }));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitPurchaseResult(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws Throwable {
        C05821 c05821;
        if (continuation instanceof C05821) {
            c05821 = (C05821) continuation;
            if ((c05821.label & Integer.MIN_VALUE) != 0) {
                c05821.label -= Integer.MIN_VALUE;
            } else {
                c05821 = new C05821(continuation);
            }
        }
        Object orThrow = c05821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orThrow);
            c05821.L$0 = purchases;
            c05821.L$1 = purchaseParams;
            c05821.label = 1;
            C05821 c058212 = c05821;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c058212));
            final SafeContinuation safeContinuation2 = safeContinuation;
            purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    invoke2(storeTransaction, customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    Continuation<Result<PurchaseResult>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(new PurchaseResult(storeTransaction, customerInfo)));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitPurchaseResult$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool) {
                    invoke(purchasesError, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError, boolean z) {
                    Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                    Continuation<Result<PurchaseResult>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesTransactionException(purchasesError, z))));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            }));
            orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c058212);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orThrow);
        }
        return ((Result) orThrow).getValue();
    }

    public static final /* synthetic */ Object awaitRestore(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsCommonKt.restorePurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<CustomerInfo> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestore$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                invoke2(customerInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<CustomerInfo> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitRestoreResult(Purchases purchases, Continuation continuation) throws Throwable {
        C05831 c05831;
        if (continuation instanceof C05831) {
            c05831 = (C05831) continuation;
            if ((c05831.label & Integer.MIN_VALUE) != 0) {
                c05831.label -= Integer.MIN_VALUE;
            } else {
                c05831 = new C05831(continuation);
            }
        }
        Object orThrow = c05831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05831.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orThrow);
            c05831.L$0 = purchases;
            c05831.label = 1;
            C05831 c058312 = c05831;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c058312));
            final SafeContinuation safeContinuation2 = safeContinuation;
            ListenerConversionsCommonKt.restorePurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                    invoke2(purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Result<CustomerInfo>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitRestoreResult$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                    invoke2(customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    Continuation<Result<CustomerInfo>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM11444boximpl = Result.m11444boximpl(Result.m11445constructorimpl(customerInfo));
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m11445constructorimpl(resultM11444boximpl));
                }
            });
            orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c058312);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orThrow);
        }
        return ((Result) orThrow).getValue();
    }

    public static final Object awaitStorefrontCountryCode(Purchases purchases, Continuation<? super String> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsCommonKt.getStorefrontCountryCodeWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<String> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new CoroutinesExtensionsCommonKt$awaitStorefrontCountryCode$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
