package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmd extends zzbel implements zzbft {
    private static final zzmd zzb;
    private int zzd;
    private int zzh;
    private int zzn;
    private boolean zzo;
    private zznj zzp;
    private zznl zzq;
    private zzmj zzs;
    private zzmm zzv;
    private byte zzx = 2;
    private zzbet zze = zzL();
    private zzbet zzf = zzL();
    private zzbet zzg = zzL();
    private zzbet zzi = zzL();
    private zzbet zzj = zzbel.zzL();
    private zzbet zzk = zzbel.zzL();
    private zzbet zzl = zzbel.zzL();
    private zzbet zzm = zzbel.zzL();
    private zzbet zzr = zzL();
    private String zzt = "";
    private String zzu = "";
    private zzbet zzw = zzL();

    static {
        zzmd zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzbel.zzR(zzmd.class, zzmdVar);
    }

    private zzmd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzx);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0013\u0000\u0001\u0001Ϫ\u0013\u0000\n\b\u0001Л\u0006Л\u0007Л\b\u0004\tЛ\nȚ\u000b\u0004\fᐉ\u0000\rᐉ\u0001\u000eЛ\u000fȚ\u0010Ț\u0011Ț\u0012ဉ\u0002\u0013Ȉ\u0014Ȉ\u0015\u0007ϩᐉ\u0003Ϫ\u001b", new Object[]{"zzd", "zze", zzmc.class, "zzf", zzmw.class, "zzg", zznb.class, "zzh", "zzi", zzng.class, "zzj", "zzn", "zzp", "zzq", "zzr", zzmf.class, "zzk", "zzl", "zzm", "zzs", "zzt", "zzu", "zzo", "zzv", "zzw", zzbcq.class});
        }
        if (i2 == 3) {
            return new zzmd();
        }
        zzlz zzlzVar = null;
        if (i2 == 4) {
            return new zzma(zzlzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzx = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
