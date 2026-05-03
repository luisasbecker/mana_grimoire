package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbum extends zzbel implements zzbft {
    private static final zzbum zzb;
    private int zzd;
    private Object zzf;
    private zzbuf zzg;
    private int zze = 0;
    private zzbfm zzm = zzbfm.zza();
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzbet zzk = zzL();
    private zzbet zzl = zzL();
    private zzbet zzn = zzL();

    static {
        zzbum zzbumVar = new zzbum();
        zzb = zzbumVar;
        zzbel.zzR(zzbum.class, zzbumVar);
    }

    private zzbum() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\t\u0001\u0001\u0001\u000b\t\u0001\u0003\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u001b\u0004\u001b\u0005<\u0000\b2\t\u001b\nȈ\u000bȈ", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh", "zzk", zzbuj.class, "zzl", zzbul.class, zzbud.class, "zzm", zzbug.zza, "zzn", zzbcq.class, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzbum();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbuh(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
