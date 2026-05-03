package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadu extends zzbel implements zzbft {
    private static final zzadu zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private zzbet zzl = zzbel.zzL();
    private String zzm = "";
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    static {
        zzadu zzaduVar = new zzadu();
        zzb = zzaduVar;
        zzbel.zzR(zzadu.class, zzaduVar);
    }

    private zzadu() {
    }

    public static zzadt zza() {
        return (zzadt) zzb.zzB();
    }

    public static zzadu zzd() {
        return zzb;
    }

    static /* synthetic */ void zzf(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 1;
        zzaduVar.zze = str;
    }

    static /* synthetic */ void zzg(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 8;
        zzaduVar.zzh = str;
    }

    static /* synthetic */ void zzh(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 16;
        zzaduVar.zzi = str;
    }

    static /* synthetic */ void zzi(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 32;
        zzaduVar.zzj = str;
    }

    static /* synthetic */ void zzj(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 64;
        zzaduVar.zzk = str;
    }

    static /* synthetic */ void zzk(zzadu zzaduVar, Iterable iterable) {
        zzbet zzbetVar = zzaduVar.zzl;
        if (!zzbetVar.zzc()) {
            zzaduVar.zzl = zzbel.zzM(zzbetVar);
        }
        zzbck.zzu(iterable, zzaduVar.zzl);
    }

    static /* synthetic */ void zzl(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 128;
        zzaduVar.zzm = str;
    }

    static /* synthetic */ void zzm(zzadu zzaduVar, boolean z) {
        zzaduVar.zzd |= 256;
        zzaduVar.zzn = z;
    }

    static /* synthetic */ void zzn(zzadu zzaduVar, boolean z) {
        zzaduVar.zzd |= 512;
        zzaduVar.zzo = z;
    }

    static /* synthetic */ void zzo(zzadu zzaduVar, int i) {
        zzaduVar.zzd |= 2048;
        zzaduVar.zzq = i;
    }

    static /* synthetic */ void zzp(zzadu zzaduVar, int i) {
        zzaduVar.zzd |= 4096;
        zzaduVar.zzr = i;
    }

    static /* synthetic */ void zzq(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 2;
        zzaduVar.zzf = str;
    }

    static /* synthetic */ void zzr(zzadu zzaduVar, String str) {
        zzaduVar.zzd |= 4;
        zzaduVar.zzg = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t\fဇ\n\rဋ\u000b\u000eင\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzadu();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzadt(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zze() {
        return this.zzi;
    }
}
