package com.google.android.libraries.intelligence.acceleration.process;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzg extends zza {
    zzg() {
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(new zzi());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("com.google.android.libraries.intelligence.acceleration.process.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new zzj(), "com.google.android.libraries.intelligence.acceleration.process.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
