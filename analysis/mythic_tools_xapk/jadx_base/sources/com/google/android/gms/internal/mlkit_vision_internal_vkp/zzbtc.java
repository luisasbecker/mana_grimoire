package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbtc extends zzbel implements zzbft {
    private static final zzbtc zzb;
    private int zzd;
    private double zze;
    private double zzf;
    private double zzh;
    private boolean zzi;
    private double zzj;
    private double zzk;
    private byte zzl = 2;
    private String zzg = "";

    static {
        zzbtc zzbtcVar = new zzbtc();
        zzb = zzbtcVar;
        zzbel.zzR(zzbtc.class, zzbtcVar);
    }

    private zzbtc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001\u0004က\u0005\u0005က\u0006\u0006ဇ\u0004\u0007က\u0003\bဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzj", "zzk", "zzi", "zzh", "zzg"});
        }
        if (i2 == 3) {
            return new zzbtc();
        }
        zzbta zzbtaVar = null;
        if (i2 == 4) {
            return new zzbtb(zzbtaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
