package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbu extends zzbel implements zzbft {
    private static final zzbbu zzb;
    private int zzd;
    private String zze = "";
    private double zzf = 1.0d;
    private zzbet zzg = zzbel.zzL();

    static {
        zzbbu zzbbuVar = new zzbbu();
        zzb = zzbbuVar;
        zzbel.zzR(zzbbu.class, zzbbuVar);
    }

    private zzbbu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u000f\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002က\u0001\u000f\u001a", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbbu();
        }
        zzbbs zzbbsVar = null;
        if (i2 == 4) {
            return new zzbbt(zzbbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
