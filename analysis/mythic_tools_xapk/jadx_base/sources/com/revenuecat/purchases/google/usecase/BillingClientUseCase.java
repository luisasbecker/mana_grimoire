package com.revenuecat.purchases.google.usecase;

import androidx.exifinterface.media.ExifInterface;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResponse;
import com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.strings.BillingStrings;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: BillingClientUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t\u0012H\u0010\n\u001aD\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010¢\u0006\u0002\u0010\u0011J$\u0010\"\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010$\u001a\u00020#H\u0002J$\u0010%\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\bH&J\u0010\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0015\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00028\u0000H&¢\u0006\u0002\u0010+JG\u0010,\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010-\u001a\u00028\u00002\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00062\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\bH\u0002J\u0010\u00101\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\fJ'\u00103\u001a\u00020\b*\u0004\u0018\u0001042\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b6H\u0004R\u0014\u0010\u0012\u001a\u00020\u0013X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019RS\u0010\n\u001aD\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020 X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", ExifInterface.GPS_DIRECTION_TRUE, "", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/UseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "backoffForNetworkErrors", "", "getBackoffForNetworkErrors", "()Z", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "getExecuteRequestOnUIThread", "()Lkotlin/jvm/functions/Function2;", "maxRetries", "", "retryAttempt", "retryBackoff", "Lkotlin/time/Duration;", "J", "backoffOrErrorIfServiceUnavailable", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "backoffOrRetryNetworkError", "executeAsync", "forwardError", "getStackTrace", "onOk", "received", "(Ljava/lang/Object;)V", "processResult", "response", "onSuccess", "(Lcom/android/billingclient/api/BillingResult;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "retryWithBackoff", "run", "delayMilliseconds", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "receivingFunction", "Lkotlin/ExtensionFunctionType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BillingClientUseCase<T> {
    private final boolean backoffForNetworkErrors;
    private final Function2<Long, Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread;
    private final int maxRetries;
    private final Function1<PurchasesError, Unit> onError;
    private int retryAttempt;
    private long retryBackoff;
    private final UseCaseParams useCaseParams;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.BillingClientUseCase$processResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: BillingClientUseCase.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<T, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, BillingClientUseCase.class, "onOk", "onOk(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            ((BillingClientUseCase) this.receiver).onOk(t);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.BillingClientUseCase$processResult$2, reason: invalid class name */
    /* JADX INFO: compiled from: BillingClientUseCase.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<BillingResult, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, BillingClientUseCase.class, "forwardError", "forwardError(Lcom/android/billingclient/api/BillingResult;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BillingResult billingResult) {
            invoke2(billingResult);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BillingResult p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((BillingClientUseCase) this.receiver).forwardError(p0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BillingClientUseCase(UseCaseParams useCaseParams, Function1<? super PurchasesError, Unit> onError, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onError = onError;
        this.executeRequestOnUIThread = executeRequestOnUIThread;
        this.maxRetries = 3;
        this.retryBackoff = BillingClientUseCaseKt.RETRY_TIMER_START;
    }

    private final void backoffOrErrorIfServiceUnavailable(Function1<? super BillingResult, Unit> onError, BillingResult billingResult) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final LogIntent logIntent = LogIntent.GOOGLE_WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.BillingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(BillingStrings.BILLING_SERVICE_UNAVAILABLE, Arrays.copyOf(new Object[]{Boolean.valueOf(this.useCaseParams.getAppInBackground())}, 1));
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
        if (Duration.m12795compareToLRDsOJo(this.retryBackoff, this.useCaseParams.getAppInBackground() ? BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME() : BillingClientUseCaseKt.getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND()) < 0) {
            retryWithBackoff();
        } else {
            onError.invoke(billingResult);
        }
    }

    private final void backoffOrRetryNetworkError(Function1<? super BillingResult, Unit> onError, BillingResult billingResult) {
        int i;
        if (getBackoffForNetworkErrors() && Duration.m12795compareToLRDsOJo(this.retryBackoff, BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME()) < 0) {
            retryWithBackoff();
        } else if (getBackoffForNetworkErrors() || (i = this.retryAttempt) >= this.maxRetries) {
            onError.invoke(billingResult);
        } else {
            this.retryAttempt = i + 1;
            executeAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forwardError(BillingResult billingResult) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final String str2 = getErrorMessage() + " - " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(billingResult);
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.BillingClientUseCase$forwardError$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str2;
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
        Function1<PurchasesError, Unit> function1 = this.onError;
        PurchasesError purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.getResponseCode(), str2);
        LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
        function1.invoke(purchasesErrorBillingResponseToPurchasesError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringWriter.toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void processResult$default(BillingClientUseCase billingClientUseCase, BillingResult billingResult, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processResult");
        }
        if ((i & 4) != 0) {
            function1 = new AnonymousClass1(billingClientUseCase);
        }
        if ((i & 8) != 0) {
            function12 = new AnonymousClass2(billingClientUseCase);
        }
        billingClientUseCase.processResult(billingResult, obj, function1, function12);
    }

    private final void retryWithBackoff() {
        long j = this.retryBackoff;
        this.retryBackoff = DurationExtensionsKt.m10334minQTBD994(Duration.m12827timesUwyO8pc(j, 2), BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME());
        run(Duration.m12807getInWholeMillisecondsimpl(j));
    }

    public static /* synthetic */ void run$default(BillingClientUseCase billingClientUseCase, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        billingClientUseCase.run(j);
    }

    public abstract void executeAsync();

    protected boolean getBackoffForNetworkErrors() {
        return this.backoffForNetworkErrors;
    }

    public abstract String getErrorMessage();

    public final Function2<Long, Function1<? super PurchasesError, Unit>, Unit> getExecuteRequestOnUIThread() {
        return this.executeRequestOnUIThread;
    }

    public abstract void onOk(T received);

    public final void processResult(BillingResult billingResult, T response, Function1<? super T, Unit> onSuccess, Function1<? super BillingResult, Unit> onError) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BillingResponse billingResponseFromCode = BillingResponse.INSTANCE.fromCode(billingResult.getResponseCode());
        if (Intrinsics.areEqual(billingResponseFromCode, BillingResponse.OK.INSTANCE)) {
            this.retryBackoff = BillingClientUseCaseKt.RETRY_TIMER_START;
            onSuccess.invoke(response);
            return;
        }
        if (!Intrinsics.areEqual(billingResponseFromCode, BillingResponse.ServiceDisconnected.INSTANCE)) {
            if (Intrinsics.areEqual(billingResponseFromCode, BillingResponse.ServiceUnavailable.INSTANCE)) {
                backoffOrErrorIfServiceUnavailable(onError, billingResult);
                return;
            }
            if (Intrinsics.areEqual(billingResponseFromCode, BillingResponse.NetworkError.INSTANCE) ? true : Intrinsics.areEqual(billingResponseFromCode, BillingResponse.Error.INSTANCE)) {
                backoffOrRetryNetworkError(onError, billingResult);
                return;
            } else {
                onError.invoke(billingResult);
                return;
            }
        }
        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.BillingClientUseCase$processResult$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Billing Service disconnected";
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
        run$default(this, 0L, 1, null);
    }

    public final void run(long delayMilliseconds) {
        this.executeRequestOnUIThread.invoke(Long.valueOf(delayMilliseconds), new Function1<PurchasesError, Unit>(this) { // from class: com.revenuecat.purchases.google.usecase.BillingClientUseCase.run.1
            final /* synthetic */ BillingClientUseCase<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError purchasesError) {
                BillingClientUseCase<T> billingClientUseCase = this.this$0;
                if (purchasesError == null) {
                    billingClientUseCase.executeAsync();
                } else {
                    ((BillingClientUseCase) billingClientUseCase).onError.invoke(purchasesError);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void withConnectedClient(BillingClient billingClient, Function1<? super BillingClient, Unit> receivingFunction) {
        Unit unit;
        Intrinsics.checkNotNullParameter(receivingFunction, "receivingFunction");
        if (billingClient == null) {
            unit = null;
        } else {
            if (!billingClient.isReady()) {
                billingClient = null;
            }
            if (billingClient != null) {
                receivingFunction.invoke(billingClient);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            final LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.usecase.BillingClientUseCase$withConnectedClient$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str = String.format(BillingStrings.BILLING_CLIENT_DISCONNECTED, Arrays.copyOf(new Object[]{this.getStackTrace()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return sbAppend.append(str).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), function0.invoke());
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
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), function0.invoke());
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
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
        }
    }
}
