package com.segment.analytics.kotlin.core;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.platform.plugins.logger.SegmentLogKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f\u0012\u0004\u0012\u00020\u00010\u000b\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0007\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"reportErrorWithMetrics", "", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "error", "", "message", "", "metric", "log", "buildTags", "Lkotlin/Function1;", "", "reportInternalError", "Lcom/segment/analytics/kotlin/core/Analytics$Companion;", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ErrorsKt {
    public static final void reportErrorWithMetrics(Analytics analytics, Throwable error, String message, String metric, String log, Function1<? super Map<String, String>, Unit> buildTags) {
        Configuration configuration;
        Function1<Throwable, Unit> errorHandler;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(buildTags, "buildTags");
        if (analytics != null && (configuration = analytics.getConfiguration()) != null && (errorHandler = configuration.getErrorHandler()) != null) {
            errorHandler.invoke(error);
        }
        String message2 = error.getMessage();
        if (message2 != null) {
            message = message + ": " + message2;
        }
        SegmentLogKt.segmentLog$default(Analytics.INSTANCE, message, null, 2, null);
        Telemetry.INSTANCE.error(metric, log, buildTags);
    }

    public static final void reportInternalError(Analytics.Companion companion, String error) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        SegmentLogKt.segmentLog$default(Analytics.INSTANCE, error, null, 2, null);
    }

    public static final void reportInternalError(Analytics.Companion companion, Throwable error) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        String message = error.getMessage();
        if (message != null) {
            SegmentLogKt.segmentLog$default(Analytics.INSTANCE, message, null, 2, null);
        }
    }

    public static final void reportInternalError(Analytics analytics, Throwable error) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(error, "error");
        Function1<Throwable, Unit> errorHandler = analytics.getConfiguration().getErrorHandler();
        if (errorHandler != null) {
            errorHandler.invoke(error);
        }
        reportInternalError(Analytics.INSTANCE, error);
    }
}
