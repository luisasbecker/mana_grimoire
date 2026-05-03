package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbnx extends zzbel implements zzbft {
    private static final zzbnx zzb;
    private int zzd;
    private byte zzg = 2;
    private String zze = "";
    private float zzf = 1.0f;

    static {
        zzbnx zzbnxVar = new zzbnx();
        zzb = zzbnxVar;
        zzbel.zzR(zzbnx.class, zzbnxVar);
    }

    private zzbnx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ခ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbnx();
        }
        zzbne zzbneVar = null;
        if (i2 == 4) {
            return new zzbnw(zzbneVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
