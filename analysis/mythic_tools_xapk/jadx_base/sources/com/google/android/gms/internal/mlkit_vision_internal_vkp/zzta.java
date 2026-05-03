package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzta extends zzbel implements zzbft {
    private static final zzta zzb;
    private int zzd;
    private zzwh zze;
    private zzwh zzf;
    private zzber zzg = zzJ();
    private long zzh;
    private boolean zzi;

    static {
        zzta zztaVar = new zzta();
        zzb = zztaVar;
        zzbel.zzR(zzta.class, zztaVar);
    }

    private zzta() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ࠞ\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzuc.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzta();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzsz(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
