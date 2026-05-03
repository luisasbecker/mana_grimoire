package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfk extends zzbel implements zzbft {
    private static final zzfk zzb;
    private int zzd;
    private float zze;
    private boolean zzf;
    private zzbdd zzg = zzbdd.zzb;

    static {
        zzfk zzfkVar = new zzfk();
        zzb = zzfkVar;
        zzbel.zzR(zzfk.class, zzfkVar);
    }

    private zzfk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ဇ\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzfk();
        }
        zzfi zzfiVar = null;
        if (i2 == 4) {
            return new zzfj(zzfiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
