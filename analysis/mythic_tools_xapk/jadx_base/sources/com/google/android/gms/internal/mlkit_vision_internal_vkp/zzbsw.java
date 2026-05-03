package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbsw extends zzbel implements zzbft {
    private static final zzbsw zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzbsw zzbswVar = new zzbsw();
        zzb = zzbswVar;
        zzbel.zzR(zzbsw.class, zzbswVar);
    }

    private zzbsw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001;\u0000\u0002=\u0000", new Object[]{"zze", "zzd"});
        }
        if (i2 == 3) {
            return new zzbsw();
        }
        zzbsu zzbsuVar = null;
        if (i2 == 4) {
            return new zzbsv(zzbsuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
