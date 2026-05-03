package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeu extends zzbel implements zzbft {
    private static final zzeu zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzeu zzeuVar = new zzeu();
        zzb = zzeuVar;
        zzbel.zzR(zzeu.class, zzeuVar);
    }

    private zzeu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zzbf.class, zzcb.class});
        }
        if (i2 == 3) {
            return new zzeu();
        }
        zzes zzesVar = null;
        if (i2 == 4) {
            return new zzet(zzesVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
