package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzblu extends zzbel implements zzbft {
    private static final zzblu zzb;
    private int zzd;
    private int zze;
    private zzblm zzf;
    private zzblg zzg;

    static {
        zzblu zzbluVar = new zzblu();
        zzb = zzbluVar;
        zzbel.zzR(zzblu.class, zzbluVar);
    }

    private zzblu() {
    }

    public static zzblu zze() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbls.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzblu();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzblr(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzf() {
        int iZza = zzblt.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
