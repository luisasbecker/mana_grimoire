package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbxi extends zzbel implements zzbft {
    private static final zzbxi zzb;
    private int zzd;
    private zzbxx zze;
    private double zzf;

    static {
        zzbxi zzbxiVar = new zzbxi();
        zzb = zzbxiVar;
        zzbel.zzR(zzbxi.class, zzbxiVar);
    }

    private zzbxi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbxi();
        }
        zzbxg zzbxgVar = null;
        if (i2 == 4) {
            return new zzbxh(zzbxgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
