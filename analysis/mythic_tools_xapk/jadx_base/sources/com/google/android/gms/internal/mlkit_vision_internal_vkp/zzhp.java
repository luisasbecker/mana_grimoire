package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhp extends zzbel implements zzbft {
    private static final zzhp zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzhp zzhpVar = new zzhp();
        zzb = zzhpVar;
        zzbel.zzR(zzhp.class, zzhpVar);
    }

    private zzhp() {
    }

    public static zzho zze() {
        return (zzho) zzb.zzB();
    }

    static /* synthetic */ void zzg(zzhp zzhpVar, int i) {
        zzhpVar.zzd |= 1;
        zzhpVar.zze = i;
    }

    static /* synthetic */ void zzh(zzhp zzhpVar, long j) {
        zzhpVar.zzd |= 2;
        zzhpVar.zzf = j;
    }

    static /* synthetic */ void zzi(zzhp zzhpVar, long j) {
        zzhpVar.zzd |= 4;
        zzhpVar.zzg = j;
    }

    public final int zza() {
        return this.zze;
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
            return new zzhp();
        }
        zzhn zzhnVar = null;
        if (i2 == 4) {
            return new zzho(zzhnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }
}
