package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbsm extends zzbel implements zzbft {
    private static final zzbsm zzb;
    private int zzd;
    private zzbso zzg;
    private zzbdd zzi;
    private zzbso zzj;
    private String zzk;
    private zzbdd zzl;
    private zzbso zzm;
    private String zzn;
    private String zzo;
    private zzbso zzp;
    private String zze = "";
    private zzbdd zzf = zzbdd.zzb;
    private String zzh = "";

    static {
        zzbsm zzbsmVar = new zzbsm();
        zzb = zzbsmVar;
        zzbel.zzR(zzbsm.class, zzbsmVar);
    }

    private zzbsm() {
        zzbdd zzbddVar = zzbdd.zzb;
        this.zzi = zzbddVar;
        this.zzk = "";
        this.zzl = zzbddVar;
        this.zzn = "";
        this.zzo = "";
    }

    public static zzbsl zzc() {
        return (zzbsl) zzb.zzB();
    }

    public static zzbsm zzf() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzbsm zzbsmVar, zzbdd zzbddVar) {
        zzbddVar.getClass();
        zzbsmVar.zzd |= 16;
        zzbsmVar.zzi = zzbddVar;
    }

    static /* synthetic */ void zzh(zzbsm zzbsmVar, zzbdd zzbddVar) {
        zzbddVar.getClass();
        zzbsmVar.zzd |= 128;
        zzbsmVar.zzl = zzbddVar;
    }

    static /* synthetic */ void zzi(zzbsm zzbsmVar, zzbso zzbsoVar) {
        zzbsoVar.getClass();
        zzbsmVar.zzg = zzbsoVar;
        zzbsmVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ည\u0004\u0004ဈ\u0003\u0005ဈ\u0006\u0006ည\u0007\u0007ဈ\t\bဈ\n\tဉ\u0002\nဉ\u0005\u000bဉ\b\fဉ\u000b", new Object[]{"zzd", "zze", "zzf", "zzi", "zzh", "zzk", "zzl", "zzn", "zzo", "zzg", "zzj", "zzm", "zzp"});
        }
        if (i2 == 3) {
            return new zzbsm();
        }
        zzbsj zzbsjVar = null;
        if (i2 == 4) {
            return new zzbsl(zzbsjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
