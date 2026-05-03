package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagm extends zzbel implements zzbft {
    private static final zzagm zzb;
    private int zzd;
    private zzbet zze = zzL();
    private int zzf;
    private int zzg;

    static {
        zzagm zzagmVar = new zzagm();
        zzb = zzagmVar;
        zzbel.zzR(zzagm.class, zzagmVar);
    }

    private zzagm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002᠌\u0000\u0003᠌\u0001", new Object[]{"zzd", "zze", zzagk.class, "zzf", zzagl.zza, "zzg", zzagg.zza});
        }
        if (i2 == 3) {
            return new zzagm();
        }
        zzagh zzaghVar = null;
        if (i2 == 4) {
            return new zzagi(zzaghVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
