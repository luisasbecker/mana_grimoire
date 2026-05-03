package com.segment.analytics.kotlin.android.plugins;

import android.app.Activity;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/segment/analytics/kotlin/android/plugins/AndroidLifecycle;", "", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AndroidLifecycle {

    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onActivityCreated(AndroidLifecycle androidLifecycle, Activity activity, Bundle bundle) {
        }

        public static void onActivityDestroyed(AndroidLifecycle androidLifecycle, Activity activity) {
        }

        public static void onActivityPaused(AndroidLifecycle androidLifecycle, Activity activity) {
        }

        public static void onActivityResumed(AndroidLifecycle androidLifecycle, Activity activity) {
        }

        public static void onActivitySaveInstanceState(AndroidLifecycle androidLifecycle, Activity activity, Bundle bundle) {
        }

        public static void onActivityStarted(AndroidLifecycle androidLifecycle, Activity activity) {
        }

        public static void onActivityStopped(AndroidLifecycle androidLifecycle, Activity activity) {
        }
    }

    void onActivityCreated(Activity activity, Bundle savedInstanceState);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivitySaveInstanceState(Activity activity, Bundle outState);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);
}
