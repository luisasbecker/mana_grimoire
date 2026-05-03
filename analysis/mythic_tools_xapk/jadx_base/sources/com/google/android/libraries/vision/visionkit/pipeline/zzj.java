package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends zzbel implements zzbft {
    private static final zzj zzb;
    private int zzd;
    private int zze;
    private zzdj zzf;

    static {
        zzj zzjVar = new zzj();
        zzb = zzjVar;
        zzbel.zzR(zzj.class, zzjVar);
    }

    private zzj() {
    }

    public static zzi zza() {
        return (zzi) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzj zzjVar, int i) {
        zzjVar.zze = 1;
        zzjVar.zzd = 1 | zzjVar.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", zzn.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzj();
        }
        zzh zzhVar = null;
        if (i2 == 4) {
            return new zzi(zzhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
