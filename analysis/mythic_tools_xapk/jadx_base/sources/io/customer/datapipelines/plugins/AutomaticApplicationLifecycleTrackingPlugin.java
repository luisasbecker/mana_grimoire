package io.customer.datapipelines.plugins;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.Plugin;
import io.customer.datapipelines.util.UiThreadRunner;
import io.customer.sdk.CustomerIO;
import io.customer.sdk.DataPipelineInstance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: AutomaticApplicationLifecycleTrackingPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/customer/datapipelines/plugins/AutomaticApplicationLifecycleTrackingPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "<init>", "()V", "processLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "uiThreadRunner", "Lio/customer/datapipelines/util/UiThreadRunner;", "(Landroidx/lifecycle/LifecycleOwner;Lio/customer/datapipelines/util/UiThreadRunner;)V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "setup", "", "registerProcessLifecycleObserver", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutomaticApplicationLifecycleTrackingPlugin implements Plugin {
    public Analytics analytics;
    private final LifecycleOwner processLifecycleOwner;
    private final Plugin.Type type;
    private final UiThreadRunner uiThreadRunner;

    public AutomaticApplicationLifecycleTrackingPlugin() {
        this(ProcessLifecycleOwner.INSTANCE.get(), new UiThreadRunner());
    }

    public AutomaticApplicationLifecycleTrackingPlugin(LifecycleOwner processLifecycleOwner, UiThreadRunner uiThreadRunner) {
        Intrinsics.checkNotNullParameter(processLifecycleOwner, "processLifecycleOwner");
        Intrinsics.checkNotNullParameter(uiThreadRunner, "uiThreadRunner");
        this.type = Plugin.Type.Utility;
        this.processLifecycleOwner = processLifecycleOwner;
        this.uiThreadRunner = uiThreadRunner;
    }

    private final void registerProcessLifecycleObserver() {
        this.processLifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: io.customer.datapipelines.plugins.AutomaticApplicationLifecycleTrackingPlugin.registerProcessLifecycleObserver.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onStart(LifecycleOwner owner) {
                Object objM11445constructorimpl;
                Intrinsics.checkNotNullParameter(owner, "owner");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AnonymousClass1 anonymousClass1 = this;
                    DataPipelineInstance.track$default(CustomerIO.INSTANCE.instance(), "Application Foregrounded", null, 2, null);
                    objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
                }
                AutomaticApplicationLifecycleTrackingPlugin automaticApplicationLifecycleTrackingPlugin = AutomaticApplicationLifecycleTrackingPlugin.this;
                if (Result.m11448exceptionOrNullimpl(objM11445constructorimpl) != null) {
                    Analytics.track$default(automaticApplicationLifecycleTrackingPlugin.getAnalytics(), "Application Foregrounded", (JsonObject) null, (Function1) null, 6, (Object) null);
                }
            }
        });
    }

    static final Unit setup$lambda$0(AutomaticApplicationLifecycleTrackingPlugin automaticApplicationLifecycleTrackingPlugin) {
        automaticApplicationLifecycleTrackingPlugin.registerProcessLifecycleObserver();
        return Unit.INSTANCE;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent baseEvent) {
        return Plugin.DefaultImpls.execute(this, baseEvent);
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
        this.uiThreadRunner.run(new Function0() { // from class: io.customer.datapipelines.plugins.AutomaticApplicationLifecycleTrackingPlugin$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AutomaticApplicationLifecycleTrackingPlugin.setup$lambda$0(this.f$0);
            }
        });
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
