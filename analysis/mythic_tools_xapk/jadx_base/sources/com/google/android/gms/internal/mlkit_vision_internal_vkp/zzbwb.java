package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwb extends zzbel implements zzbft {
    private static final zzbwb zzb;
    private String zzd = "";
    private zzbet zze = zzL();

    static {
        zzbwb zzbwbVar = new zzbwb();
        zzb = zzbwbVar;
        zzbel.zzR(zzbwb.class, zzbwbVar);
    }

    private zzbwb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzbwh.class});
        }
        if (i2 == 3) {
            return new zzbwb();
        }
        zzbvz zzbvzVar = null;
        if (i2 == 4) {
            return new zzbwa(zzbvzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
