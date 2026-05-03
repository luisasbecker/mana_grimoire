package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbya extends zzbel implements zzbft {
    private static final zzbya zzb;
    private long zze;
    private long zzf;
    private zzbdd zzd = zzbdd.zzb;
    private zzbet zzg = zzL();

    static {
        zzbya zzbyaVar = new zzbya();
        zzb = zzbyaVar;
        zzbel.zzR(zzbya.class, zzbyaVar);
    }

    private zzbya() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\n\u0002\u0002\u0003\u0002\u0004\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzbwt.class});
        }
        if (i2 == 3) {
            return new zzbya();
        }
        zzbxy zzbxyVar = null;
        if (i2 == 4) {
            return new zzbxz(zzbxyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
