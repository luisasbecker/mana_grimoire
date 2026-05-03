package com.google.android.libraries.intelligence.acceleration.process;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends Fragment {
    public static final /* synthetic */ int zza = 0;
    private zzc zzb;

    /* JADX WARN: Multi-variable type inference failed */
    static void zza(Activity activity, Lifecycle.Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
            }
        }
    }

    private final void zzc(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            zza(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        zzc(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        zzc(Lifecycle.Event.ON_DESTROY);
        this.zzb = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        zzc(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        zzc zzcVar = this.zzb;
        if (zzcVar != null) {
            zzcVar.zza.zzc();
        }
        zzc(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        zzc zzcVar = this.zzb;
        if (zzcVar != null) {
            zzcVar.zza.zzd();
        }
        zzc(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        zzc(Lifecycle.Event.ON_STOP);
    }

    final void zzb(zzc zzcVar) {
        this.zzb = zzcVar;
    }
}
