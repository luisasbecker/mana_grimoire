package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaaq extends zzbel implements zzbft {
    private static final zzaaq zzb;
    private zzbet zzd = zzL();

    static {
        zzaaq zzaaqVar = new zzaaq();
        zzb = zzaaqVar;
        zzbel.zzR(zzaaq.class, zzaaqVar);
    }

    private zzaaq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzaam.class});
        }
        if (i2 == 3) {
            return new zzaaq();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzaap(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
