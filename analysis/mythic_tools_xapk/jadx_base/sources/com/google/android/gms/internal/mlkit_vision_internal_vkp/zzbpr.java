package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbpr extends zzbel implements zzbft {
    private static final zzbpr zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private float zzg;
    private float zzh;

    static {
        zzbpr zzbprVar = new zzbpr();
        zzb = zzbprVar;
        zzbel.zzR(zzbpr.class, zzbprVar);
    }

    private zzbpr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005᠌\u0000", new Object[]{"zzd", "zzf", "zzg", "zzh", "zze", zzbqc.zza});
        }
        if (i2 == 3) {
            return new zzbpr();
        }
        zzbpp zzbppVar = null;
        if (i2 == 4) {
            return new zzbpq(zzbppVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
