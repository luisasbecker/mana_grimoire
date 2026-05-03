package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbal extends zzbel implements zzbft {
    private static final zzbal zzb;
    private int zzd;
    private zzbdd zzf;
    private zzbdd zzg;
    private zzazv zzh;
    private String zzi;
    private byte zzj = 2;
    private zzbdd zze = zzbdd.zzb;

    static {
        zzbal zzbalVar = new zzbal();
        zzb = zzbalVar;
        zzbel.zzR(zzbal.class, zzbalVar);
    }

    private zzbal() {
        zzbdd zzbddVar = zzbdd.zzb;
        this.zzf = zzbddVar;
        this.zzg = zzbddVar;
        this.zzi = "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0002\u0001ᔊ\u0000\u0002ည\u0001\u0003ည\u0002\u0004ᐉ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbal();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbak(zzaztVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
