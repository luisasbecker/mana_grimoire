package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbst extends zzbel implements zzbft {
    private static final zzbst zzb;
    private int zzd;
    private zzbsw zze;
    private zzbry zzf;
    private zzbsf zzg;

    static {
        zzbst zzbstVar = new zzbst();
        zzb = zzbstVar;
        zzbel.zzR(zzbst.class, zzbstVar);
    }

    private zzbst() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbst();
        }
        zzbsr zzbsrVar = null;
        if (i2 == 4) {
            return new zzbss(zzbsrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
