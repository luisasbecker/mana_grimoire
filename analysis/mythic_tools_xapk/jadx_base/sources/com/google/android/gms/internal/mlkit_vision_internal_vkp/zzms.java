package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzms extends zzbel implements zzbft {
    private static final zzms zzb;
    private int zzd;
    private String zze = "";
    private zzmp zzf;

    static {
        zzms zzmsVar = new zzms();
        zzb = zzmsVar;
        zzbel.zzR(zzms.class, zzmsVar);
    }

    private zzms() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzms();
        }
        zzmn zzmnVar = null;
        if (i2 == 4) {
            return new zzmr(zzmnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
