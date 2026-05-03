package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagq {
    private Long zza;
    private zzkz zzb;
    private zzkz zzc;
    private zzkz zzd;
    private String zze;
    private zzagr zzf;

    public final zzagq zzd(zzagr zzagrVar) {
        this.zzf = zzagrVar;
        return this;
    }

    public final zzagq zze(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzagq zzf(zzkz zzkzVar) {
        this.zzb = zzkzVar;
        return this;
    }

    public final zzagq zzg(String str) {
        this.zze = "com.google.perception";
        return this;
    }

    public final zzagq zzh(zzkz zzkzVar) {
        this.zzc = zzkzVar;
        return this;
    }

    public final zzagq zzi(zzkz zzkzVar) {
        this.zzd = zzkzVar;
        return this;
    }

    public final zzagu zzk() {
        return new zzagu(this, null);
    }
}
