package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbl extends zzbel implements zzbft {
    private static final zzbbl zzb;
    private int zzd;
    private zzazv zze;
    private int zzh;
    private int zzi;
    private byte zzj = 2;
    private String zzf = "";
    private zzber zzg = zzJ();

    static {
        zzbbl zzbblVar = new zzbbl();
        zzb = zzbblVar;
        zzbel.zzR(zzbbl.class, zzbblVar);
    }

    private zzbbl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ဈ\u0001\u0003\u0016\u0004င\u0002\u0005᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzbof.zza()});
        }
        if (i2 == 3) {
            return new zzbbl();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbbk(zzaztVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
