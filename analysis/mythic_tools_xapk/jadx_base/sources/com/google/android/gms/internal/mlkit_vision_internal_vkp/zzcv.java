package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcv extends zzbel implements zzbft {
    private static final zzcv zzb;
    private zzbet zzd = zzL();

    static {
        zzcv zzcvVar = new zzcv();
        zzb = zzcvVar;
        zzbel.zzR(zzcv.class, zzcvVar);
    }

    private zzcv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzcu.class});
        }
        if (i2 == 3) {
            return new zzcv();
        }
        zzcr zzcrVar = null;
        if (i2 == 4) {
            return new zzcs(zzcrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
