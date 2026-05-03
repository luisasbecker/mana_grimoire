package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmm extends zzbeh implements zzbft {
    private static final zzmm zzd;
    private byte zze = 2;

    static {
        zzmm zzmmVar = new zzmm();
        zzd = zzmmVar;
        zzbel.zzR(zzmm.class, zzmmVar);
    }

    private zzmm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzmk zzmkVar = null;
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzmm();
        }
        if (i2 == 4) {
            return new zzml(zzmkVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
