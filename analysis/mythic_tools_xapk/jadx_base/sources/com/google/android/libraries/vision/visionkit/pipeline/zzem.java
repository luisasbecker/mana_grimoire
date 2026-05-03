package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzem extends zzbel implements zzbft {
    private static final zzem zzb;
    private int zzd;
    private String zze = "";

    static {
        zzem zzemVar = new zzem();
        zzb = zzemVar;
        zzbel.zzR(zzem.class, zzemVar);
    }

    private zzem() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzem();
        }
        zzej zzejVar = null;
        if (i2 == 4) {
            return new zzel(zzejVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
