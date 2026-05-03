package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbix extends zzbel implements zzbft {
    private static final zzbix zzb;
    private int zzd;
    private int zze;
    private zzbip zzh;
    private int zzj;
    private int zzk;
    private int zzn;
    private zzbet zzf = zzL();
    private int zzg = -1;
    private String zzi = "";
    private zzber zzl = zzJ();
    private String zzm = "";

    static {
        zzbix zzbixVar = new zzbix();
        zzb = zzbixVar;
        zzbel.zzR(zzbix.class, zzbixVar);
    }

    private zzbix() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006\n᠌\u0007", new Object[]{"zzd", "zze", zzbis.zza, "zzf", zzbir.class, "zzg", "zzh", "zzi", "zzj", zzbiu.zza, "zzk", zzbiv.zza, "zzl", "zzm", "zzn", zzbiw.zza});
        }
        if (i2 == 3) {
            return new zzbix();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbit(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
