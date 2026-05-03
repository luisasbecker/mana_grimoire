package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjs extends zzbel implements zzbft {
    private static final zzbjs zzb;
    private int zzd;
    private zzbet zze = zzL();
    private zzbju zzf;
    private zzbib zzg;

    static {
        zzbjs zzbjsVar = new zzbjs();
        zzb = zzbjsVar;
        zzbel.zzR(zzbjs.class, zzbjsVar);
    }

    private zzbjs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzbki.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbjs();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbjr(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
