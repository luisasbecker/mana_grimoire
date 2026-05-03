package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbvv;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzu extends zzbel implements zzbft {
    private static final zzu zzb;
    private int zzd;
    private zzbvv zze;
    private String zzf = "";
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzbel.zzR(zzu.class, zzuVar);
    }

    private zzu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဇ\u0003\u0005᠌\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzt.zza});
        }
        if (i2 == 3) {
            return new zzu();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzs(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
