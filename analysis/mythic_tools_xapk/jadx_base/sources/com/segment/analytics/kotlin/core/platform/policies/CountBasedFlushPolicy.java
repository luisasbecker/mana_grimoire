package com.segment.analytics.kotlin.core.platform.policies;

import androidx.core.app.NotificationCompat;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CountBasedFlushPolicy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/policies/CountBasedFlushPolicy;", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "flushAt", "", "(I)V", "count", "getFlushAt", "()I", "setFlushAt", "reset", "", "shouldFlush", "", "updateState", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/BaseEvent;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CountBasedFlushPolicy implements FlushPolicy {
    private int count;
    private int flushAt;

    public CountBasedFlushPolicy() {
        this(0, 1, null);
    }

    public CountBasedFlushPolicy(int i) {
        this.flushAt = i;
        this.flushAt = i < 1 ? 20 : i;
    }

    public /* synthetic */ CountBasedFlushPolicy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 20 : i);
    }

    public final int getFlushAt() {
        return this.flushAt;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void reset() {
        this.count = 0;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void schedule(Analytics analytics) {
        FlushPolicy.DefaultImpls.schedule(this, analytics);
    }

    public final void setFlushAt(int i) {
        this.flushAt = i;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public boolean shouldFlush() {
        return this.count >= this.flushAt;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void unschedule() {
        FlushPolicy.DefaultImpls.unschedule(this);
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void updateState(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.count++;
    }
}
