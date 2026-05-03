package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzza extends zzbel implements zzbft {
    private static final zzza zzb;
    private int zzd;
    private zzvc zze;
    private zzagb zzf;
    private zzut zzg;
    private zzum zzh;
    private int zzi;
    private int zzj;

    static {
        zzza zzzaVar = new zzza();
        zzb = zzzaVar;
        zzbel.zzR(zzza.class, zzzaVar);
    }

    private zzza() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzza();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzyz(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
