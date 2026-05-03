package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwh extends zzbel implements zzbft {
    private static final zzwh zzb;
    private int zzd;
    private zzwd zze;
    private zzwg zzf;
    private zzwg zzg;
    private boolean zzh;

    static {
        zzwh zzwhVar = new zzwh();
        zzb = zzwhVar;
        zzbel.zzR(zzwh.class, zzwhVar);
    }

    private zzwh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzwh();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzwe(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
