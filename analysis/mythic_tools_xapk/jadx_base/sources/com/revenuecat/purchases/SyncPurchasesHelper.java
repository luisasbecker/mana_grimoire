package com.revenuecat.purchases;

import com.revenuecat.purchases.SyncPurchasesHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;

/* JADX INFO: compiled from: SyncPurchasesHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00100\u0017H\u0002J>\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00100\u0017J\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/SyncPurchasesHelper;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "customerInfoHelper", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/PostReceiptHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/DateProvider;)V", "retrieveCustomerInfo", "", "appUserID", "", "appInBackground", "", "isRestore", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "syncPurchases", "trackSyncPurchasesResultIfNeeded", "error", "startTime", "Ljava/util/Date;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SyncPurchasesHelper {
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2, reason: invalid class name */
    /* JADX INFO: compiled from: SyncPurchasesHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "allPurchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<List<? extends StoreTransaction>, Unit> {
        final /* synthetic */ boolean $appInBackground;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ Function1<PurchasesError, Unit> $handleError;
        final /* synthetic */ Function1<CustomerInfo, Unit> $handleSuccess;
        final /* synthetic */ boolean $isRestore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
            super(1);
            this.$appUserID = str;
            this.$appInBackground = z;
            this.$isRestore = z2;
            this.$handleSuccess = function1;
            this.$handleError = function12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
            if (Intrinsics.areEqual(storeTransaction, storeTransaction2)) {
                if (list.isEmpty()) {
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
                    }
                    syncPurchasesHelper.retrieveCustomerInfo(str, z, z2, function1, function12);
                    return;
                }
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                String str2 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler2.e("[Purchases] - ERROR", str2, null);
                function12.invoke(CollectionsKt.first((List) list));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreTransaction> list) {
            invoke2((List<StoreTransaction>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<StoreTransaction> allPurchases) {
            Intrinsics.checkNotNullParameter(allPurchases, "allPurchases");
            if (allPurchases.isEmpty()) {
                SyncPurchasesHelper.this.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$handleSuccess, this.$handleError);
                return;
            }
            final StoreTransaction storeTransaction = (StoreTransaction) CollectionsKt.last((List) allPurchases);
            final ArrayList arrayList = new ArrayList();
            final SyncPurchasesHelper syncPurchasesHelper = SyncPurchasesHelper.this;
            final boolean z = this.$isRestore;
            final String str = this.$appUserID;
            final boolean z2 = this.$appInBackground;
            final Function1<CustomerInfo, Unit> function1 = this.$handleSuccess;
            final Function1<PurchasesError, Unit> function12 = this.$handleError;
            for (final StoreTransaction storeTransaction2 : allPurchases) {
                ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction2.getProductIds(), Long.valueOf(storeTransaction2.getPurchaseTime()), null, null, null, null, null, null, null, null, false, storeTransaction2.getStoreUserID(), storeTransaction2.getMarketplace(), 2044, null);
                PostReceiptHelper postReceiptHelper = syncPurchasesHelper.postReceiptHelper;
                String purchaseToken = storeTransaction2.getPurchaseToken();
                PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                final ArrayList arrayList2 = arrayList;
                arrayList = arrayList2;
                Function1<CustomerInfo, Unit> function13 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$1
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
                        LogHandler currentLogHandler;
                        String str2;
                        String strInvoke;
                        Intrinsics.checkNotNullParameter(it, "it");
                        final LogIntent logIntent = LogIntent.PURCHASE;
                        final StoreTransaction storeTransaction3 = storeTransaction2;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$1$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                String str3 = String.format(PurchaseStrings.PURCHASE_SYNCED, Arrays.copyOf(new Object[]{storeTransaction3}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                return sbAppend.append(str3).toString();
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    str2 = "[Purchases] - " + logLevel.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                                    str2 = "[Purchases] - " + logLevel4.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                                    str2 = "[Purchases] - " + logLevel6.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    str2 = "[Purchases] - " + logLevel7.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                        SyncPurchasesHelper.AnonymousClass2.invoke$handleLastPurchase(arrayList2, syncPurchasesHelper, str, z2, z, function1, function12, storeTransaction2, storeTransaction);
                    }
                };
                final StoreTransaction storeTransaction3 = storeTransaction;
                Function1<PurchasesError, Unit> function14 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$2
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
                    public final void invoke2(final PurchasesError error) {
                        LogHandler currentLogHandler;
                        String str2;
                        String strInvoke;
                        Intrinsics.checkNotNullParameter(error, "error");
                        final LogIntent logIntent = LogIntent.RC_ERROR;
                        final StoreTransaction storeTransaction4 = storeTransaction2;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2$1$2$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                String str3 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR_DETAILS, Arrays.copyOf(new Object[]{storeTransaction4, error}, 2));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                return sbAppend.append(str3).toString();
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    str2 = "[Purchases] - " + logLevel.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                                    str2 = "[Purchases] - " + logLevel4.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                                    str2 = "[Purchases] - " + logLevel6.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    str2 = "[Purchases] - " + logLevel7.name();
                                    strInvoke = function0.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                        arrayList.add(error);
                        SyncPurchasesHelper.AnonymousClass2.invoke$handleLastPurchase(arrayList, syncPurchasesHelper, str, z2, z, function1, function12, storeTransaction2, storeTransaction3);
                    }
                };
                Function1<CustomerInfo, Unit> function15 = function1;
                storeTransaction = storeTransaction3;
                Function1<PurchasesError, Unit> function16 = function12;
                boolean z3 = z;
                String str2 = str;
                postReceiptHelper.postTokenWithoutConsuming(purchaseToken, receiptInfo, z3, str2, postReceiptInitiationSource, function13, function14, storeTransaction2.getIsAutoRenewing());
                z2 = z2;
                z = z3;
                str = str2;
                function1 = function15;
                function12 = function16;
            }
        }
    }

    public SyncPurchasesHelper(BillingAbstract billing, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(customerInfoHelper, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.billing = billing;
        this.identityManager = identityManager;
        this.customerInfoHelper = customerInfoHelper;
        this.postReceiptHelper = postReceiptHelper;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ SyncPurchasesHelper(BillingAbstract billingAbstract, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(billingAbstract, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker, (i & 32) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retrieveCustomerInfo(String appUserID, boolean appInBackground, boolean isRestore, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, appUserID, CacheFetchPolicy.CACHED_OR_FETCHED, appInBackground, isRestore, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.retrieveCustomerInfo.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackSyncPurchasesResultIfNeeded(PurchasesError error, Date startTime) {
        PurchasesErrorCode code;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m10349trackSyncPurchasesResultSxA4cEA((error == null || (code = error.getCode()) == null) ? null : Integer.valueOf(code.getCode()), error != null ? error.getMessage() : null, DurationExtensionsKt.between(Duration.INSTANCE, startTime, this.dateProvider.getNow()));
        }
    }

    public final void syncPurchases(boolean isRestore, boolean appInBackground, final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Syncing purchases";
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
        final Date now = this.dateProvider.getNow();
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackSyncPurchasesStarted();
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Function1<CustomerInfo, Unit> function1 = new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$handleSuccess$1
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
                this.this$0.trackSyncPurchasesResultIfNeeded(null, now);
                onSuccess.invoke(it);
            }
        };
        final Function1<PurchasesError, Unit> function12 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$handleError$1
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
                this.this$0.trackSyncPurchasesResultIfNeeded(it, now);
                onError.invoke(it);
            }
        };
        this.billing.queryAllPurchases(currentAppUserID, new AnonymousClass2(currentAppUserID, appInBackground, isRestore, function1, function12), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.syncPurchases.3
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
            public final void invoke2(final PurchasesError it) {
                LogHandler currentLogHandler8;
                String str2;
                String strInvoke2;
                Intrinsics.checkNotNullParameter(it, "it");
                final LogIntent logIntent2 = LogIntent.RC_ERROR;
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                        String str3 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{it}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        return sbAppend.append(str3).toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            str2 = "[Purchases] - " + logLevel11.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler8.d(str2, strInvoke2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel12 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel13 = LogLevel.INFO;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler10.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel14 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            str2 = "[Purchases] - " + logLevel14.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler8.d(str2, strInvoke2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel15 = LogLevel.INFO;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler11.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            str2 = "[Purchases] - " + logLevel16.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler8.d(str2, strInvoke2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            str2 = "[Purchases] - " + logLevel17.name();
                            strInvoke2 = function02.invoke();
                            currentLogHandler8.d(str2, strInvoke2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler12.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel19 = LogLevel.WARN;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            currentLogHandler13.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler14.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                        break;
                }
                function12.invoke(it);
            }
        });
    }
}
