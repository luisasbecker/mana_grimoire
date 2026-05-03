package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbyg extends zzbel implements zzbft {
    private static final zzbyg zzb;
    private int zzd;
    private zzbxx zze;
    private double zzf;
    private double zzg;

    static {
        zzbyg zzbygVar = new zzbyg();
        zzb = zzbygVar;
        zzbel.zzR(zzbyg.class, zzbygVar);
    }

    private zzbyg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000\u0003\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbyg();
        }
        zzbye zzbyeVar = null;
        if (i2 == 4) {
            return new zzbyf(zzbyeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
