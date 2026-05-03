package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zziy;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzad extends zzbel implements zzbft {
    private static final zzad zzb;
    private int zzd;
    private int zzf;
    private zzbet zze = zzL();
    private zzbet zzg = zzbel.zzL();

    static {
        zzad zzadVar = new zzad();
        zzb = zzadVar;
        zzbel.zzR(zzad.class, zzadVar);
    }

    private zzad() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002င\u0000\u0003\u001a", new Object[]{"zzd", "zze", zziy.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzad();
        }
        zzab zzabVar = null;
        if (i2 == 4) {
            return new zzac(zzabVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
