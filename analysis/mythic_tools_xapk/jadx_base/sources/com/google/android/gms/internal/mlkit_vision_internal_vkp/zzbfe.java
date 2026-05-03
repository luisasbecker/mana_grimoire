package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfe {
    zzbfe() {
    }

    public static final List zza(Object obj, long j) {
        zzbet zzbetVar = (zzbet) zzbhk.zzf(obj, j);
        if (zzbetVar.zzc()) {
            return zzbetVar;
        }
        int size = zzbetVar.size();
        zzbet zzbetVarZzd = zzbetVar.zzd(size == 0 ? 10 : size + size);
        zzbhk.zzs(obj, j, zzbetVarZzd);
        return zzbetVarZzd;
    }
}
