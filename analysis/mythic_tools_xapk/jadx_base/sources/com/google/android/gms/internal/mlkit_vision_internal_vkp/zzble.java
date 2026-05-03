package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzble extends zzbel implements zzbft {
    private static final zzble zzb;
    private int zzd;
    private int zzh;
    private int zzi;
    private int zzk;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzj = "";

    static {
        zzble zzbleVar = new zzble();
        zzb = zzbleVar;
        zzbel.zzR(zzble.class, zzbleVar);
    }

    private zzble() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzble();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzbld(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
