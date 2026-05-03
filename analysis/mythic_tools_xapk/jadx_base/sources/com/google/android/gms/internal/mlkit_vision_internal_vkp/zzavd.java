package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzavd {
    private Long zza;
    private zzkz zzb;
    private zzkz zzc;
    private zzkz zzd;
    private Integer zze;

    public final zzavd zzd(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzavd zze(zzkz zzkzVar) {
        this.zzb = zzkzVar;
        return this;
    }

    public final zzavd zzf(Integer num) {
        this.zze = num;
        return this;
    }

    public final zzavd zzg(zzkz zzkzVar) {
        this.zzc = zzkzVar;
        return this;
    }

    public final zzavd zzh(zzkz zzkzVar) {
        this.zzd = zzkzVar;
        return this;
    }

    public final zzavg zzi() {
        return new zzavg(this, null);
    }
}
