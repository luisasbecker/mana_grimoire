package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcq extends zzbel implements zzbft {
    private static final zzbcq zzb;
    private String zzd = "";
    private zzbdd zze = zzbdd.zzb;

    static {
        zzbcq zzbcqVar = new zzbcq();
        zzb = zzbcqVar;
        zzbel.zzR(zzbcq.class, zzbcqVar);
    }

    private zzbcq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzbgd(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzbcq();
        }
        zzbco zzbcoVar = null;
        if (i2 == 4) {
            return new zzbcp(zzbcoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
