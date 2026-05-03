package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbs extends zzbel implements zzbft {
    private static final zzbs zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;

    static {
        zzbs zzbsVar = new zzbs();
        zzb = zzbsVar;
        zzbel.zzR(zzbs.class, zzbsVar);
    }

    private zzbs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbs();
        }
        zzbq zzbqVar = null;
        if (i2 == 4) {
            return new zzbr(zzbqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
