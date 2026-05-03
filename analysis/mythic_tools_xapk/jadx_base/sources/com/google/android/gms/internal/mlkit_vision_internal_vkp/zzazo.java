package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazo extends zzbel implements zzbft {
    private static final zzazo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";

    static {
        zzazo zzazoVar = new zzazo();
        zzb = zzazoVar;
        zzbel.zzR(zzazo.class, zzazoVar);
    }

    private zzazo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဏ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", zzazs.zza, "zzf", zzazr.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzazo();
        }
        zzazm zzazmVar = null;
        if (i2 == 4) {
            return new zzazn(zzazmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
