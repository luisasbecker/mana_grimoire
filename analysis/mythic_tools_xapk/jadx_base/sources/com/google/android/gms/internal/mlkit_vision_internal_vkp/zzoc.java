package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoc extends zzbel implements zzbft {
    private static final zzoc zzb;
    private int zzd;
    private long zze;
    private zzber zzf = zzJ();
    private zzber zzg = zzJ();
    private zzber zzh = zzJ();
    private String zzi = "";
    private int zzj;
    private int zzk;

    static {
        zzoc zzocVar = new zzoc();
        zzb = zzocVar;
        zzbel.zzR(zzoc.class, zzocVar);
    }

    private zzoc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzbep zzbepVar = zzob.zza;
            return zzO(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001ဃ\u0000\u0002ࠞ\u0003ࠞ\u0004ࠞ\u0005ဈ\u0001\u0006᠌\u0002\u0007င\u0003", new Object[]{"zzd", "zze", "zzf", zzbepVar, "zzg", zzbepVar, "zzh", zzbepVar, "zzi", "zzj", zzoa.zza, "zzk"});
        }
        if (i2 == 3) {
            return new zzoc();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zznz(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
