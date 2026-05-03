package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase;
import com.revenuecat.purchases.strings.PurchaseStrings;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AcknowledgePurchaseUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B·\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\r\u0012#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\n0\u0006\u0012H\u0010\u0011\u001aD\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00188TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCaseParams;", "onReceive", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", Constants.GP_IAP_PURCHASE_TOKEN, "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "backoffForNetworkErrors", "", "getBackoffForNetworkErrors", "()Z", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getWithConnectedClient", "executeAsync", "onOk", "received", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AcknowledgePurchaseUseCase extends BillingClientUseCase<String> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<String, Unit> onReceive;
    private final AcknowledgePurchaseUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: compiled from: AcknowledgePurchaseUseCase.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostReceiptInitiationSource.values().length];
            try {
                iArr[PostReceiptInitiationSource.RESTORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostReceiptInitiationSource.PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: AcknowledgePurchaseUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<BillingClient, Unit> {
        AnonymousClass1() {
            super(1);
        }

        static final void invoke$lambda$0(final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase, BillingResult billingResult) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            BillingClientUseCase.processResult$default(acknowledgePurchaseUseCase, billingResult, acknowledgePurchaseUseCase.useCaseParams.getPurchaseToken(), null, new Function1<BillingResult, Unit>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BillingResult billingResult2) {
                    invoke2(billingResult2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BillingResult errorBillingResult) {
                    final String str;
                    LogHandler currentLogHandler;
                    String str2;
                    String strInvoke;
                    Intrinsics.checkNotNullParameter(errorBillingResult, "errorBillingResult");
                    if (errorBillingResult.getResponseCode() != 8 || acknowledgePurchaseUseCase.useCaseParams.getInitiationSource() != PostReceiptInitiationSource.RESTORE) {
                        str = acknowledgePurchaseUseCase.getErrorMessage() + " - " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(errorBillingResult);
                        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
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
                    } else {
                        final LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
                        str = PurchaseStrings.ACKNOWLEDGING_PURCHASE_ERROR_RESTORE;
                        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                            case 1:
                                LogLevel logLevel11 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    str2 = "[Purchases] - " + logLevel11.name();
                                    strInvoke = function02.invoke();
                                    currentLogHandler.d(str2, strInvoke);
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel12 = LogLevel.WARN;
                                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                    currentLogHandler12.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel13 = LogLevel.INFO;
                                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                    currentLogHandler13.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel14 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                    str2 = "[Purchases] - " + logLevel14.name();
                                    strInvoke = function02.invoke();
                                    currentLogHandler.d(str2, strInvoke);
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel15 = LogLevel.INFO;
                                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                    currentLogHandler14.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel16 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                    str2 = "[Purchases] - " + logLevel16.name();
                                    strInvoke = function02.invoke();
                                    currentLogHandler.d(str2, strInvoke);
                                }
                                break;
                            case 9:
                                LogLevel logLevel17 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                    str2 = "[Purchases] - " + logLevel17.name();
                                    strInvoke = function02.invoke();
                                    currentLogHandler.d(str2, strInvoke);
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
                    acknowledgePurchaseUseCase.getOnError().invoke(ErrorsKt.billingResponseToPurchasesError(errorBillingResult.getResponseCode(), str));
                }
            }, 4, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
            invoke2(billingClient);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BillingClient invoke) {
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(AcknowledgePurchaseUseCase.this.useCaseParams.getPurchaseToken()).build();
            Intrinsics.checkNotNullExpressionValue(acknowledgePurchaseParamsBuild, "newBuilder()\n           …\n                .build()");
            final AcknowledgePurchaseUseCase acknowledgePurchaseUseCase = AcknowledgePurchaseUseCase.this;
            invoke.acknowledgePurchase(acknowledgePurchaseParamsBuild, new AcknowledgePurchaseResponseListener() { // from class: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                    AcknowledgePurchaseUseCase.AnonymousClass1.invoke$lambda$0(acknowledgePurchaseUseCase, billingResult);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AcknowledgePurchaseUseCase(AcknowledgePurchaseUseCaseParams useCaseParams, Function1<? super String, Unit> onReceive, Function1<? super PurchasesError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
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

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    protected boolean getBackoffForNetworkErrors() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error acknowledging purchase";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<String, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(String received) {
        Intrinsics.checkNotNullParameter(received, "received");
        this.onReceive.invoke(received);
    }
}
