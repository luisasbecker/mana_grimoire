package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzik extends zzbel implements zzbft {
    private static final zzik zzb;
    private int zzd;
    private zzii zzf;
    private zzhm zzg;
    private zzbzh zzh;
    private zzbhv zzk;
    private String zze = "";
    private String zzi = "en";
    private int zzj = 1;
    private int zzl = -1;
    private String zzm = "";

    static {
        zzik zzikVar = new zzik();
        zzb = zzikVar;
        zzbel.zzR(zzik.class, zzikVar);
    }

    private zzik() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003᠌\u0005\u0004ဉ\u0006\u0005ဉ\u0002\u0006ဈ\u0004\u0007င\u0007\bဉ\u0003\tဈ\b", new Object[]{"zzd", "zze", "zzf", "zzj", zzij.zza, "zzk", "zzg", "zzi", "zzl", "zzh", "zzm"});
        }
        if (i2 == 3) {
            return new zzik();
        }
        zzif zzifVar = null;
        if (i2 == 4) {
            return new zzig(zzifVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
