package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbsq;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzjb;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzer extends zzbel implements zzbft {
    private static final zzer zzb;
    private int zzd;
    private int zze;
    private zzbsq zzf;
    private zzjb zzg;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzdx zzh;
    private zzaa zzi;
    private byte zzj = 2;

    static {
        zzer zzerVar = new zzer();
        zzb = zzerVar;
        zzbel.zzR(zzer.class, zzerVar);
    }

    private zzer() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ဉ\u0002\u0002ဉ\u0003\u0003᠌\u0000\u0004ဉ\u0004\u0005ᐉ\u0001", new Object[]{"zzd", "zzg", "zzh", "zze", zzeq.zza, "zzi", "zzf"});
        }
        if (i2 == 3) {
            return new zzer();
        }
        zzeo zzeoVar = null;
        if (i2 == 4) {
            return new zzep(zzeoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
