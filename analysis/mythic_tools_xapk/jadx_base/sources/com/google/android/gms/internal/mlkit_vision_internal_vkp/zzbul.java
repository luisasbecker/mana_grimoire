package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbul extends zzbel implements zzbft {
    private static final zzbul zzb;
    private String zzd = "";
    private String zze = "";
    private float zzf;

    static {
        zzbul zzbulVar = new zzbul();
        zzb = zzbulVar;
        zzbel.zzR(zzbul.class, zzbulVar);
    }

    private zzbul() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbul();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuk(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
