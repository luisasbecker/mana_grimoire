package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzada extends zzbel implements zzbft {
    private static final zzada zzb;
    private int zzd;
    private long zze;
    private zzber zzf = zzJ();
    private zzber zzg = zzJ();
    private zzber zzh = zzJ();
    private int zzi;

    static {
        zzada zzadaVar = new zzada();
        zzb = zzadaVar;
        zzbel.zzR(zzada.class, zzadaVar);
    }

    private zzada() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzbep zzbepVar = zzacz.zza;
            return zzO(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002ࠞ\u0003ࠞ\u0004ࠞ\u0005င\u0001", new Object[]{"zzd", "zze", "zzf", zzbepVar, "zzg", zzbepVar, "zzh", zzbepVar, "zzi"});
        }
        if (i2 == 3) {
            return new zzada();
        }
        zzny zznyVar = null;
        if (i2 == 4) {
            return new zzacy(zznyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
