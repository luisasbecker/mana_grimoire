package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbzb extends zzbel implements zzbft {
    private static final zzbzb zzb;
    private String zzd = "";
    private String zze = "";
    private int zzf;

    static {
        zzbzb zzbzbVar = new zzbzb();
        zzb = zzbzbVar;
        zzbel.zzR(zzbzb.class, zzbzbVar);
    }

    private zzbzb() {
    }

    public static zzbza zze() {
        return (zzbza) zzb.zzB();
    }

    static /* synthetic */ void zzi(zzbzb zzbzbVar, String str) {
        str.getClass();
        zzbzbVar.zzd = str;
    }

    static /* synthetic */ void zzj(zzbzb zzbzbVar, String str) {
        str.getClass();
        zzbzbVar.zze = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbzb();
        }
        zzbyz zzbyzVar = null;
        if (i2 == 4) {
            return new zzbza(zzbyzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zze;
    }
}
