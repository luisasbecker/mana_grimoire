package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwq extends zzbel implements zzbft {
    private static final zzbwq zzb;
    private zzbet zzd = zzL();
    private zzbet zze = zzL();

    static {
        zzbwq zzbwqVar = new zzbwq();
        zzb = zzbwqVar;
        zzbel.zzR(zzbwq.class, zzbwqVar);
    }

    private zzbwq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zzbwk.class, "zze", zzbwn.class});
        }
        if (i2 == 3) {
            return new zzbwq();
        }
        zzbwo zzbwoVar = null;
        if (i2 == 4) {
            return new zzbwp(zzbwoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
