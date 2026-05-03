package io.customer.datapipelines.plugins;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.segment.analytics.kotlin.android.plugins.AndroidLifecycle;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.platform.Plugin;
import io.customer.sdk.CustomerIO;
import io.customer.sdk.DataPipelineInstance;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import io.customer.sdk.tracking.TrackableScreen;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: AutomaticActivityScreenTrackingPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/customer/datapipelines/plugins/AutomaticActivityScreenTrackingPlugin;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "Lcom/segment/analytics/kotlin/android/plugins/AndroidLifecycle;", "<init>", "()V", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "logger", "Lio/customer/sdk/core/util/Logger;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutomaticActivityScreenTrackingPlugin implements Plugin, AndroidLifecycle {
    public Analytics analytics;
    private final Plugin.Type type = Plugin.Type.Utility;
    private final Logger logger = SDKComponent.INSTANCE.getLogger();

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

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AndroidLifecycle.DefaultImpls.onActivityCreated(this, activity, bundle);
    }

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityDestroyed(Activity activity) {
        AndroidLifecycle.DefaultImpls.onActivityDestroyed(this, activity);
    }

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityPaused(Activity activity) {
        AndroidLifecycle.DefaultImpls.onActivityPaused(this, activity);
    }

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityResumed(Activity activity) {
        AndroidLifecycle.DefaultImpls.onActivityResumed(this, activity);
    }

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AndroidLifecycle.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityStarted(Activity activity) {
        String str;
        String screenName;
        String str2;
        Object objM11445constructorimpl;
        PackageManager packageManager = activity != 0 ? activity.getPackageManager() : null;
        try {
            if (activity instanceof TrackableScreen) {
                screenName = ((TrackableScreen) activity).getScreenName();
            } else {
                ActivityInfo activityInfo = packageManager != null ? packageManager.getActivityInfo(activity.getComponentName(), 128) : null;
                CharSequence charSequenceLoadLabel = activityInfo != null ? activityInfo.loadLabel(packageManager) : null;
                if (activity == 0) {
                    str = null;
                    str2 = str;
                    if (str2 != null || StringsKt.isBlank(str2)) {
                    }
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        AutomaticActivityScreenTrackingPlugin automaticActivityScreenTrackingPlugin = this;
                        DataPipelineInstance.screen$default(CustomerIO.INSTANCE.instance(), str, null, 2, null);
                        objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m11448exceptionOrNullimpl(objM11445constructorimpl) != null) {
                        Analytics.screen$default(getAnalytics(), str, (JsonObject) null, (String) null, (Function1) null, 14, (Object) null);
                        return;
                    }
                    return;
                }
                String strValueOf = String.valueOf(charSequenceLoadLabel);
                if (strValueOf.length() == 0) {
                    String simpleName = activity.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                    strValueOf = StringExtensionsKt.getScreenNameFromActivity(simpleName);
                }
                screenName = strValueOf;
            }
            str = screenName;
            str2 = str;
            if (str2 != null) {
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger logger = this.logger;
            String message = e.getMessage();
            if (message == null) {
                message = "Unable to activity screen NameNotFoundException, " + activity;
            }
            Logger.DefaultImpls.error$default(logger, message, null, null, 6, null);
        } catch (Exception e2) {
            Logger logger2 = this.logger;
            String message2 = e2.getMessage();
            if (message2 == null) {
                message2 = "Unable to activity screen, " + activity;
            }
            Logger.DefaultImpls.error$default(logger2, message2, null, null, 6, null);
        }
    }

    @Override // com.segment.analytics.kotlin.android.plugins.AndroidLifecycle
    public void onActivityStopped(Activity activity) {
        AndroidLifecycle.DefaultImpls.onActivityStopped(this, activity);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Plugin.DefaultImpls.setup(this, analytics);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
