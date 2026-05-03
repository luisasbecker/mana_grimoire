package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayy extends zzbel implements zzbft {
    private static final zzayy zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg = 2;
    private float zzh;
    private boolean zzi;

    static {
        zzayy zzayyVar = new zzayy();
        zzb = zzayyVar;
        zzbel.zzR(zzayy.class, zzayyVar);
    }

    private zzayy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", zzayw.zza, "zzf", zzazc.zza, "zzg", zzazb.zza, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzayy();
        }
        zzayp zzaypVar = null;
        if (i2 == 4) {
            return new zzayx(zzaypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
