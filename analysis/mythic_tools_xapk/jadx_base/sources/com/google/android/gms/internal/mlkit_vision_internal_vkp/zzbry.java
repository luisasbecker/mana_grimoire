package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbry extends zzbel implements zzbft {
    private static final zzbry zzb;
    private zzbeq zzd = zzI();
    private zzbeq zze = zzI();
    private zzbeq zzf = zzI();
    private zzbeq zzg = zzI();
    private zzbeq zzh = zzI();
    private zzbeq zzi = zzI();

    static {
        zzbry zzbryVar = new zzbry();
        zzb = zzbryVar;
        zzbel.zzR(zzbry.class, zzbryVar);
    }

    private zzbry() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0006\u0000\u0001\u0013\u0002\u0013\u0003\u0013\u0004\u0013\u0005\u0013\u0006\u0013", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbry();
        }
        zzbru zzbruVar = null;
        if (i2 == 4) {
            return new zzbrx(zzbruVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
