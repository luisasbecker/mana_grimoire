package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbud extends zzbel implements zzbft {
    private static final zzbud zzb;
    private zzbet zzd = zzL();

    static {
        zzbud zzbudVar = new zzbud();
        zzb = zzbudVar;
        zzbel.zzR(zzbud.class, zzbudVar);
    }

    private zzbud() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzbvd.class});
        }
        if (i2 == 3) {
            return new zzbud();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuc(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
