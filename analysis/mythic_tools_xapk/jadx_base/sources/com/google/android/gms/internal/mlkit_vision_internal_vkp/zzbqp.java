package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqp extends zzbel implements zzbft {
    private static final zzbqp zzb;
    private int zzd;
    private zzbet zze = zzbel.zzL();
    private String zzf = "";
    private float zzg;

    static {
        zzbqp zzbqpVar = new zzbqp();
        zzb = zzbqpVar;
        zzbel.zzR(zzbqp.class, zzbqpVar);
    }

    private zzbqp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000\u0003ခ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbqp();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbqo(zzbqnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
