package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcv extends zzbel implements zzbft {
    private static final zzcv zzb;
    private zzbet zzd = zzL();

    static {
        zzcv zzcvVar = new zzcv();
        zzb = zzcvVar;
        zzbel.zzR(zzcv.class, zzcvVar);
    }

    private zzcv() {
    }

    public static zzco zza() {
        return (zzco) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzcv zzcvVar, zzcu zzcuVar) {
        zzcuVar.getClass();
        zzbet zzbetVar = zzcvVar.zzd;
        if (!zzbetVar.zzc()) {
            zzcvVar.zzd = zzbel.zzM(zzbetVar);
        }
        zzcvVar.zzd.add(zzcuVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzcu.class});
        }
        if (i2 == 3) {
            return new zzcv();
        }
        zzcn zzcnVar = null;
        if (i2 == 4) {
            return new zzco(zzcnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
