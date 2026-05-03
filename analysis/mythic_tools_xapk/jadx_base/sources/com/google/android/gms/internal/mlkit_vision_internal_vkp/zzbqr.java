package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqr extends zzbel implements zzbft {
    private static final zzbqr zzb;
    private int zzd;
    private zzbet zze = zzbel.zzL();
    private String zzf = "";

    static {
        zzbqr zzbqrVar = new zzbqr();
        zzb = zzbqrVar;
        zzbel.zzR(zzbqr.class, zzbqrVar);
    }

    private zzbqr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbqr();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbqq(zzbqnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
