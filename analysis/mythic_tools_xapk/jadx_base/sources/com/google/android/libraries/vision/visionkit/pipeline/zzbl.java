package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbl extends zzbel implements zzbft {
    private static final zzbl zzb;
    private int zzd;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzed zze;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzej zzf;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzeg zzg;

    static {
        zzbl zzblVar = new zzbl();
        zzb = zzblVar;
        zzbel.zzR(zzbl.class, zzblVar);
    }

    private zzbl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbl();
        }
        zzbj zzbjVar = null;
        if (i2 == 4) {
            return new zzbk(zzbjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
