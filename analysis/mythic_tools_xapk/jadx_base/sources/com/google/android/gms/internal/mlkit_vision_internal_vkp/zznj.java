package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zznj extends zzbel implements zzbft {
    private static final zznj zzb;
    private int zzd;
    private zzmm zzf;
    private byte zzg = 2;
    private String zze = "DefaultInputStreamHandler";

    static {
        zznj zznjVar = new zznj();
        zzb = zznjVar;
        zzbel.zzR(zznj.class, zznjVar);
    }

    private zznj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0003ᐉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zznj();
        }
        zznh zznhVar = null;
        if (i2 == 4) {
            return new zzni(zznhVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
