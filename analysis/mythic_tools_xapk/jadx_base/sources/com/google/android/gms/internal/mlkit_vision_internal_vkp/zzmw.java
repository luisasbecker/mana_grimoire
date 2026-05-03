package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmw extends zzbel implements zzbft {
    private static final zzmw zzb;
    private int zzd;
    private zzmy zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzmw zzmwVar = new zzmw();
        zzb = zzmwVar;
        zzbel.zzR(zzmw.class, zzmwVar);
    }

    private zzmw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ᐉ\u0003Ϫဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzh", "zzg"});
        }
        if (i2 == 3) {
            return new zzmw();
        }
        zzmu zzmuVar = null;
        if (i2 == 4) {
            return new zzmv(zzmuVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
