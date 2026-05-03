package com.google.android.libraries.intelligence.acceleration.process;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zze extends zza {
    final /* synthetic */ zzf zza;

    zze(zzf zzfVar) {
        this.zza = zzfVar;
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i = zzj.zza;
            ((zzj) activity.getFragmentManager().findFragmentByTag("com.google.android.libraries.intelligence.acceleration.process.report_fragment_tag")).zzb(this.zza.zza);
        }
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new zzd(this));
    }

    @Override // com.google.android.libraries.intelligence.acceleration.process.zza, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.zza.zze();
    }
}
