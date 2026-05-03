package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbtj extends zzbel implements zzbft {
    private static final zzbtj zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private boolean zzh;
    private byte zzi = 2;
    private zzbet zzf = zzL();

    static {
        zzbtj zzbtjVar = new zzbtj();
        zzb = zzbtjVar;
        zzbel.zzR(zzbtj.class, zzbtjVar);
    }

    private zzbtj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0004\u0000\u0001\u0003\u0006\u0004\u0000\u0001\u0002\u0003ᔄ\u0000\u0004Л\u0005င\u0001\u0006ဇ\u0002", new Object[]{"zzd", "zze", "zzf", zzbtn.class, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbtj();
        }
        zzbtg zzbtgVar = null;
        if (i2 == 4) {
            return new zzbti(zzbtgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
