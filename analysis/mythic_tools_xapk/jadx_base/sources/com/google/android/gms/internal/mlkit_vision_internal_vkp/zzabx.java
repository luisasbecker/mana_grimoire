package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabx extends zzbel implements zzbft {
    private static final zzabx zzb;
    private int zzd;
    private zzvc zze;
    private zzbet zzf = zzL();
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzabx zzabxVar = new zzabx();
        zzb = zzabxVar;
        zzbel.zzR(zzabx.class, zzabxVar);
    }

    private zzabx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzd", "zze", "zzf", zzabw.class, "zzg", zzabu.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzabx();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzabt(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
