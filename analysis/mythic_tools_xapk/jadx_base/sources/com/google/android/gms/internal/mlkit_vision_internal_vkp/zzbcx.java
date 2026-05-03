package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbcx extends zzbdc {
    private final int zzc;
    private final int zzd;

    zzbcx(byte[] bArr, int i, int i2) {
        super(bArr);
        zzl(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdc, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdd
    public final byte zza(int i) {
        zzq(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdc, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdd
    final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdc
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdc, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdd
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdc, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdd
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
