package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzblp extends zzbel implements zzbft {
    private static final zzblp zzb;
    private int zzd;
    private int zzf;
    private long zzh;
    private String zze = "";
    private String zzg = "";

    static {
        zzblp zzblpVar = new zzblp();
        zzb = zzblpVar;
        zzbel.zzR(zzblp.class, zzblpVar);
    }

    private zzblp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzblp();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzblo(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzg;
    }
}
