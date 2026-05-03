package io.customer.sdk.data.store;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/customer/sdk/data/store/ApplicationStoreImpl;", "Lio/customer/sdk/data/store/ApplicationStore;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "customerAppName", "", "getCustomerAppName", "()Ljava/lang/String;", "customerAppVersion", "getCustomerAppVersion", "customerPackageName", "getCustomerPackageName", "isPushEnabled", "", "()Z", "tryGetValueOrNull", "tryGetValue", "Lkotlin/Function0;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationStoreImpl implements ApplicationStore {
    private final Context context;

    public ApplicationStoreImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final String tryGetValueOrNull(Function0<String> tryGetValue) {
        try {
            return tryGetValue.invoke();
        } catch (Exception unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerAppName() {
        return tryGetValueOrNull(new Function0() { // from class: io.customer.sdk.data.store.ApplicationStoreImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ApplicationStoreImpl applicationStoreImpl = this.f$0;
                return applicationStoreImpl.context.getApplicationInfo().loadLabel(applicationStoreImpl.context.getPackageManager()).toString();
            }
        });
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerAppVersion() {
        return tryGetValueOrNull(new Function0() { // from class: io.customer.sdk.data.store.ApplicationStoreImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ApplicationStoreImpl applicationStoreImpl = this.f$0;
                return applicationStoreImpl.context.getPackageManager().getPackageInfo(applicationStoreImpl.context.getPackageName(), 0).versionName;
            }
        });
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerPackageName() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public boolean isPushEnabled() {
        return NotificationManagerCompat.from(this.context).areNotificationsEnabled();
    }
}
