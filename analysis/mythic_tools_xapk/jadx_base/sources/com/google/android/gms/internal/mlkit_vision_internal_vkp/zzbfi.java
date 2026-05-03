package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfi implements zzbfq {
    private final zzbfq[] zza;

    zzbfi(zzbfq... zzbfqVarArr) {
        this.zza = zzbfqVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfq
    public final zzbfp zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzbfq zzbfqVar = this.zza[i];
            if (zzbfqVar.zzc(cls)) {
                return zzbfqVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfq
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
