package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbup extends zzbel implements zzbft {
    private static final zzbup zzb;
    private int zzd = 0;
    private Object zze;
    private float zzf;

    static {
        zzbup zzbupVar = new zzbup();
        zzb = zzbupVar;
        zzbel.zzR(zzbup.class, zzbupVar);
    }

    private zzbup() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001?\u0000\u0002Ȼ\u0000\u0003\u0001", new Object[]{"zze", "zzd", "zzf"});
        }
        if (i2 == 3) {
            return new zzbup();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuo(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
