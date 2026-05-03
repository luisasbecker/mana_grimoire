package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbm extends zzbel implements zzbft {
    private static final zzbm zzb;
    private int zzd;
    private float zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzf = "";
    private zzbet zzg = zzL();

    static {
        zzbm zzbmVar = new zzbm();
        zzb = zzbmVar;
        zzbel.zzR(zzbm.class, zzbmVar);
    }

    private zzbm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003Л\u0004ခ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzbbd.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzbm();
        }
        zzbk zzbkVar = null;
        if (i2 == 4) {
            return new zzbl(zzbkVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
