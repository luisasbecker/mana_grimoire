package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zziy extends zzbel implements zzbft {
    private static final zziy zzb;
    private int zzd;
    private zzix zzg;
    private zzhm zzh;
    private zzhm zzi;
    private zzbzh zzj;
    private float zzm;
    private boolean zzp;
    private zzbhv zzq;
    private String zze = "";
    private String zzf = "";
    private String zzk = "en";
    private int zzl = -1;
    private zzbet zzn = zzbel.zzL();
    private zzbet zzo = zzbel.zzL();
    private int zzr = -1;

    static {
        zziy zziyVar = new zziy();
        zzb = zziyVar;
        zzbel.zzR(zziy.class, zziyVar);
    }

    private zziy() {
    }

    public static zziv zza() {
        return (zziv) zzb.zzB();
    }

    static /* synthetic */ void zzd(zziy zziyVar, zzhm zzhmVar) {
        zzhmVar.getClass();
        zziyVar.zzh = zzhmVar;
        zziyVar.zzd |= 8;
    }

    static /* synthetic */ void zze(zziy zziyVar, zzhm zzhmVar) {
        zzhmVar.getClass();
        zziyVar.zzi = zzhmVar;
        zziyVar.zzd |= 16;
    }

    static /* synthetic */ void zzf(zziy zziyVar, int i) {
        zziyVar.zzd |= 128;
        zziyVar.zzl = i;
    }

    static /* synthetic */ void zzg(zziy zziyVar, float f) {
        zziyVar.zzd |= 256;
        zziyVar.zzm = f;
    }

    static /* synthetic */ void zzh(zziy zziyVar, Iterable iterable) {
        zzbet zzbetVar = zziyVar.zzo;
        if (!zzbetVar.zzc()) {
            zziyVar.zzo = zzbel.zzM(zzbetVar);
        }
        zzbck.zzu(iterable, zziyVar.zzo);
    }

    static /* synthetic */ void zzi(zziy zziyVar, zzbhv zzbhvVar) {
        zzbhvVar.getClass();
        zziyVar.zzq = zzbhvVar;
        zziyVar.zzd |= 1024;
    }

    static /* synthetic */ void zzj(zziy zziyVar, String str) {
        zziyVar.zzd |= 1;
        zziyVar.zze = "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0007\u0003ခ\b\u0004\u001a\u0005\u001a\u0006ဉ\u0002\bဇ\t\tဉ\n\nဉ\u0003\u000bဈ\u0006\fဉ\u0004\rင\u000b\u000eဉ\u0005\u000fဈ\u0001", new Object[]{"zzd", "zze", "zzl", "zzm", "zzn", "zzo", "zzg", "zzp", "zzq", "zzh", "zzk", "zzi", "zzr", "zzj", "zzf"});
        }
        if (i2 == 3) {
            return new zziy();
        }
        zziu zziuVar = null;
        if (i2 == 4) {
            return new zziv(zziuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
