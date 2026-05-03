package com.revenuecat.purchases;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadata;
import com.revenuecat.purchases.common.caching.LocalTransactionMetadataStore;
import com.revenuecat.purchases.common.networking.PostReceiptProductInfo;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.utils.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PostReceiptHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\\BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0\"H\u0002J`\u0010&\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%0,0+2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"H\u0002J¢\u0001\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00162\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001e0\"2B\u0010$\u001a>\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u001e08j\u0002`?H\u0002J\u0090\u0001\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001e0\"2B\u0010$\u001a>\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u001109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u001e08j\u0002`?H\u0002JZ\u0010C\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010D\u001a\u00020\u00162\f\u0010E\u001a\b\u0012\u0004\u0012\u00020 0F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001e0H2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0\"2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0\"Jg\u0010I\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u0010/\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u0002032\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0\"2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010KJ\u0098\u0001\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020S\u0018\u00010R2\u0006\u0010/\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010T\u001a\u00020\u00162\"\b\u0002\u0010!\u001a\u001c\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e\u0018\u00010Uj\u0004\u0018\u0001`V2\"\b\u0002\u0010$\u001a\u001c\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010Uj\u0004\u0018\u0001`WJ:\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u0002092\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001e0\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0HH\u0002J$\u0010Z\u001a\u00020[*\u00020\u00132\u0006\u0010.\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/revenuecat/purchases/PostReceiptHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "customerInfoUpdateHandler", "Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "paywallPresentedCache", "Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "localTransactionMetadataStore", "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadataStore;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/CustomerInfoUpdateHandler;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadataStore;)V", "finishTransactions", "", "getFinishTransactions", "()Z", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "calculateOfflineCustomerInfo", "", "appUserID", "", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "callTransactionMetadataCompletionFromResults", "transactionMetadataToSync", "", "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "results", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/revenuecat/purchases/utils/Result;", "performPostReceipt", Constants.GP_IAP_PURCHASE_TOKEN, "isRestore", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "paywallData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "hasCachedTransactionMetadata", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "Lkotlin/ParameterName;", "name", "postReceiptErrorHandlingBehavior", "Lorg/json/JSONObject;", "body", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "postReceiptAndSubscriberAttributes", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "postRemainingCachedTransactionMetadata", "allowSharingPlayStoreAccount", "pendingTransactionsTokens", "", "onNoTransactionsToSync", "Lkotlin/Function0;", "postTokenWithoutConsuming", "isAutoRenewing", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/ReceiptInfo;ZLjava/lang/String;Lcom/revenuecat/purchases/PostReceiptInitiationSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;)V", "postTransactionAndConsumeIfNeeded", FirebaseAnalytics.Event.PURCHASE, "Lcom/revenuecat/purchases/models/StoreTransaction;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "subscriptionOptionForProductIDs", "", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "sdkOriginated", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "useOfflineEntitlementsCustomerInfoIfNeeded", "errorHandlingBehavior", "getOrPutDataToPost", "Lcom/revenuecat/purchases/PostReceiptHelper$CachedDataToPost;", "CachedDataToPost", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PostReceiptHelper {
    private final AppConfig appConfig;
    private final Backend backend;
    private final BillingAbstract billing;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final LocalTransactionMetadataStore localTransactionMetadataStore;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    /* JADX INFO: compiled from: PostReceiptHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/PostReceiptHelper$CachedDataToPost;", "", "localTransactionMetadata", "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "paywallEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "didCacheData", "", "(Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;Z)V", "getDidCacheData", "()Z", "getLocalTransactionMetadata", "()Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "getPaywallEvent", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class CachedDataToPost {
        private final boolean didCacheData;
        private final LocalTransactionMetadata localTransactionMetadata;
        private final PaywallEvent paywallEvent;

        public CachedDataToPost(LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean z) {
            this.localTransactionMetadata = localTransactionMetadata;
            this.paywallEvent = paywallEvent;
            this.didCacheData = z;
        }

        public static /* synthetic */ CachedDataToPost copy$default(CachedDataToPost cachedDataToPost, LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                localTransactionMetadata = cachedDataToPost.localTransactionMetadata;
            }
            if ((i & 2) != 0) {
                paywallEvent = cachedDataToPost.paywallEvent;
            }
            if ((i & 4) != 0) {
                z = cachedDataToPost.didCacheData;
            }
            return cachedDataToPost.copy(localTransactionMetadata, paywallEvent, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LocalTransactionMetadata getLocalTransactionMetadata() {
            return this.localTransactionMetadata;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PaywallEvent getPaywallEvent() {
            return this.paywallEvent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getDidCacheData() {
            return this.didCacheData;
        }

        public final CachedDataToPost copy(LocalTransactionMetadata localTransactionMetadata, PaywallEvent paywallEvent, boolean didCacheData) {
            return new CachedDataToPost(localTransactionMetadata, paywallEvent, didCacheData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedDataToPost)) {
                return false;
            }
            CachedDataToPost cachedDataToPost = (CachedDataToPost) other;
            return Intrinsics.areEqual(this.localTransactionMetadata, cachedDataToPost.localTransactionMetadata) && Intrinsics.areEqual(this.paywallEvent, cachedDataToPost.paywallEvent) && this.didCacheData == cachedDataToPost.didCacheData;
        }

        public final boolean getDidCacheData() {
            return this.didCacheData;
        }

        public final LocalTransactionMetadata getLocalTransactionMetadata() {
            return this.localTransactionMetadata;
        }

        public final PaywallEvent getPaywallEvent() {
            return this.paywallEvent;
        }

        public int hashCode() {
            LocalTransactionMetadata localTransactionMetadata = this.localTransactionMetadata;
            int iHashCode = (localTransactionMetadata == null ? 0 : localTransactionMetadata.hashCode()) * 31;
            PaywallEvent paywallEvent = this.paywallEvent;
            return ((iHashCode + (paywallEvent != null ? paywallEvent.hashCode() : 0)) * 31) + Boolean.hashCode(this.didCacheData);
        }

        public String toString() {
            return "CachedDataToPost(localTransactionMetadata=" + this.localTransactionMetadata + ", paywallEvent=" + this.paywallEvent + ", didCacheData=" + this.didCacheData + ')';
        }
    }

    public PostReceiptHelper(AppConfig appConfig, Backend backend, BillingAbstract billing, CustomerInfoUpdateHandler customerInfoUpdateHandler, DeviceCache deviceCache, SubscriberAttributesManager subscriberAttributesManager, OfflineEntitlementsManager offlineEntitlementsManager, PaywallPresentedCache paywallPresentedCache, LocalTransactionMetadataStore localTransactionMetadataStore) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(paywallPresentedCache, "paywallPresentedCache");
        Intrinsics.checkNotNullParameter(localTransactionMetadataStore, "localTransactionMetadataStore");
        this.appConfig = appConfig;
        this.backend = backend;
        this.billing = billing;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.deviceCache = deviceCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.localTransactionMetadataStore = localTransactionMetadataStore;
    }

    private final void calculateOfflineCustomerInfo(String appUserID, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        this.offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(appUserID, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.calculateOfflineCustomerInfo.1
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
                PostReceiptHelper.this.customerInfoUpdateHandler.notifyListeners(customerInfo);
                onSuccess.invoke(customerInfo);
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.calculateOfflineCustomerInfo.2
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
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callTransactionMetadataCompletionFromResults(List<LocalTransactionMetadata> transactionMetadataToSync, ConcurrentLinkedQueue<Result<CustomerInfo, PurchasesError>> results, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        if (transactionMetadataToSync.size() == results.size()) {
            int i = 0;
            for (Object obj : results) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Result result = (Result) obj;
                if (result instanceof Result.Error) {
                    if (onError != null) {
                        onError.invoke(((Result.Error) result).getValue());
                        return;
                    }
                    return;
                } else {
                    if (i == results.size() - 1 && onSuccess != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        onSuccess.invoke(((Result.Success) result).getValue());
                    }
                    i = i2;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void callTransactionMetadataCompletionFromResults$default(PostReceiptHelper postReceiptHelper, List list, ConcurrentLinkedQueue concurrentLinkedQueue, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        postReceiptHelper.callTransactionMetadataCompletionFromResults(list, concurrentLinkedQueue, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    private final synchronized CachedDataToPost getOrPutDataToPost(LocalTransactionMetadataStore localTransactionMetadataStore, String str, ReceiptInfo receiptInfo, PostReceiptInitiationSource postReceiptInitiationSource) {
        LocalTransactionMetadata localTransactionMetadata;
        boolean z;
        PaywallEvent andRemovePurchaseInitiatedEventIfNeeded;
        PaywallEvent.Data data;
        localTransactionMetadata = localTransactionMetadataStore.getLocalTransactionMetadata(str);
        z = localTransactionMetadata == null && postReceiptInitiationSource == PostReceiptInitiationSource.PURCHASE;
        andRemovePurchaseInitiatedEventIfNeeded = localTransactionMetadata == null ? this.paywallPresentedCache.getAndRemovePurchaseInitiatedEventIfNeeded(receiptInfo.getProductIDs(), receiptInfo.getPurchaseTime()) : null;
        if (z) {
            PresentedOfferingContext presentedOfferingContext = (andRemovePurchaseInitiatedEventIfNeeded == null || (data = andRemovePurchaseInitiatedEventIfNeeded.getData()) == null) ? null : data.getPresentedOfferingContext();
            localTransactionMetadataStore.cacheLocalTransactionMetadata(str, new LocalTransactionMetadata(str, (receiptInfo.getPresentedOfferingContext() != null || presentedOfferingContext == null) ? receiptInfo : ReceiptInfo.copy$default(receiptInfo, null, null, presentedOfferingContext, null, null, null, null, null, null, null, false, null, null, 8187, null), andRemovePurchaseInitiatedEventIfNeeded != null ? andRemovePurchaseInitiatedEventIfNeeded.toPaywallPostReceiptData$purchases_defaultsBc8Release() : null, getPurchasesAreCompletedBy()));
        }
        return new CachedDataToPost(localTransactionMetadata, andRemovePurchaseInitiatedEventIfNeeded, z);
    }

    private final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.appConfig.getPurchasesAreCompletedBy();
    }

    private final void performPostReceipt(final String appUserID, final String purchaseToken, final boolean isRestore, final ReceiptInfo receiptInfo, final PostReceiptInitiationSource initiationSource, final PaywallPostReceiptData paywallData, final PurchasesAreCompletedBy purchasesAreCompletedBy, final boolean hasCachedTransactionMetadata, final Function1<? super PostReceiptResponse, Unit> onSuccess, final Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        this.subscriberAttributesManager.getUnsyncedSubscriberAttributes(appUserID, new Function1<Map<String, ? extends SubscriberAttribute>, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends SubscriberAttribute> map) {
                invoke2((Map<String, SubscriberAttribute>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Map<String, SubscriberAttribute> unsyncedSubscriberAttributesByKey) {
                Intrinsics.checkNotNullParameter(unsyncedSubscriberAttributesByKey, "unsyncedSubscriberAttributesByKey");
                Backend backend = PostReceiptHelper.this.backend;
                String str = purchaseToken;
                String str2 = appUserID;
                boolean z = isRestore;
                boolean finishTransactions = PostReceiptHelper.this.getFinishTransactions();
                Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(unsyncedSubscriberAttributesByKey);
                ReceiptInfo receiptInfo2 = receiptInfo;
                PostReceiptInitiationSource postReceiptInitiationSource = initiationSource;
                PaywallPostReceiptData paywallPostReceiptData = paywallData;
                PurchasesAreCompletedBy purchasesAreCompletedBy2 = purchasesAreCompletedBy;
                final boolean z2 = hasCachedTransactionMetadata;
                final PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                final String str3 = purchaseToken;
                final String str4 = appUserID;
                final Function1<PostReceiptResponse, Unit> function1 = onSuccess;
                Function1<PostReceiptResponse, Unit> function12 = new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PostReceiptResponse postReceiptResponse) {
                        invoke2(postReceiptResponse);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PostReceiptResponse postReceiptResponse) {
                        Intrinsics.checkNotNullParameter(postReceiptResponse, "postReceiptResponse");
                        if (z2) {
                            postReceiptHelper.localTransactionMetadataStore.clearLocalTransactionMetadata(SetsKt.setOf(str3));
                        }
                        postReceiptHelper.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                        postReceiptHelper.subscriberAttributesManager.markAsSynced(str4, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(postReceiptResponse.getBody()));
                        postReceiptHelper.customerInfoUpdateHandler.cacheAndNotifyListeners(postReceiptResponse.getCustomerInfo());
                        function1.invoke(postReceiptResponse);
                    }
                };
                final boolean z3 = hasCachedTransactionMetadata;
                final PostReceiptHelper postReceiptHelper2 = PostReceiptHelper.this;
                final String str5 = purchaseToken;
                final String str6 = appUserID;
                final Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> function3 = onError;
                backend.postReceiptData(str, str2, z, finishTransactions, backendMap, receiptInfo2, postReceiptInitiationSource, paywallPostReceiptData, purchasesAreCompletedBy2, function12, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.performPostReceipt.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                        invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PurchasesError error, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                        if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                            if (z3) {
                                postReceiptHelper2.localTransactionMetadataStore.clearLocalTransactionMetadata(SetsKt.setOf(str5));
                            }
                            postReceiptHelper2.subscriberAttributesManager.markAsSynced(str6, unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(jSONObject));
                        }
                        function3.invoke(error, errorHandlingBehavior, jSONObject);
                    }
                });
            }
        });
    }

    private final void postReceiptAndSubscriberAttributes(String appUserID, String purchaseToken, boolean isRestore, ReceiptInfo receiptInfo, PostReceiptInitiationSource initiationSource, PurchaseState purchaseState, Function1<? super PostReceiptResponse, Unit> onSuccess, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        PaywallPostReceiptData paywallPostReceiptData;
        ReceiptInfo receiptInfo2;
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        CachedDataToPost orPutDataToPost = getOrPutDataToPost(this.localTransactionMetadataStore, purchaseToken, receiptInfo, initiationSource);
        LocalTransactionMetadata localTransactionMetadata = orPutDataToPost.getLocalTransactionMetadata();
        PaywallEvent paywallEvent = orPutDataToPost.getPaywallEvent();
        boolean didCacheData = orPutDataToPost.getDidCacheData();
        if (localTransactionMetadata != null && (paywallPostReceiptData$purchases_defaultsBc8Release = localTransactionMetadata.getPaywallPostReceiptData()) != null) {
            paywallPostReceiptData = paywallPostReceiptData$purchases_defaultsBc8Release;
        } else if (paywallEvent != null) {
            PaywallPostReceiptData paywallPostReceiptData$purchases_defaultsBc8Release = paywallEvent.toPaywallPostReceiptData$purchases_defaultsBc8Release();
            paywallPostReceiptData = paywallPostReceiptData$purchases_defaultsBc8Release;
        } else {
            paywallPostReceiptData = null;
        }
        if (localTransactionMetadata == null || (receiptInfo2 = localTransactionMetadata.getReceiptInfo()) == null) {
            receiptInfo2 = receiptInfo;
        }
        if (localTransactionMetadata == null || (purchasesAreCompletedBy = localTransactionMetadata.getPurchasesAreCompletedBy()) == null) {
            purchasesAreCompletedBy = getPurchasesAreCompletedBy();
        }
        if (purchaseState != PurchaseState.PENDING) {
            performPostReceipt(appUserID, purchaseToken, isRestore, receiptInfo2, initiationSource, paywallPostReceiptData, purchasesAreCompletedBy, localTransactionMetadata != null || didCacheData, onSuccess, onError);
            return;
        }
        PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, null, 2, null);
        LogUtilsKt.errorLog(purchasesError);
        onError.invoke(purchasesError, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postTransactionAndConsumeIfNeeded$default(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, StoreProduct storeProduct, Map map, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, boolean z2, Function2 function2, Function2 function22, int i, Object obj) {
        Function2 function23;
        PostReceiptHelper postReceiptHelper2;
        StoreTransaction storeTransaction2;
        StoreProduct storeProduct2;
        Map map2;
        boolean z3;
        String str2;
        PostReceiptInitiationSource postReceiptInitiationSource2;
        boolean z4 = (i & 64) != 0 ? false : z2;
        Function2 function24 = (i & 128) != 0 ? null : function2;
        if ((i & 256) != 0) {
            function23 = null;
            storeTransaction2 = storeTransaction;
            storeProduct2 = storeProduct;
            map2 = map;
            z3 = z;
            str2 = str;
            postReceiptInitiationSource2 = postReceiptInitiationSource;
            postReceiptHelper2 = postReceiptHelper;
        } else {
            function23 = function22;
            postReceiptHelper2 = postReceiptHelper;
            storeTransaction2 = storeTransaction;
            storeProduct2 = storeProduct;
            map2 = map;
            z3 = z;
            str2 = str;
            postReceiptInitiationSource2 = postReceiptInitiationSource;
        }
        postReceiptHelper2.postTransactionAndConsumeIfNeeded(storeTransaction2, storeProduct2, map2, z3, str2, postReceiptInitiationSource2, z4, function24, function23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useOfflineEntitlementsCustomerInfoIfNeeded(PostReceiptErrorHandlingBehavior errorHandlingBehavior, String appUserID, Function1<? super CustomerInfo, Unit> onSuccess, final Function0<Unit> onError) {
        if (this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInPostReceipt(errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME)) {
            calculateOfflineCustomerInfo(appUserID, onSuccess, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    onError.invoke();
                }
            });
        } else {
            onError.invoke();
        }
    }

    public final void postRemainingCachedTransactionMetadata(String appUserID, boolean allowSharingPlayStoreAccount, Set<String> pendingTransactionsTokens, Function0<Unit> onNoTransactionsToSync, final Function1<? super PurchasesError, Unit> onError, final Function1<? super CustomerInfo, Unit> onSuccess) {
        String appUserID2 = appUserID;
        Intrinsics.checkNotNullParameter(appUserID2, "appUserID");
        Intrinsics.checkNotNullParameter(pendingTransactionsTokens, "pendingTransactionsTokens");
        Intrinsics.checkNotNullParameter(onNoTransactionsToSync, "onNoTransactionsToSync");
        final Function1<? super PurchasesError, Unit> onError2 = onError;
        Intrinsics.checkNotNullParameter(onError2, "onError");
        final Function1<? super CustomerInfo, Unit> onSuccess2 = onSuccess;
        Intrinsics.checkNotNullParameter(onSuccess2, "onSuccess");
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        final PostReceiptHelper postReceiptHelper = this;
        List<LocalTransactionMetadata> allLocalTransactionMetadata = postReceiptHelper.localTransactionMetadataStore.getAllLocalTransactionMetadata();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allLocalTransactionMetadata) {
            if (!pendingTransactionsTokens.contains(((LocalTransactionMetadata) obj).getToken())) {
                arrayList.add(obj);
            }
        }
        final ArrayList<LocalTransactionMetadata> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            onNoTransactionsToSync.invoke();
            return;
        }
        for (LocalTransactionMetadata localTransactionMetadata : arrayList2) {
            performPostReceipt(appUserID2, localTransactionMetadata.getToken(), allowSharingPlayStoreAccount, localTransactionMetadata.getReceiptInfo(), PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, localTransactionMetadata.getPaywallPostReceiptData(), localTransactionMetadata.getPurchasesAreCompletedBy(), true, new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postRemainingCachedTransactionMetadata$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PostReceiptResponse postReceiptResponse) {
                    invoke2(postReceiptResponse);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PostReceiptResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    concurrentLinkedQueue.add(new Result.Success(it.getCustomerInfo()));
                    postReceiptHelper.callTransactionMetadataCompletionFromResults(arrayList2, concurrentLinkedQueue, onError2, onSuccess2);
                }
            }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper$postRemainingCachedTransactionMetadata$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                    invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PurchasesError backendError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                    Intrinsics.checkNotNullParameter(backendError, "backendError");
                    Intrinsics.checkNotNullParameter(postReceiptErrorHandlingBehavior, "<anonymous parameter 1>");
                    concurrentLinkedQueue.add(new Result.Error(backendError));
                    this.callTransactionMetadataCompletionFromResults(arrayList2, concurrentLinkedQueue, onError, onSuccess);
                }
            });
            postReceiptHelper = this;
            appUserID2 = appUserID;
            onError2 = onError;
            onSuccess2 = onSuccess;
            concurrentLinkedQueue = concurrentLinkedQueue;
            arrayList2 = arrayList2;
        }
    }

    public final void postTokenWithoutConsuming(final String purchaseToken, ReceiptInfo receiptInfo, boolean isRestore, final String appUserID, PostReceiptInitiationSource initiationSource, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError, final Boolean isAutoRenewing) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        postReceiptAndSubscriberAttributes(appUserID, purchaseToken, isRestore, receiptInfo, initiationSource, PurchaseState.UNSPECIFIED_STATE, new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostReceiptResponse postReceiptResponse) {
                invoke2(postReceiptResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostReceiptResponse postReceiptResponse) {
                Intrinsics.checkNotNullParameter(postReceiptResponse, "postReceiptResponse");
                PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(purchaseToken, isAutoRenewing);
                onSuccess.invoke(postReceiptResponse.getCustomerInfo());
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                    PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(purchaseToken, isAutoRenewing);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str = appUserID;
                final Function1<CustomerInfo, Unit> function1 = onSuccess;
                Function1<CustomerInfo, Unit> function12 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2.1
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
                        function1.invoke(it);
                    }
                };
                final Function1<PurchasesError, Unit> function13 = onError;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str, function12, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTokenWithoutConsuming.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function13.invoke(backendError);
                    }
                });
            }
        });
    }

    public final void postTransactionAndConsumeIfNeeded(final StoreTransaction purchase, StoreProduct storeProduct, Map<String, ? extends SubscriptionOption> subscriptionOptionForProductIDs, boolean isRestore, final String appUserID, final PostReceiptInitiationSource initiationSource, boolean sdkOriginated, final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super StoreTransaction, ? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        postReceiptAndSubscriberAttributes(appUserID, purchase.getPurchaseToken(), isRestore, ReceiptInfo.INSTANCE.from(purchase, storeProduct, subscriptionOptionForProductIDs, sdkOriginated), initiationSource, purchase.getPurchaseState(), new Function1<PostReceiptResponse, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostReceiptResponse postReceiptResponse) {
                invoke2(postReceiptResponse);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(PostReceiptResponse postReceiptResponse) {
                boolean zBooleanValue;
                PostReceiptProductInfo postReceiptProductInfo;
                Boolean shouldConsume;
                Intrinsics.checkNotNullParameter(postReceiptResponse, "postReceiptResponse");
                Map<String, PostReceiptProductInfo> productInfoByProductId = postReceiptResponse.getProductInfoByProductId();
                if (productInfoByProductId != null) {
                    StoreTransaction storeTransaction = purchase;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, PostReceiptProductInfo> entry : productInfoByProductId.entrySet()) {
                        if (storeTransaction.getProductIds().contains(entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    Collection collectionValues = linkedHashMap.values();
                    zBooleanValue = (collectionValues == null || (postReceiptProductInfo = (PostReceiptProductInfo) CollectionsKt.firstOrNull(collectionValues)) == null || (shouldConsume = postReceiptProductInfo.getShouldConsume()) == null) ? false : shouldConsume.booleanValue();
                }
                PostReceiptHelper.this.billing.consumeAndSave(PostReceiptHelper.this.getFinishTransactions(), purchase, zBooleanValue, initiationSource);
                Function2<StoreTransaction, CustomerInfo, Unit> function2 = onSuccess;
                if (function2 != null) {
                    function2.invoke(purchase, postReceiptResponse.getCustomerInfo());
                }
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                invoke2(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(backendError, "backendError");
                Intrinsics.checkNotNullParameter(errorHandlingBehavior, "errorHandlingBehavior");
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                    PostReceiptHelper.this.billing.consumeAndSave(PostReceiptHelper.this.getFinishTransactions(), purchase, false, initiationSource);
                }
                PostReceiptHelper postReceiptHelper = PostReceiptHelper.this;
                String str = appUserID;
                final Function2<StoreTransaction, CustomerInfo, Unit> function2 = onSuccess;
                final StoreTransaction storeTransaction = purchase;
                Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2.1
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
                        Function2<StoreTransaction, CustomerInfo, Unit> function22 = function2;
                        if (function22 != null) {
                            function22.invoke(storeTransaction, customerInfo);
                        }
                    }
                };
                final Function2<StoreTransaction, PurchasesError, Unit> function22 = onError;
                final StoreTransaction storeTransaction2 = purchase;
                postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, str, function1, new Function0<Unit>() { // from class: com.revenuecat.purchases.PostReceiptHelper.postTransactionAndConsumeIfNeeded.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function2<StoreTransaction, PurchasesError, Unit> function23 = function22;
                        if (function23 != null) {
                            function23.invoke(storeTransaction2, backendError);
                        }
                    }
                });
            }
        });
    }
}
