package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbg extends zzbel implements zzbft {
    private static final zzbg zzb;
    private int zzd;
    private zzbvi zzg;
    private zzjt zzh;
    private boolean zzk;
    private boolean zze = true;
    private boolean zzf = true;
    private float zzi = 0.7f;
    private float zzj = 0.8f;

    static {
        zzbg zzbgVar = new zzbg();
        zzb = zzbgVar;
        zzbel.zzR(zzbg.class, zzbgVar);
    }

    private zzbg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဉ\u0002\u0003ဉ\u0003\u0004ဇ\u0001\u0005ခ\u0004\u0006ခ\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzg", "zzh", "zzf", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbg();
        }
        zzbe zzbeVar = null;
        if (i2 == 4) {
            return new zzbf(zzbeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
