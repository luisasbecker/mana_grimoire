package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzck extends zzbel implements zzbft {
    private static final zzck zzb;
    private int zzd;
    private zzby zze;
    private zzbeq zzf = zzI();

    static {
        zzck zzckVar = new zzck();
        zzb = zzckVar;
        zzbel.zzR(zzck.class, zzckVar);
    }

    private zzck() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0013", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzck();
        }
        zzci zzciVar = null;
        if (i2 == 4) {
            return new zzcj(zzciVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
