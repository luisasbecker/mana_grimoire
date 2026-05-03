package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwp extends zzbel implements zzbft {
    private static final zzwp zzb;
    private int zzd;
    private int zze;
    private float zzf;
    private int zzg;
    private int zzh;

    static {
        zzwp zzwpVar = new zzwp();
        zzb = zzwpVar;
        zzbel.zzR(zzwp.class, zzwpVar);
    }

    private zzwp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzd", "zze", zzwo.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzwp();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzwn(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
