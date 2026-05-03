package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaz extends zzbel implements zzbft {
    private static final zzaz zzb;
    private int zzd;
    private int zze;

    static {
        zzaz zzazVar = new zzaz();
        zzb = zzazVar;
        zzbel.zzR(zzaz.class, zzazVar);
    }

    private zzaz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaz();
        }
        zzax zzaxVar = null;
        if (i2 == 4) {
            return new zzay(zzaxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
