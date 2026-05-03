package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwg extends zzbel implements zzbft {
    private static final zzwg zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzwg zzwgVar = new zzwg();
        zzb = zzwgVar;
        zzbel.zzR(zzwg.class, zzwgVar);
    }

    private zzwg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzwg();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzwf(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
