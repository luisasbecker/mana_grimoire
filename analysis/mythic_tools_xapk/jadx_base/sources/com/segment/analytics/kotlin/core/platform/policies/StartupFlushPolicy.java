package com.segment.analytics.kotlin.core.platform.policies;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: StartupFlushPolicy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/policies/StartupFlushPolicy;", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "()V", "flushedAtStartup", "", "shouldFlush", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StartupFlushPolicy implements FlushPolicy {
    private boolean flushedAtStartup;

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void reset() {
        FlushPolicy.DefaultImpls.reset(this);
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void schedule(Analytics analytics) {
        FlushPolicy.DefaultImpls.schedule(this, analytics);
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public boolean shouldFlush() {
        if (this.flushedAtStartup) {
            return false;
        }
        this.flushedAtStartup = true;
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void unschedule() {
        FlushPolicy.DefaultImpls.unschedule(this);
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void updateState(BaseEvent baseEvent) {
        FlushPolicy.DefaultImpls.updateState(this, baseEvent);
    }
}
