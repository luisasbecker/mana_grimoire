package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdx extends zzbel implements zzbft {
    private static final zzdx zzb;
    private int zzd;
    private zzdi zze;
    private zzdq zzf;
    private zzdm zzg;
    private zzdu zzh;

    static {
        zzdx zzdxVar = new zzdx();
        zzb = zzdxVar;
        zzbel.zzR(zzdx.class, zzdxVar);
    }

    private zzdx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzdx();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzdw(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
