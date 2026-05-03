package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoj extends zzbel implements zzbft {
    private static final zzoj zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private zzbet zzg = zzL();
    private zzbet zzh = zzL();
    private zzwh zzi;

    static {
        zzoj zzojVar = new zzoj();
        zzb = zzojVar;
        zzbel.zzR(zzoj.class, zzojVar);
    }

    private zzoj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzd", "zze", zzuc.zza, "zzf", "zzg", zzsx.class, "zzh", zzsx.class, "zzi"});
        }
        if (i2 == 3) {
            return new zzoj();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzoi(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
