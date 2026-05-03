package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwh extends zzbel implements zzbft {
    private static final zzbwh zzb;
    private String zzd = "";
    private String zze = "";
    private double zzf;

    static {
        zzbwh zzbwhVar = new zzbwh();
        zzb = zzbwhVar;
        zzbel.zzR(zzbwh.class, zzbwhVar);
    }

    private zzbwh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0000\u0003Ȉ", new Object[]{"zzd", "zzf", "zze"});
        }
        if (i2 == 3) {
            return new zzbwh();
        }
        zzbwf zzbwfVar = null;
        if (i2 == 4) {
            return new zzbwg(zzbwfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
