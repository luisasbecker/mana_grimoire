package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzw extends zzbel implements zzbft {
    private static final zzzw zzb;
    private int zzd;
    private zzvc zze;
    private zzaaa zzf;
    private zzut zzg;
    private int zzh;
    private float zzi;

    static {
        zzzw zzzwVar = new zzzw();
        zzb = zzzwVar;
        zzbel.zzR(zzzw.class, zzzwVar);
    }

    private zzzw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzzw();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzzv(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
