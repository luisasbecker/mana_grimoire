package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbwt extends zzbel implements zzbft {
    private static final zzbwt zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzbwt zzbwtVar = new zzbwt();
        zzb = zzbwtVar;
        zzbel.zzR(zzbwt.class, zzbwtVar);
    }

    private zzbwt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbwt();
        }
        zzbwr zzbwrVar = null;
        if (i2 == 4) {
            return new zzbws(zzbwrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
