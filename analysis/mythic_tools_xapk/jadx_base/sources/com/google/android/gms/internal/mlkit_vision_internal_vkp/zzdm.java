package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdm extends zzbel implements zzbft {
    private static final zzdm zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzdm zzdmVar = new zzdm();
        zzb = zzdmVar;
        zzbel.zzR(zzdm.class, zzdmVar);
    }

    private zzdm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzdl.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzdm();
        }
        zzdj zzdjVar = null;
        if (i2 == 4) {
            return new zzdk(zzdjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
