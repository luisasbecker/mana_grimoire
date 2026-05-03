package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvv extends zzbel implements zzbft {
    private static final zzbvv zzb;
    private int zzd;
    private String zze = "visionkit-pa.googleapis.com";
    private String zzf = "";
    private zzbet zzg = zzL();

    static {
        zzbvv zzbvvVar = new zzbvv();
        zzb = zzbvvVar;
        zzbel.zzR(zzbvv.class, zzbvvVar);
    }

    private zzbvv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzbvu.class});
        }
        if (i2 == 3) {
            return new zzbvv();
        }
        zzbvr zzbvrVar = null;
        if (i2 == 4) {
            return new zzbvs(zzbvrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
