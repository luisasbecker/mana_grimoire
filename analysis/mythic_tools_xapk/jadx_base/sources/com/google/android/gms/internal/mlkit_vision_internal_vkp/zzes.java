package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzes extends zzbel implements zzbft {
    private static final zzes zzb;
    private int zzd;
    private zzbdd zze = zzbdd.zzb;
    private float zzf;

    static {
        zzes zzesVar = new zzes();
        zzb = zzesVar;
        zzbel.zzR(zzes.class, zzesVar);
    }

    private zzes() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ခ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzes();
        }
        zzeq zzeqVar = null;
        if (i2 == 4) {
            return new zzer(zzeqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
