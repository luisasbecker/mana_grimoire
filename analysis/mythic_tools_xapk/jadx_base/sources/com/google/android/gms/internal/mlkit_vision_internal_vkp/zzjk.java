package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjk extends zzbel implements zzbft {
    private static final zzjk zzb;
    private int zzd;
    private zzbeq zze = zzI();
    private zzbdd zzf = zzbdd.zzb;

    static {
        zzjk zzjkVar = new zzjk();
        zzb = zzjkVar;
        zzbel.zzR(zzjk.class, zzjkVar);
    }

    private zzjk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001$\u0002ည\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjk();
        }
        zzji zzjiVar = null;
        if (i2 == 4) {
            return new zzjj(zzjiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
