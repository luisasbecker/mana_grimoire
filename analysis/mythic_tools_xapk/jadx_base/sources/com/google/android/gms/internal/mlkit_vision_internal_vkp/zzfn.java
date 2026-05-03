package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfn extends zzbel implements zzbft {
    private static final zzfn zzb;
    private int zzd;
    private boolean zze;
    private float zzf = 0.8f;
    private int zzg;
    private int zzh;

    static {
        zzfn zzfnVar = new zzfn();
        zzb = zzfnVar;
        zzbel.zzR(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzfn();
        }
        zzfl zzflVar = null;
        if (i2 == 4) {
            return new zzfm(zzflVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
