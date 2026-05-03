package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.StoreTransactionConversionsKt;
import com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;

/* JADX INFO: compiled from: QueryPurchaseHistoryUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B®\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\u000b\u0012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\b0\u0007\u0012H\u0010\u000f\u001aD\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J \u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchaseHistoryUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/QueryPurchaseHistoryUseCaseParams;", "onReceive", "Lkotlin/Function1;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/QueryPurchaseHistoryUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getWithConnectedClient", "executeAsync", "onOk", "received", "trackGoogleQueryPurchaseHistoryRequestIfNeeded", "productType", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "requestStartTime", "Ljava/util/Date;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QueryPurchaseHistoryUseCase extends BillingClientUseCase<List<? extends StoreTransaction>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<List<StoreTransaction>, Unit> onReceive;
    private final QueryPurchaseHistoryUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: QueryPurchaseHistoryUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<BillingClient, Unit> {
        AnonymousClass1() {
            super(1);
        }

        static final void invoke$lambda$7$lambda$6(AtomicBoolean atomicBoolean, QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase, Date date, final BillingResult billingResult, List activePurchases) {
            Unit unit;
            LogHandler currentLogHandler;
            String str;
            String strInvoke;
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(activePurchases, "activePurchases");
            if (atomicBoolean.getAndSet(true)) {
                final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$7$lambda$6$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                        String str2 = String.format(RestoreStrings.EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        return sbAppend.append(str2).toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel.name(), function0.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel4.name(), function0.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler6.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler8.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler11.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                        break;
                }
                return;
            }
            queryPurchaseHistoryUseCase.trackGoogleQueryPurchaseHistoryRequestIfNeeded(queryPurchaseHistoryUseCase.useCaseParams.getProductType(), billingResult, date);
            List<Purchase> list = !activePurchases.isEmpty() ? activePurchases : null;
            if (list != null) {
                for (final Purchase purchase : list) {
                    final LogIntent logIntent2 = LogIntent.RC_PURCHASE_SUCCESS;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$7$lambda$6$lambda$3$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            Purchase it = purchase;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            String str2 = String.format(RestoreStrings.PURCHASE_HISTORY_RETRIEVED, Arrays.copyOf(new Object[]{PurchaseExtensionsKt.toHumanReadableDescription(purchase)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            return sbAppend.append(str2).toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                str = "[Purchases] - " + logLevel11.name();
                                strInvoke = function02.invoke();
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            continue;
                        case 3:
                            LogLevel logLevel12 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 4:
                            LogLevel logLevel13 = LogLevel.INFO;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                currentLogHandler13.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 5:
                            LogLevel logLevel14 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                str = "[Purchases] - " + logLevel14.name();
                                strInvoke = function02.invoke();
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            continue;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler14.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str = "[Purchases] - " + logLevel16.name();
                                strInvoke = function02.invoke();
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                str = "[Purchases] - " + logLevel17.name();
                                strInvoke = function02.invoke();
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            continue;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            continue;
                    }
                    currentLogHandler.d(str, strInvoke);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                final LogIntent logIntent3 = LogIntent.DEBUG;
                Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1$invoke$lambda$7$lambda$6$$inlined$log$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Purchase history is empty.";
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                    case 1:
                        LogLevel logLevel21 = LogLevel.DEBUG;
                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            currentLogHandler18.d("[Purchases] - " + logLevel21.name(), function03.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel22 = LogLevel.WARN;
                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                            currentLogHandler19.w("[Purchases] - " + logLevel22.name(), function03.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel23 = LogLevel.INFO;
                        LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                            currentLogHandler20.i("[Purchases] - " + logLevel23.name(), function03.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel24 = LogLevel.DEBUG;
                        LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                            currentLogHandler21.d("[Purchases] - " + logLevel24.name(), function03.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel25 = LogLevel.INFO;
                        LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                            currentLogHandler22.i("[Purchases] - " + logLevel25.name(), function03.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel26 = LogLevel.DEBUG;
                        LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                            currentLogHandler23.d("[Purchases] - " + logLevel26.name(), function03.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel27 = LogLevel.DEBUG;
                        LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                            currentLogHandler24.d("[Purchases] - " + logLevel27.name(), function03.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel28 = LogLevel.WARN;
                        LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                            currentLogHandler25.w("[Purchases] - " + logLevel28.name(), function03.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel29 = LogLevel.WARN;
                        LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                            currentLogHandler26.w("[Purchases] - " + logLevel29.name(), function03.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel30 = LogLevel.WARN;
                        LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                            currentLogHandler27.w("[Purchases] - " + logLevel30.name(), function03.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function03.invoke(), null);
                        break;
                }
            }
            QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase2 = queryPurchaseHistoryUseCase;
            List<Purchase> list2 = activePurchases;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Purchase it : list2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(StoreTransactionConversionsKt.toStoreTransaction$default(it, ProductTypeConversionsKt.toRevenueCatProductType(queryPurchaseHistoryUseCase.useCaseParams.getProductType()), null, null, null, null, 30, null));
            }
            BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase2, billingResult, arrayList, null, null, 12, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
            invoke2(billingClient);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BillingClient invoke) {
            Unit unit;
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final Date now = QueryPurchaseHistoryUseCase.this.useCaseParams.getDateProvider().getNow();
            QueryPurchasesParams queryPurchasesParamsBuildQueryPurchasesParams = BillingClientParamBuildersKt.buildQueryPurchasesParams(QueryPurchaseHistoryUseCase.this.useCaseParams.getProductType());
            if (queryPurchasesParamsBuildQueryPurchasesParams != null) {
                final QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase = QueryPurchaseHistoryUseCase.this;
                invoke.queryPurchasesAsync(queryPurchasesParamsBuildQueryPurchasesParams, new PurchasesResponseListener() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchaseHistoryUseCase$executeAsync$1$$ExternalSyntheticLambda0
                    @Override // com.android.billingclient.api.PurchasesResponseListener
                    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                        QueryPurchaseHistoryUseCase.AnonymousClass1.invoke$lambda$7$lambda$6(atomicBoolean, queryPurchaseHistoryUseCase, now, billingResult, list);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase2 = QueryPurchaseHistoryUseCase.this;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                String str = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchaseHistory"}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                currentLogHandler.e("[Purchases] - ERROR", str, null);
                BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(5).build();
                Intrinsics.checkNotNullExpressionValue(billingResultBuild, "newBuilder()\n           …                 .build()");
                BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase2, billingResultBuild, null, null, null, 12, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryPurchaseHistoryUseCase(QueryPurchaseHistoryUseCaseParams useCaseParams, Function1<? super List<StoreTransaction>, Unit> onReceive, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGoogleQueryPurchaseHistoryRequestIfNeeded(String productType, BillingResult billingResult, Date requestStartTime) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m10344trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(productType, responseCode, debugMessage, DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.useCaseParams.getDateProvider().getNow()));
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error receiving purchase history";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<List<StoreTransaction>, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(List<? extends StoreTransaction> list) {
        onOk2((List<StoreTransaction>) list);
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(List<StoreTransaction> received) {
        Function1<List<StoreTransaction>, Unit> function1 = this.onReceive;
        if (received == null) {
            received = CollectionsKt.emptyList();
        }
        function1.invoke(received);
    }
}
