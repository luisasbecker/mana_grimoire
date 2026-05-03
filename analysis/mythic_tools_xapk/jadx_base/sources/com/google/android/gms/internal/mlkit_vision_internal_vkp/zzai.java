package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzai extends zzbel implements zzbft {
    private static final zzai zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzai zzaiVar = new zzai();
        zzb = zzaiVar;
        zzbel.zzR(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzah.zza});
        }
        if (i2 == 3) {
            return new zzai();
        }
        zzaf zzafVar = null;
        if (i2 == 4) {
            return new zzag(zzafVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
