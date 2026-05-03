package com.segment.analytics.kotlin.core.platform.plugins.logger;

import com.segment.analytics.kotlin.core.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentLog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"segmentLog", "", "Lcom/segment/analytics/kotlin/core/Analytics$Companion;", "message", "", "kind", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/LogKind;", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SegmentLogKt {

    /* JADX INFO: compiled from: SegmentLog.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogKind.values().length];
            try {
                iArr[LogKind.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void segmentLog(Analytics.Companion companion, String message, LogKind kind) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Logger logger$core = companion.getLogger$core();
        LogMessage logMessage = new LogMessage(kind, message, null, 4, null);
        if (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()] != 1) {
            logger$core.parseLog(logMessage);
        } else if (companion.getDebugLogsEnabled()) {
            logger$core.parseLog(logMessage);
        }
    }

    public static /* synthetic */ void segmentLog$default(Analytics.Companion companion, String str, LogKind logKind, int i, Object obj) {
        if ((i & 2) != 0) {
            logKind = LogKind.ERROR;
        }
        segmentLog(companion, str, logKind);
    }
}
