package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbvv;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaa extends zzbel implements zzbft {
    private static final zzaa zzb;
    private int zzd;
    private zzbvv zze;
    private String zzf = "";
    private boolean zzg;
    private zzen zzh;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzbel.zzR(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzaa();
        }
        zzy zzyVar = null;
        if (i2 == 4) {
            return new zzz(zzyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
