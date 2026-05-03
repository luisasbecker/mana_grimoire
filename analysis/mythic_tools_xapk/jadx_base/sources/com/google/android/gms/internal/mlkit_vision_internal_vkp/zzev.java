package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzev extends zzbel implements zzbft {
    private static final zzev zzb;
    private int zzd;
    private boolean zze;
    private float zzf = 0.2f;
    private zzbet zzg = zzL();

    static {
        zzev zzevVar = new zzev();
        zzb = zzevVar;
        zzbel.zzR(zzev.class, zzevVar);
    }

    private zzev() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0004\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzey.class});
        }
        if (i2 == 3) {
            return new zzev();
        }
        zzet zzetVar = null;
        if (i2 == 4) {
            return new zzeu(zzetVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
