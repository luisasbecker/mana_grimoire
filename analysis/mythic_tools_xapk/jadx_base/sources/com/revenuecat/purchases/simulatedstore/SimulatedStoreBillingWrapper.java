package com.revenuecat.purchases.simulatedstore;

import android.app.Activity;
import android.os.Handler;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.networking.WebBillingProductResponse;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.utils.AlertDialogHelper;
import com.revenuecat.purchases.utils.DefaultAlertDialogHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SimulatedStoreBillingWrapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0014JH\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100$H\u0016J4\u0010'\u001a\u00020\u00102\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100$2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100$j\u0002`)H\u0016J\b\u0010*\u001a\u00020\u000eH\u0016JC\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u00103JB\u00104\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0018\u00105\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001806\u0012\u0004\u0012\u00020\u00100$2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100$j\u0002`)H\u0016JT\u00108\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f0:2\u001c\u0010;\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001206\u0012\u0004\u0012\u00020\u00100$j\u0002`<2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100$j\u0002`)H\u0016JD\u0010=\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00180>\u0012\u0004\u0012\u00020\u00100$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100$H\u0016J,\u0010?\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A062\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100CH\u0016J\"\u0010D\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010E\u001a\u00020\u0010H\u0016J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020HH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/revenuecat/purchases/simulatedstore/SimulatedStoreBillingWrapper;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "mainHandler", "Landroid/os/Handler;", "purchasesStateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "dialogHelper", "Lcom/revenuecat/purchases/utils/AlertDialogHelper;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Landroid/os/Handler;Lcom/revenuecat/purchases/PurchasesStateProvider;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/utils/AlertDialogHelper;)V", "connected", "", "completePurchase", "", "product", "Lcom/revenuecat/purchases/models/StoreProduct;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "consumeAndSave", "finishTransactions", FirebaseAnalytics.Event.PURCHASE, "Lcom/revenuecat/purchases/models/StoreTransaction;", "shouldConsume", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "endConnection", "findPurchaseInPurchaseHistory", "appUserID", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "productId", "onCompletion", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getStorefront", "onSuccess", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "isConnected", "makePurchaseAsync", "activity", "Landroid/app/Activity;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "isPersonalizedPrice", "(Landroid/app/Activity;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/common/ReplaceProductInfo;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Boolean;)V", "queryAllPurchases", "onReceivePurchaseHistory", "", "onReceivePurchaseHistoryError", InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, "productIds", "", "onReceive", "Lcom/revenuecat/purchases/common/StoreProductsCallback;", InAppPurchaseConstants.METHOD_QUERY_PURCHASES, "", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "subscriptionStatusChange", "Lkotlin/Function0;", "showPurchaseDialog", InAppPurchaseConstants.METHOD_START_CONNECTION, "startConnectionOnMainThread", "delayMilliseconds", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimulatedStoreBillingWrapper extends BillingAbstract {
    private final Backend backend;
    private volatile boolean connected;
    private final DeviceCache deviceCache;
    private final AlertDialogHelper dialogHelper;
    private final Handler mainHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler mainHandler, PurchasesStateProvider purchasesStateProvider, Backend backend, AlertDialogHelper dialogHelper) {
        super(purchasesStateProvider);
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(purchasesStateProvider, "purchasesStateProvider");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(dialogHelper, "dialogHelper");
        this.deviceCache = deviceCache;
        this.mainHandler = mainHandler;
        this.backend = backend;
        this.dialogHelper = dialogHelper;
    }

    public /* synthetic */ SimulatedStoreBillingWrapper(DeviceCache deviceCache, Handler handler, PurchasesStateProvider purchasesStateProvider, Backend backend, DefaultAlertDialogHelper defaultAlertDialogHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, handler, purchasesStateProvider, backend, (i & 16) != 0 ? new DefaultAlertDialogHelper() : defaultAlertDialogHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completePurchase(StoreProduct product, PresentedOfferingContext presentedOfferingContext) throws JSONException {
        Map mapEmptyMap;
        String str;
        long time = new Date().getTime();
        String str2 = "test_" + time + '_' + UUID.randomUUID();
        List listListOf = CollectionsKt.listOf(product.getId());
        ProductType type = product.getType();
        PurchaseState purchaseState = PurchaseState.PURCHASED;
        Boolean boolValueOf = Boolean.valueOf(product.getType() == ProductType.SUBS);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("orderId", str2);
        jSONObject.put("productId", product.getId());
        jSONObject.put(Constants.GP_IAP_PURCHASE_TIME, time);
        jSONObject.put(Constants.GP_IAP_PURCHASE_TOKEN, str2);
        jSONObject.put("purchaseState", PurchaseState.PURCHASED.ordinal());
        Unit unit = Unit.INSTANCE;
        PurchaseType purchaseType = PurchaseType.GOOGLE_PURCHASE;
        SubscriptionOption defaultOption = product.getDefaultOption();
        String str3 = defaultOption != null ? defaultOption.get$id() : null;
        SubscriptionOption defaultOption2 = product.getDefaultOption();
        if (defaultOption2 == null || (str = defaultOption2.get$id()) == null || (mapEmptyMap = MapsKt.mapOf(TuplesKt.to(product.getId(), str))) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        StoreTransaction storeTransaction = new StoreTransaction(str2, listListOf, type, time, str2, purchaseState, boolValueOf, null, jSONObject, presentedOfferingContext, null, purchaseType, null, str3, mapEmptyMap, null);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
        }
    }

    private final void showPurchaseDialog(Activity activity, final StoreProduct product, final PresentedOfferingContext presentedOfferingContext) {
        StringBuilder sb = new StringBuilder("This is a test purchase and should only be used during development. In production, use a Google/Amazon API key from RevenueCat.\n\n");
        sb.append("Product: " + product.getId() + '\n');
        sb.append("Price: " + product.getPrice().getFormatted() + '\n');
        SubscriptionOption defaultOption = product.getDefaultOption();
        if (defaultOption != null) {
            for (PricingPhase pricingPhase : defaultOption.getPricingPhases()) {
                sb.append("Phase: " + pricingPhase.getPrice().getFormatted() + " for " + pricingPhase.getBillingPeriod().getIso8601() + '\n');
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.dialogHelper.showDialog(activity, "Test Store Purchase", string, "Test valid purchase", "Test failed purchase", "Cancel", new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws JSONException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws JSONException {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "[Test store] Performing test purchase. This purchase won't appear in production.");
                }
                SimulatedStoreBillingWrapper.this.completePurchase(product, presentedOfferingContext);
            }
        }, new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.2
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
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "[Test store] Purchase failure simulated successfully in Test Store.");
                }
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener != null) {
                    purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.TestStoreSimulatedPurchaseError, "Simulated error successfully."));
                }
            }
        }, new Function0<Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.showPurchaseDialog.3
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
                BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = SimulatedStoreBillingWrapper.this.getPurchasesUpdatedListener();
                if (purchasesUpdatedListener != null) {
                    purchasesUpdatedListener.onPurchasesFailedToUpdate(new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, "Purchase cancelled by user"));
                }
            }
        });
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void consumeAndSave(boolean finishTransactions, StoreTransaction purchase, boolean shouldConsume, PostReceiptInitiationSource initiationSource) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: consumeAndSave - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    protected void endConnection() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Ending connection");
        }
        this.connected = false;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void findPurchaseInPurchaseHistory(String appUserID, ProductType productType, String productId, Function1<? super StoreTransaction, Unit> onCompletion, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: findPurchaseInPurchaseHistory for product: " + productId + " will always fail");
        }
        onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, "No active purchase found for product: " + productId));
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void getStorefront(Function1<? super String, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: getStorefront - returning US by default");
        }
        onSuccess.invoke("US");
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    /* JADX INFO: renamed from: isConnected, reason: from getter */
    public boolean getConnected() {
        return this.connected;
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void makePurchaseAsync(Activity activity, String appUserID, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, PresentedOfferingContext presentedOfferingContext, Boolean isPersonalizedPrice) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasingData, "purchasingData");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: makePurchaseAsync for product: " + purchasingData.getProductId());
        }
        SimulatedStorePurchasingData simulatedStorePurchasingData = purchasingData instanceof SimulatedStorePurchasingData ? (SimulatedStorePurchasingData) purchasingData : null;
        if (simulatedStorePurchasingData == null) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Purchasing data is not a valid SimulatedStorePurchasingData: " + purchasingData.getProductId()));
        }
        showPurchaseDialog(activity, simulatedStorePurchasingData.getStoreProduct(), presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryAllPurchases(String appUserID, Function1<? super List<StoreTransaction>, Unit> onReceivePurchaseHistory, Function1<? super PurchasesError, Unit> onReceivePurchaseHistoryError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistory, "onReceivePurchaseHistory");
        Intrinsics.checkNotNullParameter(onReceivePurchaseHistoryError, "onReceivePurchaseHistoryError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryAllPurchases - returning empty list");
        }
        onReceivePurchaseHistory.invoke(CollectionsKt.emptyList());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryProductDetailsAsync(ProductType productType, Set<String> productIds, final Function1<? super List<? extends StoreProduct>, Unit> onReceive, final Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryProductDetailsAsync for products: " + productIds);
        }
        Backend backend = this.backend;
        String cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release == null) {
            cachedAppUserID$purchases_defaultsBc8Release = "";
        }
        backend.getWebBillingProducts(cachedAppUserID$purchases_defaultsBc8Release, productIds, new Function1<WebBillingProductsResponse, Unit>() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper.queryProductDetailsAsync.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebBillingProductsResponse webBillingProductsResponse) {
                invoke2(webBillingProductsResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebBillingProductsResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    List<WebBillingProductResponse> productDetails = response.getProductDetails();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productDetails, 10));
                    Iterator<T> it = productDetails.iterator();
                    while (it.hasNext()) {
                        arrayList.add(SimulatedStoreProductConverter.convertToStoreProduct$default(SimulatedStoreProductConverter.INSTANCE, (WebBillingProductResponse) it.next(), null, 2, null));
                    }
                    onReceive.invoke(arrayList);
                } catch (PurchasesException e) {
                    onError.invoke(e.getError());
                }
            }
        }, onError);
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void queryPurchases(String appUserID, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: queryPurchases - returning empty map");
        }
        onSuccess.invoke(MapsKt.emptyMap());
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes, Function0<Unit> subscriptionStatusChange) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        Intrinsics.checkNotNullParameter(subscriptionStatusChange, "subscriptionStatusChange");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: showInAppMessagesIfNeeded - no-op for test store");
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnection() {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "SimulatedStoreBillingAbstract: Starting connection");
        }
        this.connected = true;
        BillingAbstract.StateListener stateListener = getStateListener();
        if (stateListener != null) {
            stateListener.onConnected();
        }
    }

    @Override // com.revenuecat.purchases.common.BillingAbstract
    public void startConnectionOnMainThread(long delayMilliseconds) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.simulatedstore.SimulatedStoreBillingWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startConnection();
            }
        }, delayMilliseconds);
    }
}
