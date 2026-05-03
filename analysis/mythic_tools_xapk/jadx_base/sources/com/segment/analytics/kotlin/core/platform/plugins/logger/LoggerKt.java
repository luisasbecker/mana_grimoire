package com.segment.analytics.kotlin.core.platform.plugins.logger;

import com.segment.analytics.kotlin.core.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"log", "", "Lcom/segment/analytics/kotlin/core/Analytics;", "message", "", "kind", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LoggerKt {
    public static final void log(Analytics analytics, String message) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(analytics, message, null, 2, null);
    }

    public static final void log(Analytics analytics, String message, LogKind kind) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(kind, "kind");
        SegmentLogKt.segmentLog(Analytics.INSTANCE, message, kind);
    }

    public static /* synthetic */ void log$default(Analytics analytics, String str, LogKind logKind, int i, Object obj) {
        if ((i & 2) != 0) {
            logKind = LogKind.DEBUG;
        }
        log(analytics, str, logKind);
    }
}
