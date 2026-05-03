package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbad extends zzbel implements zzbft {
    private static final zzbad zzb;
    private zzbet zzd = zzL();

    static {
        zzbad zzbadVar = new zzbad();
        zzb = zzbadVar;
        zzbel.zzR(zzbad.class, zzbadVar);
    }

    private zzbad() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzbac.class});
        }
        if (i2 == 3) {
            return new zzbad();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbaa(zzaztVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
