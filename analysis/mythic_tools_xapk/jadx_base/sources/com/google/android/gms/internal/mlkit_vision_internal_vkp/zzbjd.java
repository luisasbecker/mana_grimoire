package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjd extends zzbel implements zzbft {
    private static final zzbjd zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        zzbjd zzbjdVar = new zzbjd();
        zzb = zzbjdVar;
        zzbel.zzR(zzbjd.class, zzbjdVar);
    }

    private zzbjd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzbep zzbepVar = zzbjf.zza;
            zzbep zzbepVar2 = zzbjb.zza;
            zzbep zzbepVar3 = zzbje.zza;
            return zzO(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", zzbepVar, "zzg", "zzh", zzbepVar2, "zzi", zzbepVar3, "zzj", zzbepVar3, "zzk", zzbepVar3, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzbjd();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbjc(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
