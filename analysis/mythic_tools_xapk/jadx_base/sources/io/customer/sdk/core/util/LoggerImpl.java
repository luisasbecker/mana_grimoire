package io.customer.sdk.core.util;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.customer.sdk.core.environment.BuildEnvironment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LoggerImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0010\u0018\u0000 $2\u00020\u0001:\u0001$B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0016\u001a\u00020\u00152\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J,\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\tH\u0002J\u001a\u0010#\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/customer/sdk/core/util/LoggerImpl;", "Lio/customer/sdk/core/util/Logger;", "buildEnvironment", "Lio/customer/sdk/core/environment/BuildEnvironment;", "actualLogger", "Lio/customer/sdk/core/util/LogcatLogger;", "<init>", "(Lio/customer/sdk/core/environment/BuildEnvironment;Lio/customer/sdk/core/util/LogcatLogger;)V", "preferredLogLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "fallbackLogLevel", "getFallbackLogLevel", "()Lio/customer/sdk/core/util/CioLogLevel;", "value", "logLevel", "getLogLevel", "setLogLevel", "(Lio/customer/sdk/core/util/CioLogLevel;)V", "logDispatcher", "Lkotlin/Function2;", "", "", "setLogDispatcher", "dispatcher", "info", "message", ViewHierarchyConstants.TAG_KEY, "debug", "error", "throwable", "", "logIfMatchesCriteria", "levelForMessage", "shouldLog", "", "prependTagToMessage", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LoggerImpl implements Logger {
    public static final String TAG = "[CIO]";
    private final LogcatLogger actualLogger;
    private final BuildEnvironment buildEnvironment;
    private Function2<? super CioLogLevel, ? super String, Unit> logDispatcher;
    private CioLogLevel preferredLogLevel;

    /* JADX INFO: compiled from: LoggerImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CioLogLevel.values().length];
            try {
                iArr[CioLogLevel.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CioLogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CioLogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CioLogLevel.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LoggerImpl(BuildEnvironment buildEnvironment, LogcatLogger actualLogger) {
        Intrinsics.checkNotNullParameter(buildEnvironment, "buildEnvironment");
        Intrinsics.checkNotNullParameter(actualLogger, "actualLogger");
        this.buildEnvironment = buildEnvironment;
        this.actualLogger = actualLogger;
    }

    public /* synthetic */ LoggerImpl(BuildEnvironment buildEnvironment, LogcatLogger logcatLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(buildEnvironment, (i & 2) != 0 ? new LogcatLogger() : logcatLogger);
    }

    private final CioLogLevel getFallbackLogLevel() {
        return this.buildEnvironment.getDebugModeEnabled() ? CioLogLevel.DEBUG : CioLogLevel.INSTANCE.getDEFAULT();
    }

    private final void logIfMatchesCriteria(CioLogLevel levelForMessage, String message, String tag, Throwable throwable) {
        if (shouldLog(levelForMessage)) {
            Function2<? super CioLogLevel, ? super String, Unit> function2 = this.logDispatcher;
            if (function2 != null) {
                function2.invoke(levelForMessage, message);
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[levelForMessage.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.actualLogger.error(TAG, prependTagToMessage(tag, message), throwable);
                } else if (i == 3) {
                    this.actualLogger.info(TAG, prependTagToMessage(tag, message));
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.actualLogger.debug(TAG, prependTagToMessage(tag, message));
                }
            }
        }
    }

    private final String prependTagToMessage(String tag, String message) {
        String str = tag;
        return (str == null || StringsKt.isBlank(str)) ? message : "[" + tag + "] " + message;
    }

    private final boolean shouldLog(CioLogLevel levelForMessage) {
        return getLogLevel().getPriority() >= levelForMessage.getPriority();
    }

    @Override // io.customer.sdk.core.util.Logger
    public void debug(String message, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfMatchesCriteria(CioLogLevel.DEBUG, message, tag, null);
    }

    @Override // io.customer.sdk.core.util.Logger
    public void error(String message, String tag, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfMatchesCriteria(CioLogLevel.ERROR, message, tag, throwable);
    }

    @Override // io.customer.sdk.core.util.Logger
    public CioLogLevel getLogLevel() {
        CioLogLevel cioLogLevel = this.preferredLogLevel;
        return cioLogLevel == null ? getFallbackLogLevel() : cioLogLevel;
    }

    @Override // io.customer.sdk.core.util.Logger
    public void info(String message, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        logIfMatchesCriteria(CioLogLevel.INFO, message, tag, null);
    }

    @Override // io.customer.sdk.core.util.Logger
    public void setLogDispatcher(Function2<? super CioLogLevel, ? super String, Unit> dispatcher) {
        this.logDispatcher = dispatcher;
    }

    @Override // io.customer.sdk.core.util.Logger
    public void setLogLevel(CioLogLevel value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.preferredLogLevel = value;
    }
}
