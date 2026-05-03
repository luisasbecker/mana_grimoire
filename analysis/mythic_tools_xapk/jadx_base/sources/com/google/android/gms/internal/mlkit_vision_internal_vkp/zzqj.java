package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqj extends zzbel implements zzbft {
    private static final zzqj zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private zzut zzg;
    private zzabn zzh;

    static {
        zzqj zzqjVar = new zzqj();
        zzb = zzqjVar;
        zzbel.zzR(zzqj.class, zzqjVar);
    }

    private zzqj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", zzuc.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzqj();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzqi(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
