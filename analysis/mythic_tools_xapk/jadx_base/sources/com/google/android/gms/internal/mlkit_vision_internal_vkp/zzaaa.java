package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaaa extends zzbel implements zzbft {
    private static final zzaaa zzb;
    private int zzd;
    private int zze;
    private float zzf;
    private zzwh zzg;

    static {
        zzaaa zzaaaVar = new zzaaa();
        zzb = zzaaaVar;
        zzbel.zzR(zzaaa.class, zzaaaVar);
    }

    private zzaaa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaaa();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzzz(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
