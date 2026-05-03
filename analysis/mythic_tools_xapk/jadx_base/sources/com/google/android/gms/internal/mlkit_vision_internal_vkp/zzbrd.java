package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbrd extends zzbel implements zzbft {
    private static final zzbrd zzb;
    private int zzd;
    private float zzf;
    private float zzg;
    private float zzi;
    private String zze = "";
    private float zzh = 1.0f;
    private zzbet zzj = zzbel.zzL();

    static {
        zzbrd zzbrdVar = new zzbrd();
        zzb = zzbrdVar;
        zzbel.zzR(zzbrd.class, zzbrdVar);
    }

    private zzbrd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzbrd();
        }
        zzbqn zzbqnVar = null;
        if (i2 == 4) {
            return new zzbrc(zzbqnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
