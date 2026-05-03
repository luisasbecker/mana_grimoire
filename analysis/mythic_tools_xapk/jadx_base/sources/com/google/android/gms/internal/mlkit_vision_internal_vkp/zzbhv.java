package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhv extends zzbel implements zzbft {
    private static final zzbhv zzb;
    private int zzd;
    private int zze;
    private zzbki zzf;
    private zzbjq zzg;
    private zzbjs zzh;

    static {
        zzbhv zzbhvVar = new zzbhv();
        zzb = zzbhvVar;
        zzbel.zzR(zzbhv.class, zzbhvVar);
    }

    private zzbhv() {
    }

    public static zzbhv zze() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", zzbiy.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbhv();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbhu(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
