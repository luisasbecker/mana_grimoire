package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbxo extends zzbel implements zzbft {
    private static final zzbxo zzb;
    private int zzd;
    private zzbxu zze;
    private zzbyj zzf;
    private zzbxl zzg;
    private zzbwq zzh;
    private zzbwe zzi;
    private zzbyd zzj;
    private zzbww zzk;

    static {
        zzbxo zzbxoVar = new zzbxo();
        zzb = zzbxoVar;
        zzbel.zzR(zzbxo.class, zzbxoVar);
    }

    private zzbxo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbxo();
        }
        zzbxm zzbxmVar = null;
        if (i2 == 4) {
            return new zzbxn(zzbxmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
