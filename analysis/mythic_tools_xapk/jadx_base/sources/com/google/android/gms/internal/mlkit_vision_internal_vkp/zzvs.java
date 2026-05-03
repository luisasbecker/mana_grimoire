package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvs extends zzbel implements zzbft {
    private static final zzvs zzb;
    private int zzd;
    private zzvu zze;
    private long zzf;
    private int zzg;
    private int zzh;

    static {
        zzvs zzvsVar = new zzvs();
        zzb = zzvsVar;
        zzbel.zzR(zzvs.class, zzvsVar);
    }

    private zzvs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဋ\u0002\u0004᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzuc.zza});
        }
        if (i2 == 3) {
            return new zzvs();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzvr(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
