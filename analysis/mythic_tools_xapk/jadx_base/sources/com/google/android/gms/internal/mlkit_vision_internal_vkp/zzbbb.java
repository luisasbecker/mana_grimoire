package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbb extends zzbel implements zzbft {
    private static final zzbbb zzb;
    private int zzd;
    private float zzf;
    private String zze = "";
    private String zzg = "";

    static {
        zzbbb zzbbbVar = new zzbbb();
        zzb = zzbbbVar;
        zzbel.zzR(zzbbb.class, zzbbbVar);
    }

    private zzbbb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbbb();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbba(zzaztVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
