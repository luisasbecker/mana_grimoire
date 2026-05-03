package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyk extends zzbel implements zzbft {
    private static final zzyk zzb;
    private int zzd;
    private zzvc zze;
    private zzym zzf;
    private zzut zzg;

    static {
        zzyk zzykVar = new zzyk();
        zzb = zzykVar;
        zzbel.zzR(zzyk.class, zzykVar);
    }

    private zzyk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzyk();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzyj(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
