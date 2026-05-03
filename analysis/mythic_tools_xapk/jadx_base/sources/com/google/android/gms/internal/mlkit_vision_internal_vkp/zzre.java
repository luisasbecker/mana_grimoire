package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzre extends zzbel implements zzbft {
    private static final zzre zzb;
    private int zzd;
    private zzvc zze;
    private zzwh zzf;
    private long zzg;
    private float zzh;
    private zzut zzi;

    static {
        zzre zzreVar = new zzre();
        zzb = zzreVar;
        zzbel.zzR(zzre.class, zzreVar);
    }

    private zzre() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzre();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzrd(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
