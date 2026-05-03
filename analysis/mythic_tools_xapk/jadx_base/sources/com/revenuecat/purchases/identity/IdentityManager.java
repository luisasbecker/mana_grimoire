package com.revenuecat.purchases.identity;

import android.content.SharedPreferences;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IdentityManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 52\u00020\u0001:\u00015BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0006\u0010 \u001a\u00020\u0011J\u0016\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180#H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J<\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00142\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180)2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00180,J\u001c\u0010.\u001a\u00020\u00182\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00180,J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0014H\u0002J\u0012\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010*H\u0002J\u000e\u00104\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/revenuecat/purchases/identity/IdentityManager;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "offeringsCache", "Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "offlineEntitlementsManager", "Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "uiPreviewMode", "", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/offerings/OfferingsCache;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/offlineentitlements/OfflineEntitlementsManager;Lcom/revenuecat/purchases/common/Dispatcher;Z)V", "currentAppUserID", "", "getCurrentAppUserID", "()Ljava/lang/String;", "aliasCurrentUserIdTo", "", "oldAppUserID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configure", "appUserID", "copySubscriberAttributesToNewUserIfOldIsAnonymous", "oldAppUserId", "newAppUserId", "currentUserIsAnonymous", "enqueue", "command", "Lkotlin/Function0;", "generateRandomID", "invalidateETagCacheIfNeeded", "logIn", "newAppUserID", "onSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "logOut", "completion", "resetAndSaveUserID", "newUserID", "shouldInvalidateETagCache", "customerInfo", "switchUser", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IdentityManager {
    public static final String UI_PREVIEW_MODE_APP_USER_ID = "$RC_PREVIEW_MODE_USER";
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final OfferingsCache offeringsCache;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final SubscriberAttributesCache subscriberAttributesCache;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final boolean uiPreviewMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex anonymousIdRegex = new Regex("^\\$RCAnonymousID:([a-f0-9]{32})$");

    /* JADX INFO: compiled from: IdentityManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/identity/IdentityManager$Companion;", "", "()V", "UI_PREVIEW_MODE_APP_USER_ID", "", "anonymousIdRegex", "Lkotlin/text/Regex;", "isUserIDAnonymous", "", "appUserID", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUserIDAnonymous(String appUserID) {
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return IdentityManager.anonymousIdRegex.matches(appUserID);
        }
    }

    public IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesManager subscriberAttributesManager, OfferingsCache offeringsCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, Dispatcher dispatcher, boolean z) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "subscriberAttributesCache");
        Intrinsics.checkNotNullParameter(subscriberAttributesManager, "subscriberAttributesManager");
        Intrinsics.checkNotNullParameter(offeringsCache, "offeringsCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.deviceCache = deviceCache;
        this.subscriberAttributesCache = subscriberAttributesCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offeringsCache = offeringsCache;
        this.backend = backend;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.dispatcher = dispatcher;
        this.uiPreviewMode = z;
    }

    public /* synthetic */ IdentityManager(DeviceCache deviceCache, SubscriberAttributesCache subscriberAttributesCache, SubscriberAttributesManager subscriberAttributesManager, OfferingsCache offeringsCache, Backend backend, OfflineEntitlementsManager offlineEntitlementsManager, Dispatcher dispatcher, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend, offlineEntitlementsManager, dispatcher, (i & 128) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copySubscriberAttributesToNewUserIfOldIsAnonymous(String oldAppUserId, String newAppUserId) {
        if (INSTANCE.isUserIDAnonymous(oldAppUserId)) {
            this.subscriberAttributesManager.copyUnsyncedSubscriberAttributes(oldAppUserId, newAppUserId);
        }
    }

    private final synchronized void enqueue(final Function0<Unit> command) {
        this.dispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.identity.IdentityManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, Delay.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateRandomID() {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        StringBuilder sb = new StringBuilder("$RCAnonymousID:");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, "-", "", false, 4, (Object) null);
        final LogIntent logIntent = LogIntent.USER;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$generateRandomID$lambda$12$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Setting new anonymous App User ID - %s";
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
        return sb.append(strReplace$default).toString();
    }

    private final void invalidateETagCacheIfNeeded(String appUserID) {
        if (!Intrinsics.areEqual(this.backend.getVerificationMode(), SignatureVerificationMode.Disabled.INSTANCE) && shouldInvalidateETagCache(this.deviceCache.getCachedCustomerInfo$purchases_defaultsBc8Release(appUserID))) {
            LogLevel logLevel = LogLevel.INFO;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.i("[Purchases] - " + logLevel.name(), IdentityStrings.INVALIDATING_CACHED_ETAG_CACHE);
            }
            this.backend.clearCaches();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void resetAndSaveUserID(String newUserID) {
        this.deviceCache.clearCachesForAppUserID$purchases_defaultsBc8Release(getCurrentAppUserID());
        this.offeringsCache.clearCache();
        this.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(getCurrentAppUserID());
        this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
        this.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(newUserID);
        this.backend.clearCaches();
    }

    private final boolean shouldInvalidateETagCache(CustomerInfo customerInfo) {
        return (customerInfo == null || customerInfo.getEntitlements().getVerification() != VerificationResult.NOT_REQUESTED || Intrinsics.areEqual(this.backend.getVerificationMode(), SignatureVerificationMode.Disabled.INSTANCE)) ? false : true;
    }

    public final Object aliasCurrentUserIdTo(final String str, Continuation<? super Unit> continuation) throws Throwable {
        final String currentAppUserID = getCurrentAppUserID();
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        this.backend.aliasUsers(str, currentAppUserID, new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$1
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
                LogHandler currentLogHandler;
                String str2;
                String strInvoke;
                IdentityManager identityManager = this.this$0;
                final String str3 = currentAppUserID;
                final String str4 = str;
                synchronized (identityManager) {
                    final LogIntent logIntent = LogIntent.USER;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$1$invoke$lambda$1$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                            String str5 = String.format(IdentityStrings.ALIAS_OLD_USER_ID_TO_CURRENT_SUCCESSFUL, Arrays.copyOf(new Object[]{str4, str3}, 2));
                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                            return sbAppend.append(str5).toString();
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
                    identityManager.offeringsCache.clearCache();
                    identityManager.deviceCache.clearCustomerInfoCache$purchases_defaultsBc8Release(str3);
                    identityManager.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                    Unit unit = Unit.INSTANCE;
                }
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(Unit.INSTANCE));
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager$aliasCurrentUserIdTo$2$2
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
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(new PurchasesException(error))));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public final synchronized void configure(String appUserID) {
        final String cachedAppUserID$purchases_defaultsBc8Release;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (this.uiPreviewMode) {
            final LogIntent logIntent = LogIntent.USER;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Configuring with UI preview mode user ID";
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
            cachedAppUserID$purchases_defaultsBc8Release = UI_PREVIEW_MODE_APP_USER_ID;
        } else {
            String str2 = appUserID;
            if (str2 == null || StringsKt.isBlank(str2)) {
                if (appUserID != null && StringsKt.isBlank(appUserID)) {
                    final LogIntent logIntent2 = LogIntent.WARNING;
                    Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Identifying with empty App User ID will be treated as anonymous.";
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel11 = LogLevel.DEBUG;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.d("[Purchases] - " + logLevel11.name(), function02.invoke());
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
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler11.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel15 = LogLevel.INFO;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                currentLogHandler12.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                currentLogHandler13.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                            }
                            break;
                        case 9:
                            LogLevel logLevel17 = LogLevel.DEBUG;
                            LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler14.d("[Purchases] - " + logLevel17.name(), function02.invoke());
                            }
                            break;
                        case 10:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel19 = LogLevel.WARN;
                            LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel20 = LogLevel.WARN;
                            LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                currentLogHandler17.w("[Purchases] - " + logLevel20.name(), function02.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                            break;
                    }
                }
                cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
                if (cachedAppUserID$purchases_defaultsBc8Release == null && (cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getLegacyCachedAppUserID$purchases_defaultsBc8Release()) == null) {
                    cachedAppUserID$purchases_defaultsBc8Release = generateRandomID();
                }
            } else {
                cachedAppUserID$purchases_defaultsBc8Release = appUserID;
            }
        }
        final LogIntent logIntent3 = LogIntent.USER;
        Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$configure$$inlined$log$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str3 = String.format(IdentityStrings.IDENTIFYING_APP_USER_ID, Arrays.copyOf(new Object[]{cachedAppUserID$purchases_defaultsBc8Release}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return sbAppend.append(str3).toString();
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
        SharedPreferences.Editor editorStartEditing$purchases_defaultsBc8Release = this.deviceCache.startEditing$purchases_defaultsBc8Release();
        this.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release, editorStartEditing$purchases_defaultsBc8Release);
        this.subscriberAttributesCache.cleanUpSubscriberAttributeCache(cachedAppUserID$purchases_defaultsBc8Release, editorStartEditing$purchases_defaultsBc8Release);
        invalidateETagCacheIfNeeded(cachedAppUserID$purchases_defaultsBc8Release);
        editorStartEditing$purchases_defaultsBc8Release.apply();
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.configure.2
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
                IdentityManager.this.deviceCache.cleanupOldAttributionData$purchases_defaultsBc8Release();
            }
        });
    }

    public final synchronized boolean currentUserIsAnonymous() {
        Companion companion;
        String cachedAppUserID$purchases_defaultsBc8Release;
        companion = INSTANCE;
        cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release == null) {
            cachedAppUserID$purchases_defaultsBc8Release = "";
        }
        return companion.isUserIDAnonymous(cachedAppUserID$purchases_defaultsBc8Release) || Intrinsics.areEqual(this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release(), this.deviceCache.getLegacyCachedAppUserID$purchases_defaultsBc8Release());
    }

    public final String getCurrentAppUserID() {
        String cachedAppUserID$purchases_defaultsBc8Release = this.deviceCache.getCachedAppUserID$purchases_defaultsBc8Release();
        return cachedAppUserID$purchases_defaultsBc8Release == null ? "" : cachedAppUserID$purchases_defaultsBc8Release;
    }

    public final void logIn(final String newAppUserID, final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID) || Intrinsics.areEqual(newAppUserID, UI_PREVIEW_MODE_APP_USER_ID)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE);
            LogUtilsKt.errorLog(purchasesError);
            onError.invoke(purchasesError);
            return;
        }
        if (StringsKt.isBlank(newAppUserID)) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.InvalidAppUserIdError, IdentityStrings.LOG_IN_ERROR_MISSING_APP_USER_ID);
            LogUtilsKt.errorLog(purchasesError2);
            onError.invoke(purchasesError2);
            return;
        }
        final LogIntent logIntent = LogIntent.USER;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(IdentityStrings.LOGGING_IN, Arrays.copyOf(new Object[]{this.getCurrentAppUserID(), newAppUserID}, 2));
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
        final String currentAppUserID = getCurrentAppUserID();
        this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(newAppUserID, new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logIn.4
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
                Backend backend = IdentityManager.this.backend;
                String str2 = currentAppUserID;
                String str3 = newAppUserID;
                final IdentityManager identityManager = IdentityManager.this;
                final Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                final String str4 = currentAppUserID;
                final String str5 = newAppUserID;
                backend.logIn(str2, str3, new Function2<CustomerInfo, Boolean, Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logIn.4.1
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

                    public final void invoke(CustomerInfo customerInfo, final boolean z) {
                        LogHandler currentLogHandler8;
                        String str6;
                        String strInvoke2;
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        IdentityManager identityManager2 = identityManager;
                        String str7 = str4;
                        final String str8 = str5;
                        synchronized (identityManager2) {
                            final LogIntent logIntent2 = LogIntent.USER;
                            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logIn$4$1$invoke$lambda$1$$inlined$log$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                    String str9 = String.format(IdentityStrings.LOG_IN_SUCCESSFUL, Arrays.copyOf(new Object[]{str8, Boolean.valueOf(z)}, 2));
                                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                    return sbAppend.append(str9).toString();
                                }
                            };
                            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                case 1:
                                    LogLevel logLevel11 = LogLevel.DEBUG;
                                    currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                        str6 = "[Purchases] - " + logLevel11.name();
                                        strInvoke2 = function02.invoke();
                                        currentLogHandler8.d(str6, strInvoke2);
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
                                        str6 = "[Purchases] - " + logLevel14.name();
                                        strInvoke2 = function02.invoke();
                                        currentLogHandler8.d(str6, strInvoke2);
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
                                        str6 = "[Purchases] - " + logLevel16.name();
                                        strInvoke2 = function02.invoke();
                                        currentLogHandler8.d(str6, strInvoke2);
                                    }
                                    break;
                                case 9:
                                    LogLevel logLevel17 = LogLevel.DEBUG;
                                    currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                        str6 = "[Purchases] - " + logLevel17.name();
                                        strInvoke2 = function02.invoke();
                                        currentLogHandler8.d(str6, strInvoke2);
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
                            identityManager2.deviceCache.clearCachesForAppUserID$purchases_defaultsBc8Release(str7);
                            identityManager2.offeringsCache.clearCache();
                            identityManager2.subscriberAttributesCache.clearSubscriberAttributesIfSyncedForSubscriber(str7);
                            identityManager2.deviceCache.cacheAppUserID$purchases_defaultsBc8Release(str8);
                            identityManager2.deviceCache.cacheCustomerInfo$purchases_defaultsBc8Release(str8, customerInfo);
                            identityManager2.copySubscriberAttributesToNewUserIfOldIsAnonymous(str7, str8);
                            identityManager2.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                            Unit unit = Unit.INSTANCE;
                        }
                        function2.invoke(customerInfo, Boolean.valueOf(z));
                    }
                }, onError);
            }
        });
    }

    public final synchronized void logOut(final Function1<? super PurchasesError, Unit> completion) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID)) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE);
            LogUtilsKt.errorLog(purchasesError);
            completion.invoke(purchasesError);
            return;
        }
        if (!currentUserIsAnonymous()) {
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getCurrentAppUserID(), new Function0<Unit>() { // from class: com.revenuecat.purchases.identity.IdentityManager.logOut.3
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
                    LogHandler currentLogHandler2;
                    String str2;
                    String strInvoke2;
                    IdentityManager identityManager = IdentityManager.this;
                    identityManager.resetAndSaveUserID(identityManager.generateRandomID());
                    final LogIntent logIntent = LogIntent.USER;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logOut$3$invoke$$inlined$log$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Logged out successfully";
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                        case 1:
                            LogLevel logLevel = LogLevel.DEBUG;
                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                str2 = "[Purchases] - " + logLevel.name();
                                strInvoke2 = function0.invoke();
                                currentLogHandler2.d(str2, strInvoke2);
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
                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                str2 = "[Purchases] - " + logLevel4.name();
                                strInvoke2 = function0.invoke();
                                currentLogHandler2.d(str2, strInvoke2);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                str2 = "[Purchases] - " + logLevel6.name();
                                strInvoke2 = function0.invoke();
                                currentLogHandler2.d(str2, strInvoke2);
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                str2 = "[Purchases] - " + logLevel7.name();
                                strInvoke2 = function0.invoke();
                                currentLogHandler2.d(str2, strInvoke2);
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler6.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler7.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                        case 13:
                            LogLevel logLevel10 = LogLevel.WARN;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                currentLogHandler8.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                            break;
                    }
                    completion.invoke(null);
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.RC_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.identity.IdentityManager$logOut$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Called logOut but the current user is anonymous";
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
        completion.invoke(new PurchasesError(PurchasesErrorCode.LogOutWithAnonymousUserError, null, 2, null));
    }

    public final void switchUser(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        if (Intrinsics.areEqual(getCurrentAppUserID(), UI_PREVIEW_MODE_APP_USER_ID) || Intrinsics.areEqual(newAppUserID, UI_PREVIEW_MODE_APP_USER_ID)) {
            LogUtilsKt.errorLog(new PurchasesError(PurchasesErrorCode.UnsupportedError, IdentityStrings.OPERATION_NOT_SUPPORTED_IN_PREVIEW_MODE));
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(IdentityStrings.SWITCHING_USER, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        resetAndSaveUserID(newAppUserID);
    }
}
