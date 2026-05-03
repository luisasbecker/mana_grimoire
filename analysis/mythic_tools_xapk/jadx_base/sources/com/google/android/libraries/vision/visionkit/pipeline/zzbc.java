package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbqm;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbc extends zzbel implements zzbft {
    private static final zzbc zzb;
    private Object zze;
    private int zzd = 0;
    private byte zzg = 2;
    private zzbet zzf = zzL();

    static {
        zzbc zzbcVar = new zzbc();
        zzb = zzbcVar;
        zzbel.zzR(zzbc.class, zzbcVar);
    }

    private zzbc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0001\u0001:\u0000\u0003Л", new Object[]{"zze", "zzd", "zzf", zzbqm.class});
        }
        if (i2 == 3) {
            return new zzbc();
        }
        zzba zzbaVar = null;
        if (i2 == 4) {
            return new zzbb(zzbaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
