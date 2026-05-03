package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqb extends zzbeh implements zzbft {
    private static final zzbqb zzd;
    private int zze;
    private zzbpt zzf;
    private float zzh;
    private float zzi;
    private zzbpt zzl;
    private zzbpl zzm;
    private byte zzo = 2;
    private zzbet zzg = zzL();
    private zzbet zzj = zzL();
    private zzbdd zzk = zzbdd.zzb;
    private zzbet zzn = zzL();

    static {
        zzbqb zzbqbVar = new zzbqb();
        zzd = zzbqbVar;
        zzbel.zzR(zzbqb.class, zzbqbVar);
    }

    private zzbqb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0003\u0001\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004\u001b\u0005ᐉ\u0005\u0006\u001b\u0007ည\u0003\bဉ\u0004\tခ\u0002", new Object[]{"zze", "zzf", "zzg", zzbqa.class, "zzh", "zzj", zzbpw.class, "zzm", "zzn", zzbpr.class, "zzk", "zzl", "zzi"});
        }
        if (i2 == 3) {
            return new zzbqb();
        }
        zzbpp zzbppVar = null;
        if (i2 == 4) {
            return new zzbpu(zzbppVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
