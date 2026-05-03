package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmf extends zzbel implements zzbft {
    private static final zzmf zzb;
    private int zzd;
    private zzmm zzg;
    private byte zzh = 2;
    private String zze = "";
    private String zzf = "";

    static {
        zzmf zzmfVar = new zzmf();
        zzb = zzmfVar;
        zzbel.zzR(zzmf.class, zzmfVar);
    }

    private zzmf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ȉ\u0002Ȉ\u0003ᐉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzmf();
        }
        zzlz zzlzVar = null;
        if (i2 == 4) {
            return new zzme(zzlzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
