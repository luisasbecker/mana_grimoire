package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf extends zzbel implements zzbft {
    private static final zzf zzb;
    private zzbet zzd = zzL();
    private int zze;

    static {
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        zzbel.zzR(zzf.class, zzfVar);
    }

    private zzf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\f", new Object[]{"zzd", zzc.class, "zze"});
        }
        if (i2 == 3) {
            return new zzf();
        }
        zzd zzdVar = null;
        if (i2 == 4) {
            return new zze(zzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
