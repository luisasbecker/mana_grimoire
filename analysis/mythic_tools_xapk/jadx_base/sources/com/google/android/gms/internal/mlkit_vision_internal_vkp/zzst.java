package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzst extends zzbel implements zzbft {
    private static final zzst zzb;
    private int zzd;
    private zzwh zze;
    private int zzf;

    static {
        zzst zzstVar = new zzst();
        zzb = zzstVar;
        zzbel.zzR(zzst.class, zzstVar);
    }

    private zzst() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzuc.zza});
        }
        if (i2 == 3) {
            return new zzst();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzss(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
