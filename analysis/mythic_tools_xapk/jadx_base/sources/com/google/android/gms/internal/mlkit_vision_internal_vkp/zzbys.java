package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbys extends zzbel implements zzbft {
    private static final zzbys zzb;
    private int zzf;
    private String zzd = "";
    private String zze = "";
    private String zzg = "";

    static {
        zzbys zzbysVar = new zzbys();
        zzb = zzbysVar;
        zzbel.zzR(zzbys.class, zzbysVar);
    }

    private zzbys() {
    }

    public static zzbyr zze() {
        return (zzbyr) zzb.zzB();
    }

    public static zzbys zzg() {
        return zzb;
    }

    static /* synthetic */ void zzk(zzbys zzbysVar, String str) {
        str.getClass();
        zzbysVar.zzd = str;
    }

    static /* synthetic */ void zzl(zzbys zzbysVar, String str) {
        str.getClass();
        zzbysVar.zze = str;
    }

    static /* synthetic */ void zzn(zzbys zzbysVar, String str) {
        str.getClass();
        zzbysVar.zzg = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbys();
        }
        zzbyq zzbyqVar = null;
        if (i2 == 4) {
            return new zzbyr(zzbyqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzd;
    }
}
