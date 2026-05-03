package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbva extends zzbel implements zzbft {
    private static final zzbva zzb;
    private zzbet zzd = zzL();
    private zzbet zze = zzL();
    private zzbet zzf = zzL();
    private zzbet zzg = zzL();

    static {
        zzbva zzbvaVar = new zzbva();
        zzb = zzbvaVar;
        zzbel.zzR(zzbva.class, zzbvaVar);
    }

    private zzbva() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zzd", zzbum.class, "zze", zzbub.class, "zzf", zzbvf.class, "zzg", zzbuy.class});
        }
        if (i2 == 3) {
            return new zzbva();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuz(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
