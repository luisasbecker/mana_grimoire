package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayt extends zzbel implements zzbft {
    private static final zzayt zzb;
    private zzbet zzd = zzL();

    static {
        zzayt zzaytVar = new zzayt();
        zzb = zzaytVar;
        zzbel.zzR(zzayt.class, zzaytVar);
    }

    private zzayt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzays.class});
        }
        if (i2 == 3) {
            return new zzayt();
        }
        zzayp zzaypVar = null;
        if (i2 == 4) {
            return new zzayq(zzaypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
