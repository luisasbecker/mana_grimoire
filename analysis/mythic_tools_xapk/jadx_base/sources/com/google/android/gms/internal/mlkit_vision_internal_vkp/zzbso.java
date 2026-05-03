package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbso extends zzbel implements zzbft {
    private static final zzbso zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzbso zzbsoVar = new zzbso();
        zzb = zzbsoVar;
        zzbel.zzR(zzbso.class, zzbsoVar);
    }

    private zzbso() {
    }

    public static zzbsn zzc() {
        return (zzbsn) zzb.zzB();
    }

    static /* synthetic */ void zzf(zzbso zzbsoVar, int i) {
        zzbsoVar.zzd |= 1;
        zzbsoVar.zze = i;
    }

    static /* synthetic */ void zzg(zzbso zzbsoVar, long j) {
        zzbsoVar.zzd |= 2;
        zzbsoVar.zzf = j;
    }

    static /* synthetic */ void zzh(zzbso zzbsoVar, long j) {
        zzbsoVar.zzd |= 4;
        zzbsoVar.zzg = j;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbso();
        }
        zzbsj zzbsjVar = null;
        if (i2 == 4) {
            return new zzbsn(zzbsjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
