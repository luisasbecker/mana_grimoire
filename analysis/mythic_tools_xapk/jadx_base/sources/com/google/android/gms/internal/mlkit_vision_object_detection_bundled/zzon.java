package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzon {
    private Long zza;
    private zzpa zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;
    private zzaq zzf;
    private Boolean zzg;
    private Boolean zzh;

    public final zzon zzb(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzon zzc(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzon zzd(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzon zze(zzpa zzpaVar) {
        this.zzb = zzpaVar;
        return this;
    }

    public final zzon zzf(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzon zzg(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzon zzh(zzaq zzaqVar) {
        this.zzf = zzaqVar;
        return this;
    }

    public final zzon zzi(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzop zzj() {
        return new zzop(this, null);
    }
}
