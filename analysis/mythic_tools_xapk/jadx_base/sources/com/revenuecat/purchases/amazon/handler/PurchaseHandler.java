package com.revenuecat.purchases.amazon.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivityBroadcastReceiver;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: PurchaseHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0013\b\u0000\u0018\u00002\u00020\u0001:\u0001)B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJK\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016JV\u0010$\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0016JN\u0010(\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler;", "Lcom/revenuecat/purchases/amazon/listener/PurchaseResponseListener;", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "applicationContext", "Landroid/content/Context;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;Landroid/content/Context;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/DateProvider;)V", "productTypes", "", "", "Lcom/revenuecat/purchases/ProductType;", "purchaseCallbacks", "Lcom/amazon/device/iap/model/RequestId;", "Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler$PurchaseRequest;", "createRequestIdResultReceiver", "com/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1", "mainHandler", "Landroid/os/Handler;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "onSuccess", "Lkotlin/Function2;", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "(Landroid/os/Handler;Lcom/revenuecat/purchases/models/StoreProduct;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1;", "onPurchaseResponse", "response", "Lcom/amazon/device/iap/model/PurchaseResponse;", FirebaseAnalytics.Event.PURCHASE, "activity", "Landroid/app/Activity;", "appUserID", "startProxyActivity", "PurchaseRequest", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseHandler implements PurchaseResponseListener {
    private final Context applicationContext;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Map<String, ProductType> productTypes;
    private final Map<RequestId, PurchaseRequest> purchaseCallbacks;
    private final PurchasingServiceProvider purchasingServiceProvider;

    /* JADX INFO: compiled from: PurchaseHandler.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/amazon/handler/PurchaseHandler$PurchaseRequest;", "", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "startTime", "Ljava/util/Date;", "onSuccess", "Lkotlin/Function2;", "Lcom/amazon/device/iap/model/Receipt;", "Lcom/amazon/device/iap/model/UserData;", "", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/models/StoreProduct;Ljava/util/Date;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnSuccess", "()Lkotlin/jvm/functions/Function2;", "getStartTime", "()Ljava/util/Date;", "getStoreProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class PurchaseRequest {
        private final Function1<PurchasesError, Unit> onError;
        private final Function2<Receipt, UserData, Unit> onSuccess;
        private final Date startTime;
        private final StoreProduct storeProduct;

        /* JADX WARN: Multi-variable type inference failed */
        public PurchaseRequest(StoreProduct storeProduct, Date startTime, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.storeProduct = storeProduct;
            this.startTime = startTime;
            this.onSuccess = onSuccess;
            this.onError = onError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PurchaseRequest copy$default(PurchaseRequest purchaseRequest, StoreProduct storeProduct, Date date, Function2 function2, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                storeProduct = purchaseRequest.storeProduct;
            }
            if ((i & 2) != 0) {
                date = purchaseRequest.startTime;
            }
            if ((i & 4) != 0) {
                function2 = purchaseRequest.onSuccess;
            }
            if ((i & 8) != 0) {
                function1 = purchaseRequest.onError;
            }
            return purchaseRequest.copy(storeProduct, date, function2, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getStartTime() {
            return this.startTime;
        }

        public final Function2<Receipt, UserData, Unit> component3() {
            return this.onSuccess;
        }

        public final Function1<PurchasesError, Unit> component4() {
            return this.onError;
        }

        public final PurchaseRequest copy(StoreProduct storeProduct, Date startTime, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            return new PurchaseRequest(storeProduct, startTime, onSuccess, onError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PurchaseRequest)) {
                return false;
            }
            PurchaseRequest purchaseRequest = (PurchaseRequest) other;
            return Intrinsics.areEqual(this.storeProduct, purchaseRequest.storeProduct) && Intrinsics.areEqual(this.startTime, purchaseRequest.startTime) && Intrinsics.areEqual(this.onSuccess, purchaseRequest.onSuccess) && Intrinsics.areEqual(this.onError, purchaseRequest.onError);
        }

        public final Function1<PurchasesError, Unit> getOnError() {
            return this.onError;
        }

        public final Function2<Receipt, UserData, Unit> getOnSuccess() {
            return this.onSuccess;
        }

        public final Date getStartTime() {
            return this.startTime;
        }

        public final StoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        public int hashCode() {
            return (((((this.storeProduct.hashCode() * 31) + this.startTime.hashCode()) * 31) + this.onSuccess.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "PurchaseRequest(storeProduct=" + this.storeProduct + ", startTime=" + this.startTime + ", onSuccess=" + this.onSuccess + ", onError=" + this.onError + ')';
        }
    }

    /* JADX INFO: compiled from: PurchaseHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseResponse.RequestStatus.values().length];
            try {
                iArr[PurchaseResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.INVALID_SKU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.ALREADY_PURCHASED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider, Context applicationContext, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.applicationContext = applicationContext;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.productTypes = new LinkedHashMap();
        this.purchaseCallbacks = new LinkedHashMap();
    }

    public /* synthetic */ PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider, Context context, DiagnosticsTracker diagnosticsTracker, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasingServiceProvider, context, diagnosticsTracker, (i & 8) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.revenuecat.purchases.amazon.handler.PurchaseHandler$createRequestIdResultReceiver$1] */
    private final AnonymousClass1 createRequestIdResultReceiver(Handler mainHandler, final StoreProduct storeProduct, final Function2<? super Receipt, ? super UserData, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        return new ResultReceiver(mainHandler) { // from class: com.revenuecat.purchases.amazon.handler.PurchaseHandler.createRequestIdResultReceiver.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                Object obj;
                PurchaseHandler purchaseHandler = this;
                StoreProduct storeProduct2 = storeProduct;
                Function2<Receipt, UserData, Unit> function2 = onSuccess;
                Function1<PurchasesError, Unit> function1 = onError;
                synchronized (purchaseHandler) {
                    if (resultData != null) {
                        try {
                            obj = resultData.get(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        obj = null;
                    }
                    RequestId requestId = obj instanceof RequestId ? (RequestId) obj : null;
                    if (requestId != null) {
                        purchaseHandler.purchaseCallbacks.put(requestId, new PurchaseRequest(storeProduct2, purchaseHandler.dateProvider.getNow(), function2, function1));
                        purchaseHandler.productTypes.put(storeProduct2.getId(), storeProduct2.getType());
                    } else {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "No RequestId coming from ProxyAmazonBillingActivity", null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    private final void startProxyActivity(Handler mainHandler, Activity activity, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        activity.startActivity(ProxyAmazonBillingActivity.INSTANCE.newStartIntent(activity, createRequestIdResultReceiver(mainHandler, storeProduct, onSuccess, onError), storeProduct.getId(), this.purchasingServiceProvider));
    }

    public void onPurchaseResponse(final PurchaseResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        PurchaseRequest purchaseRequestRemove;
        PurchasesErrorCode code;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.PurchaseHandler$onPurchaseResponse$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str2 = String.format(AmazonStrings.PURCHASE_REQUEST_FINISHED, Arrays.copyOf(new Object[]{response.toJSON().toString(1)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return sbAppend.append(str2).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            ProxyAmazonBillingActivityBroadcastReceiver.Companion companion = ProxyAmazonBillingActivityBroadcastReceiver.INSTANCE;
            String packageName = this.applicationContext.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "applicationContext.packageName");
            this.applicationContext.sendBroadcast(companion.newPurchaseFinishedIntent(packageName));
            RequestId requestId = response.getRequestId();
            synchronized (this) {
                purchaseRequestRemove = this.purchaseCallbacks.remove(requestId);
            }
            if (purchaseRequestRemove != null) {
                StoreProduct storeProduct = purchaseRequestRemove.getStoreProduct();
                Date startTime = purchaseRequestRemove.getStartTime();
                Function2<Receipt, UserData, Unit> function2Component3 = purchaseRequestRemove.component3();
                Function1<PurchasesError, Unit> function1Component4 = purchaseRequestRemove.component4();
                PurchaseResponse.RequestStatus requestStatus = response.getRequestStatus();
                int i = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
                PurchasesError purchasesError = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_UNKNOWN) : new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_NOT_SUPPORTED) : new PurchasesError(PurchasesErrorCode.ProductAlreadyPurchasedError, AmazonStrings.ERROR_PURCHASE_ALREADY_OWNED) : new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, AmazonStrings.ERROR_PURCHASE_INVALID_SKU) : new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, AmazonStrings.ERROR_PURCHASE_FAILED) : null;
                DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
                if (diagnosticsTracker != null) {
                    diagnosticsTracker.m10337trackAmazonPurchaseAttempt9VgGkz4(storeProduct.getId(), response.getRequestStatus().name(), (purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(Duration.INSTANCE, startTime, this.dateProvider.getNow()));
                }
                if (purchasesError != null) {
                    function1Component4.invoke(purchasesError);
                    return;
                }
                Receipt receipt = response.getReceipt();
                Intrinsics.checkNotNullExpressionValue(receipt, "response.receipt");
                UserData userData = response.getUserData();
                Intrinsics.checkNotNullExpressionValue(userData, "response.userData");
                function2Component3.invoke(receipt, userData);
            }
        } catch (Exception e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseResponse", e);
            throw e;
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, final StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.PURCHASE;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.amazon.handler.PurchaseHandler$purchase$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(PurchaseStrings.PURCHASING_PRODUCT, Arrays.copyOf(new Object[]{storeProduct.getId()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        startProxyActivity(mainHandler, activity, storeProduct, onSuccess, onError);
    }
}
