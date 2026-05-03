package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbrm extends zzbel implements zzbft {
    private static final zzbrm zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private int zzh;
    private int zzi;
    private float zzj;

    static {
        zzbrm zzbrmVar = new zzbrm();
        zzb = zzbrmVar;
        zzbel.zzR(zzbrm.class, zzbrmVar);
    }

    private zzbrm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ခ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzbrk.zza, "zzi", zzbrl.zza, "zzj"});
        }
        if (i2 == 3) {
            return new zzbrm();
        }
        zzbrf zzbrfVar = null;
        if (i2 == 4) {
            return new zzbrj(zzbrfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
