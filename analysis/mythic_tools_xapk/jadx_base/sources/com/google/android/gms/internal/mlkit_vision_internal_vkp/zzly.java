package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzly extends zzbeh implements zzbft {
    private static final zzly zzd;
    private int zze;
    private boolean zzf;
    private byte zzg = 2;

    static {
        zzly zzlyVar = new zzly();
        zzd = zzlyVar;
        zzbel.zzR(zzly.class, zzlyVar);
    }

    private zzly() {
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
            return new zzly();
        }
        zzlw zzlwVar = null;
        if (i2 == 4) {
            return new zzlx(zzlwVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
