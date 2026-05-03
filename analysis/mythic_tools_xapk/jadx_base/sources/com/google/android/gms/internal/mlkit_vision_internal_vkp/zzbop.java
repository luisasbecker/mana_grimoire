package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbop extends zzbel implements zzbft {
    private static final zzbop zzb;
    private zzbfm zzd = zzbfm.zza();

    static {
        zzbop zzbopVar = new zzbop();
        zzb = zzbopVar;
        zzbel.zzR(zzbop.class, zzbopVar);
    }

    private zzbop() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zzd", zzboo.zza});
        }
        if (i2 == 3) {
            return new zzbop();
        }
        zzbom zzbomVar = null;
        if (i2 == 4) {
            return new zzbon(zzbomVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
