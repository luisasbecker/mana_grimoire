package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqu extends zzbel implements zzbft {
    private static final zzbqu zzb;
    private int zzd;
    private String zze = "";
    private zzbeq zzf = zzI();
    private zzbeq zzg = zzI();
    private zzbet zzh = zzbel.zzL();

    static {
        zzbqu zzbquVar = new zzbqu();
        zzb = zzbquVar;
        zzbel.zzR(zzbqu.class, zzbquVar);
    }

    private zzbqu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001ဈ\u0000\u0002$\u0003$\u0004\u001a", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbqu();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbqt(zzbqnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
