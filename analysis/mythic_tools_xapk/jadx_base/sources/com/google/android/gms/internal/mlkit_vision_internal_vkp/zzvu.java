package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvu extends zzbel implements zzbft {
    private static final zzvu zzb;
    private int zzd;
    private String zze = "";
    private zzbet zzf = zzbel.zzL();
    private String zzg = "";
    private boolean zzh;

    static {
        zzvu zzvuVar = new zzvu();
        zzb = zzvuVar;
        zzbel.zzR(zzvu.class, zzvuVar);
    }

    private zzvu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဈ\u0001\u0004ဇ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzvu();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzvt(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
