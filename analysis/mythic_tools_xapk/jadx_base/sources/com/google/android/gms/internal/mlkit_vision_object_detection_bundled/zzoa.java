package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoa {
    private Long zza;
    private Long zzb;
    private Long zzc;
    private Long zzd;
    private Long zze;
    private Long zzf;

    public final zzoa zza(Long l) {
        this.zzc = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoa zzb(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoa zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoa zzd(Long l) {
        this.zze = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoa zze(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoa zzf(Long l) {
        this.zzf = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzoc zzg() {
        return new zzoc(this, null);
    }
}
