package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawy {
    private final zzkw zza = new zzkw();
    private final zzkw zzb = new zzkw();
    private final zzkw zzc = new zzkw();
    private final String zzd = "com.google.perception";
    private final zzagr zze = zzagr.NNAPI;
    private long zzf;
    private long zzg;

    public zzawy(String str, int i) {
    }

    public final zzagq zza() {
        zzkj.zzf(this.zzf != 0);
        zzkj.zzf(this.zzg != 0);
        long j = this.zzg - this.zzf;
        zzagq zzagqVar = new zzagq();
        zzagqVar.zze(Long.valueOf(j));
        zzagqVar.zzg(this.zzd);
        zzagqVar.zzd(this.zze);
        zzagqVar.zzi(this.zza.zzc());
        zzagqVar.zzh(this.zzb.zzc());
        zzagqVar.zzf(this.zzc.zzc());
        return zzagqVar;
    }

    public final void zzb(zzags zzagsVar) {
        this.zzc.zzb(zzagsVar);
    }

    public final void zzc(zzags zzagsVar) {
        this.zzb.zzb(zzagsVar);
    }

    public final void zzd(zzags zzagsVar) {
        this.zza.zzb(zzagsVar);
    }

    public final void zze() {
        zzkj.zzg(this.zzg == 0, "Method endTiming is not supposed to be called more than once.");
        this.zzg = SystemClock.elapsedRealtime();
    }

    public final void zzf() {
        zzkj.zzg(this.zzf == 0, "Method startTiming is not supposed to be called more than once.");
        this.zzf = SystemClock.elapsedRealtime();
    }
}
