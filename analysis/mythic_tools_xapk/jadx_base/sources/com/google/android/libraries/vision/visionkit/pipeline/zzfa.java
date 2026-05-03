package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzmt;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfa extends zzbel implements zzbft {
    private static final zzfa zzb;
    private int zzd;
    private String zze = "";
    private zzbet zzf = zzbel.zzL();
    private zzbet zzg = zzbel.zzL();
    private zzbet zzh = zzbel.zzL();
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbd zzi;
    private zzmt zzj;

    static {
        zzfa zzfaVar = new zzfa();
        zzb = zzfaVar;
        zzbel.zzR(zzfa.class, zzfaVar);
    }

    private zzfa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဉ\u0001\u0004\u001a\u0005ဉ\u0002\u0006\u001a", new Object[]{"zzd", "zze", "zzf", "zzi", "zzh", "zzj", "zzg"});
        }
        if (i2 == 3) {
            return new zzfa();
        }
        zzey zzeyVar = null;
        if (i2 == 4) {
            return new zzez(zzeyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
