package com.segment.analytics.kotlin.core.platform.policies;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FrequencyFlushPolicy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/policies/FrequencyFlushPolicy;", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "flushIntervalInMillis", "", "(J)V", "getFlushIntervalInMillis", "()J", "setFlushIntervalInMillis", "flushJob", "Lkotlinx/coroutines/Job;", "getFlushJob", "()Lkotlinx/coroutines/Job;", "setFlushJob", "(Lkotlinx/coroutines/Job;)V", "jobStarted", "", "getJobStarted", "()Z", "setJobStarted", "(Z)V", "schedule", "", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "shouldFlush", "unschedule", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FrequencyFlushPolicy implements FlushPolicy {
    private long flushIntervalInMillis;
    private Job flushJob;
    private boolean jobStarted;

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.platform.policies.FrequencyFlushPolicy$schedule$1, reason: invalid class name */
    /* JADX INFO: compiled from: FrequencyFlushPolicy.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.platform.policies.FrequencyFlushPolicy$schedule$1", f = "FrequencyFlushPolicy.kt", i = {0}, l = {30}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Analytics $analytics;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Analytics analytics, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$analytics = analytics;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FrequencyFlushPolicy.this.new AnonymousClass1(this.$analytics, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                if (FrequencyFlushPolicy.this.getFlushIntervalInMillis() > 0) {
                    coroutineScope = coroutineScope2;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                this.$analytics.flush();
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(FrequencyFlushPolicy.this.getFlushIntervalInMillis(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public FrequencyFlushPolicy() {
        this(0L, 1, null);
    }

    public FrequencyFlushPolicy(long j) {
        this.flushIntervalInMillis = j;
    }

    public /* synthetic */ FrequencyFlushPolicy(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 30000L : j);
    }

    public final long getFlushIntervalInMillis() {
        return this.flushIntervalInMillis;
    }

    public final Job getFlushJob() {
        return this.flushJob;
    }

    public final boolean getJobStarted() {
        return this.jobStarted;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void reset() {
        FlushPolicy.DefaultImpls.reset(this);
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void schedule(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        if (this.jobStarted) {
            return;
        }
        this.jobStarted = true;
        this.flushJob = BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getFileIODispatcher(), null, new AnonymousClass1(analytics, null), 2, null);
    }

    public final void setFlushIntervalInMillis(long j) {
        this.flushIntervalInMillis = j;
    }

    public final void setFlushJob(Job job) {
        this.flushJob = job;
    }

    public final void setJobStarted(boolean z) {
        this.jobStarted = z;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public boolean shouldFlush() {
        return false;
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void unschedule() {
        if (this.jobStarted) {
            this.jobStarted = false;
            Job job = this.flushJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.policies.FlushPolicy
    public void updateState(BaseEvent baseEvent) {
        FlushPolicy.DefaultImpls.updateState(this, baseEvent);
    }
}
