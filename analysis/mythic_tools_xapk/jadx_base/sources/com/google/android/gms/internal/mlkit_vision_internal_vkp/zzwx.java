package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwx extends zzbel implements zzbft {
    private static final zzwx zzb;
    private int zzd;
    private zzbet zze = zzL();
    private int zzf;

    static {
        zzwx zzwxVar = new zzwx();
        zzb = zzwxVar;
        zzbel.zzR(zzwx.class, zzwxVar);
    }

    private zzwx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002င\u0000", new Object[]{"zzd", "zze", zzxe.class, "zzf"});
        }
        if (i2 == 3) {
            return new zzwx();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzww(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
