package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbvl;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zziy;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq extends zzbel implements zzbft {
    private static final zzq zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zziy zzg;

    static {
        zzq zzqVar = new zzq();
        zzb = zzqVar;
        zzbel.zzR(zzq.class, zzqVar);
    }

    private zzq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbp.class, zzbvl.class});
        }
        if (i2 == 3) {
            return new zzq();
        }
        zzo zzoVar = null;
        if (i2 == 4) {
            return new zzp(zzoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
