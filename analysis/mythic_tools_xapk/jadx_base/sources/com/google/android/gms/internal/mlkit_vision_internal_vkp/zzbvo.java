package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvo extends zzbel implements zzbft {
    private static final zzbvo zzb;
    private int zzd;
    private int zze;
    private boolean zzh;
    private int zzf = 100;
    private int zzg = -100;
    private float zzi = 40.0f;

    static {
        zzbvo zzbvoVar = new zzbvo();
        zzb = zzbvoVar;
        zzbel.zzR(zzbvo.class, zzbvoVar);
    }

    private zzbvo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ခ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbvo();
        }
        zzbvm zzbvmVar = null;
        if (i2 == 4) {
            return new zzbvn(zzbvmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
