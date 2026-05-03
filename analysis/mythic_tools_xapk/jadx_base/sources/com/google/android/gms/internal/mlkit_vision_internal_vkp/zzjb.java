package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjb extends zzbel implements zzbft {
    private static final zzjb zzb;
    private int zzd;
    private zzhm zzg;
    private zzhm zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private zzbhv zzm;
    private String zze = "";
    private String zzf = "";
    private int zzl = 1;

    static {
        zzjb zzjbVar = new zzjb();
        zzb = zzjbVar;
        zzbel.zzR(zzjb.class, zzjbVar);
    }

    private zzjb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0005\u0003ဇ\u0006\u0004ဉ\u0002\u0006ဇ\u0004\u0007င\u0007\bဉ\b\tဉ\u0003\nဈ\u0001", new Object[]{"zzd", "zze", "zzj", "zzk", "zzg", "zzi", "zzl", "zzm", "zzh", "zzf"});
        }
        if (i2 == 3) {
            return new zzjb();
        }
        zziz zzizVar = null;
        if (i2 == 4) {
            return new zzja(zzizVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
