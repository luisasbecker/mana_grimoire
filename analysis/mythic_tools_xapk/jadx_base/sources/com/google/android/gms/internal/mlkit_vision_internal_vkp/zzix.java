package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzix extends zzbel implements zzbft {
    private static final zzix zzb;
    private int zzd;
    private zzhm zze;
    private zzhm zzf;

    static {
        zzix zzixVar = new zzix();
        zzb = zzixVar;
        zzbel.zzR(zzix.class, zzixVar);
    }

    private zzix() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzix();
        }
        zziu zziuVar = null;
        if (i2 == 4) {
            return new zziw(zziuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
