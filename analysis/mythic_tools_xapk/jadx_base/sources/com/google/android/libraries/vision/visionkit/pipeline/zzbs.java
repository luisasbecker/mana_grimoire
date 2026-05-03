package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbs extends zzbel implements zzbft {
    private static final zzbs zzb;
    private int zzd;
    private int zze;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzdf zzf;
    private zzx zzg;

    static {
        zzbs zzbsVar = new zzbs();
        zzb = zzbsVar;
        zzbel.zzR(zzbs.class, zzbsVar);
    }

    private zzbs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbr.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbs();
        }
        zzbp zzbpVar = null;
        if (i2 == 4) {
            return new zzbq(zzbpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
