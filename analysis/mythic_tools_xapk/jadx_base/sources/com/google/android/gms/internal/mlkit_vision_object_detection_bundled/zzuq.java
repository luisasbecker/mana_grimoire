package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuq {
    private final zzuf zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;

    public zzuq(zzuf zzufVar, String str, String str2, long j) {
        this.zza = zzufVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzuf zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return System.currentTimeMillis() >= this.zzd;
    }
}
