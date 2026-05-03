package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbhh extends zzbhj {
    zzbhh(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final void zzc(Object obj, long j, boolean z) {
        if (zzbhk.zzb) {
            zzbhk.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzbhk.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final void zzd(Object obj, long j, byte b) {
        if (zzbhk.zzb) {
            zzbhk.zzD(obj, j, b);
        } else {
            zzbhk.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhj
    public final boolean zzg(Object obj, long j) {
        return zzbhk.zzb ? zzbhk.zzt(obj, j) : zzbhk.zzu(obj, j);
    }
}
