package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyi extends zzbel implements zzbft {
    private static final zzyi zzb;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzyi zzyiVar = new zzyi();
        zzb = zzyiVar;
        zzbel.zzR(zzyi.class, zzyiVar);
    }

    private zzyi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဃ\u0001", new Object[]{"zzd", "zze", zzuc.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzyi();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzyh(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
