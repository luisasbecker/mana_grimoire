package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbma extends zzbel implements zzbft {
    private static final zzbma zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzbet zzg = zzL();

    static {
        zzbma zzbmaVar = new zzbma();
        zzb = zzbmaVar;
        zzbel.zzR(zzbma.class, zzbmaVar);
    }

    private zzbma() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzblx.class});
        }
        if (i2 == 3) {
            return new zzbma();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzblz(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
