package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbmp extends zzbeh implements zzbft {
    private static final zzbmp zzd;
    private int zze;
    private zzbkr zzf;
    private zzblq zzg;
    private zzble zzh;
    private zzbmk zzi;
    private zzbmi zzj;
    private int zzk;
    private int zzl;
    private int zzn;
    private zzbmb zzo;
    private long zzp;
    private int zzq;
    private byte zzr = 2;
    private zzbet zzm = zzL();

    static {
        zzbmp zzbmpVar = new zzbmp();
        zzd = zzbmpVar;
        zzbel.zzR(zzbmp.class, zzbmpVar);
    }

    private zzbmp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzr);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006᠌\u0005\u0007᠌\u0006\b\u001b\t᠌\u0007\nᐉ\b\u000bဂ\t\fင\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzbml.zza, "zzl", zzbmo.zza, "zzm", zzbmg.class, "zzn", zzbmm.zza, "zzo", "zzp", "zzq"});
        }
        if (i2 == 3) {
            return new zzbmp();
        }
        zzbmc zzbmcVar = null;
        if (i2 == 4) {
            return new zzbmn(zzbmcVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzr = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
