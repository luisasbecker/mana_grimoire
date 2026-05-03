package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgj extends zzbel implements zzbft {
    private static final zzgj zzb;
    private int zzd;
    private float zzf;
    private boolean zzg;
    private zzbhv zzi;
    private boolean zzj;
    private boolean zzk;
    private zzber zze = zzJ();
    private int zzh = 1;

    static {
        zzgj zzgjVar = new zzgj();
        zzb = zzgjVar;
        zzbel.zzR(zzgj.class, zzgjVar);
    }

    private zzgj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0000\u0001ࠞ\u0002ခ\u0000\u0003ဇ\u0001\u0004᠌\u0002\u0005ဉ\u0003\u0007ဇ\u0004\bဇ\u0005", new Object[]{"zzd", "zze", zzgf.zza, "zzf", "zzg", "zzh", zzgi.zza, "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzgj();
        }
        zzgg zzggVar = null;
        if (i2 == 4) {
            return new zzgh(zzggVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
