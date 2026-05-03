package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbmg extends zzbel implements zzbft {
    private static final zzbmg zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzbmg zzbmgVar = new zzbmg();
        zzb = zzbmgVar;
        zzbel.zzR(zzbmg.class, zzbmgVar);
    }

    private zzbmg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzbmf.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzbmg();
        }
        zzbmc zzbmcVar = null;
        if (i2 == 4) {
            return new zzbme(zzbmcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
