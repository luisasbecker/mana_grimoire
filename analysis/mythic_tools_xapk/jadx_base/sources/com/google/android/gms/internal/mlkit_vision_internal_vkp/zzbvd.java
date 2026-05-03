package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvd extends zzbel implements zzbft {
    private static final zzbvd zzb;
    private float zzd;
    private float zze;

    static {
        zzbvd zzbvdVar = new zzbvd();
        zzb = zzbvdVar;
        zzbel.zzR(zzbvd.class, zzbvdVar);
    }

    private zzbvd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbvd();
        }
        zzbvb zzbvbVar = null;
        if (i2 == 4) {
            return new zzbvc(zzbvbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
