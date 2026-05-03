package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgm extends zzbel implements zzbft {
    private static final zzgm zzb;
    private zzbet zzd = zzL();

    static {
        zzgm zzgmVar = new zzgm();
        zzb = zzgmVar;
        zzbel.zzR(zzgm.class, zzgmVar);
    }

    private zzgm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzge.class});
        }
        if (i2 == 3) {
            return new zzgm();
        }
        zzgk zzgkVar = null;
        if (i2 == 4) {
            return new zzgl(zzgkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
