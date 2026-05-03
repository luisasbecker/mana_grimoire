package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzay extends zzbeh implements zzbft {
    private static final zzay zzd;
    private byte zze = 2;

    static {
        zzay zzayVar = new zzay();
        zzd = zzayVar;
        zzbel.zzR(zzay.class, zzayVar);
    }

    private zzay() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzaw zzawVar = null;
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzay();
        }
        if (i2 == 4) {
            return new zzax(zzawVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
