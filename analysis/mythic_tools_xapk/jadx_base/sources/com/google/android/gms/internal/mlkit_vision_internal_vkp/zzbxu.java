package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbxu extends zzbel implements zzbft {
    private static final zzbxu zzb;
    private int zzd;
    private zzbs zze;
    private zzbet zzf = zzL();

    static {
        zzbxu zzbxuVar = new zzbxu();
        zzb = zzbxuVar;
        zzbel.zzR(zzbxu.class, zzbxuVar);
    }

    private zzbxu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zzbwh.class});
        }
        if (i2 == 3) {
            return new zzbxu();
        }
        zzbxs zzbxsVar = null;
        if (i2 == 4) {
            return new zzbxt(zzbxsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
