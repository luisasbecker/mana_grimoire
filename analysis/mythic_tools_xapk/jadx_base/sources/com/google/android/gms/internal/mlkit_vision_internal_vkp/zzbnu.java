package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbnu extends zzbeh implements zzbft {
    private static final zzbnu zzd;
    private int zze;
    private Object zzg;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzf = 0;
    private byte zzl = 2;
    private String zzh = "";

    static {
        zzbnu zzbnuVar = new zzbnu();
        zzd = zzbnuVar;
        zzbel.zzR(zzbnu.class, zzbnuVar);
    }

    private zzbnu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0007\u0001\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0006=\u0000\u0007=\u0000\b6\u0000", new Object[]{"zzg", "zzf", "zze", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbnu();
        }
        zzbne zzbneVar = null;
        if (i2 == 4) {
            return new zzbnt(zzbneVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
