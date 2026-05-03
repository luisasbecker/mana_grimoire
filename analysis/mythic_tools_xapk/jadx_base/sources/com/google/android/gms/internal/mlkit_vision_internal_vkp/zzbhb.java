package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhb extends zzbel implements zzbft {
    private static final zzbhb zzb;
    private long zzd;
    private int zze;

    static {
        zzbhb zzbhbVar = new zzbhb();
        zzb = zzbhbVar;
        zzbel.zzR(zzbhb.class, zzbhbVar);
    }

    private zzbhb() {
    }

    public static zzbha zze() {
        return (zzbha) zzb.zzB();
    }

    public static zzbhb zzg() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzbgd(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbhb();
        }
        zzbgz zzbgzVar = null;
        if (i2 == 4) {
            return new zzbha(zzbgzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final long zzc() {
        return this.zzd;
    }
}
