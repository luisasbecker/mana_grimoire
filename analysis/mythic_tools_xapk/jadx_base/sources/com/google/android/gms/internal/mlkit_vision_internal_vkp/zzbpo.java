package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbpo extends zzbel implements zzbft {
    private static final zzbpo zzb;
    private byte zze = 2;
    private zzbet zzd = zzL();

    static {
        zzbpo zzbpoVar = new zzbpo();
        zzb = zzbpoVar;
        zzbel.zzR(zzbpo.class, zzbpoVar);
    }

    private zzbpo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzbpl.class});
        }
        if (i2 == 3) {
            return new zzbpo();
        }
        zzbpm zzbpmVar = null;
        if (i2 == 4) {
            return new zzbpn(zzbpmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
