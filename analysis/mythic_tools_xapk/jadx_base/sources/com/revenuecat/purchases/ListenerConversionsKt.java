package com.revenuecat.purchases;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: listenerConversions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u001a0\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u001aN\u0010\u000e\u001a\u00020\u000f2!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u001ag\u0010\u0012\u001a\u00020\u001328\u0010\u0002\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00142#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0000\u001az\u0010\u0019\u001a\u00020\u001a28\u0010\u0002\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u001426\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\u0014H\u0000\u001a?\u0010\u001e\u001a\u00020\u001f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u001a?\u0010!\u001a\u00020\"2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u001aC\u0010#\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001aR\u0010%\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0003\u001aZ\u0010%\u001a\u00020\u0005*\u00020$2\u0006\u0010&\u001a\u00020'2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0003\u001af\u0010(\u001a\u00020\u0005*\u00020$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032'\u0010,\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020-0*¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001aT\u0010/\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001ah\u00102\u001a\u00020\u0005*\u00020$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032'\u0010,\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020-0*¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001aR\u00103\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u0003\u001ao\u00104\u001a\u00020\u0005*\u00020$2\u0006\u00105\u001a\u00020+2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000326\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00050\u0014\u001aR\u00106\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0003\u001a\u008e\u0001\u00107\u001a\u00020\u0005*\u00020$2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;28\b\u0002\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\u001426\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0014H\u0007\u001a\u008e\u0001\u0010<\u001a\u00020\u0005*\u00020$2\u0006\u00108\u001a\u0002092\u0006\u0010=\u001a\u00020-28\b\u0002\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\u001426\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0014H\u0007\u001aC\u0010>\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00050\u0003\u001aC\u0010?\u001a\u00020\u0005*\u00020$2#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006@"}, d2 = {"getAmazonLWAConsentStatusListener", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lkotlin/ParameterName;", "name", "error", "getCustomerCenterConfigDataListener", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "getVirtualCurrenciesCallback", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "virtualCurrencies", "logInSuccessListener", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "", "created", "productChangeCompletedListener", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/models/StoreTransaction;", FirebaseAnalytics.Event.PURCHASE, "userCancelled", "syncAttributesAndOfferingsListener", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "Lcom/revenuecat/purchases/Offerings;", "syncPurchasesListener", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "getAmazonLWAConsentStatusWith", "Lcom/revenuecat/purchases/Purchases;", "getCustomerInfoWith", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "getNonSubscriptionSkusWith", "skus", "", "", "onReceiveSkus", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "getStorefrontLocaleWith", "Ljava/util/Locale;", "storefrontLocale", "getSubscriptionSkusWith", "getVirtualCurrenciesWith", "logInWith", "appUserID", "logOutWith", "purchasePackageWith", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "purchaseProductWith", "storeProduct", "syncAttributesAndOfferingsIfNeededWith", "syncPurchasesWith", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListenerConversionsKt {
    public static final GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusListener(final Function1<? super AmazonLWAConsentStatus, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetAmazonLWAConsentStatusCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getAmazonLWAConsentStatusListener.1
            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onSuccess(AmazonLWAConsentStatus consentStatus) {
                Intrinsics.checkNotNullParameter(consentStatus, "consentStatus");
                onSuccess.invoke(consentStatus);
            }
        };
    }

    public static final void getAmazonLWAConsentStatusWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super AmazonLWAConsentStatus, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getAmazonLWAConsentStatus(getAmazonLWAConsentStatusListener(onSuccess, onError));
    }

    public static /* synthetic */ void getAmazonLWAConsentStatusWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getAmazonLWAConsentStatusWith(purchases, function1, function12);
    }

    public static final GetCustomerCenterConfigCallback getCustomerCenterConfigDataListener(final Function1<? super CustomerCenterConfigData, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getCustomerCenterConfigDataListener.1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                Intrinsics.checkNotNullParameter(customerCenterConfig, "customerCenterConfig");
                onSuccess.invoke(customerCenterConfig);
            }
        };
    }

    public static final void getCustomerInfoWith(Purchases purchases, CacheFetchPolicy fetchPolicy, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(fetchPolicy, ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static final void getCustomerInfoWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, cacheFetchPolicy, function1, function12);
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, function1, function12);
    }

    @Deprecated(message = "Replaced with getProductsWith() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProductsWith()", imports = {}))
    public static final void getNonSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.INAPP, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static final void getStorefrontLocaleWith(Purchases purchases, final Function1<? super PurchasesError, Unit> onError, final Function1<? super Locale, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getStorefrontLocale(new GetStorefrontLocaleCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getStorefrontLocaleWith.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onReceived(Locale storefrontLocale) {
                Intrinsics.checkNotNullParameter(storefrontLocale, "storefrontLocale");
                onSuccess.invoke(storefrontLocale);
            }
        });
    }

    public static /* synthetic */ void getStorefrontLocaleWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getStorefrontLocaleWith(purchases, function1, function12);
    }

    @Deprecated(message = "Replaced with getProductsWith() which returns both subscriptions and non-subscriptions", replaceWith = @ReplaceWith(expression = "getProductsWith()", imports = {}))
    public static final void getSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.SUBS, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static /* synthetic */ void getSubscriptionSkusWith$default(Purchases purchases, List list, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getSubscriptionSkusWith(purchases, list, function1, function12);
    }

    public static final GetVirtualCurrenciesCallback getVirtualCurrenciesCallback(final Function1<? super VirtualCurrencies, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetVirtualCurrenciesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getVirtualCurrenciesCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onReceived(VirtualCurrencies virtualCurrencies) {
                Intrinsics.checkNotNullParameter(virtualCurrencies, "virtualCurrencies");
                onSuccess.invoke(virtualCurrencies);
            }
        };
    }

    public static final void getVirtualCurrenciesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super VirtualCurrencies, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getVirtualCurrencies(getVirtualCurrenciesCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getVirtualCurrenciesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getVirtualCurrenciesWith(purchases, function1, function12);
    }

    public static final LogInCallback logInSuccessListener(final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new LogInCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.logInSuccessListener.1
            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                    function1.invoke(error);
                }
            }

            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onReceived(CustomerInfo customerInfo, boolean created) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                if (function2 != null) {
                    function2.invoke(customerInfo, Boolean.valueOf(created));
                }
            }
        };
    }

    public static final void logInWith(Purchases purchases, String appUserID, Function1<? super PurchasesError, Unit> onError, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logIn(appUserID, logInSuccessListener(onSuccess, onError));
    }

    public static /* synthetic */ void logInWith$default(Purchases purchases, String str, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logInWith(purchases, str, function1, function2);
    }

    public static final void logOutWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logOut(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void logOutWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logOutWith(purchases, function1, function12);
    }

    public static final ProductChangeCallback productChangeCompletedListener(final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ProductChangeCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.productChangeCompletedListener.1
            @Override // com.revenuecat.purchases.interfaces.ProductChangeCallback
            public void onCompleted(StoreTransaction purchase, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(purchase, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean userCancelled) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error, Boolean.valueOf(userCancelled));
            }
        };
    }

    @Deprecated(message = "Use purchaseWith and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchaseWith()", imports = {}))
    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r2, Function2 function2, Function2 function22, int i, Object obj) throws PurchasesException {
        if ((i & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r2, function2, function22);
    }

    @Deprecated(message = "Use purchase() and PurchaseParams.Builder instead", replaceWith = @ReplaceWith(expression = "purchase()", imports = {}))
    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2 function2, Function2 function22, int i, Object obj) throws PurchasesException {
        if ((i & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, function2, function22);
    }

    public static final void syncAttributesAndOfferingsIfNeededWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.syncAttributesAndOfferingsIfNeeded(syncAttributesAndOfferingsListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncAttributesAndOfferingsIfNeededWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncAttributesAndOfferingsIfNeededWith(purchases, function1, function12);
    }

    public static final SyncAttributesAndOfferingsCallback syncAttributesAndOfferingsListener(final Function1<? super Offerings, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new SyncAttributesAndOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncAttributesAndOfferingsListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onSuccess(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final SyncPurchasesCallback syncPurchasesListener(final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new SyncPurchasesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncPurchasesListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        };
    }

    public static final void syncPurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.syncPurchases(syncPurchasesListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncPurchasesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncPurchasesWith(purchases, function1, function12);
    }
}
