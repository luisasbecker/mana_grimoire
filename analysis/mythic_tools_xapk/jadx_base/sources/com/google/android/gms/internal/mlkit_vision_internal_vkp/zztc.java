package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztc extends zzbel implements zzbft {
    private static final zztc zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zztc zztcVar = new zztc();
        zzb = zztcVar;
        zzbel.zzR(zztc.class, zztcVar);
    }

    private zztc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", zzwb.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zztc();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zztb(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
