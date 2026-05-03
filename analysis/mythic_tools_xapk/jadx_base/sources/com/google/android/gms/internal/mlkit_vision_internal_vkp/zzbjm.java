package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjm extends zzbel implements zzbft {
    private static final zzbjm zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzbjm zzbjmVar = new zzbjm();
        zzb = zzbjmVar;
        zzbel.zzR(zzbjm.class, zzbjmVar);
    }

    private zzbjm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzbjk.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbjm();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbjl(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
