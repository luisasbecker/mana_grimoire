package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbzh extends zzbel implements zzbft {
    private static final zzbzh zzb;
    private int zzd;
    private zzhm zze;
    private zzbhv zzf;

    static {
        zzbzh zzbzhVar = new zzbzh();
        zzb = zzbzhVar;
        zzbel.zzR(zzbzh.class, zzbzhVar);
    }

    private zzbzh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbzh();
        }
        zzbzf zzbzfVar = null;
        if (i2 == 4) {
            return new zzbzg(zzbzfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
