package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzys extends zzbel implements zzbft {
    private static final zzys zzb;
    private int zzd;
    private long zze;
    private int zzf;
    private zztv zzg;
    private int zzh;

    static {
        zzys zzysVar = new zzys();
        zzb = zzysVar;
        zzbel.zzR(zzys.class, zzysVar);
    }

    private zzys() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဃ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဋ\u0003", new Object[]{"zzd", "zze", "zzf", zzuc.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzys();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzyr(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
