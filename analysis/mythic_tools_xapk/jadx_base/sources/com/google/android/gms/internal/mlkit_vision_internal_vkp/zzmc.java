package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmc extends zzbel implements zzbft {
    private static final zzmc zzb;
    private int zzd;
    private zzly zzk;
    private int zzm;
    private int zzn;
    private zznj zzo;
    private zznl zzp;
    private zzmj zzs;
    private int zzt;
    private byte zzw = 2;
    private String zze = "";
    private String zzf = "";
    private zzbet zzg = zzbel.zzL();
    private zzbet zzh = zzbel.zzL();
    private zzbet zzi = zzbel.zzL();
    private zzbet zzj = zzbel.zzL();
    private zzbet zzl = zzL();
    private zzbet zzq = zzL();
    private String zzr = "";
    private zzbet zzu = zzbel.zzL();
    private zzbet zzv = zzbel.zzL();

    static {
        zzmc zzmcVar = new zzmc();
        zzb = zzmcVar;
        zzbel.zzR(zzmc.class, zzmcVar);
    }

    private zzmc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzw);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0012\u0000\u0001\u0001ϭ\u0012\u0000\b\u0003\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ț\u0005Ț\u0006Ț\u0007ᐉ\u0000\b\u001b\t\u0004\n\u0004\u000bᐉ\u0001\fᐉ\u0002\r\u001b\u000eȈ\u000fဉ\u0003\u0010\u0004\u0011ȚϭȚ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzbcq.class, "zzm", "zzn", "zzo", "zzp", "zzq", zzmh.class, "zzr", "zzs", "zzt", "zzu", "zzv"});
        }
        if (i2 == 3) {
            return new zzmc();
        }
        zzlz zzlzVar = null;
        if (i2 == 4) {
            return new zzmb(zzlzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzw = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
