package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdz extends zzbel implements zzbft {
    private static final zzdz zzb;
    private zzbet zzd = zzL();

    static {
        zzdz zzdzVar = new zzdz();
        zzb = zzdzVar;
        zzbel.zzR(zzdz.class, zzdzVar);
    }

    private zzdz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzdy.class});
        }
        if (i2 == 3) {
            return new zzdz();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzdw(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
