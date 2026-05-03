package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjy extends zzbel implements zzbft {
    private static final zzjy zzb;
    private int zzd;
    private int zzf;
    private int zze = 1;
    private int zzg = 4;
    private int zzh = 240;
    private zzber zzi = zzJ();

    static {
        zzjy zzjyVar = new zzjy();
        zzb = zzjyVar;
        zzbel.zzR(zzjy.class, zzjyVar);
    }

    private zzjy() {
    }

    public static zzjy zzc() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0003\n\u0005\u0000\u0001\u0000\u0003᠌\u0000\u0007င\u0001\bင\u0002\tင\u0003\nࠬ", new Object[]{"zzd", "zze", zzjx.zza, "zzf", "zzg", "zzh", "zzi", zzjw.zza});
        }
        if (i2 == 3) {
            return new zzjy();
        }
        zzju zzjuVar = null;
        if (i2 == 4) {
            return new zzjv(zzjuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
