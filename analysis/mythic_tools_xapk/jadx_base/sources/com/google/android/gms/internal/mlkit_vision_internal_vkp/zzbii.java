package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbii extends zzbel implements zzbft {
    private static final zzbii zzb;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        zzbii zzbiiVar = new zzbii();
        zzb = zzbiiVar;
        zzbel.zzR(zzbii.class, zzbiiVar);
    }

    private zzbii() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", zzbih.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbii();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbig(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
