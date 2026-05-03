package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazz extends zzbel implements zzbft {
    private static final zzazz zzb;
    private int zzd;
    private float zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzazz zzazzVar = new zzazz();
        zzb = zzazzVar;
        zzbel.zzR(zzazz.class, zzazzVar);
    }

    private zzazz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔁ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzazz();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzazy(zzaztVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
