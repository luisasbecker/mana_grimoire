package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmp extends zzbel implements zzbft {
    private static final zzmp zzb;
    private Object zze;
    private int zzd = 0;
    private zzbet zzf = zzL();

    static {
        zzmp zzmpVar = new zzmp();
        zzb = zzmpVar;
        zzbel.zzR(zzmp.class, zzmpVar);
    }

    private zzmp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001;\u0000\u00023\u0000\u0003<\u0000\u0004\u001b", new Object[]{"zze", "zzd", zzmt.class, "zzf", zzmp.class});
        }
        if (i2 == 3) {
            return new zzmp();
        }
        zzmn zzmnVar = null;
        if (i2 == 4) {
            return new zzmo(zzmnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
