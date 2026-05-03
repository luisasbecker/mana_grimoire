package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhd extends zzbel implements zzbft {
    private static final zzhd zzb;
    private int zzd;
    private String zze = "";
    private float zzf;

    static {
        zzhd zzhdVar = new zzhd();
        zzb = zzhdVar;
        zzbel.zzR(zzhd.class, zzhdVar);
    }

    private zzhd() {
    }

    public static zzhc zza() {
        return (zzhc) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzhd zzhdVar, String str) {
        zzhdVar.zzd |= 1;
        zzhdVar.zze = "/m/0bl9f";
    }

    static /* synthetic */ void zze(zzhd zzhdVar, float f) {
        zzhdVar.zzd |= 2;
        zzhdVar.zzf = 0.46f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhd();
        }
        zzhb zzhbVar = null;
        if (i2 == 4) {
            return new zzhc(zzhbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
