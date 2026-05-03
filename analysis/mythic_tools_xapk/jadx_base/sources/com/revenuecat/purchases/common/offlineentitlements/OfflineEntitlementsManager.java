package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineEntitlementsManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ6\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00190\u00182\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00190\u0018J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u0019J\u0016\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020!J \u0010&\u001a\u00020\u00192\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8B@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RH\u0010\u0013\u001a<\u0012\u0004\u0012\u00020\u0015\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u0002`\u001b0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineCustomerInfoCalculator", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "diagnosticsTracker", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "(Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;)V", "<set-?>", "Lcom/revenuecat/purchases/CustomerInfo;", "_offlineCustomerInfo", "offlineCustomerInfo", "getOfflineCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "offlineCustomerInfoCallbackCache", "", "", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCallback;", "calculateAndCacheOfflineCustomerInfo", "appUserId", "onSuccess", "onError", "isOfflineEntitlementsEnabled", "", "resetOfflineCustomerInfoCache", "shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest", "isServerError", "shouldCalculateOfflineCustomerInfoInPostReceipt", "updateProductEntitlementMappingCacheIfStale", "completion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfflineEntitlementsManager {
    private CustomerInfo _offlineCustomerInfo;
    private final AppConfig appConfig;
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final DiagnosticsTracker diagnosticsTracker;
    private final OfflineCustomerInfoCalculator offlineCustomerInfoCalculator;
    private final Map<String, List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>>> offlineCustomerInfoCallbackCache;

    public OfflineEntitlementsManager(Backend backend, OfflineCustomerInfoCalculator offlineCustomerInfoCalculator, DeviceCache deviceCache, AppConfig appConfig, DiagnosticsTracker diagnosticsTracker) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineCustomerInfoCalculator, "offlineCustomerInfoCalculator");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        this.backend = backend;
        this.offlineCustomerInfoCalculator = offlineCustomerInfoCalculator;
        this.deviceCache = deviceCache;
        this.appConfig = appConfig;
        this.diagnosticsTracker = diagnosticsTracker;
        this.offlineCustomerInfoCallbackCache = new LinkedHashMap();
    }

    private final boolean isOfflineEntitlementsEnabled() {
        return this.appConfig.getFinishTransactions() && this.appConfig.getEnableOfflineEntitlements() && !this.appConfig.getCustomEntitlementComputation() && this.appConfig.getStore() != Store.TEST_STORE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateProductEntitlementMappingCacheIfStale$default(OfflineEntitlementsManager offlineEntitlementsManager, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        offlineEntitlementsManager.updateProductEntitlementMappingCacheIfStale(function1);
    }

    public final void calculateAndCacheOfflineCustomerInfo(final String appUserId, Function1<? super CustomerInfo, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!this.appConfig.getEnableOfflineEntitlements()) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_NOT_ENABLED));
            return;
        }
        synchronized (this) {
            boolean zContainsKey = this.offlineCustomerInfoCallbackCache.containsKey(appUserId);
            List<Pair<Function1<CustomerInfo, Unit>, Function1<PurchasesError, Unit>>> listEmptyList = this.offlineCustomerInfoCallbackCache.get(appUserId);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            this.offlineCustomerInfoCallbackCache.put(appUserId, CollectionsKt.plus((Collection) listEmptyList, (Iterable) CollectionsKt.listOf(TuplesKt.to(onSuccess, onError))));
            if (!zContainsKey) {
                Unit unit = Unit.INSTANCE;
                this.offlineCustomerInfoCalculator.computeOfflineCustomerInfo(appUserId, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.calculateAndCacheOfflineCustomerInfo.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                        String str = appUserId;
                        synchronized (offlineEntitlementsManager) {
                            LogLevel logLevel = LogLevel.WARN;
                            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                currentLogHandler.w("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO);
                            }
                            DiagnosticsTracker diagnosticsTracker = offlineEntitlementsManager.diagnosticsTracker;
                            if (diagnosticsTracker != null) {
                                diagnosticsTracker.trackEnteredOfflineEntitlementsMode();
                            }
                            offlineEntitlementsManager._offlineCustomerInfo = customerInfo;
                            String cachedAppUserID$purchases_defaultsBc8Release = offlineEntitlementsManager.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
                            if (cachedAppUserID$purchases_defaultsBc8Release != null) {
                                offlineEntitlementsManager.deviceCache.clearCustomerInfoCache$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release);
                            }
                            List list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    ((Function1) ((Pair) it.next()).component1()).invoke(customerInfo);
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.calculateAndCacheOfflineCustomerInfo.3
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
                        OfflineEntitlementsManager offlineEntitlementsManager = OfflineEntitlementsManager.this;
                        String str = appUserId;
                        synchronized (offlineEntitlementsManager) {
                            List list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
                            if (list != null) {
                                Iterator it2 = list.iterator();
                                while (it2.hasNext()) {
                                    ((Function1) ((Pair) it2.next()).component2()).invoke(it);
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                });
                return;
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(OfflineEntitlementsStrings.ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO, Arrays.copyOf(new Object[]{appUserId}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.d(str, str2);
            }
        }
    }

    /* JADX INFO: renamed from: getOfflineCustomerInfo, reason: from getter */
    public final CustomerInfo get_offlineCustomerInfo() {
        return this._offlineCustomerInfo;
    }

    public final synchronized void resetOfflineCustomerInfoCache() {
        if (this._offlineCustomerInfo != null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.RESETTING_OFFLINE_CUSTOMER_INFO_CACHE);
            }
            this._offlineCustomerInfo = null;
        }
    }

    public final boolean shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(boolean isServerError, String appUserId) {
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        return isServerError && isOfflineEntitlementsEnabled() && this.deviceCache.getCachedCustomerInfo$purchases_defaultsBc8Release(appUserId) == null;
    }

    public final boolean shouldCalculateOfflineCustomerInfoInPostReceipt(boolean isServerError) {
        return isServerError && isOfflineEntitlementsEnabled();
    }

    public final void updateProductEntitlementMappingCacheIfStale(final Function1<? super PurchasesError, Unit> completion) {
        if (!isOfflineEntitlementsEnabled() || !this.deviceCache.isProductEntitlementMappingCacheStale$purchases_defaultsBc8Release()) {
            if (completion != null) {
                completion.invoke(null);
            }
        } else {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), OfflineEntitlementsStrings.UPDATING_PRODUCT_ENTITLEMENT_MAPPING);
            }
            this.backend.getProductEntitlementMapping(new Function1<ProductEntitlementMapping, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProductEntitlementMapping productEntitlementMapping) {
                    invoke2(productEntitlementMapping);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProductEntitlementMapping productEntitlementMapping) {
                    Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
                    OfflineEntitlementsManager.this.deviceCache.cacheProductEntitlementMapping$purchases_defaultsBc8Release(productEntitlementMapping);
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.d("[Purchases] - " + logLevel2.name(), OfflineEntitlementsStrings.SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS);
                    }
                    Function1<PurchasesError, Unit> function1 = completion;
                    if (function1 != null) {
                        function1.invoke(null);
                    }
                }
            }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale.3
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
                public final void invoke2(PurchasesError e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    String str = String.format(OfflineEntitlementsStrings.ERROR_UPDATING_PRODUCT_ENTITLEMENTS, Arrays.copyOf(new Object[]{e}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    currentLogHandler2.e("[Purchases] - ERROR", str, null);
                    Function1<PurchasesError, Unit> function1 = completion;
                    if (function1 != null) {
                        function1.invoke(e);
                    }
                }
            });
        }
    }
}
