package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaba extends zzbel implements zzbft {
    private static final zzaba zzb;
    private int zzd;
    private zzaaw zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private zzbet zzi = zzL();

    static {
        zzaba zzabaVar = new zzaba();
        zzb = zzabaVar;
        zzbel.zzR(zzaba.class, zzabaVar);
    }

    private zzaba() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005\u001b", new Object[]{"zzd", "zze", "zzf", zzuc.zza, "zzg", "zzh", "zzi", zzacv.class});
        }
        if (i2 == 3) {
            return new zzaba();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzaaz(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
