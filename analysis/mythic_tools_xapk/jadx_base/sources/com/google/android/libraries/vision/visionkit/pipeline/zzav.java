package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzav extends zzbel implements zzbft {
    private static final zzav zzb;
    private int zzd;
    private float zze;
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzav zzavVar = new zzav();
        zzb = zzavVar;
        zzbel.zzR(zzav.class, zzavVar);
    }

    private zzav() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzav();
        }
        zzaq zzaqVar = null;
        if (i2 == 4) {
            return new zzau(zzaqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
