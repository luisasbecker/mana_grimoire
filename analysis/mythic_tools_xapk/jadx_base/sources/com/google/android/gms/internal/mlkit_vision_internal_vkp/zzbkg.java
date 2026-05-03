package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbkg extends zzbel implements zzbft {
    private static final zzbkg zzb;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private int zzm;
    private String zze = "";
    private String zzg = "";
    private String zzi = "";
    private zzbet zzj = zzbel.zzL();
    private zzbet zzk = zzL();
    private zzbet zzl = zzbel.zzL();

    static {
        zzbkg zzbkgVar = new zzbkg();
        zzb = zzbkgVar;
        zzbel.zzR(zzbkg.class, zzbkgVar);
    }

    private zzbkg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0003\u0000\u0001ဈ\u0000\u0002င\u0001\u0003\u001a\u0004\u001b\u0006ဈ\u0002\u0007ဇ\u0003\bဈ\u0004\t\u001a\nင\u0005", new Object[]{"zzd", "zze", "zzf", "zzj", "zzk", zzbka.class, "zzg", "zzh", "zzi", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzbkg();
        }
        zzbht zzbhtVar = null;
        if (i2 == 4) {
            return new zzbkf(zzbhtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
