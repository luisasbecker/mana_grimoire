package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsp extends zzbel implements zzbft {
    private static final zzsp zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private int zzg;
    private boolean zzh;

    static {
        zzsp zzspVar = new zzsp();
        zzb = zzspVar;
        zzbel.zzR(zzsp.class, zzspVar);
    }

    private zzsp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဃ\u0001\u0003᠌\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzuc.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzsp();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzso(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
