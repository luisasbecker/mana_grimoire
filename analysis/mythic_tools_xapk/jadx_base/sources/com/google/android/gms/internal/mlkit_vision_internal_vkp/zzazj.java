package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazj extends zzbel implements zzbft {
    private static final zzazj zzb;
    private boolean zzh;
    private boolean zzi;
    private boolean zzn;
    private boolean zzo;
    private zzbfm zzd = zzbfm.zza();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private zzbet zzm = zzbel.zzL();
    private String zzp = "";
    private zzbet zzq = zzbel.zzL();

    static {
        zzazj zzazjVar = new zzazj();
        zzb = zzazjVar;
        zzbel.zzR(zzazj.class, zzazjVar);
    }

    private zzazj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u000e\u0000\u0000\u0001\u0010\u000e\u0001\u0002\u0000\u00012\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0007\tȈ\nȈ\u000bȚ\f\u0007\rȈ\u000e\u0007\u000fȈ\u0010Ț", new Object[]{"zzd", zzazi.zza, "zzi", "zze", "zzf", "zzj", "zzh", "zzk", "zzl", "zzm", "zzn", "zzg", "zzo", "zzp", "zzq"});
        }
        if (i2 == 3) {
            return new zzazj();
        }
        zzazg zzazgVar = null;
        if (i2 == 4) {
            return new zzazh(zzazgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
