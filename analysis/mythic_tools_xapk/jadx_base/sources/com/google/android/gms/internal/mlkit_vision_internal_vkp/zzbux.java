package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbux extends zzbel implements zzbft {
    private static final zzbux zzb;
    private zzbeq zzd = zzI();

    static {
        zzbux zzbuxVar = new zzbux();
        zzb = zzbuxVar;
        zzbel.zzR(zzbux.class, zzbuxVar);
    }

    private zzbux() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzbux();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuw(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
