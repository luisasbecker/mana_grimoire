package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzab extends zzbel implements zzbft {
    private static final zzab zzb;
    private int zzd;
    private int zzf;
    private float zzh;
    private boolean zzi;
    private boolean zzj;
    private String zze = "";
    private String zzg = "";

    static {
        zzab zzabVar = new zzab();
        zzb = zzabVar;
        zzbel.zzR(zzab.class, zzabVar);
    }

    private zzab() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ခ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzab();
        }
        zzz zzzVar = null;
        if (i2 == 4) {
            return new zzaa(zzzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
