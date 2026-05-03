package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzep extends zzbel implements zzbft {
    private static final zzep zzb;
    private int zzd;
    private int zzf;
    private int zzg;
    private float zzi;
    private zzbet zze = zzL();
    private String zzh = "";

    static {
        zzep zzepVar = new zzep();
        zzb = zzepVar;
        zzbel.zzR(zzep.class, zzepVar);
    }

    private zzep() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001c\u0002င\u0000\u0003င\u0001\u0004ဈ\u0002\u0005ခ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzep();
        }
        zzen zzenVar = null;
        if (i2 == 4) {
            return new zzeo(zzenVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
