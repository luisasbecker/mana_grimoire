package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbre extends zzbel implements zzbft {
    private static final zzbre zzb;
    private int zzd;
    private zzbet zze = zzL();
    private zzbrd zzf;
    private float zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzbre zzbreVar = new zzbre();
        zzb = zzbreVar;
        zzbel.zzR(zzbre.class, zzbreVar);
        zzbel.zzD(zzbqz.zze(), zzbreVar, zzbreVar, null, 32149011, zzbhq.MESSAGE, zzbre.class);
    }

    private zzbre() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0003\u0003ဉ\u0000\u0004ခ\u0001\u0005ဇ\u0004\u0006᠌\u0002", new Object[]{"zzd", "zze", zzbrd.class, "zzi", "zzf", "zzg", "zzj", "zzh", zzbrb.zza});
        }
        if (i2 == 3) {
            return new zzbre();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbra(zzbqnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
