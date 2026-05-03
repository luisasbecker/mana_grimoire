package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqz extends zzbeh implements zzbft {
    private static final zzbqz zzd;
    private byte zzf = 2;
    private zzbet zze = zzL();

    static {
        zzbqz zzbqzVar = new zzbqz();
        zzd = zzbqzVar;
        zzbel.zzR(zzbqz.class, zzbqzVar);
    }

    private zzbqz() {
    }

    public static zzbqz zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0000\u0003\u001b", new Object[]{"zze", zzbqy.class});
        }
        if (i2 == 3) {
            return new zzbqz();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbqw(zzbqnVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
