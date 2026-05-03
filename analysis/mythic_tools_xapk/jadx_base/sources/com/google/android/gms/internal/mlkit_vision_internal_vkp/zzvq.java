package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvq extends zzbel implements zzbft {
    private static final zzvq zzb;
    private int zzd;
    private zzvu zze;
    private long zzf;
    private int zzg;
    private long zzh;
    private int zzi;

    static {
        zzvq zzvqVar = new zzvq();
        zzb = zzvqVar;
        zzbel.zzR(zzvq.class, zzvqVar);
    }

    private zzvq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဋ\u0002\u0004ဃ\u0003\u0005᠌\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzuc.zza});
        }
        if (i2 == 3) {
            return new zzvq();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzvp(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
