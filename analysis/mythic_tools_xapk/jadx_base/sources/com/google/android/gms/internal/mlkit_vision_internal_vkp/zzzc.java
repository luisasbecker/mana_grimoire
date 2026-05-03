package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzc extends zzbel implements zzbft {
    private static final zzzc zzb;
    private int zzd;
    private int zze;

    static {
        zzzc zzzcVar = new zzzc();
        zzb = zzzcVar;
        zzbel.zzR(zzzc.class, zzzcVar);
    }

    private zzzc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzuc.zza});
        }
        if (i2 == 3) {
            return new zzzc();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzzb(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
