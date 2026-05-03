package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1bSDK;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class AFb1lSDK implements Application.ActivityLifecycleCallbacks {
    private volatile boolean AFAdRevenueData;
    private final Runnable areAllFieldsValid;
    private ScheduledFuture<?> component1;
    final AFb1bSDK.AFa1zSDK getCurrencyIso4217Code;
    private final ScheduledExecutorService getMediationNetwork;
    private final AFi1rSDK getMonetizationNetwork;
    private final AFa1oSDK getRevenue;

    public AFb1lSDK(ScheduledExecutorService scheduledExecutorService, AFa1oSDK aFa1oSDK, AFi1rSDK aFi1rSDK, AFb1bSDK.AFa1zSDK aFa1zSDK) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "");
        Intrinsics.checkNotNullParameter(aFa1oSDK, "");
        Intrinsics.checkNotNullParameter(aFi1rSDK, "");
        Intrinsics.checkNotNullParameter(aFa1zSDK, "");
        this.getMediationNetwork = scheduledExecutorService;
        this.getRevenue = aFa1oSDK;
        this.getMonetizationNetwork = aFi1rSDK;
        this.getCurrencyIso4217Code = aFa1zSDK;
        this.areAllFieldsValid = new Runnable() { // from class: com.appsflyer.internal.AFb1lSDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AFb1lSDK.getCurrencyIso4217Code(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(AFb1lSDK aFb1lSDK) {
        Object objM11445constructorimpl;
        Intrinsics.checkNotNullParameter(aFb1lSDK, "");
        aFb1lSDK.AFAdRevenueData = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            aFb1lSDK.getCurrencyIso4217Code.getCurrencyIso4217Code();
            objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
        if (thM11448exceptionOrNullimpl != null) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", thM11448exceptionOrNullimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(AFb1lSDK aFb1lSDK, AFh1oSDK aFh1oSDK) {
        Object objM11445constructorimpl;
        Intrinsics.checkNotNullParameter(aFb1lSDK, "");
        Intrinsics.checkNotNullParameter(aFh1oSDK, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            aFb1lSDK.getCurrencyIso4217Code.getMediationNetwork(aFh1oSDK);
            objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
        if (thM11448exceptionOrNullimpl != null) {
            AFLogger.afErrorLog("Listener thrown an exception: ", thM11448exceptionOrNullimpl, true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        AFa1oSDK aFa1oSDK = this.getRevenue;
        Intent intent = activity.getIntent();
        if (((intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) ? null : intent.getData()) != null && intent != aFa1oSDK.AFAdRevenueData) {
            aFa1oSDK.AFAdRevenueData = intent;
        }
        this.getMonetizationNetwork.getCurrencyIso4217Code(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        if (this.AFAdRevenueData) {
            ScheduledExecutorService scheduledExecutorService = this.getMediationNetwork;
            Runnable runnable = this.areAllFieldsValid;
            AFb1bSDK.Companion companion = AFb1bSDK.INSTANCE;
            this.component1 = scheduledExecutorService.schedule(runnable, AFb1bSDK.Companion.getRevenue(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        if (!this.AFAdRevenueData) {
            this.AFAdRevenueData = true;
            final AFh1oSDK aFh1oSDK = new AFh1oSDK(activity, this.getMonetizationNetwork);
            this.getMediationNetwork.execute(new Runnable() { // from class: com.appsflyer.internal.AFb1lSDK$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AFb1lSDK.getCurrencyIso4217Code(this.f$0, aFh1oSDK);
                }
            });
        } else {
            ScheduledFuture<?> scheduledFuture = this.component1;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bundle, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }
}
