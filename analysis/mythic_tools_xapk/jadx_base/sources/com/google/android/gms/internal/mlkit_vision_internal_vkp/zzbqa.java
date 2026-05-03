package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqa extends zzbel implements zzbft {
    private static final zzbqa zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private zzbpt zzk;
    private int zzl;
    private int zzm;
    private float zzn;

    static {
        zzbqa zzbqaVar = new zzbqa();
        zzb = zzbqaVar;
        zzbel.zzR(zzbqa.class, zzbqaVar);
    }

    private zzbqa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004᠌\u0007\u0005᠌\b\u0006ခ\t\u0007ဉ\u0006\tခ\u0003\nခ\u0004\u000bခ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzl", zzbpy.zza, "zzm", zzbpz.zza, "zzn", "zzk", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzbqa();
        }
        zzbpp zzbppVar = null;
        if (i2 == 4) {
            return new zzbpx(zzbppVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
