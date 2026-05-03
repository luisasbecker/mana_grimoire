package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbf extends zzbel implements zzbft {
    private static final zzbbf zzb;
    private int zzd;
    private int zze;
    private float zzg;
    private byte zzh = 2;
    private zzber zzf = zzJ();

    static {
        zzbbf zzbbfVar = new zzbbf();
        zzb = zzbbfVar;
        zzbel.zzR(zzbbf.class, zzbbfVar);
    }

    private zzbbf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ᔄ\u0000\u0002ᔁ\u0001\u0003\u0016", new Object[]{"zzd", "zze", "zzg", "zzf"});
        }
        if (i2 == 3) {
            return new zzbbf();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbbe(zzaztVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
