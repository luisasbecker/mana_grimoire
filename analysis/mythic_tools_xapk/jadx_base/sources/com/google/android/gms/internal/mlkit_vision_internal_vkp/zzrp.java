package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrp extends zzbel implements zzbft {
    private static final zzrp zzb;
    private int zzd;
    private zzvc zze;
    private zzrs zzf;
    private zzut zzg;

    static {
        zzrp zzrpVar = new zzrp();
        zzb = zzrpVar;
        zzbel.zzR(zzrp.class, zzrpVar);
    }

    private zzrp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzrp();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzro(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
