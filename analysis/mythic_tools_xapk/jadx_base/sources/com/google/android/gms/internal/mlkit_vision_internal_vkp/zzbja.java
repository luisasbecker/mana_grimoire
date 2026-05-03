package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbja extends zzbel implements zzbft {
    private static final zzbja zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzbja zzbjaVar = new zzbja();
        zzb = zzbjaVar;
        zzbel.zzR(zzbja.class, zzbjaVar);
    }

    private zzbja() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbja();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbiz(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
