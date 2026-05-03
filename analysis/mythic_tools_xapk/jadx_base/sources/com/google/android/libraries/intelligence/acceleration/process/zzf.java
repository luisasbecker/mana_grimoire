package com.google.android.libraries.intelligence.acceleration.process;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf implements LifecycleOwner {
    private static final zzf zzb = new zzf();
    private Handler zzg;
    private int zzc = 0;
    private int zzd = 0;
    private boolean zze = true;
    private boolean zzf = true;
    private final LifecycleRegistry zzh = new LifecycleRegistry(this);
    private final Runnable zzi = new zzb(this);
    final zzc zza = new zzc(this);

    private zzf() {
    }

    public static LifecycleOwner zza() {
        return zzb;
    }

    static void zzh(Context context) {
        zzf zzfVar = zzb;
        zzfVar.zzg = new Handler();
        zzfVar.zzh.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new zze(zzfVar));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.zzh;
    }

    final void zzb() {
        int i = this.zzd - 1;
        this.zzd = i;
        if (i == 0) {
            this.zzg.postDelayed(this.zzi, 0L);
        }
    }

    final void zzc() {
        int i = this.zzd + 1;
        this.zzd = i;
        if (i == 1) {
            if (!this.zze) {
                this.zzg.removeCallbacks(this.zzi);
            } else {
                this.zzh.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.zze = false;
            }
        }
    }

    final void zzd() {
        int i = this.zzc + 1;
        this.zzc = i;
        if (i == 1 && this.zzf) {
            this.zzh.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.zzf = false;
        }
    }

    final void zze() {
        this.zzc--;
        zzg();
    }

    final void zzf() {
        if (this.zzd == 0) {
            this.zze = true;
            this.zzh.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    final void zzg() {
        if (this.zzc == 0 && this.zze) {
            this.zzh.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.zzf = true;
        }
    }
}
