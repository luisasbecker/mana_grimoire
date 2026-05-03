package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzco extends zzbel implements zzbft {
    private static final zzco zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg = 1;

    static {
        zzco zzcoVar = new zzco();
        zzb = zzcoVar;
        zzbel.zzR(zzco.class, zzcoVar);
    }

    private zzco() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzcn.zza});
        }
        if (i2 == 3) {
            return new zzco();
        }
        zzcl zzclVar = null;
        if (i2 == 4) {
            return new zzcm(zzclVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
