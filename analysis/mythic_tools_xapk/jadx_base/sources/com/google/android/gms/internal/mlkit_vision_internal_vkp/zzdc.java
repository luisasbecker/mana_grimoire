package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdc extends zzbel implements zzbft {
    private static final zzdc zzb;
    private int zzd;
    private zzhm zze;

    static {
        zzdc zzdcVar = new zzdc();
        zzb = zzdcVar;
        zzbel.zzR(zzdc.class, zzdcVar);
    }

    private zzdc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0000\u0004ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzdc();
        }
        zzcz zzczVar = null;
        if (i2 == 4) {
            return new zzdb(zzczVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
