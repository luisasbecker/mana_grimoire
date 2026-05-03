package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeg extends zzbel implements zzbft {
    private static final zzeg zzb;
    private int zzd;
    private float zze;

    static {
        zzeg zzegVar = new zzeg();
        zzb = zzegVar;
        zzbel.zzR(zzeg.class, zzegVar);
    }

    private zzeg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzeg();
        }
        zzee zzeeVar = null;
        if (i2 == 4) {
            return new zzef(zzeeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
