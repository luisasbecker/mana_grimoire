package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"METRIC_TYPE", "", "logError", "", NotificationCompat.CATEGORY_ERROR, "", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TelemetryKt {
    private static final String METRIC_TYPE = "Counter";

    public static final void logError(Throwable err) {
        Intrinsics.checkNotNullParameter(err, "err");
        ErrorsKt.reportInternalError(Analytics.INSTANCE, err);
    }
}
