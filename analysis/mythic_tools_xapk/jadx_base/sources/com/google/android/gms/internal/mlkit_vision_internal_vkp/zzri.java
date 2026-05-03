package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzri extends zzbel implements zzbft {
    private static final zzri zzb;
    private int zzd;
    private long zze;
    private zzafw zzf;
    private int zzg;
    private int zzh;

    static {
        zzri zzriVar = new zzri();
        zzb = zzriVar;
        zzbel.zzR(zzri.class, zzriVar);
    }

    private zzri() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဉ\u0001\u0003᠌\u0002\u0004᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzacs.zza, "zzh", zzuc.zza});
        }
        if (i2 == 3) {
            return new zzri();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzrh(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
