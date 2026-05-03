package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzblb extends zzbel implements zzbft {
    private static final zzblb zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzbkp zzi;
    private zzbky zzj;
    private int zzk;
    private int zzm;
    private String zzg = "";
    private String zzh = "";
    private zzbet zzl = zzL();

    static {
        zzblb zzblbVar = new zzblb();
        zzb = zzblbVar;
        zzbel.zzR(zzblb.class, zzblbVar);
    }

    private zzblb() {
    }

    public static zzblb zzg() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzd", "zze", zzbks.zza, "zzf", zzbkz.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzblk.class, "zzm"});
        }
        if (i2 == 3) {
            return new zzblb();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzbku(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzbkp zzc() {
        zzbkp zzbkpVar = this.zzi;
        return zzbkpVar == null ? zzbkp.zze() : zzbkpVar;
    }

    public final zzbky zze() {
        zzbky zzbkyVar = this.zzj;
        return zzbkyVar == null ? zzbky.zzf() : zzbkyVar;
    }

    public final int zzh() {
        int iZza = zzbkt.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzi() {
        int iZza = zzbla.zza(this.zzf);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
