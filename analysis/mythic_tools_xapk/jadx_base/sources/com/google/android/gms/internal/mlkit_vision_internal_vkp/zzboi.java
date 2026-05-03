package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzboi extends zzbel implements zzbft {
    private static final zzboi zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzboi zzboiVar = new zzboi();
        zzb = zzboiVar;
        zzbel.zzR(zzboi.class, zzboiVar);
    }

    private zzboi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzboi();
        }
        zzbne zzbneVar = null;
        if (i2 == 4) {
            return new zzboh(zzbneVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
