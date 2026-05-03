package com.segment.analytics.kotlin.core.platform.plugins;

import androidx.core.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LoggerKt;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: StartupQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/StartupQueue;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "Lsovran/kotlin/Subscriber;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "maxSize", "", "queuedEvents", "Ljava/util/Queue;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "execute", NotificationCompat.CATEGORY_EVENT, "replayEvents", "", "runningUpdate", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/segment/analytics/kotlin/core/System;", "setup", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StartupQueue implements Plugin, Subscriber {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Before;
    private final int maxSize = 1000;
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final Queue<BaseEvent> queuedEvents = new ConcurrentLinkedQueue();

    private final void replayEvents() {
        while (!this.queuedEvents.isEmpty()) {
            BaseEvent baseEventPoll = this.queuedEvents.poll();
            if (baseEventPoll != null) {
                getAnalytics().process(baseEventPoll, baseEventPoll.getEnrichment());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runningUpdate(System state) {
        LoggerKt.log$default(getAnalytics(), "Analytics starting = " + state.getRunning(), null, 2, null);
        this.started.set(state.getRunning());
        if (this.started.get()) {
            replayEvents();
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.started.get()) {
            return event;
        }
        LoggerKt.log$default(getAnalytics(), "SegmentStartupQueue queueing event", null, 2, null);
        if (this.queuedEvents.size() >= this.maxSize) {
            this.queuedEvents.remove();
        }
        this.queuedEvents.offer(event);
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Plugin.Type getType() {
        return this.type;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Plugin.DefaultImpls.setup(this, analytics);
        BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getAnalyticsDispatcher(), null, new StartupQueue$setup$1$1(analytics, this, null), 2, null);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
