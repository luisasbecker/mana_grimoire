package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbov extends zzbel implements zzbft {
    private static final zzbov zzb;
    private zzbet zzd = zzL();
    private zzbet zze = zzL();

    static {
        zzbov zzbovVar = new zzbov();
        zzb = zzbovVar;
        zzbel.zzR(zzbov.class, zzbovVar);
    }

    private zzbov() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zzbos.class, "zze", zzbqi.class});
        }
        if (i2 == 3) {
            return new zzbov();
        }
        zzbot zzbotVar = null;
        if (i2 == 4) {
            return new zzbou(zzbotVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
