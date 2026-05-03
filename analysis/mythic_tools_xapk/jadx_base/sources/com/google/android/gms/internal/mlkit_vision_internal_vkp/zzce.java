package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzce extends zzbel implements zzbft {
    private static final zzce zzb;
    private int zzd;
    private float zzf;
    private int zzi;
    private float zzj;
    private zzbet zze = zzbel.zzL();
    private boolean zzg = true;
    private float zzh = 0.8f;

    static {
        zzce zzceVar = new zzce();
        zzb = zzceVar;
        zzbel.zzR(zzce.class, zzceVar);
    }

    private zzce() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001a\u0002ခ\u0000\u0003ဇ\u0001\u0004ခ\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzce();
        }
        zzcc zzccVar = null;
        if (i2 == 4) {
            return new zzcd(zzccVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
