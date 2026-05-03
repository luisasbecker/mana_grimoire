package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvf extends zzbel implements zzbft {
    private static final zzbvf zzb;
    private int zzd = 0;
    private Object zze;
    private float zzf;

    static {
        zzbvf zzbvfVar = new zzbvf();
        zzb = zzbvfVar;
        zzbel.zzR(zzbvf.class, zzbvfVar);
    }

    private zzbvf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u00017\u0000\u0002\u0001\u0003<\u0000", new Object[]{"zze", "zzd", "zzf", zzbvd.class});
        }
        if (i2 == 3) {
            return new zzbvf();
        }
        zzbvb zzbvbVar = null;
        if (i2 == 4) {
            return new zzbve(zzbvbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
