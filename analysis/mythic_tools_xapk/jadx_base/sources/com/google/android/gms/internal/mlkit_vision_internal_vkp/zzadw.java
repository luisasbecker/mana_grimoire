package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadw extends zzbel implements zzbft {
    private static final zzadw zzb;
    private int zzd;
    private int zze;
    private zzadz zzf;

    static {
        zzadw zzadwVar = new zzadw();
        zzb = zzadwVar;
        zzbel.zzR(zzadw.class, zzadwVar);
    }

    private zzadw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", zzuc.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzadw();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzadv(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
