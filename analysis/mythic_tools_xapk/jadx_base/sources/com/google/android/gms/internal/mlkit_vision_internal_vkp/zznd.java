package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zznd extends zzbeh implements zzbft {
    private static final zznd zzd;
    private int zze;
    private byte zzg = 2;
    private boolean zzf = true;

    static {
        zznd zzndVar = new zznd();
        zzd = zzndVar;
        zzbel.zzR(zznd.class, zzndVar);
    }

    private zznd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zznd();
        }
        zzmz zzmzVar = null;
        if (i2 == 4) {
            return new zznc(zzmzVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
