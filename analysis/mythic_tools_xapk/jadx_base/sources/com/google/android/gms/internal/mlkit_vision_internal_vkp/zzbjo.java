package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbjo extends zzbel implements zzbft {
    private static final zzbjo zzb;
    private int zzd;
    private int zze;

    static {
        zzbjo zzbjoVar = new zzbjo();
        zzb = zzbjoVar;
        zzbel.zzR(zzbjo.class, zzbjoVar);
    }

    private zzbjo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbjo();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbjn(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
