package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzq extends zzbel implements zzbft {
    private static final zzzq zzb;
    private int zzd;
    private zzvc zze;
    private zzut zzf;
    private int zzg;
    private float zzh;
    private int zzi;

    static {
        zzzq zzzqVar = new zzzq();
        zzb = zzzqVar;
        zzbel.zzR(zzzq.class, zzzqVar);
    }

    private zzzq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0004ဋ\u0002\u0005ခ\u0003\u0006᠌\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzzp.zza});
        }
        if (i2 == 3) {
            return new zzzq();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzzo(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
