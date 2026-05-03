package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbua extends zzbel implements zzbft {
    private static final zzbua zzb;
    private int zzd;
    private zzber zze = zzJ();

    static {
        zzbua zzbuaVar = new zzbua();
        zzb = zzbuaVar;
        zzbel.zzR(zzbua.class, zzbuaVar);
    }

    private zzbua() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002'", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbua();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbtz(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
