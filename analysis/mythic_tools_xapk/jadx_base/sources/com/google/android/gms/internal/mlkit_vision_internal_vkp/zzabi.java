package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabi extends zzbel implements zzbft {
    private static final zzabi zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzber zzh = zzJ();
    private int zzi;

    static {
        zzabi zzabiVar = new zzabi();
        zzb = zzabiVar;
        zzbel.zzR(zzabi.class, zzabiVar);
    }

    private zzabi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzbep zzbepVar = zzabe.zza;
            zzbep zzbepVar2 = zzabg.zza;
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ࠬ\u0005᠌\u0003", new Object[]{"zzd", "zze", zzbepVar, "zzf", zzbepVar2, "zzg", zzbepVar2, "zzh", zzabf.zza, "zzi", zzabh.zza});
        }
        if (i2 == 3) {
            return new zzabi();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzabd(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
