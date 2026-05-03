package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbsq extends zzbeh implements zzbft {
    private static final zzbsq zzd;
    private boolean zzA;
    private int zze;
    private float zzi;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private zzbst zzp;
    private zzbrt zzq;
    private zzbov zzr;
    private zzbsi zzs;
    private zzbsm zzt;
    private zzbhv zzv;
    private boolean zzw;
    private boolean zzx;
    private int zzy;
    private int zzz;
    private byte zzB = 2;
    private String zzf = "";
    private int zzg = 10;
    private int zzh = 1;
    private float zzj = 0.3f;
    private zzbet zzk = zzbel.zzL();
    private int zzu = 1;

    static {
        zzbsq zzbsqVar = new zzbsq();
        zzd = zzbsqVar;
        zzbel.zzR(zzbsq.class, zzbsqVar);
    }

    private zzbsq() {
    }

    public static zzbsk zzc() {
        return (zzbsk) zzd.zzB();
    }

    static /* synthetic */ void zzf(zzbsq zzbsqVar, String str) {
        zzbsqVar.zze |= 1;
        zzbsqVar.zzf = "MobileSSDTfLiteClient";
    }

    static /* synthetic */ void zzg(zzbsq zzbsqVar, boolean z) {
        zzbsqVar.zze |= 32;
        zzbsqVar.zzl = true;
    }

    static /* synthetic */ void zzh(zzbsq zzbsqVar, zzbsm zzbsmVar) {
        zzbsmVar.getClass();
        zzbsqVar.zzt = zzbsmVar;
        zzbsqVar.zze |= 8192;
    }

    static /* synthetic */ void zzi(zzbsq zzbsqVar, zzbhv zzbhvVar) {
        zzbhvVar.getClass();
        zzbsqVar.zzv = zzbhvVar;
        zzbsqVar.zze |= 32768;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzB);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a\u0007ဇ\u0005\bဇ\u0006\tဇ\u0007\nဋ\b\u000bဉ\t\fဉ\n\rဉ\f\u000fင\u000e\u0010ဉ\r\u0011ဉ\u000f\u0012ဇ\u0010\u0013ဇ\u0011\u0014င\u0012\u0015ဉ\u000b\u0016᠌\u0013\u0017ဇ\u0014", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzs", "zzu", "zzt", "zzv", "zzw", "zzx", "zzy", "zzr", "zzz", zzbsp.zza, "zzA"});
        }
        if (i2 == 3) {
            return new zzbsq();
        }
        zzbsj zzbsjVar = null;
        if (i2 == 4) {
            return new zzbsk(zzbsjVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzB = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
