package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzum extends zzbel implements zzbft {
    private static final zzum zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private float zzj;

    static {
        zzum zzumVar = new zzum();
        zzb = zzumVar;
        zzbel.zzR(zzum.class, zzumVar);
    }

    private zzum() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzd", "zze", zzuk.zza, "zzf", zzui.zza, "zzg", zzul.zza, "zzh", zzuj.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzum();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzuh(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
