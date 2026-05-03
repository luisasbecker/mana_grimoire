package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzgp;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzjh;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdm extends zzbel implements zzbft {
    private static final zzdm zzb;
    private int zzd;
    private zzgp zze;
    private zzbet zzf = zzL();
    private zzbet zzg = zzL();

    static {
        zzdm zzdmVar = new zzdm();
        zzb = zzdmVar;
        zzbel.zzR(zzdm.class, zzdmVar);
    }

    private zzdm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"zzd", "zze", "zzf", zzjh.class, "zzg", com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcv.class});
        }
        if (i2 == 3) {
            return new zzdm();
        }
        zzdk zzdkVar = null;
        if (i2 == 4) {
            return new zzdl(zzdkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
