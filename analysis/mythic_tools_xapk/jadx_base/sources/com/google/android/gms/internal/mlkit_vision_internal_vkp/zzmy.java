package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmy extends zzbeh implements zzbft {
    private static final zzmy zzd;
    private byte zze = 2;

    static {
        zzmy zzmyVar = new zzmy();
        zzd = zzmyVar;
        zzbel.zzR(zzmy.class, zzmyVar);
    }

    private zzmy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzmu zzmuVar = null;
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzmy();
        }
        if (i2 == 4) {
            return new zzmx(zzmuVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
