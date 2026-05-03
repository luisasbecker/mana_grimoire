package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbsd extends zzbel implements zzbft {
    private static final zzbsd zzb;
    private int zzd;
    private int zzf;
    private String zze = "";
    private zzbeq zzg = zzI();
    private String zzh = "";
    private zzbet zzi = zzbel.zzL();

    static {
        zzbsd zzbsdVar = new zzbsd();
        zzb = zzbsdVar;
        zzbel.zzR(zzbsd.class, zzbsdVar);
    }

    private zzbsd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003$\u0004ဈ\u0002\u0005\u001a", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbsd();
        }
        zzbsb zzbsbVar = null;
        if (i2 == 4) {
            return new zzbsc(zzbsbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
