package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzde extends zzbel implements zzbft {
    private static final zzde zzb;
    private int zzd;
    private int zze = -1;
    private float zzf = 1.0f;
    private int zzg;

    static {
        zzde zzdeVar = new zzde();
        zzb = zzdeVar;
        zzbel.zzR(zzde.class, zzdeVar);
    }

    private zzde() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzde();
        }
        zzcz zzczVar = null;
        if (i2 == 4) {
            return new zzdd(zzczVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
