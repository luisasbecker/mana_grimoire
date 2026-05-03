package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbli extends zzbel implements zzbft {
    private static final zzbli zzb;
    private int zzd;
    private zzbkr zze;
    private zzblq zzf;
    private zzble zzg;
    private int zzh;
    private zzblb zzi;
    private zzbmb zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;
    private int zzn;
    private byte zzo = 2;

    static {
        zzbli zzbliVar = new zzbli();
        zzb = zzbliVar;
        zzbel.zzR(zzbli.class, zzbliVar);
    }

    private zzbli() {
    }

    public static zzblh zzf() {
        return (zzblh) zzb.zzB();
    }

    static /* synthetic */ void zzh(zzbli zzbliVar, int i) {
        zzbliVar.zzd |= 512;
        zzbliVar.zzn = 3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzh", zzblc.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzg"});
        }
        if (i2 == 3) {
            return new zzbli();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzblh(zzbkmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final long zzc() {
        return this.zzl;
    }

    public final zzblb zze() {
        zzblb zzblbVar = this.zzi;
        return zzblbVar == null ? zzblb.zzg() : zzblbVar;
    }
}
