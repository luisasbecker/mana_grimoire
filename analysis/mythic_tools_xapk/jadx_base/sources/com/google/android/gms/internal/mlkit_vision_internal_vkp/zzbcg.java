package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcg extends zzbel implements zzbft {
    private static final zzbcg zzb;
    private int zzd;
    private float zzf;
    private String zze = "";
    private int zzg = 1;

    static {
        zzbcg zzbcgVar = new zzbcg();
        zzb = zzbcgVar;
        zzbel.zzR(zzbcg.class, zzbcgVar);
    }

    private zzbcg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbcg();
        }
        zzbce zzbceVar = null;
        if (i2 == 4) {
            return new zzbcf(zzbceVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
