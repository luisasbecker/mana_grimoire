package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfi extends zzbel implements zzbft {
    private static final zzfi zzb;
    private int zzd;
    private int zze = 1;
    private boolean zzf;

    static {
        zzfi zzfiVar = new zzfi();
        zzb = zzfiVar;
        zzbel.zzR(zzfi.class, zzfiVar);
    }

    private zzfi() {
    }

    public static zzfh zza() {
        return (zzfh) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzfi zzfiVar, boolean z) {
        zzfiVar.zzd |= 2;
        zzfiVar.zzf = true;
    }

    static /* synthetic */ void zze(zzfi zzfiVar, int i) {
        zzfiVar.zze = i - 1;
        zzfiVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", zzn.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzfi();
        }
        zzfg zzfgVar = null;
        if (i2 == 4) {
            return new zzfh(zzfgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
