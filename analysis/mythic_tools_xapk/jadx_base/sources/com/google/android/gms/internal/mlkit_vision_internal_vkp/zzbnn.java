package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbnn extends zzbel implements zzbft {
    private static final zzbnn zzb;
    private int zzd;
    private zzaza zzf;
    private float zzg;
    private byte zzh = 2;
    private int zze = 2;

    static {
        zzbnn zzbnnVar = new zzbnn();
        zzb = zzbnnVar;
        zzbel.zzR(zzbnn.class, zzbnnVar);
    }

    private zzbnn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0007\u0003\u0000\u0000\u0001\u0001᠌\u0000\u0002ᐉ\u0001\u0007ခ\u0002", new Object[]{"zzd", "zze", zzbnl.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbnn();
        }
        zzbne zzbneVar = null;
        if (i2 == 4) {
            return new zzbnm(zzbneVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
