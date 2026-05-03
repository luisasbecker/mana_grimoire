package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhm extends zzbel implements zzbft {
    private static final zzhm zzb;
    private int zzd;
    private zzbdd zze = zzbdd.zzb;
    private String zzf = "";
    private zzhp zzg;

    static {
        zzhm zzhmVar = new zzhm();
        zzb = zzhmVar;
        zzbel.zzR(zzhm.class, zzhmVar);
    }

    private zzhm() {
    }

    public static zzhl zza() {
        return (zzhl) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzhm zzhmVar, zzbdd zzbddVar) {
        zzbddVar.getClass();
        zzhmVar.zzd |= 1;
        zzhmVar.zze = zzbddVar;
    }

    static /* synthetic */ void zze(zzhm zzhmVar, String str) {
        str.getClass();
        zzhmVar.zzd |= 2;
        zzhmVar.zzf = str;
    }

    static /* synthetic */ void zzf(zzhm zzhmVar, zzhp zzhpVar) {
        zzhpVar.getClass();
        zzhmVar.zzg = zzhpVar;
        zzhmVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဈ\u0001\u0002ည\u0000\u0004ဉ\u0002", new Object[]{"zzd", "zzf", "zze", "zzg"});
        }
        if (i2 == 3) {
            return new zzhm();
        }
        zzhk zzhkVar = null;
        if (i2 == 4) {
            return new zzhl(zzhkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
