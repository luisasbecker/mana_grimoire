package com.google.android.libraries.vision.visionkit.pipeline;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbg {
    private byte[] zza;
    private long zzb;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcq zzc;
    private int zzd;
    private int zze;

    public final zzbg zza(byte[] bArr) {
        this.zza = bArr;
        return this;
    }

    public final zzbg zzb(com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcq zzcqVar) {
        this.zzc = zzcqVar;
        return this;
    }

    public final zzbg zzc(long j) {
        this.zzb = j;
        return this;
    }

    public final zzbh zzd() {
        return new zzbh(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final zzbg zze(int i) {
        this.zzd = 2;
        return this;
    }

    public final zzbg zzf(int i) {
        this.zze = i;
        return this;
    }
}
