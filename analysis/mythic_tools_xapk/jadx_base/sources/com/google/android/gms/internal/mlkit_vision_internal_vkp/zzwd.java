package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwd extends zzbel implements zzbft {
    private static final zzwd zzb;
    private int zzd;
    private int zzg;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private String zze = "";
    private String zzf = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzwd zzwdVar = new zzwd();
        zzb = zzwdVar;
        zzbel.zzR(zzwd.class, zzwdVar);
    }

    private zzwd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006᠌\u0005\u0007ဃ\u0006\bဇ\u0007\tဇ\b", new Object[]{"zzd", "zze", "zzf", "zzg", zzwc.zza, "zzh", "zzi", "zzj", zzwb.zza, "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzwd();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzwa(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
