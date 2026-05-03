package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdp extends zzbel implements zzbft {
    private static final zzdp zzb;
    private int zzd;
    private boolean zze;

    static {
        zzdp zzdpVar = new zzdp();
        zzb = zzdpVar;
        zzbel.zzR(zzdp.class, zzdpVar);
    }

    private zzdp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzdp();
        }
        zzdn zzdnVar = null;
        if (i2 == 4) {
            return new zzdo(zzdnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
