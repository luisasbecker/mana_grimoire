package com.segment.analytics.kotlin.core.platform.policies;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlushPolicy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "", "reset", "", "schedule", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "shouldFlush", "", "unschedule", "updateState", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlushPolicy {

    /* JADX INFO: compiled from: FlushPolicy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void reset(FlushPolicy flushPolicy) {
        }

        public static void schedule(FlushPolicy flushPolicy, Analytics analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
        }

        public static void unschedule(FlushPolicy flushPolicy) {
        }

        public static void updateState(FlushPolicy flushPolicy, BaseEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    void reset();

    void schedule(Analytics analytics);

    boolean shouldFlush();

    void unschedule();

    void updateState(BaseEvent event);
}
