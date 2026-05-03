package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbf extends zzbel implements zzbft {
    private static final zzbf zzb;
    private int zzd;
    private zzbet zze = zzbel.zzL();
    private long zzf;

    static {
        zzbf zzbfVar = new zzbf();
        zzb = zzbfVar;
        zzbel.zzR(zzbf.class, zzbfVar);
    }

    private zzbf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဂ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbf();
        }
        zzbd zzbdVar = null;
        if (i2 == 4) {
            return new zzbe(zzbdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
