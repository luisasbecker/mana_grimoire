package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzum {
    boolean zza;
    private long zzb;
    private long zzc;
    private final zzan zzd = new zzan();
    private final zzan zze = new zzan();
    private final zzan zzf = new zzan();
    private int zzg;

    public final zzsv zza() {
        zzd.zzd(this.zzb != 0);
        zzd.zzd(this.zzc != 0);
        long j = this.zzc - this.zzb;
        zzsv zzsvVar = new zzsv();
        zzsvVar.zzd(Long.valueOf(j));
        zzsvVar.zzh(this.zzd.zzc());
        zzsvVar.zzg(this.zze.zzc());
        zzsvVar.zze(this.zzf.zzc());
        int i = this.zzg;
        if (i != 0) {
            zzsvVar.zzf(Integer.valueOf(i));
        }
        return zzsvVar;
    }

    public final void zzb(zzsw zzswVar) {
        this.zzf.zzb(zzswVar);
    }

    public final void zzc(zzsw zzswVar) {
        this.zze.zzb(zzswVar);
    }

    public final void zzd(zzsw zzswVar) {
        if (this.zza) {
            this.zze.zzb(zzswVar);
        } else {
            this.zzd.zzb(zzswVar);
        }
    }

    public final void zze() {
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzf(int i) {
        this.zzg = i;
    }

    public final void zzg() {
        this.zzb = SystemClock.elapsedRealtime();
    }

    public final void zzh() {
        this.zza = true;
    }
}
