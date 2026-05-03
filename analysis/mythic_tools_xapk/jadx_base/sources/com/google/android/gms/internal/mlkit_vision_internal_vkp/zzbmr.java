package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbmr extends zzbel implements zzbft {
    private static final zzbmr zzb;
    private int zzd;
    private String zze = "";
    private int zzf;

    static {
        zzbmr zzbmrVar = new zzbmr();
        zzb = zzbmrVar;
        zzbel.zzR(zzbmr.class, zzbmrVar);
    }

    private zzbmr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzbmd.zza});
        }
        if (i2 == 3) {
            return new zzbmr();
        }
        zzbmc zzbmcVar = null;
        if (i2 == 4) {
            return new zzbmq(zzbmcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
