package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbut extends zzbel implements zzbft {
    private static final zzbut zzb;
    private int zzd = 0;
    private Object zze;
    private int zzf;
    private float zzg;

    static {
        zzbut zzbutVar = new zzbut();
        zzb = zzbutVar;
        zzbel.zzR(zzbut.class, zzbutVar);
    }

    private zzbut() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002\u0001\u0003?\u0000\u0004Ȼ\u0000", new Object[]{"zze", "zzd", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbut();
        }
        zzbtx zzbtxVar = null;
        if (i2 == 4) {
            return new zzbus(zzbtxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
