package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrw {
    private zzrs zza;
    private zzpa zzb;
    private Long zzc;
    private zzaq zzd;

    public final zzrw zzd(zzrs zzrsVar) {
        this.zza = zzrsVar;
        return this;
    }

    public final zzrw zze(zzpa zzpaVar) {
        this.zzb = zzpaVar;
        return this;
    }

    public final zzrw zzf(zzaq zzaqVar) {
        this.zzd = zzaqVar;
        return this;
    }

    public final zzrw zzg(Long l) {
        this.zzc = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzry zzh() {
        return new zzry(this, null);
    }
}
