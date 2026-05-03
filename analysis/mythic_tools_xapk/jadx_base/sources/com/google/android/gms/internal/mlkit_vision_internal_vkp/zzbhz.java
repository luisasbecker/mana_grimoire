package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhz extends zzbel implements zzbft {
    private static final zzbhz zzb;
    private int zzd;
    private zzbjq zze;
    private zzbet zzf = zzL();
    private zzbet zzg = zzL();

    static {
        zzbhz zzbhzVar = new zzbhz();
        zzb = zzbhzVar;
        zzbel.zzR(zzbhz.class, zzbhzVar);
    }

    private zzbhz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"zzd", "zze", "zzf", zzbkg.class, "zzg", zzbhv.class});
        }
        if (i2 == 3) {
            return new zzbhz();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbhy(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
