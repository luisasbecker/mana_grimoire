package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzey extends zzbel implements zzbft {
    private static final zzey zzb;
    private int zzd;
    private String zze = "";
    private float zzf;

    static {
        zzey zzeyVar = new zzey();
        zzb = zzeyVar;
        zzbel.zzR(zzey.class, zzeyVar);
    }

    private zzey() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzey();
        }
        zzew zzewVar = null;
        if (i2 == 4) {
            return new zzex(zzewVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
