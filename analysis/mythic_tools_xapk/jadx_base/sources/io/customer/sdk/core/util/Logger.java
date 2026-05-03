package io.customer.sdk.core.util;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH&J\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fH&J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lio/customer/sdk/core/util/Logger;", "", "logLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "getLogLevel", "()Lio/customer/sdk/core/util/CioLogLevel;", "setLogLevel", "(Lio/customer/sdk/core/util/CioLogLevel;)V", "setLogDispatcher", "", "dispatcher", "Lkotlin/Function2;", "", "info", "message", ViewHierarchyConstants.TAG_KEY, "debug", "error", "throwable", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Logger {

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void debug$default(Logger logger, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            logger.debug(str, str2);
        }

        public static /* synthetic */ void error$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.error(str, str2, th);
        }

        public static /* synthetic */ void info$default(Logger logger, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            logger.info(str, str2);
        }
    }

    void debug(String message, String tag);

    void error(String message, String tag, Throwable throwable);

    CioLogLevel getLogLevel();

    void info(String message, String tag);

    void setLogDispatcher(Function2<? super CioLogLevel, ? super String, Unit> dispatcher);

    void setLogLevel(CioLogLevel cioLogLevel);
}
