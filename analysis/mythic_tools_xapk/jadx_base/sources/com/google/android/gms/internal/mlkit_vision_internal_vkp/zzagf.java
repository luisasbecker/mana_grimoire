package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagf extends zzbel implements zzbft {
    private static final zzagf zzb;
    private int zzd;
    private zzagm zze;
    private float zzf;
    private int zzg;
    private boolean zzh;

    static {
        zzagf zzagfVar = new zzagf();
        zzb = zzagfVar;
        zzbel.zzR(zzagf.class, zzagfVar);
    }

    private zzagf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003᠌\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzage.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzagf();
        }
        zzagc zzagcVar = null;
        if (i2 == 4) {
            return new zzagd(zzagcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
