package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbid extends zzbel implements zzbft {
    private static final zzbid zzb;
    private int zzd;
    private int zze = -1;

    static {
        zzbid zzbidVar = new zzbid();
        zzb = zzbidVar;
        zzbel.zzR(zzbid.class, zzbidVar);
    }

    private zzbid() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbid();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbic(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
