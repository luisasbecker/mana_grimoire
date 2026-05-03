package io.customer.sdk.core.extensions;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"applicationMetaData", "Landroid/os/Bundle;", "Landroid/content/Context;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextExtensionsKt {
    public static final Bundle applicationMetaData(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L)) : context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNull(applicationInfo);
            return applicationInfo.metaData;
        } catch (Exception e) {
            Logger.DefaultImpls.error$default(SDKComponent.INSTANCE.getLogger(), "Failed to get ApplicationInfo with error: " + e.getMessage(), null, null, 6, null);
            return null;
        }
    }
}
