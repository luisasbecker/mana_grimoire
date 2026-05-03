package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbpl extends zzbeh implements zzbft {
    private static final zzbpl zzd;
    private int zze;
    private zzbpb zzf;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private long zzo;
    private long zzp;
    private long zzq;
    private float zzr;
    private zzbpg zzs;
    private byte zzt = 2;
    private zzbet zzg = zzL();
    private zzbet zzm = zzL();
    private zzbet zzn = zzL();

    static {
        zzbpl zzbplVar = new zzbpl();
        zzd = zzbplVar;
        zzbel.zzR(zzbpl.class, zzbplVar);
    }

    private zzbpl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005\u000eဉ\n", new Object[]{"zze", "zzf", "zzg", zzbpk.class, "zzh", "zzi", "zzj", "zzk", "zzm", zzbpe.class, "zzn", zzboz.class, "zzp", "zzr", "zzq", "zzo", "zzl", "zzs"});
        }
        if (i2 == 3) {
            return new zzbpl();
        }
        zzbow zzbowVar = null;
        if (i2 == 4) {
            return new zzbpc(zzbowVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
