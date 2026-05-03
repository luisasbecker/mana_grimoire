package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhj extends zzbel implements zzbft {
    private static final zzhj zzb;
    private int zzd;
    private Object zzf;
    private float zzg;
    private boolean zzi;
    private int zze = 0;
    private String zzh = "";

    static {
        zzhj zzhjVar = new zzhj();
        zzb = zzhjVar;
        zzbel.zzR(zzhj.class, zzhjVar);
    }

    private zzhj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002ခ\u0000\u0003;\u0000\u0004ဈ\u0001\u0005ဇ\u0002", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzhj();
        }
        zzhh zzhhVar = null;
        if (i2 == 4) {
            return new zzhi(zzhhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
