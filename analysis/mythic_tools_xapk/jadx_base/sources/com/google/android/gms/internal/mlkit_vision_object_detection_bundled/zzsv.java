package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsv {
    private Long zza;
    private zzaq zzb;
    private zzaq zzc;
    private zzaq zzd;
    private Integer zze;

    public final zzsv zzd(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzsv zze(zzaq zzaqVar) {
        this.zzb = zzaqVar;
        return this;
    }

    public final zzsv zzf(Integer num) {
        this.zze = num;
        return this;
    }

    public final zzsv zzg(zzaq zzaqVar) {
        this.zzc = zzaqVar;
        return this;
    }

    public final zzsv zzh(zzaq zzaqVar) {
        this.zzd = zzaqVar;
        return this;
    }

    public final zzsy zzi() {
        return new zzsy(this, null);
    }
}
