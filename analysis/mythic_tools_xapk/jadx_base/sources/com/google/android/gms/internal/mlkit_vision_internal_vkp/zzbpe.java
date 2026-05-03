package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbpe extends zzbel implements zzbft {
    private static final zzbpe zzb;
    private int zzd;
    private int zze;
    private zzbdd zzf = zzbdd.zzb;
    private String zzg = "";
    private float zzh;

    static {
        zzbpe zzbpeVar = new zzbpe();
        zzb = zzbpeVar;
        zzbel.zzR(zzbpe.class, zzbpeVar);
    }

    private zzbpe() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbpe();
        }
        zzbow zzbowVar = null;
        if (i2 == 4) {
            return new zzbpd(zzbowVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
