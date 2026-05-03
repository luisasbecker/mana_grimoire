package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjq extends zzbel implements zzbft {
    private static final zzjq zzb;
    private byte zze = 2;
    private zzbet zzd = zzL();

    static {
        zzjq zzjqVar = new zzjq();
        zzb = zzjqVar;
        zzbel.zzR(zzjq.class, zzjqVar);
    }

    private zzjq() {
    }

    public static zzjq zze() {
        return zzb;
    }

    public final int zza() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzjn.class});
        }
        if (i2 == 3) {
            return new zzjq();
        }
        zzjo zzjoVar = null;
        if (i2 == 4) {
            return new zzjp(zzjoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zzjn zzc(int i) {
        return (zzjn) this.zzd.get(i);
    }
}
