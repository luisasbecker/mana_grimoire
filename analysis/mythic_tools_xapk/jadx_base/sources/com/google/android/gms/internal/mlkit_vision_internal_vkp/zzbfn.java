package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfn {
    zzbfn() {
    }

    public static final boolean zza(Object obj) {
        return !((zzbfm) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzbfm zzbfmVarZzb = (zzbfm) obj;
        zzbfm zzbfmVar = (zzbfm) obj2;
        if (!zzbfmVar.isEmpty()) {
            if (!zzbfmVarZzb.zze()) {
                zzbfmVarZzb = zzbfmVarZzb.zzb();
            }
            zzbfmVarZzb.zzd(zzbfmVar);
        }
        return zzbfmVarZzb;
    }
}
