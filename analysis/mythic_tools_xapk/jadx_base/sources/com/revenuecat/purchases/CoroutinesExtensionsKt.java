package com.revenuecat.purchases;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.data.LogInResult;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: coroutinesExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u000b*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a&\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019H\u0086@¢\u0006\u0002\u0010\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u001d\u001a\u00020\u0017*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u001e\u001a\u00020\u000b*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0086@¢\u0006\u0002\u0010\t¨\u0006!"}, d2 = {"awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "Lcom/revenuecat/purchases/Purchases;", "email", "", "description", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitLogIn", "Lcom/revenuecat/purchases/data/LogInResult;", "appUserID", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLogOut", "awaitSetAppstackAttributionParams", "Lcom/revenuecat/purchases/Offerings;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitStorefrontLocale", "Ljava/util/Locale;", "awaitSyncAttributesAndOfferingsIfNeeded", "awaitSyncPurchases", "getAmazonLWAConsentStatus", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutinesExtensionsKt {
    public static final /* synthetic */ Object awaitCreateSupportTicket(Purchases purchases, String str, String str2, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        purchases.createSupportTicket(str, str2, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Continuation<CreateSupportTicketResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(new CreateSupportTicketResult(z)));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCreateSupportTicket$2$2
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
                Continuation<CreateSupportTicketResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitCustomerCenterConfigData(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        purchases.getCustomerCenterConfigData$purchases_defaultsBc8Release(new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerCenterConfigData$2$1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Continuation<CustomerCenterConfigData> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(error))));
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                Intrinsics.checkNotNullParameter(customerCenterConfig, "customerCenterConfig");
                Continuation<CustomerCenterConfigData> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(customerCenterConfig));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerInfo$2$2
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
        }, new CoroutinesExtensionsKt$awaitCustomerInfo$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i, Object obj) throws PurchasesException {
        if ((i & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.INSTANCE.m10260default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, continuation);
    }

    public static final /* synthetic */ Object awaitGetVirtualCurrencies(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.getVirtualCurrenciesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$1
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
                Continuation<VirtualCurrencies> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new Function1<VirtualCurrencies, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VirtualCurrencies virtualCurrencies) {
                invoke2(virtualCurrencies);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VirtualCurrencies it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<VirtualCurrencies> continuation2 = safeContinuation2;
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

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.logInWith(purchases, str, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$1
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
                Continuation<LogInResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogIn$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo, Boolean bool) {
                invoke(customerInfo, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo, boolean z) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Continuation<LogInResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(new LogInResult(customerInfo, z)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.logOutWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$1
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
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitLogOut$2$2
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

    public static final /* synthetic */ Object awaitSetAppstackAttributionParams(Purchases purchases, Map map, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        purchases.setAppstackAttributionParams(map, ListenerConversionsKt.syncAttributesAndOfferingsListener(new CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$1(safeContinuation2), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSetAppstackAttributionParams$2$2
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
        }));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final Object awaitStorefrontLocale(Purchases purchases, Continuation<? super Locale> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.getStorefrontLocaleWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitStorefrontLocale$2$2
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
                Continuation<Locale> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new CoroutinesExtensionsKt$awaitStorefrontLocale$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitSyncAttributesAndOfferingsIfNeeded(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2
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
        }, new CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.syncPurchasesWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitSyncPurchases$2$2
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
        }, new CoroutinesExtensionsKt$awaitSyncPurchases$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object getAmazonLWAConsentStatus(Purchases purchases, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(purchases, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$2
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
                Continuation<AmazonLWAConsentStatus> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        }, new CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1(safeContinuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
