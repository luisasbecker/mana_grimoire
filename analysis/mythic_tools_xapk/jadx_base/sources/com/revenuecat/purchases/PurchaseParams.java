package com.revenuecat.purchases;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GalaxyReplacementMode;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseParams.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020(8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams;", "", "builder", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;)V", "activity", "Landroid/app/Activity;", "getActivity$purchases_defaultsBc8Release", "()Landroid/app/Activity;", "getBuilder", "()Lcom/revenuecat/purchases/PurchaseParams$Builder;", "containsAddOnItems", "", "getContainsAddOnItems$purchases_defaultsBc8Release$annotations", "()V", "getContainsAddOnItems$purchases_defaultsBc8Release", "()Z", "galaxyReplacementMode", "Lcom/revenuecat/purchases/models/GalaxyReplacementMode;", "getGalaxyReplacementMode$annotations", "getGalaxyReplacementMode", "()Lcom/revenuecat/purchases/models/GalaxyReplacementMode;", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getGoogleReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "isPersonalizedPrice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "oldProductId", "", "getOldProductId", "()Ljava/lang/String;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPresentedOfferingContext$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/PurchasingData;", "Builder", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseParams {
    private final Activity activity;
    private final Builder builder;
    private final GalaxyReplacementMode galaxyReplacementMode;
    private final GoogleReplacementMode googleReplacementMode;
    private final Boolean isPersonalizedPrice;
    private final String oldProductId;
    private PresentedOfferingContext presentedOfferingContext;
    private final PurchasingData purchasingData;

    /* JADX INFO: compiled from: PurchaseParams.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\u0016\u0010;\u001a\u00020\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0007J\u0016\u0010=\u001a\u00020\u00002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0<H\u0007J\u0016\u0010>\u001a\u00020\u00002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0007J\u0016\u0010?\u001a\u00020\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0<H\u0002J\b\u0010B\u001a\u00020CH\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u001e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R,\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0015\u001a\u0004\u0018\u00010$8@@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0015\u001a\u0004\u0018\u00010+8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams$Builder;", "", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;)V", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;)V", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "product", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/models/StoreProduct;)V", "getActivity$purchases_defaultsBc8Release", "()Landroid/app/Activity;", "<set-?>", "Lcom/revenuecat/purchases/models/GalaxyReplacementMode;", "galaxyReplacementMode", "getGalaxyReplacementMode$purchases_defaultsBc8Release$annotations", "()V", "getGalaxyReplacementMode$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/GalaxyReplacementMode;", "setGalaxyReplacementMode$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/GalaxyReplacementMode;)V", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "googleReplacementMode", "getGoogleReplacementMode$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "setGoogleReplacementMode$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/GoogleReplacementMode;)V", "", "isPersonalizedPrice", "isPersonalizedPrice$purchases_defaultsBc8Release", "()Ljava/lang/Boolean;", "setPersonalizedPrice$purchases_defaultsBc8Release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "", "oldProductId", "getOldProductId$purchases_defaultsBc8Release", "()Ljava/lang/String;", "setOldProductId$purchases_defaultsBc8Release", "(Ljava/lang/String;)V", "getPresentedOfferingContext$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPresentedOfferingContext$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getProduct$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchasingData$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/PurchasingData;", "setPurchasingData$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/PurchasingData;)V", "addOnPackages", "", "addOnStoreProducts", "addOnSubscriptionOptions", "attachSubscriptionAddOns", "addOns", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "build", "Lcom/revenuecat/purchases/PurchaseParams;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Builder {
        private final Activity activity;
        private GalaxyReplacementMode galaxyReplacementMode;
        private GoogleReplacementMode googleReplacementMode;
        private Boolean isPersonalizedPrice;
        private String oldProductId;
        private PresentedOfferingContext presentedOfferingContext;
        private final StoreProduct product;
        private PurchasingData purchasingData;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, Package packageToPurchase) {
            this(activity, packageToPurchase.getProduct().getPurchasingData(), packageToPurchase.getPresentedOfferingContext(), packageToPurchase.getProduct());
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        }

        private Builder(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, StoreProduct storeProduct) {
            this.activity = activity;
            this.purchasingData = purchasingData;
            this.presentedOfferingContext = presentedOfferingContext;
            this.product = storeProduct;
            this.googleReplacementMode = GoogleReplacementMode.WITHOUT_PRORATION;
            this.galaxyReplacementMode = GalaxyReplacementMode.INSTANCE.getDefault();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, StoreProduct storeProduct) {
            this(activity, storeProduct.getPurchasingData(), storeProduct.getPresentedOfferingContext(), storeProduct);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, SubscriptionOption subscriptionOption) {
            this(activity, subscriptionOption.getPurchasingData(), subscriptionOption.getPresentedOfferingContext(), null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final Builder attachSubscriptionAddOns(List<? extends GooglePurchasingData> addOns) {
            if (addOns.isEmpty()) {
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchaseParams$Builder$attachSubscriptionAddOns$lambda$14$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " An empty list of add-ons was provided. Will proceed with purchasing the base product.";
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        return this;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        return this;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        return this;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                            return this;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        return this;
                }
            } else {
                PurchasingData purchasingData = this.purchasingData;
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GooglePurchasingData googlePurchasingData : addOns) {
                        GooglePurchasingData.Subscription subscription2 = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
                        if (subscription2 != null) {
                            arrayList.add(subscription2);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    String productId = subscription.getProductId();
                    String optionId = subscription.getOptionId();
                    ProductDetails productDetails = subscription.getProductDetails();
                    String token = subscription.getToken();
                    Period billingPeriod = subscription.getBillingPeriod();
                    List addOnProducts = subscription.getAddOnProducts();
                    if (addOnProducts == null) {
                        addOnProducts = CollectionsKt.emptyList();
                    }
                    this.purchasingData = new GooglePurchasingData.Subscription(productId, optionId, productDetails, token, billingPeriod, CollectionsKt.plus((Collection) addOnProducts, (Iterable) arrayList2));
                }
            }
            return this;
        }

        public static /* synthetic */ void getGalaxyReplacementMode$purchases_defaultsBc8Release$annotations() {
        }

        public final Builder addOnPackages(List<Package> addOnPackages) {
            Intrinsics.checkNotNullParameter(addOnPackages, "addOnPackages");
            List<Package> list = addOnPackages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Package) it.next()).getProduct());
            }
            addOnStoreProducts(arrayList);
            return this;
        }

        public final Builder addOnStoreProducts(List<? extends StoreProduct> addOnStoreProducts) {
            Intrinsics.checkNotNullParameter(addOnStoreProducts, "addOnStoreProducts");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnStoreProducts.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((StoreProduct) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        public final Builder addOnSubscriptionOptions(List<? extends SubscriptionOption> addOnSubscriptionOptions) {
            Intrinsics.checkNotNullParameter(addOnSubscriptionOptions, "addOnSubscriptionOptions");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnSubscriptionOptions.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((SubscriptionOption) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        public PurchaseParams build() {
            return new PurchaseParams(this);
        }

        public final Builder galaxyReplacementMode(GalaxyReplacementMode galaxyReplacementMode) {
            Intrinsics.checkNotNullParameter(galaxyReplacementMode, "galaxyReplacementMode");
            this.galaxyReplacementMode = galaxyReplacementMode;
            return this;
        }

        /* JADX INFO: renamed from: getActivity$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ Activity getActivity() {
            return this.activity;
        }

        /* JADX INFO: renamed from: getGalaxyReplacementMode$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ GalaxyReplacementMode getGalaxyReplacementMode() {
            return this.galaxyReplacementMode;
        }

        /* JADX INFO: renamed from: getGoogleReplacementMode$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ GoogleReplacementMode getGoogleReplacementMode() {
            return this.googleReplacementMode;
        }

        /* JADX INFO: renamed from: getOldProductId$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ String getOldProductId() {
            return this.oldProductId;
        }

        /* JADX INFO: renamed from: getPresentedOfferingContext$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX INFO: renamed from: getProduct$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ StoreProduct getProduct() {
            return this.product;
        }

        /* JADX INFO: renamed from: getPurchasingData$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ PurchasingData getPurchasingData() {
            return this.purchasingData;
        }

        public final Builder googleReplacementMode(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
            this.googleReplacementMode = googleReplacementMode;
            return this;
        }

        public final Builder isPersonalizedPrice(boolean isPersonalizedPrice) {
            this.isPersonalizedPrice = Boolean.valueOf(isPersonalizedPrice);
            return this;
        }

        /* JADX INFO: renamed from: isPersonalizedPrice$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ Boolean getIsPersonalizedPrice() {
            return this.isPersonalizedPrice;
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        public final Builder presentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.presentedOfferingContext = presentedOfferingContext;
            return this;
        }

        public final /* synthetic */ void setGalaxyReplacementMode$purchases_defaultsBc8Release(GalaxyReplacementMode galaxyReplacementMode) {
            Intrinsics.checkNotNullParameter(galaxyReplacementMode, "<set-?>");
            this.galaxyReplacementMode = galaxyReplacementMode;
        }

        public final /* synthetic */ void setGoogleReplacementMode$purchases_defaultsBc8Release(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "<set-?>");
            this.googleReplacementMode = googleReplacementMode;
        }

        public final /* synthetic */ void setOldProductId$purchases_defaultsBc8Release(String str) {
            this.oldProductId = str;
        }

        public final /* synthetic */ void setPersonalizedPrice$purchases_defaultsBc8Release(Boolean bool) {
            this.isPersonalizedPrice = bool;
        }

        public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
            this.presentedOfferingContext = presentedOfferingContext;
        }

        public final void setPurchasingData$purchases_defaultsBc8Release(PurchasingData purchasingData) {
            Intrinsics.checkNotNullParameter(purchasingData, "<set-?>");
            this.purchasingData = purchasingData;
        }
    }

    public PurchaseParams(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.isPersonalizedPrice = builder.getIsPersonalizedPrice();
        this.oldProductId = builder.getOldProductId();
        this.googleReplacementMode = builder.getGoogleReplacementMode();
        this.galaxyReplacementMode = builder.getGalaxyReplacementMode();
        this.purchasingData = builder.getPurchasingData();
        this.activity = builder.getActivity();
        this.presentedOfferingContext = builder.getPresentedOfferingContext();
    }

    public static /* synthetic */ void getContainsAddOnItems$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getGalaxyReplacementMode$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchaseParams) && Intrinsics.areEqual(this.builder, ((PurchaseParams) obj).builder);
    }

    /* JADX INFO: renamed from: getActivity$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ Activity getActivity() {
        return this.activity;
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    public final /* synthetic */ boolean getContainsAddOnItems$purchases_defaultsBc8Release() {
        List addOnProducts;
        PurchasingData purchasingData = this.purchasingData;
        GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
        if (subscription == null || (addOnProducts = subscription.getAddOnProducts()) == null) {
            return false;
        }
        return !addOnProducts.isEmpty();
    }

    public final GalaxyReplacementMode getGalaxyReplacementMode() {
        return this.galaxyReplacementMode;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    /* JADX INFO: renamed from: getPresentedOfferingContext$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX INFO: renamed from: getPurchasingData$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PurchasingData getPurchasingData() {
        return this.purchasingData;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    /* JADX INFO: renamed from: isPersonalizedPrice, reason: from getter */
    public final Boolean getIsPersonalizedPrice() {
        return this.isPersonalizedPrice;
    }

    public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public String toString() {
        return "PurchaseParams(builder=" + this.builder + ')';
    }
}
