package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbkl extends zzbel implements zzbft {
    private static final zzbkl zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzbkl zzbklVar = new zzbkl();
        zzb = zzbklVar;
        zzbel.zzR(zzbkl.class, zzbklVar);
    }

    private zzbkl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", zzbkj.zza, "zzg"});
        }
        if (i2 == 3) {
            return new zzbkl();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbkk(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
