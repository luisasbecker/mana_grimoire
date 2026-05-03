package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvl extends zzbel implements zzbft {
    private static final zzbvl zzb;
    private int zzd;
    private zzhm zze;
    private String zzf = "";

    static {
        zzbvl zzbvlVar = new zzbvl();
        zzb = zzbvlVar;
        zzbel.zzR(zzbvl.class, zzbvlVar);
    }

    private zzbvl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbvl();
        }
        zzbvj zzbvjVar = null;
        if (i2 == 4) {
            return new zzbvk(zzbvjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
