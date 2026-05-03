package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbky extends zzbel implements zzbft {
    private static final zzbky zzb;
    private int zzd;
    private zzbkw zze;
    private zzbkw zzf;
    private boolean zzg;

    static {
        zzbky zzbkyVar = new zzbky();
        zzb = zzbkyVar;
        zzbel.zzR(zzbky.class, zzbkyVar);
    }

    private zzbky() {
    }

    public static zzbky zzf() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbky();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzbkx(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzbkw zzc() {
        zzbkw zzbkwVar = this.zze;
        return zzbkwVar == null ? zzbkw.zze() : zzbkwVar;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }
}
