package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmh extends zzbel implements zzbft {
    private static final zzmh zzb;
    private String zzd = "";
    private boolean zze;

    static {
        zzmh zzmhVar = new zzmh();
        zzb = zzmhVar;
        zzbel.zzR(zzmh.class, zzmhVar);
    }

    private zzmh() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzmh();
        }
        zzlz zzlzVar = null;
        if (i2 == 4) {
            return new zzmg(zzlzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
