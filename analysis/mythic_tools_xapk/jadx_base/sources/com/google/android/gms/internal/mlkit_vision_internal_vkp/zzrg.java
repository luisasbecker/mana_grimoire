package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrg extends zzbel implements zzbft {
    private static final zzrg zzb;
    private int zzd;
    private zzwh zze;
    private zzwh zzf;
    private zzber zzg = zzJ();
    private long zzh;

    static {
        zzrg zzrgVar = new zzrg();
        zzb = zzrgVar;
        zzbel.zzR(zzrg.class, zzrgVar);
    }

    private zzrg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ࠞ\u0004ဃ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzuc.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzrg();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzrf(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
