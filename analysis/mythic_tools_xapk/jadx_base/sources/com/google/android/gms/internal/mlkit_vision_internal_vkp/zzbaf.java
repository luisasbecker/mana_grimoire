package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbaf extends zzbel implements zzbft {
    private static final zzbaf zzb;
    private int zzd;
    private zzbad zze;
    private double zzf;
    private boolean zzg;

    static {
        zzbaf zzbafVar = new zzbaf();
        zzb = zzbafVar;
        zzbel.zzR(zzbaf.class, zzbafVar);
    }

    private zzbaf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbaf();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbae(zzaztVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
