package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjj extends zzbel implements zzbft {
    private static final zzbjj zzb;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzbdd zzh = zzbdd.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        zzbjj zzbjjVar = new zzbjj();
        zzb = zzbjjVar;
        zzbel.zzR(zzbjj.class, zzbjjVar);
    }

    private zzbjj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzbep zzbepVar = zzbjh.zza;
            zzbep zzbepVar2 = zzbji.zza;
            return zzO(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", zzbepVar, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzbepVar2, "zzn", zzbepVar2, "zzo"});
        }
        if (i2 == 3) {
            return new zzbjj();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbjg(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
