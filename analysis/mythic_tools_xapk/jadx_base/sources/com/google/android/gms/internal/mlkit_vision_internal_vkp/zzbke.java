package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbke extends zzbel implements zzbft {
    private static final zzbke zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzbke zzbkeVar = new zzbke();
        zzb = zzbkeVar;
        zzbel.zzR(zzbke.class, zzbkeVar);
    }

    private zzbke() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbke();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbkd(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
