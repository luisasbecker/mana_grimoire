package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbuv extends zzbel implements zzbft {
    private static final zzbuv zzb;
    private int zzd = 0;
    private Object zze;
    private float zzf;

    static {
        zzbuv zzbuvVar = new zzbuv();
        zzb = zzbuvVar;
        zzbel.zzR(zzbuv.class, zzbuvVar);
    }

    private zzbuv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001?\u0000\u0002Ȼ\u0000\u0003\u0001\u0004<\u0000", new Object[]{"zze", "zzd", "zzf", zzbux.class});
        }
        if (i2 == 3) {
            return new zzbuv();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuu(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
