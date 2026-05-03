package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbhf extends zzbhd {
    zzbhf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzbel zzbelVar = (zzbel) obj;
        zzbhe zzbheVar = zzbelVar.zzc;
        if (zzbheVar != zzbhe.zzc()) {
            return zzbheVar;
        }
        zzbhe zzbheVarZzf = zzbhe.zzf();
        zzbelVar.zzc = zzbheVarZzf;
        return zzbheVarZzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* synthetic */ Object zzb() {
        return zzbhe.zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* synthetic */ Object zzc(Object obj) {
        zzbhe zzbheVar = (zzbhe) obj;
        zzbheVar.zzh();
        return zzbheVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzbhe) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzbhe) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzbhe) obj).zzj((i << 3) | 3, (zzbhe) obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzbdd zzbddVar) {
        ((zzbhe) obj).zzj((i << 3) | 2, zzbddVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzbhe) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final void zzi(Object obj) {
        ((zzbel) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhd
    final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zzbel) obj).zzc = (zzbhe) obj2;
    }
}
