package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbmk extends zzbel implements zzbft {
    private static final zzbmk zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private int zzk;

    static {
        zzbmk zzbmkVar = new zzbmk();
        zzb = zzbmkVar;
        zzbel.zzR(zzbmk.class, zzbmkVar);
    }

    private zzbmk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007᠌\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzbms.zza});
        }
        if (i2 == 3) {
            return new zzbmk();
        }
        zzbmc zzbmcVar = null;
        if (i2 == 4) {
            return new zzbmj(zzbmcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
