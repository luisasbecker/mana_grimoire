package io.customer.sdk.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleStateChange.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lio/customer/sdk/lifecycle/LifecycleStateChange;", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "bundle", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/ref/WeakReference;Landroidx/lifecycle/Lifecycle$Event;Landroid/os/Bundle;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "getEvent", "()Landroidx/lifecycle/Lifecycle$Event;", "getBundle", "()Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LifecycleStateChange {
    private final WeakReference<Activity> activity;
    private final Bundle bundle;
    private final Lifecycle.Event event;

    public LifecycleStateChange(WeakReference<Activity> activity, Lifecycle.Event event, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        this.activity = activity;
        this.event = event;
        this.bundle = bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LifecycleStateChange copy$default(LifecycleStateChange lifecycleStateChange, WeakReference weakReference, Lifecycle.Event event, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            weakReference = lifecycleStateChange.activity;
        }
        if ((i & 2) != 0) {
            event = lifecycleStateChange.event;
        }
        if ((i & 4) != 0) {
            bundle = lifecycleStateChange.bundle;
        }
        return lifecycleStateChange.copy(weakReference, event, bundle);
    }

    public final WeakReference<Activity> component1() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Lifecycle.Event getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    public final LifecycleStateChange copy(WeakReference<Activity> activity, Lifecycle.Event event, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        return new LifecycleStateChange(activity, event, bundle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LifecycleStateChange)) {
            return false;
        }
        LifecycleStateChange lifecycleStateChange = (LifecycleStateChange) other;
        return Intrinsics.areEqual(this.activity, lifecycleStateChange.activity) && this.event == lifecycleStateChange.event && Intrinsics.areEqual(this.bundle, lifecycleStateChange.bundle);
    }

    public final WeakReference<Activity> getActivity() {
        return this.activity;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final Lifecycle.Event getEvent() {
        return this.event;
    }

    public int hashCode() {
        int iHashCode = ((this.activity.hashCode() * 31) + this.event.hashCode()) * 31;
        Bundle bundle = this.bundle;
        return iHashCode + (bundle == null ? 0 : bundle.hashCode());
    }

    public String toString() {
        return "LifecycleStateChange(activity=" + this.activity + ", event=" + this.event + ", bundle=" + this.bundle + ")";
    }
}
