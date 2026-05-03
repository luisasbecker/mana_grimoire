package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbca extends zzbel implements zzbft {
    private static final zzbca zzb;
    private zzbet zzd = zzL();
    private zzbet zze = zzbel.zzL();

    static {
        zzbca zzbcaVar = new zzbca();
        zzb = zzbcaVar;
        zzbel.zzR(zzbca.class, zzbcaVar);
    }

    private zzbca() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0000\u0001\u000f\u0002\u0000\u0002\u0000\u0001\u001b\u000f\u001a", new Object[]{"zzd", zzbbw.class, "zze"});
        }
        if (i2 == 3) {
            return new zzbca();
        }
        zzbbs zzbbsVar = null;
        if (i2 == 4) {
            return new zzbbz(zzbbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
